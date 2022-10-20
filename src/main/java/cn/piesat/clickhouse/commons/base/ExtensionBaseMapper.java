package cn.piesat.clickhouse.commons.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

/**
 * @description 扩展通用 Mapper，支持数据批量插入 <br>
 * @date 2021-09-22 20:11:20 <br>
 * @author hezhanfeng <br>
 * @version v1.0 <br>
 */
public interface ExtensionBaseMapper<T> extends BaseMapper<T> {

    /**
     * 批量插入
     *
     * @param entityList 实体列表
     * @return 影响行数
     */
    Integer insertBatchSomeColumn(Collection<T> entityList);
}
