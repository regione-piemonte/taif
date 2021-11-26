/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.action.domanda;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.taifweb.business.common.CPBECpDocumentazione;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaPk;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaDto;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.message.Message;
import it.csi.taif.taifweb.business.report.SchedaAzienda;
import it.csi.taif.taifweb.dto.BaseSessionAwareDTO;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.presentation.taifweb.action.BaseAction;
import it.csi.taif.taifweb.presentation.taifweb.action.CommandExecutionException;
import it.csi.taif.taifweb.presentation.taifweb.action.ICommand;
import it.csi.taif.taifweb.util.Constants;

@SuppressWarnings("rawtypes")
public class DownloadDocumentoDomandaIscrizioneAction extends BaseAction {

	private static final long serialVersionUID = -4241169739259022819L;

	private static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".presentation");

	private static final String CONTENT_DISPOSITION_PATTERN = "attachment; filename=\"%s\";";

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String inputName;
	private String contentDisposition;
	private InputStream inputStream;
	private String filename;
	private String idTipoAllegato;

	@Autowired
	private CPBECpDocumentazione CPBECpDocumentazione;

	@Autowired
	private SchedaAzienda schedaAzienda;

	public void setSchedaAzienda(SchedaAzienda schedaAzienda) {
		this.schedaAzienda = schedaAzienda;
	}

	public void setCPBECpDocumentazione(CPBECpDocumentazione cPBECpDocumentazione) {
		CPBECpDocumentazione = cPBECpDocumentazione;
	}

	public String execute() throws ManagerException {

		LOG.debug("[DownloadDocumentoDomandaIscrizioneAction::execute] BEGIN");

		String idTipoAllegato = getIdTipoAllegato();
		LOG.debug("[DownloadDocumentoDomandaIscrizioneAction::execute] filename: " + idTipoAllegato);

		Integer idAzienda = (Integer) ActionContext.getContext().getSession().get("appDataidAzienda");
		Integer idPratica = (Integer) ActionContext.getContext().getSession().get("appDataidPratica");
		String flagFirma = (String) ActionContext.getContext().getSession().get("flagFirma");
		String dataTracciato = (String) ActionContext.getContext().getSession().get("appDatatracciato");

		LOG.debug("-------------------     *" + this.CPBECpDocumentazione + "*      --------------------------------");

		String fileName = this.CPBECpDocumentazione.getFileName(idAzienda, idPratica, idTipoAllegato);
		String _fileName = fileName + ".pdf";
		this.setFilename(_fileName);
		this.setContentDisposition(String.format(CONTENT_DISPOSITION_PATTERN, this.getFilename()));

		LOG.debug("[DownloadDocumentoDomandaIscrizioneAction::execute] filename: " + this.getFilename());

		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
			if ((idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.one))
					|| (idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.two))) {
				arrayOutputStream = this.CPBECpDocumentazione.makePdf(idAzienda, idPratica, flagFirma);
			} else if ((idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.fiveStr))
					|| (idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.six))) {
				arrayOutputStream = this.CPBECpDocumentazione.makeDichiarazionePdf(idAzienda, idPratica, flagFirma);
			} else if ((idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.three))
					|| (idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.four))) {
				arrayOutputStream = this.CPBECpDocumentazione.makeAttestazionePdf(idAzienda, idPratica, flagFirma);
			} else if ((idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.eight))) {
				LOG.debug("[---------- ] *" + schedaAzienda + "*");
				arrayOutputStream = schedaAzienda.makeSchedaAziendaPdf(idAzienda, dataTracciato);
			}
		} else {
			if ((idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.elevenStr))
					|| (idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.twelveStr))) {
				arrayOutputStream = this.CPBECpDocumentazione.makeDichiarazioneFrancesePdf(idAzienda, idPratica,
						flagFirma);
			} else if ((idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.eight))) {
				LOG.debug("[---------- ] *" + schedaAzienda + "*");
				arrayOutputStream = schedaAzienda.makeSchedaAziendaPdf(idAzienda, dataTracciato);
			}
		}

		if (arrayOutputStream == null) {
			throw new ManagerException(new Message());
		}

		final ByteArrayInputStream bas = new ByteArrayInputStream(arrayOutputStream.toByteArray());

		this.setInputStream(bas);

		LOG.debug("[DownloadDocumentoDomandaIscrizioneAction::execute] END");

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
	 * @return the idTipoAllegato
	 */
	public String getIdTipoAllegato() {
		return idTipoAllegato;
	}

	/**
	 * @param idTipoAllegato
	 *            the idTipoAllegato to set
	 */
	public void setIdTipoAllegato(String idTipoAllegato) {
		this.idTipoAllegato = idTipoAllegato;
	}

}
