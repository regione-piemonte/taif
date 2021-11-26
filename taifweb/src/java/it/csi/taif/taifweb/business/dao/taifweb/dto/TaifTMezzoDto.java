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
 * Data transfer object relativo al DAO TaifTMezzoDao.
 * @generated
 */
public class TaifTMezzoDto extends TaifTMezzoPk {

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
	 * store della proprieta' associata alla colonna FK_ALIMENTAZIONE
	 * @generated
	 */
	protected Integer fkAlimentazione;

	/**
	 * Imposta il valore della proprieta' fkAlimentazione associata alla
	 * colonna FK_ALIMENTAZIONE.
	 * @generated
	 */
	public void setFkAlimentazione(Integer val) {

		fkAlimentazione = val;

	}

	/**
	 * Legge il valore della proprieta' fkAlimentazione associata alla
	 * @generated
	 */
	public Integer getFkAlimentazione() {

		return fkAlimentazione;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_CARRELLO
	 * @generated
	 */
	protected Integer fkTipoCarrello;

	/**
	 * Imposta il valore della proprieta' fkTipoCarrello associata alla
	 * colonna FK_TIPO_CARRELLO.
	 * @generated
	 */
	public void setFkTipoCarrello(Integer val) {

		fkTipoCarrello = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoCarrello associata alla
	 * @generated
	 */
	public Integer getFkTipoCarrello() {

		return fkTipoCarrello;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_MEZZO
	 * @generated
	 */
	protected Integer fkTipoMezzo;

	/**
	 * Imposta il valore della proprieta' fkTipoMezzo associata alla
	 * colonna FK_TIPO_MEZZO.
	 * @generated
	 */
	public void setFkTipoMezzo(Integer val) {

		fkTipoMezzo = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoMezzo associata alla
	 * @generated
	 */
	public Integer getFkTipoMezzo() {

		return fkTipoMezzo;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TRAZIONE
	 * @generated
	 */
	protected Integer fkTrazione;

	/**
	 * Imposta il valore della proprieta' fkTrazione associata alla
	 * colonna FK_TRAZIONE.
	 * @generated
	 */
	public void setFkTrazione(Integer val) {

		fkTrazione = val;

	}

	/**
	 * Legge il valore della proprieta' fkTrazione associata alla
	 * @generated
	 */
	public Integer getFkTrazione() {

		return fkTrazione;

	}

	/**
	 * store della proprieta' associata alla colonna ANNO
	 * @generated
	 */
	protected java.math.BigDecimal anno;

	/**
	 * Imposta il valore della proprieta' anno associata alla
	 * colonna ANNO.
	 * @generated
	 */
	public void setAnno(java.math.BigDecimal val) {

		anno = val;

	}

	/**
	 * Legge il valore della proprieta' anno associata alla
	 * @generated
	 */
	public java.math.BigDecimal getAnno() {

		return anno;

	}

	/**
	 * store della proprieta' associata alla colonna POTENZA_KW
	 * @generated
	 */
	protected Integer potenzaKw;

	/**
	 * Imposta il valore della proprieta' potenzaKw associata alla
	 * colonna POTENZA_KW.
	 * @generated
	 */
	public void setPotenzaKw(Integer val) {

		potenzaKw = val;

	}

	/**
	 * Legge il valore della proprieta' potenzaKw associata alla
	 * @generated
	 */
	public Integer getPotenzaKw() {

		return potenzaKw;

	}

	/**
	 * store della proprieta' associata alla colonna PORTATA_KG
	 * @generated
	 */
	protected Integer portataKg;

	/**
	 * Imposta il valore della proprieta' portataKg associata alla
	 * colonna PORTATA_KG.
	 * @generated
	 */
	public void setPortataKg(Integer val) {

		portataKg = val;

	}

	/**
	 * Legge il valore della proprieta' portataKg associata alla
	 * @generated
	 */
	public Integer getPortataKg() {

		return portataKg;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_COMANDATO_DISTANZA
	 * @generated
	 */
	protected java.math.BigDecimal flgComandatoDistanza;

	/**
	 * Imposta il valore della proprieta' flgComandatoDistanza associata alla
	 * colonna FLG_COMANDATO_DISTANZA.
	 * @generated
	 */
	public void setFlgComandatoDistanza(java.math.BigDecimal val) {

		flgComandatoDistanza = val;

	}

	/**
	 * Legge il valore della proprieta' flgComandatoDistanza associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgComandatoDistanza() {

		return flgComandatoDistanza;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_NOLEGGIO
	 * @generated
	 */
	protected java.math.BigDecimal flgNoleggio;

	/**
	 * Imposta il valore della proprieta' flgNoleggio associata alla
	 * colonna FLG_NOLEGGIO.
	 * @generated
	 */
	public void setFlgNoleggio(java.math.BigDecimal val) {

		flgNoleggio = val;

	}

	/**
	 * Legge il valore della proprieta' flgNoleggio associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgNoleggio() {

		return flgNoleggio;

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
	 * store della proprieta' associata alla colonna DESCR_ALTRO
	 * @generated
	 */
	protected String descrAltro;

	/**
	 * Imposta il valore della proprieta' descrAltro associata alla
	 * colonna DESCR_ALTRO.
	 * @generated
	 */
	public void setDescrAltro(String val) {

		descrAltro = val;

	}

	/**
	 * Legge il valore della proprieta' descrAltro associata alla
	 * @generated
	 */
	public String getDescrAltro() {

		return descrAltro;

	}

	/**
	 * Crea una istanza di TaifTMezzoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTMezzoPk
	 * @generated
	 */
	public TaifTMezzoPk createPk() {
		return new TaifTMezzoPk(idMezzo);
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
