package com.amg.mall.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class PageQueryUtil extends LinkedHashMap<String, Object> {
    
    //当前页码
    private int current_page;
    
    //每页条数
    private int limit;
    
    public PageQueryUtil(Map<String, Object> params) {
        
        this.putAll(params);
        
        //分页参数
        this.current_page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        
        //每一页开始索引
        this.put("start" ,(current_page - 1) * limit);
        this.put("page", current_page);
        this.put("limit", limit);
        
    }
    
    public int getCurrent_page() {
        return current_page;
    }
    
    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }
    
    public int getLimit() {
        return limit;
    }
    
    public void setLimit(int limit) {
        this.limit = limit;
    }
    
    @Override
    public String toString() {
        return "PageQueryUtil{" +
                "current_page=" + current_page +
                ", limit=" + limit +
                '}';
    }
}
