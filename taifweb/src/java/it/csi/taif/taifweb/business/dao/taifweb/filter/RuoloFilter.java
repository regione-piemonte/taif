/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class RuoloFilter  implements Serializable {
	

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idRuolo;
	private String ruoloName;
	private int flagVisibile;
	
	
	public String getRuoloName() {
		return ruoloName;
	}
	public void setRuoloName(String ruoloName) {
		this.ruoloName = ruoloName;
	}
	public int getFlagVisibile() {
		return flagVisibile;
	}
	public void setFlagVisibile(int flagVisibile) {
		this.flagVisibile = flagVisibile;
	}
	public int getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}
	
	
	
}
