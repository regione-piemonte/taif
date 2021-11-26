/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.gestore;

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
 * logica di business associata alla Schermata [cpRicercaAziendaGestore]
 */
@Validation
public class CpRicercaAziendaGestoreModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoAlbiRicercaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAlbiRicercaAzienda(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoAlbiRicercaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAlbiRicercaAzienda'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoAlbiRicercaAzienda() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoAlbiRicercaAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAlbiSelezionatiRicercaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAlbiSelezionatiRicercaAzienda(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataelencoAlbiSelezionatiRicercaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAlbiSelezionatiRicercaAzienda'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataelencoAlbiSelezionatiRicercaAzienda() {
		return (java.util.ArrayList<java.lang.String>) (getSession().get("appDataelencoAlbiSelezionatiRicercaAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoStatiRicercaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatiRicercaAzienda(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoStatiRicercaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatiRicercaAzienda'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoStatiRicercaAzienda() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoStatiRicercaAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSottostatiRicercaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSottostatiRicercaAzienda(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSottostatiRicercaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSottostatiRicercaAzienda'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoSottostatiRicercaAzienda() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSottostatiRicercaAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAssociazioniCertificazioneRicercaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAssociazioniCertificazioneRicercaAzienda(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoAssociazioniCertificazioneRicercaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAssociazioniCertificazioneRicercaAzienda'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoAssociazioniCertificazioneRicercaAzienda() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoAssociazioniCertificazioneRicercaAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCategorieImpresaRicercaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCategorieImpresaRicercaAzienda(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoCategorieImpresaRicercaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCategorieImpresaRicercaAzienda'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoCategorieImpresaRicercaAzienda() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoCategorieImpresaRicercaAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAttivitaSvolteRicercaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAttivitaSvolteRicercaAzienda(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoAttivitaSvolteRicercaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAttivitaSvolteRicercaAzienda'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoAttivitaSvolteRicercaAzienda() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoAttivitaSvolteRicercaAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSezioniRicercaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSezioniRicercaAzienda(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSezioniRicercaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSezioniRicercaAzienda'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoSezioniRicercaAzienda() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSezioniRicercaAzienda"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniRicercaAziendaGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniRicercaAziendaGestore(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniRicercaAziendaGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniRicercaAziendaGestore'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoComuniRicercaAziendaGestore() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniRicercaAziendaGestore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidComuneSelezionatoRicercaAziendaGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDataidComuneSelezionatoRicercaAziendaGestore(java.lang.String value) {
		getSession().put("appDataidComuneSelezionatoRicercaAziendaGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidComuneSelezionatoRicercaAziendaGestore'
	 * @generated
	 */
	public java.lang.String getAppDataidComuneSelezionatoRicercaAziendaGestore() {
		return (java.lang.String) (getSession().get("appDataidComuneSelezionatoRicercaAziendaGestore"));
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
	 * imposta il valore dell' ApplicationData 'appDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore(java.lang.String value) {
		getSession().put("appDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore'
	 * @generated
	 */
	public java.lang.String getAppDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore() {
		return (java.lang.String) (getSession().get("appDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidStatoPraticaSelezionatoRicercaAziendaGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDataidStatoPraticaSelezionatoRicercaAziendaGestore(java.lang.String value) {
		getSession().put("appDataidStatoPraticaSelezionatoRicercaAziendaGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidStatoPraticaSelezionatoRicercaAziendaGestore'
	 * @generated
	 */
	public java.lang.String getAppDataidStatoPraticaSelezionatoRicercaAziendaGestore() {
		return (java.lang.String) (getSession().get("appDataidStatoPraticaSelezionatoRicercaAziendaGestore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatanumeroRisultatiRicercaAziendaGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDatanumeroRisultatiRicercaAziendaGestore(java.lang.String value) {
		getSession().put("appDatanumeroRisultatiRicercaAziendaGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanumeroRisultatiRicercaAziendaGestore'
	 * @generated
	 */
	public java.lang.String getAppDatanumeroRisultatiRicercaAziendaGestore() {
		return (java.lang.String) (getSession().get("appDatanumeroRisultatiRicercaAziendaGestore"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda(
			java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda() {
		return (java.util.ArrayList<java.lang.String>) (getSession()
				.get("appDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAttivitaSvolteSelezionatiRicercaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAttivitaSvolteSelezionatiRicercaAzienda(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataelencoAttivitaSvolteSelezionatiRicercaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAttivitaSvolteSelezionatiRicercaAzienda'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataelencoAttivitaSvolteSelezionatiRicercaAzienda() {
		return (java.util.ArrayList<java.lang.String>) (getSession()
				.get("appDataelencoAttivitaSvolteSelezionatiRicercaAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCategorieImpresaSelezionatiRicercaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCategorieImpresaSelezionatiRicercaAzienda(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataelencoCategorieImpresaSelezionatiRicercaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCategorieImpresaSelezionatiRicercaAzienda'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataelencoCategorieImpresaSelezionatiRicercaAzienda() {
		return (java.util.ArrayList<java.lang.String>) (getSession()
				.get("appDataelencoCategorieImpresaSelezionatiRicercaAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSezioniSelezionatiRicercaAzienda'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSezioniSelezionatiRicercaAzienda(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataelencoSezioniSelezionatiRicercaAzienda", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSezioniSelezionatiRicercaAzienda'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataelencoSezioniSelezionatiRicercaAzienda() {
		return (java.util.ArrayList<java.lang.String>) (getSession()
				.get("appDataelencoSezioniSelezionatiRicercaAzienda"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidProvinciaSelezionatoRicercaAziendaGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDataidProvinciaSelezionatoRicercaAziendaGestore(java.lang.String value) {
		getSession().put("appDataidProvinciaSelezionatoRicercaAziendaGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidProvinciaSelezionatoRicercaAziendaGestore'
	 * @generated
	 */
	public java.lang.String getAppDataidProvinciaSelezionatoRicercaAziendaGestore() {
		return (java.lang.String) (getSession().get("appDataidProvinciaSelezionatoRicercaAziendaGestore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoProvinciaRicercaAziendaGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoProvinciaRicercaAziendaGestore(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoProvinciaRicercaAziendaGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoProvinciaRicercaAziendaGestore'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoProvinciaRicercaAziendaGestore() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoProvinciaRicercaAziendaGestore"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
