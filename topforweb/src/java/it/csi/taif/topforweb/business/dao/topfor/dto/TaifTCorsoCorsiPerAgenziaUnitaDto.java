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
 * DTO specifico della query modellata nel finder corsiPerAgenziaUnita.
 * @generated
 */
public class TaifTCorsoCorsiPerAgenziaUnitaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idCorso;

	/**
	 * @generated
	 */
	public void setIdCorso(Integer val) {

		idCorso = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdCorso() {

		return idCorso;

	}

	/*	 
	 * @generated
	 */
	private String descrizioneCorsoCorso;

	/**
	 * @generated
	 */
	public void setDescrizioneCorsoCorso(String val) {

		descrizioneCorsoCorso = val;

	}
	/**
	 * @generated
	 */
	public String getDescrizioneCorsoCorso() {

		return descrizioneCorsoCorso;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataInizioCorso;

	/**
	 * @generated
	 */
	public void setDataInizioCorso(java.sql.Timestamp val) {

		if (val != null) {
			dataInizioCorso = new java.sql.Timestamp(val.getTime());
		} else {
			dataInizioCorso = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataInizioCorso() {

		if (dataInizioCorso != null) {
			return new java.sql.Timestamp(dataInizioCorso.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataFineCorso;

	/**
	 * @generated
	 */
	public void setDataFineCorso(java.sql.Timestamp val) {

		if (val != null) {
			dataFineCorso = new java.sql.Timestamp(val.getTime());
		} else {
			dataFineCorso = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataFineCorso() {

		if (dataFineCorso != null) {
			return new java.sql.Timestamp(dataFineCorso.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String sedeCorso;

	/**
	 * @generated
	 */
	public void setSedeCorso(String val) {

		sedeCorso = val;

	}
	/**
	 * @generated
	 */
	public String getSedeCorso() {

		return sedeCorso;

	}

	/*	 
	 * @generated
	 */
	private String comuneEsteroSede;

	/**
	 * @generated
	 */
	public void setComuneEsteroSede(String val) {

		comuneEsteroSede = val;

	}
	/**
	 * @generated
	 */
	public String getComuneEsteroSede() {

		return comuneEsteroSede;

	}

	/*	 
	 * @generated
	 */
	private String indirizzoSede;

	/**
	 * @generated
	 */
	public void setIndirizzoSede(String val) {

		indirizzoSede = val;

	}
	/**
	 * @generated
	 */
	public String getIndirizzoSede() {

		return indirizzoSede;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal numeroOre;

	/**
	 * @generated
	 */
	public void setNumeroOre(java.math.BigDecimal val) {

		numeroOre = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getNumeroOre() {

		return numeroOre;

	}

	/*	 
	 * @generated
	 */
	private Integer idAgenziaFormativa;

	/**
	 * @generated
	 */
	public void setIdAgenziaFormativa(Integer val) {

		idAgenziaFormativa = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAgenziaFormativa() {

		return idAgenziaFormativa;

	}

	/*	 
	 * @generated
	 */
	private Integer idUnitaFormativa;

	/**
	 * @generated
	 */
	public void setIdUnitaFormativa(Integer val) {

		idUnitaFormativa = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdUnitaFormativa() {

		return idUnitaFormativa;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal flagVisibile;

	/**
	 * @generated
	 */
	public void setFlagVisibile(java.math.BigDecimal val) {

		flagVisibile = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFlagVisibile() {

		return flagVisibile;

	}

	/*	 
	 * @generated
	 */
	private String flagItaFr;

	/**
	 * @generated
	 */
	public void setFlagItaFr(String val) {

		flagItaFr = val;

	}
	/**
	 * @generated
	 */
	public String getFlagItaFr() {

		return flagItaFr;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal ordinamento;

	/**
	 * @generated
	 */
	public void setOrdinamento(java.math.BigDecimal val) {

		ordinamento = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getOrdinamento() {

		return ordinamento;

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
