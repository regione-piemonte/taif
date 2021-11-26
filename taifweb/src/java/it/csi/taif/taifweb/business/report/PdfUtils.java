/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lowagie.text.Chunk;
import com.lowagie.text.DocumentException;
//TAIF-29: itextpdf DEPRECATA sostituita con openpdf (lowagie)
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import it.csi.taif.taifweb.business.dao.util.Constants;

public class PdfUtils {
	
	
    FontsForDocuments docFonts = new FontsForDocuments();

    public  void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public  PdfPCell getCell(Paragraph p, int verticalAlignment) {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setVerticalAlignment(verticalAlignment);
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        cell.addElement(p);
        return cell;
    }
    
    public PdfPTable makeFirmaDataTable(Chunk leader, String firma, String tracciato) throws DocumentException {
    	
    	
    	
    	Date date = new Date();
    	Paragraph p;
		PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{4,2,2});
        if(firma.equals("A")){
            	if(tracciato.equals(Constants.iLang)) {
            	    p = new Paragraph(it.csi.taif.taifweb.util.Constants.FIRMA_IT_LUOGO, docFonts.normalFont);
            	}else {
            	  p = new Paragraph(it.csi.taif.taifweb.util.Constants.FIRMA_FR_LUOGO, docFonts.normalFont); 
            	}
        	p.add(leader);
        }else{
            if(tracciato.equals(Constants.iLang)) {
        	p = new Paragraph(it.csi.taif.taifweb.util.Constants.FIRMA_IT_DATA + new SimpleDateFormat(it.csi.taif.taifweb.util.Constants.FIRMA_FORMAT_DATA).format(date), docFonts.normalFont);
            }else {
        	p = new Paragraph(it.csi.taif.taifweb.util.Constants.FIRMA_FR_DATA + new SimpleDateFormat(it.csi.taif.taifweb.util.Constants.FIRMA_FORMAT_DATA).format(date), docFonts.normalFont);
            }
        	
        }
    	table.addCell(getCell(p, PdfPCell.ALIGN_LEFT));
       
        if(firma.equals("A")){
            if(tracciato.equals(Constants.iLang)) {
        	p = new Paragraph(it.csi.taif.taifweb.util.Constants.FIRMA_IT_FIRMA, docFonts.normalFont);
            }else {
        	p = new Paragraph(it.csi.taif.taifweb.util.Constants.FIRMA_FR_FIRMA, docFonts.normalFont);
            }
            p = new Paragraph("firma", docFonts.normalFont);
            p.add(leader);
        }else {
            if(tracciato.equals(Constants.iLang)) {
        	  p = new Paragraph(it.csi.taif.taifweb.util.Constants.FIRMA_IT_DIGITAL, docFonts.normalFont);
            }else {
        	p = new Paragraph(it.csi.taif.taifweb.util.Constants.FIRMA_FR_DIGITAL, docFonts.normalFont);
            }
          
            
        }
        table.addCell(getCell(new Paragraph(), PdfPCell.ALIGN_CENTER));
        table.addCell(getCell(p, PdfPCell.ALIGN_LEFT));
        
		return table;
	}

 

}
