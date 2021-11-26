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
 * Primary Key del DTO TaifROpfoCorsoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifROpfoCorsoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CORSO
	 * @generated
	 */
	protected Integer idCorso;

	/**
	 * Imposta il valore della proprieta' idCorso associata alla
	 * colonna ID_CORSO.
	 * @generated
	 */
	public void setIdCorso(Integer val) {

		idCorso = val;

	}

	/**
	 * Legge il valore della proprieta' idCorso associata alla
	 * @generated
	 */
	public Integer getIdCorso() {

		return idCorso;

	}

	/**
	 * store della proprieta' associata alla colonna ID_PERSONA
	 * @generated
	 */
	protected Integer idPersona;

	/**
	 * Imposta il valore della proprieta' idPersona associata alla
	 * colonna ID_PERSONA.
	 * @generated
	 */
	public void setIdPersona(Integer val) {

		idPersona = val;

	}

	/**
	 * Legge il valore della proprieta' idPersona associata alla
	 * @generated
	 */
	public Integer getIdPersona() {

		return idPersona;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifROpfoCorsoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifROpfoCorsoPk(

			final Integer idCorso, final Integer idPersona

	) {

		this.setIdCorso(idCorso);

		this.setIdPersona(idPersona);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifROpfoCorsoPk sono equals se i valori di tutti i campi coincidono.
	 * 
	 * @param _other
	 * @return boolean se i due oggetti sono uguali
	 */
	public boolean equals(Object _other) {
		if (_other == null) {
			return false;
		}

		if (_other == this) {
			return true;
		}

		if (!(_other instanceof TaifROpfoCorsoPk)) {
			return false;
		}

		final TaifROpfoCorsoPk _cast = (TaifROpfoCorsoPk) _other;

		if (idCorso == null ? _cast.getIdCorso() != null : !idCorso.equals(_cast.getIdCorso())) {
			return false;
		}

		if (idPersona == null ? _cast.getIdPersona() != null : !idPersona.equals(_cast.getIdPersona())) {
			return false;
		}

		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode() {
		int _hashCode = 0;

		if (idCorso != null) {
			_hashCode = 29 * _hashCode + idCorso.hashCode();
		}

		if (idPersona != null) {
			_hashCode = 29 * _hashCode + idPersona.hashCode();
		}

		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();

		ret.append("it.csi.taif.topforweb.business.dao.topfor.dto.TaifROpfoCorsoPk: ");
		ret.append("idCorso=" + idCorso);

		ret.append("it.csi.taif.topforweb.business.dao.topfor.dto.TaifROpfoCorsoPk: ");
		ret.append("idPersona=" + idPersona);

		return ret.toString();
	}
}
