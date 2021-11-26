/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.topforweb.action.gestore;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.DocumentException;
import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaByCodiceFiscalePersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaDatiIdentificativiOperatoreDto;
import it.csi.taif.topforweb.business.gestore.CPBECpInserimentoOperatore;
import it.csi.taif.topforweb.business.gestore.CPBECpOperatoreDettaglio;
import it.csi.taif.topforweb.business.manager.message.Message;
import it.csi.taif.topforweb.dto.BaseSessionAwareDTO;
import it.csi.taif.topforweb.dto.operatore.Operatore;
import it.csi.taif.topforweb.exception.ManagerException;
import it.csi.taif.topforweb.presentation.topforweb.action.BaseAction;
import it.csi.taif.topforweb.presentation.topforweb.action.CommandExecutionException;
import it.csi.taif.topforweb.presentation.topforweb.action.ICommand;
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.ConvertUtil;

public class DownloadAttestatoDettaglioAction  extends BaseAction {

    
    /**
     * 
     */
    private static final long serialVersionUID = 4328979364584737452L;

    private static final Logger LOG = Logger.getLogger(it.csi.taif.topforweb.util.Constants.APPLICATION_CODE + ".presentation");

   

    private static final String CONTENT_DISPOSITION_PATTERN = "attachment; filename=\"%s\";";

    private HttpServletRequest request;
    private HttpServletResponse response;
    private String inputName;
    private String contentDisposition;
    private InputStream inputStream;
    private String filename;
    private String idCorsoProfessionale;
    private String idUnitaFormativa;
   
    
    
    @Autowired
    private CPBECpOperatoreDettaglio CPBECpOperatoreDettaglio;
    
  
    
    public String execute() throws ManagerException, DocumentException, IOException {

   	LOG.debug("[DownloadAttestatoDettaglioAction::execute] BEGIN");
   	
   	String  dataTracciato = (String) ActionContext.getContext().getSession().get("appDatatracciato");
   	String idCorsoProfessionale= getIdCorsoProfessionale();
   	
   	LOG.debug("-------------------     *"+this.CPBECpOperatoreDettaglio+"*      --------------------------------");
   	
   	String  fileName = "attestatoFrequenza"; 
   	String _fileName= fileName + ".pdf";
   	this.setFilename(_fileName);
   	this.setContentDisposition(String.format(CONTENT_DISPOSITION_PATTERN, this.getFilename()));

   	LOG.debug("[DownloadAttestatoDettaglioAction::execute] filename: " + this.getFilename());
   	
   	Operatore operatoreSelezionato = (Operatore) ActionContext.getContext().getSession().get("appDatadettaglioOperatoreSelezionato");
   	// List<TaifTPersonaByCodiceFiscalePersonaDto> titolarePerCodiceFiscale = dbMgr.findPersonaPerCodiceFiscale(datiOperatore.getCodiceFiscaleOperatore());   	
   	ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
   	if(dataTracciato.equals(Constants.TRACCIATO_IT)) {
   	
          	    arrayOutputStream = CPBECpOperatoreDettaglio.createPdfAttestato(Integer.parseInt(idCorsoProfessionale),operatoreSelezionato);
   	}
   	if (arrayOutputStream == null) {
   	    throw new ManagerException(new Message());
   	}
   	
   	
   	final ByteArrayInputStream bas = new ByteArrayInputStream(arrayOutputStream.toByteArray());

   	this.setInputStream(bas);

   	LOG.debug("[DownloadAttestatoDettaglioAction::execute] END");

   	return "downloadFile";
       }
    
      
    public CPBECpOperatoreDettaglio getCPBECpOperatoreDettaglio() {
        return CPBECpOperatoreDettaglio;
    }
    public void setCPBECpOperatoreDettaglio(CPBECpOperatoreDettaglio cPBECpOperatoreDettaglio) {
        CPBECpOperatoreDettaglio = cPBECpOperatoreDettaglio;
    }






    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

 
    
    public String getContentDisposition() {
        return contentDisposition;
    }

    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }

    public String getIdUnitaFormativa() {
        return idUnitaFormativa;
    }

    public void setIdUnitaFormativa(String idUnitaFormativa) {
        this.idUnitaFormativa = idUnitaFormativa;
    }

    public String getIdCorsoProfessionale() {
        return idCorsoProfessionale;
    }

    public void setIdCorsoProfessionale(String idCorsoProfessionale) {
        this.idCorsoProfessionale = idCorsoProfessionale;
    }

    @Override
    public Class modelClass() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public BaseSessionAwareDTO getModel() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setModel(BaseSessionAwareDTO t) {
	// TODO Auto-generated method stub
	
    }

    @Override
    protected void dumpModel(boolean pre) {
	// TODO Auto-generated method stub
	
    }

    @Override
    protected void doBeforeEventCommand() throws CommandExecutionException {
	// TODO Auto-generated method stub
	
    }

    @Override
    protected void doAfterEventCommand() throws CommandExecutionException {
	// TODO Auto-generated method stub
	
    }

    @Override
    protected ICommand initCommand(String moduleName, String panelName, String widgName, String eventName) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void clearPageScopedAppData(String targetContentPanelName) {
	// TODO Auto-generated method stub
	
    }

}
