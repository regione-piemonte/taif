#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>

<%-- Parametro per la gestione della abilitazione/disabilitazione del widget --%>
<s:set name="CpRiepilogo_udwRiepilogoMessaggioBozzaIncompleta_enabled_local" value="isWidgetDisabled('CpRiepilogo','udwRiepilogoMessaggioBozzaIncompleta')" />

<!--PROTECTED REGION ID(R-1448559485) ENABLED START-->
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==1">
	<s:if test="appDatadomandaRiepilogo.schedeComplete">
		<div class="msgBoxPanel feedOk">
			<s:text name="CpRiepilogo.messaggioStatoSchedaBozzaCompleta.label" />
		</div>
	</s:if>
	<s:else>
	    <div class="msgBoxPanel warning">
			<s:text name="CpRiepilogo.messaggioStatoSchedaBozzaIncompleta.label" />
		</div>
	</s:else>
</s:if>
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==2">
	<div class="msgBoxPanel domanda-presentata">
	<s:text name="CpRiepilogo.messaggioStatoSchedaInviata.label" />
	<p>&nbsp;</p>
	</div>
</s:if>
<!--PROTECTED REGION END-->

