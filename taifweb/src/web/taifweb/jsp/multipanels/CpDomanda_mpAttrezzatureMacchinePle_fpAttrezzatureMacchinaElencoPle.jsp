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

	
	<div id="p_fpAttrezzatureMacchinaElencoPle" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchinaElencoPle -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchinaElencoPle">


	
	

	
	
			
	
	<div id="p_wpElencoMacchinaPle" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchinaPle -->
	
	

<div class="widgetsPanel" id="wpElencoMacchinaPle">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchinaPle')" >

	
<div class="tableWidget">


<!-- widget tblMacchinaPle -->
<s:set name="CpDomanda_tblMacchinaPle_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchinaPle')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchinePle"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchinaPle"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchinaPle_clearStatus}"
               uid="row_tblMacchinaPle"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchinaPleCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchinaPle.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchinePle['+(#attr.row_tblMacchinaPle_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaPle.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchinePle['+(#attr.row_tblMacchinaPle_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaPle.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchinePle['+(#attr.row_tblMacchinaPle_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchinePle[(#attr.row_tblMacchinaPle_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchinaPle.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchinaPle --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaPle" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaPle -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaPle">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaPle')" >

	



<!-- widget btnAddAttrezzaturaMacchinaPle -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaPle" id="widg_btnAddAttrezzaturaMacchinaPle" method="handleBtnAddAttrezzaturaMacchinaPle_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaPle.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaPle')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaPle --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchinaElencoPle --></div>
