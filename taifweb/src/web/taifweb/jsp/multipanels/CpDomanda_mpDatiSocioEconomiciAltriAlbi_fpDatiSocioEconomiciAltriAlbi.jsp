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

	
	<div id="p_fpDatiSocioEconomiciAltriAlbi" class="formPanelBlock"><!-- startFragment:p_fpDatiSocioEconomiciAltriAlbi -->
		
	
<div class="formPanel" id="fpDatiSocioEconomiciAltriAlbi">


	
	

	
	
			
	
	<div id="p_wpDatiSocioEconomiciAltriAlbi" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiSocioEconomiciAltriAlbi -->
	
	

<div class="widgetsPanel" id="wpDatiSocioEconomiciAltriAlbi">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tbDatiSocioEconomiciAltriAlbi')" >

	
<div class="tableWidget">


<!-- widget tbDatiSocioEconomiciAltriAlbi -->
<s:set name="CpDomanda_tbDatiSocioEconomiciAltriAlbi_clearStatus" value="isTableClearStatus('CpDomanda_tbDatiSocioEconomiciAltriAlbi')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoAltriAlbi"  				
			   excludedParams="*"			   export="false"
               id="widg_tbDatiSocioEconomiciAltriAlbi"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tbDatiSocioEconomiciAltriAlbi_clearStatus}"
               uid="row_tbDatiSocioEconomiciAltriAlbi"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTbDatiSocioEconomiciAltriAlbiCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tbDatiSocioEconomiciAltriAlbi.denominazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAltriAlbi['+(#attr.row_tbDatiSocioEconomiciAltriAlbi_rowNum - 1)+'].denominazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tbDatiSocioEconomiciAltriAlbi.numeroAlbo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAltriAlbi['+(#attr.row_tbDatiSocioEconomiciAltriAlbi_rowNum - 1)+'].numeroAlbo'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tbDatiSocioEconomiciAltriAlbi.dataIscrizione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAltriAlbi['+(#attr.row_tbDatiSocioEconomiciAltriAlbi_rowNum - 1)+'].dataIscrizione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tbDatiSocioEconomiciAltriAlbi.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDatiSocioEconomiciAltriAlbi --></div>

			
	
	<div id="p_cmdAggiungiAltroAlbo" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAltroAlbo -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAltroAlbo">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAltroAlbo')" >

	



<!-- widget btnAddAltroAlbo -->
<s:submit name="widg_btnAddAltroAlbo" id="widg_btnAddAltroAlbo" method="handleBtnAddAltroAlbo_CLICKED"
	key="CpDomanda.btnAddAltroAlbo.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAltroAlbo')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAltroAlbo --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiSocioEconomiciAltriAlbi --></div>
