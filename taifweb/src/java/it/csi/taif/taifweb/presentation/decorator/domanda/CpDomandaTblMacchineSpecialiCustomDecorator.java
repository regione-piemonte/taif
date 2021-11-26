/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.domanda;

/*PROTECTED REGION ID(R134248391) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.taif.taifweb.dto.domanda.MacchinaMezzo;
import it.csi.taif.taifweb.util.Constants;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDomandaTblMacchineSpecialiCustomDecorator extends TableDecorator {

	public CpDomandaTblMacchineSpecialiCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-710681020) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  
	public Object getIconaCancella() {
		MacchinaMezzo curr = (MacchinaMezzo) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		html.append("<a href=\"/taifweb/base/domanda/CpDomanda!handleTblMacchineSpeciali_CLICKED.do?idRiga=");
		html.append(curr.getRownum());
		html.append("&idColonna=");
		html.append(Constants.ICONA_CANCELLA);
		html.append("\"");
		html.append("\" class=\"elimina\" title=\"prova custom decorator cancella con rownum = ");
		html.append(curr.getRownum());
		html.append("\">");
		html.append("X</a>");

		return html.toString();
	}
	/*PROTECTED REGION END*/

}
