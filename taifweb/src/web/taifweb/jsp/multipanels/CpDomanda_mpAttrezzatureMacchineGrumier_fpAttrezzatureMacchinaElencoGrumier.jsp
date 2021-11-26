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

	
	<div id="p_fpAttrezzatureMacchinaElencoGrumier" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchinaElencoGrumier -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchinaElencoGrumier">


	
	

	
	
			
	
	<div id="p_wpElencoMacchinaGrumier" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchinaGrumier -->
	
	

<div class="widgetsPanel" id="wpElencoMacchinaGrumier">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchinaGrumier')" >

	
<div class="tableWidget">


<!-- widget tblMacchinaGrumier -->
<s:set name="CpDomanda_tblMacchinaGrumier_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchinaGrumier')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineGrumier"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchinaGrumier"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchinaGrumier_clearStatus}"
               uid="row_tblMacchinaGrumier"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchinaGrumierCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchinaGrumier.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineGrumier['+(#attr.row_tblMacchinaGrumier_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaGrumier.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineGrumier['+(#attr.row_tblMacchinaGrumier_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaGrumier.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineGrumier['+(#attr.row_tblMacchinaGrumier_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineGrumier[(#attr.row_tblMacchinaGrumier_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchinaGrumier.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchinaGrumier --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaGrumier" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaGrumier -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaGrumier">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaGrumier')" >

	



<!-- widget btnAddAttrezzaturaMacchinaGrumier -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaGrumier" id="widg_btnAddAttrezzaturaMacchinaGrumier" method="handleBtnAddAttrezzaturaMacchinaGrumier_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaGrumier.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaGrumier')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaGrumier --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchinaElencoGrumier --></div>
