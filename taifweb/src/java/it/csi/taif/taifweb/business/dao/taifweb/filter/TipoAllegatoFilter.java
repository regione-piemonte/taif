/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class TipoAllegatoFilter implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int idprocedura;
	private String flagContesto;
	private String flagFirma;
	private int flagDownload;
	private int flagUplod;
	private int flagVisibile;
	private String flagItaFr;
	private String estensioneFile;
	private String idTipoAllegatoSelezionato;
	private int idPratica;
	
	
	public int getIdprocedura() {
		return idprocedura;
	}
	public void setIdprocedura(int idprocedura) {
		this.idprocedura = idprocedura;
	}
	public String getFlagContesto() {
		return flagContesto;
	}
	public void setFlagContesto(String flagContesto) {
		this.flagContesto = flagContesto;
	}
	public String getFlagFirma() {
		return flagFirma;
	}
	public void setFlagFirma(String flagFirma) {
		this.flagFirma = flagFirma;
	}
	public int getFlagDownload() {
		return flagDownload;
	}
	public void setFlagDownload(int flagDownload) {
		this.flagDownload = flagDownload;
	}
	public int getFlagVisibile() {
		return flagVisibile;
	}
	public void setFlagVisibile(int flagVisibile) {
		this.flagVisibile = flagVisibile;
	}
	public String getFlagItaFr() {
		return flagItaFr;
	}
	public void setFlagItaFr(String flagItaFr) {
		this.flagItaFr = flagItaFr;
	}
	public String getEstensioneFile() {
		return estensioneFile;
	}
	public void setEstensioneFile(String estensioneFile) {
		this.estensioneFile = estensioneFile;
	}
	public String getIdTipoAllegatoSelezionato() {
		return idTipoAllegatoSelezionato;
	}
	public void setIdTipoAllegatoSelezionato(String idTipoAllegatoSelezionato) {
		this.idTipoAllegatoSelezionato = idTipoAllegatoSelezionato;
	}
	public int getFlagUplod() {
		return flagUplod;
	}
	public void setFlagUplod(int flagUplod) {
		this.flagUplod = flagUplod;
	}
	/**
	 * @return the idPratica
	 */
	public int getIdPratica() {
		return idPratica;
	}
	/**
	 * @param idPratica the idPratica to set
	 */
	public void setIdPratica(int idPratica) {
		this.idPratica = idPratica;
	}
	
	
	
	

}
