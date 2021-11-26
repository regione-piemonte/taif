/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business;

import java.util.*;

import it.csi.taif.topforweb.dto.*;

import org.apache.log4j.*;
import it.csi.taif.topforweb.util.*;

/*PROTECTED REGION ID(R-1534196706) ENABLED START*/
import java.util.Locale;
import it.csi.iride2.policy.entity.Identita;
import it.csi.taif.topforweb.dto.common.ProfiloUtenteTopFor;
import it.csi.taif.topforweb.dto.home.CpHomeModel;
import it.csi.taif.topforweb.exception.DbManagerException;
import it.csi.taif.topforweb.exception.ManagerException;
import it.csi.taif.topforweb.business.manager.TopForMgr;
import it.csi.taif.topforweb.business.SecurityHelper;

import it.csi.taif.topforweb.business.common.ProfiloEnum;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaProfiloUtenteByCodiceFiscaleDto;
import it.csi.taif.topforweb.business.dao.topfor.filter.ConfigProfiloFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.PersonaFilter;

import javax.servlet.jsp.jstl.core.Config;
/*import it.csi.taif.topforweb.business.manager.TaifMgr;
import it.csi.taif.topforweb.exception.ManagerException;*/

import com.opensymphony.xwork2.ActionContext;
/*PROTECTED REGION END*/

public class BackEndFacade {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [TreeStatus, scope:USER_SESSION]
	public static final String APPDATA_TREESTATUS_CODE = "appDataTreeStatus";

	// ApplicationData: [crumbs, scope:USER_SESSION]
	public static final String APPDATA_CRUMBS_CODE = "appDatacrumbs";

	// ApplicationData: [serviceUrl, scope:USER_SESSION]
	public static final String APPDATA_SERVICEURL_CODE = "appDataserviceUrl";

	// ApplicationData: [idAzienda, scope:USER_SESSION]
	public static final String APPDATA_IDAZIENDA_CODE = "appDataidAzienda";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [tipologia, scope:USER_SESSION]
	public static final String APPDATA_TIPOLOGIA_CODE = "appDatatipologia";

	// ApplicationData: [login, scope:USER_ACTION]
	public static final String APPDATA_LOGIN_CODE = "appDatalogin";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [msgError, scope:USER_ACTION]
	public static final String APPDATA_MSGERROR_CODE = "appDatamsgError";

	// ApplicationData: [tipoAccesso, scope:USER_SESSION]
	public static final String APPDATA_TIPOACCESSO_CODE = "appDatatipoAccesso";

	// ApplicationData: [primoIngresso, scope:USER_SESSION]
	public static final String APPDATA_PRIMOINGRESSO_CODE = "appDataprimoIngresso";

	// ApplicationData: [profiloUtente, scope:USER_SESSION]
	public static final String APPDATA_PROFILOUTENTE_CODE = "appDataprofiloUtente";

	// ApplicationData: [fromModifica, scope:USER_SESSION]
	public static final String APPDATA_FROMMODIFICA_CODE = "appDatafromModifica";

	// ApplicationData: [isNuovoInserimentoOperatore, scope:USER_SESSION]
	public static final String APPDATA_ISNUOVOINSERIMENTOOPERATORE_CODE = "appDataisNuovoInserimentoOperatore";

	// ApplicationData: [arrivoDaModifica, scope:USER_SESSION]
	public static final String APPDATA_ARRIVODAMODIFICA_CODE = "appDataarrivoDaModifica";

	// ApplicationData: [urlPrivacy, scope:USER_SESSION]
	public static final String APPDATA_URLPRIVACY_CODE = "appDataurlPrivacy";

	// ApplicationData: [idSezioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSEZIONESELEZIONATA_CODE = "appDataidSezioneSelezionata";

	// ApplicationData: [elencoAlbiRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBIRICERCAOPERATORE_CODE = "appDataelencoAlbiRicercaOperatore";

	// ApplicationData: [elencoAlbiSelezionatiRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBISELEZIONATIRICERCAOPERATORE_CODE = "appDataelencoAlbiSelezionatiRicercaOperatore";

	// ApplicationData: [elencoRisultatiRicercaOperatoreGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCORISULTATIRICERCAOPERATOREGESTORE_CODE = "appDataelencoRisultatiRicercaOperatoreGestore";

	// ApplicationData: [elencoComuniRicercaOperatoreGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRICERCAOPERATOREGESTORE_CODE = "appDataelencoComuniRicercaOperatoreGestore";

	// ApplicationData: [idComuneSelezionatoRicercaOperatoreGestore, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNESELEZIONATORICERCAOPERATOREGESTORE_CODE = "appDataidComuneSelezionatoRicercaOperatoreGestore";

	// ApplicationData: [numeroRisultatiRicercaOperatoreGestore, scope:USER_SESSION]
	public static final String APPDATA_NUMERORISULTATIRICERCAOPERATOREGESTORE_CODE = "appDatanumeroRisultatiRicercaOperatoreGestore";

	// ApplicationData: [numeroAlboOperatore, scope:USER_SESSION]
	public static final String APPDATA_NUMEROALBOOPERATORE_CODE = "appDatanumeroAlboOperatore";

	// ApplicationData: [cognomeRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_COGNOMERICERCAOPERATORE_CODE = "appDatacognomeRicercaOperatore";

	// ApplicationData: [dataPeriodoSvolgimentoDa, scope:USER_SESSION]
	public static final String APPDATA_DATAPERIODOSVOLGIMENTODA_CODE = "appDatadataPeriodoSvolgimentoDa";

	// ApplicationData: [dataPeriodoSvolgimentoA, scope:USER_SESSION]
	public static final String APPDATA_DATAPERIODOSVOLGIMENTOA_CODE = "appDatadataPeriodoSvolgimentoA";

	// ApplicationData: [elencoUnitaFormativaRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUNITAFORMATIVARICERCAOPERATORE_CODE = "appDataelencoUnitaFormativaRicercaOperatore";

	// ApplicationData: [idUnitaFormativaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAFORMATIVASELEZIONATA_CODE = "appDataidUnitaFormativaSelezionata";

	// ApplicationData: [elencoAgenziaFormativaRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAGENZIAFORMATIVARICERCAOPERATORE_CODE = "appDataelencoAgenziaFormativaRicercaOperatore";

	// ApplicationData: [idAgenziaFormativaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDAGENZIAFORMATIVASELEZIONATA_CODE = "appDataidAgenziaFormativaSelezionata";

	// ApplicationData: [elencoStatoOperatoreRicerca, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATOOPERATORERICERCA_CODE = "appDataelencoStatoOperatoreRicerca";

	// ApplicationData: [elencoStatoSchedaRicerca, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATOSCHEDARICERCA_CODE = "appDataelencoStatoSchedaRicerca";

	// ApplicationData: [isOperatoreConQualifica, scope:USER_SESSION]
	public static final String APPDATA_ISOPERATORECONQUALIFICA_CODE = "appDataisOperatoreConQualifica";

	// ApplicationData: [isIstruttoreOperatore, scope:USER_SESSION]
	public static final String APPDATA_ISISTRUTTOREOPERATORE_CODE = "appDataisIstruttoreOperatore";

	// ApplicationData: [idStatoSchedaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOSCHEDASELEZIONATO_CODE = "appDataidStatoSchedaSelezionato";

	// ApplicationData: [idStatoOperatoreSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOOPERATORESELEZIONATO_CODE = "appDataidStatoOperatoreSelezionato";

	// ApplicationData: [dettaglioOperatoreSelezionato, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOOPERATORESELEZIONATO_CODE = "appDatadettaglioOperatoreSelezionato";

	// ApplicationData: [elencoCorsiProfessionaliFinanziatiDaRegione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCORSIPROFESSIONALIFINANZIATIDAREGIONE_CODE = "appDataelencoCorsiProfessionaliFinanziatiDaRegione";

	// ApplicationData: [elencoAltriCorsi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALTRICORSI_CODE = "appDataelencoAltriCorsi";

	// ApplicationData: [elencoQualifiche, scope:USER_SESSION]
	public static final String APPDATA_ELENCOQUALIFICHE_CODE = "appDataelencoQualifiche";

	// ApplicationData: [elencoRiconoscimento, scope:USER_SESSION]
	public static final String APPDATA_ELENCORICONOSCIMENTO_CODE = "appDataelencoRiconoscimento";

	// ApplicationData: [elencoNazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCONAZIONI_CODE = "appDataelencoNazioni";

	// ApplicationData: [idComuneNascitaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNENASCITASELEZIONATO_CODE = "appDataidComuneNascitaSelezionato";

	// ApplicationData: [idComuneResidenzaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNERESIDENZASELEZIONATO_CODE = "appDataidComuneResidenzaSelezionato";

	// ApplicationData: [idNazioneNascitaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDNAZIONENASCITASELEZIONATA_CODE = "appDataidNazioneNascitaSelezionata";

	// ApplicationData: [elencoTitoloCorso, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTITOLOCORSO_CODE = "appDataelencoTitoloCorso";

	// ApplicationData: [idTitoloCorsoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDTITOLOCORSOSELEZIONATO_CODE = "appDataidTitoloCorsoSelezionato";

	// ApplicationData: [elencoSedeCorso, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEDECORSO_CODE = "appDataelencoSedeCorso";

	// ApplicationData: [idSedeCorsoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDSEDECORSOSELEZIONATO_CODE = "appDataidSedeCorsoSelezionato";

	// ApplicationData: [elencoPeriodoSvolgimentoCorso, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPERIODOSVOLGIMENTOCORSO_CODE = "appDataelencoPeriodoSvolgimentoCorso";

	// ApplicationData: [idPeriodoSvolgimentoCorsoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDPERIODOSVOLGIMENTOCORSOSELEZIONATO_CODE = "appDataidPeriodoSvolgimentoCorsoSelezionato";

	// ApplicationData: [numeroOreCorso, scope:USER_SESSION]
	public static final String APPDATA_NUMEROORECORSO_CODE = "appDatanumeroOreCorso";

	// ApplicationData: [elencoEsitoCorso, scope:USER_SESSION]
	public static final String APPDATA_ELENCOESITOCORSO_CODE = "appDataelencoEsitoCorso";

	// ApplicationData: [idEsitoCorsoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDESITOCORSOSELEZIONATO_CODE = "appDataidEsitoCorsoSelezionato";

	// ApplicationData: [elencoAttestatoConScadenzaInserimento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTESTATOCONSCADENZAINSERIMENTO_CODE = "appDataelencoAttestatoConScadenzaInserimento";

	// ApplicationData: [idAttestatoConScadenzaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDATTESTATOCONSCADENZASELEZIONATO_CODE = "appDataidAttestatoConScadenzaSelezionato";

	// ApplicationData: [idQualificaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDQUALIFICASELEZIONATO_CODE = "appDataidQualificaSelezionato";

	// ApplicationData: [idAgenziaFormativaQualificaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDAGENZIAFORMATIVAQUALIFICASELEZIONATA_CODE = "appDataidAgenziaFormativaQualificaSelezionata";

	// ApplicationData: [datiOperatore, scope:USER_SESSION]
	public static final String APPDATA_DATIOPERATORE_CODE = "appDatadatiOperatore";

	// ApplicationData: [elencoCorsiFinanziatiFromUnitaFormativa, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCORSIFINANZIATIFROMUNITAFORMATIVA_CODE = "appDataelencoCorsiFinanziatiFromUnitaFormativa";

	// ApplicationData: [corsoSelezionatoInserimento, scope:USER_SESSION]
	public static final String APPDATA_CORSOSELEZIONATOINSERIMENTO_CODE = "appDatacorsoSelezionatoInserimento";

	// ApplicationData: [altroCorsoSelezionatoInserimento, scope:USER_SESSION]
	public static final String APPDATA_ALTROCORSOSELEZIONATOINSERIMENTO_CODE = "appDataaltroCorsoSelezionatoInserimento";

	// ApplicationData: [qualificaSelezionataInserimento, scope:USER_SESSION]
	public static final String APPDATA_QUALIFICASELEZIONATAINSERIMENTO_CODE = "appDataqualificaSelezionataInserimento";

	// ApplicationData: [riconoscimentoSelezionatoInserimento, scope:USER_SESSION]
	public static final String APPDATA_RICONOSCIMENTOSELEZIONATOINSERIMENTO_CODE = "appDatariconoscimentoSelezionatoInserimento";

	// ApplicationData: [elencoUnitaFormativaRiconoscimento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUNITAFORMATIVARICONOSCIMENTO_CODE = "appDataelencoUnitaFormativaRiconoscimento";

	// ApplicationData: [idAgenziaFormativaRiconoscimentoSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDAGENZIAFORMATIVARICONOSCIMENTOSELEZIONATA_CODE = "appDataidAgenziaFormativaRiconoscimentoSelezionata";

	// ApplicationData: [idUnitaFormativaRiconoscimentoSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAFORMATIVARICONOSCIMENTOSELEZIONATA_CODE = "appDataidUnitaFormativaRiconoscimentoSelezionata";

	// ApplicationData: [elencoAltriCorsiDenominazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALTRICORSIDENOMINAZIONI_CODE = "appDataelencoAltriCorsiDenominazioni";

	// ApplicationData: [elencoQualificheDenominazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOQUALIFICHEDENOMINAZIONI_CODE = "appDataelencoQualificheDenominazioni";

	// ApplicationData: [idStatoSchedaSelezionatoRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOSCHEDASELEZIONATORICERCAOPERATORE_CODE = "appDataidStatoSchedaSelezionatoRicercaOperatore";

	// ApplicationData: [tipoProcedura, scope:USER_SESSION]
	public static final String APPDATA_TIPOPROCEDURA_CODE = "appDatatipoProcedura";

	// ApplicationData: [datiOperatoreFromDB, scope:USER_SESSION]
	public static final String APPDATA_DATIOPERATOREFROMDB_CODE = "appDatadatiOperatoreFromDB";

	// ApplicationData: [motivazioneRifiutoValidazione, scope:USER_SESSION]
	public static final String APPDATA_MOTIVAZIONERIFIUTOVALIDAZIONE_CODE = "appDatamotivazioneRifiutoValidazione";

	// ApplicationData: [elencoUnitaFormativaCorsiFinanziati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUNITAFORMATIVACORSIFINANZIATI_CODE = "appDataelencoUnitaFormativaCorsiFinanziati";

	// ApplicationData: [privacy, scope:USER_SESSION]
	public static final String APPDATA_PRIVACY_CODE = "appDataprivacy";

	// ApplicationData: [consensoPubblicazione, scope:USER_SESSION]
	public static final String APPDATA_CONSENSOPUBBLICAZIONE_CODE = "appDataconsensoPubblicazione";

	// ApplicationData: [elencoAmbitoFormativoRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAMBITOFORMATIVORICERCAOPERATORE_CODE = "appDataelencoAmbitoFormativoRicercaOperatore";

	// ApplicationData: [idAmbitoFormativoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDAMBITOFORMATIVOSELEZIONATO_CODE = "appDataidAmbitoFormativoSelezionato";

	// ApplicationData: [elencoProvinceRicercaOperatoreGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCERICERCAOPERATOREGESTORE_CODE = "appDataelencoProvinceRicercaOperatoreGestore";

	// ApplicationData: [idProvinciaSelezionatoRicercaOperatoreGestore, scope:USER_SESSION]
	public static final String APPDATA_IDPROVINCIASELEZIONATORICERCAOPERATOREGESTORE_CODE = "appDataidProvinciaSelezionatoRicercaOperatoreGestore";

	// ApplicationData: [ricercaLibera, scope:USER_SESSION]
	public static final String APPDATA_RICERCALIBERA_CODE = "appDataricercaLibera";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	/// - i metodi relativi a menu e azioni di inizializzazione sono direttamente 
	///   implementati in questa classe
	/// - i metodi relativi ai singoli content panel sono delegati nei rispettivi
	///   bean
	//////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo resetDatiOperatore utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults resetDatiOperatore(

			it.csi.taif.topforweb.dto.home.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().resetDatiOperatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults executeInit(

			it.csi.taif.topforweb.dto.home.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeRefresh utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults executeRefresh(

			it.csi.taif.topforweb.dto.home.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().executeRefresh(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeLogin utilizzato in un ExecCommand
	 * del ContentPanel cpLogin
	 */
	public ExecResults executeLogin(

			it.csi.taif.topforweb.dto.home.CpLoginModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpLogin
		return getCPBECpLogin().executeLogin(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel cpLogin
	 */
	public ExecResults executeInit(

			it.csi.taif.topforweb.dto.home.CpLoginModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpLogin
		return getCPBECpLogin().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo goToHome utilizzato in un ExecCommand
	 * del ContentPanel cpError
	 */
	public ExecResults goToHome(

			it.csi.taif.topforweb.dto.common.CpErrorModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpError
		return getCPBECpError().goToHome(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadUnitaFormative utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaOperatoreForestaleGestore
	 */
	public ExecResults loadUnitaFormative(

			it.csi.taif.topforweb.dto.gestore.CpRicercaOperatoreForestaleGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaOperatoreForestaleGestore
		return getCPBECpRicercaOperatoreForestaleGestore().loadUnitaFormative(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadComuni utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaOperatoreForestaleGestore
	 */
	public ExecResults loadComuni(

			it.csi.taif.topforweb.dto.gestore.CpRicercaOperatoreForestaleGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaOperatoreForestaleGestore
		return getCPBECpRicercaOperatoreForestaleGestore().loadComuni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo goBack utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaOperatoreForestaleGestore
	 */
	public ExecResults goBack(

			it.csi.taif.topforweb.dto.gestore.CpRicercaOperatoreForestaleGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaOperatoreForestaleGestore
		return getCPBECpRicercaOperatoreForestaleGestore().goBack(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaOperatore utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaOperatoreForestaleGestore
	 */
	public ExecResults ricercaOperatore(

			it.csi.taif.topforweb.dto.gestore.CpRicercaOperatoreForestaleGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaOperatoreForestaleGestore
		return getCPBECpRicercaOperatoreForestaleGestore().ricercaOperatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaOperatoreForestaleGestore
	 */
	public ExecResults executeInit(

			it.csi.taif.topforweb.dto.gestore.CpRicercaOperatoreForestaleGestoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaOperatoreForestaleGestore
		return getCPBECpRicercaOperatoreForestaleGestore().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoOperatori utilizzato in un ExecCommand
	 * del ContentPanel cpElencoOperatori
	 */
	public ExecResults onClickTabellaElencoOperatori(

			it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoOperatori
		return getCPBECpElencoOperatori().onClickTabellaElencoOperatori(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo indietroRicerca utilizzato in un ExecCommand
	 * del ContentPanel cpElencoOperatori
	 */
	public ExecResults indietroRicerca(

			it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoOperatori
		return getCPBECpElencoOperatori().indietroRicerca(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo exportRicercaOperatori utilizzato in un ExecCommand
	 * del ContentPanel cpElencoOperatori
	 */
	public ExecResults exportRicercaOperatori(

			it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoOperatori
		return getCPBECpElencoOperatori().exportRicercaOperatori(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo nuovaRicerca utilizzato in un ExecCommand
	 * del ContentPanel cpElencoOperatori
	 */
	public ExecResults nuovaRicerca(

			it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoOperatori
		return getCPBECpElencoOperatori().nuovaRicerca(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo exportRicercaLibera utilizzato in un ExecCommand
	 * del ContentPanel cpElencoOperatori
	 */
	public ExecResults exportRicercaLibera(

			it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoOperatori
		return getCPBECpElencoOperatori().exportRicercaLibera(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaOperatore utilizzato in un ExecCommand
	 * del ContentPanel cpElencoOperatori
	 */
	public ExecResults eliminaOperatore(

			it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpElencoOperatori
		return getCPBECpElencoOperatori().eliminaOperatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoCorsiFinanziatiRegione utilizzato in un ExecCommand
	 * del ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults onClickTabellaElencoCorsiFinanziatiRegione(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpOperatoreDettaglio
		return getCPBECpOperatoreDettaglio().onClickTabellaElencoCorsiFinanziatiRegione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onTableClickAltriCorsi utilizzato in un ExecCommand
	 * del ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults onTableClickAltriCorsi(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpOperatoreDettaglio
		return getCPBECpOperatoreDettaglio().onTableClickAltriCorsi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo modificaOperatore utilizzato in un ExecCommand
	 * del ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults modificaOperatore(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpOperatoreDettaglio
		return getCPBECpOperatoreDettaglio().modificaOperatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaOperatore utilizzato in un ExecCommand
	 * del ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults eliminaOperatore(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpOperatoreDettaglio
		return getCPBECpOperatoreDettaglio().eliminaOperatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo indietroDettaglioOperatore utilizzato in un ExecCommand
	 * del ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults indietroDettaglioOperatore(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpOperatoreDettaglio
		return getCPBECpOperatoreDettaglio().indietroDettaglioOperatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo nuovaRicerca utilizzato in un ExecCommand
	 * del ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults nuovaRicerca(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpOperatoreDettaglio
		return getCPBECpOperatoreDettaglio().nuovaRicerca(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaAttestato utilizzato in un ExecCommand
	 * del ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults eliminaAttestato(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpOperatoreDettaglio
		return getCPBECpOperatoreDettaglio().eliminaAttestato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults executeInit(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpOperatoreDettaglio
		return getCPBECpOperatoreDettaglio().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeRefresh utilizzato in un ExecCommand
	 * del ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults executeRefresh(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpOperatoreDettaglio
		return getCPBECpOperatoreDettaglio().executeRefresh(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeSwitchWizardOperatore utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults executeSwitchWizardOperatore(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().executeSwitchWizardOperatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaOperatoreInAnagraficaIt utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults ricercaOperatoreInAnagraficaIt(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().ricercaOperatoreInAnagraficaIt(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaOperatoreInAnagraficaFr utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults ricercaOperatoreInAnagraficaFr(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().ricercaOperatoreInAnagraficaFr(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onChangeStatoNascita utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeStatoNascita(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().onChangeStatoNascita(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadSoggettoGestoreFromIstat utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults loadSoggettoGestoreFromIstat(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().loadSoggettoGestoreFromIstat(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onChangeStatoScheda utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeStatoScheda(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().onChangeStatoScheda(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onChangeAgenziaFormativa utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeAgenziaFormativa(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().onChangeAgenziaFormativa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onChangeUnitaFormativa utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeUnitaFormativa(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().onChangeUnitaFormativa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onChangeTitoloCorso utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeTitoloCorso(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().onChangeTitoloCorso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addCorsoFinanziatoRegione utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults addCorsoFinanziatoRegione(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().addCorsoFinanziatoRegione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoCorsiFinanziatiRegione utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onClickTabellaElencoCorsiFinanziatiRegione(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().onClickTabellaElencoCorsiFinanziatiRegione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaCorsoFinanziatoRegione utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults eliminaCorsoFinanziatoRegione(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().eliminaCorsoFinanziatoRegione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onChangeTitoloAltroCorso utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeTitoloAltroCorso(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().onChangeTitoloAltroCorso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addAltroCorso utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults addAltroCorso(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().addAltroCorso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoAltriCorsi utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onClickTabellaElencoAltriCorsi(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().onClickTabellaElencoAltriCorsi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaAltroCorso utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults eliminaAltroCorso(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().eliminaAltroCorso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addQualifica utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults addQualifica(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().addQualifica(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaElencoQualifica utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onClickTabellaElencoQualifica(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().onClickTabellaElencoQualifica(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaQualifica utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults eliminaQualifica(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().eliminaQualifica(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onChangeAgenziaFormativaRiconoscimento utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeAgenziaFormativaRiconoscimento(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().onChangeAgenziaFormativaRiconoscimento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onChangeUnitaFormativaRiconoscimento utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeUnitaFormativaRiconoscimento(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().onChangeUnitaFormativaRiconoscimento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo addRiconoscimento utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults addRiconoscimento(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().addRiconoscimento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo onClickTabellaRiconoscimenti utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onClickTabellaRiconoscimenti(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().onClickTabellaRiconoscimenti(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaRiconoscimento utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults eliminaRiconoscimento(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().eliminaRiconoscimento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo goBackElencoOperatore utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults goBackElencoOperatore(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().goBackElencoOperatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo goBack utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults goBack(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().goBack(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaInBozza utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults salvaInBozza(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().salvaInBozza(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaProsegui utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults salvaProsegui(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().salvaProsegui(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo executeInit utilizzato in un ExecCommand
	 * del ContentPanel cpInserimentoOperatore
	 */
	public ExecResults executeInit(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpInserimentoOperatore
		return getCPBECpInserimentoOperatore().executeInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo identificaProfilo definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults identificaProfilo(

			it.csi.taif.topforweb.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String IDENTIFICAPROFILO_OUTCOME_CODE__OK_LIBERO_IT = //NOSONAR  Reason:EIAS
				"OK_LIBERO_IT"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__OK_LIBERO_FR = //NOSONAR  Reason:EIAS
				"OK_LIBERO_FR"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__OK_GESTORE_IT = //NOSONAR  Reason:EIAS
				"OK_GESTORE_IT"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__OK_GESTORE_FR = //NOSONAR  Reason:EIAS
				"OK_GESTORE_FR"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__OK_OPERATORE_IT = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_IT"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__OK_OPERATORE_FR = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_FR"; //NOSONAR  Reason:EIAS
		final String IDENTIFICAPROFILO_OUTCOME_CODE__INITKO = //NOSONAR  Reason:EIAS
				"initKO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1532503971) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			SecurityHelper sh = new SecurityHelper();
			log.debug("TIPO ACCESSO: *" + theModel.getTipoAccesso());
			String accesso = theModel.getTipoAccesso();
			if (theModel.getAppDatacurrentUser() == null) {
				theModel.setAppDatacurrentUser(new it.csi.taif.topforweb.dto.common.UserInfo());
			}
			ProfiloEnum profiloEnum = ProfiloEnum.getByProfilo(accesso);
			ActionContext.getContext().getSession().put("tipoAccesso", theModel.getTipoAccesso());
			ProfiloUtenteTopFor profiloUtenteTopFor = new ProfiloUtenteTopFor();
			String code = Constants.EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_IT;
			Locale locale = null;
			switch (profiloEnum) {
				case OPERATORE_IT :
					log.debug("Entro OPERATORE_IT");
					//code = this.identificaOperatore(theModel, Constants.EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_IT);
					code = IDENTIFICAPROFILO_OUTCOME_CODE__OK_OPERATORE_IT;
					profiloUtenteTopFor.setIdProfilo(it.csi.taif.topforweb.business.dao.util.Constants.one);
					theModel.getAppDatacurrentUser().setTipoAccesso(accesso);
					theModel.getAppDatacurrentUser().setProfiloUtenteTopFor(profiloUtenteTopFor);
					theModel.getAppDatacurrentUser().setLingua(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
					theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
					//String tipoAccesso = theModel.getAppDatacurrentUser().getTipoAccesso();
					makeProfiloOperatore(theModel, result);
					locale = Locale.ITALY;
					break;
				case OPERATORE_FR :
					log.debug("Entro OPERATORE_FR");
					//code = this.identificaOperatore(theModel, Constants.EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_FR);
					code = IDENTIFICAPROFILO_OUTCOME_CODE__OK_OPERATORE_FR;
					theModel.getAppDatacurrentUser().setTipoAccesso(accesso);
					profiloUtenteTopFor.setIdProfilo(it.csi.taif.topforweb.business.dao.util.Constants.two);
					theModel.getAppDatacurrentUser().setLingua(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
					theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
					theModel.getAppDatacurrentUser().setProfiloUtenteTopFor(profiloUtenteTopFor);
					locale = Locale.FRANCE;
					break;
				case GESTORE_IT :
					log.debug("Entro GESTORE_IT");
					code = this.identificaGestore(theModel, Constants.EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_IT);
					if (!IDENTIFICAPROFILO_OUTCOME_CODE__INITKO.equalsIgnoreCase(code)) {
						theModel.getAppDatacurrentUser().setTipoAccesso(accesso);
						theModel.getAppDatacurrentUser().getProfiloUtenteTopFor()
								.setIdProfilo(it.csi.taif.topforweb.business.dao.util.Constants.three);
						theModel.getAppDatacurrentUser()
								.setLingua(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
						theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
						locale = Locale.ITALY;
					}
					break;
				case GESTORE_FR :
					log.debug("Entro GESTORE_FR");
					code = IDENTIFICAPROFILO_OUTCOME_CODE__OK_GESTORE_FR;
					theModel.getAppDatacurrentUser().setTipoAccesso(accesso);
					theModel.getAppDatacurrentUser().setLingua(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
					theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
					//theModel.getAppDatacurrentUser().setProfiloUtenteTopFor(profiloUtenteTopFor);
					locale = Locale.FRANCE;
					break;
				case LIBERO_IT :
					log.debug("Entro LIBERO_IT");
					code = Constants.EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_IT;
					profiloUtenteTopFor.setIdProfilo(it.csi.taif.topforweb.business.dao.util.Constants.five);
					theModel.getAppDatacurrentUser().setTipoAccesso(accesso);
					theModel.getAppDatacurrentUser().setLingua(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
					theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
					theModel.getAppDatacurrentUser().setProfiloUtenteTopFor(profiloUtenteTopFor);
					locale = Locale.ITALY;
					break;
				case LIBERO_FR :
					log.debug("Entro LIBERO_FR");
					code = Constants.EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_FR;
					profiloUtenteTopFor.setIdProfilo(it.csi.taif.topforweb.business.dao.util.Constants.six);
					theModel.getAppDatacurrentUser().setTipoAccesso(accesso);
					theModel.getAppDatacurrentUser().setLingua(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
					theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
					theModel.getAppDatacurrentUser().setProfiloUtenteTopFor(profiloUtenteTopFor);
					locale = Locale.FRANCE;
					break;
			}
			log.debug("CODE = *" + code + "*");
			theModel.getSession().put(Config.FMT_LOCALE, locale);
			theModel.setAppDataprofiloUtente(code);
			result.setResultCode(code);
			result.setModel(theModel);
			return result;

			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::identificaProfilo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property relative ai bean spring associati agli specifici content panel
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	private it.csi.taif.topforweb.business.home.CPBECpHome cPBECpHome = null;

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	public void setCPBECpHome(it.csi.taif.topforweb.business.home.CPBECpHome bean) {
		this.cPBECpHome = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	public it.csi.taif.topforweb.business.home.CPBECpHome getCPBECpHome() {
		return this.cPBECpHome;
	}

	/**
	 * riferimento al CPBE del content panel cpLogin
	 */
	private it.csi.taif.topforweb.business.home.CPBECpLogin cPBECpLogin = null;

	/**
	 * riferimento al CPBE del content panel cpLogin
	 */
	public void setCPBECpLogin(it.csi.taif.topforweb.business.home.CPBECpLogin bean) {
		this.cPBECpLogin = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpLogin
	 */
	public it.csi.taif.topforweb.business.home.CPBECpLogin getCPBECpLogin() {
		return this.cPBECpLogin;
	}

	/**
	 * riferimento al CPBE del content panel cpError
	 */
	private it.csi.taif.topforweb.business.common.CPBECpError cPBECpError = null;

	/**
	 * riferimento al CPBE del content panel cpError
	 */
	public void setCPBECpError(it.csi.taif.topforweb.business.common.CPBECpError bean) {
		this.cPBECpError = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpError
	 */
	public it.csi.taif.topforweb.business.common.CPBECpError getCPBECpError() {
		return this.cPBECpError;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaOperatoreForestaleGestore
	 */
	private it.csi.taif.topforweb.business.gestore.CPBECpRicercaOperatoreForestaleGestore cPBECpRicercaOperatoreForestaleGestore = null;

	/**
	 * riferimento al CPBE del content panel cpRicercaOperatoreForestaleGestore
	 */
	public void setCPBECpRicercaOperatoreForestaleGestore(
			it.csi.taif.topforweb.business.gestore.CPBECpRicercaOperatoreForestaleGestore bean) {
		this.cPBECpRicercaOperatoreForestaleGestore = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaOperatoreForestaleGestore
	 */
	public it.csi.taif.topforweb.business.gestore.CPBECpRicercaOperatoreForestaleGestore getCPBECpRicercaOperatoreForestaleGestore() {
		return this.cPBECpRicercaOperatoreForestaleGestore;
	}

	/**
	 * riferimento al CPBE del content panel cpElencoOperatori
	 */
	private it.csi.taif.topforweb.business.gestore.CPBECpElencoOperatori cPBECpElencoOperatori = null;

	/**
	 * riferimento al CPBE del content panel cpElencoOperatori
	 */
	public void setCPBECpElencoOperatori(it.csi.taif.topforweb.business.gestore.CPBECpElencoOperatori bean) {
		this.cPBECpElencoOperatori = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpElencoOperatori
	 */
	public it.csi.taif.topforweb.business.gestore.CPBECpElencoOperatori getCPBECpElencoOperatori() {
		return this.cPBECpElencoOperatori;
	}

	/**
	 * riferimento al CPBE del content panel cpOperatoreDettaglio
	 */
	private it.csi.taif.topforweb.business.gestore.CPBECpOperatoreDettaglio cPBECpOperatoreDettaglio = null;

	/**
	 * riferimento al CPBE del content panel cpOperatoreDettaglio
	 */
	public void setCPBECpOperatoreDettaglio(it.csi.taif.topforweb.business.gestore.CPBECpOperatoreDettaglio bean) {
		this.cPBECpOperatoreDettaglio = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpOperatoreDettaglio
	 */
	public it.csi.taif.topforweb.business.gestore.CPBECpOperatoreDettaglio getCPBECpOperatoreDettaglio() {
		return this.cPBECpOperatoreDettaglio;
	}

	/**
	 * riferimento al CPBE del content panel cpInserimentoOperatore
	 */
	private it.csi.taif.topforweb.business.gestore.CPBECpInserimentoOperatore cPBECpInserimentoOperatore = null;

	/**
	 * riferimento al CPBE del content panel cpInserimentoOperatore
	 */
	public void setCPBECpInserimentoOperatore(it.csi.taif.topforweb.business.gestore.CPBECpInserimentoOperatore bean) {
		this.cPBECpInserimentoOperatore = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpInserimentoOperatore
	 */
	public it.csi.taif.topforweb.business.gestore.CPBECpInserimentoOperatore getCPBECpInserimentoOperatore() {
		return this.cPBECpInserimentoOperatore;
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1264235389) ENABLED START*/
	private TopForMgr topForMgr;

	public TopForMgr getTopForMgr() {
		return topForMgr;
	}

	public void setTopForMgr(TopForMgr topForMgr) {
		this.topForMgr = topForMgr;
	}

	private void makeProfiloOperatore(it.csi.taif.topforweb.dto.GlobalHomeModel theModel, ExecResults result)
			throws DbManagerException, ManagerException {

		String tipoAccesso = theModel.getAppDatacurrentUser().getTipoAccesso();
		if (tipoAccesso == null) {
			tipoAccesso = "4"; // only for Test mm
		}
		int idProfilo = 0;

		//se l'Accesso è 1/2 (operatore) il profilo è 6 (operatore)
		//se l'Accesso è 3/4 (gestore) il profilo può essere  7 (agenzia), 8 (admin) o 9 (superadmin)

		if (tipoAccesso.equals(it.csi.taif.topforweb.business.dao.util.Constants.one)
				|| tipoAccesso.equals(it.csi.taif.topforweb.business.dao.util.Constants.two)) {
			idProfilo = it.csi.taif.topforweb.business.dao.util.Constants.sixInt;
		} else if (tipoAccesso.equals(it.csi.taif.topforweb.business.dao.util.Constants.three)
				|| tipoAccesso.equals(it.csi.taif.topforweb.business.dao.util.Constants.four)) {
			idProfilo = it.csi.taif.topforweb.business.dao.util.Constants.sevenInt;
		}
		String codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();
		// testmm
		//codiceFiscale = "RNLPRX90A01L219X";
		PersonaFilter filterPersona = new PersonaFilter();
		filterPersona.setCodiceFiscale(codiceFiscale);
		filterPersona.setNome(theModel.getAppDatacurrentUser().getNome());
		filterPersona.setCognome(theModel.getAppDatacurrentUser().getCognome());
		String naz = theModel.getAppDatacurrentUser().getNazionalita();
		if (naz.equals(it.csi.taif.topforweb.business.dao.util.Constants.fLang)) {
			filterPersona.setIdNazione(it.csi.taif.topforweb.business.dao.util.Constants.twoInt);
			theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
		} else {
			filterPersona.setIdNazione(it.csi.taif.topforweb.business.dao.util.Constants.oneInt);
			theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
		}
		//filterPersona.setIdNazione(2);
		// ONLY PER TEST MM
		// idProfilo = 4;
		filterPersona.setIdProfiloUtente(idProfilo);
		if (codiceFiscale != null && StringUtils.isNotBlank(codiceFiscale)) {
			String tracciato = theModel.getAppDatatracciato();
			Integer idConfigUtente = topForMgr.findUserCollegatoPerCodiceFiscale(filterPersona, tracciato);
			topForMgr.updateNumeroAccessi(idConfigUtente);
			Integer idPersona = topForMgr.getPersonaFromCnfUtente(idConfigUtente);
			int idNazione = topForMgr.getPersonaByIdPersona(idPersona).getFkNazione();
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente = topForMgr
					.getConfigProfiloUtenteByCodiceFiscale(getConfigProfiloUtente(theModel, idNazione), idProfilo);
			profiloUtente.setIdConfigUtente(idConfigUtente);
			profiloUtente.setIdNazione(idNazione);
			theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().setIdProfilo(String.valueOf(idProfilo));
			theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().setIdPersona(idPersona);
			theModel.getAppDatacurrentUser().getProfiloUtenteTopFor()
					.setIdSoggettoGestore(profiloUtente.getIdSoggettoGestore());
			theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().setIdConfigUtente(idConfigUtente);

			result.setResultCode(theModel.getAppDataprofiloUtente());
		}
	}

	public String identificaGestore(it.csi.taif.topforweb.dto.GlobalHomeModel theModel, String resultCode)
			throws Exception {
		final String EXECUTEINIT_OUTCOME_CODE_GESTORE_KO = //NOSONAR  Reason:EIAS
				Constants.EXECUTEINIT_OUTCOME_CODE__GESTORE_KO; //NOSONAR  Reason:EIAS
		SecurityHelper sh = new SecurityHelper();
		Identita identita = sh.getCurrentUser(theModel.getSession());
		ProfiloUtenteTopFor pu = this.getTopForMgr().getProfiloUtente(identita.getCodFiscale(), false);
		if (pu == null) {
			return Constants.EXECUTEINIT_OUTCOME_CODE__GESTORE_KO;
		} else {
			theModel.getAppDatacurrentUser().setProfiloUtenteTopFor(pu);
			return resultCode;
		}
	}

	public String identificaOperatore(it.csi.taif.topforweb.dto.GlobalHomeModel theModel, String resultCode)
			throws ManagerException, BEException {
		final String IDENTIFICAPROFILO_OUTCOME_CODE__INITKO = //NOSONAR  Reason:EIAS
				Constants.IDENTIFICAPROFILO_OUTCOME_CODE__INITKO; //NOSONAR  Reason:EIAS
		SecurityHelper sh = new SecurityHelper();
		Identita identita = sh.getCurrentUser(theModel.getSession());
		ProfiloUtenteTopFor pu = this.getTopForMgr().getProfiloUtente(identita.getCodFiscale(), true);
		if (pu == null) {
			return Constants.EXECUTEINIT_OUTCOME_CODE__GESTORE_KO;
		} else {
			theModel.getAppDatacurrentUser().setProfiloUtenteTopFor(pu);
			return resultCode;
		}
	}

	private ConfigProfiloFilter getConfigProfiloUtente(GlobalHomeModel theModel, int nazione) {
		ConfigProfiloFilter configProfiloFilter = new ConfigProfiloFilter();
		configProfiloFilter.setCodiceFiscale(theModel.getAppDatacurrentUser().getCodFisc());
		configProfiloFilter.setFlagAttivo(it.csi.taif.topforweb.business.dao.util.Constants.oneInt);
		configProfiloFilter.setIdProcedura(it.csi.taif.topforweb.business.dao.util.Constants.twoInt);
		if (nazione == 1) {
			configProfiloFilter.setDataTracciato(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
		} else {
			configProfiloFilter.setDataTracciato(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
		}
		return configProfiloFilter;
	}

	/*PROTECTED REGION END*/
}
