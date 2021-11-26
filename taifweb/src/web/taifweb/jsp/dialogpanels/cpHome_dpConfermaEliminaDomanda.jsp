#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpConfermaEliminaDomandaForm" action="cpHome" namespace="/base/home" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpHome.dpConfermaEliminaDomanda.label" /></h3>
				<div class="dialogPanel" id="dpConfermaEliminaDomanda">

		
		
<div id="p_mbpInfoEliminaDomanda" class="msgBoxPanelBlock"><!-- startFragment:p_mbpInfoEliminaDomanda -->

	
<div class="msgBoxPanel info" id="mbpInfoEliminaDomanda">


		
<s:if test="isWidgetVisible('cpHome','ptInfoEliminaDomanda')" >

	
<p>


<!-- widget ptInfoEliminaDomanda -->
<s:text name="cpHome.ptInfoEliminaDomanda.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpInfoEliminaDomanda --></div>

	
	<div id="p_cmdInfoEliminaDomanda" class="commandPanelBlock"><!-- startFragment:p_cmdInfoEliminaDomanda -->
	
	
<div class="commandPanel functional" id="cmdInfoEliminaDomanda">

	
	
		
		
<s:if test="isWidgetVisible('cpHome','btnAnnullaEliminaDomanda')" >

	



<!-- widget btnAnnullaEliminaDomanda -->
<s:submit name="widg_btnAnnullaEliminaDomanda" id="widg_btnAnnullaEliminaDomanda" method="handleBtnAnnullaEliminaDomanda_CLICKED"
	key="cpHome.btnAnnullaEliminaDomanda.label" cssClass="buttonWidget cancel"
	disabled="isWidgetDisabled('cpHome','btnAnnullaEliminaDomanda')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpHome','btnConfermaEliminaDomanda')" >

	



<!-- widget btnConfermaEliminaDomanda -->
<s:submit name="widg_btnConfermaEliminaDomanda" id="widg_btnConfermaEliminaDomanda" method="handleBtnConfermaEliminaDomanda_CLICKED"
	key="cpHome.btnConfermaEliminaDomanda.label" cssClass="buttonWidget confirm"
	disabled="isWidgetDisabled('cpHome','btnConfermaEliminaDomanda')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cmdInfoEliminaDomanda --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
