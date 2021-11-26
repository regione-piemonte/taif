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
 * Primary Key del DTO TaifDTitoloStudioDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTitoloStudioPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TITOLO_STUDIO
	 * @generated
	 */
	protected Integer idTitoloStudio;

	/**
	 * Imposta il valore della proprieta' idTitoloStudio associata alla
	 * colonna ID_TITOLO_STUDIO.
	 * @generated
	 */
	public void setIdTitoloStudio(Integer val) {

		idTitoloStudio = val;

	}

	/**
	 * Legge il valore della proprieta' idTitoloStudio associata alla
	 * @generated
	 */
	public Integer getIdTitoloStudio() {

		return idTitoloStudio;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTitoloStudioPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTitoloStudioPk(

			final Integer idTitoloStudio

	) {

		this.setIdTitoloStudio(idTitoloStudio);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTitoloStudioPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTitoloStudioPk)) {
			return false;
		}

		final TaifDTitoloStudioPk _cast = (TaifDTitoloStudioPk) _other;

		if (idTitoloStudio == null
				? _cast.getIdTitoloStudio() != null
				: !idTitoloStudio.equals(_cast.getIdTitoloStudio())) {
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

		if (idTitoloStudio != null) {
			_hashCode = 29 * _hashCode + idTitoloStudio.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTitoloStudioPk: ");
		ret.append("idTitoloStudio=" + idTitoloStudio);

		return ret.toString();
	}
}
