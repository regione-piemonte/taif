/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byIdPratica.
 * @generated
 */
public class TaifTAllegatoByIdPraticaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idAllegato;

	/**
	 * @generated
	 */
	public void setIdAllegato(Integer val) {

		idAllegato = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdAllegato() {

		return idAllegato;

	}

	/*	 
	 * @generated
	 */
	private String nomeAllegato;

	/**
	 * @generated
	 */
	public void setNomeAllegato(String val) {

		nomeAllegato = val;

	}
	/**
	 * @generated
	 */
	public String getNomeAllegato() {

		return nomeAllegato;

	}

	/*	 
	 * @generated
	 */
	private Integer idPratica;

	/**
	 * @generated
	 */
	public void setIdPratica(Integer val) {

		idPratica = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdPratica() {

		return idPratica;

	}

	/*	 
	 * @generated
	 */
	private Integer idCorso;

	/**
	 * @generated
	 */
	public void setIdCorso(Integer val) {

		idCorso = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdCorso() {

		return idCorso;

	}

	/*	 
	 * @generated
	 */
	private Integer idPersona;

	/**
	 * @generated
	 */
	public void setIdPersona(Integer val) {

		idPersona = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdPersona() {

		return idPersona;

	}

	/*	 
	 * @generated
	 */
	private Integer idTipoAll;

	/**
	 * @generated
	 */
	public void setIdTipoAll(Integer val) {

		idTipoAll = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdTipoAll() {

		return idTipoAll;

	}

	/*	 
	 * @generated
	 */
	private String tipoInvio;

	/**
	 * @generated
	 */
	public void setTipoInvio(String val) {

		tipoInvio = val;

	}
	/**
	 * @generated
	 */
	public String getTipoInvio() {

		return tipoInvio;

	}

	/*	 
	 * @generated
	 */
	private String note;

	/**
	 * @generated
	 */
	public void setNote(String val) {

		note = val;

	}
	/**
	 * @generated
	 */
	public String getNote() {

		return note;

	}

	/*	 
	 * @generated
	 */
	private Integer allegatoDimensioneFileKb;

	/**
	 * @generated
	 */
	public void setAllegatoDimensioneFileKb(Integer val) {

		allegatoDimensioneFileKb = val;

	}
	/**
	 * @generated
	 */
	public Integer getAllegatoDimensioneFileKb() {

		return allegatoDimensioneFileKb;

	}

	/*	 
	 * @generated
	 */
	private String allegatoIdDocDoqui;

	/**
	 * @generated
	 */
	public void setAllegatoIdDocDoqui(String val) {

		allegatoIdDocDoqui = val;

	}
	/**
	 * @generated
	 */
	public String getAllegatoIdDocDoqui() {

		return allegatoIdDocDoqui;

	}

	/*	 
	 * @generated
	 */
	private String allegatoIdClassificazioneDoqui;

	/**
	 * @generated
	 */
	public void setAllegatoIdClassificazioneDoqui(String val) {

		allegatoIdClassificazioneDoqui = val;

	}
	/**
	 * @generated
	 */
	public String getAllegatoIdClassificazioneDoqui() {

		return allegatoIdClassificazioneDoqui;

	}

	/*	 
	 * @generated
	 */
	private String tipoallegatoTipoAllegato;

	/**
	 * @generated
	 */
	public void setTipoallegatoTipoAllegato(String val) {

		tipoallegatoTipoAllegato = val;

	}
	/**
	 * @generated
	 */
	public String getTipoallegatoTipoAllegato() {

		return tipoallegatoTipoAllegato;

	}

	/*	 
	 * @generated
	 */
	private String tipoallegatoFlgFirma;

	/**
	 * @generated
	 */
	public void setTipoallegatoFlgFirma(String val) {

		tipoallegatoFlgFirma = val;

	}
	/**
	 * @generated
	 */
	public String getTipoallegatoFlgFirma() {

		return tipoallegatoFlgFirma;

	}

	/*	 
	 * @generated
	 */
	private String tipoallegatoActaOggetto;

	/**
	 * @generated
	 */
	public void setTipoallegatoActaOggetto(String val) {

		tipoallegatoActaOggetto = val;

	}
	/**
	 * @generated
	 */
	public String getTipoallegatoActaOggetto() {

		return tipoallegatoActaOggetto;

	}

	/*	 
	 * @generated
	 */
	private String tipoallegatoActaFlgAllegati;

	/**
	 * @generated
	 */
	public void setTipoallegatoActaFlgAllegati(String val) {

		tipoallegatoActaFlgAllegati = val;

	}
	/**
	 * @generated
	 */
	public String getTipoallegatoActaFlgAllegati() {

		return tipoallegatoActaFlgAllegati;

	}

	/*	 
	 * @generated
	 */
	private String tipoallegatoActaStatoDiEfficacia;

	/**
	 * @generated
	 */
	public void setTipoallegatoActaStatoDiEfficacia(String val) {

		tipoallegatoActaStatoDiEfficacia = val;

	}
	/**
	 * @generated
	 */
	public String getTipoallegatoActaStatoDiEfficacia() {

		return tipoallegatoActaStatoDiEfficacia;

	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 * @generated
	 */
	public boolean equals(Object _other) {
		return super.equals(_other);
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 * @generated
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
