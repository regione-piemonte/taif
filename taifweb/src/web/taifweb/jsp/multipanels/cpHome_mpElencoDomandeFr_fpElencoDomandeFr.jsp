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

	
	<div id="p_fpElencoDomandeFr" class="formPanelBlock"><!-- startFragment:p_fpElencoDomandeFr -->
		
	
<div class="formPanel" id="fpElencoDomandeFr">


	
	

	
	
			
	
	<div id="p_wpLabelElencoDomandeFr" class="widgetsPanelBlock"><!-- startFragment:p_wpLabelElencoDomandeFr -->
	
	

<div class="widgetsPanel" id="wpLabelElencoDomandeFr">
	
	<customtag:widgetsPanel id="wpLabelElencoDomandeFrTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpHome','udwLabelDomandeInseriteFr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpHome.udwLabelDomandeInseriteFr.label')}" labelFor="widg_udwLabelDomandeInseriteFr" errorFor="widg_udwLabelDomandeInseriteFr" labelId="udwLabelDomandeInseriteFrLbl"
	  >


<s:include value="/jsp/userwidgets/cpHome_udwLabelDomandeInseriteFr.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpLabelElencoDomandeFr --></div>

			
	
	<div id="p_wpElencoDomandeFr" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoDomandeFr -->
	
	

<div class="widgetsPanel" id="wpElencoDomandeFr">
	

	
	
<s:if test="isWidgetVisible('cpHome','tElencoDomandeFr')" >

	
<div class="tableWidget">


<!-- widget tElencoDomandeFr -->
	<csiuicore:ajaxify id="p_wpElencoDomandeFr" 
		widgetType="table"		
		pageId="cpHome"
		javascriptDetection="false">
<s:set name="cpHome_tElencoDomandeFr_clearStatus" value="isTableClearStatus('cpHome_tElencoDomandeFr')" />
<s:url id="cpHomeViewUrl"						   
					   action="cpHome"
					   namespace="/base/home"/>
<display:table name="appDataelencoDomande"  				
			   excludedParams="*"			   export="false"
               id="widg_tElencoDomandeFr"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpHomeViewUrl}"  
               clearStatus="${cpHome_tElencoDomandeFr_clearStatus}"
               uid="row_tElencoDomandeFr"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.home.CpHomeTElencoDomandeFrCustomDecorator"               class="dataTable">
	
		<display:column  titleKey="cpHome.tElencoDomandeFr.dsAlbo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpHome!handleTElencoDomandeFr_CLICKED"
					namespace="/base/home"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoDomandeFr.idDomanda}"/>
				<s:param name="idColonna">dsAlbo</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoDomandeFr.dsAlbo}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpHome.tElencoDomandeFr.numeroAlbo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpHome!handleTElencoDomandeFr_CLICKED"
					namespace="/base/home"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoDomandeFr.idDomanda}"/>
				<s:param name="idColonna">numeroAlbo</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoDomandeFr.numeroAlbo}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpHome.tElencoDomandeFr.dsDomanda.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpHome!handleTElencoDomandeFr_CLICKED"
					namespace="/base/home"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoDomandeFr.idDomanda}"/>
				<s:param name="idColonna">dsDomanda</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoDomandeFr.dsDomanda}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpHome.tElencoDomandeFr.data.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpHome!handleTElencoDomandeFr_CLICKED"
					namespace="/base/home"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoDomandeFr.idDomanda}"/>
				<s:param name="idColonna">data</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoDomandeFr.data}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpHome.tElencoDomandeFr.dsStatoFr.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpHome!handleTElencoDomandeFr_CLICKED"
					namespace="/base/home"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoDomandeFr.idDomanda}"/>
				<s:param name="idColonna">dsStatoFr</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoDomandeFr.dsStatoFr}"/>
			</s:a>
			
		</display:column>
		<display:column property="iconaCancella" titleKey="cpHome.tElencoDomandeFr.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoDomandeFr --></div>

	

		
	
</div>

	<!-- endFragment:p_fpElencoDomandeFr --></div>
