/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.util.List;

import it.csi.taif.taifweb.dto.common.CodeDescription;

public class BePersonaleDto {

	
	private int idPersonale;
	private String codiceFiscale;
	private String cognome;
	private String nome;
	private int idTipologiaPersonale;
	private String descTipologiaPersonale;
	private List<CodeDescription> elencoTipologiaPersonale;
	private int idMansione;
	private String descMansione ;
	private List<CodeDescription> elencoMansioni;
	private int idContratto ;
	private java.lang.String dsContratto ;
	private List<CodeDescription> elencoContratti ;
	private int idDurataContratto;
	private String dsDurataContratto;
	private List<CodeDescription> elencoDurateContratto;
	private String giorniNellAnno;
	private int idInquadramento = 0;
	private String dsInquadramento = null;
	private List<CodeDescription> elencoInquadramenti;
	private int rownum;
	private String iconaCancella = null;
	
	
	public int getIdPersonale() {
		return idPersonale;
	}
	public void setIdPersonale(int idPersonale) {
		this.idPersonale = idPersonale;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
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
	public int getIdTipologiaPersonale() {
		return idTipologiaPersonale;
	}
	public void setIdTipologiaPersonale(int idTipologiaPersonale) {
		this.idTipologiaPersonale = idTipologiaPersonale;
	}
	public String getDescTipologiaPersonale() {
		return descTipologiaPersonale;
	}
	public void setDescTipologiaPersonale(String descTipologiaPersonale) {
		this.descTipologiaPersonale = descTipologiaPersonale;
	}
	public List<CodeDescription> getElencoTipologiaPersonale() {
		return elencoTipologiaPersonale;
	}
	public void setElencoTipologiaPersonale(List<CodeDescription> elencoTipologiaPersonale) {
		this.elencoTipologiaPersonale = elencoTipologiaPersonale;
	}
	public int getIdMansione() {
		return idMansione;
	}
	public void setIdMansione(int idMansione) {
		this.idMansione = idMansione;
	}
	public String getDescMansione() {
		return descMansione;
	}
	public void setDescMansione(String descMansione) {
		this.descMansione = descMansione;
	}
	public List<CodeDescription> getElencoMansioni() {
		return elencoMansioni;
	}
	public void setElencoMansioni(List<CodeDescription> elencoMansioni) {
		this.elencoMansioni = elencoMansioni;
	}
	public int getIdContratto() {
		return idContratto;
	}
	public void setIdContratto(int idContratto) {
		this.idContratto = idContratto;
	}
	public java.lang.String getDsContratto() {
		return dsContratto;
	}
	public void setDsContratto(java.lang.String dsContratto) {
		this.dsContratto = dsContratto;
	}
	public List<CodeDescription> getElencoContratti() {
		return elencoContratti;
	}
	public void setElencoContratti(List<CodeDescription> elencoContratti) {
		this.elencoContratti = elencoContratti;
	}
	public int getIdDurataContratto() {
		return idDurataContratto;
	}
	public void setIdDurataContratto(int idDurataContratto) {
		this.idDurataContratto = idDurataContratto;
	}
	public String getDsDurataContratto() {
		return dsDurataContratto;
	}
	public void setDsDurataContratto(String dsDurataContratto) {
		this.dsDurataContratto = dsDurataContratto;
	}
	public List<CodeDescription> getElencoDurateContratto() {
		return elencoDurateContratto;
	}
	public void setElencoDurateContratto(List<CodeDescription> elencoDurateContratto) {
		this.elencoDurateContratto = elencoDurateContratto;
	}
	public String getGiorniNellAnno() {
		return giorniNellAnno;
	}
	public void setGiorniNellAnno(String giorniNellAnno) {
		this.giorniNellAnno = giorniNellAnno;
	}
	public int getIdInquadramento() {
		return idInquadramento;
	}
	public void setIdInquadramento(int idInquadramento) {
		this.idInquadramento = idInquadramento;
	}
	public String getDsInquadramento() {
		return dsInquadramento;
	}
	public void setDsInquadramento(String dsInquadramento) {
		this.dsInquadramento = dsInquadramento;
	}
	public List<CodeDescription> getElencoInquadramenti() {
		return elencoInquadramenti;
	}
	public void setElencoInquadramenti(List<CodeDescription> elencoInquadramenti) {
		this.elencoInquadramenti = elencoInquadramenti;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getIconaCancella() {
		return iconaCancella;
	}
	public void setIconaCancella(String iconaCancella) {
		this.iconaCancella = iconaCancella;
	}
	
	
	
}
