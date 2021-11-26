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

	
	<div id="p_fpWizardAltriCorsiOperatore" class="formPanelBlock"><!-- startFragment:p_fpWizardAltriCorsiOperatore -->
		
	
<div class="formPanel" id="fpWizardAltriCorsiOperatore">


	
	

	
	
			
	
	<div id="p_smpOperatore1.3" class="stdMessagePanelBlock"><!-- startFragment:p_smpOperatore1.3 -->
	
	
<div class="stdMessagePanel" id="smpOperatore1.3">
	<customtag:stdMessagePanel id="smpOperatore1.3" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpOperatore1.3 --></div>

			
	
	<div id="p_wpInserimentoAltriCorsi" class="widgetsPanelBlock"><!-- startFragment:p_wpInserimentoAltriCorsi -->
	
	
<h4 class="wpLabel"><s:text name="cpInserimentoOperatore.wpInserimentoAltriCorsi.label" /> <span id="toggle_wpInserimentoAltriCorsi"></span></h4>
<div class="widgetsPanel" id="wpInserimentoAltriCorsi">
	
	<customtag:widgetsPanel id="wpInserimentoAltriCorsiTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoAltroCorso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoAltroCorso.label')}" labelFor="widg_cbInserimentoAltroCorso" errorFor="appDataaltroCorsoSelezionatoInserimento.idCorsoProfessionale" labelId="cbInserimentoAltroCorsoLbl"
	position="first"  >


<!-- widget cbInserimentoAltroCorso -->

<s:url id="widg_cbInserimentoAltroCorsourlComboBoxValueChange"
   action="/topforweb/cpInserimentoOperatore!handleCbInserimentoAltroCorso_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataaltroCorsoSelezionatoInserimento.idCorsoProfessionale" id="widg_cbInserimentoAltroCorso"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoAltriCorsiDenominazioni"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoAltroCorso')"
	  listKey="idCorsoProfessionale"
	  listValue="titoloCorso"
	  onclick="onCBClick(this,'confermacbInserimentoAltroCorso','conferma','%{widg_cbInserimentoAltroCorsourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbInserimentoAltroCorso','conferma','%{widg_cbInserimentoAltroCorsourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoAltriCorsi_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoAltriCorsi_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_1_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoAltriCorsi_1_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tfDescrizioniAltriCorsi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tfDescrizioniAltriCorsi.label')}" labelFor="widg_tfDescrizioniAltriCorsi" errorFor="appDataaltroCorsoSelezionatoInserimento.descrizioneAltroCorso" labelId="tfDescrizioniAltriCorsiLbl"
	position="first"  >


<!-- widget tfDescrizioniAltriCorsi -->
<s:textfield 
	
	
	name="appDataaltroCorsoSelezionatoInserimento.descrizioneAltroCorso" id="widg_tfDescrizioniAltriCorsi"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tfDescrizioniAltriCorsi')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoAltriCorsi_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoAltriCorsi_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_2_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoAltriCorsi_2_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoAttestatoConScadenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoAttestatoConScadenza.label')}" labelFor="widg_cbInserimentoAttestatoConScadenza" errorFor="appDataaltroCorsoSelezionatoInserimento.attestatoConScadenza" labelId="cbInserimentoAttestatoConScadenzaLbl"
	position="first"  >


<!-- widget cbInserimentoAttestatoConScadenza -->
<s:select name="appDataaltroCorsoSelezionatoInserimento.attestatoConScadenza" id="widg_cbInserimentoAttestatoConScadenza"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoAttestatoConScadenzaInserimento"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoAttestatoConScadenza')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoEsitoAltroCorso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoEsitoAltroCorso.label')}" labelFor="widg_cbInserimentoEsitoAltroCorso" errorFor="appDataaltroCorsoSelezionatoInserimento.esitoCorso" labelId="cbInserimentoEsitoAltroCorsoLbl"
	  >


<!-- widget cbInserimentoEsitoAltroCorso -->
<s:select name="appDataaltroCorsoSelezionatoInserimento.esitoCorso" id="widg_cbInserimentoEsitoAltroCorso"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoEsitoCorso"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoEsitoAltroCorso')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_3_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoAltriCorsi_3_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_3_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoAltriCorsi_3_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','updFileAttestatoAltriCorsi')" >

	
<customtag:widgetsPanelColumn  tooltip="Selezionare il file da caricare" labelField="true" textLabel="%{getText('cpInserimentoOperatore.updFileAttestatoAltriCorsi.label')}" labelFor="widg_updFileAttestatoAltriCorsi" errorFor="widg_updFileAttestatoAltriCorsi" labelId="updFileAttestatoAltriCorsiLbl"
	position="first"  >


<s:file 
	
title="Selezionare il file da caricare"	
	name="widg_updFileAttestatoAltriCorsi" id="widg_updFileAttestatoAltriCorsi"
	disabled="isWidgetDisabled('cpInserimentoOperatore','updFileAttestatoAltriCorsi')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoAltriCorsi_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','btAggiungiAltriCorsiButton')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btAggiungiAltriCorsiButton -->
<s:submit name="widg_btAggiungiAltriCorsiButton" id="widg_btAggiungiAltriCorsiButton" method="handleBtAggiungiAltriCorsiButton_CLICKED"
	key="cpInserimentoOperatore.btAggiungiAltriCorsiButton.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btAggiungiAltriCorsiButton')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoAltriCorsi_4_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoAltriCorsi_4_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInserimentoAltriCorsi --></div>

			
	
	<div id="p_wpInserimentoElencoAltriCorsi" class="widgetsPanelBlock"><!-- startFragment:p_wpInserimentoElencoAltriCorsi -->
	
	

<div class="widgetsPanel" id="wpInserimentoElencoAltriCorsi">
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tblInserimentoAltriCorsi')" >

	
<div class="tableWidget">


<!-- widget tblInserimentoAltriCorsi -->
<s:set name="cpInserimentoOperatore_tblInserimentoAltriCorsi_clearStatus" value="isTableClearStatus('cpInserimentoOperatore_tblInserimentoAltriCorsi')" />
<s:url id="cpInserimentoOperatoreViewUrl"						   
					   action="cpInserimentoOperatore"
					   namespace="/base/gestore"/>
<display:table name="appDataelencoAltriCorsi"  				
			   excludedParams="*"			   export="false"
               id="widg_tblInserimentoAltriCorsi"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpInserimentoOperatoreViewUrl}"  
               clearStatus="${cpInserimentoOperatore_tblInserimentoAltriCorsi_clearStatus}"
               uid="row_tblInserimentoAltriCorsi"
               summary="" 
decorator="it.csi.taif.topforweb.presentation.decorator.gestore.CpInserimentoOperatoreTblInserimentoAltriCorsiCustomDecorator"               class="dataTable">
	
		<display:column  titleKey="cpInserimentoOperatore.tblInserimentoAltriCorsi.titoloCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpInserimentoOperatore!handleTblInserimentoAltriCorsi_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblInserimentoAltriCorsi.idCorsoProfessionale}"/>
				<s:param name="idColonna">titoloCorso</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblInserimentoAltriCorsi.titoloCorso}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpInserimentoOperatore.tblInserimentoAltriCorsi.descrizioneAltroCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpInserimentoOperatore!handleTblInserimentoAltriCorsi_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblInserimentoAltriCorsi.idCorsoProfessionale}"/>
				<s:param name="idColonna">descrizioneAltroCorso</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblInserimentoAltriCorsi.descrizioneAltroCorso}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpInserimentoOperatore.tblInserimentoAltriCorsi.dsEsitoCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpInserimentoOperatore!handleTblInserimentoAltriCorsi_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblInserimentoAltriCorsi.idCorsoProfessionale}"/>
				<s:param name="idColonna">dsEsitoCorso</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblInserimentoAltriCorsi.dsEsitoCorso}"/>
			</s:a>
			
		</display:column>
		<display:column  titleKey="cpInserimentoOperatore.tblInserimentoAltriCorsi.dsAttestatoConScadenza.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			<s:url id="targetUrlLinkableCell"						   
					action="cpInserimentoOperatore!handleTblInserimentoAltriCorsi_CLICKED"
					namespace="/base/gestore"
					includeParams="none">
				<s:param name="idRiga"  value="%{#attr.row_tblInserimentoAltriCorsi.idCorsoProfessionale}"/>
				<s:param name="idColonna">dsAttestatoConScadenza</s:param>
			</s:url>
			<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
				<s:property value="%{#attr.row_tblInserimentoAltriCorsi.dsAttestatoConScadenza}"/>
			</s:a>
			
		</display:column>
		<display:column property="iconaAllegato" titleKey="cpInserimentoOperatore.tblInserimentoAltriCorsi.iconaAllegato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaCancella" titleKey="cpInserimentoOperatore.tblInserimentoAltriCorsi.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpInserimentoElencoAltriCorsi --></div>

	

		
	
</div>

	<!-- endFragment:p_fpWizardAltriCorsiOperatore --></div>
