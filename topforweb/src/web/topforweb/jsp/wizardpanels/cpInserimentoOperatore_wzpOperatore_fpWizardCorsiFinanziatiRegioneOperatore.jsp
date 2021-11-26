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
	
	
<h4 class="wpLabel"><s:text name="cpInserimentoOperatore.wpInserimentoCorsiFinanziatiRegione.label" /> <span id="toggle_wpInserimentoCorsiFinanziatiRegione"></span></h4>
<div class="widgetsPanel" id="wpInserimentoCorsiFinanziatiRegione">
	
	<customtag:widgetsPanel id="wpInserimentoCorsiFinanziatiRegioneTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoAgenziaFormativa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoAgenziaFormativa.label')}" labelFor="widg_cbInserimentoAgenziaFormativa" errorFor="appDataidAgenziaFormativaSelezionata" labelId="cbInserimentoAgenziaFormativaLbl"
	position="first"  >


<!-- widget cbInserimentoAgenziaFormativa -->

<s:url id="widg_cbInserimentoAgenziaFormativaurlComboBoxValueChange"
   action="/topforweb/cpInserimentoOperatore!handleCbInserimentoAgenziaFormativa_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidAgenziaFormativaSelezionata" id="widg_cbInserimentoAgenziaFormativa"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoAgenziaFormativaRicercaOperatore"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoAgenziaFormativa')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbInserimentoAgenziaFormativa','conferma','%{widg_cbInserimentoAgenziaFormativaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbInserimentoAgenziaFormativa','conferma','%{widg_cbInserimentoAgenziaFormativaurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_1_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoCorsiFinanziatiRegione_1_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoUnitaFormativa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoUnitaFormativa.label')}" labelFor="widg_cbInserimentoUnitaFormativa" errorFor="appDataidUnitaFormativaSelezionata" labelId="cbInserimentoUnitaFormativaLbl"
	position="first"  >


<!-- widget cbInserimentoUnitaFormativa -->

<s:url id="widg_cbInserimentoUnitaFormativaurlComboBoxValueChange"
   action="/topforweb/cpInserimentoOperatore!handleCbInserimentoUnitaFormativa_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidUnitaFormativaSelezionata" id="widg_cbInserimentoUnitaFormativa"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUnitaFormativaCorsiFinanziati"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoUnitaFormativa')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbInserimentoUnitaFormativa','conferma','%{widg_cbInserimentoUnitaFormativaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbInserimentoUnitaFormativa','conferma','%{widg_cbInserimentoUnitaFormativaurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_2_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoCorsiFinanziatiRegione_2_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoTitoloCorso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoTitoloCorso.label')}" labelFor="widg_cbInserimentoTitoloCorso" errorFor="appDataidTitoloCorsoSelezionato" labelId="cbInserimentoTitoloCorsoLbl"
	position="first"  >


<!-- widget cbInserimentoTitoloCorso -->

<s:url id="widg_cbInserimentoTitoloCorsourlComboBoxValueChange"
   action="/topforweb/cpInserimentoOperatore!handleCbInserimentoTitoloCorso_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidTitoloCorsoSelezionato" id="widg_cbInserimentoTitoloCorso"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTitoloCorso"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoTitoloCorso')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbInserimentoTitoloCorso','conferma','%{widg_cbInserimentoTitoloCorsourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbInserimentoTitoloCorso','conferma','%{widg_cbInserimentoTitoloCorsourlComboBoxValueChange}')" 
	  />


	
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

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoCorsiFinanziatiRegione_3_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','ptInserimentoNumeroOreCorso')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpInserimentoOperatore.ptInserimentoNumeroOreCorso.label')}" labelFor="widg_ptInserimentoNumeroOreCorso" errorFor="appDatacorsoSelezionatoInserimento.numeroOre" labelId="ptInserimentoNumeroOreCorsoLbl"  position="first" >


<!-- widget ptInserimentoNumeroOreCorso -->
<s:property value="appDatacorsoSelezionatoInserimento.numeroOre" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_4_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_4_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_4_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoCorsiFinanziatiRegione_4_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','ptInserimentoSedeCorso')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpInserimentoOperatore.ptInserimentoSedeCorso.label')}" labelFor="widg_ptInserimentoSedeCorso" errorFor="appDatacorsoSelezionatoInserimento.sedeCorso" labelId="ptInserimentoSedeCorsoLbl"  position="first" >


<!-- widget ptInserimentoSedeCorso -->
<s:property value="appDatacorsoSelezionatoInserimento.sedeCorso" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_5_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_5_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_5_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoCorsiFinanziatiRegione_5_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoEsitoCorso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoEsitoCorso.label')}" labelFor="widg_cbInserimentoEsitoCorso" errorFor="appDataidEsitoCorsoSelezionato" labelId="cbInserimentoEsitoCorsoLbl"
	position="first"  >


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
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_6_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_6_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_6_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoCorsiFinanziatiRegione_6_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','updFileAttestatoCorsoRegione')" >

	
<customtag:widgetsPanelColumn  tooltip="Selezionare il file da caricare" labelField="true" textLabel="%{getText('cpInserimentoOperatore.updFileAttestatoCorsoRegione.label')}" labelFor="widg_updFileAttestatoCorsoRegione" errorFor="widg_updFileAttestatoCorsoRegione" labelId="updFileAttestatoCorsoRegioneLbl"
	position="first"  >


<s:file 
	
title="Selezionare il file da caricare"	
	name="widg_updFileAttestatoCorsoRegione" id="widg_updFileAttestatoCorsoRegione"
	disabled="isWidgetDisabled('cpInserimentoOperatore','updFileAttestatoCorsoRegione')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','btAggiungiCorsoFinanziatoRegione')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btAggiungiCorsoFinanziatoRegione -->
<s:submit name="widg_btAggiungiCorsoFinanziatoRegione" id="widg_btAggiungiCorsoFinanziatoRegione" method="handleBtAggiungiCorsoFinanziatoRegione_CLICKED"
	key="cpInserimentoOperatore.btAggiungiCorsoFinanziatoRegione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btAggiungiCorsoFinanziatoRegione')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_7_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoCorsiFinanziatiRegione_7_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoCorsiFinanziatiRegione_7_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoCorsiFinanziatiRegione_7_4_fictitious_ -->


	
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
	
		<display:column property="dsAgenziaFormativa" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.dsAgenziaFormativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dsUnitaFormativa" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.dsUnitaFormativa.label" 
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
		<display:column property="dsEsitoCorso" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.dsEsitoCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaAttestato" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.iconaAttestato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaAllegato" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.iconaAllegato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaCancella" titleKey="cpInserimentoOperatore.tblInserimentoCorsiProfessionaliFinanziatiRegione.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpInserimentoElencoCorsiFinanziatiRegione --></div>

	

		
	
</div>

	<!-- endFragment:p_fpWizardCorsiFinanziatiRegioneOperatore --></div>
