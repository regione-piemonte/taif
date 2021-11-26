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

	
	<div id="p_fpAttrezzatureMacchineSpeciali" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchineSpeciali -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchineSpeciali">


	
	

	
	
			
	
	<div id="p_wpElencoMacchineSpeciali" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchineSpeciali -->
	
	

<div class="widgetsPanel" id="wpElencoMacchineSpeciali">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchineSpeciali')" >

	
<div class="tableWidget">


<!-- widget tblMacchineSpeciali -->
<s:set name="CpDomanda_tblMacchineSpeciali_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchineSpeciali')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineSpeciali"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchineSpeciali"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchineSpeciali_clearStatus}"
               uid="row_tblMacchineSpeciali"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchineSpecialiCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchineSpeciali.idTipoMacchinaMezzo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineSpeciali['+(#attr.row_tblMacchineSpeciali_rowNum - 1)+'].idTipoMacchinaMezzo'}" headerKey="" headerValue=""  list= "appDataelencoMacchineSpeciali[(#attr.row_tblMacchineSpeciali_rowNum - 1)].elencoTipoMacchinaMezzo"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineSpeciali.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineSpeciali['+(#attr.row_tblMacchineSpeciali_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineSpeciali.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineSpeciali['+(#attr.row_tblMacchineSpeciali_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineSpeciali.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineSpeciali['+(#attr.row_tblMacchineSpeciali_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineSpeciali[(#attr.row_tblMacchineSpeciali_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchineSpeciali.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchineSpeciali --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaSpeciale" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaSpeciale -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaSpeciale">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaSpeciale')" >

	



<!-- widget btnAddAttrezzaturaMacchinaSpeciale -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaSpeciale" id="widg_btnAddAttrezzaturaMacchinaSpeciale" method="handleBtnAddAttrezzaturaMacchinaSpeciale_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaSpeciale.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaSpeciale')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaSpeciale --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchineSpeciali --></div>
