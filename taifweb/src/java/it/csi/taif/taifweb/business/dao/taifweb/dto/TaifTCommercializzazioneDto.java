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
 * Data transfer object relativo al DAO TaifTCommercializzazioneDao.
 * @generated
 */
public class TaifTCommercializzazioneDto extends TaifTCommercializzazionePk {

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
	 * store della proprieta' associata alla colonna FK_SPECIE
	 * @generated
	 */
	protected Integer fkSpecie;

	/**
	 * Imposta il valore della proprieta' fkSpecie associata alla
	 * colonna FK_SPECIE.
	 * @generated
	 */
	public void setFkSpecie(Integer val) {

		fkSpecie = val;

	}

	/**
	 * Legge il valore della proprieta' fkSpecie associata alla
	 * @generated
	 */
	public Integer getFkSpecie() {

		return fkSpecie;

	}

	/**
	 * store della proprieta' associata alla colonna FK_PROVENIENZA
	 * @generated
	 */
	protected Integer fkProvenienza;

	/**
	 * Imposta il valore della proprieta' fkProvenienza associata alla
	 * colonna FK_PROVENIENZA.
	 * @generated
	 */
	public void setFkProvenienza(Integer val) {

		fkProvenienza = val;

	}

	/**
	 * Legge il valore della proprieta' fkProvenienza associata alla
	 * @generated
	 */
	public Integer getFkProvenienza() {

		return fkProvenienza;

	}

	/**
	 * store della proprieta' associata alla colonna FK_DESTINAZIONE
	 * @generated
	 */
	protected Integer fkDestinazione;

	/**
	 * Imposta il valore della proprieta' fkDestinazione associata alla
	 * colonna FK_DESTINAZIONE.
	 * @generated
	 */
	public void setFkDestinazione(Integer val) {

		fkDestinazione = val;

	}

	/**
	 * Legge il valore della proprieta' fkDestinazione associata alla
	 * @generated
	 */
	public Integer getFkDestinazione() {

		return fkDestinazione;

	}

	/**
	 * store della proprieta' associata alla colonna FK_ASSORTIMENTO
	 * @generated
	 */
	protected Integer fkAssortimento;

	/**
	 * Imposta il valore della proprieta' fkAssortimento associata alla
	 * colonna FK_ASSORTIMENTO.
	 * @generated
	 */
	public void setFkAssortimento(Integer val) {

		fkAssortimento = val;

	}

	/**
	 * Legge il valore della proprieta' fkAssortimento associata alla
	 * @generated
	 */
	public Integer getFkAssortimento() {

		return fkAssortimento;

	}

	/**
	 * store della proprieta' associata alla colonna FK_UNITA_DI_MISURA
	 * @generated
	 */
	protected Integer fkUnitaDiMisura;

	/**
	 * Imposta il valore della proprieta' fkUnitaDiMisura associata alla
	 * colonna FK_UNITA_DI_MISURA.
	 * @generated
	 */
	public void setFkUnitaDiMisura(Integer val) {

		fkUnitaDiMisura = val;

	}

	/**
	 * Legge il valore della proprieta' fkUnitaDiMisura associata alla
	 * @generated
	 */
	public Integer getFkUnitaDiMisura() {

		return fkUnitaDiMisura;

	}

	/**
	 * store della proprieta' associata alla colonna VENDUTO_MEDIO
	 * @generated
	 */
	protected java.math.BigDecimal vendutoMedio;

	/**
	 * Imposta il valore della proprieta' vendutoMedio associata alla
	 * colonna VENDUTO_MEDIO.
	 * @generated
	 */
	public void setVendutoMedio(java.math.BigDecimal val) {

		vendutoMedio = val;

	}

	/**
	 * Legge il valore della proprieta' vendutoMedio associata alla
	 * @generated
	 */
	public java.math.BigDecimal getVendutoMedio() {

		return vendutoMedio;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_TAGLIATO_ACQUISTATO
	 * @generated
	 */
	protected String flgTagliatoAcquistato;

	/**
	 * Imposta il valore della proprieta' flgTagliatoAcquistato associata alla
	 * colonna FLG_TAGLIATO_ACQUISTATO.
	 * @generated
	 */
	public void setFlgTagliatoAcquistato(String val) {

		flgTagliatoAcquistato = val;

	}

	/**
	 * Legge il valore della proprieta' flgTagliatoAcquistato associata alla
	 * @generated
	 */
	public String getFlgTagliatoAcquistato() {

		return flgTagliatoAcquistato;

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
	 * Crea una istanza di TaifTCommercializzazionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTCommercializzazionePk
	 * @generated
	 */
	public TaifTCommercializzazionePk createPk() {
		return new TaifTCommercializzazionePk(idCommercializzazione);
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
