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
 * Data transfer object relativo al DAO TaifCnfMailDao.
 * @generated
 */
public class TaifCnfMailDto extends TaifCnfMailPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna HOST
	 * @generated
	 */
	protected String host;

	/**
	 * Imposta il valore della proprieta' host associata alla
	 * colonna HOST.
	 * @generated
	 */
	public void setHost(String val) {

		host = val;

	}

	/**
	 * Legge il valore della proprieta' host associata alla
	 * @generated
	 */
	public String getHost() {

		return host;

	}

	/**
	 * store della proprieta' associata alla colonna PORTA
	 * @generated
	 */
	protected java.math.BigDecimal porta;

	/**
	 * Imposta il valore della proprieta' porta associata alla
	 * colonna PORTA.
	 * @generated
	 */
	public void setPorta(java.math.BigDecimal val) {

		porta = val;

	}

	/**
	 * Legge il valore della proprieta' porta associata alla
	 * @generated
	 */
	public java.math.BigDecimal getPorta() {

		return porta;

	}

	/**
	 * store della proprieta' associata alla colonna USER_ID
	 * @generated
	 */
	protected String userId;

	/**
	 * Imposta il valore della proprieta' userId associata alla
	 * colonna USER_ID.
	 * @generated
	 */
	public void setUserId(String val) {

		userId = val;

	}

	/**
	 * Legge il valore della proprieta' userId associata alla
	 * @generated
	 */
	public String getUserId() {

		return userId;

	}

	/**
	 * store della proprieta' associata alla colonna PASSWORD
	 * @generated
	 */
	protected String password;

	/**
	 * Imposta il valore della proprieta' password associata alla
	 * colonna PASSWORD.
	 * @generated
	 */
	public void setPassword(String val) {

		password = val;

	}

	/**
	 * Legge il valore della proprieta' password associata alla
	 * @generated
	 */
	public String getPassword() {

		return password;

	}

	/**
	 * store della proprieta' associata alla colonna PROTOCOLLO
	 * @generated
	 */
	protected String protocollo;

	/**
	 * Imposta il valore della proprieta' protocollo associata alla
	 * colonna PROTOCOLLO.
	 * @generated
	 */
	public void setProtocollo(String val) {

		protocollo = val;

	}

	/**
	 * Legge il valore della proprieta' protocollo associata alla
	 * @generated
	 */
	public String getProtocollo() {

		return protocollo;

	}

	/**
	 * store della proprieta' associata alla colonna MITTENTE
	 * @generated
	 */
	protected String mittente;

	/**
	 * Imposta il valore della proprieta' mittente associata alla
	 * colonna MITTENTE.
	 * @generated
	 */
	public void setMittente(String val) {

		mittente = val;

	}

	/**
	 * Legge il valore della proprieta' mittente associata alla
	 * @generated
	 */
	public String getMittente() {

		return mittente;

	}

	/**
	 * store della proprieta' associata alla colonna DES_TIPO_POSTA
	 * @generated
	 */
	protected String desTipoPosta;

	/**
	 * Imposta il valore della proprieta' desTipoPosta associata alla
	 * colonna DES_TIPO_POSTA.
	 * @generated
	 */
	public void setDesTipoPosta(String val) {

		desTipoPosta = val;

	}

	/**
	 * Legge il valore della proprieta' desTipoPosta associata alla
	 * @generated
	 */
	public String getDesTipoPosta() {

		return desTipoPosta;

	}

	/**
	 * Crea una istanza di TaifCnfMailPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifCnfMailPk
	 * @generated
	 */
	public TaifCnfMailPk createPk() {
		return new TaifCnfMailPk(idMail);
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
