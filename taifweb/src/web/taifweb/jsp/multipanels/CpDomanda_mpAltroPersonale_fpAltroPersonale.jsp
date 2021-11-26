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

	
	<div id="p_fpAltroPersonale" class="formPanelBlock"><!-- startFragment:p_fpAltroPersonale -->
		
	
<div class="formPanel" id="fpAltroPersonale">


	
	

	
	
			
	
	<div id="p_wpRicercaAltroPersonale" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaAltroPersonale -->
	
	

<div class="widgetsPanel" id="wpRicercaAltroPersonale">
	
	<customtag:widgetsPanel id="wpRicercaAltroPersonaleTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','cmbRicercaAltroPersonale')" >

	
<customtag:widgetsPanelColumn  tooltip="minimo 4 caratteri" labelField="true" textLabel="%{getText('CpDomanda.cmbRicercaAltroPersonale.label')}" labelFor="widg_cmbRicercaAltroPersonale" errorFor="appDatapersonaleDaCercare" labelId="cmbRicercaAltroPersonaleLbl"
	position="first"  >


<!-- widget cmbRicercaAltroPersonale -->

<s:textfield 

	
		title="minimo 4 caratteri"
	
	name="appDatapersonaleDaCercare.description"
	id="widg_cmbRicercaAltroPersonale"
	size="30"
	disabled="isWidgetDisabled('CpDomanda','cmbRicercaAltroPersonale')"
	/>


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','btnAggiungiCodiceFiscaleAltroPersonale')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnAggiungiCodiceFiscaleAltroPersonale -->
<s:submit name="widg_btnAggiungiCodiceFiscaleAltroPersonale" id="widg_btnAggiungiCodiceFiscaleAltroPersonale" method="handleBtnAggiungiCodiceFiscaleAltroPersonale_CLICKED"
	key="CpDomanda.btnAggiungiCodiceFiscaleAltroPersonale.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('CpDomanda','btnAggiungiCodiceFiscaleAltroPersonale')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAltroPersonale --></div>

			
	
	<div id="p_wpAltroPersonale" class="widgetsPanelBlock"><!-- startFragment:p_wpAltroPersonale -->
	
	

<div class="widgetsPanel" id="wpAltroPersonale">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblAltroPersonale')" >

	
<div class="tableWidget">


<!-- widget tblAltroPersonale -->
<s:set name="CpDomanda_tblAltroPersonale_clearStatus" value="isTableClearStatus('CpDomanda_tblAltroPersonale')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoPersonale"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAltroPersonale"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblAltroPersonale_clearStatus}"
               uid="row_tblAltroPersonale"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.domanda.CpDomandaTblAltroPersonaleCustomDecorator"               class="dataTable">
	
		<display:column titleKey="CpDomanda.tblAltroPersonale.codiceFiscale.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoPersonale['+(#attr.row_tblAltroPersonale_rowNum - 1)+'].codiceFiscale'}"  disabled="%{!appDataelencoPersonale[(#attr.row_tblAltroPersonale_rowNum - 1)].codiceFiscaleEditabile}"   theme="csi-tableinput-rem" maxlength="16" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltroPersonale.cognome.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoPersonale['+(#attr.row_tblAltroPersonale_rowNum - 1)+'].cognome'}"  disabled="%{!appDataelencoPersonale[(#attr.row_tblAltroPersonale_rowNum - 1)].cognomeEditabile}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltroPersonale.nome.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoPersonale['+(#attr.row_tblAltroPersonale_rowNum - 1)+'].nome'}"  disabled="%{!appDataelencoPersonale[(#attr.row_tblAltroPersonale_rowNum - 1)].nomeEditabile}"   theme="csi-tableinput-rem" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltroPersonale.idTipologiaPersonale.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoPersonale['+(#attr.row_tblAltroPersonale_rowNum - 1)+'].idTipologiaPersonale'}" headerKey="" headerValue=""  list= "appDataelencoPersonale[(#attr.row_tblAltroPersonale_rowNum - 1)].elencoTipologiaPersonale"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltroPersonale.idMansione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoPersonale['+(#attr.row_tblAltroPersonale_rowNum - 1)+'].idMansione'}" headerKey="" headerValue=""  list= "appDataelencoPersonale[(#attr.row_tblAltroPersonale_rowNum - 1)].elencoMansioni"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltroPersonale.idContratto.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoPersonale['+(#attr.row_tblAltroPersonale_rowNum - 1)+'].idContratto'}" headerKey="" headerValue=""  list= "appDataelencoPersonale[(#attr.row_tblAltroPersonale_rowNum - 1)].elencoContratti"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltroPersonale.idDurataContratto.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoPersonale['+(#attr.row_tblAltroPersonale_rowNum - 1)+'].idDurataContratto'}" headerKey="" headerValue=""  list= "appDataelencoPersonale[(#attr.row_tblAltroPersonale_rowNum - 1)].elencoDurateContratto"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltroPersonale.giorniNellAnno.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoPersonale['+(#attr.row_tblAltroPersonale_rowNum - 1)+'].giorniNellAnno'}"   theme="csi-tableinput-rem" maxlength="3" />
		</display:column>
		
		<display:column titleKey="CpDomanda.tblAltroPersonale.idInquadramento.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDataelencoPersonale['+(#attr.row_tblAltroPersonale_rowNum - 1)+'].idInquadramento'}" headerKey="" headerValue=""  list= "appDataelencoPersonale[(#attr.row_tblAltroPersonale_rowNum - 1)].elencoInquadramenti"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column property="iconaOperatore" titleKey="CpDomanda.tblAltroPersonale.iconaOperatore.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaCancella" titleKey="CpDomanda.tblAltroPersonale.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAltroPersonale --></div>

			
	
	<div id="p_cmdAggiungiPersonale" class="commandPanelBlock"><!-- startFragment:p_cmdAggiungiPersonale -->
	
	
<div class="commandPanel functional" id="cmdAggiungiPersonale">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('CpDomanda','btnAddPersonale')" >

	



<!-- widget btnAddPersonale -->
<s:submit name="widg_btnAddPersonale" id="widg_btnAddPersonale" method="handleBtnAddPersonale_CLICKED"
	key="CpDomanda.btnAddPersonale.label" cssClass="buttonWidget addItem"
	disabled="isWidgetDisabled('CpDomanda','btnAddPersonale')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdAggiungiPersonale --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAltroPersonale --></div>
