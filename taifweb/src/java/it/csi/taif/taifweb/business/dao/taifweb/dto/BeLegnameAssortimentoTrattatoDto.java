/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.util.ArrayList;
import java.util.List;

import it.csi.taif.taifweb.dto.common.CodeDescription;

public class BeLegnameAssortimentoTrattatoDto {
	
	private int idLegname; 
	
	private int idSpecie;
	private String descrizioneSpecie;
	//private ArrayList<CodeDescription> listSpecie;
	private List<TaifDSpecieByFilterDto> listSpecie;
	
	private int idProvenienza;
	private String descrizioneProvenienza;
	private ArrayList<CodeDescription> listProvenienza;
	
	private int idAssortimento;
	private String descrizioneAssortimento;
	private ArrayList<CodeDescription> listAssortimento;
	
	private int idTagliatoAquistato;
	private String flagTagliatoAcquistato;
	private ArrayList<CodeDescription> listTagliatoAquistato;
	
	private String vendutoAnno;

	private String note;
	
	private int idUnitaMisura;
	private String descrizioneUnitaMisura;
	private ArrayList<CodeDescription> listUnitaMisura;
	
	private int idDestinazione;
	private String descrizioneDestinazione;
	private ArrayList<CodeDescription> listDestinazione;
	
	
	public int getIdLegname() {
		return idLegname;
	}
	public void setIdLegname(int idLegname) {
		this.idLegname = idLegname;
	}
	public int getIdSpecie() {
		return idSpecie;
	}
	public void setIdSpecie(int idSpecie) {
		this.idSpecie = idSpecie;
	}
	public String getDescrizioneSpecie() {
		return descrizioneSpecie;
	}
	public void setDescrizioneSpecie(String descrizioneSpecie) {
		this.descrizioneSpecie = descrizioneSpecie;
	}
	/*public ArrayList<CodeDescription> getListSpecie() {
		return listSpecie;
	}
	public void setListSpecie(ArrayList<CodeDescription> listSpecie) {
		this.listSpecie = listSpecie;
	}*/
	public int getIdProvenienza() {
		return idProvenienza;
	}
	public void setIdProvenienza(int idProvenienza) {
		this.idProvenienza = idProvenienza;
	}
	public String getDescrizioneProvenienza() {
		return descrizioneProvenienza;
	}
	public void setDescrizioneProvenienza(String descrizioneProvenienza) {
		this.descrizioneProvenienza = descrizioneProvenienza;
	}
	public ArrayList<CodeDescription> getListProvenienza() {
		return listProvenienza;
	}
	public void setListProvenienza(ArrayList<CodeDescription> listProvenienza) {
		this.listProvenienza = listProvenienza;
	}
	public int getIdAssortimento() {
		return idAssortimento;
	}
	public void setIdAssortimento(int idAssortimento) {
		this.idAssortimento = idAssortimento;
	}
	public String getDescrizioneAssortimento() {
		return descrizioneAssortimento;
	}
	public void setDescrizioneAssortimento(String descrizioneAssortimento) {
		this.descrizioneAssortimento = descrizioneAssortimento;
	}
	public ArrayList<CodeDescription> getListAssortimento() {
		return listAssortimento;
	}
	public void setListAssortimento(ArrayList<CodeDescription> listAssortimento) {
		this.listAssortimento = listAssortimento;
	}
	
	
	public int getIdUnitaMisura() {
		return idUnitaMisura;
	}
	public void setIdUnitaMisura(int idUnitaMisura) {
		this.idUnitaMisura = idUnitaMisura;
	}
	public String getDescrizioneUnitaMisura() {
		return descrizioneUnitaMisura;
	}
	public void setDescrizioneUnitaMisura(String descrizioneUnitaMisura) {
		this.descrizioneUnitaMisura = descrizioneUnitaMisura;
	}
	public ArrayList<CodeDescription> getListUnitaMisura() {
		return listUnitaMisura;
	}
	public void setListUnitaMisura(ArrayList<CodeDescription> listUnitaMisura) {
		this.listUnitaMisura = listUnitaMisura;
	}
	public int getIdDestinazione() {
		return idDestinazione;
	}
	public void setIdDestinazione(int idDestinazione) {
		this.idDestinazione = idDestinazione;
	}
	public String getDescrizioneDestinazione() {
		return descrizioneDestinazione;
	}
	public void setDescrizioneDestinazione(String descrizioneDestinazione) {
		this.descrizioneDestinazione = descrizioneDestinazione;
	}
	public ArrayList<CodeDescription> getListDestinazione() {
		return listDestinazione;
	}
	public void setListDestinazione(ArrayList<CodeDescription> listDestinazione) {
		this.listDestinazione = listDestinazione;
	}
	
	public String getVendutoAnno() {
		return vendutoAnno;
	}
	public void setVendutoAnno(String vendutoAnno) {
		this.vendutoAnno = vendutoAnno;
	}
	public String getFlagTagliatoAcquistato() {
		return flagTagliatoAcquistato;
	}
	public void setFlagTagliatoAcquistato(String flagTagliatoAcquistato) {
		this.flagTagliatoAcquistato = flagTagliatoAcquistato;
	}
	public List<TaifDSpecieByFilterDto> getListSpecie() {
		return listSpecie;
	}
	public void setListSpecie(List<TaifDSpecieByFilterDto> listSpecie) {
		this.listSpecie = listSpecie;
	}
	public int getIdTagliatoAquistato() {
		return idTagliatoAquistato;
	}
	public void setIdTagliatoAquistato(int idTagliatoAquistato) {
		this.idTagliatoAquistato = idTagliatoAquistato;
	}
	public ArrayList<CodeDescription> getListTagliatoAquistato() {
		return listTagliatoAquistato;
	}
	public void setListTagliatoAquistato(ArrayList<CodeDescription> listTagliatoAquistato) {
		this.listTagliatoAquistato = listTagliatoAquistato;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
	
	
	
	
	
	

}
