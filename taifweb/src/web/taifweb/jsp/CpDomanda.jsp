#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/domanda/CpDomandaAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/domanda -->
<!-- pageId:CpDomanda -->

<s:form id="CpDomanda" action="CpDomanda" namespace="/base/domanda" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpDomandaUserInfo" class="formPanelBlock"><!-- startFragment:p_fpDomandaUserInfo -->

	
	

	
	
			
	
	<div id="p_uipDomanda" class="userInfoPanelBlock"><!-- startFragment:p_uipDomanda -->
	
	
<div class="userInfoPanel" id="uipDomanda">
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

	<!-- endFragment:p_uipDomanda --></div>

			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('CpDomanda','menuView')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpDomandaUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpDomandaBody" class="formPanelBlock"><!-- startFragment:p_fpDomandaBody -->

	
	

	
	
			
	
	<div id="p_smpDomanda" class="stdMessagePanelBlock"><!-- startFragment:p_smpDomanda -->
	
	
<div class="stdMessagePanel" id="smpDomanda">
	<customtag:stdMessagePanel id="smpDomanda" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpDomanda --></div>

			
	
	<div id="p_wpAlboDomanda" class="widgetsPanelBlock"><!-- startFragment:p_wpAlboDomanda -->
	
	

<div class="widgetsPanel" id="wpAlboDomanda">
	
	<customtag:widgetsPanel id="wpAlboDomandaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','udwAlboDomanda')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >


<s:include value="/jsp/userwidgets/CpDomanda_udwAlboDomanda.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAlboDomanda --></div>

			
	
	
	<div class="wizardPanelContent">
	<div id="p_wzpDomanda" class="wizardPanelBlock"><!-- startFragment:p_wzpDomanda -->
	
	
<div class="wizardPanel" id="wzpDomanda">
	<ol>
		<s:url id="CpDomanda_wzpDomanda_fpWizard1DatiAnagrafici_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomanda_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomanda_fpWizard1DatiAnagrafici'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomanda_selectedMultiPanel == 'CpDomanda_wzpDomanda_fpWizard1DatiAnagrafici' || #session.CpDomanda_wzpDomanda_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem"><s:text name="CpDomanda.fpWizard1DatiAnagrafici.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1">

	<csiuicore:ajaxify id="p_wzpDomanda" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomanda_FpWizard1DatiAnagrafici_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda"
		          id="tsWizardDomanda_fpWizard1DatiAnagrafici"
		          method="handle_CpDomanda_WzpDomanda_FpWizard1DatiAnagrafici_CLICKED"
		          key="CpDomanda.fpWizard1DatiAnagrafici.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="CpDomanda_wzpDomanda_fpWizard2DatiSocioEconomici_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomanda_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomanda_fpWizard2DatiSocioEconomici'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomanda_selectedMultiPanel == 'CpDomanda_wzpDomanda_fpWizard2DatiSocioEconomici'}">
	<li class="item-2 active"><span class="activeItem"><s:text name="CpDomanda.fpWizard2DatiSocioEconomici.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2">

	<csiuicore:ajaxify id="p_wzpDomanda" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomanda_FpWizard2DatiSocioEconomici_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda"
		          id="tsWizardDomanda_fpWizard2DatiSocioEconomici"
		          method="handle_CpDomanda_WzpDomanda_FpWizard2DatiSocioEconomici_CLICKED"
		          key="CpDomanda.fpWizard2DatiSocioEconomici.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="CpDomanda_wzpDomanda_fpWizard3Attivita_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomanda_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomanda_fpWizard3Attivita'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomanda_selectedMultiPanel == 'CpDomanda_wzpDomanda_fpWizard3Attivita'}">
	<li class="item-3 active"><span class="activeItem"><s:text name="CpDomanda.fpWizard3Attivita.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-3">

	<csiuicore:ajaxify id="p_wzpDomanda" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomanda_FpWizard3Attivita_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda"
		          id="tsWizardDomanda_fpWizard3Attivita"
		          method="handle_CpDomanda_WzpDomanda_FpWizard3Attivita_CLICKED"
		          key="CpDomanda.fpWizard3Attivita.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="CpDomanda_wzpDomanda_fpWizard4Strutture_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomanda_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomanda_fpWizard4Strutture'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomanda_selectedMultiPanel == 'CpDomanda_wzpDomanda_fpWizard4Strutture'}">
	<li class="item-4 active"><span class="activeItem"><s:text name="CpDomanda.fpWizard4Strutture.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-4">

	<csiuicore:ajaxify id="p_wzpDomanda" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomanda_FpWizard4Strutture_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda"
		          id="tsWizardDomanda_fpWizard4Strutture"
		          method="handle_CpDomanda_WzpDomanda_FpWizard4Strutture_CLICKED"
		          key="CpDomanda.fpWizard4Strutture.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="CpDomanda_wzpDomanda_fpWizard5Attrezzature_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomanda_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomanda_fpWizard5Attrezzature'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomanda_selectedMultiPanel == 'CpDomanda_wzpDomanda_fpWizard5Attrezzature'}">
	<li class="item-5 active"><span class="activeItem"><s:text name="CpDomanda.fpWizard5Attrezzature.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-5">

	<csiuicore:ajaxify id="p_wzpDomanda" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomanda_FpWizard5Attrezzature_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda"
		          id="tsWizardDomanda_fpWizard5Attrezzature"
		          method="handle_CpDomanda_WzpDomanda_FpWizard5Attrezzature_CLICKED"
		          key="CpDomanda.fpWizard5Attrezzature.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="CpDomanda_wzpDomanda_fpWizard6Personale_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomanda_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomanda_fpWizard6Personale'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomanda_selectedMultiPanel == 'CpDomanda_wzpDomanda_fpWizard6Personale'}">
	<li class="item-6 active"><span class="activeItem"><s:text name="CpDomanda.fpWizard6Personale.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-6">

	<csiuicore:ajaxify id="p_wzpDomanda" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomanda_FpWizard6Personale_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda"
		          id="tsWizardDomanda_fpWizard6Personale"
		          method="handle_CpDomanda_WzpDomanda_FpWizard6Personale_CLICKED"
		          key="CpDomanda.fpWizard6Personale.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.CpDomanda_wzpDomanda_selectedMultiPanel == 'CpDomanda_wzpDomanda_fpWizard1DatiAnagrafici' || #session.CpDomanda_wzpDomanda_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomanda_fpWizard1DatiAnagrafici.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.CpDomanda_wzpDomanda_selectedMultiPanel == 'CpDomanda_wzpDomanda_fpWizard2DatiSocioEconomici'">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomanda_fpWizard2DatiSocioEconomici.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.CpDomanda_wzpDomanda_selectedMultiPanel == 'CpDomanda_wzpDomanda_fpWizard3Attivita'">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomanda_fpWizard3Attivita.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.CpDomanda_wzpDomanda_selectedMultiPanel == 'CpDomanda_wzpDomanda_fpWizard4Strutture'">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomanda_fpWizard4Strutture.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.CpDomanda_wzpDomanda_selectedMultiPanel == 'CpDomanda_wzpDomanda_fpWizard5Attrezzature'">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomanda_fpWizard5Attrezzature.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.CpDomanda_wzpDomanda_selectedMultiPanel == 'CpDomanda_wzpDomanda_fpWizard6Personale'">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomanda_fpWizard6Personale.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_wzpDomanda --></div>
	</div>

			
	
	<div id="p_cmdWizardDomanda" class="commandPanelBlock"><!-- startFragment:p_cmdWizardDomanda -->
	
	
<div class="commandPanel navigation" id="cmdWizardDomanda">

	
	
		

	
	
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('CpDomanda','btnWizardDomandaIndietro')" >

	



<!-- widget btnWizardDomandaIndietro -->
<s:submit name="widg_btnWizardDomandaIndietro" id="widg_btnWizardDomandaIndietro" method="handleBtnWizardDomandaIndietro_CLICKED"
	key="CpDomanda.btnWizardDomandaIndietro.label" cssClass="buttonWidget back"
	disabled="isWidgetDisabled('CpDomanda','btnWizardDomandaIndietro')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('CpDomanda','btnWizardDomandaSalva')" >

	



<!-- widget btnWizardDomandaSalva -->
<s:submit name="widg_btnWizardDomandaSalva" id="widg_btnWizardDomandaSalva" method="handleBtnWizardDomandaSalva_CLICKED"
	key="CpDomanda.btnWizardDomandaSalva.label" cssClass="buttonWidget save"
	disabled="isWidgetDisabled('CpDomanda','btnWizardDomandaSalva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('CpDomanda','btnWizardDomandaProsegui')" >

	



<!-- widget btnWizardDomandaProsegui -->
<s:submit name="widg_btnWizardDomandaProsegui" id="widg_btnWizardDomandaProsegui" method="handleBtnWizardDomandaProsegui_CLICKED"
	key="CpDomanda.btnWizardDomandaProsegui.label" cssClass="buttonWidget forward"
	disabled="isWidgetDisabled('CpDomanda','btnWizardDomandaProsegui')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnDocumentiDemo')" >

	



<!-- widget btnDocumentiDemo -->
<s:submit name="widg_btnDocumentiDemo" id="widg_btnDocumentiDemo" method="handleBtnDocumentiDemo_CLICKED"
	key="CpDomanda.btnDocumentiDemo.label" cssClass="buttonWidget lookup"
	disabled="isWidgetDisabled('CpDomanda','btnDocumentiDemo')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('CpDomanda','btnIndexDemo')" >

	



<!-- widget btnIndexDemo -->
<s:submit name="widg_btnIndexDemo" id="widg_btnIndexDemo" method="handleBtnIndexDemo_CLICKED"
	key="CpDomanda.btnIndexDemo.label" cssClass="buttonWidget lookup"
	disabled="isWidgetDisabled('CpDomanda','btnIndexDemo')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdWizardDomanda --></div>

	

	<!-- endFragment:p_fpDomandaBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
