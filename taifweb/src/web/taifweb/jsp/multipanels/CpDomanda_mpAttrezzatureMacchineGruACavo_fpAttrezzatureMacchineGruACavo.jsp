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

	
	<div id="p_fpAttrezzatureMacchineGruACavo" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchineGruACavo -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchineGruACavo">


	
	

	
	
			
	
	<div id="p_wpElencoMacchineGruACavo" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchineGruACavo -->
	
	

<div class="widgetsPanel" id="wpElencoMacchineGruACavo">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchineGruACavo')" >

	
<div class="tableWidget">


<!-- widget tblMacchineGruACavo -->
<s:set name="CpDomanda_tblMacchineGruACavo_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchineGruACavo')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineGruACavo"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchineGruACavo"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchineGruACavo_clearStatus}"
               uid="row_tblMacchineGruACavo"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchineGruACavoCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchineGruACavo.idTipoMacchinaMezzo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineGruACavo['+(#attr.row_tblMacchineGruACavo_rowNum - 1)+'].idTipoMacchinaMezzo'}" headerKey="" headerValue=""  list= "appDataelencoMacchineGruACavo[(#attr.row_tblMacchineGruACavo_rowNum - 1)].elencoTipoMacchinaMezzo"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineGruACavo.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineGruACavo['+(#attr.row_tblMacchineGruACavo_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineGruACavo.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineGruACavo['+(#attr.row_tblMacchineGruACavo_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineGruACavo.portata.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineGruACavo['+(#attr.row_tblMacchineGruACavo_rowNum - 1)+'].portata'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineGruACavo.idTipoCarrello.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineGruACavo['+(#attr.row_tblMacchineGruACavo_rowNum - 1)+'].idTipoCarrello'}" headerKey="" headerValue=""  list= "appDataelencoMacchineGruACavo[(#attr.row_tblMacchineGruACavo_rowNum - 1)].elencoTipoCarrello"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchineGruACavo.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineGruACavo['+(#attr.row_tblMacchineGruACavo_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineGruACavo[(#attr.row_tblMacchineGruACavo_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchineGruACavo.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchineGruACavo --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaGruACavo" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaGruACavo -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaGruACavo">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaGruACavo')" >

	



<!-- widget btnAddAttrezzaturaMacchinaGruACavo -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaGruACavo" id="widg_btnAddAttrezzaturaMacchinaGruACavo" method="handleBtnAddAttrezzaturaMacchinaGruACavo_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaGruACavo.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaGruACavo')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaGruACavo --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchineGruACavo --></div>
