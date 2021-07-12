package com.audit.export.App.business;
import com.audit.export.App.dao.pdf.AuditData;
import com.audit.export.App.dao.pdf.entity.ProductGroup;
import com.audit.export.App.dao.pdf.entity.ShopData;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.WebColors;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;


import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.kernel.colors.Color;


import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneratePDFFile {

    private static final int font10 = 10;
    private static final String fontFamily = "Arial";
    private static final TextAlignment alignCenter = TextAlignment.CENTER;
    private static final Color greyColor = WebColors.getRGBColor("#C9C9C9");
    private static final Color whiteColor = ColorConstants.WHITE;



    public void addCellHeader(Table table, String value) {
        table.addCell(new Cell().add(new Paragraph(value)
                .setFontSize(font10)
                .setTextAlignment(alignCenter)
                .setBold()));
    }

    public void addCell(Table table, String value, Color color) {
        table.addCell(new Cell().setBackgroundColor(color).add(new Paragraph(value)
                .setFontSize(font10)));
    }

    public void addTable(Table table, ProductGroup group, Document document) {
        document.add(new Paragraph(group.getPgNumber() + " - " + group.getPgName()).setBold().setFontSize(font10));
        String [] headerStrings =  {"BRAND", "MODEL", "FEATURE TEXT", "M.P.", "ARTICLE", "PRO", "SAL"};
        new ArrayList<>(Arrays.asList(headerStrings)).forEach(title -> {
            addCellHeader(table, title);
        });
        AtomicInteger row = new AtomicInteger();
        group.getArticles().forEach(article -> {
            if(row.get() %2 !=0) {
                addCell(table,article.getBranch(), greyColor);
                addCell(table, article.getMode(), greyColor);
                addCell(table, article.getFeatureText(), greyColor);
                addCell(table, article.getMultiPack(), greyColor);
                addCell(table, article.getArticleNumber()+"",greyColor);
                addCell(table,article.getPro(),greyColor);
                addCell(table, article.getSal(),greyColor);
            } else {
                addCell(table,article.getBranch(), whiteColor);
                addCell(table, article.getMode(), whiteColor);
                addCell(table, article.getFeatureText(), whiteColor);
                addCell(table, article.getMultiPack(), whiteColor);
                addCell(table, article.getArticleNumber()+"",whiteColor);
                addCell(table,article.getPro(),whiteColor);
                addCell(table, article.getSal(),whiteColor);
            }
            row.getAndIncrement();

        });
    }

    public Cell getCell(String text, TextAlignment alignment) {
        Cell cell = new Cell().add(new Paragraph(text));
        cell.setPadding(0);
        cell.setTextAlignment(alignment);
        cell.setBorder(Border.NO_BORDER);
        return cell;
    }

    private void generateTopData(Document document, List<ShopData> shopData) throws MalformedURLException {
        String iconPath = System.getProperty("user.dir").concat("/src/main/resources/images/gfk.png");
        ImageData iconGFK = ImageDataFactory.create(iconPath);
        Image image = new Image(iconGFK);
        float [] column = {1F, 1F};
        Table table = new Table(column);
        table.setWidth(UnitValue.createPercentValue(100));
        Paragraph period = new Paragraph(shopData.get(0).getTitle() + " : " + shopData.get(0).getValue());
        Paragraph shop = new Paragraph(shopData.get(1).getTitle() + " : " + shopData.get(1).getValue());
        Paragraph printDate = new Paragraph(shopData.get(2).getTitle() + " : " + shopData.get(2).getValue());
        table.addCell(new Cell().add(period).setTextAlignment(TextAlignment.LEFT).setBorder(Border.NO_BORDER).setFontSize(font10).setBold());
        table.addCell(new Cell().add(image.setWidth(40f).setHorizontalAlignment(HorizontalAlignment.RIGHT)).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(shop).setBorder(Border.NO_BORDER).setFontSize(font10));
        table.addCell(new Cell().add(printDate).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER).setFontSize(font10).setPaddingTop(-2f));
        table.addCell(new Cell().setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("[PG #,Brand,Article #,Model,Feature Text]")).setBorder(Border.NO_BORDER).setFontSize(9f).setTextAlignment(TextAlignment.RIGHT).setPaddingTop(-7f));
        table.setMarginBottom(15f);
        document.add(table);



    }

    public void generatePDFFile() throws FileNotFoundException, MalformedURLException {
        List<ProductGroup> productGroups = new AuditData().getDataBody();
        List<ShopData> shopData = new AuditData().getShopData();
        // Create pdf writer

        String path = System.getProperty("user.dir").concat("/audit.pdf");

        PdfWriter pdfWriter = new PdfWriter(path);
        // Add a new page
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();
        // Creating document
        Document document = new Document(pdfDocument);
        generateTopData(document, shopData);
        float [] pointColumnWidths = {1, 1, 3, 1, 1, 1, 1};
        productGroups.forEach(group -> {
            Table table = new Table(UnitValue.createPercentArray(pointColumnWidths));
            table.setWidth(UnitValue.createPercentValue(100));
            table.setFixedLayout();
            addTable(table, group, document);
            document.add(table);
        });
        document.close();
        System.out.println("Generated PDF File");
    }
}