/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;
import java.util.Date;

public class PraticaFilter implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idPratica;
	private int idAzienda;
	private int idSoggettoGestore;
	private Date dataInscrizioneAlbo;
	private String numeroAlbo;
	
	public int getIdPratica() {
		return idPratica;
	}
	public void setIdPratica(int idPratica) {
		this.idPratica = idPratica;
	}
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
	public int getIdSoggettoGestore() {
		return idSoggettoGestore;
	}
	public void setIdSoggettoGestore(int idSoggettoGestore) {
		this.idSoggettoGestore = idSoggettoGestore;
	}
	public Date getDataInscrizioneAlbo() {
		return dataInscrizioneAlbo;
	}
	public void setDataInscrizioneAlbo(Date dataInscrizioneAlbo) {
		this.dataInscrizioneAlbo = dataInscrizioneAlbo;
	}
	public String getNumeroAlbo() {
		return numeroAlbo;
	}
	public void setNumeroAlbo(String numeroAlbo) {
		this.numeroAlbo = numeroAlbo;
	}
	
	
	

}
