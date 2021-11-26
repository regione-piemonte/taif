/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.common;

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
 * logica di business associata alla Schermata [CpRiepilogo]
 */
@Validation
public class CpRiepilogoModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatadomandaRiepilogo'
	 * @param value
	 * @generated
	 */

	public void setAppDatadomandaRiepilogo(it.csi.taif.taifweb.dto.domanda.Riepilogo value) {
		getSession().put("appDatadomandaRiepilogo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadomandaRiepilogo'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.Riepilogo getAppDatadomandaRiepilogo() {
		return (it.csi.taif.taifweb.dto.domanda.Riepilogo) (getSession().get("appDatadomandaRiepilogo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoStatiDomandaRiepilogo'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatiDomandaRiepilogo(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoStatiDomandaRiepilogo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatiDomandaRiepilogo'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoStatiDomandaRiepilogo() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoStatiDomandaRiepilogo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidStatoDomandaRiepilogo'
	 * @param value
	 * @generated
	 */

	public void setAppDataidStatoDomandaRiepilogo(java.lang.String value) {
		getSession().put("appDataidStatoDomandaRiepilogo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidStatoDomandaRiepilogo'
	 * @generated
	 */
	public java.lang.String getAppDataidStatoDomandaRiepilogo() {
		return (java.lang.String) (getSession().get("appDataidStatoDomandaRiepilogo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatastatoDomanda'
	 * @param value
	 * @generated
	 */

	public void setAppDatastatoDomanda(it.csi.taif.taifweb.dto.domanda.Stato value) {
		getSession().put("appDatastatoDomanda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatastatoDomanda'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.Stato getAppDatastatoDomanda() {
		return (it.csi.taif.taifweb.dto.domanda.Stato) (getSession().get("appDatastatoDomanda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataalbo'
	 * @param value
	 * @generated
	 */

	public void setAppDataalbo(it.csi.taif.taifweb.dto.domanda.Albo value) {
		getSession().put("appDataalbo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataalbo'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.Albo getAppDataalbo() {
		return (it.csi.taif.taifweb.dto.domanda.Albo) (getSession().get("appDataalbo"));
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
	 * imposta il valore dell' ApplicationData 'appDatabackDomanda'
	 * @param value
	 * @generated
	 */

	public void setAppDatabackDomanda(java.lang.String value) {
		getSession().put("appDatabackDomanda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatabackDomanda'
	 * @generated
	 */
	public java.lang.String getAppDatabackDomanda() {
		return (java.lang.String) (getSession().get("appDatabackDomanda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoGestioneStatiRiepilogo'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoGestioneStatiRiepilogo(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.DettaglioStato> value) {
		getSession().put("appDataelencoGestioneStatiRiepilogo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoGestioneStatiRiepilogo'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.DettaglioStato> getAppDataelencoGestioneStatiRiepilogo() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.DettaglioStato>) (getSession()
				.get("appDataelencoGestioneStatiRiepilogo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoRisultatiRicercaAziendaGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoRisultatiRicercaAziendaGestore(
			java.util.ArrayList<it.csi.taif.taifweb.dto.gestore.Azienda> value) {
		getSession().put("appDataelencoRisultatiRicercaAziendaGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoRisultatiRicercaAziendaGestore'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.gestore.Azienda> getAppDataelencoRisultatiRicercaAziendaGestore() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.gestore.Azienda>) (getSession()
				.get("appDataelencoRisultatiRicercaAziendaGestore"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tblElencoStatiDomanda

	private it.csi.taif.taifweb.dto.domanda.DettaglioStato widgTblElencoStatiDomanda;

	public void setWidg_tblElencoStatiDomanda(it.csi.taif.taifweb.dto.domanda.DettaglioStato value) {
		widgTblElencoStatiDomanda = value;
	}

	public it.csi.taif.taifweb.dto.domanda.DettaglioStato getWidg_tblElencoStatiDomanda() {
		return widgTblElencoStatiDomanda;
	}

}
