/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.decorator.gestore;

/*PROTECTED REGION ID(R1202295852) ENABLED START*/
/// inserire qui eventuali import aggiuntive

import it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale;
import it.csi.taif.topforweb.dto.qualifica.Qualifica;
import it.csi.taif.topforweb.util.ConvertUtil;
import it.csi.taif.topforweb.util.Constants;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpInserimentoOperatoreTblQualificheCustomDecorator extends TableDecorator {

	public CpInserimentoOperatoreTblQualificheCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-2126327831) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	public Object getIconaCancella() {
		Qualifica curr = (Qualifica) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (ConvertUtil.checkIsNullOrEmpty(curr.getIconaCancella())) {
			html.append(
					"<a href=\"/topforweb/base/gestore/cpInserimentoOperatore!handleTblQualifiche_CLICKED.do?idRiga=");
			html.append(curr.getIdQualifica());
			html.append("&idColonna=");
			html.append(Constants.ICONA_CANCELLA);
			html.append("\"");
			html.append("\" class=\"elimina\" title=\" cancella qualifica con rownum = ");
			html.append(curr.getIdQualifica());
			html.append("\">");
			html.append("X</a>");
		}
		return html.toString();
	}

	public Object getIconaAttestato() {
		Qualifica curr = (Qualifica) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (ConvertUtil.checkIsNullOrEmpty(curr.getIconaAttestato())) {
			html.append(
					"<a href=\"/topforweb/base/gestore/cpInserimentoOperatore!handleTblQualifiche_CLICKED.do?idRiga=");
			html.append(curr.getIconaAttestato());
			html.append("&idColonna=");
			html.append(Constants.ICONA_PDF);
			html.append("\"");
			html.append("\" class=\"pdf\" title=\"scarica allegato con id ");
			html.append(curr.getIconaAttestato());
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
			html.append("&idColonna=");
			html.append(Constants.ICONA_PDF);
			html.append("\" title=\"scarica allegato con id ");
			html.append(curr.getIconaAllegato());
			html.append("\">");
			html.append("<span class=\"pdf\"></span>");
			html.append("</a>");
		}
		return html.toString();
	}

	/*PROTECTED REGION END*/

}
