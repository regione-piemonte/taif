/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.home;

import java.util.*;
import it.csi.taif.taifweb.dto.*;
import it.csi.taif.taifweb.dto.domanda.*;
import it.csi.taif.taifweb.dto.common.*;
import it.csi.taif.taifweb.dto.gestore.*;
import it.csi.taif.taifweb.dto.allegato.*;
import it.csi.taif.taifweb.dto.allegatodownload.*;

import it.csi.taif.taifweb.presentation.uiutils.*;
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
	 * imposta il valore dell' ApplicationData 'appDataelencoDomande'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoDomande(java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Domanda> value) {
		getSession().put("appDataelencoDomande", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoDomande'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Domanda> getAppDataelencoDomande() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Domanda>) (getSession()
				.get("appDataelencoDomande"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAlboSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAlboSelezionato(java.lang.String value) {
		getSession().put("appDataidAlboSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAlboSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidAlboSelezionato() {
		return (java.lang.String) (getSession().get("appDataidAlboSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidDomandaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidDomandaSelezionata(java.lang.String value) {
		getSession().put("appDataidDomandaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidDomandaSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataidDomandaSelezionata() {
		return (java.lang.String) (getSession().get("appDataidDomandaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatanodoAziendaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDatanodoAziendaSelezionata(java.lang.String value) {
		getSession().put("appDatanodoAziendaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanodoAziendaSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDatanodoAziendaSelezionata() {
		return (java.lang.String) (getSession().get("appDatanodoAziendaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatreeElencoAziende'
	 * @param value
	 * @generated
	 */

	public void setAppDatatreeElencoAziende(it.csi.custom.component.tree.base.TreeNode value) {
		getSession().put("appDatatreeElencoAziende", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatreeElencoAziende'
	 * @generated
	 */
	public it.csi.custom.component.tree.base.TreeNode getAppDatatreeElencoAziende() {
		return (it.csi.custom.component.tree.base.TreeNode) (getSession().get("appDatatreeElencoAziende"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidPratica'
	 * @param value
	 * @generated
	 */

	public void setAppDataidPratica(java.lang.Integer value) {
		getSession().put("appDataidPratica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidPratica'
	 * @generated
	 */
	public java.lang.Integer getAppDataidPratica() {
		return (java.lang.Integer) (getSession().get("appDataidPratica"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoAziendeAAEP'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAziendeAAEP(java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.AziendaAAEP> value) {
		getSession().put("appDataelencoAziendeAAEP", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAziendeAAEP'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.AziendaAAEP> getAppDataelencoAziendeAAEP() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.AziendaAAEP>) (getSession()
				.get("appDataelencoAziendeAAEP"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tElencoAziendeAAEP

	private it.csi.taif.taifweb.dto.domanda.AziendaAAEP widgTElencoAziendeAAEP;

	public void setWidg_tElencoAziendeAAEP(it.csi.taif.taifweb.dto.domanda.AziendaAAEP value) {
		widgTElencoAziendeAAEP = value;
	}

	public it.csi.taif.taifweb.dto.domanda.AziendaAAEP getWidg_tElencoAziendeAAEP() {
		return widgTElencoAziendeAAEP;
	}

	// Table tElencoDomande

	private it.csi.taif.taifweb.dto.domanda.Domanda widgTElencoDomande;

	public void setWidg_tElencoDomande(it.csi.taif.taifweb.dto.domanda.Domanda value) {
		widgTElencoDomande = value;
	}

	public it.csi.taif.taifweb.dto.domanda.Domanda getWidg_tElencoDomande() {
		return widgTElencoDomande;
	}

	// Table tElencoDomandeFr

	private it.csi.taif.taifweb.dto.domanda.Domanda widgTElencoDomandeFr;

	public void setWidg_tElencoDomandeFr(it.csi.taif.taifweb.dto.domanda.Domanda value) {
		widgTElencoDomandeFr = value;
	}

	public it.csi.taif.taifweb.dto.domanda.Domanda getWidg_tElencoDomandeFr() {
		return widgTElencoDomandeFr;
	}

}
