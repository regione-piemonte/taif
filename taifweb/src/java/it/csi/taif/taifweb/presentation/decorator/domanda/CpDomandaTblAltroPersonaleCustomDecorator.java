/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.domanda;

/*PROTECTED REGION ID(R1408241892) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.taif.taifweb.dto.domanda.Personale;
import it.csi.taif.taifweb.util.Constants;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDomandaTblAltroPersonaleCustomDecorator extends TableDecorator {

	public CpDomandaTblAltroPersonaleCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R2146507425) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2 
	public Object getIconaCancella() {
		Personale curr = (Personale) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		html.append("<a href=\"/taifweb/base/domanda/CpDomanda!handleTblAltroPersonale_CLICKED.do?idRiga=");
		html.append(curr.getRownum());
		html.append("&idColonna=");
		html.append(Constants.ICONA_CANCELLA);
		html.append("\"");
		html.append("\" class=\"elimina\" title=\"elimina riga");
		html.append(curr.getRownum());
		html.append("\">");
		html.append("X</a>");

		return html.toString();
	}

	public Object getIconaOperatore() {
		Personale curr = (Personale) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		html.append("<a href=\"/taifweb/jsp/modal_corsi.jsp?row=");
		html.append(curr.getRownum());
		html.append("\" class=\"operatore aprialbo\">");
		html.append(curr.getRownum());
		html.append("\">");
		html.append("X</a>");

		return html.toString();
	}

	/*PROTECTED REGION END*/

}
