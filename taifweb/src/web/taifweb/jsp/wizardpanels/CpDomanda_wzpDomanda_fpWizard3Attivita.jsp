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

	
	<div id="p_fpWizard3Attivita" class="formPanelBlock"><!-- startFragment:p_fpWizard3Attivita -->
		
	


	
	

	
	
			
	
	
	<div class="wizardPanelContent">
	<div id="p_wzpDomandaAttivita" class="wizardPanelBlock"><!-- startFragment:p_wzpDomandaAttivita -->
	
	
<div class="wizardPanel" id="wzpDomandaAttivita">
	<ol>
		<s:url id="CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub1_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomandaAttivita_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub1'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomandaAttivita_selectedMultiPanel == 'CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub1' || #session.CpDomanda_wzpDomandaAttivita_selectedMultiPanel == null}">
	<li class="item-1 active"><span class="activeItem"><s:text name="CpDomanda.fpWizardAttivitaSub1.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-1">

	<csiuicore:ajaxify id="p_wzpDomandaAttivita" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomandaAttivita_FpWizardAttivitaSub1_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda3"
		          id="tsWizardDomanda3_fpWizardAttivitaSub1"
		          method="handle_CpDomanda_WzpDomandaAttivita_FpWizardAttivitaSub1_CLICKED"
		          key="CpDomanda.fpWizardAttivitaSub1.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub2_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomandaAttivita_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub2'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomandaAttivita_selectedMultiPanel == 'CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub2'}">
	<li class="item-2 active"><span class="activeItem"><s:text name="CpDomanda.fpWizardAttivitaSub2.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-2">

	<csiuicore:ajaxify id="p_wzpDomandaAttivita" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomandaAttivita_FpWizardAttivitaSub2_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda3"
		          id="tsWizardDomanda3_fpWizardAttivitaSub2"
		          method="handle_CpDomanda_WzpDomandaAttivita_FpWizardAttivitaSub2_CLICKED"
		          key="CpDomanda.fpWizardAttivitaSub2.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
		<s:url id="CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub3_URL" action="CpDomanda" namespace="/base/domanda" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'CpDomanda_wzpDomandaAttivita_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub3'}" />
		</s:url>
		<s:if test="%{#session.CpDomanda_wzpDomandaAttivita_selectedMultiPanel == 'CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub3'}">
	<li class="item-3 active"><span class="activeItem"><s:text name="CpDomanda.fpWizardAttivitaSub3.label" /></span><span class="separator"> | </span></li>
		</s:if>
		<s:else>
				
	<li class="item-3">

	<csiuicore:ajaxify id="p_wzpDomandaAttivita" 
		widgetType="button" 
		requestUri="/taifweb/base/domanda/CpDomanda!handle_CpDomanda_WzpDomandaAttivita_FpWizardAttivitaSub3_CLICKED.do" 
		pageId="CpDomanda" 
		formName="CpDomanda"
		javascriptDetection="false">
    	<s:submit name="tsWizardDomanda3"
		          id="tsWizardDomanda3_fpWizardAttivitaSub3"
		          method="handle_CpDomanda_WzpDomandaAttivita_FpWizardAttivitaSub3_CLICKED"
		          key="CpDomanda.fpWizardAttivitaSub3.label" />
        	
	</csiuicore:ajaxify>
        <span class="separator"> | </span>
	</li>
		</s:else>
	</ol>
</div>


	
		

		
<s:if test="#session.CpDomanda_wzpDomandaAttivita_selectedMultiPanel == 'CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub1' || #session.CpDomanda_wzpDomandaAttivita_selectedMultiPanel == null">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub1.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.CpDomanda_wzpDomandaAttivita_selectedMultiPanel == 'CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub2'">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub2.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.CpDomanda_wzpDomandaAttivita_selectedMultiPanel == 'CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub3'">
	<s:include value="/jsp/wizardpanels/CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub3.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_wzpDomandaAttivita --></div>
	</div>

	

		
	

	<!-- endFragment:p_fpWizard3Attivita --></div>
