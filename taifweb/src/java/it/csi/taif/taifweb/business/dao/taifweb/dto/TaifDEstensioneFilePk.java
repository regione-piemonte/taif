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
 * Primary Key del DTO TaifDEstensioneFileDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDEstensioneFilePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_ESTENSIONE_FILE
	 * @generated
	 */
	protected Integer idEstensioneFile;

	/**
	 * Imposta il valore della proprieta' idEstensioneFile associata alla
	 * colonna ID_ESTENSIONE_FILE.
	 * @generated
	 */
	public void setIdEstensioneFile(Integer val) {

		idEstensioneFile = val;

	}

	/**
	 * Legge il valore della proprieta' idEstensioneFile associata alla
	 * @generated
	 */
	public Integer getIdEstensioneFile() {

		return idEstensioneFile;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDEstensioneFilePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDEstensioneFilePk(

			final Integer idEstensioneFile

	) {

		this.setIdEstensioneFile(idEstensioneFile);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDEstensioneFilePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDEstensioneFilePk)) {
			return false;
		}

		final TaifDEstensioneFilePk _cast = (TaifDEstensioneFilePk) _other;

		if (idEstensioneFile == null
				? _cast.getIdEstensioneFile() != null
				: !idEstensioneFile.equals(_cast.getIdEstensioneFile())) {
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

		if (idEstensioneFile != null) {
			_hashCode = 29 * _hashCode + idEstensioneFile.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDEstensioneFilePk: ");
		ret.append("idEstensioneFile=" + idEstensioneFile);

		return ret.toString();
	}
}
