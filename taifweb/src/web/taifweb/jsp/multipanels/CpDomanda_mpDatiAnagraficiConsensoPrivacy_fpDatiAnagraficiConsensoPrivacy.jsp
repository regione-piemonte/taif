#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiAnagraficiConsensoPrivacy" class="formPanelBlock"><!-- startFragment:p_fpDatiAnagraficiConsensoPrivacy -->
		
	
<div class="formPanel" id="fpDatiAnagraficiConsensoPrivacy">


	
	

	
	
			
	
	<div id="p_wpConsensoPrivacy" class="widgetsPanelBlock"><!-- startFragment:p_wpConsensoPrivacy -->
	
	

<div class="widgetsPanel" id="wpConsensoPrivacy">
	
	<customtag:widgetsPanel id="wpConsensoPrivacyTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="0,100">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','udwConsensoPrivacy')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_udwConsensoPrivacy" errorFor="widg_udwConsensoPrivacy" labelId="udwConsensoPrivacyLbl"
	position="first"  >


<s:include value="/jsp/userwidgets/CpDomanda_udwConsensoPrivacy.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','chbPrivacy')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.chbPrivacy.label')}" labelFor="widg_chbPrivacy" errorFor="appDataanagraficaAziendale.privacy" labelId="chbPrivacyLbl"
	position="first"  >


<!-- widget chbPrivacy -->
<s:checkbox 
	
	
	name="appDataanagraficaAziendale.privacy" id="widg_chbPrivacy"
	disabled="isWidgetDisabled('CpDomanda','chbPrivacy')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('CpDomanda','chbPrivacy')" >
	<s:hidden name="__checkbox_appDataanagraficaAziendale.privacy" id="__checkbox_widg_chbPrivacy" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpConsensoPrivacy --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiAnagraficiConsensoPrivacy --></div>
