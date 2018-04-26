package com.mrlin.service;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class UserPDFView extends AbstractPdfView {

    protected void buildPdfDocument(Map<String, Object> model, Document document,
                                    PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Map<String,String> userData = (Map<String,String>) model.get("userData");

        Table table = new Table(2);
        table.addCell("No.");
        table.addCell("User Name");

//        for (Map.Entry<String, String> entry : userData.entrySet()) {
//            table.addCell(entry.getKey());
//            table.addCell(entry.getValue());
//        }

        userData.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByKey())
                .forEachOrdered(entry -> {
                    try {
                        table.addCell(entry.getKey());
                        table.addCell(entry.getValue());
                    } catch (BadElementException e) {
                        e.printStackTrace();
                    }
                });
        document.add(table);
    }
}
