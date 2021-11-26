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

	
	<div id="p_fpAttrezzatureMacchineSegherieMobili" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchineSegherieMobili -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchineSegherieMobili">


	
	

	
	
			
	
	<div id="p_wpElencoMacchineSegherieMobili" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchineSegherieMobili -->
	
	

<div class="widgetsPanel" id="wpElencoMacchineSegherieMobili">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchineSegherieMobili')" >

	
<div class="tableWidget">


<!-- widget tblMacchineSegherieMobili -->
<s:set name="CpDomanda_tblMacchineSegherieMobili_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchineSegherieMobili')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineSegheriaMobile"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchineSegherieMobili"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchineSegherieMobili_clearStatus}"
               uid="row_tblMacchineSegherieMobili"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchineSegherieMobiliCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchineSegherieMobili.idTipoMacchinaMezzo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineSegheriaMobile['+(#attr.row_tblMacchineSegherieMobili_rowNum - 1)+'].idTipoMacchinaMezzo'}" headerKey="" headerValue=""  list= "appDataelencoMacchineSegheriaMobile[(#attr.row_tblMacchineSegherieMobili_rowNum - 1)].elencoTipoMacchinaMezzo"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineSegherieMobili.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineSegheriaMobile['+(#attr.row_tblMacchineSegherieMobili_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineSegherieMobili.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineSegheriaMobile['+(#attr.row_tblMacchineSegherieMobili_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineSegherieMobili.idTipoAlimentazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineSegheriaMobile['+(#attr.row_tblMacchineSegherieMobili_rowNum - 1)+'].idTipoAlimentazione'}" headerKey="" headerValue=""  list= "appDataelencoMacchineSegheriaMobile[(#attr.row_tblMacchineSegherieMobili_rowNum - 1)].elencoTipoAlimentazione"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineSegherieMobili.comandatoADistanza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:checkbox name="%{'appDataelencoMacchineSegheriaMobile['+(#attr.row_tblMacchineSegherieMobili_rowNum - 1)+'].comandatoADistanza'}"   id="%{'widg_tblMacchineSegherieMobili_comandatoADistanza_'+(#attr.row_tblMacchineSegherieMobili_rowNum - 1)}"  theme="csi-tableinput-rem"/>
<s:hidden name="%{'__checkbox_appDataelencoMacchineSegheriaMobile['+(#attr.row_tblMacchineSegherieMobili_rowNum - 1)+'].comandatoADistanza'}" id="%{'__checkbox_widg_tblMacchineSegherieMobili_comandatoADistanza_'+(#attr.row_tblMacchineSegherieMobili_rowNum - 1)}" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineSegherieMobili.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineSegheriaMobile['+(#attr.row_tblMacchineSegherieMobili_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineSegheriaMobile[(#attr.row_tblMacchineSegherieMobili_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchineSegherieMobili.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchineSegherieMobili --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaSegherieMobili" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaSegherieMobili -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaSegherieMobili">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaSegherieMobili')" >

	



<!-- widget btnAddAttrezzaturaMacchinaSegherieMobili -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaSegherieMobili" id="widg_btnAddAttrezzaturaMacchinaSegherieMobili" method="handleBtnAddAttrezzaturaMacchinaSegherieMobili_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaSegherieMobili.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaSegherieMobili')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaSegherieMobili --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchineSegherieMobili --></div>
