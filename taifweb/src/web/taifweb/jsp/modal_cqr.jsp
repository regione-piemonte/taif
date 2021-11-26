#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/domanda/CpDomandaAction" />
<div id="dlgDialogCorsi" class="dialogPanel">
 <h3>Elenco corsi di formazione sostenuti</h3>
 <s:if test="appDataelencoPersonale.[param.row].corsiPresenti">
 	<p>${appDataelencoPersonale[param.row].corsi}</p>
 </s:if>
 <s:else>
 	<p>Nessun corso presente</p>
 </s:else>
 <h3>Elenco qualifiche</h3>
 <s:if test="appDataelencoPersonale.[param.row].qualifichePresenti">
 	<p>${appDataelencoPersonale[param.row].qualifiche}</p>
 </s:if>
 <s:else>
 	<p>Nessuna qualifica presente</p>
 </s:else>
 <h3>Elenco riconoscimenti</h3>
 <s:if test="appDataelencoPersonale.[param.row].riconoscimentiPresenti">
 <p>${appDataelencoPersonale[param.row].riconoscimenti}</p>
 </s:if>
 <s:else>
 	<p>Nessun riconoscimento presente</p>
 </s:else>
</div>
