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
 * Data transfer object relativo al DAO TaifTSedeAziendaDao.
 * @generated
 */
public class TaifTSedeAziendaDto extends TaifTSedeAziendaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_AZIENDA
	 * @generated
	 */
	protected Integer fkAzienda;

	/**
	 * Imposta il valore della proprieta' fkAzienda associata alla
	 * colonna FK_AZIENDA.
	 * @generated
	 */
	public void setFkAzienda(Integer val) {

		fkAzienda = val;

	}

	/**
	 * Legge il valore della proprieta' fkAzienda associata alla
	 * @generated
	 */
	public Integer getFkAzienda() {

		return fkAzienda;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_SEDE
	 * @generated
	 */
	protected Integer fkTipoSede;

	/**
	 * Imposta il valore della proprieta' fkTipoSede associata alla
	 * colonna FK_TIPO_SEDE.
	 * @generated
	 */
	public void setFkTipoSede(Integer val) {

		fkTipoSede = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoSede associata alla
	 * @generated
	 */
	public Integer getFkTipoSede() {

		return fkTipoSede;

	}

	/**
	 * store della proprieta' associata alla colonna ISTAT_COMUNE
	 * @generated
	 */
	protected String istatComune;

	/**
	 * Imposta il valore della proprieta' istatComune associata alla
	 * colonna ISTAT_COMUNE.
	 * @generated
	 */
	public void setIstatComune(String val) {

		istatComune = val;

	}

	/**
	 * Legge il valore della proprieta' istatComune associata alla
	 * @generated
	 */
	public String getIstatComune() {

		return istatComune;

	}

	/**
	 * store della proprieta' associata alla colonna COMUNE_ESTERO
	 * @generated
	 */
	protected String comuneEstero;

	/**
	 * Imposta il valore della proprieta' comuneEstero associata alla
	 * colonna COMUNE_ESTERO.
	 * @generated
	 */
	public void setComuneEstero(String val) {

		comuneEstero = val;

	}

	/**
	 * Legge il valore della proprieta' comuneEstero associata alla
	 * @generated
	 */
	public String getComuneEstero() {

		return comuneEstero;

	}

	/**
	 * store della proprieta' associata alla colonna INDIRIZZO
	 * @generated
	 */
	protected String indirizzo;

	/**
	 * Imposta il valore della proprieta' indirizzo associata alla
	 * colonna INDIRIZZO.
	 * @generated
	 */
	public void setIndirizzo(String val) {

		indirizzo = val;

	}

	/**
	 * Legge il valore della proprieta' indirizzo associata alla
	 * @generated
	 */
	public String getIndirizzo() {

		return indirizzo;

	}

	/**
	 * store della proprieta' associata alla colonna CIVICO
	 * @generated
	 */
	protected String civico;

	/**
	 * Imposta il valore della proprieta' civico associata alla
	 * colonna CIVICO.
	 * @generated
	 */
	public void setCivico(String val) {

		civico = val;

	}

	/**
	 * Legge il valore della proprieta' civico associata alla
	 * @generated
	 */
	public String getCivico() {

		return civico;

	}

	/**
	 * store della proprieta' associata alla colonna CAP
	 * @generated
	 */
	protected String cap;

	/**
	 * Imposta il valore della proprieta' cap associata alla
	 * colonna CAP.
	 * @generated
	 */
	public void setCap(String val) {

		cap = val;

	}

	/**
	 * Legge il valore della proprieta' cap associata alla
	 * @generated
	 */
	public String getCap() {

		return cap;

	}

	/**
	 * store della proprieta' associata alla colonna TELEFONO
	 * @generated
	 */
	protected String telefono;

	/**
	 * Imposta il valore della proprieta' telefono associata alla
	 * colonna TELEFONO.
	 * @generated
	 */
	public void setTelefono(String val) {

		telefono = val;

	}

	/**
	 * Legge il valore della proprieta' telefono associata alla
	 * @generated
	 */
	public String getTelefono() {

		return telefono;

	}

	/**
	 * store della proprieta' associata alla colonna CELLULARE
	 * @generated
	 */
	protected String cellulare;

	/**
	 * Imposta il valore della proprieta' cellulare associata alla
	 * colonna CELLULARE.
	 * @generated
	 */
	public void setCellulare(String val) {

		cellulare = val;

	}

	/**
	 * Legge il valore della proprieta' cellulare associata alla
	 * @generated
	 */
	public String getCellulare() {

		return cellulare;

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
	 * Crea una istanza di TaifTSedeAziendaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTSedeAziendaPk
	 * @generated
	 */
	public TaifTSedeAziendaPk createPk() {
		return new TaifTSedeAziendaPk(idSede);
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
