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
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTDpiDpiByAziendaVisibileDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTMezzoByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDFormaGiuridicaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDTipoAttivitaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter;
import it.csi.taif.taifweb.business.dao.util.Constants;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.exception.DbManagerException;

public class SchedaAziendaSezioneCinque {

    
    
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

	String sezione5 = "Sezione 5";
	String attrezzature = "Attrezzature anti infortunistiche – mezzi di protezione individuale (DPI) ";
	String macchineMezzi = "Macchine e mezzi";
	String casco = " 1. Casco forestale           ";
	String scarponi = " 2. Scarponi rinforzati           ";
	String pantaloni = " 3. Pantaloni antitaglio           ";
	String tipologia = "Annotazioni               ";
	String quantita = "Quantita (n) ";
	String data = "Anno di scadenza  ";
	String tipo = "Tipo ";
	String annoImmat = "Anno immatr   ";
	String potenza = "Potenza (kw)    ";
	String portata = "Portata         ";
	String trazione = "Trazione   ";
	String noleggio = "Di proprieta   ";
	String alimentazione = "Alimentazione     ";
	String carello = "Carello           ";
	String trattriceTitolo = "Trattrice                   ";
	String macchineSpeciali = "Macchine speciali           ";
	String macchineMovTerra = "Macchine movimento terra    ";
	String gruaCavo = "Gru a cavo                  ";
	String rimorchiTitolo = "Rimorchi                   ";
	String vericelliTitolo = "Verricelli                   ";
	String pleTitolo = "Piattaforma elevabile - PLE        ";
	String trinciaTitolo = "Trincia forestale              ";
	String segherieTitolo = "Segherie mobili                ";
	String comandoDistanza = "Comando distanza             ";
	String mezziTrasportoTit = "Mezzi trasporto                ";
	String altriMezziTrsp = "Altri mezzi               ";
	String cippatriciTitolo = "Cippatrici                   ";
	String descrizione = "Descrizione  ";
	
	AziendaVisibleFilter aziendaVisibleFilter = new AziendaVisibleFilter();
	aziendaVisibleFilter.setFlagItaFr(tracciatoData);
	aziendaVisibleFilter.setFlagVisibile(Constants.oneInt);
	aziendaVisibleFilter.setIdAzienda(taifTAziendaDto.getIdAzienda());
	
	FontsForDocuments docFonts= new FontsForDocuments();
	PdfUtils pdfUtils= new PdfUtils();
	

	String tenSpace="          ";
	String twoSpace2="  ";
	String newLine="\n";

	List<Integer> idMacchineSpeciale = Arrays.asList(2, 3, 4, 5);
	List<Integer> idMacchineTerra = Arrays.asList(6, 7, 8, 9);
	List<Integer> idSegherie = Arrays.asList(14, 15, 16, 17);
	List<Integer> idGru = Arrays.asList(18, 19, 20);
	List<Integer> idMezziTransp = Arrays.asList(22, 23, 24);
	

	List<TaifTDpiDpiByAziendaVisibileDto> allDispositiviByAzienda = pdfDbManager.getDispositiviProtezione(aziendaVisibleFilter);

	List<TaifTMezzoByIdAziendaDto> allMacchineMezziByAzienda = pdfDbManager.getMacchineMezzi(taifTAziendaDto.getIdAzienda());

	Paragraph sezioneThree = new Paragraph();
	sezioneThree.add(new Chunk(sezione5, docFonts.titoloFont16));
	sezioneThree.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(sezioneThree, 1);

	Paragraph testoAnnoInizioAttivita = new Paragraph();
	testoAnnoInizioAttivita.add(new Chunk(attrezzature, docFonts.titoloFont12));
	testoAnnoInizioAttivita.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(testoAnnoInizioAttivita, 1);

	Paragraph dispositivi = new Paragraph();
	boolean flagCasco = false;
	boolean flagScarponi = false;
	boolean flagPantaloni = false;
	
	for (TaifTDpiDpiByAziendaVisibileDto disposi : allDispositiviByAzienda) {
	    if(disposi.getIdTipoDpi().intValue() == Constants.oneInt) {
		flagCasco = true;
	    }
	    if( disposi.getIdTipoDpi().intValue() == Constants.twoInt) {
		flagScarponi = true;
	    }
	    if( disposi.getIdTipoDpi().intValue() == Constants.threInt) {
		flagPantaloni = true;
	    }
	}
	
	if(flagCasco) {
	    dispositivi.add(new Chunk(casco, docFonts.descrFont10));
	    dispositivi.add(new Chunk(newLine));  
	}
	for (TaifTDpiDpiByAziendaVisibileDto disposi : allDispositiviByAzienda) {
	    if (disposi.getIdTipoDpi().intValue() == Constants.oneInt) {
		
		dispositivi.add(new Chunk(tenSpace.concat(quantita), docFonts.titoloFont10));
		dispositivi.add(new Chunk(twoSpace2.concat(disposi.getQuantita().toString()), docFonts.descrFont10));
		dispositivi.add(new Chunk(tenSpace.concat(data), docFonts.titoloFont10));
		if(disposi.getAnnoScadenza() !=null) {
		    dispositivi
			.add(new Chunk(twoSpace2.concat(disposi.getAnnoScadenza().toString()), docFonts.descrFont10));  
		}
		dispositivi.add(new Chunk(tenSpace.concat(tipologia), docFonts.titoloFont10));
		dispositivi.add(new Chunk(twoSpace2.concat(disposi.getTipologia()), docFonts.descrFont10));
		dispositivi.add(new Chunk(newLine));
	    }
	}
	if(flagScarponi) {
	    	dispositivi.add(new Chunk(newLine));
		dispositivi.add(new Chunk(scarponi, docFonts.descrFont10));
		dispositivi.add(new Chunk());
	}
	for (TaifTDpiDpiByAziendaVisibileDto disposi : allDispositiviByAzienda) {
	    if (disposi.getIdTipoDpi().intValue() == Constants.twoInt) {
		
		dispositivi.add(new Chunk(tenSpace.concat(quantita), docFonts.titoloFont10));
		dispositivi.add(new Chunk(twoSpace2.concat(disposi.getQuantita().toString()), docFonts.descrFont10));
		dispositivi.add(new Chunk(tenSpace.concat(data), docFonts.titoloFont10));
		if(disposi.getAnnoScadenza() !=null) {
		dispositivi
			.add(new Chunk(twoSpace2.concat(disposi.getAnnoScadenza().toString()), docFonts.descrFont10));
		}
		dispositivi.add(new Chunk(tenSpace.concat(tipologia), docFonts.titoloFont10));
		dispositivi.add(new Chunk(twoSpace2.concat(disposi.getTipologia()), docFonts.descrFont10));
		dispositivi.add(new Chunk(newLine));
	    }
	}
	if(flagPantaloni) {
	    	dispositivi.add(new Chunk(newLine));
		dispositivi.add(new Chunk(pantaloni, docFonts.descrFont10));
		dispositivi.add(new Chunk(newLine));
	}
	for (TaifTDpiDpiByAziendaVisibileDto disposi : allDispositiviByAzienda) {
	    if (disposi.getIdTipoDpi().intValue() == Constants.threInt) {
		
		
		dispositivi.add(new Chunk(tenSpace.concat(quantita), docFonts.titoloFont10));
		dispositivi.add(new Chunk(twoSpace2.concat(disposi.getQuantita().toString()), docFonts.descrFont10));
		dispositivi.add(new Chunk(tenSpace.concat(data), docFonts.titoloFont10));
		if(disposi.getAnnoScadenza() !=null) {
		dispositivi
			.add(new Chunk(twoSpace2.concat(disposi.getAnnoScadenza().toString()), docFonts.descrFont10));
		}
		dispositivi.add(new Chunk(tenSpace.concat(tipologia), docFonts.titoloFont10));
		dispositivi.add(new Chunk(twoSpace2.concat(disposi.getTipologia()), docFonts.descrFont10));
		dispositivi.add(new Chunk(newLine));
	    }
	}
	dispositivi.add(new Chunk(newLine));
	dispositivi.add(new Chunk(newLine));
	

	Paragraph trattrice = new Paragraph();
	Paragraph maccSpeciali = new Paragraph();
	Paragraph macchineTerra = new Paragraph();
	Paragraph rimorchi = new Paragraph();
	Paragraph verricelli = new Paragraph();
	Paragraph ple = new Paragraph();
	Paragraph trinciaForestale = new Paragraph();
	Paragraph segherieMobili = new Paragraph();
	Paragraph gruCavo = new Paragraph();
	Paragraph cippatrici = new Paragraph();
	Paragraph mezziTrasporto = new Paragraph();
	boolean flagTattrice = false;
	boolean flagSpeciale = false;
	boolean flagTerra = false;
	boolean flagRimorchi = false;
	boolean flagPle = false;
	boolean flagVericelli = false;
	boolean flagTrincia = false;
	boolean flagSegherie = false;
	boolean flagGru = false;
	boolean flagCippatrici = false;
	boolean flagMezziTrsp = false;
	boolean flagAltri = false;
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (macchine.getIdTipoMezzo() == Constants.oneInt) {
		flagTattrice = true;
	    }
	    if (idMacchineSpeciale.contains(macchine.getIdTipoMezzo()))  {
		flagSpeciale = true;
	    }
	    if (idMacchineTerra.contains(macchine.getIdTipoMezzo()))  {
		flagTerra = true;
	    }
	    if (macchine.getIdTipoMezzo() == Constants.ten) {
		flagRimorchi = true;
	    }
	    if (macchine.getIdTipoMezzo() == 13) {
		flagPle = true;
	    }
	    if (macchine.getIdTipoMezzo() == Constants.eleven) {
		flagVericelli = true;
	    }
	    if (macchine.getIdTipoMezzo() == 12) {
		flagTrincia = true;
	    }
	    if (idSegherie.contains(macchine.getIdTipoMezzo())) {
		flagSegherie = true;
	    }
	    if (idGru.contains(macchine.getIdTipoMezzo())) {
		flagGru = true;
	    }
	    if (macchine.getIdTipoMezzo() == 21) {
		flagCippatrici = true ;
	    }
	    if (idMezziTransp.contains(macchine.getIdTipoMezzo())) {
		flagMezziTrsp = true;
	    }
	    if (macchine.getIdTipoMezzo() == 25) {
		flagAltri = true;
	    }
	}  
	
	Paragraph testoMezzi = new Paragraph();
	testoMezzi.add(new Chunk(macchineMezzi, docFonts.titoloFont12));
	testoMezzi.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(testoMezzi, 1);
	if(flagTattrice) {
		trattrice.add(new Chunk(trattriceTitolo, docFonts.descrFont10));
		trattrice.add(new Chunk());
		trattrice.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (macchine.getIdTipoMezzo() == Constants.oneInt) {
		trattrice.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		trattrice.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		trattrice.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		trattrice.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		trattrice.add(new Chunk(tenSpace.concat(trazione), docFonts.titoloFont10));
		trattrice.add(
			new Chunk(twoSpace2.concat(macchine.getIdTipoTrazione().toString()), docFonts.descrFont10));
		trattrice.add(new Chunk(newLine));
	    }
	}
	if(flagSpeciale) {
	   	maccSpeciali.add(new Chunk(macchineSpeciali, docFonts.descrFont10));
		maccSpeciali.add(new Chunk());
		maccSpeciali.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (idMacchineSpeciale.contains(macchine.getIdTipoMezzo())) {
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
	    macchineTerra.add(new Chunk(macchineMovTerra, docFonts.descrFont10));
	    macchineTerra.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (idMacchineTerra.contains(macchine.getIdTipoMezzo())) {
		macchineTerra.add(new Chunk(twoSpace2.concat(tipo), docFonts.titoloFont10));
		macchineTerra.add(
			new Chunk(twoSpace2.concat(pdfDbManager.getTipoMezzoById(macchine.getIdTipoMezzo())), docFonts.descrFont10));
		macchineTerra.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		macchineTerra.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		macchineTerra.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		macchineTerra.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		macchineTerra.add(new Chunk(tenSpace.concat(trazione), docFonts.titoloFont10));
		macchineTerra.add(new Chunk(twoSpace2.concat(pdfDbManager.getTipoTrazione(macchine.getIdTipoTrazione())),
			docFonts.descrFont10));
		macchineTerra.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		macchineTerra.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue())),
			docFonts.descrFont10));
		macchineTerra.add(new Chunk(newLine));
	    }
	}
	if(flagRimorchi) {
	    rimorchi.add(new Chunk(rimorchiTitolo, docFonts.descrFont10));
	    rimorchi.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (macchine.getIdTipoMezzo() == Constants.ten) {
		rimorchi.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		rimorchi.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		rimorchi.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		rimorchi.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		rimorchi.add(new Chunk(tenSpace.concat(trazione), docFonts.titoloFont10));
		rimorchi.add(
			new Chunk(twoSpace2.concat(macchine.getIdTipoTrazione().toString()), docFonts.descrFont10));
		rimorchi.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		rimorchi.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue()))));
		rimorchi.add(new Chunk(newLine));
	    }
	}
	
	if(flagVericelli) {
	    verricelli.add(new Chunk(vericelliTitolo, docFonts.descrFont10));
	    verricelli.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (macchine.getIdTipoMezzo() == Constants.eleven) {
		
		verricelli.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		verricelli.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		verricelli.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		verricelli.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		verricelli.add(new Chunk(tenSpace.concat(comandoDistanza), docFonts.titoloFont10));
		verricelli.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getComando().intValue())),
			docFonts.descrFont10));
		verricelli.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		verricelli.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue()))));
		verricelli.add(new Chunk(newLine));
	    }
	}

	if(flagPle) {
	    ple.add(new Chunk(pleTitolo, docFonts.descrFont10));
	    ple.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (macchine.getIdTipoMezzo() == 13) {
		ple.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		ple.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		ple.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		ple.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		ple.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		ple.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue()))));
		ple.add(new Chunk(newLine));
	    }
	}

	if(flagTrincia) {
	    trinciaForestale.add(new Chunk(trinciaTitolo, docFonts.descrFont10));
	    trinciaForestale.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (macchine.getIdTipoMezzo() == 12) {
		trinciaForestale.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		trinciaForestale.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		trinciaForestale.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		trinciaForestale
			.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		trinciaForestale.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		trinciaForestale.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue()))));
		trinciaForestale.add(new Chunk(newLine));
	    }
	}
	
	if(flagSegherie) {
	    segherieMobili.add(new Chunk(segherieTitolo, docFonts.descrFont10));
	    segherieMobili.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (idSegherie.contains(macchine.getIdTipoMezzo())) {
		segherieMobili.add(new Chunk(twoSpace2.concat(tipo), docFonts.titoloFont10));
		segherieMobili.add(
			new Chunk(twoSpace2.concat(pdfDbManager.getTipoMezzoById(macchine.getIdTipoMezzo())), docFonts.descrFont10));
		segherieMobili.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		segherieMobili.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		segherieMobili.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		segherieMobili.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		segherieMobili.add(new Chunk(tenSpace.concat(alimentazione), docFonts.titoloFont10));
		segherieMobili
			.add(new Chunk(twoSpace2.concat(pdfDbManager.getTipoAllimentazioneMezzoById(macchine.getIdAlimentazione())),
				docFonts.descrFont10));
		segherieMobili.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		segherieMobili.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue())),
			docFonts.descrFont10));
		segherieMobili.add(new Chunk(newLine));
	    }
	}

	if(flagGru) {
		gruCavo.add(new Chunk(gruaCavo, docFonts.descrFont10));
		gruCavo.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (idGru.contains(macchine.getIdTipoMezzo())) {
		gruCavo.add(new Chunk(twoSpace2.concat(tipo), docFonts.titoloFont10));
		gruCavo.add(
			new Chunk(twoSpace2.concat(pdfDbManager.getTipoMezzoById(macchine.getIdTipoMezzo())), docFonts.descrFont10));
		gruCavo.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		gruCavo.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		gruCavo.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		gruCavo.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		gruCavo.add(new Chunk(tenSpace.concat(portata), docFonts.titoloFont10));
		gruCavo.add(new Chunk(twoSpace2.concat((macchine.getPortata().toString())), docFonts.descrFont10));
		gruCavo.add(new Chunk(tenSpace.concat(carello), docFonts.titoloFont10));
		gruCavo.add(new Chunk(twoSpace2.concat(pdfDbManager.getTipoCarelloById(macchine.getIdTipoCarrel())),
			docFonts.descrFont10));
		gruCavo.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		gruCavo.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue())),
			docFonts.descrFont10));
		gruCavo.add(new Chunk(newLine));
	    }
	}
	if(flagCippatrici) {
	    cippatrici.add(new Chunk(cippatriciTitolo, docFonts.descrFont10));
	    cippatrici.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (macchine.getIdTipoMezzo() == 21) {
		cippatrici.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		cippatrici.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		cippatrici.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		cippatrici.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		cippatrici.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		cippatrici.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue())), docFonts.descrFont10));
		cippatrici.add(new Chunk(newLine));
	    }
	}

	if(flagMezziTrsp) {
		mezziTrasporto.add(new Chunk(mezziTrasportoTit, docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (idMezziTransp.contains(macchine.getIdTipoMezzo())) {
		mezziTrasporto.add(new Chunk(twoSpace2.concat(tipo), docFonts.titoloFont10));
		mezziTrasporto.add(
			new Chunk(twoSpace2.concat(pdfDbManager.getTipoMezzoById(macchine.getIdTipoMezzo())), docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		mezziTrasporto.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		mezziTrasporto.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(tenSpace.concat(alimentazione), docFonts.titoloFont10));
		mezziTrasporto
			.add(new Chunk(twoSpace2.concat(pdfDbManager.getTipoAllimentazioneMezzoById(macchine.getIdAlimentazione())),
				docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		mezziTrasporto.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue())),
			docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(newLine));
	    }
	}
	
	if(flagAltri) {
		mezziTrasporto.add(new Chunk(altriMezziTrsp, docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(newLine));
	}
	for (TaifTMezzoByIdAziendaDto macchine : allMacchineMezziByAzienda) {
	    if (macchine.getIdTipoMezzo() == 25) {
		mezziTrasporto.add(new Chunk(twoSpace2.concat(descrizione), docFonts.titoloFont10));
		mezziTrasporto.add(new Chunk(twoSpace2.concat(macchine.getDescrizioneAltromezzo()), docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(twoSpace2.concat(annoImmat), docFonts.titoloFont10));
		mezziTrasporto.add(new Chunk(twoSpace2.concat(macchine.getAnno().toString()), docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(tenSpace.concat(potenza), docFonts.titoloFont10));
		if(macchine.getPotenza() != null) {
		    mezziTrasporto.add(new Chunk(twoSpace2.concat(macchine.getPotenza().toString()), docFonts.descrFont10));
		}
		mezziTrasporto.add(new Chunk(tenSpace.concat(alimentazione), docFonts.titoloFont10));
		mezziTrasporto
			.add(new Chunk(twoSpace2.concat(pdfDbManager.getTipoAllimentazioneMezzoById(macchine.getIdAlimentazione())),
				docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(tenSpace.concat(noleggio), docFonts.titoloFont10));
		mezziTrasporto.add(new Chunk(twoSpace2.concat(pdfDbManager.getNoleggio(macchine.getNoleggio().intValue())),
			docFonts.descrFont10));
		mezziTrasporto.add(new Chunk(newLine));
	    }
	}


	document.add(sezioneThree);
	document.add(testoAnnoInizioAttivita);
	document.add(dispositivi);
	document.add(testoMezzi);
	document.add(trattrice);
	document.add(maccSpeciali);
	document.add(macchineTerra);
	document.add(rimorchi);
	document.add(verricelli);
	document.add(ple);
	document.add(trinciaForestale);
	document.add(segherieMobili);
	document.add(gruCavo);
	document.add(cippatrici);
	document.add(mezziTrasporto);
	document.newPage();
	return document;

    }

   

}
