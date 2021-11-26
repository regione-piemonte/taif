#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>

<%-- Parametro per la gestione della abilitazione/disabilitazione del widget --%>
<s:set name="CpRiepilogo_udwRiepilogoStatoDomanda_enabled_local" value="isWidgetDisabled('CpRiepilogo','udwRiepilogoStatoDomanda')" />

<!--PROTECTED REGION ID(R2002323413) ENABLED START-->
<div class="wizardPanelContent">

			
			
		<div class="msgWizard">

			<div class="wizardPanel">
				<ol>
				
				<li class="<s:property value="appDatadomandaRiepilogo.css1" escape="false"/>">
				<span><a href="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomanda_FpWizard1DatiAnagrafici_CLICKED.do"><s:text name="CpDomanda.fpWizard1DatiAnagrafici.label"/></a></span>
				<span class="separator"> | </span>
				</li>
				
				<li class="<s:property value="appDatadomandaRiepilogo.css2" escape="false"/>">
					<span><a href="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomanda_FpWizard2DatiSocioEconomici_CLICKED.do"><s:text name="CpDomanda.fpWizard2DatiSocioEconomici.label"/></a></span>
					<span class="separator"> | </span>
				</li>
						
				<li class="<s:property value="appDatadomandaRiepilogo.css3" escape="false"/>">
					<span><a href="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomanda_FpWizard3Attivita_CLICKED.do"><s:text name="CpDomanda.fpWizard3Attivita.label"/></a></span>
					<span class="separator"> | </span>
				</li>
							
				<li class="<s:property value="appDatadomandaRiepilogo.css4" escape="false"/>">
					<span><a href="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomanda_FpWizard4Strutture_CLICKED.do"><s:text name="CpDomanda.fpWizard4Strutture.label"/></a></span>
					<span class="separator"> | </span>
				</li>
					
				<li class="<s:property value="appDatadomandaRiepilogo.css5" escape="false"/>">
					<span><a href="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomanda_FpWizard5Attrezzature_CLICKED.do"><s:text name="CpDomanda.fpWizard5Attrezzature.label"/></a></span>
					<span class="separator"> | </span>
				</li>
					
				<li class="<s:property value="appDatadomandaRiepilogo.css6" escape="false"/>">
					<span><a href="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomanda_FpWizard6Personale_CLICKED.do"><s:text name="CpDomanda.fpWizard6Personale.label"/></a></span>
					<span class="separator"> | </span>
				</li>
					
				</ol>
			</div><!-- / wizardPanel -->

		</div><!-- / msgWizard -->



	<!-- endFragment:p_mpRiepilogoStatoDomanda --></div>
	
<!--PROTECTED REGION END-->

