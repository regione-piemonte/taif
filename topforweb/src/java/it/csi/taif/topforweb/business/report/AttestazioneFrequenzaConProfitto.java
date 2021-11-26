/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.report;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.DottedLineSeparator;

//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAgenziaFormativaByUnitaFormativaPersonaDto;
import it.csi.taif.topforweb.business.manager.TopForMgr;
import it.csi.taif.topforweb.business.manager.db.DbMgr;
import it.csi.taif.topforweb.business.manager.service.ServiceMgr;
import it.csi.taif.topforweb.exception.ManagerException;
import it.csi.taif.topforweb.util.Constants;

public class AttestazioneFrequenzaConProfitto {

    FontsForDocuments docFonts = new FontsForDocuments();
    PdfUtils pdfUtils = new PdfUtils();
   
    @Autowired
    private TopForMgr topForMgr;
    
    @Autowired
    private DbMgr dbMgr;
  
    @Autowired
    private ServiceMgr serviceMgr;
    
   
    public ByteArrayOutputStream createPdf(List<TaifTAgenziaFormativaByUnitaFormativaPersonaDto> listAgenziaFormativa,String istatSedeCorso, String image)
        throws DocumentException, IOException, ManagerException {
    
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter writer= PdfWriter.getInstance(document, byteArrayOutputStream);
	writer.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO);

	document.setPageSize(PageSize.A4);
	document.setMargins(36, 36, 50, 30);
	document.open();

	addTitleAndBodyPage(document, listAgenziaFormativa,istatSedeCorso, image);

	document.close();
	byteArrayOutputStream.close();
    	return byteArrayOutputStream;
    	

    }
   

    private void addTitleAndBodyPage(Document document,
	    List<TaifTAgenziaFormativaByUnitaFormativaPersonaDto> listAgenziaFormativa, String istatSedeCorso,String image)
	    throws DocumentException, IOException, ManagerException {

	String tipoFrequenzaProfitto = "ATTESTATO DI FREQUENZA CON PROFITTO";
	String tipoFrequenza = "ATTESTATO DI FREQUENZA";
	String attivitaFormativa = "ad ATTIVITA' FORMATIVA realizzata con il contributo congiunto di Comunita' Europea, Stato Italiano e Regione ";
	String nelAmbito = ", nell'ambito del";
	String psr = " PSR ";
	String conferitoAl = "CONFERITO A ";
	String nato = "nato/a il ";
	String a = "a";
	String haFrequentato = "che ha frequentato con esito positivo il corso di formazione per Operatore Forestale:";
	String unFormativa = "UNITA' FORMATIVA";
	String diCui = "di cui alla D.D. n. 813 del 19/12/2007";
	String organizzato1 = "organizzato dall'Ente di Formazione ";
	String svolto = " e svolto a";
	String dal = "dal";
	String al = "al";
	String perTotale = "per un totale di";
	String ore = "ore";
	String assolvendo = "assolvendo anche a quanto disposto dall'art. 37 del d.lgs 81/2008 e cosi' come definito dall'Accordo Stato Regioni del 21 dicembre 2011 in riferimento alla formazione specifica ed all'addestramento.";

	Chunk leader = new Chunk(new DottedLineSeparator());
	String twoSpace = "  ";
	String fuorSpace = "  ";
	String tenSpaces = "           ";
	String twoSpaceNext = "  \n";

	Paragraph preface = new Paragraph();
	Paragraph capa = new Paragraph();
	Paragraph titolo = new Paragraph();
	Paragraph attFormativa = new Paragraph();
	Paragraph conferito = new Paragraph();
	Paragraph attestato = new Paragraph();
	Paragraph unitaFormativa = new Paragraph();
	Paragraph diCuiPar = new Paragraph();
	Paragraph enteFormazionePar = new Paragraph();
	Paragraph assolvento = new Paragraph();

	SimpleDateFormat sdf = new SimpleDateFormat();
	sdf = new SimpleDateFormat(Constants.FIRMA_FORMAT_DATA);
	
	
	 
	
	for (TaifTAgenziaFormativaByUnitaFormativaPersonaDto agenziaFormativa : listAgenziaFormativa) {
	    
	 
	    preface.add(new Chunk(agenziaFormativa.getRagioneSociale(), docFonts.titoloFont18Italic));
	    preface.setAlignment(Element.ALIGN_CENTER);
	    pdfUtils.addEmptyLine(preface, 1);

	    if (agenziaFormativa.getIndirizzo() != null && agenziaFormativa.getIndirizzo().length() > 1) {
		capa.add(new Chunk(agenziaFormativa.getIndirizzo(), docFonts.titoloFont18Italic));
	    }
	    if (agenziaFormativa.getCap() != null && agenziaFormativa.getCap().length() > 1) {
		capa.add(new Chunk(agenziaFormativa.getCap(), docFonts.titoloFont18Italic));
	    }
	     
	    capa.add(new Chunk(tenSpaces.concat(this.getComuneByIstat(agenziaFormativa.getIstatSede())), docFonts.titoloFont18Italic));
	    capa.setAlignment(Element.ALIGN_CENTER);
	    pdfUtils.addEmptyLine(capa, 2);

	    if (agenziaFormativa.getFlagEsito().equals("P")) {
		titolo.add(new Chunk(tipoFrequenzaProfitto, docFonts.catFont22));
	    } else if (agenziaFormativa.getFlagEsito().equals("F")) {
		titolo.add(new Chunk(tipoFrequenza, docFonts.catFont22));
	    }
	    titolo.setAlignment(Element.ALIGN_CENTER);
	    pdfUtils.addEmptyLine(titolo, 2);

	    attFormativa.add(new Chunk(
		    fuorSpace.concat(
			    attivitaFormativa.concat(twoSpace.concat(agenziaFormativa.getDenominazioneBreve()))),
		    docFonts.normalBig));
	    attFormativa.add(new Chunk(twoSpace.concat(nelAmbito), docFonts.normalBig));
	    attFormativa.add(new Chunk(twoSpace.concat(psr), docFonts.normalBold12));
	    attFormativa
		    .add(new Chunk(twoSpace.concat(agenziaFormativa.getDenominazioneBreve()), docFonts.normalBold12));
	    attFormativa.setAlignment(Element.ALIGN_CENTER);
	    pdfUtils.addEmptyLine(attFormativa, 2);

	    conferito.add(new Chunk(conferitoAl, docFonts.normalBig));
	    conferito.add(new Chunk(twoSpaceNext.concat(agenziaFormativa.getCognomePersona()), docFonts.normalBold12));
	    conferito.add(new Chunk(twoSpace.concat(agenziaFormativa.getNomePersona()), docFonts.normalBold12));
	    conferito.add(new Chunk(twoSpaceNext.concat(nato), docFonts.normalBig));
	    conferito
		    .add(new Chunk(twoSpace.concat(sdf.format(agenziaFormativa.getDataNascita())), docFonts.normalBig));
	    conferito.add(new Chunk(twoSpace.concat(a), docFonts.normalBig));
	    conferito.add(new Chunk(twoSpace.concat(this.getComuneByIstat(agenziaFormativa.getIstatComuneNascita())), docFonts.normalBig));
	   // Comune comuneResidenza = taifMgr.getComuneByIstat(personaTitolareRapp.getIstatComuneRes());
	    conferito.setAlignment(Element.ALIGN_CENTER);
	    pdfUtils.addEmptyLine(conferito, 2);

	    attestato.add(new Chunk(haFrequentato, docFonts.normalBig));
	    attestato.add(new Chunk(twoSpaceNext.concat(agenziaFormativa.getCorso()), docFonts.normalBold12));
	    attestato.setAlignment(Element.ALIGN_CENTER);
	    pdfUtils.addEmptyLine(attestato, 2);

	    unitaFormativa.add(new Chunk(unFormativa, docFonts.normalBig));
	    unitaFormativa
		    .add(new Chunk(twoSpace.concat(agenziaFormativa.getSigla().concat(" - ")), docFonts.normalBold12));
	    unitaFormativa.add(new Chunk(agenziaFormativa.getUnitaFormativa(), docFonts.normalBold12));
	    unitaFormativa.setAlignment(Element.ALIGN_CENTER);
	    // pdfUtils.addEmptyLine(unitaFormativa, 1);

	    diCuiPar.add(new Chunk(diCui, docFonts.smallItalic));
	    diCuiPar.add(new Chunk(agenziaFormativa.getSigla(), docFonts.smallItalic));
	    diCuiPar.setAlignment(Element.ALIGN_CENTER);
	    pdfUtils.addEmptyLine(diCuiPar, 1);

	    enteFormazionePar.add(new Chunk(organizzato1, docFonts.normalBig));
	    enteFormazionePar.add(new Chunk(agenziaFormativa.getRagioneSociale(), docFonts.normalBig));
	    enteFormazionePar.add(new Chunk(svolto, docFonts.normalBig));
	    enteFormazionePar.add(new Chunk(twoSpace.concat(this.getComuneByIstat(istatSedeCorso)), docFonts.normalBig));
	    enteFormazionePar.add(new Chunk(twoSpaceNext.concat(dal), docFonts.normalBig));
	    enteFormazionePar.add(
		    new Chunk(twoSpace.concat(sdf.format(agenziaFormativa.getDataInizioCorso())), docFonts.normalBig));
	    enteFormazionePar.add(new Chunk(twoSpace.concat(al), docFonts.normalBig));
	    enteFormazionePar.add(
		    new Chunk(twoSpace.concat(sdf.format(agenziaFormativa.getDataFineCorso())), docFonts.normalBig));
	    enteFormazionePar.add(new Chunk(twoSpace.concat(perTotale), docFonts.normalBig));
	    enteFormazionePar
		    .add(new Chunk(twoSpace.concat(agenziaFormativa.getNumeroOre().toString()), docFonts.normalBig));
	    enteFormazionePar.add(new Chunk(twoSpace.concat(ore), docFonts.normalBig));
	    enteFormazionePar.setAlignment(Element.ALIGN_CENTER);
	    pdfUtils.addEmptyLine(enteFormazionePar, 1);

	    assolvento.add(new Chunk(assolvendo, docFonts.normalBig));
	    assolvento.setAlignment(Element.ALIGN_CENTER);
	    pdfUtils.addEmptyLine(assolvento, 2);

	    
	    
	    PdfPTable table = makeFirmaDataTable(leader, agenziaFormativa);

	    document.add(preface);
	    document.add(capa);
	    document.add(titolo);
	    document.add(attFormativa);
	    document.add(conferito);
	    document.add(attestato);
	    document.add(unitaFormativa);
	    document.add(diCuiPar);
	    document.add(enteFormazionePar);
	    document.add(assolvento);
	    document.add(table);
	    document.add( Chunk.NEWLINE);
	    document.add( Chunk.NEWLINE);
	    document.add( Chunk.NEWLINE);
	    addRegioneBox(document, image);
	    //document.newPage();

	}

    }

    public PdfPTable makeFirmaDataTable(Chunk leader, TaifTAgenziaFormativaByUnitaFormativaPersonaDto agenziaFormativa)
	    throws DocumentException {

	String enteFormazione = "ENTE FORMAZIONE";
	String responsabileCorso = "Responsabile corso";
	String responsabileSettore = "Responsabile settore";

	Paragraph p;
	Paragraph p1;
	PdfPTable table = new PdfPTable(3);
	table.setWidthPercentage(100);
	table.setWidths(new int[] { 3, 3, 3 });

	p = new Paragraph(agenziaFormativa.getDenominazione(), docFonts.normalFont);
	p.add(new Chunk("\n"));
	p.add(new Chunk("\n"));
	p.add(new Chunk("\n"));
	p.add(responsabileSettore);
	p.add(new Chunk("\n"));
	if (agenziaFormativa.getReferente() != null) {
	    p.add(agenziaFormativa.getReferente());
	} else {
	    p.add(leader);
	}

	p1 = new Paragraph(enteFormazione, docFonts.normalFont);
	p1.add(new Chunk("\n"));
	p1.add(leader);
	p1.add(new Chunk("\n"));
	p1.add(new Chunk("\n"));
	p1.add(responsabileCorso);
	p1.add(new Chunk("\n"));
	p1.add(leader);

	table.addCell(getCell(p, PdfPCell.ALIGN_LEFT));
	table.addCell(getCell(new Paragraph(), PdfPCell.ALIGN_CENTER));
	table.addCell(getCell(p1, PdfPCell.ALIGN_LEFT));

	return table;
    }

    public PdfPCell getCell(Paragraph p, int verticalAlignment) {

	PdfPCell cell = new PdfPCell();
	cell.setBorder(Rectangle.NO_BORDER);
	cell.setVerticalAlignment(verticalAlignment);
	cell.setUseAscender(true);
	cell.setUseDescender(true);
	cell.addElement(p);
	return cell;
    }

    private void addRegioneBox(Document document, String image) throws DocumentException, IOException {
	PdfPTable table = new PdfPTable(1);

	table.getDefaultCell().setBorder(0);
	table.setWidthPercentage(100);
	table.addCell(createImageCell(image));
	table.addCell(new Phrase(" "));
	table.addCell(new Phrase(" "));
	table.addCell(new Phrase(" "));
	document.add(table);

    }

    public static PdfPCell createImageCell(String image) throws DocumentException, IOException {
	Image img = Image.getInstance(image);
	img.setBorder(Image.NO_BORDER);
	img.setAlignment(Element.ALIGN_CENTER);
	PdfPCell cell = new PdfPCell(img, true);
	cell.setBorder(0);
	return cell;
    }
    

    public TopForMgr getTopForMgr() {
        return topForMgr;
    }



    public void setTopForMgr(TopForMgr topForMgr) {
        this.topForMgr = topForMgr;
    }



    public DbMgr getDbMgr() {
        return dbMgr;
    }



    public void setDbMgr(DbMgr dbMgr) {
        this.dbMgr = dbMgr;
    }



    public ServiceMgr getServiceMgr() {
        return serviceMgr;
    }



    public void setServiceMgr(ServiceMgr serviceMgr) {
        this.serviceMgr = serviceMgr;
    }
    
    private String getComuneByIstat(String istatComune) throws ManagerException {
    	if(StringUtils.isNotEmpty(istatComune)) {
    		return this.topForMgr.getComuneByIstat(istatComune);
    	}
    	return "";
    }

}
