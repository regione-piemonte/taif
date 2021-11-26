/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class UnitaFormativaFilter implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idUnitaFormativa;
	private int idAmbitoFormativo;
	private int idSoggettoGestore;
	private String unitaFormativa;
	private int flagVisibile;
	private String flagItaFr;
	
	
	public int getIdUnitaFormativa() {
		return idUnitaFormativa;
	}
	public void setIdUnitaFormativa(int idUnitaFormativa) {
		this.idUnitaFormativa = idUnitaFormativa;
	}
	public int getIdAmbitoFormativo() {
		return idAmbitoFormativo;
	}
	public void setIdAmbitoFormativo(int idAmbitoFormativo) {
		this.idAmbitoFormativo = idAmbitoFormativo;
	}
	public int getIdSoggettoGestore() {
		return idSoggettoGestore;
	}
	public void setIdSoggettoGestore(int idSoggettoGestore) {
		this.idSoggettoGestore = idSoggettoGestore;
	}
	public String getUnitaFormativa() {
		return unitaFormativa;
	}
	public void setUnitaFormativa(String unitaFormativa) {
		this.unitaFormativa = unitaFormativa;
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
	
	

	
}
