/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto;

import java.util.*;
import com.opensymphony.xwork2.validator.annotations.*;
import it.csi.taif.taifweb.dto.domanda.*;
import it.csi.taif.taifweb.dto.common.*;
import it.csi.taif.taifweb.dto.gestore.*;
import it.csi.taif.taifweb.dto.allegato.*;
import it.csi.taif.taifweb.dto.allegatodownload.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla OnInit action
 */
public class GlobalHomeModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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
	 * imposta il valore dell' ApplicationData 'appDatacurrentUser'
	 * @param value
	 * @generated
	 */

	public void setAppDatacurrentUser(it.csi.taif.taifweb.dto.common.UserInfo value) {
		getSession().put("appDatacurrentUser", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacurrentUser'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.common.UserInfo getAppDatacurrentUser() {
		return (it.csi.taif.taifweb.dto.common.UserInfo) (getSession().get("appDatacurrentUser"));
	}

	/**
	 * Activation Param [tipoAccesso]
	 * @generated
	 */
	private java.lang.String tipoAccesso = null;

	/**
	 * imposta il valore dell' Activation Param [tipoAccesso]
	 * @praram val
	 * @generated
	 */
	public void setTipoAccesso(java.lang.String val) {
		tipoAccesso = val;
	}

	/**
	 * legge il valore dell' Activation Param [tipoAccesso]
	 * @generated
	 */
	public java.lang.String getTipoAccesso() {
		return tipoAccesso;
	}

	/**
	 * Activation Param [login]
	 * @generated
	 */
	private java.lang.String login = null;

	/**
	 * imposta il valore dell' Activation Param [login]
	 * @praram val
	 * @generated
	 */
	public void setLogin(java.lang.String val) {
		login = val;
	}

	/**
	 * legge il valore dell' Activation Param [login]
	 * @generated
	 */
	public java.lang.String getLogin() {
		return login;
	}

}
