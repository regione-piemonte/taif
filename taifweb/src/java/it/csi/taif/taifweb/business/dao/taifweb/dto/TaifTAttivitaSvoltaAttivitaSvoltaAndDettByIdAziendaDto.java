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
 * DTO specifico della query modellata nel finder attivitaSvoltaAndDettByIdAzienda.
 * @generated
 */
public class TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto implements Serializable {

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
	private String tipoAttivita;

	/**
	 * @generated
	 */
	public void setTipoAttivita(String val) {

		tipoAttivita = val;

	}
	/**
	 * @generated
	 */
	public String getTipoAttivita() {

		return tipoAttivita;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal fatturato;

	/**
	 * @generated
	 */
	public void setFatturato(java.math.BigDecimal val) {

		fatturato = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFatturato() {

		return fatturato;

	}

	/*	 
	 * @generated
	 */
	private String altreAttivita;

	/**
	 * @generated
	 */
	public void setAltreAttivita(String val) {

		altreAttivita = val;

	}
	/**
	 * @generated
	 */
	public String getAltreAttivita() {

		return altreAttivita;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataInserimento;

	/**
	 * @generated
	 */
	public void setDataInserimento(java.sql.Timestamp val) {

		if (val != null) {
			dataInserimento = new java.sql.Timestamp(val.getTime());
		} else {
			dataInserimento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataInserimento() {

		if (dataInserimento != null) {
			return new java.sql.Timestamp(dataInserimento.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataAggiornamento;

	/**
	 * @generated
	 */
	public void setDataAggiornamento(java.sql.Timestamp val) {

		if (val != null) {
			dataAggiornamento = new java.sql.Timestamp(val.getTime());
		} else {
			dataAggiornamento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataAggiornamento() {

		if (dataAggiornamento != null) {
			return new java.sql.Timestamp(dataAggiornamento.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private Integer progressivoDettaglio;

	/**
	 * @generated
	 */
	public void setProgressivoDettaglio(Integer val) {

		progressivoDettaglio = val;

	}
	/**
	 * @generated
	 */
	public Integer getProgressivoDettaglio() {

		return progressivoDettaglio;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal valore1Dettaglio;

	/**
	 * @generated
	 */
	public void setValore1Dettaglio(java.math.BigDecimal val) {

		valore1Dettaglio = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getValore1Dettaglio() {

		return valore1Dettaglio;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal valore2Dettaglio;

	/**
	 * @generated
	 */
	public void setValore2Dettaglio(java.math.BigDecimal val) {

		valore2Dettaglio = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getValore2Dettaglio() {

		return valore2Dettaglio;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal valore3Dettaglio;

	/**
	 * @generated
	 */
	public void setValore3Dettaglio(java.math.BigDecimal val) {

		valore3Dettaglio = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getValore3Dettaglio() {

		return valore3Dettaglio;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal percentualeContoTerzi;

	/**
	 * @generated
	 */
	public void setPercentualeContoTerzi(java.math.BigDecimal val) {

		percentualeContoTerzi = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPercentualeContoTerzi() {

		return percentualeContoTerzi;

	}

	/*	 
	 * @generated
	 */
	private Integer unitaMisuraDettaglio;

	/**
	 * @generated
	 */
	public void setUnitaMisuraDettaglio(Integer val) {

		unitaMisuraDettaglio = val;

	}
	/**
	 * @generated
	 */
	public Integer getUnitaMisuraDettaglio() {

		return unitaMisuraDettaglio;

	}

	/*	 
	 * @generated
	 */
	private Integer idTipoAttivita;

	/**
	 * @generated
	 */
	public void setIdTipoAttivita(Integer val) {

		idTipoAttivita = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoAttivita() {

		return idTipoAttivita;

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
