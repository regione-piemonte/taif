/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import java.util.ArrayList;

import it.csi.taif.taifweb.dto.common.CodeDescription;

public class BeCertificazioneDto {

	
	
		private int idCertificazione ;
		private int idTipoCertificazione ;
		private String dsTipoCertificazione ;
		private String numero = null;
		private String enteCertificatore ;
		private String annoRilascio ;
		private String dataScadenza ;
		private ArrayList<CodeDescription> elencoTipoCertificazione ;
		private String iconaCancella ;
		
		
		public int getIdCertificazione() {
			return idCertificazione;
		}
		public void setIdCertificazione(int idCertificazione) {
			this.idCertificazione = idCertificazione;
		}
		public int getIdTipoCertificazione() {
			return idTipoCertificazione;
		}
		public void setIdTipoCertificazione(int idTipoCertificazione) {
			this.idTipoCertificazione = idTipoCertificazione;
		}
		public String getDsTipoCertificazione() {
			return dsTipoCertificazione;
		}
		public void setDsTipoCertificazione(String dsTipoCertificazione) {
			this.dsTipoCertificazione = dsTipoCertificazione;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		public String getEnteCertificatore() {
			return enteCertificatore;
		}
		public void setEnteCertificatore(String enteCertificatore) {
			this.enteCertificatore = enteCertificatore;
		}
		public String getAnnoRilascio() {
			return annoRilascio;
		}
		public void setAnnoRilascio(String annoRilascio) {
			this.annoRilascio = annoRilascio;
		}
		public String getDataScadenza() {
			return dataScadenza;
		}
		public void setDataScadenza(String dataScadenza) {
			this.dataScadenza = dataScadenza;
		}
		public ArrayList<CodeDescription> getElencoTipoCertificazione() {
			return elencoTipoCertificazione;
		}
		public void setElencoTipoCertificazione(ArrayList<CodeDescription> elencoTipoCertificazione) {
			this.elencoTipoCertificazione = elencoTipoCertificazione;
		}
		public String getIconaCancella() {
			return iconaCancella;
		}
		public void setIconaCancella(String iconaCancella) {
			this.iconaCancella = iconaCancella;
		}
		
		
		

		
		
}
