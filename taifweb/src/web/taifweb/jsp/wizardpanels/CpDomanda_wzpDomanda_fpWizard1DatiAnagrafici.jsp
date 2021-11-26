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

	
	<div id="p_fpWizard1DatiAnagrafici" class="formPanelBlock"><!-- startFragment:p_fpWizard1DatiAnagrafici -->
		
	


	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_wzpDomandaDatiAnagrafici" class="wizardPanelBlock"><!-- startFragment:p_wzpDomandaDatiAnagrafici -->
	
	
<div class="wizardPanel" id="wzpDomandaDatiAnagrafici">
	<ol>
		<s:url id="CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub1_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub1'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel == 'CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub1' || #session.CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem"><s:text name="CpDomanda.fpWizardDatiAnagraficiSub1.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1">

	<csiuicore:ajaxify id="p_wzpDomandaDatiAnagrafici" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomandaDatiAnagrafici_FpWizardDatiAnagraficiSub1_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda1"
		          id="tsWizardDomanda1_fpWizardDatiAnagraficiSub1"
		          method="handle_CpDomanda_WzpDomandaDatiAnagrafici_FpWizardDatiAnagraficiSub1_CLICKED"
		          key="CpDomanda.fpWizardDatiAnagraficiSub1.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub2_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub2'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel == 'CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub2'}">
	<li class="item-2 active"><span class="activeItem"><s:text name="CpDomanda.fpWizardDatiAnagraficiSub2.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2">

	<csiuicore:ajaxify id="p_wzpDomandaDatiAnagrafici" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomandaDatiAnagrafici_FpWizardDatiAnagraficiSub2_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda1"
		          id="tsWizardDomanda1_fpWizardDatiAnagraficiSub2"
		          method="handle_CpDomanda_WzpDomandaDatiAnagrafici_FpWizardDatiAnagraficiSub2_CLICKED"
		          key="CpDomanda.fpWizardDatiAnagraficiSub2.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel == 'CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub1' || #session.CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub1.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel == 'CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub2'">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub2.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_wzpDomandaDatiAnagrafici --></div>
	</div>

	

		
	

	<!-- endFragment:p_fpWizard1DatiAnagrafici --></div>
