#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpConfermaEliminaAziendaGestoreForm" action="cpElencoAziendeGestore" namespace="/base/gestore" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpElencoAziendeGestore.dpConfermaEliminaAziendaGestore.label" /></h3>
				<div class="dialogPanel" id="dpConfermaEliminaAziendaGestore">

		
		
<div id="p_mbpInfoEliminaAziendaGestore" class="msgBoxPanelBlock"><!-- startFragment:p_mbpInfoEliminaAziendaGestore -->

	
<div class="msgBoxPanel info" id="mbpInfoEliminaAziendaGestore">


		
<s:if test="isWidgetVisible('cpElencoAziendeGestore','ptInfoEliminaAziendaGestore')" >

	
<p>


<!-- widget ptInfoEliminaAziendaGestore -->
<s:text name="cpElencoAziendeGestore.ptInfoEliminaAziendaGestore.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpInfoEliminaAziendaGestore --></div>

	
	<div id="p_cmdInfoEliminaAziendaGestore" class="commandPanelBlock"><!-- startFragment:p_cmdInfoEliminaAziendaGestore -->
	
	
<div class="commandPanel functional" id="cmdInfoEliminaAziendaGestore">

	
	
		
		
<s:if test="isWidgetVisible('cpElencoAziendeGestore','btnAnnullaEliminaAziendaGestore')" >

	



<!-- widget btnAnnullaEliminaAziendaGestore -->
<s:submit name="widg_btnAnnullaEliminaAziendaGestore" id="widg_btnAnnullaEliminaAziendaGestore" method="handleBtnAnnullaEliminaAziendaGestore_CLICKED"
	key="cpElencoAziendeGestore.btnAnnullaEliminaAziendaGestore.label" cssClass="buttonWidget cancel"
	disabled="isWidgetDisabled('cpElencoAziendeGestore','btnAnnullaEliminaAziendaGestore')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAziendeGestore','btnConfermaEliminaAziendaGestore')" >

	



<!-- widget btnConfermaEliminaAziendaGestore -->
<s:submit name="widg_btnConfermaEliminaAziendaGestore" id="widg_btnConfermaEliminaAziendaGestore" method="handleBtnConfermaEliminaAziendaGestore_CLICKED"
	key="cpElencoAziendeGestore.btnConfermaEliminaAziendaGestore.label" cssClass="buttonWidget confirm"
	disabled="isWidgetDisabled('cpElencoAziendeGestore','btnConfermaEliminaAziendaGestore')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cmdInfoEliminaAziendaGestore --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
