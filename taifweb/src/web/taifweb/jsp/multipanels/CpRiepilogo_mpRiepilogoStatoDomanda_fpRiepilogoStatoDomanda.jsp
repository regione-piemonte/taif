#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpRiepilogoStatoDomanda" class="formPanelBlock"><!-- startFragment:p_fpRiepilogoStatoDomanda -->
		
	
<div class="formPanel" id="fpRiepilogoStatoDomanda">


	
	

	
	
			
	
	<div id="p_wpRiepilogoStatoDomanda" class="widgetsPanelBlock"><!-- startFragment:p_wpRiepilogoStatoDomanda -->
	
	

<div class="widgetsPanel" id="wpRiepilogoStatoDomanda">
	
	<customtag:widgetsPanel id="wpRiepilogoStatoDomandaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpRiepilogo','udwRiepilogoStatoDomanda')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >


<s:include value="/jsp/userwidgets/CpRiepilogo_udwRiepilogoStatoDomanda.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRiepilogoStatoDomanda --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRiepilogoStatoDomanda --></div>
