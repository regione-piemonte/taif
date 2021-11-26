/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO TaifCnfTipoAllegatoDao.
 * @generated
 */
public class TaifCnfTipoAllegatoDto extends TaifCnfTipoAllegatoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_PROCEDURA
	 * @generated
	 */
	protected Integer fkProcedura;

	/**
	 * Imposta il valore della proprieta' fkProcedura associata alla
	 * colonna FK_PROCEDURA.
	 * @generated
	 */
	public void setFkProcedura(Integer val) {

		fkProcedura = val;

	}

	/**
	 * Legge il valore della proprieta' fkProcedura associata alla
	 * @generated
	 */
	public Integer getFkProcedura() {

		return fkProcedura;

	}

	/**
	 * store della proprieta' associata alla colonna TIPO_ALLEGATO
	 * @generated
	 */
	protected String tipoAllegato;

	/**
	 * Imposta il valore della proprieta' tipoAllegato associata alla
	 * colonna TIPO_ALLEGATO.
	 * @generated
	 */
	public void setTipoAllegato(String val) {

		tipoAllegato = val;

	}

	/**
	 * Legge il valore della proprieta' tipoAllegato associata alla
	 * @generated
	 */
	public String getTipoAllegato() {

		return tipoAllegato;

	}

	/**
	 * store della proprieta' associata alla colonna MTD_ORDINAMENTO
	 * @generated
	 */
	protected java.math.BigDecimal mtdOrdinamento;

	/**
	 * Imposta il valore della proprieta' mtdOrdinamento associata alla
	 * colonna MTD_ORDINAMENTO.
	 * @generated
	 */
	public void setMtdOrdinamento(java.math.BigDecimal val) {

		mtdOrdinamento = val;

	}

	/**
	 * Legge il valore della proprieta' mtdOrdinamento associata alla
	 * @generated
	 */
	public java.math.BigDecimal getMtdOrdinamento() {

		return mtdOrdinamento;

	}

	/**
	 * store della proprieta' associata alla colonna MTD_FLG_VISIBILE
	 * @generated
	 */
	protected java.math.BigDecimal mtdFlgVisibile;

	/**
	 * Imposta il valore della proprieta' mtdFlgVisibile associata alla
	 * colonna MTD_FLG_VISIBILE.
	 * @generated
	 */
	public void setMtdFlgVisibile(java.math.BigDecimal val) {

		mtdFlgVisibile = val;

	}

	/**
	 * Legge il valore della proprieta' mtdFlgVisibile associata alla
	 * @generated
	 */
	public java.math.BigDecimal getMtdFlgVisibile() {

		return mtdFlgVisibile;

	}

	/**
	 * store della proprieta' associata alla colonna MTD_FLG_ITA_FRA
	 * @generated
	 */
	protected String mtdFlgItaFra;

	/**
	 * Imposta il valore della proprieta' mtdFlgItaFra associata alla
	 * colonna MTD_FLG_ITA_FRA.
	 * @generated
	 */
	public void setMtdFlgItaFra(String val) {

		mtdFlgItaFra = val;

	}

	/**
	 * Legge il valore della proprieta' mtdFlgItaFra associata alla
	 * @generated
	 */
	public String getMtdFlgItaFra() {

		return mtdFlgItaFra;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_CONTESTO
	 * @generated
	 */
	protected String flgContesto;

	/**
	 * Imposta il valore della proprieta' flgContesto associata alla
	 * colonna FLG_CONTESTO.
	 * @generated
	 */
	public void setFlgContesto(String val) {

		flgContesto = val;

	}

	/**
	 * Legge il valore della proprieta' flgContesto associata alla
	 * @generated
	 */
	public String getFlgContesto() {

		return flgContesto;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_FIRMA
	 * @generated
	 */
	protected String flgFirma;

	/**
	 * Imposta il valore della proprieta' flgFirma associata alla
	 * colonna FLG_FIRMA.
	 * @generated
	 */
	public void setFlgFirma(String val) {

		flgFirma = val;

	}

	/**
	 * Legge il valore della proprieta' flgFirma associata alla
	 * @generated
	 */
	public String getFlgFirma() {

		return flgFirma;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_DOWNLOAD
	 * @generated
	 */
	protected java.math.BigDecimal flgDownload;

	/**
	 * Imposta il valore della proprieta' flgDownload associata alla
	 * colonna FLG_DOWNLOAD.
	 * @generated
	 */
	public void setFlgDownload(java.math.BigDecimal val) {

		flgDownload = val;

	}

	/**
	 * Legge il valore della proprieta' flgDownload associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgDownload() {

		return flgDownload;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_UPLOAD
	 * @generated
	 */
	protected java.math.BigDecimal flgUpload;

	/**
	 * Imposta il valore della proprieta' flgUpload associata alla
	 * colonna FLG_UPLOAD.
	 * @generated
	 */
	public void setFlgUpload(java.math.BigDecimal val) {

		flgUpload = val;

	}

	/**
	 * Legge il valore della proprieta' flgUpload associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgUpload() {

		return flgUpload;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_INVIO
	 * @generated
	 */
	protected java.math.BigDecimal flgInvio;

	/**
	 * Imposta il valore della proprieta' flgInvio associata alla
	 * colonna FLG_INVIO.
	 * @generated
	 */
	public void setFlgInvio(java.math.BigDecimal val) {

		flgInvio = val;

	}

	/**
	 * Legge il valore della proprieta' flgInvio associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgInvio() {

		return flgInvio;

	}

	/**
	 * store della proprieta' associata alla colonna ACTA_OGGETTO
	 * @generated
	 */
	protected String actaOggetto;

	/**
	 * Imposta il valore della proprieta' actaOggetto associata alla
	 * colonna ACTA_OGGETTO.
	 * @generated
	 */
	public void setActaOggetto(String val) {

		actaOggetto = val;

	}

	/**
	 * Legge il valore della proprieta' actaOggetto associata alla
	 * @generated
	 */
	public String getActaOggetto() {

		return actaOggetto;

	}

	/**
	 * store della proprieta' associata alla colonna ACTA_FLG_ALLEGATI
	 * @generated
	 */
	protected String actaFlgAllegati;

	/**
	 * Imposta il valore della proprieta' actaFlgAllegati associata alla
	 * colonna ACTA_FLG_ALLEGATI.
	 * @generated
	 */
	public void setActaFlgAllegati(String val) {

		actaFlgAllegati = val;

	}

	/**
	 * Legge il valore della proprieta' actaFlgAllegati associata alla
	 * @generated
	 */
	public String getActaFlgAllegati() {

		return actaFlgAllegati;

	}

	/**
	 * store della proprieta' associata alla colonna ACTA_STATO_DI_EFFICACIA
	 * @generated
	 */
	protected String actaStatoDiEfficacia;

	/**
	 * Imposta il valore della proprieta' actaStatoDiEfficacia associata alla
	 * colonna ACTA_STATO_DI_EFFICACIA.
	 * @generated
	 */
	public void setActaStatoDiEfficacia(String val) {

		actaStatoDiEfficacia = val;

	}

	/**
	 * Legge il valore della proprieta' actaStatoDiEfficacia associata alla
	 * @generated
	 */
	public String getActaStatoDiEfficacia() {

		return actaStatoDiEfficacia;

	}

	/**
	 * Crea una istanza di TaifCnfTipoAllegatoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifCnfTipoAllegatoPk
	 * @generated
	 */
	public TaifCnfTipoAllegatoPk createPk() {
		return new TaifCnfTipoAllegatoPk(idTipoAllegato);
	}

	/**
	 * la semantica dell'equals del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * @param other l'oggetto con cui effettuare il confronto
	 * @return true se i due oggetti sono semanticamente da considerarsi uguali
	 */
	public boolean equals(Object other) {
		return super.equals(other);
	}

	/**
	 * la semantica dell'hashCode del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * 
	 * @return int
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
