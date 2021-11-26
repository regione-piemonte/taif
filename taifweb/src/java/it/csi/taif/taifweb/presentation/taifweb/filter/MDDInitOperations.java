/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.filter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.dispatcher.ng.HostConfig;
import org.apache.struts2.dispatcher.ng.InitOperations;

public class MDDInitOperations extends InitOperations {

	@Override
	public Dispatcher initDispatcher(HostConfig filterConfig) {
		Dispatcher dispatcher = createDispatcher(filterConfig);
		dispatcher.init();
		return dispatcher;
	}

	private Dispatcher createDispatcher(HostConfig filterConfig) {
		Map<String, String> params = new HashMap();
		for (Iterator e = filterConfig.getInitParameterNames(); e.hasNext();) {
			String name = (String) e.next();
			String value = filterConfig.getInitParameter(name);
			params.put(name, value);
		}
		return new MDDDispatcher(filterConfig.getServletContext(), params);
	}

}
