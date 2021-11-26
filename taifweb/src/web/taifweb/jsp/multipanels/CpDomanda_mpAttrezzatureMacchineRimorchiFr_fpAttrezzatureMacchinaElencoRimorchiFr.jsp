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

	
	<div id="p_fpAttrezzatureMacchinaElencoRimorchiFr" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchinaElencoRimorchiFr -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchinaElencoRimorchiFr">


	
	

	
	
			
	
	<div id="p_wpElencoMacchinaRimorchiFr" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchinaRimorchiFr -->
	
	

<div class="widgetsPanel" id="wpElencoMacchinaRimorchiFr">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchinaRimorchiFr')" >

	
<div class="tableWidget">


<!-- widget tblMacchinaRimorchiFr -->
<s:set name="CpDomanda_tblMacchinaRimorchiFr_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchinaRimorchiFr')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineRimorchiFr"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchinaRimorchiFr"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchinaRimorchiFr_clearStatus}"
               uid="row_tblMacchinaRimorchiFr"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchinaRimorchiFrCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchinaRimorchiFr.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineRimorchiFr['+(#attr.row_tblMacchinaRimorchiFr_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaRimorchiFr.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineRimorchiFr['+(#attr.row_tblMacchinaRimorchiFr_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaRimorchiFr.idTipoTrazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineRimorchiFr['+(#attr.row_tblMacchinaRimorchiFr_rowNum - 1)+'].idTipoTrazione'}" headerKey="" headerValue=""  list= "appDataelencoMacchineRimorchiFr[(#attr.row_tblMacchinaRimorchiFr_rowNum - 1)].elencoTipoTrazione"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaRimorchiFr.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineRimorchiFr['+(#attr.row_tblMacchinaRimorchiFr_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineRimorchiFr[(#attr.row_tblMacchinaRimorchiFr_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchinaRimorchiFr.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchinaRimorchiFr --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaRimorchiFr" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaRimorchiFr -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaRimorchiFr">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaRimorchiFr')" >

	



<!-- widget btnAddAttrezzaturaMacchinaRimorchiFr -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaRimorchiFr" id="widg_btnAddAttrezzaturaMacchinaRimorchiFr" method="handleBtnAddAttrezzaturaMacchinaRimorchiFr_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaRimorchiFr.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaRimorchiFr')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaRimorchiFr --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchinaElencoRimorchiFr --></div>
