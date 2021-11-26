/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

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
 * logica di business associata alla Schermata [cpIstanzeTaglioPresentate]
 */
@Validation
public class CpIstanzeTaglioPresentateModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataattivitaUltimoAnno1'
	 * @param value
	 * @generated
	 */

	public void setAppDataattivitaUltimoAnno1(it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno1 value) {
		getSession().put("appDataattivitaUltimoAnno1", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataattivitaUltimoAnno1'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno1 getAppDataattivitaUltimoAnno1() {
		return (it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno1) (getSession().get("appDataattivitaUltimoAnno1"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatagestioneAttivitaUltimoAnno'
	 * @param value
	 * @generated
	 */

	public void setAppDatagestioneAttivitaUltimoAnno(it.csi.taif.taifweb.dto.domanda.GestioneAttivitaUltimoAnno value) {
		getSession().put("appDatagestioneAttivitaUltimoAnno", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatagestioneAttivitaUltimoAnno'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.GestioneAttivitaUltimoAnno getAppDatagestioneAttivitaUltimoAnno() {
		return (it.csi.taif.taifweb.dto.domanda.GestioneAttivitaUltimoAnno) (getSession()
				.get("appDatagestioneAttivitaUltimoAnno"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoUnitaMisura'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoUnitaMisura(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoUnitaMisura", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoUnitaMisura'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoUnitaMisura() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoUnitaMisura"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIstanzeTaglioPresentate'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIstanzeTaglioPresentate(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.IstanzaTaglioPresentata> value) {
		getSession().put("appDataelencoIstanzeTaglioPresentate", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIstanzeTaglioPresentate'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.IstanzaTaglioPresentata> getAppDataelencoIstanzeTaglioPresentate() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.IstanzaTaglioPresentata>) (getSession()
				.get("appDataelencoIstanzeTaglioPresentate"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidUnitaMisuraTagliIntercalariInRegioneSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidUnitaMisuraTagliIntercalariInRegioneSelezionato(java.lang.String value) {
		getSession().put("appDataidUnitaMisuraTagliIntercalariInRegioneSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidUnitaMisuraTagliIntercalariInRegioneSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidUnitaMisuraTagliIntercalariInRegioneSelezionato() {
		return (java.lang.String) (getSession().get("appDataidUnitaMisuraTagliIntercalariInRegioneSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato(java.lang.String value) {
		getSession().put("appDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato() {
		return (java.lang.String) (getSession().get("appDataidUnitaMisuraTaglioPioppetoInRegioneSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato(java.lang.String value) {
		getSession().put("appDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato() {
		return (java.lang.String) (getSession().get("appDataidUnitaMisuraTagliDiUtilizzazioneInRegioneSelezionato"));
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
	 * imposta il valore dell' ApplicationData 'appDatacodiceFiscale'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodiceFiscale(java.lang.String value) {
		getSession().put("appDatacodiceFiscale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodiceFiscale'
	 * @generated
	 */
	public java.lang.String getAppDatacodiceFiscale() {
		return (java.lang.String) (getSession().get("appDatacodiceFiscale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataisVolumeAcquisitoFromPrimpaForSrv'
	 * @param value
	 * @generated
	 */

	public void setAppDataisVolumeAcquisitoFromPrimpaForSrv(java.lang.Boolean value) {
		getSession().put("appDataisVolumeAcquisitoFromPrimpaForSrv", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisVolumeAcquisitoFromPrimpaForSrv'
	 * @generated
	 */
	public java.lang.Boolean getAppDataisVolumeAcquisitoFromPrimpaForSrv() {
		return (java.lang.Boolean) (getSession().get("appDataisVolumeAcquisitoFromPrimpaForSrv"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatavolumiAcquisitiPrimpaForSrv'
	 * @param value
	 * @generated
	 */

	public void setAppDatavolumiAcquisitiPrimpaForSrv(it.csi.taif.taifweb.dto.domanda.Intervento value) {
		getSession().put("appDatavolumiAcquisitiPrimpaForSrv", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatavolumiAcquisitiPrimpaForSrv'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.Intervento getAppDatavolumiAcquisitiPrimpaForSrv() {
		return (it.csi.taif.taifweb.dto.domanda.Intervento) (getSession().get("appDatavolumiAcquisitiPrimpaForSrv"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataanagraficaAziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataanagraficaAziendale(it.csi.taif.taifweb.dto.domanda.AnagraficaAziendale value) {
		getSession().put("appDataanagraficaAziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataanagraficaAziendale'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.AnagraficaAziendale getAppDataanagraficaAziendale() {
		return (it.csi.taif.taifweb.dto.domanda.AnagraficaAziendale) (getSession().get("appDataanagraficaAziendale"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tblElencoIstanzeTaglioPresentate

	private it.csi.taif.taifweb.dto.domanda.AziendaAAEP widgTblElencoIstanzeTaglioPresentate;

	public void setWidg_tblElencoIstanzeTaglioPresentate(it.csi.taif.taifweb.dto.domanda.AziendaAAEP value) {
		widgTblElencoIstanzeTaglioPresentate = value;
	}

	public it.csi.taif.taifweb.dto.domanda.AziendaAAEP getWidg_tblElencoIstanzeTaglioPresentate() {
		return widgTblElencoIstanzeTaglioPresentate;
	}

}
