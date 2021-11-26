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
 * DTO specifico della query modellata nel finder lavoroPaByAziendaVisibile.
 * @generated
 */
public class TaifTLavoroPaLavoroPaByAziendaVisibileDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idLavoro;

	/**
	 * @generated
	 */
	public void setIdLavoro(Integer val) {

		idLavoro = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdLavoro() {

		return idLavoro;

	}

	/*	 
	 * @generated
	 */
	private String commitente;

	/**
	 * @generated
	 */
	public void setCommitente(String val) {

		commitente = val;

	}
	/**
	 * @generated
	 */
	public String getCommitente() {

		return commitente;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal importo;

	/**
	 * @generated
	 */
	public void setImporto(java.math.BigDecimal val) {

		importo = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getImporto() {

		return importo;

	}

	/*	 
	 * @generated
	 */
	private String tipoLavoro;

	/**
	 * @generated
	 */
	public void setTipoLavoro(String val) {

		tipoLavoro = val;

	}
	/**
	 * @generated
	 */
	public String getTipoLavoro() {

		return tipoLavoro;

	}

	/*	 
	 * @generated
	 */
	private Integer idTipoLavoro;

	/**
	 * @generated
	 */
	public void setIdTipoLavoro(Integer val) {

		idTipoLavoro = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoLavoro() {

		return idTipoLavoro;

	}

	/*	 
	 * @generated
	 */
	private Integer fkAzienda;

	/**
	 * @generated
	 */
	public void setFkAzienda(Integer val) {

		fkAzienda = val;

	}
	/**
	 * @generated
	 */
	public Integer getFkAzienda() {

		return fkAzienda;

	}

	/*	 
	 * @generated
	 */
	private String descAltroLavoro;

	/**
	 * @generated
	 */
	public void setDescAltroLavoro(String val) {

		descAltroLavoro = val;

	}
	/**
	 * @generated
	 */
	public String getDescAltroLavoro() {

		return descAltroLavoro;

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
