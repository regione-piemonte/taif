/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.manager.db;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.jta.JtaTransactionManager;

import it.csi.taif.topforweb.business.common.ProfiloEnum;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifCnfConfigUtenteDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifCnfEstensAmmDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifCnfMailDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifCnfParamApimgrDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifCnfTipoMailDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifDAmbitoFormativoDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifDNazioneDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifDStatoOpfoDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifDStatoPraticaDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifDTipoQualificaDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifDUnitaFormativaDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifROpfoCorsoDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifTAgenziaFormativaDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifTAllegatoDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifTCorsoDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifTOpfoDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifTPersonaCorsiExtDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifTPersonaDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifTPersonaExtDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifTQualificaDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifTRiconoscimentoDao;
import it.csi.taif.topforweb.business.dao.topfor.dao.TaifTSoggettoGestoreDao;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfConfigUtenteDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfConfigUtentePk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfConfigUtenteProfiloByCodiceFiscaleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfMailDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfMailPk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfParamApimgrDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfTipoMailDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDAmbitoFormativoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDNazioneByFilterVisibleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDNazioneByNazioneFraVisibleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDNazioneByNazioneItaVisibleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDNazioneDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDNazionePk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDStatoOpfoByFilterVisibleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDStatoOpfoByVisibileFraDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDStatoOpfoByVisibileItaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDTipoQualificaByFilterVisibleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDTipoQualificaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDTipoQualificaPk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDUnitaFormativaByAmbitoFormativoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDUnitaFormativaByFilterAgenziaFormativaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDUnitaFormativaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifDUnitaFormativaPk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifROpfoCorsoByIdPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifROpfoCorsoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifROpfoCorsoPk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAgenziaFormativaByFilterSoggettoGestoreDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAgenziaFormativaByFilterVisibleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAgenziaFormativaByUnitaFormativaPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAgenziaFormativaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAgenziaFormativaPk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAllegatoByCorsoPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAllegatoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAllegatoPk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTCorsoByFilterUnitaFormativaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTCorsoByFilterVisibleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTCorsoCorsiPerAgenziaUnitaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTCorsoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTCorsoPk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTOpfoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTOpfoPk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTOpfoRicercaOperatoreAvanzataDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaAnagraficaOperatoreByIdOperatoreDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaByCodiceFiscalePersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaByFilterDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaCorsiExtAltriCorsiDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaDatiIdentificativiOperatoreDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaExtRicercaNumeroAlboForestaleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaOperatoriCorsiPerPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaPk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaProfiloUtenteByCodiceFiscaleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaQualifichePerPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaRiconoscimentiPerPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTQualificaByIdPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTQualificaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTQualificaPk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTRiconoscimentoByIdPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTRiconoscimentoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTRiconoscimentoPk;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTSoggettoGestoreByFilterVisibleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTSoggettoGestoreDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTSoggettoGestorePk;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.DaoException;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.TaifTPersonaDaoException;
import it.csi.taif.topforweb.business.dao.topfor.filter.AgenziaFormativaFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.AllegatoFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.ConfigProfiloFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.CorsoFormazioneFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.CorsoProfessionaleFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.PersonaFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.PersonaSoggettogestoreFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.UnitaFormativaFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.UnitaFormativaPersona;
import it.csi.taif.topforweb.business.dao.topfor.filter.VisibileOrdinFilter;
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
import it.csi.taif.topforweb.exception.ValidationException;
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.ConvertUtil;
import it.csi.taif.topforweb.util.DateUtil;
import it.csi.taif.topforweb.util.service.integration.svista.Comune;
import it.csi.taif.topforweb.util.service.integration.svista.Provincia;

public class DbMgr {

	private static final Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	private JtaTransactionManager txManager;

	private ServiceMgr serviceMgr;

	private TaifTSoggettoGestoreDao taifTSoggettoGestoreDao;
	private TaifCnfConfigUtenteDao taifCnfConfigUtenteDao;
	private TaifTAgenziaFormativaDao taifTAgenziaFormativaDao;
	private TaifDUnitaFormativaDao taifDUnitaFormativaDao;
	private TaifDStatoOpfoDao taifDStatoOpfoDao;
	private TaifDStatoPraticaDao taifDStatoPraticaDao;
	private TaifTOpfoDao taifTOpfoDao;
	private TaifTPersonaDao taifTPersonaDao;
	private TaifTPersonaExtDao taifTPersonaExtDao;
	private TaifTPersonaCorsiExtDao taifTPersonaCorsiExtDao;
	private TaifTQualificaDao taifTQualificaDao;
	private TaifTRiconoscimentoDao taifTRiconoscimentoDao;
	private TaifDNazioneDao taifDNazioneDao;
	private DozerBeanMapper dozerBeanMapper;
	private TaifTAllegatoDao taifTAllegatoDao;
	private TaifTCorsoDao taifTCorsoDao;
	private TaifDTipoQualificaDao taifDTipoQualificaDao;
	private TaifCnfEstensAmmDao taifCnfEstensAmmDao;
	private TaifROpfoCorsoDao taifROpfoCorsoDao;
	private TaifCnfParamApimgrDao taifCnfParamApimgrDao;
	private TaifCnfMailDao taifCnfMailDao;
	private TaifCnfTipoMailDao taifCnfTipoMailDao;
	private TaifDAmbitoFormativoDao taifDAmbitoFormativoDao;

	public TaifROpfoCorsoDao getTaifROpfoCorsoDao() {
		return taifROpfoCorsoDao;
	}

	public void setTaifROpfoCorsoDao(TaifROpfoCorsoDao taifROpfoCorsoDao) {
		this.taifROpfoCorsoDao = taifROpfoCorsoDao;
	}

	public TaifTAllegatoDao getTaifTAllegatoDao() {
		return taifTAllegatoDao;
	}

	public void setTaifTAllegatoDao(TaifTAllegatoDao taifTAllegatoDao) {
		this.taifTAllegatoDao = taifTAllegatoDao;
	}

	public TaifTRiconoscimentoDao getTaifTRiconoscimentoDao() {
		return taifTRiconoscimentoDao;
	}

	public void setTaifTRiconoscimentoDao(TaifTRiconoscimentoDao taifTRiconoscimentoDao) {
		this.taifTRiconoscimentoDao = taifTRiconoscimentoDao;
	}

	public TaifTQualificaDao getTaifTQualificaDao() {
		return taifTQualificaDao;
	}

	public void setTaifTQualificaDao(TaifTQualificaDao taifTQualificaDao) {
		this.taifTQualificaDao = taifTQualificaDao;
	}

	public TaifTPersonaCorsiExtDao getTaifTPersonaCorsiExtDao() {
		return taifTPersonaCorsiExtDao;
	}

	public void setTaifTPersonaCorsiExtDao(TaifTPersonaCorsiExtDao taifTPersonaCorsiExtDao) {
		this.taifTPersonaCorsiExtDao = taifTPersonaCorsiExtDao;
	}

	public TaifTPersonaExtDao getTaifTPersonaExtDao() {
		return taifTPersonaExtDao;
	}

	public void setTaifTPersonaExtDao(TaifTPersonaExtDao taifTPersonaExtDao) {
		this.taifTPersonaExtDao = taifTPersonaExtDao;
	}

	public TaifTOpfoDao getTaifTOpfoDao() {
		return taifTOpfoDao;
	}

	public void setTaifTOpfoDao(TaifTOpfoDao taifTOpfoDao) {
		this.taifTOpfoDao = taifTOpfoDao;
	}

	public TaifDNazioneDao getTaifDNazioneDao() {
		return taifDNazioneDao;
	}

	public void setTaifDNazioneDao(TaifDNazioneDao taifDNazioneDao) {
		this.taifDNazioneDao = taifDNazioneDao;
	}

	public TaifTCorsoDao getTaifTCorsoDao() {
		return taifTCorsoDao;
	}

	public void setTaifTCorsoDao(TaifTCorsoDao taifTCorsoDao) {
		this.taifTCorsoDao = taifTCorsoDao;
	}

	public TaifDTipoQualificaDao getTaifDTipoQualificaDao() {
		return taifDTipoQualificaDao;
	}

	public void setTaifDTipoQualificaDao(TaifDTipoQualificaDao taifDTipoQualificaDao) {
		this.taifDTipoQualificaDao = taifDTipoQualificaDao;
	}

	public TaifCnfEstensAmmDao getTaifCnfEstensAmmDao() {
		return taifCnfEstensAmmDao;
	}

	public void setTaifCnfEstensAmmDao(TaifCnfEstensAmmDao taifCnfEstensAmmDao) {
		this.taifCnfEstensAmmDao = taifCnfEstensAmmDao;
	}

	public TaifCnfParamApimgrDao getTaifCnfParamApimgrDao() {
		return taifCnfParamApimgrDao;
	}

	public void setTaifCnfParamApimgrDao(TaifCnfParamApimgrDao taifCnfParamApimgrDao) {
		this.taifCnfParamApimgrDao = taifCnfParamApimgrDao;
	}

	public TaifCnfMailDao getTaifCnfMailDao() {
		return taifCnfMailDao;
	}

	public void setTaifCnfMailDao(TaifCnfMailDao taifCnfMailDao) {
		this.taifCnfMailDao = taifCnfMailDao;
	}

	public TaifCnfTipoMailDao getTaifCnfTipoMailDao() {
		return taifCnfTipoMailDao;
	}

	public void setTaifCnfTipoMailDao(TaifCnfTipoMailDao taifCnfTipoMailDao) {
		this.taifCnfTipoMailDao = taifCnfTipoMailDao;
	}

	public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
		this.dozerBeanMapper = dozerBeanMapper;
		this.dozerBeanMapper.setMappingFiles(Arrays.asList("dozer-mapping.xml"));

	}

	@Autowired
	private ValidationMgr validationMgr;

	/**
	 * @return the serviceMgr
	 */
	public ServiceMgr getServiceMgr() {
		return serviceMgr;
	}

	/**
	 * @param serviceMgr
	 *            the serviceMgr to set
	 */
	public void setServiceMgr(ServiceMgr serviceMgr) {
		this.serviceMgr = serviceMgr;
	}

	private MsgMgr msgMgr;

	public MsgMgr getMsgMgr() {
		return this.msgMgr;
	}

	public void setMsgMgr(MsgMgr msgMgr) {
		this.msgMgr = msgMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	public void setTxManager(JtaTransactionManager txManager) {
		this.txManager = txManager;
	}

	public TaifTAgenziaFormativaDao getTaifTAgenziaFormativaDao() {
		return taifTAgenziaFormativaDao;
	}

	public void setTaifTAgenziaFormativaDao(TaifTAgenziaFormativaDao taifTAgenziaFormativaDao) {
		this.taifTAgenziaFormativaDao = taifTAgenziaFormativaDao;
	}

	public TaifDUnitaFormativaDao getTaifDUnitaFormativaDao() {
		return taifDUnitaFormativaDao;
	}

	public void setTaifDUnitaFormativaDao(TaifDUnitaFormativaDao taifDUnitaFormativaDao) {
		this.taifDUnitaFormativaDao = taifDUnitaFormativaDao;
	}

	public TaifCnfConfigUtenteDao getTaifCnfConfigUtenteDao() {
		return taifCnfConfigUtenteDao;
	}

	public void setTaifCnfConfigUtenteDao(TaifCnfConfigUtenteDao taifCnfConfigUtenteDao) {
		this.taifCnfConfigUtenteDao = taifCnfConfigUtenteDao;
	}

	public TaifTSoggettoGestoreDao getTaifTSoggettoGestoreDao() {
		return taifTSoggettoGestoreDao;
	}

	public void setTaifTSoggettoGestoreDao(TaifTSoggettoGestoreDao taifTSoggettoGestoreDao) {
		this.taifTSoggettoGestoreDao = taifTSoggettoGestoreDao;
	}

	public TaifDStatoOpfoDao getTaifDStatoOpfoDao() {
		return taifDStatoOpfoDao;
	}

	public void setTaifDStatoOpfoDao(TaifDStatoOpfoDao taifDStatoOpfoDao) {
		this.taifDStatoOpfoDao = taifDStatoOpfoDao;
	}

	public TaifDStatoPraticaDao getTaifDStatoPraticaDao() {
		return taifDStatoPraticaDao;
	}

	public void setTaifDStatoPraticaDao(TaifDStatoPraticaDao taifDStatoPraticaDao) {
		this.taifDStatoPraticaDao = taifDStatoPraticaDao;
	}
	
	

	/**
	 * @return the taifDAmbitoFormativoDao
	 */
	public TaifDAmbitoFormativoDao getTaifDAmbitoFormativoDao() {
		return taifDAmbitoFormativoDao;
	}

	/**
	 * @param taifDAmbitoFormativoDao the taifDAmbitoFormativoDao to set
	 */
	public void setTaifDAmbitoFormativoDao(TaifDAmbitoFormativoDao taifDAmbitoFormativoDao) {
		this.taifDAmbitoFormativoDao = taifDAmbitoFormativoDao;
	}

	public ProfiloUtenteTopFor getProfiloUtente(String codiceFiscale, Boolean isOperatore) throws ManagerException {
		log.debug("[DbMgr::getProfiloUtente] BEGIN ");
		ProfiloUtenteTopFor result = null;
		try {
			List<TaifCnfConfigUtenteProfiloByCodiceFiscaleDto> list = new ArrayList<TaifCnfConfigUtenteProfiloByCodiceFiscaleDto>();
			List<TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto> listOp = new ArrayList<TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto>();
			if (isOperatore) {
				listOp = this.taifCnfConfigUtenteDao.findProfiloByCodiceFiscaleOperatore(codiceFiscale);
				if (!listOp.isEmpty()) {
					TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto dto = listOp.get(0);
					result = dozerBeanMapper.map(dto, ProfiloUtenteTopFor.class);
				}
			} else {
				list = this.taifCnfConfigUtenteDao.findProfiloByCodiceFiscale(codiceFiscale);
				if (!list.isEmpty()) {
					TaifCnfConfigUtenteProfiloByCodiceFiscaleDto dto = list.get(0);
					result = dozerBeanMapper.map(dto, ProfiloUtenteTopFor.class);
				}
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProfiloUtente] END");
		}
		return result;
	}

	public ArrayList<CodeDescription> getAlbi(SoggettoGestoreVisibleOrdinFilter filter) throws DbManagerException {
		try {
			log.debug("[DbMgr::getAlbi] START");
			ArrayList<CodeDescription> alboList = new ArrayList<CodeDescription>();
			List<TaifTSoggettoGestoreByFilterVisibleDto> soggetto = taifTSoggettoGestoreDao.findByFilterVisible(filter);
			for (TaifTSoggettoGestoreByFilterVisibleDto taifTSoggettoGestoreByFilterDto : soggetto) {
				CodeDescription albo = new CodeDescription();
				albo.setCode(taifTSoggettoGestoreByFilterDto.getIdSoggettoGestore() + "");
				albo.setDescription(taifTSoggettoGestoreByFilterDto.getDenominazionebreve());
				alboList.add(albo);
				// no funziona
				// alboList.add(dozerBeanMapper.map(taifTSoggettoGestoreByFilterDto,
				// CodeDescription.class));
			}
			return alboList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getAlbi] END");
		}
	}

	public ArrayList<CodeDescription> getUnitaFormativa(SoggettoGestoreVisibleOrdinFilter filter, String linguaDati)
			throws DbManagerException {
		try {
			log.debug("[DbMgr::getUnitaFormativa] START");
			ArrayList<CodeDescription> unitaFormativaList = new ArrayList<CodeDescription>();
			List<TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto> list = taifDUnitaFormativaDao
					.findByFilterVisibleSoggettoGestore(filter);
			for (TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto taifDUnitaFormativaByFilterVisibleSoggettoGestoreDto : list) {
				CodeDescription unita = new CodeDescription();
				unita.setCode(taifDUnitaFormativaByFilterVisibleSoggettoGestoreDto.getIdUnitaFormativa() + "");
				if (ConvertUtil.checkIsNullOrEmpty(taifDUnitaFormativaByFilterVisibleSoggettoGestoreDto.getSigla())) {
					unita.setDescription(taifDUnitaFormativaByFilterVisibleSoggettoGestoreDto.getSigla() + " - "
							+ taifDUnitaFormativaByFilterVisibleSoggettoGestoreDto.getDenominazioneUnitaFormativa());
				} else {
					unita.setDescription(
							taifDUnitaFormativaByFilterVisibleSoggettoGestoreDto.getDenominazioneUnitaFormativa());
				}
				unitaFormativaList.add(unita);
				// no funziona
				// unitaFormativaList.add(dozerBeanMapper.map(taifTSoggettoGestoreByFilterDto,
				// CodeDescription.class));
			}
			return unitaFormativaList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getUnitaFormativa] END");
		}
	}

	public ArrayList<CodeDescription> getElencoQualifiche(SoggettoGestoreVisibleOrdinFilter filter, String linguaDati)
			throws DbManagerException {
		try {
			log.debug("[DbMgr::getElencoQualifiche] START");
			ArrayList<CodeDescription> qualificheList = new ArrayList<CodeDescription>();
			List<TaifDTipoQualificaByFilterVisibleDto> list = taifDTipoQualificaDao.findByFilterVisible(filter);
			for (TaifDTipoQualificaByFilterVisibleDto taifDTipoQualificaByFilterVisibleDto : list) {
				CodeDescription qualifica = new CodeDescription();
				qualifica.setCode(taifDTipoQualificaByFilterVisibleDto.getIdQualifica() + "");
				qualifica.setDescription(taifDTipoQualificaByFilterVisibleDto.getTipoQualifica());
				qualificheList.add(qualifica);
				// no funziona
				// qualificheList.add(dozerBeanMapper.map(taifDTipoQualificaByFilterVisibleDto,
				// CodeDescription.class));
			}
			return qualificheList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoQualifiche] END");
		}
	}

	public ArrayList<CodeDescription> getAgenziaFormativa(SoggettoGestoreVisibleOrdinFilter filter)
			throws DbManagerException {
		try {
			log.debug("[DbMgr::getAgenziaFormativa] START");
			ArrayList<CodeDescription> agenziaFormativaList = new ArrayList<CodeDescription>();
			List<TaifTAgenziaFormativaByFilterVisibleDto> list = taifTAgenziaFormativaDao.findByFilterVisible(filter);
			for (TaifTAgenziaFormativaByFilterVisibleDto taifTAgenziaFormativaByVisibleFilterDto : list) {
				agenziaFormativaList
						.add(dozerBeanMapper.map(taifTAgenziaFormativaByVisibleFilterDto, CodeDescription.class));
			}
			return agenziaFormativaList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getAgenziaFormativa] END");
		}
	}

	public ArrayList<CodeDescription> getAgenziaFormativaFromSoggettoGestore(SoggettoGestoreVisibleOrdinFilter filter,
			String linguaDati) throws DbManagerException {
		try {
			log.debug("[DbMgr::getAgenziaFormativa] START");
			ArrayList<CodeDescription> agenziaFormativaList = new ArrayList<CodeDescription>();
			List<TaifTAgenziaFormativaByFilterSoggettoGestoreDto> list = taifTAgenziaFormativaDao
					.findByFilterSoggettoGestore(filter);
			for (TaifTAgenziaFormativaByFilterSoggettoGestoreDto taifTAgenziaFormativaByFilterSoggettoGestoreDto : list) {

				agenziaFormativaList.add(
						dozerBeanMapper.map(taifTAgenziaFormativaByFilterSoggettoGestoreDto, CodeDescription.class));
				// agenzia.setCode(taifTAgenziaFormativaByFilterSoggettoGestoreDto.getIdAgenzia()
				// + "");
				//// agenzia.setDescription(taifTAgenziaFormativaByFilterSoggettoGestoreDto.getDsAgenziaFormativa());
				// agenziaFormativaList.add(agenzia);

			}
			return agenziaFormativaList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getAgenziaFormativa] END");
		}
	}

	public ArrayList<CodeDescription> getElencoUnitaFormativaFromAgenziaFormativa(AgenziaFormativaFilter filter)
			throws DbManagerException {
		try {
			log.debug("[DbMgr::AgenziaFormativaFilter] START");
			ArrayList<CodeDescription> agenziaFormativaList = new ArrayList<CodeDescription>();
			List<TaifDUnitaFormativaByFilterAgenziaFormativaDto> list = taifDUnitaFormativaDao
					.findByFilterAgenziaFormativa(filter);
			for (TaifDUnitaFormativaByFilterAgenziaFormativaDto taifDUnitaFormativaByFilterAgenziaFormativaDto : list) {
				CodeDescription agenzia = new CodeDescription();
				agenzia.setCode(taifDUnitaFormativaByFilterAgenziaFormativaDto.getIdUnitaFormativa() + "");
				String sigla = ConvertUtil.checkIsNullOrEmpty(taifDUnitaFormativaByFilterAgenziaFormativaDto.getSigla())
						? (taifDUnitaFormativaByFilterAgenziaFormativaDto.getSigla() + " - ")
						: "";
				agenzia.setDescription(sigla + taifDUnitaFormativaByFilterAgenziaFormativaDto.getDsUnitaFormativa());
				agenziaFormativaList.add(agenzia);
				// no funziona
				// unitaFormativaList.add(dozerBeanMapper.map(taifDUnitaFormativaByFilterAgenziaFormativaDto,
				// CodeDescription.class));
			}
			return agenziaFormativaList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::AgenziaFormativaFilter] END");
		}
	}

	public CorsoProfessionale getCorsoSelezionato(CorsoProfessionaleFilter filter, CpInserimentoOperatoreModel theModel)
			throws DbManagerException {
		try {
			log.debug("[DbMgr::UnitaFormativaFilter] START");
			CorsoProfessionale corso = new CorsoProfessionale();
			TaifTCorsoPk pk = new TaifTCorsoPk();
			pk.setIdCorso(new Integer(filter.getIdCorso()));
			TaifTCorsoDto corsoDto = taifTCorsoDao.findByPrimaryKey(pk);
			if (corsoDto != null) {
				corso.setIdCorsoProfessionale(corsoDto.getIdCorso() + "");
				corso.setTitoloCorso(corsoDto.getCorso());
				if (ConvertUtil.checkIsNullOrEmpty(corsoDto.getIstatSede())) {
					String sedeCorso = ConvertUtil.getDenominazioneComuneFromCodiceIstat(corsoDto.getIstatSede(),
							theModel.getAppDataelencoComuniRicercaOperatoreGestore());
					corso.setSedeCorso(sedeCorso);
				}
				String dataInizioCorso = "";
				String dataFineCorso = "";
				if (corsoDto.getDataInizio() != null) {
					dataInizioCorso = new SimpleDateFormat("dd/MM/yyyy").format(corsoDto.getDataInizio());
				}
				if (corsoDto.getDataFine() != null) {
					dataFineCorso = new SimpleDateFormat("dd/MM/yyyy").format(corsoDto.getDataFine());
				}
				if (ConvertUtil.checkIsNullOrEmpty(dataInizioCorso) && ConvertUtil.checkIsNullOrEmpty(dataFineCorso)) {
					corso.setPeriodoSvolgimento(dataInizioCorso + " - " + dataFineCorso);
				}
				corso.setNumeroOre(corsoDto.getNroOre() + "");
				// no funziona
				// unitaFormativaList.add(dozerBeanMapper.map(corsoDto,
				// CorsoProfessionale.class));

			}
			return corso;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::UnitaFormativaFilter] END");
		}
	}

	public ArrayList<CodeDescription> getElencoCorsiFromUnitaFormativa(UnitaFormativaFilter filter)
			throws DbManagerException {
		try {
			log.debug("[DbMgr::UnitaFormativaFilter] START");
			ArrayList<CodeDescription> corsoList = new ArrayList<CodeDescription>();
			List<TaifTCorsoByFilterUnitaFormativaDto> list = taifTCorsoDao.findByFilterUnitaFormativa(filter);
			for (TaifTCorsoByFilterUnitaFormativaDto taifDUnitaFormativaByFilterAgenziaFormativaDto : list) {
				CodeDescription corso = new CodeDescription();
				corso.setCode(taifDUnitaFormativaByFilterAgenziaFormativaDto.getIdCorso() + "");
				corso.setDescription(taifDUnitaFormativaByFilterAgenziaFormativaDto.getDsCorso());
				corsoList.add(corso);
				// no funziona
				// unitaFormativaList.add(dozerBeanMapper.map(taifDUnitaFormativaByFilterAgenziaFormativaDto,
				// CodeDescription.class));
			}
			return corsoList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::UnitaFormativaFilter] END");
		}
	}

	public ArrayList<CodeDescription> getElencoStatoScheda(SoggettoGestoreVisibleOrdinFilter filter, String linguaDati)
			throws DbManagerException {
		try {
			log.debug("[DbMgr::getElencoStatoScheda] START");
			ArrayList<CodeDescription> statoSchedaOperatoreList = new ArrayList<CodeDescription>();
			List<TaifDStatoOpfoByFilterVisibleDto> list = taifDStatoOpfoDao.findByFilterVisible(filter);
			for (TaifDStatoOpfoByFilterVisibleDto taifDStatoOpfoByFilterVisibleDto : list) {
				CodeDescription statoSchedaOperatore = new CodeDescription();
				statoSchedaOperatore.setCode(taifDStatoOpfoByFilterVisibleDto.getIdStatoOperatore() + "");
				if (ConvertUtil.checkIsNullOrEmpty(linguaDati)
						&& linguaDati.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.fLang)) {
					statoSchedaOperatore.setDescription(taifDStatoOpfoByFilterVisibleDto.getStatoOperatoreFra());
				} else {
					statoSchedaOperatore.setDescription(taifDStatoOpfoByFilterVisibleDto.getStatoOperatoreIta());
				}
				statoSchedaOperatoreList.add(statoSchedaOperatore);
				// no funziona
				// unitaFormativaList.add(dozerBeanMapper.map(taifTSoggettoGestoreByFilterDto,
				// CodeDescription.class));
			}
			return statoSchedaOperatoreList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoStatoScheda] END");
		}
	}

	/*
	 * public ArrayList<CodeDescription>
	 * getElencoAltriCorsiDenominazioni(VisibileOrdinFilter filter, String
	 * linguaDati) throws DbManagerException { try {
	 * log.debug("[DbMgr::getElencoAltriCorsiDenominazioni] START");
	 * ArrayList<CodeDescription> altriCorsiDenominazioniList = new
	 * ArrayList<CodeDescription>(); List<TaifTCorsoByFilterVisibleDto> list =
	 * taifTCorsoDao.findByFilterVisible(filter); for (TaifTCorsoByFilterVisibleDto
	 * taifTCorsoByFilterVisibleDto : list) { CodeDescription
	 * denominazioneAltroCorso = new CodeDescription();
	 * denominazioneAltroCorso.setCode(taifTCorsoByFilterVisibleDto.getIdCorso()+"")
	 * ; denominazioneAltroCorso.setDescription(taifTCorsoByFilterVisibleDto.
	 * getDsCorso()); altriCorsiDenominazioniList.add(denominazioneAltroCorso); //
	 * no funziona // altriCorsiDenominazioniList.add(dozerBeanMapper.map(
	 * taifTCorsoByFilterVisibleDto, CodeDescription.class)); } return
	 * altriCorsiDenominazioniList; } catch (Exception e) { throw new
	 * DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001)); } finally {
	 * log.debug("[DbMgr::getElencoAltriCorsiDenominazioni] END"); } }
	 */

	public ArrayList<CorsoProfessionale> getElencoAltriCorsiDenominazioni(VisibileOrdinFilter filter, String linguaDati)
			throws DbManagerException {
		try {
			log.debug("[DbMgr::getElencoAltriCorsiDenominazioni] START");
			ArrayList<CorsoProfessionale> altriCorsiDenominazioniList = new ArrayList<CorsoProfessionale>();
			List<TaifTCorsoByFilterVisibleDto> list = taifTCorsoDao.findByFilterVisible(filter);
			for (TaifTCorsoByFilterVisibleDto taifTCorsoByFilterVisibleDto : list) {
				CorsoProfessionale denominazioneAltroCorso = new CorsoProfessionale();
				denominazioneAltroCorso.setIdCorsoProfessionale(taifTCorsoByFilterVisibleDto.getIdCorso() + "");
				denominazioneAltroCorso.setTitoloCorso(taifTCorsoByFilterVisibleDto.getDsCorso());
				denominazioneAltroCorso.setFlgAltroCorso(taifTCorsoByFilterVisibleDto.getFlgAltroCorso() + "");

				altriCorsiDenominazioniList.add(denominazioneAltroCorso);
				// no funziona
				// altriCorsiDenominazioniList.add(dozerBeanMapper.map(taifTCorsoByFilterVisibleDto,
				// CodeDescription.class));
			}
			return altriCorsiDenominazioniList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoAltriCorsiDenominazioni] END");
		}
	}

	// findRicercaOperatoreAvanzata
	public ArrayList<TaifTOpfoRicercaOperatoreAvanzataDto> findRicercaOperatoreAvanzata(RicercaOperatoreFilter filter)
			throws DbManagerException {
		log.debug("[DbMgr::findRicercaAziendaAvanzata] BEGIN");
		try {
			ArrayList<TaifTOpfoRicercaOperatoreAvanzataDto> listOperatore = new ArrayList<TaifTOpfoRicercaOperatoreAvanzataDto>();
			listOperatore = (ArrayList<TaifTOpfoRicercaOperatoreAvanzataDto>) taifTOpfoDao
					.findRicercaOperatoreAvanzata(filter);
			return listOperatore;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findRicercaAziendaAvanzata] END");
		}
	}

	// findDettaglioOperatoreByIdPersona
	public ArrayList<TaifTPersonaDatiIdentificativiOperatoreDto> findDettaglioOperatoreByIdPersona(
			RicercaOperatoreFilter idOperatoreFilter) throws DbManagerException {
		log.debug("[DbMgr::findDettaglioOperatoreByIdPersona] BEGIN");
		try {
			ArrayList<TaifTPersonaDatiIdentificativiOperatoreDto> listOperatore = new ArrayList<TaifTPersonaDatiIdentificativiOperatoreDto>();
			listOperatore = (ArrayList<TaifTPersonaDatiIdentificativiOperatoreDto>) taifTPersonaDao
					.findDatiIdentificativiOperatore(idOperatoreFilter);
			return listOperatore;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findDettaglioOperatoreByIdPersona] END");
		}
	}

	public TaifTPersonaDao getTaifTPersonaDao() {
		return taifTPersonaDao;
	}

	public void setTaifTPersonaDao(TaifTPersonaDao taifTPersonaDao) {
		this.taifTPersonaDao = taifTPersonaDao;
	}

	// findRicercaNumeroAlboForestale
	public ArrayList<TaifTPersonaExtRicercaNumeroAlboForestaleDto> findRicercaNumeroAlboForestale(
			RicercaOperatoreFilter idOperatoreFilter) throws DbManagerException {
		log.debug("[DbMgr::findRicercaNumeroAlboForestale] BEGIN");
		try {
			ArrayList<TaifTPersonaExtRicercaNumeroAlboForestaleDto> listCorsiAbilitatiRegione = new ArrayList<TaifTPersonaExtRicercaNumeroAlboForestaleDto>();
			listCorsiAbilitatiRegione = (ArrayList<TaifTPersonaExtRicercaNumeroAlboForestaleDto>) taifTPersonaExtDao
					.findRicercaNumeroAlboForestale(idOperatoreFilter);
			return listCorsiAbilitatiRegione;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findRicercaNumeroAlboForestale] END");
		}
	}

	// findRicercaCorsiFinanziatiRegione
	public ArrayList<TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto> findRicercaCorsiFinanziatiRegione(
			RicercaOperatoreFilter idOperatoreFilter) throws DbManagerException {
		log.debug("[DbMgr::findRicercaCorsiFinanziatiRegione] BEGIN");
		try {
			ArrayList<TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto> listCorsiAbilitatiRegione = new ArrayList<TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto>();
			listCorsiAbilitatiRegione = (ArrayList<TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto>) taifTPersonaCorsiExtDao
					.findCorsiFinanziatiRegione(idOperatoreFilter);
			return listCorsiAbilitatiRegione;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findRicercaCorsiFinanziatiRegione] END");
		}
	}

	// findAltriCorsi
	public ArrayList<TaifTPersonaCorsiExtAltriCorsiDto> findAltriCorsi(RicercaOperatoreFilter idOperatoreFilter)
			throws DbManagerException {
		log.debug("[DbMgr::findRicercaCorsiFinanziatiRegione] BEGIN");
		try {
			ArrayList<TaifTPersonaCorsiExtAltriCorsiDto> listAltriCorsi = new ArrayList<TaifTPersonaCorsiExtAltriCorsiDto>();
			listAltriCorsi = (ArrayList<TaifTPersonaCorsiExtAltriCorsiDto>) taifTPersonaCorsiExtDao
					.findAltriCorsi(idOperatoreFilter);
			return listAltriCorsi;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findAltriCorsi] END");
		}
	}

	// findQualificaByIdPersonas
	public ArrayList<TaifTQualificaByIdPersonaDto> findQualificaByIdPersona(RicercaOperatoreFilter idOperatoreFilter)
			throws DbManagerException {
		log.debug("[DbMgr::findQualificaByIdPersona] BEGIN");
		try {
			ArrayList<TaifTQualificaByIdPersonaDto> listQualifiche = new ArrayList<TaifTQualificaByIdPersonaDto>();
			listQualifiche = (ArrayList<TaifTQualificaByIdPersonaDto>) taifTQualificaDao
					.findByIdPersona(idOperatoreFilter);
			return listQualifiche;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findQualificaByIdPersona] END");
		}
	}

	// findRiconoscimentoByIdPersona
	public ArrayList<TaifTRiconoscimentoByIdPersonaDto> findRiconoscimentoByIdPersona(
			RicercaOperatoreFilter idOperatoreFilter) throws DbManagerException {
		log.debug("[DbMgr::findRiconoscimentoByIdPersona] BEGIN");
		try {
			ArrayList<TaifTRiconoscimentoByIdPersonaDto> listRiconscimenti = new ArrayList<TaifTRiconoscimentoByIdPersonaDto>();
			listRiconscimenti = (ArrayList<TaifTRiconoscimentoByIdPersonaDto>) taifTRiconoscimentoDao
					.findByIdPersona(idOperatoreFilter);
			return listRiconscimenti;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findRiconoscimentoByIdPersona] END");
		}
	}

	// findNazione
	public ArrayList<CodeDescription> getElencoNazioni(SoggettoGestoreVisibleOrdinFilter filter, String linguaDati)
			throws DbManagerException {
		log.debug("[DbMgr::getElencoNazioni] BEGIN");
		try {
			ArrayList<CodeDescription> nazioneList = new ArrayList<CodeDescription>();
			ArrayList<TaifDNazioneByFilterVisibleDto> list = new ArrayList<TaifDNazioneByFilterVisibleDto>();
			filter.setFlagItaFr(linguaDati);
			list = (ArrayList<TaifDNazioneByFilterVisibleDto>) taifDNazioneDao.findByFilterVisible(filter);

			for (TaifDNazioneByFilterVisibleDto taifDNazioneByFilterVisibleDto : list) {
				CodeDescription nazione = new CodeDescription();
				nazione.setCode(taifDNazioneByFilterVisibleDto.getIdNazione() + "");
				if (!ConvertUtil.checkIsNullOrEmpty(linguaDati)
						&& linguaDati.equalsIgnoreCase(Constants.LINGUA_DATI_FRA)) {
					nazione.setDescription(taifDNazioneByFilterVisibleDto.getDsNazioneFra());
				} else {
					nazione.setDescription(taifDNazioneByFilterVisibleDto.getDsNazioneIta());
				}
				nazioneList.add(nazione);
				// no funziona
				// unitaFormativaList.add(dozerBeanMapper.map(taifTSoggettoGestoreByFilterDto,
				// CodeDescription.class));
			}

			return nazioneList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoNazioni] END");
		}
	}

	public it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAllegatoDto getTaifTAllegatoByPk(String idAllegato)
			throws DbManagerException {
		log.debug("[DbMgr::getTaifTAllegatoByPk] BEGIN");
		try {
			return this.taifTAllegatoDao
					.findByPrimaryKey(new TaifTAllegatoPk(ConvertUtil.convertToInteger(idAllegato)));
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getTaifTAllegatoByPk] END");
		}
	}

	public TaifTPersonaDatiIdentificativiOperatoreDto findDatiIdentificativiOperatore(RicercaOperatoreFilter op)
			throws DbManagerException {
		log.debug("[DbMgr::findByCodiceFiscalePersona] BEGIN ");
		TaifTPersonaDatiIdentificativiOperatoreDto operatoreDto = new TaifTPersonaDatiIdentificativiOperatoreDto();
		try {

			List<TaifTPersonaDatiIdentificativiOperatoreDto> personaPerCodiceFiscale = taifTPersonaDao
					.findDatiIdentificativiOperatore(op);
			if (personaPerCodiceFiscale != null && personaPerCodiceFiscale.size() > 0) {
				operatoreDto = personaPerCodiceFiscale.get(0);
			}

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findByCodiceFiscalePersona] END");
		}
		return operatoreDto;
	}

	public TaifTPersonaByCodiceFiscalePersonaDto findDatiIdentificativiPersona(RicercaOperatoreFilter op)
			throws DbManagerException {
		log.debug("[DbMgr::findDatiIdentificativiPersona] BEGIN ");
		TaifTPersonaByCodiceFiscalePersonaDto operatoreDto = new TaifTPersonaByCodiceFiscalePersonaDto();
		try {
			List<TaifTPersonaByCodiceFiscalePersonaDto> personaPerCodiceFiscale = taifTPersonaDao
					.findByCodiceFiscalePersona(op.getCodiceFiscale());
			if (personaPerCodiceFiscale != null && personaPerCodiceFiscale.size() > 0) {
				operatoreDto = personaPerCodiceFiscale.get(0);
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findDatiIdentificativiPersona] END");
		}
		return operatoreDto;
	}

	public ArrayList<CodeDescription> getElencoNazioniIta(int visibile) throws DbManagerException {
		log.debug("[DbMgr::getElencoFormaGiuridica] BEGIN");
		try {
			ArrayList<CodeDescription> elencoNazioni = new ArrayList<CodeDescription>();
			List<TaifDNazioneByNazioneItaVisibleDto> nazioneList = taifDNazioneDao.findByNazioneItaVisible(visibile);
			for (TaifDNazioneByNazioneItaVisibleDto nazIta : nazioneList) {
				elencoNazioni.add(dozerBeanMapper.map(nazIta, CodeDescription.class));
			}
			return elencoNazioni;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoFormaGiuridica] END");
		}
	}

	public ArrayList<CodeDescription> getElencoNazioniFra(int visibile) throws DbManagerException {
		log.debug("[DbMgr::getElencoFormaGiuridica] BEGIN");
		try {
			ArrayList<CodeDescription> elencoNazioni = new ArrayList<CodeDescription>();
			List<TaifDNazioneByNazioneFraVisibleDto> nazioneList = taifDNazioneDao.findByNazioneFraVisible(visibile);
			for (TaifDNazioneByNazioneFraVisibleDto nazFra : nazioneList) {
				elencoNazioni.add(dozerBeanMapper.map(nazFra, CodeDescription.class));
			}
			return elencoNazioni;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoFormaGiuridica] END");
		}
	}

	public ArrayList<CodeDescription> getElencoStatoOperatoreITA(int visibile) throws DbManagerException {
		log.debug("[DbMgr::getElencoStatoSchedaIta] BEGIN");
		try {
			ArrayList<CodeDescription> elencoStatoOp = new ArrayList<CodeDescription>();
			List<TaifDStatoOpfoByVisibileItaDto> nazioneList = taifDStatoOpfoDao.findByVisibileIta(visibile);
			for (TaifDStatoOpfoByVisibileItaDto statoIta : nazioneList) {
				elencoStatoOp.add(dozerBeanMapper.map(statoIta, CodeDescription.class));
			}
			return elencoStatoOp;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoStatoSchedaIta] END");
		}
	}

	public ArrayList<CodeDescription> getElencoStatoOperatoreFRA(int visibile) throws DbManagerException {
		log.debug("[DbMgr::getElencoStatoSchedaFra] BEGIN");
		try {
			ArrayList<CodeDescription> elencoStatoOp = new ArrayList<CodeDescription>();
			List<TaifDStatoOpfoByVisibileFraDto> statiList = taifDStatoOpfoDao.findByVisibileFra(visibile);
			for (TaifDStatoOpfoByVisibileFraDto statoFra : statiList) {
				elencoStatoOp.add(dozerBeanMapper.map(statoFra, CodeDescription.class));
			}
			return elencoStatoOp;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoStatoSchedaFra] END");
		}
	}

	public List<TaifTPersonaProfiloUtenteByCodiceFiscaleDto> getConfigProfiloUtenteByCodiceFiscale(
			ConfigProfiloFilter filtro) throws DbManagerException {
		log.debug("[DbMgr::getProfiloPerCodiceFiscale] BEGIN ");
		List<TaifTPersonaProfiloUtenteByCodiceFiscaleDto> persProfilo;
		try {
			persProfilo = taifTPersonaDao.findProfiloUtenteByCodiceFiscale(filtro);
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProfiloPerCodiceFiscale] END");
		}
		return persProfilo;
	}

	public List<TaifTPersonaByCodiceFiscalePersonaDto> findPersonaPerCodiceFiscale(String codiceFiscale)
			throws DbManagerException, TaifTPersonaDaoException {
		log.debug("[DbMgr::findPersonaPerCodiceFiscale] BEGIN");
		try {
			List<TaifTPersonaByCodiceFiscalePersonaDto> persoanaByCodiceFiscale = taifTPersonaDao
					.findByCodiceFiscalePersona(codiceFiscale);
			return persoanaByCodiceFiscale;
		} finally {
			log.debug("[DbMgr::findPersonaPerCodiceFiscale] END");
		}
	}

	public TaifTPersonaDto findPersonaByIdPersona(Integer idPersona)
			throws DbManagerException, TaifTPersonaDaoException {
		log.debug("[DbMgr::findPersonaByIdPersona] BEGIN");
		try {
			TaifTPersonaDto persoanaByCodiceFiscale = taifTPersonaDao.findByPrimaryKey(new TaifTPersonaPk(idPersona));
			return persoanaByCodiceFiscale;
		} finally {
			log.debug("[DbMgr::findPersonaByIdPersona] END");
		}
	}

	public Integer updatePersonaleOperatore(Integer idPersona, Operatore datiOperatore,
			Operatore datiOperatoreDettaglio, String idStatoNascita, String idComuneResidenza, String idComuneNascita,
			int idConfigUtente, String dataTracciato, String idStatoScheda) throws DbManagerException {
		log.debug("[DbMgr::updateColumnsForPersonaleAzienda] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			//TaifTPersonaDto personaForUpdate = new TaifTPersonaDto();
			TaifTPersonaDto operatoreInput = new TaifTPersonaDto();
			TaifTOpfoDto operatoreForestale = new TaifTOpfoDto();

			
//			List<TaifTPersonaByCodiceFiscalePersonaDto> titolarePerCodiceFiscale = findPersonaPerCodiceFiscale(
//					datiOperatore.getCodiceFiscaleOperatore());
//			if (titolarePerCodiceFiscale.size() > 1) {
//				for (TaifTPersonaByCodiceFiscalePersonaDto taifTPersonaByCodiceFiscalePersonaDto : titolarePerCodiceFiscale) {
//					if (taifTPersonaByCodiceFiscalePersonaDto.getCognome()
//							.equalsIgnoreCase(datiOperatore.getCognomeOperatore())
//							&& taifTPersonaByCodiceFiscalePersonaDto.getNome()
//									.equalsIgnoreCase(datiOperatore.getNomeOperatore())) {
//						personaForUpdate = getPersonaByIdPersona(taifTPersonaByCodiceFiscalePersonaDto.getIdPersona());
//						idPersona = taifTPersonaByCodiceFiscalePersonaDto.getIdPersona();
//						break;
//					}
//				}
//			} else {
//				personaForUpdate = getPersonaByIdPersona(titolarePerCodiceFiscale.get(0).getIdPersona());
//				idPersona = titolarePerCodiceFiscale.get(0).getIdPersona();
//			}
			
			
			operatoreInput = dozerBeanMapper.map(datiOperatore, TaifTPersonaDto.class);
			if (dataTracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.fLang)) {
				operatoreInput.setNRsiMsa(datiOperatore.getNRsiMsa());
			}
			operatoreInput.setIdPersona(idPersona);
			
			// Patch provvisoria in attesa di modificare l'interfaccia
			
			
			
			
//			operatoreInput.setFkTitoloStudio(personaForUpdate.getFkTitoloStudio());
//			operatoreInput.setFkTitoloStudioFra(personaForUpdate.getFkTitoloStudioFra());
			if (dataTracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
				operatoreInput.setIstatComuneNascita(idComuneNascita);
				operatoreInput.setIstatComuneRes(idComuneResidenza);
			} else {
				operatoreInput.setComuneEsteroNascita(datiOperatore.getComuneEsteroNascitaOperatore());
				operatoreInput.setComuneEsteroRes(datiOperatore.getComuneEsteroResidenzaOperatore());

			}
			operatoreInput.setFkNazione(Integer.parseInt(idStatoNascita));
			operatoreInput.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			operatoreInput.setFkConfigUtente(idConfigUtente);

			taifTPersonaDao.updateColumnsByIdPersona(operatoreInput);

			TaifTOpfoDto opeForestaliTrovati = taifTOpfoDao.findByPrimaryKey(new TaifTOpfoPk(idPersona));
			if (opeForestaliTrovati != null && opeForestaliTrovati.getIdPersona() != null) {
				operatoreForestale.setFkConfigUtente(idConfigUtente);
				if (datiOperatore.getStatoOperatore() != null && datiOperatore.getStatoOperatore()
						.equals(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_RB_SI)) {
					opeForestaliTrovati
							.setFlgPubblico(new BigDecimal(it.csi.taif.topforweb.business.dao.util.Constants.oneInt));
				} else {
					opeForestaliTrovati
							.setFlgPubblico(new BigDecimal(it.csi.taif.topforweb.business.dao.util.Constants.zeroInt));
				}
				opeForestaliTrovati.setFkStatoOpfo(new Integer(idStatoScheda));
				opeForestaliTrovati.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				opeForestaliTrovati.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				;
				taifTOpfoDao.updateColumnsByIdOperatoriForestali(opeForestaliTrovati);
			} else {
				operatoreForestale = dozerBeanMapper.map(datiOperatore, TaifTOpfoDto.class);
				operatoreForestale.setFkConfigUtente(idConfigUtente);
				if (datiOperatore.getStatoOperatore() != null && datiOperatore.getStatoOperatore()
						.equals(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_RB_SI)) {
					operatoreForestale
							.setFlgPubblico(new BigDecimal(it.csi.taif.topforweb.business.dao.util.Constants.oneInt));
				} else {
					operatoreForestale
							.setFlgPubblico(new BigDecimal(it.csi.taif.topforweb.business.dao.util.Constants.zeroInt));
				}
				operatoreForestale.setFkStatoOpfo(it.csi.taif.topforweb.business.dao.util.Constants.oneInt);
				operatoreForestale.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				operatoreForestale.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				taifTOpfoDao.insert(operatoreForestale);
			}
			utx.commit();
		} catch (Exception e) {
			log.error("[DbMgr::updateColumnsForPersonaleAzienda] Rollback successo  ", e);
			try {
				utx.rollback();
			} catch (Exception e2) {
				log.error("[DbMgr::updateColumnsForPersonaleAzienda] Rollback exception ", e2);
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::updateColumnsForPersonaleAzienda] END");
		}
		return idPersona;
	}

	public Integer salvaPersonale(Operatore datiOperatore, Operatore datiOperatoreDettaglio,
			String statoNascitaOperatore, String idComuneResidenza, String idComuneNascita, int idConfigUtente,
			String dataTracciato) throws DbManagerException {
		log.debug("[DbMgr::salvaPersonale] BEGIN");
		TaifTPersonaPk personaPK = new TaifTPersonaPk();
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			TaifTPersonaDto personaToInsert = new TaifTPersonaDto();
			TaifTOpfoDto operatoreForestale = new TaifTOpfoDto();

			if (datiOperatore != null) {
				personaToInsert = dozerBeanMapper.map(datiOperatore, TaifTPersonaDto.class);
				personaToInsert.setFkConfigUtente(idConfigUtente);
				personaToInsert.setFkNazione(Integer.parseInt(it.csi.taif.topforweb.business.dao.util.Constants.one));

				if (dataTracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
					personaToInsert.setCodiceFiscale(datiOperatore.getCodiceFiscaleOperatore());
					personaToInsert.setFkTitoloStudioFra(
							Integer.parseInt(it.csi.taif.topforweb.business.dao.util.Constants.zero));
					personaToInsert.setFkTitoloStudio(
							Integer.parseInt(it.csi.taif.topforweb.business.dao.util.Constants.zero));
					personaToInsert.setIstatComuneNascita(idComuneNascita);
					personaToInsert.setIstatComuneRes(idComuneResidenza);
					personaToInsert.setNRsiMsa(null);
				} else {
					personaToInsert.setNRsiMsa(datiOperatore.getCodiceFiscaleOperatore());
					personaToInsert.setFkTitoloStudioFra(
							Integer.parseInt(it.csi.taif.topforweb.business.dao.util.Constants.zero));
					personaToInsert.setFkTitoloStudio(
							Integer.parseInt(it.csi.taif.topforweb.business.dao.util.Constants.zero));
					personaToInsert.setComuneEsteroNascita(datiOperatore.getComuneEsteroResidenzaOperatore());
					personaToInsert.setComuneEsteroRes(datiOperatore.getComuneEsteroResidenzaOperatore());
					personaToInsert.setCodiceFiscale(null);
				}
				personaToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				personaToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				personaPK = taifTPersonaDao.insert(personaToInsert);

				// op forestale

				operatoreForestale = dozerBeanMapper.map(datiOperatore, TaifTOpfoDto.class);
				operatoreForestale.setIdPersona(personaPK.getIdPersona());
				operatoreForestale.setFkConfigUtente(idConfigUtente);
				if (datiOperatore.getStatoOperatore() != null && datiOperatore.getStatoOperatore()
						.equals(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_RB_SI)) {
					operatoreForestale
							.setFlgPubblico(new BigDecimal(it.csi.taif.topforweb.business.dao.util.Constants.oneInt));
				} else {
					operatoreForestale
							.setFlgPubblico(new BigDecimal(it.csi.taif.topforweb.business.dao.util.Constants.zeroInt));
				}
				operatoreForestale.setFkStatoOpfo(it.csi.taif.topforweb.business.dao.util.Constants.oneInt);
				operatoreForestale.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				operatoreForestale.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
				taifTOpfoDao.insert(operatoreForestale);

			}
			utx.commit();

		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::salvaPersonale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::salvaPersonale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::salvaPersonale] END");
		}
		return personaPK.getIdPersona();
	}

	public TaifTPersonaDto getPersonaByIdPersona(Integer idPersona) throws DbManagerException {
		log.debug("[DbMgr::getPersonaByIdPersona] BEGIN");
		try {
			TaifTPersonaDto personaByIdPersona = taifTPersonaDao.findByPrimaryKey(new TaifTPersonaPk(idPersona));
			if (personaByIdPersona != null) {
				return personaByIdPersona;
			} else {
				return new TaifTPersonaDto();
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPersonaByIdPersona] END");
		}
	}

	// se l'Accesso è 1/2 (operatore) il profilo è 6 (operatore)
	// se l'Accesso è 3/4 (gestore) il profilo può essere 7 (agenzia), 8 (admin) o 9
	// (superadmin)

	public Integer findUserCollegatoPerCodiceFiscale(PersonaFilter filterPersona, String tracciato)
			throws DbManagerException {
		log.debug("[DbMgr::findUserCollegatoPerCodiceFiscale] BEGIN ");
		UserTransaction utx = txManager.getUserTransaction();
		List<TaifTPersonaByFilterDto> personaCollegataTrovata;
		Integer idConfigUtente = 0;
		TaifTPersonaDto taifTPersonaDto;
		try {
			utx.begin();
			personaCollegataTrovata = taifTPersonaDao.findByFilter(filterPersona);
			if (personaCollegataTrovata != null && !personaCollegataTrovata.isEmpty()) {
				for (TaifTPersonaByFilterDto taifTPersonaByFilterDto : personaCollegataTrovata) {
					// trovata persona
					PersonaSoggettogestoreFilter personaSoggettogestoreFilter = new PersonaSoggettogestoreFilter();
					personaSoggettogestoreFilter.setIdPersona(taifTPersonaByFilterDto.getIdPersona());
					personaSoggettogestoreFilter
							.setIdSoggettoGestore(it.csi.taif.topforweb.business.dao.util.Constants.zeroInt);
					personaSoggettogestoreFilter.setIdProfilo(filterPersona.getIdProfiloUtente());
					List<TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto> trovatoProfiloPersona = taifCnfConfigUtenteDao
							.findProfiloByIdPersonaIdSoggettoGestore(personaSoggettogestoreFilter);
					if (trovatoProfiloPersona != null && !trovatoProfiloPersona.isEmpty()) {
						// ok
						idConfigUtente = trovatoProfiloPersona.get(0).getIdConfigUtente();
					} else {
						// no trovato profilo persona ma esiste persona
						if (filterPersona.getIdProfiloUtente() != 7 && filterPersona.getIdProfiloUtente() != 8
								&& filterPersona.getIdProfiloUtente() != 9) {
							// no profilo 7,8,9
							idConfigUtente = insertConfigPersonaPerProfilo(filterPersona,
									taifTPersonaByFilterDto.getIdPersona());
						}
					}
				}
			} else {
				if (filterPersona.getIdProfiloUtente() != 7 && filterPersona.getIdProfiloUtente() != 8
						&& filterPersona.getIdProfiloUtente() != 9) {
					// insert persona
					TaifTPersonaDto personaToInsert = new TaifTPersonaDto();
					if (filterPersona.getIdNazione() == 1) {
						personaToInsert.setCodiceFiscale(filterPersona.getCodiceFiscale());
					} else {
						personaToInsert.setNRsiMsa(filterPersona.getCodiceFiscale());
					}
					personaToInsert.setNome(filterPersona.getNome());
					personaToInsert.setCognome(filterPersona.getCognome());
					personaToInsert.setDataInserimento(new Timestamp(System.currentTimeMillis()));
					personaToInsert.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
					personaToInsert.setFkTitoloStudio(0);
					personaToInsert.setFkTitoloStudioFra(0);
					personaToInsert.setFkNazione(filterPersona.getIdNazione());
					TaifTPersonaPk personaPk = taifTPersonaDao.insert(personaToInsert);

					idConfigUtente = insertConfigPersonaPerProfilo(filterPersona, personaPk.getIdPersona());
				}
			}
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::findUserCollegatoPerCodiceFiscale] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::findUserCollegatoPerCodiceFiscale] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findUserCollegatoPerCodiceFiscale] END");
		}
		return idConfigUtente;
	}

	private int insertConfigPersonaPerProfilo(PersonaFilter filterPersona, int idPersona) {

		TaifCnfConfigUtenteDto configUtenteInsert = new TaifCnfConfigUtenteDto();
		configUtenteInsert.setFkPersona(idPersona);
		configUtenteInsert
				.setFkSoggettoGestore(Integer.parseInt(it.csi.taif.topforweb.business.dao.util.Constants.zero));
		configUtenteInsert.setFkProfiloUtente(filterPersona.getIdProfiloUtente());
		configUtenteInsert.setDataPrimoAccesso(new Timestamp(System.currentTimeMillis()));
		configUtenteInsert.setDataUltimoAccesso(new Timestamp(System.currentTimeMillis()));
		configUtenteInsert.setNrAccessi(0);

		Integer idConfigUtente = taifCnfConfigUtenteDao.insert(configUtenteInsert).getIdConfigUtente();
		return idConfigUtente;
	}

	public TaifCnfConfigUtenteDto findConfigUtenteByPrimaryKey(Integer idConfigUtente) throws DbManagerException {
		log.debug("[DbMgr::findConfigUtenteByPrimaryKey] BEGIN ");
		TaifCnfConfigUtenteDto configUtenteDto = new TaifCnfConfigUtenteDto();
		log.debug("[DbMgr::updateColumnsForPersonaleAzienda] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			configUtenteDto = taifCnfConfigUtenteDao.findByPrimaryKey(new TaifCnfConfigUtentePk(idConfigUtente));
			int numeroAccessi = configUtenteDto.getNrAccessi();
			configUtenteDto.setNrAccessi(++numeroAccessi);
			configUtenteDto.setDataUltimoAccesso(new Timestamp(System.currentTimeMillis()));
			taifCnfConfigUtenteDao.updateColumnsConfigUtente(configUtenteDto);
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
				log.info("[DbMgr::updatePersonaleFrancese] Rollback successo  ");
			} catch (Exception e2) {
				log.debug("[DbMgr::updatePersonaleFrancese] Rollback exception ");
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::updatePersonaleFrancese] END");
		}

		return configUtenteDto;
	}

	public Integer insertAllegato(int idCorso, int idPersona, Allegato allegato, CorsoProfessionale corso,
			int idConfigUtente) throws DbManagerException {
		log.debug("[DbMgr::insertAllegato] BEGIN");
		try {
			TaifTAllegatoDto taifTAllegato = dozerBeanMapper.map(allegato, TaifTAllegatoDto.class);
			taifTAllegato.setDataAggiornamento(DateUtil.getTimestampDataCorrente());
			taifTAllegato.setDataInserimento(DateUtil.getTimestampDataCorrente());
			taifTAllegato.setDataUpload(DateUtil.getTimestampDataCorrente());
			taifTAllegato.setFkCorso(idCorso);
			taifTAllegato.setNomeFile(allegato.getNomeFile());
			taifTAllegato.setFkPersona(idPersona);
			taifTAllegato.setFkPratica(null);
			if (ConvertUtil.checkIsNullOrEmpty(corso.getAttestatoConScadenza())) {
				taifTAllegato.setFlgScadenza(new BigDecimal(corso.getAttestatoConScadenza()));
			} else {
				taifTAllegato.setFlgScadenza(new BigDecimal(0));
			}

			taifTAllegato.setDimensioneFileKb(new Integer(allegato.getDimensioneFileKb()));
			String estensione = org.apache.commons.lang3.StringUtils.substringAfterLast(allegato.getNomeFile(), ".");
			taifTAllegato.setEstensioneFile(estensione);
			taifTAllegato.setFkEstensioneFile(Constants.ID_ESTENSIONE_ALLEGATO_PDF);
			taifTAllegato.setFkConfigUtente(idConfigUtente);
			taifTAllegato.setFkTipoAllegato(Constants.ID_TIPO_ALLEGATO_ATTESTATO);

			TaifTAllegatoPk pk = this.taifTAllegatoDao.insert(taifTAllegato);
			return pk.getIdAllegato();
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::insertAllegato] END");
		}
	}

	public Integer insertROpfoCorso(int idCorso, int idPersona, Allegato allegato, CorsoProfessionale corso,
			int idConfigUtente) throws DbManagerException {
		log.debug("[DbMgr::insertROpfoCorso] BEGIN");
		try {
			TaifROpfoCorsoDto taifRopfoCorso = new TaifROpfoCorsoDto();
			taifRopfoCorso.setDataAggiornamento(DateUtil.getTimestampDataCorrente());
			taifRopfoCorso.setDataInserimento(DateUtil.getTimestampDataCorrente());
			taifRopfoCorso.setDescrizioneAltro(corso.getDescrizioneAltroCorso());
			taifRopfoCorso.setFkConfigUtente(idConfigUtente);
			taifRopfoCorso.setFlgEsito(corso.getEsitoCorso());
			taifRopfoCorso.setIdCorso(idCorso);
			taifRopfoCorso.setIdPersona(idPersona);

			TaifROpfoCorsoPk pk = this.taifROpfoCorsoDao.insert(taifRopfoCorso);
			return pk.getIdCorso();
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::insertROpfoCorso] END");
		}
	}

	public String getStatoNascitaOperatore(int idStatoNascitaOperatore, String dataTracciato)
			throws DbManagerException {
		log.debug("[DbMgr::insertROpfoCorso] BEGIN");
		try {
			String result = Constants.blank;
			TaifDNazioneDto nazione = taifDNazioneDao.findByPrimaryKey(new TaifDNazionePk(idStatoNascitaOperatore));
			if (dataTracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.fLang)) {
				result = nazione.getNazioneFra();
			} else {
				result = nazione.getNazioneIta();
			}
			return result;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::insertROpfoCorso] END");
		}
	}

	public Integer getPersonaFromCnfUtente(int idConfigUtente) throws DbManagerException {
		log.debug("[DbMgr::getPersonaFromCnfUtente] BEGIN");
		try {
			Integer idPersona = null;
			TaifCnfConfigUtenteDto configUtenteDto = taifCnfConfigUtenteDao
					.findByPrimaryKey(new TaifCnfConfigUtentePk(idConfigUtente));
			if (configUtenteDto != null) {
				idPersona = configUtenteDto.getFkPersona();
			}
			return idPersona;
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getPersonaFromCnfUtente] END");
		}
	}

	public void rollBack(int idCorso, int idPersona, int idAllegato) throws DbManagerException {
		log.debug("[DbMgr::rollBack] BEGIN");
		try {
			if (ConvertUtil.checkIntIsNullOrZero(idAllegato)) {
				TaifTAllegatoPk pkAllegato = new TaifTAllegatoPk();
				pkAllegato.setIdAllegato(idAllegato);
				this.taifTAllegatoDao.delete(pkAllegato);
			}
			TaifROpfoCorsoPk pk = new TaifROpfoCorsoPk();
			pk.setIdCorso(idCorso);
			pk.setIdPersona(idPersona);
			this.taifROpfoCorsoDao.delete(pk);

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::rollBack] END");
		}
	}

	public UserInfo accessFromUserPassword(LoginInfo info) throws ManagerException {
		log.debug("[DbMgr::accessFromUserPassword] BEGIN ");
		UserInfo result = null;
		try {
			List<TaifTPersonaDto> list = this.taifTPersonaDao.findLoginInfo(info);
			if (list != null && !list.isEmpty()) {
				result = dozerBeanMapper.map(list.get(0), UserInfo.class);
				result.setNazionalita(Constants.LINGUA_DATI_FRA);
			} else {
				throw new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.U001));
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::accessFromUserPassword] END");
		}
		return result;
	}

	public ProfiloUtenteTopFor getProfiloUtenteGestore(String codiceFiscale) throws ManagerException {
		log.debug("[DbMgr::getProfiloUtente] BEGIN ");
		ProfiloUtenteTopFor result = null;
		try {
			List<TaifCnfConfigUtenteProfiloByCodiceFiscaleDto> list = this.taifCnfConfigUtenteDao
					.findProfiloByCodiceFiscale(codiceFiscale);
			if (list != null && !list.isEmpty()) {
				TaifCnfConfigUtenteProfiloByCodiceFiscaleDto dto = list.get(0);
				result = dozerBeanMapper.map(dto, ProfiloUtenteTopFor.class);
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getProfiloUtente] END");
		}
		return result;
	}

	public Operatore getOperatoreFromPersona(int idPersona, String dataTracciato) throws ManagerException {
		log.debug("[DbMgr::getOperatoreFromPersona] BEGIN ");
		Operatore result = new Operatore();
		try {
			TaifTPersonaDto personaTrovata = taifTPersonaDao.findByPrimaryKey(new TaifTPersonaPk(idPersona));
			if (dataTracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.fLang)) {
				personaTrovata.setCodiceFiscale(personaTrovata.getNRsiMsa());
			}
			if (personaTrovata != null && personaTrovata.getCodiceFiscale() != null) {
				result = dozerBeanMapper.map(personaTrovata, Operatore.class);
				// Il mapping è stato portato a questo punto perchè se 
				// non trova la persona restituisce almeno l'oggetto valorizzato
				// con alcune properties
				try {
					TaifTOpfoDto r = taifTOpfoDao.findByPrimaryKey(new TaifTOpfoPk(idPersona));
					if(r!=null) {
						
						result.setStatoOperatore(r.getFlgPubblico() + "");
	
						if (r.getFlgPubblico().intValue() == it.csi.taif.topforweb.business.dao.util.Constants.oneInt) {
							result.setStatoOperatore(
									it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_RB_SI);
						} else if (r.getFlgPubblico()
								.intValue() == it.csi.taif.topforweb.business.dao.util.Constants.zeroInt) {
							result.setStatoOperatore(
									it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_RB_NO);
						}
	
						result.setStatoScheda(r.getFkStatoOpfo() + "");
						RicercaOperatoreFilter t = new RicercaOperatoreFilter();
						t.setIdPersona(idPersona + "");
						List<TaifTPersonaExtRicercaNumeroAlboForestaleDto> associatoAziendaIscrittaAlboRegione = taifTPersonaExtDao
								.findRicercaNumeroAlboForestale(t);
	
						String numeroAlboForestale = "NO";
						if (associatoAziendaIscrittaAlboRegione != null
								&& associatoAziendaIscrittaAlboRegione.size() != 0) {
							String numero = associatoAziendaIscrittaAlboRegione.get(0).getNumeroAlboForestale();
							numeroAlboForestale = ConvertUtil.checkIsNullOrEmpty(numero)
									? "SI &emsp;&emsp;<b>numero albo<b>:    " + numero
									: "NO";
						}
						result.setAssociatoAziendaIscrittaAlboForestaleENumeroAlbo(numeroAlboForestale);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (dataTracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
				result.setTitoloStudioIta(String.valueOf(personaTrovata.getFkTitoloStudio()));
			} else {
				result.setTitoloStudioFra(String.valueOf(personaTrovata.getFkTitoloStudioFra()));
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getOperatoreFromPersona] END");
		}
		return result;
	}

	public List<TaifTPersonaByFilterDto> findPersonaPerCodiceFiscale(PersonaFilter personaFilter)
			throws DbManagerException {
		log.debug("[DbMgr::findPersonaPerCodiceFiscale] BEGIN");
		try {
			List<TaifTPersonaByFilterDto> listOperatore = new ArrayList<TaifTPersonaByFilterDto>();
			listOperatore = taifTPersonaDao.findByFilter(personaFilter);
			return listOperatore;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findPersonaPerCodiceFiscale] END");
		}
	}

	public ArrayList<CodeDescription> findCorsiPerAgenziaUnita(CorsoFormazioneFilter corsoFilter)
			throws DbManagerException {
		log.debug("[DbMgr::findCorsiPerAgenziaUnita] BEGIN");
		try {
			List<TaifTCorsoCorsiPerAgenziaUnitaDto> listCorsiFormazione = new ArrayList<TaifTCorsoCorsiPerAgenziaUnitaDto>();
			ArrayList<CodeDescription> corsiList = new ArrayList<CodeDescription>();
			listCorsiFormazione = taifTCorsoDao.findCorsiPerAgenziaUnita(corsoFilter);
			for (TaifTCorsoCorsiPerAgenziaUnitaDto taifTCorsoCorsiPerAgenziaUnitaDto : listCorsiFormazione) {
				String conc = taifTCorsoCorsiPerAgenziaUnitaDto.getDescrizioneCorsoCorso();
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				if (taifTCorsoCorsiPerAgenziaUnitaDto.getDataInizioCorso() != null) {
					conc = conc + " (" + df.format(taifTCorsoCorsiPerAgenziaUnitaDto.getDataInizioCorso());
				}
				if (taifTCorsoCorsiPerAgenziaUnitaDto.getDataFineCorso() != null) {
					conc = conc + " - " + df.format(taifTCorsoCorsiPerAgenziaUnitaDto.getDataFineCorso()) + ")";
				} else {
					conc = conc + ")";
				}
				taifTCorsoCorsiPerAgenziaUnitaDto.setDescrizioneCorsoCorso(conc);
				corsiList.add(dozerBeanMapper.map(taifTCorsoCorsiPerAgenziaUnitaDto, CodeDescription.class));
			}
			return corsiList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findCorsiPerAgenziaUnita] END");
		}
	}

	public List<TaifROpfoCorsoByIdPersonaDto> findByIdPersona(int idPersona) throws DbManagerException {
		log.debug("[DbMgr::findCorsiPerAgenziaUnita] BEGIN");
		try {
			List<TaifROpfoCorsoByIdPersonaDto> rOpfoCorsoList = new ArrayList<TaifROpfoCorsoByIdPersonaDto>();
			rOpfoCorsoList = taifROpfoCorsoDao.findByIdPersona(idPersona);
			return rOpfoCorsoList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findCorsiPerAgenziaUnita] END");
		}
	}

	public TaifTSoggettoGestoreDto findSoggettoGestoreById(int id) throws DbManagerException {
		log.debug("[DbMgr::findSoggettoGestoreById] BEGIN");
		try {
			TaifTSoggettoGestoreDto sogg = taifTSoggettoGestoreDao.findByPrimaryKey(new TaifTSoggettoGestorePk(id));
			return sogg;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findSoggettoGestoreById] END");
		}
	}

	public void deleteOpfoCorso(int idCorso, int idPersona) throws DbManagerException {
		log.debug("[DbMgr::deleteOpfoCorso] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();

			List<TaifTAllegatoByCorsoPersonaDto> allegatoDaCancell = new ArrayList<TaifTAllegatoByCorsoPersonaDto>();
			TaifTAllegatoDto allegato = new TaifTAllegatoDto();
			TaifROpfoCorsoDto corsoOpfoDao = new TaifROpfoCorsoDto();
			AllegatoFilter allegatoFilter = new AllegatoFilter();
			allegatoFilter.setIdCorso(idCorso);
			allegatoFilter.setIdPersona(idPersona);

			allegatoDaCancell = taifTAllegatoDao.findByCorsoPersona(allegatoFilter);
			for (TaifTAllegatoByCorsoPersonaDto taifTAllegatoByCorsoPersonaDto : allegatoDaCancell) {
				allegato = taifTAllegatoDao
						.findByPrimaryKey(new TaifTAllegatoPk(taifTAllegatoByCorsoPersonaDto.getIdAllegato()));
				if (allegato != null) {
					taifTAllegatoDao.delete(new TaifTAllegatoPk(allegato.getIdAllegato()));
				}
			}

			corsoOpfoDao = taifROpfoCorsoDao.findByPrimaryKey(new TaifROpfoCorsoPk(idCorso, idPersona));
			if (corsoOpfoDao != null) {
				taifROpfoCorsoDao.delete(corsoOpfoDao);
			}
			utx.commit();
		} catch (Exception e) {
			try {
				log.info("[DbMgr::deleteOpfoCorso] Rollback successo  ", e);
				utx.rollback();
			} catch (Exception e2) {
				log.error("[DbMgr::deleteOpfoCorso] Rollback exception ", e2);
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::deleteOpfoCorso] END");
		}
	}

	public Integer insertQualificaOperatore(Qualifica qualificaOperatore, int idPerosna, int idConfigUtente)
			throws DbManagerException {
		log.debug("[DbMgr::insertQualificaOperatore] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();

			TaifTQualificaDto qualificaDto = new TaifTQualificaDto();
			qualificaDto = dozerBeanMapper.map(qualificaOperatore, TaifTQualificaDto.class);
			qualificaDto.setFkPersona(idPerosna);
			qualificaDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
			qualificaDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			qualificaDto.setFkConfigUtente(idConfigUtente);
			TaifTQualificaPk qualificaPk = taifTQualificaDao.insert(qualificaDto);

			utx.commit();

			return qualificaPk.getIdQualifica();
		} catch (Exception e) {
			try {
				log.info("[DbMgr::insertQualificaOperatore] Rollback successo  ", e);
				utx.rollback();
			} catch (Exception e2) {
				log.error("[DbMgr::insertQualificaOperatore] Rollback exception ", e2);
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::insertQualificaOperatore] END");
		}
	}

	public Integer insertRiconoscimentoCorso(Riconoscimento riconoscimentoCorso, int idPersoana, int idConfigUtente)
			throws DbManagerException {
		log.debug("[DbMgr::insertRiconoscimentoCorso] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();

			TaifTRiconoscimentoDto riconoscimentoDto = new TaifTRiconoscimentoDto();
			riconoscimentoDto = dozerBeanMapper.map(riconoscimentoCorso, TaifTRiconoscimentoDto.class);
			riconoscimentoDto.setDataInserimento(new Timestamp(System.currentTimeMillis()));
			riconoscimentoDto.setDataAggiornamento(new Timestamp(System.currentTimeMillis()));
			riconoscimentoDto.setFkPersona(idPersoana);
			riconoscimentoDto.setFkConfigUtente(idConfigUtente);
			TaifTRiconoscimentoPk riconoscimentoPk = taifTRiconoscimentoDao.insert(riconoscimentoDto);

			utx.commit();

			return riconoscimentoPk.getIdRiconoscimento();
		} catch (Exception e) {
			try {
				log.info("[DbMgr::insertRiconoscimentoCorso] Rollback successo  ", e);
				utx.rollback();
			} catch (Exception e2) {
				log.error("[DbMgr::insertRiconoscimentoCorso] Rollback exception ", e2);
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::insertRiconoscimentoCorso] END");
		}
	}

	public Qualifica findQualificaByPrimaryKey(int idQualifica) throws DbManagerException {
		log.debug("[DbMgr::findQualificaByPrimaryKey] BEGIN");
		try {
			TaifTQualificaDto qualificaInserita = new TaifTQualificaDto();
			Qualifica qualifica = new Qualifica();
			qualificaInserita = taifTQualificaDao.findByPrimaryKey(new TaifTQualificaPk(idQualifica));

			TaifDTipoQualificaDto qualificaByPk = taifDTipoQualificaDao
					.findByPrimaryKey(new TaifDTipoQualificaPk(qualificaInserita.getFkTipoQualifica()));
			qualifica.setIdQualifica(qualificaByPk.getIdTipoQualifica() + "");
			qualifica.setTipoQualifica(qualificaByPk.getTipoQualifica());
			if (ConvertUtil.checkDateIsNullOrZero(qualificaInserita.getDataRilascio())) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String dataRilascio = sdf.format(qualificaInserita.getDataRilascio());
				qualifica.setDataQualifica(dataRilascio);
			}
			qualifica.setIconaCancella(qualificaInserita.getFkTipoQualifica() + "");
			TaifTAgenziaFormativaDto agenziaFormativa = taifTAgenziaFormativaDao
					.findByPrimaryKey(new TaifTAgenziaFormativaPk(qualificaInserita.getFkAgenziaFormativa()));
			qualifica.setAgenziaFormativa(agenziaFormativa.getRagioneSociale());

			return qualifica;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findQualificaByPrimaryKey] END");
		}
	}

	public TaifCnfParamApimgrDto getParametriApiManager() throws DbManagerException {
		log.debug("[DbMgr::getParametriApiManager] BEGIN");
		try {
			List<TaifCnfParamApimgrDto> list = this.taifCnfParamApimgrDao.findParametriValidi(null);
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			} else {
				return new TaifCnfParamApimgrDto();
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getParametriApiManager] END");
		}
	}

	public Riconoscimento findRiconoscimentoByPrimaryKey(int idRiconoscimento) throws DbManagerException {
		log.debug("[DbMgr::findRiconoscimentoByPrimaryKey] BEGIN");
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			TaifTRiconoscimentoDto riconoscimentoInserito = new TaifTRiconoscimentoDto();
			Riconoscimento riconoscimento = new Riconoscimento();
			riconoscimentoInserito = taifTRiconoscimentoDao
					.findByPrimaryKey(new TaifTRiconoscimentoPk(idRiconoscimento));
			TaifTAgenziaFormativaDto agenziaFormativa = taifTAgenziaFormativaDao
					.findByPrimaryKey(new TaifTAgenziaFormativaPk(riconoscimentoInserito.getFkAgenziaFormativa()));
			riconoscimento.setDsAgenziaFormativa(agenziaFormativa.getRagioneSociale());
			riconoscimento.setAgenziaFormativa(agenziaFormativa.getRagioneSociale());
			TaifDUnitaFormativaDto unitaFormativa = taifDUnitaFormativaDao
					.findByPrimaryKey(new TaifDUnitaFormativaPk(riconoscimentoInserito.getFkUnitaFormativa()));
			riconoscimento.setDsUnitaFormativa(unitaFormativa.getUnitaFormativa());
			riconoscimento.setUnitaFormativa(unitaFormativa.getUnitaFormativa());
			riconoscimento.setDataRiconoscimento(sdf.format(riconoscimentoInserito.getDataRiconoscimento()));
			if (riconoscimentoInserito.getNote() != null) {
				riconoscimento.setNote(riconoscimentoInserito.getNote());
			}
			riconoscimento.setIconaCancella(riconoscimentoInserito.getIdRiconoscimento() + "");
			return riconoscimento;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findRiconoscimentoByPrimaryKey] END");
		}
	}

	public void deleteQualificaPersonale(int idQualifica) throws DbManagerException {
		log.debug("[DbMgr::deleteOpfoCorso] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			TaifTQualificaDto qualifica = new TaifTQualificaDto();
			qualifica = taifTQualificaDao.findByPrimaryKey(new TaifTQualificaPk(idQualifica));
			if (qualifica != null) {
				taifTQualificaDao.delete(new TaifTQualificaPk(idQualifica));
			}
			utx.commit();
		} catch (Exception e) {
			try {
				log.info("[DbMgr::deleteOpfoCorso] Rollback successo  ", e);
				utx.rollback();
			} catch (Exception e2) {
				log.error("[DbMgr::deleteOpfoCorso] Rollback exception ", e2);
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::deleteOpfoCorso] END");
		}
	}

	public void deleteRiconoscimentoCorso(int idRiconoscimento) throws DbManagerException {
		log.debug("[DbMgr::deleteOpfoCorso] BEGIN");
		UserTransaction utx = txManager.getUserTransaction();
		try {
			utx.begin();
			TaifTRiconoscimentoDto riconoscimentoDto = new TaifTRiconoscimentoDto();
			riconoscimentoDto = taifTRiconoscimentoDao.findByPrimaryKey(new TaifTRiconoscimentoPk(idRiconoscimento));
			if (riconoscimentoDto != null) {
				taifTRiconoscimentoDao.delete(new TaifTRiconoscimentoPk(idRiconoscimento));
			}
			utx.commit();
		} catch (Exception e) {
			try {
				log.info("[DbMgr::deleteOpfoCorso] Rollback successo  ", e);
				utx.rollback();
			} catch (Exception e2) {
				log.error("[DbMgr::deleteOpfoCorso] Rollback exception ", e2);
			}
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::deleteOpfoCorso] END");
		}
	}

	public ArrayList<Riconoscimento> getElencoRiconoscimenti(String idPersona) throws DbManagerException {
		ArrayList<Riconoscimento> riconoscimentoList = new ArrayList<Riconoscimento>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			log.debug("[DbMgr::getElencoRiconoscimenti] START");
			RicercaOperatoreFilter filter = new RicercaOperatoreFilter();
			filter.setIdPersona(idPersona);
			List<TaifTRiconoscimentoByIdPersonaDto> listRiconoscimento = taifTRiconoscimentoDao.findByIdPersona(filter);
			for (TaifTRiconoscimentoByIdPersonaDto riconoscimentoTrovato : listRiconoscimento) {
				Riconoscimento riconoscimento = new Riconoscimento();
				riconoscimento.setIdRiconoscimento(riconoscimentoTrovato.getIdRiconoscimento() + "");
				riconoscimento.setAgenziaFormativa(riconoscimentoTrovato.getRagioneSociale());
				riconoscimento.setUnitaFormativa(riconoscimentoTrovato.getUnitaFormativa());
				if (riconoscimentoTrovato.getNote() != null) {
					riconoscimento.setNote(riconoscimentoTrovato.getNote());
				}
				riconoscimento.setDataRiconoscimento(sdf.format(riconoscimentoTrovato.getDataRilascio()));
				riconoscimento.setIconaCancella(String.valueOf(riconoscimentoTrovato.getIdRiconoscimento()));
				riconoscimentoList.add(riconoscimento);
			}
			return riconoscimentoList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoRiconoscimenti] END");
		}
	}

	public ArrayList<Qualifica> getElencoQualifiche(String idPersona) throws DbManagerException {
		ArrayList<Qualifica> qualificaList = new ArrayList<Qualifica>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			log.debug("[DbMgr::getElencoQualifiche] START");
			RicercaOperatoreFilter filter = new RicercaOperatoreFilter();
			filter.setIdPersona(idPersona);
			List<TaifTQualificaByIdPersonaDto> listQualifiche = taifTQualificaDao.findByIdPersona(filter);
			for (TaifTQualificaByIdPersonaDto qualificaTrovata : listQualifiche) {
				Qualifica qualifica = new Qualifica();
				qualifica.setIdQualifica((qualificaTrovata.getIdQualifica() + ""));
				qualifica.setTipoQualifica(qualificaTrovata.getTipoQualifica());
				qualifica.setAgenziaFormativa(qualificaTrovata.getRagioneSociale());
				if (qualificaTrovata.getDataRilascio() != null) {
					qualifica.setDataQualifica(sdf.format(qualificaTrovata.getDataRilascio()));
				}
				qualifica.setIconaCancella(String.valueOf(qualificaTrovata.getIdQualifica()));
				qualificaList.add(qualifica);
			}
			return qualificaList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoQualifiche] END");
		}
	}

	public TaifCnfMailDto getParametriInvioMail() throws DbManagerException {
		log.debug("[DbMgr::getParametriInvioMail] BEGIN ");
		try {
			return this.taifCnfMailDao.findByPrimaryKey(
					new TaifCnfMailPk(it.csi.taif.topforweb.business.dao.util.Constants.MAIL_NORMALE));
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getParametriInvioMail] END");
		}
	}

	public it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfTipoMailDto getMail(Integer idStato, String tipoAccesso)
			throws DbManagerException {
		log.debug("[DbMgr::getMail] BEGIN");
		TaifCnfTipoMailDto res = null;
		ProfiloEnum profiloEnum = ProfiloEnum.getByProfilo(tipoAccesso);
		try {
			List<TaifCnfTipoMailDto> list = taifCnfTipoMailDao.findByStatoPratica(idStato);
			if (list != null && !list.isEmpty()) {
				switch (profiloEnum) {
				case GESTORE_IT:
					// mail salvataggio da parte di gestore
					res = list.get(1);
					break;
				case OPERATORE_IT:
					// mail salvataggio da parte del operatore
					res = list.get(0);
					break;
				case GESTORE_FR:
					// mail salvataggio da parte di gestore
					res = list.get(1);
					break;
				case OPERATORE_FR:
					// mail salvataggio da parte del operatore
					res = list.get(0);
					break;
				}
			}
		} catch (DaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getMail] END");
		}
		return res;
	}

	public TaifTOpfoDto findOperatoreFromIdPersona(Integer idPersona) throws DbManagerException {
		log.debug("[DbMgr::findOperatoreFromIdPersona] BEGIN");
		try {
			TaifTOpfoDto opfo = new TaifTOpfoDto();
			opfo = taifTOpfoDao.findByPrimaryKey(new TaifTOpfoPk(idPersona));
			return opfo;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findOperatoreFromIdPersona] END");
		}
	}

	public Comune getComuneFromIstat(String istatComune) throws DbManagerException, ServiceException {
		log.debug("[DbMgr::getComuneFromIstat] BEGIN");
		try {
			return serviceMgr.limitiAmministrativiGetComuneByIstat(istatComune);

		} finally {
			log.debug("[DbMgr::getComuneFromIstat] END");
		}
	}

	public Provincia getProvinciaFromIstat(String istatComune) throws DbManagerException, ServiceException {
		log.debug("[DbMgr::getComuneFromIstat] BEGIN");
		try {
			return serviceMgr.limitiAmministrativiGetProvinciaByIstatComune(istatComune);

		} finally {
			log.debug("[DbMgr::getComuneFromIstat] END");
		}
	}

	public AnagraficaOperatoriBean findAnagraficaOperatoreByIdOperatore(int idPersona, String tracciato)
			throws DbManagerException {
		try {
			log.debug("[DbMgr::findAnagraficaOperatoreByIdOperatore] START");
			AnagraficaOperatoriBean anagraficaPersona = new AnagraficaOperatoriBean();
			TaifTPersonaAnagraficaOperatoreByIdOperatoreDto anagraficaOperatore = new TaifTPersonaAnagraficaOperatoreByIdOperatoreDto();
			TaifDNazioneDto nazioneDto = new TaifDNazioneDto();
			String statoNascita = "";
			String nomeComuneNascita = "";
			String nomeComuneResidenza = "";
			List<TaifTPersonaAnagraficaOperatoreByIdOperatoreDto> anagraficaOperatoreList = taifTPersonaDao
					.findAnagraficaOperatoreByIdOperatore(idPersona);
			if (anagraficaOperatoreList.size() > 0) {
				anagraficaOperatore = anagraficaOperatoreList.get(0);
			} else {
				anagraficaOperatore = (TaifTPersonaAnagraficaOperatoreByIdOperatoreDto) anagraficaOperatoreList;
			}

			if (anagraficaOperatore.getIdNazione() != null
					&& !anagraficaOperatore.getIdNazione().equals(Constants.blank)) {
				nazioneDto = taifDNazioneDao.findByPrimaryKey(new TaifDNazionePk(anagraficaOperatore.getIdNazione()));
				if (nazioneDto != null) {
					if (tracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
						statoNascita = nazioneDto.getNazioneIta();
					} else {
						statoNascita = nazioneDto.getNazioneFra();
					}
				}
			}
			if (anagraficaOperatore.getIstatComuneNascita() != null) {
				Comune comuneNascita = getComuneFromIstat(anagraficaOperatore.getIstatComuneNascita());
				if (comuneNascita != null) {
					nomeComuneNascita = comuneNascita.getNome();
				}
			}
			System.out.println("3   : ");
			if (anagraficaOperatore.getIstatComuneResidenza() != null) {
				Comune comuneResidenza = getComuneFromIstat(anagraficaOperatore.getIstatComuneResidenza());
				if (comuneResidenza != null) {
					nomeComuneResidenza = comuneResidenza.getNome();
				}
			}

			anagraficaPersona = dozerBeanMapper.map(anagraficaOperatore, AnagraficaOperatoriBean.class);
			anagraficaPersona.setComuneNascita(nomeComuneNascita);
			anagraficaPersona.setComuneResidenza(nomeComuneResidenza);
			anagraficaPersona.setStatoNascita(statoNascita);
			if (tracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
				anagraficaPersona.setCodiceFiscale(anagraficaOperatore.getCodiceFiscalePersona());
			} else {
				anagraficaPersona.setCodiceFiscale(anagraficaOperatore.getNRsiMsa());
			}
			if (anagraficaOperatore.getStatoOpfoIta().equals(it.csi.taif.topforweb.business.dao.util.Constants.one)) {
				anagraficaPersona.setAziendaAssociata(it.csi.taif.topforweb.business.dao.util.Constants.SI_VALUE);
			} else {
				anagraficaPersona.setAziendaAssociata(it.csi.taif.topforweb.business.dao.util.Constants.NO_VALUE);
			}
			if (anagraficaOperatore.getFlagPubblico()
					.intValue() == it.csi.taif.topforweb.business.dao.util.Constants.oneInt) {
				anagraficaPersona.setPublicabilita(it.csi.taif.topforweb.business.dao.util.Constants.SI_VALUE);
			} else {
				anagraficaPersona.setPublicabilita(it.csi.taif.topforweb.business.dao.util.Constants.NO_VALUE);
			}
			if (anagraficaOperatore.getTelefono() != null
					&& !anagraficaOperatore.getTelefono().equals(Constants.blank)) {
				anagraficaPersona.setTelCellulare(anagraficaOperatore.getTelefono());
			} else {
				if (anagraficaOperatore.getCellulare() != null
						&& !anagraficaOperatore.getCellulare().equals(Constants.blank)) {
					anagraficaPersona.setTelCellulare(anagraficaOperatore.getCellulare());
				} else {
					anagraficaPersona.setTelCellulare(it.csi.taif.topforweb.business.dao.util.Constants.blank);
				}
			}
			return anagraficaPersona;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findAnagraficaOperatoreByIdOperatore] END");
		}
	}

	public List<CorsiOperatoriBean> findCorsiPerOperatori(int idPersona, String tracciato) throws DbManagerException {
		try {
			log.debug("[DbMgr::findCorsiPerOperatori] START");

			List<CorsiOperatoriBean> corsiOperatoriList = new ArrayList<CorsiOperatoriBean>();
			List<TaifTPersonaOperatoriCorsiPerPersonaDto> listaCorsiPerOperatore = taifTPersonaDao
					.findOperatoriCorsiPerPersona(idPersona);
			CorsiOperatoriBean corsiOperatori = new CorsiOperatoriBean();
			if (listaCorsiPerOperatore != null && !listaCorsiPerOperatore.isEmpty()) {
				for (TaifTPersonaOperatoriCorsiPerPersonaDto taifTPersonaOperatoriCorsi : listaCorsiPerOperatore) {
					corsiOperatori = dozerBeanMapper.map(taifTPersonaOperatoriCorsi, CorsiOperatoriBean.class);
					if (tracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
						corsiOperatori.setCodiceFiscale(taifTPersonaOperatoriCorsi.getCodiceFiscalePersona());
					} else {
						corsiOperatori.setCodiceFiscale(taifTPersonaOperatoriCorsi.getNRsiMsa());
					}
					corsiOperatoriList.add(corsiOperatori);
				}
			}
			return corsiOperatoriList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findCorsiPerOperatori] END");
		}
	}

	public List<RiconoscimentiOperatoreBean> findRiconoscimentiPerPersona(int idPersona, String tracciato)
			throws DbManagerException {
		try {
			log.debug("[DbMgr::findRiconoscimentiPerPersona] START");

			List<RiconoscimentiOperatoreBean> ricOperatoriList = new ArrayList<RiconoscimentiOperatoreBean>();
			List<TaifTPersonaRiconoscimentiPerPersonaDto> listaRiconoscimentiCorsi = taifTPersonaDao
					.findRiconoscimentiPerPersona(idPersona);
			RiconoscimentiOperatoreBean ricOperatori = new RiconoscimentiOperatoreBean();
			if (listaRiconoscimentiCorsi != null && !listaRiconoscimentiCorsi.isEmpty()) {
				for (TaifTPersonaRiconoscimentiPerPersonaDto riconoscimenti : listaRiconoscimentiCorsi) {
					ricOperatori = dozerBeanMapper.map(riconoscimenti, RiconoscimentiOperatoreBean.class);
					if (tracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
						ricOperatori.setCodiceFiscale(riconoscimenti.getCodiceFiscalePersona());
					} else {
						ricOperatori.setCodiceFiscale(riconoscimenti.getNRsiMsa());
					}
					ricOperatoriList.add(ricOperatori);
				}
			}
			return ricOperatoriList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findRiconoscimentiPerPersona] END");
		}
	}

	public List<QualificaOperatoreBean> findQualifichePerPersona(int idPersona, String tracciato)
			throws DbManagerException {
		try {
			log.debug("[DbMgr::findQualifichePerPersona] START");

			List<QualificaOperatoreBean> qualificheList = new ArrayList<QualificaOperatoreBean>();
			List<TaifTPersonaQualifichePerPersonaDto> listaQualifiche = taifTPersonaDao
					.findQualifichePerPersona(idPersona);
			QualificaOperatoreBean qualificheOp = new QualificaOperatoreBean();
			if (listaQualifiche != null && !listaQualifiche.isEmpty()) {
				for (TaifTPersonaQualifichePerPersonaDto qualifiche : listaQualifiche) {
					qualificheOp = dozerBeanMapper.map(qualifiche, QualificaOperatoreBean.class);
					if (tracciato.equals(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
						qualificheOp.setCodiceFiscale(qualifiche.getCodiceFiscalePersona());
					} else {
						qualificheOp.setCodiceFiscale(qualifiche.getNRsiMsa());
					}
					qualificheList.add(qualificheOp);
				}
			}
			return qualificheList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findQualifichePerPersona] END");
		}
	}

	public TaifDUnitaFormativaDto findUnitaFormativaById(Integer idUnitaFormativa) throws DbManagerException {
		log.debug("[DbMgr::findUnitaFormativaById] BEGIN");
		try {
			TaifDUnitaFormativaDto unitaFormativa = new TaifDUnitaFormativaDto();
			unitaFormativa = taifDUnitaFormativaDao.findByPrimaryKey(new TaifDUnitaFormativaPk(idUnitaFormativa));
			return unitaFormativa;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findUnitaFormativaById] END");
		}
	}

	public List<TaifTAgenziaFormativaByUnitaFormativaPersonaDto> findByUnitaFormativaPersona(
			UnitaFormativaPersona unitaFormativaPers) throws DbManagerException {
		log.debug("[DbMgr::findByUnitaFormativaPersona] BEGIN");
		try {
			List<TaifTAgenziaFormativaByUnitaFormativaPersonaDto> listAgenziaFormativa = new ArrayList<TaifTAgenziaFormativaByUnitaFormativaPersonaDto>();
			listAgenziaFormativa = taifTAgenziaFormativaDao.findByUnitaFormativaPersona(unitaFormativaPers);
			return listAgenziaFormativa;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findByUnitaFormativaPersona] END");
		}
	}

	public TaifTCorsoDto findCorsoById(Integer idCorsoProfesionale) throws DbManagerException {
		log.debug("[DbMgr::findCorsoById] BEGIN");
		try {
			TaifTCorsoDto corsoDto = taifTCorsoDao.findByPrimaryKey(new TaifTCorsoPk(idCorsoProfesionale));
			return corsoDto;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::findCorsoById] END");
		}
	}
	
	public ArrayList<CodeDescription> getElencoAmbitiFormativi(SoggettoGestoreVisibleOrdinFilter filter) throws DbManagerException{
		log.debug("[DbMgr::getElencoAmbitiFormativi] START");
		try {
			ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
			List<TaifDAmbitoFormativoDto> list = taifDAmbitoFormativoDao.findByFilter(filter);
			for (TaifDAmbitoFormativoDto dto : list) {
				CodeDescription cd = new CodeDescription();
				cd.setCode(ConvertUtil.convertToString(dto.getIdAmbitoFormativo()));
				cd.setDescription(dto.getAmbitoFormativo());
				result.add(cd);
			}
			return result;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getElencoAmbitiFormativi] END");
		}
	}
	
	public ArrayList<CodeDescription> getUnitaFormativa(String idAmbitoFormativo, SoggettoGestoreVisibleOrdinFilter filter, String linguaDati)
			throws DbManagerException {
		try {
			log.debug("[DbMgr::getUnitaFormativa] START");
			ArrayList<CodeDescription> unitaFormativaList = new ArrayList<CodeDescription>();
			List<TaifDUnitaFormativaByAmbitoFormativoDto> list = taifDUnitaFormativaDao
					.findByAmbitoFormativo(ConvertUtil.convertToInteger(idAmbitoFormativo), filter);
			
			for (TaifDUnitaFormativaByAmbitoFormativoDto dto : list) {
				CodeDescription unita = new CodeDescription();
				unita.setCode(dto.getIdUnitaFormativa() + "");
				if (ConvertUtil.checkIsNullOrEmpty(dto.getSigla())) {
					unita.setDescription(dto.getSigla() + " - "
							+ dto.getDenominazioneUnitaFormativa());
				} else {
					unita.setDescription(
							dto.getDenominazioneUnitaFormativa());
				}
				unitaFormativaList.add(unita);
				// no funziona
				// unitaFormativaList.add(dozerBeanMapper.map(taifTSoggettoGestoreByFilterDto,
				// CodeDescription.class));
			}
			return unitaFormativaList;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			log.debug("[DbMgr::getUnitaFormativa] END");
		}
	}

}
