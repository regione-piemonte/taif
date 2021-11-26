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
 * Data transfer object relativo al DAO TaifDMaterialeDao.
 * @generated
 */
public class TaifDMaterialeDto extends TaifDMaterialePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna MATERIALE
	 * @generated
	 */
	protected String materiale;

	/**
	 * Imposta il valore della proprieta' materiale associata alla
	 * colonna MATERIALE.
	 * @generated
	 */
	public void setMateriale(String val) {

		materiale = val;

	}

	/**
	 * Legge il valore della proprieta' materiale associata alla
	 * @generated
	 */
	public String getMateriale() {

		return materiale;

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
	 * store della proprieta' associata alla colonna FLG_VIVAI_ARB
	 * @generated
	 */
	protected String flgVivaiArb;

	/**
	 * Imposta il valore della proprieta' flgVivaiArb associata alla
	 * colonna FLG_VIVAI_ARB.
	 * @generated
	 */
	public void setFlgVivaiArb(String val) {

		flgVivaiArb = val;

	}

	/**
	 * Legge il valore della proprieta' flgVivaiArb associata alla
	 * @generated
	 */
	public String getFlgVivaiArb() {

		return flgVivaiArb;

	}

	/**
	 * Crea una istanza di TaifDMaterialePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifDMaterialePk
	 * @generated
	 */
	public TaifDMaterialePk createPk() {
		return new TaifDMaterialePk(idMateriale);
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
