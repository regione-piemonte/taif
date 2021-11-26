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

	
	<div id="p_pWizardAttrezzatureSub2" class="formPanelBlock"><!-- startFragment:p_pWizardAttrezzatureSub2 -->
		
	


	
	

	
	
			
	
	
	<div id="p_mpMacchineMezziIt" class="panelBlock"><!-- startFragment:p_mpMacchineMezziIt -->
		

		
<s:if test="#session.CpDomanda_mpMacchineMezziIt_selectedMultiPanel == 'CpDomanda_mpMacchineMezziIt_fpMacchineMezziIt'">
	<s:include value="/jsp/multipanels/CpDomanda_mpMacchineMezziIt_fpMacchineMezziIt.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpMacchineMezziIt --></div>

			
	
	
	<div id="p_mpMacchineMezziFr" class="panelBlock"><!-- startFragment:p_mpMacchineMezziFr -->
		

		
<s:if test="#session.CpDomanda_mpMacchineMezziFr_selectedMultiPanel == 'CpDomanda_mpMacchineMezziFr_fpMacchineMezziFr'">
	<s:include value="/jsp/multipanels/CpDomanda_mpMacchineMezziFr_fpMacchineMezziFr.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpMacchineMezziFr --></div>

	

		
	

	<!-- endFragment:p_pWizardAttrezzatureSub2 --></div>
