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

	
	<div id="p_fpAttrezzatureCascoForestale" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureCascoForestale -->
		
	
<div class="formPanel" id="fpAttrezzatureCascoForestale">


	
	

	
	
			
	
	<div id="p_wpElencoAttrezzatureCascoForestale" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoAttrezzatureCascoForestale -->
	
	

<div class="widgetsPanel" id="wpElencoAttrezzatureCascoForestale">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblAttrezzatureCascoForestale')" >

	
<div class="tableWidget">


<!-- widget tblAttrezzatureCascoForestale -->
<s:set name="CpDomanda_tblAttrezzatureCascoForestale_clearStatus" value="isTableClearStatus('CpDomanda_tblAttrezzatureCascoForestale')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoCaschiForestaliAttrezzature"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAttrezzatureCascoForestale"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblAttrezzatureCascoForestale_clearStatus}"
               uid="row_tblAttrezzatureCascoForestale"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblAttrezzatureCascoForestaleCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblAttrezzatureCascoForestale.quantita.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoCaschiForestaliAttrezzature['+(#attr.row_tblAttrezzatureCascoForestale_rowNum - 1)+'].quantita'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAttrezzatureCascoForestale.annoScadenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoCaschiForestaliAttrezzature['+(#attr.row_tblAttrezzatureCascoForestale_rowNum - 1)+'].annoScadenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAttrezzatureCascoForestale.tipologia.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoCaschiForestaliAttrezzature['+(#attr.row_tblAttrezzatureCascoForestale_rowNum - 1)+'].tipologia'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblAttrezzatureCascoForestale.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoAttrezzatureCascoForestale --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaCascoForestale" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaCascoForestale -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaCascoForestale">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaCascoForestale')" >

	



<!-- widget btnAddAttrezzaturaCascoForestale -->
<s:submit name="widg_btnAddAttrezzaturaCascoForestale" id="widg_btnAddAttrezzaturaCascoForestale" method="handleBtnAddAttrezzaturaCascoForestale_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaCascoForestale.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaCascoForestale')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaCascoForestale --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureCascoForestale --></div>
