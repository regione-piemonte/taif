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

	
	<div id="p_fpElencoDomande" class="formPanelBlock"><!-- startFragment:p_fpElencoDomande -->
		
	
<div class="formPanel" id="fpElencoDomande">


	
	

	
	
			
	
	<div id="p_wpLabelElencoDomande" class="widgetsPanelBlock"><!-- startFragment:p_wpLabelElencoDomande -->
	
	

<div class="widgetsPanel" id="wpLabelElencoDomande">
	
	<customtag:widgetsPanel id="wpLabelElencoDomandeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="0,100">
	

	
	
<s:if test="isWidgetVisible('cpHome','udwLabelDomandeInserite')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_udwLabelDomandeInserite" errorFor="widg_udwLabelDomandeInserite" labelId="udwLabelDomandeInseriteLbl"
	  >


<s:include value="/jsp/userwidgets/cpHome_udwLabelDomandeInserite.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpLabelElencoDomande --></div>

			
	
	<div id="p_wpElencoDomande" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoDomande -->
	
	

<div class="widgetsPanel" id="wpElencoDomande">
	

	
	
<s:if test="isWidgetVisible('cpHome','tElencoDomande')" >

	
<div class="tableWidget">


<!-- widget tElencoDomande -->
	<csiuicore:ajaxify id="p_wpElencoDomande" 
		widgetType="table"		
		pageId="cpHome"
		javascriptDetection="false">
<s:set name="cpHome_tElencoDomande_clearStatus" value="isTableClearStatus('cpHome_tElencoDomande')" />
<s:url id="cpHomeViewUrl"						   
					   action="cpHome"
					   namespace="/base/home"/>
<display:table name="appDataelencoDomande"  				
			   excludedParams="*"			   export="false"
               id="widg_tElencoDomande"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpHomeViewUrl}"  
               clearStatus="${cpHome_tElencoDomande_clearStatus}"
               uid="row_tElencoDomande"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.home.CpHomeTElencoDomandeCustomDecorator"               class="dataTable">
	
		<display:column  titleKey="cpHome.tElencoDomande.dsAlbo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpHome!handleTElencoDomande_CLICKED"
					namespace="/base/home"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoDomande.idDomanda}"/>
				<s:param name="idColonna">dsAlbo</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoDomande.dsAlbo}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpHome.tElencoDomande.numeroAlbo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpHome!handleTElencoDomande_CLICKED"
					namespace="/base/home"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoDomande.idDomanda}"/>
				<s:param name="idColonna">numeroAlbo</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoDomande.numeroAlbo}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpHome.tElencoDomande.dsDomanda.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpHome!handleTElencoDomande_CLICKED"
					namespace="/base/home"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoDomande.idDomanda}"/>
				<s:param name="idColonna">dsDomanda</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoDomande.dsDomanda}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpHome.tElencoDomande.data.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpHome!handleTElencoDomande_CLICKED"
					namespace="/base/home"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoDomande.idDomanda}"/>
				<s:param name="idColonna">data</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoDomande.data}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpHome.tElencoDomande.dsStato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpHome!handleTElencoDomande_CLICKED"
					namespace="/base/home"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tElencoDomande.idDomanda}"/>
				<s:param name="idColonna">dsStato</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tElencoDomande.dsStato}"/>
			</s:a>
			
		</display:column>
		<display:column property="iconaCancella" titleKey="cpHome.tElencoDomande.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoDomande --></div>

	

		
	
</div>

	<!-- endFragment:p_fpElencoDomande --></div>
