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
 * Primary Key del DTO TaifRAttivDetMaterialeDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifRAttivDetMaterialePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_MATERIALE
	 * @generated
	 */
	protected Integer idMateriale;

	/**
	 * Imposta il valore della proprieta' idMateriale associata alla
	 * colonna ID_MATERIALE.
	 * @generated
	 */
	public void setIdMateriale(Integer val) {

		idMateriale = val;

	}

	/**
	 * Legge il valore della proprieta' idMateriale associata alla
	 * @generated
	 */
	public Integer getIdMateriale() {

		return idMateriale;

	}

	/**
	 * store della proprieta' associata alla colonna ID_ATTIVITA
	 * @generated
	 */
	protected Integer idAttivita;

	/**
	 * Imposta il valore della proprieta' idAttivita associata alla
	 * colonna ID_ATTIVITA.
	 * @generated
	 */
	public void setIdAttivita(Integer val) {

		idAttivita = val;

	}

	/**
	 * Legge il valore della proprieta' idAttivita associata alla
	 * @generated
	 */
	public Integer getIdAttivita() {

		return idAttivita;

	}

	/**
	 * store della proprieta' associata alla colonna PROGRESSIVO
	 * @generated
	 */
	protected Integer progressivo;

	/**
	 * Imposta il valore della proprieta' progressivo associata alla
	 * colonna PROGRESSIVO.
	 * @generated
	 */
	public void setProgressivo(Integer val) {

		progressivo = val;

	}

	/**
	 * Legge il valore della proprieta' progressivo associata alla
	 * @generated
	 */
	public Integer getProgressivo() {

		return progressivo;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifRAttivDetMaterialePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifRAttivDetMaterialePk(

			final Integer idMateriale, final Integer idAttivita, final Integer progressivo

	) {

		this.setIdMateriale(idMateriale);

		this.setIdAttivita(idAttivita);

		this.setProgressivo(progressivo);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifRAttivDetMaterialePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifRAttivDetMaterialePk)) {
			return false;
		}

		final TaifRAttivDetMaterialePk _cast = (TaifRAttivDetMaterialePk) _other;

		if (idMateriale == null ? _cast.getIdMateriale() != null : !idMateriale.equals(_cast.getIdMateriale())) {
			return false;
		}

		if (idAttivita == null ? _cast.getIdAttivita() != null : !idAttivita.equals(_cast.getIdAttivita())) {
			return false;
		}

		if (progressivo == null ? _cast.getProgressivo() != null : !progressivo.equals(_cast.getProgressivo())) {
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

		if (idMateriale != null) {
			_hashCode = 29 * _hashCode + idMateriale.hashCode();
		}

		if (idAttivita != null) {
			_hashCode = 29 * _hashCode + idAttivita.hashCode();
		}

		if (progressivo != null) {
			_hashCode = 29 * _hashCode + progressivo.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAttivDetMaterialePk: ");
		ret.append("idMateriale=" + idMateriale);

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAttivDetMaterialePk: ");
		ret.append("idAttivita=" + idAttivita);

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAttivDetMaterialePk: ");
		ret.append("progressivo=" + progressivo);

		return ret.toString();
	}
}
