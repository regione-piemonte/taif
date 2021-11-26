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

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTStrutturaFindByAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDFormaGiuridicaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDTipoAttivitaDaoException;
import it.csi.taif.taifweb.business.dao.util.Constants;
import it.csi.taif.taifweb.business.manager.db.DbMgr;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.exception.DbManagerException;

public class SchedaAziendaSezioneQuatro {

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

    public Document addSezioneFourBodyPage(Document document, TaifTAziendaDto taifTAziendaDto, String tracciatoData)
	    throws DocumentException, IOException, DbManagerException, TaifDTipoAttivitaDaoException,
	    TaifDFormaGiuridicaDaoException {

	String sezione4 = "Sezione 4 – Dati strutturali       ";
	String struttureCoinvoltee = "Strutture coinvolte nelle attività forestali ";
	String capannone = "Capannone           ";
	String piazzale = "Piazzale di stoccaggio               ";
	String funzione = "Funzione  ";
	String dimensioneCap = "Dimensione (mc)  ";
	String dimensionePia = "Dimensione (mq)  ";
	String annoDiConstuczione = "Anno di costruzione o riattamento ";

	String sezione4Fr = "FICHE 4 – DONNEES STRUCTURELLES       ";
	// String struttureCoinvolteeFr = "En ne se référant qu’aux structures
	// impliquées dans les activités forestières ";
	String capannoneFr = "Hangar           ";
	String piazzaleFr = "Place de stockage               ";
	String funzioneFr = "Fonction   ";
	String dimensioneCapFr = "Dimension totale";
	String dimensionePiaFr = "Taille (mq)  ";
	String annoDiConstuczioneFr = "Année de construction ou de remise en état ";

	SimpleDateFormat sdf = new SimpleDateFormat();
	sdf = new SimpleDateFormat(it.csi.taif.taifweb.util.Constants.FIRMA_FORMAT_DATA);

	FontsForDocuments docFonts = new FontsForDocuments();
	PdfUtils pdfUtils = new PdfUtils();

	String forSpace = "   ";
	String twoSpace = " \n";
	String tenSpace = "          ";
	String twoSpace2 = "  ";
	String newLine = "\n";

	List<TaifTStrutturaFindByAziendaDto> allStruttureByAzienda = pdfDbManager
		.getStrutture(taifTAziendaDto.getIdAzienda());

	Paragraph sezioneThree = new Paragraph();
	if (tracciatoData.equals(Constants.iLang)) {
	    sezioneThree.add(new Chunk(sezione4, docFonts.titoloFont14));
	    sezioneThree.add(new Chunk(newLine));
	    sezioneThree.add(new Chunk(twoSpace));
	    sezioneThree.add(new Chunk(struttureCoinvoltee, docFonts.titoloFont12));
	} else {
	    sezioneThree.add(new Chunk(sezione4Fr, docFonts.titoloFont14));
	    sezioneThree.add(new Chunk(newLine));
	    sezioneThree.add(new Chunk(twoSpace));
	    // sezioneThree.add(new Chunk(struttureCoinvolteeFr, docFonts.titoloFont12));
	}

	sezioneThree.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(sezioneThree, 1);

	Paragraph testoAnnoInizioAttivita = new Paragraph();
	Paragraph capannoneTag = new Paragraph();
	Paragraph piazzaleTag = new Paragraph();
	boolean flagCap = false;
	boolean flagPiazza = false;
	for (TaifTStrutturaFindByAziendaDto struttura : allStruttureByAzienda) {
	    if (struttura.getFunz() != 5 || struttura.getFunz() != 10) {
		flagCap = true;
	    }
	}
	for (TaifTStrutturaFindByAziendaDto struttura : allStruttureByAzienda) {
	    if (struttura.getFunz() == 5 || struttura.getFunz() == 10) {
		flagPiazza = true;
	    }
	}
	if (flagCap) {
	    if (tracciatoData.equals(Constants.iLang)) {
		capannoneTag.add(new Chunk(capannone, docFonts.descrFont12));
	    } else {
		capannoneTag.add(new Chunk(capannoneFr, docFonts.descrFont12));
	    }
	    capannoneTag.add(new Chunk());
	    capannoneTag.add(new Chunk(newLine));
	}
	if (flagPiazza) {
	    piazzaleTag.add(new Chunk(newLine));
	    if (tracciatoData.equals(Constants.iLang)) {
		piazzaleTag.add(new Chunk(piazzale, docFonts.descrFont12));
	    } else {
		piazzaleTag.add(new Chunk(piazzaleFr, docFonts.descrFont12));
	    }
	    piazzaleTag.add(new Chunk());
	    piazzaleTag.add(new Chunk(newLine));
	}
	for (TaifTStrutturaFindByAziendaDto struttura : allStruttureByAzienda) {
	    if (struttura.getFunz() != 5) {
		if (tracciatoData.equals(Constants.iLang)) {
		    capannoneTag.add(new Chunk(twoSpace2.concat(funzione), docFonts.titoloFont10));
		} else {
		    capannoneTag.add(new Chunk(twoSpace2.concat(funzioneFr), docFonts.titoloFont10));
		}
		capannoneTag.add(new Chunk(twoSpace2.concat(pdfDbManager.getFunzioneCapannone(struttura.getFunz())),
			docFonts.descrFont10));
		if (tracciatoData.equals(Constants.iLang)) {
		    capannoneTag.add(new Chunk(tenSpace.concat(dimensioneCap), docFonts.titoloFont10));
		} else {
		    capannoneTag.add(new Chunk(tenSpace.concat(dimensioneCapFr), docFonts.titoloFont10));
		}
		capannoneTag.add(new Chunk(twoSpace2.concat(struttura.getDim().toString()), docFonts.descrFont10));
		if (tracciatoData.equals(Constants.iLang)) {
		    capannoneTag.add(new Chunk(tenSpace.concat(annoDiConstuczione), docFonts.titoloFont10));
		} else {
		    capannoneTag.add(new Chunk(tenSpace.concat(annoDiConstuczioneFr), docFonts.titoloFont10));
		}
		capannoneTag.add(new Chunk(twoSpace2.concat(struttura.getAnno().toString()), docFonts.descrFont10));
		capannoneTag.add(new Chunk(newLine));
	    }
	}

	for (TaifTStrutturaFindByAziendaDto struttura : allStruttureByAzienda) {
	    if (struttura.getFunz() == 5) {
		if (tracciatoData.equals(Constants.iLang)) {
		    piazzaleTag.add(new Chunk(twoSpace2.concat(dimensionePia), docFonts.titoloFont10));
		} else {
		    piazzaleTag.add(new Chunk(twoSpace2.concat(dimensionePiaFr), docFonts.titoloFont10));
		}
		piazzaleTag.add(new Chunk(twoSpace2.concat(struttura.getDim().toString()), docFonts.descrFont10));
		if (tracciatoData.equals(Constants.iLang)) {
		    piazzaleTag.add(new Chunk(tenSpace.concat(annoDiConstuczione), docFonts.titoloFont10));
		} else {
		    piazzaleTag.add(new Chunk(tenSpace.concat(annoDiConstuczioneFr), docFonts.titoloFont10));
		}
		piazzaleTag.add(new Chunk(twoSpace2.concat(struttura.getAnno().toString()), docFonts.descrFont10));
		piazzaleTag.add(new Chunk(newLine));
	    }
	}
	document.add(sezioneThree);
	document.add(testoAnnoInizioAttivita);
	document.add(capannoneTag);
	document.add(piazzaleTag);
	document.newPage();

	return document;
    }

}
