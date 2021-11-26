/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.home;

/*PROTECTED REGION ID(R-1963875871) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.taif.taifweb.dto.domanda.AziendaAAEP;
import it.csi.taif.taifweb.util.Constants;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpHomeTElencoAziendeAAEPCustomDecorator extends TableDecorator {

	public CpHomeTElencoAziendeAAEPCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-1758673186) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e'
	/// disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2

	public Object getIconaDettaglio() {
		AziendaAAEP curr = (AziendaAAEP) getCurrentRowObject();
		StringBuffer html = new StringBuffer();

		html.append("<a href=\"/taifweb/base/home/cpHome!handleTElencoAziendeAAEP_CLICKED.do?idRiga=");
		html.append(curr.getCodiceFiscale());
		html.append("&idColonna=");
		html.append(Constants.ICONA_DETTAGLIO);
		html.append("\"");
		html.append("\" class=\"modifica\" title=\"rownum = ");
		html.append(curr.getCodiceFiscale());
		html.append("\">");
		html.append("X</a>");

		return html.toString();
	}

	/*PROTECTED REGION END*/

}
