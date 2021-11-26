/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.helper.dto.factory;

import it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter;
import it.csi.taif.topforweb.util.ConvertUtil;

public class RicercaOperatoreFilterFactory {
	
	public static RicercaOperatoreFilter createRicercaOperatoreFilter(Integer idPersona) {
		RicercaOperatoreFilter result = new RicercaOperatoreFilter();
		result.setIdPersona(ConvertUtil.convertToString(idPersona));
		return result;
	}
	
}
