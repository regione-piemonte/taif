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
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','udwConsensoPrivacy')" >

	
<customtag:widgetsPanelColumn 
	position="first" colSpan="2" >


<s:include value="/jsp/userwidgets/cpInserimentoOperatore_udwConsensoPrivacy.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','chbPrivacy')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.chbPrivacy.label')}" labelFor="widg_chbPrivacy" errorFor="appDataprivacy.privacy" labelId="chbPrivacyLbl"
	position="first"  >


<!-- widget chbPrivacy -->
<s:checkbox 
	
	
	name="appDataprivacy.privacy" id="widg_chbPrivacy"
	disabled="isWidgetDisabled('cpInserimentoOperatore','chbPrivacy')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpInserimentoOperatore','chbPrivacy')" >
	<s:hidden name="__checkbox_appDataprivacy.privacy" id="__checkbox_widg_chbPrivacy" />
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
