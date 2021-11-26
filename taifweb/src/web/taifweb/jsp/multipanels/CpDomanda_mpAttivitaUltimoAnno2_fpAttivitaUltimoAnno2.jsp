#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAttivitaUltimoAnno2" class="formPanelBlock"><!-- startFragment:p_fpAttivitaUltimoAnno2 -->
		
	
<div class="formPanel" id="fpAttivitaUltimoAnno2">


	
	

	
	
			
	
	<div id="p_wpAttivitaUltimoAnno2" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno2 -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno2">
	
	<customtag:widgetsPanel id="wpAttivitaUltimoAnno2Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfAttivitaUltimoAnnoEttariRealizzati')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAttivitaUltimoAnnoEttariRealizzati.label')}" labelFor="widg_tfAttivitaUltimoAnnoEttariRealizzati" errorFor="appDatagestioneAttivitaUltimoAnno.attivita2.ettariRealizzati" labelId="tfAttivitaUltimoAnnoEttariRealizzatiLbl"
	  >


<!-- widget tfAttivitaUltimoAnnoEttariRealizzati -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivita2.ettariRealizzati" id="widg_tfAttivitaUltimoAnnoEttariRealizzati"
maxlength="20"	disabled="isWidgetDisabled('CpDomanda','tfAttivitaUltimoAnnoEttariRealizzati')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno2 --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttivitaUltimoAnno2 --></div>
