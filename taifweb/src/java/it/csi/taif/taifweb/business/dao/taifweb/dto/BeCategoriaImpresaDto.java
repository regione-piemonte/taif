/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

public class BeCategoriaImpresaDto {
	
	
	private int idCategoria ;
	private String dsCategoria;
	private String nomeCategoria;
	private String altro;
	private boolean altroVisibile;
	
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDsCategoria() {
		return dsCategoria;
	}
	public void setDsCategoria(String dsCategoria) {
		this.dsCategoria = dsCategoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public String getAltro() {
		return altro;
	}
	public void setAltro(String altro) {
		this.altro = altro;
	}
	public boolean isAltroVisibile() {
		return altroVisibile;
	}
	public void setAltroVisibile(boolean altroVisibile) {
		this.altroVisibile = altroVisibile;
	}


	
	
	

}
