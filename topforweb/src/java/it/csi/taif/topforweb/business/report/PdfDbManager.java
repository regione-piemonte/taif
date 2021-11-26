/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.report;

import org.apache.log4j.Logger;

import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaDto;
import it.csi.taif.topforweb.business.dao.util.Constants;
import it.csi.taif.topforweb.business.manager.db.DbMgr;
import it.csi.taif.topforweb.business.manager.message.MsgMgr;
import it.csi.taif.topforweb.business.manager.service.ServiceMgr;
import it.csi.taif.topforweb.exception.DbManagerException;

import it.csi.taif.topforweb.util.service.integration.svista.Comune;
import it.csi.taif.topforweb.util.service.integration.svista.Provincia;



public class PdfDbManager {

    
    private static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE + ".business.report");
    
    private ServiceMgr serviceMgr;
    private MsgMgr msgMgr;
    private DbMgr dbMgr;
	

    public TaifTPersonaDto getPersona(int idPersona) throws DbManagerException {
	TaifTPersonaDto titolareRapp = new TaifTPersonaDto();
	try {
	    titolareRapp = dbMgr.getPersonaByIdPersona(idPersona);
	} catch (Exception e) {
	    throw new DbManagerException();
	}
	return titolareRapp;
    }

   

    public Comune getComuneFromIstat(String istatComune) throws DbManagerException {
	try {
	    return dbMgr.getComuneFromIstat(istatComune);
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new DbManagerException();
	}

    }

    public Provincia getProvinciaFromIstat(String istatComune) throws DbManagerException {

	try {
	    return dbMgr.getProvinciaFromIstat(istatComune);
	} catch (Exception e) {
	    throw new DbManagerException();
	}
    }

   

  

  

 

    public ServiceMgr getServiceMgr() {
        return serviceMgr;
    }

    public void setServiceMgr(ServiceMgr serviceMgr) {
        this.serviceMgr = serviceMgr;
    }

    public MsgMgr getMsgMgr() {
        return msgMgr;
    }

    public void setMsgMgr(MsgMgr msgMgr) {
        this.msgMgr = msgMgr;
    }

    public DbMgr getDbMgr() {
        return dbMgr;
    }

    public void setDbMgr(DbMgr dbMgr) {
        this.dbMgr = dbMgr;
    }
    
    
}
