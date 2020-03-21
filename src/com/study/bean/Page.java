package com.study.bean;

import java.util.List;

public class Page<T> {
    //当前是第几页
    private int pageNo;
    //总页数
    private int totalPage;
    //总记录数
    private int totalCount;
    //每页像是的条数
    private int pageSize=4;
    //数据库从哪个索引开始
    private int index;
    //是否有下页
    private boolean hasNext;
    //是否有上页
    private boolean hasPrev;
    //查询出来的分页数据
    private List<T> list;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", index=" + index +
                ", hasNext=" + hasNext +
                ", hasPrev=" + hasPrev +
                ", list=" + list +
                '}';
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        pageNo = pageNo>0?pageNo:1;
        pageNo = pageNo>getTotalPage()?getTotalPage():pageNo;
        this.pageNo = pageNo;
    }

    public int getTotalPage() {
        return (int) Math.ceil((double) getTotalCount()/(double) getPageSize());
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getIndex() {

        return (getPageNo()-1)*pageSize;
    }


    public boolean isHasNext() {
        return getPageNo()<getTotalPage();
    }


    public boolean isHasPrev() {
        return getPageNo()>1;
    }


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Page(int pageNo, int totalPage, int totalCount, int pageSize, int index, boolean hasNext, boolean hasPrev, List<T> list) {
        this.pageNo = pageNo;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.index = index;
        this.hasNext = hasNext;
        this.hasPrev = hasPrev;
        this.list = list;
    }

    public Page() {
    }
}
