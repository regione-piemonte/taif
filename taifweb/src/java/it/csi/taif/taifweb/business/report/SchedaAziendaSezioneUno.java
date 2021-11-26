/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.displaytag.export.DefaultPdfExportView;
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

import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDAttivitaAtecoApeDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDFormaGiuridicaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTipoAttivitaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifDTitoloStudioDao;
import it.csi.taif.taifweb.business.dao.taifweb.dao.TaifTPersonaDao;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDAttivitaAtecoApeDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDAttivitaAtecoApePk;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDFormaGiuridicaPk;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoAttivitaPk;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTitoloStudioPk;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRPersonaAziendaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaPk;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTSedeAziendaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDAttivitaAtecoApeDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDFormaGiuridicaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDTipoAttivitaDaoException;
import it.csi.taif.taifweb.business.dao.util.Constants;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.db.DbMgr;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.util.service.integration.svista.Comune;
import it.csi.taif.taifweb.util.service.integration.svista.Provincia;

public class SchedaAziendaSezioneUno {
	
	@Autowired
	private TaifMgr taifMgr;
	
	/**
	 * @return the taifMgr
	 */
	public TaifMgr getTaifMgr() {
		return taifMgr;
	}

	/**
	 * @param taifMgr the taifMgr to set
	 */
	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}
 
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

	Document addSezioneOneBodyPage(Document document, TaifTAziendaDto taifTAziendaDto, String comuneSedeLegale,
			String provinciaSedeLegale, List<TaifTSedeAziendaByIdAziendaDto> sedeAzienda,
			List<TaifTPraticaByIdAziendaDto> pratichePerAzienda,
			List<TaifRPersonaAziendaByIdAziendaDto> listPersonePerIdAzienda, String tracciatoData)
			throws DocumentException, IOException, TaifDTipoAttivitaDaoException,
			TaifDFormaGiuridicaDaoException, ManagerException {

		String domandaTitle = " ALBO IMPRESE FORESTALI TRANSFRONTALIERO  ";
		String dettaglioSchedaAzienda = "DETTAGLIO SCHEDA AZIENDA ";
		String sezione1 = "SEZIONE 1 – Dati anagrafici  ";
		String codiceFiscale = "Codice fiscale ";
		String partivaIva = "Partita IVA";
		String denominazione = "Denominazione ";
		String iscrizioneCcia = "Iscrizione CCIA ";
		String sedeLegale = "Sede legale ";
		String sedeLegaleComune = "Comune ";
		String sedeLegaleProvincia = "Provincia ";
		String sedeLegaleIndirizzo = "Indirizzo ";
		String sedeLegaleCivico = "Civico ";
		String sedeLegaleCap = "CAP ";
		String pecAzienda = "PEC ";
		String eMailAzienda = "E-mail ";
		String telefonoAzienda = "Telefono ";
		String cellulareAzienda = "Cellulare ";
		String sitoWEB = "Sito WEB ";
		String attivitaRimaria = "Attività primaria ";
		String attivitaSecondaria = "Attività secondaria ";
		String formaGiuridica = "Forma Giuridica ";
		String marcaBollo = " Marca da bollo ";
		String quadriAnagrafica = "Quadro Titolare / Legale rappresentante ";
		String codiceFiscaleTitolare = "Codice fiscale ";
		String nomeTitolare = "Nome ";
		String cognomeTitolare = "Cognome";
		String dataNascitaTitolare = "Data nascita";
		String indirizzoResidenzaTitolare = "Indirizzo comune di residenza ";
		String civicoResidenzaTitolare = "Civico ";
		String capResidenzaTitolare = "Cap ";
		String comuneResidenzaTitolare = "Comune residenza ";
		String telefoneTitolare = "Telefono/ Cellulare  ";
		String eMailTitolare = "eMail ";
		String titoloStudioTitolare = "Titolo di Studio ";
		String altriTitolare = "Altri titoli di studio ";
		String conduttore = "Quadro conduttore ";
		String altreSedi = "Altre sedi";
		String fraseConduttore = "Il titolare o rappresentante legale coincide con il conduttore dell'azienda";
		String domandaTitleFr = "ANNUAIRE DES ENTREPRISES FORESTIÈRES TRANSFRONTALIÈR  ";
		String dettaglioSchedaAziendaFr = "PROFIL DE L’ENTREPRISE  ";
		String sezione1Fr = "FICHE 1 – DONNEES PERSONNELLES  ";
		String codiceFiscaleFr = "N. SIRET   ";
		String partivaIvaFr = "N. TVA ";
		String denominazioneFr = "Dénomination sociale ";
		String sedeLegaleFr = "Adresse du siège social  ";
		String sedeLegaleComuneFr = "Commune ";
		String sedeLegaleProvinciaFr = "Départem ";
		String sedeLegaleIndirizzoFr = "Indirizzo ";
		String sedeLegaleCivicoFr = "Numéro ";
		String sedeLegaleCapFr = "Code Postal ";
		String eMailAziendaFr = "E-mail ";
		String telefonoAziendaFr = "Téléphone ";
		String cellulareAziendaFr = "Portable  ";
		String sitoWEBFr = "Site WEB ";
		String attivitaRimariaFr = "Activitè principale ";
		String formaGiuridicaFr = "Statut juridique ";
		String quadriAnagraficaFr = "PROPRIETAIRE/REPRESENTANT LEGAL ";
		String codiceFiscaleTitolareFr = "N° RSI//MSA ";
		String nomeTitolareFr = "Prénom ";
		String cognomeTitolareFr = "Nom ";
		String dataNascitaTitolareFr = "Date de naissance";
		String indirizzoResidenzaTitolareFr = "Adresse de résidence (rue ) ";
		String civicoResidenzaTitolareFr = "Numéro ";
		String capResidenzaTitolareFr = "Code Postal ";
		String comuneResidenzaTitolareFr = "Commune ";
		String telefoneTitolareFr = "Téléphone  ";
		String eMailTitolareFr = "E-Mail ";
		String titoloStudioTitolareFr = "Diplôme ";
		String altriTitolareFr = "Etudes supplémentaires - cours –  ";
		String formazioneForestale = "Formazione forestale";
		String formazioneForestaleFr = "Entraînement en forêt";

		FontsForDocuments docFonts = new FontsForDocuments();
		PdfUtils pdfUtils = new PdfUtils();

		String forSpace = "   ";
		String twoSpace = " \n";
		String tenSpace = "          ";
		String twoSpace2 = "  ";
		String newLine = "\n";

		TaifTSedeAziendaByIdAziendaDto sedeLegaleDataBase = new TaifTSedeAziendaByIdAziendaDto();
		List<TaifTSedeAziendaByIdAziendaDto> altriSediDataBase = new ArrayList<TaifTSedeAziendaByIdAziendaDto>();
		for (TaifTSedeAziendaByIdAziendaDto sede : sedeAzienda) {
			if (sede.getIdTipo() == 1) {
				sedeLegaleDataBase = sede;
			} else {
				altriSediDataBase.add(sede);
			}
		}
		int idPersona = 0;
		int idConduttore = 0;
		TaifTPersonaDto conduttoreRapp = new TaifTPersonaDto();
		for (TaifRPersonaAziendaByIdAziendaDto persAzienda : listPersonePerIdAzienda) {
			if (persAzienda.getIdRuolo() == 1) {
				idPersona = persAzienda.getId();
			} else if (persAzienda.getIdRuolo() == 2) {
				idConduttore = persAzienda.getId();
			}
		}
		TaifTPersonaDto titolareRapp = pdfDbManager.getPersona(idPersona);
		if (idConduttore > 0) {
			conduttoreRapp = pdfDbManager.getPersona(idConduttore);
		} else {
			conduttoreRapp = pdfDbManager.getPersona(idPersona);
		}
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf = new SimpleDateFormat(it.csi.taif.taifweb.util.Constants.FIRMA_FORMAT_DATA);
		String dataStr = sdf.format(titolareRapp.getDataNascita());

		Paragraph preface = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			preface.add(new Chunk(domandaTitle, docFonts.titoloFont16));
		} else {
			preface.add(new Chunk(domandaTitleFr, docFonts.titoloFont16));
		}
		preface.setAlignment(Element.ALIGN_CENTER);
		pdfUtils.addEmptyLine(preface, 1);

		Paragraph preface2 = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			preface2.add(new Chunk(dettaglioSchedaAzienda, docFonts.titoloFont14));
		} else {
			preface2.add(new Chunk(dettaglioSchedaAziendaFr, docFonts.titoloFont14));
		}
		preface2.setAlignment(Element.ALIGN_CENTER);
		pdfUtils.addEmptyLine(preface2, 1);

		Paragraph testo = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testo.add(new Chunk(sezione1, docFonts.titoloFont14));
		} else {
			testo.add(new Chunk(sezione1Fr, docFonts.titoloFont14));
		}
		testo.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testo, 1);
		/*
		 * Paragraph testoTitolare = new Paragraph(); testoTitolare.add(new
		 * Chunk(quadriAnagrafica, docFonts.titoloFont12));
		 * testoTitolare.setAlignment(Element.ALIGN_LEFT);
		 * pdfUtils.addEmptyLine(testoTitolare, 1);
		 */

		// coficeFiscale
		Paragraph testocf = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testocf.add(new Chunk(codiceFiscale, docFonts.titoloFont10));
		} else {
			testocf.add(new Chunk(codiceFiscaleFr, docFonts.titoloFont10));
		}
		if (tracciatoData.equals(Constants.iLang)) {
			testocf.add(new Chunk(twoSpace.concat(taifTAziendaDto.getCodiceFiscale()), docFonts.descrFont10));
		} else {
			testocf.add(new Chunk(twoSpace.concat(taifTAziendaDto.getNSiret()), docFonts.descrFont10));
		}
		testocf.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testocf, 1);

		// partivaIva
		Paragraph testoPartitaIva = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoPartitaIva.add(new Chunk(partivaIva, docFonts.titoloFont10));
			testoPartitaIva.add(new Chunk(twoSpace.concat(taifTAziendaDto.getPartitaIva()), docFonts.descrFont10));
		} else {
			testoPartitaIva.add(new Chunk(partivaIvaFr, docFonts.titoloFont10));
			testoPartitaIva.add(new Chunk(twoSpace.concat(taifTAziendaDto.getNTva()), docFonts.descrFont10));
		}

		testoPartitaIva.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoPartitaIva, 1);

		// denominazione
		Paragraph testoDenominazione = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoDenominazione.add(new Chunk(denominazione, docFonts.titoloFont10));
		} else {
			testoDenominazione.add(new Chunk(denominazioneFr, docFonts.titoloFont10));
		}
		testoDenominazione.add(new Chunk(twoSpace.concat(taifTAziendaDto.getRagioneSociale()), docFonts.descrFont10));
		testoDenominazione.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoDenominazione, 1);

		// iscrizioneCcia
		Paragraph testoIscrizioneCcia = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoIscrizioneCcia.add(new Chunk(iscrizioneCcia, docFonts.titoloFont10));
			testoIscrizioneCcia.add(new Chunk(
					twoSpace.concat(taifTAziendaDto.getCciaaSiglaProv() + tenSpace + taifTAziendaDto.getCciaaNumero()),
					docFonts.descrFont10));
			testoIscrizioneCcia.setAlignment(Element.ALIGN_LEFT);
		}
		pdfUtils.addEmptyLine(testoIscrizioneCcia, 1);

		// sedeLegale
		Paragraph testoSedeLegale = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoSedeLegale.add(new Chunk(sedeLegale, docFonts.titoloFont10));
			testoSedeLegale.add(new Chunk(twoSpace.concat(sedeLegaleProvincia), docFonts.titoloFont10));
			testoSedeLegale.add(new Chunk(
					twoSpace2.concat(pdfDbManager.getProvinciaFromIstat(sedeLegaleDataBase.getIstatComune()).getNome()),
					docFonts.descrFont10));
			// testoSedeLegale.add(new
			// Chunk(twoSpace2.concat(provinciaSedeLegale.getNome()),
			// docFonts.descrFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat(sedeLegaleComune), docFonts.titoloFont10));
			// testoSedeLegale.add(new Chunk(twoSpace2.concat(comuneSedeLegale.getNome()),
			// docFonts.descrFont10));
			testoSedeLegale.add(new Chunk(
					twoSpace2.concat(pdfDbManager.getComuneFromIstat(sedeLegaleDataBase.getIstatComune()).getNome()),
					docFonts.descrFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat(sedeLegaleIndirizzo), docFonts.titoloFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat(sedeLegaleDataBase.getIndirizzo()), docFonts.descrFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat(sedeLegaleCivico), docFonts.titoloFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat((sedeLegaleDataBase.getCivico())), docFonts.descrFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat(sedeLegaleCap), docFonts.titoloFont10));
			testoSedeLegale
					.add(new Chunk(twoSpace2.concat((sedeLegaleDataBase.getCap().toString())), docFonts.descrFont10));
		} else {
			testoSedeLegale.add(new Chunk(sedeLegaleFr, docFonts.titoloFont10));
			testoSedeLegale.add(new Chunk(twoSpace.concat(sedeLegaleProvinciaFr), docFonts.titoloFont10));
			// testoSedeLegale.add(new
			// Chunk(twoSpace2.concat(pdfDbManager.getProvinciaFromIstat(sedeLegaleDataBase.getIstatComune()).getNome()),
			// docFonts.descrFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat(""), docFonts.descrFont10));
			// testoSedeLegale.add(new
			// Chunk(twoSpace2.concat(provinciaSedeLegale.getNome()),
			// docFonts.descrFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat(sedeLegaleComuneFr), docFonts.titoloFont10));
			// testoSedeLegale.add(new Chunk(twoSpace2.concat(comuneSedeLegale.getNome()),
			// docFonts.descrFont10));
			// testoSedeLegale.add(new
			// Chunk(twoSpace2.concat(pdfDbManager.getComuneFromIstat(sedeLegaleDataBase.getIstatComune()).getNome()),
			// docFonts.descrFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat(""), docFonts.descrFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat(sedeLegaleIndirizzoFr), docFonts.titoloFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat(sedeLegaleDataBase.getIndirizzo()), docFonts.descrFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat(sedeLegaleCivicoFr), docFonts.titoloFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat((sedeLegaleDataBase.getCivico())), docFonts.descrFont10));
			testoSedeLegale.add(new Chunk(twoSpace2.concat(sedeLegaleCapFr), docFonts.titoloFont10));
			testoSedeLegale
					.add(new Chunk(twoSpace2.concat((sedeLegaleDataBase.getCap().toString())), docFonts.descrFont10));
		}

		testoSedeLegale.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoSedeLegale, 1);

		// pec
		Paragraph testoPec = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoPec.add(new Chunk(pecAzienda, docFonts.titoloFont10));
			testoPec.add(new Chunk(twoSpace.concat(taifTAziendaDto.getPec()), docFonts.descrFont10));
			testoPec.setAlignment(Element.ALIGN_LEFT);
		}
		pdfUtils.addEmptyLine(testoPec, 1);

		// eMail
		Paragraph testoMail = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoMail.add(new Chunk(eMailAzienda, docFonts.titoloFont10));
		} else {
			testoMail.add(new Chunk(eMailAziendaFr, docFonts.titoloFont10));
		}
		if (taifTAziendaDto.getEmail() != null) {
			testoMail
					.add(new Chunk(twoSpace.concat(forSpace.concat(taifTAziendaDto.getEmail())), docFonts.descrFont10));
		}
		testoMail.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoMail, 1);

		// Telefono
		Paragraph testoTelefono = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoTelefono.add(new Chunk(telefonoAzienda, docFonts.titoloFont10));
		} else {
			testoTelefono.add(new Chunk(telefonoAziendaFr, docFonts.titoloFont10));
		}

		if (sedeLegaleDataBase.getTelefon() != null) {
			testoTelefono.add(new Chunk(twoSpace.concat(sedeLegaleDataBase.getTelefon()), docFonts.descrFont10));
		}
		testoTelefono.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoTelefono, 1);

		// Cellulare
		Paragraph testoCellulare = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoCellulare.add(new Chunk(cellulareAzienda, docFonts.titoloFont10));
		} else {
			testoCellulare.add(new Chunk(cellulareAziendaFr, docFonts.titoloFont10));
		}

		if (sedeLegaleDataBase.getCellulare() != null) {
			testoCellulare.add(new Chunk(twoSpace.concat(sedeLegaleDataBase.getCellulare()), docFonts.descrFont10));
		}
		testoCellulare.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoCellulare, 1);

		// Sito web
		Paragraph testoSitoWeb = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoSitoWeb.add(new Chunk(sitoWEB, docFonts.titoloFont10));
		} else {
			testoSitoWeb.add(new Chunk(sitoWEBFr, docFonts.titoloFont10));
		}

		if (taifTAziendaDto.getSitoWeb() != null) {
			testoSitoWeb.add(new Chunk(twoSpace.concat(taifTAziendaDto.getSitoWeb()), docFonts.descrFont10));
		}
		testoSitoWeb.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoSitoWeb, 1);

		// Sito web
		Paragraph testoAttivitaOne = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoAttivitaOne.add(new Chunk(attivitaRimaria, docFonts.titoloFont10));
		} else {
			testoAttivitaOne.add(new Chunk(attivitaRimariaFr, docFonts.titoloFont10));
		}

		if (taifTAziendaDto.getFkAttivitaPrimaria() != null) {
			testoAttivitaOne.add(new Chunk(
					twoSpace.concat(pdfDbManager.getAttivitaAteco(taifTAziendaDto.getFkAttivitaPrimaria()).toString()),
					docFonts.descrFont10));
		}
		testoAttivitaOne.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoAttivitaOne, 1);

		// Sito web
		Paragraph testoAttivitaTwo = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoAttivitaTwo.add(new Chunk(attivitaSecondaria, docFonts.titoloFont10));
			if (taifTAziendaDto.getFkAttivitaSecondaria() != null) {
				testoAttivitaTwo.add(new Chunk(
						twoSpace.concat(pdfDbManager.getAttivitaAteco(taifTAziendaDto.getFkAttivitaSecondaria())),
						docFonts.descrFont10));
			}
		}
		testoAttivitaTwo.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoAttivitaTwo, 1);

		// Forma Giuridica
		Paragraph testoFormaGiuridica = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoFormaGiuridica.add(new Chunk(formaGiuridica, docFonts.titoloFont10));
		} else {
			testoFormaGiuridica.add(new Chunk(formaGiuridicaFr, docFonts.titoloFont10));
		}
		if (tracciatoData.equals(Constants.iLang)) {
			if (taifTAziendaDto.getFkFormaGiuridicaIta() != null) {
				testoFormaGiuridica.add(new Chunk(
						twoSpace.concat(
								pdfDbManager.getFormaGiuridica(taifTAziendaDto.getFkFormaGiuridicaIta()).toString()),
						docFonts.descrFont10));
			}
		} else {
			if (taifTAziendaDto.getFkAttivitaSecondaria() != null) {
				testoFormaGiuridica.add(new Chunk(
						twoSpace.concat(
								pdfDbManager.getFormaGiuridica(taifTAziendaDto.getFkFormaGiuridicaFra()).toString()),
						docFonts.descrFont10));
			}
		}
		testoFormaGiuridica.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoFormaGiuridica, 1);

		// Marca bollo
		Paragraph testoMarcaBollo = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoMarcaBollo.add(new Chunk(marcaBollo, docFonts.titoloFont10));
			if (taifTAziendaDto.getNMarcaBollo() != null) {
				testoMarcaBollo.add(new Chunk(twoSpace.concat(taifTAziendaDto.getNMarcaBollo()), docFonts.descrFont10));
			}
		}
		testoMarcaBollo.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoMarcaBollo, 1);

		// TitolareRapp

		Paragraph testoTitolare = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoTitolare.add(new Chunk(quadriAnagrafica, docFonts.titoloFont12));
		} else {
			testoTitolare.add(new Chunk(quadriAnagraficaFr, docFonts.titoloFont12));
		}
		testoTitolare.setAlignment(Element.ALIGN_LEFT);
		//pdfUtils.addEmptyLine(testoTitolare, 1);
		testoTitolare.add(new Chunk(newLine));

		Paragraph titolare = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoTitolare.add(new Chunk(twoSpace.concat(codiceFiscaleTitolare), docFonts.titoloFont10));
		} else {
			testoTitolare.add(new Chunk(twoSpace.concat(codiceFiscaleTitolareFr), docFonts.titoloFont10));
		}
		if (tracciatoData.equals(Constants.iLang)) {
			if (titolareRapp.getCodiceFiscale() != null) {
				testoTitolare.add(new Chunk(twoSpace.concat(titolareRapp.getCodiceFiscale()), docFonts.descrFont10));
			}
		} else {
			if (titolareRapp.getNRsiMsa() != null) {
				testoTitolare.add(new Chunk(twoSpace.concat(titolareRapp.getNRsiMsa()), docFonts.descrFont10));
			}
		}
		titolare.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoTitolare, 1);

		Paragraph testoCognome = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoCognome.add(new Chunk(cognomeTitolare, docFonts.titoloFont10));
		} else {
			testoCognome.add(new Chunk(cognomeTitolareFr, docFonts.titoloFont10));
		}
		if (titolareRapp.getCodiceFiscale() != null) {
			testoCognome.add(new Chunk(twoSpace.concat(titolareRapp.getCognome()), docFonts.descrFont10));
		}
		testoCognome.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoCognome, 1);

		Paragraph testoNome = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoNome.add(new Chunk(nomeTitolare, docFonts.titoloFont10));
		} else {
			testoNome.add(new Chunk(nomeTitolareFr, docFonts.titoloFont10));
		}
		if (titolareRapp.getCodiceFiscale() != null) {
			testoNome.add(new Chunk(twoSpace.concat(titolareRapp.getNome()), docFonts.descrFont10));
		}
		testoNome.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoNome, 1);

		Paragraph testoDataNascita = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoDataNascita.add(new Chunk(dataNascitaTitolare, docFonts.titoloFont10));
		} else {
			testoDataNascita.add(new Chunk(dataNascitaTitolareFr, docFonts.titoloFont10));
		}
		if (titolareRapp.getCodiceFiscale() != null) {
			testoDataNascita.add(new Chunk(twoSpace));
			testoDataNascita.add(new Chunk(dataStr, docFonts.descrFont10));
		}
		testoDataNascita.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoDataNascita, 1);

		Paragraph testoIndirizzo = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoIndirizzo.add(new Chunk(indirizzoResidenzaTitolare, docFonts.titoloFont10));
		} else {
			testoIndirizzo.add(new Chunk(indirizzoResidenzaTitolareFr, docFonts.titoloFont10));
		}
		if (titolareRapp.getIndirizzoRes() != null) {
			testoIndirizzo.add(new Chunk(twoSpace2));
			testoIndirizzo.add(new Chunk(titolareRapp.getIndirizzoRes(), docFonts.descrFont10));
		}
		if (tracciatoData.equals(Constants.iLang)) {
			testoIndirizzo.add(new Chunk(tenSpace.concat(civicoResidenzaTitolare), docFonts.titoloFont10));
		} else {
			testoIndirizzo.add(new Chunk(tenSpace.concat(civicoResidenzaTitolareFr), docFonts.titoloFont10));
		}
		if (titolareRapp.getIndirizzoRes() != null) {
			testoIndirizzo.add(new Chunk(twoSpace2));
			testoIndirizzo.add(new Chunk(titolareRapp.getCivicoRes(), docFonts.descrFont10));
		}
		testoIndirizzo.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoIndirizzo, 1);

		Paragraph testoComuneResidenza = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoComuneResidenza.add(new Chunk(comuneResidenzaTitolare, docFonts.titoloFont10));
			if (titolareRapp.getIstatComuneRes() != null) {
				 testoComuneResidenza.add(new
				 Chunk(twoSpace2.concat(taifMgr.getComuneByIstat(titolareRapp.getIstatComuneRes()).getNome()),
				 docFonts.descrFont10));
				//testoComuneResidenza.add(new Chunk(twoSpace2.concat(comuneSedeLegale), docFonts.descrFont10));
			}
		} else {
			testoComuneResidenza.add(new Chunk(comuneResidenzaTitolareFr, docFonts.titoloFont10));
			if (titolareRapp.getComuneEsteroRes() != null) {
				testoComuneResidenza.add(new Chunk(twoSpace2));
				testoComuneResidenza.add(new Chunk(titolareRapp.getComuneEsteroRes(), docFonts.descrFont10));
			}
		}
		if (titolareRapp.getCapRes() != null) {
			if (tracciatoData.equals(Constants.iLang)) {
				testoComuneResidenza.add(new Chunk(tenSpace.concat(capResidenzaTitolare), docFonts.titoloFont10));
			} else {
				testoComuneResidenza.add(new Chunk(tenSpace.concat(capResidenzaTitolareFr), docFonts.titoloFont10));
			}
			if (titolareRapp.getIndirizzoRes() != null) {
				testoComuneResidenza.add(new Chunk(twoSpace2));
				testoComuneResidenza.add(new Chunk(titolareRapp.getCapRes(), docFonts.descrFont10));
			}
		}
		testoComuneResidenza.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoComuneResidenza, 1);

		Paragraph testoTelefonoTitolare = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoTelefonoTitolare.add(new Chunk(telefoneTitolare, docFonts.titoloFont10));
		} else {
			testoTelefonoTitolare.add(new Chunk(telefoneTitolareFr, docFonts.titoloFont10));
		}
		if (titolareRapp.getTelefono() != null) {
			testoTelefonoTitolare.add(new Chunk(twoSpace));
			testoTelefonoTitolare.add(new Chunk(titolareRapp.getTelefono(), docFonts.descrFont10));
		}
		testoTelefonoTitolare.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoTelefonoTitolare, 1);

		Paragraph testoMailTitolare = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoMailTitolare.add(new Chunk(eMailTitolare, docFonts.titoloFont10));
		} else {
			testoMailTitolare.add(new Chunk(eMailTitolareFr, docFonts.titoloFont10));
		}
		if (titolareRapp.getMail() != null) {
			testoMailTitolare.add(new Chunk(twoSpace));
			testoMailTitolare.add(new Chunk(titolareRapp.getMail(), docFonts.descrFont10));
		}
		testoMailTitolare.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoMailTitolare, 1);

		Paragraph testoTitoloStudio = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoTitoloStudio.add(new Chunk(titoloStudioTitolare, docFonts.titoloFont10));
		} else {
			testoTitoloStudio.add(new Chunk(titoloStudioTitolareFr, docFonts.titoloFont10));
		}
		if (tracciatoData.equals(Constants.iLang)) {
			if (titolareRapp.getFkTitoloStudio() != null) {
				testoTitoloStudio.add(new Chunk(twoSpace));
				testoTitoloStudio.add(new Chunk(pdfDbManager.getTitoloStudio(titolareRapp.getFkTitoloStudio()),
						docFonts.descrFont10));
			}
		} else {
			if (titolareRapp.getFkTitoloStudioFra() != null) {
				testoTitoloStudio.add(new Chunk(twoSpace));
				testoTitoloStudio.add(new Chunk(pdfDbManager.getTitoloStudio(titolareRapp.getFkTitoloStudioFra()),
						docFonts.descrFont10));
			}
		}
		testoTitoloStudio.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoTitoloStudio, 1);

		Paragraph testoAltriTitoloStudio = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoAltriTitoloStudio.add(new Chunk(altriTitolare, docFonts.titoloFont10));
		} else {
			testoAltriTitoloStudio.add(new Chunk(altriTitolareFr, docFonts.titoloFont10));
		}
		if (titolareRapp.getAltriStudi() != null) {
			testoAltriTitoloStudio.add(new Chunk(twoSpace));
			testoAltriTitoloStudio.add(new Chunk(titolareRapp.getAltriStudi(), docFonts.descrFont10));
		}

		testoAltriTitoloStudio.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoAltriTitoloStudio, 1);

		Paragraph testoFormazioneTitolare = new Paragraph();
		String formazioneF = pdfDbManager.findCorsiPerPersona(idPersona);
		if (tracciatoData.equals(Constants.iLang)) {
			testoFormazioneTitolare.add(new Chunk(formazioneForestale, docFonts.titoloFont10));
		} else {
			testoFormazioneTitolare.add(new Chunk(formazioneForestaleFr, docFonts.titoloFont10));
		}
		// if (formazioneF.length() > 1) {
		if (StringUtils.isNotEmpty(formazioneF)) {
			testoFormazioneTitolare.add(new Chunk(twoSpace.concat(formazioneF), docFonts.descrFont10));
		} else {
			testoFormazioneTitolare.add(new Chunk(tenSpace.concat(Constants.NO), docFonts.descrFont10));
		}
		testoFormazioneTitolare.add(new Chunk(newLine));
		testoFormazioneTitolare.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoFormazioneTitolare, 1);

		// Conduttore

		Paragraph testoConduttore = new Paragraph();
		Paragraph testoCognomeCond = new Paragraph();
		Paragraph testoNomeCond = new Paragraph();
		Paragraph testoDataNascitaCond = new Paragraph();
		Paragraph testoIndirizzoCond = new Paragraph();
		Paragraph testoComuneResidenzaCond = new Paragraph();
		Paragraph testoTelefonoTitolareCond = new Paragraph();
		Paragraph testoTitoloStudioCond = new Paragraph();
		Paragraph testoFormazioneConduttore = new Paragraph();
		Paragraph testoAltriTitoloStudioCond = new Paragraph();
		Paragraph testoMailTitolareCond = new Paragraph();



		testoConduttore.add(new Chunk(conduttore, docFonts.titoloFont12));
		testoConduttore.add(new Chunk(newLine));
		
		if (idConduttore == 0) {
			testoConduttore.add(new Chunk(twoSpace.concat(fraseConduttore), docFonts.titoloFont10));

		} else {
		testoConduttore.add(new Chunk(twoSpace.concat(codiceFiscaleTitolare), docFonts.titoloFont10));
		if (tracciatoData.equals(Constants.iLang)) {
			if (titolareRapp.getCodiceFiscale() != null) {
				testoConduttore
						.add(new Chunk(twoSpace.concat(conduttoreRapp.getCodiceFiscale()), docFonts.descrFont10));
			}
		} else {
			if (titolareRapp.getNRsiMsa() != null) {
				testoConduttore.add(new Chunk(twoSpace.concat(conduttoreRapp.getNRsiMsa()), docFonts.descrFont10));
			}
		}
		testoConduttore.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoConduttore, 1);
		
		//Paragraph testoCognomeCond = new Paragraph();

		testoCognomeCond.add(new Chunk(cognomeTitolare, docFonts.titoloFont10));
		if (conduttoreRapp.getCognome() != null) {
			testoCognomeCond.add(new Chunk(twoSpace.concat(conduttoreRapp.getCognome()), docFonts.descrFont10));
		}
		testoCognomeCond.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoCognomeCond, 1);

		//Paragraph testoNomeCond = new Paragraph();

		testoNomeCond.add(new Chunk(nomeTitolare, docFonts.titoloFont10));
		if (conduttoreRapp.getNome() != null) {
			testoNomeCond.add(new Chunk(twoSpace.concat(conduttoreRapp.getNome()), docFonts.descrFont10));
		}
		testoNomeCond.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoNomeCond, 1);

		//Paragraph testoDataNascitaCond = new Paragraph();

		testoDataNascitaCond.add(new Chunk(dataNascitaTitolare, docFonts.titoloFont10));
		if (conduttoreRapp.getDataNascita() != null) {
			testoDataNascitaCond.add(new Chunk(twoSpace));
			testoDataNascitaCond.add(new Chunk(dataStr, docFonts.descrFont10));
		}
		testoDataNascitaCond.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoDataNascitaCond, 1);

		//Paragraph testoIndirizzoCond = new Paragraph();

		testoIndirizzoCond.add(new Chunk(indirizzoResidenzaTitolare, docFonts.titoloFont10));
		if (conduttoreRapp.getIndirizzoRes() != null) {
			testoIndirizzoCond.add(new Chunk(twoSpace2));
			testoIndirizzoCond.add(new Chunk(conduttoreRapp.getIndirizzoRes(), docFonts.descrFont10));
		}
		testoIndirizzoCond.add(new Chunk(tenSpace.concat(civicoResidenzaTitolareFr), docFonts.titoloFont10));
		if (conduttoreRapp.getIndirizzoRes() != null) {
			testoIndirizzoCond.add(new Chunk(twoSpace2));
			testoIndirizzoCond.add(new Chunk(conduttoreRapp.getCivicoRes(), docFonts.descrFont10));
		}
		testoIndirizzoCond.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoIndirizzoCond, 1);

		//Paragraph testoComuneResidenzaCond = new Paragraph();

		testoComuneResidenzaCond.add(new Chunk(comuneResidenzaTitolare, docFonts.titoloFont10));
		if (conduttoreRapp.getIstatComuneRes() != null) {
			testoComuneResidenzaCond.add(new Chunk(twoSpace2));
			 testoComuneResidenzaCond.add(new
			 Chunk(taifMgr.getComuneByIstat(conduttoreRapp.getIstatComuneRes()).getNome(),
			 docFonts.descrFont10));
		}
		testoComuneResidenzaCond.add(new Chunk(tenSpace.concat(capResidenzaTitolare), docFonts.titoloFont10));
		if (conduttoreRapp.getIndirizzoRes() != null) {
			testoComuneResidenzaCond.add(new Chunk(twoSpace2));
			testoComuneResidenzaCond.add(new Chunk(conduttoreRapp.getCapRes(), docFonts.descrFont10));
		}
		testoComuneResidenzaCond.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoComuneResidenzaCond, 1);

		//Paragraph testoTelefonoTitolareCond = new Paragraph();
		testoTelefonoTitolareCond.add(new Chunk(telefoneTitolare, docFonts.titoloFont10));
		if (conduttoreRapp.getTelefono() != null) {
			testoTelefonoTitolareCond.add(new Chunk(twoSpace));
			testoTelefonoTitolareCond.add(new Chunk(conduttoreRapp.getTelefono(), docFonts.descrFont10));
		}
		testoTelefonoTitolareCond.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoTelefonoTitolareCond, 1);

		//Paragraph testoMailTitolareCond = new Paragraph();
		testoMailTitolareCond.add(new Chunk(eMailTitolare, docFonts.titoloFont10));
		if (conduttoreRapp.getMail() != null) {
			testoMailTitolareCond.add(new Chunk(twoSpace));
			testoMailTitolareCond.add(new Chunk(conduttoreRapp.getMail(), docFonts.descrFont10));
		}
		testoMailTitolareCond.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoMailTitolareCond, 1);

		//Paragraph testoTitoloStudioCond = new Paragraph();
		
		testoTitoloStudioCond.add(new Chunk(titoloStudioTitolare, docFonts.titoloFont10));
		if (tracciatoData.equals(Constants.iLang)) {
			if (conduttoreRapp.getFkTitoloStudio() != null) {
				testoTitoloStudioCond.add(new Chunk(twoSpace));
				testoTitoloStudioCond.add(new Chunk(pdfDbManager.getTitoloStudio(conduttoreRapp.getFkTitoloStudio()),
						docFonts.descrFont10));
			}
		} else {
			if (conduttoreRapp.getFkTitoloStudioFra() != null) {
				testoTitoloStudioCond.add(new Chunk(twoSpace));
				testoTitoloStudioCond.add(new Chunk(pdfDbManager.getTitoloStudio(conduttoreRapp.getFkTitoloStudioFra()),
						docFonts.descrFont10));
			}
		}
		testoTitoloStudioCond.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoTitoloStudioCond, 1);

		//Paragraph testoAltriTitoloStudioCond = new Paragraph();
		testoAltriTitoloStudioCond.add(new Chunk(altriTitolare, docFonts.titoloFont10));
		if (conduttoreRapp.getAltriStudi() != null) {
			testoAltriTitoloStudioCond.add(new Chunk(twoSpace));
			testoAltriTitoloStudioCond.add(new Chunk(conduttoreRapp.getAltriStudi(), docFonts.descrFont10));
		}

		testoAltriTitoloStudioCond.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoAltriTitoloStudioCond, 1);

		//Paragraph testoFormazioneConduttore = new Paragraph();
		testoFormazioneConduttore.add(new Chunk(formazioneForestale, docFonts.titoloFont10));
		String formazioneFC = pdfDbManager.findCorsiPerPersona(idConduttore);
		//if (formazioneF.length() > 1) {
		if(StringUtils.isNotEmpty(formazioneFC)) {
			testoFormazioneConduttore.add(new Chunk(twoSpace.concat(formazioneFC), docFonts.descrFont10));
		} else {
			testoFormazioneConduttore.add(new Chunk(tenSpace.concat(Constants.NO), docFonts.descrFont10));
		}
		testoFormazioneConduttore.add(new Chunk(twoSpace));
		testoFormazioneConduttore.setAlignment(Element.ALIGN_LEFT);
		pdfUtils.addEmptyLine(testoFormazioneConduttore, 1);
		}
		// altri sedi
		// sedeLegale

		Paragraph testoAltreSedi = new Paragraph();
		if (tracciatoData.equals(Constants.iLang)) {
			testoAltreSedi.add(new Chunk(altreSedi, docFonts.titoloFont10));
			for (TaifTSedeAziendaByIdAziendaDto altroSede : altriSediDataBase) {
				String comuneSedeAzienda = "";
				String provinciaSedeAzienda = "";
				
					Comune c = taifMgr.getComuneByIstat(altroSede.getIstatComune());
					comuneSedeAzienda = c.getNome();
					Provincia p = taifMgr.getProvinciaByIstat(altroSede.getIstatComune());
					provinciaSedeAzienda = p.getNome();
				
				
				
				testoAltreSedi.add(new Chunk(twoSpace.concat(sedeLegaleProvincia), docFonts.titoloFont10));
				// testoAltreSedi.add(new
				// Chunk(twoSpace2.concat(getProvinciaFromIstat(sedeLegaleDataBase.getIstatComune()).getNome()),
				// docFonts.descrFont10));
				testoAltreSedi.add(new Chunk(twoSpace2.concat(provinciaSedeAzienda), docFonts.descrFont10));
				testoAltreSedi.add(new Chunk(twoSpace2.concat(sedeLegaleComune), docFonts.titoloFont10));
				testoAltreSedi.add(new Chunk(twoSpace2.concat(comuneSedeAzienda), docFonts.descrFont10));
				// testoAltreSedi.add(new
				// Chunk(twoSpace2.concat(getComuneFromIstat(sedeLegaleDataBase.getIstatComune()).getNome()),
				// docFonts.descrFont10));
				testoAltreSedi.add(new Chunk(twoSpace2.concat(sedeLegaleIndirizzo), docFonts.titoloFont10));
				testoAltreSedi.add(new Chunk(twoSpace2.concat(altroSede.getIndirizzo()), docFonts.descrFont10));
				testoAltreSedi.add(new Chunk(twoSpace2.concat(sedeLegaleCivico), docFonts.titoloFont10));
				testoAltreSedi.add(new Chunk(twoSpace2.concat((altroSede.getCivico())), docFonts.descrFont10));
				testoAltreSedi.add(new Chunk(twoSpace2.concat(sedeLegaleCap), docFonts.titoloFont10));
				testoAltreSedi.add(new Chunk(twoSpace2.concat((altroSede.getCap().toString())), docFonts.descrFont10));

				testoAltreSedi.setAlignment(Element.ALIGN_LEFT);
			}
			pdfUtils.addEmptyLine(testoAltreSedi, 1);
		}
		// variazioni

		document.add(preface);
		document.add(preface2);
		document.add(testo);
		document.add(testocf);
		document.add(testoPartitaIva);
		document.add(testoDenominazione);
		document.add(testoIscrizioneCcia);
		document.add(testoSedeLegale);
		document.add(testoPec);
		document.add(testoMail);
		document.add(testoTelefono);
		document.add(testoCellulare);
		document.add(testoSitoWeb);
		document.add(testoAttivitaOne);
		document.add(testoAttivitaTwo);
		document.add(testoFormaGiuridica);
		document.add(testoMarcaBollo);
		document.add(testoAltreSedi);
		document.add(testoTitolare);
		document.add(testoCognome);
		document.add(testoNome);
		document.add(testoDataNascita);
		document.add(testoIndirizzo);
		document.add(testoComuneResidenza);

		document.add(testoTelefonoTitolare);
		document.add(testoMailTitolare);
		document.add(testoTitoloStudio);
		document.add(testoAltriTitoloStudio);
		document.add(testoFormazioneTitolare);
		if (tracciatoData.equals(Constants.iLang)) {
			document.add(testoConduttore);
			if(idConduttore > 0) {
				document.add(testoCognomeCond);
				document.add(testoNomeCond);
				document.add(testoDataNascitaCond);
				document.add(testoIndirizzoCond);
				document.add(testoComuneResidenzaCond);
				document.add(testoTelefonoTitolareCond);
				document.add(testoMailTitolareCond);
				document.add(testoTitoloStudioCond);
				document.add(testoAltriTitoloStudioCond);
				document.add(testoFormazioneConduttore);
			}
		}
		document.newPage();

		return document;

	}

}
