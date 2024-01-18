package controllers;


import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import data.DataVenda;
import models.Venda;

public class ControllerPdf {

	private DataVenda dados = new DataVenda();
	private ControllerCliente controller = new ControllerCliente();
	
	public ControllerPdf() {
		
	}
	
	public void criarPdfVendas(ArrayList<Venda> vendas, String nomeCliente) throws ExcecaoControladores {
		
		verificarCampos(vendas, nomeCliente);
		
		String destino = "C:/PDFS/pfdVendas"+nomeCliente+".pdf";
		
		try {
			PdfWriter writer = new PdfWriter(destino);
			
			PdfDocument pdfDoc = new PdfDocument(writer);
			pdfDoc.addNewPage();
			
			Document document = new Document(pdfDoc); 
			
			float [] pointColumnWidths = {150F, 150F, 150F};   
		    Table table = new Table(pointColumnWidths);
		    
		    table.addCell(new Cell().add("VALOR"));
		    table.addCell(new Cell().add("DATA"));
		    table.addCell(new Cell().add("CLIENTE"));
			
			for(Venda venda : vendas) {
				table.addCell(new Cell().add("" + venda.getValor()));
				table.addCell(new Cell().add("" + venda.getData()));
				table.addCell(new Cell().add("" + venda.getCliente().getNome()));
			}
			
			String StrParagraph = "VALOR TOTAL: " + controller.buscarDebitoCliente(nomeCliente);
			Paragraph para = new Paragraph(StrParagraph);
			
			document.add(table);
			document.add(para);
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void verificarCampos(ArrayList<Venda> vendas, String nomeCliente) throws ExcecaoControladores{
		if (nomeCliente.isBlank()) {
			throw new ExcecaoControladores("Selecione um cliente.");
		}
		
		if(vendas.isEmpty()) {
			throw new ExcecaoControladores("O cliente selecionado não possui vendas em aberto");
		}
	}
}
