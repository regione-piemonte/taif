#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/home/CpHomeAction" />


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

	
	

	
	
			
	
	<div id="p_wpNuovaAzienda" class="widgetsPanelBlock"><!-- startFragment:p_wpNuovaAzienda -->
	
	

<div class="widgetsPanel" id="wpNuovaAzienda">
	
	<customtag:widgetsPanel id="wpNuovaAziendaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpHome','udwNuovaAzienda')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >


<s:include value="/jsp/userwidgets/cpHome_udwNuovaAzienda.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpHome','ptNuovaAzienda')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNuovaAzienda -->
<s:text name="cpHome.ptNuovaAzienda.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpNuovaAzienda --></div>

			
	
	
	<div id="p_mpAziendeAAEP" class="panelBlock"><!-- startFragment:p_mpAziendeAAEP -->
		

		
<s:if test="#session.cpHome_mpAziendeAAEP_selectedMultiPanel == 'cpHome_mpAziendeAAEP_fpAziendeAAEP'">
	<s:include value="/jsp/multipanels/cpHome_mpAziendeAAEP_fpAziendeAAEP.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAziendeAAEP --></div>

			
	
	
	<div id="p_mpElencoDomande" class="panelBlock"><!-- startFragment:p_mpElencoDomande -->
		

		
<s:if test="#session.cpHome_mpElencoDomande_selectedMultiPanel == 'cpHome_mpElencoDomande_fpElencoDomande'">
	<s:include value="/jsp/multipanels/cpHome_mpElencoDomande_fpElencoDomande.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpElencoDomande --></div>

			
	
	
	<div id="p_mpElencoDomandeFr" class="panelBlock"><!-- startFragment:p_mpElencoDomandeFr -->
		

		
<s:if test="#session.cpHome_mpElencoDomandeFr_selectedMultiPanel == 'cpHome_mpElencoDomandeFr_fpElencoDomandeFr'">
	<s:include value="/jsp/multipanels/cpHome_mpElencoDomandeFr_fpElencoDomandeFr.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpElencoDomandeFr --></div>

			
	
	<div id="p_stdHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdHome -->
	
	
<div class="stdMessagePanel" id="stdHome">
	<customtag:stdMessagePanel id="stdHome" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdHome --></div>

			
	
	<div id="p_cmdpLanguageHome" class="commandPanelBlock"><!-- startFragment:p_cmdpLanguageHome -->
	
	
<div class="commandPanel functional" id="cmdpLanguageHome">

	
	
		
		
<s:if test="isWidgetVisible('cpHome','btnHomeIT')" >

	



<!-- widget btnHomeIT -->
<s:submit name="widg_btnHomeIT" id="widg_btnHomeIT" method="handleBtnHomeIT_CLICKED"
	key="cpHome.btnHomeIT.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpHome','btnHomeIT')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpHome','btnHomeFR')" >

	



<!-- widget btnHomeFR -->
<s:submit name="widg_btnHomeFR" id="widg_btnHomeFR" method="handleBtnHomeFR_CLICKED"
	key="cpHome.btnHomeFR.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpHome','btnHomeFR')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpHome','btnActa')" >

	



<!-- widget btnActa -->
<s:submit name="widg_btnActa" id="widg_btnActa" method="handleBtnActa_CLICKED"
	key="cpHome.btnActa.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpHome','btnActa')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cmdpLanguageHome --></div>

	

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
