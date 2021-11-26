/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.decorator.gestore;

/*PROTECTED REGION ID(R504730271) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale;
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.ConvertUtil;
import org.apache.log4j.Logger;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpOperatoreDettaglioTblAltriCorsiCustomDecorator extends TableDecorator {

	public CpOperatoreDettaglioTblAltriCorsiCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R661770012) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".presentation");

	public Object getIconaAttestato() {
		CorsoProfessionale curr = (CorsoProfessionale) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (ConvertUtil.checkIsNullOrEmpty(curr.getIconaAttestato())) {
			html.append(
					"<a href=\"/topforweb/base/gestore/cpOperatoreDettaglio!handleTblAltriCorsi_CLICKED.do?idRiga=");
			html.append(curr.getIdCorsoProfessionale());
			html.append("&idColonna=");
			html.append(Constants.ICONA_PDF);
			html.append("\"");
			html.append("\" class=\"pdf\" title=\"scarica allegato con id ");
			html.append(curr.getIdCorsoProfessionale());
			html.append("\">");
			html.append("</a>");
		}
		return html.toString();
	}

	public Object getIconaAllegato() {
		CorsoProfessionale curr = (CorsoProfessionale) getCurrentRowObject();
		StringBuffer html = new StringBuffer();

		if (ConvertUtil.checkIsNullOrEmpty(curr.getIconaAllegato())) {
			html.append("<a href=\"visualizzaFile.do?idAllegato=");
			html.append(curr.getIconaAllegato());
			html.append("\">");
			html.append("<span class=\"pdf\"></span>");
			html.append("</a>");
		}
		return html.toString();
	}
	/*PROTECTED REGION END*/

}
