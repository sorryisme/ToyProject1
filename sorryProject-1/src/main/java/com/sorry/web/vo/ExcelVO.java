package com.sorry.web.vo;

import java.math.BigDecimal;

public class ExcelVO {
    
    String remark;
    BigDecimal currentProfit;
    BigDecimal lastProfit;
    
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
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ExcelVO [remark=");
        builder.append(remark);
        builder.append(", currentProfit=");
        builder.append(currentProfit);
        builder.append(", lastProfit=");
        builder.append(lastProfit);
        builder.append("]");
        return builder.toString();
    }
    
    
}
