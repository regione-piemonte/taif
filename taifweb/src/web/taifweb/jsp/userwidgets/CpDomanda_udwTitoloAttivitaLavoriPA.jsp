#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>

<%-- Parametro per la gestione della abilitazione/disabilitazione del widget --%>
<s:set name="CpDomanda_udwTitoloAttivitaLavoriPA_enabled_local" value="isWidgetDisabled('CpDomanda','udwTitoloAttivitaLavoriPA')" />

<!--PROTECTED REGION ID(R-1931863527) ENABLED START-->
<!-- Inserire qui il codice del widget -->
<h4 class="wpLabel"><s:text name="CpDomanda.wpAttivitaLavoriPA.label" /></h4>
<!--PROTECTED REGION END-->

