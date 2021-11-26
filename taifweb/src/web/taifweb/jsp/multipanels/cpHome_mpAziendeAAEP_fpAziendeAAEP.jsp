#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/home/CpHomeAction" />

	
	<div id="p_fpAziendeAAEP" class="formPanelBlock"><!-- startFragment:p_fpAziendeAAEP -->
		
	
<div class="formPanel" id="fpAziendeAAEP">


	
	

	
	
			
	
	<div id="p_wpLabelElencoAziendeAAEP" class="widgetsPanelBlock"><!-- startFragment:p_wpLabelElencoAziendeAAEP -->
	
	

<div class="widgetsPanel" id="wpLabelElencoAziendeAAEP">
	
	<customtag:widgetsPanel id="wpLabelElencoAziendeAAEPTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="0,100">
	

	
	
<s:if test="isWidgetVisible('cpHome','udwLabelAziendeAAEP')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_udwLabelAziendeAAEP" errorFor="widg_udwLabelAziendeAAEP" labelId="udwLabelAziendeAAEPLbl"
	  >


<s:include value="/jsp/userwidgets/cpHome_udwLabelAziendeAAEP.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpLabelElencoAziendeAAEP --></div>

			
	
	<div id="p_wpElencoAziende" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoAziende -->
	
	

<div class="widgetsPanel" id="wpElencoAziende">
	

	
	
<s:if test="isWidgetVisible('cpHome','tElencoAziendeAAEP')" >

	
<div class="tableWidget">


<!-- widget tElencoAziendeAAEP -->
	<csiuicore:ajaxify id="p_wpElencoAziende" 
		widgetType="table"		
		pageId="cpHome"
		javascriptDetection="false">
<s:set name="cpHome_tElencoAziendeAAEP_clearStatus" value="isTableClearStatus('cpHome_tElencoAziendeAAEP')" />
<s:url id="cpHomeViewUrl"						   
					   action="cpHome"
					   namespace="/base/home"/>
<display:table name="appDataelencoAziendeAAEP"  				
			   excludedParams="*"			   export="false"
               id="widg_tElencoAziendeAAEP"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpHomeViewUrl}"  
               clearStatus="${cpHome_tElencoAziendeAAEP_clearStatus}"
               uid="row_tElencoAziendeAAEP"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.home.CpHomeTElencoAziendeAAEPCustomDecorator"               class="dataTable">
	
		<display:column  titleKey="cpHome.tElencoAziendeAAEP.codiceFiscale.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpHome!handleTElencoAziendeAAEP_CLICKED"
					namespace="/base/home"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoAziendeAAEP.codiceFiscale}"/>
				<s:param name="idColonna">codiceFiscale</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoAziendeAAEP.codiceFiscale}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpHome.tElencoAziendeAAEP.ragioneSociale.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpHome!handleTElencoAziendeAAEP_CLICKED"
					namespace="/base/home"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoAziendeAAEP.codiceFiscale}"/>
				<s:param name="idColonna">ragioneSociale</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoAziendeAAEP.ragioneSociale}"/>
			</s:a>
			
		</display:column>
		<display:column property="iconaDettaglio" titleKey="cpHome.tElencoAziendeAAEP.iconaDettaglio.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoAziende --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAziendeAAEP --></div>
