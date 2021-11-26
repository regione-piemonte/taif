/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.manager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.taifweb.business.common.StatoDomandaEnum;
import it.csi.taif.taifweb.business.dao.taifweb.dto.BeAnagraficaAziendaleDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.BeCategoriaImpresaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.BeFatturatoCategorieDiImpresaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.BeFormaOrganizzativaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.BeSedeDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.BeTitolareRappresentanteLegaleDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifApplSchedaOkDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfConfigUtenteDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfMailDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfProfiloUtenteByProfiloUtenteDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfTipoAllegatoByAllegatoFilterDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfTipoMailDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDAlimentazioneDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDCategoriaMezzoByIdTipoMezzoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoAttivitaByFilterDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoCarrelloDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoContrattoByIdContrattoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoContrattoByVisibleOrdinDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoInquadramentoByIdInquadramentoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoMansioneByVisibleOrdinDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoMezzoByCategoriaMezzoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTrazioneDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAttivDetMaterialeByIdAttivitaProgressivoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAttivDetMaterialeDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAttivDetMaterialePk;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaAssociazioneByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaFrTipoContrFindTipoByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaFrTipoMansFindTipoByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRPersonaAziendaByAziendaUtenteDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRPersonaAziendaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRPersonaAziendaConteggioPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRTrazTipoMezzoByIdTipoMezzoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRTrazTipoMezzoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAllegatoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDettaglioAziendaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDomandaByCodiceFiscaleDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaRicercaAziendaAvanzataDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCertificazioneElencoCertificazioniDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCertificazioneFindCertificazioniByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCommercializzazioneByAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTDpiDpiByAziendaVisibileDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTLavoroPaByAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTLavoroPaLavoroPaByAziendaVisibileDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTMezzoByIdTipoMezzoAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTMezzoByTipoMezzoAziendaVisibileDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTMezzoDettaglioMezzoByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaByCodiceFiscalePersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaByFilterDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaByProfiloPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaProfiloUtenteByCodiceFiscaleDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaAltriAlbiByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaByIdAziendaAlboDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDettaglioPraticaPerInvioDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTSedeAziendaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTSoggettoGestoreDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTStoricoStatoByStatoPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifVApplSchedaOkRealeDto;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.DaoException;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifTPersonaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AssortimentoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AttivitaProgressivoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloPersona;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ContrattoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.CorsoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.CorsoQualificaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.FormaGiuridicaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.InquadramentoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.LavoroPaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.MaterialeFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaAziendaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.PraticaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ProvenienzaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.RicercaAziendaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.SoggettoGestoreFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.SpecieFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.StrutturaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.UnitaMisuraFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter;
import it.csi.taif.taifweb.business.helper.dto.factory.AllegatoFactory;
import it.csi.taif.taifweb.business.helper.dto.factory.AziendaFactory;
import it.csi.taif.taifweb.business.helper.dto.factory.DettaglioEmailFactory;
import it.csi.taif.taifweb.business.manager.db.DbMgr;
import it.csi.taif.taifweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.taifweb.business.manager.message.MsgMgr;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.business.manager.validation.ValidationMgr;
import it.csi.taif.taifweb.business.report.SchedaAzienda;
import it.csi.taif.taifweb.dto.allegato.Allegato;
import it.csi.taif.taifweb.dto.common.CodeDescription;
import it.csi.taif.taifweb.dto.common.LoginInfo;
import it.csi.taif.taifweb.dto.common.ProfiloUtenteTaif;
import it.csi.taif.taifweb.dto.common.UserInfo;
import it.csi.taif.taifweb.dto.domanda.Albo;
import it.csi.taif.taifweb.dto.domanda.AnagraficaAziendale;
import it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno;
import it.csi.taif.taifweb.dto.domanda.AssociazioniECertificazioni;
import it.csi.taif.taifweb.dto.domanda.Attivita;
import it.csi.taif.taifweb.dto.domanda.AziendaAAEP;
import it.csi.taif.taifweb.dto.domanda.Capannone;
import it.csi.taif.taifweb.dto.domanda.CategoriaImpresa;
import it.csi.taif.taifweb.dto.domanda.Certificazione;
import it.csi.taif.taifweb.dto.domanda.DettaglioAttivitaUltimoAnnoFr;
import it.csi.taif.taifweb.dto.domanda.DettaglioStato;
import it.csi.taif.taifweb.dto.domanda.Domanda;
import it.csi.taif.taifweb.dto.domanda.FatturatoCategorieDiImpresa;
import it.csi.taif.taifweb.dto.domanda.FormaOrganizzativa;
import it.csi.taif.taifweb.dto.domanda.GestioneAttivitaUltimoAnno;
import it.csi.taif.taifweb.dto.domanda.GestioneFatturatoCategoriaDiImpresa;
import it.csi.taif.taifweb.dto.domanda.GestioneMacchineMezzi;
import it.csi.taif.taifweb.dto.domanda.GestionePersonaleFr;
import it.csi.taif.taifweb.dto.domanda.ImportAziendaAAEP;
import it.csi.taif.taifweb.dto.domanda.IstanzaTaglioPresentata;
import it.csi.taif.taifweb.dto.domanda.LavoroPA;
import it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato;
import it.csi.taif.taifweb.dto.domanda.MacchinaMezzo;
import it.csi.taif.taifweb.dto.domanda.MaterialePropagazione;
import it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale;
import it.csi.taif.taifweb.dto.domanda.Personale;
import it.csi.taif.taifweb.dto.domanda.PiazzaleStoccaggio;
import it.csi.taif.taifweb.dto.domanda.Riepilogo;
import it.csi.taif.taifweb.dto.domanda.Sede;
import it.csi.taif.taifweb.dto.domanda.TitolareRappresentanteLegale;
import it.csi.taif.taifweb.dto.gestore.Azienda;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.util.CollectionUtils;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.ListUtils;
import it.csi.taif.taifweb.util.StringUtils;
import it.csi.taif.taifweb.util.service.integration.svista.Comune;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.IdentificazioneRegistrazione;

public class TaifMgr {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	private MsgMgr msgMgr;

	private DbMgr dbMgr;

	private ServiceMgr serviziMgr;

	private ValidationMgr validationMgr;

	private SchedaAzienda schedaAzienda;
	
	private AziendaVisibleFilter aziendaVisibleFilter;

	/**
	 * @return the schedaAzienda
	 */
	public SchedaAzienda getSchedaAzienda() {
		return schedaAzienda;
	}

	/**
	 * @param schedaAzienda
	 *            the schedaAzienda to set
	 */
	public void setSchedaAzienda(SchedaAzienda schedaAzienda) {
		this.schedaAzienda = schedaAzienda;
	}

	/**
	 * @return the msgMgr
	 */
	public MsgMgr getMsgMgr() {
		return msgMgr;
	}

	/**
	 * @param msgMgr
	 *            the msgMgr to set
	 */
	public void setMsgMgr(MsgMgr msgMgr) {
		this.msgMgr = msgMgr;
	}

	/**
	 * @return the dbMgr
	 */
	public DbMgr getDbMgr() {
		return dbMgr;
	}

	/**
	 * @param dbMgr
	 *            the dbMgr to set
	 */
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	/**
	 * @return the serviziMgr
	 */
	public ServiceMgr getServiziMgr() {
		return serviziMgr;
	}

	/**
	 * @param serviziMgr
	 *            the serviziMgr to set
	 */
	public void setServiziMgr(ServiceMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	/**
	 * @return the validationMgr
	 */
	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	/**
	 * @param validationMgr
	 *            the validationMgr to set
	 */
	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}
	
	

	// INIZIO METODI DI BUSINESS

	public AziendaVisibleFilter getAziendaVisibleFilter() {
	    return aziendaVisibleFilter;
	}

	public void setAziendaVisibleFilter(AziendaVisibleFilter aziendaVisibleFilter) {
	    this.aziendaVisibleFilter = aziendaVisibleFilter;
	}

	public ArrayList<CodeDescription> getElencoMateriali(MaterialeFilter visibile) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoMateriali] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getElencoMateriali(visibile);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TaifMgr::getElencoMateriali] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTitoliDiStudio(VisibileOrdinFilter visibileFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTitoliDiStudio] BEGIN");
		try {
			return dbMgr.getElencoTitoliDiStudio(visibileFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTitoliDiStudio] END");
		}
	}

	public ArrayList<Sede> getSedeLegale(Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::getSedeLegale] BEGIN");
		try {
			return dbMgr.getSedeLegale(idAzienda);
		} finally {
			LOGGER.debug("[TaifMgr::getSedeLegale] END");
		}
	}

	//
	public ArrayList<Sede> getElencoSedi(Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoSedi] BEGIN");
		try {
			return dbMgr.getElencoSedi(idAzienda);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoSedi] END");
		}
	}

	public ArrayList<CodeDescription> getCorsiSostenutiTitolare(CorsoQualificaFilter corsoFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getCorsiSostenutiTitolare] BEGIN");
		try {
			
			return CollectionUtils.parseEmptyList(dbMgr.getCorsiSostenutiTitolare(corsoFilter), "Nessun Corso Presente");
		} finally {
			LOGGER.debug("[TaifMgr::getCorsiSostenutiTitolare] END");
		}
	}
	
	public ArrayList<CodeDescription> getCorsiSostenutiFromUnitaFormativa(CorsoQualificaFilter corsoFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getCorsiSostenutiTitolare] BEGIN");
		try {
			
			return CollectionUtils.parseEmptyList(dbMgr.getCorsiSostenutiFromUnitaFormativa(corsoFilter), "Nessun Corso Presente");
		} finally {
			LOGGER.debug("[TaifMgr::getCorsiSostenutiTitolare] END");
		}
	}

	public ArrayList<CodeDescription> getQualificheTitolare(Integer idPersona) throws ManagerException {
		LOGGER.debug("[TaifMgr::getQualificheTitolare] BEGIN");
		try {
			return dbMgr.getQualificheTitolare(idPersona);
		} finally {
			LOGGER.debug("[TaifMgr::getQualificheTitolare] END");
		}
	}

	public ArrayList<CodeDescription> getAltriCorsiSostenutiTitolare(CorsoQualificaFilter corsoFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getAltriCorsiSostenutiTitolare] BEGIN");
		try {
			return CollectionUtils.parseEmptyList(dbMgr.getAltriCorsiSostenutiTitolare(corsoFilter), "Nessuna qualifica presente");
		} finally {
			LOGGER.debug("[TaifMgr::getAltriCorsiSostenutiTitolare] END");
		}
	}

	public ArrayList<CodeDescription> getAltreQualificheTitolare(Integer idPersona) throws ManagerException {
		LOGGER.debug("[TaifMgr::getAltreQualificheTitolare] BEGIN");
		try {
			return dbMgr.getAltreQualificheTitolare(idPersona);
		} finally {
			LOGGER.debug("[TaifMgr::getAltreQualificheTitolare] END");
		}
	}

	public ArrayList<CategoriaImpresa> getElencoCategorieImpresa(VisibileOrdinFilter inputFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoCategorieImpresa] BEGIN");
		try {
			return dbMgr.getElencoCategorieImpresa(inputFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoCategorieImpresa] END");
		}
	}

	// ()
	public ArrayList<Albo> getElencoAltriAlbi(Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoAltriAlbi] BEGIN");
		try {

			ArrayList<Albo> result = dbMgr.getElencoAltriAlbi(idAzienda);

			if (result == null || result.isEmpty()) {
				result = new ArrayList<Albo>();
				result.add(ListUtils.addNuovoAlbo(1));
			}
			return result;

		} finally {
			LOGGER.debug("[TaifMgr::getElencoAltriAlbi] END");
		}
	}

	public Albo getAlboSogettoGestore(int idCodice) throws ManagerException {
		LOGGER.debug("[TaifMgr::getAlboSogettoGestore] BEGIN");
		try {
			return dbMgr.getAlboSogettoGestore(idCodice);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getAlboSogettoGestore] END");
		}

	}

	public TaifTSoggettoGestoreDto getSoggettoGestoreById(int idSoggettoGestore) throws ManagerException {
		LOGGER.debug("[TaifMgr::getSoggettoGestoreById] BEGIN");
		try {
			return dbMgr.getSoggettoGestoreById(idSoggettoGestore);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getSoggettoGestoreById] END");
		}

	}

	//

	public String getCodiceSoggetto(int idCodice) throws DbManagerException {
		LOGGER.debug("[TaifMgr::getAlboSogettoGestore] BEGIN");
		try {
			return dbMgr.getCodiceSoggetto(idCodice);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getCodiceSoggetto] END");
		}

	}

	//
	public ArrayList<Certificazione> getCertificazioni() throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoCertificazioni] BEGIN");
		try {
			return dbMgr.getElencoCertificazioni();
		} finally {
			LOGGER.debug("[TaifMgr::getElencoCertificazioni] END");
		}
	}

	public ArrayList<Certificazione> getElencoCertificazioniforAzienda(VisibileOrdinFilter filter, Integer idAzienda)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoCertificazioni] BEGIN");
		try {
			ArrayList<Certificazione> result = dbMgr.getElencoCertificazioniforAzienda(idAzienda);
			if (result == null || result.isEmpty()) {
				result = new ArrayList<Certificazione>();
				result.add(ListUtils.addNuovaCertificazione(1, this.getElencoTipoCertificazioni(filter)));
			}
			return result;
		} finally {
			LOGGER.debug("[TaifMgr::getElencoCertificazioni] END");
		}
	}

	public ArrayList<FormaOrganizzativa> getElencoFormeOrganizzative(VisibileOrdinFilter inputFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoFormeOrganizzative] BEGIN");
		try {
			return dbMgr.getElencoFormeOrganizzative(inputFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoFormeOrganizzative] END");
		}
	}

	public ArrayList<Attivita> getElencoAttivitaUltimoAnno(Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoAttivitaUltimoAnno] BEGIN");
		try {
			return dbMgr.getElencoAttivitaUltimoAnno(idAzienda);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoAttivitaUltimoAnno] END");
		}
	}

	public ArrayList<MaterialePropagazione> getElencoMaterialiPropagazione(MaterialeFilter ordinFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoMaterialiPropagazione] BEGIN");
		try {
			return dbMgr.getElencoMaterialiPropagazione(ordinFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoMaterialiPropagazione] END");
		}
	}

	public ArrayList<ArboricolturaDaLegno> getElencoArboricolturaDaLegno(Integer idAttivita, MaterialeFilter filter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoArboricolturaDaLegno] BEGIN");
		try {
			ArrayList<ArboricolturaDaLegno> result = dbMgr.getElencoArboricolturaDaLegno(idAttivita);
			if (result == null || result.isEmpty()) {
				result = new ArrayList<ArboricolturaDaLegno>();
				result.add(ListUtils.addNuovaArboricolturaDaLegno(1, this.getElencoMateriali(filter)));
			}
			return result;
		} finally {
			LOGGER.debug("[TaifMgr::getElencoArboricolturaDaLegno] END");
		}
	}

	/*
	 * public ArrayList<LavoroPA> getElencoLavoriPA(VisibileOrdinFilter
	 * visibileOrdinFilter) throws ManagerException {
	 * LOGGER.debug("[TaifMgr::getElencoLavoriPA] BEGIN"); try { ArrayList<LavoroPA>
	 * result = dbMgr.getElencoLavoriPA(visibileOrdinFilter);
	 * if(result==null||result.isEmpty()) { result = new ArrayList<LavoroPA>();
	 * result.add(ListUtils.addNuovoLavoroPA(1, this.getElencoTipoLavoroPA())); }
	 * return result; } finally { LOGGER.debug("[TaifMgr::getElencoLavoriPA] END");
	 * } }
	 */
	// findByAzienda

	public ArrayList<LavoroPA> getElencoLavoriPAByAzienda(LavoroPaFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoLavoriPA] BEGIN");
		try {
			ArrayList<LavoroPA> result = dbMgr.getElencoLavoriPAByAzienda(filter);
			if (result == null || result.isEmpty()) {
				result = new ArrayList<LavoroPA>();
				result.add(ListUtils.addNuovoLavoroPA(1, this.getElencoTipoLavoroPA()));
			}
			return result;
		} finally {
			LOGGER.debug("[TaifMgr::getElencoLavoriPA] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoLavoroPA() throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoLavoroPA] BEGIN");
		try {
			VisibileOrdinFilter filter = new VisibileOrdinFilter();
			filter.setFlagVisibile(1);
			return this.dbMgr.getElencoTipoLavoroPa(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoLavoriPA] END");
		}
	}

	public ArrayList<LegnameAssortimentoTrattato> getElencoLegnami(VisibileOrdinFilter ordinFilter, int idAzienda)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoLegnami] BEGIN");
		try {
			ArrayList<LegnameAssortimentoTrattato> result = dbMgr.getElencoLegnami(ordinFilter, idAzienda);
			if (result == null || result.isEmpty()) {
				result = new ArrayList<LegnameAssortimentoTrattato>();
				result.add(ListUtils.addNuovoLegnameAssortimentoTrattato(1, getElencoSpecie(ordinFilter),
						getProvenienzaMateriale(ordinFilter), getElencoAssortimento(ordinFilter),
						getTagliatoAquistatoTALista(), getElencoUnitaMisura(), getDestinazioneMateriale(ordinFilter)));
			}
			return result;
		} finally {
			LOGGER.debug("[TaifMgr::getElencoLegnami] END");
		}
	}

	public ArrayList<CodeDescription> getTagliatoAcquistato() throws ManagerException {
		LOGGER.debug("[TaifMgr::getTagliatoAcquistato] BEGIN");
		try {
			ArrayList<CodeDescription> ta = dbMgr.getTagliatoAcquistato();
			return ta;
		} finally {
			LOGGER.debug("[TaifMgr::getTagliatoAcquistato] END");
		}
	}

	public ArrayList<CodeDescription> getElencoUnitaMisura() throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoAssortimento] BEGIN");
		try {
			ArrayList<CodeDescription> listaUM = dbMgr
					.getUnitaMisura(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
			return listaUM;
		} finally {
			LOGGER.debug("[TaifMgr::getElencoAssortimento] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAssortimento(VisibileOrdinFilter visibileFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoAssortimento] BEGIN");
		try {
			ArrayList<CodeDescription> listaAssortimento = dbMgr.getElencoAssortimento(visibileFilter);
			return listaAssortimento;
		} finally {
			LOGGER.debug("[TaifMgr::getElencoAssortimento] END");
		}
	}

	public ArrayList<Capannone> getElencoCapannoni(VisibileOrdinFilter visibileFilter, Integer idAzienda)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoCapannoni] BEGIN");
		try {
			ArrayList<Capannone> result = dbMgr.getElencoCapannoni(idAzienda, visibileFilter);
			if (result == null || result.isEmpty()) {
				result = new ArrayList<Capannone>();
				// result.add(ListUtils.addNuovoCapannone(1, this.getElenco));
				result.add(ListUtils.addNuovoCapannone(1, this.getElencoFunzioniCapannone(visibileFilter)));
			}
			return result;
		} finally {
			LOGGER.debug("[TaifMgr::getElencoCapannoni] END");
		}
	}

	public ArrayList<CodeDescription> getElencoFunzioniCapannone(VisibileOrdinFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoFunzioniCapannone] BEGIN");
		try {
			return this.getDbMgr().getFunzioneCapannone(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoFunzioniCapannone] END");
		}
	}

	public ArrayList<CodeDescription> getElencoSpecie(VisibileOrdinFilter ordinFilter) throws DbManagerException {
		LOGGER.debug("[DbMgr::getElencoSpecie] BEGIN");
		try {
			ArrayList<CodeDescription> listSpecie = new ArrayList<CodeDescription>();
			listSpecie = dbMgr.getElencoSpecie(ordinFilter);
			return listSpecie;
		} finally {
			LOGGER.debug("[DbMgr::getElencoSpecie] END");
		}
	}

	public ArrayList<CodeDescription> getProvenienzaMateriale(VisibileOrdinFilter ordinFilter)
			throws DbManagerException {
		LOGGER.debug("[DbMgr::getElencoSpecie] BEGIN");
		try {
			ArrayList<CodeDescription> listProvenienza = new ArrayList<CodeDescription>();
			listProvenienza = dbMgr.getProvenienzaMateriale(ordinFilter);
			return listProvenienza;
		} finally {
			LOGGER.debug("[DbMgr::getElencoSpecie] END");
		}
	}

	public ArrayList<CodeDescription> getDestinazioneMateriale(VisibileOrdinFilter ordinFilter)
			throws DbManagerException {
		LOGGER.debug("[DbMgr::getDestinazioneMateriale] BEGIN");
		try {
			ArrayList<CodeDescription> listDest = new ArrayList<CodeDescription>();
			listDest = dbMgr.getDestinazioneMateriale(ordinFilter);
			return listDest;
		} finally {
			LOGGER.debug("[DbMgr::getDestinazioneMateriale] END");
		}
	}

	public ArrayList<CodeDescription> getElencoPiazzaliStoccaggio(VisibileOrdinFilter ordinFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoPiazzaliStoccaggio] BEGIN");
		try {
			return dbMgr.getElencoPiazzaliStoccaggio(ordinFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoPiazzaliStoccaggio] END");
		}
	}

	public PiazzaleStoccaggio addNuovoPiazzaleStoccaggio(
			ArrayList<PiazzaleStoccaggio> appDataelencoPiazzaliStoccaggio) {
		PiazzaleStoccaggio result = new PiazzaleStoccaggio();
		result.setRownum(ListUtils.getMaxRowNumListaPiazzaliStoccaggio(appDataelencoPiazzaliStoccaggio) + 1);
		return result;
	}

	public ArrayList<MezzoDiProtezioneIndividuale> getElencoCaschiForestali(VisibileOrdinFilter filter,
			Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoCaschiForestali] BEGIN");
		try {
			ArrayList<MezzoDiProtezioneIndividuale> result = dbMgr.getElencoCaschiForestali(filter, idAzienda);
			if (result == null || result.isEmpty()) {
				result = new ArrayList<MezzoDiProtezioneIndividuale>();
				result.add(ListUtils.addNuovoMezzoDiProtezioneIndividuale(1, getElencoTipoDpi()));
			}
			return result;
		} finally {
			LOGGER.debug("[TaifMgr::getElencoCaschiForestali] END");
		}
	}

	// getElencoScarponiRinforzati
	public ArrayList<MezzoDiProtezioneIndividuale> getElencoScarponiRinforzati(VisibileOrdinFilter filter,
			Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoScarponiRinforzati] BEGIN");
		try {
			ArrayList<MezzoDiProtezioneIndividuale> result = dbMgr.getElencoScarponiRinforzati(filter, idAzienda);
			if (result == null || result.isEmpty()) {
				result = new ArrayList<MezzoDiProtezioneIndividuale>();
				result.add(ListUtils.addNuovoMezzoDiProtezioneIndividuale(1, getElencoTipoDpi()));
			}
			return result;
		} finally {
			LOGGER.debug("[TaifMgr::getElencoScarponiRinforzati] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoDpi() throws DbManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoDpi] BEGIN");
		try {
			return dbMgr.getElencoTipoDpi(1);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoDpi] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoCertificazioni(VisibileOrdinFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoCertificazioni] BEGIN");
		try {
			return dbMgr.getElencoTipoCertificazioni(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoCertificazioni] END");
		}
	}

	public ArrayList<MezzoDiProtezioneIndividuale> getElencoPantaloniAntitaglio(VisibileOrdinFilter filter,
			Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoPantaloniAntitaglio] BEGIN");
		try {
			ArrayList<MezzoDiProtezioneIndividuale> result = dbMgr.getElencoPantaloniAntitaglio(filter, idAzienda);
			if (result == null || result.isEmpty()) {
				result = new ArrayList<MezzoDiProtezioneIndividuale>();
				result.add(ListUtils.addNuovoMezzoDiProtezioneIndividuale(1, getElencoTipoDpi()));
			}
			return result;
		} finally {
			LOGGER.debug("[TaifMgr::getElencoPantaloniAntitaglio] END");
		}
	}

	public ArrayList<MacchinaMezzo> getElencoMacchine(TipoMezzoFilter filter, String tipoMezzo)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoMacchine] BEGIN");
		ArrayList<MacchinaMezzo> elencomacchine = new ArrayList<MacchinaMezzo>();
		try {
			filter.setIdTipoMezzo(dbMgr.getIdMezzoByTipoMezzo(filter));
			filter.setTipoMezzo(tipoMezzo);
			elencomacchine = dbMgr.getElencoMacchine(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoMacchine] END");
		}
		return elencomacchine;
	}

	public ArrayList<CodeDescription> getElencoNazioniFra(VisibileOrdinFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoNazioniFra] BEGIN");
		try {
			return dbMgr.getElencoNazioniFra(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoNazioniFra] END");
		}
	}

	public ArrayList<CodeDescription> getElencoNazioniIta(VisibileOrdinFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoNazioniIta] BEGIN");
		try {
			return dbMgr.getElencoNazioniIta(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoNazioniIta] END");
		}
	}

	public ArrayList<MacchinaMezzo> getElencoMacchineCategoria(TipoMezzoFilter filter, String categoriaMezzo)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoMacchineCategoria] BEGIN");
		try {
			// return dbMgr.getElencoMacchineCategoria(filter, categoriaMezzo);
			filter.setTipoMezzo(categoriaMezzo);
			return dbMgr.getElencoMacchineCategoria(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoMacchineCategoria] END");
		}
	}

	public ArrayList<Personale> getElencoPersonaleAzienda(Integer idAzienda, VisibileOrdinFilter filter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoPersonaleAzienda] BEGIN");
		try {
			return dbMgr.getElencoPersonaleAzienda(idAzienda, filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoPersonaleAzienda] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAziende() throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoAziende] BEGIN");
		try {
			return dbMgr.getElencoAziende();
		} finally {
			LOGGER.debug("[TaifMgr::getElencoAziende] END");
		}
	}

	public ArrayList<AziendaAAEP> getElencoAziendeAAEP(String codiceFiscaleSoggetto) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoAziendeAAEP] BEGIN");
		try {
			return serviziMgr.aaepGetAziendePerCodiceFiscaleSoggetto(codiceFiscaleSoggetto);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoAziendeAAEP] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAziende(String codiceFiscaleSoggetto) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoAziende] BEGIN");
		try {
			return serviziMgr.aaepGetAziendePerCodiceFiscale(codiceFiscaleSoggetto);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoAziende] END");
		}
	}

	public ArrayList<CodeDescription> getElencoAttivitaAteco(VisibileOrdinFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoAttivitaAteco] BEGIN");
		try {
			return dbMgr.getElencoAttivitaAteco(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoAttivitaAteco] END");
		}
	}

	public ArrayList<CodeDescription> getElencoFormaGiuridica(FormaGiuridicaFilter formaGiuridica)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoFormaGiuridica] BEGIN");
		try {
			return dbMgr.getElencoFormaGiuridica(formaGiuridica);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoFormaGiuridica] END");
		}
	}

	// idFunzione= 5 for piazzale Stoccaggio
	public ArrayList<PiazzaleStoccaggio> getElencoPiazzaliStoccaggio(StrutturaFilter filterStruttura)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoPiazzaliStoccaggio] BEGIN");
		try {
			ArrayList<PiazzaleStoccaggio> result = dbMgr.getElencoPiazzaliStoccaggio(filterStruttura);
			if (result == null || result.isEmpty()) {
				result = new ArrayList<PiazzaleStoccaggio>();
				result.add(ListUtils.addNuovoPiazzaleStoccaggio(1));
			}
			return result;
		} finally {
			LOGGER.debug("[TaifMgr::getElencoPiazzaliStoccaggio] END");
		}
	}

	// public List<Sede> getListSedePerAzienda(Integer idAzienda) throws
	// DbManagerException {

	public ArrayList<Sede> getListSedePerAzienda(Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoFormaGiuridica] BEGIN");
		try {
			return dbMgr.getListSedePerAzienda(idAzienda);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoFormaGiuridica] END");
		}
	}

	public TaifTPersonaByProfiloPersonaDto getPersonaByCodiceFiscaleandProfilo(ConfigProfiloPersona filter)
			throws DbManagerException {

		LOGGER.debug("[TaifMgr::getPersonaByCodiceFiscaleandProfilo] BEGIN");
		try {
			return dbMgr.getPersonaByCodiceFiscaleandProfilo(filter);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getPersonaByCodiceFiscaleandProfilo] END");
		}

	}

	// findByProfiloUtente
	public TaifCnfProfiloUtenteByProfiloUtenteDto getProfiloUtenteByProcedura(ConfigProfiloFilter filter)
			throws DbManagerException {

		LOGGER.debug("[TaifMgr::findByProfiloUtente] BEGIN");
		try {
			return dbMgr.getProfiloUtenteByProcedura(filter);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findByProfiloUtente] END");
		}

	}

	public TaifTAziendaDto getAziendaById(int idAzienda) throws DbManagerException {
		LOGGER.debug("[DbMgr::getAziendaById] BEGIN");
		try {
			return dbMgr.getAziendaById(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getAziendaById] END");
		}
	}

	public TaifTPersonaDto getPersonaFromAziendaUtente(PersonaAziendaFilter personaFilter) throws DbManagerException {
		LOGGER.debug("[DbMgr::getPersonaFromAziendaUtente] BEGIN");
		try {
			return dbMgr.getPersonaFromAziendaUtente(personaFilter);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getPersonaFromAziendaUtente] END");
		}
	}

	public List<TaifRPersonaAziendaByAziendaUtenteDto> getRuoloPersonaFromAziendaUtente(
			PersonaAziendaFilter personaFilter) throws DbManagerException {
		LOGGER.debug("[DbMgr::getPersonaFromAziendaUtente] BEGIN");
		try {
			return dbMgr.getRuoloPersonaFromAziendaUtente(personaFilter);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getPersonaFromAziendaUtente] END");
		}
	}

	public TaifTPraticaDto getPraticByIdPratica(int idPratica) throws DbManagerException {
		LOGGER.debug("[DbMgr::getPraticByIdPratica] BEGIN");
		try {
			return dbMgr.getPraticByIdPratica(idPratica);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getPraticByIdPratica] END");
		}
	}

	public Integer salvaDatiAziendali(Integer idAzienda, AnagraficaAziendale anagraficaAziendale, Sede sedeLegale,
			ArrayList<Sede> sedi, Albo albo, String dataTracciato, int idAlbo) throws ManagerException {

		// SCHEDA 1.1
		// anagraficAziendale ha il idAzienda, non serve
//		TaifApplSchedaOkDto scheda = new TaifApplSchedaOkDto();
		if (sedi == null) {
			sedi = new ArrayList<Sede>();
		}
		TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente = (TaifTPersonaProfiloUtenteByCodiceFiscaleDto) ActionContext
				.getContext().getSession().get("profiloUtente");

		LOGGER.debug("[TaifMgr::salvaDatiAziendali] BEGIN");
		//boolean existesezione11 = false;
//		scheda = getDatiFromSchedaApplOk(idAzienda);
//		if (scheda != null) {
//			if ((scheda.getFlgSez11ItaOk().byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
//					|| scheda.getFlgSez11FraOk()
//							.byteValue() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
//				existesezione11 = true;
//				ActionContext.getContext().getSession().put("backDomandaRiepilogo", Constants.BACK_DOMANDA_RIEPILOGO);
//
//			}
//		}
		
		
		boolean existesezione11 = idAzienda != null;
		
		
		if (!existesezione11) {
			this.validationMgr.validazioneCodiceFiscaleEPiva(anagraficaAziendale, dataTracciato);
		}
		if (existesezione11) {
			this.validationMgr.validazioneDatiAziendaliMarcaBollo(idAzienda, anagraficaAziendale, dataTracciato,
					albo.getIdAlbo());
		}
		if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
			this.validationMgr.validazioneDatiAziendali(idAzienda, anagraficaAziendale, sedeLegale, sedi, dataTracciato,
					idAlbo);
		} else {
			this.validationMgr.validazioneDatiAziendaliFrancese(idAzienda, anagraficaAziendale, sedeLegale, sedi,
					dataTracciato, idAlbo);
		}
		Integer result = idAzienda;

		try {
			BeAnagraficaAziendaleDto backAnagraficaAziendale = new BeAnagraficaAziendaleDto();
			if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
				if (sedi != null && !sedi.isEmpty()) {
					for (Sede sede : sedi) {
						String resultIstat = "000000" + sede.getIdComune();
						int length = resultIstat.length();
						resultIstat = resultIstat.substring(length - 6, length);
						sede.setIstatComuneSede(resultIstat);
					}
				} else {
					sedi = new ArrayList<Sede>();
				}
			}
			List<BeSedeDto> backSediList = new ArrayList<BeSedeDto>();
			sedeLegale.setIdTipoSede(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
			sedeLegale.setTelefono(anagraficaAziendale.getTelefono());
			sedeLegale.setCellulare(anagraficaAziendale.getCellulare());
			try {
				sedi.add(sedeLegale);
				backSediList = dbMgr.getListSedePerAziendaFeToBe(sedi);
				backAnagraficaAziendale = dbMgr.getAnagraficaAziendaleFeToBe(anagraficaAziendale);
				if (backAnagraficaAziendale != null && backSediList != null) {
					result = dbMgr.salvaDatiAziendali(idAzienda, backAnagraficaAziendale, backSediList, albo,
							profiloUtente, dataTracciato, existesezione11);
				}
				sedi.remove(sedeLegale);
			} catch (DbManagerException e) {
				throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
			}
		} finally {
			LOGGER.debug("[TaifMgr::salvaDatiAziendali] END");
		}

		return result;

	}

	public void salvaTitolareRappresentanteLegale(Integer idAzienda, TitolareRappresentanteLegale titolare,
			TitolareRappresentanteLegale altroTitolare, TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente,
			String esisteConduttore, String dataTracciato) throws ManagerException, TaifTPersonaDaoException {

		// SCHEDA 1.2
		LOGGER.debug("[TaifMgr::salvaTitolareRappresentanteLegale] BEGIN");
		if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
			this.validationMgr.validazioneTitolariRappresentante(idAzienda, titolare, altroTitolare, esisteConduttore);
		} else {
			this.validationMgr.validazioneTitolariRappresentanteFrancese(idAzienda, titolare);
		}
		try {

			BeTitolareRappresentanteLegaleDto backTitolareLegale = new BeTitolareRappresentanteLegaleDto();
			BeTitolareRappresentanteLegaleDto backAltroTitolare = new BeTitolareRappresentanteLegaleDto();

			try {

				PersonaFilter personaFilter = new PersonaFilter();
				if (titolare.getCodiceFiscale() != null && StringUtils.isNotEmpty(titolare.getCodiceFiscale())) {
					personaFilter.setCodiceFiscale(titolare.getCodiceFiscale());
				}
				if (titolare.getNrsiMsa() != null && StringUtils.isNotEmpty(titolare.getNrsiMsa())) {
					personaFilter.setCodiceFiscale(titolare.getNrsiMsa());
				}
				List<TaifTPersonaByFilterDto> titolarePerCodiceFiscale = dbMgr.findPersonaByFilter(personaFilter);
				if (titolare != null) {
					backTitolareLegale = dbMgr.getTitolareRappresentanteLegalePerAziendaFeToBe(titolare);
					LOGGER.info("[TaifMgr::salvaTitolareRappresentanteLegale] UPDATE titolare.getDsComuneNascitaNoIta()" + titolare.getDsComuneNascitaNoIta());
					if(titolare.getDsComuneNascitaNoIta()!=null) {
						backTitolareLegale.setDsComuneNascitaNoIta(titolare.getDsComuneNascitaNoIta());
					}
					LOGGER.info("[TaifMgr::salvaTitolareRappresentanteLegale] UPDATE backTitolareLegale.getDsComuneNascitaNoIta()" + backTitolareLegale.getDsComuneNascitaNoIta());
									}
				if (altroTitolare != null) {
					backAltroTitolare = dbMgr.getTitolareRappresentanteLegalePerAziendaFeToBe(altroTitolare);
				}

				if (titolarePerCodiceFiscale != null && !titolarePerCodiceFiscale.isEmpty()) {
					ActionContext.getContext().getSession().put("backDomandaRiepilogo",
							it.csi.taif.taifweb.util.Constants.BACK_DOMANDA_RIEPILOGO);
					LOGGER.info("[TaifMgr::salvaTitolareRappresentanteLegale] UPDATE");
					dbMgr.updateColumnsForTitolareRappresentante(idAzienda, titolare, altroTitolare, profiloUtente,
							titolarePerCodiceFiscale, esisteConduttore, dataTracciato);
				} else {
					LOGGER.info("[TaifMgr::salvaTitolareRappresentanteLegale] INSERT");

					dbMgr.salvaTitolareRappresentanteLegale(idAzienda, backTitolareLegale, backAltroTitolare,
							profiloUtente, altroTitolare, esisteConduttore, dataTracciato);
				}
			} catch (DbManagerException e) {
				throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));

			}

		} finally {
			LOGGER.debug("[TaifMgr::salvaTitolareRappresentanteLegale] END");
		}

	}

	public void salvaFatturatoECategorieImpresa(Integer idAzienda, List<CategoriaImpresa> elencoCategorieImpresa,
			GestioneFatturatoCategoriaDiImpresa dto, TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente,
			String impresaSelezionalta, FatturatoCategorieDiImpresa fatturatoCategorieDiImpresa, String dataTracciato) throws ManagerException {
		// SCHEDA 2.1
		LOGGER.debug("[TaifMgr::salvaFatturatoECategorieImpresa] BEGIN");
		this.validationMgr.validazioneFatturatoECategorieImpresa(idAzienda, dto, impresaSelezionalta, fatturatoCategorieDiImpresa);

		try {
			List<BeCategoriaImpresaDto> backCategoriaImpresaList = new ArrayList<BeCategoriaImpresaDto>();
			BeFatturatoCategorieDiImpresaDto backFatturatoCategoria = new BeFatturatoCategorieDiImpresaDto();
			ArrayList<CategoriaImpresa> categoriaImpresaList = new ArrayList<CategoriaImpresa>();
			FatturatoCategorieDiImpresa fatturatoCategoria = new FatturatoCategorieDiImpresa();
//			TaifApplSchedaOkDto scheda = new TaifApplSchedaOkDto();
			
			try {
				if (dto != null) {
					if (dto.getFatturato() != null)
						backFatturatoCategoria = dbMgr.getFatturatocategoriaFeToBe(dto.getFatturato());
					fatturatoCategoria = dto.getFatturato();
					if (dto.getElencoCategorieImpresa() != null)
						backCategoriaImpresaList = dbMgr.getCategoriaImpresaFeToBe(dto.getElencoCategorieImpresa());
					categoriaImpresaList = dto.getElencoCategorieImpresa();
					if (dto.getElencoCategorieImpresa() != null) {
						// esiste idAzienda+ sezione
						boolean existesezione = false;
						//TaifApplSchedaOkDto scheda = getDatiFromSchedaApplOk(idAzienda);
						TaifVApplSchedaOkRealeDto scheda = getInfoSchedeAzienda(idAzienda);
						if ((scheda.getFlgSez21ItaOk()
								.byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
								|| scheda.getFlgSez21FraOk()
										.byteValue() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
							existesezione = true;
							ActionContext.getContext().getSession().put("backDomandaRiepilogo",
									Constants.BACK_DOMANDA_RIEPILOGO);
						}
						if (existesezione) {
							// update
							dbMgr.updateFatturatoECategorieImpresa(idAzienda, elencoCategorieImpresa,
									fatturatoCategoria, categoriaImpresaList, profiloUtente, impresaSelezionalta,fatturatoCategorieDiImpresa,
									dataTracciato);
						} else {
							// insert
							dbMgr.salvaFatturatoECategorieImpresa(idAzienda, elencoCategorieImpresa,
									backFatturatoCategoria, backCategoriaImpresaList, profiloUtente,
									impresaSelezionalta, fatturatoCategorieDiImpresa, dataTracciato);
						}
					}
				}
			} catch (DbManagerException e) {
				throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
			}
		} finally {
			LOGGER.debug("[TaifMgr::salvaFatturatoECategorieImpresa] END");
		}

	}

	public void salvaAssociazoniECertificazioni(Integer idAzienda, ArrayList<Albo> albi,
			ArrayList<FormaOrganizzativa> elencoFormeOrganizzative, ArrayList<FormaOrganizzativa> formeOrganizzative,
			ArrayList<Certificazione> certificazioni,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, ArrayList<String> listFormeOrganizzative,
			String esisteAlbo, String esisteCertificazione, String dataTracciato) throws ManagerException {
		// SCHEDA 2.2
		LOGGER.debug("[TaifMgr::salvaAssociazoniECertificazioni] BEGIN");
		LOGGER.info("[TaifMgr::salvaAssociazoniECertificazioni] BEGIN");

		this.validationMgr.validazioneAssociazioniECertificazioni(idAzienda, albi, formeOrganizzative,
				 certificazioni, listFormeOrganizzative, esisteAlbo, esisteCertificazione);
		List<TaifTPraticaByIdAziendaAlboDto> backTaifTPraticaByIdAzienda = new ArrayList<TaifTPraticaByIdAziendaAlboDto>();
		List<BeFormaOrganizzativaDto> backAssociazione = new ArrayList<BeFormaOrganizzativaDto>();
		// List<BeFormaOrganizzativaDto> backElencoFormeOrganizzative = new
		// ArrayList<BeFormaOrganizzativaDto>();
		List<TaifTCertificazioneElencoCertificazioniDto> backCertificazione = new ArrayList<TaifTCertificazioneElencoCertificazioniDto>();
//		TaifApplSchedaOkDto scheda = new TaifApplSchedaOkDto();
		try {
			backTaifTPraticaByIdAzienda = dbMgr.getElencoAltriAlbiBeToFe(albi);
			backAssociazione = dbMgr.getElencoFormeOrganizzativeFeToBeFinal(formeOrganizzative);
			backCertificazione = dbMgr.getElencoCertificazioniFeToBe(certificazioni);
			// backElencoFormeOrganizzative =
			// dbMgr.getElencoFormeOrganizzativeFeToBeFinal(elencoFormeOrganizzative);
			if (backTaifTPraticaByIdAzienda != null) {
				// salva taifTPratica ; salva certificazioniT
				boolean existesezione = false;
				//TaifApplSchedaOkDto scheda = getDatiFromSchedaApplOk(idAzienda);
				TaifVApplSchedaOkRealeDto scheda = getInfoSchedeAzienda(idAzienda);
				if ((scheda.getFlgSez22ItaOk()
						.byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
						|| scheda.getFlgSez22FraOk()
								.byteValue() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
					existesezione = true;
					ActionContext.getContext().getSession().put("backDomandaRiepilogo",
							Constants.BACK_DOMANDA_RIEPILOGO);
				}
				if (existesezione) {
					LOGGER.debug("[TaifMgr::salvaAssociazoniECertificazioni] EXIST SEZIONE -> UPDATE");

					LOGGER.info("[TaifMgr::salvaAssociazoniECertificazioni] EXIST SEZIONE -> UPDATE");
					// update
					dbMgr.updateAssocECert(idAzienda, backTaifTPraticaByIdAzienda, 
							formeOrganizzative, backCertificazione, profiloUtente,
							esisteAlbo, esisteCertificazione, dataTracciato);
				} else {
					LOGGER.info("[TaifMgr::salvaAssociazoniECertificazioni] NOT EXIST SEZIONE -> INSERT");
					LOGGER.debug("[TaifMgr::salvaAssociazoniECertificazioni] NOT EXIST SEZIONE -> INSERT");

					// insert
					dbMgr.salvaAssociazoniECertificazioni(idAzienda, backTaifTPraticaByIdAzienda,
							formeOrganizzative, backAssociazione, backCertificazione,
							profiloUtente, esisteAlbo, esisteCertificazione, dataTracciato);
				}

			}
		} catch (DbManagerException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}
		LOGGER.debug("[TaifMgr::salvaAssociazoniECertificazioni] END");
	}

	public void salvaAttivitaUltimoAnno(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno,
			List<MaterialePropagazione> elencoMaterialePropagazione,
			ArrayList<ArboricolturaDaLegno> elencoArboricoltureLegno, List<String> idMaterialiPropagazione,
			List<String> listIdAttivitaFrancese, Map<String, Boolean> attivitaMap,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, String dataTracciato,
			String idTaglioUtilizzazioneRegione, String idTaglioPiopettiRegione, String idTaglioTagliIntervalariRegione,
			String idTaglioUtilizzazioneFuori, String idTaglioPiopettiFuori, String idTaglioTagliIntercalariFuori, ArrayList<MaterialePropagazione> materialePropagazione)
			throws ManagerException {
		// SCHEDA 3.1

		LOGGER.debug("[TaifMgr::salvaAttivitaUltimoAnno] BEGIN");
		if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
			this.validationMgr.validazioneSalvaAttivitaUltimoAnno(idAzienda, gestioneAttivitaUltimoAnno,
					elencoMaterialePropagazione, idMaterialiPropagazione, attivitaMap, dataTracciato);
			this.validationMgr.validazionePercentualeAttivita(idAzienda, gestioneAttivitaUltimoAnno, attivitaMap,
					dataTracciato);
		} else {
			this.validationMgr.validazioneSalvaAttivitaUltimoAnnoFrancese(idAzienda, gestioneAttivitaUltimoAnno,
					listIdAttivitaFrancese, dataTracciato);
			this.validationMgr.validazionePercentualeAttivitaFrancese(gestioneAttivitaUltimoAnno,
					listIdAttivitaFrancese, dataTracciato);

		}

		try {
			boolean existesezione = false;
			//TaifApplSchedaOkDto scheda = getDatiFromSchedaApplOk(idAzienda);
			TaifVApplSchedaOkRealeDto scheda = getInfoSchedeAzienda(idAzienda);
			if (scheda != null) {
				if ((scheda.getFlgSez31ItaOk()
						.byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
						|| scheda.getFlgSez31FraOk()
								.byteValue() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
					existesezione = true;
					ActionContext.getContext().getSession().put("backDomandaRiepilogo",
							Constants.BACK_DOMANDA_RIEPILOGO);
				}
			}
			if (existesezione) {
				if (gestioneAttivitaUltimoAnno != null) {
					if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
						dbMgr.updateAttivitaUltimoAnno(idAzienda, gestioneAttivitaUltimoAnno, profiloUtente,
								attivitaMap, elencoMaterialePropagazione, elencoArboricoltureLegno,
								idMaterialiPropagazione, dataTracciato, idTaglioUtilizzazioneRegione,
								idTaglioPiopettiRegione, idTaglioTagliIntervalariRegione, idTaglioUtilizzazioneFuori,
								idTaglioPiopettiFuori, idTaglioTagliIntercalariFuori, materialePropagazione.get(0));
					} else {
						// update TracciatoFrancese
						dbMgr.updateAttivitaUltimoAnnoFrancese(idAzienda, gestioneAttivitaUltimoAnno,
								listIdAttivitaFrancese, profiloUtente, attivitaMap, dataTracciato);
					}
				}
			} else {
				if (gestioneAttivitaUltimoAnno != null) {
					if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
						dbMgr.salvaAttivitaUltimoAnno(idAzienda, gestioneAttivitaUltimoAnno, profiloUtente, attivitaMap,
								elencoMaterialePropagazione, elencoArboricoltureLegno, idMaterialiPropagazione,
								dataTracciato, idTaglioUtilizzazioneRegione, idTaglioPiopettiRegione,
								idTaglioTagliIntervalariRegione, idTaglioUtilizzazioneFuori, idTaglioPiopettiFuori,
								idTaglioTagliIntercalariFuori, materialePropagazione.get(0));
					} else {
						// salva TracciatoFrancese
						dbMgr.salvaAttivitaUltimoAnnoFrancese(idAzienda, gestioneAttivitaUltimoAnno,
								listIdAttivitaFrancese, profiloUtente, attivitaMap, dataTracciato);
					}
				}
			}

		} catch (DbManagerException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}

		LOGGER.debug("[TaifMgr::salvaAttivitaUltimoAnno] END");
	}

	public void salvaLavoriPerPAUltimoAnno(Integer idAzienda, ArrayList<LavoroPA> list,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, String esistenzaLavoriPA, String dataTracciato)
			throws ManagerException {
		// SCHEDA 3.2
		LOGGER.debug("[TaifMgr::salvaLavoriPerPAUltimoAnno] BEGIN");
		this.validationMgr.validazioneSalvaLavoriPerPAUltimoAnno(idAzienda, list, esistenzaLavoriPA, dataTracciato);
		try {
			boolean existesezione = false;
			//TaifApplSchedaOkDto scheda = getDatiFromSchedaApplOk(idAzienda);
			TaifVApplSchedaOkRealeDto scheda = getInfoSchedeAzienda(idAzienda);
			if (scheda != null) {
				if ((scheda.getFlgSez32ItaOk()
						.byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
					existesezione = true;
					ActionContext.getContext().getSession().put("backDomandaRiepilogo",
							Constants.BACK_DOMANDA_RIEPILOGO);
				}
			}
			// if (list != null && !list.isEmpty()) {
			if (existesezione) {
				dbMgr.updateLavoriPerPAUltimoAnno(idAzienda, list, profiloUtente, esistenzaLavoriPA, dataTracciato);
			} else {
				dbMgr.salvaLavoriPerPAUltimoAnno(idAzienda, list, profiloUtente, esistenzaLavoriPA, dataTracciato);
				// }
			}
		} catch (DbManagerException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}

		LOGGER.debug("[TaifMgr::salvaLavoriPerPAUltimoAnno] END");

	}

	public void salvaCommercializzazioneLegnameEAssortimentiUltimoAnno(Integer idAzienda,
			ArrayList<LegnameAssortimentoTrattato> list, TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente,
			String esistenzaAttivitaLegname, Integer percentualeCommercioFr, String dataTracciato)
			throws ManagerException {
		// SCHEDA 3.3
		LOGGER.debug("[TaifMgr::salvaCommercializzazioneLegnameEAssortimentiUltimoAnno] BEGIN");
		

		boolean existesezione33 = false;
		//TaifApplSchedaOkDto scheda = getDatiFromSchedaApplOk(idAzienda);
		TaifVApplSchedaOkRealeDto scheda = getInfoSchedeAzienda(idAzienda);
		if (scheda != null) {
			if ((scheda.getFlgSez33ItaOk().byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
					|| (scheda.getFlgSez33FraOk()
							.byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
				existesezione33 = true;
				ActionContext.getContext().getSession().put("backDomandaRiepilogo", Constants.BACK_DOMANDA_RIEPILOGO);
			}
		}
		try {
		    this.validationMgr.validazioneSalvaCommercializzazioneLegnameEAssortimentiUltimoAnno(idAzienda, list,
				esistenzaAttivitaLegname, percentualeCommercioFr, existesezione33, dataTracciato);
		    
			if (existesezione33) {
			    	
				dbMgr.updateCommercializzazioneLegnameEAssortimentiUltimoAnno(idAzienda, list, profiloUtente,
						esistenzaAttivitaLegname, percentualeCommercioFr, dataTracciato);
				dbMgr.countAllCommLegnameAndDeleteAttivitaEight(aziendaVisibleFilter, dataTracciato);
			} else {
			    
				dbMgr.salvaCommercializzazioneLegnameEAssortimentiUltimoAnno(idAzienda, list, profiloUtente,
						esistenzaAttivitaLegname, percentualeCommercioFr, dataTracciato);
			}
			// test quante commercializzazioni ho 
			 aziendaVisibleFilter = dbMgr.getAziendaVisibleFilter(idAzienda,dataTracciato, it.csi.taif.taifweb.business.dao.util.Constants.eightInt);
			
			
		} catch (DbManagerException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}
		LOGGER.debug("[TaifMgr::salvaCommercializzazioneLegnameEAssortimentiUltimoAnno] END");
	}

	public void salvaStrutture(Integer idAzienda, ArrayList<Capannone> capannoni,
			ArrayList<PiazzaleStoccaggio> piazzali, TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente,
			boolean esisteCapannone, boolean esistePiazzaSto, String dataTracciato) throws ManagerException {
		// SCHEDA 4
		LOGGER.debug("[TaifMgr::salvaStrutture] BEGIN");
		this.validationMgr.validazioneSalvaStrutture(idAzienda, capannoni, piazzali, esisteCapannone, esistePiazzaSto,
				dataTracciato);
		boolean existesezione4 = false;
		//TaifApplSchedaOkDto scheda = getDatiFromSchedaApplOk(idAzienda);
		TaifVApplSchedaOkRealeDto scheda = getInfoSchedeAzienda(idAzienda);
		if (scheda != null) {
			if ((scheda.getFlgSez4ItaOk().byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
					|| (scheda.getFlgSez4FraOk()
							.byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
				existesezione4 = true;
				ActionContext.getContext().getSession().put("backDomandaRiepilogo", Constants.BACK_DOMANDA_RIEPILOGO);
			}
		}
		try {
			if (capannoni != null) {
				if (existesezione4) {
					dbMgr.updateStrutture(idAzienda, capannoni, piazzali, profiloUtente, esisteCapannone,
							esistePiazzaSto, dataTracciato);
				} else {
					dbMgr.salvaStrutture(idAzienda, capannoni, piazzali, profiloUtente, esisteCapannone,
							esistePiazzaSto, dataTracciato);
				}
			}

		} catch (DbManagerException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}
		LOGGER.debug("[TaifMgr::salvaStrutture] END");

	}

	public void salvaAttrezzaturaAntiInfortunisticaMezziDPI(Integer idAzienda,
			ArrayList<MezzoDiProtezioneIndividuale> caschiForestali,
			ArrayList<MezzoDiProtezioneIndividuale> scarponiRinforzati,
			ArrayList<MezzoDiProtezioneIndividuale> pantaloniAntitaglio,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, Map<String, Boolean> attrezzatureMap,
			String dataTracciato) throws ManagerException {
		// SCHEDA 5.1
		LOGGER.debug("[TaifMgr::salvaAttrezzaturaAntiInfortunisticaMezziDPI] BEGIN");
		this.validationMgr.validazioneSalvaAttrezzaturaAntiInfortunisticaMezziDPI(idAzienda, caschiForestali,
				scarponiRinforzati, pantaloniAntitaglio, attrezzatureMap, dataTracciato);
		boolean existesezione51 = false;
		//TaifApplSchedaOkDto scheda = getDatiFromSchedaApplOk(idAzienda);
		TaifVApplSchedaOkRealeDto scheda = getInfoSchedeAzienda(idAzienda);
		if (scheda != null) {
			if ((scheda.getFlgSez51ItaOk()
					.byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
				existesezione51 = true;
				ActionContext.getContext().getSession().put("backDomandaRiepilogo", Constants.BACK_DOMANDA_RIEPILOGO);
			}
		}
		try {
			int idConfigUtente = profiloUtente.getIdConfigUtente();
			if (existesezione51) {
				dbMgr.updateAttrezzaturaAntiInfortunisticaMezziDPI(idAzienda, caschiForestali, scarponiRinforzati,
						pantaloniAntitaglio, idConfigUtente, attrezzatureMap, dataTracciato);
			} else {
				dbMgr.salvaAttrezzaturaAntiInfortunisticaMezziDPI(idAzienda, caschiForestali, scarponiRinforzati,
						pantaloniAntitaglio, idConfigUtente, attrezzatureMap, dataTracciato);
			}

		} catch (DbManagerException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}
		LOGGER.debug("[TaifMgr::salvaAttrezzaturaAntiInfortunisticaMezziDPI] END");
	}

	public void salvaMacchineEMezzi(Integer idAzienda, GestioneMacchineMezzi gestioneMacchineMezzi,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, Map<String, Boolean> macchineMezziMap,
			String dataTracciato) throws ManagerException {
		// SCHEDA 5.2
		LOGGER.debug("[TaifMgr::salvaMacchineEMezzi] BEGIN");
		this.validationMgr.validazioneSalvaMacchineEMezzi(idAzienda, gestioneMacchineMezzi, macchineMezziMap,
				dataTracciato);
		boolean existesezione52 = false;
		//TaifApplSchedaOkDto scheda = getDatiFromSchedaApplOk(idAzienda);
		TaifVApplSchedaOkRealeDto scheda = getInfoSchedeAzienda(idAzienda);
		int idConfigUtente = profiloUtente.getIdConfigUtente();
		if (scheda != null) {
			if ((scheda.getFlgSez52ItaOk().byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt
					|| (scheda.getFlgSez52FraOk()
							.byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
				existesezione52 = true;
				ActionContext.getContext().getSession().put("backDomandaRiepilogo", Constants.BACK_DOMANDA_RIEPILOGO);
			}
		}
		try {
			if (existesezione52) {
				if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
					dbMgr.updateMacchineEMezzi(idAzienda, gestioneMacchineMezzi, idConfigUtente, macchineMezziMap,
							dataTracciato);
				} else {
					dbMgr.updateMacchineEMezziFrancese(idAzienda, gestioneMacchineMezzi, idConfigUtente,
							macchineMezziMap, dataTracciato);
				}

			} else {
				if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
					dbMgr.salvaMacchineEMezzi(idAzienda, gestioneMacchineMezzi, idConfigUtente, macchineMezziMap,
							dataTracciato);
				} else {
					dbMgr.salvaMacchineEMezziFrancese(idAzienda, gestioneMacchineMezzi, idConfigUtente,
							macchineMezziMap, dataTracciato);
				}

			}
		} catch (DbManagerException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}
		LOGGER.debug("[TaifMgr::salvaMacchineEMezzi] END");
	}

	public void salvaPersonale(Integer idAzienda, ArrayList<Personale> elencoPersonale,
			GestionePersonaleFr gestionePersonaleFrancese, TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente,
			String dataTracciato) throws ManagerException {
		// SCHEDA 6
		LOGGER.debug("[TaifMgr::salvaMacchineEMezzi] BEGIN");

		try {
			if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
				this.validationMgr.validationSalvaPersonale(idAzienda, elencoPersonale);
				ArrayList<Personale> listForUpdatePersonale = new ArrayList<Personale>();
				ArrayList<Personale> listForInsertPersonale = new ArrayList<Personale>();
				int idConfigUtente = profiloUtente.getIdConfigUtente();
				if (elencoPersonale != null && !elencoPersonale.isEmpty()) {
					for (Personale personale : elencoPersonale) {
						List<TaifTPersonaByCodiceFiscalePersonaDto> titolarePerCodiceFiscale = dbMgr
								.findPersonaPerCodiceFiscale(personale.getCodiceFiscale());
						if (titolarePerCodiceFiscale != null && !titolarePerCodiceFiscale.isEmpty()) {
							listForUpdatePersonale.add(personale);
						} else {
							listForInsertPersonale.add(personale);
						}
					}
				}
				if (listForUpdatePersonale != null) {
					ActionContext.getContext().getSession().put("backDomandaRiepilogo",
							it.csi.taif.taifweb.util.Constants.BACK_DOMANDA_RIEPILOGO);
					dbMgr.updateColumnsForPersonaleAzienda(idAzienda, listForUpdatePersonale, idConfigUtente,
							dataTracciato);
				}
				if (listForInsertPersonale != null) {
					dbMgr.salvaPersonale(idAzienda, listForInsertPersonale, idConfigUtente, dataTracciato);
				}
			} else {
				this.validationMgr.validationSalvaPersonaleFrancese(idAzienda, gestionePersonaleFrancese);
				// tracciato francese
				boolean existesezione6 = false;
				//TaifApplSchedaOkDto scheda = getDatiFromSchedaApplOk(idAzienda);
				TaifVApplSchedaOkRealeDto scheda = getInfoSchedeAzienda(idAzienda);
				int idConfigUtente = profiloUtente.getIdConfigUtente();
				if (scheda != null) {
					if ((scheda.getFlgSez6FraOk()
							.byteValueExact()) == it.csi.taif.taifweb.business.dao.util.Constants.oneInt) {
						existesezione6 = true;
						ActionContext.getContext().getSession().put("backDomandaRiepilogo",
								Constants.BACK_DOMANDA_RIEPILOGO);
					}
					if (existesezione6) {
						// update
						dbMgr.updatePersonaleFrancese(idAzienda, gestionePersonaleFrancese, idConfigUtente,
								dataTracciato);
					} else {
						// insert
						dbMgr.salvaPersonaleFrancese(idAzienda, gestionePersonaleFrancese, idConfigUtente,
								dataTracciato);
					}
				}

			}
		} catch (DbManagerException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} catch (TaifTPersonaDaoException e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		}
		LOGGER.debug("[TaifMgr::salvaMacchineEMezzi] END");
	}

	public ArrayList<CodeDescription> getElencoTipoTrazioni(VisibileOrdinFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoTrazioni] BEGIN");
		try {
			return this.getDbMgr().getElencoTipoTrazione(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoTrazioni] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoTrazioniPerTipoMezzo(TipoMezzoFilter filter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoTrazioniPerTipoMezzo] BEGIN");
		try {
			return this.getDbMgr().getElencoTipoTrazioniPerTipoMezzo(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoTrazioniPerTipoMezzo] END");
		}
	}

	// getElencoTipoMezzoByCategoria
	public ArrayList<CodeDescription> getElencoTipoMezzoByCategoria(TipoMezzoFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoMezzoByCategoria] BEGIN");
		try {
			return this.getDbMgr().getElencoTipoMezzoByCategoria(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoMezzoByCategoria] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoNoleggi() {
		LOGGER.debug("[TaifMgr::getElencoTipoNoleggi] BEGIN");
		try {
			return ListUtils.createGenericListOfCodeDescription(it.csi.taif.taifweb.business.dao.util.Constants.NO,
					it.csi.taif.taifweb.business.dao.util.Constants.SI);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoNoleggi] END");
		}
	}

	public ArrayList<CodeDescription> getComandoDistanza() {
		LOGGER.debug("[TaifMgr::getComandoDistanza] BEGIN");
		try {
			return ListUtils.createGenericListOfCodeDescription(it.csi.taif.taifweb.business.dao.util.Constants.NO,
					it.csi.taif.taifweb.business.dao.util.Constants.SI);
		} finally {
			LOGGER.debug("[TaifMgr::getComandoDistanza] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoMezzo(VisibileOrdinFilter visibileOrdinFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoMezzo] BEGIN");
		try {
			return this.dbMgr.getElencoTipoMezzo(visibileOrdinFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoMezzo] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoAlimentazione(VisibileOrdinFilter visibileOrdinFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoAlimentazione] BEGIN");
		try {
			return this.dbMgr.getElencoAlimentazione(visibileOrdinFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoAlimentazione] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoCarrello(VisibileOrdinFilter visibileOrdinFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoCarrello] BEGIN");
		try {
			return this.dbMgr.getElencoTipoCarrello(visibileOrdinFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoCarrello] END");
		}
	}

	public ArrayList<CodeDescription> getElencoContratti(VisibileOrdinFilter visibileOrdinFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoContratti] BEGIN");
		try {
			return this.dbMgr.getElencoContratti(visibileOrdinFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoContratti] END");
		}
	}

	public ArrayList<CodeDescription> getElencoDurateContratti(Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoDurateContratti] BEGIN");
		try {
			return this.dbMgr.getElencoDurateContratti(idAzienda);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoDurateContratti] END");
		}
	}

	public ArrayList<CodeDescription> getElencoInquadramenti(VisibileOrdinFilter visibileOrdinFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoInquadramenti] BEGIN");
		try {
			return this.dbMgr.getElencoInquadramenti(visibileOrdinFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoInquadramenti] END");
		}
	}

	public ArrayList<CodeDescription> getElencoMansioni(VisibileOrdinFilter visibileOrdinFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoContratti] BEGIN");
		try {
			return this.dbMgr.getElencoMansioni(visibileOrdinFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoMansioni] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipologiaPersonale(VisibileOrdinFilter visibileOrdinFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipologiaPersonale] BEGIN");
		try {
			return this.dbMgr.getElencoTipologiaPersonale(visibileOrdinFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipologiaPersonale] END");
		}
	}

	public ArrayList<CodeDescription> getElencoProvince() throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoProvince] BEGIN");
		try {
			return this.serviziMgr.limitiAmministrativiGetProvince();
		} finally {
			LOGGER.debug("[TaifMgr::getElencoProvince] END");
		}
	}
	
	public ArrayList<CodeDescription> getElencoProvinceIstat() throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoProvince] BEGIN");
		try {
			return this.serviziMgr.limitiAmministrativiGetProvinceIstat();
		} finally {
			LOGGER.debug("[TaifMgr::getElencoProvince] END");
		}
	}

	public ArrayList<CodeDescription> getElencoComuniPerProvincia(String idProvincia) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoComuniPerProvincia] BEGIN");
		try {
			return this.serviziMgr.limitiAmministrativiGetComuniPerProvincia(idProvincia);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoComuniPerProvincia] END");
		}
	}
	
	public ArrayList<CodeDescription> getElencoComuniPerIstatProvincia(String codiceIstatProvincia) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoComuniPerProvincia] BEGIN");
		try {
			return this.serviziMgr.limitiAmministrativiGetComuniPerIstatProvincia(codiceIstatProvincia);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoComuniPerProvincia] END");
		}
	}

	public ArrayList<CodeDescription> getElencoComuni() throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoComuni] BEGIN");
		try {
			return this.serviziMgr.limitiAmministrativiGetTuttiIComuni();
		} finally {
			LOGGER.debug("[TaifMgr::getElencoComuni] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoSede(VisibileOrdinFilter visibileOrdinFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoSede] BEGIN");
		try {
			return this.dbMgr.getElencoTipoSedeAzienda(visibileOrdinFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoSede] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoSedeAziendaNoSedeLegale(VisibileOrdinFilter visibileOrdinFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoSedeAziendaNoSedeLegale] BEGIN");
		try {
			return this.dbMgr.getElencoTipoSedeAziendaNoSedeLegale(visibileOrdinFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoSedeAziendaNoSedeLegale] END");
		}
	}

	/*
	 * public String getNazioneFromId(int idNazione){ return
	 * this.dbMgr.getNazioneFromId(idNazione); }
	 */

	public ArrayList<Domanda> getElencoDomande(String codFiscale) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoDomande] BEGIN");
		try {
			// return this.dbMgr.getElencoDomande(codFiscale, idNazione);
			return this.dbMgr.findElencoDomandaByLegaleRapp(codFiscale);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoDomande] END");
		}
	}

	// getDomandaByPratica

	public ArrayList<Domanda> getDomandaByPratica(PraticaFilter filter, String idNazione) throws ManagerException {
		LOGGER.debug("[TaifMgr::getDomandaByPratica] BEGIN");
		try {
			return this.dbMgr.getDomandaByPratica(filter, idNazione);
		} finally {
			LOGGER.debug("[TaifMgr::getDomandaByPratica] END");
		}
	}

	public ArrayList<TaifTAziendaDomandaByCodiceFiscaleDto> makePdfTT(String codiceFiscale) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoDomande] BEGIN");
		try {

			return this.dbMgr.getElencoDomandeTT(codiceFiscale);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoDomande] END");
		}
	}

	public String getRuoloById(int idRuolo) throws ManagerException {
		LOGGER.debug("[TaifMgr::getRuoloById] BEGIN");
		try {
			return this.dbMgr.getRuoloById(idRuolo);
		} finally {
			LOGGER.debug("[TaifMgr::getRuoloById] END");
		}
	}

	public it.csi.taif.taifweb.util.service.integration.svista.Comune getComuneByIstat(String codIstatComune)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getComuneByIstat] BEGIN");
		Comune comuneFromIstat = new Comune();
		try {

			comuneFromIstat = serviziMgr.limitiAmministrativiGetComuneByIstat(codIstatComune);
		} finally {
			LOGGER.debug("[TaifMgr::getComuneByIstat] END");
		}
		return comuneFromIstat;

	}

	public it.csi.taif.taifweb.util.service.integration.svista.Provincia getProvinciaByIstat(String codIstatComune)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getComuneByIstat] BEGIN");
		try {
			return serviziMgr.limitiAmministrativiGetProvinciaByIstatComune(codIstatComune);
		} finally {
			LOGGER.debug("[TaifMgr::getComuneByIstat] END");
		}
	}
	// per la ricerca

	public ArrayList<CodeDescription> getElencoAlbi(SoggettoGestoreFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoAlbi] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getAlbi(filter);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TaifMgr::getElencoAlbi] END");
		}
	}

	public ArrayList<CodeDescription> getElencoCategorieImpresaRicerca(VisibileOrdinFilter inputFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoCategorieImpresaRicerca] BEGIN");
		try {
			return dbMgr.getElencoCategorieImpresaRicerca(inputFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoCategorieImpresaRicerca] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoAttivita(VisibileOrdinFilter inputFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoAttivita] BEGIN");
		try {
			return dbMgr.getElencoAttivitaSvolteRicerca(inputFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoAttivita] END");
		}
	}

	public ArrayList<Azienda> ricercaAziende() throws DbManagerException {
		LOGGER.debug("[TaifMgr::ricercaAziende] BEGIN");
		try {
			return null; // dbMgr.ricercaAziende();
		} finally {
			LOGGER.debug("[TaifMgr::ricercaAziende] END");
		}

	}

	public ArrayList<CodeDescription> getElencoAssociazioniCertificazioni(String linguaDati) {
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();

		CodeDescription uno = new CodeDescription();
		uno.setCode(Constants.FILTRO_RICERCA_ALTRI_ALBI);
		CodeDescription due = new CodeDescription();
		due.setCode(Constants.FILTRO_RICERCA_CERTIFICAZIONI);
		if (linguaDati.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.itaLang)) {
			uno.setDescription(Constants.FILTRO_RICERCA_ALTRI_ALBI_TESTO_ITA);
			due.setDescription(Constants.FILTRO_RICERCA_CERTIFICAZIONI_TESTO_ITA);
		} else {
			uno.setDescription(Constants.FILTRO_RICERCA_ALTRI_ALBI_TESTO_FRA);
			due.setDescription(Constants.FILTRO_RICERCA_CERTIFICAZIONI_TESTO_FRA);
		}
		result.add(uno);
		result.add(due);
		return result;
	}

	public List<TaifTAziendaRicercaAziendaAvanzataDto> ricercaAziende(RicercaAziendaFilter aziendaFilter)
			throws DbManagerException {
		// TODO Auto-generated method stub
		LOGGER.debug("[TaifMgr::ricercaAziende] BEGIN");
		try {
			return dbMgr.findRicercaAziendaAvanzata(aziendaFilter);
		} finally {
			LOGGER.debug("[TaifMgr::ricercaAziende] END");
		}
	}

	public ArrayList<Azienda> ricercaAziendeRiepilogo(RicercaAziendaFilter aziendaFilter) throws ManagerException {
		// TODO Auto-generated method stub
		LOGGER.debug("[TaifMgr::findRicercaAziendaAvanzata] BEGIN");
		ArrayList<Azienda> result = new ArrayList<Azienda>();
		try {
			List<TaifTAziendaRicercaAziendaAvanzataDto> list = dbMgr.findRicercaAziendaAvanzata(aziendaFilter);
			if (list != null && !list.isEmpty()) {
				for (TaifTAziendaRicercaAziendaAvanzataDto dto : list) {
					result.add(AziendaFactory.createAzienda(dto,
							ConvertUtil.getLinguaFromSoggettoGestore(aziendaFilter.getIdSoggettoGestore()),
							getComuneByIstat(dto.getIstatComuneSede())));
				}
			}
			return result;
		} finally {
			LOGGER.debug("[TaifMgr::findRicercaAziendaAvanzata] END");
		}
	}

	public List<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto> findCategoriaImpresaByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::findCategoriaImpresaByIdAzienda] BEGIN");
		try {
			return dbMgr.findCategoriaImpresaByIdAzienda(aziendaVisibleFilter);
		} finally {
			LOGGER.debug("[TaifMgr::findCategoriaImpresaByIdAzienda] END");
		}
	}

	public List<TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto> findDettaglioCategoriaImpresaByIdAzienda(
			String idRiga) throws ManagerException {
		LOGGER.debug("[TaifMgr::findDettaglioCategoriaImpresaByIdAzienda] BEGIN");
		try {
			return dbMgr.findDettaglioCategoriaImpresaByIdAzienda(idRiga);
		} finally {
			LOGGER.debug("[TaifMgr::findDettaglioCategoriaImpresaByIdAzienda] END");
		}
	}

	public List<TaifTPraticaAltriAlbiByIdAziendaDto> findAltriAlbiByIdAzienda(String idRiga) throws ManagerException {
		LOGGER.debug("[TaifMgr::findAltriAlbiByIdAzienda] BEGIN");
		try {
			return dbMgr.findAltriAlbiByIdAzienda(idRiga);
		} finally {
			LOGGER.debug("[TaifMgr::findAltriAlbiByIdAzienda] END");
		}
	}

	public List<TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto> findDettaglioCertificazioniByIdAzienda(
			String idRiga) throws ManagerException {
		LOGGER.debug("[TaifMgr::findDettaglioCertificazioniByIdAzienda] BEGIN");
		try {
			return dbMgr.findDettaglioCertificazioniByIdAzienda(idRiga);
		} finally {
			LOGGER.debug("[TaifMgr::findDettaglioCertificazioniByIdAzienda] END");
		}
	}

	public List<TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto> findDettaglioAttivitaByIdAzienda(
			String idRiga) throws ManagerException {
		LOGGER.debug("[TaifMgr::findDettaglioAttivitaByIdAzienda] BEGIN");
		try {
			return dbMgr.findDettaglioAttivitaByIdAzienda(idRiga);
		} finally {
			LOGGER.debug("[TaifMgr::findDettaglioAttivitaByIdAzienda] END");
		}
	}

	public List<TaifTMezzoDettaglioMezzoByIdAziendaDto> findDettaglioMezziIdAzienda(String idRiga)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::findDettaglioMezziIdAzienda] BEGIN");
		try {
			return dbMgr.findDettaglioMezziIdAzienda(idRiga);
		} finally {
			LOGGER.debug("[TaifMgr::findDettaglioMezziIdAzienda] END");
		}
	}

	public byte[] downloadFile(String idAllegato) throws ManagerException {
		LOGGER.debug("[TaifMgr::downloadFile] BEGIN");
		try {
			this.getValidationMgr().validazioneFormaleSelezioneElenco(idAllegato);
			return this.getServiziMgr().indexDownloadFile(idAllegato);
		} finally {
			LOGGER.debug("[TaifMgr::downloadFile] BEGIN");
		}
	}

	public void deleteFile(String idAllegato) throws ManagerException {
		LOGGER.debug("[TaifMgr::deleteFile] BEGIN");
		try {
			this.getValidationMgr().validazioneFormaleSelezioneElenco(idAllegato);
			this.getServiziMgr().indexDeleteFile(idAllegato);
			this.getDbMgr().eliminaAllegato(idAllegato);
		} finally {
			LOGGER.debug("[TaifMgr::deleteFile] BEGIN");
		}
	}
	
	public ArrayList<IstanzaTaglioPresentata> cercaIstanzeForestaPerCodFiscaleTipoComunicazioneStatoAnno(String codiceFiscale, int tipoComunicazione, int stato, int annoCorrente) throws ManagerException {
		LOGGER.debug("[TaifMgr::cercaIstanzeForestaPerCodFiscaleTipoComunicazioneStatoAnno] BEGIN");
		try {
			return this.getServiziMgr().cercaIstanzeForestaPerCodFiscaleTipoComunicazioneStatoAnno(codiceFiscale, tipoComunicazione, stato, annoCorrente);
		} finally {
			LOGGER.debug("[TaifMgr::cercaIstanzeForestaPerCodFiscaleTipoComunicazioneStatoAnno] BEGIN");
		}
	}

	public List<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto> findAssociazioneByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::findAssociazioneByIdAzienda] BEGIN");
		try {
			return dbMgr.findAssociazioneByIdAzienda(aziendaVisibleFilter);
		} finally {
			LOGGER.debug("[TaifMgr::findAssociazioneByIdAzienda] END");
		}
	}

	public ArrayList<TaifCnfTipoAllegatoByAllegatoFilterDto> getTipoFirmaAllegati(TipoAllegatoFilter visibileFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getTipoFirmaAllegati] BEGIN");
		try {
			if (dbMgr != null) {
				return dbMgr.getTipoFirmaAllegati(visibileFilter);
			} else {
				return null;
			}
		} finally {
			LOGGER.debug("[TaifMgr::getTipoFirmaAllegati] END");
		}
	}

	public String uploadFile(int idPratica, Allegato allegato, int idConfigUtente, File file) throws ManagerException {
		// 1. Upload su DB
		int idAllegato = this.dbMgr.insertAllegato(idPratica, allegato, idConfigUtente);
		allegato.setIdAllegato(idAllegato);
		// 2. Upload su INDEX
		this.serviziMgr.indexUploadFile(idPratica, allegato, file);
		return ConvertUtil.convertToString(idAllegato);
	}

	public String uploadFile(int idPratica, Allegato allegato, int idConfigUtente, byte[] file)
			throws ManagerException {
		// 1. Upload su DB
		int idAllegato = this.dbMgr.insertAllegato(idPratica, allegato, idConfigUtente);
		allegato.setIdAllegato(idAllegato);
		// 2. Upload su INDEX
		this.serviziMgr.indexUploadFile(idPratica, allegato, file);
		return ConvertUtil.convertToString(idAllegato);
	}

	public Riepilogo getRiepilogo(Integer idAzienda, Integer idAlbo) throws ManagerException {
		LOGGER.debug("[TaifMgr::getRiepilogo] BEGIN");
		try {
			return this.dbMgr.getRiepilogo(idAzienda, idAlbo);
		} finally {
			LOGGER.debug("[TaifMgr::getRiepilogo] END");
		}
	}

	public List<TaifTCertificazioneFindCertificazioniByIdAziendaDto> findCertificazioniByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::findCertificazioniByIdAzienda] BEGIN");
		try {
			return dbMgr.findCertificazioniByIdAzienda(aziendaVisibleFilter);
		} finally {
			LOGGER.debug("[TaifMgr::findCertificazioniByIdAzienda] END");
		}
	}

	public List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> findAttivitaSvoltaByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::findAttivitaSvoltaByIdAzienda] BEGIN");
		try {
			return dbMgr.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
		} finally {
			LOGGER.debug("[TaifMgr::findAttivitaSvoltaByIdAzienda] END");
		}
	}

	public List<TaifTLavoroPaLavoroPaByAziendaVisibileDto> findLavoroPaByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::findLavoroPaByIdAzienda] BEGIN");
		try {
			return dbMgr.findLavoroPaByIdAzienda(aziendaVisibleFilter);
		} finally {
			LOGGER.debug("[TaifMgr::findLavoroPaByIdAzienda] END");
		}
	}

	public List<TaifTCommercializzazioneByAziendaDto> findCommerciallizazioneByIdAzienda(Integer idAzienda)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::findCommerciallizazioneByIdAzienda] BEGIN");
		try {
			return dbMgr.findCommerciallizazioneByIdAzienda(idAzienda);
		} finally {
			LOGGER.debug("[TaifMgr::findCommerciallizazioneByIdAzienda] END");
		}
	}

	public String findSpecieByIdSpecieVisible(SpecieFilter specieFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::findSpecieByIdSpecieVisible] BEGIN");
		try {
			if (dbMgr.findSpecieByIdSpecieVisible(specieFilter) != null
					&& dbMgr.findSpecieByIdSpecieVisible(specieFilter).size() > 0) {
				return dbMgr.findSpecieByIdSpecieVisible(specieFilter).get(0).getNomeSpecie();
			}
		} finally {
			LOGGER.debug("[TaifMgr::findSpecieByIdSpecieVisible] END");
		}
		return null;
	}

	public String findAssortimentoByIdAssortimentoVisible(AssortimentoFilter assortimentoFilte)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::findAssortimentoByIdAssortimentoVisible] BEGIN");
		try {
			if (dbMgr.findAssortimentoByIdAssortimentoVisible(assortimentoFilte) != null
					&& dbMgr.findAssortimentoByIdAssortimentoVisible(assortimentoFilte).size() > 0) {
				return dbMgr.findAssortimentoByIdAssortimentoVisible(assortimentoFilte).get(0).getAssortimento();
			}
		} finally {
			LOGGER.debug("[TaifMgr::findAssortimentoByIdAssortimentoVisible] END");
		}
		return null;
	}

	public String findProvenienzaByIdProvenienzaVisible(ProvenienzaFilter provenienzaFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::findAssortimentoByIdAssortimentoVisible] BEGIN");
		try {
			if (dbMgr.findProvenienzaByIdProvenienzaVisible(provenienzaFilter) != null
					&& dbMgr.findProvenienzaByIdProvenienzaVisible(provenienzaFilter).size() > 0) {
				return dbMgr.findProvenienzaByIdProvenienzaVisible(provenienzaFilter).get(0).getProvenienza();
			}
		} finally {
			LOGGER.debug("[TaifMgr::findAssortimentoByIdAssortimentoVisible] END");
		}
		return null;
	}

	public String findCommUmByIdUnitaMisuraVisible(UnitaMisuraFilter unitaMisuraFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::findAssortimentoByIdAssortimentoVisible] BEGIN");
		try {
			if (dbMgr.findCommUmByIdUnitaMisuraVisible(unitaMisuraFilter) != null
					&& dbMgr.findCommUmByIdUnitaMisuraVisible(unitaMisuraFilter).size() > 0) {
				return dbMgr.findCommUmByIdUnitaMisuraVisible(unitaMisuraFilter).get(0).getUnitaMisura();
			}
		} finally {
			LOGGER.debug("[TaifMgr::findAssortimentoByIdAssortimentoVisible] END");
		}
		return null;
	}

	public List<TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto> findFindFunzioneTipoStrutturaByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::findFindFunzioneTipoStrutturaByIdAzienda] BEGIN");
		try {
			if (dbMgr.findFindFunzioneTipoStrutturaByIdAzienda(aziendaVisibleFilter) != null
					&& dbMgr.findFindFunzioneTipoStrutturaByIdAzienda(aziendaVisibleFilter).size() > 0) {
				return dbMgr.findFindFunzioneTipoStrutturaByIdAzienda(aziendaVisibleFilter);
			}
		} finally {
			LOGGER.debug("[TaifMgr::findFindFunzioneTipoStrutturaByIdAzienda] END");
		}
		return null;
	}

	public List<TaifTDpiDpiByAziendaVisibileDto> findDpiByAziendaVisibile(AziendaVisibleFilter aziendaVisibleFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::findDpiByAziendaVisibile] BEGIN");
		try {
			if (dbMgr.findDpiByAziendaVisibile(aziendaVisibleFilter) != null
					&& dbMgr.findDpiByAziendaVisibile(aziendaVisibleFilter).size() > 0) {
				return dbMgr.findDpiByAziendaVisibile(aziendaVisibleFilter);
			}
		} finally {
			LOGGER.debug("[TaifMgr::findDpiByAziendaVisibile] END");
		}
		return null;
	}

	public List<TaifTMezzoByTipoMezzoAziendaVisibileDto> findByTipoMezzoAziendaVisibile(TipoMezzoFilter tipoMezzoFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::findByTipoMezzoAziendaVisibile] BEGIN");
		try {
			if (dbMgr.findByTipoMezzoAziendaVisibile(tipoMezzoFilter) != null
					&& dbMgr.findByTipoMezzoAziendaVisibile(tipoMezzoFilter).size() > 0) {
				return dbMgr.findByTipoMezzoAziendaVisibile(tipoMezzoFilter);
			}
		} finally {
			LOGGER.debug("[TaifMgr::findByTipoMezzoAziendaVisibile] END");
		}
		return null;
	}

	public List<TaifRTrazTipoMezzoByIdTipoMezzoDto> findTrazioneByIdTipoMezzo(Integer idTipoMezzo)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::findByIdTipoMezzo] BEGIN");
		try {
			if (dbMgr.findByIdTipoMezzo(idTipoMezzo) != null && dbMgr.findByIdTipoMezzo(idTipoMezzo).size() > 0) {
				return dbMgr.findByIdTipoMezzo(idTipoMezzo);
			}
		} finally {
			LOGGER.debug("[TaifMgr::findByIdTipoMezzo] END");
		}
		return null;
	}

	public TaifRTrazTipoMezzoDto findByPrimaryKey(Integer idTipoMezzo, Integer idTrazione) throws ManagerException {
		LOGGER.debug("[TaifMgr::findByPrimaryKey] BEGIN");
		try {
			if (dbMgr.findByPrimaryKey(idTipoMezzo, idTrazione) != null) {
				return dbMgr.findByPrimaryKey(idTipoMezzo, idTrazione);
			}
		} finally {
			LOGGER.debug("[TaifMgr::findByPrimaryKey] END");
		}
		return new TaifRTrazTipoMezzoDto();
	}

	public ArrayList<TaifTAziendaRicercaAziendaAvanzataDto> findRicercaAziendaAvanzata(RicercaAziendaFilter filter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::findRicercaAziendaAvanzata] BEGIN");
		try {
			if (dbMgr.findRicercaAziendaAvanzata(filter) != null) {
				return dbMgr.findRicercaAziendaAvanzata(filter);
			}
		} finally {
			LOGGER.debug("[TaifMgr::findRicercaAziendaAvanzata] END");
		}
		return null;
	}

	//

	public List<TaifDCategoriaMezzoByIdTipoMezzoDto> findTipoECategoriaByIdTipoMezzo(TipoMezzoFilter tipoMezzoFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::findTipoECategoriaByIdTipoMezzo] BEGIN");
		try {

			List<TaifDCategoriaMezzoByIdTipoMezzoDto> listCategoraMezzoByIdMezzo = dbMgr
					.findTipoECategoriaByIdTipoMezzo(tipoMezzoFilter);
			if (listCategoraMezzoByIdMezzo != null && listCategoraMezzoByIdMezzo.size() > 0) {
				return listCategoraMezzoByIdMezzo;
			}
		} finally {
			LOGGER.debug("[TaifMgr::findTipoECategoriaByIdTipoMezzo] END");
		}
		return null;
	}

	public String findTipoTrazioneByIdTrazione(Integer idTipoTrazione) throws ManagerException {
		LOGGER.debug("[TaifMgr::findTipoTrazioneByIdTrazione] BEGIN");
		try {
			TaifDTrazioneDto tipoTrazione = dbMgr.findTipoTrazioneByIdTrazione(idTipoTrazione);
			if (tipoTrazione != null) {
				return tipoTrazione.getTrazione();
			}
		} finally {
			LOGGER.debug("[TaifMgr::findTipoTrazioneByIdTrazione] END");
		}
		return null;
	}

	public String findTipoAlimentazioneById(Integer idTipoAlim) throws ManagerException {
		LOGGER.debug("[TaifMgr::findTipoTrazioneByIdTrazione] BEGIN");
		try {
			TaifDAlimentazioneDto tipoAlimentazione = dbMgr.findTipoAllimentazioneMezzoById(idTipoAlim);
			if (tipoAlimentazione != null) {
				return tipoAlimentazione.getAlimentazione();
			}
		} finally {
			LOGGER.debug("[TaifMgr::findTipoTrazioneByIdTrazione] END");
		}
		return null;
	}

	public String findTipoCarrelloById(Integer idTipoCarrello) throws ManagerException {
		LOGGER.debug("[TaifMgr::findTipoCarrelloById] BEGIN");
		try {
			TaifDTipoCarrelloDto tipoCarrello = dbMgr.findTipoCarrelloByIdCarello(idTipoCarrello);
			if (tipoCarrello != null) {
				return tipoCarrello.getTipoCarrello();
			}
		} finally {
			LOGGER.debug("[TaifMgr::findTipoCarrelloById] END");
		}
		return null;
	}

	public List<TaifRPersonaAziendaByIdAziendaDto> getPersonePerIdAzienda(Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::getPersonePerIdAzienda] BEGIN");
		try {
			List<TaifRPersonaAziendaByIdAziendaDto> listPersonePerIdAzienda = dbMgr.getPersonePerIdAzienda(idAzienda);
			if (listPersonePerIdAzienda != null && !listPersonePerIdAzienda.isEmpty()) {
				return listPersonePerIdAzienda;
			}
		} finally {
			LOGGER.debug("[TaifMgr::getPersonePerIdAzienda] END");
		}
		return null;
	}

	public TaifTPersonaDto getPersonaByIdPersona(Integer idPersona) throws ManagerException {
		LOGGER.debug("[TaifMgr::getPersonePerIdAzienda] BEGIN");
		TaifTPersonaDto personaById;
		try {
			personaById = dbMgr.getPersonaByIdPersona(idPersona);
		} finally {
			LOGGER.debug("[TaifMgr::getPersonePerIdAzienda] END");
		}
		return personaById;
	}

	public String findTipoContrattoByIdAndVisibile(ContrattoFilter contrattoFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::findTipoContrattoByIdAndVisibile] BEGIN");
		TaifDTipoContrattoByIdContrattoDto contrattoPersona;
		try {
			contrattoPersona = dbMgr.findTipoContrattoByIdAndVisibile(contrattoFilter);
		} finally {
			LOGGER.debug("[TaifMgr::findTipoContrattoByIdAndVisibile] END");
		}
		return contrattoPersona.getTipoContratto();
	}

	public String findTipoInquadramentoByIdVisibile(InquadramentoFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::findTipoInquadramentoByIdVisibile] BEGIN");
		TaifDTipoInquadramentoByIdInquadramentoDto inquadramento;
		try {
			inquadramento = dbMgr.findTipoInquadramentoByIdVisibile(filter);
		} finally {
			LOGGER.debug("[TaifMgr::findTipoInquadramentoByIdVisibile] END");
		}
		return inquadramento.getTipoInquadramento();
	}

	public ArrayList<CodeDescription> getElencoStatiPraticaIta(StatoPraticaFilter statoFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoStatiPratica] BEGIN");
		ArrayList<CodeDescription> listStatoPratica;
		try {
			listStatoPratica = dbMgr.getElencoStatiPraticaIta(statoFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoStatiPratica] END");
		}
		return listStatoPratica;
	}

	public ArrayList<CodeDescription> getElencoStatiPraticaFra(StatoPraticaFilter statoFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoStatiPratica] BEGIN");
		ArrayList<CodeDescription> listSottoStatoPratica;
		try {
			listSottoStatoPratica = dbMgr.getElencoStatiPraticaFra(statoFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoStatiPratica] END");
		}
		return listSottoStatoPratica;
	}

	public ArrayList<CodeDescription> getElencoSottoStatiPraticaIta(StatoPraticaFilter statoFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoSottoStatiPraticaIta] BEGIN");
		ArrayList<CodeDescription> listSottoStatoPratica;
		try {
			listSottoStatoPratica = dbMgr.getElencoSottoStatiPraticaIta(statoFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoSottoStatiPraticaIta] END");
		}
		return listSottoStatoPratica;
	}

	public ArrayList<CodeDescription> getElencoSottoStatiPraticaFra(StatoPraticaFilter statoFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoSottoStatiPraticaFra] BEGIN");
		ArrayList<CodeDescription> listSottoStatoPratica;
		try {
			listSottoStatoPratica = dbMgr.getElencoSottoStatiPraticaFra(statoFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoSottoStatiPraticaFra] END");
		}
		return listSottoStatoPratica;
	}

	public TitolareRappresentanteLegale findInAnagraficaByCodiceFiscalePersona(String codiceFiscale)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::findInAnagraficaByCodiceFiscalePersona] BEGIN");
		try {
			return dbMgr.findByCodiceFiscalePersona(codiceFiscale);
		} finally {
			LOGGER.debug("[TaifMgr::findInAnagraficaByCodiceFiscalePersona] END");
		}
	}
	
	public TitolareRappresentanteLegale findLastInAnagraficaByCodiceFiscalePersona(String codiceFiscale)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::findInAnagraficaByCodiceFiscalePersona] BEGIN");
		try {
			return dbMgr.findLastByCodiceFiscalePersona(codiceFiscale);
		} finally {
			LOGGER.debug("[TaifMgr::findInAnagraficaByCodiceFiscalePersona] END");
		}
	}

	public List<TaifTPersonaByCodiceFiscalePersonaDto> findPersonaPerCodiceFiscale(String codiceFiscale)
			throws DbManagerException {
		LOGGER.debug("[DbMgr::findPersonaPerCodiceFiscale] BEGIN ");
		try {
			List<TaifTPersonaByCodiceFiscalePersonaDto> personaPerCodiceFiscale = dbMgr
					.findPersonaPerCodiceFiscale(codiceFiscale);
			return personaPerCodiceFiscale;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findPersonaPerCodiceFiscale] END");
		}
	}

	public Integer updateDatiAziendali(Integer idAzienda, AnagraficaAziendale anagraficaAziendale, Sede sedeLegale,
			ArrayList<Sede> sedi, Albo albo, String dataTracciato, int idAlbo) throws ManagerException {
		LOGGER.debug("[TaifMgr::updateDatiAziendali] BEGIN");
		TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente = (TaifTPersonaProfiloUtenteByCodiceFiscaleDto) ActionContext
				.getContext().getSession().get("profiloUtente");

		this.validationMgr.validazioneCodiceFiscaleEPiva(anagraficaAziendale, dataTracciato);
		this.validationMgr.validazioneDatiAziendali(idAzienda, anagraficaAziendale, sedeLegale, sedi, dataTracciato,
				idAlbo);
		Integer result = idAzienda;
		try {
			BeAnagraficaAziendaleDto backAnagraficaAziendale = new BeAnagraficaAziendaleDto();

			List<BeSedeDto> backSediList = new ArrayList<BeSedeDto>();
			sedeLegale.setIdTipoSede(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);

			try {
				sedi.add(sedeLegale);
				backSediList = dbMgr.getListSedePerAziendaFeToBe(sedi);
				backAnagraficaAziendale = dbMgr.getAnagraficaAziendaleFeToBe(anagraficaAziendale);

				if (backAnagraficaAziendale != null && backSediList != null) {
					result = dbMgr.updateDatiAziendaSedeByIdAzienda(idAzienda, backAnagraficaAziendale, backSediList,
							albo, profiloUtente.getIdConfigUtente(), dataTracciato);
				}
			} catch (DbManagerException e) {
				throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
			}
		} finally {
			LOGGER.debug("[TaifMgr::updateDatiAziendali] END");
		}
		return result;
	}

	// mm
	public void updateTitolareConduttoreRiepilogo(Integer idAzienda, TitolareRappresentanteLegale titolare,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente, String dataTracciato) throws ManagerException {

		// mod 1.2
		LOGGER.debug("[TaifMgr::updateTitolareRappresentanteLegale] BEGIN");
		this.validationMgr.validazioneTitolariRappresentante(idAzienda, titolare, null,
				it.csi.taif.taifweb.business.dao.util.Constants.SI);
		try {
			BeTitolareRappresentanteLegaleDto backTitolareLegale = new BeTitolareRappresentanteLegaleDto();
			try {
				List<TaifTPersonaByCodiceFiscalePersonaDto> titolarePerCodiceFiscale = dbMgr
						.findPersonaPerCodiceFiscale(titolare.getCodiceFiscale());
				if (titolare != null) {
					// only for test -- manca provincia , comune
					titolare.setIdComuneNascita("1234");
					titolare.setIdComuneResidenza("3456");
					backTitolareLegale = dbMgr.getTitolareRappresentanteLegalePerAziendaFeToBe(titolare);
				}
				if (titolarePerCodiceFiscale != null && !titolarePerCodiceFiscale.isEmpty()) {
					dbMgr.updateTitolareConduttoreRiepilogo(idAzienda, titolare, profiloUtente,
							titolarePerCodiceFiscale, dataTracciato);
				}
			} catch (DbManagerException e) {
				throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));

			} catch (TaifTPersonaDaoException e) {
				throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
			}

		} finally {
			LOGGER.debug("[TaifMgr::updateTitolareRappresentanteLegale] END");
		}

	}

	//
	public Riepilogo getRiepilogoByPratica(Integer idPratica) throws ManagerException {
		LOGGER.debug("[TaifMgr::getRiepilogoByPratica] BEGIN");
		try {
			return this.dbMgr.getRiepilogoByPratica(idPratica);
		} finally {
			LOGGER.debug("[TaifMgr::getRiepilogoByPratica] END");
		}
	}

	public ArrayList<CodeDescription> getDurataContratto() {
		LOGGER.debug("[TaifMgr::getDurataContratto] BEGIN");
		try {
			// return
			// ListUtils.createGenericListOfCodeDescriptionSameCode(it.csi.taif.taifweb.business.dao.util.Constants.DET,it.csi.taif.taifweb.business.dao.util.Constants.INDET);
			return ListUtils.createGenericListOfCodeDescription(it.csi.taif.taifweb.business.dao.util.Constants.DET,
					it.csi.taif.taifweb.business.dao.util.Constants.INDET);
		} finally {
			LOGGER.debug("[TaifMgr::getDurataContratto] END");
		}
	}

	public ArrayList<CodeDescription> getTagliatoAquistatoTALista() {
		LOGGER.debug("[TaifMgr::getComandoDistanza] BEGIN");
		try {
			return ListUtils.createGenericListOfCodeDescriptionSameCode(
					it.csi.taif.taifweb.business.dao.util.Constants.TAGLIATO,
					it.csi.taif.taifweb.business.dao.util.Constants.ACQUISTATO);
			// return ListUtils.createGenericListOfCodeDescription(
			// it.csi.taif.taifweb.business.dao.util.Constants.TAGLIATO,
			// it.csi.taif.taifweb.business.dao.util.Constants.AQUISTATO);
		} finally {
			LOGGER.debug("[TaifMgr::getComandoDistanza] END");
		}
	}

	public ArrayList<CodeDescription> getElencoSezioni() {
		LOGGER.debug("[TaifMgr::getElencoSezioni] BEGIN");
		try {
			return ListUtils.createListOfCodeDescription(it.csi.taif.taifweb.business.dao.util.Constants.aChar,
					it.csi.taif.taifweb.business.dao.util.Constants.bChar);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoSezioni] END");
		}
	}

	public Personale findInAnagraficaByCodiceFiscalePersonaPerContratto(String codiceFiscale) throws ManagerException {
		LOGGER.debug("[TaifMgr::findInAnagraficaByCodiceFiscalePersona] BEGIN");
		try {
			return dbMgr.findPersonaByCodiceFiscalePersonaPerContratto(codiceFiscale);
		} finally {
			LOGGER.debug("[TaifMgr::findInAnagraficaByCodiceFiscalePersona] END");
		}
	}

	public TaifApplSchedaOkDto getDatiFromSchedaApplOk(Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::getDatiFromSchedaApplOk] BEGIN");
		try {
			TaifApplSchedaOkDto listElencoTipo = dbMgr.getDatiFromSchedaApplOk(idAzienda);
			return listElencoTipo;
		} finally {
			LOGGER.debug("[TaifMgr::getDatiFromSchedaApplOk] BEGIN");
		}
	}

	public ProfiloUtenteTaif getProfiloUtente(String codiceFiscale) throws ManagerException {
		LOGGER.debug("[TaifMgr::getProfiloUtente] BEGIN ");
		try {
			return this.dbMgr.getProfiloUtente(codiceFiscale);
		} finally {
			LOGGER.debug("[TaifMgr::getProfiloUtente] END");
		}
	}

	public ProfiloUtenteTaif getProfiloUtenteGestore(String codiceFiscale) throws ManagerException {
		LOGGER.debug("[TaifMgr::getProfiloUtente] BEGIN ");
		try {
			return this.dbMgr.getProfiloUtenteGestore(codiceFiscale);
		} finally {
			LOGGER.debug("[TaifMgr::getProfiloUtente] END");
		}
	}

	public List<CodeDescription> getElencoPersone() throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoPersone] BEGIN ");
		try {
			return this.dbMgr.getElencoPersone();
		} finally {
			LOGGER.debug("[TaifMgr::getElencoPersone] END");
		}
	}

	public Personale getPersonaByCodiceFiscale(String codiceFiscale, VisibileOrdinFilter filter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getPersonaByCodiceFiscale] BEGIN ");
		try {
			return this.dbMgr.getPersonaByCodiceFiscale(codiceFiscale, filter);
		} finally {
			LOGGER.debug("[TaifMgr::getPersonaByCodiceFiscale] END");
		}
	}

	public UserInfo accessFromUserPassword(LoginInfo info) throws ManagerException {
		LOGGER.debug("[TaifMgr::accessFromUserPassword] BEGIN ");
		try {
			this.validationMgr.validateLoginInfo(info);
			return this.dbMgr.accessFromUserPassword(info);
		} finally {
			LOGGER.debug("[TaifMgr::accessFromUserPassword] END");
		}
	}

	public TaifTPersonaProfiloUtenteByCodiceFiscaleDto getConfigProfiloUtenteByCodiceFiscale(ConfigProfiloFilter filtro,
			int idProfilo) throws ManagerException {
		LOGGER.debug("[TaifMgr::TaifTPersonaProfiloUtenteByCodiceFiscaleDto] BEGIN ");
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
			LOGGER.debug("[TaifMgr::TaifTPersonaProfiloUtenteByCodiceFiscaleDto] END");
		}

	}
	// public AnagraficaAziendale getAnagraficaAziendale(Integer idAzienda) throws
	// DbManagerException {

	public AnagraficaAziendale getAnagraficaAziendaleFromIdAzienda(int idAzienda, String tracciato)
			throws DbManagerException {
		LOGGER.debug("[DbMgr::getAziendaById] BEGIN");
		try {
			return dbMgr.getAnagraficaAziendale(idAzienda, tracciato);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getAziendaById] END");
		}
	}

	public ArrayList<CategoriaImpresa> getCategoriaImpresaByAzienda(int idAzienda) throws DbManagerException {
		LOGGER.debug("[DbMgr::getCategoriaImpresaByAzienda] BEGIN");
		try {
			return dbMgr.getCategoriaImpresa(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getCategoriaImpresaByAzienda] END");
		}
	}

	public List<TaifTPraticaByIdAziendaDto> getPraticaPerIdAzienda(int idAzienda) throws DbManagerException {
		LOGGER.debug("[DbMgr::getPraticaPerIdAzienda] BEGIN");
		try {
			return dbMgr.getPraticaPerIdAzienda(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getPraticaPerIdAzienda] END");
		}
	}

	public List<TaifRAziendaAssociazioneByIdAziendaDto> getElencoAssociazioniPerIdAzienda(int idAzienda)
			throws DbManagerException {
		LOGGER.debug("[DbMgr::getElencoAssociazioniPerIdAzienda] BEGIN");
		try {
			return dbMgr.getAssociazioniPerIdAzienda(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getElencoAssociazioniPerIdAzienda] END");
		}
	}

	public List<TaifTAziendaDettaglioAziendaByIdAziendaDto> ricercaAziendeById(String idRiga)
			throws DbManagerException {
		LOGGER.debug("[DbMgr::ricercaAziendeById] BEGIN");
		try {
			return dbMgr.ricercaAziendeById(idRiga);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::ricercaAziendeById] END");
		}
	}

	public List<TaifRPersonaAziendaConteggioPersonaDto> conteggioNumeroAddettiByIdAzienda(String idRiga)
			throws DbManagerException {
		LOGGER.debug("[DbMgr::conteggioNumeroAddettiByIdAzienda] BEGIN");
		try {
			return dbMgr.conteggioNumeroAddettiByIdAzienda(idRiga);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::conteggioNumeroAddettiByIdAzienda] END");
		}
	}

	public List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> findAttivitaSvoltaAndDettByIdAzienda(
			AziendaVisibleFilter aziendaVisibleFilter) throws DbManagerException {
		LOGGER.debug("[DbMgr::findAttivitaSvoltaAndDettByIdAzienda] BEGIN");
		List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> attivitaSvolta;
		try {
			attivitaSvolta = dbMgr.findAttivitaSvoltaAndDettByIdAzienda(aziendaVisibleFilter);
			if (attivitaSvolta == null) {
				attivitaSvolta = new ArrayList<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto>();
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findAttivitaSvoltaAndDettByIdAzienda] BEGIN");
		}
		return attivitaSvolta;

	}

	public List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> findMaterialeByAttivitaProgressivo(
			AttivitaProgressivoFilter aziendaVisibleFilter) throws DbManagerException {
		LOGGER.debug("[DbMgr::findMaterialeByAttivitaProgressivo] BEGIN");
		List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> materialeAttivitaList;
		try {
			materialeAttivitaList = dbMgr.findMaterialeByAttivitaProgressivo(aziendaVisibleFilter);
			if (materialeAttivitaList == null) {
				materialeAttivitaList = new ArrayList<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto>();
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findMaterialeByAttivitaProgressivo] BEGIN");
		}
		return materialeAttivitaList;

	}

	public TaifRAttivDetMaterialeDto findByPrimaryKeyMaterialeDett(TaifRAttivDetMaterialePk materialeAttProgressivo)
			throws DbManagerException {
		LOGGER.debug("[DbMgr::findByPrimaryKey] BEGIN");
		TaifRAttivDetMaterialeDto materialeById;
		try {
			materialeById = dbMgr.findByPrimaryKeyMaterialeDett(materialeAttProgressivo);
			if (materialeById == null) {
				materialeById = new TaifRAttivDetMaterialeDto();
			}
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findByPrimaryKey] BEGIN");
		}
		return materialeById;

	}

	public List<TaifDTipoMezzoByCategoriaMezzoDto> cercaTipoMezzoPerCategoriaMezzo(TipoMezzoFilter tipoMezzoFilter)
			throws DbManagerException {
		LOGGER.debug("[DbMgr::cercaTipoMezzoPerCategoriaMezzo] BEGIN");
		try {
			return dbMgr.cercaTipoMezzoPerCategoriaMezzo(tipoMezzoFilter);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::cercaTipoMezzoPerCategoriaMezzo] END");
		}
	}

	public List<TaifTMezzoByIdTipoMezzoAziendaDto> findMezzoByIdTipoMezzoAzienda(TipoMezzoFilter tipoMezzoFilter)
			throws DbManagerException {
		LOGGER.debug("[DbMgr::findMezzoByIdTipoMezzoAzienda] BEGIN");
		try {
			return dbMgr.findMezzoByIdTipoMezzoAzienda(tipoMezzoFilter);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findMezzoByIdTipoMezzoAzienda] END");
		}
	}

	public TitolareRappresentanteLegale findPersoneListByIdAzienda(int idAzienda, int idRuolo, String dataTracciato)
			throws DbManagerException {
		LOGGER.debug("[DbMgr::findListPersoneByIdAzienda] BEGIN");
		try {
			TitolareRappresentanteLegale legaleRappresentante = dbMgr.findPersoneListByIdAziendaIdRuolo(idAzienda,
					idRuolo, dataTracciato);
			return legaleRappresentante;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findListPersoneByIdAzienda] END");
		}
	}

	public Integer findUserCollegatoPerCodiceFiscale(PersonaFilter filterPersona, String tracciato)
			throws DbManagerException {
		LOGGER.debug("[DbMgr::findUserCollegatoPerCodiceFiscale] BEGIN");
		try {
			Integer idConfigUtente = dbMgr.findUserCollegatoPerCodiceFiscale(filterPersona, tracciato);
			// this.validationMgr.validateProfiloUtente(idPersonaR);

			return idConfigUtente;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::findUserCollegatoPerCodiceFiscale] END");
		}
	}

	public TaifTStoricoStatoByStatoPraticaDto cambiaStato(Integer idPratica, Integer idStatoDomanda, Integer idConfigUtente) throws ManagerException {
		LOGGER.debug("[TaifMgr::cambiaStato] BEGIN");
		this.dbMgr.cambiaStato(idPratica, idStatoDomanda, idConfigUtente);
		TaifTStoricoStatoByStatoPraticaDto result = this.dbMgr.getDettaglioStato(idPratica, idStatoDomanda);
		LOGGER.debug("[TaifMgr::cambiaStato] BEGIN");
		return result;
	}

	public Integer getIdPraticaByAziendaAndSoggettoGestore(Integer idAzienda, Integer idSoggettoGestore)
			throws ManagerException {
		return this.getDbMgr().getIdPraticaByAziendaAndSoggettoGestore(idAzienda, idSoggettoGestore);
	}

	public void eliminaDomandaByIdzienda(Integer idPratica) throws DbManagerException {
		LOGGER.debug("[TaifMgr::eliminaDomandaByIdzienda] BEGIN");
		try {

			TaifTPraticaDto praticaByIdPratica = getPraticByIdPratica(idPratica);
			Integer idAzienda = praticaByIdPratica.getFkAzienda();
			dbMgr.eliminaDomandaByIdzienda(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[TaifMgr::eliminaDomandaByIdzienda] END");
		}
	}

	public ArrayList<Allegato> getElencoAllegati(Integer idPratica) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoAllegati] BEGIN");
		try {
			return this.dbMgr.getElencoAllegati(idPratica);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoAllegati] END");
		}
	}

	public List<Integer> getAllegatiObbligatoriPerPratica(TipoAllegatoFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getAllegatiObbligatoriPerPratica] BEGIN");
		try {
			return this.dbMgr.getAllegatiObbligatoriPerPratica(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getAllegatiObbligatoriPerPratica] END");
		}
	}

	/*
	 * public void findSchedaAzienda(Integer idAzienda, String tracciato) throws
	 * ManagerException { LOGGER.debug("[DbMgr::findSchedaAzienda] BEGIN"); try {
	 * dbMgr.findSchedaAzienda(idAzienda, tracciato); } catch (Exception e) { throw
	 * new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001)); }
	 * finally { LOGGER.debug("[DbMgr::findSchedaAzienda] END"); }
	 * 
	 * }
	 */

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

	public ArrayList<DettaglioAttivitaUltimoAnnoFr> getElencoAttivitaUltimoAnnoFrancese(Integer idAzienda,
			List<Integer> listAttivitaFrancese) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoAttivitaUltimoAnno] BEGIN");
		try {
			return dbMgr.getElencoAttivitaUltimoAnnoFrancese(idAzienda, listAttivitaFrancese);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoAttivitaUltimoAnno] END");
		}
	}
	// getElencoTipoAttivita

	public List<TaifDTipoAttivitaByFilterDto> getElencoIdTipoAttivitaFrancese(VisibileOrdinFilter inputFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoAttivita] BEGIN");
		try {
			return dbMgr.getElencoIdTipoAttivitaFrancese(inputFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoAttivita] END");
		}
	}

	public ArrayList<String> getElencoDSTipoAttivitaFrancese(VisibileOrdinFilter inputFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoTipoAttivita] BEGIN");
		try {
			return dbMgr.getElencoDSTipoAttivitaFrancese(inputFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoAttivita] END");
		}
	}

	public List<TaifDTipoContrattoByVisibleOrdinDto> getElencoContrattiPerTracciato(VisibileOrdinFilter inputFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoContrattiPerTracciato] BEGIN");
		try {
			return dbMgr.getElencoContrattiPerTracciato(inputFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoContrattiPerTracciato] END");
		}
	}

	public List<TaifDTipoMansioneByVisibleOrdinDto> getElencoMansioniPerTracciato(VisibileOrdinFilter inputFilter)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoMansioniPerTracciato] BEGIN");
		try {
			return dbMgr.getElencoMansioniPerTracciato(inputFilter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoMansioniPerTracciato] END");
		}
	}

	public List<TaifRAziendaFrTipoContrFindTipoByIdAziendaDto> getContrattoByAziendaFrancese(int idAzienda)
			throws ManagerException {
		LOGGER.debug("[TaifMgr::getContrattoByAziendaFrancese] BEGIN");
		try {
			return dbMgr.getContrattoByAziendaFrancese(idAzienda);
		} finally {
			LOGGER.debug("[TaifMgr::getContrattoByAziendaFrancese] END");
		}
	}

	public List<TaifRAziendaFrTipoMansFindTipoByIdAziendaDto> getMansioneByAziendaFrancese(int idAzienda)
			throws DbManagerException {
		LOGGER.debug("[TaifMgr::getMansioneByAziendaFrancese] BEGIN");
		try {
			return dbMgr.getMansioneByAziendaFrancese(idAzienda);
		} finally {
			LOGGER.debug("[TaifMgr::getMansioneByAziendaFrancese] END");
		}
	}

	public ArrayList<Domanda> getElencoDomandeSecondo(String codFiscale) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoDomande] BEGIN");
		try {
			// return this.dbMgr.getElencoDomande(codFiscale, idNazione);
			return this.dbMgr.findElencoDomandaByLegaleRappAndProf(codFiscale);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoDomande] END");
		}
	}

	public ArrayList<CodeDescription> getElencoTipoNoleggiFrancese() {
		LOGGER.debug("[TaifMgr::getElencoTipoNoleggi] BEGIN");
		try {
			return ListUtils.createGenericListOfCodeDescription(it.csi.taif.taifweb.business.dao.util.Constants.NO,
					it.csi.taif.taifweb.business.dao.util.Constants.OUI);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoTipoNoleggi] END");
		}
	}

	public TitolareRappresentanteLegale findByNrSiMsaPersonaFrancese(String codiceFiscale) throws ManagerException {
		LOGGER.debug("[TaifMgr::findInAnagraficaByCodiceFiscalePersona] BEGIN");
		try {
			return dbMgr.findByNrSiMsaPersonaFrancese(codiceFiscale);
		} finally {
			LOGGER.debug("[TaifMgr::findInAnagraficaByCodiceFiscalePersona] END");
		}

	}

	public ArrayList<DettaglioStato> getElencoDettaglioStato(Integer idPratica, String lingua) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoDettaglioStato] BEGIN");
		try {
			return dbMgr.getElencoDettaglioStato(idPratica, lingua);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoDettaglioStato] END");
		}

	}

	public void salvaStato(Integer idPratica, DettaglioStato dto, Integer idConfigUtente) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoDettaglioStato] BEGIN");
		try {
			this.validationMgr.validateStato(dto);
			if (dto.getEsisteDB()) {
				this.dbMgr.salvaStato(idPratica, dto, idConfigUtente);
			} else {
				this.dbMgr.cambiaStato(idPratica, dto, idConfigUtente);
				// Invio mail per cambio stato
				this.inviaMailCambioStato(idPratica, ConvertUtil.convertToInteger(dto.getIdStatoDomanda()));
			}
		} finally {
			LOGGER.debug("[TaifMgr::getElencoDettaglioStato] END");
		}

	}

	public ArrayList<CodeDescription> getElencoUnitaMisuraQuintaliMc() throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoAssortimento] BEGIN");
		try {
			ArrayList<CodeDescription> listaUM = dbMgr
					.getUnitaMisuraQuintaliMc(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
			return listaUM;
		} finally {
			LOGGER.debug("[TaifMgr::getElencoAssortimento] END");
		}
	}

	public ArrayList<CodeDescription> getElencoStatiPratica(VisibileOrdinFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getElencoDettaglioStato] BEGIN");
		try {
			return this.dbMgr.getElencoStatiPratica(filter);
		} finally {
			LOGGER.debug("[TaifMgr::getElencoDettaglioStato] END");
		}
	}

	public String findCorsiPerPersonaFromView(Integer idPersona) throws ManagerException {
		LOGGER.debug("[TaifMgr::findCorsiPerPersonaFromView] BEGIN");
		try {
			String listaCorsi = dbMgr.findCorsiPerPersona(idPersona);
			return listaCorsi;
		} finally {
			LOGGER.debug("[TaifMgr::findCorsiPerPersonaFromView] END");
		}
	}

	public List<String> getListFlagSezionePerIdAzienda(int idAzienda) throws DbManagerException {
		LOGGER.debug("[TaifMgr::getListFlagSezionePerIdAzienda] BEGIN");
		List<String> listFlag = new ArrayList<String>();
		try {
			listFlag = dbMgr.getListFlagSezionePerIdAzienda(idAzienda);
			return listFlag;
		} finally {
			LOGGER.debug("[TaifMgr::getListFlagSezionePerIdAzienda] END");
		}
	}

	// @Transactional(rollbackFor = { RuntimeException.class, ManagerException.class
	// })
	public void inviaDomanda(Integer idPratica, String tracciatoData, Integer idConfigUtente) throws ManagerException {
		LOGGER.debug("[TaifMgr::inviaDomanda] BEGIN");
		try {

			// Dettaglio Pratica
			TaifTPraticaDettaglioPraticaPerInvioDto dto = this.dbMgr.getDettaglioPraticaPerInvio(idPratica);
			if (dto != null) {
				// 1. Generazione scheda
				ByteArrayOutputStream baos = this.schedaAzienda.makeSchedaAziendaPdf(dto.getAzIdAzienda(),
						tracciatoData);
				// 2. Upload su Index
				// this.serviziMgr.indexUploadFile(idPratica,
				// AllegatoFactory.createAllegato(dto), baos.toByteArray());
				this.uploadFile(idPratica, AllegatoFactory.createAllegato(dto, baos.size()), idConfigUtente,
						baos.toByteArray());
				// 3. Cambio di stato
				Integer statoSuccessivo = StatoDomandaEnum.getNextElement(dto.getSsFkStatoPratica());
				if (statoSuccessivo != null) {
					TaifTStoricoStatoByStatoPraticaDto stato = this.cambiaStato(idPratica, statoSuccessivo, idConfigUtente);
					// 4. Archiviazione e protoccolazione (SOLO PER PIEMONTE)
					if(dto.getSgIdSoggettoGestore()==it.csi.taif.taifweb.business.dao.util.Constants.GESTORE_PIEMONTE) {
						this.protocollaIstanza(dto, stato);
					}
					if(Constants.TRACCIATO_IT.equals(tracciatoData)) {
						// TODO Al momento solo per tracciato italiano
						// 5. Invio mail
						this.invioMailInvioDomanda(dto, statoSuccessivo);
					}
					
				}

			}

		} finally {
			LOGGER.debug("[TaifMgr::inviaDomanda] END");
		}
	}
	
	private void inviaMailCambioStato(Integer idPratica, Integer idStato)throws ManagerException{
		LOGGER.debug("[TaifMgr::inviaMailCambioStato] BEGIN");
		try {
			// Dettaglio Pratica
			TaifTPraticaDettaglioPraticaPerInvioDto dto = this.dbMgr.getDettaglioPraticaPerInvio(idPratica);
			this.invioMailInvioDomanda(dto, idStato);
		}
		finally {
			LOGGER.debug("[TaifMgr::inviaMailCambioStato] END");
		}
			
	}

	public void updateNumeroAccessi(int idConfigUtente) throws ManagerException {

		LOGGER.debug("[TaifMgr::findConfigUtenteByPrimaryKey] BEGIN");
		TaifCnfConfigUtenteDto configUtenteDto = new TaifCnfConfigUtenteDto();
		try {
			configUtenteDto = dbMgr.findConfigUtenteByPrimaryKey(idConfigUtente);
		} finally {
			LOGGER.debug("[TaifMgr::findConfigUtenteByPrimaryKey] END");
		}

	}

	public TaifTPersonaDto getRappLegaleFromAzienda(int idAzienda) throws ManagerException {
		LOGGER.debug("[DbMgr::getPersonaFromAziendaUtente] BEGIN");
		try {
			return dbMgr.getPersonaRappLegalePerAzienda(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getPersonaFromAziendaUtente] END");
		}
	}

	public Integer getPersonaFromCnfUtente(int idConfigUtente) throws ManagerException {
		LOGGER.debug("[DbMgr::getPersonaFromCnfUtente] BEGIN");
		try {
			return dbMgr.getPersonaFromCnfUtente(idConfigUtente);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getPersonaFromCnfUtente] END");
		}
	}

	private void invioMailInvioDomanda(TaifTPraticaDettaglioPraticaPerInvioDto dto, Integer statoSuccessivo)
			throws ManagerException {

		TaifCnfMailDto configMail = this.dbMgr.getParametriInvioMail();
		TaifCnfTipoMailDto mailDto = this.dbMgr.getMail(statoSuccessivo);

		this.serviziMgr.invioMail(DettaglioEmailFactory.createDettaglioEmail(configMail, mailDto, dto));

	}

	public List<TaifTLavoroPaByAziendaDto> getLavoroPa(LavoroPaFilter lavoroPaFilter) throws ManagerException {
		LOGGER.debug("[TaifMgr::findCommerciallizazioneByIdAzienda] BEGIN");
		try {
			return dbMgr.getLavoroPa(lavoroPaFilter);
		} finally {
			LOGGER.debug("[TaifMgr::findCommerciallizazioneByIdAzienda] END");
		}
	}

	public String getAttivitaAteco(int idTipoAttivita) throws DbManagerException {

		try {

			return dbMgr.getAttivitaAteco(idTipoAttivita);

		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public TaifTPraticaByIdAziendaDto pratichePerAzienda(Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::pratichePerAzienda] BEGIN");
		try {
			List<TaifTPraticaByIdAziendaDto> praticaPerAzienda = new ArrayList<TaifTPraticaByIdAziendaDto>();
			TaifTPraticaByIdAziendaDto praticaBase = new TaifTPraticaByIdAziendaDto();
			praticaPerAzienda = dbMgr.pratichePerAzienda(idAzienda);
			for (TaifTPraticaByIdAziendaDto taifTPraticaByIdAziendaDto : praticaPerAzienda) {
				if (taifTPraticaByIdAziendaDto.getIdSoggettoGestore() != 0) {
					praticaBase = taifTPraticaByIdAziendaDto;
				}
			}
			return praticaBase;

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getPersonaFromCnfUtente] END");
		}
	}

	public List<TaifTSedeAziendaByIdAziendaDto> getSedePerIdAzienda(int idAzienda) throws ManagerException {
		LOGGER.debug("[DbMgr::getSedePerIdAzienda] BEGIN");
		try {
			return dbMgr.getSedePerIdAzienda(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getSedePerIdAzienda] END");
		}
	}

	public String getStatoPratica(Integer idPratica) throws ManagerException {
		LOGGER.debug("[DbMgr::getStatoPratica] BEGIN");
		try {
			return dbMgr.getStatoPratica(idPratica);
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getStatoPratica] END");
		}
	}

	public TaifTSedeAziendaByIdAziendaDto getSedeLegalePerIdAzienda(int idAzienda) throws ManagerException {
		LOGGER.debug("[DbMgr::getSedePerIdAzienda] BEGIN");
		try {
			TaifTSedeAziendaByIdAziendaDto sedeLegale = new TaifTSedeAziendaByIdAziendaDto();
			List<TaifTSedeAziendaByIdAziendaDto> sedeAzienda = dbMgr.getSedePerIdAzienda(idAzienda);
			for (TaifTSedeAziendaByIdAziendaDto taifTSedeAziendaByIdAziendaDto : sedeAzienda) {
				if (taifTSedeAziendaByIdAziendaDto.getIdTipo() == 1) {
					sedeLegale = taifTSedeAziendaByIdAziendaDto;
				}
			}
			return sedeLegale;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getSedePerIdAzienda] END");
		}
	}

	public TaifTPersonaByIdAziendaDto getLegaleRappresentanteConduttore(int idAzienda, int idRuolo)
			throws DbManagerException {

		List<TaifTPersonaByIdAziendaDto> personePerAzienda = new ArrayList<TaifTPersonaByIdAziendaDto>();
		TaifTPersonaByIdAziendaDto legaleRapp = new TaifTPersonaByIdAziendaDto();
		try {
			personePerAzienda = dbMgr.getAllPersonePerIdAzienda(idAzienda);
			for (TaifTPersonaByIdAziendaDto taifTPersonaByIdAziendaDto : personePerAzienda) {
				if (taifTPersonaByIdAziendaDto.getIdRuoloPersona() == idRuolo) {
					legaleRapp = taifTPersonaByIdAziendaDto;
				}
			}
			return legaleRapp;
		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public TaifTPraticaByIdAziendaDto altrePratichePerAzienda(Integer idAzienda) throws ManagerException {
		LOGGER.debug("[TaifMgr::pratichePerAzienda] BEGIN");
		try {
			List<TaifTPraticaByIdAziendaDto> praticaPerAzienda = new ArrayList<TaifTPraticaByIdAziendaDto>();
			TaifTPraticaByIdAziendaDto praticaBase = new TaifTPraticaByIdAziendaDto();
			praticaPerAzienda = dbMgr.pratichePerAzienda(idAzienda);
			for (TaifTPraticaByIdAziendaDto taifTPraticaByIdAziendaDto : praticaPerAzienda) {
				if (taifTPraticaByIdAziendaDto.getIdSoggettoGestore() == 0) {
					praticaBase = taifTPraticaByIdAziendaDto;
				}
			}
			return praticaBase;

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
			LOGGER.debug("[DbMgr::getPersonaFromCnfUtente] END");
		}
	}

	public String findCorsiPerPersona(CorsoQualificaFilter corsoFilter) throws DbManagerException {
		LOGGER.debug("[TaifMgr::findCorsiPerPersona] BEGIN");
		try {
			String corsiList = dbMgr.findCorsiPerPersona(corsoFilter);
			return corsiList;
		} catch (Exception e) {
			throw new DbManagerException();
		} finally {
			LOGGER.debug("[DbMgr::findCorsiPerPersona] END");
		}

	}

	public Integer getMaxNumeroAlboForGestore(Integer idSoggettoGestore) throws ManagerException {
		LOGGER.debug("[TaifMgr::getMaxNumeroAlboForGestore] BEGIN");
		try {
			Integer maxAlbo = dbMgr.getMaxNumeroAlboForGestore(idSoggettoGestore);
			return maxAlbo;
		} catch (Exception e) {
			throw new DbManagerException();
		} finally {
			LOGGER.debug("[TaifMgr::getMaxNumeroAlboForGestore] END");
		}

	}

	public void testActa() throws ManagerException {
		TaifTPraticaDettaglioPraticaPerInvioDto pratica = this.getDbMgr().getDettaglioPraticaPerInvio(143);
		//this.protocollaIstanza(pratica);
	}
	
	public void protocollaIstanza(TaifTPraticaDettaglioPraticaPerInvioDto pratica, TaifTStoricoStatoByStatoPraticaDto stato) throws ManagerException{
		LOGGER.debug("[TaifMgr::protocollaIstanza] BEGIN");
		IdentificazioneRegistrazione registrazione = this.serviziMgr.actaArchiviaProtocolla(pratica);
		String dataProtocollo = registrazione.getDataUltimoAggiornamento().getValue();
		String numeroProtocollo = registrazione.getNumero();
		stato.setNumProtocollo(numeroProtocollo);
		stato.setDataProt(ConvertUtil.convertToSqlDate(dataProtocollo));
		this.inserisciProtocollo(stato);
		LOGGER.debug("[TaifMgr::protocollaIstanza] END");
	}
	
	
	private void inserisciProtocollo(TaifTStoricoStatoByStatoPraticaDto stato) throws ManagerException {
		LOGGER.debug("[TaifMgr::inserisciProtocollo] BEGIN");
		this.getDbMgr().inserisciProtocollo(stato);
		LOGGER.debug("[TaifMgr::inserisciProtocollo] END");
	}

	public ImportAziendaAAEP importAziendaFromAAEP(String codiceFiscaleAzienda)throws ManagerException{
		return this.serviziMgr.aaepImportAzienda(codiceFiscaleAzienda);
	}
	
	
	public Integer getCodiceAttivitaApe(String codiceAttivita) throws ManagerException {
	    LOGGER.debug("[TaifMgr::getCodiceAttivitaApe] BEGIN");
		try {
			Integer  idAttivitaApe = dbMgr.getCodiceAttivitaApe(codiceAttivita);
			return idAttivitaApe;
		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
		    LOGGER.debug("[TaifMgr::getCodiceAttivitaApe] END");
		}

	}
	
	public Integer getIdFormaGiuridica(FormaGiuridicaFilter filter) throws DbManagerException {
	    LOGGER.debug("[TaifMgr::getIdFormaGiuridica] BEGIN");
		try {

		       Integer idFormaGiuridica = dbMgr.getIdFormaGiuridica(filter);
		       return idFormaGiuridica;

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
		    LOGGER.debug("[TaifMgr::getIdFormaGiuridica] END");
		}
	}
	
	public boolean existeCodiceFiscaleAzienda(String codiceFiscaleAzienda) throws DbManagerException {
	    LOGGER.debug("[TaifMgr::existeCodiceFiscaleAzienda] BEGIN");
		try {
			return  dbMgr.existeCodiceFiscaleAzienda(codiceFiscaleAzienda);

		} catch (Exception e) {
			throw new DbManagerException(e, this.msgMgr.getMessage(MsgCodeEnum.G001));
		} finally {
		    LOGGER.debug("[TaifMgr::existeCodiceFiscaleAzienda] BEGIN");
		}
	}

	public ArrayList<CodeDescription> getRiconoscimentiPersona(CorsoQualificaFilter filter) throws ManagerException {
		LOGGER.debug("[TaifMgr::getRiconoscimentiPersona] BEGIN");
		try {
			return  CollectionUtils.parseEmptyList(dbMgr.getRiconoscimentiPersona(filter), "Nessun riconoscimento presente");

		} finally {
		    LOGGER.debug("[TaifMgr::getRiconoscimentiPersona] BEGIN");
		}
	}
	
	public TaifVApplSchedaOkRealeDto getInfoSchedeAzienda(Integer idAzienda) throws ManagerException{
		LOGGER.debug("[TaifMgr::getInfoSchedeAzienda] BEGIN");
		try {
			return this.dbMgr.getInfoSchedeAzienda(idAzienda);
			
		}  finally {
			LOGGER.debug("[TaifMgr::getInfoSchedeAzienda] END");
		}
		
	}


}
