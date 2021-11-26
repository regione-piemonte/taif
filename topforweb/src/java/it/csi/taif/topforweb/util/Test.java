/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util;

import it.csi.taif.topforweb.business.gestore.WizardDomandaStatus;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String selected = Constants.WIZARD_SEL_5;
		
		WizardDomandaStatus d = WizardDomandaStatus.getByName(selected);
		
		System.out.println(d.getNextElement(selected));
		
	}

}
