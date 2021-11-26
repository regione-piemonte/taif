#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/topforweb/presentation/topforweb/action/gestore/CpInserimentoOperatoreAction" />

	
	<div id="p_fpWizardAltriCorsiOperatore" class="formPanelBlock"><!-- startFragment:p_fpWizardAltriCorsiOperatore -->
		
	
<div class="formPanel" id="fpWizardAltriCorsiOperatore">


	
	

	
	
			
	
	<div id="p_smpOperatore1.3" class="stdMessagePanelBlock"><!-- startFragment:p_smpOperatore1.3 -->
	
	
<div class="stdMessagePanel" id="smpOperatore1.3">
	<customtag:stdMessagePanel id="smpOperatore1.3" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpOperatore1.3 --></div>

			
	
	<div id="p_wpInserimentoAltriCorsi" class="widgetsPanelBlock"><!-- startFragment:p_wpInserimentoAltriCorsi -->
	
	
<h4 class="wpLabel">Altri corsi, studi o altro da segnalare <span id="toggle_wpInserimentoAltriCorsi"></span></h4>
<div class="widgetsPanel" id="wpInserimentoAltriCorsi">
	
	<customtag:widgetsPanel id="wpInserimentoAltriCorsiTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tfDescrizioniAltriCorsi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tfDescrizioniAltriCorsi.label')}" labelFor="widg_tfDescrizioniAltriCorsi" errorFor="widg_tfDescrizioniAltriCorsi" labelId="tfDescrizioniAltriCorsiLbl"
	position="first"  >


<!-- widget tfDescrizioniAltriCorsi -->
<s:textfield 
	
	
	name="widg_tfDescrizioniAltriCorsi" id="widg_tfDescrizioniAltriCorsi"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tfDescrizioniAltriCorsi')"
	size="99%" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoAttestatoConScadenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoAttestatoConScadenza.label')}" labelFor="widg_cbInserimentoAttestatoConScadenza" errorFor="appDataidAttestatoConScadenzaSelezionato" labelId="cbInserimentoAttestatoConScadenzaLbl"
	  >


<!-- widget cbInserimentoAttestatoConScadenza -->
<s:select name="appDataidAttestatoConScadenzaSelezionato" id="widg_cbInserimentoAttestatoConScadenza"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoAttestatoConScadenzaInserimento"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoAttestatoConScadenza')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','updFileAttestatoAltriCorsi')" >

	
<customtag:widgetsPanelColumn  tooltip="Selezionare il file da caricare" labelField="true" textLabel="%{getText('cpInserimentoOperatore.updFileAttestatoAltriCorsi.label')}" labelFor="widg_updFileAttestatoAltriCorsi" errorFor="widg_updFileAttestatoAltriCorsi" labelId="updFileAttestatoAltriCorsiLbl"
	  >


<s:file 
	
title="Selezionare il file da caricare"	
	name="widg_updFileAttestatoAltriCorsi" id="widg_updFileAttestatoAltriCorsi"
	disabled="isWidgetDisabled('cpInserimentoOperatore','updFileAttestatoAltriCorsi')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_1_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoAltriCorsi_1_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_2_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpInserimentoAltriCorsi_2_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoAltriCorsi_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoAltriCorsi_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','btLoadAttestatoAltriCorsiButton')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btLoadAttestatoAltriCorsiButton -->
<s:submit name="widg_btLoadAttestatoAltriCorsiButton" id="widg_btLoadAttestatoAltriCorsiButton" method="execute"
	key="cpInserimentoOperatore.btLoadAttestatoAltriCorsiButton.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btLoadAttestatoAltriCorsiButton')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInserimentoAltriCorsi --></div>

			
	
	<div id="p_wpInserimentoElencoAltriCorsi" class="widgetsPanelBlock"><!-- startFragment:p_wpInserimentoElencoAltriCorsi -->
	
	

<div class="widgetsPanel" id="wpInserimentoElencoAltriCorsi">
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tblInserimentoAltriCorsi')" >

	
<div class="tableWidget">


<!-- widget tblInserimentoAltriCorsi -->
	<csiuicore:ajaxify id="p_wpInserimentoElencoAltriCorsi" 
		widgetType="table"		
		pageId="cpInserimentoOperatore"
		javascriptDetection="false">
<s:set name="cpInserimentoOperatore_tblInserimentoAltriCorsi_clearStatus" value="isTableClearStatus('cpInserimentoOperatore_tblInserimentoAltriCorsi')" />
<s:url id="cpInserimentoOperatoreViewUrl"						   
					   action="cpInserimentoOperatore"
					   namespace="/base/gestore"/>
<display:table name="appDataelencoAltriCorsi"  				
			   excludedParams="*"			   export="false"
               id="widg_tblInserimentoAltriCorsi"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpInserimentoOperatoreViewUrl}"  
               clearStatus="${cpInserimentoOperatore_tblInserimentoAltriCorsi_clearStatus}"
               uid="row_tblInserimentoAltriCorsi"
               summary="" 
decorator="it.csi.taif.topforweb.presentation.decorator.gestore.CpInserimentoOperatoreTblInserimentoAltriCorsiCustomDecorator"               class="dataTable">
	
		<display:column property="descrizioneAltroCorso" titleKey="cpInserimentoOperatore.tblInserimentoAltriCorsi.descrizioneAltroCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="attestatoConScadenza" titleKey="cpInserimentoOperatore.tblInserimentoAltriCorsi.attestatoConScadenza.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaAttestato" titleKey="cpInserimentoOperatore.tblInserimentoAltriCorsi.iconaAttestato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpInserimentoElencoAltriCorsi --></div>

	

		
	
</div>

	<!-- endFragment:p_fpWizardAltriCorsiOperatore --></div>
