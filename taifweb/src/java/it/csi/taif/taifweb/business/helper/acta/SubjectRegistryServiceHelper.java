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
import it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice.SubjectRegistryServiceLocator;
import it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice.SubjectRegistryServicePort;
import it.csi.wso2.apiman.oauth2.helper.GenericWrapperFactoryBean;
import it.csi.wso2.apiman.oauth2.helper.TokenRetryManager;
import it.csi.wso2.apiman.oauth2.helper.WsProvider;
import it.csi.wso2.apiman.oauth2.helper.extra.axis1.Axis1Impl;

public class SubjectRegistryServiceHelper extends AbstractServiceHelper {
	
	private SubjectRegistryServicePort service;

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

	public SubjectRegistryServiceHelper(String urlService) {

		this.urlService = urlService;

	}

	private SubjectRegistryServicePort getService()
			throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[SubjectRegistryServiceHelper::getService] BEGIN");

		// if (this.service == null) {
		SubjectRegistryServiceLocator serviceLoc = new SubjectRegistryServiceLocator();

		SubjectRegistryServicePort port = serviceLoc.getSubjectRegistryServicePort();

		final TokenRetryManager trm = new TokenRetryManager();
		trm.setOauthHelper(getApiManagerServiceHelper().getOauthHelper());
		//
		final WsProvider wsp = new Axis1Impl();
		trm.setWsProvider(wsp);

		GenericWrapperFactoryBean gwfb = new GenericWrapperFactoryBean();
		LOGGER.debug("url service " + this.urlService);
		gwfb.setEndPoint(this.urlService);
		gwfb.setWrappedInterface(SubjectRegistryServicePort.class);
		gwfb.setPort(port);
		gwfb.setTokenRetryManager(trm);

		this.service = (SubjectRegistryServicePort) gwfb.create();

		LOGGER.debug("[SubjectRegistryServiceHelper::getService] Service 'SubjectRegistryServicePort' INITIALIZED");
		// }

		LOGGER.debug("[SubjectRegistryServiceHelper::getService] END");

		return this.service;
	}
}
