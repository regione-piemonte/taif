/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.dto;

import java.io.Serializable;

public class MetadatiIndex implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1946774237456010662L;
	
	
	private String idAllegato;
	
	private String idTipologia;
	
	private String idAzienda;
	
	private String idPratica;
	
	private String idPersona;
	
	private String idCorso;
	
	private String tipoProcedura;

	/**
	 * @return the idAllegato
	 */
	public String getIdAllegato() {
		return idAllegato;
	}

	/**
	 * @param idAllegato the idAllegato to set
	 */
	public void setIdAllegato(String idAllegato) {
		this.idAllegato = idAllegato;
	}

	/**
	 * @return the idTipologia
	 */
	public String getIdTipologia() {
		return idTipologia;
	}

	/**
	 * @param idTipologia the idTipologia to set
	 */
	public void setIdTipologia(String idTipologia) {
		this.idTipologia = idTipologia;
	}

	/**
	 * @return the idAzienda
	 */
	public String getIdAzienda() {
		return idAzienda;
	}

	/**
	 * @param idAzienda the idAzienda to set
	 */
	public void setIdAzienda(String idAzienda) {
		this.idAzienda = idAzienda;
	}

	/**
	 * @return the idPratica
	 */
	public String getIdPratica() {
		return idPratica;
	}

	/**
	 * @param idPratica the idPratica to set
	 */
	public void setIdPratica(String idPratica) {
		this.idPratica = idPratica;
	}

	/**
	 * @return the idPersona
	 */
	public String getIdPersona() {
		return idPersona;
	}

	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * @return the idCorso
	 */
	public String getIdCorso() {
		return idCorso;
	}

	/**
	 * @param idCorso the idCorso to set
	 */
	public void setIdCorso(String idCorso) {
		this.idCorso = idCorso;
	}
	
	
	
	/**
	 * @return the tipoProcedura
	 */
	public String getTipoProcedura() {
		return tipoProcedura;
	}

	/**
	 * @param tipoProcedura the tipoProcedura to set
	 */
	public void setTipoProcedura(String tipoProcedura) {
		this.tipoProcedura = tipoProcedura;
	}



	public static final String META_ID_ALLEGATO = "taif:idAllegato";
	
	public static final String META_ID_AZIENDA = "taif:idAzienda";
	
	public static final String META_ID_CORSO = "taif:idCorso";
	
	public static final String META_ID_PERSONA = "taif:idPersona";
	
	public static final String META_ID_PRATICA = "taif:idPratica";
	
	public static final String META_ID_TIPOLOGIA = "taif:idTipologia";
	
	
}
