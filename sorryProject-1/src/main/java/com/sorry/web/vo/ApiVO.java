package com.sorry.web.vo;

public class ApiVO {
    String crp_cls; //법인구분 : Y(유가), K(코스닥), N(코넥스), E(기타)
    String crp_nm; //공시대상회사의 종목명(상장사) 또는 법인명(기타법인)
    String crp_cd; //공시대상회사의 종목코드(6자리) 또는 고유번호(8자리)
    String rpt_nm; //공시구분+보고서명+기타정보
    String rcp_no; //접수번호(공시뷰어 연결에 이용)
//    - PC용 : http://dart.fss.or.kr/dsaf001/main.do?rcpNo=접수번호
//    - 모바일용 : http://m.dart.fss.or.kr/html_mdart/MD1007.html?rcpNo=접수번호
    String flr_nm;//공시 제출인명
    String rcp_dt;//공시 접수일자(YYYYMMDD)
    String rmk;// 조합문자
    
    
    public String getCrp_cls() {
        return crp_cls;
    }
    public void setCrp_cls(String crp_cls) {
        this.crp_cls = crp_cls;
    }
    public String getCrp_nm() {
        return crp_nm;
    }
    public void setCrp_nm(String crp_nm) {
        this.crp_nm = crp_nm;
    }
    public String getCrp_cd() {
        return crp_cd;
    }
    public void setCrp_cd(String crp_cd) {
        this.crp_cd = crp_cd;
    }
    public String getRpt_nm() {
        return rpt_nm;
    }
    public void setRpt_nm(String rpt_nm) {
        this.rpt_nm = rpt_nm;
    }
    public String getRcp_no() {
        return rcp_no;
    }
    public void setRcp_no(String rcp_no) {
        this.rcp_no = rcp_no;
    }
    public String getFlr_nm() {
        return flr_nm;
    }
    public void setFlr_nm(String flr_nm) {
        this.flr_nm = flr_nm;
    }
    public String getRcp_dt() {
        return rcp_dt;
    }
    public void setRcp_dt(String rcp_dt) {
        this.rcp_dt = rcp_dt;
    }
    public String getRmk() {
        return rmk;
    }
    public void setRmk(String rmk) {
        this.rmk = rmk;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ApiVO [crp_cls=");
        builder.append(crp_cls);
        builder.append(", crp_nm=");
        builder.append(crp_nm);
        builder.append(", crp_cd=");
        builder.append(crp_cd);
        builder.append(", rpt_nm=");
        builder.append(rpt_nm);
        builder.append(", rcp_no=");
        builder.append(rcp_no);
        builder.append(", flr_nm=");
        builder.append(flr_nm);
        builder.append(", rcp_dt=");
        builder.append(rcp_dt);
        builder.append(", rmk=");
        builder.append(rmk);
        builder.append("]");
        return builder.toString();
    }
    
}
