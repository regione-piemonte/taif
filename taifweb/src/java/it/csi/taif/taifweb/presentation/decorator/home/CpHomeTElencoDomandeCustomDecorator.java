/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.home;

/*PROTECTED REGION ID(R-2083554602) ENABLED START*/
/// inserire qui eventuali import aggiuntive

import it.csi.taif.taifweb.dto.domanda.Domanda;
import it.csi.taif.taifweb.util.Constants;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpHomeTElencoDomandeCustomDecorator extends TableDecorator {

	public CpHomeTElencoDomandeCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-400140013) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  
	public Object getIconaCancella() {
		Domanda curr = (Domanda) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (curr.getIdStato() == 1) {

			html.append("<a href=\"/taifweb/base/home/cpHome!handleTElencoDomande_CLICKED.do?idRiga=");
			html.append(curr.getIdDomanda());
			html.append("&idColonna=");
			html.append(Constants.ICONA_CANCELLA);
			html.append("\"");
			html.append("\" class=\"elimina\" title=\"prova custom decorator cancella con rownum = ");
			html.append(curr.getIdDomanda());
			html.append("\">");
			html.append("X</a>");
		}
		return html.toString();
	}
	/*PROTECTED REGION END*/

}
