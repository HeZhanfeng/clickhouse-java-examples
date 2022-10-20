package cn.piesat.clickhouse.entity;

import cn.piesat.clickhouse.commons.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 日志
 * </p>
 *
 * @author hezhanfeng
 * @since 2021-12-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user")
@FieldNameConstants(innerTypeName = "Column")
public class User extends BaseDomain {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
}
