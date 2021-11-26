/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.common;

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

/*PROTECTED REGION ID(R1261040080) ENABLED START*/
import it.csi.taif.taifweb.exception.ValidationException;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.taifweb.business.manager.message.MsgMgr;
import it.csi.taif.taifweb.business.manager.validation.Validator;
import it.csi.taif.taifweb.exception.ManagerException;

import com.opensymphony.xwork2.ActionContext;

/*PROTECTED REGION END*/

public class CPBECpError {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [login, scope:USER_ACTION]
	public static final String APPDATA_LOGIN_CODE = "appDatalogin";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpError";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo showError definito in un ExecCommand del
	 * ContentPanel cpError
	 */
	public ExecResults showError(

			it.csi.taif.taifweb.dto.common.CpErrorModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SHOWERROR_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SHOWERROR_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1093584226) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				//taif-17
				if (ActionContext.getContext().getSession().containsValue("gestoreKO")) {
					throw new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.U002));
				}

				//taif-18 azienda

				if (ActionContext.getContext().getSession().containsValue("azienzaKO")) {
					throw new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.U003));
				}

				//taif-18 professionista

				if (ActionContext.getContext().getSession().containsValue("professionistaKO")) {
					throw new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.U004));
				}

			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, SHOWERROR_OUTCOME_CODE__KO);
				return result;
			}
			// impostazione del result code 
			result.setResultCode(SHOWERROR_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::showError] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1676292770) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private TaifMgr taifMgr;
	private MsgMgr msgMgr;

	public TaifMgr getTaifMgr() {
		return taifMgr;
	}

	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}

	/**
	 * @return the msgMgr
	 */
	public MsgMgr getMsgMgr() {
		return msgMgr;
	}

	/**
	 * @param msgMgr the msgMgr to set
	 */
	public void setMsgMgr(MsgMgr msgMgr) {
		this.msgMgr = msgMgr;
	}
	/*PROTECTED REGION END*/
}
