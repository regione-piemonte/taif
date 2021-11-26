/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.filter;

import java.io.Serializable;

public class CorsoProfessionaleFilter  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String idCorso;


	public String getIdCorso() {
		return idCorso;
	}


	public void setIdCorso(String idCorso) {
		this.idCorso = idCorso;
	}



	

}
