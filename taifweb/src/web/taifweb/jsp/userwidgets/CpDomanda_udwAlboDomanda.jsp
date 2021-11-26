#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>

<%-- Parametro per la gestione della abilitazione/disabilitazione del widget --%>
<s:set name="CpDomanda_udwAlboDomanda_enabled_local" value="isWidgetDisabled('CpDomanda','udwAlboDomanda')" />

<!--PROTECTED REGION ID(R1726428108) ENABLED START-->
<!-- Inserire qui il codice del widget -->
<h4 class="<s:property value="appDataalbo.cssAlbo" escape="false"/>"><s:property value="appDataalbo.dsAlboEstesa" escape="false"/></h4>
<!--PROTECTED REGION END-->

