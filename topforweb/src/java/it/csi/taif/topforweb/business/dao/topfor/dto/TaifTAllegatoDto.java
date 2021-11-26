/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dto;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO TaifTAllegatoDao.
 * @generated
 */
public class TaifTAllegatoDto extends TaifTAllegatoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_PRATICA
	 * @generated
	 */
	protected Integer fkPratica;

	/**
	 * Imposta il valore della proprieta' fkPratica associata alla
	 * colonna FK_PRATICA.
	 * @generated
	 */
	public void setFkPratica(Integer val) {

		fkPratica = val;

	}

	/**
	 * Legge il valore della proprieta' fkPratica associata alla
	 * @generated
	 */
	public Integer getFkPratica() {

		return fkPratica;

	}

	/**
	 * store della proprieta' associata alla colonna FK_CORSO
	 * @generated
	 */
	protected Integer fkCorso;

	/**
	 * Imposta il valore della proprieta' fkCorso associata alla
	 * colonna FK_CORSO.
	 * @generated
	 */
	public void setFkCorso(Integer val) {

		fkCorso = val;

	}

	/**
	 * Legge il valore della proprieta' fkCorso associata alla
	 * @generated
	 */
	public Integer getFkCorso() {

		return fkCorso;

	}

	/**
	 * store della proprieta' associata alla colonna FK_PERSONA
	 * @generated
	 */
	protected Integer fkPersona;

	/**
	 * Imposta il valore della proprieta' fkPersona associata alla
	 * colonna FK_PERSONA.
	 * @generated
	 */
	public void setFkPersona(Integer val) {

		fkPersona = val;

	}

	/**
	 * Legge il valore della proprieta' fkPersona associata alla
	 * @generated
	 */
	public Integer getFkPersona() {

		return fkPersona;

	}

	/**
	 * store della proprieta' associata alla colonna FK_ESTENSIONE_FILE
	 * @generated
	 */
	protected Integer fkEstensioneFile;

	/**
	 * Imposta il valore della proprieta' fkEstensioneFile associata alla
	 * colonna FK_ESTENSIONE_FILE.
	 * @generated
	 */
	public void setFkEstensioneFile(Integer val) {

		fkEstensioneFile = val;

	}

	/**
	 * Legge il valore della proprieta' fkEstensioneFile associata alla
	 * @generated
	 */
	public Integer getFkEstensioneFile() {

		return fkEstensioneFile;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_ALLEGATO
	 * @generated
	 */
	protected Integer fkTipoAllegato;

	/**
	 * Imposta il valore della proprieta' fkTipoAllegato associata alla
	 * colonna FK_TIPO_ALLEGATO.
	 * @generated
	 */
	public void setFkTipoAllegato(Integer val) {

		fkTipoAllegato = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoAllegato associata alla
	 * @generated
	 */
	public Integer getFkTipoAllegato() {

		return fkTipoAllegato;

	}

	/**
	 * store della proprieta' associata alla colonna NOME_FILE
	 * @generated
	 */
	protected String nomeFile;

	/**
	 * Imposta il valore della proprieta' nomeFile associata alla
	 * colonna NOME_FILE.
	 * @generated
	 */
	public void setNomeFile(String val) {

		nomeFile = val;

	}

	/**
	 * Legge il valore della proprieta' nomeFile associata alla
	 * @generated
	 */
	public String getNomeFile() {

		return nomeFile;

	}

	/**
	 * store della proprieta' associata alla colonna DIMENSIONE_FILE_KB
	 * @generated
	 */
	protected Integer dimensioneFileKb;

	/**
	 * Imposta il valore della proprieta' dimensioneFileKb associata alla
	 * colonna DIMENSIONE_FILE_KB.
	 * @generated
	 */
	public void setDimensioneFileKb(Integer val) {

		dimensioneFileKb = val;

	}

	/**
	 * Legge il valore della proprieta' dimensioneFileKb associata alla
	 * @generated
	 */
	public Integer getDimensioneFileKb() {

		return dimensioneFileKb;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_TIPO_INVIO
	 * @generated
	 */
	protected String flgTipoInvio;

	/**
	 * Imposta il valore della proprieta' flgTipoInvio associata alla
	 * colonna FLG_TIPO_INVIO.
	 * @generated
	 */
	public void setFlgTipoInvio(String val) {

		flgTipoInvio = val;

	}

	/**
	 * Legge il valore della proprieta' flgTipoInvio associata alla
	 * @generated
	 */
	public String getFlgTipoInvio() {

		return flgTipoInvio;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SCADENZA
	 * @generated
	 */
	protected java.math.BigDecimal flgScadenza;

	/**
	 * Imposta il valore della proprieta' flgScadenza associata alla
	 * colonna FLG_SCADENZA.
	 * @generated
	 */
	public void setFlgScadenza(java.math.BigDecimal val) {

		flgScadenza = val;

	}

	/**
	 * Legge il valore della proprieta' flgScadenza associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgScadenza() {

		return flgScadenza;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_UPLOAD
	 * @generated
	 */
	protected java.sql.Timestamp dataUpload;

	/**
	 * Imposta il valore della proprieta' dataUpload associata alla
	 * colonna DATA_UPLOAD.
	 * @generated
	 */
	public void setDataUpload(java.sql.Timestamp val) {

		if (val != null) {
			dataUpload = new java.sql.Timestamp(val.getTime());
		} else {
			dataUpload = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataUpload associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataUpload() {

		if (dataUpload != null) {
			return new java.sql.Timestamp(dataUpload.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna NOTE
	 * @generated
	 */
	protected String note;

	/**
	 * Imposta il valore della proprieta' note associata alla
	 * colonna NOTE.
	 * @generated
	 */
	public void setNote(String val) {

		note = val;

	}

	/**
	 * Legge il valore della proprieta' note associata alla
	 * @generated
	 */
	public String getNote() {

		return note;

	}

	/**
	 * store della proprieta' associata alla colonna ESTENSIONE_FILE
	 * @generated
	 */
	protected String estensioneFile;

	/**
	 * Imposta il valore della proprieta' estensioneFile associata alla
	 * colonna ESTENSIONE_FILE.
	 * @generated
	 */
	public void setEstensioneFile(String val) {

		estensioneFile = val;

	}

	/**
	 * Legge il valore della proprieta' estensioneFile associata alla
	 * @generated
	 */
	public String getEstensioneFile() {

		return estensioneFile;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INSERIMENTO
	 * @generated
	 */
	protected java.sql.Timestamp dataInserimento;

	/**
	 * Imposta il valore della proprieta' dataInserimento associata alla
	 * colonna DATA_INSERIMENTO.
	 * @generated
	 */
	public void setDataInserimento(java.sql.Timestamp val) {

		if (val != null) {
			dataInserimento = new java.sql.Timestamp(val.getTime());
		} else {
			dataInserimento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInserimento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataInserimento() {

		if (dataInserimento != null) {
			return new java.sql.Timestamp(dataInserimento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_AGGIORNAMENTO
	 * @generated
	 */
	protected java.sql.Timestamp dataAggiornamento;

	/**
	 * Imposta il valore della proprieta' dataAggiornamento associata alla
	 * colonna DATA_AGGIORNAMENTO.
	 * @generated
	 */
	public void setDataAggiornamento(java.sql.Timestamp val) {

		if (val != null) {
			dataAggiornamento = new java.sql.Timestamp(val.getTime());
		} else {
			dataAggiornamento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataAggiornamento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataAggiornamento() {

		if (dataAggiornamento != null) {
			return new java.sql.Timestamp(dataAggiornamento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna FK_CONFIG_UTENTE
	 * @generated
	 */
	protected Integer fkConfigUtente;

	/**
	 * Imposta il valore della proprieta' fkConfigUtente associata alla
	 * colonna FK_CONFIG_UTENTE.
	 * @generated
	 */
	public void setFkConfigUtente(Integer val) {

		fkConfigUtente = val;

	}

	/**
	 * Legge il valore della proprieta' fkConfigUtente associata alla
	 * @generated
	 */
	public Integer getFkConfigUtente() {

		return fkConfigUtente;

	}

	/**
	 * Crea una istanza di TaifTAllegatoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTAllegatoPk
	 * @generated
	 */
	public TaifTAllegatoPk createPk() {
		return new TaifTAllegatoPk(idAllegato);
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
