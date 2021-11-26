#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpRiepilogoMessaggio" class="formPanelBlock"><!-- startFragment:p_fpRiepilogoMessaggio -->
		
	
<div class="formPanel" id="fpRiepilogoMessaggio">


	
	

	
	
			
	
	<div id="p_wpRiepilogoMessaggio" class="widgetsPanelBlock"><!-- startFragment:p_wpRiepilogoMessaggio -->
	
	

<div class="widgetsPanel" id="wpRiepilogoMessaggio">
	
	<customtag:widgetsPanel id="wpRiepilogoMessaggioTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpRiepilogo','udwRiepilogoMessaggio')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >


<s:include value="/jsp/userwidgets/CpRiepilogo_udwRiepilogoMessaggio.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRiepilogoMessaggio --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRiepilogoMessaggio --></div>
