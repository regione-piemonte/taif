/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.qbe;

/**
 * 
 * Verifica di conformita' con una regular expression 
 * @generated
 */
public class RegexpChk extends FieldChk {

	/**
	 * @generated
	 */
	private final String regexp;

	/**
	 * @param equalsTo valore di confronto 
	 * @generated
	 */
	public RegexpChk(String p_regexp) {
		assert p_regexp != null && p_regexp.length() > 0;
		regexp = p_regexp;
	}

	/**
	 * @generated
	 */
	public String getRegexp() {
		return regexp;
	}
}
