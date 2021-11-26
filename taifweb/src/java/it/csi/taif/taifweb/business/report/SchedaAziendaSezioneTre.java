/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAttivDetMaterialeByIdAttivitaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaDettByAttivitaProgressivoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaDettByFilterAttivitaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCommercializzazioneByAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTLavoroPaByAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDFormaGiuridicaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDTipoAttivitaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.exception.DbManagerException;

public class SchedaAziendaSezioneTre {

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
	    List<TaifTLavoroPaByAziendaDto> lavoriPa, List<TaifTCommercializzazioneByAziendaDto> commLegname,
	    String tracciatoData) throws DocumentException, IOException, DbManagerException,
	    TaifDTipoAttivitaDaoException, TaifDFormaGiuridicaDaoException {

	String sezione3 = "Sezione 3 – Attività svolte nell'ultimo anno  ";
	String attivitaSvolte = "Attività svolte ";
	String inRegione = "In Regione: ";
	String totaleVolumiTagliUtilizzazione = "Totale volumi tagli di utilizzazione ";
	String unitaMisura = "Unita di misura ";
	String contoTerzi = "Di cui per conto terzi (%) :";
	String totaliVolumiTagliPiopeti = "Totale volumi taglio pioppeti        ";
	String totaliVolumiTagliIntercalari = "Totale volumi tagli intercalari      ";
	String totaliVolumiTagliIntercalariF = "Totale volumi tagli intercalari     ";
	String fuoriRegione = "Fuori Regione ";
	String ettariRealizzati = "Ettari realizzati       ";
	String realizzazioni = "Realizzazione (Km)       ";
	String manutenzione = "Manutenzione (Km)       ";

	String tipoVivaistica = "Tipo  ";
	String pioppeti = "Pioppeti";
	String conduzione = "Conduzione       ";
	String altro = "Altro      ";
	String descrizione1 = "Descrizione altro ";
	String realizzazione1 = "Realizzazione (ha) ";
	String manutenzione1 = "Manutenzione (ha)  ";
	String conduzione1 = "Conduzione (ha) ";
	String pubblicaAmministrazione = "Quadro lavori per la pubblica amministrazione nell'ultimo anno";
	String commercializzazione = "Quadro commercializzazione legname e assortimenti trattati nell'ultimo anno";
	String commitente = "Commitente ";
	String oggetto = "Oggetto degli interventi";
	String importo = "Importo compressivo dei lavori eseguiti IVA esclusa";
	String specie = "Specie";
	String venduto = "Venduto ";
	String unitaMisuraComm = "UdM ";
	String destinazione = "Destinazione ";
	String provenienza = "Provenienza";
	String assortimento = "Assortimento";
	String ta = "T/A";

	FontsForDocuments docFonts = new FontsForDocuments();
	PdfUtils pdfUtils = new PdfUtils();

	String forSpace = "   ";
	String twoSpace = " \n";
	String tenSpace = "          ";
	String twoSpace2 = "  ";
	String newLine = "\n";

	AziendaVisibleFilter aziendaVisibleFilter = new AziendaVisibleFilter();
	aziendaVisibleFilter.setFlagItaFr(tracciatoData);
	aziendaVisibleFilter.setIdAzienda(taifTAziendaDto.getIdAzienda());

	List<TaifTAttivitaSvoltaByIdAziendaDto> attivitaSvolteList = pdfDbManager
		.getAttivitaSvolte(taifTAziendaDto.getIdAzienda());

	List<Integer> progressivoList = Arrays.asList(1, 2, 3);
	List<Integer> progressivoListFuori = Arrays.asList(4, 5, 6);

	Paragraph sezioneThree = new Paragraph();
	sezioneThree.add(new Chunk(sezione3, docFonts.titoloFont14));
	sezioneThree.setAlignment(Element.ALIGN_LEFT);
	pdfUtils.addEmptyLine(sezioneThree, 1);

	Paragraph testoAnnoInizioAttivita = new Paragraph();
	testoAnnoInizioAttivita.add(new Chunk(attivitaSvolte, docFonts.titoloFont12));
	testoAnnoInizioAttivita.setAlignment(Element.ALIGN_LEFT);
	// pdfUtils.addEmptyLine(testoAnnoInizioAttivita, 1);
	boolean flagFuori = false;
	boolean flagReg = false;
	Paragraph attSvolta = new Paragraph();
	Paragraph attSvoltaF = new Paragraph();
	Paragraph attSvolta2 = new Paragraph();
	Paragraph attSvolta3 = new Paragraph();
	Paragraph attSvolta4 = new Paragraph();
	Paragraph attSvolta5 = new Paragraph();
	Paragraph attSvolta6 = new Paragraph();
	Paragraph attSvolta7 = new Paragraph();
	Paragraph attSvolta8 = new Paragraph();
	Paragraph attSvolta9 = new Paragraph();
	Paragraph pubblicaAmm = new Paragraph();
	Paragraph commercial = new Paragraph();
	for (TaifTAttivitaSvoltaByIdAziendaDto attivitaSvolta : attivitaSvolteList) {
	    List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> attivitaSvolteDettaglioList = pdfDbManager
		    .getAttivitaSvolteDettaglio(attivitaSvolta.getId());
	    if (attivitaSvolta.getIdTipoAttivita() == 1) {
		attSvolta.add(new Chunk(newLine));
		attSvolta.add(new Chunk(attivitaSvolta.getTipoAttivita(), docFonts.titoloFont10));
		attSvolta.add(new Chunk(twoSpace2.concat("(")));
		attSvolta.add(new Chunk(attivitaSvolta.getFatturato().toString(), docFonts.descrFont12));
		attSvolta.add(new Chunk((" %)")));
		for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaSvolteDett : attivitaSvolteDettaglioList) {
		    if (progressivoList.contains(attivitaSvolteDett.getProgressivo())) {
			flagReg = true;
		    }
		}
		if (flagReg) {
		    attSvolta.add(new Chunk(twoSpace.concat(inRegione), docFonts.descrFont10));
		    attSvolta.add(new Chunk(newLine));
		}
		for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaSvolteDett : attivitaSvolteDettaglioList) {
		    // in regione
		    if (progressivoList.contains(attivitaSvolteDett.getProgressivo())) {

			if (attivitaSvolteDett.getProgressivo() == 1) {

			    attSvolta.add(
				    new Chunk(twoSpace2.concat(totaleVolumiTagliUtilizzazione), docFonts.titoloFont10));
			    attSvolta.add(new Chunk(twoSpace2.concat(attivitaSvolteDett.getVal1().toString()),
				    docFonts.descrFont10));
			    attSvolta.add(new Chunk(
				    twoSpace2.concat(pdfDbManager.getUnitaMisura(attivitaSvolteDett.getUnitaMisura())),
				    docFonts.descrFont10));
			    attSvolta.add(new Chunk(forSpace.concat(contoTerzi), docFonts.titoloFont10));
			    attSvolta.add(new Chunk(twoSpace2.concat(attivitaSvolteDett.getPercent().toString()),
				    docFonts.descrFont10));
			    attSvolta.add(new Chunk(newLine));
			}
			if (attivitaSvolteDett.getProgressivo() == 2) {
			    attSvolta.add(new Chunk(twoSpace2.concat(totaliVolumiTagliPiopeti), docFonts.titoloFont10));
			    attSvolta.add(new Chunk(twoSpace2.concat(attivitaSvolteDett.getVal1().toString()),
				    docFonts.descrFont10));
			    attSvolta.add(new Chunk(
				    twoSpace2.concat(pdfDbManager.getUnitaMisura(attivitaSvolteDett.getUnitaMisura())),
				    docFonts.descrFont10));
			    attSvolta.add(new Chunk(forSpace.concat(contoTerzi), docFonts.titoloFont10));
			    attSvolta.add(new Chunk(twoSpace2.concat(attivitaSvolteDett.getPercent().toString()),
				    docFonts.descrFont10));
			    attSvolta.add(new Chunk(newLine));
			}
			if (attivitaSvolteDett.getProgressivo() == 3) {
			    attSvolta.add(
				    new Chunk(twoSpace2.concat(totaliVolumiTagliIntercalari), docFonts.titoloFont10));
			    attSvolta.add(new Chunk(twoSpace2.concat(attivitaSvolteDett.getVal1().toString()),
				    docFonts.descrFont10));
			    attSvolta.add(new Chunk(
				    twoSpace2.concat(pdfDbManager.getUnitaMisura(attivitaSvolteDett.getUnitaMisura())),
				    docFonts.descrFont10));
			    attSvolta.add(new Chunk(forSpace.concat(contoTerzi), docFonts.titoloFont10));
			    attSvolta.add(new Chunk(twoSpace2.concat(attivitaSvolteDett.getPercent().toString()),
				    docFonts.descrFont10));
			    attSvolta.add(new Chunk(newLine));
			}

		    }
		}
		for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaSvolteDett1 : attivitaSvolteDettaglioList) {
		    if (progressivoListFuori.contains(attivitaSvolteDett1.getProgressivo())) {
			flagFuori = true;
		    }
		}
		if (flagFuori) {
		    attSvoltaF.add(new Chunk(twoSpace.concat(fuoriRegione), docFonts.descrFont10));
		    attSvoltaF.add(new Chunk(newLine));
		}
		for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaSvolteDett1 : attivitaSvolteDettaglioList) {
		    if (progressivoListFuori.contains(attivitaSvolteDett1.getProgressivo())) {
			if (attivitaSvolteDett1.getProgressivo() == 4) {
			    attSvoltaF.add(
				    new Chunk(twoSpace2.concat(totaleVolumiTagliUtilizzazione), docFonts.titoloFont10));
			    attSvoltaF.add(new Chunk(twoSpace2.concat(attivitaSvolteDett1.getVal1().toString()),
				    docFonts.descrFont10));
			    attSvoltaF.add(new Chunk(
				    twoSpace2.concat(pdfDbManager.getUnitaMisura(attivitaSvolteDett1.getUnitaMisura())),
				    docFonts.descrFont10));
			    attSvoltaF.add(new Chunk(forSpace.concat(contoTerzi), docFonts.titoloFont10));
			    attSvoltaF.add(new Chunk(twoSpace2.concat(attivitaSvolteDett1.getPercent().toString()),
				    docFonts.descrFont10));
			    attSvoltaF.add(new Chunk(newLine));
			}
			if (attivitaSvolteDett1.getProgressivo() == 5) {
			    attSvoltaF
				    .add(new Chunk(twoSpace2.concat(totaliVolumiTagliPiopeti), docFonts.titoloFont10));
			    attSvoltaF.add(new Chunk(twoSpace2.concat(attivitaSvolteDett1.getVal1().toString()),
				    docFonts.descrFont10));
			    attSvoltaF.add(new Chunk(
				    twoSpace2.concat(pdfDbManager.getUnitaMisura(attivitaSvolteDett1.getUnitaMisura())),
				    docFonts.descrFont10));
			    attSvoltaF.add(new Chunk(forSpace.concat(contoTerzi), docFonts.titoloFont10));
			    attSvoltaF.add(new Chunk(twoSpace2.concat(attivitaSvolteDett1.getPercent().toString()),
				    docFonts.descrFont10));
			    attSvoltaF.add(new Chunk(newLine));
			}
			if (attivitaSvolteDett1.getProgressivo() == 6) {
			    attSvoltaF.add(
				    new Chunk(twoSpace2.concat(totaliVolumiTagliIntercalariF), docFonts.titoloFont10));
			    attSvoltaF.add(new Chunk(twoSpace2.concat(attivitaSvolteDett1.getVal1().toString()),
				    docFonts.descrFont10));
			    attSvoltaF.add(new Chunk(
				    twoSpace2.concat(pdfDbManager.getUnitaMisura(attivitaSvolteDett1.getUnitaMisura())),
				    docFonts.descrFont10));
			    attSvoltaF.add(new Chunk(forSpace.concat(contoTerzi), docFonts.titoloFont10));
			    attSvoltaF.add(new Chunk(twoSpace2.concat(attivitaSvolteDett1.getPercent().toString()),
				    docFonts.descrFont10));
			    attSvoltaF.add(new Chunk(newLine));
			}
		    }
		}
	    }
	    if (attivitaSvolta.getIdTipoAttivita() == 2) {
		attSvolta2.add(new Chunk(newLine));
		attSvolta2.add(new Chunk(attivitaSvolta.getTipoAttivita(), docFonts.titoloFont10));
		attSvolta2.add(new Chunk(twoSpace2.concat("(")));
		attSvolta2.add(new Chunk(attivitaSvolta.getFatturato().toString(), docFonts.descrFont12));
		attSvolta2.add(new Chunk((" %)")));
		for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaSvolteDett : attivitaSvolteDettaglioList) {
		    attSvolta2.add(new Chunk(newLine));
		    attSvolta2.add(new Chunk(twoSpace2.concat(ettariRealizzati), docFonts.titoloFont10));
		    attSvolta2.add(
			    new Chunk(twoSpace2.concat(attivitaSvolteDett.getVal1().toString()), docFonts.descrFont10));
		    attSvolta2.add(new Chunk(
			    twoSpace2.concat(pdfDbManager.getUnitaMisura(attivitaSvolteDett.getUnitaMisura())),
			    docFonts.descrFont10));
		    // attSvolta2.add(new Chunk(twoSpace2.concat(contoTerzi),
		    // docFonts.titoloFont10));
		    // attSvolta2.add(new
		    // Chunk(twoSpace2.concat(attivitaSvolteDett.getPercent().toString()),
		    // attSvolta2.add(new Chunk(twoSpace2.concat(""), docFonts.descrFont10));
		    attSvolta2.add(new Chunk(newLine));
		}
	    }
	    if (attivitaSvolta.getIdTipoAttivita() == 3) {
		attSvolta3.add(new Chunk(newLine));
		attSvolta3.add(new Chunk(attivitaSvolta.getTipoAttivita(), docFonts.titoloFont10));
		attSvolta3.add(new Chunk(twoSpace2.concat("(")));
		attSvolta3.add(new Chunk(attivitaSvolta.getFatturato().toString(), docFonts.descrFont12));
		attSvolta3.add(new Chunk((" %)")));
		for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaSvolteDett : attivitaSvolteDettaglioList) {
		    attSvolta3.add(new Chunk(newLine));
		    attSvolta3.add(new Chunk(twoSpace2.concat(realizzazioni), docFonts.titoloFont10));
		    attSvolta3.add(
			    new Chunk(twoSpace2.concat(attivitaSvolteDett.getVal1().toString()), docFonts.descrFont10));
		    attSvolta3.add(new Chunk(
			    twoSpace2.concat(pdfDbManager.getUnitaMisura(attivitaSvolteDett.getUnitaMisura())),
			    docFonts.descrFont10));
		    attSvolta3.add(new Chunk(newLine));
		    attSvolta3.add(new Chunk(twoSpace2.concat(manutenzione), docFonts.titoloFont10));
		    attSvolta3.add(
			    new Chunk(twoSpace2.concat(attivitaSvolteDett.getVal1().toString()), docFonts.descrFont10));
		    attSvolta3.add(new Chunk(
			    twoSpace2.concat(pdfDbManager.getUnitaMisura(attivitaSvolteDett.getUnitaMisura())),
			    docFonts.descrFont10));

		}
	    }

	    if (attivitaSvolta.getIdTipoAttivita() == 4) {
		attSvolta4.add(new Chunk(newLine));
		attSvolta4.add(new Chunk(attivitaSvolta.getTipoAttivita(), docFonts.titoloFont10));
		attSvolta4.add(new Chunk(twoSpace2.concat("(")));
		attSvolta4.add(new Chunk(attivitaSvolta.getFatturato().toString(), docFonts.descrFont12));
		attSvolta4.add(new Chunk((" %)")));
		for (TaifTAttivitaSvoltaDettByFilterAttivitaDto attivitaSvolteDett : attivitaSvolteDettaglioList) {
		    List<TaifRAttivDetMaterialeByIdAttivitaDto> vivaisticaMateriale = pdfDbManager
			    .getMaterialeVivaistica(attivitaSvolteDett.getId());
		    for (TaifRAttivDetMaterialeByIdAttivitaDto material : vivaisticaMateriale) {
			attSvolta4.add(new Chunk(newLine));
			// attSvolta4.add(new Chunk(twoSpace2.concat(tipoVivaistica),
			// docFonts.titoloFont10));
			attSvolta4.add(
				new Chunk(twoSpace2.concat(pdfDbManager.getMaterialePerId(material.getIdMateriale())),
					docFonts.descrFont10));
			if (material.getMateriale() != null) {
			    // attSvolta4.add(new Chunk(twoSpace2.concat(note), docFonts.titoloFont10));
			    attSvolta4.add(new Chunk(twoSpace2.concat(":"), docFonts.titoloFont10));
			    attSvolta4.add(new Chunk(twoSpace2.concat(material.getMateriale()), docFonts.descrFont10));
			}
		    }
		}
	    }
	    List<TaifTAttivitaSvoltaDettByAttivitaProgressivoDto> attivitaMaterialeList = pdfDbManager
		    .getAttivitaDettaglioMateriale(attivitaSvolta.getId());
	    if (attivitaSvolta.getIdTipoAttivita() == 5) {
		attSvolta5.add(new Chunk(newLine));
		attSvolta5.add(new Chunk(attivitaSvolta.getTipoAttivita(), docFonts.titoloFont10));
		attSvolta5.add(new Chunk(twoSpace2.concat("(")));
		attSvolta5.add(new Chunk(attivitaSvolta.getFatturato().toString(), docFonts.descrFont12));
		attSvolta5.add(new Chunk((" %)")));
		for (TaifTAttivitaSvoltaDettByAttivitaProgressivoDto attivitaSvolteDett : attivitaMaterialeList) {
		    attSvolta5.add(new Chunk(newLine));
		    attSvolta5.add(new Chunk(twoSpace2.concat(tipoVivaistica), docFonts.titoloFont10));
		    attSvolta5.add(new Chunk(
			    twoSpace2.concat(pdfDbManager.getMaterialePerId(attivitaSvolteDett.getIdMateriale())),
			    docFonts.descrFont10));

		    if (attivitaSvolteDett.getIdMateriale() != null) {
			attSvolta5.add(new Chunk(twoSpace2.concat(descrizione1), docFonts.titoloFont10));
			attSvolta5.add(new Chunk(twoSpace2.concat(attivitaSvolteDett.getAltroMateriale()),
				docFonts.descrFont10));
		    }

		    attSvolta5.add(new Chunk(twoSpace2.concat(realizzazione1), docFonts.titoloFont10));
		    attSvolta5.add(new Chunk(twoSpace2.concat(attivitaSvolteDett.getValore1().toString()),
			    docFonts.descrFont10));

		    attSvolta5.add(new Chunk(twoSpace2.concat(manutenzione1), docFonts.titoloFont10));
		    attSvolta5.add(new Chunk(twoSpace2.concat(attivitaSvolteDett.getValore2().toString()),
			    docFonts.descrFont10));

		    attSvolta5.add(new Chunk(twoSpace2.concat(conduzione1), docFonts.titoloFont10));
		    attSvolta5.add(new Chunk(twoSpace2.concat(attivitaSvolteDett.getValore3().toString()),
			    docFonts.descrFont10));
		}

		// }
	    }

	    if (attivitaSvolta.getIdTipoAttivita() == 6) {
		attSvolta6.add(new Chunk(newLine));
		attSvolta6.add(new Chunk(attivitaSvolta.getTipoAttivita(), docFonts.titoloFont10));
		attSvolta6.add(new Chunk(twoSpace2.concat("(")));
		attSvolta6.add(new Chunk(attivitaSvolta.getFatturato().toString(), docFonts.descrFont12));
		attSvolta6.add(new Chunk((" %)")));
	    }
	    if (attivitaSvolta.getIdTipoAttivita() == 7) {
		attSvolta7.add(new Chunk(newLine));
		attSvolta7.add(new Chunk(attivitaSvolta.getTipoAttivita(), docFonts.titoloFont10));
		attSvolta7.add(new Chunk(twoSpace2.concat("(")));
		attSvolta7.add(new Chunk(attivitaSvolta.getFatturato().toString(), docFonts.descrFont12));
		attSvolta7.add(new Chunk((" %)")));
	    }
	    if (attivitaSvolta.getIdTipoAttivita() == 8) {
		attSvolta8.add(new Chunk(newLine));
		attSvolta8.add(new Chunk(attivitaSvolta.getTipoAttivita(), docFonts.titoloFont10));
		attSvolta8.add(new Chunk(twoSpace2.concat("(")));
		attSvolta8.add(new Chunk(attivitaSvolta.getFatturato().toString(), docFonts.descrFont12));
		attSvolta8.add(new Chunk((" %)")));
		//attSvolta8.add(new Chunk(twoSpace2.concat(altro), docFonts.titoloFont10));
		//attSvolta8.add(new Chunk(twoSpace2.concat(attivitaSvolta.getAltre()), docFonts.descrFont10));
	    }
	    if (attivitaSvolta.getIdTipoAttivita() == 9) {
		attSvolta9.add(new Chunk(newLine));
		attSvolta9.add(new Chunk(attivitaSvolta.getTipoAttivita(), docFonts.titoloFont10));
		attSvolta9.add(new Chunk(twoSpace2.concat("(")));
		attSvolta9.add(new Chunk(attivitaSvolta.getFatturato().toString(), docFonts.descrFont12));
		attSvolta9.add(new Chunk((" %)")));
		attSvolta9.add(new Chunk(twoSpace2.concat(altro), docFonts.titoloFont10));
		attSvolta9.add(new Chunk(twoSpace2.concat(attivitaSvolta.getAltre()), docFonts.descrFont10));
	    }
	}

	// lavoriPa
	if (!lavoriPa.isEmpty()) {
	    pubblicaAmm.add(new Chunk(newLine));
	    pubblicaAmm.add(new Chunk(pubblicaAmministrazione, docFonts.titoloFont12));
	    pubblicaAmm.add(new Chunk(newLine));
	}
	for (TaifTLavoroPaByAziendaDto lavoriPub : lavoriPa) {
	    pubblicaAmm.add(new Chunk(newLine));
	    pubblicaAmm.add(new Chunk(twoSpace2.concat(commitente), docFonts.titoloFont10));
	    pubblicaAmm.add(new Chunk(twoSpace2.concat(lavoriPub.getCommit()), docFonts.descrFont10));
	    pubblicaAmm.add(new Chunk(tenSpace.concat(oggetto), docFonts.titoloFont10));
	    pubblicaAmm.add(new Chunk(twoSpace2.concat(lavoriPub.getTipoLavoro()), docFonts.descrFont10));
	    pubblicaAmm.add(new Chunk(newLine));
	    pubblicaAmm.add(new Chunk(tenSpace.concat(importo), docFonts.titoloFont10));
	    pubblicaAmm.add(new Chunk(twoSpace2.concat(lavoriPub.getImporto().toString()), docFonts.descrFont10));
	    pubblicaAmm.add(new Chunk(newLine));
	}

	// comm
	if (!commLegname.isEmpty()) {
	    commercial.add(new Chunk(newLine));
	    commercial.add(new Chunk(commercializzazione, docFonts.titoloFont12));
	    commercial.add(new Chunk(newLine));
	}
	for (TaifTCommercializzazioneByAziendaDto comm : commLegname) {
	    commercial.add(new Chunk(newLine));
	    commercial.add(new Chunk(twoSpace2.concat(specie), docFonts.titoloFont10));
	    commercial.add(new Chunk(
		    twoSpace2.concat(pdfDbManager.getSpecieCommercializzata(comm.getIdSpecie(), tracciatoData)),
		    docFonts.descrFont10));
	    commercial.add(new Chunk(tenSpace));

	    commercial.add(new Chunk(twoSpace2.concat(provenienza), docFonts.titoloFont10));
	    commercial.add(new Chunk(twoSpace2.concat(pdfDbManager.getProvDestinazione(comm.getIdProvenienza())),
		    docFonts.descrFont10));
	    commercial.add(new Chunk(tenSpace));

	    commercial.add(new Chunk(twoSpace2.concat(assortimento), docFonts.titoloFont10));
	    commercial.add(new Chunk(twoSpace2.concat(pdfDbManager.getAssortimento(comm.getIdAssortimento())),
		    docFonts.descrFont10));
	    commercial.add(new Chunk(twoSpace2.concat(ta), docFonts.titoloFont10));
	    //commercial.add(new Chunk(twoSpace2.concat(comm.getFlgTagliato()), docFonts.descrFont10));
	    commercial.add(new Chunk(tenSpace));
	    commercial.add(new Chunk(newLine));
	    commercial.add(new Chunk(forSpace.concat(venduto), docFonts.titoloFont10));
	    commercial.add(new Chunk(twoSpace2.concat(comm.getVendutoMedio().toString()), docFonts.descrFont10));
	    commercial.add(new Chunk(tenSpace));
	    commercial.add(new Chunk(twoSpace2.concat(unitaMisuraComm), docFonts.titoloFont10));
	    commercial.add(new Chunk(twoSpace2.concat(pdfDbManager.getUnitaMisura(comm.getIdUnMis()).toString()),
		    docFonts.descrFont10));
	    commercial.add(new Chunk(tenSpace));
	    commercial.add(new Chunk(twoSpace2.concat(destinazione), docFonts.titoloFont10));
	    commercial.add(new Chunk(pdfDbManager.getProvDestinazione(comm.getIdDestinazione()), docFonts.descrFont10));
	    pubblicaAmm.add(new Chunk(newLine));
	}

	document.add(sezioneThree);
	document.add(testoAnnoInizioAttivita);
	document.add(attSvolta);
	document.add(attSvoltaF);
	document.add(attSvolta2);
	document.add(attSvolta3);
	document.add(attSvolta4);
	document.add(attSvolta5);
	document.add(attSvolta6);
	document.add(attSvolta7);
	document.add(attSvolta8);
	document.add(attSvolta9);
	document.add(pubblicaAmm);
	document.add(commercial);
	document.newPage();
    }

}
