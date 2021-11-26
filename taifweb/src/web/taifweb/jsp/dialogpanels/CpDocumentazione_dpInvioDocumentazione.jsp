#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpInvioDocumentazioneForm" action="CpDocumentazione" namespace="/base/common" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="CpDocumentazione.dpInvioDocumentazione.label" /></h3>
				<div class="dialogPanel" id="dpInvioDocumentazione">

		
		
<div id="p_mbpInfoInviaDocumentazione" class="msgBoxPanelBlock"><!-- startFragment:p_mbpInfoInviaDocumentazione -->

	
<div class="msgBoxPanel info" id="mbpInfoInviaDocumentazione">


		
<s:if test="isWidgetVisible('CpDocumentazione','ptInfoInvioDocumentazione')" >

	
<p>


<!-- widget ptInfoInvioDocumentazione -->
<s:text name="CpDocumentazione.ptInfoInvioDocumentazione.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpInfoInviaDocumentazione --></div>

	
	<div id="p_cmdInfoInvioDomanda" class="commandPanelBlock"><!-- startFragment:p_cmdInfoInvioDomanda -->
	
	
<div class="commandPanel functional" id="cmdInfoInvioDomanda">

	
	
		
		
<s:if test="isWidgetVisible('CpDocumentazione','btnConfermaInvioDocumentazioneHome')" >

	



<!-- widget btnConfermaInvioDocumentazioneHome -->
<s:submit name="widg_btnConfermaInvioDocumentazioneHome" id="widg_btnConfermaInvioDocumentazioneHome" method="handleBtnConfermaInvioDocumentazioneHome_CLICKED"
	key="CpDocumentazione.btnConfermaInvioDocumentazioneHome.label" cssClass="buttonWidget confirm"
	disabled="isWidgetDisabled('CpDocumentazione','btnConfermaInvioDocumentazioneHome')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cmdInfoInvioDomanda --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
