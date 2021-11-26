#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo" class="formPanelBlock"><!-- startFragment:p_fpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo -->
		
	
<div class="formPanel" id="fpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo">


	
	

	
	
			
	
	<div id="p_wpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo.label" /> </h4>
<div class="widgetsPanel" id="wpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo">
	
	<customtag:widgetsPanel id="wpDatiAnagraficiAnagrafeAziendaleMarcaDaBolloTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		percentCols="25,75">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleNumeroMarcaDaBollo')" >

	
<customtag:widgetsPanelColumn  tooltip="Copiare il numero di 14 cifre presente sopra il codice a barre della marca da bollo" labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAnagrafeAziendaleNumeroMarcaDaBollo.label')}" labelFor="widg_tfDatiAnagraficiAnagrafeAziendaleNumeroMarcaDaBollo" errorFor="appDataanagraficaAziendale.marcaDaBollo" labelId="tfDatiAnagraficiAnagrafeAziendaleNumeroMarcaDaBolloLbl"
	position="first"  >


<!-- widget tfDatiAnagraficiAnagrafeAziendaleNumeroMarcaDaBollo -->
<s:textfield 
	
title="Copiare il numero di 14 cifre presente sopra il codice a barre della marca da bollo"	
	name="appDataanagraficaAziendale.marcaDaBollo" id="widg_tfDatiAnagraficiAnagrafeAziendaleNumeroMarcaDaBollo"
maxlength="14"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleNumeroMarcaDaBollo')"
	size="14" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','ptDatiAnagraficiAnagrafeAziendaleMarcaDaBolloDichiarazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptDatiAnagraficiAnagrafeAziendaleMarcaDaBolloDichiarazione" errorFor="widg_ptDatiAnagraficiAnagrafeAziendaleMarcaDaBolloDichiarazione" labelId="ptDatiAnagraficiAnagrafeAziendaleMarcaDaBolloDichiarazioneLbl"  position="first" >


<!-- widget ptDatiAnagraficiAnagrafeAziendaleMarcaDaBolloDichiarazione -->
<s:text name="CpDomanda.ptDatiAnagraficiAnagrafeAziendaleMarcaDaBolloDichiarazione.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo --></div>
