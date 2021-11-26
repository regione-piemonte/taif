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
 * logica di business associata alla Schermata [cpRicercaAccessoLibero]
 */
@Validation
public class CpRicercaAccessoLiberoModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoProvinceRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoProvinceRicercaAccessoLibero(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoProvinceRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoProvinceRicercaAccessoLibero'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoProvinceRicercaAccessoLibero() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoProvinceRicercaAccessoLibero"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidComuneSelezionatoRicercaAccessoLibero'
	 * @param value
	 * @generated
	 */

	public void setAppDataidComuneSelezionatoRicercaAccessoLibero(java.lang.String value) {
		getSession().put("appDataidComuneSelezionatoRicercaAccessoLibero", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidComuneSelezionatoRicercaAccessoLibero'
	 * @generated
	 */
	public java.lang.String getAppDataidComuneSelezionatoRicercaAccessoLibero() {
		return (java.lang.String) (getSession().get("appDataidComuneSelezionatoRicercaAccessoLibero"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
