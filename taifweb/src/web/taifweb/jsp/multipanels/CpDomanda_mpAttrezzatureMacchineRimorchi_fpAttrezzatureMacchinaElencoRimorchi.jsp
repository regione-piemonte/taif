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

	
	<div id="p_fpAttrezzatureMacchinaElencoRimorchi" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchinaElencoRimorchi -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchinaElencoRimorchi">


	
	

	
	
			
	
	<div id="p_wpElencoMacchinaRimorchi" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchinaRimorchi -->
	
	

<div class="widgetsPanel" id="wpElencoMacchinaRimorchi">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchinaRimorchi')" >

	
<div class="tableWidget">


<!-- widget tblMacchinaRimorchi -->
<s:set name="CpDomanda_tblMacchinaRimorchi_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchinaRimorchi')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineRimorchi"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchinaRimorchi"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchinaRimorchi_clearStatus}"
               uid="row_tblMacchinaRimorchi"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchinaRimorchiCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchinaRimorchi.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineRimorchi['+(#attr.row_tblMacchinaRimorchi_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaRimorchi.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineRimorchi['+(#attr.row_tblMacchinaRimorchi_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaRimorchi.idTipoTrazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineRimorchi['+(#attr.row_tblMacchinaRimorchi_rowNum - 1)+'].idTipoTrazione'}" headerKey="" headerValue=""  list= "appDataelencoMacchineRimorchi[(#attr.row_tblMacchinaRimorchi_rowNum - 1)].elencoTipoTrazione"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaRimorchi.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineRimorchi['+(#attr.row_tblMacchinaRimorchi_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineRimorchi[(#attr.row_tblMacchinaRimorchi_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchinaRimorchi.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchinaRimorchi --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaRimorchi" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaRimorchi -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaRimorchi">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaRimorchi')" >

	



<!-- widget btnAddAttrezzaturaMacchinaRimorchi -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaRimorchi" id="widg_btnAddAttrezzaturaMacchinaRimorchi" method="handleBtnAddAttrezzaturaMacchinaRimorchi_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaRimorchi.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaRimorchi')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaRimorchi --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchinaElencoRimorchi --></div>
