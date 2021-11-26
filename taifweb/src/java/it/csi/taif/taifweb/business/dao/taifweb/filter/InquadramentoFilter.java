/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class InquadramentoFilter  implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idInquadramento;
	private int flagVisibile;
	private String tipoInquadramento;
	
	
	public int getFlagVisibile() {
		return flagVisibile;
	}
	public void setFlagVisibile(int flagVisibile) {
		this.flagVisibile = flagVisibile;
	}

	public String getTipoInquadramento() {
		return tipoInquadramento;
	}
	public void setTipoInquadramento(String tipoInquadramento) {
		this.tipoInquadramento = tipoInquadramento;
	}
	public int getIdInquadramento() {
		return idInquadramento;
	}
	public void setIdInquadramento(int idInquadramento) {
		this.idInquadramento = idInquadramento;
	}
	
	
	
}
