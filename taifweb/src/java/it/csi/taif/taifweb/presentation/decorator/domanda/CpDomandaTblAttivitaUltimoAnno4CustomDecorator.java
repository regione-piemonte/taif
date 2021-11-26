/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.domanda;

/*PROTECTED REGION ID(R-1263077071) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.taif.taifweb.dto.domanda.MaterialePropagazione;
import it.csi.taif.taifweb.util.Constants;

import org.apache.log4j.Logger;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDomandaTblAttivitaUltimoAnno4CustomDecorator extends TableDecorator {

	public CpDomandaTblAttivitaUltimoAnno4CustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R704623150) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".presentation"); //NOSONAR  Reason:EIAS
	public Object getAltro() {
		MaterialePropagazione curr = (MaterialePropagazione) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		log.debug("-------------------- ALTRO? " + curr.getAltroVisibile());
		if (curr.getAltroVisibile()) {
			String val = curr.getAltro();
			if (val == null) {
				val = "";
			}
			html.append("<input type=\"text\" name=\"appDataelencoMaterialePropagazione[");
			html.append(curr.getIdMaterialePropagazione());
			html.append(
					"].altro\" size=\"50\" value=\"" + val + "\" id=\"CpDomanda_appDataelencoMaterialePropagazione_");
			html.append(curr.getIdMaterialePropagazione());
			html.append("__altro\" onkeyup=\"copyValue(this, 'widg_hiddenAttivitaUltimoAnno4Altro')\">");
		} else {
			html.append("");
		}
		return html.toString();
	}
	/*PROTECTED REGION END*/

}
