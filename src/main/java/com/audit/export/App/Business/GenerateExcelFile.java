package com.audit.export.App.Business;

import com.audit.export.App.Dao.ChildData;
import com.audit.export.App.Dao.TopData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class GenerateExcelFile {
    public void generate() throws IOException {
        ChildData childData = new ChildData();
        TopData topData = new TopData();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Sheet1");


        // Create header CellStyle
        Font headerFont = workbook.createFont();
        XSSFCellStyle headerCellStyle = spreadsheet.getWorkbook().createCellStyle();
        // setHeader Font
        headerFont.setFontHeightInPoints((short)10);
        headerFont.setFontName("Arial");

        // fill foreground color ...
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        // and solid fill pattern produces solid grey cell fill
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);

        // data type style
        Font dataFont = workbook.createFont();
        XSSFCellStyle dataCellStyle = spreadsheet.getWorkbook().createCellStyle();
        dataFont.setFontName("Arial");
        dataFont.setFontHeightInPoints((short) 10);
        dataCellStyle.setAlignment(HorizontalAlignment.LEFT);
        dataCellStyle.setWrapText(true);
        dataCellStyle.setFont(dataFont);

        // Top style
        Font topFont = workbook.createFont();
        CellStyle topCellStyle = spreadsheet.getWorkbook().createCellStyle();
        topCellStyle.setBorderTop(BorderStyle.THIN);
        topCellStyle.setBorderBottom(BorderStyle.THIN);
        topCellStyle.setBorderRight(BorderStyle.THIN);
        topCellStyle.setBorderLeft(BorderStyle.THIN);
        topFont.setFontName("Arial");
        topFont.setFontHeightInPoints((short)10);
        topCellStyle.setAlignment(HorizontalAlignment.LEFT);
        topCellStyle.setFont(topFont);

        // TitleFont
        Font titleFont = workbook.createFont();
        CellStyle titleCellStyle = spreadsheet.getWorkbook().createCellStyle();
        // setHeader Font
        titleFont.setFontHeightInPoints((short)10);
        titleFont.setBold(true);
        titleFont.setColor(IndexedColors.BLUE.index);
        titleFont.setFontName("Arial");
        titleCellStyle.setBorderRight(BorderStyle.THIN);
        titleCellStyle.setBorderLeft(BorderStyle.THIN);
        titleCellStyle.setBorderTop(BorderStyle.THIN);
        titleCellStyle.setBorderBottom(BorderStyle.THIN);
        // fill foreground color ...
        titleCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        // and solid fill pattern produces solid grey cell fill
        titleCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleCellStyle.setFont(titleFont);

        // Value Style
        XSSFCellStyle valueCellStyle = spreadsheet.getWorkbook().createCellStyle();
        valueCellStyle.setAlignment(HorizontalAlignment.LEFT);

        // TOP
        Set<String> topKeySet = topData.getData().keySet();
        int topRowNumber = 0;
        for(String key: topKeySet) {
            int topCellNumber = 0;

            XSSFRow topTopRow = spreadsheet.createRow(topRowNumber);
            topRowNumber++;

            Object[] topArrayObject = topData.getData().get(key);
            for(Object obj: topArrayObject) {
                XSSFCell cell;

                if(topCellNumber == 2) cell = topTopRow.createCell(6);
                else if(topCellNumber == 3) cell = topTopRow.createCell(8);
                else cell = topTopRow.createCell(topCellNumber);
                topCellNumber++;
                cell.setCellStyle(topCellStyle);
                if(obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if(obj instanceof  Integer) {
                    cell.setCellValue((Integer) obj);
                }
                if(topCellNumber % 2 != 0) {
                    cell.setCellStyle(titleCellStyle);
                }
                else {
                    cell.setCellStyle(topCellStyle);
                }

            }
        }

        // The table data
        // Iterate over data and write to sheet
        Set<String> keySet = childData.getData().keySet();
        int rowNumber = 5;
        for(String key: keySet) {
            int cellNum = 0;
            XSSFRow row = spreadsheet.createRow(rowNumber++);
            row.setHeight((short)-1);
            Object[] objectArray = childData.getData().get(key);
            for(Object obj: objectArray) {
                XSSFCell cell = row.createCell(cellNum++);
                // if rowNum is 6 (first row was created before) then set header CellStyle
                if (rowNumber == 6) {
                    cell.setCellValue((String) obj);
                    cell.setCellStyle(headerCellStyle);
                }
                else if(obj instanceof String) {
                    cell.setCellValue((String) obj);
                    row.setRowStyle(dataCellStyle);
                    cell.setCellStyle(dataCellStyle);
                } else if(obj instanceof  Integer) {
                    cell.setCellValue((Integer) obj);
                    cell.setCellStyle(dataCellStyle);
                }
            }
        }

        for(int column = 0; column < 10; column++) {
            spreadsheet.autoSizeColumn(column);
        }

        for(int row = 0; row <= 4; row++) {
            spreadsheet.addMergedRegion(new CellRangeAddress(row, row, 1, 5));
            spreadsheet.addMergedRegion(new CellRangeAddress(row, row, 6, 7));
            spreadsheet.addMergedRegion(new CellRangeAddress(row, row, 8, 11));
            RegionUtil.setBorderBottom(BorderStyle.THIN, new CellRangeAddress(row, row, 1, 5), spreadsheet);
            RegionUtil.setBorderBottom(BorderStyle.THIN, new CellRangeAddress(row, row, 6, 7), spreadsheet);
            RegionUtil.setBorderBottom(BorderStyle.THIN, new CellRangeAddress(row, row, 8, 11), spreadsheet);
            RegionUtil.setBorderRight(BorderStyle.THIN, new CellRangeAddress(row, row, 1, 5), spreadsheet);
            RegionUtil.setBorderRight(BorderStyle.THIN, new CellRangeAddress(row, row, 6, 7), spreadsheet);
            RegionUtil.setBorderRight(BorderStyle.THIN, new CellRangeAddress(row, row, 8, 11), spreadsheet);

        }

        FileOutputStream out = new FileOutputStream(new File("export.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("export.xlsx written successfully");
    }
}
