#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpConfermaEliminaOperatoreForestaleGestoreForm" action="cpElencoOperatoreGestore" namespace="/base/gestore" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpElencoOperatoreGestore.dpConfermaEliminaOperatoreForestaleGestore.label" /></h3>
				<div class="dialogPanel" id="dpConfermaEliminaOperatoreForestaleGestore">

		
		
<div id="p_mbpInfoEliminaOperatoreForestaleGestore" class="msgBoxPanelBlock"><!-- startFragment:p_mbpInfoEliminaOperatoreForestaleGestore -->

	
<div class="msgBoxPanel info" id="mbpInfoEliminaOperatoreForestaleGestore">


		
<s:if test="isWidgetVisible('cpElencoOperatoreGestore','ptInfoEliminaOperatoreForestaleGestore')" >

	
<p>


<!-- widget ptInfoEliminaOperatoreForestaleGestore -->
<s:text name="cpElencoOperatoreGestore.ptInfoEliminaOperatoreForestaleGestore.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpInfoEliminaOperatoreForestaleGestore --></div>

	
	<div id="p_cmdInfoEliminaOperatoreForestaleGestore" class="commandPanelBlock"><!-- startFragment:p_cmdInfoEliminaOperatoreForestaleGestore -->
	
	
<div class="commandPanel functional" id="cmdInfoEliminaOperatoreForestaleGestore">

	
	
		
		
<s:if test="isWidgetVisible('cpElencoOperatoreGestore','btnAnnullaEliminaOperatoreForestaleGestore')" >

	



<!-- widget btnAnnullaEliminaOperatoreForestaleGestore -->
<s:submit name="widg_btnAnnullaEliminaOperatoreForestaleGestore" id="widg_btnAnnullaEliminaOperatoreForestaleGestore" method="handleBtnAnnullaEliminaOperatoreForestaleGestore_CLICKED"
	key="cpElencoOperatoreGestore.btnAnnullaEliminaOperatoreForestaleGestore.label" cssClass="buttonWidget cancel"
	disabled="isWidgetDisabled('cpElencoOperatoreGestore','btnAnnullaEliminaOperatoreForestaleGestore')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoOperatoreGestore','btnConfermaEliminaOperatoreForestaleGestore')" >

	



<!-- widget btnConfermaEliminaOperatoreForestaleGestore -->
<s:submit name="widg_btnConfermaEliminaOperatoreForestaleGestore" id="widg_btnConfermaEliminaOperatoreForestaleGestore" method="handleBtnConfermaEliminaOperatoreForestaleGestore_CLICKED"
	key="cpElencoOperatoreGestore.btnConfermaEliminaOperatoreForestaleGestore.label" cssClass="buttonWidget confirm"
	disabled="isWidgetDisabled('cpElencoOperatoreGestore','btnConfermaEliminaOperatoreForestaleGestore')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cmdInfoEliminaOperatoreForestaleGestore --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
