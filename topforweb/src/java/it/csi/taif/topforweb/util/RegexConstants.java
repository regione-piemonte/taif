/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util;

public final class RegexConstants {
	
	/**
	 * Espressione regolare per il codice fiscale (AAAAAA99A99A999A)
	 */
	public static final String CODICE_FISCALE = "[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]";
	/**
	 * Espressione regolare per il codice fiscale (AAAAAA99A99A99AA)
	 */
	public static final String CODICE_FISCALE_STRANIERI = "[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d[a-zA-Z][a-zA-Z]";
	/**
	 * Espressione regolare per la mail
	 */
	public static final String EMAIL = "^([a-zA-Z0-9_\\-\\.]+)*[a-zA-Z0-9]@[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
	
	/**
	 * Espressione regolare per la data
	 */
	public static final String DATA = "(0[1-9]|[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012]|[1-9])/(19|20)\\d{2}";
	/**
	 * Espressione regolare per il cap
	 */
	public static final String CAP = "\\d{5}";
	/**
	 * Espressione regolare per la partita IVA
	 */
	public static final String PARTITA_IVA = "\\d{11}";
	
	/**
	 * Espressione regolare per la partita IVA
	 */
	public static final String PECMAIL = "^(?)(\\\".+?(?<!\\\\\\\\)\\\"@)|(([0-9a-z]((\\\\.(?!\\\\.))|[-!#\\\\$%&'\\\\*\\\\+/=\\\\?\\\\^`{}|~\\\\w])*)(?<=[0-9a-z])@)(?)([(\\\\d{1,3}.){3}\\\\d{1,3}])|(([0-9a-z][-0-9a-z]*[0-9a-z]*.)+[a-z0-9][-a-z0-9]{0,22}[a-z0-9])$";
	/**
	 * Espressione regolare pernumero di telefono
	 */
	public static final String TELEFONO = "^[0-9_ ]{0,15}$";
	
	/**
	 * Espressione regolare per sito
	 */
	public static final String INTERNETSITE ="^(https?:\\\\/\\\\/)?(www\\.)?([\\\\w\\\\Q$-_+!*'(),%\\\\E]+\\\\.)+[‌​\\\\w]{2,63}\\\\/?$";
	
	/**
	 * Espressione regolare per la partita IVA
	 */
	public static final String MARCA_DA_BOLLO = "\\d{14}";
	
	public static final String CIVICO = "\\d{5}";
	
	public static final String ANNO_PATTERN =  "\\d{4}$";
	
	public static final String DOUBLE_INTEGER = "\\d+?\\,*\\d*";
	
	public static final String DOUBLE_INTEGER2 = "\\d+?\\.*\\d*";
	
	public static final String PERCENT_PATTERN =  "^((100)|(\\d{1,2}(.\\d*)?))$";
	
	public static final String DATA_FORMAT= "^(3[01]|[12][0-9]|0?[1-9])/(1[0-2]|0?[1-9])/(?:[0-9]{2})?[0-9]{2}$";
	
}
