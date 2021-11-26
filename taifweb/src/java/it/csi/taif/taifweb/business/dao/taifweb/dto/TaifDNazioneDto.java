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
 * Data transfer object relativo al DAO TaifDNazioneDao.
 * @generated
 */
public class TaifDNazioneDto extends TaifDNazionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna NAZIONE_ITA
	 * @generated
	 */
	protected String nazioneIta;

	/**
	 * Imposta il valore della proprieta' nazioneIta associata alla
	 * colonna NAZIONE_ITA.
	 * @generated
	 */
	public void setNazioneIta(String val) {

		nazioneIta = val;

	}

	/**
	 * Legge il valore della proprieta' nazioneIta associata alla
	 * @generated
	 */
	public String getNazioneIta() {

		return nazioneIta;

	}

	/**
	 * store della proprieta' associata alla colonna NAZIONE_FRA
	 * @generated
	 */
	protected String nazioneFra;

	/**
	 * Imposta il valore della proprieta' nazioneFra associata alla
	 * colonna NAZIONE_FRA.
	 * @generated
	 */
	public void setNazioneFra(String val) {

		nazioneFra = val;

	}

	/**
	 * Legge il valore della proprieta' nazioneFra associata alla
	 * @generated
	 */
	public String getNazioneFra() {

		return nazioneFra;

	}

	/**
	 * store della proprieta' associata alla colonna MTD_ORDINAMENTO_ITA
	 * @generated
	 */
	protected java.math.BigDecimal mtdOrdinamentoIta;

	/**
	 * Imposta il valore della proprieta' mtdOrdinamentoIta associata alla
	 * colonna MTD_ORDINAMENTO_ITA.
	 * @generated
	 */
	public void setMtdOrdinamentoIta(java.math.BigDecimal val) {

		mtdOrdinamentoIta = val;

	}

	/**
	 * Legge il valore della proprieta' mtdOrdinamentoIta associata alla
	 * @generated
	 */
	public java.math.BigDecimal getMtdOrdinamentoIta() {

		return mtdOrdinamentoIta;

	}

	/**
	 * store della proprieta' associata alla colonna MTD_ORDINAMENTO_FRA
	 * @generated
	 */
	protected java.math.BigDecimal mtdOrdinamentoFra;

	/**
	 * Imposta il valore della proprieta' mtdOrdinamentoFra associata alla
	 * colonna MTD_ORDINAMENTO_FRA.
	 * @generated
	 */
	public void setMtdOrdinamentoFra(java.math.BigDecimal val) {

		mtdOrdinamentoFra = val;

	}

	/**
	 * Legge il valore della proprieta' mtdOrdinamentoFra associata alla
	 * @generated
	 */
	public java.math.BigDecimal getMtdOrdinamentoFra() {

		return mtdOrdinamentoFra;

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
	 * Crea una istanza di TaifDNazionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifDNazionePk
	 * @generated
	 */
	public TaifDNazionePk createPk() {
		return new TaifDNazionePk(idNazione);
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
