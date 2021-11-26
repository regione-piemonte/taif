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
 * Primary Key del DTO TaifCnfEstensAmmDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifCnfEstensAmmPk implements Serializable {

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
	 * store della proprieta' associata alla colonna ID_TIPO_ALLEGATO
	 * @generated
	 */
	protected Integer idTipoAllegato;

	/**
	 * Imposta il valore della proprieta' idTipoAllegato associata alla
	 * colonna ID_TIPO_ALLEGATO.
	 * @generated
	 */
	public void setIdTipoAllegato(Integer val) {

		idTipoAllegato = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoAllegato associata alla
	 * @generated
	 */
	public Integer getIdTipoAllegato() {

		return idTipoAllegato;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifCnfEstensAmmPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifCnfEstensAmmPk(

			final Integer idEstensioneFile, final Integer idTipoAllegato

	) {

		this.setIdEstensioneFile(idEstensioneFile);

		this.setIdTipoAllegato(idTipoAllegato);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifCnfEstensAmmPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifCnfEstensAmmPk)) {
			return false;
		}

		final TaifCnfEstensAmmPk _cast = (TaifCnfEstensAmmPk) _other;

		if (idEstensioneFile == null
				? _cast.getIdEstensioneFile() != null
				: !idEstensioneFile.equals(_cast.getIdEstensioneFile())) {
			return false;
		}

		if (idTipoAllegato == null
				? _cast.getIdTipoAllegato() != null
				: !idTipoAllegato.equals(_cast.getIdTipoAllegato())) {
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

		if (idTipoAllegato != null) {
			_hashCode = 29 * _hashCode + idTipoAllegato.hashCode();
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

		ret.append("it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfEstensAmmPk: ");
		ret.append("idEstensioneFile=" + idEstensioneFile);

		ret.append("it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfEstensAmmPk: ");
		ret.append("idTipoAllegato=" + idTipoAllegato);

		return ret.toString();
	}
}
