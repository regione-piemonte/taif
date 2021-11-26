/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.filter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RicercaOperatoreFilter implements Serializable {
	
	
	
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private List<String> alboOperatore;
	private String cognome;
	private String unitaFormativa;
	private String agenziaFormativa;
	private Date dataDa;
	private Date dataA;
	private boolean isOperatoreConQualifica;
	private boolean isIstruttore;
	private boolean ricercaLibera;
	private String statoOperatore;
	private String statoScheda;
	private String idPersona;
	private String codiceFiscale;
	private String nRsiMsa;
	private String idSoggettoGestore;
	private String istatProvincia;
	private String istatComune;
	private String idAmbitoFormativo;

	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
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
	public boolean isRicercaLibera() {
		return ricercaLibera;
	}
	public void setRicercaLibera(boolean ricercaLibera) {
		this.ricercaLibera = ricercaLibera;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getUnitaFormativa() {
		return unitaFormativa;
	}
	public void setUnitaFormativa(String unitaFormativa) {
		this.unitaFormativa = unitaFormativa;
	}
	public String getAgenziaFormativa() {
		return agenziaFormativa;
	}
	public void setAgenziaFormativa(String agenziaFormativa) {
		this.agenziaFormativa = agenziaFormativa;
	}
	public boolean isOperatoreConQualifica() {
		return isOperatoreConQualifica;
	}
	public void setOperatoreConQualifica(boolean isOperatoreConQualifica) {
		this.isOperatoreConQualifica = isOperatoreConQualifica;
	}
	public boolean isIstruttore() {
		return isIstruttore;
	}
	public void setIstruttore(boolean isIstruttore) {
		this.isIstruttore = isIstruttore;
	}
	public List<String> getAlboOperatore() {
		return alboOperatore;
	}
	public void setAlboOperatore(List<String> alboOperatore) {
		this.alboOperatore = alboOperatore;
	}
	public String getStatoOperatore() {
		return statoOperatore;
	}
	public void setStatoOperatore(String statoOperatore) {
		this.statoOperatore = statoOperatore;
	}
	public String getStatoScheda() {
		return statoScheda;
	}
	public void setStatoScheda(String statoScheda) {
		this.statoScheda = statoScheda;
	}
	public String getnRsiMsa() {
		return nRsiMsa;
	}
	public void setnRsiMsa(String nRsiMsa) {
		this.nRsiMsa = nRsiMsa;
	}
	public String getIdSoggettoGestore() {
		return idSoggettoGestore;
	}
	public void setIdSoggettoGestore(String idSoggettoGestore) {
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
	/**
	 * @return the istatComune
	 */
	public String getIstatComune() {
		return istatComune;
	}
	/**
	 * @param istatComune the istatComune to set
	 */
	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}
	/**
	 * @return the idAmbitoFormativo
	 */
	public String getIdAmbitoFormativo() {
		return idAmbitoFormativo;
	}
	/**
	 * @param idAmbitoFormativo the idAmbitoFormativo to set
	 */
	public void setIdAmbitoFormativo(String idAmbitoFormativo) {
		this.idAmbitoFormativo = idAmbitoFormativo;
	}
	
	
	
}
