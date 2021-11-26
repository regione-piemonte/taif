#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>

<%-- Parametro per la gestione della abilitazione/disabilitazione del widget --%>
<s:set name="cpHome_udwLabelDomandeInserite_enabled_local" value="isWidgetDisabled('cpHome','udwLabelDomandeInserite')" />

<!--PROTECTED REGION ID(R-310438544) ENABLED START-->
<!-- Inserire qui il codice del widget -->
<h5><s:text name="cpHome.udwLabelDomandeInserite.label" /></h5>
<!--PROTECTED REGION END-->

