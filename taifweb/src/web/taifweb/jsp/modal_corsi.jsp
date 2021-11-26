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
    <p>${appDataelencoPersonale[param.row].corsi}</p>
 <h3>Elenco qualifiche</h3>
  	 	<p>${appDataelencoPersonale[param.row].qualifiche}</p>
 <h3>Elenco riconoscimenti</h3>
    <p>${appDataelencoPersonale[param.row].riconoscimenti}</p>	 
</div>
