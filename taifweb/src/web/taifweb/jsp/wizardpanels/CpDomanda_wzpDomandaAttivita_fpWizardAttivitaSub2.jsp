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

	
	<div id="p_fpWizardAttivitaSub2" class="formPanelBlock"><!-- startFragment:p_fpWizardAttivitaSub2 -->
		
	


	
	

	
	
			
	
	
	<div id="p_mpAttivitaLavoriPAIt" class="panelBlock"><!-- startFragment:p_mpAttivitaLavoriPAIt -->
		

		
<s:if test="#session.CpDomanda_mpAttivitaLavoriPAIt_selectedMultiPanel == 'CpDomanda_mpAttivitaLavoriPAIt_fpAttivitaLavoriPAIt'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttivitaLavoriPAIt_fpAttivitaLavoriPAIt.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttivitaLavoriPAIt --></div>

			
	
	
	<div id="p_mpAttivitaLavoriPA" class="panelBlock"><!-- startFragment:p_mpAttivitaLavoriPA -->
		

		
<s:if test="#session.CpDomanda_mpAttivitaLavoriPA_selectedMultiPanel == 'CpDomanda_mpAttivitaLavoriPA_fpAttivitaLavoriPA'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttivitaLavoriPA_fpAttivitaLavoriPA.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttivitaLavoriPA --></div>

			
	
	
	<div id="p_mpAttivitaLavoriPAFr" class="panelBlock"><!-- startFragment:p_mpAttivitaLavoriPAFr -->
		

		
<s:if test="#session.CpDomanda_mpAttivitaLavoriPAFr_selectedMultiPanel == 'CpDomanda_mpAttivitaLavoriPAFr_fpAttivitaLavoriPAFr'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttivitaLavoriPAFr_fpAttivitaLavoriPAFr.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttivitaLavoriPAFr --></div>

	

		
	

	<!-- endFragment:p_fpWizardAttivitaSub2 --></div>
