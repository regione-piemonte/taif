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
 * Data transfer object relativo al DAO TaifDTipoMezzoDao.
 * @generated
 */
public class TaifDTipoMezzoDto extends TaifDTipoMezzoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_CATEGORIA_MEZZO
	 * @generated
	 */
	protected Integer fkCategoriaMezzo;

	/**
	 * Imposta il valore della proprieta' fkCategoriaMezzo associata alla
	 * colonna FK_CATEGORIA_MEZZO.
	 * @generated
	 */
	public void setFkCategoriaMezzo(Integer val) {

		fkCategoriaMezzo = val;

	}

	/**
	 * Legge il valore della proprieta' fkCategoriaMezzo associata alla
	 * @generated
	 */
	public Integer getFkCategoriaMezzo() {

		return fkCategoriaMezzo;

	}

	/**
	 * store della proprieta' associata alla colonna TIPO_MEZZO
	 * @generated
	 */
	protected String tipoMezzo;

	/**
	 * Imposta il valore della proprieta' tipoMezzo associata alla
	 * colonna TIPO_MEZZO.
	 * @generated
	 */
	public void setTipoMezzo(String val) {

		tipoMezzo = val;

	}

	/**
	 * Legge il valore della proprieta' tipoMezzo associata alla
	 * @generated
	 */
	public String getTipoMezzo() {

		return tipoMezzo;

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
	 * Crea una istanza di TaifDTipoMezzoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifDTipoMezzoPk
	 * @generated
	 */
	public TaifDTipoMezzoPk createPk() {
		return new TaifDTipoMezzoPk(idTipoMezzo);
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
