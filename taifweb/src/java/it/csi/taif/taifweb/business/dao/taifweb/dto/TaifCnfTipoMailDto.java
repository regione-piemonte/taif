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
 * Data transfer object relativo al DAO TaifCnfTipoMailDao.
 * @generated
 */
public class TaifCnfTipoMailDto extends TaifCnfTipoMailPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_STATO_PRATICA
	 * @generated
	 */
	protected Integer fkStatoPratica;

	/**
	 * Imposta il valore della proprieta' fkStatoPratica associata alla
	 * colonna FK_STATO_PRATICA.
	 * @generated
	 */
	public void setFkStatoPratica(Integer val) {

		fkStatoPratica = val;

	}

	/**
	 * Legge il valore della proprieta' fkStatoPratica associata alla
	 * @generated
	 */
	public Integer getFkStatoPratica() {

		return fkStatoPratica;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_TIPO_MAIL
	 * @generated
	 */
	protected java.math.BigDecimal flgTipoMail;

	/**
	 * Imposta il valore della proprieta' flgTipoMail associata alla
	 * colonna FLG_TIPO_MAIL.
	 * @generated
	 */
	public void setFlgTipoMail(java.math.BigDecimal val) {

		flgTipoMail = val;

	}

	/**
	 * Legge il valore della proprieta' flgTipoMail associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgTipoMail() {

		return flgTipoMail;

	}

	/**
	 * store della proprieta' associata alla colonna OGGETTO
	 * @generated
	 */
	protected String oggetto;

	/**
	 * Imposta il valore della proprieta' oggetto associata alla
	 * colonna OGGETTO.
	 * @generated
	 */
	public void setOggetto(String val) {

		oggetto = val;

	}

	/**
	 * Legge il valore della proprieta' oggetto associata alla
	 * @generated
	 */
	public String getOggetto() {

		return oggetto;

	}

	/**
	 * store della proprieta' associata alla colonna TESTO
	 * @generated
	 */
	protected String testo;

	/**
	 * Imposta il valore della proprieta' testo associata alla
	 * colonna TESTO.
	 * @generated
	 */
	public void setTesto(String val) {

		testo = val;

	}

	/**
	 * Legge il valore della proprieta' testo associata alla
	 * @generated
	 */
	public String getTesto() {

		return testo;

	}

	/**
	 * Crea una istanza di TaifCnfTipoMailPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifCnfTipoMailPk
	 * @generated
	 */
	public TaifCnfTipoMailPk createPk() {
		return new TaifCnfTipoMailPk(idTipoMail);
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
