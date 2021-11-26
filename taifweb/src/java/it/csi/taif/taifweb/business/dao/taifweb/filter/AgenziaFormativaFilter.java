/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class AgenziaFormativaFilter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idAgenziaFormativa;
	private String codiceFiscale;
	private String partitaIva;
	private String ragioneSociale;
	private String codicePsr;
	private String istatSede;
	private String comuneEstero;
	
	public int getIdAgenziaFormativa() {
		return idAgenziaFormativa;
	}
	public void setIdAgenziaFormativa(int idAgenziaFormativa) {
		this.idAgenziaFormativa = idAgenziaFormativa;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public String getCodicePsr() {
		return codicePsr;
	}
	public void setCodicePsr(String codicePsr) {
		this.codicePsr = codicePsr;
	}
	public String getIstatSede() {
		return istatSede;
	}
	public void setIstatSede(String istatSede) {
		this.istatSede = istatSede;
	}
	public String getComuneEstero() {
		return comuneEstero;
	}
	public void setComuneEstero(String comuneEstero) {
		this.comuneEstero = comuneEstero;
	}
	
	

	
	
	
}
