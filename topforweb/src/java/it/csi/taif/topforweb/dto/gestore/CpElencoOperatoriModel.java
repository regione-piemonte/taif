/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.dto.gestore;

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
 * logica di business associata alla Schermata [cpElencoOperatori]
 */
@Validation
public class CpElencoOperatoriModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataidSezioneSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidSezioneSelezionata(java.lang.String value) {
		getSession().put("appDataidSezioneSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidSezioneSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataidSezioneSelezionata() {
		return (java.lang.String) (getSession().get("appDataidSezioneSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacognomeRicercaOperatore'
	 * @param value
	 * @generated
	 */

	public void setAppDatacognomeRicercaOperatore(java.lang.String value) {
		getSession().put("appDatacognomeRicercaOperatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacognomeRicercaOperatore'
	 * @generated
	 */
	public java.lang.String getAppDatacognomeRicercaOperatore() {
		return (java.lang.String) (getSession().get("appDatacognomeRicercaOperatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadataPeriodoSvolgimentoA'
	 * @param value
	 * @generated
	 */

	public void setAppDatadataPeriodoSvolgimentoA(java.lang.String value) {
		getSession().put("appDatadataPeriodoSvolgimentoA", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadataPeriodoSvolgimentoA'
	 * @generated
	 */
	public java.lang.String getAppDatadataPeriodoSvolgimentoA() {
		return (java.lang.String) (getSession().get("appDatadataPeriodoSvolgimentoA"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadataPeriodoSvolgimentoDa'
	 * @param value
	 * @generated
	 */

	public void setAppDatadataPeriodoSvolgimentoDa(java.lang.String value) {
		getSession().put("appDatadataPeriodoSvolgimentoDa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadataPeriodoSvolgimentoDa'
	 * @generated
	 */
	public java.lang.String getAppDatadataPeriodoSvolgimentoDa() {
		return (java.lang.String) (getSession().get("appDatadataPeriodoSvolgimentoDa"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadettaglioOperatoreSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDatadettaglioOperatoreSelezionato(it.csi.taif.topforweb.dto.operatore.Operatore value) {
		getSession().put("appDatadettaglioOperatoreSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadettaglioOperatoreSelezionato'
	 * @generated
	 */
	public it.csi.taif.topforweb.dto.operatore.Operatore getAppDatadettaglioOperatoreSelezionato() {
		return (it.csi.taif.topforweb.dto.operatore.Operatore) (getSession()
				.get("appDatadettaglioOperatoreSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAgenziaFormativaRicercaOperatore'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAgenziaFormativaRicercaOperatore(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoAgenziaFormativaRicercaOperatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAgenziaFormativaRicercaOperatore'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoAgenziaFormativaRicercaOperatore() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoAgenziaFormativaRicercaOperatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAlbiRicercaOperatore'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAlbiRicercaOperatore(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoAlbiRicercaOperatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAlbiRicercaOperatore'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoAlbiRicercaOperatore() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoAlbiRicercaOperatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAlbiSelezionatiRicercaOperatore'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAlbiSelezionatiRicercaOperatore(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataelencoAlbiSelezionatiRicercaOperatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAlbiSelezionatiRicercaOperatore'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataelencoAlbiSelezionatiRicercaOperatore() {
		return (java.util.ArrayList<java.lang.String>) (getSession()
				.get("appDataelencoAlbiSelezionatiRicercaOperatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAltriCorsi'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAltriCorsi(
			java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> value) {
		getSession().put("appDataelencoAltriCorsi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAltriCorsi'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> getAppDataelencoAltriCorsi() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale>) (getSession()
				.get("appDataelencoAltriCorsi"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniRicercaOperatoreGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniRicercaOperatoreGestore(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniRicercaOperatoreGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniRicercaOperatoreGestore'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoComuniRicercaOperatoreGestore() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniRicercaOperatoreGestore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCorsiProfessionaliFinanziatiDaRegione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCorsiProfessionaliFinanziatiDaRegione(
			java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> value) {
		getSession().put("appDataelencoCorsiProfessionaliFinanziatiDaRegione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCorsiProfessionaliFinanziatiDaRegione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> getAppDataelencoCorsiProfessionaliFinanziatiDaRegione() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale>) (getSession()
				.get("appDataelencoCorsiProfessionaliFinanziatiDaRegione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoQualifiche'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoQualifiche(java.util.ArrayList<it.csi.taif.topforweb.dto.qualifica.Qualifica> value) {
		getSession().put("appDataelencoQualifiche", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoQualifiche'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.qualifica.Qualifica> getAppDataelencoQualifiche() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.qualifica.Qualifica>) (getSession()
				.get("appDataelencoQualifiche"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoRiconoscimento'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoRiconoscimento(
			java.util.ArrayList<it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento> value) {
		getSession().put("appDataelencoRiconoscimento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoRiconoscimento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento> getAppDataelencoRiconoscimento() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento>) (getSession()
				.get("appDataelencoRiconoscimento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoRisultatiRicercaOperatoreGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoRisultatiRicercaOperatoreGestore(
			java.util.ArrayList<it.csi.taif.topforweb.dto.operatore.Operatore> value) {
		getSession().put("appDataelencoRisultatiRicercaOperatoreGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoRisultatiRicercaOperatoreGestore'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.operatore.Operatore> getAppDataelencoRisultatiRicercaOperatoreGestore() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.operatore.Operatore>) (getSession()
				.get("appDataelencoRisultatiRicercaOperatoreGestore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoStatoOperatoreRicerca'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatoOperatoreRicerca(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoStatoOperatoreRicerca", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatoOperatoreRicerca'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoStatoOperatoreRicerca() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoStatoOperatoreRicerca"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoStatoSchedaRicerca'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatoSchedaRicerca(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoStatoSchedaRicerca", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatoSchedaRicerca'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoStatoSchedaRicerca() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoStatoSchedaRicerca"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoUnitaFormativaRicercaOperatore'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoUnitaFormativaRicercaOperatore(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoUnitaFormativaRicercaOperatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoUnitaFormativaRicercaOperatore'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoUnitaFormativaRicercaOperatore() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoUnitaFormativaRicercaOperatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAgenziaFormativaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAgenziaFormativaSelezionata(java.lang.String value) {
		getSession().put("appDataidAgenziaFormativaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAgenziaFormativaSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataidAgenziaFormativaSelezionata() {
		return (java.lang.String) (getSession().get("appDataidAgenziaFormativaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidComuneSelezionatoRicercaOperatoreGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDataidComuneSelezionatoRicercaOperatoreGestore(java.lang.String value) {
		getSession().put("appDataidComuneSelezionatoRicercaOperatoreGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidComuneSelezionatoRicercaOperatoreGestore'
	 * @generated
	 */
	public java.lang.String getAppDataidComuneSelezionatoRicercaOperatoreGestore() {
		return (java.lang.String) (getSession().get("appDataidComuneSelezionatoRicercaOperatoreGestore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidStatoOperatoreSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidStatoOperatoreSelezionato(java.lang.String value) {
		getSession().put("appDataidStatoOperatoreSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidStatoOperatoreSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidStatoOperatoreSelezionato() {
		return (java.lang.String) (getSession().get("appDataidStatoOperatoreSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidStatoSchedaSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidStatoSchedaSelezionato(java.lang.String value) {
		getSession().put("appDataidStatoSchedaSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidStatoSchedaSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidStatoSchedaSelezionato() {
		return (java.lang.String) (getSession().get("appDataidStatoSchedaSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidUnitaFormativaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidUnitaFormativaSelezionata(java.lang.String value) {
		getSession().put("appDataidUnitaFormativaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidUnitaFormativaSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataidUnitaFormativaSelezionata() {
		return (java.lang.String) (getSession().get("appDataidUnitaFormativaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataisIstruttoreOperatore'
	 * @param value
	 * @generated
	 */

	public void setAppDataisIstruttoreOperatore(java.lang.String value) {
		getSession().put("appDataisIstruttoreOperatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisIstruttoreOperatore'
	 * @generated
	 */
	public java.lang.String getAppDataisIstruttoreOperatore() {
		return (java.lang.String) (getSession().get("appDataisIstruttoreOperatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataisOperatoreConQualifica'
	 * @param value
	 * @generated
	 */

	public void setAppDataisOperatoreConQualifica(java.lang.String value) {
		getSession().put("appDataisOperatoreConQualifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisOperatoreConQualifica'
	 * @generated
	 */
	public java.lang.String getAppDataisOperatoreConQualifica() {
		return (java.lang.String) (getSession().get("appDataisOperatoreConQualifica"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatanumeroAlboOperatore'
	 * @param value
	 * @generated
	 */

	public void setAppDatanumeroAlboOperatore(java.lang.String value) {
		getSession().put("appDatanumeroAlboOperatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanumeroAlboOperatore'
	 * @generated
	 */
	public java.lang.String getAppDatanumeroAlboOperatore() {
		return (java.lang.String) (getSession().get("appDatanumeroAlboOperatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatanumeroRisultatiRicercaOperatoreGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDatanumeroRisultatiRicercaOperatoreGestore(java.lang.String value) {
		getSession().put("appDatanumeroRisultatiRicercaOperatoreGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanumeroRisultatiRicercaOperatoreGestore'
	 * @generated
	 */
	public java.lang.String getAppDatanumeroRisultatiRicercaOperatoreGestore() {
		return (java.lang.String) (getSession().get("appDatanumeroRisultatiRicercaOperatoreGestore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuni(java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoComuni() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoProvince'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoProvince(java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoProvince", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoProvince'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoProvince() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoProvince"));
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
	 * imposta il valore dell' ApplicationData 'appDataidStatoSchedaSelezionatoRicercaOperatore'
	 * @param value
	 * @generated
	 */

	public void setAppDataidStatoSchedaSelezionatoRicercaOperatore(java.lang.String value) {
		getSession().put("appDataidStatoSchedaSelezionatoRicercaOperatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidStatoSchedaSelezionatoRicercaOperatore'
	 * @generated
	 */
	public java.lang.String getAppDataidStatoSchedaSelezionatoRicercaOperatore() {
		return (java.lang.String) (getSession().get("appDataidStatoSchedaSelezionatoRicercaOperatore"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoNazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoNazioni(java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoNazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoNazioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoNazioni() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoNazioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataconsensoPubblicazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataconsensoPubblicazione(java.lang.Boolean value) {
		getSession().put("appDataconsensoPubblicazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataconsensoPubblicazione'
	 * @generated
	 */
	public java.lang.Boolean getAppDataconsensoPubblicazione() {
		return (java.lang.Boolean) (getSession().get("appDataconsensoPubblicazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprivacy'
	 * @param value
	 * @generated
	 */

	public void setAppDataprivacy(java.lang.Boolean value) {
		getSession().put("appDataprivacy", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprivacy'
	 * @generated
	 */
	public java.lang.Boolean getAppDataprivacy() {
		return (java.lang.Boolean) (getSession().get("appDataprivacy"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaLibera'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaLibera(java.lang.Boolean value) {
		getSession().put("appDataricercaLibera", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaLibera'
	 * @generated
	 */
	public java.lang.Boolean getAppDataricercaLibera() {
		return (java.lang.Boolean) (getSession().get("appDataricercaLibera"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tblElencoOperatori

	private it.csi.taif.topforweb.dto.operatore.Operatore widgTblElencoOperatori;

	public void setWidg_tblElencoOperatori(it.csi.taif.topforweb.dto.operatore.Operatore value) {
		widgTblElencoOperatori = value;
	}

	public it.csi.taif.topforweb.dto.operatore.Operatore getWidg_tblElencoOperatori() {
		return widgTblElencoOperatori;
	}

	// TextField tfVerificaCaptchaRicercaLibera

	private java.lang.String widgTfVerificaCaptchaRicercaLibera;

	public void setWidg_tfVerificaCaptchaRicercaLibera(java.lang.String value) {
		widgTfVerificaCaptchaRicercaLibera = value;
	}

	public java.lang.String getWidg_tfVerificaCaptchaRicercaLibera() {
		return widgTfVerificaCaptchaRicercaLibera;
	}

	// Captcha widg_captchaExportRicercaLibera (readonly)
	public boolean validateAnswerForWidg_captchaExportRicercaLibera(String answer) {
		nl.captcha.Captcha captcha = (nl.captcha.Captcha) (this.getSession()
				.get(it.csi.taif.topforweb.util.Constants.CAPTCHA_SESSION_NAME));
		if (captcha != null) {
			return captcha.isCorrect(answer);
		} else {
			return false; // no captcha, no answer
		}
	}

}
