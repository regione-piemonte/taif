/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.dto.home;

import java.util.*;
import it.csi.taif.topforweb.dto.*;
import it.csi.taif.topforweb.dto.common.*;
import it.csi.taif.topforweb.dto.gestore.*;
import it.csi.taif.topforweb.dto.operatore.*;
import it.csi.taif.topforweb.dto.corsoprofessionale.*;
import it.csi.taif.topforweb.dto.qualifica.*;
import it.csi.taif.topforweb.dto.riconoscimento.*;
import it.csi.taif.topforweb.dto.allegato.*;

import it.csi.taif.topforweb.presentation.uiutils.*;
import flexjson.JSON;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.validator.annotations.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla Schermata [cpHome]
 */
@Validation
public class CpHomeModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatacurrentUser'
	 * @param value
	 * @generated
	 */

	public void setAppDatacurrentUser(it.csi.taif.topforweb.dto.common.UserInfo value) {
		getSession().put("appDatacurrentUser", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacurrentUser'
	 * @generated
	 */
	public it.csi.taif.topforweb.dto.common.UserInfo getAppDatacurrentUser() {
		return (it.csi.taif.topforweb.dto.common.UserInfo) (getSession().get("appDatacurrentUser"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatracciato'
	 * @param value
	 * @generated
	 */

	public void setAppDatatracciato(java.lang.String value) {
		getSession().put("appDatatracciato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatracciato'
	 * @generated
	 */
	public java.lang.String getAppDatatracciato() {
		return (java.lang.String) (getSession().get("appDatatracciato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipoAccesso'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipoAccesso(java.lang.String value) {
		getSession().put("appDatatipoAccesso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipoAccesso'
	 * @generated
	 */
	public java.lang.String getAppDatatipoAccesso() {
		return (java.lang.String) (getSession().get("appDatatipoAccesso"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprofiloUtente'
	 * @param value
	 * @generated
	 */

	public void setAppDataprofiloUtente(java.lang.String value) {
		getSession().put("appDataprofiloUtente", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprofiloUtente'
	 * @generated
	 */
	public java.lang.String getAppDataprofiloUtente() {
		return (java.lang.String) (getSession().get("appDataprofiloUtente"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadatiOperatore'
	 * @param value
	 * @generated
	 */

	public void setAppDatadatiOperatore(it.csi.taif.topforweb.dto.operatore.Operatore value) {
		getSession().put("appDatadatiOperatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadatiOperatore'
	 * @generated
	 */
	public it.csi.taif.topforweb.dto.operatore.Operatore getAppDatadatiOperatore() {
		return (it.csi.taif.topforweb.dto.operatore.Operatore) (getSession().get("appDatadatiOperatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatafromModifica'
	 * @param value
	 * @generated
	 */

	public void setAppDatafromModifica(java.lang.Boolean value) {
		getSession().put("appDatafromModifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatafromModifica'
	 * @generated
	 */
	public java.lang.Boolean getAppDatafromModifica() {
		return (java.lang.Boolean) (getSession().get("appDatafromModifica"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadatiOperatoreFromDB'
	 * @param value
	 * @generated
	 */

	public void setAppDatadatiOperatoreFromDB(it.csi.taif.topforweb.dto.operatore.Operatore value) {
		getSession().put("appDatadatiOperatoreFromDB", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadatiOperatoreFromDB'
	 * @generated
	 */
	public it.csi.taif.topforweb.dto.operatore.Operatore getAppDatadatiOperatoreFromDB() {
		return (it.csi.taif.topforweb.dto.operatore.Operatore) (getSession().get("appDatadatiOperatoreFromDB"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataisNuovoInserimentoOperatore'
	 * @param value
	 * @generated
	 */

	public void setAppDataisNuovoInserimentoOperatore(java.lang.Boolean value) {
		getSession().put("appDataisNuovoInserimentoOperatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisNuovoInserimentoOperatore'
	 * @generated
	 */
	public java.lang.Boolean getAppDataisNuovoInserimentoOperatore() {
		return (java.lang.Boolean) (getSession().get("appDataisNuovoInserimentoOperatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataurlPrivacy'
	 * @param value
	 * @generated
	 */

	public void setAppDataurlPrivacy(java.lang.String value) {
		getSession().put("appDataurlPrivacy", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataurlPrivacy'
	 * @generated
	 */
	public java.lang.String getAppDataurlPrivacy() {
		return (java.lang.String) (getSession().get("appDataurlPrivacy"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
