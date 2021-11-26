/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.dto;

import java.util.*;
import com.opensymphony.xwork2.validator.annotations.*;
import it.csi.taif.topforweb.dto.common.*;
import it.csi.taif.topforweb.dto.gestore.*;
import it.csi.taif.topforweb.dto.operatore.*;
import it.csi.taif.topforweb.dto.corsoprofessionale.*;
import it.csi.taif.topforweb.dto.qualifica.*;
import it.csi.taif.topforweb.dto.riconoscimento.*;
import it.csi.taif.topforweb.dto.allegato.*;

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

}
