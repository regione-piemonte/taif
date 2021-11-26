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

	
	<div id="p_fpAttrezzatureMacchineMovimentoATerraFr" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchineMovimentoATerraFr -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchineMovimentoATerraFr">


	
	

	
	
			
	
	<div id="p_wpElencoMacchineMovimentoATerraFr" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchineMovimentoATerraFr -->
	
	

<div class="widgetsPanel" id="wpElencoMacchineMovimentoATerraFr">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchineMovimentoATerraFr')" >

	
<div class="tableWidget">


<!-- widget tblMacchineMovimentoATerraFr -->
<s:set name="CpDomanda_tblMacchineMovimentoATerraFr_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchineMovimentoATerraFr')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineMovimentoTerraFr"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchineMovimentoATerraFr"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchineMovimentoATerraFr_clearStatus}"
               uid="row_tblMacchineMovimentoATerraFr"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchineMovimentoATerraFrCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchineMovimentoATerraFr.idTipoMacchinaMezzo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineMovimentoTerraFr['+(#attr.row_tblMacchineMovimentoATerraFr_rowNum - 1)+'].idTipoMacchinaMezzo'}" headerKey="" headerValue=""  list= "appDataelencoMacchineMovimentoTerraFr[(#attr.row_tblMacchineMovimentoATerraFr_rowNum - 1)].elencoTipoMacchinaMezzo"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineMovimentoATerraFr.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineMovimentoTerraFr['+(#attr.row_tblMacchineMovimentoATerraFr_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineMovimentoATerraFr.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineMovimentoTerraFr['+(#attr.row_tblMacchineMovimentoATerraFr_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineMovimentoATerraFr.idTipoTrazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineMovimentoTerraFr['+(#attr.row_tblMacchineMovimentoATerraFr_rowNum - 1)+'].idTipoTrazione'}" headerKey="" headerValue=""  list= "appDataelencoMacchineMovimentoTerraFr[(#attr.row_tblMacchineMovimentoATerraFr_rowNum - 1)].elencoTipoTrazione"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineMovimentoATerraFr.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineMovimentoTerraFr['+(#attr.row_tblMacchineMovimentoATerraFr_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineMovimentoTerraFr[(#attr.row_tblMacchineMovimentoATerraFr_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchineMovimentoATerraFr.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchineMovimentoATerraFr --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaMovimentoATerraFr" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaMovimentoATerraFr -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaMovimentoATerraFr">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaMovimentoATerraFr')" >

	



<!-- widget btnAddAttrezzaturaMacchinaMovimentoATerraFr -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaMovimentoATerraFr" id="widg_btnAddAttrezzaturaMacchinaMovimentoATerraFr" method="handleBtnAddAttrezzaturaMacchinaMovimentoATerraFr_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaMovimentoATerraFr.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaMovimentoATerraFr')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaMovimentoATerraFr --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchineMovimentoATerraFr --></div>
