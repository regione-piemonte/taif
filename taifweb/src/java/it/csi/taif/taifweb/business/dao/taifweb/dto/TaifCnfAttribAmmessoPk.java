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
 * Primary Key del DTO TaifCnfAttribAmmessoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifCnfAttribAmmessoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_MEZZO
	 * @generated
	 */
	protected Integer fkTipoMezzo;

	/**
	 * Imposta il valore della proprieta' fkTipoMezzo associata alla
	 * colonna FK_TIPO_MEZZO.
	 * @generated
	 */
	public void setFkTipoMezzo(Integer val) {

		fkTipoMezzo = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoMezzo associata alla
	 * @generated
	 */
	public Integer getFkTipoMezzo() {

		return fkTipoMezzo;

	}

	/**
	 * store della proprieta' associata alla colonna NOME_ATTRIB
	 * @generated
	 */
	protected String nomeAttrib;

	/**
	 * Imposta il valore della proprieta' nomeAttrib associata alla
	 * colonna NOME_ATTRIB.
	 * @generated
	 */
	public void setNomeAttrib(String val) {

		nomeAttrib = val;

	}

	/**
	 * Legge il valore della proprieta' nomeAttrib associata alla
	 * @generated
	 */
	public String getNomeAttrib() {

		return nomeAttrib;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifCnfAttribAmmessoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifCnfAttribAmmessoPk(

			final Integer fkTipoMezzo, final String nomeAttrib

	) {

		this.setFkTipoMezzo(fkTipoMezzo);

		this.setNomeAttrib(nomeAttrib);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifCnfAttribAmmessoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifCnfAttribAmmessoPk)) {
			return false;
		}

		final TaifCnfAttribAmmessoPk _cast = (TaifCnfAttribAmmessoPk) _other;

		if (fkTipoMezzo == null ? _cast.getFkTipoMezzo() != null : !fkTipoMezzo.equals(_cast.getFkTipoMezzo())) {
			return false;
		}

		if (nomeAttrib == null ? _cast.getNomeAttrib() != null : !nomeAttrib.equals(_cast.getNomeAttrib())) {
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

		if (fkTipoMezzo != null) {
			_hashCode = 29 * _hashCode + fkTipoMezzo.hashCode();
		}

		if (nomeAttrib != null) {
			_hashCode = 29 * _hashCode + nomeAttrib.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfAttribAmmessoPk: ");
		ret.append("fkTipoMezzo=" + fkTipoMezzo);

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfAttribAmmessoPk: ");
		ret.append("nomeAttrib=" + nomeAttrib);

		return ret.toString();
	}
}
