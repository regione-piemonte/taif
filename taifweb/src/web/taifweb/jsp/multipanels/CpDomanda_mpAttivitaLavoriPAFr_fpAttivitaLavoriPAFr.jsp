#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAttivitaLavoriPAFr" class="formPanelBlock"><!-- startFragment:p_fpAttivitaLavoriPAFr -->
		
	
<div class="formPanel" id="fpAttivitaLavoriPAFr">


	
	

	
	
			
	
	<div id="p_wpAttivitaLavoriPAFr" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaLavoriPAFr -->
	
	

<div class="widgetsPanel" id="wpAttivitaLavoriPAFr">
	
	<customtag:widgetsPanel id="wpAttivitaLavoriPAFrTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="100">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','udwInfoAttivitaPAFr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_udwInfoAttivitaPAFr" errorFor="widg_udwInfoAttivitaPAFr" labelId="udwInfoAttivitaPAFrLbl"
	  >


<s:include value="/jsp/userwidgets/CpDomanda_udwInfoAttivitaPAFr.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaLavoriPAFr --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttivitaLavoriPAFr --></div>
