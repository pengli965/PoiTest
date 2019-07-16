package poi;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import java.io.*;
import java.math.BigInteger;
public class PoiTestWord {
    /**
     * word整体样式
     */
    private static CTStyles wordStyles = null;

    /**
     * Word整体样式
     */
    static {
        XWPFDocument template;
        try {
            // 读取模板文档
            template = new XWPFDocument(new FileInputStream("e:\\POI生成word练习.docx"));
            // 获得模板文档的整体样式
            wordStyles = template.getStyle();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        //创建Document对象
        XWPFDocument document = new XWPFDocument();
        //下载路径和文件名
        FileOutputStream out = new FileOutputStream(new File("e:\\POI生成word练习1.docx"));
        // 获取新建文档对象的样式
        XWPFStyles newStyles = document.createStyles();
        // 关键行// 修改设置文档样式为静态块中读取到的样式
        newStyles.setStyles(wordStyles);

        //
        //添加标题一
        XWPFParagraph titleP1 = document.createParagraph();
        titleP1.setStyle("1");
        XWPFRun titlepr1 = titleP1.createRun();
        //设置文本
        titlepr1.setText("我是标题一");


        //添加标题二
        XWPFParagraph titleP2 = document.createParagraph();
        titleP2.setStyle("2");
        XWPFRun titlepr2 = titleP2.createRun();
        //设置文本
        titlepr2.setText("我是标题二");

        //设置段落1
        XWPFParagraph firstP1 = document.createParagraph();
        XWPFRun run1 = firstP1.createRun();
        run1.setText("我们都是宋体");

        //设置段落2
        XWPFParagraph firstP2 = document.createParagraph();
        XWPFRun run2 = firstP2.createRun();
        run2.setText("我是蓝色加粗的");
        run2.setColor("0000FF");
        run2.setBold(true);

        //设置表格
        XWPFTable infoTable = document.createTable();
        //列宽自动分割
        CTTblWidth infoTableW = infoTable.getCTTbl().addNewTblPr().addNewTblW();
        infoTableW.setType(STTblWidth.DXA);
        infoTableW.setW(BigInteger.valueOf(9072));

        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("列名1");
        infoTableRowOne.addNewTableCell().setText("列名2");

        //表格第二行
        XWPFTableRow infoTableRowTwo = infoTable.createRow();
        infoTableRowTwo.getCell(0).setText("数据1");
        infoTableRowTwo.getCell(1).setText("数据2");

        document.write(out);
        out.close();
    }
}
