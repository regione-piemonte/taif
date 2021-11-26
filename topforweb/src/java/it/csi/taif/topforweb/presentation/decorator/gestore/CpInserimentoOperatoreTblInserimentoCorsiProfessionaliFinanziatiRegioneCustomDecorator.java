/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.decorator.gestore;

/*PROTECTED REGION ID(R-382244298) ENABLED START*/
import it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale;
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.ConvertUtil;
import org.apache.log4j.Logger;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpInserimentoOperatoreTblInserimentoCorsiProfessionaliFinanziatiRegioneCustomDecorator
		extends
			TableDecorator {

	public CpInserimentoOperatoreTblInserimentoCorsiProfessionaliFinanziatiRegioneCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-1283284877) ENABLED START*/
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".presentation");

	public Object getIconaCancella() {
		CorsoProfessionale curr = (CorsoProfessionale) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (ConvertUtil.checkIsNullOrEmpty(curr.getIconaCancella())) {
			html.append(
					"<a href=\"/topforweb/base/gestore/cpInserimentoOperatore!handleTblInserimentoCorsiProfessionaliFinanziatiRegione_CLICKED.do?idRiga=");
			html.append(curr.getIdCorsoProfessionale());
			html.append("&idColonna=");
			html.append(Constants.ICONA_CANCELLA);
			html.append("\"");
			html.append("\" class=\"elimina\" title=\"cancella corso con id = ");
			html.append(curr.getIdCorsoProfessionale());
			html.append("\">");
			html.append("X</a>");
		}
		return html.toString();
	}

	public Object getIconaAttestato() {
		CorsoProfessionale curr = (CorsoProfessionale) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (ConvertUtil.checkIsNullOrEmpty(curr.getIconaAttestato())) {
			html.append("<a href=\"downloadDocumentoDomanda.do");
			html.append("?idCorsoProfessionale=" + curr.getIdCorsoProfessionale());
			html.append("&idColonna=");
			html.append(Constants.ICONA_ATTESTATO);
			html.append("\"");
			html.append("\" title=\"genera attestato per il corso con id  ");
			html.append(curr.getIconaAttestato());
			html.append("\">");
			html.append("<span class=\"pdf\"></span>");
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
			html.append("&idColonna=");
			html.append(Constants.ICONA_PDF);
			html.append("\" title=\" allegato con id ");
			html.append(curr.getIconaAllegato());
			html.append("\">");
			html.append("<span class=\"pdf\"></span>");
			html.append("</a>");
		}
		return html.toString();
	}

	/*PROTECTED REGION END*/

}
