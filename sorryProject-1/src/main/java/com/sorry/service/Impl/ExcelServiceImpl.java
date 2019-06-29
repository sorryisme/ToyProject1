package com.sorry.service.Impl;

import java.io.FileInputStream;
import java.math.BigDecimal;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.sorry.service.ExcelService;
import com.sorry.web.vo.ExcelVO;

@Service
public class ExcelServiceImpl implements ExcelService{
    
    /**
     * @param fileName(dart 정보)
     * @return insert amt
     * */
    @Override
    public int insertExcel (String fileName, String remark) {
        HSSFWorkbook workBook = fileToWorkbook(fileName);
        //3번째 시트를 가져오기
        HSSFSheet sheet = getSheet(workBook, 2);
        //12번째 row 가져오기
        HSSFRow rows = getRow(sheet,11);
        
        //당년 영업이익, 전년도 영업이익 값을 가져오기
        double cell1 = getNumeric(getCell(rows,1));
        double cell2 = getNumeric(getCell(rows,2));
        
        BigDecimal currentProfit = parseToDecimal(cell1); 
        BigDecimal lastProfit = parseToDecimal(cell2);
        
        ExcelVO vo = new ExcelVO();
        vo.setCurrentProfit(currentProfit);
        vo.setLastProfit(lastProfit);
        vo.setRemark(remark);
        
        
        
        return 0;
    }
    
    public HSSFWorkbook fileToWorkbook(String fileName) {
        HSSFWorkbook result = null;
        
        try { 
        FileInputStream fis = new FileInputStream("c:\\test\\excel\\"+ fileName +"_ko.xls");
        result = new HSSFWorkbook(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public HSSFSheet getSheet(HSSFWorkbook workbook,int no) {
        HSSFSheet result= null;
        try {
            result = workbook.getSheetAt(no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public HSSFRow getRow(HSSFSheet sheet, int no) {
        HSSFRow result = null;
        try{
            result = sheet.getRow(no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public HSSFCell getCell(HSSFRow rows, int no) {
        HSSFCell result = null;
        
        try {
            result = rows.getCell(no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public double getNumeric(HSSFCell cell) {
        return cell.getNumericCellValue();
    }
    
    public BigDecimal parseToDecimal(double no) {
        return new BigDecimal(no); 
    }
    
}

