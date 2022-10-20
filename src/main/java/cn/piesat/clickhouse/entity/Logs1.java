package cn.piesat.clickhouse.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
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
@Accessors(chain = true)
@TableName("logs1")
@FieldNameConstants(innerTypeName = "Column")
public class Logs1 implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDateTime logTime;

    private String machineName;

    private String machineGroup;

    private Float cpuIdle;

    private Float cpuNice;

    private Float cpuSystem;

    private Float cpuUser;

    private Float cpuWio;

    private Float diskFree;

    private Float diskTotal;

    private Float partMaxUsed;

    private Float loadFifteen;

    private Float loadFive;

    private Float loadOne;

    private Float memBuffers;

    private Float memCached;

    private Float memFree;

    private Float memShared;

    private Float swapFree;

    private Float bytesIn;

    private Float bytesOut;
}
