package com.amg.mall.controller.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单列表页面VO
 */
public class MallOrderListVO implements Serializable {
    
    private Integer order_id;
    
    private String order_number;
    
    private Integer total_price;
    
    private Byte pay_type;
    
    private Byte order_status;
    
    private String orderStatusString;
    
    private String user_address;
    
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date create_time;
    
    private List<MallOrderItemVO> MallOrderItemVOS;
    
    public Integer getOrder_id() {
        return order_id;
    }
    
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
    
    public String getOrder_number() {
        return order_number;
    }
    
    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }
    
    public Integer getTotal_price() {
        return total_price;
    }
    
    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }
    
    public Byte getPay_type() {
        return pay_type;
    }
    
    public void setPay_type(Byte pay_type) {
        this.pay_type = pay_type;
    }
    
    public Byte getOrder_status() {
        return order_status;
    }
    
    public void setOrder_status(Byte order_status) {
        this.order_status = order_status;
    }
    
    public String getOrderStatusString() {
        return orderStatusString;
    }
    
    public void setOrderStatusString(String orderStatusString) {
        this.orderStatusString = orderStatusString;
    }
    
    public String getUser_address() {
        return user_address;
    }
    
    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
    
    public Date getCreate_time() {
        return create_time;
    }
    
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    
    public List<MallOrderItemVO> getMallOrderItemVOS() {
        return MallOrderItemVOS;
    }
    
    public void setMallOrderItemVOS(List<MallOrderItemVO> mallOrderItemVOS) {
        MallOrderItemVOS = mallOrderItemVOS;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MallOrderListVO{");
        sb.append("order_id=").append(order_id);
        sb.append(", order_number='").append(order_number).append('\'');
        sb.append(", total_price=").append(total_price);
        sb.append(", pay_type=").append(pay_type);
        sb.append(", order_status=").append(order_status);
        sb.append(", orderStatusString='").append(orderStatusString).append('\'');
        sb.append(", user_address='").append(user_address).append('\'');
        sb.append(", create_time=").append(create_time);
        sb.append(", MallOrderItemVOS=").append(MallOrderItemVOS);
        sb.append('}');
        return sb.toString();
    }
}
