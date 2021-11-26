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

	
	<div id="p_fpAttrezzatureMezziDiTrasporto" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMezziDiTrasporto -->
		
	
<div class="formPanel" id="fpAttrezzatureMezziDiTrasporto">


	
	

	
	
			
	
	<div id="p_wpElencoMezziDiTrasporto" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMezziDiTrasporto -->
	
	

<div class="widgetsPanel" id="wpElencoMezziDiTrasporto">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMezziDiTrasporto')" >

	
<div class="tableWidget">


<!-- widget tblMezziDiTrasporto -->
<s:set name="CpDomanda_tblMezziDiTrasporto_clearStatus" value="isTableClearStatus('CpDomanda_tblMezziDiTrasporto')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMezziDiTrasporto"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMezziDiTrasporto"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMezziDiTrasporto_clearStatus}"
               uid="row_tblMezziDiTrasporto"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMezziDiTrasportoCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMezziDiTrasporto.idTipoMacchinaMezzo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMezziDiTrasporto['+(#attr.row_tblMezziDiTrasporto_rowNum - 1)+'].idTipoMacchinaMezzo'}" headerKey="" headerValue=""  list= "appDataelencoMezziDiTrasporto[(#attr.row_tblMezziDiTrasporto_rowNum - 1)].elencoTipoMacchinaMezzo"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMezziDiTrasporto.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMezziDiTrasporto['+(#attr.row_tblMezziDiTrasporto_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMezziDiTrasporto.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMezziDiTrasporto['+(#attr.row_tblMezziDiTrasporto_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMezziDiTrasporto.portata.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMezziDiTrasporto['+(#attr.row_tblMezziDiTrasporto_rowNum - 1)+'].portata'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMezziDiTrasporto.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMezziDiTrasporto['+(#attr.row_tblMezziDiTrasporto_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMezziDiTrasporto[(#attr.row_tblMezziDiTrasporto_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMezziDiTrasporto.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMezziDiTrasporto --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMezziDiTrasporto" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMezziDiTrasporto -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMezziDiTrasporto">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMezziDiTrasporto')" >

	



<!-- widget btnAddAttrezzaturaMezziDiTrasporto -->
<s:submit name="widg_btnAddAttrezzaturaMezziDiTrasporto" id="widg_btnAddAttrezzaturaMezziDiTrasporto" method="handleBtnAddAttrezzaturaMezziDiTrasporto_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMezziDiTrasporto.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMezziDiTrasporto')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMezziDiTrasporto --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMezziDiTrasporto --></div>
