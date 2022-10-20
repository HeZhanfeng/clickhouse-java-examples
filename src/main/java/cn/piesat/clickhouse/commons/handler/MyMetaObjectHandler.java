package cn.piesat.clickhouse.commons.handler;

import cn.piesat.clickhouse.commons.constant.Constant;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * MybatisPlus 自动填充配置
 *
 * <p>
 * Description:
 * </p>
 *
 * @author hezhanfeng
 * @version v1.0
 * @date 2020/10/28 21:19
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 通用字段：已删除
     */
    private static final String DELETED = "deleted";

    @Override
    public void insertFill(MetaObject metaObject) {
        // 判断是否有相关字段
        boolean hasCreateTime = metaObject.hasSetter(Constant.CREATE_TIME);
        boolean hasUpdateTime = metaObject.hasSetter(Constant.UPDATE_TIME);
        boolean hasDeleted = metaObject.hasSetter(DELETED);

        // 有字段则自动填充
        if (hasCreateTime) {
            strictInsertFill(metaObject, Constant.CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        }
        if (hasUpdateTime) {
            strictInsertFill(metaObject, Constant.UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        }
        if (hasDeleted) {
            strictInsertFill(metaObject, DELETED, Boolean.class, false);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object val = getFieldValByName(Constant.UPDATE_TIME, metaObject);
        // 没有自定义值时才更新字段
        if (val == null) {
            strictUpdateFill(metaObject, Constant.UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        }
    }
}
