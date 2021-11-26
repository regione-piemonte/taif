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
 * Primary Key del DTO TaifDTipoSedeAziendaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTipoSedeAziendaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_SEDE
	 * @generated
	 */
	protected Integer idTipoSede;

	/**
	 * Imposta il valore della proprieta' idTipoSede associata alla
	 * colonna ID_TIPO_SEDE.
	 * @generated
	 */
	public void setIdTipoSede(Integer val) {

		idTipoSede = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoSede associata alla
	 * @generated
	 */
	public Integer getIdTipoSede() {

		return idTipoSede;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTipoSedeAziendaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTipoSedeAziendaPk(

			final Integer idTipoSede

	) {

		this.setIdTipoSede(idTipoSede);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTipoSedeAziendaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTipoSedeAziendaPk)) {
			return false;
		}

		final TaifDTipoSedeAziendaPk _cast = (TaifDTipoSedeAziendaPk) _other;

		if (idTipoSede == null ? _cast.getIdTipoSede() != null : !idTipoSede.equals(_cast.getIdTipoSede())) {
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

		if (idTipoSede != null) {
			_hashCode = 29 * _hashCode + idTipoSede.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoSedeAziendaPk: ");
		ret.append("idTipoSede=" + idTipoSede);

		return ret.toString();
	}
}
