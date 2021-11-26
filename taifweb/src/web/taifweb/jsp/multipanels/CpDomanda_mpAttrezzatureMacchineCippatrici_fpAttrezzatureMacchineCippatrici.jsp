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

	
	<div id="p_fpAttrezzatureMacchineCippatrici" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchineCippatrici -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchineCippatrici">


	
	

	
	
			
	
	<div id="p_wpElencoMacchineCippatrici" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchineCippatrici -->
	
	

<div class="widgetsPanel" id="wpElencoMacchineCippatrici">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchineCippatrici')" >

	
<div class="tableWidget">


<!-- widget tblMacchineCippatrici -->
<s:set name="CpDomanda_tblMacchineCippatrici_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchineCippatrici')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineCippatrici"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchineCippatrici"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchineCippatrici_clearStatus}"
               uid="row_tblMacchineCippatrici"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchineCippatriciCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchineCippatrici.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineCippatrici['+(#attr.row_tblMacchineCippatrici_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineCippatrici.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineCippatrici['+(#attr.row_tblMacchineCippatrici_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineCippatrici.idTipoAlimentazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineCippatrici['+(#attr.row_tblMacchineCippatrici_rowNum - 1)+'].idTipoAlimentazione'}" headerKey="" headerValue=""  list= "appDataelencoMacchineCippatrici[(#attr.row_tblMacchineCippatrici_rowNum - 1)].elencoTipoAlimentazione"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineCippatrici.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineCippatrici['+(#attr.row_tblMacchineCippatrici_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineCippatrici[(#attr.row_tblMacchineCippatrici_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchineCippatrici.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchineCippatrici --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaCippatrici" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaCippatrici -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaCippatrici">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaCippatrici')" >

	



<!-- widget btnAddAttrezzaturaMacchinaCippatrici -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaCippatrici" id="widg_btnAddAttrezzaturaMacchinaCippatrici" method="handleBtnAddAttrezzaturaMacchinaCippatrici_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaCippatrici.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaCippatrici')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaCippatrici --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchineCippatrici --></div>
