#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/topforweb/presentation/topforweb/action/gestore/CpInserimentoOperatoreAction" />

	
	<div id="p_fpWizardCorsiFinanziatiRegioneOperatore" class="formPanelBlock"><!-- startFragment:p_fpWizardCorsiFinanziatiRegioneOperatore -->
		
	
<div class="formPanel" id="fpWizardCorsiFinanziatiRegioneOperatore">


	
	

	
	
			
	
	<div id="p_smpOperatore1.2" class="stdMessagePanelBlock"><!-- startFragment:p_smpOperatore1.2 -->
	
	
<div class="stdMessagePanel" id="smpOperatore1.2">
	<customtag:stdMessagePanel id="smpOperatore1.2" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpOperatore1.2 --></div>

			
	
	<div id="p_wpInserimentoCorsiFinanziatiRegione" class="widgetsPanelBlock"><!-- startFragment:p_wpInserimentoCorsiFinanziatiRegione -->
	
	
<h4 class="wpLabel">Corsi professionali forestali finanziati da Regione <span id="toggle_wpInserimentoCorsiFinanziatiRegione"></span></h4>
<div class="widgetsPanel" id="wpInserimentoCorsiFinanziatiRegione">
	
	<customtag:widgetsPanel id="wpInserimentoCorsiFinanziatiRegioneTbl" columns="10" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoAgenziaFormativa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoAgenziaFormativa.label')}" labelFor="widg_cbInserimentoAgenziaFormativa" errorFor="appDataidAgenziaFormativaSelezionata" labelId="cbInserimentoAgenziaFormativaLbl"
	position="first"  >


<!-- widget cbInserimentoAgenziaFormativa -->
<s:select name="appDataidAgenziaFormativaSelezionata" id="widg_cbInserimentoAgenziaFormativa"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoAgenziaFormativaRicercaOperatore"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoAgenziaFormativa')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoTitoloCorso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoTitoloCorso.label')}" labelFor="widg_cbInserimentoTitoloCorso" errorFor="appDataidTitoloCorsoSelezionato" labelId="cbInserimentoTitoloCorsoLbl"
	  >


<!-- widget cbInserimentoTitoloCorso -->
<s:select name="appDataidTitoloCorsoSelezionato" id="widg_cbInserimentoTitoloCorso"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTitoloCorso"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoTitoloCorso')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoPeriodoSvolgimento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoPeriodoSvolgimento.label')}" labelFor="widg_cbInserimentoPeriodoSvolgimento" errorFor="appDataidPeriodoSvolgimentoCorsoSelezionato" labelId="cbInserimentoPeriodoSvolgimentoLbl"
	  >


<!-- widget cbInserimentoPeriodoSvolgimento -->
<s:select name="appDataidPeriodoSvolgimentoCorsoSelezionato" id="widg_cbInserimentoPeriodoSvolgimento"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoPeriodoSvolgimentoCorso"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoPeriodoSvolgimento')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','ptNumeroOreCorso')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpInserimentoOperatore.ptNumeroOreCorso.label')}" labelFor="widg_ptNumeroOreCorso" errorFor="appDatanumeroOreCorso" labelId="ptNumeroOreCorsoLbl"   >


<!-- widget ptNumeroOreCorso -->
<s:property value="appDatanumeroOreCorso" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_1_5_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoCorsiFinanziatiRegione_1_5_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoUnitaFormativa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoUnitaFormativa.label')}" labelFor="widg_cbInserimentoUnitaFormativa" errorFor="appDataidUnitaFormativaSelezionata" labelId="cbInserimentoUnitaFormativaLbl"
	position="first"  >


<!-- widget cbInserimentoUnitaFormativa -->
<s:select name="appDataidUnitaFormativaSelezionata" id="widg_cbInserimentoUnitaFormativa"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUnitaFormativaRicercaOperatore"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoUnitaFormativa')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoSedeCorso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoSedeCorso.label')}" labelFor="widg_cbInserimentoSedeCorso" errorFor="appDataidSedeCorsoSelezionato" labelId="cbInserimentoSedeCorsoLbl"
	  >


<!-- widget cbInserimentoSedeCorso -->
<s:select name="appDataidSedeCorsoSelezionato" id="widg_cbInserimentoSedeCorso"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSedeCorso"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoSedeCorso')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoEsitoCorso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoEsitoCorso.label')}" labelFor="widg_cbInserimentoEsitoCorso" errorFor="appDataidEsitoCorsoSelezionato" labelId="cbInserimentoEsitoCorsoLbl"
	  >


<!-- widget cbInserimentoEsitoCorso -->
<s:select name="appDataidEsitoCorsoSelezionato" id="widg_cbInserimentoEsitoCorso"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoEsitoCorso"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoEsitoCorso')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','updFileAttestatoCorsoRegione')" >

	
<customtag:widgetsPanelColumn  tooltip="Selezionare il file da caricare" labelField="true" textLabel="%{getText('cpInserimentoOperatore.updFileAttestatoCorsoRegione.label')}" labelFor="widg_updFileAttestatoCorsoRegione" errorFor="widg_updFileAttestatoCorsoRegione" labelId="updFileAttestatoCorsoRegioneLbl"
	  >


<s:file 
	
title="Selezionare il file da caricare"	
	name="widg_updFileAttestatoCorsoRegione" id="widg_updFileAttestatoCorsoRegione"
	disabled="isWidgetDisabled('cpInserimentoOperatore','updFileAttestatoCorsoRegione')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_2_5_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoCorsiFinanziatiRegione_2_5_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_3_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpInserimentoCorsiFinanziatiRegione_3_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_3_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_3_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_3_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_3_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','btLoadAttestatoRegioneButton')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btLoadAttestatoRegioneButton -->
<s:submit name="widg_btLoadAttestatoRegioneButton" id="widg_btLoadAttestatoRegioneButton" method="execute"
	key="cpInserimentoOperatore.btLoadAttestatoRegioneButton.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btLoadAttestatoRegioneButton')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInserimentoCorsiFinanziatiRegione --></div>

			
	
	<div id="p_wpInserimentoElencoCorsiFinanziatiRegione" class="widgetsPanelBlock"><!-- startFragment:p_wpInserimentoElencoCorsiFinanziatiRegione -->
	
	

<div class="widgetsPanel" id="wpInserimentoElencoCorsiFinanziatiRegione">
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tblInserimentoCorsiProfessionaliFinanziatiRegione')" >

	
<div class="tableWidget">


<!-- widget tblInserimentoCorsiProfessionaliFinanziatiRegione -->
	<csiuicore:ajaxify id="p_wpInserimentoElencoCorsiFinanziatiRegione" 
		widgetType="table"		
		pageId="cpInserimentoOperatore"
		javascriptDetection="false">
<s:set name="cpInserimentoOperatore_tblInserimentoCorsiProfessionaliFinanziatiRegione_clearStatus" value="isTableClearStatus('cpInserimentoOperatore_tblInserimentoCorsiProfessionaliFinanziatiRegione')" />
<s:url id="cpInserimentoOperatoreViewUrl"						   
					   action="cpInserimentoOperatore"
					   namespace="/base/gestore"/>
<display:table name="appDataelencoCorsiProfessionaliFinanziatiDaRegione"  				
			   excludedParams="*"			   export="false"
               id="widg_tblInserimentoCorsiProfessionaliFinanziatiRegione"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpInserimentoOperatoreViewUrl}"  
               clearStatus="${cpInserimentoOperatore_tblInserimentoCorsiProfessionaliFinanziatiRegione_clearStatus}"
               uid="row_tblInserimentoCorsiProfessionaliFinanziatiRegione"
               summary="" 
decorator="it.csi.taif.topforweb.presentation.decorator.gestore.CpInserimentoOperatoreTblInserimentoCorsiProfessionaliFinanziatiRegioneCustomDecorator"               class="dataTable">
	
		<display:column property="agenziaFormativa" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.agenziaFormativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="unitaFormativa" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.unitaFormativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="titoloCorso" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.titoloCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="sedeCorso" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.sedeCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="periodoSvolgimento" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.periodoSvolgimento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="numeroOre" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.numeroOre.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="esitoCorso" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.esitoCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaAttestato" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.iconaAttestato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpInserimentoElencoCorsiFinanziatiRegione --></div>

	

		
	
</div>

	<!-- endFragment:p_fpWizardCorsiFinanziatiRegioneOperatore --></div>
