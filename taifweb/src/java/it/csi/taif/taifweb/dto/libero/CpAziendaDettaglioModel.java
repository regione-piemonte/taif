/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.libero;

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
 * logica di business associata alla Schermata [cpAziendaDettaglio]
 */
@Validation
public class CpAziendaDettaglioModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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
	 * imposta il valore dell' ApplicationData 'appDatacrumbs'
	 * @param value
	 * @generated
	 */

	public void setAppDatacrumbs(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDatacrumbs", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacrumbs'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDatacrumbs() {
		return (java.util.ArrayList<java.lang.String>) (getSession().get("appDatacrumbs"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoComuni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuni(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoComuni() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoDownloadAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoDownloadAllegati(
			java.util.ArrayList<it.csi.taif.taifweb.dto.allegatodownload.AllegatoDownload> value) {
		getSession().put("appDataelencoDownloadAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoDownloadAllegati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.allegatodownload.AllegatoDownload> getAppDataelencoDownloadAllegati() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.allegatodownload.AllegatoDownload>) (getSession()
				.get("appDataelencoDownloadAllegati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoProvince'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoProvince(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoProvince", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoProvince'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoProvince() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoProvince"));
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
	 * @generated
	 */
	private it.csi.taif.taifweb.dto.common.LoginInfo appDatalogin = null;

	/**
	 * imposta il valore dell' ApplicationData 'appDatalogin'
	 * @param value
	 * @generated
	 */

	public void setAppDatalogin(it.csi.taif.taifweb.dto.common.LoginInfo value) {
		appDatalogin = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalogin'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.common.LoginInfo getAppDatalogin() {
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

	/**
	 * imposta il valore dell' ApplicationData 'appDatacodFisPivaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodFisPivaAzienda(java.lang.String value) {
		getSession().put("appDatacodFisPivaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodFisPivaAzienda'
	 * @generated
	 */
	public java.lang.String getAppDatacodFisPivaAzienda() {
		return (java.lang.String) (getSession().get("appDatacodFisPivaAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadataIscrizioneAlboAziendaA'
	 * @param value
	 * @generated
	 */

	public void setAppDatadataIscrizioneAlboAziendaA(java.lang.String value) {
		getSession().put("appDatadataIscrizioneAlboAziendaA", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadataIscrizioneAlboAziendaA'
	 * @generated
	 */
	public java.lang.String getAppDatadataIscrizioneAlboAziendaA() {
		return (java.lang.String) (getSession().get("appDatadataIscrizioneAlboAziendaA"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadataIscrizioneAlboAziendaDa'
	 * @param value
	 * @generated
	 */

	public void setAppDatadataIscrizioneAlboAziendaDa(java.lang.String value) {
		getSession().put("appDatadataIscrizioneAlboAziendaDa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadataIscrizioneAlboAziendaDa'
	 * @generated
	 */
	public java.lang.String getAppDatadataIscrizioneAlboAziendaDa() {
		return (java.lang.String) (getSession().get("appDatadataIscrizioneAlboAziendaDa"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadenominazioneAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDatadenominazioneAzienda(java.lang.String value) {
		getSession().put("appDatadenominazioneAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadenominazioneAzienda'
	 * @generated
	 */
	public java.lang.String getAppDatadenominazioneAzienda() {
		return (java.lang.String) (getSession().get("appDatadenominazioneAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadettaglioAziendaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDatadettaglioAziendaSelezionata(it.csi.taif.taifweb.dto.gestore.Azienda value) {
		getSession().put("appDatadettaglioAziendaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadettaglioAziendaSelezionata'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.gestore.Azienda getAppDatadettaglioAziendaSelezionata() {
		return (it.csi.taif.taifweb.dto.gestore.Azienda) (getSession().get("appDatadettaglioAziendaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAlbiRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAlbiRicercaAccessoLibero(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoAlbiRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAlbiRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoAlbiRicercaAccessoLibero() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoAlbiRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAlbiSelezionatiRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAlbiSelezionatiRicercaAccessoLibero(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataelencoAlbiSelezionatiRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAlbiSelezionatiRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataelencoAlbiSelezionatiRicercaAccessoLibero() {
		return (java.util.ArrayList<java.lang.String>) (getSession()
				.get("appDataelencoAlbiSelezionatiRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAssociazioniCertificazioneRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAssociazioniCertificazioneRicercaAccessoLibero(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoAssociazioniCertificazioneRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAssociazioniCertificazioneRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoAssociazioniCertificazioneRicercaAccessoLibero() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoAssociazioniCertificazioneRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero(
			java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero() {
		return (java.util.ArrayList<java.lang.String>) (getSession()
				.get("appDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAttivitaSvolteRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAttivitaSvolteRicercaAccessoLibero(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoAttivitaSvolteRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAttivitaSvolteRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoAttivitaSvolteRicercaAccessoLibero() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoAttivitaSvolteRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero(
			java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero() {
		return (java.util.ArrayList<java.lang.String>) (getSession()
				.get("appDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCategorieImpresaRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCategorieImpresaRicercaAccessoLibero(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoCategorieImpresaRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCategorieImpresaRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoCategorieImpresaRicercaAccessoLibero() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoCategorieImpresaRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero(
			java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero() {
		return (java.util.ArrayList<java.lang.String>) (getSession()
				.get("appDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniRicercaAccessoLibero(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoComuniRicercaAccessoLibero() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoRisultatiRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoRisultatiRicercaAccessoLibero(
			java.util.ArrayList<it.csi.taif.taifweb.dto.gestore.Azienda> value) {
		getSession().put("appDataelencoRisultatiRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoRisultatiRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.gestore.Azienda> getAppDataelencoRisultatiRicercaAccessoLibero() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.gestore.Azienda>) (getSession()
				.get("appDataelencoRisultatiRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSezioniRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSezioniRicercaAccessoLibero(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSezioniRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSezioniRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoSezioniRicercaAccessoLibero() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSezioniRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSezioniSelezionatiRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSezioniSelezionatiRicercaAccessoLibero(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataelencoSezioniSelezionatiRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSezioniSelezionatiRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataelencoSezioniSelezionatiRicercaAccessoLibero() {
		return (java.util.ArrayList<java.lang.String>) (getSession()
				.get("appDataelencoSezioniSelezionatiRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidProvinciaSelezionatoRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataidProvinciaSelezionatoRicercaAccessoLibero(java.lang.String value) {
		getSession().put("appDataidProvinciaSelezionatoRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidProvinciaSelezionatoRicercaAccessoLibero'
	 * @generated
	 */
	public java.lang.String getAppDataidProvinciaSelezionatoRicercaAccessoLibero() {
		return (java.lang.String) (getSession().get("appDataidProvinciaSelezionatoRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatanumeroAlboAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDatanumeroAlboAzienda(java.lang.String value) {
		getSession().put("appDatanumeroAlboAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanumeroAlboAzienda'
	 * @generated
	 */
	public java.lang.String getAppDatanumeroAlboAzienda() {
		return (java.lang.String) (getSession().get("appDatanumeroAlboAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatitolareLegaleRappresentanteAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDatatitolareLegaleRappresentanteAzienda(java.lang.String value) {
		getSession().put("appDatatitolareLegaleRappresentanteAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatitolareLegaleRappresentanteAzienda'
	 * @generated
	 */
	public java.lang.String getAppDatatitolareLegaleRappresentanteAzienda() {
		return (java.lang.String) (getSession().get("appDatatitolareLegaleRappresentanteAzienda"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
