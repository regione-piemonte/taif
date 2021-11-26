/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.common;

import java.io.File;
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
 * logica di business associata alla Schermata [CpDocumentazione]
 */
@Validation
public class CpDocumentazioneModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoTipologieAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipologieAllegati(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipologieAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipologieAllegati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoTipologieAllegati() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipologieAllegati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAllegati(java.util.ArrayList<it.csi.taif.taifweb.dto.allegato.Allegato> value) {
		getSession().put("appDataelencoAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAllegati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.allegato.Allegato> getAppDataelencoAllegati() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.allegato.Allegato>) (getSession()
				.get("appDataelencoAllegati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataallegato'
	 * @param value
	 * @generated
	 */

	public void setAppDataallegato(it.csi.taif.taifweb.dto.allegato.Allegato value) {
		getSession().put("appDataallegato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataallegato'
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.allegato.Allegato getAppDataallegato() {
		return (it.csi.taif.taifweb.dto.allegato.Allegato) (getSession().get("appDataallegato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSottotipologieAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSottotipologieAllegati(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSottotipologieAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSottotipologieAllegati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoSottotipologieAllegati() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSottotipologieAllegati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAllegatoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAllegatoSelezionato(java.lang.String value) {
		getSession().put("appDataidAllegatoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAllegatoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidAllegatoSelezionato() {
		return (java.lang.String) (getSession().get("appDataidAllegatoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidSottotipologiaAllegatoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidSottotipologiaAllegatoSelezionato(java.lang.String value) {
		getSession().put("appDataidSottotipologiaAllegatoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidSottotipologiaAllegatoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidSottotipologiaAllegatoSelezionato() {
		return (java.lang.String) (getSession().get("appDataidSottotipologiaAllegatoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTipologiaAllegatoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTipologiaAllegatoSelezionato(java.lang.String value) {
		getSession().put("appDataidTipologiaAllegatoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTipologiaAllegatoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidTipologiaAllegatoSelezionato() {
		return (java.lang.String) (getSession().get("appDataidTipologiaAllegatoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoDenominazioneTipoAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoDenominazioneTipoAllegati(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoDenominazioneTipoAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoDenominazioneTipoAllegati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoDenominazioneTipoAllegati() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoDenominazioneTipoAllegati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAllegatiDownload'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAllegatiDownload(
			java.util.ArrayList<it.csi.taif.taifweb.dto.allegatodownload.AllegatoDownload> value) {
		getSession().put("appDataelencoAllegatiDownload", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAllegatiDownload'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.allegatodownload.AllegatoDownload> getAppDataelencoAllegatiDownload() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.allegatodownload.AllegatoDownload>) (getSession()
				.get("appDataelencoAllegatiDownload"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipologieAllegatiDownload'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipologieAllegatiDownload(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipologieAllegatiDownload", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipologieAllegatiDownload'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getAppDataelencoTipologieAllegatiDownload() {
		return (java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipologieAllegatiDownload"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTipologiaAllegatoDownloadSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTipologiaAllegatoDownloadSelezionato(java.lang.String value) {
		getSession().put("appDataidTipologiaAllegatoDownloadSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTipologiaAllegatoDownloadSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidTipologiaAllegatoDownloadSelezionato() {
		return (java.lang.String) (getSession().get("appDataidTipologiaAllegatoDownloadSelezionato"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tElencoDownloadAllegati

	private it.csi.taif.taifweb.dto.allegato.Allegato widgTElencoDownloadAllegati;

	public void setWidg_tElencoDownloadAllegati(it.csi.taif.taifweb.dto.allegato.Allegato value) {
		widgTElencoDownloadAllegati = value;
	}

	public it.csi.taif.taifweb.dto.allegato.Allegato getWidg_tElencoDownloadAllegati() {
		return widgTElencoDownloadAllegati;
	}

	// FileUpload widg_updFile
	private File widgUpdFile; // The actual file(s)
	private String widgUpdFileContentType; // The content type of the file(s) 
	private String widgUpdFileFileName; // The uploaded file(s) name and path 

	public void setWidg_updFile(File value) {
		widgUpdFile = value;
	}
	@JSON(include = false)
	public File getWidg_updFile() {
		return widgUpdFile;
	}

	public void setWidg_updFileContentType(String value) {
		widgUpdFileContentType = value;
	}
	@JSON(include = false)
	public String getWidg_updFileContentType() {
		return widgUpdFileContentType;
	}

	public void setWidg_updFileFileName(String value) {
		widgUpdFileFileName = value;
	}
	@JSON(include = false)
	public String getWidg_updFileFileName() {
		return widgUpdFileFileName;
	}

	// Table tElencoAllegati

	private it.csi.taif.taifweb.dto.allegato.Allegato widgTElencoAllegati;

	public void setWidg_tElencoAllegati(it.csi.taif.taifweb.dto.allegato.Allegato value) {
		widgTElencoAllegati = value;
	}

	public it.csi.taif.taifweb.dto.allegato.Allegato getWidg_tElencoAllegati() {
		return widgTElencoAllegati;
	}

}
