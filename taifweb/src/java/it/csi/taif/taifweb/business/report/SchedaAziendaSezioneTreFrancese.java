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

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaDettByFilterAttivitaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCommercializzazioneByAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDFormaGiuridicaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDTipoAttivitaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.exception.DbManagerException;

public class SchedaAziendaSezioneTreFrancese {

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

    void addSezioneThreeBodyPage(Document document, TaifTAziendaDto taifTAziendaDto,
	    List<TaifTCommercializzazioneByAziendaDto> commLegname, String tracciatoData) throws DocumentException,
	    IOException, DbManagerException, TaifDTipoAttivitaDaoException, TaifDFormaGiuridicaDaoException {

	String sezione3Fr = "FICHE 3: ACTIVITES EXERCEES  ";
	String attivitaSvolteFr = "Activites realisées au cours de la dernière année ";

	String attivitaFr = "Activité       ";
	String volumeFr = "Volume       ";
	String percentuale = "Pourcentage       ";
	String client1 = "Client 1 ";
	String client2 = "Client 2 ";
	String client3 = "Client 3 ";

	String commercializzaLegname = "Commercialisation du bois – Assortiments traités";
	String indique = "% du chiffre d’affaires";
	String provenance = "Provenance";
	String essences = "Essences";
	String assortiment = "Assortiment";
	String vendu = "Vendu ";
	String unitaMisura = "UdM ";
	String destination = "Destination";
	String notes = "Notes";

	FontsForDocuments docFonts = new FontsForDocuments();
	PdfUtils pdfUtils = new PdfUtils();

	String forSpace = "   ";
	String twoSpace = " \n";
	String tenSpace = "                    ";
	String twoSpace2 = "  ";
	String newLine = "\n";

	AziendaVisibleFilter aziendaVisibleFilter = new AziendaVisibleFilter();
	aziendaVisibleFilter.setFlagItaFr(tracciatoData);
	aziendaVisibleFilter.setIdAzienda(taifTAziendaDto.getIdAzienda());

	List<TaifTAttivitaSvoltaByIdAziendaDto> attivitaSvolteList = pdfDbManager
		.getAttivitaSvolte(taifTAziendaDto.getIdAzienda());

	Paragraph sezioneThree = new Paragraph();
	sezioneThree.add(new Chunk(sezione3Fr, docFonts.titoloFont14));
	sezioneThree.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(sezioneThree, 1);

	Paragraph testoAnnoInizioAttivita = new Paragraph();
	testoAnnoInizioAttivita.add(new Chunk(attivitaSvolteFr, docFonts.titoloFont12));
	testoAnnoInizioAttivita.setAlignment(Element.ALIGN_LEFT);
	// pdfUtils.addEmptyLine(testoAnnoInizioAttivita, 1);

	Paragraph attSvolta = new Paragraph();
	Paragraph cliente = new Paragraph();
	Paragraph testoComm = new Paragraph();
	Paragraph commerc = new Paragraph();
	for (TaifTAttivitaSvoltaByIdAziendaDto attivitaSvolta : attivitaSvolteList) {
	    List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> attivitaSvolteDettaglioList = pdfDbManager
		    .getAttivitaSvolteDettaglio(attivitaSvolta.getId());
	    attSvolta.add(new Chunk(newLine));
	    attSvolta.add(new Chunk(attivitaSvolta.getTipoAttivita(), docFonts.titoloFont10));
	    attSvolta.add(new Chunk(tenSpace));
	    for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaSvolteDett : attivitaSvolteDettaglioList) {
		if (attivitaSvolteDett.getProgressivo() == 1) {
		    attSvolta.add(new Chunk(twoSpace2.concat(volumeFr), docFonts.titoloFont10));
		    attSvolta.add(
			    new Chunk(twoSpace2.concat(attivitaSvolteDett.getVal1().toString()), docFonts.descrFont10));
		    attSvolta.add(new Chunk(
			    twoSpace2.concat(pdfDbManager.getUnitaMisura(attivitaSvolteDett.getUnitaMisura())),
			    docFonts.descrFont10));
		    attSvolta.add(new Chunk(tenSpace.concat(percentuale), docFonts.titoloFont10));
		    attSvolta.add(new Chunk(twoSpace2.concat(attivitaSvolta.getFatturato().toString()),
			    docFonts.descrFont10));
		    attSvolta.add(new Chunk(newLine));
		}
	    }
	}

	cliente.add(new Chunk(newLine));
	if (taifTAziendaDto.getClient1Fra() != null) {
	    cliente.add(new Chunk(twoSpace2.concat(client1), docFonts.titoloFont10));
	    cliente.add(new Chunk(twoSpace2.concat(taifTAziendaDto.getClient1Fra()), docFonts.descrFont10));
	    cliente.add(new Chunk(newLine));
	}
	if (taifTAziendaDto.getClient2Fra() != null) {
	    cliente.add(new Chunk(twoSpace2.concat(client2), docFonts.titoloFont10));
	    cliente.add(new Chunk(twoSpace2.concat(taifTAziendaDto.getClient2Fra()), docFonts.descrFont10));
	    cliente.add(new Chunk(newLine));
	}
	if (taifTAziendaDto.getClient3Fra() != null) {
	    cliente.add(new Chunk(twoSpace2.concat(client3), docFonts.titoloFont10));
	    cliente.add(new Chunk(twoSpace2.concat(taifTAziendaDto.getClient3Fra()), docFonts.descrFont10));
	    cliente.add(new Chunk(newLine));
	}
	cliente.add(new Chunk(tenSpace));

	if (!commLegname.isEmpty()) {

	    testoComm.add(new Chunk(attivitaSvolteFr, docFonts.titoloFont12));
	    testoComm.setAlignment(Element.ALIGN_LEFT);
	    commerc.add(new Chunk(newLine));
	    commerc.add(new Chunk(commercializzaLegname, docFonts.titoloFont12));
	    commerc.add(new Chunk(newLine));
	    commerc.add(new Chunk(indique, docFonts.titoloFont10));
	    commerc.add(new Chunk(twoSpace2.concat(taifTAziendaDto.getPercCommercioFra().toString()),
		    docFonts.descrFont10));
	    commerc.add(new Chunk(tenSpace));
	}
	for (TaifTCommercializzazioneByAziendaDto comm : commLegname) {
	    commerc.add(new Chunk(newLine));
	    commerc.add(new Chunk(twoSpace2.concat(essences), docFonts.titoloFont10));
	    commerc.add(new Chunk(
		    twoSpace2.concat(pdfDbManager.getSpecieCommercializzata(comm.getIdSpecie(), tracciatoData)),
		    docFonts.descrFont10));
	    commerc.add(new Chunk(tenSpace));

	    commerc.add(new Chunk(twoSpace2.concat(provenance), docFonts.titoloFont10));
	    commerc.add(new Chunk(twoSpace2.concat(pdfDbManager.getProvDestinazione(comm.getIdProvenienza())),
		    docFonts.descrFont10));
	    commerc.add(new Chunk(tenSpace));

	    commerc.add(new Chunk(twoSpace2.concat(assortiment), docFonts.titoloFont10));
	    commerc.add(new Chunk(twoSpace2.concat(pdfDbManager.getAssortimento(comm.getIdAssortimento())),
		    docFonts.descrFont10));

	    commerc.add(new Chunk(newLine));

	    commerc.add(new Chunk(twoSpace2.concat(vendu), docFonts.titoloFont10));
	    commerc.add(new Chunk(twoSpace2.concat(comm.getVendutoMedio().toString()), docFonts.descrFont10));
	    commerc.add(new Chunk(tenSpace));

	    commerc.add(new Chunk(twoSpace2.concat(unitaMisura), docFonts.titoloFont10));
	    commerc.add(new Chunk(twoSpace2.concat(pdfDbManager.getUnitaMisura(comm.getIdUnMis()).toString()),
		    docFonts.descrFont10));
	    commerc.add(new Chunk(tenSpace));

	    commerc.add(new Chunk(twoSpace2.concat(destination), docFonts.titoloFont10));
	    commerc.add(new Chunk(pdfDbManager.getProvDestinazione(comm.getIdDestinazione()), docFonts.descrFont10));
	    commerc.add(new Chunk(tenSpace));

	    commerc.add(new Chunk(twoSpace2.concat(notes), docFonts.titoloFont10));
	    commerc.add(new Chunk(twoSpace2.concat(comm.getNote()), docFonts.descrFont10));
	    commerc.add(new Chunk(tenSpace));

	}

	document.add(sezioneThree);
	document.add(testoAnnoInizioAttivita);
	document.add(attSvolta);
	document.add(cliente);
	document.add(commerc);
	document.newPage();

    }

}
