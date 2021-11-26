#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpSchedaAzienda" class="formPanelBlock"><!-- startFragment:p_fpSchedaAzienda -->
		
	
<div class="formPanel" id="fpSchedaAzienda">


	
	

	
	
			
	
	<div id="p_wpSchedaAzienda" class="widgetsPanelBlock"><!-- startFragment:p_wpSchedaAzienda -->
	
	
<h4 class="wpLabel"><s:text name="CpRiepilogo.wpSchedaAzienda.label" /> </h4>
<div class="widgetsPanel" id="wpSchedaAzienda">
	
	<customtag:widgetsPanel id="wpSchedaAziendaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="0,100">
	

	
	
<s:if test="isWidgetVisible('CpRiepilogo','ptSchedaAzienda')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptSchedaAzienda" errorFor="widg_ptSchedaAzienda" labelId="ptSchedaAziendaLbl"   >


<!-- widget ptSchedaAzienda -->
<s:text name="CpRiepilogo.ptSchedaAzienda.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpSchedaAzienda --></div>

	

		
	
</div>

	<!-- endFragment:p_fpSchedaAzienda --></div>
