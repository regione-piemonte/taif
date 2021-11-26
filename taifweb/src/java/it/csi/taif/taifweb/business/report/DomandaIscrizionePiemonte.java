/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.Anchor;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.DottedLineSeparator;

//import com.itextpdf.text.Anchor;
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTSoggettoGestoreDto;



public class DomandaIscrizionePiemonte {

    
	FontsForDocuments docFonts= new FontsForDocuments();
	PdfUtils pdfUtils= new PdfUtils();
	
    public ByteArrayOutputStream createPdf(TaifTAziendaDto taifTAziendaDto,TaifTPraticaDto praticaIscritta,TaifTPersonaDto personaTitolareRapp,List<String> flagList,
    		TaifTSoggettoGestoreDto soggettoGestore , String comuneSoggetoGestore, String tipoFirma, String filePath) throws DocumentException, IOException {
   	
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    	Document document = new Document();
        PdfWriter writer= PdfWriter.getInstance(document, byteArrayOutputStream);
         writer.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO);
     
        document.setPageSize(PageSize.A4);
        document.setMargins(36, 36, 50, 30);
        document.open();

        addMarcaBolloBox(document, taifTAziendaDto);
        addRegioneBox(document, soggettoGestore, comuneSoggetoGestore );
        addTitleBodyPage(document,  personaTitolareRapp, taifTAziendaDto, soggettoGestore, flagList, tipoFirma,  filePath );
    
        document.close();
        byteArrayOutputStream.close();
	return byteArrayOutputStream;

    }
    
 
    private  void addRegioneBox(Document document, TaifTSoggettoGestoreDto soggettoGestore, String comuneSoggetoGestore) throws DocumentException {

    	
    	
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        String denominazione = soggettoGestore.getDenominazione();
        String[] divide = denominazione.split("-");
        String regioneAdress= divide[0].trim()+ "\n" + divide[1].trim() +"\n"  +  soggettoGestore.getIndirizzo() + "  "
        		+ soggettoGestore.getCivico() + "\n"  
        		+ soggettoGestore.getCap() + "  "
        		+ comuneSoggetoGestore.substring(0,1).concat(comuneSoggetoGestore.substring(1,comuneSoggetoGestore.length()).toLowerCase());
     
        Phrase paragInsert= new Phrase(regioneAdress, docFonts.normalFont);
        PdfPCell cell = new PdfPCell(paragInsert);
        cell.setPadding(10);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell);
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.getDefaultCell().setPadding(10);

        document.add(table);



    }

    private  void addMarcaBolloBox(Document document, TaifTAziendaDto taifTAziendaDto) throws DocumentException {

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 4});
        PdfPCell cell = new PdfPCell();
        cell.setBorderColor(Color.WHITE);
        cell.setColspan(2);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("MARCA DA BOLLO " +  "\n" +"       Euro 16,00", docFonts.smallBold));
        cell.setIndent(10);
        cell.setLeading(9f, 0f);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        String identificativo ="Nr. Identificativo della marca da bollo:";
        String numeroBollo= taifTAziendaDto.getNMarcaBollo();
        String comment= "Consapevole delle sanzioni penali previste dall'art. 76 del D.P.R. 445/2000, si dichiara che la " +
                "marca da bollo è stata annullata per la presentazione della presente domanda e non sarà " +
                "utilizzata per qualsiasi altro adempimento che ne richiede l'apposizione (art. 3 D.M. 10/11/11).";
        Paragraph secondCell = new Paragraph(identificativo + "\n" + numeroBollo + "\n" + comment , docFonts.smallBold);
        secondCell.setAlignment(Element.ALIGN_LEFT);
        cell = new PdfPCell(secondCell);
        cell.setPadding(5);
        cell.setLeading(9f, 0f);
        table.addCell(cell);

        table.setSpacingAfter(10f); 

        document.add(table);


    }

    private  void addTitleBodyPage(Document document, TaifTPersonaDto personaTitolareRapp,TaifTAziendaDto taifTAziendaDto, TaifTSoggettoGestoreDto soggettoGestore,
	    List<String> flagList, String firma, String filePath) throws DocumentException, IOException {

	
        String domandaTitle = "DOMANDA DI ISCRIZIONE" +  "\n" + "ALL'ALBO DELLE IMPRESE FORESTALI DEL PIEMONTE";
        String sottoscritto= "Il sottoscritto  ";
        String codiceFiscale= "codice fiscale ";
        String qualita= "in qualità di ";
        String qualitaTitolare = "Titolare/Legale rappresentante";
        
        String impresa= "dell'impresa denominata ";
        String core1= "che l'impresa che rappresenta sia iscritta all'Albo delle imprese forestali del Piemonte, istituito con l'art. 31 della l.r. 4/2009 (Gestione e promozione economica delle foreste ) e disciplinato dal Regolamento regionale 8/R/2020 (di seguito Regolamento), nella:";
        String sezioneA= "Sezione A – Imprese forestali con sede legale in Piemonte;";
        String sezioneB= "Sezione B – Imprese forestali che non hanno sede legale in Piemonte";
        String sezioneB1 = "altre regioni.;";
        String core3= "A tal fine trasmette la seguente documentazione:";
        String allegato1= "1 – Dichiarazione sostitutiva sui requisiti d'iscrizione previsti dall'art. 6 del Regolamento;";
        String allegato2= "2 – Scheda  aziendale.";
        String core5="Il sottoscritto si impegna a comunicare tempestivamente qualsiasi modifica o perdita dei requisiti, comprese le variazioni di indirizzo, residenza, domicilio, recapito telefonico e indirizzo PEC.";
        String core6="Solo in caso di firma autografa allegare fotocopia chiara e leggibile di un documento di identità in corso di validità del firmatario.";
        String core7= "ll sottoscritto dichiara di avere preso visione dell' ";
        String core8= "informativa sulla privacy ";
        String core9= "ai sensi del GDPR 2016/679.";
        String forSpace="   ";
        String twoSpace="  ";
        String tenSpace = "          ";
        String teSpace = "                           ";
    
        Chunk leader = new Chunk(new DottedLineSeparator());

        float indentation = 5;
    
       
        Paragraph preface = new Paragraph();
        preface.add(new Chunk(domandaTitle, docFonts.catFont));
        preface.setAlignment(Element.ALIGN_CENTER);
        pdfUtils.addEmptyLine(preface, 1);

      
        Paragraph testo = new Paragraph(sottoscritto, docFonts.normalFont);
        testo.add(new Chunk(personaTitolareRapp.getNome() + forSpace + personaTitolareRapp.getCognome(), docFonts.normalBold));
        testo.setAlignment(Element.ALIGN_LEFT);

       Paragraph testocf = new Paragraph(codiceFiscale, docFonts.normalFont);
       testocf.add(new Chunk(twoSpace.concat(personaTitolareRapp.getCodiceFiscale()), docFonts.normalBold));
       testocf.setAlignment(Element.ALIGN_LEFT);

       BaseFont base = BaseFont.createFont( filePath, BaseFont.IDENTITY_H, false);
       Font fontck = new Font(base, 12f, Font.NORMAL);
       char checked='\u00FE';
       char unchecked='\u00A8';
       Paragraph testoq = new Paragraph(qualita, docFonts.normalFont);
      
       testoq.add(new Chunk(forSpace.concat(qualitaTitolare), docFonts.normalBold));
       testoq.setAlignment(Element.ALIGN_LEFT);

        Paragraph testoi = new Paragraph(impresa, docFonts.normalFont);
        testoi.add(new Chunk(twoSpace.concat(taifTAziendaDto.getRagioneSociale()), docFonts.normalBold));
        testoi.setAlignment(Element.ALIGN_LEFT);
        pdfUtils.addEmptyLine(testoi, 1);

        Paragraph chiede = new Paragraph();
        chiede.setAlignment(Element.ALIGN_CENTER);
        chiede.add(new Chunk("CHIEDE",docFonts.normalBold));
        pdfUtils.addEmptyLine(chiede, 1);

        Paragraph richiesta1 = new Paragraph();
        richiesta1.add(new Chunk(core1, docFonts.normalFont));
        richiesta1.setAlignment(Element.ALIGN_JUSTIFIED);
        pdfUtils.addEmptyLine(richiesta1, 1);
        
        Paragraph richiesta3 = new Paragraph();
        richiesta3.setAlignment(Element.ALIGN_LEFT);
        richiesta3.setIndentationLeft(indentation);
        if(flagList.contains("A")) {
            richiesta3.add(new Chunk(twoSpace.concat(String.valueOf(checked)),fontck));  
        }else {
            richiesta3.add(new Chunk(twoSpace.concat(String.valueOf(unchecked)),fontck)); 
        }
        richiesta3.add(new Chunk(twoSpace.concat(sezioneA), docFonts.normalFont));
       
        Paragraph richiesta3B = new Paragraph();
        richiesta3B.setAlignment(Paragraph.ALIGN_LEFT);
        richiesta3B.setIndentationLeft(indentation);
        if(flagList.contains("B")) {
            richiesta3B.add(new Chunk(twoSpace.concat(String.valueOf(checked)),fontck));  
        }else {
            richiesta3B.add(new Chunk(twoSpace.concat(String.valueOf(unchecked)),fontck)); 
        }
        richiesta3B.add(new Chunk(twoSpace.concat(sezioneB), docFonts.normalFont));
        
  	Paragraph richiesta3B1 = new Paragraph();
	richiesta3B1.setAlignment(Element.ALIGN_LEFT);
	richiesta3B1.setIndentationLeft(indentation);
	richiesta3B1.add(new Chunk(tenSpace.concat(teSpace.concat(sezioneB1)), docFonts.normalFont));
	pdfUtils.addEmptyLine(richiesta3B1,1);

        Paragraph richiesta31 = new Paragraph();
        richiesta31.add(new Chunk(core3,docFonts.normalFont));
        richiesta31.setAlignment(Paragraph.ALIGN_LEFT);
        pdfUtils.addEmptyLine(richiesta31,1);
        
        Paragraph pAllegato1 = new Paragraph();
        pAllegato1.setAlignment(Element.ALIGN_LEFT);
        pAllegato1.setIndentationLeft(indentation);
        pAllegato1.add(new Chunk(tenSpace.concat(allegato1), docFonts.normalFont));
        
        Paragraph pAllegato2 = new Paragraph();
        pAllegato2.setAlignment(Element.ALIGN_LEFT);
        pAllegato2.setIndentationLeft(indentation);
        pAllegato2.add(new Chunk(tenSpace.concat(allegato2), docFonts.normalFont));
        pdfUtils.addEmptyLine(pAllegato2,1);
        
        Paragraph richiesta6 = new Paragraph();
        richiesta6.add(new Chunk(core5,docFonts.normalFont));
        richiesta6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        pdfUtils.addEmptyLine(richiesta6,1);
        
        Paragraph richiesta61 = new Paragraph();
        richiesta61.add(new Chunk(core6,docFonts.normalFont));
        richiesta61.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        pdfUtils.addEmptyLine(richiesta61,1);
                
        Anchor anchor = new Anchor(core8, docFonts.normalFontBlue);
        anchor.setReference(soggettoGestore.getUrlDocPrivacy());
                
        Paragraph richiesta7 = new Paragraph(core7, docFonts.normalFont);
        richiesta7.add(anchor);
        richiesta7.add(new Chunk(core9, docFonts.normalFont));
        pdfUtils.addEmptyLine(richiesta7,2);
        
        PdfPTable table = pdfUtils.makeFirmaDataTable(leader, firma, it.csi.taif.taifweb.business.dao.util.Constants.iLang);
      

        document.add(preface);
        document.add(testo);
        document.add(testocf);
        document.add(testoq);
        document.add(testoi);
        document.add(chiede);
        document.add(richiesta1);
        document.add(richiesta3);
        document.add(richiesta3B);
        document.add(richiesta3B1);
        document.add(richiesta31);
        document.add(pAllegato1);
        document.add(pAllegato2);
        document.add(richiesta6);
        document.add(richiesta61);
        document.add(richiesta7);
        document.add(table);

        // Start a new pagetesto
        document.newPage();
    }


}
