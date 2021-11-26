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

	
	<div id="p_fpAltroPersonaleFr" class="formPanelBlock"><!-- startFragment:p_fpAltroPersonaleFr -->
		
	
<div class="formPanel" id="fpAltroPersonaleFr">


	
	

	
	
			
	
	<div id="p_wpAltroPersonaleFr" class="widgetsPanelBlock"><!-- startFragment:p_wpAltroPersonaleFr -->
	
	

<div class="widgetsPanel" id="wpAltroPersonaleFr">
	
	<customtag:widgetsPanel id="wpAltroPersonaleFrTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfAltroPersonaleNbreDeSalaries')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAltroPersonaleNbreDeSalaries.label')}" labelFor="widg_tfAltroPersonaleNbreDeSalaries" errorFor="appDatagestioneAltroPersonaleFr.numeroTotaleAddetti" labelId="tfAltroPersonaleNbreDeSalariesLbl"
	  >


<!-- widget tfAltroPersonaleNbreDeSalaries -->
<s:textfield 
	
	
	name="appDatagestioneAltroPersonaleFr.numeroTotaleAddetti" id="widg_tfAltroPersonaleNbreDeSalaries"
maxlength="6"	disabled="isWidgetDisabled('CpDomanda','tfAltroPersonaleNbreDeSalaries')"
	size="6" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','tfAltroPersonaleEquivalentTempsPlein')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfAltroPersonaleEquivalentTempsPlein.label')}" labelFor="widg_tfAltroPersonaleEquivalentTempsPlein" errorFor="appDatagestioneAltroPersonaleFr.numeroEquivalenti" labelId="tfAltroPersonaleEquivalentTempsPleinLbl"
	  >


<!-- widget tfAltroPersonaleEquivalentTempsPlein -->
<s:textfield 
	
	
	name="appDatagestioneAltroPersonaleFr.numeroEquivalenti" id="widg_tfAltroPersonaleEquivalentTempsPlein"
maxlength="6"	disabled="isWidgetDisabled('CpDomanda','tfAltroPersonaleEquivalentTempsPlein')"
	size="6" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAltroPersonaleFr --></div>

			
	
	<div id="p_wpAltroPersonaleTipoContrattoFr" class="widgetsPanelBlock"><!-- startFragment:p_wpAltroPersonaleTipoContrattoFr -->
	
	

<div class="widgetsPanel" id="wpAltroPersonaleTipoContrattoFr">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblAltroPersonaleTipoContrattoFr')" >

	
<div class="tableWidget">


<!-- widget tblAltroPersonaleTipoContrattoFr -->
<s:set name="CpDomanda_tblAltroPersonaleTipoContrattoFr_clearStatus" value="isTableClearStatus('CpDomanda_tblAltroPersonaleTipoContrattoFr')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoAltroPersonaleTipoContrattoFr"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAltroPersonaleTipoContrattoFr"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblAltroPersonaleTipoContrattoFr_clearStatus}"
               uid="row_tblAltroPersonaleTipoContrattoFr"
               summary="" 
               class="dataTable">
	
		<display:column property="dsTipologia" titleKey="CpDomanda.tblAltroPersonaleTipoContrattoFr.dsTipologia.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column titleKey="CpDomanda.tblAltroPersonaleTipoContrattoFr.numeroAddetti.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAltroPersonaleTipoContrattoFr['+(#attr.row_tblAltroPersonaleTipoContrattoFr_rowNum - 1)+'].numeroAddetti'}"   theme="csi-tableinput-rem" maxlength="3" />
		</display:column>
		
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAltroPersonaleTipoContrattoFr --></div>

			
	
	<div id="p_wpAltroPersonaleTipoMansioneFr" class="widgetsPanelBlock"><!-- startFragment:p_wpAltroPersonaleTipoMansioneFr -->
	
	

<div class="widgetsPanel" id="wpAltroPersonaleTipoMansioneFr">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblAltroPersonaleTipoMansioneFr')" >

	
<div class="tableWidget">


<!-- widget tblAltroPersonaleTipoMansioneFr -->
<s:set name="CpDomanda_tblAltroPersonaleTipoMansioneFr_clearStatus" value="isTableClearStatus('CpDomanda_tblAltroPersonaleTipoMansioneFr')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoAltroPersonaleTipoMansioneFr"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAltroPersonaleTipoMansioneFr"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblAltroPersonaleTipoMansioneFr_clearStatus}"
               uid="row_tblAltroPersonaleTipoMansioneFr"
               summary="" 
               class="dataTable">
	
		<display:column property="dsTipologia" titleKey="CpDomanda.tblAltroPersonaleTipoMansioneFr.dsTipologia.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column titleKey="CpDomanda.tblAltroPersonaleTipoMansioneFr.numeroAddetti.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAltroPersonaleTipoMansioneFr['+(#attr.row_tblAltroPersonaleTipoMansioneFr_rowNum - 1)+'].numeroAddetti'}"   theme="csi-tableinput-rem" maxlength="3" />
		</display:column>
		
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAltroPersonaleTipoMansioneFr --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAltroPersonaleFr --></div>
