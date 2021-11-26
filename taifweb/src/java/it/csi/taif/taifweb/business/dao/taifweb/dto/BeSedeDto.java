/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.util.List;

import it.csi.taif.taifweb.dto.common.CodeDescription;

public class BeSedeDto {

	
	
		private int idSede ;
		private int idTipoSede ;
		private String descrizioneTipoSede ;
		private List<CodeDescription> elencoTipoSede;
		private List<CodeDescription> elencoComuni;
		private String descrizioneComune ;
		private String cap;
		private String indirizzo ;
		private String numeroCivico ;
		private String telefono ;
		private String cellulare ;
		private String iconaCancella;
		private String iconaAggiungi;
		private String istatComuneSede;
		private int rownum ;
		
		
		public int getIdSede() {
			return idSede;
		}
		public void setIdSede(int idSede) {
			this.idSede = idSede;
		}
		public int getIdTipoSede() {
			return idTipoSede;
		}
		public void setIdTipoSede(int idTipoSede) {
			this.idTipoSede = idTipoSede;
		}
		public String getDescrizioneTipoSede() {
			return descrizioneTipoSede;
		}
		public void setDescrizioneTipoSede(String descrizioneTipoSede) {
			this.descrizioneTipoSede = descrizioneTipoSede;
		}
		public List<CodeDescription> getElencoTipoSede() {
			return elencoTipoSede;
		}
		public void setElencoTipoSede(List<CodeDescription> elencoTipoSede) {
			this.elencoTipoSede = elencoTipoSede;
		}
		public String getDescrizioneComune() {
			return descrizioneComune;
		}
		public void setDescrizioneComune(String descrizioneComune) {
			this.descrizioneComune = descrizioneComune;
		}
		public String getCap() {
			return cap;
		}
		public void setCap(String cap) {
			this.cap = cap;
		}
		public String getIndirizzo() {
			return indirizzo;
		}
		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}
		public String getNumeroCivico() {
			return numeroCivico;
		}
		public void setNumeroCivico(String numeroCivico) {
			this.numeroCivico = numeroCivico;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public String getIconaCancella() {
			return iconaCancella;
		}
		public void setIconaCancella(String iconaCancella) {
			this.iconaCancella = iconaCancella;
		}
		public String getIconaAggiungi() {
			return iconaAggiungi;
		}
		public void setIconaAggiungi(String iconaAggiungi) {
			this.iconaAggiungi = iconaAggiungi;
		}
		public int getRownum() {
			return rownum;
		}
		public void setRownum(int rownum) {
			this.rownum = rownum;
		}
		public String getCellulare() {
			return cellulare;
		}
		public void setCellulare(String cellulare) {
			this.cellulare = cellulare;
		}
		/**
		 * @return the istatComuneSede
		 */
		public String getIstatComuneSede() {
			return istatComuneSede;
		}
		/**
		 * @param istatComuneSede the istatComuneSede to set
		 */
		public void setIstatComuneSede(String istatComuneSede) {
			this.istatComuneSede = istatComuneSede;
		}
		public List<CodeDescription> getElencoComuni() {
			return elencoComuni;
		}
		public void setElencoComuni(List<CodeDescription> elencoComuni) {
			this.elencoComuni = elencoComuni;
		}
		
		
		
		
		
		
}
