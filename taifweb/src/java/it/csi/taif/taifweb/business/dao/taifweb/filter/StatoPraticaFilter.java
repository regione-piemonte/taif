/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class StatoPraticaFilter implements Serializable {

	

	private static final long serialVersionUID = 1L;
	
	
	private int flagVisibile;
	private String flagItaFr;
	private String statoPraticaLang;
	private int fKStatoPraticaPadre;
	
	
	public StatoPraticaFilter(int flagVisibile) {
		this.flagVisibile = flagVisibile;
	}
	
	public StatoPraticaFilter() {}
	
	
	public int getFlagVisibile() {
		return flagVisibile;
	}
	public void setFlagVisibile(int flagVisibile) {
		this.flagVisibile = flagVisibile;
	}
	public String getFlagItaFr() {
		return flagItaFr;
	}
	public void setFlagItaFr(String flagItaFr) {
		this.flagItaFr = flagItaFr;
	}
	public String getStatoPraticaLang() {
		return statoPraticaLang;
	}
	public void setStatoPraticaLang(String statoPraticaLang) {
		this.statoPraticaLang = statoPraticaLang;
	}
	public int getfKStatoPraticaPadre() {
		return fKStatoPraticaPadre;
	}
	public void setfKStatoPraticaPadre(int fKStatoPraticaPadre) {
		this.fKStatoPraticaPadre = fKStatoPraticaPadre;
	}
	
	
}
