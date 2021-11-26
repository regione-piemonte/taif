/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.acta;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import it.csi.taif.taifweb.business.helper.AbstractServiceHelper;
import it.csi.taif.taifweb.business.helper.ApiManagerServiceHelper;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.service.integration.acta.archive.AcarisRepositoryEntryType;
import it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
import it.csi.taif.taifweb.util.service.integration.acta.managementservice.ManagementServicePort;
import it.csi.taif.taifweb.util.service.integration.acta.repositoryservice.RepositoryServiceLocator;
import it.csi.taif.taifweb.util.service.integration.acta.repositoryservice.RepositoryServicePort;
import it.csi.wso2.apiman.oauth2.helper.GenericWrapperFactoryBean;
import it.csi.wso2.apiman.oauth2.helper.TokenRetryManager;
import it.csi.wso2.apiman.oauth2.helper.WsProvider;
import it.csi.wso2.apiman.oauth2.helper.extra.axis1.Axis1Impl;

public class RepositoryServiceHelper extends AbstractServiceHelper {
	private RepositoryServicePort service;

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

	public RepositoryServiceHelper(String urlService) {
		LOGGER.debug("************* url service " + this.urlService);
		this.urlService = urlService;

	}

	private RepositoryServicePort getService()
			throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[RepositoryServiceHelper::getService] BEGIN");

		// if (this.service == null) {
		RepositoryServiceLocator serviceLoc = new RepositoryServiceLocator();

		RepositoryServicePort port = serviceLoc.getRepositoryServicePort();

		final TokenRetryManager trm = new TokenRetryManager();
		trm.setOauthHelper(getApiManagerServiceHelper().getOauthHelper());
		//
		final WsProvider wsp = new Axis1Impl();
		trm.setWsProvider(wsp);

		GenericWrapperFactoryBean gwfb = new GenericWrapperFactoryBean();
		LOGGER.debug("url service " + this.urlService);
		gwfb.setEndPoint(this.urlService);
		gwfb.setWrappedInterface(ManagementServicePort.class);
		gwfb.setPort(port);
		gwfb.setTokenRetryManager(trm);

		this.service = (RepositoryServicePort) gwfb.create();

		LOGGER.debug("[RepositoryServiceHelper::getService] Service 'RepositoryServicePort' INITIALIZED");
		// }

		LOGGER.debug("[RepositoryServiceHelper::getService] END");

		return this.service;
	}
	
	public AcarisRepositoryEntryType[] getRepositories() {
		LOGGER.debug("[RepositoryServiceHelper::getRepositories] BEGIN");
		AcarisRepositoryEntryType[] result = null;
		try {
			result = this.getService().getRepositories();
		} catch (AcarisFaultType e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DbManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.debug("[RepositoryServiceHelper::getRepositories] END");
		return result;
	}
}
