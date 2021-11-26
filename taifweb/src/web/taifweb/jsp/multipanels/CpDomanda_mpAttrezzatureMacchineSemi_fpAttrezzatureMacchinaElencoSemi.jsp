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

	
	<div id="p_fpAttrezzatureMacchinaElencoSemi" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchinaElencoSemi -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchinaElencoSemi">


	
	

	
	
			
	
	<div id="p_wpElencoMacchinaSemi" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchinaSemi -->
	
	

<div class="widgetsPanel" id="wpElencoMacchinaSemi">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchinaSemi')" >

	
<div class="tableWidget">


<!-- widget tblMacchinaSemi -->
<s:set name="CpDomanda_tblMacchinaSemi_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchinaSemi')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineSemi"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchinaSemi"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchinaSemi_clearStatus}"
               uid="row_tblMacchinaSemi"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchinaSemiCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchinaSemi.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineSemi['+(#attr.row_tblMacchinaSemi_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaSemi.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineSemi['+(#attr.row_tblMacchinaSemi_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaSemi.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineSemi['+(#attr.row_tblMacchinaSemi_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineSemi[(#attr.row_tblMacchinaSemi_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchinaSemi.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchinaSemi --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaSemi" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaSemi -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaSemi">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaSemi')" >

	



<!-- widget btnAddAttrezzaturaMacchinaSemi -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaSemi" id="widg_btnAddAttrezzaturaMacchinaSemi" method="handleBtnAddAttrezzaturaMacchinaSemi_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaSemi.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaSemi')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaSemi --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchinaElencoSemi --></div>
