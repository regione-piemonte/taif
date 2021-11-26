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
 * Data transfer object relativo al DAO TaifDStatoPraticaDao.
 * @generated
 */
public class TaifDStatoPraticaDto extends TaifDStatoPraticaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_STATO_PADRE
	 * @generated
	 */
	protected Integer fkStatoPadre;

	/**
	 * Imposta il valore della proprieta' fkStatoPadre associata alla
	 * colonna FK_STATO_PADRE.
	 * @generated
	 */
	public void setFkStatoPadre(Integer val) {

		fkStatoPadre = val;

	}

	/**
	 * Legge il valore della proprieta' fkStatoPadre associata alla
	 * @generated
	 */
	public Integer getFkStatoPadre() {

		return fkStatoPadre;

	}

	/**
	 * store della proprieta' associata alla colonna STATO_PRATICA_ITA
	 * @generated
	 */
	protected String statoPraticaIta;

	/**
	 * Imposta il valore della proprieta' statoPraticaIta associata alla
	 * colonna STATO_PRATICA_ITA.
	 * @generated
	 */
	public void setStatoPraticaIta(String val) {

		statoPraticaIta = val;

	}

	/**
	 * Legge il valore della proprieta' statoPraticaIta associata alla
	 * @generated
	 */
	public String getStatoPraticaIta() {

		return statoPraticaIta;

	}

	/**
	 * store della proprieta' associata alla colonna STATO_PRATICA_FRA
	 * @generated
	 */
	protected String statoPraticaFra;

	/**
	 * Imposta il valore della proprieta' statoPraticaFra associata alla
	 * colonna STATO_PRATICA_FRA.
	 * @generated
	 */
	public void setStatoPraticaFra(String val) {

		statoPraticaFra = val;

	}

	/**
	 * Legge il valore della proprieta' statoPraticaFra associata alla
	 * @generated
	 */
	public String getStatoPraticaFra() {

		return statoPraticaFra;

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
	 * Crea una istanza di TaifDStatoPraticaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifDStatoPraticaPk
	 * @generated
	 */
	public TaifDStatoPraticaPk createPk() {
		return new TaifDStatoPraticaPk(idStatoPratica);
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
