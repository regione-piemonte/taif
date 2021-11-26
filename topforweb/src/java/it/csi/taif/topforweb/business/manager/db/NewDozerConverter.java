/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.manager.db;

import org.dozer.DozerConverter;

public class NewDozerConverter extends DozerConverter<String, Boolean>{

	public NewDozerConverter(Class<String> prototypeA, Class<Boolean> prototypeB) {
		super(prototypeA, prototypeB);
		// TODO Auto-generated constructor stub
		
	}
	
	 public Boolean convertTo(String source, Boolean destination) {
		    if ("true".equals(source)) {
		      return Boolean.TRUE;
		    } else if ("false".equals(source)) {
		      return Boolean.FALSE;
		    }
		    throw new IllegalStateException("Unknown value!");
		  }

		  public String convertFrom(Boolean source, String destination) {
		    if (Boolean.TRUE.equals(source)) {
		      return "true";
		    } else if (Boolean.FALSE.equals(source)) {
		      return "false";
		    }
		    throw new IllegalStateException("Unknown value!");
	
		  }	
	

}
