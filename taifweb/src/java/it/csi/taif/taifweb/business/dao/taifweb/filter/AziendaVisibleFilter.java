/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class AziendaVisibleFilter implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int idAzienda;
	private int flagVisibile;
	private String flagItaFr;
	private int idTipoAttivita=0;
	
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
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
	public int getIdTipoAttivita() {
		return idTipoAttivita;
	}
	public void setIdTipoAttivita(int idTipoAttivita) {
		this.idTipoAttivita = idTipoAttivita;
	}

	
	
	
	
}
