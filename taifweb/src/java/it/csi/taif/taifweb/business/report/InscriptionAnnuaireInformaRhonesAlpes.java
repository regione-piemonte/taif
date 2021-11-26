/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.DottedLineSeparator;

//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTSoggettoGestoreDto;
import it.csi.taif.taifweb.business.dao.util.Constants;


public class InscriptionAnnuaireInformaRhonesAlpes {
	
	
    FontsForDocuments docFonts= new FontsForDocuments();
    PdfUtils pdfUtils= new PdfUtils();

    public ByteArrayOutputStream createPdf(TaifTAziendaDto taifTAziendaDto,TaifTPraticaDto praticaIscritta,TaifTPersonaDto personaTitolareRapp,
	    TaifTSoggettoGestoreDto soggettoGestore,String tipoFirma, String image) throws IOException, DocumentException {

	
	
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    	
        Document document = new Document();
        PdfWriter writer= PdfWriter.getInstance(document, byteArrayOutputStream);
        writer.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO);
        document.setPageSize(PageSize.A4);
        document.setMargins(36, 36, 50, 30);
        document.open();

        addRegioneBox(document, image); 
        document.add(new Paragraph());
        document.add(new Paragraph());
        addTitlePage(document);
        addBodyPage(document, taifTAziendaDto, personaTitolareRapp, tipoFirma);
       

        document.close();
        byteArrayOutputStream.close();
    	return byteArrayOutputStream;

    }
    
 
    private  void addRegioneBox(Document document, String image) throws DocumentException, IOException {
            PdfPTable table = new PdfPTable(1);
          
            table.getDefaultCell().setBorder(0);
            table.setWidthPercentage(100);
            table.addCell(createImageCell(image));
            table.addCell(new Phrase(" "));
            table.addCell(new Phrase(" "));
            table.addCell(new Phrase(" "));
            document.add(table);
          
           
        }

    private  void addTitlePage(Document document) throws DocumentException {

        String sostitutivaTitle = "INSCRIPTION ANNUELLE A L’ANNUAIRE TRANSFRONTALIER ";
        String sostitutivaTitleTwo = "EXPLOITANTS FORESTIERS, ENTREPRENEURS DE TRAVAUX FORESTIERS ET SCIEURS ";
        String sostitutivaSottoTitle= "PROJET INFORMA+";
      
      
        Paragraph preface = new Paragraph();
        preface.add(new Chunk(sostitutivaTitle, docFonts.normalBold12));
        preface.setAlignment(Element.ALIGN_CENTER);
        
        Paragraph prefaceTwo = new Paragraph();
        prefaceTwo.add(new Chunk(sostitutivaTitleTwo, docFonts.normalBold12));
        prefaceTwo.setAlignment(Element.ALIGN_CENTER);
        pdfUtils.addEmptyLine(prefaceTwo, 1);
        
        Paragraph prefaceCenter = new Paragraph();
        prefaceCenter.add(new Chunk(sostitutivaSottoTitle, docFonts.normalBold));
        prefaceCenter.setAlignment(Element.ALIGN_CENTER);
        pdfUtils.addEmptyLine(prefaceCenter, 1);

        document.add(new Paragraph());
        document.add(new Paragraph());
        document.add(new Paragraph());
        document.add(preface);
        document.add(prefaceTwo);
        document.add(prefaceCenter);

    }


    private  void addBodyPage(Document document, TaifTAziendaDto taifTAziendaDto,TaifTPersonaDto personaTitolareRapp, String tipoFirma) throws DocumentException {


        String sottoscritto = "Je soussigné(e) ";
        String qualita = "Agissant en qualité de représentant(e) légal(e) de l’entreprise ";
        String codiceFiscale = "N° SIRET :  ";
     
        String consapevole= "J’atteste sur l’honneur : ";
        String domanda = "demande l’inscription de mon entreprise à l’annuaire INFORMA+ ";
        String dichiara1 = "de l’exactitude des renseignements fournis dans « l’annuaire Informa+ »";
        String dichiara2 = "que mon entreprise est immatriculée au Registre du Commerce et des Sociétés avec pour activité principale ou secondaire un code de Sylviculture et autres activités forestières, exploitation forestière ou scierie ;";
        String dichiara3 = "être titulaire d’une attestation de levé de présomption de salariat (ou d’un document attestant du salariat du dirigeant) ;";
        String dichiara4 = "que mon entreprise est à jour de ses cotisations fiscales et sociales ; ";
        String dichiara5 = "que mon entreprise n’est pas en situation de faillite, de liquidation forcée, de concordat préventif et ne pas faire l’objet d’une procédure de cette nature ;  ";
        String dichiara6 = "que mon entreprise n’a pas commis, au cours des trois années précédant la demande d’inscription, des infractions graves aux règles en matière d’environnement, de forêts, de travail et de sécurité sur les chantiers, ayant entraîné une condamnation pénale définitive. ";
      
        String forSpace = "  ";
        String tenSpace = "          ";
        Paragraph p;
        Chunk leader = new Chunk(new DottedLineSeparator());

        Font zapfdingbats = new Font(Font.ZAPFDINGBATS, 7);
        Chunk bullet = new Chunk(String.valueOf((char) 108), zapfdingbats);
        
        float indentation = 17;
    
        Paragraph dichiaraParag = new Paragraph();
        Paragraph testoCont1 = new Paragraph();
        Paragraph testoCont2 = new Paragraph();
        Paragraph testoCont3 = new Paragraph();
        Paragraph testoCont4 = new Paragraph();
        Paragraph testoCont5 = new Paragraph();
        Paragraph testoCont6 = new Paragraph();
   
        DottedLineSeparator separator = new DottedLineSeparator();
        Chunk c = new Chunk(separator);
        Paragraph testos= new Paragraph(sottoscritto.concat(forSpace), docFonts.normalFont);
        testos.add(new Chunk( personaTitolareRapp.getNome() + forSpace + personaTitolareRapp.getCognome(), docFonts.normalBold));
        testos.setAlignment(Element.ALIGN_LEFT);
   
        Paragraph testoq=new Paragraph(qualita.concat(forSpace), docFonts.normalFont);
        testoq.add(new Chunk(taifTAziendaDto.getRagioneSociale(), docFonts.normalBold));;
        testoq.setAlignment(Element.ALIGN_LEFT);
       
        
        Paragraph testocf= new Paragraph(codiceFiscale.concat(forSpace), docFonts.normalFont);
        testocf.add(new Chunk(taifTAziendaDto.getNSiret(), docFonts.normalBold));
        testocf.setAlignment(Element.ALIGN_LEFT);
        pdfUtils.addEmptyLine(testocf, 1);
        

        dichiaraParag.add(new Chunk(domanda, docFonts.normalBold));
        dichiaraParag.setAlignment(Element.ALIGN_CENTER);
        pdfUtils.addEmptyLine(dichiaraParag, 1);

        Paragraph testo= new Paragraph(consapevole, docFonts.normalFont);
        testo.setAlignment(Element.ALIGN_JUSTIFIED);
        //pdfUtils.addEmptyLine(testo, 1);

     
        testoCont1.add(bullet);
        testoCont1.add(new Chunk(forSpace.concat(dichiara1), docFonts.normalFont));
        testoCont1.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont1.setIndentationLeft(indentation);
        testoCont1.setFirstLineIndent(-indentation);
        pdfUtils.addEmptyLine(testoCont1, 1);
   
        testoCont2.add(bullet);
        testoCont2.add(new Chunk(forSpace.concat(dichiara2), docFonts.normalFont));
        testoCont2.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont2.setIndentationLeft(indentation);
        testoCont2.setFirstLineIndent(-indentation);
        pdfUtils.addEmptyLine(testoCont2, 1);

        
        testoCont3.add(bullet);
        testoCont3.add(new Chunk(forSpace.concat(dichiara3), docFonts.normalFont));
        testoCont3.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont3.setIndentationLeft(indentation);
        testoCont3.setFirstLineIndent(-indentation);
        pdfUtils.addEmptyLine(testoCont3, 1);

       
        testoCont4.add(bullet);
        testoCont4.add(new Chunk(forSpace.concat(dichiara4), docFonts.normalFont));
        testoCont4.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont4.setIndentationLeft(indentation);
        testoCont4.setFirstLineIndent(-indentation);
        pdfUtils.addEmptyLine(testoCont4, 1);

      
        testoCont5.add(bullet);
        testoCont5.add(new Chunk(forSpace.concat(dichiara5), docFonts.normalFont));
        testoCont5.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont5.setIndentationLeft(indentation);
        testoCont5.setFirstLineIndent(-indentation);
        pdfUtils.addEmptyLine(testoCont5, 1);

     
        testoCont6.add(bullet);
        testoCont6.add(new Chunk(forSpace.concat(dichiara6), docFonts.normalFont));
        testoCont6.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont6.setIndentationLeft(indentation);
        testoCont6.setFirstLineIndent(-indentation);
        pdfUtils.addEmptyLine(testoCont6, 3);

        PdfPTable table = pdfUtils.makeFirmaDataTable(leader, tipoFirma, Constants.fLang);
       
        document.add(testos);
        document.add(testoq);
        document.add(testocf);
        document.add(dichiaraParag);
        document.add(testo);
        document.add(testoCont1);
        document.add(testoCont2);
        document.add(testoCont3);
        document.add(testoCont4);
        document.add(testoCont5);
        document.add(testoCont6);
        document.add(new Paragraph());
        document.add(new Paragraph());
        document.add(table);
     

        // Start a new pagetesto
        document.newPage();

    }

    public static PdfPCell createImageCell(String path) throws DocumentException, IOException {
        Image img = Image.getInstance(path);
        img.setBorder(Image.NO_BORDER);
        img.setAlignment(Element.ALIGN_CENTER);
        PdfPCell cell = new PdfPCell(img, true);
        cell.setBorder(0);
        return cell;
    }
	
 

}
