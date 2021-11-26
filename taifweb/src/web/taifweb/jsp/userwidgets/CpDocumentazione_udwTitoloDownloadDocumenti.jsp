#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>

<%-- Parametro per la gestione della abilitazione/disabilitazione del widget --%>
<s:set name="CpDocumentazione_udwTitoloDownloadDocumenti_enabled_local" value="isWidgetDisabled('CpDocumentazione','udwTitoloDownloadDocumenti')" />

<!--PROTECTED REGION ID(R10038828) ENABLED START-->
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==1">
<h4 class="wpLabel"><s:text name="CpDocumentazione.titoloIscrizione.label" /></h4>
</s:if>
<s:else>
<h4 class="wpLabel"><s:text name="CpDocumentazione.titoloConferma.label" /></h4>
</s:else>
<!--PROTECTED REGION END-->

