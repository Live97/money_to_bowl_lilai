package com.amg.mall.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *  订单实体类
 */
public class MallOrder  {
    
    private Integer order_id;
    
    private Integer user_id;
    
    private Integer total_price;
    
    private String order_number;
    
    private String extra_info;
    
    private String user_name;
    
    private String user_phone;
    
    private String user_address;
    
    private Byte pay_status;
    
    private Byte pay_type;
    
    private Byte order_status;
    
    private Byte is_deleted;
    
    private Date pay_time;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;
    
    public Integer getOrder_id() {
        return order_id;
    }
    
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
    
    public Integer getUser_id() {
        return user_id;
    }
    
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    
    public Integer getTotal_price() {
        return total_price;
    }
    
    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }
    
    public String getOrder_number() {
        return order_number;
    }
    
    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }
    
    public String getExtra_info() {
        return extra_info;
    }
    
    public void setExtra_info(String extra_info) {
        this.extra_info = extra_info;
    }
    
    public String getUser_name() {
        return user_name;
    }
    
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    
    public String getUser_phone() {
        return user_phone;
    }
    
    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
    
    public String getUser_address() {
        return user_address;
    }
    
    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
    
    public Byte getPay_status() {
        return pay_status;
    }
    
    public void setPay_status(Byte pay_status) {
        this.pay_status = pay_status;
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
    
    public Byte getIs_deleted() {
        return is_deleted;
    }
    
    public void setIs_deleted(Byte is_deleted) {
        this.is_deleted = is_deleted;
    }
    
    public Date getPay_time() {
        return pay_time;
    }
    
    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }
    
    public Date getCreate_time() {
        return create_time;
    }
    
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    
    public Date getUpdate_time() {
        return update_time;
    }
    
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MallOrder{");
        sb.append("order_id=").append(order_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", total_price=").append(total_price);
        sb.append(", order_numner='").append(order_number).append('\'');
        sb.append(", extra_info='").append(extra_info).append('\'');
        sb.append(", user_name='").append(user_name).append('\'');
        sb.append(", user_phone='").append(user_phone).append('\'');
        sb.append(", user_address='").append(user_address).append('\'');
        sb.append(", pay_status=").append(pay_status);
        sb.append(", pay_type=").append(pay_type);
        sb.append(", order_status=").append(order_status);
        sb.append(", is_deleted=").append(is_deleted);
        sb.append(", pay_time=").append(pay_time);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append('}');
        return sb.toString();
    }
}
