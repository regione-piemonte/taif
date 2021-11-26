/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.util.Constants;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.exception.DbManagerException;

public class SchedaAziendaSezioneSei {

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

		String sezione6 = "Sezione 6  ";
		String descrizioneAdetti = "Quadro addetti dell'azienda ";
		String persone = "Persone  per Azienda        ";
		String codiceFiscalePersona = "Codice Fiscale  ";
		String cognome = "Cognome  ";
		String nome = "Nome  ";
		String altriStudi = "Altri studi  ";
		String ruolo = "Ruolo ";
		String mansione = "Mansione ";
		String contratto = "Contratto ";
		String inquadramento = "Inquadramento ";
		String tempoDeterminato = "Tempo Determinato ";
		String giorni = "Giorni ";
		String formazioneForestale = "Formazione forestale";

		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf = new SimpleDateFormat(it.csi.taif.taifweb.util.Constants.FIRMA_FORMAT_DATA);

		FontsForDocuments docFonts = new FontsForDocuments();
		PdfUtils pdfUtils = new PdfUtils();

		String forSpace = "   ";
		String twoSpace = " \n";
		String tenSpace = "          ";
		String twoSpace2 = "  ";
		String newLine = "\n";

		List<TaifTPersonaByIdAziendaDto> alPersonePerAzienda = pdfDbManager
				.getPersonePerAzienda(taifTAziendaDto.getIdAzienda());

		Paragraph sezioneSei = new Paragraph();
		sezioneSei.add(new Chunk(sezione6, docFonts.titoloFont14));
		sezioneSei.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(sezioneSei, 1);

		Paragraph testoAnnoInizioAttivita = new Paragraph();
		testoAnnoInizioAttivita.add(new Chunk(descrizioneAdetti, docFonts.titoloFont12));
		testoAnnoInizioAttivita.setAlignment(Element.ALIGN_LEFT);

		Paragraph personaTag = new Paragraph();
		// personaTag.add(new Chunk(persone, docFonts.descrFont10));
		personaTag.add(new Chunk(newLine));
		for (TaifTPersonaByIdAziendaDto persona : alPersonePerAzienda) {
			personaTag.add(new Chunk(newLine));
			personaTag.add(new Chunk(codiceFiscalePersona, docFonts.titoloFont10));
			personaTag.add(new Chunk(tenSpace.concat(persona.getCodiceFiscale()), docFonts.descrFont10));
			personaTag.add(new Chunk(twoSpace.concat(cognome), docFonts.titoloFont10));
			personaTag.add(new Chunk(tenSpace.concat(persona.getCognome()), docFonts.descrFont10));
			personaTag.add(new Chunk(twoSpace.concat(nome), docFonts.titoloFont10));
			personaTag.add(new Chunk(tenSpace.concat(persona.getNome()), docFonts.descrFont10));

			personaTag.add(new Chunk(twoSpace.concat(ruolo), docFonts.titoloFont10));
			personaTag.add(new Chunk(tenSpace.concat(pdfDbManager.getRuolo(persona.getIdRuoloPersona())),
					docFonts.descrFont10));

			personaTag.add(new Chunk(twoSpace.concat(mansione), docFonts.titoloFont10));
			personaTag.add(new Chunk(tenSpace.concat(pdfDbManager.getTipoMansione(persona.getIdTipoMansione())),
					docFonts.descrFont10));

			personaTag.add(new Chunk(twoSpace.concat(contratto), docFonts.titoloFont10));
			personaTag.add(new Chunk(tenSpace.concat(pdfDbManager.getTipoContratto(persona.getIdTipoContratto())),
					docFonts.descrFont10));

			personaTag.add(new Chunk(twoSpace.concat(inquadramento), docFonts.titoloFont10));
			personaTag
					.add(new Chunk(tenSpace.concat(pdfDbManager.getTipoInquadramento(persona.getIdTipoInquadramento())),
							docFonts.descrFont10));

			if (persona.getFlagTenpoDeterminato() != null) {
				personaTag.add(new Chunk(twoSpace.concat(tempoDeterminato), docFonts.titoloFont10));
				personaTag.add(new Chunk(
						tenSpace.concat(pdfDbManager.getFlagTempoDett(persona.getFlagTenpoDeterminato().intValue())),
						docFonts.descrFont10));
			}

			if (persona.getGiorniTempoDeterminato() != null) {
				personaTag.add(new Chunk(twoSpace.concat(giorni), docFonts.titoloFont10));
				personaTag.add(new Chunk(tenSpace.concat(persona.getGiorniTempoDeterminato().toString()),
						docFonts.descrFont10));
			}
			String formazioneF = pdfDbManager.findCorsiPerPersona(persona.getIdPersona());
			personaTag.add(new Chunk(twoSpace.concat(formazioneForestale), docFonts.titoloFont10));
			// if (formazioneF.length() > 1) {
			if (StringUtils.isNotEmpty(formazioneF)) {
				personaTag.add(new Chunk(twoSpace.concat(formazioneF), docFonts.descrFont10));
			} else {
				personaTag.add(new Chunk(tenSpace.concat(Constants.NO), docFonts.descrFont10));
			}
			personaTag.add(new Chunk(newLine));

		}

		document.add(sezioneSei);
		document.add(testoAnnoInizioAttivita);
		document.add(personaTag);
		document.newPage();

		return document;
	}

}
