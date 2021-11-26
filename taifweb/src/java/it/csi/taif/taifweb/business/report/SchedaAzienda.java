/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.pdf.PdfWriter;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRPersonaAziendaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCommercializzazioneByAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTLavoroPaByAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTSedeAziendaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDFormaGiuridicaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDTipoAttivitaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.filter.LavoroPaFilter;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.db.DbMgr;
import it.csi.taif.taifweb.business.manager.message.Message;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.service.integration.svista.Comune;
import it.csi.taif.taifweb.util.service.integration.svista.Provincia;

public class SchedaAzienda {
	
	private static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".business");

	@Autowired
	private DbMgr dbMgr;

	@Autowired
	private TaifMgr taifMgr;

	@Autowired
	private SchedaAziendaSezioneCinque schedaAziendaSezioneCinque;

	@Autowired
	private SchedaAziendaSezioneQuatro schedaAziendaSezioneQuatro;

	@Autowired
	private SchedaAziendaSezioneTre schedaAziendaSezioneTre;

	@Autowired
	private SchedaAziendaSezioneDue schedaAziendaSezioneDue;

	@Autowired
	private SchedaAziendaSezioneUno schedaAziendaSezioneUno;

	@Autowired
	private SchedaAziendaSezioneSei schedaAziendaSezioneSei;
	
	@Autowired
	private SchedaAziendaSezioneCinqueFrancese schedaAziendaSezioneCinqueFrancese;
	
	@Autowired
	private SchedaAziendaSezioneSeiFrancese schedaAziendaSezioneSeiFrancese;
	

	@Autowired
	private SchedaAziendaSezioneTreFrancese schedaAziendaSezioneTreFrancese;
	
	@Autowired
	private LavoroPaFilter lavoroPaFilter;
	

	FontsForDocuments docFonts = new FontsForDocuments();
	PdfUtils pdfUtils = new PdfUtils();

	String forSpace = "   ";
	String twoSpace = " \n";
	String tenSpace = "          ";
	String twoSpace2 = "  ";
	String newLine = "\n";

	public ByteArrayOutputStream createPdf(TaifTAziendaDto taifTAziendaDto, String comuneSedeLegale,
			String provinciaSedeLegale, List<TaifTSedeAziendaByIdAziendaDto> sedeAzienda,
			List<TaifTPraticaByIdAziendaDto> pratichePerAzienda,
			List<TaifRPersonaAziendaByIdAziendaDto> listPersonePerIdAzienda,
			List<TaifTLavoroPaByAziendaDto> lavoriPa, List<TaifTCommercializzazioneByAziendaDto> commLegname, String tracciatoData)
			throws DocumentException, IOException, TaifDTipoAttivitaDaoException,
			TaifDFormaGiuridicaDaoException, ManagerException {
	
		
		LOG.debug("[SchedaAzienda::createPdf] BEGIN");
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
		writer.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO);

		document.setPageSize(PageSize.A4);
		document.setMargins(36, 36, 90, 70);
		document.open();

		schedaAziendaSezioneUno.addSezioneOneBodyPage(document, taifTAziendaDto, comuneSedeLegale, provinciaSedeLegale,
				sedeAzienda, pratichePerAzienda, listPersonePerIdAzienda, tracciatoData);
		schedaAziendaSezioneDue.addSezioneTwoBodyPage(document, taifTAziendaDto, pratichePerAzienda, tracciatoData);
		if(tracciatoData.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
		    schedaAziendaSezioneTre.addSezioneThreeBodyPage(document, taifTAziendaDto,lavoriPa,commLegname, tracciatoData);
		}else {
		    schedaAziendaSezioneTreFrancese.addSezioneThreeBodyPage(document, taifTAziendaDto,commLegname, tracciatoData); 
		}
		schedaAziendaSezioneQuatro.addSezioneFourBodyPage(document, taifTAziendaDto, tracciatoData);
		if(tracciatoData.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
		    schedaAziendaSezioneCinque.addSezioneFiveBodyPage(document, taifTAziendaDto, tracciatoData);
		    schedaAziendaSezioneSei.addSezioneSixBodyPage(document, taifTAziendaDto, tracciatoData);
		}else {
		    schedaAziendaSezioneCinqueFrancese.addSezioneFiveBodyPage(document, taifTAziendaDto, tracciatoData);
		    schedaAziendaSezioneSeiFrancese.addSezioneSixBodyPage(document, taifTAziendaDto, tracciatoData);
		}
	
		document.close();

		LOG.debug("[SchedaAzienda::createPdf] END");
		byteArrayOutputStream.close();
		return byteArrayOutputStream;

	}

	public ByteArrayOutputStream makeSchedaAziendaPdf(int idAzienda, String tracciatoData) throws ManagerException {
		LOG.debug("[SchedaAzienda::makeSchedaAziendaPdf] BEGIN");
		try {

			TaifTAziendaDto taifTAziendaDto = dbMgr.getAziendaById(idAzienda);
			List<TaifTPraticaByIdAziendaDto> pratichePerAzienda = dbMgr.pratichePerAzienda(idAzienda);

//			List<TaifTPersonaByIdAziendaDto> listPersonePerIdAzienda = dbMgr.getAllPersonePerIdAzienda(idAzienda);

			List<TaifRPersonaAziendaByIdAziendaDto> listPersoneAziendaPerIdAzienda = dbMgr
					.getPersonePerIdAzienda(idAzienda);

			List<TaifTSedeAziendaByIdAziendaDto> sedeAzienda = dbMgr.getSedePerIdAzienda(idAzienda);

			TaifTSedeAziendaByIdAziendaDto sedeLegale = dbMgr.getSedeLegalePerIdAzienda(idAzienda);
			
			String comuneSedeLegale = "";
			String provinciaSedeLegale = "";
			if(tracciatoData.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
				Comune c = taifMgr.getComuneByIstat(sedeLegale.getIstatComune());
				comuneSedeLegale = c.getNome();
				Provincia p = taifMgr.getProvinciaByIstat(sedeLegale.getIstatComune());
				provinciaSedeLegale = p.getNome();
			}
			else {
				comuneSedeLegale = sedeLegale.getEstero();
			}

			
			lavoroPaFilter.setIdAzienda(idAzienda);
			lavoroPaFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
	        	    List<TaifTLavoroPaByAziendaDto> lavoriPa = taifMgr.getLavoroPa(lavoroPaFilter);
	        	    List<TaifTCommercializzazioneByAziendaDto> commLegname = taifMgr.findCommerciallizazioneByIdAzienda(idAzienda); 

			return this.createPdf(taifTAziendaDto, comuneSedeLegale, provinciaSedeLegale, sedeAzienda,
					pratichePerAzienda, listPersoneAziendaPerIdAzienda,lavoriPa,commLegname, tracciatoData);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ManagerException(new Message());
		}
		finally {
			LOG.debug("[SchedaAzienda::makeSchedaAziendaPdf] END");
		}

	}

	public List<String> findNumeroPratica(List<TaifTPraticaByIdAziendaDto> pratichePerAzienda) {
		List<String> listNumero = new ArrayList<String>();
		if (pratichePerAzienda != null && !pratichePerAzienda.isEmpty()) {
			for (TaifTPraticaByIdAziendaDto pratica : pratichePerAzienda) {
				listNumero.add(pratica.getIdSoggettoGestore() + pratica.getNrAlbo());
			}
		}
		return listNumero;
	}

	public PdfUtils getPdfUtils() {
		return pdfUtils;
	}

	public void setPdfUtils(PdfUtils pdfUtils) {
		this.pdfUtils = pdfUtils;
	}

	/**
	 * @return the dbMgr
	 */
	public DbMgr getDbMgr() {
		return dbMgr;
	}

	/**
	 * @param dbMgr the dbMgr to set
	 */
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

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

	/**
	 * @return the schedaAziendaSezioneCinque
	 */
	public SchedaAziendaSezioneCinque getSchedaAziendaSezioneCinque() {
		return schedaAziendaSezioneCinque;
	}

	/**
	 * @param schedaAziendaSezioneCinque the schedaAziendaSezioneCinque to set
	 */
	public void setSchedaAziendaSezioneCinque(SchedaAziendaSezioneCinque schedaAziendaSezioneCinque) {
		this.schedaAziendaSezioneCinque = schedaAziendaSezioneCinque;
	}

	/**
	 * @return the schedaAziendaSezioneQuatro
	 */
	public SchedaAziendaSezioneQuatro getSchedaAziendaSezioneQuatro() {
		return schedaAziendaSezioneQuatro;
	}

	/**
	 * @param schedaAziendaSezioneQuatro the schedaAziendaSezioneQuatro to set
	 */
	public void setSchedaAziendaSezioneQuatro(SchedaAziendaSezioneQuatro schedaAziendaSezioneQuatro) {
		this.schedaAziendaSezioneQuatro = schedaAziendaSezioneQuatro;
	}

	/**
	 * @return the schedaAziendaSezioneTre
	 */
	public SchedaAziendaSezioneTre getSchedaAziendaSezioneTre() {
		return schedaAziendaSezioneTre;
	}

	/**
	 * @param schedaAziendaSezioneTre the schedaAziendaSezioneTre to set
	 */
	public void setSchedaAziendaSezioneTre(SchedaAziendaSezioneTre schedaAziendaSezioneTre) {
		this.schedaAziendaSezioneTre = schedaAziendaSezioneTre;
	}

	/**
	 * @return the schedaAziendaSezioneDue
	 */
	public SchedaAziendaSezioneDue getSchedaAziendaSezioneDue() {
		return schedaAziendaSezioneDue;
	}

	/**
	 * @param schedaAziendaSezioneDue the schedaAziendaSezioneDue to set
	 */
	public void setSchedaAziendaSezioneDue(SchedaAziendaSezioneDue schedaAziendaSezioneDue) {
		this.schedaAziendaSezioneDue = schedaAziendaSezioneDue;
	}

	/**
	 * @return the schedaAziendaSezioneUno
	 */
	public SchedaAziendaSezioneUno getSchedaAziendaSezioneUno() {
		return schedaAziendaSezioneUno;
	}

	/**
	 * @param schedaAziendaSezioneUno the schedaAziendaSezioneUno to set
	 */
	public void setSchedaAziendaSezioneUno(SchedaAziendaSezioneUno schedaAziendaSezioneUno) {
		this.schedaAziendaSezioneUno = schedaAziendaSezioneUno;
	}

	/**
	 * @return the schedaAziendaSezioneSei
	 */
	public SchedaAziendaSezioneSei getSchedaAziendaSezioneSei() {
		return schedaAziendaSezioneSei;
	}

	/**
	 * @param schedaAziendaSezioneSei the schedaAziendaSezioneSei to set
	 */
	public void setSchedaAziendaSezioneSei(SchedaAziendaSezioneSei schedaAziendaSezioneSei) {
		this.schedaAziendaSezioneSei = schedaAziendaSezioneSei;
	}

	public SchedaAziendaSezioneCinqueFrancese getSchedaAziendaSezioneCinqueFrancese() {
		return schedaAziendaSezioneCinqueFrancese;
	}

	public void setSchedaAziendaSezioneCinqueFrancese(
			SchedaAziendaSezioneCinqueFrancese schedaAziendaSezioneCinqueFrancese) {
		this.schedaAziendaSezioneCinqueFrancese = schedaAziendaSezioneCinqueFrancese;
	}

	public SchedaAziendaSezioneSeiFrancese getSchedaAziendaSezioneSeiFrancese() {
		return schedaAziendaSezioneSeiFrancese;
	}

	public void setSchedaAziendaSezioneSeiFrancese(SchedaAziendaSezioneSeiFrancese schedaAziendaSezioneSeiFrancese) {
		this.schedaAziendaSezioneSeiFrancese = schedaAziendaSezioneSeiFrancese;
	}

	public SchedaAziendaSezioneTreFrancese getSchedaAziendaSezioneTreFrancese() {
		return schedaAziendaSezioneTreFrancese;
	}

	public void setSchedaAziendaSezioneTreFrancese(SchedaAziendaSezioneTreFrancese schedaAziendaSezioneTreFrancese) {
		this.schedaAziendaSezioneTreFrancese = schedaAziendaSezioneTreFrancese;
	}

	public LavoroPaFilter getLavoroPaFilter() {
		return lavoroPaFilter;
	}

	public void setLavoroPaFilter(LavoroPaFilter lavoroPaFilter) {
		this.lavoroPaFilter = lavoroPaFilter;
	}
	
	
	
}
