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
 * Data transfer object relativo al DAO TaifCnfParamActaDao.
 * @generated
 */
public class TaifCnfParamActaDto extends TaifCnfParamActaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna CODICE
	 * @generated
	 */
	protected String codice;

	/**
	 * Imposta il valore della proprieta' codice associata alla
	 * colonna CODICE.
	 * @generated
	 */
	public void setCodice(String val) {

		codice = val;

	}

	/**
	 * Legge il valore della proprieta' codice associata alla
	 * @generated
	 */
	public String getCodice() {

		return codice;

	}

	/**
	 * store della proprieta' associata alla colonna VALORE
	 * @generated
	 */
	protected String valore;

	/**
	 * Imposta il valore della proprieta' valore associata alla
	 * colonna VALORE.
	 * @generated
	 */
	public void setValore(String val) {

		valore = val;

	}

	/**
	 * Legge il valore della proprieta' valore associata alla
	 * @generated
	 */
	public String getValore() {

		return valore;

	}

	/**
	 * Crea una istanza di TaifCnfParamActaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifCnfParamActaPk
	 * @generated
	 */
	public TaifCnfParamActaPk createPk() {
		return new TaifCnfParamActaPk(idConfigParamActa);
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
