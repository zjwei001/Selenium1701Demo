package com.qizi.day4.execl4j;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class POITest {
    public static List<Map<String, Object>> getDataFroMapsSheet(String path, int index) {
        List<Map<String, Object>> maplList = new ArrayList<>();
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new FileInputStream(path));
            Sheet sheet = workbook.getSheetAt(index);
            Row row = sheet.getRow(0);
            List<String> cellList = new ArrayList<String>();
            for (int i = 0; i < row.getLastCellNum(); i++) {
                Cell cell = row.getCell(i);
                // getValue(cell)
                cellList.add(String.valueOf(getValue(cell)));
            }

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i + 1);
                Map<String, Object> mapline = new HashMap<String, Object>();
                for (int j = 0; j < currentRow.getLastCellNum(); j++) {
                    mapline.put(cellList.get(j), getValue(currentRow.getCell(j)));
                }
                maplList.add(mapline);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return maplList;
    }

    private static Object getValue(Cell cell) {
        // TODO Auto-generated method stub
        if (cell == null) {
            return "";
        }
        if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
            return cell.getBooleanCellValue();
        } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        } else {
            return cell.getStringCellValue();
        }
    }

}

