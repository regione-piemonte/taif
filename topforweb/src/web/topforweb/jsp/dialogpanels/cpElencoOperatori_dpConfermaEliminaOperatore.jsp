#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpConfermaEliminaOperatoreForm" action="cpElencoOperatori" namespace="/base/gestore" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpElencoOperatori.dpConfermaEliminaOperatore.label" /></h3>
				<div class="dialogPanel" id="dpConfermaEliminaOperatore">

		
		
<div id="p_mbpInfoEliminaOperatore" class="msgBoxPanelBlock"><!-- startFragment:p_mbpInfoEliminaOperatore -->

	
<div class="msgBoxPanel info" id="mbpInfoEliminaOperatore">


		
<s:if test="isWidgetVisible('cpElencoOperatori','ptInfoEliminaOperatore')" >

	
<p>


<!-- widget ptInfoEliminaOperatore -->
<s:text name="cpElencoOperatori.ptInfoEliminaOperatore.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpInfoEliminaOperatore --></div>

	
	<div id="p_cmdInfoEliminaOperatore" class="commandPanelBlock"><!-- startFragment:p_cmdInfoEliminaOperatore -->
	
	
<div class="commandPanel functional" id="cmdInfoEliminaOperatore">

	
	
		
		
<s:if test="isWidgetVisible('cpElencoOperatori','btnAnnullaEliminaOperatore')" >

	



<!-- widget btnAnnullaEliminaOperatore -->
<s:submit name="widg_btnAnnullaEliminaOperatore" id="widg_btnAnnullaEliminaOperatore" method="handleBtnAnnullaEliminaOperatore_CLICKED"
	key="cpElencoOperatori.btnAnnullaEliminaOperatore.label" cssClass="buttonWidget cancel"
	disabled="isWidgetDisabled('cpElencoOperatori','btnAnnullaEliminaOperatore')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoOperatori','btnConfermaEliminaOperatore')" >

	



<!-- widget btnConfermaEliminaOperatore -->
<s:submit name="widg_btnConfermaEliminaOperatore" id="widg_btnConfermaEliminaOperatore" method="handleBtnConfermaEliminaOperatore_CLICKED"
	key="cpElencoOperatori.btnConfermaEliminaOperatore.label" cssClass="buttonWidget confirm"
	disabled="isWidgetDisabled('cpElencoOperatori','btnConfermaEliminaOperatore')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cmdInfoEliminaOperatore --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
