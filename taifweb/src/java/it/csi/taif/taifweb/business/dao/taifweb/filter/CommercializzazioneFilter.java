/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.filter;

import java.io.Serializable;

public class CommercializzazioneFilter implements Serializable{

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private int idCommercializzazione;
	private int idAzienda;
	private int idSpecie;
	private int idProvenienza;
	private int idDestinazione;
	private int idAssortimento;
	private float vendutoMedio;
	private int idUnitaMisura;
	private int flgTagliatoAcq;
	
	public int getIdCommercializzazione() {
		return idCommercializzazione;
	}
	public void setIdCommercializzazione(int idCommercializzazione) {
		this.idCommercializzazione = idCommercializzazione;
	}
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
	public int getIdSpecie() {
		return idSpecie;
	}
	public void setIdSpecie(int idSpecie) {
		this.idSpecie = idSpecie;
	}
	public int getIdProvenienza() {
		return idProvenienza;
	}
	public void setIdProvenienza(int idProvenienza) {
		this.idProvenienza = idProvenienza;
	}
	public int getIdDestinazione() {
		return idDestinazione;
	}
	public void setIdDestinazione(int idDestinazione) {
		this.idDestinazione = idDestinazione;
	}
	public int getIdAssortimento() {
		return idAssortimento;
	}
	public void setIdAssortimento(int idAssortimento) {
		this.idAssortimento = idAssortimento;
	}
	public float getVendutoMedio() {
		return vendutoMedio;
	}
	public void setVendutoMedio(float vendutoMedio) {
		this.vendutoMedio = vendutoMedio;
	}
	public int getIdUnitaMisura() {
		return idUnitaMisura;
	}
	public void setIdUnitaMisura(int idUnitaMisura) {
		this.idUnitaMisura = idUnitaMisura;
	}
	public int getFlgTagliatoAcq() {
		return flgTagliatoAcq;
	}
	public void setFlgTagliatoAcq(int flgTagliatoAcq) {
		this.flgTagliatoAcq = flgTagliatoAcq;
	}
	
	
	
	
	
}
