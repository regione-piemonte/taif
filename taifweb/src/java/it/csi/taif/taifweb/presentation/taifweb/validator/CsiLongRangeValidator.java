/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.validator;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.RangeValidatorSupport;

/**
 * Controlla il valore del campo di tipo Long sia contenuto nel range atteso
 *
 * @author GuiGen
 */
public class CsiLongRangeValidator extends RangeValidatorSupport<Long> {

	protected CsiLongRangeValidator() {
		super(Long.class);
	}
}
