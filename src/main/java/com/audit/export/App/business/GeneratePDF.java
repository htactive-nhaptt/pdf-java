package com.audit.export.App.business;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneratePDF {

    private static PDFont FONT = PDType1Font.HELVETICA;
    private static  float FONT_SIZE = 10;


    private void drawMultiLineText(String text, int x, int y, int allowedWidth, PDPage page, PDPageContentStream contentStream, PDFont font, int fontSize, int lineHeight) throws IOException {
        List<String> lines = new ArrayList<String>();
        StringBuilder myLine = new StringBuilder();
        String[] words = text.split(" ");
        for(String word : words) {
            if(myLine.length() > 0) {
                myLine.append(" ");
            }
            int size = (int) (fontSize * font.getStringWidth(myLine + word) / 1000);
            if(size > allowedWidth) {
                lines.add(myLine.toString());
                myLine = new StringBuilder(word);
            } else {
                myLine.append(word);
            }
        }
        lines.add(myLine.toString());
        for(String line : lines) {
            contentStream.beginText();
            contentStream.setFont(font, fontSize);
            contentStream.moveTextPositionByAmount(x, y);
            contentStream.drawString(line);
            contentStream.endText();
            y -= lineHeight;
        }
    }


    public void generateFile() throws IOException {
        File file = new File(System.getProperty("user.dir").concat("/my_work.pdf"));
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        String text = "Hi!!! This i adsf asdf asf a asdf asdf adsf afsdf asd asdf asdf asdf asdf asdf asdf asdf asdfa sdfa sdf asdf asdfs the multiple text content example asdfa sdfa sdf asdf a. phan tran thanh nha";
        String Line1 = "Here, we discussed about h aow to add text content in the pages of the PDF document.";
        String Line2 = "We do this by using the ShowText() method of the ContentStream class";
        drawMultiLineText(text, 20, 750, 580, page, contentStream, FONT, 10,10);
        drawMultiLineText(text, 20, 725, 580, page, contentStream, FONT, 10,10);
        contentStream.close();
        doc.save(System.getProperty("user.dir").concat("/my_work.pdf"));
        System.out.println("PDF Created");
        doc.close();
    }
}
