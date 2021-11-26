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

	
	<div id="p_fpWizardAttivitaSub3" class="formPanelBlock"><!-- startFragment:p_fpWizardAttivitaSub3 -->
		
	


	
	

	
	
			
	
	<div id="p_wpAttivitaLegname" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaLegname -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpAttivitaLegname.label" /> </h4>
<div class="widgetsPanel" id="wpAttivitaLegname">
	
	<customtag:widgetsPanel id="wpAttivitaLegnameTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','rbsAttivitaLegname')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.rbsAttivitaLegname.label')}" labelFor="widg_rbsAttivitaLegname" errorFor="widg_rbsAttivitaLegname" labelId="rbsAttivitaLegnameLbl"
	  >


<!-- widget rbsAttivitaLegname -->

	
<div id="widg_rbsAttivitaLegname" class="radiobuttons horizontal">





<div>

<s:url id="widg_rbsAttivitaLegnameurlRadioButtonValueChange"
   action="/taifweb/CpDomanda!handleRbsAttivitaLegname_VALUE_CHANGED" namespace="/base/domanda"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbAttivitaLegnameSi" name="widg_rbsAttivitaLegname"
	list="#{'SI':'Si'}"
	disabled="isWidgetDisabled('CpDomanda','rbsAttivitaLegname')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsAttivitaLegnameurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbAttivitaLegnameSiSI"><s:text name="CpDomanda.rbsAttivitaLegname.rbAttivitaLegnameSi.label" /></label>
</div>





<div>

<s:radio
	
	
	id="widg_rbAttivitaLegnameNo" name="widg_rbsAttivitaLegname"
	list="#{'NO':'No'}"
	disabled="isWidgetDisabled('CpDomanda','rbsAttivitaLegname')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsAttivitaLegnameurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbAttivitaLegnameNoNO"><s:text name="CpDomanda.rbsAttivitaLegname.rbAttivitaLegnameNo.label" /></label>
</div>




	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaLegname --></div>

			
	
	
	<div id="p_mpAttivitaLegname" class="panelBlock"><!-- startFragment:p_mpAttivitaLegname -->
		

		
<s:if test="#session.CpDomanda_mpAttivitaLegname_selectedMultiPanel == 'CpDomanda_mpAttivitaLegname_fpAttivitaLegname'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttivitaLegname_fpAttivitaLegname.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttivitaLegname --></div>

			
	
	
	<div id="p_mpAttivitaLegnameFr" class="panelBlock"><!-- startFragment:p_mpAttivitaLegnameFr -->
		

		
<s:if test="#session.CpDomanda_mpAttivitaLegnameFr_selectedMultiPanel == 'CpDomanda_mpAttivitaLegnameFr_fpAttivitaLegnameFr'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAttivitaLegnameFr_fpAttivitaLegnameFr.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAttivitaLegnameFr --></div>

	

		
	

	<!-- endFragment:p_fpWizardAttivitaSub3 --></div>
