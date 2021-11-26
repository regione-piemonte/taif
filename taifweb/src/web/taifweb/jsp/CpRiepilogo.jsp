#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/common/CpRiepilogoAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/common -->
<!-- pageId:CpRiepilogo -->

<s:form id="CpRiepilogo" action="CpRiepilogo" namespace="/base/common" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpRiepilogoUserInfo" class="formPanelBlock"><!-- startFragment:p_fpRiepilogoUserInfo -->

	
	

	
	
			
	
	<div id="p_uipRiepilogo" class="userInfoPanelBlock"><!-- startFragment:p_uipRiepilogo -->
	
	
<div class="userInfoPanel" id="uipRiepilogo">
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

	<!-- endFragment:p_uipRiepilogo --></div>

			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('CpRiepilogo','menuView')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpRiepilogoUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpRiepilogoBody" class="formPanelBlock"><!-- startFragment:p_fpRiepilogoBody -->

	
	

	
	
			
	
	<div id="p_smpRiepilogo" class="stdMessagePanelBlock"><!-- startFragment:p_smpRiepilogo -->
	
	
<div class="stdMessagePanel" id="smpRiepilogo">
	<customtag:stdMessagePanel id="smpRiepilogo" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpRiepilogo --></div>

			
	
	<div id="p_wpRiepilogoIntestazioneStato" class="widgetsPanelBlock"><!-- startFragment:p_wpRiepilogoIntestazioneStato -->
	
	
<h4 class="wpLabel"><s:text name="CpRiepilogo.wpRiepilogoIntestazioneStato.label" /> </h4>
<div class="widgetsPanel" id="wpRiepilogoIntestazioneStato">
	
	<customtag:widgetsPanel id="wpRiepilogoIntestazioneStatoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpRiepilogo','ptDsStatoDomanda')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('CpRiepilogo.ptDsStatoDomanda.label')}" labelFor="widg_ptDsStatoDomanda" errorFor="appDatadomandaRiepilogo.statoDomanda" labelId="ptDsStatoDomandaLbl"  position="first" >


<!-- widget ptDsStatoDomanda -->
<s:property value="appDatadomandaRiepilogo.statoDomanda" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpRiepilogo','btnRiepilogoModificaStato')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRiepilogoModificaStato -->
<s:submit name="widg_btnRiepilogoModificaStato" id="widg_btnRiepilogoModificaStato" method="handleBtnRiepilogoModificaStato_CLICKED"
	key="CpRiepilogo.btnRiepilogoModificaStato.label" cssClass="buttonWidget editItem"
	disabled="isWidgetDisabled('CpRiepilogo','btnRiepilogoModificaStato')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRiepilogoIntestazioneStato --></div>

			
	
	
	<div id="p_mpRiepilogoTabellaStati" class="panelBlock"><!-- startFragment:p_mpRiepilogoTabellaStati -->
		

		
<s:if test="#session.CpRiepilogo_mpRiepilogoTabellaStati_selectedMultiPanel == 'CpRiepilogo_mpRiepilogoTabellaStati_fpRiepilogoTabellaStati'">
	<s:include value="/jsp/multipanels/CpRiepilogo_mpRiepilogoTabellaStati_fpRiepilogoTabellaStati.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpRiepilogoTabellaStati --></div>

			
	
	<div id="p_wpRiepilogoAltiDati" class="widgetsPanelBlock"><!-- startFragment:p_wpRiepilogoAltiDati -->
	
	

<div class="widgetsPanel" id="wpRiepilogoAltiDati">
	
	<customtag:widgetsPanel id="wpRiepilogoAltiDatiTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpRiepilogo','ptRiepilogoDsDomanda')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('CpRiepilogo.ptRiepilogoDsDomanda.label')}" labelFor="widg_ptRiepilogoDsDomanda" errorFor="appDatadomandaRiepilogo.dsDomanda" labelId="ptRiepilogoDsDomandaLbl" colSpan="5" position="first" >


<!-- widget ptRiepilogoDsDomanda -->
<s:property value="appDatadomandaRiepilogo.dsDomanda" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpRiepilogo','ptRiepilogoNumeroIscrizioneAlbo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('CpRiepilogo.ptRiepilogoNumeroIscrizioneAlbo.label')}" labelFor="widg_ptRiepilogoNumeroIscrizioneAlbo" errorFor="appDatadomandaRiepilogo.numeroIscrizioneAlbo" labelId="ptRiepilogoNumeroIscrizioneAlboLbl" colSpan="5" position="first" >


<!-- widget ptRiepilogoNumeroIscrizioneAlbo -->
<s:property value="appDatadomandaRiepilogo.numeroIscrizioneAlbo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpRiepilogo','ptRiepilogoDataIscrizioneAlbo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('CpRiepilogo.ptRiepilogoDataIscrizioneAlbo.label')}" labelFor="widg_ptRiepilogoDataIscrizioneAlbo" errorFor="appDatadomandaRiepilogo.dataIscrizioneAlbo" labelId="ptRiepilogoDataIscrizioneAlboLbl" colSpan="5" position="first" >


<!-- widget ptRiepilogoDataIscrizioneAlbo -->
<s:property value="appDatadomandaRiepilogo.dataIscrizioneAlbo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpRiepilogo','ptRiepilogoProtocolloAvvioProcedimento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('CpRiepilogo.ptRiepilogoProtocolloAvvioProcedimento.label')}" labelFor="widg_ptRiepilogoProtocolloAvvioProcedimento" errorFor="appDatadomandaRiepilogo.numeroProtocollo" labelId="ptRiepilogoProtocolloAvvioProcedimentoLbl" colSpan="5" position="first" >


<!-- widget ptRiepilogoProtocolloAvvioProcedimento -->
<s:property value="appDatadomandaRiepilogo.numeroProtocollo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpRiepilogo','ptRiepilogoDataProtocollo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('CpRiepilogo.ptRiepilogoDataProtocollo.label')}" labelFor="widg_ptRiepilogoDataProtocollo" errorFor="appDatadomandaRiepilogo.dataProtocollo" labelId="ptRiepilogoDataProtocolloLbl" colSpan="5" position="first" >


<!-- widget ptRiepilogoDataProtocollo -->
<s:property value="appDatadomandaRiepilogo.dataProtocollo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpRiepilogo','ptRiepilogoOperatoreUltimaModifica')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('CpRiepilogo.ptRiepilogoOperatoreUltimaModifica.label')}" labelFor="widg_ptRiepilogoOperatoreUltimaModifica" errorFor="appDatadomandaRiepilogo.operatoreUltimaModifica" labelId="ptRiepilogoOperatoreUltimaModificaLbl" colSpan="5" position="first" >


<!-- widget ptRiepilogoOperatoreUltimaModifica -->
<s:property value="appDatadomandaRiepilogo.operatoreUltimaModifica" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpRiepilogo','ptRiepilogoUltimaModificaDomanda')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('CpRiepilogo.ptRiepilogoUltimaModificaDomanda.label')}" labelFor="widg_ptRiepilogoUltimaModificaDomanda" errorFor="appDatadomandaRiepilogo.ultimaModificaDomanda" labelId="ptRiepilogoUltimaModificaDomandaLbl" colSpan="5" position="first" >


<!-- widget ptRiepilogoUltimaModificaDomanda -->
<s:property value="appDatadomandaRiepilogo.ultimaModificaDomanda" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRiepilogoAltiDati --></div>

			
	
	
	<div id="p_mpRiepilogoGestioneStatoDomanda" class="panelBlock"><!-- startFragment:p_mpRiepilogoGestioneStatoDomanda -->
		

		
<s:if test="#session.CpRiepilogo_mpRiepilogoGestioneStatoDomanda_selectedMultiPanel == 'CpRiepilogo_mpRiepilogoGestioneStatoDomanda_fpRiepilogoGestioneStatoDomanda'">
	<s:include value="/jsp/multipanels/CpRiepilogo_mpRiepilogoGestioneStatoDomanda_fpRiepilogoGestioneStatoDomanda.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpRiepilogoGestioneStatoDomanda --></div>

			
	
	
	<div id="p_mpRiepilogoStatoDomanda" class="panelBlock"><!-- startFragment:p_mpRiepilogoStatoDomanda -->
		

		
<s:if test="#session.CpRiepilogo_mpRiepilogoStatoDomanda_selectedMultiPanel == 'CpRiepilogo_mpRiepilogoStatoDomanda_fpRiepilogoStatoDomanda'">
	<s:include value="/jsp/multipanels/CpRiepilogo_mpRiepilogoStatoDomanda_fpRiepilogoStatoDomanda.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpRiepilogoStatoDomanda --></div>

			
	
	
	<div id="p_mpRiepilogoMessaggio" class="panelBlock"><!-- startFragment:p_mpRiepilogoMessaggio -->
		

		
<s:if test="#session.CpRiepilogo_mpRiepilogoMessaggio_selectedMultiPanel == 'CpRiepilogo_mpRiepilogoMessaggio_fpRiepilogoMessaggio'">
	<s:include value="/jsp/multipanels/CpRiepilogo_mpRiepilogoMessaggio_fpRiepilogoMessaggio.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpRiepilogoMessaggio --></div>

			
	
	
	<div id="p_mpSchedaAzienda" class="panelBlock"><!-- startFragment:p_mpSchedaAzienda -->
		

		
<s:if test="#session.CpRiepilogo_mpSchedaAzienda_selectedMultiPanel == 'CpRiepilogo_mpSchedaAzienda_fpSchedaAzienda'">
	<s:include value="/jsp/multipanels/CpRiepilogo_mpSchedaAzienda_fpSchedaAzienda.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpSchedaAzienda --></div>

			
	
	<div id="p_cmdpRiepilogoNav" class="commandPanelBlock"><!-- startFragment:p_cmdpRiepilogoNav -->
	
	
<div class="commandPanel navigation" id="cmdpRiepilogoNav">

	
	
		

	
	
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('CpRiepilogo','btnRiepilogoIndietro')" >

	



<!-- widget btnRiepilogoIndietro -->
<s:submit name="widg_btnRiepilogoIndietro" id="widg_btnRiepilogoIndietro" method="handleBtnRiepilogoIndietro_CLICKED"
	key="CpRiepilogo.btnRiepilogoIndietro.label" cssClass="buttonWidget back"
	disabled="isWidgetDisabled('CpRiepilogo','btnRiepilogoIndietro')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('CpRiepilogo','btnRiepilogoChiudi')" >

	



<!-- widget btnRiepilogoChiudi -->
<s:submit name="widg_btnRiepilogoChiudi" id="widg_btnRiepilogoChiudi" method="handleBtnRiepilogoChiudi_CLICKED"
	key="CpRiepilogo.btnRiepilogoChiudi.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('CpRiepilogo','btnRiepilogoChiudi')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('CpRiepilogo','btnRiepilogoDocumenti')" >

	



<!-- widget btnRiepilogoDocumenti -->
<s:submit name="widg_btnRiepilogoDocumenti" id="widg_btnRiepilogoDocumenti" method="handleBtnRiepilogoDocumenti_CLICKED"
	key="CpRiepilogo.btnRiepilogoDocumenti.label" cssClass="buttonWidget save"
	disabled="isWidgetDisabled('CpRiepilogo','btnRiepilogoDocumenti')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdpRiepilogoNav --></div>

	

	<!-- endFragment:p_fpRiepilogoBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
