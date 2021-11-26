#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAttivitaLavoriPAIt" class="formPanelBlock"><!-- startFragment:p_fpAttivitaLavoriPAIt -->
		
	
<div class="formPanel" id="fpAttivitaLavoriPAIt">


	
	

	
	
			
	
	<div id="p_wpAttivitaLavoriPA" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaLavoriPA -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpAttivitaLavoriPA.label" /> </h4>
<div class="widgetsPanel" id="wpAttivitaLavoriPA">
	
	<customtag:widgetsPanel id="wpAttivitaLavoriPATbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','rbsAttivitaLavoriPA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.rbsAttivitaLavoriPA.label')}" labelFor="widg_rbsAttivitaLavoriPA" errorFor="widg_rbsAttivitaLavoriPA" labelId="rbsAttivitaLavoriPALbl"
	  >


<!-- widget rbsAttivitaLavoriPA -->

	
<div id="widg_rbsAttivitaLavoriPA" class="radiobuttons horizontal">





<div>

<s:url id="widg_rbsAttivitaLavoriPAurlRadioButtonValueChange"
   action="/taifweb/CpDomanda!handleRbsAttivitaLavoriPA_VALUE_CHANGED" namespace="/base/domanda"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbAttivitaLavoriPASi" name="widg_rbsAttivitaLavoriPA"
	list="#{'SI':'Si'}"
	disabled="isWidgetDisabled('CpDomanda','rbsAttivitaLavoriPA')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsAttivitaLavoriPAurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbAttivitaLavoriPASiSI"><s:text name="CpDomanda.rbsAttivitaLavoriPA.rbAttivitaLavoriPASi.label" /></label>
</div>





<div>

<s:radio
	
	
	id="widg_rbAttivitaLavoriPANo" name="widg_rbsAttivitaLavoriPA"
	list="#{'NO':'No'}"
	disabled="isWidgetDisabled('CpDomanda','rbsAttivitaLavoriPA')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsAttivitaLavoriPAurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbAttivitaLavoriPANoNO"><s:text name="CpDomanda.rbsAttivitaLavoriPA.rbAttivitaLavoriPANo.label" /></label>
</div>




	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaLavoriPA --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttivitaLavoriPAIt --></div>
