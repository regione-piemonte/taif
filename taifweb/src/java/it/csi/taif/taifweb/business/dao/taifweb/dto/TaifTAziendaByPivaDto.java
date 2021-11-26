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
 * DTO specifico della query modellata nel finder byPiva.
 * @generated
 */
public class TaifTAziendaByPivaDto implements Serializable {

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
	private Integer prim;

	/**
	 * @generated
	 */
	public void setPrim(Integer val) {

		prim = val;

	}
	/**
	 * @generated
	 */
	public Integer getPrim() {

		return prim;

	}

	/*	 
	 * @generated
	 */
	private Integer sec;

	/**
	 * @generated
	 */
	public void setSec(Integer val) {

		sec = val;

	}
	/**
	 * @generated
	 */
	public Integer getSec() {

		return sec;

	}

	/*	 
	 * @generated
	 */
	private String cd;

	/**
	 * @generated
	 */
	public void setCd(String val) {

		cd = val;

	}
	/**
	 * @generated
	 */
	public String getCd() {

		return cd;

	}

	/*	 
	 * @generated
	 */
	private String rs;

	/**
	 * @generated
	 */
	public void setRs(String val) {

		rs = val;

	}
	/**
	 * @generated
	 */
	public String getRs() {

		return rs;

	}

	/*	 
	 * @generated
	 */
	private String desc;

	/**
	 * @generated
	 */
	public void setDesc(String val) {

		desc = val;

	}
	/**
	 * @generated
	 */
	public String getDesc() {

		return desc;

	}

	/*	 
	 * @generated
	 */
	private String piva;

	/**
	 * @generated
	 */
	public void setPiva(String val) {

		piva = val;

	}
	/**
	 * @generated
	 */
	public String getPiva() {

		return piva;

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
