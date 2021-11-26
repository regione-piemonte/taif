/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dto;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO TaifDUnitaFormativaDao.
 * @generated
 */
public class TaifDUnitaFormativaDto extends TaifDUnitaFormativaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_AMBITO_FORMATIVO
	 * @generated
	 */
	protected Integer fkAmbitoFormativo;

	/**
	 * Imposta il valore della proprieta' fkAmbitoFormativo associata alla
	 * colonna FK_AMBITO_FORMATIVO.
	 * @generated
	 */
	public void setFkAmbitoFormativo(Integer val) {

		fkAmbitoFormativo = val;

	}

	/**
	 * Legge il valore della proprieta' fkAmbitoFormativo associata alla
	 * @generated
	 */
	public Integer getFkAmbitoFormativo() {

		return fkAmbitoFormativo;

	}

	/**
	 * store della proprieta' associata alla colonna FK_SOGGETTO_GESTORE
	 * @generated
	 */
	protected Integer fkSoggettoGestore;

	/**
	 * Imposta il valore della proprieta' fkSoggettoGestore associata alla
	 * colonna FK_SOGGETTO_GESTORE.
	 * @generated
	 */
	public void setFkSoggettoGestore(Integer val) {

		fkSoggettoGestore = val;

	}

	/**
	 * Legge il valore della proprieta' fkSoggettoGestore associata alla
	 * @generated
	 */
	public Integer getFkSoggettoGestore() {

		return fkSoggettoGestore;

	}

	/**
	 * store della proprieta' associata alla colonna UNITA_FORMATIVA
	 * @generated
	 */
	protected String unitaFormativa;

	/**
	 * Imposta il valore della proprieta' unitaFormativa associata alla
	 * colonna UNITA_FORMATIVA.
	 * @generated
	 */
	public void setUnitaFormativa(String val) {

		unitaFormativa = val;

	}

	/**
	 * Legge il valore della proprieta' unitaFormativa associata alla
	 * @generated
	 */
	public String getUnitaFormativa() {

		return unitaFormativa;

	}

	/**
	 * store della proprieta' associata alla colonna SIGLA
	 * @generated
	 */
	protected String sigla;

	/**
	 * Imposta il valore della proprieta' sigla associata alla
	 * colonna SIGLA.
	 * @generated
	 */
	public void setSigla(String val) {

		sigla = val;

	}

	/**
	 * Legge il valore della proprieta' sigla associata alla
	 * @generated
	 */
	public String getSigla() {

		return sigla;

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
	 * Crea una istanza di TaifDUnitaFormativaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifDUnitaFormativaPk
	 * @generated
	 */
	public TaifDUnitaFormativaPk createPk() {
		return new TaifDUnitaFormativaPk(idUnitaFormativa);
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
