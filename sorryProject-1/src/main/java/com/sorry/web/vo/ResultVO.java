package com.sorry.web.vo;

import java.util.List;

public class ResultVO {
    String err_code;
    String err_msg;
    int page_no;
    int page_set;
    int total_count;
    int total_page;
    List<ApiVO> list;
    
    public String getErr_code() {
        return err_code;
    }
    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }
    public String getErr_msg() {
        return err_msg;
    }
    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }
    public int getPage_no() {
        return page_no;
    }
    public void setPage_no(int page_no) {
        this.page_no = page_no;
    }

    public int getPage_set() {
        return page_set;
    }
    public void setPage_set(int page_set) {
        this.page_set = page_set;
    }
    public int getTotal_count() {
        return total_count;
    }
    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }
    public int getTotal_page() {
        return total_page;
    }
    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }
    public List<ApiVO> getList() {
        return list;
    }
    public void setList(List<ApiVO> list) {
        this.list = list;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ResultVO [err_code=");
        builder.append(err_code);
        builder.append(", err_msg=");
        builder.append(err_msg);
        builder.append(", page_no=");
        builder.append(page_no);
        builder.append(", page_set=");
        builder.append(page_set);
        builder.append(", total_count=");
        builder.append(total_count);
        builder.append(", total_page=");
        builder.append(total_page);
        builder.append(", list=");
        builder.append(list);
        builder.append("]");
        return builder.toString();
    }
    
}
