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
 * Data transfer object relativo al DAO TaifCnfParamApimgrDao.
 * @generated
 */
public class TaifCnfParamApimgrDto extends TaifCnfParamApimgrPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna CONSUMER_KEY
	 * @generated
	 */
	protected String consumerKey;

	/**
	 * Imposta il valore della proprieta' consumerKey associata alla
	 * colonna CONSUMER_KEY.
	 * @generated
	 */
	public void setConsumerKey(String val) {

		consumerKey = val;

	}

	/**
	 * Legge il valore della proprieta' consumerKey associata alla
	 * @generated
	 */
	public String getConsumerKey() {

		return consumerKey;

	}

	/**
	 * store della proprieta' associata alla colonna CONSUMER_SECRET
	 * @generated
	 */
	protected String consumerSecret;

	/**
	 * Imposta il valore della proprieta' consumerSecret associata alla
	 * colonna CONSUMER_SECRET.
	 * @generated
	 */
	public void setConsumerSecret(String val) {

		consumerSecret = val;

	}

	/**
	 * Legge il valore della proprieta' consumerSecret associata alla
	 * @generated
	 */
	public String getConsumerSecret() {

		return consumerSecret;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INIZIO_VALIDITA
	 * @generated
	 */
	protected java.sql.Date dataInizioValidita;

	/**
	 * Imposta il valore della proprieta' dataInizioValidita associata alla
	 * colonna DATA_INIZIO_VALIDITA.
	 * @generated
	 */
	public void setDataInizioValidita(java.sql.Date val) {

		if (val != null) {
			dataInizioValidita = new java.sql.Date(val.getTime());
		} else {
			dataInizioValidita = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInizioValidita associata alla
	 * @generated
	 */
	public java.sql.Date getDataInizioValidita() {

		if (dataInizioValidita != null) {
			return new java.sql.Date(dataInizioValidita.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_FINE_VALIDITA
	 * @generated
	 */
	protected java.sql.Date dataFineValidita;

	/**
	 * Imposta il valore della proprieta' dataFineValidita associata alla
	 * colonna DATA_FINE_VALIDITA.
	 * @generated
	 */
	public void setDataFineValidita(java.sql.Date val) {

		if (val != null) {
			dataFineValidita = new java.sql.Date(val.getTime());
		} else {
			dataFineValidita = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataFineValidita associata alla
	 * @generated
	 */
	public java.sql.Date getDataFineValidita() {

		if (dataFineValidita != null) {
			return new java.sql.Date(dataFineValidita.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Crea una istanza di TaifCnfParamApimgrPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifCnfParamApimgrPk
	 * @generated
	 */
	public TaifCnfParamApimgrPk createPk() {
		return new TaifCnfParamApimgrPk(idConfigParamApimgr);
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
