package cn.piesat.clickhouse.commons.constant;

/**
 * @description 参考坐标系枚举 <br>
 * @date 2022-01-07 13:12:51 <br>
 * @author hezhanfeng <br>
 * @version v1.0 <br>
 */
public enum CoordinateEnum {
    /**
     * J2000 惯性系
     */
    J2000("J2000"),
    /**
     * IERS2010 地固系
     */
    IERS2010("IERS2010");

    /**
     * 参考坐标系
     */
    private final String coordinate;

    private CoordinateEnum(String type) {
        this.coordinate = type;
    }

    public String get() {
        return this.coordinate;
    }
}
