/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.domanda;

import java.util.*;

import it.csi.taif.taifweb.dto.*;
import it.csi.taif.taifweb.dto.domanda.*;
import it.csi.taif.taifweb.dto.common.*;
import it.csi.taif.taifweb.dto.gestore.*;
import it.csi.taif.taifweb.dto.allegato.*;
import it.csi.taif.taifweb.dto.allegatodownload.*;

import org.apache.log4j.*;
import it.csi.taif.taifweb.util.*;
import it.csi.taif.taifweb.business.*;

/*PROTECTED REGION ID(R-264282201) ENABLED START*/
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import org.springframework.beans.factory.annotation.Autowired;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaPk;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaByIdAziendaDto;

/*PROTECTED REGION END*/

public class CPBECpIstanzeTaglioPresentate {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [attivitaUltimoAnno1, scope:USER_SESSION]
	public static final String APPDATA_ATTIVITAULTIMOANNO1_CODE = "appDataattivitaUltimoAnno1";

	// ApplicationData: [gestioneAttivitaUltimoAnno, scope:USER_SESSION]
	public static final String APPDATA_GESTIONEATTIVITAULTIMOANNO_CODE = "appDatagestioneAttivitaUltimoAnno";

	// ApplicationData: [elencoUnitaMisura, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUNITAMISURA_CODE = "appDataelencoUnitaMisura";

	// ApplicationData: [elencoIstanzeTaglioPresentate, scope:USER_SESSION]
	public static final String APPDATA_ELENCOISTANZETAGLIOPRESENTATE_CODE = "appDataelencoIstanzeTaglioPresentate";

	// ApplicationData: [idUnitaMisuraTagliIntercalariInRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIINTERCALARIINREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTagliIntercalariInRegioneSelezionato";

	// ApplicationData: [idUnitaMisuraTaglioPioppetoInRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIOPIOPPETOINREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato";

	// ApplicationData: [idUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAMISURATAGLIDIUTILIZZAZIONEINREGIONESELEZIONATO_CODE = "appDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato";

	// ApplicationData: [elencoRisultatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCORISULTATIRICERCAACCESSOLIBERO_CODE = "appDataelencoRisultatiRicercaAccessoLibero";

	// ApplicationData: [idAzienda, scope:USER_SESSION]
	public static final String APPDATA_IDAZIENDA_CODE = "appDataidAzienda";

	// ApplicationData: [elencoRisultatiRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCORISULTATIRICERCAAZIENDAGESTORE_CODE = "appDataelencoRisultatiRicercaAziendaGestore";

	// ApplicationData: [codiceFiscale, scope:USER_SESSION]
	public static final String APPDATA_CODICEFISCALE_CODE = "appDatacodiceFiscale";

	// ApplicationData: [isVolumeAcquisitoFromPrimpaForSrv, scope:USER_SESSION]
	public static final String APPDATA_ISVOLUMEACQUISITOFROMPRIMPAFORSRV_CODE = "appDataisVolumeAcquisitoFromPrimpaForSrv";

	// ApplicationData: [volumiAcquisitiPrimpaForSrv, scope:USER_SESSION]
	public static final String APPDATA_VOLUMIACQUISITIPRIMPAFORSRV_CODE = "appDatavolumiAcquisitiPrimpaForSrv";

	// ApplicationData: [anagraficaAziendale, scope:USER_SESSION]
	public static final String APPDATA_ANAGRAFICAAZIENDALE_CODE = "appDataanagraficaAziendale";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpIstanzeTaglioPresentate";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo acquisizioneVolumiTaglio definito in un ExecCommand del
	 * ContentPanel cpIstanzeTaglioPresentate
	 */
	public ExecResults acquisizioneVolumiTaglio(

			it.csi.taif.taifweb.dto.domanda.CpIstanzeTaglioPresentateModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ACQUISIZIONEVOLUMITAGLIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ACQUISIZIONEVOLUMITAGLIO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R907984032) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.info("[CPBECpIstanzeTaglioPresentate :: acquisizioneVolumiTaglio]BEGIN");
			Integer sommaUtilizzazione = 0;
			Integer sommaPioppeti = 0;
			Integer sommaIntercalari = 0;
			String unitaUtilizzazione = "";
			String unitaPioppeti = "";
			String unitaIntercalari = "";

			//VT taif-15
			log.info("[CPBECpIstanzeTaglioPresentate :: acquisizioneVolumiTaglio]BEFORE checkUnitaMisuraDiverse");

			this.checkUnitaMisuraDiverse(theModel);
			log.info("[CPBECpIstanzeTaglioPresentate :: acquisizioneVolumiTaglio]AFTER checkUnitaMisuraDiverse");
			//VT fine taif-15
			for (IstanzaTaglioPresentata i : theModel.getAppDataelencoIstanzeTaglioPresentate()) {
				if (ConvertUtil.checkIsNullOrEmpty(i.getCategoriaIntervento())
						&& ConvertUtil.checkIsNullOrEmpty(i.getStimaMassaRetraibile())) {
					if (i.getCategoriaIntervento().equalsIgnoreCase(Constants.ISTANZA_TAGLI_UTILIZZAZIONE)) {
						log.info("[CPBECpIstanzeTaglioPresentate :: acquisizioneVolumiTaglio]i.getUnita()"
								+ i.getUnita());
						sommaUtilizzazione = sommaUtilizzazione + new Integer(i.getStimaMassaRetraibile());
						unitaUtilizzazione = ConvertUtil.getCodeUnitaMisura(i.getUnita());
					} else if (i.getCategoriaIntervento().equalsIgnoreCase(Constants.ISTANZA_TAGLI_PIOPPETI)) {
						sommaPioppeti = sommaPioppeti + new Integer(i.getStimaMassaRetraibile());
						unitaPioppeti = ConvertUtil.getCodeUnitaMisura(i.getUnita());
					} else if (i.getCategoriaIntervento().equalsIgnoreCase(Constants.ISTANZA_TAGLI_INTERCALARI)) {
						sommaIntercalari = sommaIntercalari + new Integer(i.getStimaMassaRetraibile());
						unitaIntercalari = ConvertUtil.getCodeUnitaMisura(i.getUnita());
					}
				}
			}
			AttivitaUltimoAnno1 att = new AttivitaUltimoAnno1();
			GestioneAttivitaUltimoAnno gest = new GestioneAttivitaUltimoAnno();
			Intervento inter = new Intervento();

			inter.setTotaleVolumiTagliDiUtilizzazione(sommaUtilizzazione + "");
			log.info(
					"[CPBECpIstanzeTaglioPresentate :: acquisizioneVolumiTaglio]inter.getTotaleVolumiTagliDiUtilizzazione()"
							+ inter.getTotaleVolumiTagliDiUtilizzazione());
			inter.setTotaleVolumiTaglioPioppeti(sommaPioppeti + "");
			inter.setTotaleVolumiTagliIntercalari(sommaIntercalari + "");

			if (ConvertUtil.checkIsNullOrEmpty(unitaIntercalari)) {
				inter.setIdUnitaMisuraTagliIntercalari(unitaIntercalari + "");
			}
			if (ConvertUtil.checkIsNullOrEmpty(unitaUtilizzazione)) {
				inter.setIdUnitaMisuraTagliDiUtilizzazione(unitaUtilizzazione + "");
			}
			if (ConvertUtil.checkIsNullOrEmpty(unitaPioppeti)) {
				inter.setIdUnitaMisuraTaglioPioppeti(unitaPioppeti + "");
			}

			theModel.setAppDatavolumiAcquisitiPrimpaForSrv(inter);
			// impostazione del result code 
			theModel.getSession().put("RIENTROISTANZETAGLIO", "RIENTROISTANZETAGLIO");
			theModel.setAppDataisVolumeAcquisitoFromPrimpaForSrv(true);
			result.setResultCode(ACQUISIZIONEVOLUMITAGLIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::acquisizioneVolumiTaglio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo tornaIndietro definito in un ExecCommand del
	 * ContentPanel cpIstanzeTaglioPresentate
	 */
	public ExecResults tornaIndietro(

			it.csi.taif.taifweb.dto.domanda.CpIstanzeTaglioPresentateModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TORNAINDIETRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String TORNAINDIETRO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1959070620) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getSession().put("RIENTROISTANZETAGLIO", "RIENTROISTANZETAGLIO");

			// impostazione del result code 
			result.setResultCode(TORNAINDIETRO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::tornaIndietro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaIstanzeTaglioPresentate definito in un ExecCommand del
	 * ContentPanel cpIstanzeTaglioPresentate
	 */
	public ExecResults caricaIstanzeTaglioPresentate(

			it.csi.taif.taifweb.dto.domanda.CpIstanzeTaglioPresentateModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAISTANZETAGLIOPRESENTATE_OUTCOME_CODE__LISTNOTEMPTY = //NOSONAR  Reason:EIAS
				"listNotEmpty"; //NOSONAR  Reason:EIAS
		final String CARICAISTANZETAGLIOPRESENTATE_OUTCOME_CODE__LISTEMPTY = //NOSONAR  Reason:EIAS
				"listEmpty"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R323820102) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceFiscale = getCfFromIdAzienda(theModel);

			//codiceFiscale = "07067160015";
			//annoCorrente = 2018;

			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			int annoPrecedente = currentYear - 1;
			TaifTPraticaByIdAziendaDto pratichePerAzienda = taifMgr.pratichePerAzienda(theModel.getAppDataidAzienda());
			String statoPraticaDto = taifMgr.getStatoPratica(pratichePerAzienda.getIdPratica());
			log.info("[caricaIstanzeTaglioPresentate]:: stato istanza" + statoPraticaDto);
			if (statoPraticaDto.equalsIgnoreCase(Constants.STATO_PER_MANCATA_CONFERMA_ITA)) {
				annoPrecedente = currentYear - 2;
			}
			int tipoComunicazione = 0;
			int stato = 0;
			ArrayList<IstanzaTaglioPresentata> list = this.taifMgr
					.cercaIstanzeForestaPerCodFiscaleTipoComunicazioneStatoAnno(codiceFiscale, tipoComunicazione, stato,
							annoPrecedente);
			theModel.setAppDataelencoIstanzeTaglioPresentate(list);
			// impostazione del result code 
			result.setResultCode(CARICAISTANZETAGLIOPRESENTATE_OUTCOME_CODE__LISTEMPTY);
			if (list.size() != 0) {
				result.setResultCode(CARICAISTANZETAGLIOPRESENTATE_OUTCOME_CODE__LISTNOTEMPTY);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaIstanzeTaglioPresentate] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblElencoIstanzeTaglioPresentate
	 */
	public static void resetClearStatus_widg_tblElencoIstanzeTaglioPresentate(java.util.Map session) {
		session.put("cpIstanzeTaglioPresentate_tblElencoIstanzeTaglioPresentate_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-956529945) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	@Autowired
	private TaifMgr taifMgr;

	public TaifMgr getTaifMgr() {
		return taifMgr;
	}

	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}

	private String getCfFromIdAzienda(CpIstanzeTaglioPresentateModel theModel) throws DbManagerException {
		String cf = "";
		int idAzienda = theModel.getAppDataidAzienda();
		TaifTAziendaDto aziendaBe = this.taifMgr.getAziendaById(idAzienda);
		cf = aziendaBe.getCodiceFiscale();
		//		Azienda az = new Azienda();
		//		if (theModel.getAppDataanagraficaAziendale() != null
		//				&& ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataanagraficaAziendale().getCodiceFiscale())) {
		//			log.info("[getCfFromIdAzienda]:: theModel.getAppDataanagraficaAziendale().getCodiceFiscale()) NOT NULL");
		//			return cf = theModel.getAppDataanagraficaAziendale().getCodiceFiscale();
		//		} else if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDatacodiceFiscale())) {
		//			log.info("[getCfFromIdAzienda]:: theModel.getAppDatacodiceFiscale() NOT NULL");
		//			return cf = theModel.getAppDataanagraficaAziendale().getCodiceFiscale();
		//		} else if (theModel.getAppDataelencoRisultatiRicercaAziendaGestore().size() != 0) {
		//			log.info("[getCfFromIdAzienda]:: theModel.getAppDataelencoRisultatiRicercaAziendaGestore().size() != 0");
		//
		//			for (Azienda ris : theModel.getAppDataelencoRisultatiRicercaAziendaGestore()) {
		//				if (ris.getIdAzienda() == theModel.getAppDataidAzienda()) {
		//					return ris.getCodiceFiscale();
		//				} ;
		//			}
		//		} else if (theModel.getAppDataelencoRisultatiRicercaAccessoLibero().size() != 0) {
		//			log.info("[getCfFromIdAzienda]:: theModel.getAppDataelencoRisultatiRicercaAccessoLibero().size() != 0");
		//
		//			for (Azienda ris : theModel.getAppDataelencoRisultatiRicercaAccessoLibero()) {
		//				if (ris.getIdAzienda() == theModel.getAppDataidAzienda()) {
		//					return ris.getCodiceFiscale();
		//				}
		//			}
		//		}

		return cf;
	}

	private void checkUnitaMisuraDiverse(CpIstanzeTaglioPresentateModel theModel) {
		log.info("[CPBECpIstanzeTaglioPresentate]:: checkUnitaMisuraDiverse BEGIN");

		ArrayList<IstanzaTaglioPresentata> elencoIstanzeTagliUtilizazione = new ArrayList<IstanzaTaglioPresentata>();
		ArrayList<IstanzaTaglioPresentata> elencoIstanzeTagliPioppeti = new ArrayList<IstanzaTaglioPresentata>();
		ArrayList<IstanzaTaglioPresentata> elencoIstanzeTagliIntercalari = new ArrayList<IstanzaTaglioPresentata>();

		for (IstanzaTaglioPresentata i : theModel.getAppDataelencoIstanzeTaglioPresentate()) {
			if (ConvertUtil.checkIsNullOrEmpty(i.getCategoriaIntervento())
					&& ConvertUtil.checkIsNullOrEmpty(i.getStimaMassaRetraibile())) {
				if (i.getCategoriaIntervento().equalsIgnoreCase(Constants.ISTANZA_TAGLI_UTILIZZAZIONE)) {
					elencoIstanzeTagliUtilizazione.add(i);
				} else if (i.getCategoriaIntervento().equalsIgnoreCase(Constants.ISTANZA_TAGLI_PIOPPETI)) {
					elencoIstanzeTagliPioppeti.add(i);
				} else if (i.getCategoriaIntervento().equalsIgnoreCase(Constants.ISTANZA_TAGLI_INTERCALARI)) {
					elencoIstanzeTagliIntercalari.add(i);
				}
			}
		}

		boolean check = false;
		if (elencoIstanzeTagliUtilizazione != null && !elencoIstanzeTagliUtilizazione.isEmpty()) {
			for (IstanzaTaglioPresentata i : elencoIstanzeTagliUtilizazione) {
				if (!(i.getUnita().equalsIgnoreCase(elencoIstanzeTagliUtilizazione.get(0).getUnita()))) {
					log.info("[CPBECpIstanzeTaglioPresentate]:: checkUnitaMisuraDiverse utilizzazione i.getUnita()"
							+ i.getUnita());
					log.info(
							"[CPBECpIstanzeTaglioPresentate]:: checkUnitaMisuraDiverse utilizzazione i.getStimaMassaRetraibile()"
									+ i.getStimaMassaRetraibile());
					check = true;
					break;
				}
			}
		}
		if (check) {
			this.convertiUnita(theModel, Constants.ISTANZA_TAGLI_UTILIZZAZIONE);
			check = false;
		}

		if (elencoIstanzeTagliPioppeti != null && !elencoIstanzeTagliPioppeti.isEmpty()) {
			for (IstanzaTaglioPresentata i : elencoIstanzeTagliPioppeti) {
				if (!(i.getUnita().equalsIgnoreCase(elencoIstanzeTagliPioppeti.get(0).getUnita()))) {
					log.info("[CPBECpIstanzeTaglioPresentate]:: checkUnitaMisuraDiverse pioppeti i.getUnita()"
							+ i.getUnita());
					log.info(
							"[CPBECpIstanzeTaglioPresentate]:: checkUnitaMisuraDiverse pioppeti i.getStimaMassaRetraibile()"
									+ i.getStimaMassaRetraibile());
					check = true;
					break;
				}
			}
		}
		if (check) {
			this.convertiUnita(theModel, Constants.ISTANZA_TAGLI_PIOPPETI);
			check = false;
		}

		if (elencoIstanzeTagliIntercalari != null && !elencoIstanzeTagliIntercalari.isEmpty()) {
			for (IstanzaTaglioPresentata i : elencoIstanzeTagliIntercalari) {
				if (!(i.getUnita().equalsIgnoreCase(elencoIstanzeTagliIntercalari.get(0).getUnita()))) {
					log.info("[CPBECpIstanzeTaglioPresentate]:: checkUnitaMisuraDiverse intercalari i.getUnita()"
							+ i.getUnita());
					log.info("[CPBECpIstanzeTaglioPresentate]:: checkUnitaMisuraDiverse intercalari i.getUnita()"
							+ i.getStimaMassaRetraibile());
					check = true;
					break;
				}
			}
		}
		if (check) {
			this.convertiUnita(theModel, Constants.ISTANZA_TAGLI_INTERCALARI);
			check = false;
		}

		log.info("[CPBECpIstanzeTaglioPresentate]:: checkUnitaMisuraDiverse END");

	}

	private void convertiUnita(CpIstanzeTaglioPresentateModel theModel, String tipoTaglio) {
		log.info("[CPBECpIstanzeTaglioPresentate]:: convertiUnita BEGIN");

		for (IstanzaTaglioPresentata i : theModel.getAppDataelencoIstanzeTaglioPresentate()) {
			if (ConvertUtil.checkIsNullOrEmpty(i.getCategoriaIntervento())
					&& ConvertUtil.checkIsNullOrEmpty(i.getStimaMassaRetraibile())) {
				log.info("[CPBECpIstanzeTaglioPresentate]:: convertiUnita i.getUnita()" + i.getUnita());
				log.info("[CPBECpIstanzeTaglioPresentate]:: convertiUnita i.getStimaMassaRetraibile()"
						+ i.getStimaMassaRetraibile());

				if (i.getUnita().equalsIgnoreCase(Constants.UNITA_MISURA_METRI_CUBI)
						&& i.getCategoriaIntervento().equalsIgnoreCase(tipoTaglio)) {
					i.setUnita(Constants.UNITA_MISURA_QUINTALI);
					int stimaMassaMetri = ConvertUtil.toInteger(i.getStimaMassaRetraibile());
					int stimaMassaQuintali = stimaMassaMetri * 8;
					i.setStimaMassaRetraibile(String.valueOf(stimaMassaQuintali));
					log.info("[CPBECpIstanzeTaglioPresentate]:: convertiUnita  i.getUnita() convertita" + i.getUnita());
					log.info("[CPBECpIstanzeTaglioPresentate]:: convertiUnita  i.getStimaMassaRetraibile() convertita"
							+ i.getStimaMassaRetraibile());

				}

				if (i.getUnita().equalsIgnoreCase(Constants.UNITA_MISURA_TONNELLATE)
						&& i.getCategoriaIntervento().equalsIgnoreCase(tipoTaglio)) {
					i.setUnita(Constants.UNITA_MISURA_QUINTALI);
					int stimaMassaTonnellate = ConvertUtil.toInteger(i.getStimaMassaRetraibile());
					int stimaMassaQuintali = stimaMassaTonnellate * 10;
					i.setStimaMassaRetraibile(String.valueOf(stimaMassaQuintali));
					log.info("[CPBECpIstanzeTaglioPresentate]:: convertiUnita  i.getUnita() convertita" + i.getUnita());
					log.info("[CPBECpIstanzeTaglioPresentate]:: convertiUnita  i.getStimaMassaRetraibile() convertita"
							+ i.getStimaMassaRetraibile());

				}
			}
		}

		log.info("[CPBECpIstanzeTaglioPresentate]:: convertiUnita END");

	}

	/*PROTECTED REGION END*/
}
