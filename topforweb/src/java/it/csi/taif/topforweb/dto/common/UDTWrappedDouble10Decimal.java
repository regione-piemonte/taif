/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.dto.common;

/*PROTECTED REGION ID(R1591819386) ENABLED START*/
//inserire qui eventuali import aggiuntivi

/*PROTECTED REGION END*/
/**
 * Implementazione dello user defined type [WrappedDouble10Decimal].
 * <ul>
 * <li>tipo scalare base: DOUBLE</li>
 * <li>modificatori:
 *   <ul>
 *	 </ul>
 * </li>
 * </ul>
 * @generated
 */
public class UDTWrappedDouble10Decimal implements java.io.Serializable, Comparable {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 */
	public UDTWrappedDouble10Decimal() {
		super();
	}

	/**
	 * Costruttore per valore del DTO.
	 */
	public UDTWrappedDouble10Decimal(java.lang.Double v) {
		super();
		_value = v;
	}

	private java.lang.Double _value;

	public java.lang.Double getValue() {
		return _value;
	}

	public void setValue(java.lang.Double s) {
		_value = s;
	}

	/**
	 * implementazione del confronto di uguaglianza tra due istanze
	 * di UDTWrappedDouble10Decimal. 
	 */
	public boolean equals(Object other) {
		// un oggetto nullo e' distinto da tutti gli altri
		if (other == null)
			return false;
		// un oggetto di tipo differente non puo' essere uguale
		if (!(other instanceof UDTWrappedDouble10Decimal))
			return false;
		UDTWrappedDouble10Decimal otherSpecific = (UDTWrappedDouble10Decimal) other;
		// un valore nullo non e' uguale ad un valore non nullo
		if ((_value == null && otherSpecific.getValue() != null)
				|| (_value != null && otherSpecific.getValue() == null))
			return false;
		// valori entrambi non nulli: posso confrontare
		/*PROTECTED REGION ID(R-744119005) ENABLED START*/
		// TODO inserire qui la logica specifica di confronto e rimuovere l'eccezione UnsupportedOperationException
		//return _value.equals(otherSpecific.getValue());
		throw new UnsupportedOperationException("Metodo UDTWrappedDouble10Decimal.equals() non implementato");
		/*PROTECTED REGION END*/
	}

	/**
	 * implementazione della comparazione quantitativa tra due istanze
	 * di UDTWrappedDouble10Decimal. 
	 */
	public int compareTo(Object other) {
		// un oggetto nullo e' distinto da tutti gli altri e per convenzione li precede
		if (other == null)
			return +1;
		// un oggetto di tipo differente non puo' essere confrontato
		if (!(other instanceof UDTWrappedDouble10Decimal))
			throw new IllegalArgumentException(
					"impossibile confrontare un UDTWrappedDouble10Decimal con " + other.getClass());
		UDTWrappedDouble10Decimal otherSpecific = (UDTWrappedDouble10Decimal) other;
		// un valore nullo precede un valore non nullo
		if (_value == null && otherSpecific.getValue() != null)
			return -1;
		if (_value != null && otherSpecific.getValue() == null)
			return +1;
		// due valori nulli sono uguali
		if (_value == null && otherSpecific.getValue() == null)
			return 0;
		// valori entrambi non nulli: posso confrontare
		/*PROTECTED REGION ID(R56564858) ENABLED START*/
		// TODO: inserire qui la logica specifica di confronto e rimuovere l'eccezione UnsupportedOperationException
		//return _value.compareTo(otherSpecific.getValue());		
		throw new UnsupportedOperationException("Metodo UDTWrappedDouble10Decimal.compareTo() non implementato");
		/*PROTECTED REGION END*/
	}

	public int hashCode() {
		return _value == null ? 0 : _value.hashCode();
	}

	public String toString() {
		/*PROTECTED REGION ID(R1433890504) ENABLED START*/
		// TODO: inserire qui la logica specifica di rappresentazione a stringa
		//return "" + _value;
		throw new UnsupportedOperationException("Metodo UDTWrappedDouble10Decimal.toString() non implementato");
		/*PROTECTED REGION END*/

	}

	/*PROTECTED REGION ID(R2139603740) ENABLED START*/
	// inserire qui eventuali metodi aggiuntivi 
	/*PROTECTED REGION END*/

}
