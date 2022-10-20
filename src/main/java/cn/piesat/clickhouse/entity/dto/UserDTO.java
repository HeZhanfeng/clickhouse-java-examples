package cn.piesat.clickhouse.entity.dto;

import cn.piesat.clickhouse.commons.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

/**
 * <p>
 * 日志
 * </p>
 *
 * @author hezhanfeng
 * @since 2021-12-02
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
}
