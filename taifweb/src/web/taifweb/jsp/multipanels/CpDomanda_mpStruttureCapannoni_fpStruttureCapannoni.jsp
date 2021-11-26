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

	
	<div id="p_fpStruttureCapannoni" class="formPanelBlock"><!-- startFragment:p_fpStruttureCapannoni -->
		
	
<div class="formPanel" id="fpStruttureCapannoni">


	
	

	
	
			
	
	<div id="p_wpElencoCapannoni" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoCapannoni -->
	
	

<div class="widgetsPanel" id="wpElencoCapannoni">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblStruttureCapannoni')" >

	
<div class="tableWidget">


<!-- widget tblStruttureCapannoni -->
<s:set name="CpDomanda_tblStruttureCapannoni_clearStatus" value="isTableClearStatus('CpDomanda_tblStruttureCapannoni')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoCapannoni"  				
			   excludedParams="*"			   export="false"
               id="widg_tblStruttureCapannoni"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblStruttureCapannoni_clearStatus}"
               uid="row_tblStruttureCapannoni"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblStruttureCapannoniCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblStruttureCapannoni.idFunzione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoCapannoni['+(#attr.row_tblStruttureCapannoni_rowNum - 1)+'].idFunzione'}" headerKey="" headerValue=""  list= "appDataelencoCapannoni[(#attr.row_tblStruttureCapannoni_rowNum - 1)].elencoFunzioni"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblStruttureCapannoni.dimensioneCapannone.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoCapannoni['+(#attr.row_tblStruttureCapannoni_rowNum - 1)+'].dimensioneCapannone'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblStruttureCapannoni.annoCostruzioneORiattamentoCapannone.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoCapannoni['+(#attr.row_tblStruttureCapannoni_rowNum - 1)+'].annoCostruzioneORiattamentoCapannone'}"   theme="csi-tableinput-rem" maxlength="4" />
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblStruttureCapannoni.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoCapannoni --></div>

			
	
	<div id="p_cmdAggiungiCapannoni" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiCapannoni -->
	
	
<div class="commandPanel functional" id="cmdAggiungiCapannoni">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddCapannone')" >

	



<!-- widget btnAddCapannone -->
<s:submit name="widg_btnAddCapannone" id="widg_btnAddCapannone" method="handleBtnAddCapannone_CLICKED"
	key="CpDomanda.btnAddCapannone.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddCapannone')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiCapannoni --></div>

	

		
	
</div>

	<!-- endFragment:p_fpStruttureCapannoni --></div>
