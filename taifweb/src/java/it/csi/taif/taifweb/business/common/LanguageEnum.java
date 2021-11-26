/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.common;

import org.apache.log4j.Logger;

import it.csi.taif.taifweb.util.Constants;

public enum LanguageEnum {
	
		LANGUAGE_IT("it"),
		LANGUAGE_FR("fr");
		
		
		
		protected static final Logger log = //NOSONAR  Reason:EIAS 
				Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS
		
		private String lingua;

		/**
		 * @return the lingua
		 */
		public String getLingua() {
			return lingua;
		}

		/**
		 * @param profilo the lingua to set
		 */
		public void setLingua(String lingua) {
			this.lingua = lingua;
		}
		
		private LanguageEnum(String lingua) {
			this.lingua = lingua;
		}
		
		
		public static LanguageEnum getByLingua(String lingua) {
			log.debug("+++ lingua ? "+lingua+"+");
			for (LanguageEnum linguaEnum : values()) {
				log.debug("+++ LINGUA lingua? "+linguaEnum.getLingua()+"+");
				if(linguaEnum.getLingua()!=null && linguaEnum.getLingua().equals(lingua)) {
					log.debug("+++ LINGUA OK +++");
					return linguaEnum;
				}
			}
			return LANGUAGE_IT;
		}
}
