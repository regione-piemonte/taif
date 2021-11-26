/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//TAIF-29: itextpdf DEPRECATA sostituita con openpdf (lowagie)
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.DottedLineSeparator;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTSoggettoGestoreDto;
import it.csi.taif.taifweb.business.dao.util.Constants;


public class AttestazioneConfermaAosta {

  
    
	FontsForDocuments docFonts= new FontsForDocuments();
	PdfUtils pdfUtils= new PdfUtils();

    public ByteArrayOutputStream createPdf(TaifTAziendaDto taifTAziendaDto,TaifTPraticaDto praticaIscritta,TaifTPersonaDto personaTitolareRapp, TaifTSoggettoGestoreDto soggettoGestore,
	    String comuneSoggetoGestore,String tipoFirma, String filePath) throws DocumentException, IOException {
       
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    	 
    	Document document = new Document();
        PdfWriter writer= PdfWriter.getInstance(document,byteArrayOutputStream);
        writer.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO);
      
        document.setPageSize(PageSize.A4);
        document.setMargins(36, 36, 90, 70);
        document.open();
    
        addRegioneBox(document, soggettoGestore, comuneSoggetoGestore);
        addTitleBodyPage(document,  personaTitolareRapp, taifTAziendaDto ,praticaIscritta,  tipoFirma,  filePath);
   
        document.close();
        byteArrayOutputStream.close();
    	return byteArrayOutputStream;

    }
    
   
    

    private  void addRegioneBox(Document document, TaifTSoggettoGestoreDto soggettoGestore,String comuneSoggetoGestore) throws DocumentException {

    	
    	
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        String denominazione = soggettoGestore.getDenominazione();
        String[] divide = denominazione.split("-");
        String regioneAdress= divide[0].trim()+ "\n" + divide[1].trim() +"\n"  +  soggettoGestore.getIndirizzo() + "  "
        		+ soggettoGestore.getCivico() + "\n"  
        		+ soggettoGestore.getCap() + "  "
        		+ comuneSoggetoGestore;
        String regioneMail = "Spedire via PEC a ";
        String mmailAdress = soggettoGestore.getPec();
        Phrase paragInsert= new Phrase(regioneAdress, docFonts.normalFont);
        PdfPCell cell = new PdfPCell(paragInsert);
        cell.setPadding(10);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell);
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.getDefaultCell().setPadding(10);
        table.addCell(new Phrase(regioneMail + "\n" + mmailAdress, docFonts.normalBold));
        document.add(table);



    }
 
    
   
    private  void addTitleBodyPage(Document document, TaifTPersonaDto personaTitolareRapp,TaifTAziendaDto taifTAziendaDto, TaifTPraticaDto praticaIscritta, String tipoFirma, String filePath) throws DocumentException, IOException {

        String domandaTitle = "CONFERMA DEI REQUISITI PER IL MANTENIMENTO DELL'ISCRIZIONE" +  "\n" + "ALL'ALBO TRANSFRONTALIERO DELLE IMPRESE FORESTALI " + "\n" + " SEZ. REGIONE AUTONOMA VALLE D'AOSTA";
        String sottoscritto= "Il sottoscritto  ";
        String codiceFiscale= "codice fiscale ";
        String qualita= "in qualita di ";
        String qualitaTitolare = "Titolare/Legale rappresentante";
        String impresa= "dell'impresa denominata ";
        String inscritta ="iscritta all'Albo transfrontaliero delle imprese forestali sez. Regione Autonoma Valle d'Aosta N. "; // ______ del __/__/____, nella sezione:"
        String inscrittaDel="del";
        String inscrittaSezione="nella sezione:";
        String sezioneA= "Sezione unica – £	Sezione unica – Imprese forestali con sede legale in Valle d'Aosta;";
        String variazioni = "Le variazioni intervenute nella struttura aziendale.";
        String comunica= "COMUNICA";
        String core3= "A tal fine trasmette la seguente documentazione:";
        String allegato1= "ALLEGATO 1 – Dichiarazione sostitutiva sui requisiti d'iscrizione, come definiti nell'ambito delle disposizioni sopra richiamate;";
        String allegato2= "ALLEGATO 2 – Scheda aggiornata del profilo aziendale, contenente i dati riguardanti l'attività, la tipologia e la consistenza delle strutture ed attrezzature aziendali ed ogni altro dato utile ai fini del mantenimento dell'iscrizione;";
        String allegato3= "ALLEGATO 3 – Scheda aggiornata dei requisiti professionali del titolare e degli addetti;";
        String core6 = "In caso di firma autografa allegare fotocopia chiara e leggibile di un documento di identità in corso di validità del firmatario, in caso di firma digitale non allegare il documento di identità.";
        String core5="Il sottoscritto si impegna, comunque, a comunicare tempestivamente qualsiasi ulteriore variazione, modifica o perdita dei requisiti comprese le variazioni di indirizzo, residenza, domicilio, cellulare e indirizzo PEC.";
        String core7= "Si allega informativa resa ai sensi degli articoli 13-14 del GDPR 2016/679 (General  Data Protection Regulation), debitamente sottoscritta.";
        String forSpace="   ";
        String twoSpace="  ";
        String tenSpace="          ";
        Paragraph p;
        Chunk leader = new Chunk(new DottedLineSeparator());

        Font zapfdingbats = new Font(Font.ZAPFDINGBATS, 7);
        Chunk bullet = new Chunk(String.valueOf((char) 108), zapfdingbats);
        float indentation = 17;
       


        Paragraph pAllegato1 = new Paragraph("",docFonts.normalFont);
        Paragraph pAllegato2 = new Paragraph("",docFonts.normalFont);
        Paragraph pAllegato3 = new Paragraph("",docFonts.normalFont);
        pAllegato1.add(bullet);
        pAllegato2.add(bullet);
        pAllegato3.add(bullet);

       
        Paragraph preface = new Paragraph();
        preface.add(new Chunk(domandaTitle, docFonts.catFont));
        preface.setAlignment(Element.ALIGN_CENTER);
        pdfUtils.addEmptyLine(preface, 1);

        DottedLineSeparator separator = new DottedLineSeparator();
       // Chunk c = new Chunk(separator);
        Paragraph testo = new Paragraph(sottoscritto, docFonts.normalFont);
       // testo.add(c);
        testo.add(new Chunk(personaTitolareRapp.getNome() + forSpace + personaTitolareRapp.getCognome(), docFonts.normalBold));
        testo.setAlignment(Element.ALIGN_LEFT);

       Paragraph testocf = new Paragraph(codiceFiscale, docFonts.normalBold);
       //testocf.add(c);
       testocf.add(new Chunk(twoSpace.concat(personaTitolareRapp.getCodiceFiscale()), docFonts.normalBold));
       testocf.setAlignment(Element.ALIGN_LEFT);

     
       BaseFont base = BaseFont.createFont( filePath, BaseFont.IDENTITY_H, false);
       Font fontck = new Font(base, 12f, Font.NORMAL);
       char checked='\u00FE';
       char unchecked='\u00A8';
       Paragraph testoq = new Paragraph(qualita, docFonts.normalFont);
       testoq.add(new Chunk(forSpace.concat(String.valueOf(checked)),fontck));
       testoq.add(new Chunk(forSpace.concat(qualitaTitolare), docFonts.normalBold));
       testoq.setAlignment(Element.ALIGN_LEFT);

        Paragraph testoi = new Paragraph(impresa, docFonts.normalFont);
        testoi.add(new Chunk(twoSpace.concat(taifTAziendaDto.getRagioneSociale()), docFonts.normalFont));
        testoi.setAlignment(Element.ALIGN_LEFT);

        
        Paragraph inscritta1 = new Paragraph();
        inscritta1.add(new Chunk(inscritta.concat(forSpace), docFonts.normalFont));
        if(praticaIscritta.getNumeroAlbo()!=null) {
        	inscritta1.add(new Chunk(praticaIscritta.getNumeroAlbo(), docFonts.normalFont));
        }else {
        	inscritta1.add(new Chunk(" " , docFonts.normalFont));
        }
        inscritta1.add(new Chunk(tenSpace.concat(inscrittaDel).concat(twoSpace), docFonts.normalFont));
        if(praticaIscritta.getDataIscrizioneAlbo()!=null) {
        	inscritta1.add(new Chunk(praticaIscritta.getDataIscrizioneAlbo().toString(), docFonts.normalFont));
        }else {
        	inscritta1.add(new Chunk(" ", docFonts.normalFont));
        }
        inscritta1.add(new Chunk(inscrittaSezione, docFonts.normalFont));
        inscritta1.setAlignment(Element.ALIGN_JUSTIFIED);
        
        
        Paragraph comunicap = new Paragraph();
        comunicap.setAlignment(Element.ALIGN_CENTER);
        comunicap.add(new Chunk(comunica,docFonts.normalBold));
        pdfUtils.addEmptyLine(comunicap, 1);

     
        Paragraph richiesta3 = new Paragraph();
        if(praticaIscritta.getFlgSezione()!=null) {
				richiesta3.add(new Chunk(forSpace.concat(String.valueOf(checked)), fontck));
				richiesta3.add(new Chunk(sezioneA, docFonts.normalFont));
         }
        richiesta3.setIndentationLeft(20);
        pdfUtils.addEmptyLine(richiesta3,1);
        
      
        
        Paragraph richiesta30 = new Paragraph();
        richiesta30.add(new Chunk(variazioni,docFonts.normalFont));
        richiesta30.setAlignment(Element.ALIGN_JUSTIFIED);
       // pdfUtils.addEmptyLine(richiesta30,1);
        
        
        Paragraph richiesta31 = new Paragraph();
        richiesta31.add(new Chunk(core3,docFonts.normalFont));
        richiesta31.setAlignment(Element.ALIGN_JUSTIFIED);
        pdfUtils.addEmptyLine(richiesta31,1);
        
        
        pAllegato1.add(new Chunk(forSpace.concat(allegato1), docFonts.normalFont));
        pAllegato1.setAlignment(Element.ALIGN_JUSTIFIED);
        pAllegato1.setIndentationLeft(indentation);
        pAllegato1.setFirstLineIndent(-indentation);
        pAllegato2.add(new Chunk(forSpace.concat(allegato2), docFonts.normalFont));
        pAllegato2.setAlignment(Element.ALIGN_JUSTIFIED);
        pAllegato2.setIndentationLeft(indentation);
        pAllegato2.setFirstLineIndent(-indentation);
        pAllegato3.add(new Chunk(forSpace.concat(allegato3), docFonts.normalFont));
        pAllegato3.setAlignment(Element.ALIGN_JUSTIFIED);
        pAllegato3.setIndentationLeft(indentation);
        pAllegato3.setFirstLineIndent(-indentation);
        pdfUtils.addEmptyLine(pAllegato3,1);


        Paragraph richiesta6 = new Paragraph();
        richiesta6.add(new Chunk(core5,docFonts.normalFont));
        richiesta6.setAlignment(Element.ALIGN_JUSTIFIED);
        pdfUtils.addEmptyLine(richiesta6,1);
       
        Paragraph richiesta61 = new Paragraph();
        richiesta61.add(new Chunk(core6,docFonts.normalFont));
        richiesta61.setAlignment(Element.ALIGN_JUSTIFIED);
        pdfUtils.addEmptyLine(richiesta61,1);
     
      
        Paragraph richiesta7 = new Paragraph();
        richiesta7.add(new Paragraph(core7, docFonts.normalFont));
        pdfUtils.addEmptyLine(richiesta7,2);

       
        document.add(preface);
        document.add(testo);
        document.add(testocf);
        document.add(testoq);
        document.add(testoi);
        document.add(inscritta1);
    
        document.add(richiesta3);
    
        document.add(comunicap);
        document.add(richiesta30);
        document.add(richiesta31);
      
        document.add(pAllegato1);
        document.add(pAllegato2);
        document.add(pAllegato3);
        document.add(richiesta6);
        document.add(richiesta61);
        document.add(richiesta7);
        document.add(pdfUtils.makeFirmaDataTable(leader,  tipoFirma, it.csi.taif.taifweb.business.dao.util.Constants.iLang));
        // Start a new pagetesto
        document.newPage();
    }


   

}
