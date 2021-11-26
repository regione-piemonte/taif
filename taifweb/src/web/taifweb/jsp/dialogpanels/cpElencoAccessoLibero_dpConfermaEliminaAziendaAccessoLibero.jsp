#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpConfermaEliminaAziendaAccessoLiberoForm" action="cpElencoAccessoLibero" namespace="/base/libero" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpElencoAccessoLibero.dpConfermaEliminaAziendaAccessoLibero.label" /></h3>
				<div class="dialogPanel" id="dpConfermaEliminaAziendaAccessoLibero">

		
		
<div id="p_mbpInfoEliminaAziendaAccessoLibero" class="msgBoxPanelBlock"><!-- startFragment:p_mbpInfoEliminaAziendaAccessoLibero -->

	
<div class="msgBoxPanel info" id="mbpInfoEliminaAziendaAccessoLibero">


		
<s:if test="isWidgetVisible('cpElencoAccessoLibero','ptInfoEliminaAziendaAccessoLibero')" >

	
<p>


<!-- widget ptInfoEliminaAziendaAccessoLibero -->
<s:text name="cpElencoAccessoLibero.ptInfoEliminaAziendaAccessoLibero.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpInfoEliminaAziendaAccessoLibero --></div>

	
	<div id="p_cmdInfoEliminaAziendaAccessoLibero" class="commandPanelBlock"><!-- startFragment:p_cmdInfoEliminaAziendaAccessoLibero -->
	
	
<div class="commandPanel functional" id="cmdInfoEliminaAziendaAccessoLibero">

	
	
		
		
<s:if test="isWidgetVisible('cpElencoAccessoLibero','btnAnnullaEliminaAziendaAccessoLibero')" >

	



<!-- widget btnAnnullaEliminaAziendaAccessoLibero -->
<s:submit name="widg_btnAnnullaEliminaAziendaAccessoLibero" id="widg_btnAnnullaEliminaAziendaAccessoLibero" method="handleBtnAnnullaEliminaAziendaAccessoLibero_CLICKED"
	key="cpElencoAccessoLibero.btnAnnullaEliminaAziendaAccessoLibero.label" cssClass="buttonWidget cancel"
	disabled="isWidgetDisabled('cpElencoAccessoLibero','btnAnnullaEliminaAziendaAccessoLibero')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAccessoLibero','btnConfermaEliminaAziendaAccessoLibero')" >

	



<!-- widget btnConfermaEliminaAziendaAccessoLibero -->
<s:submit name="widg_btnConfermaEliminaAziendaAccessoLibero" id="widg_btnConfermaEliminaAziendaAccessoLibero" method="handleBtnConfermaEliminaAziendaAccessoLibero_CLICKED"
	key="cpElencoAccessoLibero.btnConfermaEliminaAziendaAccessoLibero.label" cssClass="buttonWidget confirm"
	disabled="isWidgetDisabled('cpElencoAccessoLibero','btnConfermaEliminaAziendaAccessoLibero')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cmdInfoEliminaAziendaAccessoLibero --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
