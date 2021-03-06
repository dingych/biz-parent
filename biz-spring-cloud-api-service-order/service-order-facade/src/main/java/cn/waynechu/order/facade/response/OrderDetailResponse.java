package cn.waynechu.order.facade.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhuwei
 * @since 2019/9/20 14:46
 */
@Data
@ApiModel(description = "订单详情返回对象")
public class OrderDetailResponse {

    @ApiModelProperty("订单ID")
    private Long id;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("套餐ID")
    private Long productId;

    @ApiModelProperty("套餐名称")
    private String name;

    @ApiModelProperty("套餐状态：0下架，1上架")
    private Boolean productStatus;

    @ApiModelProperty("订单状态：1已下单，2已送达（部门代理人领餐成功），3已领取（代理人确认成员领餐），4未领取（9点后代理人未确认领取的全部设为未领取）。取消订单删除该条记录）")
    private Integer orderStatus;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
}
