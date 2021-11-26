#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>

<%-- Parametro per la gestione della abilitazione/disabilitazione del widget --%>
<s:set name="CpDomanda_udwConsensoPrivacy_enabled_local" value="isWidgetDisabled('CpDomanda','udwConsensoPrivacy')" />

<!--PROTECTED REGION ID(R1715005994) ENABLED START-->

<s:if test ="appDatatracciato==\"I\"">
ll/La sottoscritto/a dichiara di avere preso visione <a href="<s:property value="appDataalbo.urlPrivacy" escape="false"/>">
dell'informativa sulla privacy</a> ai sensi del GDPR 2016/679.
</s:if>
<s:else>
Le soussign&eacute; d&eacute;clare avoir pris connaissance <a href="<s:property value="appDataalbo.urlPrivacy" escape="false"/>">
du traitement des donn&eacute;es personnelles</a> conforme au GDPR 2016/679.
</s:else>
 
<!--PROTECTED REGION END-->

