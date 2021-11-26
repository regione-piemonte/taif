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
 * Data transfer object relativo al DAO TaifDStatoOpfoDao.
 * @generated
 */
public class TaifDStatoOpfoDto extends TaifDStatoOpfoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna STATO_OPFO_ITA
	 * @generated
	 */
	protected String statoOpfoIta;

	/**
	 * Imposta il valore della proprieta' statoOpfoIta associata alla
	 * colonna STATO_OPFO_ITA.
	 * @generated
	 */
	public void setStatoOpfoIta(String val) {

		statoOpfoIta = val;

	}

	/**
	 * Legge il valore della proprieta' statoOpfoIta associata alla
	 * @generated
	 */
	public String getStatoOpfoIta() {

		return statoOpfoIta;

	}

	/**
	 * store della proprieta' associata alla colonna STATO_OPFO_FRA
	 * @generated
	 */
	protected String statoOpfoFra;

	/**
	 * Imposta il valore della proprieta' statoOpfoFra associata alla
	 * colonna STATO_OPFO_FRA.
	 * @generated
	 */
	public void setStatoOpfoFra(String val) {

		statoOpfoFra = val;

	}

	/**
	 * Legge il valore della proprieta' statoOpfoFra associata alla
	 * @generated
	 */
	public String getStatoOpfoFra() {

		return statoOpfoFra;

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
	 * Crea una istanza di TaifDStatoOpfoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifDStatoOpfoPk
	 * @generated
	 */
	public TaifDStatoOpfoPk createPk() {
		return new TaifDStatoOpfoPk(idStatoOpfo);
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
