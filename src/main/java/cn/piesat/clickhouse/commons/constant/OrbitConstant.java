package cn.piesat.clickhouse.commons.constant;

import java.math.BigDecimal;

/**
 * @description OrbitConstant <br>
 * @date 2021-12-01 16:14:49 <br>
 * @author hezhanfeng <br>
 * @version 1.0.0 <br>
 */
public interface OrbitConstant {
    /**
     * 同步带距离地心的距离【同步带高度+地球半径】
     */
    BigDecimal SYNC_BELT_DISTANCE = new BigDecimal(42165800);
    /**
     * 地球半径
     */
    BigDecimal EARTH_RADIUS = new BigDecimal(6378140);
}
