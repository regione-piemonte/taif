/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.dto.factory;

import it.csi.taif.taifweb.util.service.integration.svista.Comune;
import it.csi.taif.taifweb.util.service.integration.svista.Provincia;

public class SvistaFactory {
	
	public static Comune createComuneEstero(String dsComuneEstero) {
		Comune result = new Comune();
		result.setNome(dsComuneEstero);
		result.setCodIstat("999999");
		return result;
	}
	
	public static Provincia createProvinciaEstero() {
		Provincia result = new Provincia();
		result.setNome(" ");
		result.setSigla("STATO ESTERO");
		return result;
	}
	
}
