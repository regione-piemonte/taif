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

	
	<div id="p_fpAttrezzatureAltriMezzi" class="formPanelBlock"><!-- startFragment:p_fpAttrezzatureAltriMezzi -->
		
	
<div class="formPanel" id="fpAttrezzatureAltriMezzi">


	
	

	
	
			
	
	<div id="p_wpElencoAltriMezzi" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoAltriMezzi -->
	
	

<div class="widgetsPanel" id="wpElencoAltriMezzi">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblAltriMezzi')" >

	
<div class="tableWidget">


<!-- widget tblAltriMezzi -->
<s:set name="CpDomanda_tblAltriMezzi_clearStatus" value="isTableClearStatus('CpDomanda_tblAltriMezzi')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoAltriMezzi"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAltriMezzi"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblAltriMezzi_clearStatus}"
               uid="row_tblAltriMezzi"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblAltriMezziCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblAltriMezzi.descrizione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAltriMezzi['+(#attr.row_tblAltriMezzi_rowNum - 1)+'].descrizione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltriMezzi.annoImmatricolazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAltriMezzi['+(#attr.row_tblAltriMezzi_rowNum - 1)+'].annoImmatricolazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltriMezzi.potenza.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAltriMezzi['+(#attr.row_tblAltriMezzi_rowNum - 1)+'].potenza'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltriMezzi.idTipoTrazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoAltriMezzi['+(#attr.row_tblAltriMezzi_rowNum - 1)+'].idTipoTrazione'}" headerKey="" headerValue=""  list= "appDataelencoAltriMezzi[(#attr.row_tblAltriMezzi_rowNum - 1)].elencoTipoTrazione"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltriMezzi.idTipoAlimentazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoAltriMezzi['+(#attr.row_tblAltriMezzi_rowNum - 1)+'].idTipoAlimentazione'}" headerKey="" headerValue=""  list= "appDataelencoAltriMezzi[(#attr.row_tblAltriMezzi_rowNum - 1)].elencoTipoAlimentazione"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltriMezzi.portata.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAltriMezzi['+(#attr.row_tblAltriMezzi_rowNum - 1)+'].portata'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltriMezzi.idTipoCarrello.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoAltriMezzi['+(#attr.row_tblAltriMezzi_rowNum - 1)+'].idTipoCarrello'}" headerKey="" headerValue=""  list= "appDataelencoAltriMezzi[(#attr.row_tblAltriMezzi_rowNum - 1)].elencoTipoCarrello"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltriMezzi.idTipoNoleggio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoAltriMezzi['+(#attr.row_tblAltriMezzi_rowNum - 1)+'].idTipoNoleggio'}" headerKey="" headerValue=""  list= "appDataelencoAltriMezzi[(#attr.row_tblAltriMezzi_rowNum - 1)].elencoTipoNoleggio"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblAltriMezzi.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoAltriMezzi --></div>

			
	
	<div id="p_cmdAggiungiAttrezzaturaAltriMezzi" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiAttrezzaturaAltriMezzi -->
	
	
<div class="commandPanel functional" id="cmdAggiungiAttrezzaturaAltriMezzi">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddAttrezzaturaAltriMezzi')" >

	



<!-- widget btnAddAttrezzaturaAltriMezzi -->
<s:submit name="widg_btnAddAttrezzaturaAltriMezzi" id="widg_btnAddAttrezzaturaAltriMezzi" method="handleBtnAddAttrezzaturaAltriMezzi_CLICKED"
	key="CpDomanda.btnAddAttrezzaturaAltriMezzi.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddAttrezzaturaAltriMezzi')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiAttrezzaturaAltriMezzi --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttrezzatureAltriMezzi --></div>
