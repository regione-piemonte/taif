/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper;

import java.io.IOException;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfParamApimgrDto;
import it.csi.taif.taifweb.business.helper.dto.ApiManagerDto;
import it.csi.taif.taifweb.business.manager.db.DbMgr;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.GenericUtil;
import it.csi.wso2.apiman.oauth2.helper.OauthHelper;

import org.apache.log4j.Logger;


public class ApiManagerServiceHelper extends AbstractServiceHelper {

	/**
	 * Logger.
	 */
	protected static final Logger LOGGER = Logger
			.getLogger(Constants.APPLICATION_CODE + ".service");

	/**
	 * Istanza di {@link DbMgr}.
	 */
	private DbMgr dbMgr;
	
	public ApiManagerServiceHelper(String taifTokenUrl){
		this.taifTokenUrl = taifTokenUrl;
	}
	
	
	/**
	 * Restituisce l'istanza di {@link DbMgr}.
	 * 
	 * @return the dbMgr l'istanza di {@link DbMgr}
	 */
	public DbMgr getDbMgr() {
		return this.dbMgr;
	}

	/**
	 * Imposta l'istanza di {@link DbMgr}.
	 * 
	 * @param dbMgr
	 *            l'stanza di {@link DbMgr}
	 */
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	
	private OauthHelper oauthHelper;

	private String taifTokenUrl;
	

	public final OauthHelper getOauthHelper() throws IOException,
			DbManagerException {
		LOGGER.debug("[ApiManagerServiceHelper::getOauthHelper] BEGIN");
	
		TaifCnfParamApimgrDto config = this.getDbMgr().getParametriApiManager();
    	
		if (this.oauthHelper == null) {
			this.oauthHelper = new OauthHelper(
					this.taifTokenUrl,
					//"https://tst-api-ent.ecosis.csi.it/api/token",
					config.getConsumerKey(),
					//"HBxosGiK8fYHHMfZW6qWYyjt_SAa",
					config.getConsumerSecret(), 10000);
					//"2qZSNCr5KIa44gRbuYCa4t64DXMa", 10000);
		}
		
		LOGGER.debug("[ApiManagerServiceHelper::getOauthHelper] END");
		return this.oauthHelper;
		

	}
	
	public final ApiManagerDto getApiManagerInfo() throws DbManagerException{
		ApiManagerDto result = new ApiManagerDto();
		LOGGER.debug("[ApiManagerServiceHelper::getApiManagerInfo] BEGIN");
		TaifCnfParamApimgrDto config = this.getDbMgr().getParametriApiManager();
		result.setConsumerKey(config.getConsumerKey());
		result.setConsumerSecret(config.getConsumerSecret());
		result.setUrl(this.taifTokenUrl);
		LOGGER.debug("[ApiManagerServiceHelper::getApiManagerInfo] END");
		return result;
	}

}
