#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>

<%-- Parametro per la gestione della abilitazione/disabilitazione del widget --%>
<s:set name="cpInserimentoOperatore_udwConsensoPrivacy_enabled_local" value="isWidgetDisabled('cpInserimentoOperatore','udwConsensoPrivacy')" />

<!--PROTECTED REGION ID(R-1239541666) ENABLED START-->

<s:if test ="appDataurlPrivacy!=\"\"">
		<s:if test ="appDatatracciato==\"I\"">
			ll/La sottoscritto/a dichiara di avere preso visione <a target="_blank" href="<s:property value="appDataurlPrivacy" escape="false"/>">
			dell'informativa sulla privacy</a> ai sensi del GDPR 2016/679.
		</s:if>
		<s:else>
			Le soussign&eacute; d&eacute;clare avoir pris connaissance <a target="_blank" href="<s:property value="appDataurlPrivacy" escape="false"/>">
			du traitement des donn&eacute;es personnelles</a> conforme au GDPR 2016/679.
		</s:else>
</s:if>
<s:else>
		<s:if test ="appDatatracciato==\"I\"">
			ll/La sottoscritto/a dichiara di avere preso visione <a target="_blank" href="http://www.sistemapiemonte.it/ris/montagna/albo_imp_forestali/TAIF_RP_informativa_gdpr.pdf">
			dell'informativa sulla privacy</a> ai sensi del GDPR 2016/679.
		</s:if>
		<s:else>
			Le soussign&eacute; d&eacute;clare avoir pris connaissance <a target="_blank" href="http://www.sistemapiemonte.it/ris/montagna/albo_imp_forestali/informativa_dgpr.pdf">
			du traitement des donn&eacute;es personnelles</a> conforme au GDPR 2016/679.
		</s:else>
</s:else>
<!--PROTECTED REGION END-->

