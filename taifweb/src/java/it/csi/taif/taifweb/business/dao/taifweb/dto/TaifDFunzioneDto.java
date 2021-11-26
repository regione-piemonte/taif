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
 * Data transfer object relativo al DAO TaifDFunzioneDao.
 * @generated
 */
public class TaifDFunzioneDto extends TaifDFunzionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_STRUTTURA
	 * @generated
	 */
	protected Integer fkTipoStruttura;

	/**
	 * Imposta il valore della proprieta' fkTipoStruttura associata alla
	 * colonna FK_TIPO_STRUTTURA.
	 * @generated
	 */
	public void setFkTipoStruttura(Integer val) {

		fkTipoStruttura = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoStruttura associata alla
	 * @generated
	 */
	public Integer getFkTipoStruttura() {

		return fkTipoStruttura;

	}

	/**
	 * store della proprieta' associata alla colonna FUNZIONE
	 * @generated
	 */
	protected String funzione;

	/**
	 * Imposta il valore della proprieta' funzione associata alla
	 * colonna FUNZIONE.
	 * @generated
	 */
	public void setFunzione(String val) {

		funzione = val;

	}

	/**
	 * Legge il valore della proprieta' funzione associata alla
	 * @generated
	 */
	public String getFunzione() {

		return funzione;

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
	 * Crea una istanza di TaifDFunzionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifDFunzionePk
	 * @generated
	 */
	public TaifDFunzionePk createPk() {
		return new TaifDFunzionePk(idFunzione);
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
