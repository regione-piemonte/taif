/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.dto.qualifica;

public class Qualifica implements java.io.Serializable {

	/// Field [idQualifica]
	private java.lang.String idQualifica = null;

	/**
	 * imposta il valore del campo [idQualifica]
	 * @param val
	 * @generated
	 */

	public void setIdQualifica(java.lang.String val) {
		idQualifica = val;
	}

	/**
	 * legge il valore del campo [idQualifica]
	 * @generated
	 */
	public java.lang.String getIdQualifica() {
		return idQualifica;
	}

	/// Field [agenziaFormativa]
	private java.lang.String agenziaFormativa = null;

	/**
	 * imposta il valore del campo [agenziaFormativa]
	 * @param val
	 * @generated
	 */

	public void setAgenziaFormativa(java.lang.String val) {
		agenziaFormativa = val;
	}

	/**
	 * legge il valore del campo [agenziaFormativa]
	 * @generated
	 */
	public java.lang.String getAgenziaFormativa() {
		return agenziaFormativa;
	}

	/// Field [dataQualifica]
	private java.lang.String dataQualifica = null;

	/**
	 * imposta il valore del campo [dataQualifica]
	 * @param val
	 * @generated
	 */

	public void setDataQualifica(java.lang.String val) {
		dataQualifica = val;
	}

	/**
	 * legge il valore del campo [dataQualifica]
	 * @generated
	 */
	public java.lang.String getDataQualifica() {
		return dataQualifica;
	}

	/// Field [tipoQualifica]
	private java.lang.String tipoQualifica = null;

	/**
	 * imposta il valore del campo [tipoQualifica]
	 * @param val
	 * @generated
	 */

	public void setTipoQualifica(java.lang.String val) {
		tipoQualifica = val;
	}

	/**
	 * legge il valore del campo [tipoQualifica]
	 * @generated
	 */
	public java.lang.String getTipoQualifica() {
		return tipoQualifica;
	}

	/// Field [iconaCancella]
	private java.lang.String iconaCancella = null;

	/**
	 * imposta il valore del campo [iconaCancella]
	 * @param val
	 * @generated
	 */

	public void setIconaCancella(java.lang.String val) {
		iconaCancella = val;
	}

	/**
	 * legge il valore del campo [iconaCancella]
	 * @generated
	 */
	public java.lang.String getIconaCancella() {
		return iconaCancella;
	}

	/// Field [iconaAttestato]
	private java.lang.String iconaAttestato = null;

	/**
	 * imposta il valore del campo [iconaAttestato]
	 * @param val
	 * @generated
	 */

	public void setIconaAttestato(java.lang.String val) {
		iconaAttestato = val;
	}

	/**
	 * legge il valore del campo [iconaAttestato]
	 * @generated
	 */
	public java.lang.String getIconaAttestato() {
		return iconaAttestato;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Qualifica() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1370985638) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
