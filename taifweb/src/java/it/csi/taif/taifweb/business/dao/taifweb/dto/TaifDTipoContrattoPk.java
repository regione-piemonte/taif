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
 * Primary Key del DTO TaifDTipoContrattoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTipoContrattoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_CONTRATTO
	 * @generated
	 */
	protected Integer idTipoContratto;

	/**
	 * Imposta il valore della proprieta' idTipoContratto associata alla
	 * colonna ID_TIPO_CONTRATTO.
	 * @generated
	 */
	public void setIdTipoContratto(Integer val) {

		idTipoContratto = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoContratto associata alla
	 * @generated
	 */
	public Integer getIdTipoContratto() {

		return idTipoContratto;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTipoContrattoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTipoContrattoPk(

			final Integer idTipoContratto

	) {

		this.setIdTipoContratto(idTipoContratto);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTipoContrattoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTipoContrattoPk)) {
			return false;
		}

		final TaifDTipoContrattoPk _cast = (TaifDTipoContrattoPk) _other;

		if (idTipoContratto == null
				? _cast.getIdTipoContratto() != null
				: !idTipoContratto.equals(_cast.getIdTipoContratto())) {
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

		if (idTipoContratto != null) {
			_hashCode = 29 * _hashCode + idTipoContratto.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoContrattoPk: ");
		ret.append("idTipoContratto=" + idTipoContratto);

		return ret.toString();
	}
}
