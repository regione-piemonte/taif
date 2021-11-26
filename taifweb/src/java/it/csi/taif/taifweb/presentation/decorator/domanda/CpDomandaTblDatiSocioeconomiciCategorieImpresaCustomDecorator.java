/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.domanda;

/*PROTECTED REGION ID(R-154839052) ENABLED START*/
import it.csi.taif.taifweb.dto.domanda.CategoriaImpresa;
import it.csi.taif.taifweb.util.Constants;

import org.apache.log4j.Logger;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDomandaTblDatiSocioeconomiciCategorieImpresaCustomDecorator extends TableDecorator {

	public CpDomandaTblDatiSocioeconomiciCategorieImpresaCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R1519183281) ENABLED START*/

	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".presentation"); //NOSONAR  Reason:EIAS

	public Object getAltro() {
		CategoriaImpresa curr = (CategoriaImpresa) getCurrentRowObject();
		int rownum = curr.getRownum();
		StringBuffer html = new StringBuffer();
		log.debug("-------------------- ALTRO? " + curr.getAltroVisibile());
		if (curr.getAltroVisibile()) {
			String val = curr.getAltro();
			if (val == null) {
				val = "";
			}
			html.append("<input type=\"text\" name=\"appDataelencoCategorieImpresa");
			html.append(rownum);
			html.append("altro\" size=\"50\" value=\"" + val + "\" id=\"CpDomanda_appDataelencoCategorieImpresa_");
			html.append(rownum);
			//html.append("__altro\" onkeyup=\"copyValue(this, 'widg_hiddenCategoriaAltro4')\">");
			html.append("__altro\" onkeyup=\"copyValue(this, 'widg_hiddenCategoriaAltro4')\">");
		} else {
			html.append("");
		}

		return html.toString();
	}
	/*PROTECTED REGION END*/

}
