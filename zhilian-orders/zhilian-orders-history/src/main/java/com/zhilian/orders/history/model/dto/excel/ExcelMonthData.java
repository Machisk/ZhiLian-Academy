package com.zhilian.orders.history.model.dto.excel;

import lombok.Data;

import java.util.List;

/**
 * 导出表格月度数据
 *
 **/
@Data
public class ExcelMonthData {
    /**
     * 月份
     */
    private String month;

    /**
     * 当月每日统计数据
     */
    private List<StatisticsData> statisticsDataList;

    /**
     * 按月聚合数据
     */
    private AggregationStatisticsData monthAggregation;
}
