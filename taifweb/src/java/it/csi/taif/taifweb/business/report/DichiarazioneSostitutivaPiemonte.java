/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
//TAIF-29: itextpdf DEPRECATA sostituita con openpdf (lowagie)

//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.DottedLineSeparator;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDto;

import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.service.integration.svista.Comune;
import it.csi.taif.taifweb.util.service.integration.svista.Provincia;

public class DichiarazioneSostitutivaPiemonte {
	
	
    FontsForDocuments docFonts= new FontsForDocuments();
    PdfUtils pdfUtils= new PdfUtils();

    public ByteArrayOutputStream createPdf(TaifTAziendaDto taifTAziendaDto,TaifTPraticaDto praticaIscritta,TaifTPersonaDto personaTitolareRapp,
    		Comune comuneNascita,  Provincia provinciaNascita, Comune comuneResidenza, Provincia provinciaResidenza,String tipoFirma) throws IOException, DocumentException {

	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    	
        Document document = new Document();
        PdfWriter writer= PdfWriter.getInstance(document, byteArrayOutputStream);
        writer.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO);
        document.setPageSize(PageSize.A4);
        document.setMargins(36, 36, 50, 30);
        document.open();

        addTitlePage(document, taifTAziendaDto, personaTitolareRapp);
        addBodyPage(document, taifTAziendaDto, personaTitolareRapp,  comuneNascita,   provinciaNascita,  comuneResidenza,  provinciaResidenza, tipoFirma);
       

        document.close();
        byteArrayOutputStream.close();
    	return byteArrayOutputStream;

    }
    
 
    private  void addTitlePage(Document document, TaifTAziendaDto taifTAziendaDto,TaifTPersonaDto personaTitolareRapp) throws DocumentException {

        String sostitutivaTitle = "Dichiarazione sostitutiva sui requisiti d'iscrizione previsti dall'art. 6 del Regolamento 8/R/2020 e  s.m.i. (disciplina dell'albo delle imprese forestali del Piemonte)";
        String sostitutivaSottoTitle= "DICHIARAZIONE SOSTITUTIVA DI CERTIFICAZIONE\r\n (D.P.R. 28/12/2000 n. 445, art. 46)";
      
        Paragraph preface = new Paragraph();
        preface.add(new Chunk(sostitutivaTitle, docFonts.bigItalic));
        preface.setAlignment(Element.ALIGN_CENTER);
        pdfUtils.addEmptyLine(preface, 1);
        
        Paragraph prefaceCenter = new Paragraph();
        prefaceCenter.add(new Chunk(sostitutivaSottoTitle, docFonts.bigBoldItalic));
        prefaceCenter.setAlignment(Element.ALIGN_CENTER);
        
        pdfUtils.addEmptyLine(prefaceCenter, 1);

        document.add(preface);
        document.add(prefaceCenter);

    }


    private  void addBodyPage(Document document, TaifTAziendaDto taifTAziendaDto,TaifTPersonaDto personaTitolareRapp,
    		Comune comuneNascita,  Provincia provinciaNascita, Comune comuneResidenza, Provincia provinciaResidenza, String tipoFirma) throws DocumentException {


        String sottoscritto = "Il/La sottoscritto";
        String nato="nato a ";
        String provincia ="provincia";
        String dataNascita ="il";
        String residente="residente  a";
        String numero="no.";
        String via="via/piazza/loc. ";
        String codiceFiscale = "codice fiscale";
        String qualita = "in qualità di titolare/rappresentante legale ";
        String impresa = "dell'impresa denominata ";
     
        String consapevole= "consapevole delle sanzioni penali richiamate dall'art. 76 D.P.R. 28.12.2000 n. 445, in caso di dichiarazioni mendaci e di formazione o uso di atti falsi e della decadenza dei benefici prevista dall'art. 45, sotto la propria personale responsabilità ";
        String dichiara = "DICHIARA";
        String dichiara1 = "che l'impresa esegue lavori o fornisce servizi nel settore forestale e ambientale, nonché attività nel settore della prima trasformazione e commercializzazione dei prodotti legnosi quali tronchi, ramaglie e cimali, svolte congiuntamente ad almeno una delle attività di gestione forestale come definite all' articolo 7, comma 1 del d.lgs. 34/2018 ;" ;
        String dichiara2 = "che l'impresa è iscritta nel registro di cui all' articolo 8 della legge 29 dicembre 1993, n. 580 (Riordinamento delle camere di commercio, industria, artigianato e agricoltura) per l'esercizio di attività di gestione forestale in quanto esegue lavori o fornisce servizi, in via prevalente o secondaria, riconducibili o equivalenti alla categoria ATECO 'Silvicoltura ed utilizzo di aree forestali (codice ATECO 02)';";
        String dichiara3 = "che l'impresa non è in stato di fallimento, di liquidazione coatta, di concordato preventivo, né di essere sottoposta ad alcun procedimento per la dichiarazione di una di tali situazioni; ";
        String dichiara4 = "di non aver riportato, nel corso dei tre anni precedenti alla richiesta di iscrizione, condanna penale definitiva a carico del personale di rappresentanza o di amministrazione, compresi i direttori tecnici, per violazioni delle norme in materia ambientale, paesaggistica, forestale, del lavoro e di sicurezza dei cantieri;";
        String dichiara5 = "di non essersi resi colpevoli di negligenza o malafede nella realizzazione di opere o servizi nell'anno precedente alla richiesta; ";
        String dichiara6 = "di non aver riportato, nell'anno precedente alla richiesta, alcuna delle sanzioni amministrative previste dalla normativa forestale vigente per importi superiori a 10.000,00 euro; ";
        String dichiara7 = "il titolare o, in subordine, almeno un addetto assunto a tempo indeterminato e a tempo pieno, è in possesso delle competenze professionali riferite all'unità formativa denominata 'Utilizzo in sicurezza della motosega nelle operazioni di abbattimento ed allestimento - (UF3)'.";
        String dichiara8 = "di essere in possesso dei requisiti di regolarità contributiva (DURC); ";

        String forSpace = "  ";
        String tenSpace = "          ";
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
        Paragraph testoCont8 = new Paragraph();

        Paragraph testos= new Paragraph(sottoscritto.concat(forSpace), docFonts.normalFont);
        testos.add(new Chunk( personaTitolareRapp.getNome() + forSpace + personaTitolareRapp.getCognome(), docFonts.normalBold));
        testos.setAlignment(Element.ALIGN_LEFT);

        Paragraph teston= new Paragraph(nato.concat(forSpace), docFonts.normalFont);
        teston.add(new Chunk(comuneNascita.getNome(), docFonts.normalBold));
        teston.add(new Chunk(tenSpace.concat(provincia).concat(forSpace), docFonts.normalFont));
        teston.add(new Chunk(provinciaNascita.getNome(), docFonts.normalBold));
        teston.add(new Chunk(tenSpace.concat(dataNascita).concat(forSpace), docFonts.normalFont));
        teston.add(new Chunk(dataStr, docFonts.normalBold));
        teston.setAlignment(Element.ALIGN_LEFT);
      

        Paragraph testor= new Paragraph(residente.concat(forSpace), docFonts.normalFont);
        testor.add(new Chunk(comuneResidenza.getNome(), docFonts.normalBold));
        testor.add(new Chunk(tenSpace.concat(provincia).concat(forSpace), docFonts.normalFont));
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
        
        i++;
        testoCont8.add(new Phrase(i + ".", docFonts.normalFont));
        testoCont8.add(new Chunk(forSpace.concat(dichiara8), docFonts.normalFont));
        testoCont8.setAlignment(Element.ALIGN_JUSTIFIED);
        testoCont8.setIndentationLeft(indentation);
        testoCont8.setFirstLineIndent(-indentation);
        testoCont8.setSpacingAfter(30f);

        PdfPTable table = pdfUtils.makeFirmaDataTable(leader, tipoFirma, it.csi.taif.taifweb.business.dao.util.Constants.iLang);

      

      
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
        document.add(testoCont8);
        document.add(table);
     

        // Start a new pagetesto
        document.newPage();

    }


	
 

}
