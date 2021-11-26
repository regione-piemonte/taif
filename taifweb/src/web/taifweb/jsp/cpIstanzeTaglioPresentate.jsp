#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/domanda/CpIstanzeTaglioPresentateAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/domanda -->
<!-- pageId:cpIstanzeTaglioPresentate -->

<s:form id="cpIstanzeTaglioPresentate" action="cpIstanzeTaglioPresentate" namespace="/base/domanda" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpIstanzeTaglioPresentateUserInfo" class="formPanelBlock"><!-- startFragment:p_fpIstanzeTaglioPresentateUserInfo -->

	
	

	
	
			
	
	<div id="p_uipIstanzeTaglioPresentate" class="userInfoPanelBlock"><!-- startFragment:p_uipIstanzeTaglioPresentate -->
	
	
<div class="userInfoPanel" id="uipIstanzeTaglioPresentate">
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

	<!-- endFragment:p_uipIstanzeTaglioPresentate --></div>

	

	<!-- endFragment:p_fpIstanzeTaglioPresentateUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpIstanzeTaglioPresentateBody" class="formPanelBlock"><!-- startFragment:p_fpIstanzeTaglioPresentateBody -->

	
	

	
	
			
	
	<div id="p_stdIstanzeTaglioPresentate" class="stdMessagePanelBlock"><!-- startFragment:p_stdIstanzeTaglioPresentate -->
	
	
<div class="stdMessagePanel" id="stdIstanzeTaglioPresentate">
	<customtag:stdMessagePanel id="stdIstanzeTaglioPresentate" errorMessage="false" errorDetails="false" actionMessage="false" />
</div>

	<!-- endFragment:p_stdIstanzeTaglioPresentate --></div>

			
	
	<div id="p_wpIstanzeTaglioPresentate" class="widgetsPanelBlock"><!-- startFragment:p_wpIstanzeTaglioPresentate -->
	
	
<h4 class="wpLabel"><s:text name="cpIstanzeTaglioPresentate.wpIstanzeTaglioPresentate.label" /> </h4>
<div class="widgetsPanel" id="wpIstanzeTaglioPresentate">
	

	
	
<s:if test="isWidgetVisible('cpIstanzeTaglioPresentate','tblElencoIstanzeTaglioPresentate')" >

	
<div class="tableWidget">


<!-- widget tblElencoIstanzeTaglioPresentate -->
	<csiuicore:ajaxify id="p_wpIstanzeTaglioPresentate" 
		widgetType="table"		
		pageId="cpIstanzeTaglioPresentate"
		javascriptDetection="false">
<s:set name="cpIstanzeTaglioPresentate_tblElencoIstanzeTaglioPresentate_clearStatus" value="isTableClearStatus('cpIstanzeTaglioPresentate_tblElencoIstanzeTaglioPresentate')" />
<s:url id="cpIstanzeTaglioPresentateViewUrl"						   
					   action="cpIstanzeTaglioPresentate"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoIstanzeTaglioPresentate"  				
			   excludedParams="*"			   export="false"
               id="widg_tblElencoIstanzeTaglioPresentate"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpIstanzeTaglioPresentateViewUrl}"  
               clearStatus="${cpIstanzeTaglioPresentate_tblElencoIstanzeTaglioPresentate_clearStatus}"
               uid="row_tblElencoIstanzeTaglioPresentate"
               summary="" 
               class="dataTable">
	
		<display:column property="numIstanza" titleKey="cpIstanzeTaglioPresentate.tblElencoIstanzeTaglioPresentate.numIstanza.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="anno" titleKey="cpIstanzeTaglioPresentate.tblElencoIstanzeTaglioPresentate.anno.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataPresentazioneIstanza" titleKey="cpIstanzeTaglioPresentate.tblElencoIstanzeTaglioPresentate.dataPresentazioneIstanza.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataAutorizzazioneIstanza" titleKey="cpIstanzeTaglioPresentate.tblElencoIstanzeTaglioPresentate.dataAutorizzazioneIstanza.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descIntervento" titleKey="cpIstanzeTaglioPresentate.tblElencoIstanzeTaglioPresentate.descIntervento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="stimaMassaRetraibile" titleKey="cpIstanzeTaglioPresentate.tblElencoIstanzeTaglioPresentate.stimaMassaRetraibile.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="unita" titleKey="cpIstanzeTaglioPresentate.tblElencoIstanzeTaglioPresentate.unita.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipoComunicazione" titleKey="cpIstanzeTaglioPresentate.tblElencoIstanzeTaglioPresentate.tipoComunicazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="stato" titleKey="cpIstanzeTaglioPresentate.tblElencoIstanzeTaglioPresentate.stato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="governo" titleKey="cpIstanzeTaglioPresentate.tblElencoIstanzeTaglioPresentate.governo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipoIntervento" titleKey="cpIstanzeTaglioPresentate.tblElencoIstanzeTaglioPresentate.tipoIntervento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dsCategoriaIntervento" titleKey="cpIstanzeTaglioPresentate.tblElencoIstanzeTaglioPresentate.dsCategoriaIntervento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpIstanzeTaglioPresentate --></div>

			
	
	<div id="p_cpInstanzeTaglioPresentate" class="commandPanelBlock"><!-- startFragment:p_cpInstanzeTaglioPresentate -->
	
	
<div class="commandPanel functional" id="cpInstanzeTaglioPresentate">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpIstanzeTaglioPresentate','btIndietroAcquisisciVolumi')" >

	



<!-- widget btIndietroAcquisisciVolumi -->
<s:submit name="widg_btIndietroAcquisisciVolumi" id="widg_btIndietroAcquisisciVolumi" method="handleBtIndietroAcquisisciVolumi_CLICKED"
	key="cpIstanzeTaglioPresentate.btIndietroAcquisisciVolumi.label" cssClass="buttonWidget back"
	disabled="isWidgetDisabled('cpIstanzeTaglioPresentate','btIndietroAcquisisciVolumi')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('cpIstanzeTaglioPresentate','btAcquisisciVolumi')" >

	



<!-- widget btAcquisisciVolumi -->
<s:submit name="widg_btAcquisisciVolumi" id="widg_btAcquisisciVolumi" method="handleBtAcquisisciVolumi_CLICKED"
	key="cpIstanzeTaglioPresentate.btAcquisisciVolumi.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpIstanzeTaglioPresentate','btAcquisisciVolumi')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpInstanzeTaglioPresentate --></div>

	

	<!-- endFragment:p_fpIstanzeTaglioPresentateBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
