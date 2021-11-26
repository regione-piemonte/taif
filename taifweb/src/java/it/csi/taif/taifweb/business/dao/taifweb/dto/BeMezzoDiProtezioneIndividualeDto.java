/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.util.List;

import it.csi.taif.taifweb.dto.common.CodeDescription;

public class BeMezzoDiProtezioneIndividualeDto {
	
	private int idMezzoProtezione;
	private String descrizioneMezzoProtezione;
	private  int idTipoMezzoProtezione;
	private  String descrizioneTipoMezzoProtezione;
	private List<CodeDescription> listTipoMezzo;
	private String quantita;
	private String annoScadenza;
	private String tipologia;
	
	
	public int getIdMezzoProtezione() {
		return idMezzoProtezione;
	}
	public void setIdMezzoProtezione(int idMezzoProtezione) {
		this.idMezzoProtezione = idMezzoProtezione;
	}
	public String getDescrizioneMezzoProtezione() {
		return descrizioneMezzoProtezione;
	}
	public void setDescrizioneMezzoProtezione(String descrizioneMezzoProtezione) {
		this.descrizioneMezzoProtezione = descrizioneMezzoProtezione;
	}
	public int getIdTipoMezzoProtezione() {
		return idTipoMezzoProtezione;
	}
	public void setIdTipoMezzoProtezione(int idTipoMezzoProtezione) {
		this.idTipoMezzoProtezione = idTipoMezzoProtezione;
	}
	public String getDescrizioneTipoMezzoProtezione() {
		return descrizioneTipoMezzoProtezione;
	}
	public void setDescrizioneTipoMezzoProtezione(String descrizioneTipoMezzoProtezione) {
		this.descrizioneTipoMezzoProtezione = descrizioneTipoMezzoProtezione;
	}
	public List<CodeDescription> getListTipoMezzo() {
		return listTipoMezzo;
	}
	public void setListTipoMezzo(List<CodeDescription> listTipoMezzo) {
		this.listTipoMezzo = listTipoMezzo;
	}
	public String getQuantita() {
		return quantita;
	}
	public void setQuantita(String quantita) {
		this.quantita = quantita;
	}
	public String getAnnoScadenza() {
		return annoScadenza;
	}
	public void setAnnoScadenza(String annoScadenza) {
		this.annoScadenza = annoScadenza;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	
	

}
