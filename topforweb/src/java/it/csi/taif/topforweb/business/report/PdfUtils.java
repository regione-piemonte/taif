/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.report;

import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;

//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.PdfPCell;



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
    
   

}
