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

	
	<div id="p_fpWizardAttivitaSub1" class="formPanelBlock"><!-- startFragment:p_fpWizardAttivitaSub1 -->
		
	


	
	

	
	
			
	
	
	<div id="p_mpAttivitaIt" class="panelBlock"><!-- startFragment:p_mpAttivitaIt -->
		

		
<s:if test="#session.CpDomanda_mpAttivitaIt_selectedMultiPanel == 'CpDomanda_mpAttivitaIt_fpAttivitaIt'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttivitaIt_fpAttivitaIt.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttivitaIt --></div>

			
	
	
	<div id="p_mpAttivitaFr" class="panelBlock"><!-- startFragment:p_mpAttivitaFr -->
		

		
<s:if test="#session.CpDomanda_mpAttivitaFr_selectedMultiPanel == 'CpDomanda_mpAttivitaFr_fpAttivitaFr'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttivitaFr_fpAttivitaFr.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttivitaFr --></div>

	

		
	

	<!-- endFragment:p_fpWizardAttivitaSub1 --></div>
