#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/autenticazione -->
<!-- pageId:CpAutenticazione -->

<s:form id="CpAutenticazione" action="CpAutenticazione" namespace="/base/autenticazione" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpAutenticazioneUserInfo" class="formPanelBlock"><!-- startFragment:p_fpAutenticazioneUserInfo -->

	
	

	
	
			
	
	<div id="p_uipAutenticazione" class="userInfoPanelBlock"><!-- startFragment:p_uipAutenticazione -->
	
	
<div class="userInfoPanel" id="uipAutenticazione">
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

	<!-- endFragment:p_uipAutenticazione --></div>

	

	<!-- endFragment:p_fpAutenticazioneUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpAutenticazioneBody" class="formPanelBlock"><!-- startFragment:p_fpAutenticazioneBody -->

	
	

	
	
			
	
	<div id="p_smpAutenticazione" class="stdMessagePanelBlock"><!-- startFragment:p_smpAutenticazione -->
	
	
<div class="stdMessagePanel" id="smpAutenticazione">
	<customtag:stdMessagePanel id="smpAutenticazione" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpAutenticazione --></div>

			
	
	<div id="p_wpDatiAutenticazione" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAutenticazione -->
	
	

<div class="widgetsPanel" id="wpDatiAutenticazione">
	
	<customtag:widgetsPanel id="wpDatiAutenticazioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpAutenticazione','tfLoginAutenticazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpAutenticazione.tfLoginAutenticazione.label')}" labelFor="widg_tfLoginAutenticazione" errorFor="widg_tfLoginAutenticazione" labelId="tfLoginAutenticazioneLbl"
	  >


<!-- widget tfLoginAutenticazione -->
<s:textfield 
	
	
	name="widg_tfLoginAutenticazione" id="widg_tfLoginAutenticazione"
	disabled="isWidgetDisabled('CpAutenticazione','tfLoginAutenticazione')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpAutenticazione','tfPasswordAutenticazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpAutenticazione.tfPasswordAutenticazione.label')}" labelFor="widg_tfPasswordAutenticazione" errorFor="widg_tfPasswordAutenticazione" labelId="tfPasswordAutenticazioneLbl"
	  >


<!-- widget tfPasswordAutenticazione -->
<s:textfield 
	
title=""	
	name="widg_tfPasswordAutenticazione" id="widg_tfPasswordAutenticazione"
	disabled="isWidgetDisabled('CpAutenticazione','tfPasswordAutenticazione')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAutenticazione --></div>

			
	
	<div id="p_cmdAutenticazione" class="commandPanelBlock"><!-- startFragment:p_cmdAutenticazione -->
	
	
<div class="commandPanel navigation" id="cmdAutenticazione">

	
	
		

	
	
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('CpAutenticazione','btnAccedi')" >

	



<!-- widget btnAccedi -->
<s:submit name="widg_btnAccedi" id="widg_btnAccedi" method="handleBtnAccedi_CLICKED"
	key="CpAutenticazione.btnAccedi.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('CpAutenticazione','btnAccedi')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAutenticazione --></div>

	

	<!-- endFragment:p_fpAutenticazioneBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
