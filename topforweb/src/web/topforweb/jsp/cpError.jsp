#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/common -->
<!-- pageId:cpError -->

<s:form id="cpError" action="cpError" namespace="/base/common" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">
	<div id="centerWrapper" class="floatWrapper">
		<div id="centerPanel">
		
		<a id="main_content" name="main_content"></a>
			<div class="wrapper">


				
				
					
	
	<div id="p_smpError" class="stdMessagePanelBlock"><!-- startFragment:p_smpError -->
	
	
<div class="stdMessagePanel" id="smpError">
	<customtag:stdMessagePanel id="smpError" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpError --></div>

				
					
	
	<div id="p_wpError" class="widgetsPanelBlock"><!-- startFragment:p_wpError -->
	
	

<div class="widgetsPanel" id="wpError">
	
	<customtag:widgetsPanel id="wpErrorTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpError','udwError')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >


<s:include value="/jsp/userwidgets/cpError_udwError.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpError','hvError')" >

	
<div class="hidden">


<!-- widget hvError -->
<s:hidden name="appDataprimoIngresso" id="widg_hvError" />

	
</div>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpError --></div>

				
					
	
	<div id="p_cpErrroNav" class="commandPanelBlock"><!-- startFragment:p_cpErrroNav -->
	
	
<div class="commandPanel navigation" id="cpErrroNav">

	
	
		
		
<s:if test="isWidgetVisible('cpError','btnErrorHome')" >

	



<!-- widget btnErrorHome -->
<s:submit name="widg_btnErrorHome" id="widg_btnErrorHome" method="handleBtnErrorHome_CLICKED"
	key="cpError.btnErrorHome.label" cssClass="buttonWidget save"
	disabled="isWidgetDisabled('cpError','btnErrorHome')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpErrroNav --></div>

				

			</div>
		</div>
	</div>
</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
