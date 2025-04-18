package com.zhilian.customer.model.dto;

import lombok.Data;

/**
 * 关联id对应评分数据
 *
 **/
@Data
public class RelationScoreDTO {
    /**
     * 关联id
     */
    private String relationId;
    
    /**
     * 评分
     */
    private Double score;
}