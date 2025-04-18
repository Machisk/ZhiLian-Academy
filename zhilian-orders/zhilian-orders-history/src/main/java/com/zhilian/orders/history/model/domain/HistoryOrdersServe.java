package com.zhilian.orders.history.model.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 服务任务
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "history_orders_serve",autoResultMap = true)
public class HistoryOrdersServe implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务单id，和
     */
    @TableId(value = "id", type = IdType.NONE)
    private Long id;

    /**
     * 服务人员或服务机构id
     */
    private Long serveProviderId;

    /**
     * 服务者类型，2：服务端服务，3：机构端服务
     */
    private Integer serveProviderType;

    /**
     * 机构服务人员id
     */
    private Long institutionStaffId;

    /**
     * 机构人员姓名
     */
    private String institutionStaffName;

    /**
     * 订单来源类型，1：抢单，2：派单
     */
    private Integer ordersOriginType;

    /**
     * 客户姓名
     */
    private String contactsName;

    /**
     * 客户电话
     */
    private String contactsPhone;

    /**
     * 服务地址
     */
    private String serveAddress;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 服务分类id
     */
    private Long serveTypeId;

    /**
     * 服务分裂名称
     */
    private String serveTypeName;

    /**
     * 预约时间
     */
    private LocalDateTime serveStartTime;

    /**
     * 服务项名称
     */
    private String serveItemName;

    /**
     * 服务项id
     */
    private Long serveItemId;

    /**
     * 服务图片
     */
    private String serveItemImg;

    /**
     * 服务单状态，3：服务完成，4：订单关闭
     */
    private Integer serveStatus;

    /**
     * 服务人姓名
     */
    private String serveProviderStaffName;

    /**
     * 服务人手机号
     */
    private String serveProviderStaffPhone;

    /**
     * 退款时间
     */
    private LocalDateTime refundTime;

    /**
     * 退款原因
     */
    private String refundReason;

    /**
     * 实际服务开始时间
     */
    private LocalDateTime realServeStartTime;

    /**
     * 实际服务完结时间
     */
    private LocalDateTime realServeEndTime;

    /**
     * 服务前照片
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> serveBeforeImgs;

    /**
     * 服务后照片
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> serveAfterImgs;

    /**
     * 服务前说明
     */
    private String serveBeforeIllustrate;

    /**
     * 服务后说明
     */
    private String serveAfterIllustrate;

    /**
     * 订单金额
     */
    private BigDecimal ordersAmount;

    /**
     * 服务单位
     */
    private Integer unit;

    /**
     * 服务数量
     */
    private Integer serveNum;

    /**
     * 服务端/机构端是否展示，1：展示，0：隐藏
     */
    private Integer display;

    /**
     * 是否是逻辑删除
     */
    private Integer isDeleted;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 排序时间，服务单状态为服务完成，该字段是完成时间；服务单状态为订单关闭，该时间为退款时间
     */
    private LocalDateTime sortTime;


}
