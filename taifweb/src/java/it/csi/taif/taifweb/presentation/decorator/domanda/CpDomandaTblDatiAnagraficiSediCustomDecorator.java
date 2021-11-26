/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.domanda;

/*PROTECTED REGION ID(R-412105297) ENABLED START*/
import it.csi.taif.taifweb.dto.domanda.Sede;
import it.csi.taif.taifweb.util.Constants;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDomandaTblDatiAnagraficiSediCustomDecorator extends TableDecorator {

	public CpDomandaTblDatiAnagraficiSediCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-1663203796) ENABLED START*/
	public Object getIconaCancella() {
		Sede curr = (Sede) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		html.append("<a href=\"/taifweb/base/domanda/CpDomanda!handleTblDatiAnagraficiSedi_CLICKED.do?idRiga=");
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
