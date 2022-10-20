package cn.piesat.clickhouse.commons.base;

import cn.piesat.clickhouse.commons.response.ResponseCode;
import cn.piesat.clickhouse.commons.response.ResponseResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 通用请求处理
 *
 * <p>
 * Description:
 * </p>
 *
 * @author hezhanfeng
 * @version v1.0
 * @date 2020/6/29 21:44
 */
@SuppressWarnings("all")
public abstract class BaseController<T extends BaseDomain, S extends IBaseService<T>> {

    @Resource
    protected HttpServletRequest request;

    @Autowired
    protected S service;

    /**
     * 新增
     *
     * @param domain 领域模型
     * @return {@link ResponseResult}
     */
    @PostMapping("create")
    public ResponseResult create(@Valid @RequestBody T domain) {
        // 业务逻辑
        boolean created = service.create(domain);
        if (created) {
            return ResponseResult.success(ResponseCode.SUCCESS, domain);
        }

        return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
    }

    /**
     * 删除
     *
     * @param ids {@code List}
     * @return {@link ResponseResult}
     */
    @DeleteMapping("remove")
    public ResponseResult remove(@RequestParam("idList") List<Long> ids) {
        // 业务逻辑
        boolean deleted = service.removeByIds(ids);
        if (deleted) {
            return ResponseResult.success(ResponseCode.SUCCESS);
        }

        return ResponseResult.failure(ResponseCode.FAILURE);
    }

    /**
     * 修改
     *
     * @param domain 领域模型
     * @return {@link ResponseResult}
     */
    @PutMapping("update")
    public ResponseResult update(@Valid @RequestBody T domain) {
        // 业务逻辑
        boolean updated = service.update(domain);
        if (updated) {
            return ResponseResult.success(ResponseCode.SUCCESS, domain);
        }

        return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
    }

    /**
     * 获取
     *
     * @param id {@code Long}
     * @return {@link ResponseResult}
     */
    @GetMapping("get/{id}")
    public ResponseResult get(@PathVariable Long id) {
        T domain = service.get(id);
        return ResponseResult.success(domain);
    }

    /**
     * 分页
     *
     * @param current {@code int} 页码
     * @param size    {@code int} 每页数量
     * @return {@link ResponseResult}
     */
    @GetMapping("page")
    public ResponseResult page(
            @RequestParam int current, @RequestParam int size, @ModelAttribute T domain) {
        IPage<?> page = service.page(current, size, domain);
        return ResponseResult.success(page);
    }
}
