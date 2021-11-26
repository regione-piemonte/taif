/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.dto.gestore;

import java.io.File;
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
 * logica di business associata alla Schermata [cpInserimentoOperatore]
 */
@Validation
public class CpInserimentoOperatoreModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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
	 * imposta il valore dell' ApplicationData 'appDataidComuneNascitaSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidComuneNascitaSelezionato(java.lang.String value) {
		getSession().put("appDataidComuneNascitaSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidComuneNascitaSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidComuneNascitaSelezionato() {
		return (java.lang.String) (getSession().get("appDataidComuneNascitaSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidComuneResidenzaSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidComuneResidenzaSelezionato(java.lang.String value) {
		getSession().put("appDataidComuneResidenzaSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidComuneResidenzaSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidComuneResidenzaSelezionato() {
		return (java.lang.String) (getSession().get("appDataidComuneResidenzaSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidNazioneNascitaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidNazioneNascitaSelezionata(java.lang.String value) {
		getSession().put("appDataidNazioneNascitaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidNazioneNascitaSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataidNazioneNascitaSelezionata() {
		return (java.lang.String) (getSession().get("appDataidNazioneNascitaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTitoloCorso'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTitoloCorso(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTitoloCorso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTitoloCorso'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoTitoloCorso() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTitoloCorso"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTitoloCorsoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTitoloCorsoSelezionato(java.lang.String value) {
		getSession().put("appDataidTitoloCorsoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTitoloCorsoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidTitoloCorsoSelezionato() {
		return (java.lang.String) (getSession().get("appDataidTitoloCorsoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSedeCorso'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSedeCorso(java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSedeCorso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSedeCorso'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoSedeCorso() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSedeCorso"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidSedeCorsoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidSedeCorsoSelezionato(java.lang.String value) {
		getSession().put("appDataidSedeCorsoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidSedeCorsoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidSedeCorsoSelezionato() {
		return (java.lang.String) (getSession().get("appDataidSedeCorsoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoEsitoCorso'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoEsitoCorso(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoEsitoCorso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoEsitoCorso'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoEsitoCorso() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoEsitoCorso"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoPeriodoSvolgimentoCorso'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoPeriodoSvolgimentoCorso(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoPeriodoSvolgimentoCorso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoPeriodoSvolgimentoCorso'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoPeriodoSvolgimentoCorso() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoPeriodoSvolgimentoCorso"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidEsitoCorsoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidEsitoCorsoSelezionato(java.lang.String value) {
		getSession().put("appDataidEsitoCorsoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidEsitoCorsoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidEsitoCorsoSelezionato() {
		return (java.lang.String) (getSession().get("appDataidEsitoCorsoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidPeriodoSvolgimentoCorsoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidPeriodoSvolgimentoCorsoSelezionato(java.lang.String value) {
		getSession().put("appDataidPeriodoSvolgimentoCorsoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidPeriodoSvolgimentoCorsoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidPeriodoSvolgimentoCorsoSelezionato() {
		return (java.lang.String) (getSession().get("appDataidPeriodoSvolgimentoCorsoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatanumeroOreCorso'
	 * @param value
	 * @generated
	 */

	public void setAppDatanumeroOreCorso(java.lang.String value) {
		getSession().put("appDatanumeroOreCorso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanumeroOreCorso'
	 * @generated
	 */
	public java.lang.String getAppDatanumeroOreCorso() {
		return (java.lang.String) (getSession().get("appDatanumeroOreCorso"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAttestatoConScadenzaInserimento'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAttestatoConScadenzaInserimento(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoAttestatoConScadenzaInserimento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAttestatoConScadenzaInserimento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoAttestatoConScadenzaInserimento() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoAttestatoConScadenzaInserimento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAttestatoConScadenzaSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAttestatoConScadenzaSelezionato(java.lang.String value) {
		getSession().put("appDataidAttestatoConScadenzaSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAttestatoConScadenzaSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidAttestatoConScadenzaSelezionato() {
		return (java.lang.String) (getSession().get("appDataidAttestatoConScadenzaSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidQualificaSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidQualificaSelezionato(java.lang.String value) {
		getSession().put("appDataidQualificaSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidQualificaSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidQualificaSelezionato() {
		return (java.lang.String) (getSession().get("appDataidQualificaSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCorsiFinanziatiFromUnitaFormativa'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCorsiFinanziatiFromUnitaFormativa(
			java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> value) {
		getSession().put("appDataelencoCorsiFinanziatiFromUnitaFormativa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCorsiFinanziatiFromUnitaFormativa'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> getAppDataelencoCorsiFinanziatiFromUnitaFormativa() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale>) (getSession()
				.get("appDataelencoCorsiFinanziatiFromUnitaFormativa"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAgenziaFormativaQualificaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAgenziaFormativaQualificaSelezionata(java.lang.String value) {
		getSession().put("appDataidAgenziaFormativaQualificaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAgenziaFormativaQualificaSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataidAgenziaFormativaQualificaSelezionata() {
		return (java.lang.String) (getSession().get("appDataidAgenziaFormativaQualificaSelezionata"));
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
	 * imposta il valore dell' ApplicationData 'appDatacorsoSelezionatoInserimento'
	 * @param value
	 * @generated
	 */

	public void setAppDatacorsoSelezionatoInserimento(
			it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale value) {
		getSession().put("appDatacorsoSelezionatoInserimento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacorsoSelezionatoInserimento'
	 * @generated
	 */
	public it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale getAppDatacorsoSelezionatoInserimento() {
		return (it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale) (getSession()
				.get("appDatacorsoSelezionatoInserimento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaltroCorsoSelezionatoInserimento'
	 * @param value
	 * @generated
	 */

	public void setAppDataaltroCorsoSelezionatoInserimento(
			it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale value) {
		getSession().put("appDataaltroCorsoSelezionatoInserimento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaltroCorsoSelezionatoInserimento'
	 * @generated
	 */
	public it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale getAppDataaltroCorsoSelezionatoInserimento() {
		return (it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale) (getSession()
				.get("appDataaltroCorsoSelezionatoInserimento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataqualificaSelezionataInserimento'
	 * @param value
	 * @generated
	 */

	public void setAppDataqualificaSelezionataInserimento(it.csi.taif.topforweb.dto.qualifica.Qualifica value) {
		getSession().put("appDataqualificaSelezionataInserimento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataqualificaSelezionataInserimento'
	 * @generated
	 */
	public it.csi.taif.topforweb.dto.qualifica.Qualifica getAppDataqualificaSelezionataInserimento() {
		return (it.csi.taif.topforweb.dto.qualifica.Qualifica) (getSession()
				.get("appDataqualificaSelezionataInserimento"));
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
	 * imposta il valore dell' ApplicationData 'appDatariconoscimentoSelezionatoInserimento'
	 * @param value
	 * @generated
	 */

	public void setAppDatariconoscimentoSelezionatoInserimento(
			it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento value) {
		getSession().put("appDatariconoscimentoSelezionatoInserimento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatariconoscimentoSelezionatoInserimento'
	 * @generated
	 */
	public it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento getAppDatariconoscimentoSelezionatoInserimento() {
		return (it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento) (getSession()
				.get("appDatariconoscimentoSelezionatoInserimento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidUnitaFormativaRiconoscimentoSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidUnitaFormativaRiconoscimentoSelezionata(java.lang.String value) {
		getSession().put("appDataidUnitaFormativaRiconoscimentoSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidUnitaFormativaRiconoscimentoSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataidUnitaFormativaRiconoscimentoSelezionata() {
		return (java.lang.String) (getSession().get("appDataidUnitaFormativaRiconoscimentoSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAltriCorsiDenominazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAltriCorsiDenominazioni(
			java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> value) {
		getSession().put("appDataelencoAltriCorsiDenominazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAltriCorsiDenominazioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> getAppDataelencoAltriCorsiDenominazioni() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale>) (getSession()
				.get("appDataelencoAltriCorsiDenominazioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoUnitaFormativaRiconoscimento'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoUnitaFormativaRiconoscimento(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoUnitaFormativaRiconoscimento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoUnitaFormativaRiconoscimento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoUnitaFormativaRiconoscimento() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoUnitaFormativaRiconoscimento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAgenziaFormativaRiconoscimentoSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAgenziaFormativaRiconoscimentoSelezionata(java.lang.String value) {
		getSession().put("appDataidAgenziaFormativaRiconoscimentoSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAgenziaFormativaRiconoscimentoSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataidAgenziaFormativaRiconoscimentoSelezionata() {
		return (java.lang.String) (getSession().get("appDataidAgenziaFormativaRiconoscimentoSelezionata"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoQualificheDenominazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoQualificheDenominazioni(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoQualificheDenominazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoQualificheDenominazioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoQualificheDenominazioni() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoQualificheDenominazioni"));
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
	 * imposta il valore dell' ApplicationData 'appDatamotivazioneRifiutoValidazione'
	 * @param value
	 * @generated
	 */

	public void setAppDatamotivazioneRifiutoValidazione(java.lang.String value) {
		getSession().put("appDatamotivazioneRifiutoValidazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamotivazioneRifiutoValidazione'
	 * @generated
	 */
	public java.lang.String getAppDatamotivazioneRifiutoValidazione() {
		return (java.lang.String) (getSession().get("appDatamotivazioneRifiutoValidazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoUnitaFormativaCorsiFinanziati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoUnitaFormativaCorsiFinanziati(
			java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoUnitaFormativaCorsiFinanziati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoUnitaFormativaCorsiFinanziati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription> getAppDataelencoUnitaFormativaCorsiFinanziati() {
		return (java.util.ArrayList<it.csi.taif.topforweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoUnitaFormativaCorsiFinanziati"));
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
	 * imposta il valore dell' ApplicationData 'appDataarrivoDaModifica'
	 * @param value
	 * @generated
	 */

	public void setAppDataarrivoDaModifica(java.lang.Boolean value) {
		getSession().put("appDataarrivoDaModifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataarrivoDaModifica'
	 * @generated
	 */
	public java.lang.Boolean getAppDataarrivoDaModifica() {
		return (java.lang.Boolean) (getSession().get("appDataarrivoDaModifica"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// FileUpload widg_updFileAttestatoCorsoRegione
	private File widgUpdFileAttestatoCorsoRegione; // The actual file(s)
	private String widgUpdFileAttestatoCorsoRegioneContentType; // The content type of the file(s) 
	private String widgUpdFileAttestatoCorsoRegioneFileName; // The uploaded file(s) name and path 

	public void setWidg_updFileAttestatoCorsoRegione(File value) {
		widgUpdFileAttestatoCorsoRegione = value;
	}
	@JSON(include = false)
	public File getWidg_updFileAttestatoCorsoRegione() {
		return widgUpdFileAttestatoCorsoRegione;
	}

	public void setWidg_updFileAttestatoCorsoRegioneContentType(String value) {
		widgUpdFileAttestatoCorsoRegioneContentType = value;
	}
	@JSON(include = false)
	public String getWidg_updFileAttestatoCorsoRegioneContentType() {
		return widgUpdFileAttestatoCorsoRegioneContentType;
	}

	public void setWidg_updFileAttestatoCorsoRegioneFileName(String value) {
		widgUpdFileAttestatoCorsoRegioneFileName = value;
	}
	@JSON(include = false)
	public String getWidg_updFileAttestatoCorsoRegioneFileName() {
		return widgUpdFileAttestatoCorsoRegioneFileName;
	}

	// Table tblInserimentoCorsiProfessionaliFinanziatiRegione

	private java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> widgTblInserimentoCorsiProfessionaliFinanziatiRegione;

	public void setWidg_tblInserimentoCorsiProfessionaliFinanziatiRegione(
			java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> value) {
		widgTblInserimentoCorsiProfessionaliFinanziatiRegione = value;
	}

	public java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> getWidg_tblInserimentoCorsiProfessionaliFinanziatiRegione() {
		return widgTblInserimentoCorsiProfessionaliFinanziatiRegione;
	}

	// FileUpload widg_updFileAttestatoAltriCorsi
	private File widgUpdFileAttestatoAltriCorsi; // The actual file(s)
	private String widgUpdFileAttestatoAltriCorsiContentType; // The content type of the file(s) 
	private String widgUpdFileAttestatoAltriCorsiFileName; // The uploaded file(s) name and path 

	public void setWidg_updFileAttestatoAltriCorsi(File value) {
		widgUpdFileAttestatoAltriCorsi = value;
	}
	@JSON(include = false)
	public File getWidg_updFileAttestatoAltriCorsi() {
		return widgUpdFileAttestatoAltriCorsi;
	}

	public void setWidg_updFileAttestatoAltriCorsiContentType(String value) {
		widgUpdFileAttestatoAltriCorsiContentType = value;
	}
	@JSON(include = false)
	public String getWidg_updFileAttestatoAltriCorsiContentType() {
		return widgUpdFileAttestatoAltriCorsiContentType;
	}

	public void setWidg_updFileAttestatoAltriCorsiFileName(String value) {
		widgUpdFileAttestatoAltriCorsiFileName = value;
	}
	@JSON(include = false)
	public String getWidg_updFileAttestatoAltriCorsiFileName() {
		return widgUpdFileAttestatoAltriCorsiFileName;
	}

	// Table tblInserimentoAltriCorsi

	private java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> widgTblInserimentoAltriCorsi;

	public void setWidg_tblInserimentoAltriCorsi(
			java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> value) {
		widgTblInserimentoAltriCorsi = value;
	}

	public java.util.ArrayList<it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale> getWidg_tblInserimentoAltriCorsi() {
		return widgTblInserimentoAltriCorsi;
	}

	// Table tblQualifiche

	private java.util.ArrayList<it.csi.taif.topforweb.dto.qualifica.Qualifica> widgTblQualifiche;

	public void setWidg_tblQualifiche(java.util.ArrayList<it.csi.taif.topforweb.dto.qualifica.Qualifica> value) {
		widgTblQualifiche = value;
	}

	public java.util.ArrayList<it.csi.taif.topforweb.dto.qualifica.Qualifica> getWidg_tblQualifiche() {
		return widgTblQualifiche;
	}

	// Table tblInserimentoRiconoscimenti

	private java.util.ArrayList<it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento> widgTblInserimentoRiconoscimenti;

	public void setWidg_tblInserimentoRiconoscimenti(
			java.util.ArrayList<it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento> value) {
		widgTblInserimentoRiconoscimenti = value;
	}

	public java.util.ArrayList<it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento> getWidg_tblInserimentoRiconoscimenti() {
		return widgTblInserimentoRiconoscimenti;
	}

}
