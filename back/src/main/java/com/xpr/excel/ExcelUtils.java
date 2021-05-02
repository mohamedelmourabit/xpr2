package com.xpr.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.joda.time.format.ISODateTimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ExcelUtils {

    public static Workbook generateWorkBook(List<WorkbookData> workbookDataList) {
        Workbook workbook = new XSSFWorkbook();
        for(WorkbookData wbData : workbookDataList){
            workbook = generateWorkBookList(wbData.getHeaders(), wbData.getData(), wbData.getSheetName(), workbook);
        }
        return workbook;
    }

    public static Workbook generateWorkBookList(String[] headers, Set<Object[]> data) {
        return generateWorkBookList(headers, data, null, null);
    }

    public static Workbook generateWorkBookList(String[] headers, Set<Object[]> data, String sheetName, Workbook defaultWorkbook) {
        Workbook workbook = (defaultWorkbook==null)? new XSSFWorkbook() : defaultWorkbook;

        // Create a Sheet
        Sheet sheet = (sheetName==null)? workbook.createSheet() : workbook.createSheet(sheetName);
        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
       // headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLUE.getIndex());
        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);
        String[] columns = headers;
        // Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int index=1;
        String pattern2 = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern2);
        for(Object[] row_data: data) {
            Row row = sheet.createRow(index++);
            for(int i=0;i<row_data.length;i++) {
                Object val = row_data[i];
                Cell cell0 = row.createCell(i);
                if(val != null) {
                    if(DataValidator.isValidDate(val.toString())) {
                        try {
                            cell0.setCellValue(df.format(DataValidator.parseDate(val.toString())));
                        }
                        catch(Exception e){
                            System.out.println("Exception: "+e);
                            cell0.setCellValue(val.toString());
                        }
                    }
                    else if(DataValidator.isNumeric(val)){
                        cell0.setCellValue(Double.parseDouble(val.toString()));
                        DataFormat cf = workbook.createDataFormat();
                        CellStyle currencyCellStyle = workbook.createCellStyle();
                        currencyCellStyle.setDataFormat(cf.getFormat("### ### ### ###"));
                        cell0.setCellStyle(currencyCellStyle);
                    }
                    else if(DataValidator.isBoolean(val)){
                        cell0.setCellValue( Boolean.valueOf(val.toString())? "Oui" : "Non" );
                    }
                    else {
                        cell0.setCellValue(val.toString());
                    }
                }
            }
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        return workbook;
    }

}

class DataValidator {

   // private static org.joda.time.format.DateTimeFormatter sdf = ISODateTimeFormat.dateTime();

    public static boolean isValidDate(String dateStr) {
        try {
            parseDate(dateStr);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Date parseDate(String dateStr) throws ParseException {
        return null;//sdf.parseDateTime(dateStr).toDate();
    }

    public static boolean isNumeric(Object val) {
        if (val == null) {
            return false;
        }
        return val instanceof Number;
    }

    public static boolean isBoolean(Object val) {
        if (val == null) {
            return false;
        }
        return val instanceof Boolean;
    }

}

