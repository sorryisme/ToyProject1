package com.sorry.web.vo;

public class BoardVO {
    
    int boardNo;
    int readFlag;
    String updateDate;
    String TargetCompany;
    String title;
    String remarks;
    String submitter;
    String link;
    String regDate;
    
    public int getBoardNo() {
        return boardNo;
    }
    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }
    public int getReadFlag() {
        return readFlag;
    }
    public void setReadFlag(int readFlag) {
        this.readFlag = readFlag;
    }
    public String getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    public String getTargetCompany() {
        return TargetCompany;
    }
    public void setTargetCompany(String targetCompany) {
        TargetCompany = targetCompany;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getSubmitter() {
        return submitter;
    }
    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getRegDate() {
        return regDate;
    }
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

}
