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

	
	<div id="p_fpAttrezzatureMacchinaElencoTrattrici" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchinaElencoTrattrici -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchinaElencoTrattrici">


	
	

	
	
			
	
	<div id="p_wpElencoMacchinaTrattrici" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchinaTrattrici -->
	
	

<div class="widgetsPanel" id="wpElencoMacchinaTrattrici">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchinaTrattrici')" >

	
<div class="tableWidget">


<!-- widget tblMacchinaTrattrici -->
<s:set name="CpDomanda_tblMacchinaTrattrici_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchinaTrattrici')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineTrattrici"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchinaTrattrici"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchinaTrattrici_clearStatus}"
               uid="row_tblMacchinaTrattrici"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchinaTrattriciCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchinaTrattrici.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineTrattrici['+(#attr.row_tblMacchinaTrattrici_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaTrattrici.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineTrattrici['+(#attr.row_tblMacchinaTrattrici_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaTrattrici.idTipoTrazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineTrattrici['+(#attr.row_tblMacchinaTrattrici_rowNum - 1)+'].idTipoTrazione'}" headerKey="" headerValue=""  list= "appDataelencoMacchineTrattrici[(#attr.row_tblMacchinaTrattrici_rowNum - 1)].elencoTipoTrazione"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaTrattrici.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineTrattrici['+(#attr.row_tblMacchinaTrattrici_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineTrattrici[(#attr.row_tblMacchinaTrattrici_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchinaTrattrici.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchinaTrattrici --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaTrattrice" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaTrattrice -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaTrattrice">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaTrattrice')" >

	



<!-- widget btnAddAttrezzaturaMacchinaTrattrice -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaTrattrice" id="widg_btnAddAttrezzaturaMacchinaTrattrice" method="handleBtnAddAttrezzaturaMacchinaTrattrice_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaTrattrice.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaTrattrice')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaTrattrice --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchinaElencoTrattrici --></div>
