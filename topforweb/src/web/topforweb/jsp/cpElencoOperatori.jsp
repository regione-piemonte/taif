#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/topforweb/presentation/topforweb/action/gestore/CpElencoOperatoriAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestore -->
<!-- pageId:cpElencoOperatori -->

<s:form id="cpElencoOperatori" action="cpElencoOperatori" namespace="/base/gestore" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpElencoOperatoriUserInfo" class="formPanelBlock"><!-- startFragment:p_fpElencoOperatoriUserInfo -->

	
	

	
	
			
	
	<div id="p_uipElencoOperatore" class="userInfoPanelBlock"><!-- startFragment:p_uipElencoOperatore -->
	
	
<div class="userInfoPanel" id="uipElencoOperatore">
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

	<!-- endFragment:p_uipElencoOperatore --></div>

	

	<!-- endFragment:p_fpElencoOperatoriUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpElencoOperatoriBody" class="formPanelBlock"><!-- startFragment:p_fpElencoOperatoriBody -->

	
	

	
	
			
	
	<div id="p_stdHomeOperatore" class="stdMessagePanelBlock"><!-- startFragment:p_stdHomeOperatore -->
	
	
<div class="stdMessagePanel" id="stdHomeOperatore">
	<customtag:stdMessagePanel id="stdHomeOperatore" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdHomeOperatore --></div>

			
	
	<div id="p_wpElencoOperatore" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoOperatore -->
	
	
<h4 class="wpLabel"><s:text name="cpElencoOperatori.wpElencoOperatore.label" /> </h4>
<div class="widgetsPanel" id="wpElencoOperatore">
	

	
	
<s:if test="isWidgetVisible('cpElencoOperatori','tblElencoOperatori')" >

	
<div class="tableWidget">


<!-- widget tblElencoOperatori -->
	<csiuicore:ajaxify id="p_wpElencoOperatore" 
		widgetType="table"		
		pageId="cpElencoOperatori"
		javascriptDetection="false">
<s:set name="cpElencoOperatori_tblElencoOperatori_clearStatus" value="isTableClearStatus('cpElencoOperatori_tblElencoOperatori')" />
<s:url id="cpElencoOperatoriViewUrl"						   
					   action="cpElencoOperatori"
					   namespace="/base/gestore"/>
<display:table name="appDataelencoRisultatiRicercaOperatoreGestore"  				
			   excludedParams="*"			   export="false"
               id="widg_tblElencoOperatori"
               pagesize="50"
               keepStatus="true"
               requestURI="${cpElencoOperatoriViewUrl}"  
               clearStatus="${cpElencoOperatori_tblElencoOperatori_clearStatus}"
               uid="row_tblElencoOperatori"
               summary="" 
decorator="it.csi.taif.topforweb.presentation.decorator.gestore.CpElencoOperatoriTblElencoOperatoriCustomDecorator"               class="dataTable">
	
		<display:column  titleKey="cpElencoOperatori.tblElencoOperatori.dsElencoAmministrazioneCompetenza.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoOperatori!handleTblElencoOperatori_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoOperatori.idPersonaOperatore}"/>
				<s:param name="idColonna">dsElencoAmministrazioneCompetenza</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoOperatori.dsElencoAmministrazioneCompetenza}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoOperatori.tblElencoOperatori.cognomeNomeOperatore.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoOperatori!handleTblElencoOperatori_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoOperatori.idPersonaOperatore}"/>
				<s:param name="idColonna">cognomeNomeOperatore</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoOperatori.cognomeNomeOperatore}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpElencoOperatori.tblElencoOperatori.corsiSostenutiOperatore.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpElencoOperatori!handleTblElencoOperatori_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblElencoOperatori.idPersonaOperatore}"/>
				<s:param name="idColonna">corsiSostenutiOperatore</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblElencoOperatori.corsiSostenutiOperatore}"/>
			</s:a>
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoOperatore --></div>

			
	
	<div id="p_cpElencoOperatore" class="commandPanelBlock"><!-- startFragment:p_cpElencoOperatore -->
	
	
<div class="commandPanel functional" id="cpElencoOperatore">

	
	
		

	
	
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('cpElencoOperatori','btnElencoOperatoreIndietro')" >

	



<!-- widget btnElencoOperatoreIndietro -->
<s:submit name="widg_btnElencoOperatoreIndietro" id="widg_btnElencoOperatoreIndietro" method="handleBtnElencoOperatoreIndietro_CLICKED"
	key="cpElencoOperatori.btnElencoOperatoreIndietro.label" cssClass="buttonWidget back"
	disabled="isWidgetDisabled('cpElencoOperatori','btnElencoOperatoreIndietro')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoOperatori','btnElencoOperatoreExport')" >

	



<!-- widget btnElencoOperatoreExport -->
<s:submit name="widg_btnElencoOperatoreExport" id="widg_btnElencoOperatoreExport" method="handleBtnElencoOperatoreExport_CLICKED"
	key="cpElencoOperatori.btnElencoOperatoreExport.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoOperatori','btnElencoOperatoreExport')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoOperatori','btnElencoOperatoreNuovaRicerca')" >

	



<!-- widget btnElencoOperatoreNuovaRicerca -->
<s:submit name="widg_btnElencoOperatoreNuovaRicerca" id="widg_btnElencoOperatoreNuovaRicerca" method="handleBtnElencoOperatoreNuovaRicerca_CLICKED"
	key="cpElencoOperatori.btnElencoOperatoreNuovaRicerca.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('cpElencoOperatori','btnElencoOperatoreNuovaRicerca')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpElencoOperatore --></div>

			
	
	
	<div id="p_mpCaptcha" class="panelBlock"><!-- startFragment:p_mpCaptcha -->
		

		
<s:if test="#session.cpElencoOperatori_mpCaptcha_selectedMultiPanel == 'cpElencoOperatori_mpCaptcha_fpCaptcha'">
	<s:include value="/jsp/multipanels/cpElencoOperatori_mpCaptcha_fpCaptcha.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpCaptcha --></div>

	

	<!-- endFragment:p_fpElencoOperatoriBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
