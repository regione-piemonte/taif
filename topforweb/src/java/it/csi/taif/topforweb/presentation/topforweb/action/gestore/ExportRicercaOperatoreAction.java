/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.topforweb.action.gestore;

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

import it.csi.taif.topforweb.business.gestore.CPBECpElencoOperatori;
import it.csi.taif.topforweb.business.manager.message.Message;
import it.csi.taif.topforweb.dto.BaseSessionAwareDTO;
import it.csi.taif.topforweb.exception.ManagerException;
import it.csi.taif.topforweb.presentation.topforweb.action.BaseAction;
import it.csi.taif.topforweb.presentation.topforweb.action.CommandExecutionException;
import it.csi.taif.topforweb.presentation.topforweb.action.ICommand;

@SuppressWarnings("rawtypes")
public class ExportRicercaOperatoreAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 658295454925075582L;
	private static final Logger LOG = Logger
			.getLogger(it.csi.taif.topforweb.util.Constants.APPLICATION_CODE + ".presentation");

	private static final String CONTENT_TYPE = "application/pdf";
	private static final String CONTENT_DISPOSITION_PATTERN = "attachment; filename=\"%s\";";

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String inputName;
	private String contentDisposition;
	private InputStream inputStream;
	private String contentType;
	private String filename;
	private String tipoExport;

	/**
	 * @return the tipoExport
	 */
	public String getTipoExport() {
		return tipoExport;
	}

	/**
	 * @param tipoExport
	 *            the tipoExport to set
	 */
	public void setTipoExport(String tipoExport) {
		this.tipoExport = tipoExport;
	}

	private final String TIPO_EXPORT_NORMALE = "NORMALE";
	private final String TIPO_EXPORT_RIDOTTO = "RIDOTTO";

	@Autowired
	private CPBECpElencoOperatori CPBECpElencoOperatori;

	public CPBECpElencoOperatori getCPBECpElencoOperatori() {
		return CPBECpElencoOperatori;
	}

	public void setCPBECpElencoOperatori(CPBECpElencoOperatori cPBECpElencoOperatori) {
		CPBECpElencoOperatori = cPBECpElencoOperatori;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws ManagerException, Exception {
		LOG.debug("[ExportRicercaGestoreAction::execute] BEGIN");

		this.setContentType(CONTENT_TYPE);

		this.setFilename("exportOperatoriForestali"
				.concat(new Timestamp(System.currentTimeMillis()).toString().concat(".xlsx")));

		this.setContentDisposition(String.format(CONTENT_DISPOSITION_PATTERN, this.getFilename()));

		LOG.debug("[ExportRicercaOperatoreAction::execute] filename: " + this.getFilename());
		ArrayList<Integer> listIdOperatoriTrovati = new ArrayList<Integer>();
		listIdOperatoriTrovati = (ArrayList<Integer>) ActionContext.getContext().getSession().get("idOperatoriTrovati");
		String tracciato = (String) ActionContext.getContext().getSession().get("tracciatoExp");

		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		if(TIPO_EXPORT_NORMALE.equalsIgnoreCase(getTipoExport())) {
			arrayOutputStream = this.CPBECpElencoOperatori.makeExportToExcel(listIdOperatoriTrovati, tracciato);
		}
		else {
			arrayOutputStream = this.CPBECpElencoOperatori.makeExportToExcelRidotto(listIdOperatoriTrovati, tracciato);
		}
		if (arrayOutputStream == null) {
			throw new ManagerException(new Message());
		}
		final ByteArrayInputStream bas = new ByteArrayInputStream(arrayOutputStream.toByteArray());
		this.setInputStream(bas);

		LOG.debug("[ExportRicercaOperatoreAction::execute] END");
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

}
