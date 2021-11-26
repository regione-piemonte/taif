/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;
import java.util.Date;

public class PersonaFilter implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idTitoloStudio;
	private int idTitoloStudioFra;
	private int idNazione;
	private String codiceFiscale;
	private String nRsimsa;
	private String cognome;
	private String nome;
	private String flSesso;
	private Date dataNascita;
	private String istatComNascita;
	private String comEsteroNascita;
	private String istatComRes;
	private String indirizzoRes;
	private String civicoRes;
	private String capRes;
	private String telefono;
	private String cellulare;
	private String mail;
	private String altriStudi;
	private String idConfigUtente;
	private int idProfiloUtente;
	private int idSoggettoGestore;
	
	
	public int getIdTitoloStudio() {
		return idTitoloStudio;
	}
	public void setIdTitoloStudio(int idTitoloStudio) {
		this.idTitoloStudio = idTitoloStudio;
	}
	public int getIdTitoloStudioFra() {
		return idTitoloStudioFra;
	}
	public void setIdTitoloStudioFra(int idTitoloStudioFra) {
		this.idTitoloStudioFra = idTitoloStudioFra;
	}
	public int getIdNazione() {
		return idNazione;
	}
	public void setIdNazione(int idNazione) {
		this.idNazione = idNazione;
	}
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
	public String getFlSesso() {
		return flSesso;
	}
	public void setFlSesso(String flSesso) {
		this.flSesso = flSesso;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getIstatComNascita() {
		return istatComNascita;
	}
	public void setIstatComNascita(String istatComNascita) {
		this.istatComNascita = istatComNascita;
	}
	public String getComEsteroNascita() {
		return comEsteroNascita;
	}
	public void setComEsteroNascita(String comEsteroNascita) {
		this.comEsteroNascita = comEsteroNascita;
	}
	public String getIstatComRes() {
		return istatComRes;
	}
	public void setIstatComRes(String istatComRes) {
		this.istatComRes = istatComRes;
	}
	public String getIndirizzoRes() {
		return indirizzoRes;
	}
	public void setIndirizzoRes(String indirizzoRes) {
		this.indirizzoRes = indirizzoRes;
	}
	public String getCivicoRes() {
		return civicoRes;
	}
	public void setCivicoRes(String civicoRes) {
		this.civicoRes = civicoRes;
	}
	public String getCapRes() {
		return capRes;
	}
	public void setCapRes(String capRes) {
		this.capRes = capRes;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCellulare() {
		return cellulare;
	}
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAltriStudi() {
		return altriStudi;
	}
	public void setAltriStudi(String altriStudi) {
		this.altriStudi = altriStudi;
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
	
	
	
	
	

}
