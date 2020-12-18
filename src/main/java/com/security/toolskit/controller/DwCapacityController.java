package com.security.toolskit.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.security.toolskit.common.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@Api(tags = "用户管理",value = "用户管理")
@RequestMapping("/dw")
public class DwCapacityController {

    public static void main(String[] args) throws IOException {

        Document document = new Document(PageSize.A4,30,30,40,40);
        try {
            // 中文文本
            BaseFont bfChinese= BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font subjectFont=new Font(bfChinese,10,Font.BOLD);
            Font titleFont=new Font(bfChinese,8,Font.BOLD);
            Font keyFont=new Font(bfChinese,6,Font.BOLD);
            Font textFont=new Font(bfChinese,6, Font.NORMAL);

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Administrator\\Desktop\\1.pdf"));

            document.open();
            Paragraph titlePara = new Paragraph("主标题",subjectFont);
            titlePara.setAlignment(Element.ALIGN_CENTER);
            document.add(new Paragraph(titlePara));

            document.add(new Paragraph("1. 目录1",titleFont));
            document.add(new Paragraph("\r\n")); // 换行
            PdfPTable table = createTable(writer, keyFont, textFont);
            document.add(table);
            document.add(new Paragraph("2. 目录2",titleFont));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

    }
    public static PdfPTable createTable(PdfWriter writer, Font keyfont,Font textfont) throws DocumentException, IOException {
        PdfPTable table = new PdfPTable(2);//生成一个两列的表格
        PdfPCell cell;
        int size = 15;
        cell = new PdfPCell(new Paragraph("标题1",keyfont));
        cell.setFixedHeight(size);//设置高度
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("标题2",keyfont));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("内容1",textfont));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("内容2",textfont));
        cell.setFixedHeight(size);
        table.addCell(cell);
        return table;
    }
}
