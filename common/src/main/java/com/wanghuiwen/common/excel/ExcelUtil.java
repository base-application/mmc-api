package com.wanghuiwen.common.excel;

import com.wanghuiwen.common.UtilFun;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

    public static List<List<String>> read(MultipartFile file) throws IOException {
        List<List<String>> list = new ArrayList<>();
        Workbook offices;

        String lowerCaseFileName = file.getOriginalFilename().toLowerCase();
        if (lowerCaseFileName.endsWith(".xlsx")) {
            offices = new XSSFWorkbook(file.getInputStream());
        } else {
            offices = new HSSFWorkbook(file.getInputStream());
        }


        Sheet sheet1 = offices.getSheetAt(0);

        //删除第一行标题
        sheet1.removeRow(sheet1.getRow(0));

        for (Row row : sheet1) {
            List<String> rowData = new ArrayList<>();
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        rowData.add(cell.getRichStringCellValue().getString());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            rowData.add(UtilFun.DateToString(cell.getDateCellValue(),"MM/dd/YYYY"));
                        } else {
                            rowData.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                        }
                        break;
                    case BOOLEAN:
                        rowData.add(String.valueOf(cell.getBooleanCellValue()));
                        break;
                    case FORMULA:
                        rowData.add(cell.getCellFormula());
                        break;
                    default:
                        rowData.add(null);
                }

            }
            list.add(rowData);
        }

        return list;

    }
}
