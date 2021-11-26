/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.domanda;

/*PROTECTED REGION ID(R-1850867521) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.taif.taifweb.dto.domanda.Attivita;
import it.csi.taif.taifweb.util.Constants;

import org.apache.log4j.Logger;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDomandaTblAttivitaUltimoAnnoCustomDecorator extends TableDecorator {

	public CpDomandaTblAttivitaUltimoAnnoCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R1821328700) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".presentation");

	public Object getIconaDettaglio() {
		Attivita curr = (Attivita) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (curr.getIconaDettaglioVisibile()) {
			html.append("<a href=\"/taifweb/base/domanda/CpDomanda!handleTblAttivitaUltimoAnno_CLICKED.do?idRiga=");
			html.append(curr.getRownum());
			html.append("&idColonna=");
			html.append(Constants.ICONA_DETTAGLIO);
			html.append("\"");
			html.append("\" class=\"elimina\" title=\"prova custom decorator cancella con rownum = ");
			html.append(curr.getRownum());
			html.append("\">");
			html.append("X</a>");
		}
		return html.toString();
	}

	public Object getAltro() {

		Attivita curr = (Attivita) getCurrentRowObject();
		int rownum = curr.getRownum();
		StringBuffer html = new StringBuffer();
		log.debug("-------------------- ALTRO? " + curr.getAltroVisibile());
		log.debug("-------------------- ROWNUM? " + curr.getRownum());
		if (curr.getAltroVisibile()) {
			html.append("<input type=\"text\" name=\"appDataelencoAttivitaUltimoAnno[");
			html.append(rownum);
			html.append("].altro\" size=\"30\" value=\"\" id=\"CpDomanda_appDataelencoAttivitaUltimoAnno_");
			html.append(rownum);
			html.append("__altro\">");
		} else {
			html.append("");
		}

		return html.toString();
	}

	/*PROTECTED REGION END*/

}
