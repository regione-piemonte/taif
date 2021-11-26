/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class AttivitaSvoltaDettFilter implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idAttivita;
	private int valore1;
	private int valore2;
	private int valore3;
	
	
	public int getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(int idAttivita) {
		this.idAttivita = idAttivita;
	}
	public int getValore1() {
		return valore1;
	}
	public void setValore1(int valore1) {
		this.valore1 = valore1;
	}
	public int getValore2() {
		return valore2;
	}
	public void setValore2(int valore2) {
		this.valore2 = valore2;
	}
	public int getValore3() {
		return valore3;
	}
	public void setValore3(int valore3) {
		this.valore3 = valore3;
	}
	
	

}
