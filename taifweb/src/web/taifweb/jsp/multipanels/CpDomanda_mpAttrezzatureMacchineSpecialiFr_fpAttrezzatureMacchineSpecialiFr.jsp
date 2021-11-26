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

	
	<div id="p_fpAttrezzatureMacchineSpecialiFr" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchineSpecialiFr -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchineSpecialiFr">


	
	

	
	
			
	
	<div id="p_wpElencoMacchineSpecialiFr" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchineSpecialiFr -->
	
	

<div class="widgetsPanel" id="wpElencoMacchineSpecialiFr">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchineSpecialiFr')" >

	
<div class="tableWidget">


<!-- widget tblMacchineSpecialiFr -->
<s:set name="CpDomanda_tblMacchineSpecialiFr_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchineSpecialiFr')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineSpecialiFr"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchineSpecialiFr"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchineSpecialiFr_clearStatus}"
               uid="row_tblMacchineSpecialiFr"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchineSpecialiFrCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchineSpecialiFr.idTipoMacchinaMezzo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineSpecialiFr['+(#attr.row_tblMacchineSpecialiFr_rowNum - 1)+'].idTipoMacchinaMezzo'}" headerKey="" headerValue=""  list= "appDataelencoMacchineSpecialiFr[(#attr.row_tblMacchineSpecialiFr_rowNum - 1)].elencoTipoMacchinaMezzo"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineSpecialiFr.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineSpecialiFr['+(#attr.row_tblMacchineSpecialiFr_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineSpecialiFr.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineSpecialiFr['+(#attr.row_tblMacchineSpecialiFr_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineSpecialiFr.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineSpecialiFr['+(#attr.row_tblMacchineSpecialiFr_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineSpecialiFr[(#attr.row_tblMacchineSpecialiFr_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchineSpecialiFr.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchineSpecialiFr --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaSpecialeFr" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaSpecialeFr -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaSpecialeFr">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaSpecialeFr')" >

	



<!-- widget btnAddAttrezzaturaMacchinaSpecialeFr -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaSpecialeFr" id="widg_btnAddAttrezzaturaMacchinaSpecialeFr" method="handleBtnAddAttrezzaturaMacchinaSpecialeFr_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaSpecialeFr.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaSpecialeFr')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaSpecialeFr --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchineSpecialiFr --></div>
