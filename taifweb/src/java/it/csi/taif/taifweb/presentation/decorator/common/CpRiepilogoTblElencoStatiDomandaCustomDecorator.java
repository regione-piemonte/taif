/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.decorator.common;

/*PROTECTED REGION ID(R-1483478058) ENABLED START*/
import it.csi.taif.taifweb.dto.domanda.DettaglioStato;
import it.csi.taif.taifweb.util.Constants;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpRiepilogoTblElencoStatiDomandaCustomDecorator extends TableDecorator {

	public CpRiepilogoTblElencoStatiDomandaCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R1683163667) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	public Object getIconaModifica() {
		DettaglioStato curr = (DettaglioStato) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (curr.getEsisteDB() && !curr.getEditing()) {
			html.append("<a href=\"/taifweb/base/common/CpRiepilogo!handleTblElencoStatiDomanda_CLICKED.do?idRiga=");
			html.append(curr.getRownum());
			html.append("&idColonna=");
			html.append(Constants.ICONA_MODIFICA);
			html.append("\"");
			html.append("\" class=\"modifica\" title=\" rownum = ");
			html.append(curr.getRownum());
			html.append("\">");
			html.append("&nbsp;</a>");
		} else {
			html.append("<span class=\"modifica_disable\">");
			html.append("&nbsp;</span>");
		}
		return html.toString();
	}

	public Object getIconaSalva() {
		DettaglioStato curr = (DettaglioStato) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (curr.getEditing()) {
			html.append("<a href=\"/taifweb/base/common/CpRiepilogo!handleTblElencoStatiDomanda_CLICKED.do?idRiga=");
			html.append(curr.getRownum());
			html.append("&idColonna=");
			html.append(Constants.ICONA_SALVA);
			html.append("\"");
			html.append("\" class=\"salva\" title=\" rownum = ");
			html.append(curr.getRownum());
			html.append("\">");
			html.append("&nbsp;</a>");
		} else {
			html.append("<span class=\"salva_disable\">");
			html.append("&nbsp;</span>");
		}
		return html.toString();
	}

	public Object getIconaCancella() {
		DettaglioStato curr = (DettaglioStato) getCurrentRowObject();
		StringBuffer html = new StringBuffer();
		if (curr.getEditing() && !curr.getEsisteDB()) {
			html.append("<a href=\"/taifweb/base/common/CpRiepilogo!handleTblElencoStatiDomanda_CLICKED.do?idRiga=");
			html.append(curr.getRownum());
			html.append("&idColonna=");
			html.append(Constants.ICONA_CANCELLA);
			html.append("\"");
			html.append("\" class=\"elimina\" title=\"rownum = ");
			html.append(curr.getRownum());
			html.append("\">");
			html.append("</a>");
		} else {
			html.append("<span class=\"elimina_disable\">");
			html.append("&nbsp;</span>");
		}
		return html.toString();
	}

	/*PROTECTED REGION END*/

}
