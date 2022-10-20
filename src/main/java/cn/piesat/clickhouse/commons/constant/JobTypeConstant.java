package cn.piesat.clickhouse.commons.constant;

/**
 * @description: 任务分类常量
 * @author: chenjiahang
 * @Date: 2022-01-20 18:10
 * @version: 1.0.0
 */
public enum JobTypeConstant {

    /**
     * 接近任务
     */
    NEAR_EVENT_JOB("nearEventJob"),

    /**
     * 轨道变化任务
     */
    ORBIT_CHANGE_JOB("orbitChangeJob");

    private final String type;

    JobTypeConstant(String type){
        this.type = type;
    }

    public String get() {
        return this.type;
    }
}
