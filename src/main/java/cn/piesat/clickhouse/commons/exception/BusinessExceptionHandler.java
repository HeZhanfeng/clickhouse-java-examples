package cn.piesat.clickhouse.commons.exception;

import cn.piesat.clickhouse.commons.response.ResponseCode;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.UnexpectedTypeException;
import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 全局业务异常处理
 *
 * <p>
 * Description:
 * </p>
 *
 * @author hezhanfeng
 * @version v1.0
 * @date 2020/6/28 22:44
 */
@Slf4j
@ControllerAdvice
public class BusinessExceptionHandler {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDateTime.parse(text, FORMATTER));
            }
        });
    }

    @ExceptionHandler({BusinessException.class, Exception.class})
    public ResponseEntity<?> handlerException(HttpServletRequest request, Exception ex) {
        Map<String, Object> error = new HashMap<>(2);
        // 业务异常
        if (ex instanceof BusinessException) {
            error.put("code", ((BusinessException) ex).getCode());
            error.put("message", ex.getMessage());
            log.warn("[全局业务异常]\r\n业务编码：{}\r\n异常记录：{}", error.get("code"), error.get("message"));
        }

        // 统一处理 JSON 参数验证
        else if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) ex;
            BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
            String msg = bindingResult.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .distinct()
                    .collect(Collectors.joining(","));
            error.put("code", HttpStatus.BAD_REQUEST.value());
            error.put("message", msg);
        }

        // 统一处理表单绑定验证
        else if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            BindingResult bindingResult = bindException.getBindingResult();
            String msg = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .distinct()
                    .collect(Collectors.joining(","));
            error.put("code", HttpStatus.BAD_REQUEST.value());
            error.put("message", msg);
        } else if (ex instanceof UnexpectedTypeException || ex instanceof InvalidFormatException || ex instanceof HttpMessageNotReadableException) {
            log.error(ex.getMessage());
            error.put("code", ResponseCode.PARAM_TYPE_BIND_ERROR.code());
            error.put("message", ResponseCode.PARAM_TYPE_BIND_ERROR.message());
        }

        // 未知错误
        else {
            error.put("code", ResponseCode.UNKNOWN.code());
            error.put("message", ResponseCode.UNKNOWN.message());
            log.error(ex.getMessage());
            ex.printStackTrace();
        }

        return new ResponseEntity<>(error, HttpStatus.OK);
    }
}
