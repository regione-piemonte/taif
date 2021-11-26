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

	
	<div id="p_fpAttrezzatureMacchinaElencoVerricelli" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureMacchinaElencoVerricelli -->
		
	
<div class="formPanel" id="fpAttrezzatureMacchinaElencoVerricelli">


	
	

	
	
			
	
	<div id="p_wpElencoMacchinaVerricelli" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoMacchinaVerricelli -->
	
	

<div class="widgetsPanel" id="wpElencoMacchinaVerricelli">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblMacchinaVerricelli')" >

	
<div class="tableWidget">


<!-- widget tblMacchinaVerricelli -->
<s:set name="CpDomanda_tblMacchinaVerricelli_clearStatus" value="isTableClearStatus('CpDomanda_tblMacchinaVerricelli')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoMacchineVerricelli"  				
			   excludedParams="*"			   export="false"
               id="widg_tblMacchinaVerricelli"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblMacchinaVerricelli_clearStatus}"
               uid="row_tblMacchinaVerricelli"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblMacchinaVerricelliCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblMacchinaVerricelli.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineVerricelli['+(#attr.row_tblMacchinaVerricelli_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaVerricelli.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoMacchineVerricelli['+(#attr.row_tblMacchinaVerricelli_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaVerricelli.comandatoADistanza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:checkbox name="%{'appDataelencoMacchineVerricelli['+(#attr.row_tblMacchinaVerricelli_rowNum - 1)+'].comandatoADistanza'}"   id="%{'widg_tblMacchinaVerricelli_comandatoADistanza_'+(#attr.row_tblMacchinaVerricelli_rowNum - 1)}"  theme="csi-tableinput-rem"/>
<s:hidden name="%{'__checkbox_appDataelencoMacchineVerricelli['+(#attr.row_tblMacchinaVerricelli_rowNum - 1)+'].comandatoADistanza'}" id="%{'__checkbox_widg_tblMacchinaVerricelli_comandatoADistanza_'+(#attr.row_tblMacchinaVerricelli_rowNum - 1)}" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblMacchinaVerricelli.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoMacchineVerricelli['+(#attr.row_tblMacchinaVerricelli_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoMacchineVerricelli[(#attr.row_tblMacchinaVerricelli_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblMacchinaVerricelli.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoMacchinaVerricelli --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaMacchinaVerricelli" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaMacchinaVerricelli -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaMacchinaVerricelli">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaMacchinaVerricelli')" >

	



<!-- widget btnAddAttrezzaturaMacchinaVerricelli -->
<s:submit name="widg_btnAddAttrezzaturaMacchinaVerricelli" id="widg_btnAddAttrezzaturaMacchinaVerricelli" method="handleBtnAddAttrezzaturaMacchinaVerricelli_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaMacchinaVerricelli.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaMacchinaVerricelli')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaMacchinaVerricelli --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureMacchinaElencoVerricelli --></div>
