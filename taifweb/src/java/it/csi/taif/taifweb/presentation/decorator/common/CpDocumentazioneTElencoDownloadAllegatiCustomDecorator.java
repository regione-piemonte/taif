/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.common;

/*PROTECTED REGION ID(R2041100437) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.taif.taifweb.dto.allegatodownload.AllegatoDownload;
import it.csi.taif.taifweb.util.Constants;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDocumentazioneTElencoDownloadAllegatiCustomDecorator extends TableDecorator {

	public CpDocumentazioneTElencoDownloadAllegatiCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R2120350354) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  
	public Object getIconaDownload() {
		AllegatoDownload curr = (AllegatoDownload) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		//	html.append(
		//			"<a href=\"/taifweb/base/common/CpDocumentazione!handleTElencoDownloadAllegati_CLICKED.do?idRiga=");
		html.append("<a href=\"downloadDocumentoDomanda.do");
		html.append("?idTipoAllegato=" + curr.getIdTipoAllegato());
		html.append("\" title=\"scarica modello allegato ");
		html.append("\">");
		html.append("<span class=\"pdf\"></span>");
		html.append("</a>");

		return html.toString();
	}
	/*PROTECTED REGION END*/

}
