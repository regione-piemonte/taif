#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/libero/CpElencoAccessoLiberoAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/libero -->
<!-- pageId:cpElencoAccessoLibero -->

<s:form id="cpElencoAccessoLibero" action="cpElencoAccessoLibero" namespace="/base/libero" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpElencoAziendeAccessoLiberoUserInfo" class="formPanelBlock"><!-- startFragment:p_fpElencoAziendeAccessoLiberoUserInfo -->

	
	

	
	
			
	
	<div id="p_uipElencoAziendeAccessoLibero" class="userInfoPanelBlock"><!-- startFragment:p_uipElencoAziendeAccessoLibero -->
	
	
<div class="userInfoPanel" id="uipElencoAziendeAccessoLibero">
	<div class="userData">
		<span class="user">Utente: <span class="value"><s:property value="appDatacurrentUser.nome" /> <s:property value="appDatacurrentUser.cognome" /></span></span>
		<span class="organization">Ente: <span class="value"><s:property value="appDatacurrentUser.ente" /></span></span>
		<span class="role">Ruolo: <span class="value"><s:property value="appDatacurrentUser.ruolo" /></span></span>
	</div>
	<div class="userInfoActions">
		<!-- uscita dal servizio e/o cambio ruolo -->
		<s:url id="logoutUrl" action="Logout" namespace="/secure" method="confirmLogout" />
		<s:a href="%{logoutUrl}" title="chiudi: questo link fa uscire dal servizio">esci</s:a>
	</div>
</div>

	<!-- endFragment:p_uipElencoAziendeAccessoLibero --></div>

	

	<!-- endFragment:p_fpElencoAziendeAccessoLiberoUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpElencoAziendeAccessoLiberoBody" class="formPanelBlock"><!-- startFragment:p_fpElencoAziendeAccessoLiberoBody -->

	
	

	
	
			
	
	<div id="p_stdHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdHome -->
	
	
<div class="stdMessagePanel" id="stdHome">
	<customtag:stdMessagePanel id="stdHome" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdHome --></div>

			
	
	<div id="p_wpElencoAziendeAccessoLibero" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoAziendeAccessoLibero -->
	
	
<h4 class="wpLabel"><s:text name="cpElencoAccessoLibero.wpElencoAziendeAccessoLibero.label" /> </h4>
<div class="widgetsPanel" id="wpElencoAziendeAccessoLibero">
	

	
	
<s:if test="isWidgetVisible('cpElencoAccessoLibero','tblElencoAziendeAccessoLibero')" >

	
<div class="tableWidget">


<!-- widget tblElencoAziendeAccessoLibero -->
	<csiuicore:ajaxify id="p_wpElencoAziendeAccessoLibero" 
		widgetType="table"		
		pageId="cpElencoAccessoLibero"
		javascriptDetection="false">
<s:set name="cpElencoAccessoLibero_tblElencoAziendeAccessoLibero_clearStatus" value="isTableClearStatus('cpElencoAccessoLibero_tblElencoAziendeAccessoLibero')" />
<s:url id="cpElencoAccessoLiberoViewUrl"						   
					   action="cpElencoAccessoLibero"
					   namespace="/base/libero"/>
<display:table name="appDataelencoRisultatiRicercaAccessoLibero"  				
			   excludedParams="*"			   export="false"
               id="widg_tblElencoAziendeAccessoLibero"
               pagesize="50"
               keepStatus="true"
               requestURI="${cpElencoAccessoLiberoViewUrl}"  
               clearStatus="${cpElencoAccessoLibero_tblElencoAziendeAccessoLibero_clearStatus}"
               uid="row_tblElencoAziendeAccessoLibero"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.libero.CpElencoAccessoLiberoTblElencoAziendeAccessoLiberoCustomDecorator"               class="dataTable">
	
		<display:column  titleKey="cpElencoAccessoLibero.tblElencoAziendeAccessoLibero.dsAlbo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAccessoLibero!handleTblElencoAziendeAccessoLibero_CLICKED"
					namespace="/base/libero"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeAccessoLibero.idAzienda}"/>
				<s:param name="idColonna">dsAlbo</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeAccessoLibero.dsAlbo}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoAccessoLibero.tblElencoAziendeAccessoLibero.numeroAlbo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAccessoLibero!handleTblElencoAziendeAccessoLibero_CLICKED"
					namespace="/base/libero"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeAccessoLibero.idAzienda}"/>
				<s:param name="idColonna">numeroAlbo</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeAccessoLibero.numeroAlbo}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoAccessoLibero.tblElencoAziendeAccessoLibero.codiceFiscale.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAccessoLibero!handleTblElencoAziendeAccessoLibero_CLICKED"
					namespace="/base/libero"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeAccessoLibero.idAzienda}"/>
				<s:param name="idColonna">codiceFiscale</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeAccessoLibero.codiceFiscale}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoAccessoLibero.tblElencoAziendeAccessoLibero.denominazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAccessoLibero!handleTblElencoAziendeAccessoLibero_CLICKED"
					namespace="/base/libero"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeAccessoLibero.idAzienda}"/>
				<s:param name="idColonna">denominazione</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeAccessoLibero.denominazione}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoAccessoLibero.tblElencoAziendeAccessoLibero.titolare.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAccessoLibero!handleTblElencoAziendeAccessoLibero_CLICKED"
					namespace="/base/libero"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeAccessoLibero.idAzienda}"/>
				<s:param name="idColonna">titolare</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeAccessoLibero.titolare}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoAccessoLibero.tblElencoAziendeAccessoLibero.comune.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAccessoLibero!handleTblElencoAziendeAccessoLibero_CLICKED"
					namespace="/base/libero"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeAccessoLibero.idAzienda}"/>
				<s:param name="idColonna">comune</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeAccessoLibero.comune}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoAccessoLibero.tblElencoAziendeAccessoLibero.dsStato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoAccessoLibero!handleTblElencoAziendeAccessoLibero_CLICKED"
					namespace="/base/libero"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoAziendeAccessoLibero.idAzienda}"/>
				<s:param name="idColonna">dsStato</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoAziendeAccessoLibero.dsStato}"/>
			</s:a>
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoAziendeAccessoLibero --></div>

			
	
	<div id="p_cpElencoAziendeAccessoLibero" class="commandPanelBlock"><!-- startFragment:p_cpElencoAziendeAccessoLibero -->
	
	
<div class="commandPanel navigation" id="cpElencoAziendeAccessoLibero">

	
	
		

	
	
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('cpElencoAccessoLibero','btnElencoAziendeAccessoLiberoExport')" >

	



<!-- widget btnElencoAziendeAccessoLiberoExport -->
<s:submit name="widg_btnElencoAziendeAccessoLiberoExport" id="widg_btnElencoAziendeAccessoLiberoExport" method="handleBtnElencoAziendeAccessoLiberoExport_CLICKED"
	key="cpElencoAccessoLibero.btnElencoAziendeAccessoLiberoExport.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoAccessoLibero','btnElencoAziendeAccessoLiberoExport')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoAccessoLibero','btnElencoAziendeAccessoLiberoNuovaRicerca')" >

	



<!-- widget btnElencoAziendeAccessoLiberoNuovaRicerca -->
<s:submit name="widg_btnElencoAziendeAccessoLiberoNuovaRicerca" id="widg_btnElencoAziendeAccessoLiberoNuovaRicerca" method="handleBtnElencoAziendeAccessoLiberoNuovaRicerca_CLICKED"
	key="cpElencoAccessoLibero.btnElencoAziendeAccessoLiberoNuovaRicerca.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('cpElencoAccessoLibero','btnElencoAziendeAccessoLiberoNuovaRicerca')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpElencoAziendeAccessoLibero --></div>

			
	
	
	<div id="p_mpCaptcha" class="panelBlock"><!-- startFragment:p_mpCaptcha -->
		

		
<s:if test="#session.cpElencoAccessoLibero_mpCaptcha_selectedMultiPanel == 'cpElencoAccessoLibero_mpCaptcha_fpCaptcha'">
	<s:include value="/jsp/multipanels/cpElencoAccessoLibero_mpCaptcha_fpCaptcha.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpCaptcha --></div>

	

	<!-- endFragment:p_fpElencoAziendeAccessoLiberoBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
