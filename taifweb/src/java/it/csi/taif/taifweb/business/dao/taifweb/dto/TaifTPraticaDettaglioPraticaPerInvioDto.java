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
 * DTO specifico della query modellata nel finder dettaglioPraticaPerInvio.
 * @generated
 */
public class TaifTPraticaDettaglioPraticaPerInvioDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer prIdPratica;

	/**
	 * @generated
	 */
	public void setPrIdPratica(Integer val) {

		prIdPratica = val;

	}
	/**
	 * @generated
	 */
	public Integer getPrIdPratica() {

		return prIdPratica;

	}

	/*	 
	 * @generated
	 */
	private String prNumeroAlbo;

	/**
	 * @generated
	 */
	public void setPrNumeroAlbo(String val) {

		prNumeroAlbo = val;

	}
	/**
	 * @generated
	 */
	public String getPrNumeroAlbo() {

		return prNumeroAlbo;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date prDataIscrizioneAlbo;

	/**
	 * @generated
	 */
	public void setPrDataIscrizioneAlbo(java.sql.Date val) {

		if (val != null) {
			prDataIscrizioneAlbo = new java.sql.Date(val.getTime());
		} else {
			prDataIscrizioneAlbo = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getPrDataIscrizioneAlbo() {

		if (prDataIscrizioneAlbo != null) {
			return new java.sql.Date(prDataIscrizioneAlbo.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private Integer ssFkStatoPratica;

	/**
	 * @generated
	 */
	public void setSsFkStatoPratica(Integer val) {

		ssFkStatoPratica = val;

	}
	/**
	 * @generated
	 */
	public Integer getSsFkStatoPratica() {

		return ssFkStatoPratica;

	}

	/*	 
	 * @generated
	 */
	private Integer azIdAzienda;

	/**
	 * @generated
	 */
	public void setAzIdAzienda(Integer val) {

		azIdAzienda = val;

	}
	/**
	 * @generated
	 */
	public Integer getAzIdAzienda() {

		return azIdAzienda;

	}

	/*	 
	 * @generated
	 */
	private String azPartitaIva;

	/**
	 * @generated
	 */
	public void setAzPartitaIva(String val) {

		azPartitaIva = val;

	}
	/**
	 * @generated
	 */
	public String getAzPartitaIva() {

		return azPartitaIva;

	}

	/*	 
	 * @generated
	 */
	private String azNTva;

	/**
	 * @generated
	 */
	public void setAzNTva(String val) {

		azNTva = val;

	}
	/**
	 * @generated
	 */
	public String getAzNTva() {

		return azNTva;

	}

	/*	 
	 * @generated
	 */
	private String azRagioneSociale;

	/**
	 * @generated
	 */
	public void setAzRagioneSociale(String val) {

		azRagioneSociale = val;

	}
	/**
	 * @generated
	 */
	public String getAzRagioneSociale() {

		return azRagioneSociale;

	}

	/*	 
	 * @generated
	 */
	private String azCodiceFiscale;

	/**
	 * @generated
	 */
	public void setAzCodiceFiscale(String val) {

		azCodiceFiscale = val;

	}
	/**
	 * @generated
	 */
	public String getAzCodiceFiscale() {

		return azCodiceFiscale;

	}

	/*	 
	 * @generated
	 */
	private String azNSiret;

	/**
	 * @generated
	 */
	public void setAzNSiret(String val) {

		azNSiret = val;

	}
	/**
	 * @generated
	 */
	public String getAzNSiret() {

		return azNSiret;

	}

	/*	 
	 * @generated
	 */
	private String mailAzienda;

	/**
	 * @generated
	 */
	public void setMailAzienda(String val) {

		mailAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getMailAzienda() {

		return mailAzienda;

	}

	/*	 
	 * @generated
	 */
	private String pecAzienda;

	/**
	 * @generated
	 */
	public void setPecAzienda(String val) {

		pecAzienda = val;

	}
	/**
	 * @generated
	 */
	public String getPecAzienda() {

		return pecAzienda;

	}

	/*	 
	 * @generated
	 */
	private Integer peIdPersona;

	/**
	 * @generated
	 */
	public void setPeIdPersona(Integer val) {

		peIdPersona = val;

	}
	/**
	 * @generated
	 */
	public Integer getPeIdPersona() {

		return peIdPersona;

	}

	/*	 
	 * @generated
	 */
	private String peCognome;

	/**
	 * @generated
	 */
	public void setPeCognome(String val) {

		peCognome = val;

	}
	/**
	 * @generated
	 */
	public String getPeCognome() {

		return peCognome;

	}

	/*	 
	 * @generated
	 */
	private String peNome;

	/**
	 * @generated
	 */
	public void setPeNome(String val) {

		peNome = val;

	}
	/**
	 * @generated
	 */
	public String getPeNome() {

		return peNome;

	}

	/*	 
	 * @generated
	 */
	private String peCodiceFiscale;

	/**
	 * @generated
	 */
	public void setPeCodiceFiscale(String val) {

		peCodiceFiscale = val;

	}
	/**
	 * @generated
	 */
	public String getPeCodiceFiscale() {

		return peCodiceFiscale;

	}

	/*	 
	 * @generated
	 */
	private Integer sgIdSoggettoGestore;

	/**
	 * @generated
	 */
	public void setSgIdSoggettoGestore(Integer val) {

		sgIdSoggettoGestore = val;

	}
	/**
	 * @generated
	 */
	public Integer getSgIdSoggettoGestore() {

		return sgIdSoggettoGestore;

	}

	/*	 
	 * @generated
	 */
	private String sgDenominazioneBreve;

	/**
	 * @generated
	 */
	public void setSgDenominazioneBreve(String val) {

		sgDenominazioneBreve = val;

	}
	/**
	 * @generated
	 */
	public String getSgDenominazioneBreve() {

		return sgDenominazioneBreve;

	}

	/*	 
	 * @generated
	 */
	private String sgDenominazione;

	/**
	 * @generated
	 */
	public void setSgDenominazione(String val) {

		sgDenominazione = val;

	}
	/**
	 * @generated
	 */
	public String getSgDenominazione() {

		return sgDenominazione;

	}

	/*	 
	 * @generated
	 */
	private String sgTelefono;

	/**
	 * @generated
	 */
	public void setSgTelefono(String val) {

		sgTelefono = val;

	}
	/**
	 * @generated
	 */
	public String getSgTelefono() {

		return sgTelefono;

	}

	/*	 
	 * @generated
	 */
	private String mailSoggettoGestore;

	/**
	 * @generated
	 */
	public void setMailSoggettoGestore(String val) {

		mailSoggettoGestore = val;

	}
	/**
	 * @generated
	 */
	public String getMailSoggettoGestore() {

		return mailSoggettoGestore;

	}

	/*	 
	 * @generated
	 */
	private String pecSoggettoGestore;

	/**
	 * @generated
	 */
	public void setPecSoggettoGestore(String val) {

		pecSoggettoGestore = val;

	}
	/**
	 * @generated
	 */
	public String getPecSoggettoGestore() {

		return pecSoggettoGestore;

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
