/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.uiutils;

/**
 * @generated
 */
public class TableFilter implements java.io.Serializable {
	/**
	 * Dati impostati nel filtro
	 * @generated
	 */
	private DataFilter data;

	/**
	 * campo oggetto del filtro
	 */
	private String field;

	public DataFilter getData() {
		return data;
	}
	public void setData(DataFilter data) {
		this.data = data;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
}
