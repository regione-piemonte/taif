/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfConfigUtenteDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfMailDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfTipoMailDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDUnitaFormativaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifROpfoCorsoByIdPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAgenziaFormativaByUnitaFormativaPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAllegatoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTCorsoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTOpfoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTOpfoRicercaOperatoreAvanzataDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaByCodiceFiscalePersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaByFilterDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaCorsiExtAltriCorsiDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaDatiIdentificativiOperatoreDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaExtRicercaNumeroAlboForestaleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaProfiloUtenteByCodiceFiscaleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTQualificaByIdPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTQualificaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTRiconoscimentoByIdPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTSoggettoGestoreByFilterDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTSoggettoGestoreDto;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.TaifTPersonaDaoException;
import it.csi.taif.topforweb.business.dao.topfor.filter.AgenziaFormativaFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.ConfigProfiloFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.CorsoFormazioneFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.CorsoProfessionaleFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.PersonaFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.UnitaFormativaFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.UnitaFormativaPersona;
import it.csi.taif.topforweb.business.dao.topfor.filter.VisibileOrdinFilter;
import it.csi.taif.topforweb.business.helper.dto.factory.CorsoProfessionaleFactory;
import it.csi.taif.topforweb.business.helper.dto.factory.DettaglioEmailFactory;
import it.csi.taif.topforweb.business.helper.dto.factory.RicercaOperatoreFilterFactory;
import it.csi.taif.topforweb.business.manager.db.DbMgr;
import it.csi.taif.topforweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.topforweb.business.manager.message.MsgMgr;
import it.csi.taif.topforweb.business.manager.service.ServiceMgr;
import it.csi.taif.topforweb.business.manager.validation.ValidationMgr;
import it.csi.taif.topforweb.business.report.beans.AnagraficaOperatoriBean;
import it.csi.taif.topforweb.business.report.beans.CorsiOperatoriBean;
import it.csi.taif.topforweb.business.report.beans.QualificaOperatoreBean;
import it.csi.taif.topforweb.business.report.beans.RiconoscimentiOperatoreBean;
import it.csi.taif.topforweb.dto.allegato.Allegato;
import it.csi.taif.topforweb.dto.common.CodeDescription;
import it.csi.taif.topforweb.dto.common.LoginInfo;
import it.csi.taif.topforweb.dto.common.ProfiloUtenteTopFor;
import it.csi.taif.topforweb.dto.common.UserInfo;
import it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale;
import it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel;
import it.csi.taif.topforweb.dto.operatore.Operatore;
import it.csi.taif.topforweb.dto.qualifica.Qualifica;
import it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento;
import it.csi.taif.topforweb.exception.DbManagerException;
import it.csi.taif.topforweb.exception.ManagerException;
import it.csi.taif.topforweb.exception.ServiceException;
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.ConvertUtil;
import it.csi.taif.topforweb.util.ListUtils;
import it.csi.taif.topforweb.util.service.integration.svista.Comune;

public class TopForMgr {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	@Autowired
	private MsgMgr msgMgr;

	@Autowired
	private DbMgr dbMgr;

	@Autowired
	private ServiceMgr serviceMgr;

	@Autowired
	private ValidationMgr validationMgr;

	public MsgMgr getMsgMgr() {
		return msgMgr;
	}

	public void setMsgMgr(MsgMgr msgMgr) {
		this.msgMgr = msgMgr;
	}

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	public ServiceMgr getServiceMgr() {
		return serviceMgr;
	}

	public void setServiceMgr(ServiceMgr serviceMgr) {
		this.serviceMgr = serviceMgr;
	}

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	// INIZIO METODI DI BUSINESS

	public ProfiloUtenteTopFor getProfiloUtente(String codiceFiscale, Boolean isOperatore) throws ManagerException {
		LOGGER.debug("[TopForMgr::getProfiloUtente] BEGIN ");
		try {
			return this.dbMgr.getProfiloUtente(codiceFiscale, isOperatore);
		} finally {
			LOGGER.debug("[TopForMgr::getProfiloUtente] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAlbi(SoggettoGestoreVisibleOrdinFilter filter) throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoAlbi] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getAlbi(filter);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TopForMgr::getElencoAlbi] END");
		}
	}

	public ArrayList<CodeDescription> getElencoComuni() throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoComuni] BEGIN");
		try {
			// return serviceMgr.limitiAmministrativiGetComuniPerProvincia(
			// it.csi.taif.topforweb.business.dao.util.Constants.codiciProvince);
			return serviceMgr.limitiAmministrativiGetTuttiIComuni();
		} finally {
			LOGGER.debug("[TopForMgr::getElencoComuni] END");
		}
	}

	public ArrayList<CodeDescription> getElencoNazioni(SoggettoGestoreVisibleOrdinFilter filter, String linguaDati)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoNazioni] BEGIN");
		try {
			return dbMgr.getElencoNazioni(filter, linguaDati);
		} finally {
			LOGGER.debug("[TopForMgr::getElencoNazioni] END");
		}
	}

	public ArrayList<CodeDescription> getElencoUnitaFormativa(SoggettoGestoreVisibleOrdinFilter filter,
			String linguaDati) throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoUnitaFormativa] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getUnitaFormativa(filter, linguaDati);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TopForMgr::getElencoUnitaFormativa] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAgenziaFormativa(SoggettoGestoreVisibleOrdinFilter filter)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoAgenziaFormativa] BEGIN");
		try {
			return dbMgr.getAgenziaFormativa(filter);
		} finally {
			LOGGER.debug("[TopForMgr::getElencoAgenziaFormativa] END");
		}
	}

	public ArrayList<CodeDescription> getElencoQualifiche(SoggettoGestoreVisibleOrdinFilter filter, String linguaDati)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoQualifiche] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getElencoQualifiche(filter, linguaDati);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TopForMgr::getElencoQualifiche] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAgenziaFormativaFromSoggettoGestore(
			SoggettoGestoreVisibleOrdinFilter filter, String linguaDati) throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoAgenziaFormativaFromSoggettoGestore] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getAgenziaFormativaFromSoggettoGestore(filter, linguaDati);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TopForMgr::getElencoAgenziaFormativaFromSoggettoGestore] END");
		}
	}

	public ArrayList<CodeDescription> getElencoUnitaFormativaFromAgenziaFormativa(AgenziaFormativaFilter filter)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoUnitaFormativaFromAgenziaFormativa] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getElencoUnitaFormativaFromAgenziaFormativa(filter);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TopForMgr::getElencoUnitaFormativaFromAgenziaFormativa] END");
		}
	}

	public ArrayList<CodeDescription> getElencoCorsiFromUnitaFormativa(UnitaFormativaFilter filter)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoCorsiFromUnitaFormativa] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getElencoCorsiFromUnitaFormativa(filter);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TopForMgr::getElencoCorsiFromUnitaFormativa] END");
		}
	}

	public CorsoProfessionale getCorsoSelezionato(CorsoProfessionaleFilter filter, CpInserimentoOperatoreModel theModel)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getCorsoSelezionato] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getCorsoSelezionato(filter, theModel);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TopForMgr::getCorsoSelezionato] END");
		}
	}

	public ArrayList<CodeDescription> getElencoStatoScheda(SoggettoGestoreVisibleOrdinFilter filter, String linguaDati)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoStatoScheda] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getElencoStatoScheda(filter, linguaDati);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TopForMgr::getElencoStatoScheda] END");
		}
	}

	public ArrayList<CorsoProfessionale> getElencoAltriCorsiDenominazioni(VisibileOrdinFilter filter, String linguaDati)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoAltriCorsiDenominazioni] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getElencoAltriCorsiDenominazioni(filter, linguaDati);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TopForMgr::getElencoAltriCorsiDenominazioni] END");
		}
	}

	public ArrayList<TaifTOpfoRicercaOperatoreAvanzataDto> ricercaOperatoreAvanzata(
			RicercaOperatoreFilter ricercaOperatoreFilter) throws ManagerException {
		// TODO Auto-generated method stub
		LOGGER.debug("[TopForMgr::ricercaOperatoreAvanzata] BEGIN");
		try {
			return dbMgr.findRicercaOperatoreAvanzata(ricercaOperatoreFilter);
		} finally {
			LOGGER.debug("[TopForMgr::ricercaOperatoreAvanzata] END");
		}
	}

	public ArrayList<TaifTPersonaDatiIdentificativiOperatoreDto> ricercaDettaglioOperatoreByIdPersona(
			RicercaOperatoreFilter idPersonaFilter) throws ManagerException {
		// TODO Auto-generated method stub
		LOGGER.debug("[TopForMgr::ricercaDettaglioOperatoreByIdPersona] BEGIN");
		try {
			return dbMgr.findDettaglioOperatoreByIdPersona(idPersonaFilter);
		} finally {
			LOGGER.debug("[TopForMgr::ricercaDettaglioOperatoreByIdPersona] END");
		}
	}

	public ArrayList<TaifTPersonaExtRicercaNumeroAlboForestaleDto> findRicercaNumeroAlboForestale(
			RicercaOperatoreFilter idPersonaFilter) throws ManagerException {
		// TODO Auto-generated method stub
		LOGGER.debug("[TopForMgr::findRicercaNumeroAlboForestale] BEGIN");
		try {
			return dbMgr.findRicercaNumeroAlboForestale(idPersonaFilter);
		} finally {
			LOGGER.debug("[TopForMgr::findRicercaNumeroAlboForestale] END");
		}
	}

	public ArrayList<TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto> findRicercaCorsiFinanziatiRegione(
			RicercaOperatoreFilter idPersonaFilter) throws ManagerException {
		// TODO Auto-generated method stub
		LOGGER.debug("[TopForMgr::findRicercaCorsiFinanziatiRegione] BEGIN");
		try {
			return dbMgr.findRicercaCorsiFinanziatiRegione(idPersonaFilter);
		} finally {
			LOGGER.debug("[TopForMgr::findRicercaCorsiFinanziatiRegione] END");
		}
	}

	public ArrayList<TaifTPersonaCorsiExtAltriCorsiDto> findAltriCorsi(RicercaOperatoreFilter idPersonaFilter)
			throws ManagerException {
		// TODO Auto-generated method stub
		LOGGER.debug("[TopForMgr::findAltriCorsi] BEGIN");
		try {
			return dbMgr.findAltriCorsi(idPersonaFilter);
		} finally {
			LOGGER.debug("[TopForMgr::findAltriCorsi] END");
		}
	}

	public ArrayList<TaifTRiconoscimentoByIdPersonaDto> findRiconoscimenti(RicercaOperatoreFilter idPersonaFilter)
			throws ManagerException {
		// TODO Auto-generated method stub
		LOGGER.debug("[TopForMgr::findRiconoscimenti] BEGIN");
		try {
			return dbMgr.findRiconoscimentoByIdPersona(idPersonaFilter);
		} finally {
			LOGGER.debug("[TopForMgr::findRiconoscimenti] END");
		}
	}

	public ArrayList<TaifTQualificaByIdPersonaDto> findQualificaByIdPersona(RicercaOperatoreFilter idPersonaFilter)
			throws ManagerException {
		// TODO Auto-generated method stub
		LOGGER.debug("[TopForMgr::findQualificaByIdPersona] BEGIN");
		try {
			return dbMgr.findQualificaByIdPersona(idPersonaFilter);
		} finally {
			LOGGER.debug("[TopForMgr::findQualificaByIdPersona] END");
		}
	}

	public ArrayList<TaifTRiconoscimentoByIdPersonaDto> findRiconoscimentoByIdPersona(
			RicercaOperatoreFilter idPersonaFilter) throws ManagerException {
		// TODO Auto-generated method stub
		LOGGER.debug("[TopForMgr::findRiconoscimentoByIdPersona] BEGIN");
		try {
			return dbMgr.findRiconoscimentoByIdPersona(idPersonaFilter);
		} finally {
			LOGGER.debug("[TopForMgr::findRiconoscimentoByIdPersona] END");
		}
	}

	public TaifTAllegatoDto getTaifTAllegatoByPk(String idAllegato) throws ManagerException {
		LOGGER.debug("[DbMgr::getTaifTAllegatoByPk] BEGIN");
		try {
			return this.dbMgr.getTaifTAllegatoByPk(idAllegato);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getTaifTAllegatoByPk] END");
		}
	}

	public byte[] downloadFile(String idAllegato) throws ManagerException {
		LOGGER.debug("[TopForMgr::downloadFile] BEGIN");
		try {
			this.getValidationMgr().validazioneFormaleSelezioneElenco(idAllegato);
			return serviceMgr.indexDownloadFile(idAllegato);
		} finally {
			LOGGER.debug("[TopForMgr::downloadFile] BEGIN");
		}
	}

	public TaifTPersonaDatiIdentificativiOperatoreDto findDatiIdentificativiOperatore(RicercaOperatoreFilter input)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::findDatiIdentificativiOperatore] BEGIN");
		try {
			return dbMgr.findDatiIdentificativiOperatore(input);
		} finally {
			LOGGER.debug("[TopForMgr::findDatiIdentificativiOperatore] END");
		}
	}

	public TaifTPersonaByCodiceFiscalePersonaDto findDatiIdentificativiPersona(RicercaOperatoreFilter input)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::findDatiIdentificativiPersona] BEGIN");
		try {
			return dbMgr.findDatiIdentificativiPersona(input);
		} finally {
			LOGGER.debug("[TopForMgr::findDatiIdentificativiPersona] END");
		}
	}

	public ArrayList<CodeDescription> getElencoStatoOperatoreITA(int flagVisibile, String linguaDati)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoStatoOperatoreITA] BEGIN");
		try {
			return dbMgr.getElencoStatoOperatoreITA(flagVisibile);
		} finally {
			LOGGER.debug("[TopForMgr::getElencoStatoOperatoreITA] END");
		}
	}

	public ArrayList<CodeDescription> getElencoStatoOperatoreFRA(int flagVisibile, String linguaDati)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoStatoOperatoreFRA] BEGIN");
		try {
			return dbMgr.getElencoStatoOperatoreFRA(flagVisibile);
		} finally {
			LOGGER.debug("[TopForMgr::getElencoStatoOperatoreFRA] END");
		}
	}

	public ArrayList<CodeDescription> getElencoSINO() {
		LOGGER.debug("[TopForMgr::getElencoSINO] BEGIN");
		try {
			return ListUtils.createGenericListOfCodeDescription(Constants.NO_VALUE, Constants.SI_VALUE);
		} finally {
			LOGGER.debug("[TopForMgr::getElencoSINO] END");
		}
	}

	public ArrayList<CodeDescription> getElencoNazioniPerLingua(int flagVisibile, String linguaDati)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoNazioni] BEGIN");
		try {
			if (linguaDati.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
				return dbMgr.getElencoNazioniIta(flagVisibile);
			} else {
				return dbMgr.getElencoNazioniFra(flagVisibile);
			}

		} finally {
			LOGGER.debug("[TopForMgr::getElencoNazioni] END");
		}
	}

	public ArrayList<CodeDescription> getElencoStatoSchedaPerLingua(int flagVisibile, String linguaDati)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoStatoScheda] BEGIN");
		try {
			if (linguaDati.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
				return dbMgr.getElencoStatoOperatoreITA(flagVisibile);
			} else {
				return dbMgr.getElencoStatoOperatoreFRA(flagVisibile);
			}

		} finally {
			LOGGER.debug("[TopForMgr::getElencoNazioni] END");
		}
	}

	public void invioMailOperatore(CpInserimentoOperatoreModel theModel, String testoPerMail, Integer idPersona)
			throws TaifTPersonaDaoException, ManagerException {
		String tipoAccesso = theModel.getAppDatacurrentUser().getTipoAccesso();
		Integer soggettoGestore = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdSoggettoGestore();
		TaifTPersonaDto titolarePerCodiceFiscale = dbMgr.findPersonaByIdPersona(idPersona);
		TaifTOpfoDto opfo = dbMgr.findOperatoreFromIdPersona(idPersona);
		if (soggettoGestore == null || soggettoGestore == 0) {
			soggettoGestore = new Integer(opfo.getFkSoggettoGestore());
		}
		TaifCnfMailDto configMail = this.dbMgr.getParametriInvioMail();
		TaifCnfTipoMailDto mailDto = this.dbMgr
				.getMail(it.csi.taif.topforweb.business.dao.util.Constants.CNF_TIPO_MAIL_TOPFORWEB, tipoAccesso);
		TaifTSoggettoGestoreDto sogg = this.dbMgr.findSoggettoGestoreById(soggettoGestore);

		String[] parts = mailDto.getTesto()
				.split(it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_3);

		mailDto.setTesto(parts[0] + it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_2
				+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_1 + testoPerMail + " "
				+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_1 + "\n"
				+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_3 + parts[1]);
		this.serviceMgr.invioMail(DettaglioEmailFactory.createDettaglioEmail(theModel, tipoAccesso, configMail, mailDto,
				titolarePerCodiceFiscale, sogg, opfo));
	}

	public void invioMailGestore(CpInserimentoOperatoreModel theModel, Integer idPersona)
			throws TaifTPersonaDaoException, ManagerException {
		String tipoAccesso = theModel.getAppDatacurrentUser().getTipoAccesso();
		Integer soggettoGestore = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdSoggettoGestore();
		TaifTPersonaDto titolarePerCodiceFiscale = dbMgr.findPersonaByIdPersona(idPersona);
		TaifTOpfoDto opfo = dbMgr.findOperatoreFromIdPersona(idPersona);
		if (soggettoGestore == null || soggettoGestore == 0) {
			// soggetto gestore dell'utente che sta effettuando l'operazione
			soggettoGestore = new Integer(
					theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdSoggettoGestore());
		}
		TaifTSoggettoGestoreDto sogg = this.dbMgr.findSoggettoGestoreById(soggettoGestore);
		TaifCnfMailDto configMail = this.dbMgr.getParametriInvioMail();
		TaifCnfTipoMailDto mailDto = this.dbMgr
				.getMail(it.csi.taif.topforweb.business.dao.util.Constants.CNF_TIPO_MAIL_TOPFORWEB, tipoAccesso);
		String[] parts = mailDto.getTesto()
				.split(it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_4);
		if (theModel.getAppDataidStatoSchedaSelezionato()
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.ID_STATO_SCHEDA_NON_VALIDATA)) {
			mailDto.setTesto(parts[0] + it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_1 + " "
					+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_4 + " "
					+ theModel.getAppDatamotivazioneRifiutoValidazione() + " "
					+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_1 + " " + parts[1]);
		} else {
			mailDto.setTesto(
					parts[0] + it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_1 + parts[1]);
		}

		this.serviceMgr.invioMail(DettaglioEmailFactory.createDettaglioEmail(theModel, tipoAccesso, configMail, mailDto,
				titolarePerCodiceFiscale, sogg, opfo));
	}

	public Integer salvaDatiAnagraficiOperatore(Operatore datiOperatore,
			Operatore datiOperatoreDettaglio, String idStatoScheda, String idStatoNascitaOperatore,
			String idComuneResidenza, String idComuneNascita, ProfiloUtenteTopFor profiloUtenteTopFor,
			String dataTracciato, Boolean fromModifica, Boolean privacy, Boolean consensoPubblicazione)
			throws ManagerException {

		LOGGER.debug("[TopForMgr::salvaDatiAnagraficiOperatore] BEGIN");
		//Integer result = idPersona;
		Integer result = null;

		try {
			if (dataTracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
				int idConfigUtente = profiloUtenteTopFor.getIdConfigUtente();
				if (datiOperatore != null) {
					
					this.validationMgr.validazionePersonaOperatore(datiOperatore, idStatoScheda,
							idStatoNascitaOperatore, idComuneResidenza, idComuneNascita, dataTracciato, privacy,
							consensoPubblicazione);
					
					
					List<TaifTPersonaByCodiceFiscalePersonaDto> titolarePerCodiceFiscale = dbMgr
							.findPersonaPerCodiceFiscale(datiOperatore.getCodiceFiscaleOperatore());

					// cerco sul db se esiste già in caso di primo inserimento senza ricerca su
					// anagrafica
					// se il risultato della query è diverso da zero è in datiOperatore idPersona è
					// 0
					// allora sto inserendo un operatore già esistente

					// this.validationMgr.validazioneEsistenzaSuDb(datiOperatore,
					// titolarePerCodiceFiscale,fromModifica);
					
					//  TODO DA VERIFICARE!!!
					//datiOperatore.setIdSoggettoGestore(profiloUtenteTopFor.getIdSoggettoGestore() + "");
					if (titolarePerCodiceFiscale != null && !titolarePerCodiceFiscale.isEmpty()) {
						result = dbMgr.updatePersonaleOperatore(titolarePerCodiceFiscale.get(0).getIdPersona(), datiOperatore, datiOperatoreDettaglio,
								idStatoNascitaOperatore, idComuneResidenza, idComuneNascita, idConfigUtente,
								dataTracciato, idStatoScheda);
					} else {
						result = dbMgr.salvaPersonale(datiOperatore, datiOperatoreDettaglio, idStatoNascitaOperatore,
								idComuneResidenza, idComuneNascita, idConfigUtente, dataTracciato);
					}
				}
			} else {
				// this.validationMgr.validazionePersonaOperatoreFrancese(datiOperatore);
				// tracciato francese
				if (profiloUtenteTopFor.getIdConfigUtente() != null) {
					int idConfigUtente = profiloUtenteTopFor.getIdConfigUtente();
				}
				if (true) {
					// update
					// dbMgr.updatePersonaleFrancese(idAzienda, gestionePersonaleFrancese,
					// idConfigUtente, dataTracciato);
				} else {
					// insert
					// dbMgr.salvaPersonaleFrancese(idAzienda, gestionePersonaleFrancese,
					// idConfigUtente, dataTracciato);
				}
			}

		} catch (DbManagerException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} catch (TaifTPersonaDaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}
		LOGGER.debug("[TopForMgr::salvaDatiAnagraficiOperatore] END");
		return result;

	}

	public Integer salvaCorsiFinanzatiRegione(Integer idPersona, ArrayList<CorsoProfessionale> corsiProfessionaliList,
			ProfiloUtenteTopFor profiloUtenteTopFor, String dataTracciato)
			throws ManagerException, TaifTPersonaDaoException {

		LOGGER.debug("[TopForMgr::salvaCorsiFinanzatiRegione] BEGIN");
		Integer result = idPersona;
		try {

			if (dataTracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {

				List<Integer> idCorsiEsistentiList = new ArrayList<Integer>();
				List<Integer> idCorsiArrivatiList = new ArrayList<Integer>();
				List<TaifROpfoCorsoByIdPersonaDto> opfoCorso = findOpfoCorsoByIdPersona(idPersona);
				for (TaifROpfoCorsoByIdPersonaDto taifROpfoCorsoByIdPersonaDto : opfoCorso) {
					idCorsiEsistentiList.add(taifROpfoCorsoByIdPersonaDto.getIdCorso());
				}
				for (CorsoProfessionale corso : corsiProfessionaliList) {
					idCorsiArrivatiList.add(Integer.parseInt(corso.getIdCorsoProfessionale()));
				}

				for (TaifROpfoCorsoByIdPersonaDto taifROpfoCorsoByIdPersonaDto : opfoCorso) {
					if (!(idCorsiArrivatiList.contains(taifROpfoCorsoByIdPersonaDto.getIdCorso()))) {
						dbMgr.deleteOpfoCorso(taifROpfoCorsoByIdPersonaDto.getIdCorso(), idPersona);
					}
				}

				// UserTransaction utx = txManager.getUserTransaction();

				int idConfigUtente = profiloUtenteTopFor.getIdConfigUtente();
				if (corsiProfessionaliList != null && !corsiProfessionaliList.isEmpty()) {
					// tracciato Italianao

				}
			} else {
				// this.validationMgr.validazionePersonaOperatoreFrancese(datiOperatore);
				// tracciato francese

			}
			// this.validationMgr.checkElencoCorsiFinanziatiRegione(corsiProfessionaliList);
		} catch (DbManagerException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}

		LOGGER.debug("[TopForMgr::salvaCorsiFinanzatiRegione] END");
		return result;
	}

	public void salvaAltriCorsi() {
		// TODO Auto-generated method stub

	}

	public void salvaQualifiche() {
		// TODO Auto-generated method stub

	}

	public void removeCorso(String idCorsoProfessionale, String idPersonaOperatore, String iconaAllegato)
			throws NumberFormatException, DbManagerException {
		int idAllegato = 0;
		if (ConvertUtil.checkIsNullOrEmpty(iconaAllegato)) {
			idAllegato = new Integer(iconaAllegato);
		}
		this.dbMgr.rollBack(new Integer(idCorsoProfessionale), new Integer(idPersonaOperatore), idAllegato);
		try {
			serviceMgr.indexDeleteFile(iconaAllegato);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TopForMgr::removeCorso] END");
		}
	}

	public TaifTPersonaProfiloUtenteByCodiceFiscaleDto getConfigProfiloUtenteByCodiceFiscale(ConfigProfiloFilter filtro,
			int idProfilo) throws ManagerException {
		LOGGER.debug("[TopForMgr::getConfigProfiloUtenteByCodiceFiscale] BEGIN ");
		try {

			TaifTPersonaProfiloUtenteByCodiceFiscaleDto result = new TaifTPersonaProfiloUtenteByCodiceFiscaleDto();
			List<TaifTPersonaProfiloUtenteByCodiceFiscaleDto> profiloUtente = this.dbMgr
					.getConfigProfiloUtenteByCodiceFiscale(filtro);
			for (TaifTPersonaProfiloUtenteByCodiceFiscaleDto profPers : profiloUtente) {
				if (profPers.getIdProfiloUtente() == idProfilo) {
					result = profPers;
				}
			}
			return result;
		} finally {
			LOGGER.debug("[TopForMgr::getConfigProfiloUtenteByCodiceFiscale] END");
		}

	}

	public Integer findUserCollegatoPerCodiceFiscale(PersonaFilter filterPersona, String tracciato)
			throws DbManagerException {
		LOGGER.debug("[TopForMgr:findUserCollegatoPerCodiceFiscale] BEGIN");
		try {
			Integer idPersonaR = dbMgr.findUserCollegatoPerCodiceFiscale(filterPersona, tracciato);
			// this.validationMgr.validateProfiloUtente(idPersonaR);

			return idPersonaR;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TopForMgr:findUserCollegatoPerCodiceFiscale] END");
		}
	}

	public TaifTPersonaDto getPersonaByIdPersona(Integer idPersona) throws ManagerException {
		LOGGER.debug("[TopForMgr::getPersonePerIdAzienda] BEGIN");
		TaifTPersonaDto personaById;
		try {
			personaById = dbMgr.getPersonaByIdPersona(idPersona);
		} finally {
			LOGGER.debug("[TopForMgr::getPersonePerIdAzienda] END");
		}
		return personaById;
	}

	public String salvaCorso(int idCorso, int idPersona, Allegato allegato, CorsoProfessionale altroCorso,
			int idConfigUtente, File file, String contentType) throws ManagerException {
		// 1. insert IN taif_r_opfo_corso
		idCorso = this.dbMgr.insertROpfoCorso(idCorso, idPersona, allegato, altroCorso, idConfigUtente);
		int idAllegato = 0;
		if (allegato != null) {
			// 2. Upload su DB TAIF_T_ALLEGATO
			idAllegato = this.dbMgr.insertAllegato(idCorso, idPersona, allegato, altroCorso, idConfigUtente);
			allegato.setIdAllegato(idAllegato);
			// 3. Upload su INDEX
			try {
				serviceMgr.indexUploadFile(idCorso, idPersona, allegato, file);
			} catch (ServiceException e) {
				this.dbMgr.rollBack(idCorso, idPersona, idAllegato);
				throw new ServiceException(e, this.msgMgr.getMessage(MsgCodeEnum.G0041));
			} catch (Exception e) {
				this.dbMgr.rollBack(idCorso, idPersona, idAllegato);
				throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G0029));
			}

		}

		return ConvertUtil.convertToString(idAllegato);

	}

	public void updateNumeroAccessi(Integer idConfigUtente) throws ManagerException {

		LOGGER.debug("[TopForMgr::findConfigUtenteByPrimaryKey] BEGIN");
		TaifCnfConfigUtenteDto configUtenteDto = new TaifCnfConfigUtenteDto();
		try {
			configUtenteDto = dbMgr.findConfigUtenteByPrimaryKey(idConfigUtente);

		} finally {
			LOGGER.debug("[TopForMgr::findConfigUtenteByPrimaryKey] END");
		}
	}

	public Integer getPersonaFromCnfUtente(int idConfigUtente) throws ManagerException {
		LOGGER.debug("[TopForMgr::getPersonaFromCnfUtente] BEGIN");
		try {
			return dbMgr.getPersonaFromCnfUtente(idConfigUtente);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TopForMgr::getPersonaFromCnfUtente] END");
		}
	}

	public UserInfo accessFromUserPassword(LoginInfo info) throws ManagerException {
		LOGGER.debug("[TopForMgr::accessFromUserPassword] BEGIN ");
		try {
			this.validationMgr.validateLoginInfo(info);
			return this.dbMgr.accessFromUserPassword(info);
		} finally {
			LOGGER.debug("[TopForMgr::accessFromUserPassword] END");
		}
	}

	public ProfiloUtenteTopFor getProfiloUtenteGestore(String codiceFiscale) throws ManagerException {
		LOGGER.debug("[TopForMgr::getProfiloUtente] BEGIN ");
		try {
			return this.dbMgr.getProfiloUtenteGestore(codiceFiscale);
		} finally {
			LOGGER.debug("[TopForMgr::getProfiloUtente] END");
		}
	}

	public Operatore getOperatoreFromPersona(int idPersona, String dataTracciato) throws ManagerException {
		LOGGER.debug("[TopForMgr::getOperatoreFromPersona] BEGIN");
		try {
			Operatore operatoreInCarica = dbMgr.getOperatoreFromPersona(idPersona, dataTracciato);
			return operatoreInCarica;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TopForMgr::getOperatoreFromPersona] END");
		}

	}

	public TaifTPersonaByFilterDto findPersonaPerCodiceFiscale(PersonaFilter personaFilter) throws ManagerException {
		LOGGER.debug("[TopForMgr::findPersonaPerCodiceFiscale] BEGIN");
		try {
			List<TaifTPersonaByFilterDto> operatoreInCaricaList = dbMgr.findPersonaPerCodiceFiscale(personaFilter);
			TaifTPersonaByFilterDto operatoreInCarica = new TaifTPersonaByFilterDto();
			if (!operatoreInCaricaList.isEmpty()) {
				operatoreInCarica = operatoreInCaricaList.get(0);
			}
			return operatoreInCarica;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TopForMgr::findPersonaPerCodiceFiscale] END");
		}

	}

	public ArrayList<CodeDescription> findCorsiPerAgenziaUnita(CorsoFormazioneFilter corsoFilter)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::findCorsiPerAgenziaUnita] BEGIN");
		try {
			ArrayList<CodeDescription> corsiDaCaricare = dbMgr.findCorsiPerAgenziaUnita(corsoFilter);
			return corsiDaCaricare;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TopForMgr::findCorsiPerAgenziaUnita] END");
		}

	}

	public List<TaifROpfoCorsoByIdPersonaDto> findOpfoCorsoByIdPersona(int idPersona) throws ManagerException {
		LOGGER.debug("[TopForMgr::findOpfoCorsoByIdPersona] BEGIN");
		try {
			List<TaifROpfoCorsoByIdPersonaDto> opfoCorsoList = dbMgr.findByIdPersona(idPersona);
			return opfoCorsoList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TopForMgr::findOpfoCorsoByIdPersona] END");
		}

	}

	public Integer insertQualificaOperatore(Qualifica qualificaCorso, String idPersona, int idConfigUtente)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::insertQualificaOperatore] BEGIN");
		try {
			Integer idQualifica = dbMgr.insertQualificaOperatore(qualificaCorso, Integer.parseInt(idPersona),
					idConfigUtente);
			return idQualifica;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TopForMgr::insertQualificaOperatore] END");
		}

	}

	public Integer insertRiconoscimentoCorso(Riconoscimento riconoscimento, String idPersona, int idConfigUtente)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::insertRiconoscimentoCorso] BEGIN");
		try {
			Integer idRiconoscimento = dbMgr.insertRiconoscimentoCorso(riconoscimento, Integer.parseInt(idPersona),
					idConfigUtente);
			return idRiconoscimento;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TopForMgr::insertRiconoscimentoCorso] END");
		}

	}

	public Qualifica findQualificaByPrimaryKey(int idQualifica) throws ManagerException {
		LOGGER.debug("[TopForMgr::findQualificaByPrimaryKey] BEGIN");
		try {
			Qualifica qualifica = dbMgr.findQualificaByPrimaryKey(idQualifica);
			return qualifica;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TopForMgr::findQualificaByPrimaryKey] END");
		}

	}

	public Riconoscimento findRiconoscimentoByPrimaryKey(int idRiconoscimento) throws ManagerException {
		LOGGER.debug("[TopForMgr::findRiconoscimentoByPrimaryKey] BEGIN");
		try {
			Riconoscimento riconoscimento = dbMgr.findRiconoscimentoByPrimaryKey(idRiconoscimento);
			return riconoscimento;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TopForMgr::findRiconoscimentoByPrimaryKey] END");
		}

	}

	public void deleteQualificaPersonale(int idQualifica) throws ManagerException {
		LOGGER.debug("[TopForMgr::deleteQualificaPersonale] BEGIN");
		try {
			dbMgr.deleteQualificaPersonale(idQualifica);

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TopForMgr::deleteQualificaPersonale] END");
		}
	}

	public void deleteRiconoscimentoCorso(int idRiconoscimento) throws ManagerException {
		LOGGER.debug("[DbMgr::deleteRiconoscimentoCorso] BEGIN");
		try {
			dbMgr.deleteRiconoscimentoCorso(idRiconoscimento);

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::deleteRiconoscimentoCorso] END");
		}
	}

	public ArrayList<Riconoscimento> findRiconoscimentoPerPersona(String idPersona) throws ManagerException {
		LOGGER.debug("[DbMgr::findRiconoscimentoByPrimaryKey] BEGIN");
		try {
			ArrayList<Riconoscimento> riconoscimentoList = dbMgr.getElencoRiconoscimenti(idPersona);
			return riconoscimentoList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findRiconoscimentoByPrimaryKey] END");
		}

	}

	public ArrayList<Qualifica> findQualificaPerPersona(String idPersona) throws ManagerException {
		LOGGER.debug("[DbMgr::findQualificaPerPersona] BEGIN");
		try {
			ArrayList<Qualifica> qualificaList = dbMgr.getElencoQualifiche(idPersona);
			return qualificaList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findQualificaPerPersona] END");
		}

	}

	public AnagraficaOperatoriBean findAnagraficaOperatoreByIdOperatore(int idPersona, String tracciato)
			throws ManagerException {
		LOGGER.debug("[DbMgr::findAnagraficaOperatoreByIdOperatore] BEGIN");
		try {
			AnagraficaOperatoriBean anagrafica = dbMgr.findAnagraficaOperatoreByIdOperatore(idPersona, tracciato);
			return anagrafica;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findAnagraficaOperatoreByIdOperatore] END");
		}

	}

	public List<CorsiOperatoriBean> findCorsiPerOperatori(int idPersona, String tracciato) throws ManagerException {
		LOGGER.debug("[DbMgr::findCorsiPerOperatori] BEGIN");
		try {
			List<CorsiOperatoriBean> corsiList = dbMgr.findCorsiPerOperatori(idPersona, tracciato);
			return corsiList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findCorsiPerOperatori] END");
		}

	}

	public List<RiconoscimentiOperatoreBean> findRiconoscimentiPerPersona(int idPersona, String tracciato)
			throws ManagerException {
		LOGGER.debug("[DbMgr::findRiconoscimentiPerPersona] BEGIN");
		try {
			List<RiconoscimentiOperatoreBean> riconoscimentiList = dbMgr.findRiconoscimentiPerPersona(idPersona,
					tracciato);
			return riconoscimentiList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findRiconoscimentiPerPersona] END");
		}

	}

	public List<QualificaOperatoreBean> findQualifichePerPersona(int idPersona, String tracciato)
			throws ManagerException {
		LOGGER.debug("[DbMgr::findQualifichePerPersona] BEGIN");
		try {
			List<QualificaOperatoreBean> qualificheList = dbMgr.findQualifichePerPersona(idPersona, tracciato);
			return qualificheList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findQualifichePerPersona] END");
		}

	}

	public TaifDUnitaFormativaDto findUnitaFormativaById(int idUnitaFormativa) throws ManagerException {
		LOGGER.debug("[DbMgr::findUnitaFormativaById] BEGIN");
		try {
			TaifDUnitaFormativaDto unitaFormativa = dbMgr.findUnitaFormativaById(idUnitaFormativa);
			return unitaFormativa;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findUnitaFormativaById] END");
		}

	}

	public List<TaifTAgenziaFormativaByUnitaFormativaPersonaDto> findByUnitaFormativaPersona(
			UnitaFormativaPersona unitaFormativaPers) throws ManagerException {
		LOGGER.debug("[DbMgr::findByUnitaFormativaPersona] BEGIN");
		try {
			List<TaifTAgenziaFormativaByUnitaFormativaPersonaDto> listAgenziaFormativa = dbMgr
					.findByUnitaFormativaPersona(unitaFormativaPers);
			return listAgenziaFormativa;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findByUnitaFormativaPersona] END");
		}
	}

	public TaifTCorsoDto findUnitaFormativaByIdCorso(int idCorsoProfesionale) throws ManagerException {
		LOGGER.debug("[DbMgr::findCorsoById] BEGIN");
		try {
			TaifTCorsoDto corsoDto = new TaifTCorsoDto();
			corsoDto = dbMgr.findCorsoById(idCorsoProfesionale);
			return corsoDto;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findCorsoById] END");
		}

	}

	public String getComuneByIstat(String codIstatComune) throws ManagerException {
		LOGGER.debug("[TopForMgr::getComuneByIstat] BEGIN");
		Comune comuneFromIstat = new Comune();
		String nomeComune = null;
		try {
			if (StringUtils.isNotEmpty(codIstatComune)) {
				comuneFromIstat = serviceMgr.limitiAmministrativiGetComuneByIstat(codIstatComune);
				if (comuneFromIstat != null) {
					nomeComune = comuneFromIstat.getNome();
				}
			}
		} finally {
			LOGGER.debug("[TopForMgr::getComuneByIstat] END");
		}
		return nomeComune;
	}

	public TaifTPersonaByCodiceFiscalePersonaDto findPersonaPerCodiceFiscale(String codiceFiscale)
			throws DbManagerException, TaifTPersonaDaoException {
		LOGGER.debug("[TopForMgr::findPersonaPerCodiceFiscale] BEGIN");
		try {
			TaifTPersonaByCodiceFiscalePersonaDto personaTrovata = new TaifTPersonaByCodiceFiscalePersonaDto();
			List<TaifTPersonaByCodiceFiscalePersonaDto> persoanaByCodiceFiscale = dbMgr
					.findPersonaPerCodiceFiscale(codiceFiscale);
			if (persoanaByCodiceFiscale.size() > 0) {
				personaTrovata = persoanaByCodiceFiscale.get(0);
			}
			return personaTrovata;
		} finally {
			LOGGER.debug("[TopForMgr::getComuneByIstat] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAmbitiFormativi(SoggettoGestoreVisibleOrdinFilter filter) throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoStatoScheda] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getElencoAmbitiFormativi(filter);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TopForMgr::getElencoStatoScheda] END");
		}
	}

	public ArrayList<CodeDescription> getElencoUnitaFormativaByAmbito(String idAmbitoFormativo, SoggettoGestoreVisibleOrdinFilter filter,
			String linguaDati) throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoUnitaFormativa] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getUnitaFormativa(idAmbitoFormativo, filter, linguaDati);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TopForMgr::getElencoUnitaFormativa] END");
		}
	}

	public ArrayList<CodeDescription> getUnitaFormativa(String idAmbitoFormativo,
			SoggettoGestoreVisibleOrdinFilter filter, String linguaDati) throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoUnitaFormativa] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getUnitaFormativa(idAmbitoFormativo, filter, linguaDati);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TopForMgr::getElencoUnitaFormativa] END");
		}
	}
	
	public ArrayList<CodeDescription> getElencoComuniPerIstatProvincia(String istatProvincia) throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoComuniPerIstatProvincia] BEGIN");
		try {
			return serviceMgr.limitiAmministrativiGetComuniPerIstatProvincia(istatProvincia);
		} finally {
			LOGGER.debug("[TopForMgr::getElencoComuniPerIstatProvincia] END");
		}
	}
	
	public ArrayList<CodeDescription> getElencoProvince() throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoProvince] BEGIN");
		try {
			return serviceMgr.limitiAmministrativiGetProvince();
		} finally {
			LOGGER.debug("[TaifMgr::getElencoProvince] END");
		}
	}
	
	public ArrayList<CodeDescription> getElencoProvinceIstat() throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoProvinceIstat] BEGIN");
		try {
			return serviceMgr.limitiAmministrativiGetProvinceIstat();
		} finally {
			LOGGER.debug("[TaifMgr::getElencoProvinceIstat] END");
		}
	}
	
	public ArrayList<CorsoProfessionale> getElencoCorsiPerPersona(Integer idPersona)
			throws ManagerException {
		LOGGER.debug("[TopForMgr::getElencoCorsiPerPersona] BEGIN");
		ArrayList<CorsoProfessionale> result = new ArrayList<CorsoProfessionale>();
		try {
			ArrayList<TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto> list = this.dbMgr.findRicercaCorsiFinanziatiRegione(RicercaOperatoreFilterFactory.createRicercaOperatoreFilter(idPersona));
			if(list!=null && !list.isEmpty()){
				for (TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto dto : list) {
					result.add(CorsoProfessionaleFactory.createCorsoProfessionale(dto, this.getComuneByIstat(dto.getSedeCorso())));
				}
			}
			
		} finally {
			LOGGER.debug("[TopForMgr::getElencoCorsiPerPersona] END");
		}
		return result;
	}
	
	public ArrayList<CorsoProfessionale> getElencoAltriCorsiPerPersona(Integer idPersona) throws ManagerException{
		LOGGER.debug("[TopForMgr::getElencoAltriCorsiPerPersona] BEGIN");
		try {
			List<TaifTPersonaCorsiExtAltriCorsiDto> list = this.findAltriCorsi(RicercaOperatoreFilterFactory.createRicercaOperatoreFilter(idPersona));
			return CorsoProfessionaleFactory.createListAltriCorsiProfessionali(list);
		}
		finally {
			LOGGER.debug("[TopForMgr::getElencoAltriCorsiPerPersona] END");
		}
		
	}

	public ArrayList<Riconoscimento> findRiconoscimentoPerPersona(int idPersona) throws ManagerException {
		return this.findRiconoscimentoPerPersona(ConvertUtil.convertToString(idPersona));
	}

	public ArrayList<Qualifica> findQualificaPerPersona(int idPersona) throws ManagerException {
		return this.findQualificaPerPersona(ConvertUtil.convertToString(idPersona));
	}
}
