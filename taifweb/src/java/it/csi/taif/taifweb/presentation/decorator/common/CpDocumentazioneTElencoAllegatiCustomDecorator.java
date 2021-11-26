/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.common;

/*PROTECTED REGION ID(R-1615257539) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.dto.allegato.Allegato;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDocumentazioneTElencoAllegatiCustomDecorator extends TableDecorator {

	public CpDocumentazioneTElencoAllegatiCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R20458554) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  
	public Object getIconaCancella() {
		Allegato curr = (Allegato) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		html.append("<a href=\"/taifweb/base/common/CpDocumentazione!handleTElencoAllegati_CLICKED.do?idRiga=");
		html.append(curr.getIdAllegato());
		html.append("&idColonna=");
		html.append(Constants.ICONA_CANCELLA);
		html.append("\"");
		html.append("\" class=\"elimina\" title=\"prova custom decorator cancella con rownum = ");
		html.append(curr.getIdAllegato());
		html.append("\">");
		html.append("</a>");
		return html.toString();
	}

	public Object getIconaDownload() {
		Allegato curr = (Allegato) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		html.append("<a href=\"visualizzaFile.do?idAllegato=");
		html.append(curr.getIdAllegato());
		html.append("\" title=\"download documento = ");
		html.append(curr.getIdAllegato());
		html.append("\">");
		html.append("<span class=\"pdf\"></span>");
		html.append("</a>");
		return html.toString();
	}

	/*PROTECTED REGION END*/

}
