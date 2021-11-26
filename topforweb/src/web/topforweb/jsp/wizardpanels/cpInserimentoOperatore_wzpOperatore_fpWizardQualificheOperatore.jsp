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
	
	
<h4 class="wpLabel"><s:text name="cpInserimentoOperatore.wpInserimentoQualifiche.label" /> <span id="toggle_wpInserimentoQualifiche"></span></h4>
<div class="widgetsPanel" id="wpInserimentoQualifiche">
	
	<customtag:widgetsPanel id="wpInserimentoQualificheTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoQualifica')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoQualifica.label')}" labelFor="widg_cbInserimentoQualifica" errorFor="appDataqualificaSelezionataInserimento.idQualifica" labelId="cbInserimentoQualificaLbl"
	position="first"  >


<!-- widget cbInserimentoQualifica -->
<s:select name="appDataqualificaSelezionataInserimento.idQualifica" id="widg_cbInserimentoQualifica"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoQualificheDenominazioni"
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

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoQualificaAgenziaFormativa.label')}" labelFor="widg_cbInserimentoQualificaAgenziaFormativa" errorFor="appDataqualificaSelezionataInserimento.agenziaFormativa" labelId="cbInserimentoQualificaAgenziaFormativaLbl"
	  >


<!-- widget cbInserimentoQualificaAgenziaFormativa -->
<s:select name="appDataqualificaSelezionataInserimento.agenziaFormativa" id="widg_cbInserimentoQualificaAgenziaFormativa"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoAgenziaFormativaRicercaOperatore"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoQualificaAgenziaFormativa')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoQualifiche_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoQualifiche_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','calDataQualifica')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.calDataQualifica.label')}" labelFor="widg_calDataQualifica" errorFor="appDataqualificaSelezionataInserimento.dataQualifica" labelId="calDataQualificaLbl"
	position="first"  >


<!-- widget calDataQualifica -->
<s:textfield 
	
	
	name="appDataqualificaSelezionataInserimento.dataQualifica" id="widg_calDataQualifica"
	disabled="isWidgetDisabled('cpInserimentoOperatore','calDataQualifica')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
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


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','btAggiungiQualifica')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btAggiungiQualifica -->
<s:submit name="widg_btAggiungiQualifica" id="widg_btAggiungiQualifica" method="handleBtAggiungiQualifica_CLICKED"
	key="cpInserimentoOperatore.btAggiungiQualifica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btAggiungiQualifica')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoQualifiche_3_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpInserimentoQualifiche_3_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoQualifiche_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoQualifiche_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoQualifiche_3_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoQualifiche_3_3_fictitious_ -->


	
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
	
		<display:column  titleKey="cpInserimentoOperatore.tblQualifiche.tipoQualifica.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpInserimentoOperatore!handleTblQualifiche_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblQualifiche.idQualifica}"/>
				<s:param name="idColonna">tipoQualifica</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblQualifiche.tipoQualifica}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpInserimentoOperatore.tblQualifiche.agenziaFormativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpInserimentoOperatore!handleTblQualifiche_CLICKED"
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
					action="cpInserimentoOperatore!handleTblQualifiche_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblQualifiche.idQualifica}"/>
				<s:param name="idColonna">dataQualifica</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblQualifiche.dataQualifica}"/>
			</s:a>
			
		</display:column>
		<display:column property="iconaCancella" titleKey="cpInserimentoOperatore.tblQualifiche.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpInserimentoElencoQualifiche --></div>

	

		
	
</div>

	<!-- endFragment:p_fpWizardQualificheOperatore --></div>
