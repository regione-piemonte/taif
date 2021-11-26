/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.DottedLineSeparator;

//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTSoggettoGestoreDto;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.service.integration.svista.Comune;
import it.csi.taif.taifweb.util.service.integration.svista.Provincia;

public class DichiarazioneSostitutivaAosta {

	

	FontsForDocuments docFonts= new FontsForDocuments();
	PdfUtils pdfUtils= new PdfUtils();
    

    public ByteArrayOutputStream createPdf(TaifTAziendaDto taifTAziendaDto,TaifTPraticaDto praticaIscritta,TaifTPersonaDto personaTitolareRapp,
	    Comune comuneNascita,  Provincia provinciaNascita, Comune comuneResidenza, Provincia provinciaResidenza,String firma
    		) throws IOException, DocumentException {

	
    	  
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	
        Document document = new Document();
        PdfWriter writer= PdfWriter.getInstance(document, byteArrayOutputStream);
        writer.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO);
        document.setPageSize(PageSize.A4);
        document.setMargins(36, 36, 60, 30);
        document.open();

        addTitlePage(document, taifTAziendaDto, personaTitolareRapp);
        addBodyPage(document, taifTAziendaDto, personaTitolareRapp,  comuneNascita,   provinciaNascita,  comuneResidenza,  provinciaResidenza, firma);
        
        document.close();
        byteArrayOutputStream.close();
    	return byteArrayOutputStream;

    }
    
  

    private  void addTitlePage(Document document, TaifTAziendaDto taifTAziendaDto,TaifTPersonaDto personaTitolareRapp) throws DocumentException {

        String sostitutivaTitle = "DICHIARAZIONE SOSTITUTIVA SUI REQUISITI D'ISCRIZIONE ALL'ALBO DELLE IMPRESE FORESTALI SEZ. REGIONE AUTONOMA VALLE D'AOSTA" ;
        String sostitutivaSottoTitle = "DICHIARAZIONE SOSTITUTIVA DI CERTIFICAZIONE\r\n (D.P.R.28/12/2000 n.445, art.46)";
        
        Paragraph preface = new Paragraph();
        preface.add(new Chunk(sostitutivaTitle, docFonts.normalUnderline));
        preface.setAlignment(Element.ALIGN_JUSTIFIED);
        pdfUtils.addEmptyLine(preface, 1);
        
        Paragraph prefaceCenter = new Paragraph();
        prefaceCenter.add(new Chunk(sostitutivaSottoTitle, docFonts.bigBoldItalic));
        prefaceCenter.setAlignment(Element.ALIGN_CENTER);
        pdfUtils.addEmptyLine(prefaceCenter, 1);

        document.add(preface);
        document.add(prefaceCenter);

    }

    private  void addBodyPage(Document document, TaifTAziendaDto taifTAziendaDto,TaifTPersonaDto personaTitolareRapp,
	    Comune comuneNascita,  Provincia provinciaNascita, Comune comuneResidenza, Provincia provinciaResidenza, String firma) throws DocumentException {


        String sottoscritto = "Il sottoscritto";
        String nato="nato a ";
        String provincia ="provincia";
        String dataNascita ="il";
        String residente="residente  in";
        String numero="no.";
        String via="via/piazza/loc. ";
        String codiceFiscale = "codice fiscale";
        String qualita = "in qualita di ";
        String impresa = "dell'impresa denominata ";
        String qualitaTitolare = "Titolare/Legale rappresentante";
        String consapevole= "consapevole delle sanzioni penali richiamate dall'art. 76 D.P.R. 28.12.2000 n. 445, in caso di dichiarazioni mendaci e di formazione o uso di atti falsi e della decadenza dei benefici prevista dall'art. 45, sotto la propria personale responsabilità ";
        String dichiara = "DICHIARA";
        String dichiara1 = "che l'impresa è iscritta al Registro delle imprese presso la competente Camera di commercio, industria, artigianato e agricoltura con attività prevalente o secondaria di Silvicoltura e altre attività forestali (codice ATECO 02.10.00) o Utilizzo di aree forestali\" (codice ATECO 02.20.00) o ad analoghi registri dello Stato di appartenenza per le imprese aventi sede legale all'estero per attività equivalenti; ";
        String dichiara2 ="tche l'impresa non è in stato di fallimento, di liquidazione coatta, di concordato preventivo, né di essere sottoposta ad alcun procedimento per la dichiarazione di una di tali situazioni; ";
        String dichiara3 = "di non aver commesso, nel corso dei tre anni precedenti la richiesta di iscrizione, gravi violazioni delle norme in materia ambientale, forestale, del lavoro e di sicurezza dei cantieri, che abbiano comportato condanna penale definitiva;";
        String dichiara4 = "di non essersi resi colpevoli di negligenza o malafede nella realizzazione di opere o servizi nell'anno precedente alla richiesta; ";
        String dichiara5 = "di non aver riportato sanzioni interdittive di cui all'articolo 9, comma 2, lettera c), del decreto legislativo 8 giugno 2001, n. 231 (Disciplina della responsabilità amministrativa delle persone giuridiche, delle società e delle associazioni anche prive di personalità giuridica, a norma dell'articolo 11 della legge 29 settembre 2000, n. 300) o altra sanzione che comporta il divieto di contrarre con la pubblica amministrazione; ";
        String dichiara6 = "di non aver riportato, nell'anno precedente alla richiesta, alcuna delle sanzioni amministrative previste dall'articolo 52 della l.r. n. 4/1999 “Norme in materia di foreste e di assetto idrogeologico” per importi superiori a 10.000,00 euro; ";
        String dichiara7 = "di avere nel proprio organico almeno un addetto, legato all'impresa in modo stabile ed esclusivo, o il titolare stesso, che abbia acquisito specifiche competenze tecnico-professionali in campo forestale tramite percorsi di formazione professionale riconosciute dal Provvedimento Dirigenziale 177/2014 e s.m.i., ed in particolare:";
        String notaBene = "N.B. In caso di firma autografa allegare fotocopia chiara e leggibile di un documento di identità in corso di validità del firmatario, in caso di firma digitale non allegare il documento di identità.";

        String forSpace = "  ";
        String tenSpace = "          ";
        Paragraph p;
        Chunk leader = new Chunk(new DottedLineSeparator());

        float indentation = 17;

        
        SimpleDateFormat sdf = new SimpleDateFormat(); 
        sdf = new SimpleDateFormat(Constants.FIRMA_FORMAT_DATA);
        String dataStr = sdf.format(personaTitolareRapp.getDataNascita());

        Paragraph dichiaraParag = new Paragraph();
        Paragraph testoCont1 = new Paragraph();
        Paragraph testoCont2 = new Paragraph();
        Paragraph testoCont3 = new Paragraph();
        Paragraph testoCont4 = new Paragraph();
        Paragraph testoCont5 = new Paragraph();
        Paragraph testoCont6 = new Paragraph();
        Paragraph testoCont7 = new Paragraph();
        Paragraph postScript = new Paragraph();



        DottedLineSeparator separator = new DottedLineSeparator();
        Chunk c = new Chunk(separator);
        Paragraph testos= new Paragraph(sottoscritto.concat(forSpace), docFonts.normalFont);
        testos.add(new Chunk( personaTitolareRapp.getNome() + forSpace + personaTitolareRapp.getCognome(), docFonts.normalBold));
        testos.setAlignment(Element.ALIGN_LEFT);

        Paragraph teston= new Paragraph(nato.concat(forSpace), docFonts.normalFont);
        teston.add(new Chunk(comuneNascita.getNome(), docFonts.normalBold));
        teston.add(new Chunk(tenSpace.concat(provincia).concat(forSpace), docFonts.normalBold));
        teston.add(new Chunk(provinciaNascita.getNome(), docFonts.normalBold));
        teston.add(new Chunk(tenSpace.concat(dataNascita).concat(forSpace), docFonts.normalFont));
        teston.add(new Chunk(dataStr, docFonts.normalBold));
        teston.setAlignment(Element.ALIGN_LEFT);
      

        Paragraph testor= new Paragraph(residente.concat(forSpace), docFonts.normalFont);
        testor.add(new Chunk(comuneResidenza.getNome(), docFonts.normalBold));
        testor.add(new Chunk(tenSpace.concat(provincia).concat(forSpace), docFonts.normalBold));
        testor.add(new Chunk(provinciaResidenza.getNome(), docFonts.normalBold));
        testor.setAlignment(Element.ALIGN_LEFT);
        
        

        Paragraph testov= new Paragraph(via.concat(forSpace), docFonts.normalFont);
        testov.add(new Chunk(personaTitolareRapp.getIndirizzoRes(), docFonts.normalBold));
        testov.add(new Chunk(tenSpace.concat(numero), docFonts.normalFont));
        testov.add(new Chunk(personaTitolareRapp.getCivicoRes(), docFonts.normalBold));
        testov.setAlignment(Element.ALIGN_LEFT);

       
        Paragraph testocf= new Paragraph(codiceFiscale.concat(forSpace), docFonts.normalFont);
        testocf.add(new Chunk(personaTitolareRapp.getCodiceFiscale(), docFonts.normalBold));
        testocf.setAlignment(Element.ALIGN_LEFT);

        Paragraph testoq=new Paragraph(qualita.concat(forSpace), docFonts.normalFont);
        testoq.add(new Chunk(qualitaTitolare, docFonts.normalBold));
        testoq.setAlignment(Element.ALIGN_LEFT);

        Paragraph testoi= new Paragraph(impresa.concat(forSpace), docFonts.normalFont);
        testoi.add(new Chunk(taifTAziendaDto.getRagioneSociale(), docFonts.normalBold));;
        testoi.setAlignment(Element.ALIGN_LEFT);
        pdfUtils.addEmptyLine(testoi, 1);

        Paragraph testo= new Paragraph(consapevole, docFonts.normalFont);
        testo.setAlignment(Element.ALIGN_JUSTIFIED);
        pdfUtils.addEmptyLine(testo, 1);

        dichiaraParag.add(new Chunk(dichiara, docFonts.normalBold));
        dichiaraParag.setAlignment(Element.ALIGN_CENTER);
        pdfUtils.addEmptyLine(dichiaraParag, 1);


        int i=1;
        testoCont1.add(new Phrase(i + ".", docFonts.normalFont));
        testoCont1.add(new Chunk(forSpace.concat(dichiara1), docFonts.normalFont));
        testoCont1.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont1.setIndentationLeft(indentation);
        testoCont1.setFirstLineIndent(-indentation);
        i++;
        testoCont2.add(new Phrase(i + ".", docFonts.normalFont));
        testoCont2.add(new Chunk(forSpace.concat(dichiara2), docFonts.normalFont));
        testoCont2.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont2.setIndentationLeft(indentation);
        testoCont2.setFirstLineIndent(-indentation);

        i++;
        testoCont3.add(new Phrase(i + ".", docFonts.normalFont));
        testoCont3.add(new Chunk(forSpace.concat(dichiara3), docFonts.normalFont));
        testoCont3.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont3.setIndentationLeft(indentation);
        testoCont3.setFirstLineIndent(-indentation);

        i++;
        testoCont4.add(new Phrase(i + ".", docFonts.normalFont));
        testoCont4.add(new Chunk(forSpace.concat(dichiara4), docFonts.normalFont));
        testoCont4.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont4.setIndentationLeft(indentation);
        testoCont4.setFirstLineIndent(-indentation);

        i++;
        testoCont5.add(new Phrase(i + ".", docFonts.normalFont));
        testoCont5.add(new Chunk(forSpace.concat(dichiara5), docFonts.normalFont));
        testoCont5.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont5.setIndentationLeft(indentation);
        testoCont5.setFirstLineIndent(-indentation);

        i++;
        testoCont6.add(new Phrase(i + ".", docFonts.normalFont));
        testoCont6.add(new Chunk(forSpace.concat(dichiara6), docFonts.normalFont));
        testoCont6.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont6.setIndentationLeft(indentation);
        testoCont6.setFirstLineIndent(-indentation);

        i++;
        testoCont7.add(new Phrase(i + ".", docFonts.normalFont));
        testoCont7.add(new Chunk(forSpace.concat(dichiara7), docFonts.normalFont));
        testoCont7.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont7.setIndentationLeft(indentation);
        testoCont7.setFirstLineIndent(-indentation);
        testoCont7.setSpacingAfter(30f);

        //

        PdfPTable table1 = new PdfPTable(2);
        table1.setWidthPercentage(100);
        table1.setWidths(new int[]{4, 1});
        PdfPCell cell = new PdfPCell();
        cell.setBorderColor(Color.WHITE);
        cell.setColspan(2);
        table1.addCell(cell);

        cell = new PdfPCell(new Paragraph("Categoria", docFonts.normalBold));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
    
     
        table1.addCell(cell);
      
        Paragraph secondCell = new Paragraph("Requisito\n" + "minimo\n"  , docFonts.normalBold);
        cell = new PdfPCell(secondCell);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        table1.addCell(cell);

       //
        
        PdfPTable table2 = new PdfPTable(3);
        table2.setWidthPercentage(100);
        table2.setWidths(new int[]{1,3, 1});
        PdfPCell cell21 = new PdfPCell();
        cell21.setBorderColor(Color.WHITE);
        cell21.setColspan(3);
        table2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell21);

        cell21 = new PdfPCell(new Phrase("I", docFonts.normalFont));
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setVerticalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell21);
        
        cell21 = new PdfPCell(new Phrase("Imprese e ditte di utilizzazione forestale", docFonts.normalFont));
        cell21.setLeading(9f, 0f);
        cell21.setVerticalAlignment(Element.ALIGN_JUSTIFIED);
        table2.addCell(cell21);
        
        cell21 = new PdfPCell(new Phrase("UF3", docFonts.normalFont));
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setVerticalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell21);
        
        cell21 = new PdfPCell(new Phrase("II", docFonts.normalFont));
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setVerticalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell21);
        
        cell21 = new PdfPCell(new Phrase("Imprese agricole", docFonts.normalFont));
        cell21.setLeading(9f, 0f);
        cell21.setVerticalAlignment(Element.ALIGN_JUSTIFIED);
        table2.addCell(cell21);
        
        cell21 = new PdfPCell(new Phrase("UF2", docFonts.normalFont));
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setVerticalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell21);
        
        cell21 = new PdfPCell(new Phrase("III", docFonts.normalFont));
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setVerticalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell21);
        
        cell21 = new PdfPCell(new Phrase("Imprese e ditte di commercializzazione e vendita del legno e dei prodotti di prima trasformazione ", docFonts.normalFont));
        cell21.setLeading(9f, 0f);
        cell21.setVerticalAlignment(Element.ALIGN_JUSTIFIED);
        table2.addCell(cell21);
        
        cell21 = new PdfPCell(new Phrase("UF2", docFonts.normalFont));
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setVerticalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell21);
        
        
        cell21 = new PdfPCell(new Phrase("IV", docFonts.normalFont));
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setVerticalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell21);
        
        cell21 = new PdfPCell(new Phrase("Imprese e ditte di prima trasformazione del legno", docFonts.normalFont));
        cell21.setLeading(9f, 0f);
        cell21.setVerticalAlignment(Element.ALIGN_JUSTIFIED);
        table2.addCell(cell21);
        
        cell21 = new PdfPCell(new Phrase("UF2", docFonts.normalFont));
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setVerticalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell21);
        
        
        cell21 = new PdfPCell(new Phrase("V", docFonts.normalFont));
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setVerticalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell21);
        
        cell21 = new PdfPCell(new Phrase("Imprese o ditte, anche individuali, che realizzano attività di vivaistica forestale o che non rientrano nelle categorie precedenti ma che svolgono comunque attività in ambito forestale", docFonts.normalFont));
        cell21.setLeading(9f, 0f);
        cell21.setVerticalAlignment(Element.ALIGN_JUSTIFIED);
        table2.addCell(cell21);
        
        cell21 = new PdfPCell(new Phrase("UF2", docFonts.normalFont));
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setVerticalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell21);
       
        table2.setSpacingAfter(50f);

     
        PdfPTable table = pdfUtils.makeFirmaDataTable(leader, firma, it.csi.taif.taifweb.business.dao.util.Constants.iLang);
        
        table.setSpacingAfter(20f);

        postScript.add(new Paragraph(notaBene, docFonts.small));

      
        document.add(testos);
        document.add(teston);
        document.add(testor);
        document.add(testov);
        document.add(testocf);
        document.add(testoq);
        document.add(testoi);
        document.add(testo);
        document.add(dichiaraParag);
        document.add(testoCont1);
        document.add(testoCont2);
        document.add(testoCont3);
        document.add(testoCont4);
        document.add(testoCont5);
        document.add(testoCont6);
        document.add(testoCont7);
        document.newPage();
        document.add(table1);
        document.add(table2);
        document.add(table);
        document.add(postScript);
      

    }


	

   

   

	
}
