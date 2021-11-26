/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class AllegatoObbligatorioFilter implements Serializable {

	private static final long serialVersionUID = 7454122225234067655L;
	
	private String flagContesto;
	private String flagFirma;
	private String flagItaFra;
	
	private int idPratica;

	/**
	 * @return the flagContesto
	 */
	public String getFlagContesto() {
		return flagContesto;
	}

	/**
	 * @param flagContesto the flagContesto to set
	 */
	public void setFlagContesto(String flagContesto) {
		this.flagContesto = flagContesto;
	}

	/**
	 * @return the flagFirma
	 */
	public String getFlagFirma() {
		return flagFirma;
	}

	/**
	 * @param flagFirma the flagFirma to set
	 */
	public void setFlagFirma(String flagFirma) {
		this.flagFirma = flagFirma;
	}

	/**
	 * @return the flagItaFra
	 */
	public String getFlagItaFra() {
		return flagItaFra;
	}

	/**
	 * @param flagItaFra the flagItaFra to set
	 */
	public void setFlagItaFra(String flagItaFra) {
		this.flagItaFra = flagItaFra;
	}

	/**
	 * @return the idPratica
	 */
	public int getIdPratica() {
		return idPratica;
	}

	/**
	 * @param idPratica the idPratica to set
	 */
	public void setIdPratica(int idPratica) {
		this.idPratica = idPratica;
	}
	
	

}
