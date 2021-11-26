/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.acta;

import java.io.IOException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import it.csi.taif.taifweb.business.helper.AbstractServiceHelper;
import it.csi.taif.taifweb.business.helper.ApiManagerServiceHelper;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.service.integration.acta.objectservice.ObjectServiceLocator;
import it.csi.taif.taifweb.util.service.integration.acta.objectservice.ObjectServicePort;
import it.csi.wso2.apiman.oauth2.helper.GenericWrapperFactoryBean;
import it.csi.wso2.apiman.oauth2.helper.TokenRetryManager;
import it.csi.wso2.apiman.oauth2.helper.WsProvider;
import it.csi.wso2.apiman.oauth2.helper.extra.axis1.Axis1Impl;

public class ObjectServiceHelper extends AbstractServiceHelper {
	
	private ObjectServicePort service;

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".service");

	private ApiManagerServiceHelper apiManagerServiceHelper;

	/**
	 * @return the apiManagerServiceHelper
	 */
	public ApiManagerServiceHelper getApiManagerServiceHelper() {
		return apiManagerServiceHelper;
	}

	/**
	 * @param apiManagerServiceHelper
	 *            the apiManagerServiceHelper to set
	 */
	public void setApiManagerServiceHelper(ApiManagerServiceHelper apiManagerServiceHelper) {
		this.apiManagerServiceHelper = apiManagerServiceHelper;
	}

	protected String urlService = null;

	public ObjectServiceHelper(String urlService) {

		this.urlService = urlService;

	}

	private ObjectServicePort getService()
			throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[ObjectServiceHelper::getService] BEGIN");

		// if (this.service == null) {
		ObjectServiceLocator serviceLoc = new ObjectServiceLocator();

		ObjectServicePort port = serviceLoc.getObjectServicePort();

		final TokenRetryManager trm = new TokenRetryManager();
		trm.setOauthHelper(getApiManagerServiceHelper().getOauthHelper());
		//
		final WsProvider wsp = new Axis1Impl();
		trm.setWsProvider(wsp);

		GenericWrapperFactoryBean gwfb = new GenericWrapperFactoryBean();
		LOGGER.debug("url service " + this.urlService);
		gwfb.setEndPoint(this.urlService);
		gwfb.setWrappedInterface(ObjectServicePort.class);
		gwfb.setPort(port);
		gwfb.setTokenRetryManager(trm);

		this.service = (ObjectServicePort) gwfb.create();

		LOGGER.debug("[ObjectServiceHelper::getService] Service 'ObjectServicePort' INITIALIZED");
		// }

		LOGGER.debug("[ObjectServiceHelper::getService] END");

		return this.service;
	}
}
