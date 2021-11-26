/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class AttribAmmessoFilter  implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idTipoMezzo;
	private String nomeAttrib;
	
	public int getIdTipoMezzo() {
		return idTipoMezzo;
	}
	public void setIdTipoMezzo(int idTipoMezzo) {
		this.idTipoMezzo = idTipoMezzo;
	}
	public String getNomeAttrib() {
		return nomeAttrib;
	}
	public void setNomeAttrib(String nomeAttrib) {
		this.nomeAttrib = nomeAttrib;
	}
	
	

}
