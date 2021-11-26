/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;

//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Paragraph;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaFrTipoContrFindByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaFrTipoMansFindByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.exception.DbManagerException;

public class SchedaAziendaSezioneSeiFrancese {

    @Autowired
    private ServiceMgr serviceMgr;

    @Autowired
    private PdfDbManager pdfDbManager;

    public ServiceMgr getServiceMgr() {
	return serviceMgr;
    }

    public void setServiceMgr(ServiceMgr serviceMgr) {
	this.serviceMgr = serviceMgr;
    }

    public PdfDbManager getPdfDbManager() {
	return pdfDbManager;
    }

    public void setPdfDbManager(PdfDbManager pdfDbManager) {
	this.pdfDbManager = pdfDbManager;
    }

    public Document addSezioneSixBodyPage(Document document, TaifTAziendaDto taifTAziendaDto, String tracciatoData)
	    throws DocumentException, IOException, DbManagerException {

	String sezione6 = "FICHE 6– Fiche du propriétaire et des employés  ";
	String persone = "Nbre de salariés        ";
	String tempsPlein = "Equivalent temps plein  ";
	String tipologieContrat = "Typologie de contrat ";
	String numEmploy = "Nombre d'employés  ";
	String tache = "Tâche ";
	String nombreEmploy = "Nombre d'employés ";

	FontsForDocuments docFonts = new FontsForDocuments();
	PdfUtils pdfUtils = new PdfUtils();

	String twoSpace = " \n";
	String tenSpace = "          ";
	String twoSpace2 = "  ";
	String newLine = "\n";

	List<TaifRAziendaFrTipoMansFindByIdAziendaDto> aziendaMansione = pdfDbManager
		.getMansioneFrancese(taifTAziendaDto.getIdAzienda());
	List<TaifRAziendaFrTipoContrFindByIdAziendaDto> aziendaContrattoFrancese = pdfDbManager
		.getTipologieContrattoFrancese(taifTAziendaDto.getIdAzienda());

	Paragraph sezioneSei = new Paragraph();
	sezioneSei.add(new Chunk(sezione6, docFonts.titoloFont14));
	sezioneSei.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(sezioneSei, 1);

	Paragraph numberSalaries = new Paragraph();
	numberSalaries.add(new Chunk(twoSpace.concat(persone), docFonts.titoloFont10));
	if (taifTAziendaDto.getNbreSalariesFra() != null) {
	    numberSalaries.add(
		    new Chunk(tenSpace.concat(taifTAziendaDto.getNbreSalariesFra().toString()), docFonts.descrFont10));
	}
	numberSalaries.add(new Chunk(twoSpace.concat(tempsPlein), docFonts.titoloFont10));
	if (taifTAziendaDto.getNbreSalariesFra() != null) {
	    numberSalaries.add(
		    new Chunk(tenSpace.concat(taifTAziendaDto.getTempsPleinFra().toString()), docFonts.descrFont10));
	}
	numberSalaries.add(newLine);
	numberSalaries.add(newLine);
	numberSalaries.setAlignment(Element.ALIGN_LEFT);

	Paragraph testoTypologieContratto = new Paragraph();
	for (TaifRAziendaFrTipoContrFindByIdAziendaDto contratto : aziendaContrattoFrancese) {
	    testoTypologieContratto.add(new Chunk(tipologieContrat, docFonts.titoloFont10));
	    testoTypologieContratto.add(new Chunk(
		    twoSpace2.concat(pdfDbManager.getContrattoById(contratto.getIdTipoContr())), docFonts.descrFont10));
	    testoTypologieContratto.add(new Chunk(tenSpace.concat(numEmploy), docFonts.titoloFont10));
	    testoTypologieContratto
		    .add(new Chunk(twoSpace2.concat(contratto.getNrAdetti().toString()), docFonts.descrFont10));
	    testoTypologieContratto.add(newLine);

	}
	testoTypologieContratto.setAlignment(Element.ALIGN_LEFT);

	Paragraph personaTag = new Paragraph();
	personaTag.add(new Chunk(newLine));
	for (TaifRAziendaFrTipoMansFindByIdAziendaDto mansione : aziendaMansione) {
	    personaTag.add(new Chunk(newLine));
	    personaTag.add(new Chunk(tache, docFonts.titoloFont10));
	    personaTag.add(new Chunk(tenSpace.concat(pdfDbManager.getMansioneById(mansione.getIdTipoMansione())),
		    docFonts.descrFont10));
	    personaTag.add(new Chunk(tenSpace.concat(nombreEmploy), docFonts.titoloFont10));
	    personaTag.add(new Chunk(tenSpace.concat(mansione.getNrAdetti().toString()), docFonts.descrFont10));
	    personaTag.add(new Chunk(newLine));
	}

	document.add(sezioneSei);
	document.add(numberSalaries);
	document.add(testoTypologieContratto);
	document.add(personaTag);
	document.newPage();

	return document;
    }

}
