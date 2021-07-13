package com.audit.export.App.business;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.HorizontalAlignment;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.utils.ImageUtils;
import com.audit.export.App.dao.TestDao;
import com.audit.export.App.dao.pdf.AuditData;
import com.audit.export.App.dao.pdf.entity.Article;
import com.audit.export.App.dao.pdf.entity.ProductGroup;
import com.audit.export.App.dao.pdf.entity.ShopData;
import com.google.common.io.Files;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class TableTest {
    private static final int fontSize10 = 9;
    private static final int margin = 40;


    public void createHeader(Row<PDPage> row, BaseTable table) {
        List<String> headers = new AuditData().getHeader();
        for (String header : headers) {
            Cell<PDPage> cell;
            if(header.contains("FEATURE TEXT")){
                cell = row.createCell((100 / 3f), header);
            } else {
                cell = row.createCell((100 / 9f), header);
            }
            cell.setFont(PDType1Font.HELVETICA_OBLIQUE);
            cell.setFillColor(Color.WHITE);
            cell.setTextColor(Color.BLACK);
            cell.setAlign(HorizontalAlignment.CENTER);
            cell.setFontSize(fontSize10);
        }
        table.addHeaderRow(row);
    }

    public void generate() throws IOException {
        List<String[]> facts = new TestDao().getFacts();
        List<ProductGroup> productGroups = new AuditData().getDataBody();

        PDDocument doc = new PDDocument();
        PDPage page = addNewPage(doc);
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);

        // Initialize table
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        boolean drawContent = true;
        float yStart = yStartNewPage;
        float bottomMargin = 70;
        BaseTable table = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);

        // Create Header row
        Row<PDPage> headerRow = table.createRow(15f);

        Cell<PDPage> cell;
        createHeader(headerRow, table);

        Row<PDPage> row;




        for (String[] fact : facts) {
            row = table.createRow(10f);
            cell = row.createCell((100 / 3f) * 2, fact[0]);
            cell.setFont(PDType1Font.HELVETICA);
            cell.setFontSize(fontSize10);

            for (int i = 1; i < fact.length; i++) {
                cell = row.createCell((100 / 9f), fact[i]);
                cell.setFont(PDType1Font.HELVETICA_OBLIQUE);
                cell.setFontSize(fontSize10);
            }
        }

        for(ProductGroup productGroup: productGroups) {
            row = table.createRow(10f);
            cell = row.createCell((100 / 3f) * 2, fact[0]);
            cell.setFont(PDType1Font.HELVETICA);
            cell.setFontSize(fontSize10);
            for(Article shopData: productGroup.getArticles()) {

            }
        }




        table.draw();


            // Close Stream and save pdf
            File file = new File("target/BoxableSample1.pdf");
            System.out.println("Sample file saved at : " + file.getAbsolutePath());
            Files.createParentDirs(file);
            doc.save(file);
            doc.close();

    }




    private static PDPage addNewPage(PDDocument doc) {
        PDPage page = new PDPage();
        doc.addPage(page);
        return page;
    }
}
