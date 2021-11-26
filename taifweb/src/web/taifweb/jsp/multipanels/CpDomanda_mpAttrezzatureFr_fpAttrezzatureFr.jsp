#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAttrezzatureFr" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureFr -->
		
	
<div class="formPanel" id="fpAttrezzatureFr">


	
	

	
	
			
	
	<div id="p_wpAttrezzatureFr" class="widgetsPanelBlock"><!-- startFragment:p_wpAttrezzatureFr -->
	
	

<div class="widgetsPanel" id="wpAttrezzatureFr">
	
	<customtag:widgetsPanel id="wpAttrezzatureFrTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="100">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','udwInfoAttrezzatureFr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_udwInfoAttrezzatureFr" errorFor="widg_udwInfoAttrezzatureFr" labelId="udwInfoAttrezzatureFrLbl"
	  >


<s:include value="/jsp/userwidgets/CpDomanda_udwInfoAttrezzatureFr.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttrezzatureFr --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureFr --></div>
