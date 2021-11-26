/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class StrutturaFilter  implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private int idAzienda;
	private int idFunzione;
	private int idConfigUtente;
	
	
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
	public int getIdFunzione() {
		return idFunzione;
	}
	public void setIdFunzione(int idFunzione) {
		this.idFunzione = idFunzione;
	}
	public int getIdConfigUtente() {
		return idConfigUtente;
	}
	public void setIdConfigUtente(int idConfigUtente) {
		this.idConfigUtente = idConfigUtente;
	}
	
	

}
