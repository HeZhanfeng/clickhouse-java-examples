package cn.piesat.clickhouse.commons.exception;


import cn.piesat.clickhouse.commons.response.ResponseCode;

/**
 * 全局业务异常
 *
 * <p>
 * Description:
 * </p>
 *
 * @author hezhanfeng
 * @version v1.0
 * @date 2020/6/28 22:39
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 4868842805385777275L;

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
        this.code = -1;
    }

    public BusinessException(ResponseCode status) {
        super(status.message());
        this.code = status.code();
    }
}
