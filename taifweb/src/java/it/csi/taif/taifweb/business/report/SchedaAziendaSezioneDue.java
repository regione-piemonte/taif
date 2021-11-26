/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaCategImpresaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCertificazioneFindCertificazioniByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDFormaGiuridicaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDTipoAttivitaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter;
import it.csi.taif.taifweb.business.dao.util.Constants;
import it.csi.taif.taifweb.business.manager.db.DbMgr;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.StringUtils;

public class SchedaAziendaSezioneDue {

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

    Document addSezioneTwoBodyPage(Document document, TaifTAziendaDto taifTAziendaDto,
	    List<TaifTPraticaByIdAziendaDto> pratichePerAzienda, String tracciatoData) throws DocumentException,
	    IOException, DbManagerException, TaifDTipoAttivitaDaoException, TaifDFormaGiuridicaDaoException {

	String sezione2 = "Sezione 2 – Dati Socio-Economici  ";
	String annoInizioAttivita = "Anno inizio attività ";
	String fatturatoUltimoAnno = "Fatturato ultimo anno ";
	String descrizioneAltroAlbo = "Descrizione Albo ";
	String numeroAlbo = "Numero Albo  ";
	String dataIscrizione = "Data Iscrizione Albo ";
	String sezione = "Sezione ";
	String associazione = "Associazione  ";
	String nomeAssociazione = "Nome  ";
	String categorieDeImpresa = "Categorie di impresa ";
	String iscrizioneAltriAlbi = "Iscrizione ad altri albi delle imprese forestali :";
	String partecipazioneFormeOrganizzative = "Partecipazione a forme organizzative (associazioni, consorzi , altro) : ";
	String possesoCertificazioni = "Possesso di certificazioni di qualità e/o di processo ";
	String tipoCertificato = "Tipo certificato ";
	String enteCertificatore = "Ente certificatore";
	String numeroCertificato = "Numero  ";
	String annoCertificato = "Anno certificato ";
	String dataScadenza = "Scadenza ";
	String descrizione = "Note ";
	String euro = "( euro ) ";

	String sezione2Fr = "FICHE 2 – DONNEES SOCIO-ECONOMIQUES ";
	String annoInizioAttivitaFr = "Année de début des activités ";
	String fatturatoUltimoAnnoFr = "Chiffre d’affaires dernière année  ";
	String descrizioneAltroAlboFr = "Inscription dans d’autres annuaires/registres d’entreprises forestières ";
	String numeroAlboFr = "Dénomination  ";
	String dataIscrizioneFr = "Numéro et date d’inscription ";
	String sezioneFr = "Fiche ";
	String associazioneFr = "Association  ";
	String nomeAssociazioneFr = "Dénomination  ";
	String categorieDeImpresaFr = "Catégorie  ";
	String iscrizioneAltriAlbiFr = "Inscription dans d’autres annuaires/registres d’entreprises forestières :";
	String partecipazioneFormeOrganizzativeFr = "Participation dans des formes d’association (Association - Consortium - autre) : ";
	String possesoCertificazioniFr = "Titulaire de Certification de qualité et/ou de processus ";
	String tipoCertificatoFr = "Type Certification ";
	String enteCertificatoreFr = "Organisme de certification";
	String numeroCertificatoFr = "N°   ";
	String annoCertificatoFr = "Année de délivrance ";
	String dataScadenzaFr = "Date d’échéance (mm/aaaa) ";
	String descrizioneFr = "Autre  ";
	String euros = "( euros )";

	SimpleDateFormat sdf = new SimpleDateFormat();
	sdf = new SimpleDateFormat(it.csi.taif.taifweb.util.Constants.FIRMA_FORMAT_DATA);

	FontsForDocuments docFonts = new FontsForDocuments();
	PdfUtils pdfUtils = new PdfUtils();

	String forSpace = "   ";
	String twoSpace = " \n";
	String tenSpace = "          ";
	String twoSpace2 = "  ";
	String newLine = "\n";

	AziendaVisibleFilter aziendaVisibleFilter = new AziendaVisibleFilter();
	aziendaVisibleFilter.setFlagItaFr(tracciatoData);
	aziendaVisibleFilter.setFlagVisibile(Constants.oneInt);
	aziendaVisibleFilter.setIdAzienda(taifTAziendaDto.getIdAzienda());

	List<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto> categoriaImpresa = pdfDbManager
		.getCategoriaImpresa(aziendaVisibleFilter);
	List<String> fflagList = new ArrayList<String>();
	for (TaifTPraticaByIdAziendaDto pratiche : pratichePerAzienda) {
	    if (pratiche.getIdSoggettoGestore() == 1) {
		fflagList.add(pratiche.getFlagSezione());
	    }
	}
	List<TaifTPraticaByIdAziendaDto> altriAlbiList = new ArrayList<TaifTPraticaByIdAziendaDto>();
	for (TaifTPraticaByIdAziendaDto pratiche : pratichePerAzienda) {
	    if (pratiche.getIdSoggettoGestore() == 0) {
		altriAlbiList.add(pratiche);
	    }
	}

	List<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto> associazioni = pdfDbManager
		.getFormeOrganizzative(aziendaVisibleFilter);

	List<TaifTCertificazioneFindCertificazioniByIdAziendaDto> certificazioniList = pdfDbManager
		.getCertificazioni(aziendaVisibleFilter);

	Paragraph sezioneTwo = new Paragraph();
	if (tracciatoData.equals(Constants.iLang)) {
	    sezioneTwo.add(new Chunk(sezione2, docFonts.titoloFont14));
	} else {
	    sezioneTwo.add(new Chunk(sezione2Fr, docFonts.titoloFont14));
	}
	sezioneTwo.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(sezioneTwo, 1);

	Paragraph testoAnnoInizioAttivita = new Paragraph();
	if (tracciatoData.equals(Constants.iLang)) {
	    testoAnnoInizioAttivita.add(new Chunk(annoInizioAttivita, docFonts.titoloFont10));
	} else {
	    testoAnnoInizioAttivita.add(new Chunk(annoInizioAttivitaFr, docFonts.titoloFont10));
	}
	if(taifTAziendaDto.getAnnoInizio() != null) {
	    testoAnnoInizioAttivita
		.add(new Chunk(twoSpace.concat(taifTAziendaDto.getAnnoInizio().toString()), docFonts.descrFont10));
	}else {
	    testoAnnoInizioAttivita
		.add(new Chunk(twoSpace.concat(Constants.blank), docFonts.descrFont10));  
	}
	testoAnnoInizioAttivita.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(testoAnnoInizioAttivita, 1);

	Paragraph testoFatturato = new Paragraph();
	if (tracciatoData.equals(Constants.iLang)) {
	    testoFatturato.add(new Chunk(fatturatoUltimoAnno, docFonts.titoloFont10));
	} else {
	    testoFatturato.add(new Chunk(fatturatoUltimoAnnoFr, docFonts.titoloFont10));
	}
	if (taifTAziendaDto.getFatturato() != null) {
	    testoFatturato.add(new Chunk(twoSpace.concat(ConvertUtil.convertToString(taifTAziendaDto.getFatturato())),
		    docFonts.descrFont10));
	}

	if (tracciatoData.equals(Constants.iLang)) {
	    testoFatturato.add(new Chunk(twoSpace2.concat(euro), docFonts.normalFont));
	} else {
	    testoFatturato.add(new Chunk(twoSpace2.concat(euros), docFonts.normalFont));
	}
	testoFatturato.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(testoFatturato, 1);

	Paragraph testoCategoriImpresa = new Paragraph();
	if (tracciatoData.equals(Constants.iLang)) {
	    testoCategoriImpresa.add(new Chunk(categorieDeImpresa, docFonts.titoloFont10));
	} else {
	    testoCategoriImpresa.add(new Chunk(categorieDeImpresaFr, docFonts.titoloFont10));
	}
	testoCategoriImpresa.add(new Chunk(twoSpace));
	List<TaifRAziendaCategImpresaByIdAziendaDto> categoraImpresa = pdfDbManager
		.getCategoriaImpresaFromId(taifTAziendaDto.getIdAzienda());
	if(categoraImpresa.size()>0) {
    	testoCategoriImpresa.add(new Chunk(
    		twoSpace2.concat(
    			pdfDbManager.getDescrizioneCategoriaImpresa(categoraImpresa.get(0).getIdcategImpresa())),
    		docFonts.descrFont10));
    	if (categoraImpresa.get(0).getIdcategImpresa() == 5) {
    	    testoCategoriImpresa.add(
    		    new Chunk(twoSpace2.concat(categoraImpresa.get(0).getAziendaCategImpresa()), docFonts.descrFont10));
    	}
	}
	testoCategoriImpresa.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(testoCategoriImpresa, 1);

	Paragraph testoSezione = new Paragraph();
	if (tracciatoData.equals(Constants.iLang)) {
	    testoSezione.add(new Chunk(sezione, docFonts.titoloFont10));
	} else {
	    testoSezione.add(new Chunk(sezioneFr, docFonts.titoloFont10));
	}
	for (String flag : fflagList) {
	    testoSezione.add(new Chunk(tenSpace.concat(flag), docFonts.descrFont10));
	    testoSezione.add(new Chunk(twoSpace2));
	}
	testoSezione.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(testoSezione, 1);

	Paragraph testoIscrizioneAltriAlbi = new Paragraph();
	if (tracciatoData.equals(Constants.iLang)) {
	    testoIscrizioneAltriAlbi.add(new Chunk(iscrizioneAltriAlbi, docFonts.titoloFontBold10));
	} else {
	    testoIscrizioneAltriAlbi.add(new Chunk(iscrizioneAltriAlbiFr, docFonts.titoloFontBold10));
	}
	for (TaifTPraticaByIdAziendaDto altri : altriAlbiList) {
	    testoIscrizioneAltriAlbi.add(new Chunk(twoSpace));
	    if (altri.getDenominazioneAltroAlbo() != null) {
		if (tracciatoData.equals(Constants.iLang)) {
		    testoIscrizioneAltriAlbi.add(new Chunk(descrizioneAltroAlbo, docFonts.titoloFont10));
		} else {
		    testoIscrizioneAltriAlbi.add(new Chunk(descrizioneAltroAlboFr, docFonts.titoloFont10));
		}
		testoIscrizioneAltriAlbi
			.add(new Chunk(twoSpace2.concat(altri.getDenominazioneAltroAlbo()), docFonts.descrFont10));
	    }
	    if (altri.getNrAlbo() != null) {
		if (tracciatoData.equals(Constants.iLang)) {
		    testoIscrizioneAltriAlbi.add(new Chunk(forSpace.concat(numeroAlbo), docFonts.titoloFont10));
		} else {
		    testoIscrizioneAltriAlbi.add(new Chunk(forSpace.concat(numeroAlboFr), docFonts.titoloFont10));
		}
		testoIscrizioneAltriAlbi.add(new Chunk(twoSpace2.concat(altri.getNrAlbo()), docFonts.descrFont10));
	    }
	    if (altri.getDataInscrizioneAlbo() != null) {
		if (tracciatoData.equals(Constants.iLang)) {
		    testoIscrizioneAltriAlbi.add(new Chunk(forSpace.concat(dataIscrizione), docFonts.titoloFont10));
		} else {
		    testoIscrizioneAltriAlbi.add(new Chunk(forSpace.concat(dataIscrizioneFr), docFonts.titoloFont10));
		}
		testoIscrizioneAltriAlbi.add(
			new Chunk(twoSpace2.concat(sdf.format(altri.getDataInscrizioneAlbo())), docFonts.descrFont10));
	    }
	    testoIscrizioneAltriAlbi.setAlignment(Element.ALIGN_LEFT);
	}
	pdfUtils.addEmptyLine(testoIscrizioneAltriAlbi, 1);

	Paragraph testoAltreForme = new Paragraph();
	if (tracciatoData.equals(Constants.iLang)) {
	    testoAltreForme.add(new Chunk(partecipazioneFormeOrganizzative, docFonts.titoloFontBold10));
	} else {
	    testoAltreForme.add(new Chunk(partecipazioneFormeOrganizzativeFr, docFonts.titoloFontBold10));
	}
	for (TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto assoc : associazioni) {
	    testoAltreForme.add(new Chunk(twoSpace));
	    if (assoc.getIdAssociazione() != null) {
		// testoAltreForme.add(new Chunk(associazione, docFonts.titoloFont10));
		testoAltreForme.add(new Chunk(pdfDbManager.getDescrizioneAssociazioneImpresa(assoc.getIdAssociazione()),
			docFonts.descrFont10));
	    }
	    if (assoc.getNomeAltraAssociazione() != null && !StringUtils.isEmpty(assoc.getNomeAltraAssociazione())) {
		if (tracciatoData.equals(Constants.iLang)) {
		    testoAltreForme.add(new Chunk(tenSpace.concat(nomeAssociazione), docFonts.titoloFont10));
		} else {
		    testoAltreForme.add(new Chunk(tenSpace.concat(nomeAssociazioneFr), docFonts.titoloFont10));
		}
		testoAltreForme
			.add(new Chunk(twoSpace2.concat(assoc.getNomeAltraAssociazione()), docFonts.descrFont10));
	    }
	}
	testoAltreForme.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(testoAltreForme, 1);

	Paragraph testoCertificazioni = new Paragraph();
	if (tracciatoData.equals(Constants.iLang)) {
	    testoCertificazioni.add(new Chunk(possesoCertificazioni, docFonts.titoloFontBold10));
	} else {
	    testoCertificazioni.add(new Chunk(possesoCertificazioniFr, docFonts.titoloFontBold10));
	}
	for (TaifTCertificazioneFindCertificazioniByIdAziendaDto certificato : certificazioniList) {
	    testoIscrizioneAltriAlbi.add(new Chunk(twoSpace));
	    if (certificato.getTipoCertificazione() != null) {
		if (tracciatoData.equals(Constants.iLang)) {
		    testoCertificazioni.add(new Chunk(twoSpace.concat(tipoCertificato), docFonts.titoloFont10));
		} else {
		    testoCertificazioni.add(new Chunk(twoSpace.concat(tipoCertificatoFr), docFonts.titoloFont10));
		}
		testoCertificazioni
			.add(new Chunk(twoSpace2.concat(certificato.getTipoCertificazione()), docFonts.descrFont10));
	    }
	    if (certificato.getEnteCertificatore() != null) {
		if (tracciatoData.equals(Constants.iLang)) {
		    testoCertificazioni.add(new Chunk(twoSpace2.concat(enteCertificatore), docFonts.titoloFont10));
		} else {
		    testoCertificazioni.add(new Chunk(twoSpace2.concat(enteCertificatoreFr), docFonts.titoloFont10));
		}
		testoCertificazioni
			.add(new Chunk(twoSpace2.concat(certificato.getEnteCertificatore()), docFonts.descrFont10));
	    }
	    if (certificato.getNumeroCertificazione() != null) {
		if (tracciatoData.equals(Constants.iLang)) {
		    testoCertificazioni.add(new Chunk(twoSpace2.concat(numeroCertificato), docFonts.titoloFont10));
		} else {
		    testoCertificazioni.add(new Chunk(twoSpace2.concat(numeroCertificatoFr), docFonts.titoloFont10));
		}
		testoCertificazioni
			.add(new Chunk(twoSpace2.concat(certificato.getNumeroCertificazione()), docFonts.descrFont10));
	    }
	    testoCertificazioni.add(new Chunk(newLine));
	    if (certificato.getAnnoCertificazione() != null) {
		if (tracciatoData.equals(Constants.iLang)) {
		    testoCertificazioni.add(new Chunk(twoSpace2.concat(annoCertificato), docFonts.titoloFont10));
		} else {
		    testoCertificazioni.add(new Chunk(twoSpace2.concat(annoCertificatoFr), docFonts.titoloFont10));
		}
		testoCertificazioni.add(new Chunk(twoSpace2.concat(certificato.getAnnoCertificazione().toString()),
			docFonts.descrFont10));
	    }
	    if (certificato.getDataScadenza() != null) {
		if (tracciatoData.equals(Constants.iLang)) {
		    testoCertificazioni.add(new Chunk(twoSpace2.concat(dataScadenza), docFonts.titoloFont10));
		} else {
		    testoCertificazioni.add(new Chunk(twoSpace2.concat(dataScadenzaFr), docFonts.titoloFont10));
		}
		testoCertificazioni.add(
			new Chunk(twoSpace2.concat(sdf.format(certificato.getDataScadenza())), docFonts.descrFont10));
	    }
	    if (certificato.getAltraCertificazione() != null) {
		if (tracciatoData.equals(Constants.iLang)) {
		    testoCertificazioni.add(new Chunk(twoSpace2.concat(annoCertificato), docFonts.titoloFont10));
		    testoCertificazioni.add(new Chunk(twoSpace2.concat(descrizione), docFonts.titoloFont10));
		} else {
		    testoCertificazioni.add(new Chunk(twoSpace2.concat(annoCertificatoFr), docFonts.titoloFont10));
		    testoCertificazioni.add(new Chunk(twoSpace2.concat(descrizioneFr), docFonts.titoloFont10));
		}
		testoCertificazioni.add(new Chunk(twoSpace2.concat(certificato.getAltraCertificazione().toString()),
			docFonts.descrFont10));
	    }
	    testoCertificazioni.setAlignment(Element.ALIGN_LEFT);
	}
	pdfUtils.addEmptyLine(testoCertificazioni, 1);

	// certificazioniList

	document.add(sezioneTwo);
	document.add(testoAnnoInizioAttivita);
	document.add(testoFatturato);
	document.add(testoCategoriImpresa);
	document.add(testoSezione);
	document.add(testoIscrizioneAltriAlbi);
	document.add(testoAltreForme);
	document.add(testoCertificazioni);
	document.newPage();
	return document;

    }

}
