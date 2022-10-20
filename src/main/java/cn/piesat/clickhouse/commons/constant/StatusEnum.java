package cn.piesat.clickhouse.commons.constant;

/**
 * @description 状态枚举 <br>
 * @date 2022-01-06 20:55:11 <br>
 * @author hezhanfeng <br>
 * @version 1.0.0 <br>
 */
public enum StatusEnum {
    /**
     * 删除
     */
    DELETE(-1),
    /**
     * 恢复
     */
    RESTORE(1);

    /**
     * 状态：1：未删除，-1：已删除
     */
    private final Integer status;

    StatusEnum(Integer status) {
        this.status = status;
    }

    public Integer get() {
        return this.status;
    }
}
