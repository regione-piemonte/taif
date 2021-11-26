/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class CertificazioneFilter implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int idAzienda;
	private int tipoCertificazione;
	
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
	public int getTipoCertificazione() {
		return tipoCertificazione;
	}
	public void setTipoCertificazione(int tipoCertificazione) {
		this.tipoCertificazione = tipoCertificazione;
	}
	
	
	
}
