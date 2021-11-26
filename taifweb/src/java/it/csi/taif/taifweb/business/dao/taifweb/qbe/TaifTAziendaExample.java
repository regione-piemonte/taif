/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.qbe;

import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.taifweb.dto.*;
import it.csi.taif.taifweb.business.dao.qbe.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [TaifTAziendaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class TaifTAziendaExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk idAzienda;

	/**
	 * @generated
	 */
	public void setIdAzienda(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		idAzienda = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getIdAzienda() {
		return idAzienda;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkAttivitaPrimaria;

	/**
	 * @generated
	 */
	public void setFkAttivitaPrimaria(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkAttivitaPrimaria = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkAttivitaPrimaria() {
		return fkAttivitaPrimaria;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkAttivitaSecondaria;

	/**
	 * @generated
	 */
	public void setFkAttivitaSecondaria(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkAttivitaSecondaria = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkAttivitaSecondaria() {
		return fkAttivitaSecondaria;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkAttivitaApe;

	/**
	 * @generated
	 */
	public void setFkAttivitaApe(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkAttivitaApe = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkAttivitaApe() {
		return fkAttivitaApe;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkFormaGiuridicaIta;

	/**
	 * @generated
	 */
	public void setFkFormaGiuridicaIta(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkFormaGiuridicaIta = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkFormaGiuridicaIta() {
		return fkFormaGiuridicaIta;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkFormaGiuridicaFra;

	/**
	 * @generated
	 */
	public void setFkFormaGiuridicaFra(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkFormaGiuridicaFra = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkFormaGiuridicaFra() {
		return fkFormaGiuridicaFra;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk codiceFiscale;

	/**
	 * @generated
	 */
	public void setCodiceFiscale(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		codiceFiscale = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk nSiret;

	/**
	 * @generated
	 */
	public void setNSiret(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		nSiret = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getNSiret() {
		return nSiret;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk partitaIva;

	/**
	 * @generated
	 */
	public void setPartitaIva(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		partitaIva = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getPartitaIva() {
		return partitaIva;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk nTva;

	/**
	 * @generated
	 */
	public void setNTva(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		nTva = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getNTva() {
		return nTva;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk cciaaNumero;

	/**
	 * @generated
	 */
	public void setCciaaNumero(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		cciaaNumero = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getCciaaNumero() {
		return cciaaNumero;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk cciaaSiglaProv;

	/**
	 * @generated
	 */
	public void setCciaaSiglaProv(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		cciaaSiglaProv = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getCciaaSiglaProv() {
		return cciaaSiglaProv;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk ragioneSociale;

	/**
	 * @generated
	 */
	public void setRagioneSociale(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		ragioneSociale = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getRagioneSociale() {
		return ragioneSociale;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk nMarcaBollo;

	/**
	 * @generated
	 */
	public void setNMarcaBollo(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		nMarcaBollo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getNMarcaBollo() {
		return nMarcaBollo;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk descrAltraFormaGiuridica;

	/**
	 * @generated
	 */
	public void setDescrAltraFormaGiuridica(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		descrAltraFormaGiuridica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDescrAltraFormaGiuridica() {
		return descrAltraFormaGiuridica;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk email;

	/**
	 * @generated
	 */
	public void setEmail(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		email = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getEmail() {
		return email;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk pec;

	/**
	 * @generated
	 */
	public void setPec(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		pec = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getPec() {
		return pec;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk sitoWeb;

	/**
	 * @generated
	 */
	public void setSitoWeb(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		sitoWeb = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getSitoWeb() {
		return sitoWeb;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk annoInizio;

	/**
	 * @generated
	 */
	public void setAnnoInizio(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		annoInizio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getAnnoInizio() {
		return annoInizio;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fatturato;

	/**
	 * @generated
	 */
	public void setFatturato(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fatturato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFatturato() {
		return fatturato;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk percCommercioFra;

	/**
	 * @generated
	 */
	public void setPercCommercioFra(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		percCommercioFra = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getPercCommercioFra() {
		return percCommercioFra;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk client1Fra;

	/**
	 * @generated
	 */
	public void setClient1Fra(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		client1Fra = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getClient1Fra() {
		return client1Fra;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk client2Fra;

	/**
	 * @generated
	 */
	public void setClient2Fra(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		client2Fra = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getClient2Fra() {
		return client2Fra;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk client3Fra;

	/**
	 * @generated
	 */
	public void setClient3Fra(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		client3Fra = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getClient3Fra() {
		return client3Fra;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk nbreSalariesFra;

	/**
	 * @generated
	 */
	public void setNbreSalariesFra(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		nbreSalariesFra = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getNbreSalariesFra() {
		return nbreSalariesFra;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk tempsPleinFra;

	/**
	 * @generated
	 */
	public void setTempsPleinFra(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		tempsPleinFra = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getTempsPleinFra() {
		return tempsPleinFra;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk dataInserimento;

	/**
	 * @generated
	 */
	public void setDataInserimento(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		dataInserimento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDataInserimento() {
		return dataInserimento;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk dataAggiornamento;

	/**
	 * @generated
	 */
	public void setDataAggiornamento(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		dataAggiornamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getDataAggiornamento() {
		return dataAggiornamento;
	}

	/**
	 * @generated
	 */
	private it.csi.taif.taifweb.business.dao.qbe.FieldChk fkConfigUtente;

	/**
	 * @generated
	 */
	public void setFkConfigUtente(it.csi.taif.taifweb.business.dao.qbe.FieldChk chk) {
		fkConfigUtente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.taif.taifweb.business.dao.qbe.FieldChk getFkConfigUtente() {
		return fkConfigUtente;
	}

}
