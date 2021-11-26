#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/home -->
<!-- pageId:cpHome -->

<s:form id="cpHome" action="cpHome" namespace="/base/home" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpHomeUserInfo" class="formPanelBlock"><!-- startFragment:p_fpHomeUserInfo -->

	
	

	
	
			
	
	<div id="p_uipHome" class="userInfoPanelBlock"><!-- startFragment:p_uipHome -->
	
	
<div class="userInfoPanel" id="uipHome">
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

	<!-- endFragment:p_uipHome --></div>

	

	<!-- endFragment:p_fpHomeUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpHomeBody" class="formPanelBlock"><!-- startFragment:p_fpHomeBody -->

	
	

	
	
			
	
	<div id="p_stdHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdHome -->
	
	
<div class="stdMessagePanel" id="stdHome">
	<customtag:stdMessagePanel id="stdHome" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdHome --></div>

			
	
	<div id="p_wpNuovaOperatoreForestaleGestore" class="widgetsPanelBlock"><!-- startFragment:p_wpNuovaOperatoreForestaleGestore -->
	
	

<div class="widgetsPanel" id="wpNuovaOperatoreForestaleGestore">
	
	<customtag:widgetsPanel id="wpNuovaOperatoreForestaleGestoreTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpHome','ptNuovoOperatoreForestaleGestore')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNuovoOperatoreForestaleGestore -->
<s:text name="cpHome.ptNuovoOperatoreForestaleGestore.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpNuovaOperatoreForestaleGestore --></div>

			
	
	<div id="p_wpRicercaOperatoreForestaleGestore" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaOperatoreForestaleGestore -->
	
	

<div class="widgetsPanel" id="wpRicercaOperatoreForestaleGestore">
	
	<customtag:widgetsPanel id="wpRicercaOperatoreForestaleGestoreTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpHome','ptRicercaOperatoreForestaleGestore')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptRicercaOperatoreForestaleGestore -->
<s:text name="cpHome.ptRicercaOperatoreForestaleGestore.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaOperatoreForestaleGestore --></div>

	

	<!-- endFragment:p_fpHomeBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
