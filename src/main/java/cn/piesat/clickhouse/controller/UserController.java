package cn.piesat.clickhouse.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.piesat.clickhouse.commons.response.ResponseCode;
import cn.piesat.clickhouse.commons.response.ResponseResult;
import cn.piesat.clickhouse.entity.User;
import cn.piesat.clickhouse.entity.dto.UserDTO;
import cn.piesat.clickhouse.service.IUserService;
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
 * 用户 前端控制器
 * </p>
 *
 * @author hezhanfeng
 * @since 2022-10-20
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final IUserService service;

    /**
     * 新增
     *
     * @param dto {@link UserDTO}
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "添加")
    @PostMapping
    public ResponseResult add(@Valid @RequestBody UserDTO dto) {
        User user = new User();
        BeanUtil.copyProperties(dto, user);
        if (service.create(user)) {
            return ResponseResult.success(user);
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
        if (service.remove(id)) {
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
        if (service.removeBatch(ids)) {
            return ResponseResult.success(ids);
        }
        return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
    }

    /**
     * 修改
     *
     * @param dto {@link UserDTO}
     * @return {@link ResponseResult}
     */
    @ApiOperation(value = "修改")
    @PutMapping(value = "{id}")
    public ResponseResult update(@PathVariable Long id, @RequestBody UserDTO dto) {
        User user = new User();
        BeanUtil.copyProperties(dto, user);
        user.setId(id);
        if (service.update(user)) {
            return ResponseResult.success(dto);
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
                               @ModelAttribute User domain) {
        return ResponseResult.success(service.page(current, size, domain));
    }
}
