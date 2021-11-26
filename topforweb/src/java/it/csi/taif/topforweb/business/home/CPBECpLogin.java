/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.home;

import java.util.*;

import it.csi.taif.topforweb.dto.*;
import it.csi.taif.topforweb.dto.common.*;
import it.csi.taif.topforweb.dto.gestore.*;
import it.csi.taif.topforweb.dto.operatore.*;
import it.csi.taif.topforweb.dto.corsoprofessionale.*;
import it.csi.taif.topforweb.dto.qualifica.*;
import it.csi.taif.topforweb.dto.riconoscimento.*;
import it.csi.taif.topforweb.dto.allegato.*;

import org.apache.log4j.*;
import it.csi.taif.topforweb.util.*;
import it.csi.taif.topforweb.business.*;

/*PROTECTED REGION ID(R1527793231) ENABLED START*/
import java.util.Map;

import javax.servlet.jsp.jstl.core.Config;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;

import it.csi.iride2.policy.entity.Identita;
import it.csi.iride2.policy.exceptions.MalformedIdTokenException;
import it.csi.taif.topforweb.business.BEException;
import it.csi.taif.topforweb.business.common.ProfiloEnum;
import it.csi.taif.topforweb.business.manager.TopForMgr;
import it.csi.taif.topforweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.topforweb.business.manager.message.MsgMgr;
import it.csi.taif.topforweb.business.manager.validation.Validator;
import it.csi.taif.topforweb.dto.ExecResults;
import it.csi.taif.topforweb.dto.common.LoginInfo;
import it.csi.taif.topforweb.dto.common.ProfiloUtenteTopFor;
import it.csi.taif.topforweb.dto.common.UserInfo;
import it.csi.taif.topforweb.exception.ManagerException;
import it.csi.taif.topforweb.exception.ValidationException;
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.DateUtil;
/*PROTECTED REGION END*/

public class CPBECpLogin {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [profiloUtente, scope:USER_SESSION]
	public static final String APPDATA_PROFILOUTENTE_CODE = "appDataprofiloUtente";

	// ApplicationData: [tipoAccesso, scope:USER_SESSION]
	public static final String APPDATA_TIPOACCESSO_CODE = "appDatatipoAccesso";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [idAzienda, scope:USER_SESSION]
	public static final String APPDATA_IDAZIENDA_CODE = "appDataidAzienda";

	// ApplicationData: [login, scope:USER_ACTION]
	public static final String APPDATA_LOGIN_CODE = "appDatalogin";

	// ApplicationData: [msgError, scope:USER_ACTION]
	public static final String APPDATA_MSGERROR_CODE = "appDatamsgError";

	// ApplicationData: [primoIngresso, scope:USER_SESSION]
	public static final String APPDATA_PRIMOINGRESSO_CODE = "appDataprimoIngresso";

	// ApplicationData: [serviceUrl, scope:USER_SESSION]
	public static final String APPDATA_SERVICEURL_CODE = "appDataserviceUrl";

	// ApplicationData: [tipologia, scope:USER_SESSION]
	public static final String APPDATA_TIPOLOGIA_CODE = "appDatatipologia";

	// ApplicationData: [TreeStatus, scope:USER_SESSION]
	public static final String APPDATA_TREESTATUS_CODE = "appDataTreeStatus";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpLogin";

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
	 * ContentPanel cpLogin
	 */
	public ExecResults executeLogin(

			it.csi.taif.topforweb.dto.home.CpLoginModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTELOGIN_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String EXECUTELOGIN_OUTCOME_CODE__OKGESTORE = //NOSONAR  Reason:EIAS
				"OkGestore"; //NOSONAR  Reason:EIAS
		final String EXECUTELOGIN_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1184130024) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				LoginInfo info = theModel.getAppDatalogin();
				UserInfo userInfo = topForMgr.accessFromUserPassword(info);
				userInfo.setTipoAccesso(theModel.getAppDatacurrentUser().getTipoAccesso());
				// impostazione del result code 
				String tipoAccesso = theModel.getAppDatacurrentUser().getTipoAccesso();
				log.debug("TIPO ACCESSO IN LOGIN? *" + tipoAccesso + "*");
				ProfiloEnum profiloEnum = ProfiloEnum.getByProfilo(tipoAccesso);
				switch (profiloEnum) {
					case OPERATORE_FR :
						userInfo.setProfiloUtenteTopFor(theModel.getAppDatacurrentUser().getProfiloUtenteTopFor());
						result.setResultCode(EXECUTELOGIN_OUTCOME_CODE__OK);
						break;
					case GESTORE_FR :
						userInfo.setProfiloUtenteTopFor(this.identificaGestore(info));
						result.setResultCode(EXECUTELOGIN_OUTCOME_CODE__OKGESTORE);
						break;
					default :
						userInfo.setProfiloUtenteTopFor(theModel.getAppDatacurrentUser().getProfiloUtenteTopFor());
						result.setResultCode(EXECUTELOGIN_OUTCOME_CODE__OK);
						break;
				}

				this.createFakeIdentita(userInfo);
				theModel.setAppDatacurrentUser(userInfo);

			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, EXECUTELOGIN_OUTCOME_CODE__KO);
			}
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
	 * ContentPanel cpLogin
	 */
	public ExecResults executeInit(

			it.csi.taif.topforweb.dto.home.CpLoginModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEINIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R314214919) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getSession().put(Config.FMT_LOCALE, Locale.FRANCE);
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
	/*PROTECTED REGION ID(R-522668929) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	public static final String IRIDE_ID_SESSIONATTR = "iride2_id";

	private TopForMgr topForMgr;
	private MsgMgr msgMgr;

	public TopForMgr getTopForMgr() {
		return topForMgr;
	}

	public void setTopForMgr(TopForMgr topForMgr) {
		this.topForMgr = topForMgr;
	}

	public MsgMgr getMsgMgr() {
		return msgMgr;
	}

	public void setMsgMgr(MsgMgr msgMgr) {
		this.msgMgr = msgMgr;
	}

	public void createFakeIdentita(UserInfo userInfo) {

		StringBuilder token = new StringBuilder();
		token.append(userInfo.getCodFisc());
		token.append("/");
		token.append(userInfo.getCognome());
		token.append("/");
		token.append(userInfo.getNome());
		token.append("/INFOCERT/");
		token.append(DateUtil.getTokenDataCorrente());
		token.append("/16/JqUoGcC+E9q0jQKl1zeRew==");

		try {
			Identita identita = new Identita(token.toString());
			ActionContext.getContext().getSession().put(IRIDE_ID_SESSIONATTR, identita);
		} catch (MalformedIdTokenException e) {
			log.error("[CPBECpLogin::createFakeHeader] " + e.toString(), e);
		}

	}

	private ProfiloUtenteTopFor identificaGestore(LoginInfo info) throws ManagerException {
		ProfiloUtenteTopFor profilo = topForMgr.getProfiloUtenteGestore(info.getUser());
		if (profilo == null) {
			throw new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.U001));
		}
		return profilo;
	}
	/*PROTECTED REGION END*/
}
