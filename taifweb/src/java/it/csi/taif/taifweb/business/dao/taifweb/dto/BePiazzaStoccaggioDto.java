/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

public class BePiazzaStoccaggioDto {
	
	private int idPiazzaleStoccaggio;
	private int idFunzionePiazza;
	private String funzionePiazza;
	private String dimensionePiazzale ;
	private String annoCostruzioneORiattamentoPiazzale;

	private int rownum;
	
	

	public int getIdPiazzaleStoccaggio() {
		return idPiazzaleStoccaggio;
	}

	public void setIdPiazzaleStoccaggio(int idPiazzaleStoccaggio) {
		this.idPiazzaleStoccaggio = idPiazzaleStoccaggio;
	}

	public String getDimensionePiazzale() {
		return dimensionePiazzale;
	}

	public void setDimensionePiazzale(String dimensionePiazzale) {
		this.dimensionePiazzale = dimensionePiazzale;
	}

	public String getAnnoCostruzioneORiattamentoPiazzale() {
		return annoCostruzioneORiattamentoPiazzale;
	}

	public void setAnnoCostruzioneORiattamentoPiazzale(String annoCostruzioneORiattamentoPiazzale) {
		this.annoCostruzioneORiattamentoPiazzale = annoCostruzioneORiattamentoPiazzale;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getIdFunzionePiazza() {
		return idFunzionePiazza;
	}

	public void setIdFunzionePiazza(int idFunzionePiazza) {
		this.idFunzionePiazza = idFunzionePiazza;
	}

	public String getFunzionePiazza() {
		return funzionePiazza;
	}

	public void setFunzionePiazza(String funzionePiazza) {
		this.funzionePiazza = funzionePiazza;
	}



}
