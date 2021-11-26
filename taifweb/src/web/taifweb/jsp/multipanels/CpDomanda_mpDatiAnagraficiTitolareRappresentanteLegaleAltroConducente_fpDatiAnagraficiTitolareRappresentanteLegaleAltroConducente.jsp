#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente" class="formPanelBlock"><!-- startFragment:p_fpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente -->
		
	
<div class="formPanel" id="fpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente">


	
	

	
	
			
	
	<div id="p_wpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente.label" /> </h4>
<div class="widgetsPanel" id="wpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente">
	
	<customtag:widgetsPanel id="wpDatiAnagraficiTitolareRappresentanteLegaleAltroConducenteTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','rbsDatiAnagraficiAltroConducente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.rbsDatiAnagraficiAltroConducente.label')}" labelFor="widg_rbsDatiAnagraficiAltroConducente" errorFor="widg_rbsDatiAnagraficiAltroConducente" labelId="rbsDatiAnagraficiAltroConducenteLbl"
	  >


<!-- widget rbsDatiAnagraficiAltroConducente -->

	
<div id="widg_rbsDatiAnagraficiAltroConducente" class="radiobuttons horizontal">





<div>

<s:url id="widg_rbsDatiAnagraficiAltroConducenteurlRadioButtonValueChange"
   action="/taifweb/CpDomanda!handleRbsDatiAnagraficiAltroConducente_VALUE_CHANGED" namespace="/base/domanda"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbDatiAnagraficiAltroConducenteSi" name="widg_rbsDatiAnagraficiAltroConducente"
	list="#{'SI':'Si'}"
	disabled="isWidgetDisabled('CpDomanda','rbsDatiAnagraficiAltroConducente')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsDatiAnagraficiAltroConducenteurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbDatiAnagraficiAltroConducenteSiSI"><s:text name="CpDomanda.rbsDatiAnagraficiAltroConducente.rbDatiAnagraficiAltroConducenteSi.label" /></label>
</div>





<div>

<s:radio
	
	
	id="widg_rbDatiAnagraficiAltroConducenteNo" name="widg_rbsDatiAnagraficiAltroConducente"
	list="#{'NO':'No'}"
	disabled="isWidgetDisabled('CpDomanda','rbsDatiAnagraficiAltroConducente')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsDatiAnagraficiAltroConducenteurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbDatiAnagraficiAltroConducenteNoNO"><s:text name="CpDomanda.rbsDatiAnagraficiAltroConducente.rbDatiAnagraficiAltroConducenteNo.label" /></label>
</div>




	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente --></div>
