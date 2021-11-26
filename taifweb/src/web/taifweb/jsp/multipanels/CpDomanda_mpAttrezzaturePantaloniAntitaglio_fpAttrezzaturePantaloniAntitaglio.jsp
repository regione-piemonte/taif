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

	
	<div id="p_fpAttrezzaturePantaloniAntitaglio" class="formPanelBlock"><!-- startFragment:p_fpAttrezzaturePantaloniAntitaglio -->
		
	
<div class="formPanel" id="fpAttrezzaturePantaloniAntitaglio">


	
	

	
	
			
	
	<div id="p_wpElencoAttrezzaturePantaloniAntitaglio" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoAttrezzaturePantaloniAntitaglio -->
	
	

<div class="widgetsPanel" id="wpElencoAttrezzaturePantaloniAntitaglio">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblAttrezzaturePantaloniAntitaglio')" >

	
<div class="tableWidget">


<!-- widget tblAttrezzaturePantaloniAntitaglio -->
<s:set name="CpDomanda_tblAttrezzaturePantaloniAntitaglio_clearStatus" value="isTableClearStatus('CpDomanda_tblAttrezzaturePantaloniAntitaglio')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoPantaloniAntitaglioAttrezzature"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAttrezzaturePantaloniAntitaglio"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblAttrezzaturePantaloniAntitaglio_clearStatus}"
               uid="row_tblAttrezzaturePantaloniAntitaglio"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblAttrezzaturePantaloniAntitaglioCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblAttrezzaturePantaloniAntitaglio.quantita.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoPantaloniAntitaglioAttrezzature['+(#attr.row_tblAttrezzaturePantaloniAntitaglio_rowNum - 1)+'].quantita'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAttrezzaturePantaloniAntitaglio.annoScadenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoPantaloniAntitaglioAttrezzature['+(#attr.row_tblAttrezzaturePantaloniAntitaglio_rowNum - 1)+'].annoScadenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAttrezzaturePantaloniAntitaglio.tipologia.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoPantaloniAntitaglioAttrezzature['+(#attr.row_tblAttrezzaturePantaloniAntitaglio_rowNum - 1)+'].tipologia'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblAttrezzaturePantaloniAntitaglio.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoAttrezzaturePantaloniAntitaglio --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaPantaloniAntitaglio" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaPantaloniAntitaglio -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaPantaloniAntitaglio">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddPantaloneAntitaglio')" >

	



<!-- widget btnAddPantaloneAntitaglio -->
<s:submit name="widg_btnAddPantaloneAntitaglio" id="widg_btnAddPantaloneAntitaglio" method="handleBtnAddPantaloneAntitaglio_CLICKED"
	key="CpDomanda.btnAddPantaloneAntitaglio.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddPantaloneAntitaglio')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaPantaloniAntitaglio --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzaturePantaloniAntitaglio --></div>
