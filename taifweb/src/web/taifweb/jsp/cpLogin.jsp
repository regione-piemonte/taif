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
<!-- pageId:cpLogin -->

<s:form id="cpLogin" action="cpLogin" namespace="/base/home" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">



	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpLoginBody" class="formPanelBlock"><!-- startFragment:p_fpLoginBody -->

	
	

	
	
			
	
	<div id="p_stdLogin" class="stdMessagePanelBlock"><!-- startFragment:p_stdLogin -->
	
	
<div class="stdMessagePanel" id="stdLogin">
	<customtag:stdMessagePanel id="stdLogin" errorMessage="false" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdLogin --></div>

			
	
	<div id="p_wpDatiLogin" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiLogin -->
	
	

<div class="widgetsPanel" id="wpDatiLogin">
	
	<customtag:widgetsPanel id="wpDatiLoginTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpLogin','tfLogin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpLogin.tfLogin.label')}" labelFor="widg_tfLogin" errorFor="appDatalogin.user" labelId="tfLoginLbl"
	  >


<!-- widget tfLogin -->
<s:textfield 
	
	
	name="appDatalogin.user" id="widg_tfLogin"
maxlength="30"	disabled="isWidgetDisabled('cpLogin','tfLogin')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpLogin','udwPassword')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >


<s:include value="/jsp/userwidgets/cpLogin_udwPassword.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiLogin --></div>

			
	
	<div id="p_cmdpLogin" class="commandPanelBlock"><!-- startFragment:p_cmdpLogin -->
	
	
<div class="commandPanel functional" id="cmdpLogin">

	
	
		
		
<s:if test="isWidgetVisible('cpLogin','btnSubmitLogin')" >

	



<!-- widget btnSubmitLogin -->
<s:submit name="widg_btnSubmitLogin" id="widg_btnSubmitLogin" method="handleBtnSubmitLogin_CLICKED"
	key="cpLogin.btnSubmitLogin.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpLogin','btnSubmitLogin')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cmdpLogin --></div>

	

	<!-- endFragment:p_fpLoginBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
