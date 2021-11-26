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
 * DTO specifico della query modellata nel finder byIdAzienda.
 * @generated
 */
public class TaifTSedeAziendaByIdAziendaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer id;

	/**
	 * @generated
	 */
	public void setId(Integer val) {

		id = val;

	}
	/**
	 * @generated
	 */
	public Integer getId() {

		return id;

	}

	/*	 
	 * @generated
	 */
	private Integer idAzienda;

	/**
	 * @generated
	 */
	public void setIdAzienda(Integer val) {

		idAzienda = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAzienda() {

		return idAzienda;

	}

	/*	 
	 * @generated
	 */
	private Integer idTipo;

	/**
	 * @generated
	 */
	public void setIdTipo(Integer val) {

		idTipo = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipo() {

		return idTipo;

	}

	/*	 
	 * @generated
	 */
	private String istatComune;

	/**
	 * @generated
	 */
	public void setIstatComune(String val) {

		istatComune = val;

	}
	/**
	 * @generated
	 */
	public String getIstatComune() {

		return istatComune;

	}

	/*	 
	 * @generated
	 */
	private String estero;

	/**
	 * @generated
	 */
	public void setEstero(String val) {

		estero = val;

	}
	/**
	 * @generated
	 */
	public String getEstero() {

		return estero;

	}

	/*	 
	 * @generated
	 */
	private String indirizzo;

	/**
	 * @generated
	 */
	public void setIndirizzo(String val) {

		indirizzo = val;

	}
	/**
	 * @generated
	 */
	public String getIndirizzo() {

		return indirizzo;

	}

	/*	 
	 * @generated
	 */
	private String tipoSede;

	/**
	 * @generated
	 */
	public void setTipoSede(String val) {

		tipoSede = val;

	}
	/**
	 * @generated
	 */
	public String getTipoSede() {

		return tipoSede;

	}

	/*	 
	 * @generated
	 */
	private String civico;

	/**
	 * @generated
	 */
	public void setCivico(String val) {

		civico = val;

	}
	/**
	 * @generated
	 */
	public String getCivico() {

		return civico;

	}

	/*	 
	 * @generated
	 */
	private String cap;

	/**
	 * @generated
	 */
	public void setCap(String val) {

		cap = val;

	}
	/**
	 * @generated
	 */
	public String getCap() {

		return cap;

	}

	/*	 
	 * @generated
	 */
	private String telefon;

	/**
	 * @generated
	 */
	public void setTelefon(String val) {

		telefon = val;

	}
	/**
	 * @generated
	 */
	public String getTelefon() {

		return telefon;

	}

	/*	 
	 * @generated
	 */
	private String cellulare;

	/**
	 * @generated
	 */
	public void setCellulare(String val) {

		cellulare = val;

	}
	/**
	 * @generated
	 */
	public String getCellulare() {

		return cellulare;

	}

	/*	 
	 * @generated
	 */
	private String descrizioneTipoSede;

	/**
	 * @generated
	 */
	public void setDescrizioneTipoSede(String val) {

		descrizioneTipoSede = val;

	}
	/**
	 * @generated
	 */
	public String getDescrizioneTipoSede() {

		return descrizioneTipoSede;

	}

	/*	 
	 * @generated
	 */
	private String comune;

	/**
	 * @generated
	 */
	public void setComune(String val) {

		comune = val;

	}
	/**
	 * @generated
	 */
	public String getComune() {

		return comune;

	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 * @generated
	 */
	public boolean equals(Object _other) {
		return super.equals(_other);
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 * @generated
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
