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
 * DTO specifico della query modellata nel finder assortimentoByIdAssortimentoVisible.
 * @generated
 */
public class TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto implements Serializable {

	/*	 
	 * @generated
	 */
	private String assortimento;

	/**
	 * @generated
	 */
	public void setAssortimento(String val) {

		assortimento = val;

	}
	/**
	 * @generated
	 */
	public String getAssortimento() {

		return assortimento;

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
