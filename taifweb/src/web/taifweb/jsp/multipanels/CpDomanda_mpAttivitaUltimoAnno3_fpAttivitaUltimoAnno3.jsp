#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAttivitaUltimoAnno3" class="formPanelBlock"><!-- startFragment:p_fpAttivitaUltimoAnno3 -->
		
	
<div class="formPanel" id="fpAttivitaUltimoAnno3">


	
	

	
	
			
	
	<div id="p_wpAttivitaUltimoAnno3" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno3 -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno3">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno3Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno3Realizzazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno3Realizzazione.label')}" labelFor="widg_tfAttivitaUltimoAnno3Realizzazione" errorFor="appDatagestioneAttivitaUltimoAnno.attivita3.realizzazione" labelId="tfAttivitaUltimoAnno3RealizzazioneLbl"
	  >


<!-- widget tfAttivitaUltimoAnno3Realizzazione -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita3.realizzazione" id="widg_tfAttivitaUltimoAnno3Realizzazione"
maxlength="20"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno3Realizzazione')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnno3Manutenzione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnno3Manutenzione.label')}" labelFor="widg_tfAttivitaUltimoAnno3Manutenzione" errorFor="appDatagestioneAttivitaUltimoAnno.attivita3.manutenzione" labelId="tfAttivitaUltimoAnno3ManutenzioneLbl"
	  >


<!-- widget tfAttivitaUltimoAnno3Manutenzione -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita3.manutenzione" id="widg_tfAttivitaUltimoAnno3Manutenzione"
maxlength="20"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnno3Manutenzione')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno3 --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttivitaUltimoAnno3 --></div>
