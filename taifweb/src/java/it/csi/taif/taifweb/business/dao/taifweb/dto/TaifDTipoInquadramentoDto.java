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
 * Data transfer object relativo al DAO TaifDTipoInquadramentoDao.
 * @generated
 */
public class TaifDTipoInquadramentoDto extends TaifDTipoInquadramentoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna TIPO_INQUADRAMENTO
	 * @generated
	 */
	protected String tipoInquadramento;

	/**
	 * Imposta il valore della proprieta' tipoInquadramento associata alla
	 * colonna TIPO_INQUADRAMENTO.
	 * @generated
	 */
	public void setTipoInquadramento(String val) {

		tipoInquadramento = val;

	}

	/**
	 * Legge il valore della proprieta' tipoInquadramento associata alla
	 * @generated
	 */
	public String getTipoInquadramento() {

		return tipoInquadramento;

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
	 * Crea una istanza di TaifDTipoInquadramentoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifDTipoInquadramentoPk
	 * @generated
	 */
	public TaifDTipoInquadramentoPk createPk() {
		return new TaifDTipoInquadramentoPk(idTipoInquadramento);
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
