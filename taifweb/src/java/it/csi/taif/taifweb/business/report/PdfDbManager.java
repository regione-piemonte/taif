/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDAlimentazioneDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoStrutturaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAttivDetMaterialeByIdAttivitaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaCategImpresaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaFrTipoContrFindByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaFrTipoMansFindByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRPersonaAziendaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaDettByAttivitaProgressivoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaDettByFilterAttivitaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCertificazioneFindCertificazioniByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTDpiDpiByAziendaVisibileDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTMezzoByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTStrutturaFindByAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.TaifDTipoAttivitaDaoException;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.SpecieFilter;
import it.csi.taif.taifweb.business.dao.util.Constants;
import it.csi.taif.taifweb.business.manager.db.DbMgr;
import it.csi.taif.taifweb.business.manager.message.MsgMgr;
import it.csi.taif.taifweb.business.manager.service.ServiceMgr;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.util.service.integration.svista.Comune;
import it.csi.taif.taifweb.util.service.integration.svista.Provincia;

public class PdfDbManager {

	private static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE + ".business.report");

	private ServiceMgr serviceMgr;
	private MsgMgr msgMgr;
	private DbMgr dbMgr;

	public TaifTPersonaDto getPersona(int idPersona) throws DbManagerException {
		TaifTPersonaDto titolareRapp = new TaifTPersonaDto();
		try {
			titolareRapp = dbMgr.getPersonaByIdPersona(idPersona);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return titolareRapp;
	}

	public String getTitoloStudio(int idTitolo) throws DbManagerException {
		String titoloStudio = Constants.blank;
		try {
			titoloStudio = dbMgr.getTitoloStudio(idTitolo);
		} catch (Exception e) {
			throw new DbManagerException();
		}

		return titoloStudio;
	}

	public Comune getComuneFromIstat(String istatComune) throws DbManagerException {
		try {
			return dbMgr.getComuneFromIstat(istatComune);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbManagerException();
		}

	}

	public Provincia getProvinciaFromIstat(String istatComune) throws DbManagerException {

		try {
			return dbMgr.getProvinciaFromIstat(istatComune);
		} catch (Exception e) {
			throw new DbManagerException();
		}
	}

	public String getFormaGiuridica(int idFormaGiuridica) throws DbManagerException {

		try {
			return dbMgr.getFormaGiuridica(idFormaGiuridica);
		} catch (Exception e) {
			throw new DbManagerException();
		}
	}

	public String getAttivitaSvolta(int idTipoAttivita) throws DbManagerException, TaifDTipoAttivitaDaoException {
		return dbMgr.findTipoAttivitaById(idTipoAttivita);
	}

	public String getAttivitaAteco(int idTipoAttivita) throws DbManagerException {

		try {

			return dbMgr.getAttivitaAteco(idTipoAttivita);

		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	// getAttivitaSvolte(idAzienda);
	public List<TaifTAttivitaSvoltaByIdAziendaDto> getAttivitaSvolte(int idAzienda) throws DbManagerException {
		List<TaifTAttivitaSvoltaByIdAziendaDto> attivitaSvolteList = new ArrayList<TaifTAttivitaSvoltaByIdAziendaDto>();
		try {
			attivitaSvolteList = dbMgr.getAttivitaSvolte(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return attivitaSvolteList;
	}

	// getAttivitaSvolteDettaglio
	public List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> getAttivitaSvolteDettaglio(int idAttivitaSvolta)
			throws DbManagerException {
		List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> attivitaSvolteDettaglioList = new ArrayList<TaifTAttivitaSvoltaDettByFilterAttivitaDto>();
		try {
			attivitaSvolteDettaglioList = dbMgr.getAttivitaSvolteDettaglio(idAttivitaSvolta);

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return attivitaSvolteDettaglioList;
	}

	// getMaterialeVivaistica

	public List<TaifRAttivDetMaterialeByIdAttivitaDto> getMaterialeVivaistica(int idAttivitaSvolta)
			throws DbManagerException {
		List<TaifRAttivDetMaterialeByIdAttivitaDto> attivitaSvolteDettaglioList = new ArrayList<TaifRAttivDetMaterialeByIdAttivitaDto>();
		try {
			attivitaSvolteDettaglioList = dbMgr.getMaterialeVivaistica(idAttivitaSvolta);

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return attivitaSvolteDettaglioList;
	}

	public String getUnitaMisura(int idUnitaMisura) throws DbManagerException {
		try {
			return dbMgr.getUnitaMisuraByIdUnita(idUnitaMisura);
		} catch (Exception e) {
			throw new DbManagerException();
		}
	}

	public String getMaterialePerId(int idUnitaMisura) throws DbManagerException {
		try {
			return dbMgr.getMaterialePerId(idUnitaMisura);
		} catch (Exception e) {
			throw new DbManagerException();
		}
	}

	public List<TaifTAttivitaSvoltaDettByAttivitaProgressivoDto> getAttivitaDettaglioMateriale(int idAttivitaSvolta)
			throws DbManagerException {
		List<TaifTAttivitaSvoltaDettByAttivitaProgressivoDto> attivitaDettaglioMaterialeList = new ArrayList<TaifTAttivitaSvoltaDettByAttivitaProgressivoDto>();
		try {
			attivitaDettaglioMaterialeList = dbMgr.getAttivitaDettaglioMateriale(idAttivitaSvolta);

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return attivitaDettaglioMaterialeList;
	}

	public String getSpecieCommercializzata(int idSpecie, String tracciatoData) throws DbManagerException {
		String specieNome = new String();
		SpecieFilter specieFilter = new SpecieFilter();
		specieFilter.setFlagItaFr(tracciatoData);
		specieFilter.setFlagVisibile(1);
		specieFilter.setIdSpecie(idSpecie);
		try {
			specieNome = dbMgr.findSpecieByIdSpecieVisible(specieFilter).get(0).getNomeSpecie();

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return specieNome;
	}

	public String getAssortimento(int idAssortimento) throws DbManagerException {
		String assortimento = new String();
		try {
			assortimento = dbMgr.getAssortimento(idAssortimento).getAssortimento();

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return assortimento;
	}

	public String getProvDestinazione(int idProvDest) throws DbManagerException {
		String provDestinazia = new String();
		try {
			provDestinazia = dbMgr.getProvDestinazia(idProvDest).getProvDestin();

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return provDestinazia;
	}

	public List<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto> getCategoriaImpresa(
			AziendaVisibleFilter filter) throws DbManagerException {
		List<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto> aziendaCategoriaImpresa = new ArrayList<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto>();
		try {
			aziendaCategoriaImpresa = dbMgr.findCategoriaImpresaByIdAzienda(filter);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return aziendaCategoriaImpresa;
	}

	// findAssociazioniByIdAzienda
	public List<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto> getFormeOrganizzative(
			AziendaVisibleFilter filter) throws DbManagerException {
		List<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto> aziendaAssociazioni = new ArrayList<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto>();
		try {
			aziendaAssociazioni = dbMgr.findAssociazioneByIdAzienda(filter);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return aziendaAssociazioni;
	}

	// findCertificazioniByIdAzienda
	public List<TaifTCertificazioneFindCertificazioniByIdAziendaDto> getCertificazioni(AziendaVisibleFilter filter)
			throws DbManagerException {
		List<TaifTCertificazioneFindCertificazioniByIdAziendaDto> aziendaAssociazioni = new ArrayList<TaifTCertificazioneFindCertificazioniByIdAziendaDto>();
		try {
			aziendaAssociazioni = dbMgr.findCertificazioniByIdAzienda(filter);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return aziendaAssociazioni;
	}

	public List<TaifRAziendaCategImpresaByIdAziendaDto> getCategoriaImpresaFromId(int idAzienda)
			throws DbManagerException {
		List<TaifRAziendaCategImpresaByIdAziendaDto> aziendaCategorie = new ArrayList<TaifRAziendaCategImpresaByIdAziendaDto>();
		try {
			aziendaCategorie = dbMgr.getCategoriaImpresaFromId(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return aziendaCategorie;
	}

	public String getDescrizioneCategoriaImpresa(int idCategoria) throws DbManagerException {
		String tipoCategoria = Constants.blank;
		try {
			tipoCategoria = dbMgr.getDescrizioneCategoriaImpresa(idCategoria);

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return tipoCategoria;
	}

	public String getDescrizioneAssociazioneImpresa(int idAssociazione) throws DbManagerException {
		String tipoCategoria = Constants.blank;
		try {
			tipoCategoria = dbMgr.getDescrizioneAssociazioneImpresa(idAssociazione);

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return tipoCategoria;
	}

	public List<TaifTStrutturaFindByAziendaDto> getStrutture(int idAzienda) throws DbManagerException {
		List<TaifTStrutturaFindByAziendaDto> aziendaAssociazioni = new ArrayList<TaifTStrutturaFindByAziendaDto>();
		try {
			aziendaAssociazioni = dbMgr.getStrutture(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return aziendaAssociazioni;
	}

	public String getFunzioneCapannone(int idFunzione) throws DbManagerException {
		try {
			return dbMgr.getFunzioneCapannone(idFunzione);
		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public List<TaifTPersonaByIdAziendaDto> getPersonePerAzienda(int idAzienda) throws DbManagerException {
		List<TaifTPersonaByIdAziendaDto> personeSenzaTitolare = new ArrayList<TaifTPersonaByIdAziendaDto>();
		try {
			personeSenzaTitolare = dbMgr.getPersonePerAzienda(idAzienda);

		} catch (Exception e) {
			throw new DbManagerException();
		}
		return personeSenzaTitolare;
	}

	public String getTipoContratto(int idTipoContratto) throws DbManagerException {
		try {
			return dbMgr.getTipoContratto(idTipoContratto);
		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public String getTipoInquadramento(int idTipoInquadramento) throws DbManagerException {
		try {
			return dbMgr.getTipoInquadramento(idTipoInquadramento);
		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public String getTipoMansione(int idTipoMansione) throws DbManagerException {
		try {
			return dbMgr.getTipoMansione(idTipoMansione);
		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public String getRuolo(int idTipoRuolo) throws DbManagerException {
		try {
			return dbMgr.getRuolo(idTipoRuolo);
		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public String getFlagTempoDett(int idFlag) {
		String flag = Constants.blank;
		if (idFlag == 1) {
			flag = "Indeterminato";
		} else if (idFlag == 0) {
			flag = "Determinato";
		}
		return flag;
	}

	// dbMgr
	public List<TaifTDpiDpiByAziendaVisibileDto> getDispositiviProtezione(AziendaVisibleFilter aziendaVisibile)
			throws DbManagerException {
		List<TaifTDpiDpiByAziendaVisibileDto> dispositiviList = new ArrayList<TaifTDpiDpiByAziendaVisibileDto>();
		try {
			dispositiviList = dbMgr.findDpiByAziendaVisibile(aziendaVisibile);
		} catch (Exception e) {
			throw new DbManagerException();
		}

		return dispositiviList;
	}

	public List<TaifTMezzoByIdAziendaDto> getMacchineMezzi(int idAzienda) throws DbManagerException {
		List<TaifTMezzoByIdAziendaDto> dispositiviList = new ArrayList<TaifTMezzoByIdAziendaDto>();
		try {
			dispositiviList = dbMgr.getMacchineMezzi(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return dispositiviList;
	}

	public String getTipoMezzoById(int idTipoMezzo) throws DbManagerException {
		try {
			return dbMgr.getTipoMezzoById(idTipoMezzo);
		} catch (Exception e) {
			throw new DbManagerException();
		}
	}

	public String getTipoCarelloById(int idTipoMezzo) throws DbManagerException {
		try {
			return dbMgr.findTipoCarrelloByIdCarello(idTipoMezzo).getTipoCarrello();
		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public String getTipoTrazione(int idTipoTrazione) throws DbManagerException {
		try {
			return dbMgr.findTipoTrazioneByIdTrazione(idTipoTrazione).getTrazione();
		} catch (Exception e) {
			throw new DbManagerException();
		}

	}

	public String getNoleggio(int idNoleggio) {
		String noleggio = Constants.blank;
		if (idNoleggio == 1) {
			noleggio = "SI";
		} else if (idNoleggio == 0) {
			noleggio = "NO";
		}
		return noleggio;
	}

	public String getTipoAllimentazioneMezzoById(Integer idTipoAlimentazione) throws DbManagerException {
		try {
			TaifDAlimentazioneDto tipoAlimentazione = new TaifDAlimentazioneDto();
			tipoAlimentazione = dbMgr.findTipoAllimentazioneMezzoById(idTipoAlimentazione);
			return tipoAlimentazione.getAlimentazione();
		} catch (Exception e) {
			throw new DbManagerException();
		}
	}

	public List<TaifRAziendaFrTipoContrFindByIdAziendaDto> getTipologieContrattoFrancese(int idAzienda)
			throws DbManagerException {
		List<TaifRAziendaFrTipoContrFindByIdAziendaDto> aziendaCategoriaFrancese = new ArrayList<TaifRAziendaFrTipoContrFindByIdAziendaDto>();
		try {
			aziendaCategoriaFrancese = dbMgr.getTipologieContrattoFrancese(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return aziendaCategoriaFrancese;
	}

	public List<TaifRAziendaFrTipoMansFindByIdAziendaDto> getMansioneFrancese(int idAzienda) throws DbManagerException {
		List<TaifRAziendaFrTipoMansFindByIdAziendaDto> aziendaMansioneFrancese = new ArrayList<TaifRAziendaFrTipoMansFindByIdAziendaDto>();
		try {
			aziendaMansioneFrancese = dbMgr.getMansioneFrancese(idAzienda);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return aziendaMansioneFrancese;
	}

	public String getMansioneById(Integer idTipoMansione) throws DbManagerException {
		try {
			String tipoMansione = dbMgr.getTipoMansione(idTipoMansione);
			return tipoMansione;
		} catch (Exception e) {
			throw new DbManagerException();
		}
	}

	public String getContrattoById(Integer idTipoContratto) throws DbManagerException {
		try {
			String tipoContratto = dbMgr.getTipoContratto(idTipoContratto);
			return tipoContratto;
		} catch (Exception e) {
			throw new DbManagerException();
		}
	}

	public String findCorsiPerPersona(int idPersona) throws DbManagerException {
		String corsoPersona = new String();
		try {
			corsoPersona = dbMgr.findCorsiPerPersona(idPersona);
		} catch (Exception e) {
			throw new DbManagerException();
		}
		return corsoPersona;
	}
	
	public String findQualifichePerPersona(int idPersona) throws DbManagerException{
		return dbMgr.findQualifichePerPersona(idPersona);
	}
	
	public String findRiconoscimentiPerPersona (int idPersona) throws DbManagerException{
		return dbMgr.findRiconoscimentiPerPersona(idPersona);
	}

	public String getTipoStruttureFromFunzioneStruttura(int idStruttura) throws DbManagerException {
		try {
			String tipoStruttura = dbMgr.getTipoStruttureFromFunzioneStruttura(idStruttura);
			return tipoStruttura;
		} catch (Exception e) {
			throw new DbManagerException();
		}
	}

	public int getPersoneLavoroDettPerIdAzienda(Integer idAzienda) throws ManagerException {
		logger.debug("[TaifMgr::getPersoneLavoroDettPerIdAzienda] BEGIN");
		int cont = 0;
		try {

			List<TaifRPersonaAziendaByIdAziendaDto> listPersonePerIdAzienda = dbMgr.getPersonePerIdAzienda(idAzienda);
			if (listPersonePerIdAzienda != null && !listPersonePerIdAzienda.isEmpty()) {
				for (TaifRPersonaAziendaByIdAziendaDto persona : listPersonePerIdAzienda) {
					if (persona.getFlInd() != null && persona.getFlInd().intValue() != 1) {
						cont++;
					}
				}
			}
		} finally {
			logger.debug("[TaifMgr::getPersoneLavoroDettPerIdAzienda] END");
		}
		return cont;
	}

	public ServiceMgr getServiceMgr() {
		return serviceMgr;
	}

	public void setServiceMgr(ServiceMgr serviceMgr) {
		this.serviceMgr = serviceMgr;
	}

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

}
