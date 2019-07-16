package poi;


import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;

public class PoiTestExcel {
    public static void main(String[] args) throws Exception {

        String xlsPath = "E:POI生成excel练习.xlsx";


        // excel文档对象
        XSSFWorkbook wk1 = new XSSFWorkbook();
        // sheet对象
        XSSFSheet sheet1 = wk1.createSheet("第一个sheet页");

        // 内容字体样式
        XSSFFont contFont1 = wk1.createFont();
        //字体颜色
        contFont1.setColor(Font.COLOR_NORMAL);
        // 内容样式
        XSSFCellStyle contentStyle1 = wk1.createCellStyle();
        // 设置字体css
        contentStyle1.setFont(contFont1);

        // 合并单元格（第五行,第三列,标题）
        CellRangeAddress cAddress1 = new CellRangeAddress(4, 4, 2, 3);
        sheet1.addMergedRegion(cAddress1);

        // 创建第五行
        XSSFRow row15 = sheet1.createRow(4);
        // 创建第五行第三列
        XSSFCell row3Cell13 = row15.createCell(2);
        row3Cell13.setCellValue("我是循环写入的数据头");
        row3Cell13.setCellStyle(contentStyle1);

        //创建第6-10行
        for (int j = 1; j < 6; j++) {//获取每行
            sheet1.createRow(4+j).createCell(2).setCellValue(j);
        }



        // sheet对象
        XSSFSheet sheet2 = wk1.createSheet("第二个sheet页");

        // 内容字体样式
        XSSFFont contFont2 = wk1.createFont();
        // 字体名称
        contFont2.setFontName("宋体");
        // 字体大小
        contFont2.setFontHeight(18);
        //字体颜色
        contFont2.setColor(Font.COLOR_RED);
        // 内容样式
        XSSFCellStyle contentStyle2 = wk1.createCellStyle();
        // 设置字体css
        contentStyle2.setFont(contFont2);
        // 合并单元格（第一行、标题）
        CellRangeAddress cAddress2 = new CellRangeAddress(2, 2, 1, 3);
        sheet2.addMergedRegion(cAddress2);

        // 创建第三行
        XSSFRow row23 = sheet2.createRow(2);
        // 创建第三行第二列
        XSSFCell row3Cell22 = row23.createCell(1);
        row3Cell22.setCellValue("我是合并单元格，宋体十八号");
        row3Cell22.setCellStyle(contentStyle2);

        FileOutputStream outputStream = new FileOutputStream(xlsPath);
        wk1.write(outputStream);
        outputStream.flush();
    }
}

