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

	
	<div id="p_fpWizardQualificheOperatore" class="formPanelBlock"><!-- startFragment:p_fpWizardQualificheOperatore -->
		
	
<div class="formPanel" id="fpWizardQualificheOperatore">


	
	

	
	
			
	
	<div id="p_smpOperatore1.4" class="stdMessagePanelBlock"><!-- startFragment:p_smpOperatore1.4 -->
	
	
<div class="stdMessagePanel" id="smpOperatore1.4">
	<customtag:stdMessagePanel id="smpOperatore1.4" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpOperatore1.4 --></div>

			
	
	<div id="p_wpInserimentoQualifiche" class="widgetsPanelBlock"><!-- startFragment:p_wpInserimentoQualifiche -->
	
	
<h4 class="wpLabel">Qualifiche <span id="toggle_wpInserimentoQualifiche"></span></h4>
<div class="widgetsPanel" id="wpInserimentoQualifiche">
	
	<customtag:widgetsPanel id="wpInserimentoQualificheTbl" columns="10" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoQualifica')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoQualifica.label')}" labelFor="widg_cbInserimentoQualifica" errorFor="appDataidQualificaSelezionato" labelId="cbInserimentoQualificaLbl"
	position="first"  >


<!-- widget cbInserimentoQualifica -->
<s:select name="appDataidQualificaSelezionato" id="widg_cbInserimentoQualifica"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoQualificheInserimento"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoQualifica')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoQualificaAgenziaFormativa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoQualificaAgenziaFormativa.label')}" labelFor="widg_cbInserimentoQualificaAgenziaFormativa" errorFor="appDataidQualificaAgenziaFormativaSelezionato" labelId="cbInserimentoQualificaAgenziaFormativaLbl"
	  >


<!-- widget cbInserimentoQualificaAgenziaFormativa -->
<s:select name="appDataidQualificaAgenziaFormativaSelezionato" id="widg_cbInserimentoQualificaAgenziaFormativa"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoQualificheAgenziaFormativaInserimento"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoQualificaAgenziaFormativa')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tfDataQualifica')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tfDataQualifica.label')}" labelFor="widg_tfDataQualifica" errorFor="widg_tfDataQualifica" labelId="tfDataQualificaLbl"
	  >


<!-- widget tfDataQualifica -->
<s:textfield 
	
	
	name="widg_tfDataQualifica" id="widg_tfDataQualifica"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tfDataQualifica')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','updFileAttestatoQualifiche')" >

	
<customtag:widgetsPanelColumn  tooltip="Selezionare il file da caricare" labelField="true" textLabel="%{getText('cpInserimentoOperatore.updFileAttestatoQualifiche.label')}" labelFor="widg_updFileAttestatoQualifiche" errorFor="widg_updFileAttestatoQualifiche" labelId="updFileAttestatoQualificheLbl"
	  >


<s:file 
	
title="Selezionare il file da caricare"	
	name="widg_updFileAttestatoQualifiche" id="widg_updFileAttestatoQualifiche"
	disabled="isWidgetDisabled('cpInserimentoOperatore','updFileAttestatoQualifiche')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoQualifiche_1_5_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoQualifiche_1_5_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoQualifiche_2_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpInserimentoQualifiche_2_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoQualifiche_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoQualifiche_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoQualifiche_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoQualifiche_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoQualifiche_2_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoQualifiche_2_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','btLoadAttestatoQualificheButton')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btLoadAttestatoQualificheButton -->
<s:submit name="widg_btLoadAttestatoQualificheButton" id="widg_btLoadAttestatoQualificheButton" method="execute"
	key="cpInserimentoOperatore.btLoadAttestatoQualificheButton.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btLoadAttestatoQualificheButton')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInserimentoQualifiche --></div>

			
	
	<div id="p_wpInserimentoElencoQualifiche" class="widgetsPanelBlock"><!-- startFragment:p_wpInserimentoElencoQualifiche -->
	
	

<div class="widgetsPanel" id="wpInserimentoElencoQualifiche">
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tblQualifiche')" >

	
<div class="tableWidget">


<!-- widget tblQualifiche -->
	<csiuicore:ajaxify id="p_wpInserimentoElencoQualifiche" 
		widgetType="table"		
		pageId="cpInserimentoOperatore"
		javascriptDetection="false">
<s:set name="cpInserimentoOperatore_tblQualifiche_clearStatus" value="isTableClearStatus('cpInserimentoOperatore_tblQualifiche')" />
<s:url id="cpInserimentoOperatoreViewUrl"						   
					   action="cpInserimentoOperatore"
					   namespace="/base/gestore"/>
<display:table name="appDataelencoQualifiche"  				
			   excludedParams="*"			   export="false"
               id="widg_tblQualifiche"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpInserimentoOperatoreViewUrl}"  
               clearStatus="${cpInserimentoOperatore_tblQualifiche_clearStatus}"
               uid="row_tblQualifiche"
               summary="" 
decorator="it.csi.taif.topforweb.presentation.decorator.gestore.CpInserimentoOperatoreTblQualificheCustomDecorator"               class="dataTable">
	
		<display:column  titleKey="cpInserimentoOperatore.tblQualifiche.agenziaFormativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpInserimentoOperatore!handleTblQualifiche_null"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblQualifiche.idQualifica}"/>
				<s:param name="idColonna">agenziaFormativa</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblQualifiche.agenziaFormativa}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpInserimentoOperatore.tblQualifiche.dataQualifica.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpInserimentoOperatore!handleTblQualifiche_null"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblQualifiche.idQualifica}"/>
				<s:param name="idColonna">dataQualifica</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblQualifiche.dataQualifica}"/>
			</s:a>
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpInserimentoElencoQualifiche --></div>

	

		
	
</div>

	<!-- endFragment:p_fpWizardQualificheOperatore --></div>
