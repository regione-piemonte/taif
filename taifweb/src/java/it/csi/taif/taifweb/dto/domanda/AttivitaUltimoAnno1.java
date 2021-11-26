/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class AttivitaUltimoAnno1 extends it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno
		implements
			java.io.Serializable {

	/// Field [interventoInRegione]
	private it.csi.taif.taifweb.dto.domanda.Intervento interventoInRegione = null;

	/**
	 * imposta il valore del campo [interventoInRegione]
	 * @param val
	 * @generated
	 */

	public void setInterventoInRegione(it.csi.taif.taifweb.dto.domanda.Intervento val) {
		interventoInRegione = val;
	}

	/**
	 * legge il valore del campo [interventoInRegione]
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.Intervento getInterventoInRegione() {
		return interventoInRegione;
	}

	/// Field [interventoFuoriRegione]
	private it.csi.taif.taifweb.dto.domanda.Intervento interventoFuoriRegione = null;

	/**
	 * imposta il valore del campo [interventoFuoriRegione]
	 * @param val
	 * @generated
	 */

	public void setInterventoFuoriRegione(it.csi.taif.taifweb.dto.domanda.Intervento val) {
		interventoFuoriRegione = val;
	}

	/**
	 * legge il valore del campo [interventoFuoriRegione]
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.Intervento getInterventoFuoriRegione() {
		return interventoFuoriRegione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public AttivitaUltimoAnno1() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R915653467) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
