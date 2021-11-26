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
import java.util.List;


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

public class DomandaIscrizioneLiguria {

	
	FontsForDocuments docFonts = new FontsForDocuments();
	PdfUtils pdfUtils = new PdfUtils();

    public ByteArrayOutputStream createPdf(TaifTAziendaDto taifTAziendaDto, TaifTPraticaDto praticaIscritta,
	    TaifTPersonaDto personaTitolareRapp,List<String> flagList, TaifTSoggettoGestoreDto soggettoGestore,String comuneSoggetoGestore, String tipoFirma, String filePath)
	    throws DocumentException, IOException {

	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

	Document document = new Document();
	PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
	writer.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO);

	document.setPageSize(PageSize.A4);
	document.setMargins(36, 36, 50, 30);
	document.open();

	addMarcaBolloBox(document, taifTAziendaDto);
	addRegioneBox(document, soggettoGestore, comuneSoggetoGestore);
	addTitleBodyPage(document, personaTitolareRapp, taifTAziendaDto,flagList ,tipoFirma, filePath);

	document.close();
	byteArrayOutputStream.close();

	return byteArrayOutputStream;

    }

    private void addRegioneBox(Document document, TaifTSoggettoGestoreDto soggettoGestore, String comuneSoggetoGestore) throws DocumentException {

	PdfPTable table = new PdfPTable(1);
	table.setWidthPercentage(100);
	String denominazione = soggettoGestore.getDenominazione();
	String[] divide = denominazione.split("-");
	String regioneAdress = divide[0].trim() + "\n" + divide[1].trim() + "\n" + soggettoGestore.getIndirizzo() + "  "
		+ soggettoGestore.getCivico() + "\n" + soggettoGestore.getCap() + "  "
		+ comuneSoggetoGestore;
	String regioneMail = "\n";
	String mmailAdress = soggettoGestore.getPec();
	Phrase paragInsert = new Phrase(regioneAdress, docFonts.normalFont);
	PdfPCell cell = new PdfPCell(paragInsert);
	cell.setPadding(10);
	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	cell.setBorder(PdfPCell.NO_BORDER);
	table.addCell(cell);
	table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
	table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
	table.getDefaultCell().setPadding(10);
	table.addCell(new Phrase(regioneMail +  mmailAdress, docFonts.normalBold));
	document.add(table);

    }

    private void addMarcaBolloBox(Document document, TaifTAziendaDto taifTAziendaDto) throws DocumentException {

	PdfPTable table = new PdfPTable(2);
	table.setWidthPercentage(100);
	table.setWidths(new int[] { 1, 4 });
	PdfPCell cell = new PdfPCell();
	cell.setBorderColor(Color.WHITE);
	cell.setColspan(2);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase("MARCA DA BOLLO " + "\n" + "       Euro 16,00", docFonts.smallBold));
	cell.setIndent(10);
	cell.setLeading(9f, 0f);
	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	table.addCell(cell);

	String identificativo = "Nr. Identificativo della marca da bollo:";
	String numeroBollo = taifTAziendaDto.getNMarcaBollo();
	String comment = "Consapevole delle sanzioni penali previste dall'art. 76 del D.P.R. 445/2000, si dichiara che la "
		+ "marca da bollo è stata annullata per la presentazione della presente domanda e non sarà "
		+ "utilizzata per qualsiasi altro adempimento che ne richiede l'apposizione (art. 3 D.M. 10/11/11).";
	Paragraph secondCell = new Paragraph(identificativo + "\n" + numeroBollo + "\n" + comment, docFonts.smallBold);
	secondCell.setAlignment(Element.ALIGN_LEFT);
	cell = new PdfPCell(secondCell);
	cell.setPadding(5);
	cell.setLeading(9f, 0f);
	table.addCell(cell);

	table.setSpacingAfter(10f);

	document.add(table);

    }

    private void addTitleBodyPage(Document document, TaifTPersonaDto personaTitolareRapp,
	    TaifTAziendaDto taifTAziendaDto, List<String> flagList, String firma, String filePath) throws DocumentException, IOException {

	String domandaTitle = "DOMANDA D'ISCRIZIONE" + "\n" + "ALL'ALBO DELLE IMPRESE FORESTALI DELLA LIGURIA";
	String sottoscritto = "Il sottoscritto  ";
	String codiceFiscale = "codice fiscale ";
	String qualita = "in qualita di ";
	String qualitaTitolare = "Titolare/Legale rappresentante";
	String impresa = "dell'impresa denominata ";
	String core1 = "che l'impresa che rappresenta sia iscritta all'Albo sperimentale delle imprese forestali della Liguria, attivato con D.D. n 1041 del 04/03/2019 e ss.mm.ii. nell'ambito delle attività del progetto ALCOTRA denominato INFORMAPLUS.";
	String core2 = "Su tale base, ed in attesa di una eventuale disciplina regionale di maggior dettaglio, chiede l'iscrizione nella sezione:";
	String sezioneA = "Sezione A – Imprese forestali con sede legale in Liguria;";
	String sezioneB = "Sezione B – Imprese forestali che non hanno sede legale in Liguria e imprese forestali iscritte presso analoghi albi di altre regioni.";
	String core3 = "A tal fine trasmette la seguente documentazione:";
	String core4 = "SCHEDA AZIENDALE completa, comprensiva dei seguenti allegati";
	String allegato1 = "ALLEGATO 1 – Dichiarazione sostitutiva sui requisiti d'iscrizione, come definiti nell'ambito delle disposizioni sopra richiamate;";
	String allegato2 = "ALLEGATO 2 – Scheda profilo azienda, contente i dati riguardanti l'attività, la tipologia e la consistenza delle strutture ed attrezzature aziendali ed ogni altro dato utile ai fini dell'iscrizione;";
	String allegato3 = "ALLEGATO 3 – Scheda dei requisiti professionali del titolare e degli addetti;";
	String core5 = "Il sottoscritto si impegna, inoltre, a comunicare tempestivamente qualsiasi variazione, modifica o perdita dei requisiti  comprese le variazioni di indirizzo, residenza, domicilio, cellulare e indirizzo PEC.";
	String core6 = "In caso di firma autografa allegare fotocopia chiara e leggibile di un documento di identità in corso di validità del firmatario, in caso di firma digitale non allegare il documento di identità.";
	String core7 = "ll/La sottoscritto/a dichiara di avere preso visione dell'informativa sulla privacy ai sensi del GDPR 2016/679.";
	String forSpace = "   ";
	String twoSpace = "  ";

	Paragraph p;
	Chunk leader = new Chunk(new DottedLineSeparator());

	Font zapfdingbats = new Font(Font.ZAPFDINGBATS, 7);
	Chunk bullet = new Chunk(String.valueOf((char) 108), zapfdingbats);
	float indentation = 17;

	Paragraph pAllegato1 = new Paragraph("", docFonts.normalFont);
	Paragraph pAllegato2 = new Paragraph("", docFonts.normalFont);
	Paragraph pAllegato3 = new Paragraph("", docFonts.normalFont);
	pAllegato1.add(bullet);
	pAllegato2.add(bullet);
	pAllegato3.add(bullet);

	Paragraph preface = new Paragraph();
	preface.add(new Chunk(domandaTitle, docFonts.catFont));
	preface.setAlignment(Element.ALIGN_CENTER);
	pdfUtils.addEmptyLine(preface, 1);

	DottedLineSeparator separator = new DottedLineSeparator();
	// Chunk c = new Chunk(separator);
	Paragraph testo = new Paragraph(sottoscritto, docFonts.normalBold);
	// testo.add(c);
	testo.add(new Chunk(personaTitolareRapp.getNome() + forSpace + personaTitolareRapp.getCognome(),
		docFonts.normalBold));
	testo.setAlignment(Element.ALIGN_LEFT);

	Paragraph testocf = new Paragraph(codiceFiscale, docFonts.normalFont);
	// testocf.add(c);
	testocf.add(new Chunk(twoSpace.concat(personaTitolareRapp.getCodiceFiscale()), docFonts.normalBold));
	testocf.setAlignment(Element.ALIGN_LEFT);

	BaseFont base = BaseFont.createFont(filePath, BaseFont.IDENTITY_H, false);
	Font fontck = new Font(base, 12f, Font.NORMAL);
	char checked = '\u00FE';
	char unchecked = '\u00A8';
	Paragraph testoq = new Paragraph(qualita, docFonts.normalFont);
	testoq.add(new Chunk(forSpace.concat(String.valueOf(checked)), fontck));
	testoq.add(new Chunk(forSpace.concat(qualitaTitolare), docFonts.normalBold));
	// testoq.add(c);
	testoq.setAlignment(Element.ALIGN_LEFT);

	Paragraph testoi = new Paragraph(impresa, docFonts.normalFont);
	testoi.add(new Chunk(twoSpace.concat(taifTAziendaDto.getRagioneSociale()), docFonts.normalFont));
	testoi.setAlignment(Element.ALIGN_LEFT);

	Paragraph chiede = new Paragraph();
	chiede.setAlignment(Element.ALIGN_CENTER);
	chiede.add(new Chunk("CHIEDE", docFonts.normalBold));
	pdfUtils.addEmptyLine(chiede, 1);

	Paragraph richiesta1 = new Paragraph();
	richiesta1.add(new Chunk(core1, docFonts.normalFont));
	richiesta1.setAlignment(Element.ALIGN_JUSTIFIED);

	Paragraph richiesta2 = new Paragraph();
	richiesta2.add(new Chunk(core2, docFonts.normalFont));
	richiesta2.setAlignment(Element.ALIGN_JUSTIFIED);
	
	Paragraph richiesta3 = new Paragraph();
	if(flagList.contains("A")) {
	    richiesta3.add(new Chunk(forSpace.concat(String.valueOf(checked)),fontck));  
	}else {
	    richiesta3.add(new Chunk(forSpace.concat(String.valueOf(unchecked)),fontck)); 
	}
	richiesta3.add(new Chunk(forSpace.concat(sezioneA), docFonts.normalFont));
	richiesta3.setIndentationLeft(20);

	Paragraph richiesta3B = new Paragraph();
	if(flagList.contains("B")) {
	    richiesta3B.add(new Chunk(forSpace.concat(String.valueOf(checked)),fontck));  
	}else {
	    richiesta3B.add(new Chunk(forSpace.concat(String.valueOf(unchecked)),fontck)); 
	}
	richiesta3B.add(new Chunk(forSpace.concat(sezioneB), docFonts.normalFont));
	richiesta3B.setIndentationLeft(20);

	Paragraph richiesta31 = new Paragraph();
	richiesta31.add(new Chunk(core3, docFonts.normalFont));
	richiesta31.setAlignment(Element.ALIGN_JUSTIFIED);
	pdfUtils.addEmptyLine(richiesta31, 1);

	Paragraph richiesta32 = new Paragraph();
	richiesta32.add(new Chunk(core4, docFonts.normalFont));
	richiesta32.setAlignment(Element.ALIGN_CENTER);
	pdfUtils.addEmptyLine(richiesta32, 1);

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
	pdfUtils.addEmptyLine(pAllegato3, 1);

	Paragraph richiesta6 = new Paragraph();
	richiesta6.add(new Chunk(core5, docFonts.normalFont));
	richiesta6.setAlignment(Element.ALIGN_JUSTIFIED);

	Paragraph richiesta61 = new Paragraph();
	richiesta61.add(new Chunk(core6, docFonts.normalFont));
	richiesta61.setAlignment(Element.ALIGN_JUSTIFIED);
	pdfUtils.addEmptyLine(richiesta61, 1);

	Paragraph richiesta7 = new Paragraph();
	richiesta7.add(new Paragraph(core7, docFonts.verySmall));
	pdfUtils.addEmptyLine(richiesta7, 2);

	document.add(preface);
	document.add(testo);
	document.add(testocf);
	document.add(testoq);
	document.add(testoi);
	document.add(chiede);
	document.add(richiesta1);
	document.add(richiesta2);
	document.add(richiesta3);
	document.add(richiesta3B);
	document.add(richiesta31);
	document.add(richiesta32);
	document.add(pAllegato1);
	document.add(pAllegato2);
	document.add(pAllegato3);
	document.add(richiesta6);
	document.add(richiesta61);
	document.add(richiesta7);
	document.add(pdfUtils.makeFirmaDataTable(leader, firma, it.csi.taif.taifweb.business.dao.util.Constants.iLang));

	// Start a new pagetesto
	document.newPage();
    }

}
