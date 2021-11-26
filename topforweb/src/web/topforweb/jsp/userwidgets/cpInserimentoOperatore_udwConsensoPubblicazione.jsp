#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>

<%-- Parametro per la gestione della abilitazione/disabilitazione del widget --%>
<s:set name="cpInserimentoOperatore_udwConsensoPubblicazione_enabled_local" value="isWidgetDisabled('cpInserimentoOperatore','udwConsensoPubblicazione')" />

<!--PROTECTED REGION ID(R128613389) ENABLED START-->
<!-- Inserire qui il codice del widget -->
	<s:if test ="appDatatracciato==\"I\"">
		(1) ll/La sottoscritto/a dichiara di avere preso visione del <a target="_blank" href="http://www.sistemapiemonte.it/ris/montagna/albo_imp_forestali/ConsensoPubblicabilitaElencoOp.pdf">
		Consenso informato alla pubblicazione dei dati personali</a>.
	</s:if>
	<s:else>
		(1) Le soussign&eacute; d&eacute;clare avoir pris connaissance de<a target="_blank" href="http://www.sistemapiemonte.it/ris/montagna/albo_imp_forestali/ConsensoPubblicabilitaElencoOp.pdf">
		Consentement &eacute;clair&eacute; &agrave; la publication de donn&eacute;es personnelles</a>.
	</s:else>
<!--PROTECTED REGION END-->

