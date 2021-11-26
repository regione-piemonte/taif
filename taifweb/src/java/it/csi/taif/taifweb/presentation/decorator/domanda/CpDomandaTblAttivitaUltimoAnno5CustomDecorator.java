/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.domanda;

/*PROTECTED REGION ID(R1021786384) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno;
import it.csi.taif.taifweb.util.Constants;

import org.apache.log4j.Logger;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDomandaTblAttivitaUltimoAnno5CustomDecorator extends TableDecorator {

	public CpDomandaTblAttivitaUltimoAnno5CustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R715939277) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".presentation"); //NOSONAR  Reason:EIAS
	public Object getAltro() {
		ArboricolturaDaLegno curr = (ArboricolturaDaLegno) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		log.debug("-------------------- ALTRO? " + curr.getAltroVisibile());
		if (curr.getAltroVisibile()) {
			String val = curr.getAltro();
			int rownum = curr.getRownum();
			if (val == null) {
				val = "";
			}
			html.append("<input type=\"text\" name=\"appDataelencoMaterialePropagazione[");
			html.append(rownum);
			html.append(
					"].altro\" size=\"50\" value=\"" + val + "\" id=\"CpDomanda_appDataelencoMaterialePropagazione_");
			html.append(rownum);
			html.append("__altro\">");
		} else {
			html.append(curr.getAltro());
		}
		return html.toString();
	}

	public Object getIconaCancella() {
		ArboricolturaDaLegno curr = (ArboricolturaDaLegno) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		//		if (curr.getIconaCancellaVisibile()) {
		html.append("<a href=\"/taifweb/base/domanda/CpDomanda!handleTblAttivitaUltimoAnno5_CLICKED.do?idRiga=");
		html.append(curr.getRownum());
		html.append("&idColonna=");
		html.append(Constants.ICONA_CANCELLA);
		html.append("\"");
		html.append("\" class=\"elimina\" title=\"prova custom decorator cancella con rownum = ");
		html.append(curr.getRownum());
		html.append("\">");
		html.append("X</a>");
		//		}
		return html.toString();
	}
	/*PROTECTED REGION END*/

}
