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

	
	<div id="p_fpWizardRiconoscimentiOperatore" class="formPanelBlock"><!-- startFragment:p_fpWizardRiconoscimentiOperatore -->
		
	
<div class="formPanel" id="fpWizardRiconoscimentiOperatore">


	
	

	
	
			
	
	<div id="p_smpOperatore1.2" class="stdMessagePanelBlock"><!-- startFragment:p_smpOperatore1.2 -->
	
	
<div class="stdMessagePanel" id="smpOperatore1.2">
	<customtag:stdMessagePanel id="smpOperatore1.2" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpOperatore1.2 --></div>

			
	
	<div id="p_wpRiconoscimenti" class="widgetsPanelBlock"><!-- startFragment:p_wpRiconoscimenti -->
	
	
<h4 class="wpLabel"><s:text name="cpInserimentoOperatore.wpRiconoscimenti.label" /> <span id="toggle_wpRiconoscimenti"></span></h4>
<div class="widgetsPanel" id="wpRiconoscimenti">
	
	<customtag:widgetsPanel id="wpRiconoscimentiTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoAgenziaFormativaRiconoscimento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoAgenziaFormativaRiconoscimento.label')}" labelFor="widg_cbInserimentoAgenziaFormativaRiconoscimento" errorFor="appDatariconoscimentoSelezionatoInserimento.agenziaFormativa" labelId="cbInserimentoAgenziaFormativaRiconoscimentoLbl"
	position="first"  >


<!-- widget cbInserimentoAgenziaFormativaRiconoscimento -->

<s:url id="widg_cbInserimentoAgenziaFormativaRiconoscimentourlComboBoxValueChange"
   action="/topforweb/cpInserimentoOperatore!handleCbInserimentoAgenziaFormativaRiconoscimento_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatariconoscimentoSelezionatoInserimento.agenziaFormativa" id="widg_cbInserimentoAgenziaFormativaRiconoscimento"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoAgenziaFormativaRicercaOperatore"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoAgenziaFormativaRiconoscimento')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbInserimentoAgenziaFormativaRiconoscimento','conferma','%{widg_cbInserimentoAgenziaFormativaRiconoscimentourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbInserimentoAgenziaFormativaRiconoscimento','conferma','%{widg_cbInserimentoAgenziaFormativaRiconoscimentourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpRiconoscimenti_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRiconoscimenti_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpRiconoscimenti_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRiconoscimenti_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbInserimentoUnitaFormativaRiconoscimento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbInserimentoUnitaFormativaRiconoscimento.label')}" labelFor="widg_cbInserimentoUnitaFormativaRiconoscimento" errorFor="appDatariconoscimentoSelezionatoInserimento.unitaFormativa" labelId="cbInserimentoUnitaFormativaRiconoscimentoLbl"
	position="first"  >


<!-- widget cbInserimentoUnitaFormativaRiconoscimento -->

<s:url id="widg_cbInserimentoUnitaFormativaRiconoscimentourlComboBoxValueChange"
   action="/topforweb/cpInserimentoOperatore!handleCbInserimentoUnitaFormativaRiconoscimento_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatariconoscimentoSelezionatoInserimento.unitaFormativa" id="widg_cbInserimentoUnitaFormativaRiconoscimento"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUnitaFormativaRiconoscimento"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbInserimentoUnitaFormativaRiconoscimento')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbInserimentoUnitaFormativaRiconoscimento','conferma','%{widg_cbInserimentoUnitaFormativaRiconoscimentourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbInserimentoUnitaFormativaRiconoscimento','conferma','%{widg_cbInserimentoUnitaFormativaRiconoscimentourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpRiconoscimenti_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRiconoscimenti_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpRiconoscimenti_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRiconoscimenti_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tfNoteRiconoscimento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tfNoteRiconoscimento.label')}" labelFor="widg_tfNoteRiconoscimento" errorFor="appDatariconoscimentoSelezionatoInserimento.note" labelId="tfNoteRiconoscimentoLbl"
	position="first"  >


<!-- widget tfNoteRiconoscimento -->
<s:textfield 
	
	
	name="appDatariconoscimentoSelezionatoInserimento.note" id="widg_tfNoteRiconoscimento"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tfNoteRiconoscimento')"
	size="60" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpRiconoscimenti_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpRiconoscimenti_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpRiconoscimenti_3_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRiconoscimenti_3_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','calDataRiconoscimento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.calDataRiconoscimento.label')}" labelFor="widg_calDataRiconoscimento" errorFor="appDatariconoscimentoSelezionatoInserimento.dataRiconoscimento" labelId="calDataRiconoscimentoLbl"
	position="first"  >


<!-- widget calDataRiconoscimento -->
<s:textfield 
	
	
	name="appDatariconoscimentoSelezionatoInserimento.dataRiconoscimento" id="widg_calDataRiconoscimento"
	disabled="isWidgetDisabled('cpInserimentoOperatore','calDataRiconoscimento')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','btAggiungiRiconoscimento')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btAggiungiRiconoscimento -->
<s:submit name="widg_btAggiungiRiconoscimento" id="widg_btAggiungiRiconoscimento" method="handleBtAggiungiRiconoscimento_CLICKED"
	key="cpInserimentoOperatore.btAggiungiRiconoscimento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btAggiungiRiconoscimento')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpRiconoscimenti_4_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRiconoscimenti_4_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRiconoscimenti --></div>

			
	
	<div id="p_wpInserimentoRiconoscimenti" class="widgetsPanelBlock"><!-- startFragment:p_wpInserimentoRiconoscimenti -->
	
	

<div class="widgetsPanel" id="wpInserimentoRiconoscimenti">
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tblInserimentoRiconoscimenti')" >

	
<div class="tableWidget">


<!-- widget tblInserimentoRiconoscimenti -->
	<csiuicore:ajaxify id="p_wpInserimentoRiconoscimenti" 
		widgetType="table"		
		pageId="cpInserimentoOperatore"
		javascriptDetection="false">
<s:set name="cpInserimentoOperatore_tblInserimentoRiconoscimenti_clearStatus" value="isTableClearStatus('cpInserimentoOperatore_tblInserimentoRiconoscimenti')" />
<s:url id="cpInserimentoOperatoreViewUrl"						   
					   action="cpInserimentoOperatore"
					   namespace="/base/gestore"/>
<display:table name="appDataelencoRiconoscimento"  				
			   excludedParams="*"			   export="false"
               id="widg_tblInserimentoRiconoscimenti"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpInserimentoOperatoreViewUrl}"  
               clearStatus="${cpInserimentoOperatore_tblInserimentoRiconoscimenti_clearStatus}"
               uid="row_tblInserimentoRiconoscimenti"
               summary="" 
decorator="it.csi.taif.topforweb.presentation.decorator.gestore.CpInserimentoOperatoreTblInserimentoRiconoscimentiCustomDecorator"               class="dataTable">
	
		<display:column property="agenziaFormativa" titleKey="cpInserimentoOperatore.tblInserimentoRiconoscimenti.agenziaFormativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="unitaFormativa" titleKey="cpInserimentoOperatore.tblInserimentoRiconoscimenti.unitaFormativa.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataRiconoscimento" titleKey="cpInserimentoOperatore.tblInserimentoRiconoscimenti.dataRiconoscimento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="note" titleKey="cpInserimentoOperatore.tblInserimentoRiconoscimenti.note.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaCancella" titleKey="cpInserimentoOperatore.tblInserimentoRiconoscimenti.iconaCancella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpInserimentoRiconoscimenti --></div>

	

		
	
</div>

	<!-- endFragment:p_fpWizardRiconoscimentiOperatore --></div>
