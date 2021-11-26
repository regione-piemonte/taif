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
 * Primary Key del DTO TaifTRiconoscimentoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTRiconoscimentoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_RICONOSCIMENTO
	 * @generated
	 */
	protected Integer idRiconoscimento;

	/**
	 * Imposta il valore della proprieta' idRiconoscimento associata alla
	 * colonna ID_RICONOSCIMENTO.
	 * @generated
	 */
	public void setIdRiconoscimento(Integer val) {

		idRiconoscimento = val;

	}

	/**
	 * Legge il valore della proprieta' idRiconoscimento associata alla
	 * @generated
	 */
	public Integer getIdRiconoscimento() {

		return idRiconoscimento;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTRiconoscimentoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTRiconoscimentoPk(

			final Integer idRiconoscimento

	) {

		this.setIdRiconoscimento(idRiconoscimento);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTRiconoscimentoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTRiconoscimentoPk)) {
			return false;
		}

		final TaifTRiconoscimentoPk _cast = (TaifTRiconoscimentoPk) _other;

		if (idRiconoscimento == null
				? _cast.getIdRiconoscimento() != null
				: !idRiconoscimento.equals(_cast.getIdRiconoscimento())) {
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

		if (idRiconoscimento != null) {
			_hashCode = 29 * _hashCode + idRiconoscimento.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTRiconoscimentoPk: ");
		ret.append("idRiconoscimento=" + idRiconoscimento);

		return ret.toString();
	}
}
