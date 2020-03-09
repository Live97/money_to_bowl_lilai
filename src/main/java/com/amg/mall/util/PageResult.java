package com.amg.mall.util;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 */
public class PageResult implements Serializable {
    
    //总记录数
    private int totalCount;
    
    //总页码
    private int totalpage;
    
    //当前页码
    private int currentPage;
    
    //每页条数
    private int pageSize;
    
    //列表数据
    private List<?> list;
    
    
    /**
     *
     * @param totalCount   总记录数
     * @param currentPage  当前页码
     * @param pageSize     每页显示得数据条数
     * @param list         列表数据
     */
    public PageResult(int totalCount ,int currentPage ,int pageSize ,List<?> list) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.list = list;
        this.totalpage = (totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize + 1);
    }
    
    public int getTotalCount() {
        return totalCount;
    }
    
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    
    public int getTotalpage() {
        return totalpage;
    }
    
    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
    
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public List<?> getList() {
        return list;
    }
    
    public void setList(List<?> list) {
        this.list = list;
    }
    
    @Override
    public String toString() {
        return "PageResult{" +
                "totalCount=" + totalCount +
                ", totalpage=" + totalpage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }
}
