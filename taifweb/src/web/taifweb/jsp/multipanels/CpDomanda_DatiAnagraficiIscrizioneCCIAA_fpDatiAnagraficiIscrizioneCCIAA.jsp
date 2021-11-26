#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiAnagraficiIscrizioneCCIAA" class="formPanelBlock"><!-- startFragment:p_fpDatiAnagraficiIscrizioneCCIAA -->
		
	
<div class="formPanel" id="fpDatiAnagraficiIscrizioneCCIAA">


	
	

	
	
			
	
	<div id="p_wpDatiAnagraficiIscrizioneCCIAA" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiIscrizioneCCIAA -->
	
	
<h4 class="wpLabel">Iscrizione CCIAA </h4>
<div class="widgetsPanel" id="wpDatiAnagraficiIscrizioneCCIAA">
	
	<customtag:widgetsPanel id="wpDatiAnagraficiIscrizioneCCIAATbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','cbDatiAnagraficiAnagrafeAziendaleCCIAAProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbDatiAnagraficiAnagrafeAziendaleCCIAAProvincia.label')}" labelFor="widg_cbDatiAnagraficiAnagrafeAziendaleCCIAAProvincia" errorFor="appDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale" labelId="cbDatiAnagraficiAnagrafeAziendaleCCIAAProvinciaLbl"
	position="first"  >


<!-- widget cbDatiAnagraficiAnagrafeAziendaleCCIAAProvincia -->
<s:select name="appDataidProvinciaCCIAADatiAnagraficiAnagrafeAziendale" id="widg_cbDatiAnagraficiAnagrafeAziendaleCCIAAProvincia"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvinceCCIAADatiAnagraficiAnagrafeAnziendale"
	  disabled="isWidgetDisabled('CpDomanda','cbDatiAnagraficiAnagrafeAziendaleCCIAAProvincia')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiCCIAANumero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiCCIAANumero.label')}" labelFor="widg_tfDatiAnagraficiCCIAANumero" errorFor="appDataanagraficaAziendale.numeroCCIAA" labelId="tfDatiAnagraficiCCIAANumeroLbl"
	position="last"  >


<!-- widget tfDatiAnagraficiCCIAANumero -->
<s:textfield 
	
title=""	
	name="appDataanagraficaAziendale.numeroCCIAA" id="widg_tfDatiAnagraficiCCIAANumero"
maxlength="15"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiCCIAANumero')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiIscrizioneCCIAA --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiAnagraficiIscrizioneCCIAA --></div>
