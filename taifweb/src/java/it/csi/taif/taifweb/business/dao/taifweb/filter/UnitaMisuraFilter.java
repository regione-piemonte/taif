/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class UnitaMisuraFilter implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUnitaMisura;
	private int flagVisible;
	
	private String unitaMisura;
	
	
	public int getFlagVisible() {
		return flagVisible;
	}
	public void setFlagVisible(int flagVisible) {
		this.flagVisible = flagVisible;
	}
	public String getUnitaMisura() {
		return unitaMisura;
	}
	public void setUnitaMisura(String unitaMisura) {
		this.unitaMisura = unitaMisura;
	}
	public int getIdUnitaMisura() {
		return idUnitaMisura;
	}
	public void setIdUnitaMisura(int idUnitaMisura) {
		this.idUnitaMisura = idUnitaMisura;
	}
	
	
	
	
	
}
