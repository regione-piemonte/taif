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

	
	<div id="p_fpWizard5Attrezzature" class="formPanelBlock"><!-- startFragment:p_fpWizard5Attrezzature -->
		
	


	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_wzpDomandaAttrezzatture" class="wizardPanelBlock"><!-- startFragment:p_wzpDomandaAttrezzatture -->
	
	
<div class="wizardPanel" id="wzpDomandaAttrezzatture">
	<ol>
		<s:url id="CpDomanda_wzpDomandaAttrezzatture_fpWizardAttrezzatureSub1_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomandaAttrezzatture_fpWizardAttrezzatureSub1'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel == 'CpDomanda_wzpDomandaAttrezzatture_fpWizardAttrezzatureSub1' || #session.CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem"><s:text name="CpDomanda.fpWizardAttrezzatureSub1.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1">

	<csiuicore:ajaxify id="p_wzpDomandaAttrezzatture" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomandaAttrezzatture_FpWizardAttrezzatureSub1_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda5"
		          id="tsWizardDomanda5_fpWizardAttrezzatureSub1"
		          method="handle_CpDomanda_WzpDomandaAttrezzatture_FpWizardAttrezzatureSub1_CLICKED"
		          key="CpDomanda.fpWizardAttrezzatureSub1.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub2_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub2'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel == 'CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub2'}">
	<li class="item-2 active"><span class="activeItem"><s:text name="CpDomanda.pWizardAttrezzatureSub2.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2">

	<csiuicore:ajaxify id="p_wzpDomandaAttrezzatture" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomandaAttrezzatture_PWizardAttrezzatureSub2_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda5"
		          id="tsWizardDomanda5_pWizardAttrezzatureSub2"
		          method="handle_CpDomanda_WzpDomandaAttrezzatture_PWizardAttrezzatureSub2_CLICKED"
		          key="CpDomanda.pWizardAttrezzatureSub2.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel == 'CpDomanda_wzpDomandaAttrezzatture_fpWizardAttrezzatureSub1' || #session.CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomandaAttrezzatture_fpWizardAttrezzatureSub1.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel == 'CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub2'">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub2.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_wzpDomandaAttrezzatture --></div>
	</div>

	

		
	

	<!-- endFragment:p_fpWizard5Attrezzature --></div>
