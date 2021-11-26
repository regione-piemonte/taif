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

	
	<div id="p_fpAttrezzatureMacchinaElencoTrinciaForestale" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchinaElencoTrinciaForestale -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchinaElencoTrinciaForestale">


	
	

	
	
			
	
	<div id="p_wpElencoMacchinaTrinciaForestale" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchinaTrinciaForestale -->
	
	

<div class="widgetsPanel" id="wpElencoMacchinaTrinciaForestale">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchinaTrinciaForestale')" >

	
<div class="tableWidget">


<!-- widget tblMacchinaTrinciaForestale -->
<s:set name="CpDomanda_tblMacchinaTrinciaForestale_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchinaTrinciaForestale')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineTrinciaForestali"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchinaTrinciaForestale"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchinaTrinciaForestale_clearStatus}"
               uid="row_tblMacchinaTrinciaForestale"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchinaTrinciaForestaleCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchinaTrinciaForestale.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineTrinciaForestali['+(#attr.row_tblMacchinaTrinciaForestale_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaTrinciaForestale.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineTrinciaForestali['+(#attr.row_tblMacchinaTrinciaForestale_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaTrinciaForestale.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineTrinciaForestali['+(#attr.row_tblMacchinaTrinciaForestale_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineTrinciaForestali[(#attr.row_tblMacchinaTrinciaForestale_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchinaTrinciaForestale.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchinaTrinciaForestale --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaTrinciaForestale" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaTrinciaForestale -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaTrinciaForestale">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaTrinciaForestale')" >

	



<!-- widget btnAddAttrezzaturaMacchinaTrinciaForestale -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaTrinciaForestale" id="widg_btnAddAttrezzaturaMacchinaTrinciaForestale" method="handleBtnAddAttrezzaturaMacchinaTrinciaForestale_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaTrinciaForestale.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaTrinciaForestale')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaTrinciaForestale --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchinaElencoTrinciaForestale --></div>
