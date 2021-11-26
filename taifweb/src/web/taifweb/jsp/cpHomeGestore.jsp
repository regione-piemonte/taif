#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestore -->
<!-- pageId:cpHomeGestore -->

<s:form id="cpHomeGestore" action="cpHomeGestore" namespace="/base/gestore" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpHomeGestoreUserInfo" class="formPanelBlock"><!-- startFragment:p_fpHomeGestoreUserInfo -->

	
	

	
	
			
	
	<div id="p_uipHomeGestore" class="userInfoPanelBlock"><!-- startFragment:p_uipHomeGestore -->
	
	
<div class="userInfoPanel" id="uipHomeGestore">
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

	<!-- endFragment:p_uipHomeGestore --></div>

	

	<!-- endFragment:p_fpHomeGestoreUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpHomeGestoreBody" class="formPanelBlock"><!-- startFragment:p_fpHomeGestoreBody -->

	
	

	
	
			
	
	<div id="p_stdHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdHome -->
	
	
<div class="stdMessagePanel" id="stdHome">
	<customtag:stdMessagePanel id="stdHome" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdHome --></div>

			
	
	<div id="p_wpNuovaAziendaGestore" class="widgetsPanelBlock"><!-- startFragment:p_wpNuovaAziendaGestore -->
	
	

<div class="widgetsPanel" id="wpNuovaAziendaGestore">
	
	<customtag:widgetsPanel id="wpNuovaAziendaGestoreTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpHomeGestore','ptNuovaAziendaGestore')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNuovaAziendaGestore -->
<s:text name="cpHomeGestore.ptNuovaAziendaGestore.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpNuovaAziendaGestore --></div>

			
	
	<div id="p_wpRicercaAziendaGestore" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaAziendaGestore -->
	
	

<div class="widgetsPanel" id="wpRicercaAziendaGestore">
	
	<customtag:widgetsPanel id="wpRicercaAziendaGestoreTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpHomeGestore','ptRicercaAziendaGestore')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptRicercaAziendaGestore -->
<s:text name="cpHomeGestore.ptRicercaAziendaGestore.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAziendaGestore --></div>

	

	<!-- endFragment:p_fpHomeGestoreBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
