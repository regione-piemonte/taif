/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.decorator.gestore;

/*PROTECTED REGION ID(R584145432) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.taif.topforweb.dto.qualifica.Qualifica;
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.ConvertUtil;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpOperatoreDettaglioTblQualificheCustomDecorator extends TableDecorator {

	public CpOperatoreDettaglioTblQualificheCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R2033918165) ENABLED START*/

	public Object getIconaCancella() {
		Qualifica curr = (Qualifica) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (ConvertUtil.checkIsNullOrEmpty(curr.getIconaCancella())) {
			html.append(
					"<a href=\"/topforweb/base/gestore/cpOperatoreDettaglio!handleTblQualifiche_CLICKED.do?idRiga=");
			html.append(curr.getIdQualifica());
			html.append("&idColonna=");
			html.append(Constants.ICONA_CANCELLA);
			html.append("\"");
			html.append("\" class=\"elimina\" title=\"cancella qualifica con id = ");
			html.append(curr.getIdQualifica());
			html.append("\">");
			html.append("X</a>");
		}
		return html.toString();
	}

	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  
	/*PROTECTED REGION END*/

}
