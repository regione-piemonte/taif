/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.domanda;

/*PROTECTED REGION ID(R-133905506) ENABLED START*/
import it.csi.taif.taifweb.dto.domanda.FormaOrganizzativa;
import it.csi.taif.taifweb.util.Constants;

import org.apache.log4j.Logger;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDomandaTblDatiSocioeconomiciFormaOrganizzativaCustomDecorator extends TableDecorator {

	public CpDomandaTblDatiSocioeconomiciFormaOrganizzativaCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-1725484069) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2

	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".presentation");

	public Object getAltro() {

		FormaOrganizzativa curr = (FormaOrganizzativa) getCurrentRowObject();
		int rownum = curr.getRownum();
		StringBuffer html = new StringBuffer();
		log.debug("-------------------- ALTRO? " + curr.getAltroVisibile());
		log.debug("-------------------- ROWNUM? " + curr.getRownum());
		if (curr.getAltroVisibile()) {
			String val = curr.getAltro();
			if (val == null) {
				val = "";
			}
			html.append("<input type=\"text\" name=\"appDataelencoFormeOrganizzative");
			html.append(rownum);
			html.append("altro\" size=\"50\" value=\"" + val + "\" id=\"CpDomanda_appDataelencoFormeOrganizzative_");
			html.append(rownum);
			html.append("__altro\" onkeyup=\"copyValue(this, 'widg_hiddenFormeOrganizzativeAltro");
			html.append(rownum);
			html.append("')\">");
		} else {
			html.append("");
		}

		return html.toString();
	}
	/*PROTECTED REGION END*/

}
