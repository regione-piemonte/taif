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
 * logica di business associata alla Schermata [cpLogin]
 */
@Validation
public class CpLoginModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataidAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAzienda(java.lang.Integer value) {
		getSession().put("appDataidAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAzienda'
	 * @generated
	 */
	public java.lang.Integer getAppDataidAzienda() {
		return (java.lang.Integer) (getSession().get("appDataidAzienda"));
	}

	/**
	 * @generated
	 */
	private it.csi.taif.topforweb.dto.common.LoginInfo appDatalogin = null;

	/**
	 * imposta il valore dell' ApplicationData 'appDatalogin'
	 * @param value
	 * @generated
	 */

	public void setAppDatalogin(it.csi.taif.topforweb.dto.common.LoginInfo value) {
		appDatalogin = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalogin'
	 * @generated
	 */
	public it.csi.taif.topforweb.dto.common.LoginInfo getAppDatalogin() {
		return appDatalogin;
	}

	/**
	 * @generated
	 */
	private java.lang.String appDatamsgError = null;

	/**
	 * imposta il valore dell' ApplicationData 'appDatamsgError'
	 * @param value
	 * @generated
	 */

	public void setAppDatamsgError(java.lang.String value) {
		appDatamsgError = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamsgError'
	 * @generated
	 */
	public java.lang.String getAppDatamsgError() {
		return appDatamsgError;
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprimoIngresso'
	 * @param value
	 * @generated
	 */

	public void setAppDataprimoIngresso(java.lang.Boolean value) {
		getSession().put("appDataprimoIngresso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprimoIngresso'
	 * @generated
	 */
	public java.lang.Boolean getAppDataprimoIngresso() {
		return (java.lang.Boolean) (getSession().get("appDataprimoIngresso"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataserviceUrl'
	 * @param value
	 * @generated
	 */

	public void setAppDataserviceUrl(java.lang.String value) {
		getSession().put("appDataserviceUrl", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataserviceUrl'
	 * @generated
	 */
	public java.lang.String getAppDataserviceUrl() {
		return (java.lang.String) (getSession().get("appDataserviceUrl"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipologia'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipologia(java.lang.String value) {
		getSession().put("appDatatipologia", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipologia'
	 * @generated
	 */
	public java.lang.String getAppDatatipologia() {
		return (java.lang.String) (getSession().get("appDatatipologia"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataTreeStatus'
	 * @param value
	 * @generated
	 */

	public void setAppDataTreeStatus(it.csi.custom.component.tree.base.TreeStatus value) {
		getSession().put("appDataTreeStatus", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataTreeStatus'
	 * @generated
	 */
	public it.csi.custom.component.tree.base.TreeStatus getAppDataTreeStatus() {
		return (it.csi.custom.component.tree.base.TreeStatus) (getSession().get("appDataTreeStatus"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
