package org.generation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Main {
	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		
		Document doc = new Document();
		Image image = Image.getInstance("logo.png");
		image.scaleAbsolute(100,100);
		PdfWriter.getInstance(doc, new FileOutputStream("ReciboNomina.pdf"));
		doc.open();
		PdfPTable table = new PdfPTable(3);
		PdfPCell cell;
		cell = new PdfPCell( new Paragraph("Recibo de nómina"));
		cell.setColspan(3);
		table.addCell(cell);
		cell = new PdfPCell( new Paragraph("Nombre:"));
		cell.setRowspan(2);
		table.addCell(cell);
		table.addCell("RFC:");
		table.addCell("Fecha:");
		table.addCell("Departamento:");
		table.addCell("Salario:");
		doc.add(image);
		doc.add(new Paragraph("Empresa CH45 SA de CV de RL"));		
		doc.add(new Paragraph(" "));		
		doc.add(table);
		doc.close();
	}//main
}//class Main
