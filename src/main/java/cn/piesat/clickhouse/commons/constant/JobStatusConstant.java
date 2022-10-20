package cn.piesat.clickhouse.commons.constant;

/**
 * <p>
 * 任务状态常量
 * </p>
 *
 * @author hezhanfeng
 * @version v1.0
 * @date 2021-05-12 17:19
 */
public enum JobStatusConstant {
    /**
     * 正常
     */
    NORMAL(1),
    /**
     * 暂停
     */
    PAUSE(0);

    private final Integer status;

    JobStatusConstant(Integer status) {
        this.status = status;
    }

    public Integer get() {
        return this.status;
    }
}
