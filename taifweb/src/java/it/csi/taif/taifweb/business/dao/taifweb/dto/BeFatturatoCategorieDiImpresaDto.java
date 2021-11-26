/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

public class BeFatturatoCategorieDiImpresaDto {

	
	
	private String annoInizioAttivita;
	private String fatturatoUltimoAnno;
	private String altro;
	
	
	public String getAnnoInizioAttivita() {
		return annoInizioAttivita;
	}
	public void setAnnoInizioAttivita(String annoInizioAttivita) {
		this.annoInizioAttivita = annoInizioAttivita;
	}
	public String getFatturatoUltimoAnno() {
		return fatturatoUltimoAnno;
	}
	public void setFatturatoUltimoAnno(String fatturatoUltimoAnno) {
		this.fatturatoUltimoAnno = fatturatoUltimoAnno;
	}
	public String getAltro() {
		return altro;
	}
	public void setAltro(String altro) {
		this.altro = altro;
	}

	
	
	
}
