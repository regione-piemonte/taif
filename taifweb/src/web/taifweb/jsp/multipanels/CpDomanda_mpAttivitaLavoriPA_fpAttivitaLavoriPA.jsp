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

	
	<div id="p_fpAttivitaLavoriPA" class="formPanelBlock"><!-- startFragment:p_fpAttivitaLavoriPA -->
		
	
<div class="formPanel" id="fpAttivitaLavoriPA">


	
	

	
	
			
	
	<div id="p_wpAttivitaLavoriPA" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaLavoriPA -->
	
	

<div class="widgetsPanel" id="wpAttivitaLavoriPA">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tbAttivitaLavoriPA')" >

	
<div class="tableWidget">


<!-- widget tbAttivitaLavoriPA -->
<s:set name="CpDomanda_tbAttivitaLavoriPA_clearStatus" value="isTableClearStatus('CpDomanda_tbAttivitaLavoriPA')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoLavoriPA"  				
			   excludedParams="*"			   export="false"
               id="widg_tbAttivitaLavoriPA"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tbAttivitaLavoriPA_clearStatus}"
               uid="row_tbAttivitaLavoriPA"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTbAttivitaLavoriPACustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tbAttivitaLavoriPA.committente.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoLavoriPA['+(#attr.row_tbAttivitaLavoriPA_rowNum - 1)+'].committente'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLavoriPA.idOggettoIntervento.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoLavoriPA['+(#attr.row_tbAttivitaLavoriPA_rowNum - 1)+'].idOggettoIntervento'}" headerKey="" headerValue=""  list= "appDataelencoLavoriPA[(#attr.row_tbAttivitaLavoriPA_rowNum - 1)].elencoOggettiIntervento"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLavoriPA.altro.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoLavoriPA['+(#attr.row_tbAttivitaLavoriPA_rowNum - 1)+'].altro'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLavoriPA.importoComplessivo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoLavoriPA['+(#attr.row_tbAttivitaLavoriPA_rowNum - 1)+'].importoComplessivo'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tbAttivitaLavoriPA.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAttivitaLavoriPA --></div>

			
	
	<div id="p_cmdAggiungiLavoroPA" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiLavoroPA -->
	
	
<div class="commandPanel functional" id="cmdAggiungiLavoroPA">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddLavoroPA')" >

	



<!-- widget btnAddLavoroPA -->
<s:submit name="widg_btnAddLavoroPA" id="widg_btnAddLavoroPA" method="handleBtnAddLavoroPA_CLICKED"
	key="CpDomanda.btnAddLavoroPA.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddLavoroPA')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiLavoroPA --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttivitaLavoriPA --></div>
