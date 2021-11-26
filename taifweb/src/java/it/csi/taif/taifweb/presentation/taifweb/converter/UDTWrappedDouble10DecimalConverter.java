/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.converter;

import java.util.Map;

import it.csi.taif.taifweb.dto.common.UDTWrappedDouble10Decimal;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/*PROTECTED REGION ID(R-2022186334) ENABLED START*/
//inserire qui eventuali import aggiuntivi

/*PROTECTED REGION END*/

/**
 * Custom Type Converter per lo user defined type [WrappedDouble10Decimal].
 * 
 * @author [GUIGEN]
 * @generated
 */
public class UDTWrappedDouble10DecimalConverter extends StrutsTypeConverter {

	/**
	 * Trasforma una rappresentazione a stringa di un oggetto di tipo
	 * UDTWrappedDouble10Decimal.
	 * @param  context
	 * @param  values
	 * @param  toClass
	 * @return
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		/*PROTECTED REGION ID(R-472951219) ENABLED START*/
		// TODO: implementare il metodo e rimuovere l'eccezione UnsupportedOperationException
		/*if (values!=null && values.length>0){
			String s = values[0].trim();
			UDTWrappedDouble10Decimal val = new UDTWrappedDouble10Decimal();
			try {
				// HINT: convertire in maniera opportuna la stringa s in un tipo compatibile con quello su cui e' basato
				//       il SimpleType User Defined, e settarla nell'oggetto val creato
				? t = ?;
				val.setValue(t);
				// HINT: end
			} catch (Exception e) {
				throw new TypeConversionException("Valore " + s + " non ammesso per il tipo UDTWrappedDouble10Decimal");
			}
			return val;
		}
		else {
			return null;
		}*/
		throw new UnsupportedOperationException(
				"Metodo UDTWrappedDouble10DecimalConverter.convertFromString() non implementato");
		/*PROTECTED REGION END*/
	}

	/**
	 * Trasforma una istanza di UDTWrappedDouble10Decimal nella rappresentazione a stringa.
	 * @param
	 * @param
	 * @return
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map context, Object o) {
		UDTWrappedDouble10Decimal val = (UDTWrappedDouble10Decimal) o;
		/*PROTECTED REGION ID(R-1632173858) ENABLED START*/
		// TODO: implementare la logica di conversione a stringa e rimuovere l'eccezione UnsupportedOperationException
		//return val==null ? "" : (val.getValue()!=null ? val.getValue() : "");
		throw new UnsupportedOperationException(
				"Metodo UDTWrappedDouble10DecimalConverter.convertToString() non implementato");
		/*PROTECTED REGION END*/
	}

}
