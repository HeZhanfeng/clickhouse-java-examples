package cn.piesat.clickhouse.controller;

import cn.piesat.clickhouse.commons.response.ResponseCode;
import cn.piesat.clickhouse.commons.response.ResponseResult;
import cn.piesat.clickhouse.entity.Logs1;
import cn.piesat.clickhouse.service.ILogs1Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hezhanfeng
 * @since 2022-10-20
 */
@Api(tags = "日志1")
@RestController
@RequestMapping("/logs1")
@AllArgsConstructor
public class Logs1Controller {
    private final ILogs1Service service;

    /**
     * 新增
     *
     * @param logs1 {@link Logs1}
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "添加")
    @PostMapping
    public ResponseResult add(@Valid @RequestBody Logs1 logs1) {
        if (service.save(logs1)) {
            return ResponseResult.success(logs1);
        }
        return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
    }

    /**
     * 删除
     *
     * @param id {@code Long} id
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "删除")
    @DeleteMapping(value = "{id}")
    public ResponseResult delete(@PathVariable Long id) {
        if (service.removeById(id)) {
            return ResponseResult.success(id);
        }
        return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
    }

    /**
     * 批量删除
     *
     * @param ids {@link List < Serializable >} id集合
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "批量删除")
    @DeleteMapping(value = "deleteBatch")
    public ResponseResult deleteBatch(@RequestBody List<Serializable> ids) {
        if (ids.isEmpty()) {
            return ResponseResult.failure(ResponseCode.PARAM_IS_BLANK);
        }
        if (service.removeBatchByIds(ids)) {
            return ResponseResult.success(ids);
        }
        return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
    }

    /**
     * 修改
     *
     * @param logs1 {@link Logs1}
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "修改")
    @PutMapping
    public ResponseResult update(@RequestBody Logs1 logs1) {
        LambdaUpdateWrapper<Logs1> wrapper = new LambdaUpdateWrapper<>(logs1);
        if (service.update(wrapper)) {
            return ResponseResult.success(logs1);
        }
        return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
    }

    /**
     * 分页
     *
     * @param current {@code int} 页码
     * @param size    {@code int} 每页数量
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "分页查询")
    @GetMapping(value = "page")
    public ResponseResult page(@RequestParam int current, @RequestParam int size,
                               @ModelAttribute Logs1 domain) {
        Page<Logs1> page = new Page<>(current, size);
        Wrapper<Logs1> wrapper = new LambdaQueryWrapper<>(domain);
        return ResponseResult.success(service.page(page, wrapper));
    }
}
