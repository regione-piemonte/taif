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

	
	<div id="p_fpAttivitaLegnameFr" class="formPanelBlock"><!-- startFragment:p_fpAttivitaLegnameFr -->
		
	
<div class="formPanel" id="fpAttivitaLegnameFr">


	
	

	
	
			
	
	<div id="p_wpAttivitaLegnameFr" class="widgetsPanelBlock scroll"><!-- startFragment:p_wpAttivitaLegnameFr -->
	
	

<div class="widgetsPanel" id="wpAttivitaLegnameFr">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfPercentualeCommercioFr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfPercentualeCommercioFr.label')}" labelFor="widg_tfPercentualeCommercioFr" errorFor="appDatapercentualeCommercioFr" labelId="tfPercentualeCommercioFrLbl"
	  >


<!-- widget tfPercentualeCommercioFr -->
<s:textfield 
	
	
	name="appDatapercentualeCommercioFr" id="widg_tfPercentualeCommercioFr"
maxlength="3"	disabled="isWidgetDisabled('CpDomanda','tfPercentualeCommercioFr')"
	size="3" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','udwSpazioAttivitaLegnameFr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_udwSpazioAttivitaLegnameFr" errorFor="widg_udwSpazioAttivitaLegnameFr" labelId="udwSpazioAttivitaLegnameFrLbl"
	  >


<s:include value="/jsp/userwidgets/CpDomanda_udwSpazioAttivitaLegnameFr.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','tbAttivitaLegnameFr')" >

	
<div class="tableWidget">


<!-- widget tbAttivitaLegnameFr -->
<s:set name="CpDomanda_tbAttivitaLegnameFr_clearStatus" value="isTableClearStatus('CpDomanda_tbAttivitaLegnameFr')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoLegnamiAssortimentiTrattati"  				
			   excludedParams="*"			   export="false"
               id="widg_tbAttivitaLegnameFr"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tbAttivitaLegnameFr_clearStatus}"
               uid="row_tbAttivitaLegnameFr"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTbAttivitaLegnameFrCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tbAttivitaLegnameFr.idSpecie.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegnameFr_rowNum - 1)+'].idSpecie'}" headerKey="" headerValue=""  list= "appDataelencoLegnamiAssortimentiTrattati[(#attr.row_tbAttivitaLegnameFr_rowNum - 1)].elencoSpecie"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegnameFr.idProvenienza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegnameFr_rowNum - 1)+'].idProvenienza'}" headerKey="" headerValue=""  list= "appDataelencoLegnamiAssortimentiTrattati[(#attr.row_tbAttivitaLegnameFr_rowNum - 1)].elencoProvenienze"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegnameFr.idAssortimento.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegnameFr_rowNum - 1)+'].idAssortimento'}" headerKey="" headerValue=""  list= "appDataelencoLegnamiAssortimentiTrattati[(#attr.row_tbAttivitaLegnameFr_rowNum - 1)].elencoAssortimenti"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegnameFr.volumeVendutoMedioAnnuo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegnameFr_rowNum - 1)+'].volumeVendutoMedioAnnuo'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegnameFr.idUnitaMisura.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegnameFr_rowNum - 1)+'].idUnitaMisura'}" headerKey="" headerValue=""  list= "appDataelencoLegnamiAssortimentiTrattati[(#attr.row_tbAttivitaLegnameFr_rowNum - 1)].elencoUnitaMisura"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegnameFr.idDestinazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegnameFr_rowNum - 1)+'].idDestinazione'}" headerKey="" headerValue=""  list= "appDataelencoLegnamiAssortimentiTrattati[(#attr.row_tbAttivitaLegnameFr_rowNum - 1)].elencoDestinazioni"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegnameFr.altro.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegnameFr_rowNum - 1)+'].altro'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tbAttivitaLegnameFr.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAttivitaLegnameFr --></div>

			
	
	<div id="p_cmdAggiungiLegnameFr" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiLegnameFr -->
	
	
<div class="commandPanel functional" id="cmdAggiungiLegnameFr">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddLegnameFr')" >

	



<!-- widget btnAddLegnameFr -->
<s:submit name="widg_btnAddLegnameFr" id="widg_btnAddLegnameFr" method="handleBtnAddLegnameFr_CLICKED"
	key="CpDomanda.btnAddLegnameFr.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddLegnameFr')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiLegnameFr --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttivitaLegnameFr --></div>
