/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.filter;

import java.io.Serializable;


public class PersonaFilter implements Serializable {

	
	
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    
	private String codiceFiscale;
	private String nRsimsa;
	private String cognome;
	private String nome;
	private String idConfigUtente;
	private int idProfiloUtente;
	private int idSoggettoGestore;
	private int idNazione;
	
	
	
	public String getCodiceFiscale() {
	    return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
	    this.codiceFiscale = codiceFiscale;
	}
	public String getnRsimsa() {
	    return nRsimsa;
	}
	public void setnRsimsa(String nRsimsa) {
	    this.nRsimsa = nRsimsa;
	}
	public String getCognome() {
	    return cognome;
	}
	public void setCognome(String cognome) {
	    this.cognome = cognome;
	}
	public String getNome() {
	    return nome;
	}
	public void setNome(String nome) {
	    this.nome = nome;
	}
	public String getIdConfigUtente() {
	    return idConfigUtente;
	}
	public void setIdConfigUtente(String idConfigUtente) {
	    this.idConfigUtente = idConfigUtente;
	}
	public int getIdProfiloUtente() {
	    return idProfiloUtente;
	}
	public void setIdProfiloUtente(int idProfiloUtente) {
	    this.idProfiloUtente = idProfiloUtente;
	}
	public int getIdSoggettoGestore() {
	    return idSoggettoGestore;
	}
	public void setIdSoggettoGestore(int idSoggettoGestore) {
	    this.idSoggettoGestore = idSoggettoGestore;
	}
	public int getIdNazione() {
	    return idNazione;
	}
	public void setIdNazione(int idNazione) {
	    this.idNazione = idNazione;
	}
	
	
	
	
	
}
