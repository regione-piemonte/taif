/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.io.IOException;
import java.util.Arrays;
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
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTMezzoByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDFormaGiuridicaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDTipoAttivitaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter;
import it.csi.taif.taifweb.business.dao.util.Constants;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.exception.DbManagerException;

public class SchedaAziendaSezioneCinqueFrancese {

    
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

    public Document addSezioneFiveBodyPage(Document document, TaifTAziendaDto taifTAziendaDto, String tracciatoData)
	    throws DocumentException, IOException, DbManagerException, TaifDTipoAttivitaDaoException,
	    TaifDFormaGiuridicaDaoException {
	
	String macchineMezzi = "Machines ";
	String sezione5 = "FICHE 5 – MACHINES, EQUIPEMENTS ET MOYENS FORESTIERS";
	String tipo = "Type de machine ";
	String annoImmat = "Annee d'immatriculation   ";
	String potenza = "Puissance (Kw)    ";
	String trazione = "Traction   ";
	String noleggio = "Des proprietes   ";
	String macchineSpeciali = "Machines speciales           ";
	String macchineMovTerra = "Machines de terrassement    ";
	String gruaCavo = "Grumier                  ";
	String rimorchiTitolo = "Camion/Remorque                   ";
	String mezziTrasportoTit = "Semi                ";
	
	AziendaVisibleFilter aziendaVisibleFilter = new AziendaVisibleFilter();
	aziendaVisibleFilter.setFlagItaFr(tracciatoData);
	aziendaVisibleFilter.setFlagVisibile(Constants.oneInt);
	aziendaVisibleFilter.setIdAzienda(taifTAziendaDto.getIdAzienda());
	
	FontsForDocuments docFonts= new FontsForDocuments();
	PdfUtils pdfUtils= new PdfUtils();
	
	String tenSpace="          ";
	String twoSpace2="  ";
	String newLine="\n";

	List<Integer> idMacchineSpecialeFrancese = Arrays.asList(26, 27, 28, 29);
	List<Integer> idMacchineTerraFrancese = Arrays.asList(30, 31);
	//List<Integer> idSegherie = Arrays.asList(14, 15, 16, 17);
	//List<Integer> idGru = Arrays.asList(18, 19, 20);
	//List<Integer> idMezziTransp = Arrays.asList(22, 23, 24);
	

	List<TaifTMezzoByIdAziendaDto> allMacchineMezziByAzienda = pdfDbManager.getMacchineMezzi(taifTAziendaDto.getIdAzienda());

	Paragraph sezioneThree = new Paragraph();
	sezioneThree.add(new Chunk(sezione5, docFonts.titoloFont16));
	sezioneThree.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(sezioneThree, 1);

	
	Paragraph maccSpeciali = new Paragraph();
	Paragraph macchineTerra = new Paragraph();
	Paragraph rimorchi = new Paragraph();
	Paragraph gruCavo = new Paragraph();
	Paragraph mezziTrasporto = new Paragraph();
	
	boolean flagSpeciale = false;
	boolean flagTerra = false;
	boolean flagGrumier = false;
	boolean flagRimorchi = false;
	boolean flagSemi = false;
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (idMacchineSpecialeFrancese.contains(macchine.getIdTipoMezzo()))  {
		flagSpeciale = true;
	    }
	    if (idMacchineTerraFrancese.contains(macchine.getIdTipoMezzo()))  {
		flagTerra = true;
	    }
	    if (macchine.getIdTipoMezzo() == 32) {
		flagGrumier = true;
	    }
	    if (macchine.getIdTipoMezzo() == 33) {
		flagRimorchi = true;
	    }
	    if (macchine.getIdTipoMezzo() == 34) {
		flagSemi = true ;
	    }
	}  
	
	Paragraph testoMezzi = new Paragraph();
	testoMezzi.add(new Chunk(macchineMezzi, docFonts.titoloFont12));
	testoMezzi.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(testoMezzi, 1);
	
	if(flagSpeciale) {
	   	maccSpeciali.add(new Chunk(macchineSpeciali, docFonts.descrFont10));
		maccSpeciali.add(new Chunk());
		maccSpeciali.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (idMacchineSpecialeFrancese.contains(macchine.getIdTipoMezzo())) {
		maccSpeciali.add(new Chunk(twoSpace2.concat(tipo), docFonts.titoloFont10));
		maccSpeciali.add(
			new Chunk(twoSpace2.concat(pdfDbManager.getTipoMezzoById(macchine.getIdTipoMezzo())), docFonts.descrFont10));
		maccSpeciali.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		maccSpeciali.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		maccSpeciali.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		maccSpeciali.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		maccSpeciali.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		maccSpeciali.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue())),
			docFonts.descrFont10));
		maccSpeciali.add(new Chunk(newLine));
	    }
	}
	if(flagTerra) {
	    macchineTerra.add(new Chunk(newLine));
	    macchineTerra.add(new Chunk(macchineMovTerra, docFonts.descrFont10));
	    macchineTerra.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (idMacchineTerraFrancese.contains(macchine.getIdTipoMezzo())) {
		macchineTerra.add(new Chunk(twoSpace2.concat(tipo), docFonts.titoloFont10));
		macchineTerra.add(
			new Chunk(twoSpace2.concat(pdfDbManager.getTipoMezzoById(macchine.getIdTipoMezzo())), docFonts.descrFont10));
		macchineTerra.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		macchineTerra.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		macchineTerra.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		macchineTerra.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		macchineTerra.add(new Chunk(tenSpace.concat(trazione), docFonts.titoloFont10));
		if(pdfDbManager.getTipoTrazione(macchine.getIdTipoTrazione()).equals("Nessun dato")) {
		    macchineTerra.add(new Chunk(twoSpace2.concat("pas de données"), docFonts.descrFont10));
		}else {
		    macchineTerra.add(new Chunk(twoSpace2.concat(pdfDbManager.getTipoTrazione(macchine.getIdTipoTrazione())),
				docFonts.descrFont10));
		}
		
		macchineTerra.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		macchineTerra.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue())),
			docFonts.descrFont10));
		macchineTerra.add(new Chunk(newLine));
	    }
	}
	
	if(flagGrumier) {
	    	gruCavo.add(new Chunk(newLine));
		gruCavo.add(new Chunk(gruaCavo, docFonts.descrFont10));
		gruCavo.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (macchine.getIdTipoMezzo() == 32) {
		gruCavo.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		gruCavo.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		gruCavo.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		gruCavo.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		gruCavo.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		gruCavo.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue())),
			docFonts.descrFont10));
		gruCavo.add(new Chunk(newLine));
	    }
	}
	
	if(flagRimorchi) {
	    rimorchi.add(new Chunk(newLine));
	    rimorchi.add(new Chunk(rimorchiTitolo, docFonts.descrFont10));
	    rimorchi.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (macchine.getIdTipoMezzo() == 33) {
		rimorchi.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		rimorchi.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		rimorchi.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		rimorchi.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		rimorchi.add(new Chunk(tenSpace.concat(trazione), docFonts.titoloFont10));
		rimorchi.add(
			new Chunk(twoSpace2.concat(macchine.getIdTipoTrazione().toString()), docFonts.descrFont10));
		rimorchi.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		rimorchi.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue())), docFonts.descrFont10));
		rimorchi.add(new Chunk(newLine));
	    }
	}
	
	if(flagSemi) {
	    	mezziTrasporto.add(new Chunk(newLine));
		mezziTrasporto.add(new Chunk(mezziTrasportoTit, docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (macchine.getIdTipoMezzo() == 34) {
		mezziTrasporto.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		mezziTrasporto.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		mezziTrasporto.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		mezziTrasporto.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue())),
			docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(newLine));
	    }
	}
	document.add(sezioneThree);
	document.add(testoMezzi);
	document.add(maccSpeciali);
	document.add(macchineTerra);
	document.add(gruCavo);
	document.add(rimorchi);
	document.add(mezziTrasporto);
	document.newPage();
	return document;

    }

  
   
}
