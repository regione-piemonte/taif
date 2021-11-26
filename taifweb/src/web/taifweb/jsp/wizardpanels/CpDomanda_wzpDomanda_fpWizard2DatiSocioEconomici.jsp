#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/domanda/CpDomandaAction" />

	
	<div id="p_fpWizard2DatiSocioEconomici" class="formPanelBlock"><!-- startFragment:p_fpWizard2DatiSocioEconomici -->
		
	


	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_wzpDomandaDatiSocioEconomici" class="wizardPanelBlock"><!-- startFragment:p_wzpDomandaDatiSocioEconomici -->
	
	
<div class="wizardPanel" id="wzpDomandaDatiSocioEconomici">
	<ol>
		<s:url id="CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub1_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub1'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel == 'CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub1' || #session.CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem"><s:text name="CpDomanda.fpWizardDatiSocioEconomiciSub1.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1">

	<csiuicore:ajaxify id="p_wzpDomandaDatiSocioEconomici" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomandaDatiSocioEconomici_FpWizardDatiSocioEconomiciSub1_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda2"
		          id="tsWizardDomanda2_fpWizardDatiSocioEconomiciSub1"
		          method="handle_CpDomanda_WzpDomandaDatiSocioEconomici_FpWizardDatiSocioEconomiciSub1_CLICKED"
		          key="CpDomanda.fpWizardDatiSocioEconomiciSub1.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub2_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub2'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel == 'CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub2'}">
	<li class="item-2 active"><span class="activeItem"><s:text name="CpDomanda.fpWizardDatiSocioEconomiciSub2.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2">

	<csiuicore:ajaxify id="p_wzpDomandaDatiSocioEconomici" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomandaDatiSocioEconomici_FpWizardDatiSocioEconomiciSub2_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda2"
		          id="tsWizardDomanda2_fpWizardDatiSocioEconomiciSub2"
		          method="handle_CpDomanda_WzpDomandaDatiSocioEconomici_FpWizardDatiSocioEconomiciSub2_CLICKED"
		          key="CpDomanda.fpWizardDatiSocioEconomiciSub2.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel == 'CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub1' || #session.CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub1.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel == 'CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub2'">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub2.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_wzpDomandaDatiSocioEconomici --></div>
	</div>

	

		
	

	<!-- endFragment:p_fpWizard2DatiSocioEconomici --></div>
