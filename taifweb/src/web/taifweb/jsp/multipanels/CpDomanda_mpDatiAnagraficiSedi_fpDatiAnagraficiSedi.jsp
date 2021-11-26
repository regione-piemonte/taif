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

	
	<div id="p_fpDatiAnagraficiSedi" class="formPanelBlock"><!-- startFragment:p_fpDatiAnagraficiSedi -->
		
	
<div class="formPanel" id="fpDatiAnagraficiSedi">


	
	

	
	
			
	
	<div id="p_wpDatiAnagraficiSedi" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiSedi -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiAnagraficiSedi.label" /> </h4>
<div class="widgetsPanel" id="wpDatiAnagraficiSedi">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblDatiAnagraficiSedi')" >

	
<div class="tableWidget">


<!-- widget tblDatiAnagraficiSedi -->
<s:set name="CpDomanda_tblDatiAnagraficiSedi_clearStatus" value="isTableClearStatus('CpDomanda_tblDatiAnagraficiSedi')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoSediDatiAnagraficiAnagrafeAziendale"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDatiAnagraficiSedi"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblDatiAnagraficiSedi_clearStatus}"
               uid="row_tblDatiAnagraficiSedi"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblDatiAnagraficiSediCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblDatiAnagraficiSedi.idTipoSede.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoSediDatiAnagraficiAnagrafeAziendale['+(#attr.row_tblDatiAnagraficiSedi_rowNum - 1)+'].idTipoSede'}" headerKey="" headerValue=""  list= "appDataelencoSediDatiAnagraficiAnagrafeAziendale[(#attr.row_tblDatiAnagraficiSedi_rowNum - 1)].elencoTipoSede"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblDatiAnagraficiSedi.idComune.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoSediDatiAnagraficiAnagrafeAziendale['+(#attr.row_tblDatiAnagraficiSedi_rowNum - 1)+'].idComune'}" headerKey="" headerValue=""  list= "appDataelencoSediDatiAnagraficiAnagrafeAziendale[(#attr.row_tblDatiAnagraficiSedi_rowNum - 1)].elencoComuni"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblDatiAnagraficiSedi.cap.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoSediDatiAnagraficiAnagrafeAziendale['+(#attr.row_tblDatiAnagraficiSedi_rowNum - 1)+'].cap'}"   theme="csi-tableinput-rem" maxlength="10" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblDatiAnagraficiSedi.indirizzo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoSediDatiAnagraficiAnagrafeAziendale['+(#attr.row_tblDatiAnagraficiSedi_rowNum - 1)+'].indirizzo'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblDatiAnagraficiSedi.numeroCivico.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoSediDatiAnagraficiAnagrafeAziendale['+(#attr.row_tblDatiAnagraficiSedi_rowNum - 1)+'].numeroCivico'}"   theme="csi-tableinput-rem" maxlength="10" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblDatiAnagraficiSedi.telefono.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoSediDatiAnagraficiAnagrafeAziendale['+(#attr.row_tblDatiAnagraficiSedi_rowNum - 1)+'].telefono'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblDatiAnagraficiSedi.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiSedi --></div>

			
	
	<div id="p_cmdAggiungiSede" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiSede -->
	
	
<div class="commandPanel functional" id="cmdAggiungiSede">

	
	
		

	
	
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('CpDomanda','btnDeleteSedeOperativa')" >

	



<!-- widget btnDeleteSedeOperativa -->
<s:submit name="widg_btnDeleteSedeOperativa" id="widg_btnDeleteSedeOperativa" method="handleBtnDeleteSedeOperativa_CLICKED"
	key="CpDomanda.btnDeleteSedeOperativa.label" cssClass="buttonWidget deleteItem"
	disabled="isWidgetDisabled('CpDomanda','btnDeleteSedeOperativa')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddSedeOperativa')" >

	



<!-- widget btnAddSedeOperativa -->
<s:submit name="widg_btnAddSedeOperativa" id="widg_btnAddSedeOperativa" method="handleBtnAddSedeOperativa_CLICKED"
	key="CpDomanda.btnAddSedeOperativa.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddSedeOperativa')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiSede --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiAnagraficiSedi --></div>
