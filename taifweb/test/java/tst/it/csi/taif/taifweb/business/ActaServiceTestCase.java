/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package tst.it.csi.taif.taifweb.business;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import it.csi.taif.taifweb.business.helper.ActaServiceHelper;
import it.csi.taif.taifweb.exception.ServiceException;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.GenericUtil;
import it.csi.util.beanlocatorfactory.ServiceBeanLocator;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ActaServiceTestCase {

    private static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".test.service");

    private static final String APPLICATION_CONTEXT_XML = "dao-test-beans.xml";

    private static final String ACTA_SERVICE_BEAN = "actaServiceHelper";

    private ActaServiceHelper actaServiceHelper;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
       
        try {
        	 @SuppressWarnings("unused")
        	final ApplicationContext context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML);
        	LOGGER.debug("Context? "+context);
        	GenericUtil.stampaVO(context, true);
        	LOGGER.debug("---------------- "+context.getBeanDefinitionCount());
        }
        catch (Exception e) {
        	System.err.println(e.getMessage());
			e.printStackTrace();
		}
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    	try {
    		this.actaServiceHelper = (ActaServiceHelper) ServiceBeanLocator.getBeanByName(ACTA_SERVICE_BEAN);
    	}
    	catch (Exception e) {
    		LOGGER.error("------       "+e.getMessage());
			e.printStackTrace();
		}
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    
    @Test
    public void testActa() throws ServiceException {
        LOGGER.debug("[ActaServiceHelper::testActa] BEGIN");

       
        try {
            this.actaServiceHelper.testActa();

            //assertThat(result, is(not(nullValue())));
            
            

            //LOGGER.debug("[ActaServiceHelper::testGetAziendaByCodiceFiscaleAaep] soggetti proponenti: " + objectToString(result));
        } finally {
            LOGGER.debug("[ActaServiceHelper::testActa] END");
        }
    }
    

}
