#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>

<%-- Parametro per la gestione della abilitazione/disabilitazione del widget --%>
<s:set name="CpRiepilogo_udwRiepilogoMessaggio_enabled_local" value="isWidgetDisabled('CpRiepilogo','udwRiepilogoMessaggio')" />

<!--PROTECTED REGION ID(R-40705493) ENABLED START-->
<!-- STATO 1 = BOZZA -->
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==1">
    <!-- BOZZA COMPLETA -->
	<s:if test="appDatadomandaRiepilogo.schedeComplete">
		<div class="msgBoxPanel feedOk">
			<s:text name="CpRiepilogo.messaggioStatoSchedaBozzaCompleta.label" />
		</div>
	</s:if>
	<!-- BOZZA INCOMPLETA -->
	<s:else>
	    <div class="msgBoxPanel warning">
			<s:text name="CpRiepilogo.messaggioStatoSchedaBozzaIncompleta.label" />
		</div>
	</s:else>
</s:if>
<!-- STATO 2 = PRESENTATA -->
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==2">
	<div class="msgBoxPanel domanda-presentata">
	<s:text name="CpRiepilogo.messaggioStatoSchedaInviata.label" />
	<p>&nbsp;</p>
	</div>
</s:if>
<!-- STATO 3 = PRESA IN CARICO -->
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==3">
	<div class="msgBoxPanel info">
	<s:text name="CpRiepilogo.messaggioStatoSchedaPresaInCarico.label" />
	<p>&nbsp;</p>
	</div>
</s:if>
<!-- STATO 4 = ISCRITTA -->
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==4">
	<div class="msgBoxPanel feedOk">
	<s:text name="CpRiepilogo.messaggioStatoSchedaIscritta.label" />
	<p>&nbsp;</p>
	</div>
</s:if>
<!-- STATO 5 = SOSPESA -->
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==5">
	<div class="msgBoxPanel error">
	<s:text name="CpRiepilogo.messaggioStatoSchedaSospesa.label" />
	<p>&nbsp;</p>
	</div>
</s:if>
<!-- STATO 6 = CANCELLATA -->
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==6">
	<div class="msgBoxPanel domanda-cancellata">
	<s:text name="CpRiepilogo.messaggioStatoSchedaCancellata.label" />.
	
	<p>&nbsp;</p>
	</div>
</s:if>
<!-- STATO 7 = NON ACCOLTA -->
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==7">
	<div class="msgBoxPanel domanda-cancellata">
	<s:text name="CpRiepilogo.messaggioStatoSchedaNonAccolta.label" />
	<p>&nbsp;</p>
	</div>
</s:if>
<!-- STATO 8 = ISCRITTA DA CONFERMARE -->
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==8">
    <!-- ISCRITTA DA CONFERMARE COMPLETA -->
	<s:if test="appDatadomandaRiepilogo.schedeComplete">
		<div class="msgBoxPanel info">
			<s:text name="CpRiepilogo.messaggioStatoSchedaIscrittaDaConfermareCompleta.label" />
		</div>
	</s:if>
	<!-- ISCRITTA DA CONFERMARE INCOMPLETA -->
	<s:else>
	    <div class="msgBoxPanel warning">
			<s:text name="CpRiepilogo.messaggioStatoSchedaIscrittaDaConfermareIncompleta.label" />
		</div>
	</s:else>
</s:if>
<!-- STATO 9 = ISCRITTA CONFERMATA -->
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==9">
	<div class="msgBoxPanel feedOk">
	<s:text name="CpRiepilogo.messaggioStatoSchedaConfermata.label" />
	<p>&nbsp;</p>
	</div>
</s:if>
<!-- STATO 10 = SOSPESA PER MANCATA CONFERMA -->
<s:if test="appDatadomandaRiepilogo.idStatoDomanda==10">
    <!-- SOSPESA PER MANCATA CONFERMA COMPLETA -->
	<s:if test="appDatadomandaRiepilogo.schedeComplete">
		<div class="msgBoxPanel info">
			<s:text name="CpRiepilogo.messaggioStatoSchedaSospesaMancataConfermaCompleta.label" />
		</div>
	</s:if>
	<!-- SOSPESA PER MANCATA CONFERMA INCOMPLETA -->
	<s:else>
	    <div class="msgBoxPanel warning">
			<s:text name="CpRiepilogo.messaggioStatoSchedaSospesaMancataConfermaIncompleta.label" />
		</div>
	</s:else>
</s:if>
<!--PROTECTED REGION END-->

