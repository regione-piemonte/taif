/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.util.List;

import it.csi.taif.taifweb.dto.common.CodeDescription;

public class BeMacchinaMezzoDto {
	
	private int idMacchinaMezzo;
	private String descMacchinaMezzo;
	private int idTipoMacchinaMezzo;
	private String descTipoMacchinaMezzo;
	private List<CodeDescription> listTipoMacchinaMezzo;
	private int annoImmatricolazione;
	private String potenza;
	private int idTipoTrazione;
	private String descTipoTrazione;
	private List<CodeDescription> listTipoTrazione;

	private int idTipoNoleggio;
	private String descTipoNoleggio;
	private List<CodeDescription> listTipoNoleggio;
	private String comandatoDistanza;;
	private int idTipoAlimentazione;
	private String descTipoAlimentazione;
	private List<CodeDescription> listTipoAlimentazione;

	private int idTipoCarrello;
	private String descTipoCarrello;
	private List<CodeDescription> listTipoCarrello;
	
	private int noleggio;
	private String portata;
	
	private int attrTipoMezzoOrd;
	private int attrAnnoOrd;
	private int attrNoleggioOrd;
	private int attrPotenzaOrd;
	private int attrTrazioneOrd;
	private int attrComandoOrd;
	private int attrAlimOrd;
	private int attrCarrelloOrd;
	private int attrPortataOrd;
	private int descrizione;
	
	
	public int getIdMacchinaMezzo() {
		return idMacchinaMezzo;
	}
	public void setIdMacchinaMezzo(int idMacchinaMezzo) {
		this.idMacchinaMezzo = idMacchinaMezzo;
	}
	public String getDescMacchinaMezzo() {
		return descMacchinaMezzo;
	}
	public void setDescMacchinaMezzo(String descMacchinaMezzo) {
		this.descMacchinaMezzo = descMacchinaMezzo;
	}
	public int getIdTipoMacchinaMezzo() {
		return idTipoMacchinaMezzo;
	}
	public void setIdTipoMacchinaMezzo(int idTipoMacchinaMezzo) {
		this.idTipoMacchinaMezzo = idTipoMacchinaMezzo;
	}
	public String getDescTipoMacchinaMezzo() {
		return descTipoMacchinaMezzo;
	}
	public void setDescTipoMacchinaMezzo(String descTipoMacchinaMezzo) {
		this.descTipoMacchinaMezzo = descTipoMacchinaMezzo;
	}
	public List<CodeDescription> getListTipoMacchinaMezzo() {
		return listTipoMacchinaMezzo;
	}
	public void setListTipoMacchinaMezzo(List<CodeDescription> listTipoMacchinaMezzo) {
		this.listTipoMacchinaMezzo = listTipoMacchinaMezzo;
	}
	
	public int getAnnoImmatricolazione() {
	    return annoImmatricolazione;
	}
	public void setAnnoImmatricolazione(int annoImmatricolazione) {
	    this.annoImmatricolazione = annoImmatricolazione;
	}
	public String getPotenza() {
		return potenza;
	}
	public void setPotenza(String potenza) {
		this.potenza = potenza;
	}
	public int getIdTipoTrazione() {
		return idTipoTrazione;
	}
	public void setIdTipoTrazione(int idTipoTrazione) {
		this.idTipoTrazione = idTipoTrazione;
	}
	public String getDescTipoTrazione() {
		return descTipoTrazione;
	}
	public void setDescTipoTrazione(String descTipoTrazione) {
		this.descTipoTrazione = descTipoTrazione;
	}
	public List<CodeDescription> getListTipoTrazione() {
		return listTipoTrazione;
	}
	public void setListTipoTrazione(List<CodeDescription> listTipoTrazione) {
		this.listTipoTrazione = listTipoTrazione;
	}
	public int getIdTipoNoleggio() {
		return idTipoNoleggio;
	}
	public void setIdTipoNoleggio(int idTipoNoleggio) {
		this.idTipoNoleggio = idTipoNoleggio;
	}
	public String getDescTipoNoleggio() {
		return descTipoNoleggio;
	}
	public void setDescTipoNoleggio(String descTipoNoleggio) {
		this.descTipoNoleggio = descTipoNoleggio;
	}
	public List<CodeDescription> getListTipoNoleggio() {
		return listTipoNoleggio;
	}
	public void setListTipoNoleggio(List<CodeDescription> listTipoNoleggio) {
		this.listTipoNoleggio = listTipoNoleggio;
	}
	public String getComandatoDistanza() {
		return comandatoDistanza;
	}
	public void setComandatoDistanza(String comandatoDistanza) {
		this.comandatoDistanza = comandatoDistanza;
	}
	public int getIdTipoAlimentazione() {
		return idTipoAlimentazione;
	}
	public void setIdTipoAlimentazione(int idTipoAlimentazione) {
		this.idTipoAlimentazione = idTipoAlimentazione;
	}
	public String getDescTipoAlimentazione() {
		return descTipoAlimentazione;
	}
	public void setDescTipoAlimentazione(String descTipoAlimentazione) {
		this.descTipoAlimentazione = descTipoAlimentazione;
	}
	public List<CodeDescription> getListTipoAlimentazione() {
		return listTipoAlimentazione;
	}
	public void setListTipoAlimentazione(List<CodeDescription> listTipoAlimentazione) {
		this.listTipoAlimentazione = listTipoAlimentazione;
	}
	public int getIdTipoCarrello() {
		return idTipoCarrello;
	}
	public void setIdTipoCarrello(int idTipoCarrello) {
		this.idTipoCarrello = idTipoCarrello;
	}
	public String getDescTipoCarrello() {
		return descTipoCarrello;
	}
	public void setDescTipoCarrello(String descTipoCarrello) {
		this.descTipoCarrello = descTipoCarrello;
	}
	public List<CodeDescription> getListTipoCarrello() {
		return listTipoCarrello;
	}
	public void setListTipoCarrello(List<CodeDescription> listTipoCarrello) {
		this.listTipoCarrello = listTipoCarrello;
	}
	public int getNoleggio() {
		return noleggio;
	}
	public void setNoleggio(int noleggio) {
		this.noleggio = noleggio;
	}
	public String getPortata() {
		return portata;
	}
	public void setPortata(String portata) {
		this.portata = portata;
	}
	public int getAttrAnnoOrd() {
		return attrAnnoOrd;
	}
	public void setAttrAnnoOrd(int attrAnnoOrd) {
		this.attrAnnoOrd = attrAnnoOrd;
	}
	public int getAttrNoleggioOrd() {
		return attrNoleggioOrd;
	}
	public void setAttrNoleggioOrd(int attrNoleggioOrd) {
		this.attrNoleggioOrd = attrNoleggioOrd;
	}
	public int getAttrPotenzaOrd() {
		return attrPotenzaOrd;
	}
	public void setAttrPotenzaOrd(int attrPotenzaOrd) {
		this.attrPotenzaOrd = attrPotenzaOrd;
	}
	public int getAttrTrazioneOrd() {
		return attrTrazioneOrd;
	}
	public void setAttrTrazioneOrd(int attrTrazioneOrd) {
		this.attrTrazioneOrd = attrTrazioneOrd;
	}
	public int getAttrComandoOrd() {
		return attrComandoOrd;
	}
	public void setAttrComandoOrd(int attrComandoOrd) {
		this.attrComandoOrd = attrComandoOrd;
	}
	public int getAttrAlimOrd() {
		return attrAlimOrd;
	}
	public void setAttrAlimOrd(int attrAlimOrd) {
		this.attrAlimOrd = attrAlimOrd;
	}
	public int getAttrCarrelloOrd() {
		return attrCarrelloOrd;
	}
	public void setAttrCarrelloOrd(int attrCarrelloOrd) {
		this.attrCarrelloOrd = attrCarrelloOrd;
	}
	public int getAttrPortataOrd() {
		return attrPortataOrd;
	}
	public void setAttrPortataOrd(int attrPortataOrd) {
		this.attrPortataOrd = attrPortataOrd;
	}
	public int getAttrTipoMezzoOrd() {
		return attrTipoMezzoOrd;
	}
	public void setAttrTipoMezzoOrd(int attrTipoMezzoOrd) {
		this.attrTipoMezzoOrd = attrTipoMezzoOrd;
	}
	public int getDescrizione() {
	    return descrizione;
	}
	public void setDescrizione(int descrizione) {
	    this.descrizione = descrizione;
	}
	
	
	
}
