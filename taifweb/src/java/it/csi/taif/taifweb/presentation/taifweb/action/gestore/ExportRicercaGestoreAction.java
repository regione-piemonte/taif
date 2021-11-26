/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.action.gestore;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.taifweb.business.gestore.CPBECpElencoAziendeGestore;
import it.csi.taif.taifweb.dto.BaseSessionAwareDTO;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.presentation.taifweb.action.BaseAction;
import it.csi.taif.taifweb.presentation.taifweb.action.CommandExecutionException;
import it.csi.taif.taifweb.presentation.taifweb.action.ICommand;
import it.csi.taif.taifweb.util.Constants;

@SuppressWarnings("rawtypes")
public class ExportRicercaGestoreAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7726105284483353592L;

	private static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".presentation");

	private static final String CONTENT_TYPE = "application/pdf";
	private static final String CONTENT_DISPOSITION_PATTERN = "attachment; filename=\"%s\";";
	private final String TIPO_EXPORT_NORMALE = "NORMALE";
	private final String TIPO_EXPORT_RIDOTTO = "RIDOTTO";

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String inputName;
	private String contentDisposition;
	private InputStream inputStream;
	private String contentType;
	private String filename;
	private String tipoExport;

	@Autowired
	private CPBECpElencoAziendeGestore CPBECpElencoAziendeGestore;

	public CPBECpElencoAziendeGestore getCPBECpElencoAziendeGestore() {
		return CPBECpElencoAziendeGestore;
	}

	public void setCPBECpElencoAziendeGestore(CPBECpElencoAziendeGestore cPBECpElencoAziendeGestore) {
		CPBECpElencoAziendeGestore = cPBECpElencoAziendeGestore;
	}

	public String execute() throws ManagerException, Exception {
		LOG.debug("[ExportRicercaGestoreAction::execute] BEGIN");

		this.setContentType(CONTENT_TYPE);

		this.setFilename("exportElencoAziende".concat(new Timestamp(System.currentTimeMillis()).toString().concat(".xlsx")));

		this.setContentDisposition(String.format(CONTENT_DISPOSITION_PATTERN, this.getFilename()));

		LOG.debug("[ExportRicercaGestoreAction::execute] filename: " + this.getFilename());
		ArrayList<Integer> listIdAziendaTrovate = new ArrayList<Integer>();
		listIdAziendaTrovate = (ArrayList<Integer>) ActionContext.getContext().getSession().get("idAziendeTrovate");

		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		if(TIPO_EXPORT_NORMALE.equalsIgnoreCase(getTipoExport())) {
			arrayOutputStream = this.CPBECpElencoAziendeGestore.makeExportToExcel(listIdAziendaTrovate);
		}
		else {
			arrayOutputStream = this.CPBECpElencoAziendeGestore.makeExportToExcelRidotto(listIdAziendaTrovate);
		}
		if (arrayOutputStream == null) {
			throw new ManagerException(new it.csi.taif.taifweb.business.manager.message.Message());
		}
		final ByteArrayInputStream bas = new ByteArrayInputStream(arrayOutputStream.toByteArray());
		this.setInputStream(bas);

		LOG.debug("[ExportRicercaGestoreAction::execute] END");
		return "downloadFile";

	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
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

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
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

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
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

	/**
	 * @return the tipoExport
	 */
	public String getTipoExport() {
		return tipoExport;
	}

	/**
	 * @param tipoExport the tipoExport to set
	 */
	public void setTipoExport(String tipoExport) {
		this.tipoExport = tipoExport;
	}
	
	

}
