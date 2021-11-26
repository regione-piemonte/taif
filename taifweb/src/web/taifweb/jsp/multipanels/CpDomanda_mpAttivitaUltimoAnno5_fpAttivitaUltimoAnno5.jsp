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

	
	<div id="p_fpAttivitaUltimoAnno5" class="formPanelBlock"><!-- startFragment:p_fpAttivitaUltimoAnno5 -->
		
	
<div class="formPanel" id="fpAttivitaUltimoAnno5">


	
	

	
	
			
	
	<div id="p_wpAttivitaUltimoAnno5" class="widgetsPanelBlock"><!-- startFragment:p_wpAttivitaUltimoAnno5 -->
	
	

<div class="widgetsPanel" id="wpAttivitaUltimoAnno5">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblAttivitaUltimoAnno5')" >

	
<div class="tableWidget">


<!-- widget tblAttivitaUltimoAnno5 -->
<s:set name="CpDomanda_tblAttivitaUltimoAnno5_clearStatus" value="isTableClearStatus('CpDomanda_tblAttivitaUltimoAnno5')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoArboricolturaDaLegno"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAttivitaUltimoAnno5"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblAttivitaUltimoAnno5_clearStatus}"
               uid="row_tblAttivitaUltimoAnno5"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblAttivitaUltimoAnno5CustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblAttivitaUltimoAnno5.idTipoMateriale.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoArboricolturaDaLegno['+(#attr.row_tblAttivitaUltimoAnno5_rowNum - 1)+'].idTipoMateriale'}" headerKey="" headerValue=""  list= "appDataelencoArboricolturaDaLegno[(#attr.row_tblAttivitaUltimoAnno5_rowNum - 1)].elencoTipoMateriale"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="altro" titleKey="CpDomanda.tblAttivitaUltimoAnno5.altro.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column titleKey="CpDomanda.tblAttivitaUltimoAnno5.realizzazione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoArboricolturaDaLegno['+(#attr.row_tblAttivitaUltimoAnno5_rowNum - 1)+'].realizzazione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAttivitaUltimoAnno5.manutenzione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoArboricolturaDaLegno['+(#attr.row_tblAttivitaUltimoAnno5_rowNum - 1)+'].manutenzione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAttivitaUltimoAnno5.conduzione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoArboricolturaDaLegno['+(#attr.row_tblAttivitaUltimoAnno5_rowNum - 1)+'].conduzione'}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column property="iconaCancella" titleKey="CpDomanda.tblAttivitaUltimoAnno5.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAttivitaUltimoAnno5 --></div>

			
	
	<div id="p_cmdAggiungiArboricolturaDaLegno" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiArboricolturaDaLegno -->
	
	
<div class="commandPanel functional" id="cmdAggiungiArboricolturaDaLegno">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddArboricolturaDaLegno')" >

	



<!-- widget btnAddArboricolturaDaLegno -->
<s:submit name="widg_btnAddArboricolturaDaLegno" id="widg_btnAddArboricolturaDaLegno" method="handleBtnAddArboricolturaDaLegno_CLICKED"
	key="CpDomanda.btnAddArboricolturaDaLegno.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddArboricolturaDaLegno')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiArboricolturaDaLegno --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAttivitaUltimoAnno5 --></div>
