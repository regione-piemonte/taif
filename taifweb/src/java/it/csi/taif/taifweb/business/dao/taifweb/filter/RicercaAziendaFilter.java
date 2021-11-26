/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import it.csi.taif.taifweb.dto.domanda.Attivita;

public class RicercaAziendaFilter implements Serializable {
	
	
	
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private List<String> alboAppartenenza;
	private String denominazioneAzienda;
	private String titolare;
	private String codiceFiscaleAzienda;
	private String numeroAlbo;
	private Date dataDa;
	private Date dataA;
	private String istatComune;
	private List<String> sezione;
	private List<String> listaCategoriaImpresa;
	private String appartenenzaAltriAlbi;
	private String appartenenzaCertificazioni;
	private List<Attivita> attivitaSvolteList;
	private int tipoSede;
	private int idRuolo;
	private int statoPratica;
	private boolean ricercaLibera;
	private int idSoggettoGestore;
	private String istatProvincia;
	
	
	public String getDenominazioneAzienda() {
		return denominazioneAzienda;
	}
	public void setDenominazioneAzienda(String denominazioneAzienda) {
		this.denominazioneAzienda = denominazioneAzienda;
	}
	public String getTitolare() {
		return titolare;
	}
	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}
	public String getCodiceFiscaleAzienda() {
		return codiceFiscaleAzienda;
	}
	public void setCodiceFiscaleAzienda(String codiceFiscaleAzienda) {
		this.codiceFiscaleAzienda = codiceFiscaleAzienda;
	}
	public String getNumeroAlbo() {
		return numeroAlbo;
	}
	public void setNumeroAlbo(String numeroAlbo) {
		this.numeroAlbo = numeroAlbo;
	}
	public Date getDataDa() {
		return dataDa;
	}
	public void setDataDa(Date dataDa) {
		this.dataDa = dataDa;
	}
	public Date getDataA() {
		return dataA;
	}
	public void setDataA(Date dataA) {
		this.dataA = dataA;
	}
	public String getIstatComune() {
		return istatComune;
	}
	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}
	public String getAppartenenzaAltriAlbi() {
		return appartenenzaAltriAlbi;
	}
	public void setAppartenenzaAltriAlbi(String appartenenzaAltriAlbi) {
		this.appartenenzaAltriAlbi = appartenenzaAltriAlbi;
	}
	public List<Attivita> getAttivitaSvolteList() {
		return attivitaSvolteList;
	}
	public void setAttivitaSvolteList(List<Attivita> attivitaSvolteList) {
		this.attivitaSvolteList = attivitaSvolteList;
	}
	public int getTipoSede() {
		return tipoSede;
	}
	public void setTipoSede(int tipoSede) {
		this.tipoSede = tipoSede;
	}
	public int getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}
	public List<String> getListaCategoriaImpresa() {
		return listaCategoriaImpresa;
	}
	public void setListaCategoriaImpresa(List<String> listaCategoriaImpresa) {
		this.listaCategoriaImpresa = listaCategoriaImpresa;
	}
	public String getAppartenenzaCertificazioni() {
		return appartenenzaCertificazioni;
	}
	public void setAppartenenzaCertificazioni(String appartenenzaCertificazioni) {
		this.appartenenzaCertificazioni = appartenenzaCertificazioni;
	}
	public List<String> getAlboAppartenenza() {
		return alboAppartenenza;
	}
	public void setAlboAppartenenza(List<String> alboAppartenenza) {
		this.alboAppartenenza = alboAppartenenza;
	}
	public List<String> getSezione() {
		return sezione;
	}
	public void setSezione(List<String> sezione) {
		this.sezione = sezione;
	}
	public int getStatoPratica() {
		return statoPratica;
	}
	public void setStatoPratica(int statoPratica) {
		this.statoPratica = statoPratica;
	}
	public boolean isRicercaLibera() {
		return ricercaLibera;
	}
	public void setRicercaLibera(boolean ricercaLibera) {
		this.ricercaLibera = ricercaLibera;
	}
	public int getIdSoggettoGestore() {
		return idSoggettoGestore;
	}
	public void setIdSoggettoGestore(int idSoggettoGestore) {
		this.idSoggettoGestore = idSoggettoGestore;
	}
	/**
	 * @return the istatProvincia
	 */
	public String getIstatProvincia() {
		return istatProvincia;
	}
	/**
	 * @param istatProvincia the istatProvincia to set
	 */
	public void setIstatProvincia(String istatProvincia) {
		this.istatProvincia = istatProvincia;
	}
	
	
	
	
	
	

}
