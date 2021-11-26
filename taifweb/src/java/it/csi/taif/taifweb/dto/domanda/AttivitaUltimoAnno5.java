/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class AttivitaUltimoAnno5 extends it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno
		implements
			java.io.Serializable {

	/// Field [elencoArbolicoltureDaLegno]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno> elencoArbolicoltureDaLegno = new java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno>();

	/**
	 * imposta il valore del campo [elencoArbolicoltureDaLegno]
	 * @param val
	 * @generated
	 */

	public void setElencoArbolicoltureDaLegno(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno> val) {
		elencoArbolicoltureDaLegno = val;
	}

	/**
	 * legge il valore del campo [elencoArbolicoltureDaLegno]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno> getElencoArbolicoltureDaLegno() {
		return elencoArbolicoltureDaLegno;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public AttivitaUltimoAnno5() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-2019197089) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
