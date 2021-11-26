/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.topforweb.action.gestore;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAllegatoDto;
import it.csi.taif.topforweb.business.manager.TopForMgr;
import it.csi.taif.topforweb.util.Constants;

public class VisualizzaAllegatoAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8278895378038763041L;
	
	private static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".presentation");
	
	private static final String CONTENT_DISPOSITION_PATTERN = "attachment; filename=\"%s\";";
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String inputName;
	private String contentDisposition;
	private InputStream inputStream;
	private String filename;
        private TopForMgr topForMgr;
        private String idAllegato;
    
        public TopForMgr getTopForMgr() {
    		return topForMgr;
    	}
    
    	public void setTopForMgr(TopForMgr topForMgr) {
    		this.topForMgr = topForMgr;
    	}

	

	
	/*
     * (non-Javadoc)
     * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(javax.servlet.http.HttpServletRequest)
     */
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
     */
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     *
     * @return
     */
    public HttpServletRequest getRequest() {
        return this.request;
    }

    /**
     *
     * @param request
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     *
     * @return
     */
    public HttpServletResponse getResponse() {
        return this.response;
    }

    /**
     *
     * @param response
     */
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     *
     * @return
     */
    public String getInputName() {
        return this.inputName;
    }

    /**
     *
     * @param inputName
     */
    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    /**
     *
     * @return
     */
    public String getContentDisposition() {
        return this.contentDisposition;
    }

    /**
     *
     * @param contentDisposition
     */
    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }

    /**
     *
     * @return
     */
    public InputStream getInputStream() {
        return this.inputStream;
    }

    /**
     *
     * @param inputStream
     */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

        /**
     *
     * @return
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     *
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

	/**
	 * @return the idAllegato
	 */
    /**
	 * @return the idAllegato
	 */
	public String getIdAllegato() {
		if(this.request.getSession().getAttribute(Constants.INDEX_ID_ALLEGATO_SELEZIONATO)!=null) {
			this.idAllegato = (String) this.request.getSession().getAttribute(Constants.INDEX_ID_ALLEGATO_SELEZIONATO);
			this.request.getSession().setAttribute(Constants.INDEX_ID_ALLEGATO_SELEZIONATO, null);
		}
		else {
			this.idAllegato = this.request.getParameter("idAllegato");
		}
		return idAllegato;
	}

	/**
	 * @param idAllegato the idAllegato to set
	 */
	public void setIdAllegato(String idAllegato) {
		this.idAllegato = idAllegato;
	}
	
    public String execute() throws Exception {
        LOGGER.info("[VisualizzaAllegatoAction::execute] BEGIN");

        LOGGER.info("ID ALLEGATO ???? *" + this.getIdAllegato() + "*");
        final TaifTAllegatoDto allegato = this.topForMgr.getTaifTAllegatoByPk(this.idAllegato);
        final byte[] file = this.topForMgr.downloadFile(this.idAllegato);
        LOGGER.info(" POST METODO ");

        this.setContentDisposition(String.format(CONTENT_DISPOSITION_PATTERN, allegato.getNomeFile()));
        
        final ByteArrayInputStream bas = new ByteArrayInputStream(file);

		this.setInputStream(bas);

        LOGGER.info("[VisualizzaAllegatoAction::execute] END");

        return SUCCESS;
    }
    
}
