/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.autenticazione;

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

/*PROTECTED REGION ID(R2198857) ENABLED START*/

/*PROTECTED REGION END*/

public class CPBECpAutenticazione {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "CpAutenticazione";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeLogin definito in un ExecCommand del
	 * ContentPanel CpAutenticazione
	 */
	public ExecResults executeLogin(

			it.csi.taif.taifweb.dto.autenticazione.CpAutenticazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTELOGIN_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String EXECUTELOGIN_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R107877598) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(EXECUTELOGIN_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeLogin] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeInit definito in un ExecCommand del
	 * ContentPanel CpAutenticazione
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.autenticazione.CpAutenticazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEINIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1187176577) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-96140725) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
