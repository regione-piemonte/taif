/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.topforweb.action.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.DocumentException;
import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAgenziaFormativaByUnitaFormativaPersonaDto;
import it.csi.taif.topforweb.business.gestore.CPBECpInserimentoOperatore;
import it.csi.taif.topforweb.business.manager.message.Message;
import it.csi.taif.topforweb.dto.BaseSessionAwareDTO;
import it.csi.taif.topforweb.dto.operatore.Operatore;
import it.csi.taif.topforweb.exception.ManagerException;
import it.csi.taif.topforweb.presentation.topforweb.action.BaseAction;
import it.csi.taif.topforweb.presentation.topforweb.action.CommandExecutionException;
import it.csi.taif.topforweb.presentation.topforweb.action.ICommand;
import it.csi.taif.topforweb.util.Constants;

public class DownloadDocumentoAttestatoAction  extends BaseAction {

    
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
    private CPBECpInserimentoOperatore CPBECpInserimentoOperatore;
    
  
    
    public String execute() throws ManagerException, DocumentException, IOException {

   	LOG.debug("[DownloadDocumentoAttestatoAction::execute] BEGIN");
   	
   	
   	Integer idOperatore= (Integer) ActionContext.getContext().getSession().get("idOperatore");
   	String  dataTracciato = (String) ActionContext.getContext().getSession().get("appDatatracciato");
   	
   	LOG.debug("[DownloadDocumentoAttestatoAction::execute] idOperatore "+idOperatore);
   	LOG.debug("[DownloadDocumentoAttestatoAction::execute] dataTracciato "+dataTracciato);
   	
   	String idCorsoProfessionale= getIdCorsoProfessionale();
   	
   	LOG.debug("[DownloadDocumentoAttestatoAction::execute] idCorsoProfessionale "+idCorsoProfessionale);
   	
   	LOG.debug("-------------------     *"+this.CPBECpInserimentoOperatore+"*      --------------------------------");
   	
   	String  fileName = "attestatoFrequenza"; //this.CPBECpInserimentoOperatore.getFileName(idAzienda,idPratica, idTipoAllegato);
   	String _fileName= fileName + ".pdf";
   	this.setFilename(_fileName);
   	this.setContentDisposition(String.format(CONTENT_DISPOSITION_PATTERN, this.getFilename()));

   	LOG.debug("[DownloadDocumentoDomandaIscrizioneAction::execute] filename: " + this.getFilename());
   	//List<TaifTAgenziaFormativaByUnitaFormativaPersonaDto> listAgenziaFormativa
   	Operatore operatoreSelezionato = (Operatore) ActionContext.getContext().getSession().get("appDatadettaglioOperatoreSelezionato");
   	ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
   	LOG.debug("-- 1 -- ");
   	if(dataTracciato.equals(Constants.TRACCIATO_IT)) {
   		LOG.debug("-- 2 -- ");
          	    arrayOutputStream = this.CPBECpInserimentoOperatore.createPdfAttestato(Integer.parseInt(idCorsoProfessionale),operatoreSelezionato);
          	  LOG.debug("-- 3 -- ");  	    
      }
   	if (arrayOutputStream == null) {
   		LOG.debug("-- 4 -- ");
   	    throw new ManagerException(new Message());
   	}
   	
   	LOG.debug("-- 5 -- ");
   	
   	final ByteArrayInputStream bas = new ByteArrayInputStream(arrayOutputStream.toByteArray());

   	LOG.debug("-- 6 -- ");
   	
   	this.setInputStream(bas);

   	LOG.debug("[DownloadDocumentoAttestatoAction::execute] END");

   	return "downloadFile";
       }
    
    
    
  
    
    public CPBECpInserimentoOperatore getCPBECpInserimentoOperatore() {
        return CPBECpInserimentoOperatore;
    }

    public void setCPBECpInserimentoOperatore(CPBECpInserimentoOperatore cPBECpInserimentoOperatore) {
        CPBECpInserimentoOperatore = cPBECpInserimentoOperatore;
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
