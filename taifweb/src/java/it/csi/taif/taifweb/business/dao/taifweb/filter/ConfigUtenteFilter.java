/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class ConfigUtenteFilter implements Serializable {
	
	private int idProfiloUtente;
	private int idPersona;
	
	public int getIdProfiloUtente() {
		return idProfiloUtente;
	}
	public void setIdProfiloUtente(int idProfiloUtente) {
		this.idProfiloUtente = idProfiloUtente;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

}
