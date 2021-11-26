/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper;



import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

import it.csi.taif.taifweb.util.service.integration.primpaforserv.PrimpaforservIstanzaServiceLocator;
import it.csi.taif.taifweb.util.service.integration.primpaforserv.PrimpaforservIstanza_PortType;


public class PrimpaforservHelper extends AbstractServiceHelper {
	
 private static Logger log = Logger.getLogger("primpaforserv");
 private static PrimpaforservHelper instance;

 private PrimpaforservIstanza_PortType servicePort=null;
 
 protected static String urlService = null;
 
 
 private PrimpaforservHelper(String urlService) throws Exception  {

	 try {
    		 log.info("\nPRIMPA marcSTARNA BEGIN connessione a " + urlService);

    		 servicePort =(PrimpaforservIstanza_PortType) (new PrimpaforservIstanzaServiceLocator()).getprimpaforservIstanza(new URL(urlService));
    	

   		     log.info("marc PRIMPA STARNA END\n");
		
	} catch (Exception e) {

		e.printStackTrace();
		log.debug("STARNA - PrimpaforserHELPER - Errore nella connessione al servizio remoto: "+e.getMessage());
		System.out.println("STARNAAAAAAAAAAAAAAAAAAA  EXCEPTION " + e);
		throw e;

	}

 }
	
	
	  public static PrimpaforservHelper getInstance() throws Exception {
		  if(instance == null) { instance = new PrimpaforservHelper(urlService); } 
		  return instance; 
	  }
	 
  

 public  PrimpaforservIstanza_PortType getPrimpaforserv() /*throws ServiceException */{
     return servicePort;
 }

 	
}
