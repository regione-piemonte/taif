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

	
	<div id="p_fpWizard4Strutture" class="formPanelBlock"><!-- startFragment:p_fpWizard4Strutture -->
		
	


	
	

	
	
			
	
	<div id="p_fpWizardStrutture" class="formPanelBlock"><!-- startFragment:p_fpWizardStrutture -->
		
	


	
	

	
	
			
	
	<div id="p_wpStruttureCapannoni" class="widgetsPanelBlock"><!-- startFragment:p_wpStruttureCapannoni -->
	
	

<div class="widgetsPanel" id="wpStruttureCapannoni">
	
	<customtag:widgetsPanel id="wpStruttureCapannoniTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbStruttureCapannoni')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbStruttureCapannoni.label')}" labelFor="widg_chbStruttureCapannoni" errorFor="widg_chbStruttureCapannoni" labelId="chbStruttureCapannoniLbl"
	position="first"  >


<!-- widget chbStruttureCapannoni -->
<s:checkbox 
	
	
	name="widg_chbStruttureCapannoni" id="widg_chbStruttureCapannoni"
	disabled="isWidgetDisabled('CpDomanda','chbStruttureCapannoni')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbStruttureCapannoni_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbStruttureCapannoni')" >
	<s:hidden name="__checkbox_widg_chbStruttureCapannoni" id="__checkbox_widg_chbStruttureCapannoni" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptStruttureCapannoni')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptStruttureCapannoni -->
<s:text name="CpDomanda.ptStruttureCapannoni.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpStruttureCapannoni --></div>

			
	
	
	<div id="p_mpStruttureCapannoni" class="panelBlock"><!-- startFragment:p_mpStruttureCapannoni -->
		

		
<s:if test="#session.CpDomanda_mpStruttureCapannoni_selectedMultiPanel == 'CpDomanda_mpStruttureCapannoni_fpStruttureCapannoni'">
	<s:include value="/jsp/multipanels/CpDomanda_mpStruttureCapannoni_fpStruttureCapannoni.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpStruttureCapannoni --></div>

			
	
	<div id="p_wpStrutturePiazzaliStoccaggio" class="widgetsPanelBlock"><!-- startFragment:p_wpStrutturePiazzaliStoccaggio -->
	
	

<div class="widgetsPanel" id="wpStrutturePiazzaliStoccaggio">
	
	<customtag:widgetsPanel id="wpStrutturePiazzaliStoccaggioTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="1,2,1,96">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','chbStrutturePiazzaliStoccaggio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbStrutturePiazzaliStoccaggio.label')}" labelFor="widg_chbStrutturePiazzaliStoccaggio" errorFor="widg_chbStrutturePiazzaliStoccaggio" labelId="chbStrutturePiazzaliStoccaggioLbl"
	position="first"  >


<!-- widget chbStrutturePiazzaliStoccaggio -->
<s:checkbox 
	
	
	name="widg_chbStrutturePiazzaliStoccaggio" id="widg_chbStrutturePiazzaliStoccaggio"
	disabled="isWidgetDisabled('CpDomanda','chbStrutturePiazzaliStoccaggio')"
	cssClass="checkbox"
	onclick="onRBClick('/taifweb/base/domanda/CpDomanda!handleChbStrutturePiazzaliStoccaggio_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbStrutturePiazzaliStoccaggio')" >
	<s:hidden name="__checkbox_widg_chbStrutturePiazzaliStoccaggio" id="__checkbox_widg_chbStrutturePiazzaliStoccaggio" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptStrutturePiazzaliStoccaggio')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget ptStrutturePiazzaliStoccaggio -->
<s:text name="CpDomanda.ptStrutturePiazzaliStoccaggio.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpStrutturePiazzaliStoccaggio --></div>

			
	
	
	<div id="p_mpStrutturePiazzaliStoccaggio" class="panelBlock"><!-- startFragment:p_mpStrutturePiazzaliStoccaggio -->
		

		
<s:if test="#session.CpDomanda_mpStrutturePiazzaliStoccaggio_selectedMultiPanel == 'CpDomanda_mpStrutturePiazzaliStoccaggio_fpStrutturePiazzaliStoccaggio'">
	<s:include value="/jsp/multipanels/CpDomanda_mpStrutturePiazzaliStoccaggio_fpStrutturePiazzaliStoccaggio.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpStrutturePiazzaliStoccaggio --></div>

	

		
	

	<!-- endFragment:p_fpWizardStrutture --></div>

	

		
	

	<!-- endFragment:p_fpWizard4Strutture --></div>
