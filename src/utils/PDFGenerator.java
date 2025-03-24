package utils;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import models.Product;
import java.io.FileOutputStream;
import java.util.List;

public class PDFGenerator {
    public static void generatePDF(String name, String contract, String address, List<Product> products) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Bill.pdf"));
            document.open();
            
            document.add(new Paragraph("Buyer Name: " + name));
            document.add(new Paragraph("Contract: " + contract));
            document.add(new Paragraph("Address: " + address));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            table.addCell("Product");
            table.addCell("Quantity");
            table.addCell("Price");
            table.addCell("Total");

            for (Product p : products) {
                table.addCell(p.getName());
                table.addCell(String.valueOf(p.getQuantity()));
                table.addCell(String.valueOf(p.getPrice()));
                table.addCell(String.valueOf(p.getTotalPrice()));
            }
            document.add(table);
            document.add(new Paragraph("Thank you for visiting!"));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
