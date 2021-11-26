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

	
	<div id="p_fpAttivitaFr" class="formPanelBlock"><!-- startFragment:p_fpAttivitaFr -->
		
	
<div class="formPanel" id="fpAttivitaFr">


	
	

	
	
			
	
	<div id="p_wpAttivitaUFr" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUFr -->
	
	

<div class="widgetsPanel" id="wpAttivitaUFr">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblAttivitaFr')" >

	
<div class="tableWidget">


<!-- widget tblAttivitaFr -->
<s:set name="CpDomanda_tblAttivitaFr_clearStatus" value="isTableClearStatus('CpDomanda_tblAttivitaFr')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoAttivitaUltimoAnnoFr"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAttivitaFr"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblAttivitaFr_clearStatus}"
               uid="row_tblAttivitaFr"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tblAttivitaFr.idAttivita}" name="appDataidAttivitaUltimoAnnoFr" id="%{'tblAttivitaFr-editcell-'+ (#attr.row_tblAttivitaFr_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="descrizione" titleKey="CpDomanda.tblAttivitaFr.descrizione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column titleKey="CpDomanda.tblAttivitaFr.volume.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAttivitaUltimoAnnoFr['+(#attr.row_tblAttivitaFr_rowNum - 1)+'].volume'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAttivitaFr.percentuale.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAttivitaUltimoAnnoFr['+(#attr.row_tblAttivitaFr_rowNum - 1)+'].percentuale'}"   theme="csi-tableinput-rem" />
		</display:column>
		
</display:table>

<s:hidden name="__tableselectionempty_appDataidAttivitaUltimoAnnoFr" id="__tableselectionempty_widg_tblAttivitaFr" />




	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAttivitaUFr --></div>

			
	
	<div id="p_wpClientiFr" class="widgetsPanelBlock"><!-- startFragment:p_wpClientiFr -->
	
	

<div class="widgetsPanel" id="wpClientiFr">
	
	<customtag:widgetsPanel id="wpClientiFrTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfClientiFr1')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfClientiFr1.label')}" labelFor="widg_tfClientiFr1" errorFor="appDatagestioneAttivitaUltimoAnno.attivitaFr.cliente1Fr" labelId="tfClientiFr1Lbl"
	  >


<!-- widget tfClientiFr1 -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivitaFr.cliente1Fr" id="widg_tfClientiFr1"
maxlength="40"	disabled="isWidgetDisabled('CpDomanda','tfClientiFr1')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','tfClientiFr2')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfClientiFr2.label')}" labelFor="widg_tfClientiFr2" errorFor="appDatagestioneAttivitaUltimoAnno.attivitaFr.cliente2Fr" labelId="tfClientiFr2Lbl"
	  >


<!-- widget tfClientiFr2 -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivitaFr.cliente2Fr" id="widg_tfClientiFr2"
maxlength="40"	disabled="isWidgetDisabled('CpDomanda','tfClientiFr2')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','tfClientiFr3')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfClientiFr3.label')}" labelFor="widg_tfClientiFr3" errorFor="appDatagestioneAttivitaUltimoAnno.attivitaFr.cliente3Fr" labelId="tfClientiFr3Lbl"
	  >


<!-- widget tfClientiFr3 -->
<s:textfield 
	
	
	name="appDatagestioneAttivitaUltimoAnno.attivitaFr.cliente3Fr" id="widg_tfClientiFr3"
maxlength="40"	disabled="isWidgetDisabled('CpDomanda','tfClientiFr3')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpClientiFr --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttivitaFr --></div>
