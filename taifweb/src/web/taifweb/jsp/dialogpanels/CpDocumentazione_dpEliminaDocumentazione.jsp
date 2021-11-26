#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpEliminaDocumentazioneForm" action="CpDocumentazione" namespace="/base/common" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="CpDocumentazione.dpEliminaDocumentazione.label" /></h3>
				<div class="dialogPanel" id="dpEliminaDocumentazione">

		
		
<div id="p_mbpInfoEliminaDocumento" class="msgBoxPanelBlock"><!-- startFragment:p_mbpInfoEliminaDocumento -->

	
<div class="msgBoxPanel info" id="mbpInfoEliminaDocumento">


		
<s:if test="isWidgetVisible('CpDocumentazione','ptInfoEliminaDocumento')" >

	
<p>


<!-- widget ptInfoEliminaDocumento -->
<s:text name="CpDocumentazione.ptInfoEliminaDocumento.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpInfoEliminaDocumento --></div>

	
	<div id="p_cmdInfoEliminaDomanda" class="commandPanelBlock"><!-- startFragment:p_cmdInfoEliminaDomanda -->
	
	
<div class="commandPanel functional" id="cmdInfoEliminaDomanda">

	
	
		
		
<s:if test="isWidgetVisible('CpDocumentazione','btnConfermaEliminaDocumentazione')" >

	



<!-- widget btnConfermaEliminaDocumentazione -->
<s:submit name="widg_btnConfermaEliminaDocumentazione" id="widg_btnConfermaEliminaDocumentazione" method="handleBtnConfermaEliminaDocumentazione_CLICKED"
	key="CpDocumentazione.btnConfermaEliminaDocumentazione.label" cssClass="buttonWidget confirm"
	disabled="isWidgetDisabled('CpDocumentazione','btnConfermaEliminaDocumentazione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('CpDocumentazione','btnAnnullaEliminaDocumentazione')" >

	



<!-- widget btnAnnullaEliminaDocumentazione -->
<s:submit name="widg_btnAnnullaEliminaDocumentazione" id="widg_btnAnnullaEliminaDocumentazione" method="handleBtnAnnullaEliminaDocumentazione_CLICKED"
	key="CpDocumentazione.btnAnnullaEliminaDocumentazione.label" cssClass="buttonWidget cancel"
	disabled="isWidgetDisabled('CpDocumentazione','btnAnnullaEliminaDocumentazione')" />

	


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
