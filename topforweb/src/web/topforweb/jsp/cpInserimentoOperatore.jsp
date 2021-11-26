#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/topforweb/presentation/topforweb/action/gestore/CpInserimentoOperatoreAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestore -->
<!-- pageId:cpInserimentoOperatore -->

<s:form id="cpInserimentoOperatore" action="cpInserimentoOperatore" namespace="/base/gestore" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpInserimentoOperatoreUserInfo" class="formPanelBlock"><!-- startFragment:p_fpInserimentoOperatoreUserInfo -->

	
	

	
	
			
	
	<div id="p_uipInserimentoOperatore" class="userInfoPanelBlock"><!-- startFragment:p_uipInserimentoOperatore -->
	
	
<div class="userInfoPanel" id="uipInserimentoOperatore">
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

	<!-- endFragment:p_uipInserimentoOperatore --></div>

	

	<!-- endFragment:p_fpInserimentoOperatoreUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpInserimentoOperatoreBody" class="formPanelBlock"><!-- startFragment:p_fpInserimentoOperatoreBody -->

	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_wzpOperatore" class="wizardPanelBlock"><!-- startFragment:p_wzpOperatore -->
	
	
<div class="wizardPanel" id="wzpOperatore">
	<ol>
		<s:url id="cpInserimentoOperatore_wzpOperatore_fpWizardDatiAnagraficiOperatore_URL" action="cpInserimentoOperatore" namespace="/base/gestore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpInserimentoOperatore_wzpOperatore_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpInserimentoOperatore_wzpOperatore_fpWizardDatiAnagraficiOperatore'}" />
		</s:url>
		<s:if test="%{#session.cpInserimentoOperatore_wzpOperatore_selectedMultiPanel == 'cpInserimentoOperatore_wzpOperatore_fpWizardDatiAnagraficiOperatore' || #session.cpInserimentoOperatore_wzpOperatore_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem"><s:text name="cpInserimentoOperatore.fpWizardDatiAnagraficiOperatore.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1">

	<csiuicore:ajaxify id="p_wzpOperatore" 
		widgetType="button" 
		requestUri="/topforweb/base/gestore/cpInserimentoOperatore!handle_CpInserimentoOperatore_WzpOperatore_FpWizardDatiAnagraficiOperatore_CLICKED.do" 
		pageId="cpInserimentoOperatore" 
		formName="cpInserimentoOperatore"
		javascriptDetection="false">
    	<s:submit name="tsWizardOperatore"
		          id="tsWizardOperatore_fpWizardDatiAnagraficiOperatore"
		          method="handle_CpInserimentoOperatore_WzpOperatore_FpWizardDatiAnagraficiOperatore_CLICKED"
		          key="cpInserimentoOperatore.fpWizardDatiAnagraficiOperatore.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="cpInserimentoOperatore_wzpOperatore_fpWizardCorsiFinanziatiRegioneOperatore_URL" action="cpInserimentoOperatore" namespace="/base/gestore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpInserimentoOperatore_wzpOperatore_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpInserimentoOperatore_wzpOperatore_fpWizardCorsiFinanziatiRegioneOperatore'}" />
		</s:url>
		<s:if test="%{#session.cpInserimentoOperatore_wzpOperatore_selectedMultiPanel == 'cpInserimentoOperatore_wzpOperatore_fpWizardCorsiFinanziatiRegioneOperatore'}">
	<li class="item-2 active"><span class="activeItem"><s:text name="cpInserimentoOperatore.fpWizardCorsiFinanziatiRegioneOperatore.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2">

	<csiuicore:ajaxify id="p_wzpOperatore" 
		widgetType="button" 
		requestUri="/topforweb/base/gestore/cpInserimentoOperatore!handle_CpInserimentoOperatore_WzpOperatore_FpWizardCorsiFinanziatiRegioneOperatore_CLICKED.do" 
		pageId="cpInserimentoOperatore" 
		formName="cpInserimentoOperatore"
		javascriptDetection="false">
    	<s:submit name="tsWizardOperatore"
		          id="tsWizardOperatore_fpWizardCorsiFinanziatiRegioneOperatore"
		          method="handle_CpInserimentoOperatore_WzpOperatore_FpWizardCorsiFinanziatiRegioneOperatore_CLICKED"
		          key="cpInserimentoOperatore.fpWizardCorsiFinanziatiRegioneOperatore.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="cpInserimentoOperatore_wzpOperatore_fpWizardAltriCorsiOperatore_URL" action="cpInserimentoOperatore" namespace="/base/gestore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpInserimentoOperatore_wzpOperatore_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpInserimentoOperatore_wzpOperatore_fpWizardAltriCorsiOperatore'}" />
		</s:url>
		<s:if test="%{#session.cpInserimentoOperatore_wzpOperatore_selectedMultiPanel == 'cpInserimentoOperatore_wzpOperatore_fpWizardAltriCorsiOperatore'}">
	<li class="item-3 active"><span class="activeItem"><s:text name="cpInserimentoOperatore.fpWizardAltriCorsiOperatore.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-3">

	<csiuicore:ajaxify id="p_wzpOperatore" 
		widgetType="button" 
		requestUri="/topforweb/base/gestore/cpInserimentoOperatore!handle_CpInserimentoOperatore_WzpOperatore_FpWizardAltriCorsiOperatore_CLICKED.do" 
		pageId="cpInserimentoOperatore" 
		formName="cpInserimentoOperatore"
		javascriptDetection="false">
    	<s:submit name="tsWizardOperatore"
		          id="tsWizardOperatore_fpWizardAltriCorsiOperatore"
		          method="handle_CpInserimentoOperatore_WzpOperatore_FpWizardAltriCorsiOperatore_CLICKED"
		          key="cpInserimentoOperatore.fpWizardAltriCorsiOperatore.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="cpInserimentoOperatore_wzpOperatore_fpWizardQualificheOperatore_URL" action="cpInserimentoOperatore" namespace="/base/gestore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpInserimentoOperatore_wzpOperatore_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpInserimentoOperatore_wzpOperatore_fpWizardQualificheOperatore'}" />
		</s:url>
		<s:if test="%{#session.cpInserimentoOperatore_wzpOperatore_selectedMultiPanel == 'cpInserimentoOperatore_wzpOperatore_fpWizardQualificheOperatore'}">
	<li class="item-4 active"><span class="activeItem"><s:text name="cpInserimentoOperatore.fpWizardQualificheOperatore.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-4">

	<csiuicore:ajaxify id="p_wzpOperatore" 
		widgetType="button" 
		requestUri="/topforweb/base/gestore/cpInserimentoOperatore!handle_CpInserimentoOperatore_WzpOperatore_FpWizardQualificheOperatore_CLICKED.do" 
		pageId="cpInserimentoOperatore" 
		formName="cpInserimentoOperatore"
		javascriptDetection="false">
    	<s:submit name="tsWizardOperatore"
		          id="tsWizardOperatore_fpWizardQualificheOperatore"
		          method="handle_CpInserimentoOperatore_WzpOperatore_FpWizardQualificheOperatore_CLICKED"
		          key="cpInserimentoOperatore.fpWizardQualificheOperatore.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="cpInserimentoOperatore_wzpOperatore_fpWizardRiconoscimentiOperatore_URL" action="cpInserimentoOperatore" namespace="/base/gestore" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpInserimentoOperatore_wzpOperatore_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpInserimentoOperatore_wzpOperatore_fpWizardRiconoscimentiOperatore'}" />
		</s:url>
		<s:if test="%{#session.cpInserimentoOperatore_wzpOperatore_selectedMultiPanel == 'cpInserimentoOperatore_wzpOperatore_fpWizardRiconoscimentiOperatore'}">
	<li class="item-5 active"><span class="activeItem"><s:text name="cpInserimentoOperatore.fpWizardRiconoscimentiOperatore.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-5">

	<csiuicore:ajaxify id="p_wzpOperatore" 
		widgetType="button" 
		requestUri="/topforweb/base/gestore/cpInserimentoOperatore!handle_CpInserimentoOperatore_WzpOperatore_FpWizardRiconoscimentiOperatore_CLICKED.do" 
		pageId="cpInserimentoOperatore" 
		formName="cpInserimentoOperatore"
		javascriptDetection="false">
    	<s:submit name="tsWizardOperatore"
		          id="tsWizardOperatore_fpWizardRiconoscimentiOperatore"
		          method="handle_CpInserimentoOperatore_WzpOperatore_FpWizardRiconoscimentiOperatore_CLICKED"
		          key="cpInserimentoOperatore.fpWizardRiconoscimentiOperatore.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.cpInserimentoOperatore_wzpOperatore_selectedMultiPanel == 'cpInserimentoOperatore_wzpOperatore_fpWizardDatiAnagraficiOperatore' || #session.cpInserimentoOperatore_wzpOperatore_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/cpInserimentoOperatore_wzpOperatore_fpWizardDatiAnagraficiOperatore.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpInserimentoOperatore_wzpOperatore_selectedMultiPanel == 'cpInserimentoOperatore_wzpOperatore_fpWizardCorsiFinanziatiRegioneOperatore'">
	<s:include value="/jsp/wizardpanels/cpInserimentoOperatore_wzpOperatore_fpWizardCorsiFinanziatiRegioneOperatore.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpInserimentoOperatore_wzpOperatore_selectedMultiPanel == 'cpInserimentoOperatore_wzpOperatore_fpWizardAltriCorsiOperatore'">
	<s:include value="/jsp/wizardpanels/cpInserimentoOperatore_wzpOperatore_fpWizardAltriCorsiOperatore.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpInserimentoOperatore_wzpOperatore_selectedMultiPanel == 'cpInserimentoOperatore_wzpOperatore_fpWizardQualificheOperatore'">
	<s:include value="/jsp/wizardpanels/cpInserimentoOperatore_wzpOperatore_fpWizardQualificheOperatore.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpInserimentoOperatore_wzpOperatore_selectedMultiPanel == 'cpInserimentoOperatore_wzpOperatore_fpWizardRiconoscimentiOperatore'">
	<s:include value="/jsp/wizardpanels/cpInserimentoOperatore_wzpOperatore_fpWizardRiconoscimentiOperatore.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_wzpOperatore --></div>
	</div>

			
	
	<div id="p_cmdWizardOperatore" class="commandPanelBlock"><!-- startFragment:p_cmdWizardOperatore -->
	
	
<div class="commandPanel navigation" id="cmdWizardOperatore">

	
	
		

	
	
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('cpInserimentoOperatore','btnWizardBackElencoOperatore')" >

	



<!-- widget btnWizardBackElencoOperatore -->
<s:submit name="widg_btnWizardBackElencoOperatore" id="widg_btnWizardBackElencoOperatore" method="handleBtnWizardBackElencoOperatore_CLICKED"
	key="cpInserimentoOperatore.btnWizardBackElencoOperatore.label" cssClass="buttonWidget back"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btnWizardBackElencoOperatore')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpInserimentoOperatore','btnWizardOperatoreIndietro')" >

	



<!-- widget btnWizardOperatoreIndietro -->
<s:submit name="widg_btnWizardOperatoreIndietro" id="widg_btnWizardOperatoreIndietro" method="handleBtnWizardOperatoreIndietro_CLICKED"
	key="cpInserimentoOperatore.btnWizardOperatoreIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btnWizardOperatoreIndietro')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpInserimentoOperatore','btnWizardOperatoreSalva')" >

	



<!-- widget btnWizardOperatoreSalva -->
<s:submit name="widg_btnWizardOperatoreSalva" id="widg_btnWizardOperatoreSalva" method="handleBtnWizardOperatoreSalva_CLICKED"
	key="cpInserimentoOperatore.btnWizardOperatoreSalva.label" cssClass="buttonWidget save"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btnWizardOperatoreSalva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpInserimentoOperatore','btnWizardOperatoreProsegui')" >

	



<!-- widget btnWizardOperatoreProsegui -->
<s:submit name="widg_btnWizardOperatoreProsegui" id="widg_btnWizardOperatoreProsegui" method="handleBtnWizardOperatoreProsegui_CLICKED"
	key="cpInserimentoOperatore.btnWizardOperatoreProsegui.label" cssClass="buttonWidget forward"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btnWizardOperatoreProsegui')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdWizardOperatore --></div>

	

	<!-- endFragment:p_fpInserimentoOperatoreBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
