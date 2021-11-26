/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.common;

import org.apache.log4j.Logger;

import it.csi.taif.taifweb.util.Constants;

public enum ProfiloEnum {
	AZIENDA_IT("1"),
	AZIENDA_FR("2"),
	PROFESSIONISTA_IT("3"),
	PROFESSIONISTA_FR("4"),
	GESTORE_IT("5"),
	GESTORE_FR("6"),
	LIBERO_IT("7"),
	LIBERO_FR("8");
	
	
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS
	
	private String profilo;

	/**
	 * @return the profilo
	 */
	public String getProfilo() {
		return profilo;
	}

	/**
	 * @param profilo the profilo to set
	 */
	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}
	
	private ProfiloEnum(String profilo) {
		this.profilo = profilo;
	}
	
	
	public static ProfiloEnum getByProfilo(String profilo) {
		log.debug("+++ PROFILO ? "+profilo+"+");
		for (ProfiloEnum profiloEnum : values()) {
			log.debug("+++ PROFILO ENUM? "+profiloEnum.getProfilo()+"+");
			if(profiloEnum.getProfilo()!=null && profiloEnum.getProfilo().equals(profilo)) {
				log.debug("+++ PROFILO OK +++");
				return profiloEnum;
			}
		}
		return AZIENDA_IT;
	}
}
