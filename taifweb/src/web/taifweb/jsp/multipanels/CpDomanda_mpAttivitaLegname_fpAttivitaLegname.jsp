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

	
	<div id="p_fpAttivitaLegname" class="formPanelBlock"><!-- startFragment:p_fpAttivitaLegname -->
		
	
<div class="formPanel" id="fpAttivitaLegname">


	
	

	
	
			
	
	<div id="p_wpAttivitaLegname" class="widgetsPanelBlock scroll"><!-- startFragment:p_wpAttivitaLegname -->
	
	

<div class="widgetsPanel" id="wpAttivitaLegname">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tbAttivitaLegname')" >

	
<div class="tableWidget">


<!-- widget tbAttivitaLegname -->
<s:set name="CpDomanda_tbAttivitaLegname_clearStatus" value="isTableClearStatus('CpDomanda_tbAttivitaLegname')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoLegnamiAssortimentiTrattati"  				
			   excludedParams="*"			   export="false"
               id="widg_tbAttivitaLegname"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tbAttivitaLegname_clearStatus}"
               uid="row_tbAttivitaLegname"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTbAttivitaLegnameCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tbAttivitaLegname.idSpecie.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegname_rowNum - 1)+'].idSpecie'}" headerKey="" headerValue=""  list= "appDataelencoLegnamiAssortimentiTrattati[(#attr.row_tbAttivitaLegname_rowNum - 1)].elencoSpecie"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegname.idProvenienza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegname_rowNum - 1)+'].idProvenienza'}" headerKey="" headerValue=""  list= "appDataelencoLegnamiAssortimentiTrattati[(#attr.row_tbAttivitaLegname_rowNum - 1)].elencoProvenienze"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegname.idAssortimento.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegname_rowNum - 1)+'].idAssortimento'}" headerKey="" headerValue=""  list= "appDataelencoLegnamiAssortimentiTrattati[(#attr.row_tbAttivitaLegname_rowNum - 1)].elencoAssortimenti"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegname.idTA.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegname_rowNum - 1)+'].idTA'}" headerKey="" headerValue=""  list= "appDataelencoLegnamiAssortimentiTrattati[(#attr.row_tbAttivitaLegname_rowNum - 1)].elencoTA"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegname.volumeVendutoMedioAnnuo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegname_rowNum - 1)+'].volumeVendutoMedioAnnuo'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegname.idUnitaMisura.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegname_rowNum - 1)+'].idUnitaMisura'}" headerKey="" headerValue=""  list= "appDataelencoLegnamiAssortimentiTrattati[(#attr.row_tbAttivitaLegname_rowNum - 1)].elencoUnitaMisura"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegname.idDestinazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegname_rowNum - 1)+'].idDestinazione'}" headerKey="" headerValue=""  list= "appDataelencoLegnamiAssortimentiTrattati[(#attr.row_tbAttivitaLegname_rowNum - 1)].elencoDestinazioni"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tbAttivitaLegname.altro.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoLegnamiAssortimentiTrattati['+(#attr.row_tbAttivitaLegname_rowNum - 1)+'].altro'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tbAttivitaLegname.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAttivitaLegname --></div>

			
	
	<div id="p_cmdAggiungiLegname" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiLegname -->
	
	
<div class="commandPanel functional" id="cmdAggiungiLegname">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddLegname')" >

	



<!-- widget btnAddLegname -->
<s:submit name="widg_btnAddLegname" id="widg_btnAddLegname" method="handleBtnAddLegname_CLICKED"
	key="CpDomanda.btnAddLegname.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddLegname')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiLegname --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttivitaLegname --></div>
