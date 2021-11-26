/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.service.integration.primpaforserv;



import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;


public class PrimpaforservHelper {
	
	
 private static Logger log = Logger.getLogger("primpaforserv");
 private static PrimpaforservHelper instance;

 private PrimpaforservIstanza_PortType servicePort=null;
 
 
 private PrimpaforservHelper() throws Exception  {

	 try {
			 InputStream is = getClass().getClassLoader().getResourceAsStream("primpaforservWsdlConf.properties");		

			 Properties ps = new Properties();
			 ps.load(is);			
   			 String serviceUrl =  ps.getProperty("PRIMPAFORSERV_WSDL");		
    		 log.info("\nPRIMPA marcSTARNA BEGIN connessione a "+serviceUrl);

    		 servicePort =(PrimpaforservIstanza_PortType) (new PrimpaforservIstanzaServiceLocator()).getprimpaforservIstanza(new URL(serviceUrl));
    	

   		     log.info("marc PRIMPA STARNA END\n");
		
	} catch (Exception e) {

		e.printStackTrace();
		log.debug("STARNA - PrimpaforserHELPER - Errore nella connessione al servizio remoto: "+e.getMessage());
		System.out.println("STARNAAAAAAAAAAAAAAAAAAA  EXCEPTION " + e);
		throw e;

	}

 }
	
 public static PrimpaforservHelper getInstance() throws Exception {
	 if(instance == null) {
		 instance = new PrimpaforservHelper();
	 }
	 return instance;
 }
  

 public  PrimpaforservIstanza_PortType getPrimpaforserv() /*throws ServiceException */{
     return servicePort;
 }

 	
}
