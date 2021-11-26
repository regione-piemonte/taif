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

	
	<div id="p_fpWizardAttrezzatureSub1" class="formPanelBlock"><!-- startFragment:p_fpWizardAttrezzatureSub1 -->
		
	


	
	

	
	
			
	
	
	<div id="p_mpAttrezzatureIt" class="panelBlock"><!-- startFragment:p_mpAttrezzatureIt -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureIt_selectedMultiPanel == 'CpDomanda_mpAttrezzatureIt_fpAttrezzatureIt'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureIt_fpAttrezzatureIt.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureIt --></div>

			
	
	
	<div id="p_mpAttrezzatureFr" class="panelBlock"><!-- startFragment:p_mpAttrezzatureFr -->
		

		
<s:if test="#session.CpDomanda_mpAttrezzatureFr_selectedMultiPanel == 'CpDomanda_mpAttrezzatureFr_fpAttrezzatureFr'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttrezzatureFr_fpAttrezzatureFr.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttrezzatureFr --></div>

	

		
	

	<!-- endFragment:p_fpWizardAttrezzatureSub1 --></div>
