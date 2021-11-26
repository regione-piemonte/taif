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
 * logica di business associata alla Schermata [CpDomanda]
 */
@Validation
public class CpDomandaModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatapartitaIva'
	 * @param value
	 * @generated
	 */

	public void setAppDatapartitaIva(java.lang.String value) {
		getSession().put("appDatapartitaIva", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapartitaIva'
	 * @generated
	 */
	public java.lang.String getAppDatapartitaIva() {
		return (java.lang.String) (getSession().get("appDatapartitaIva"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadescrizione'
	 * @param value
	 * @generated
	 */

	public void setAppDatadescrizione(java.lang.String value) {
		getSession().put("appDatadescrizione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadescrizione'
	 * @generated
	 */
	public java.lang.String getAppDatadescrizione() {
		return (java.lang.String) (getSession().get("appDatadescrizione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale(java.lang.String value) {
		getSession().put("appDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale'
	 * @generated
	 */
	public java.lang.String getAppDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale() {
		return (java.lang.String) (getSession().get("appDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAttivitaPrimariaDatiAnagraficiAnagrafeAnziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAttivitaPrimariaDatiAnagraficiAnagrafeAnziendale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoAttivitaPrimariaDatiAnagraficiAnagrafeAnziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAttivitaPrimariaDatiAnagraficiAnagrafeAnziendale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoAttivitaPrimariaDatiAnagraficiAnagrafeAnziendale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoAttivitaPrimariaDatiAnagraficiAnagrafeAnziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale(java.lang.String value) {
		getSession().put("appDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale'
	 * @generated
	 */
	public java.lang.String getAppDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale() {
		return (java.lang.String) (getSession().get("appDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale(java.lang.String value) {
		getSession().put("appDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale'
	 * @generated
	 */
	public java.lang.String getAppDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale() {
		return (java.lang.String) (getSession().get("appDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoFormeGiuridicheDatiAnagraficiAnagrafeAnziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoFormeGiuridicheDatiAnagraficiAnagrafeAnziendale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoFormeGiuridicheDatiAnagraficiAnagrafeAnziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoFormeGiuridicheDatiAnagraficiAnagrafeAnziendale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoFormeGiuridicheDatiAnagraficiAnagrafeAnziendale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoFormeGiuridicheDatiAnagraficiAnagrafeAnziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatanote'
	 * @param value
	 * @generated
	 */

	public void setAppDatanote(java.lang.String value) {
		getSession().put("appDatanote", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanote'
	 * @generated
	 */
	public java.lang.String getAppDatanote() {
		return (java.lang.String) (getSession().get("appDatanote"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale(java.lang.String value) {
		getSession().put("appDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale'
	 * @generated
	 */
	public java.lang.String getAppDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale() {
		return (java.lang.String) (getSession().get("appDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoProvinceCCIAADatiAnagraficiAnagrafeAnziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoProvinceCCIAADatiAnagraficiAnagrafeAnziendale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoProvinceCCIAADatiAnagraficiAnagrafeAnziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoProvinceCCIAADatiAnagraficiAnagrafeAnziendale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoProvinceCCIAADatiAnagraficiAnagrafeAnziendale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoProvinceCCIAADatiAnagraficiAnagrafeAnziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatanumeroCCIAA'
	 * @param value
	 * @generated
	 */

	public void setAppDatanumeroCCIAA(java.lang.String value) {
		getSession().put("appDatanumeroCCIAA", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanumeroCCIAA'
	 * @generated
	 */
	public java.lang.String getAppDatanumeroCCIAA() {
		return (java.lang.String) (getSession().get("appDatanumeroCCIAA"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapec'
	 * @param value
	 * @generated
	 */

	public void setAppDatapec(java.lang.String value) {
		getSession().put("appDatapec", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapec'
	 * @generated
	 */
	public java.lang.String getAppDatapec() {
		return (java.lang.String) (getSession().get("appDatapec"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataemail'
	 * @param value
	 * @generated
	 */

	public void setAppDataemail(java.lang.String value) {
		getSession().put("appDataemail", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataemail'
	 * @generated
	 */
	public java.lang.String getAppDataemail() {
		return (java.lang.String) (getSession().get("appDataemail"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatelefono'
	 * @param value
	 * @generated
	 */

	public void setAppDatatelefono(java.lang.String value) {
		getSession().put("appDatatelefono", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatelefono'
	 * @generated
	 */
	public java.lang.String getAppDatatelefono() {
		return (java.lang.String) (getSession().get("appDatatelefono"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacellulare'
	 * @param value
	 * @generated
	 */

	public void setAppDatacellulare(java.lang.String value) {
		getSession().put("appDatacellulare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacellulare'
	 * @generated
	 */
	public java.lang.String getAppDatacellulare() {
		return (java.lang.String) (getSession().get("appDatacellulare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatasitoInternet'
	 * @param value
	 * @generated
	 */

	public void setAppDatasitoInternet(java.lang.String value) {
		getSession().put("appDatasitoInternet", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasitoInternet'
	 * @generated
	 */
	public java.lang.String getAppDatasitoInternet() {
		return (java.lang.String) (getSession().get("appDatasitoInternet"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatasedeLegaleDatiAnagraficiAnagrafeAziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDatasedeLegaleDatiAnagraficiAnagrafeAziendale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Sede> value) {
		getSession().put("appDatasedeLegaleDatiAnagraficiAnagrafeAziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasedeLegaleDatiAnagraficiAnagrafeAziendale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Sede> getAppDatasedeLegaleDatiAnagraficiAnagrafeAziendale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Sede>) (getSession()
				.get("appDatasedeLegaleDatiAnagraficiAnagrafeAziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSediDatiAnagraficiAnagrafeAziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSediDatiAnagraficiAnagrafeAziendale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Sede> value) {
		getSession().put("appDataelencoSediDatiAnagraficiAnagrafeAziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSediDatiAnagraficiAnagrafeAziendale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Sede> getAppDataelencoSediDatiAnagraficiAnagrafeAziendale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Sede>) (getSession()
				.get("appDataelencoSediDatiAnagraficiAnagrafeAziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidSedeDatiAnagraficiAnagrafeAziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidSedeDatiAnagraficiAnagrafeAziendale(java.lang.String value) {
		getSession().put("appDataidSedeDatiAnagraficiAnagrafeAziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidSedeDatiAnagraficiAnagrafeAziendale'
	 * @generated
	 */
	public java.lang.String getAppDataidSedeDatiAnagraficiAnagrafeAziendale() {
		return (java.lang.String) (getSession().get("appDataidSedeDatiAnagraficiAnagrafeAziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamarcaDaBollo'
	 * @param value
	 * @generated
	 */

	public void setAppDatamarcaDaBollo(java.lang.String value) {
		getSession().put("appDatamarcaDaBollo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamarcaDaBollo'
	 * @generated
	 */
	public java.lang.String getAppDatamarcaDaBollo() {
		return (java.lang.String) (getSession().get("appDatamarcaDaBollo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoQualificheTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoQualificheTitolareRappresentanteLegale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoQualificheTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoQualificheTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoQualificheTitolareRappresentanteLegale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoQualificheTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoQualificheAltroTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoQualificheAltroTitolareRappresentanteLegale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoQualificheAltroTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoQualificheAltroTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoQualificheAltroTitolareRappresentanteLegale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoQualificheAltroTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCorsiSostenutiTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCorsiSostenutiTitolareRappresentanteLegale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoCorsiSostenutiTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCorsiSostenutiTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoCorsiSostenutiTitolareRappresentanteLegale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoCorsiSostenutiTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCorsiSostenutiAltroTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCorsiSostenutiAltroTitolareRappresentanteLegale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoCorsiSostenutiAltroTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCorsiSostenutiAltroTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoCorsiSostenutiAltroTitolareRappresentanteLegale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoCorsiSostenutiAltroTitolareRappresentanteLegale"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoCategorieImpresa'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCategorieImpresa(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.CategoriaImpresa> value) {
		getSession().put("appDataelencoCategorieImpresa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCategorieImpresa'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.CategoriaImpresa> getAppDataelencoCategorieImpresa() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.CategoriaImpresa>) (getSession()
				.get("appDataelencoCategorieImpresa"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidCategorieImpresaSelezionati'
	 * @param value
	 * @generated
	 */

	public void setAppDataidCategorieImpresaSelezionati(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataidCategorieImpresaSelezionati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidCategorieImpresaSelezionati'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataidCategorieImpresaSelezionati() {
		return (java.util.ArrayList<java.lang.String>) (getSession().get("appDataidCategorieImpresaSelezionati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAltriAlbi'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAltriAlbi(java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Albo> value) {
		getSession().put("appDataelencoAltriAlbi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAltriAlbi'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Albo> getAppDataelencoAltriAlbi() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Albo>) (getSession().get("appDataelencoAltriAlbi"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCertificazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCertificazioni(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Certificazione> value) {
		getSession().put("appDataelencoCertificazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCertificazioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Certificazione> getAppDataelencoCertificazioni() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Certificazione>) (getSession()
				.get("appDataelencoCertificazioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoFormeOrganizzative'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoFormeOrganizzative(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.FormaOrganizzativa> value) {
		getSession().put("appDataelencoFormeOrganizzative", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoFormeOrganizzative'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.FormaOrganizzativa> getAppDataelencoFormeOrganizzative() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.FormaOrganizzativa>) (getSession()
				.get("appDataelencoFormeOrganizzative"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidFormeOrganizzative'
	 * @param value
	 * @generated
	 */

	public void setAppDataidFormeOrganizzative(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataidFormeOrganizzative", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidFormeOrganizzative'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataidFormeOrganizzative() {
		return (java.util.ArrayList<java.lang.String>) (getSession().get("appDataidFormeOrganizzative"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoLavoriPA'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoLavoriPA(java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.LavoroPA> value) {
		getSession().put("appDataelencoLavoriPA", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoLavoriPA'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.LavoroPA> getAppDataelencoLavoriPA() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.LavoroPA>) (getSession()
				.get("appDataelencoLavoriPA"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoLegnamiAssortimentiTrattati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoLegnamiAssortimentiTrattati(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato> value) {
		getSession().put("appDataelencoLegnamiAssortimentiTrattati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoLegnamiAssortimentiTrattati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato> getAppDataelencoLegnamiAssortimentiTrattati() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato>) (getSession()
				.get("appDataelencoLegnamiAssortimentiTrattati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAttivitaUltimoAnno'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAttivitaUltimoAnno(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Attivita> value) {
		getSession().put("appDataelencoAttivitaUltimoAnno", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAttivitaUltimoAnno'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Attivita> getAppDataelencoAttivitaUltimoAnno() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Attivita>) (getSession()
				.get("appDataelencoAttivitaUltimoAnno"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAttivitaUltimoAnno'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAttivitaUltimoAnno(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataidAttivitaUltimoAnno", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAttivitaUltimoAnno'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataidAttivitaUltimoAnno() {
		return (java.util.ArrayList<java.lang.String>) (getSession().get("appDataidAttivitaUltimoAnno"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataattivitaUltimoAnnoSelezionate'
	 * @param value
	 * @generated
	 */

	public void setAppDataattivitaUltimoAnnoSelezionate(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Attivita> value) {
		getSession().put("appDataattivitaUltimoAnnoSelezionate", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataattivitaUltimoAnnoSelezionate'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Attivita> getAppDataattivitaUltimoAnnoSelezionate() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Attivita>) (getSession()
				.get("appDataattivitaUltimoAnnoSelezionate"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMaterialePropagazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMaterialePropagazione(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MaterialePropagazione> value) {
		getSession().put("appDataelencoMaterialePropagazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMaterialePropagazione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MaterialePropagazione> getAppDataelencoMaterialePropagazione() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MaterialePropagazione>) (getSession()
				.get("appDataelencoMaterialePropagazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidMaterialiPropagazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataidMaterialiPropagazione(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataidMaterialiPropagazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidMaterialiPropagazione'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataidMaterialiPropagazione() {
		return (java.util.ArrayList<java.lang.String>) (getSession().get("appDataidMaterialiPropagazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoArboricolturaDaLegno'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoArboricolturaDaLegno(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno> value) {
		getSession().put("appDataelencoArboricolturaDaLegno", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoArboricolturaDaLegno'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno> getAppDataelencoArboricolturaDaLegno() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno>) (getSession()
				.get("appDataelencoArboricolturaDaLegno"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCapannoni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCapannoni(java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Capannone> value) {
		getSession().put("appDataelencoCapannoni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCapannoni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Capannone> getAppDataelencoCapannoni() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Capannone>) (getSession()
				.get("appDataelencoCapannoni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoPiazzaliStoccaggio'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoPiazzaliStoccaggio(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PiazzaleStoccaggio> value) {
		getSession().put("appDataelencoPiazzaliStoccaggio", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoPiazzaliStoccaggio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PiazzaleStoccaggio> getAppDataelencoPiazzaliStoccaggio() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PiazzaleStoccaggio>) (getSession()
				.get("appDataelencoPiazzaliStoccaggio"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCaschiForestaliAttrezzature'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCaschiForestaliAttrezzature(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale> value) {
		getSession().put("appDataelencoCaschiForestaliAttrezzature", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCaschiForestaliAttrezzature'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale> getAppDataelencoCaschiForestaliAttrezzature() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale>) (getSession()
				.get("appDataelencoCaschiForestaliAttrezzature"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoPantaloniAntitaglioAttrezzature'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoPantaloniAntitaglioAttrezzature(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale> value) {
		getSession().put("appDataelencoPantaloniAntitaglioAttrezzature", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoPantaloniAntitaglioAttrezzature'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale> getAppDataelencoPantaloniAntitaglioAttrezzature() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale>) (getSession()
				.get("appDataelencoPantaloniAntitaglioAttrezzature"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoScarponiRinforzatiAttrezzature'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoScarponiRinforzatiAttrezzature(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale> value) {
		getSession().put("appDataelencoScarponiRinforzatiAttrezzature", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoScarponiRinforzatiAttrezzature'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale> getAppDataelencoScarponiRinforzatiAttrezzature() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale>) (getSession()
				.get("appDataelencoScarponiRinforzatiAttrezzature"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineCippatrici'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineCippatrici(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineCippatrici", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineCippatrici'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineCippatrici() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineCippatrici"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineGruACavo'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineGruACavo(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineGruACavo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineGruACavo'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineGruACavo() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineGruACavo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineMovimentoTerra'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineMovimentoTerra(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineMovimentoTerra", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineMovimentoTerra'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineMovimentoTerra() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineMovimentoTerra"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchinePle'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchinePle(java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchinePle", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchinePle'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchinePle() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchinePle"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineRimorchi'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineRimorchi(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineRimorchi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineRimorchi'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineRimorchi() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineRimorchi"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineSegheriaMobile'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineSegheriaMobile(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineSegheriaMobile", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineSegheriaMobile'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineSegheriaMobile() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineSegheriaMobile"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineSpeciali'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineSpeciali(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineSpeciali", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineSpeciali'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineSpeciali() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineSpeciali"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineTrattrici'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineTrattrici(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineTrattrici", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineTrattrici'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineTrattrici() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineTrattrici"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineTrinciaForestali'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineTrinciaForestali(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineTrinciaForestali", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineTrinciaForestali'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineTrinciaForestali() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineTrinciaForestali"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineVerricelli'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineVerricelli(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineVerricelli", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineVerricelli'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineVerricelli() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineVerricelli"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMezziDiTrasporto'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMezziDiTrasporto(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMezziDiTrasporto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMezziDiTrasporto'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMezziDiTrasporto() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMezziDiTrasporto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoPersonale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoPersonale(java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Personale> value) {
		getSession().put("appDataelencoPersonale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoPersonale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Personale> getAppDataelencoPersonale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.Personale>) (getSession()
				.get("appDataelencoPersonale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoPersonaleSuggerito'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoPersonaleSuggerito(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoPersonaleSuggerito", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoPersonaleSuggerito'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoPersonaleSuggerito() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoPersonaleSuggerito"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapersonaleDaCercare'
	 * @param value
	 * @generated
	 */

	public void setAppDatapersonaleDaCercare(it.csi.taif.taifweb.dto.common.CodeDescription value) {
		getSession().put("appDatapersonaleDaCercare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapersonaleDaCercare'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.common.CodeDescription getAppDatapersonaleDaCercare() {
		return (it.csi.taif.taifweb.dto.common.CodeDescription) (getSession().get("appDatapersonaleDaCercare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale(java.lang.String value) {
		getSession().put("appDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.lang.String getAppDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale() {
		return (java.lang.String) (getSession().get("appDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale(java.lang.String value) {
		getSession().put("appDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.lang.String getAppDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale() {
		return (java.lang.String) (getSession().get("appDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale"));
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

	/**
	 * imposta il valore dell' ApplicationData 'appDataaltroTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataaltroTitolareRappresentanteLegale(
			it.csi.taif.taifweb.dto.domanda.TitolareRappresentanteLegale value) {
		getSession().put("appDataaltroTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaltroTitolareRappresentanteLegale'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.TitolareRappresentanteLegale getAppDataaltroTitolareRappresentanteLegale() {
		return (it.csi.taif.taifweb.dto.domanda.TitolareRappresentanteLegale) (getSession()
				.get("appDataaltroTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDatatitolareRappresentanteLegale(
			it.csi.taif.taifweb.dto.domanda.TitolareRappresentanteLegale value) {
		getSession().put("appDatatitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatitolareRappresentanteLegale'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.TitolareRappresentanteLegale getAppDatatitolareRappresentanteLegale() {
		return (it.csi.taif.taifweb.dto.domanda.TitolareRappresentanteLegale) (getSession()
				.get("appDatatitolareRappresentanteLegale"));
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
	 * imposta il valore dell' ApplicationData 'appDatafatturatoCategorieDiImpresa'
	 * @param value
	 * @generated
	 */

	public void setAppDatafatturatoCategorieDiImpresa(
			it.csi.taif.taifweb.dto.domanda.FatturatoCategorieDiImpresa value) {
		getSession().put("appDatafatturatoCategorieDiImpresa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatafatturatoCategorieDiImpresa'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.FatturatoCategorieDiImpresa getAppDatafatturatoCategorieDiImpresa() {
		return (it.csi.taif.taifweb.dto.domanda.FatturatoCategorieDiImpresa) (getSession()
				.get("appDatafatturatoCategorieDiImpresa"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataassociazioniECertificazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataassociazioniECertificazioni(
			it.csi.taif.taifweb.dto.domanda.AssociazioniECertificazioni value) {
		getSession().put("appDataassociazioniECertificazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataassociazioniECertificazioni'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.AssociazioniECertificazioni getAppDataassociazioniECertificazioni() {
		return (it.csi.taif.taifweb.dto.domanda.AssociazioniECertificazioni) (getSession()
				.get("appDataassociazioniECertificazioni"));
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
	 * imposta il valore dell' ApplicationData 'appDataattivitaUltimoAnno2'
	 * @param value
	 * @generated
	 */

	public void setAppDataattivitaUltimoAnno2(it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno2 value) {
		getSession().put("appDataattivitaUltimoAnno2", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataattivitaUltimoAnno2'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno2 getAppDataattivitaUltimoAnno2() {
		return (it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno2) (getSession().get("appDataattivitaUltimoAnno2"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataattivitaUltimoAnno3'
	 * @param value
	 * @generated
	 */

	public void setAppDataattivitaUltimoAnno3(it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno3 value) {
		getSession().put("appDataattivitaUltimoAnno3", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataattivitaUltimoAnno3'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno3 getAppDataattivitaUltimoAnno3() {
		return (it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno3) (getSession().get("appDataattivitaUltimoAnno3"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataattivitaUltimoAnno4'
	 * @param value
	 * @generated
	 */

	public void setAppDataattivitaUltimoAnno4(it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno4 value) {
		getSession().put("appDataattivitaUltimoAnno4", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataattivitaUltimoAnno4'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno4 getAppDataattivitaUltimoAnno4() {
		return (it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno4) (getSession().get("appDataattivitaUltimoAnno4"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataattivitaUltimoAnno5'
	 * @param value
	 * @generated
	 */

	public void setAppDataattivitaUltimoAnno5(it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno5 value) {
		getSession().put("appDataattivitaUltimoAnno5", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataattivitaUltimoAnno5'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno5 getAppDataattivitaUltimoAnno5() {
		return (it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno5) (getSession().get("appDataattivitaUltimoAnno5"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataattivitaUltimoAnno6'
	 * @param value
	 * @generated
	 */

	public void setAppDataattivitaUltimoAnno6(it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno6 value) {
		getSession().put("appDataattivitaUltimoAnno6", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataattivitaUltimoAnno6'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno6 getAppDataattivitaUltimoAnno6() {
		return (it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno6) (getSession().get("appDataattivitaUltimoAnno6"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataattivitaUltimoAnno7'
	 * @param value
	 * @generated
	 */

	public void setAppDataattivitaUltimoAnno7(it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno7 value) {
		getSession().put("appDataattivitaUltimoAnno7", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataattivitaUltimoAnno7'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno7 getAppDataattivitaUltimoAnno7() {
		return (it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno7) (getSession().get("appDataattivitaUltimoAnno7"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataattivitaUltimoAnno8'
	 * @param value
	 * @generated
	 */

	public void setAppDataattivitaUltimoAnno8(it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno8 value) {
		getSession().put("appDataattivitaUltimoAnno8", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataattivitaUltimoAnno8'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno8 getAppDataattivitaUltimoAnno8() {
		return (it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno8) (getSession().get("appDataattivitaUltimoAnno8"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataattivitaUltimoAnno9'
	 * @param value
	 * @generated
	 */

	public void setAppDataattivitaUltimoAnno9(it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno9 value) {
		getSession().put("appDataattivitaUltimoAnno9", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataattivitaUltimoAnno9'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno9 getAppDataattivitaUltimoAnno9() {
		return (it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno9) (getSession().get("appDataattivitaUltimoAnno9"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatagestioneMacchineMezzi'
	 * @param value
	 * @generated
	 */

	public void setAppDatagestioneMacchineMezzi(it.csi.taif.taifweb.dto.domanda.GestioneMacchineMezzi value) {
		getSession().put("appDatagestioneMacchineMezzi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatagestioneMacchineMezzi'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.GestioneMacchineMezzi getAppDatagestioneMacchineMezzi() {
		return (it.csi.taif.taifweb.dto.domanda.GestioneMacchineMezzi) (getSession()
				.get("appDatagestioneMacchineMezzi"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatagestioneFatturatoCategoriaDiImpresa'
	 * @param value
	 * @generated
	 */

	public void setAppDatagestioneFatturatoCategoriaDiImpresa(
			it.csi.taif.taifweb.dto.domanda.GestioneFatturatoCategoriaDiImpresa value) {
		getSession().put("appDatagestioneFatturatoCategoriaDiImpresa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatagestioneFatturatoCategoriaDiImpresa'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.GestioneFatturatoCategoriaDiImpresa getAppDatagestioneFatturatoCategoriaDiImpresa() {
		return (it.csi.taif.taifweb.dto.domanda.GestioneFatturatoCategoriaDiImpresa) (getSession()
				.get("appDatagestioneFatturatoCategoriaDiImpresa"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale(java.lang.String value) {
		getSession().put("appDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.lang.String getAppDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale() {
		return (java.lang.String) (getSession()
				.get("appDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale(java.lang.String value) {
		getSession().put("appDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.lang.String getAppDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale() {
		return (java.lang.String) (getSession()
				.get("appDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuneNascitaAltroTitolareRappresentanteLegaleDaCercare'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuneNascitaAltroTitolareRappresentanteLegaleDaCercare(
			it.csi.taif.taifweb.dto.common.CodeDescription value) {
		getSession().put("appDatacomuneNascitaAltroTitolareRappresentanteLegaleDaCercare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuneNascitaAltroTitolareRappresentanteLegaleDaCercare'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.common.CodeDescription getAppDatacomuneNascitaAltroTitolareRappresentanteLegaleDaCercare() {
		return (it.csi.taif.taifweb.dto.common.CodeDescription) (getSession()
				.get("appDatacomuneNascitaAltroTitolareRappresentanteLegaleDaCercare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuneNascitaTitolareRappresentanteLegaleDaCercare'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuneNascitaTitolareRappresentanteLegaleDaCercare(
			it.csi.taif.taifweb.dto.common.CodeDescription value) {
		getSession().put("appDatacomuneNascitaTitolareRappresentanteLegaleDaCercare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuneNascitaTitolareRappresentanteLegaleDaCercare'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.common.CodeDescription getAppDatacomuneNascitaTitolareRappresentanteLegaleDaCercare() {
		return (it.csi.taif.taifweb.dto.common.CodeDescription) (getSession()
				.get("appDatacomuneNascitaTitolareRappresentanteLegaleDaCercare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuneResidenzaAltroTitolareRappresentanteLegaleDaCercare'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuneResidenzaAltroTitolareRappresentanteLegaleDaCercare(
			it.csi.taif.taifweb.dto.common.CodeDescription value) {
		getSession().put("appDatacomuneResidenzaAltroTitolareRappresentanteLegaleDaCercare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuneResidenzaAltroTitolareRappresentanteLegaleDaCercare'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.common.CodeDescription getAppDatacomuneResidenzaAltroTitolareRappresentanteLegaleDaCercare() {
		return (it.csi.taif.taifweb.dto.common.CodeDescription) (getSession()
				.get("appDatacomuneResidenzaAltroTitolareRappresentanteLegaleDaCercare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuneResidenzaTitolareRappresentanteLegaleDaCercare'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuneResidenzaTitolareRappresentanteLegaleDaCercare(
			it.csi.taif.taifweb.dto.common.CodeDescription value) {
		getSession().put("appDatacomuneResidenzaTitolareRappresentanteLegaleDaCercare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuneResidenzaTitolareRappresentanteLegaleDaCercare'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.common.CodeDescription getAppDatacomuneResidenzaTitolareRappresentanteLegaleDaCercare() {
		return (it.csi.taif.taifweb.dto.common.CodeDescription) (getSession()
				.get("appDatacomuneResidenzaTitolareRappresentanteLegaleDaCercare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniNascitaAltroTitolareRappresentante'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniNascitaAltroTitolareRappresentante(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniNascitaAltroTitolareRappresentante", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniNascitaAltroTitolareRappresentante'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoComuniNascitaAltroTitolareRappresentante() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniNascitaAltroTitolareRappresentante"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniNascitaTitolareRappresentante'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniNascitaTitolareRappresentante(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniNascitaTitolareRappresentante", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniNascitaTitolareRappresentante'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoComuniNascitaTitolareRappresentante() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniNascitaTitolareRappresentante"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniResidenzaAltroTitolareRappresentante'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniResidenzaAltroTitolareRappresentante(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniResidenzaAltroTitolareRappresentante", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniResidenzaAltroTitolareRappresentante'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoComuniResidenzaAltroTitolareRappresentante() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniResidenzaAltroTitolareRappresentante"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniResidenzaTitolareRappresentante'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniResidenzaTitolareRappresentante(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniResidenzaTitolareRappresentante", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniResidenzaTitolareRappresentante'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoComuniResidenzaTitolareRappresentante() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniResidenzaTitolareRappresentante"));
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
	 * imposta il valore dell' ApplicationData 'appDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale(java.lang.String value) {
		getSession().put("appDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.lang.String getAppDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale() {
		return (java.lang.String) (getSession()
				.get("appDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale(java.lang.String value) {
		getSession().put("appDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.lang.String getAppDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale() {
		return (java.lang.String) (getSession()
				.get("appDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale(java.lang.String value) {
		getSession().put("appDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.lang.String getAppDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale() {
		return (java.lang.String) (getSession()
				.get("appDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale(java.lang.String value) {
		getSession().put("appDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.lang.String getAppDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale() {
		return (java.lang.String) (getSession()
				.get("appDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale"));
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
	 * imposta il valore dell' ApplicationData 'appDatasedeLegaleAnagrafeAziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDatasedeLegaleAnagrafeAziendale(it.csi.taif.taifweb.dto.domanda.Sede value) {
		getSession().put("appDatasedeLegaleAnagrafeAziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasedeLegaleAnagrafeAziendale'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.Sede getAppDatasedeLegaleAnagrafeAziendale() {
		return (it.csi.taif.taifweb.dto.domanda.Sede) (getSession().get("appDatasedeLegaleAnagrafeAziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale(java.lang.String value) {
		getSession().put("appDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale'
	 * @generated
	 */
	public java.lang.String getAppDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale() {
		return (java.lang.String) (getSession().get("appDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniDatiAnagraficiAnagrafeAziendale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniDatiAnagraficiAnagrafeAziendale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniDatiAnagraficiAnagrafeAziendale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniDatiAnagraficiAnagrafeAziendale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoComuniDatiAnagraficiAnagrafeAziendale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniDatiAnagraficiAnagrafeAziendale"));
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
	 * imposta il valore dell' ApplicationData 'appDataidAttivitaUltimoAnnoFr'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAttivitaUltimoAnnoFr(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataidAttivitaUltimoAnnoFr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAttivitaUltimoAnnoFr'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataidAttivitaUltimoAnnoFr() {
		return (java.util.ArrayList<java.lang.String>) (getSession().get("appDataidAttivitaUltimoAnnoFr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAttivitaUltimoAnnoFr'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAttivitaUltimoAnnoFr(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.DettaglioAttivitaUltimoAnnoFr> value) {
		getSession().put("appDataelencoAttivitaUltimoAnnoFr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAttivitaUltimoAnnoFr'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.DettaglioAttivitaUltimoAnnoFr> getAppDataelencoAttivitaUltimoAnnoFr() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.DettaglioAttivitaUltimoAnnoFr>) (getSession()
				.get("appDataelencoAttivitaUltimoAnnoFr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapercentualeCommercioFr'
	 * @param value
	 * @generated
	 */

	public void setAppDatapercentualeCommercioFr(java.lang.Integer value) {
		getSession().put("appDatapercentualeCommercioFr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapercentualeCommercioFr'
	 * @generated
	 */
	public java.lang.Integer getAppDatapercentualeCommercioFr() {
		return (java.lang.Integer) (getSession().get("appDatapercentualeCommercioFr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAltroPersonaleTipoContrattoFr'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAltroPersonaleTipoContrattoFr(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr> value) {
		getSession().put("appDataelencoAltroPersonaleTipoContrattoFr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAltroPersonaleTipoContrattoFr'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr> getAppDataelencoAltroPersonaleTipoContrattoFr() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr>) (getSession()
				.get("appDataelencoAltroPersonaleTipoContrattoFr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAltroPersonaleTipoMansioneFr'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAltroPersonaleTipoMansioneFr(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr> value) {
		getSession().put("appDataelencoAltroPersonaleTipoMansioneFr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAltroPersonaleTipoMansioneFr'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr> getAppDataelencoAltroPersonaleTipoMansioneFr() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr>) (getSession()
				.get("appDataelencoAltroPersonaleTipoMansioneFr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatagestioneAltroPersonaleFr'
	 * @param value
	 * @generated
	 */

	public void setAppDatagestioneAltroPersonaleFr(it.csi.taif.taifweb.dto.domanda.GestionePersonaleFr value) {
		getSession().put("appDatagestioneAltroPersonaleFr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatagestioneAltroPersonaleFr'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.GestionePersonaleFr getAppDatagestioneAltroPersonaleFr() {
		return (it.csi.taif.taifweb.dto.domanda.GestionePersonaleFr) (getSession()
				.get("appDatagestioneAltroPersonaleFr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineGrumier'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineGrumier(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineGrumier", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineGrumier'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineGrumier() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineGrumier"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineMovimentoTerraFr'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineMovimentoTerraFr(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineMovimentoTerraFr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineMovimentoTerraFr'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineMovimentoTerraFr() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineMovimentoTerraFr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineRimorchiFr'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineRimorchiFr(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineRimorchiFr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineRimorchiFr'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineRimorchiFr() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineRimorchiFr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineSemi'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineSemi(java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineSemi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineSemi'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineSemi() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineSemi"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMacchineSpecialiFr'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMacchineSpecialiFr(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoMacchineSpecialiFr", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMacchineSpecialiFr'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoMacchineSpecialiFr() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoMacchineSpecialiFr"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidCategorieImpresaSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidCategorieImpresaSelezionato(java.lang.String value) {
		getSession().put("appDataidCategorieImpresaSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidCategorieImpresaSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidCategorieImpresaSelezionato() {
		return (java.lang.String) (getSession().get("appDataidCategorieImpresaSelezionato"));
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
	 * imposta il valore dell' ApplicationData 'appDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato(java.lang.String value) {
		getSession().put("appDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato() {
		return (java.lang.String) (getSession().get("appDataidUnitaMisuraTagliDiUtilizzazioneFuoriRegioneSelezionato"));
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
	 * imposta il valore dell' ApplicationData 'appDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato(java.lang.String value) {
		getSession().put("appDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato() {
		return (java.lang.String) (getSession().get("appDataidUnitaMisuraTagliIntercalariFuoriRegioneSelezionato"));
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
	 * imposta il valore dell' ApplicationData 'appDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato(java.lang.String value) {
		getSession().put("appDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato() {
		return (java.lang.String) (getSession().get("appDataidUnitaMisuraTaglioPioppetoFuoriRegioneSelezionato"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoAltriMezzi'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAltriMezzi(java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> value) {
		getSession().put("appDataelencoAltriMezzi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAltriMezzi'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo> getAppDataelencoAltriMezzi() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MacchinaMezzo>) (getSession()
				.get("appDataelencoAltriMezzi"));
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
	 * imposta il valore dell' ApplicationData 'appDataidSoggettoGestore'
	 * @param value
	 * @generated
	 */

	public void setAppDataidSoggettoGestore(java.lang.String value) {
		getSession().put("appDataidSoggettoGestore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidSoggettoGestore'
	 * @generated
	 */
	public java.lang.String getAppDataidSoggettoGestore() {
		return (java.lang.String) (getSession().get("appDataidSoggettoGestore"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoRiconiscimentiAltroTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoRiconiscimentiAltroTitolareRappresentanteLegale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoRiconiscimentiAltroTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoRiconiscimentiAltroTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoRiconiscimentiAltroTitolareRappresentanteLegale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoRiconiscimentiAltroTitolareRappresentanteLegale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoRiconiscimentiTitolareRappresentanteLegale'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoRiconiscimentiTitolareRappresentanteLegale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoRiconiscimentiTitolareRappresentanteLegale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoRiconiscimentiTitolareRappresentanteLegale'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoRiconiscimentiTitolareRappresentanteLegale() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoRiconiscimentiTitolareRappresentanteLegale"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// RadioButtons rbsDatiAnagraficiAltreSedi2

	private java.lang.String widgRbsDatiAnagraficiAltreSedi2;

	public void setWidg_rbsDatiAnagraficiAltreSedi2(java.lang.String value) {
		widgRbsDatiAnagraficiAltreSedi2 = value;
	}

	public java.lang.String getWidg_rbsDatiAnagraficiAltreSedi2() {
		return widgRbsDatiAnagraficiAltreSedi2;
	}

	// Table tblDatiAnagraficiSedi

	private it.csi.taif.taifweb.dto.domanda.Sede widgTblDatiAnagraficiSedi;

	public void setWidg_tblDatiAnagraficiSedi(it.csi.taif.taifweb.dto.domanda.Sede value) {
		widgTblDatiAnagraficiSedi = value;
	}

	public it.csi.taif.taifweb.dto.domanda.Sede getWidg_tblDatiAnagraficiSedi() {
		return widgTblDatiAnagraficiSedi;
	}

	// Table tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti

	private it.csi.taif.taifweb.dto.common.CodeDescription widgTblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti;

	public void setWidg_tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti(
			it.csi.taif.taifweb.dto.common.CodeDescription value) {
		widgTblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti = value;
	}

	public it.csi.taif.taifweb.dto.common.CodeDescription getWidg_tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti() {
		return widgTblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti;
	}

	// Table tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche

	private it.csi.taif.taifweb.dto.common.CodeDescription widgTblDatiAnagraficiTitolareRappresentanteLegaleQualifiche;

	public void setWidg_tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche(
			it.csi.taif.taifweb.dto.common.CodeDescription value) {
		widgTblDatiAnagraficiTitolareRappresentanteLegaleQualifiche = value;
	}

	public it.csi.taif.taifweb.dto.common.CodeDescription getWidg_tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche() {
		return widgTblDatiAnagraficiTitolareRappresentanteLegaleQualifiche;
	}

	// Table tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti

	private it.csi.taif.taifweb.dto.common.CodeDescription widgTblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti;

	public void setWidg_tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti(
			it.csi.taif.taifweb.dto.common.CodeDescription value) {
		widgTblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti = value;
	}

	public it.csi.taif.taifweb.dto.common.CodeDescription getWidg_tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti() {
		return widgTblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti;
	}

	// RadioButtons rbsDatiAnagraficiAltroConducente

	private java.lang.String widgRbsDatiAnagraficiAltroConducente;

	public void setWidg_rbsDatiAnagraficiAltroConducente(java.lang.String value) {
		widgRbsDatiAnagraficiAltroConducente = value;
	}

	public java.lang.String getWidg_rbsDatiAnagraficiAltroConducente() {
		return widgRbsDatiAnagraficiAltroConducente;
	}

	// Table tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti

	private it.csi.taif.taifweb.dto.common.CodeDescription widgTblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti;

	public void setWidg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti(
			it.csi.taif.taifweb.dto.common.CodeDescription value) {
		widgTblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti = value;
	}

	public it.csi.taif.taifweb.dto.common.CodeDescription getWidg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti() {
		return widgTblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti;
	}

	// Table tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche

	private it.csi.taif.taifweb.dto.common.CodeDescription widgTblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche;

	public void setWidg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche(
			it.csi.taif.taifweb.dto.common.CodeDescription value) {
		widgTblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche = value;
	}

	public it.csi.taif.taifweb.dto.common.CodeDescription getWidg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche() {
		return widgTblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche;
	}

	// Table tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti

	private it.csi.taif.taifweb.dto.common.CodeDescription widgTblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti;

	public void setWidg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti(
			it.csi.taif.taifweb.dto.common.CodeDescription value) {
		widgTblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti = value;
	}

	public it.csi.taif.taifweb.dto.common.CodeDescription getWidg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti() {
		return widgTblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti;
	}

	// RadioButtons rbsDatiSocioEconomiciAltriAlbi

	private java.lang.String widgRbsDatiSocioEconomiciAltriAlbi;

	public void setWidg_rbsDatiSocioEconomiciAltriAlbi(java.lang.String value) {
		widgRbsDatiSocioEconomiciAltriAlbi = value;
	}

	public java.lang.String getWidg_rbsDatiSocioEconomiciAltriAlbi() {
		return widgRbsDatiSocioEconomiciAltriAlbi;
	}

	// Table tbDatiSocioEconomiciAltriAlbi

	private it.csi.taif.taifweb.dto.domanda.Albo widgTbDatiSocioEconomiciAltriAlbi;

	public void setWidg_tbDatiSocioEconomiciAltriAlbi(it.csi.taif.taifweb.dto.domanda.Albo value) {
		widgTbDatiSocioEconomiciAltriAlbi = value;
	}

	public it.csi.taif.taifweb.dto.domanda.Albo getWidg_tbDatiSocioEconomiciAltriAlbi() {
		return widgTbDatiSocioEconomiciAltriAlbi;
	}

	// RadioButtons rbsDatiSocioEconomiciCertificazioniQualitaProcesso

	private java.lang.String widgRbsDatiSocioEconomiciCertificazioniQualitaProcesso;

	public void setWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso(java.lang.String value) {
		widgRbsDatiSocioEconomiciCertificazioniQualitaProcesso = value;
	}

	public java.lang.String getWidg_rbsDatiSocioEconomiciCertificazioniQualitaProcesso() {
		return widgRbsDatiSocioEconomiciCertificazioniQualitaProcesso;
	}

	// Table tbDatiSocioEconomiciCertificazioni

	private it.csi.taif.taifweb.dto.domanda.Certificazione widgTbDatiSocioEconomiciCertificazioni;

	public void setWidg_tbDatiSocioEconomiciCertificazioni(it.csi.taif.taifweb.dto.domanda.Certificazione value) {
		widgTbDatiSocioEconomiciCertificazioni = value;
	}

	public it.csi.taif.taifweb.dto.domanda.Certificazione getWidg_tbDatiSocioEconomiciCertificazioni() {
		return widgTbDatiSocioEconomiciCertificazioni;
	}

	// CheckBox chbAttivitaUltimoAnno1

	private boolean widgChbAttivitaUltimoAnno1;

	public void setWidg_chbAttivitaUltimoAnno1(boolean value) {
		widgChbAttivitaUltimoAnno1 = value;
	}

	public boolean getWidg_chbAttivitaUltimoAnno1() {
		return widgChbAttivitaUltimoAnno1;
	}

	// CheckBox chbAttivitaUltimoAnno2

	private boolean widgChbAttivitaUltimoAnno2;

	public void setWidg_chbAttivitaUltimoAnno2(boolean value) {
		widgChbAttivitaUltimoAnno2 = value;
	}

	public boolean getWidg_chbAttivitaUltimoAnno2() {
		return widgChbAttivitaUltimoAnno2;
	}

	// CheckBox chbAttivitaUltimoAnno3

	private boolean widgChbAttivitaUltimoAnno3;

	public void setWidg_chbAttivitaUltimoAnno3(boolean value) {
		widgChbAttivitaUltimoAnno3 = value;
	}

	public boolean getWidg_chbAttivitaUltimoAnno3() {
		return widgChbAttivitaUltimoAnno3;
	}

	// CheckBox chbAttivitaUltimoAnno4

	private boolean widgChbAttivitaUltimoAnno4;

	public void setWidg_chbAttivitaUltimoAnno4(boolean value) {
		widgChbAttivitaUltimoAnno4 = value;
	}

	public boolean getWidg_chbAttivitaUltimoAnno4() {
		return widgChbAttivitaUltimoAnno4;
	}

	// CheckBox chbAttivitaUltimoAnno5

	private boolean widgChbAttivitaUltimoAnno5;

	public void setWidg_chbAttivitaUltimoAnno5(boolean value) {
		widgChbAttivitaUltimoAnno5 = value;
	}

	public boolean getWidg_chbAttivitaUltimoAnno5() {
		return widgChbAttivitaUltimoAnno5;
	}

	// Table tblAttivitaUltimoAnno5

	private it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno widgTblAttivitaUltimoAnno5;

	public void setWidg_tblAttivitaUltimoAnno5(it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno value) {
		widgTblAttivitaUltimoAnno5 = value;
	}

	public it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno getWidg_tblAttivitaUltimoAnno5() {
		return widgTblAttivitaUltimoAnno5;
	}

	// CheckBox chbAttivitaUltimoAnno6

	private boolean widgChbAttivitaUltimoAnno6;

	public void setWidg_chbAttivitaUltimoAnno6(boolean value) {
		widgChbAttivitaUltimoAnno6 = value;
	}

	public boolean getWidg_chbAttivitaUltimoAnno6() {
		return widgChbAttivitaUltimoAnno6;
	}

	// CheckBox chbAttivitaUltimoAnno7

	private boolean widgChbAttivitaUltimoAnno7;

	public void setWidg_chbAttivitaUltimoAnno7(boolean value) {
		widgChbAttivitaUltimoAnno7 = value;
	}

	public boolean getWidg_chbAttivitaUltimoAnno7() {
		return widgChbAttivitaUltimoAnno7;
	}

	// CheckBox chbAttivitaUltimoAnno8

	private boolean widgChbAttivitaUltimoAnno8;

	public void setWidg_chbAttivitaUltimoAnno8(boolean value) {
		widgChbAttivitaUltimoAnno8 = value;
	}

	public boolean getWidg_chbAttivitaUltimoAnno8() {
		return widgChbAttivitaUltimoAnno8;
	}

	// CheckBox chbAttivitaUltimoAnno9

	private boolean widgChbAttivitaUltimoAnno9;

	public void setWidg_chbAttivitaUltimoAnno9(boolean value) {
		widgChbAttivitaUltimoAnno9 = value;
	}

	public boolean getWidg_chbAttivitaUltimoAnno9() {
		return widgChbAttivitaUltimoAnno9;
	}

	// RadioButtons rbsAttivitaLavoriPA

	private java.lang.String widgRbsAttivitaLavoriPA;

	public void setWidg_rbsAttivitaLavoriPA(java.lang.String value) {
		widgRbsAttivitaLavoriPA = value;
	}

	public java.lang.String getWidg_rbsAttivitaLavoriPA() {
		return widgRbsAttivitaLavoriPA;
	}

	// Table tbAttivitaLavoriPA

	private it.csi.taif.taifweb.dto.domanda.LavoroPA widgTbAttivitaLavoriPA;

	public void setWidg_tbAttivitaLavoriPA(it.csi.taif.taifweb.dto.domanda.LavoroPA value) {
		widgTbAttivitaLavoriPA = value;
	}

	public it.csi.taif.taifweb.dto.domanda.LavoroPA getWidg_tbAttivitaLavoriPA() {
		return widgTbAttivitaLavoriPA;
	}

	// RadioButtons rbsAttivitaLegname

	private java.lang.String widgRbsAttivitaLegname;

	public void setWidg_rbsAttivitaLegname(java.lang.String value) {
		widgRbsAttivitaLegname = value;
	}

	public java.lang.String getWidg_rbsAttivitaLegname() {
		return widgRbsAttivitaLegname;
	}

	// Table tbAttivitaLegname

	private it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato widgTbAttivitaLegname;

	public void setWidg_tbAttivitaLegname(it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato value) {
		widgTbAttivitaLegname = value;
	}

	public it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato getWidg_tbAttivitaLegname() {
		return widgTbAttivitaLegname;
	}

	// Table tbAttivitaLegnameFr

	private it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato widgTbAttivitaLegnameFr;

	public void setWidg_tbAttivitaLegnameFr(it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato value) {
		widgTbAttivitaLegnameFr = value;
	}

	public it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato getWidg_tbAttivitaLegnameFr() {
		return widgTbAttivitaLegnameFr;
	}

	// CheckBox chbStruttureCapannoni

	private boolean widgChbStruttureCapannoni;

	public void setWidg_chbStruttureCapannoni(boolean value) {
		widgChbStruttureCapannoni = value;
	}

	public boolean getWidg_chbStruttureCapannoni() {
		return widgChbStruttureCapannoni;
	}

	// Table tblStruttureCapannoni

	private it.csi.taif.taifweb.dto.domanda.Capannone widgTblStruttureCapannoni;

	public void setWidg_tblStruttureCapannoni(it.csi.taif.taifweb.dto.domanda.Capannone value) {
		widgTblStruttureCapannoni = value;
	}

	public it.csi.taif.taifweb.dto.domanda.Capannone getWidg_tblStruttureCapannoni() {
		return widgTblStruttureCapannoni;
	}

	// CheckBox chbStrutturePiazzaliStoccaggio

	private boolean widgChbStrutturePiazzaliStoccaggio;

	public void setWidg_chbStrutturePiazzaliStoccaggio(boolean value) {
		widgChbStrutturePiazzaliStoccaggio = value;
	}

	public boolean getWidg_chbStrutturePiazzaliStoccaggio() {
		return widgChbStrutturePiazzaliStoccaggio;
	}

	// Table tblStrutturePiazzaliStoccaggio

	private it.csi.taif.taifweb.dto.domanda.Capannone widgTblStrutturePiazzaliStoccaggio;

	public void setWidg_tblStrutturePiazzaliStoccaggio(it.csi.taif.taifweb.dto.domanda.Capannone value) {
		widgTblStrutturePiazzaliStoccaggio = value;
	}

	public it.csi.taif.taifweb.dto.domanda.Capannone getWidg_tblStrutturePiazzaliStoccaggio() {
		return widgTblStrutturePiazzaliStoccaggio;
	}

	// CheckBox chbAttrezzatureCascoForestale

	private boolean widgChbAttrezzatureCascoForestale;

	public void setWidg_chbAttrezzatureCascoForestale(boolean value) {
		widgChbAttrezzatureCascoForestale = value;
	}

	public boolean getWidg_chbAttrezzatureCascoForestale() {
		return widgChbAttrezzatureCascoForestale;
	}

	// Table tblAttrezzatureCascoForestale

	private it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale widgTblAttrezzatureCascoForestale;

	public void setWidg_tblAttrezzatureCascoForestale(
			it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale value) {
		widgTblAttrezzatureCascoForestale = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale getWidg_tblAttrezzatureCascoForestale() {
		return widgTblAttrezzatureCascoForestale;
	}

	// CheckBox chbAttrezzatureScarponiRinforzati

	private boolean widgChbAttrezzatureScarponiRinforzati;

	public void setWidg_chbAttrezzatureScarponiRinforzati(boolean value) {
		widgChbAttrezzatureScarponiRinforzati = value;
	}

	public boolean getWidg_chbAttrezzatureScarponiRinforzati() {
		return widgChbAttrezzatureScarponiRinforzati;
	}

	// Table tblAttrezzatureScarponiRinforzati

	private it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale widgTblAttrezzatureScarponiRinforzati;

	public void setWidg_tblAttrezzatureScarponiRinforzati(
			it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale value) {
		widgTblAttrezzatureScarponiRinforzati = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale getWidg_tblAttrezzatureScarponiRinforzati() {
		return widgTblAttrezzatureScarponiRinforzati;
	}

	// CheckBox chbAttrezzaturePantaloniAntitaglio

	private boolean widgChbAttrezzaturePantaloniAntitaglio;

	public void setWidg_chbAttrezzaturePantaloniAntitaglio(boolean value) {
		widgChbAttrezzaturePantaloniAntitaglio = value;
	}

	public boolean getWidg_chbAttrezzaturePantaloniAntitaglio() {
		return widgChbAttrezzaturePantaloniAntitaglio;
	}

	// Table tblAttrezzaturePantaloniAntitaglio

	private it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale widgTblAttrezzaturePantaloniAntitaglio;

	public void setWidg_tblAttrezzaturePantaloniAntitaglio(
			it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale value) {
		widgTblAttrezzaturePantaloniAntitaglio = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale getWidg_tblAttrezzaturePantaloniAntitaglio() {
		return widgTblAttrezzaturePantaloniAntitaglio;
	}

	// CheckBox chbAttrezzatureMacchinaTrattrici

	private boolean widgChbAttrezzatureMacchinaTrattrici;

	public void setWidg_chbAttrezzatureMacchinaTrattrici(boolean value) {
		widgChbAttrezzatureMacchinaTrattrici = value;
	}

	public boolean getWidg_chbAttrezzatureMacchinaTrattrici() {
		return widgChbAttrezzatureMacchinaTrattrici;
	}

	// Table tblMacchinaTrattrici

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchinaTrattrici;

	public void setWidg_tblMacchinaTrattrici(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchinaTrattrici = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchinaTrattrici() {
		return widgTblMacchinaTrattrici;
	}

	// CheckBox chbAttrezzatureMacchineSpeciali

	private boolean widgChbAttrezzatureMacchineSpeciali;

	public void setWidg_chbAttrezzatureMacchineSpeciali(boolean value) {
		widgChbAttrezzatureMacchineSpeciali = value;
	}

	public boolean getWidg_chbAttrezzatureMacchineSpeciali() {
		return widgChbAttrezzatureMacchineSpeciali;
	}

	// Table tblMacchineSpeciali

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchineSpeciali;

	public void setWidg_tblMacchineSpeciali(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchineSpeciali = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchineSpeciali() {
		return widgTblMacchineSpeciali;
	}

	// CheckBox chbAttrezzatureMacchineMovimentoATerra

	private boolean widgChbAttrezzatureMacchineMovimentoATerra;

	public void setWidg_chbAttrezzatureMacchineMovimentoATerra(boolean value) {
		widgChbAttrezzatureMacchineMovimentoATerra = value;
	}

	public boolean getWidg_chbAttrezzatureMacchineMovimentoATerra() {
		return widgChbAttrezzatureMacchineMovimentoATerra;
	}

	// Table tblMacchineMovimentoATerra

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchineMovimentoATerra;

	public void setWidg_tblMacchineMovimentoATerra(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchineMovimentoATerra = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchineMovimentoATerra() {
		return widgTblMacchineMovimentoATerra;
	}

	// CheckBox chbAttrezzatureMacchinaRimorchi

	private boolean widgChbAttrezzatureMacchinaRimorchi;

	public void setWidg_chbAttrezzatureMacchinaRimorchi(boolean value) {
		widgChbAttrezzatureMacchinaRimorchi = value;
	}

	public boolean getWidg_chbAttrezzatureMacchinaRimorchi() {
		return widgChbAttrezzatureMacchinaRimorchi;
	}

	// Table tblMacchinaRimorchi

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchinaRimorchi;

	public void setWidg_tblMacchinaRimorchi(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchinaRimorchi = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchinaRimorchi() {
		return widgTblMacchinaRimorchi;
	}

	// CheckBox chbAttrezzatureMacchinaVerricelli

	private boolean widgChbAttrezzatureMacchinaVerricelli;

	public void setWidg_chbAttrezzatureMacchinaVerricelli(boolean value) {
		widgChbAttrezzatureMacchinaVerricelli = value;
	}

	public boolean getWidg_chbAttrezzatureMacchinaVerricelli() {
		return widgChbAttrezzatureMacchinaVerricelli;
	}

	// Table tblMacchinaVerricelli

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchinaVerricelli;

	public void setWidg_tblMacchinaVerricelli(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchinaVerricelli = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchinaVerricelli() {
		return widgTblMacchinaVerricelli;
	}

	// CheckBox chbAttrezzatureMacchinaPle

	private boolean widgChbAttrezzatureMacchinaPle;

	public void setWidg_chbAttrezzatureMacchinaPle(boolean value) {
		widgChbAttrezzatureMacchinaPle = value;
	}

	public boolean getWidg_chbAttrezzatureMacchinaPle() {
		return widgChbAttrezzatureMacchinaPle;
	}

	// Table tblMacchinaPle

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchinaPle;

	public void setWidg_tblMacchinaPle(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchinaPle = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchinaPle() {
		return widgTblMacchinaPle;
	}

	// CheckBox chbAttrezzatureMacchinaTrinciaForestale

	private boolean widgChbAttrezzatureMacchinaTrinciaForestale;

	public void setWidg_chbAttrezzatureMacchinaTrinciaForestale(boolean value) {
		widgChbAttrezzatureMacchinaTrinciaForestale = value;
	}

	public boolean getWidg_chbAttrezzatureMacchinaTrinciaForestale() {
		return widgChbAttrezzatureMacchinaTrinciaForestale;
	}

	// Table tblMacchinaTrinciaForestale

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchinaTrinciaForestale;

	public void setWidg_tblMacchinaTrinciaForestale(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchinaTrinciaForestale = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchinaTrinciaForestale() {
		return widgTblMacchinaTrinciaForestale;
	}

	// CheckBox chbAttrezzatureMacchineSegherieMobili

	private boolean widgChbAttrezzatureMacchineSegherieMobili;

	public void setWidg_chbAttrezzatureMacchineSegherieMobili(boolean value) {
		widgChbAttrezzatureMacchineSegherieMobili = value;
	}

	public boolean getWidg_chbAttrezzatureMacchineSegherieMobili() {
		return widgChbAttrezzatureMacchineSegherieMobili;
	}

	// Table tblMacchineSegherieMobili

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchineSegherieMobili;

	public void setWidg_tblMacchineSegherieMobili(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchineSegherieMobili = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchineSegherieMobili() {
		return widgTblMacchineSegherieMobili;
	}

	// CheckBox chbAttrezzatureMacchineGruACavo

	private boolean widgChbAttrezzatureMacchineGruACavo;

	public void setWidg_chbAttrezzatureMacchineGruACavo(boolean value) {
		widgChbAttrezzatureMacchineGruACavo = value;
	}

	public boolean getWidg_chbAttrezzatureMacchineGruACavo() {
		return widgChbAttrezzatureMacchineGruACavo;
	}

	// Table tblMacchineGruACavo

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchineGruACavo;

	public void setWidg_tblMacchineGruACavo(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchineGruACavo = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchineGruACavo() {
		return widgTblMacchineGruACavo;
	}

	// CheckBox chbAttrezzatureMacchineCippatrici

	private boolean widgChbAttrezzatureMacchineCippatrici;

	public void setWidg_chbAttrezzatureMacchineCippatrici(boolean value) {
		widgChbAttrezzatureMacchineCippatrici = value;
	}

	public boolean getWidg_chbAttrezzatureMacchineCippatrici() {
		return widgChbAttrezzatureMacchineCippatrici;
	}

	// Table tblMacchineCippatrici

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchineCippatrici;

	public void setWidg_tblMacchineCippatrici(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchineCippatrici = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchineCippatrici() {
		return widgTblMacchineCippatrici;
	}

	// CheckBox chbAttrezzatureMezziDiTrasporto

	private boolean widgChbAttrezzatureMezziDiTrasporto;

	public void setWidg_chbAttrezzatureMezziDiTrasporto(boolean value) {
		widgChbAttrezzatureMezziDiTrasporto = value;
	}

	public boolean getWidg_chbAttrezzatureMezziDiTrasporto() {
		return widgChbAttrezzatureMezziDiTrasporto;
	}

	// Table tblMezziDiTrasporto

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMezziDiTrasporto;

	public void setWidg_tblMezziDiTrasporto(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMezziDiTrasporto = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMezziDiTrasporto() {
		return widgTblMezziDiTrasporto;
	}

	// CheckBox chbAttrezzatureAltriMezzi

	private boolean widgChbAttrezzatureAltriMezzi;

	public void setWidg_chbAttrezzatureAltriMezzi(boolean value) {
		widgChbAttrezzatureAltriMezzi = value;
	}

	public boolean getWidg_chbAttrezzatureAltriMezzi() {
		return widgChbAttrezzatureAltriMezzi;
	}

	// Table tblAltriMezzi

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblAltriMezzi;

	public void setWidg_tblAltriMezzi(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblAltriMezzi = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblAltriMezzi() {
		return widgTblAltriMezzi;
	}

	// CheckBox chbAttrezzatureMacchineSpecialiFr

	private boolean widgChbAttrezzatureMacchineSpecialiFr;

	public void setWidg_chbAttrezzatureMacchineSpecialiFr(boolean value) {
		widgChbAttrezzatureMacchineSpecialiFr = value;
	}

	public boolean getWidg_chbAttrezzatureMacchineSpecialiFr() {
		return widgChbAttrezzatureMacchineSpecialiFr;
	}

	// Table tblMacchineSpecialiFr

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchineSpecialiFr;

	public void setWidg_tblMacchineSpecialiFr(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchineSpecialiFr = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchineSpecialiFr() {
		return widgTblMacchineSpecialiFr;
	}

	// CheckBox chbAttrezzatureMacchineMovimentoATerraFr

	private boolean widgChbAttrezzatureMacchineMovimentoATerraFr;

	public void setWidg_chbAttrezzatureMacchineMovimentoATerraFr(boolean value) {
		widgChbAttrezzatureMacchineMovimentoATerraFr = value;
	}

	public boolean getWidg_chbAttrezzatureMacchineMovimentoATerraFr() {
		return widgChbAttrezzatureMacchineMovimentoATerraFr;
	}

	// Table tblMacchineMovimentoATerraFr

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchineMovimentoATerraFr;

	public void setWidg_tblMacchineMovimentoATerraFr(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchineMovimentoATerraFr = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchineMovimentoATerraFr() {
		return widgTblMacchineMovimentoATerraFr;
	}

	// CheckBox chbAttrezzatureMacchinaGrumier

	private boolean widgChbAttrezzatureMacchinaGrumier;

	public void setWidg_chbAttrezzatureMacchinaGrumier(boolean value) {
		widgChbAttrezzatureMacchinaGrumier = value;
	}

	public boolean getWidg_chbAttrezzatureMacchinaGrumier() {
		return widgChbAttrezzatureMacchinaGrumier;
	}

	// Table tblMacchinaGrumier

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchinaGrumier;

	public void setWidg_tblMacchinaGrumier(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchinaGrumier = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchinaGrumier() {
		return widgTblMacchinaGrumier;
	}

	// CheckBox chbAttrezzatureMacchinaRimorchiFr

	private boolean widgChbAttrezzatureMacchinaRimorchiFr;

	public void setWidg_chbAttrezzatureMacchinaRimorchiFr(boolean value) {
		widgChbAttrezzatureMacchinaRimorchiFr = value;
	}

	public boolean getWidg_chbAttrezzatureMacchinaRimorchiFr() {
		return widgChbAttrezzatureMacchinaRimorchiFr;
	}

	// Table tblMacchinaRimorchiFr

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchinaRimorchiFr;

	public void setWidg_tblMacchinaRimorchiFr(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchinaRimorchiFr = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchinaRimorchiFr() {
		return widgTblMacchinaRimorchiFr;
	}

	// CheckBox chbAttrezzatureMacchinaSemi

	private boolean widgChbAttrezzatureMacchinaSemi;

	public void setWidg_chbAttrezzatureMacchinaSemi(boolean value) {
		widgChbAttrezzatureMacchinaSemi = value;
	}

	public boolean getWidg_chbAttrezzatureMacchinaSemi() {
		return widgChbAttrezzatureMacchinaSemi;
	}

	// Table tblMacchinaSemi

	private it.csi.taif.taifweb.dto.domanda.MacchinaMezzo widgTblMacchinaSemi;

	public void setWidg_tblMacchinaSemi(it.csi.taif.taifweb.dto.domanda.MacchinaMezzo value) {
		widgTblMacchinaSemi = value;
	}

	public it.csi.taif.taifweb.dto.domanda.MacchinaMezzo getWidg_tblMacchinaSemi() {
		return widgTblMacchinaSemi;
	}

	// RadioButtons rbsPersonale

	private java.lang.String widgRbsPersonale;

	public void setWidg_rbsPersonale(java.lang.String value) {
		widgRbsPersonale = value;
	}

	public java.lang.String getWidg_rbsPersonale() {
		return widgRbsPersonale;
	}

	// Table tblAltroPersonale

	private it.csi.taif.taifweb.dto.domanda.LavoroPA widgTblAltroPersonale;

	public void setWidg_tblAltroPersonale(it.csi.taif.taifweb.dto.domanda.LavoroPA value) {
		widgTblAltroPersonale = value;
	}

	public it.csi.taif.taifweb.dto.domanda.LavoroPA getWidg_tblAltroPersonale() {
		return widgTblAltroPersonale;
	}

	// Table tblAltroPersonaleTipoContrattoFr

	private it.csi.taif.taifweb.dto.domanda.GestionePersonaleFr widgTblAltroPersonaleTipoContrattoFr;

	public void setWidg_tblAltroPersonaleTipoContrattoFr(it.csi.taif.taifweb.dto.domanda.GestionePersonaleFr value) {
		widgTblAltroPersonaleTipoContrattoFr = value;
	}

	public it.csi.taif.taifweb.dto.domanda.GestionePersonaleFr getWidg_tblAltroPersonaleTipoContrattoFr() {
		return widgTblAltroPersonaleTipoContrattoFr;
	}

	// Table tblAltroPersonaleTipoMansioneFr

	private it.csi.taif.taifweb.dto.domanda.GestionePersonaleFr widgTblAltroPersonaleTipoMansioneFr;

	public void setWidg_tblAltroPersonaleTipoMansioneFr(it.csi.taif.taifweb.dto.domanda.GestionePersonaleFr value) {
		widgTblAltroPersonaleTipoMansioneFr = value;
	}

	public it.csi.taif.taifweb.dto.domanda.GestionePersonaleFr getWidg_tblAltroPersonaleTipoMansioneFr() {
		return widgTblAltroPersonaleTipoMansioneFr;
	}

}
