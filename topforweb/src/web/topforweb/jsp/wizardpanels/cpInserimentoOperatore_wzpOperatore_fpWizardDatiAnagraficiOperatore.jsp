#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpWizardDatiAnagraficiOperatore" class="formPanelBlock"><!-- startFragment:p_fpWizardDatiAnagraficiOperatore -->
		
	
<div class="formPanel" id="fpWizardDatiAnagraficiOperatore">


	
	

	
	
			
	
	<div id="p_smpOperatore1.1" class="stdMessagePanelBlock"><!-- startFragment:p_smpOperatore1.1 -->
	
	
<div class="stdMessagePanel" id="smpOperatore1.1">
	<customtag:stdMessagePanel id="smpOperatore1.1" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpOperatore1.1 --></div>

			
	
	<div id="p_wpInserimentoDatiAnagraficiOperatore" class="widgetsPanelBlock"><!-- startFragment:p_wpInserimentoDatiAnagraficiOperatore -->
	
	
<h4 class="wpLabel"><s:text name="cpInserimentoOperatore.wpInserimentoDatiAnagraficiOperatore.label" /> </h4>
<div class="widgetsPanel" id="wpInserimentoDatiAnagraficiOperatore">
	
	<customtag:widgetsPanel id="wpInserimentoDatiAnagraficiOperatoreTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoCodiceFiscale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoCodiceFiscale.label')}" labelFor="widg_tInserimentoCodiceFiscale" errorFor="appDatadatiOperatore.codiceFiscaleOperatore" labelId="tInserimentoCodiceFiscaleLbl"
	position="first"  >


<!-- widget tInserimentoCodiceFiscale -->
<s:textfield 
	
	
	name="appDatadatiOperatore.codiceFiscaleOperatore" id="widg_tInserimentoCodiceFiscale"
maxlength="16"	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoCodiceFiscale')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','btnCercaOperatoreAnagraficaIt')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCercaOperatoreAnagraficaIt -->
<s:submit name="widg_btnCercaOperatoreAnagraficaIt" id="widg_btnCercaOperatoreAnagraficaIt" method="handleBtnCercaOperatoreAnagraficaIt_CLICKED"
	key="cpInserimentoOperatore.btnCercaOperatoreAnagraficaIt.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btnCercaOperatoreAnagraficaIt')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoDatiAnagraficiOperatore_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_1_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoDatiAnagraficiOperatore_1_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tfInserimentoOperatoreNrsiMsa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tfInserimentoOperatoreNrsiMsa.label')}" labelFor="widg_tfInserimentoOperatoreNrsiMsa" errorFor="appDatadatiOperatore.nRsiMsa" labelId="tfInserimentoOperatoreNrsiMsaLbl"
	position="first"  >


<!-- widget tfInserimentoOperatoreNrsiMsa -->
<s:textfield 
	
	
	name="appDatadatiOperatore.nRsiMsa" id="widg_tfInserimentoOperatoreNrsiMsa"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tfInserimentoOperatoreNrsiMsa')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','btnCercaOperatoreFr')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCercaOperatoreFr -->
<s:submit name="widg_btnCercaOperatoreFr" id="widg_btnCercaOperatoreFr" method="handleBtnCercaOperatoreFr_CLICKED"
	key="cpInserimentoOperatore.btnCercaOperatoreFr.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('cpInserimentoOperatore','btnCercaOperatoreFr')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoDatiAnagraficiOperatore_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_2_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoDatiAnagraficiOperatore_2_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoCognome.label')}" labelFor="widg_tInserimentoCognome" errorFor="appDatadatiOperatore.cognomeOperatore" labelId="tInserimentoCognomeLbl"
	position="first"  >


<!-- widget tInserimentoCognome -->
<s:textfield 
	
	
	name="appDatadatiOperatore.cognomeOperatore" id="widg_tInserimentoCognome"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoCognome')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoNome.label')}" labelFor="widg_tInserimentoNome" errorFor="appDatadatiOperatore.nomeOperatore" labelId="tInserimentoNomeLbl"
	  >


<!-- widget tInserimentoNome -->
<s:textfield 
	
	
	name="appDatadatiOperatore.nomeOperatore" id="widg_tInserimentoNome"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoNome')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_3_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoDatiAnagraficiOperatore_3_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_3_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoDatiAnagraficiOperatore_3_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','calInserimentoDataNascita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.calInserimentoDataNascita.label')}" labelFor="widg_calInserimentoDataNascita" errorFor="appDatadatiOperatore.dataNascitaOperatore" labelId="calInserimentoDataNascitaLbl"
	position="first"  >


<!-- widget calInserimentoDataNascita -->
<s:textfield 
	
	
	name="appDatadatiOperatore.dataNascitaOperatore" id="widg_calInserimentoDataNascita"
	disabled="isWidgetDisabled('cpInserimentoOperatore','calInserimentoDataNascita')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbStatoNascitaOperatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbStatoNascitaOperatore.label')}" labelFor="widg_cbStatoNascitaOperatore" errorFor="appDataidNazioneNascitaSelezionata" labelId="cbStatoNascitaOperatoreLbl"
	  >


<!-- widget cbStatoNascitaOperatore -->

<s:url id="widg_cbStatoNascitaOperatoreurlComboBoxValueChange"
   action="/topforweb/cpInserimentoOperatore!handleCbStatoNascitaOperatore_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidNazioneNascitaSelezionata" id="widg_cbStatoNascitaOperatore"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoNazioni"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbStatoNascitaOperatore')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbStatoNascitaOperatore','conferma','%{widg_cbStatoNascitaOperatoreurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbStatoNascitaOperatore','conferma','%{widg_cbStatoNascitaOperatoreurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_4_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoDatiAnagraficiOperatore_4_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_4_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoDatiAnagraficiOperatore_4_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbComuneNascitaOperatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbComuneNascitaOperatore.label')}" labelFor="widg_cbComuneNascitaOperatore" errorFor="appDataidComuneNascitaSelezionato" labelId="cbComuneNascitaOperatoreLbl"
	position="first"  >


<!-- widget cbComuneNascitaOperatore -->
<s:select name="appDataidComuneNascitaSelezionato" id="widg_cbComuneNascitaOperatore"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniRicercaOperatoreGestore"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbComuneNascitaOperatore')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tComuneNascitaEstero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tComuneNascitaEstero.label')}" labelFor="widg_tComuneNascitaEstero" errorFor="appDatadatiOperatore.comuneEsteroNascitaOperatore" labelId="tComuneNascitaEsteroLbl"
	  >


<!-- widget tComuneNascitaEstero -->
<s:textfield 
	
	
	name="appDatadatiOperatore.comuneEsteroNascitaOperatore" id="widg_tComuneNascitaEstero"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tComuneNascitaEstero')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_5_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoDatiAnagraficiOperatore_5_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_5_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoDatiAnagraficiOperatore_5_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbComuneResidenzaOperatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbComuneResidenzaOperatore.label')}" labelFor="widg_cbComuneResidenzaOperatore" errorFor="appDataidComuneResidenzaSelezionato" labelId="cbComuneResidenzaOperatoreLbl"
	position="first"  >


<!-- widget cbComuneResidenzaOperatore -->

<s:url id="widg_cbComuneResidenzaOperatoreurlComboBoxValueChange"
   action="/topforweb/cpInserimentoOperatore!handleCbComuneResidenzaOperatore_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidComuneResidenzaSelezionato" id="widg_cbComuneResidenzaOperatore"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniRicercaOperatoreGestore"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbComuneResidenzaOperatore')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbComuneResidenzaOperatore','conferma','%{widg_cbComuneResidenzaOperatoreurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComuneResidenzaOperatore','conferma','%{widg_cbComuneResidenzaOperatoreurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tComuneEsteroResidenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tComuneEsteroResidenza.label')}" labelFor="widg_tComuneEsteroResidenza" errorFor="appDatadatiOperatore.comuneEsteroResidenzaOperatore" labelId="tComuneEsteroResidenzaLbl"
	  >


<!-- widget tComuneEsteroResidenza -->
<s:textfield 
	
	
	name="appDatadatiOperatore.comuneEsteroResidenzaOperatore" id="widg_tComuneEsteroResidenza"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tComuneEsteroResidenza')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_6_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoDatiAnagraficiOperatore_6_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_6_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoDatiAnagraficiOperatore_6_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoIndirizzo.label')}" labelFor="widg_tInserimentoIndirizzo" errorFor="appDatadatiOperatore.indirizzoResidenzaOperatore" labelId="tInserimentoIndirizzoLbl"
	position="first"  >


<!-- widget tInserimentoIndirizzo -->
<s:textfield 
	
	
	name="appDatadatiOperatore.indirizzoResidenzaOperatore" id="widg_tInserimentoIndirizzo"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoIndirizzo')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoCivico.label')}" labelFor="widg_tInserimentoCivico" errorFor="appDatadatiOperatore.civicoResidenzaOperatore" labelId="tInserimentoCivicoLbl"
	  >


<!-- widget tInserimentoCivico -->
<s:textfield 
	
	
	name="appDatadatiOperatore.civicoResidenzaOperatore" id="widg_tInserimentoCivico"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoCivico')"
	size="3" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoCAP')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoCAP.label')}" labelFor="widg_tInserimentoCAP" errorFor="appDatadatiOperatore.capResidenzaOperatore" labelId="tInserimentoCAPLbl"
	  >


<!-- widget tInserimentoCAP -->
<s:textfield 
	
	
	name="appDatadatiOperatore.capResidenzaOperatore" id="widg_tInserimentoCAP"
maxlength="5"	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoCAP')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_7_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoDatiAnagraficiOperatore_7_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoTelefono')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoTelefono.label')}" labelFor="widg_tInserimentoTelefono" errorFor="appDatadatiOperatore.telefonoOperatore" labelId="tInserimentoTelefonoLbl"
	position="first"  >


<!-- widget tInserimentoTelefono -->
<s:textfield 
	
title=""	
	name="appDatadatiOperatore.telefonoOperatore" id="widg_tInserimentoTelefono"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoTelefono')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoCellulare')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoCellulare.label')}" labelFor="widg_tInserimentoCellulare" errorFor="appDatadatiOperatore.cellulareOperatore" labelId="tInserimentoCellulareLbl"
	  >


<!-- widget tInserimentoCellulare -->
<s:textfield 
	
title=""	
	name="appDatadatiOperatore.cellulareOperatore" id="widg_tInserimentoCellulare"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoCellulare')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoEmail.label')}" labelFor="widg_tInserimentoEmail" errorFor="appDatadatiOperatore.emailOperatore" labelId="tInserimentoEmailLbl"
	  >


<!-- widget tInserimentoEmail -->
<s:textfield 
	
title=""	
	name="appDatadatiOperatore.emailOperatore" id="widg_tInserimentoEmail"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoEmail')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_8_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoDatiAnagraficiOperatore_8_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','ptAssociatoAziendaIscrittaAlboForestaleInserimento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpInserimentoOperatore.ptAssociatoAziendaIscrittaAlboForestaleInserimento.label')}" labelFor="widg_ptAssociatoAziendaIscrittaAlboForestaleInserimento" errorFor="appDatadatiOperatore.associatoAziendaIscrittaAlboForestaleENumeroAlbo" labelId="ptAssociatoAziendaIscrittaAlboForestaleInserimentoLbl"  position="first" >


<!-- widget ptAssociatoAziendaIscrittaAlboForestaleInserimento -->
<s:property value="appDatadatiOperatore.associatoAziendaIscrittaAlboForestaleENumeroAlbo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','rbPubblicabilitaGroup')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.rbPubblicabilitaGroup.label')}" labelFor="widg_rbPubblicabilitaGroup" errorFor="appDatadatiOperatore.statoOperatore" labelId="rbPubblicabilitaGroupLbl"
	  >


<!-- widget rbPubblicabilitaGroup -->

	
<div id="appDatadatiOperatore.statoOperatore" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbPubblicabilitaSi" name="appDatadatiOperatore.statoOperatore"
	list="#{'pubSi':'SI'}"
	disabled="isWidgetDisabled('cpInserimentoOperatore','rbPubblicabilitaGroup')"
	cssClass="radio"
	
	/> <label  for="widg_rbPubblicabilitaSipubSi"><s:text name="cpInserimentoOperatore.rbPubblicabilitaGroup.rbPubblicabilitaSi.label" /></label>








<s:radio
	
	
	id="widg_rbPubblicabilitaNo" name="appDatadatiOperatore.statoOperatore"
	list="#{'pubNo':'NO'}"
	disabled="isWidgetDisabled('cpInserimentoOperatore','rbPubblicabilitaGroup')"
	cssClass="radio"
	
	/> <label  for="widg_rbPubblicabilitaNopubNo"><s:text name="cpInserimentoOperatore.rbPubblicabilitaGroup.rbPubblicabilitaNo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbStatoSchedaInserimento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbStatoSchedaInserimento.label')}" labelFor="widg_cbStatoSchedaInserimento" errorFor="appDataidStatoSchedaSelezionato" labelId="cbStatoSchedaInserimentoLbl"
	  >


<!-- widget cbStatoSchedaInserimento -->

<s:url id="widg_cbStatoSchedaInserimentourlComboBoxValueChange"
   action="/topforweb/cpInserimentoOperatore!handleCbStatoSchedaInserimento_VALUE_CHANGED" namespace="/base/gestore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidStatoSchedaSelezionato" id="widg_cbStatoSchedaInserimento"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoSchedaRicerca"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbStatoSchedaInserimento')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbStatoSchedaInserimento','conferma','%{widg_cbStatoSchedaInserimentourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbStatoSchedaInserimento','conferma','%{widg_cbStatoSchedaInserimentourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_9_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInserimentoDatiAnagraficiOperatore_9_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoMotivazioneRifiutoValidazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoMotivazioneRifiutoValidazione.label')}" labelFor="widg_tInserimentoMotivazioneRifiutoValidazione" errorFor="appDatamotivazioneRifiutoValidazione" labelId="tInserimentoMotivazioneRifiutoValidazioneLbl"
	position="first" colSpan="5" >


<!-- widget tInserimentoMotivazioneRifiutoValidazione -->
<s:textfield 
	
title=""	
	name="appDatamotivazioneRifiutoValidazione" id="widg_tInserimentoMotivazioneRifiutoValidazione"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoMotivazioneRifiutoValidazione')"
	size="120" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="6" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInserimentoDatiAnagraficiOperatore --></div>

			
	
	<div id="p_wpConsensoPrivacy" class="widgetsPanelBlock"><!-- startFragment:p_wpConsensoPrivacy -->
	
	

<div class="widgetsPanel" id="wpConsensoPrivacy">
	
	<customtag:widgetsPanel id="wpConsensoPrivacyTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="0,100">
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','udwConsensoPrivacy')" >

	
<customtag:widgetsPanelColumn 
	position="first" colSpan="2" >


<s:include value="/jsp/userwidgets/cpInserimentoOperatore_udwConsensoPrivacy.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','chbPrivacy')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.chbPrivacy.label')}" labelFor="widg_chbPrivacy" errorFor="appDataprivacy" labelId="chbPrivacyLbl"
	position="first"  >


<!-- widget chbPrivacy -->
<s:checkbox 
	
	
	name="appDataprivacy" id="widg_chbPrivacy"
	disabled="isWidgetDisabled('cpInserimentoOperatore','chbPrivacy')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpInserimentoOperatore','chbPrivacy')" >
	<s:hidden name="__checkbox_appDataprivacy" id="__checkbox_widg_chbPrivacy" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpConsensoPrivacy --></div>

			
	
	<div id="p_wpConsensoPubblicazione" class="widgetsPanelBlock"><!-- startFragment:p_wpConsensoPubblicazione -->
	
	

<div class="widgetsPanel" id="wpConsensoPubblicazione">
	
	<customtag:widgetsPanel id="wpConsensoPubblicazioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="0,100">
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','udwConsensoPubblicazione')" >

	
<customtag:widgetsPanelColumn 
	position="first" colSpan="2" >


<s:include value="/jsp/userwidgets/cpInserimentoOperatore_udwConsensoPubblicazione.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','chbPubblicazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.chbPubblicazione.label')}" labelFor="widg_chbPubblicazione" errorFor="appDataconsensoPubblicazione" labelId="chbPubblicazioneLbl"
	position="first"  >


<!-- widget chbPubblicazione -->
<s:checkbox 
	
	
	name="appDataconsensoPubblicazione" id="widg_chbPubblicazione"
	disabled="isWidgetDisabled('cpInserimentoOperatore','chbPubblicazione')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpInserimentoOperatore','chbPubblicazione')" >
	<s:hidden name="__checkbox_appDataconsensoPubblicazione" id="__checkbox_widg_chbPubblicazione" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpConsensoPubblicazione --></div>

	

		
	
</div>

	<!-- endFragment:p_fpWizardDatiAnagraficiOperatore --></div>
