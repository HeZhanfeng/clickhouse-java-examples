package cn.piesat.clickhouse.commons.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;

/**
 * 通用业务接口
 *
 * <p>
 * Description:
 * </p>
 *
 * @author hezhanfeng
 * @version v1.0
 * @date 2020/6/29 21:12
 */
public interface IBaseService<T extends BaseDomain> extends IService<T> {
    /**
     * 新增
     *
     * @param domain 领域模型
     * @return {@code boolean}
     */
    boolean create(T domain);

    /**
     * 删除
     *
     * @param id {@code Long} ID
     * @return {@code boolean}
     */
    boolean remove(Long id);

    /**
     * 批量删除
     *
     * @param ids {@link List<Serializable>} id集合
     * @return true or false
     */
    boolean removeBatch(List<Serializable> ids);

    /**
     * 更新
     *
     * @param domain 领域模型
     * @return {@code boolean}
     */
    boolean update(T domain);

    /**
     * 获取
     *
     * @param id {@code Long} ID
     * @return 领域模型
     */
    T get(Long id);

    /**
     * 分页
     *
     * @param current {@code int} 页码
     * @param size    {@code int} 笔数
     * @param domain  领域模型
     * @return 管理员分页数据
     */
    IPage<?> page(int current, int size, T domain);
}
