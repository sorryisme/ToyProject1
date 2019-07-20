package com.sorry.web.vo;

import java.math.BigDecimal;

public class ExcelVO {
    
    String remark;
    BigDecimal currentProfit;
    BigDecimal lastProfit;
    String rcp_no;
    
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public BigDecimal getCurrentProfit() {
        return currentProfit;
    }
    public void setCurrentProfit(BigDecimal currentProfit) {
        this.currentProfit = currentProfit;
    }
    public BigDecimal getLastProfit() {
        return lastProfit;
    }
    public void setLastProfit(BigDecimal lastProfit) {
        this.lastProfit = lastProfit;
    }
    public String getRcp_no() {
        return rcp_no;
    }
    public void setRcp_no(String rcp_no) {
        this.rcp_no = rcp_no;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ExcelVO [currentProfit=");
        builder.append(currentProfit);
        builder.append(", lastProfit=");
        builder.append(lastProfit);
        builder.append(", rcp_no=");
        builder.append(rcp_no);
        builder.append(", remark=");
        builder.append(remark);
        builder.append("]");
        return builder.toString();
    }
    
    
}
