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

	
	<div id="p_fpAttrezzatureMacchineMovimentoATerra" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchineMovimentoATerra -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchineMovimentoATerra">


	
	

	
	
			
	
	<div id="p_wpElencoMacchineMovimentoATerra" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchineMovimentoATerra -->
	
	

<div class="widgetsPanel" id="wpElencoMacchineMovimentoATerra">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchineMovimentoATerra')" >

	
<div class="tableWidget">


<!-- widget tblMacchineMovimentoATerra -->
<s:set name="CpDomanda_tblMacchineMovimentoATerra_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchineMovimentoATerra')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineMovimentoTerra"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchineMovimentoATerra"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchineMovimentoATerra_clearStatus}"
               uid="row_tblMacchineMovimentoATerra"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchineMovimentoATerraCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchineMovimentoATerra.idTipoMacchinaMezzo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineMovimentoTerra['+(#attr.row_tblMacchineMovimentoATerra_rowNum - 1)+'].idTipoMacchinaMezzo'}" headerKey="" headerValue=""  list= "appDataelencoMacchineMovimentoTerra[(#attr.row_tblMacchineMovimentoATerra_rowNum - 1)].elencoTipoMacchinaMezzo"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineMovimentoATerra.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineMovimentoTerra['+(#attr.row_tblMacchineMovimentoATerra_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineMovimentoATerra.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineMovimentoTerra['+(#attr.row_tblMacchineMovimentoATerra_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineMovimentoATerra.idTipoTrazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineMovimentoTerra['+(#attr.row_tblMacchineMovimentoATerra_rowNum - 1)+'].idTipoTrazione'}" headerKey="" headerValue=""  list= "appDataelencoMacchineMovimentoTerra[(#attr.row_tblMacchineMovimentoATerra_rowNum - 1)].elencoTipoTrazione"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineMovimentoATerra.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineMovimentoTerra['+(#attr.row_tblMacchineMovimentoATerra_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineMovimentoTerra[(#attr.row_tblMacchineMovimentoATerra_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchineMovimentoATerra.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchineMovimentoATerra --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaMovimentoATerra" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaMovimentoATerra -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaMovimentoATerra">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaMovimentoATerra')" >

	



<!-- widget btnAddAttrezzaturaMacchinaMovimentoATerra -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaMovimentoATerra" id="widg_btnAddAttrezzaturaMacchinaMovimentoATerra" method="handleBtnAddAttrezzaturaMacchinaMovimentoATerra_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaMovimentoATerra.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaMovimentoATerra')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaMovimentoATerra --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchineMovimentoATerra --></div>
