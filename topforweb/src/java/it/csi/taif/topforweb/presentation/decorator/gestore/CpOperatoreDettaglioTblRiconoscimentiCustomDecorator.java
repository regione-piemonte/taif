/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.decorator.gestore;

/*PROTECTED REGION ID(R-1563833531) ENABLED START*/
/// inserire qui eventuali import aggiuntive

import it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale;
import it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento;
import it.csi.taif.topforweb.util.ConvertUtil;
import it.csi.taif.topforweb.util.Constants;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpOperatoreDettaglioTblRiconoscimentiCustomDecorator extends TableDecorator {

	public CpOperatoreDettaglioTblRiconoscimentiCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-1190659774) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	public Object getIconaCancella() {
		Riconoscimento curr = (Riconoscimento) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (ConvertUtil.checkIsNullOrEmpty(curr.getIconaCancella())) {
			html.append(
					"<a href=\"/topforweb/base/gestore/cpOperatoreDettaglio!handleTblRiconoscimenti_CLICKED.do?idRiga=");
			html.append(curr.getIdRiconoscimento());
			html.append("&idColonna=");
			html.append(Constants.ICONA_CANCELLA);
			html.append("\"");
			html.append("\" class=\"elimina\" title=\" cancella riconoscimenti con rownum = ");
			html.append(curr.getIdRiconoscimento());
			html.append("\">");
			html.append("X</a>");
		}
		return html.toString();
	}

	public Object getIconaAttestato() {
		CorsoProfessionale curr = (CorsoProfessionale) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (ConvertUtil.checkIsNullOrEmpty(curr.getIconaAttestato())) {
			html.append(
					"<a href=\"/topforweb/base/gestore/cpInserimentoOperatore!handleTblRiconoscimenti_CLICKED.do?idRiga=");
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

	/*PROTECTED REGION END*/

}
