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
	
	
<h4 class="wpLabel">Dati anagrafici </h4>
<div class="widgetsPanel" id="wpInserimentoDatiAnagraficiOperatore">
	
	<customtag:widgetsPanel id="wpInserimentoDatiAnagraficiOperatoreTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoCodiceFiscale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoCodiceFiscale.label')}" labelFor="widg_tInserimentoCodiceFiscale" errorFor="widg_tInserimentoCodiceFiscale" labelId="tInserimentoCodiceFiscaleLbl"
	position="first"  >


<!-- widget tInserimentoCodiceFiscale -->
<s:textfield 
	
	
	name="widg_tInserimentoCodiceFiscale" id="widg_tInserimentoCodiceFiscale"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoCodiceFiscale')"
	size="30" 
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

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tfInserimentoOperatoreNrsiMsa.label')}" labelFor="widg_tfInserimentoOperatoreNrsiMsa" errorFor="widg_tfInserimentoOperatoreNrsiMsa" labelId="tfInserimentoOperatoreNrsiMsaLbl"
	position="first"  >


<!-- widget tfInserimentoOperatoreNrsiMsa -->
<s:textfield 
	
	
	name="widg_tfInserimentoOperatoreNrsiMsa" id="widg_tfInserimentoOperatoreNrsiMsa"
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

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoCognome.label')}" labelFor="widg_tInserimentoCognome" errorFor="widg_tInserimentoCognome" labelId="tInserimentoCognomeLbl"
	position="first"  >


<!-- widget tInserimentoCognome -->
<s:textfield 
	
	
	name="widg_tInserimentoCognome" id="widg_tInserimentoCognome"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoCognome')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoNome.label')}" labelFor="widg_tInserimentoNome" errorFor="widg_tInserimentoNome" labelId="tInserimentoNomeLbl"
	  >


<!-- widget tInserimentoNome -->
<s:textfield 
	
	
	name="widg_tInserimentoNome" id="widg_tInserimentoNome"
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

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.calInserimentoDataNascita.label')}" labelFor="widg_calInserimentoDataNascita" errorFor="widg_calInserimentoDataNascita" labelId="calInserimentoDataNascitaLbl"
	position="first"  >


<!-- widget calInserimentoDataNascita -->
<s:textfield 
	
	
	name="widg_calInserimentoDataNascita" id="widg_calInserimentoDataNascita"
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
<s:select name="appDataidNazioneNascitaSelezionata" id="widg_cbStatoNascitaOperatore"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoNazioni"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbStatoNascitaOperatore')"
	  listKey="code"
	  listValue="description"
	  
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


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','cbComuneResidenzaOperatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.cbComuneResidenzaOperatore.label')}" labelFor="widg_cbComuneResidenzaOperatore" errorFor="appDataidComuneResidenzaSelezionato" labelId="cbComuneResidenzaOperatoreLbl"
	  >


<!-- widget cbComuneResidenzaOperatore -->
<s:select name="appDataidComuneResidenzaSelezionato" id="widg_cbComuneResidenzaOperatore"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniRicercaOperatoreGestore"
	  disabled="isWidgetDisabled('cpInserimentoOperatore','cbComuneResidenzaOperatore')"
	  listKey="code"
	  listValue="description"
	  
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


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoIndirizzo.label')}" labelFor="widg_tInserimentoIndirizzo" errorFor="widg_tInserimentoIndirizzo" labelId="tInserimentoIndirizzoLbl"
	position="first"  >


<!-- widget tInserimentoIndirizzo -->
<s:textfield 
	
	
	name="widg_tInserimentoIndirizzo" id="widg_tInserimentoIndirizzo"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoIndirizzo')"
	size="60" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoCivico.label')}" labelFor="widg_tInserimentoCivico" errorFor="widg_tInserimentoCivico" labelId="tInserimentoCivicoLbl"
	  >


<!-- widget tInserimentoCivico -->
<s:textfield 
	
	
	name="widg_tInserimentoCivico" id="widg_tInserimentoCivico"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoCivico')"
	size="3" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoCAP')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoCAP.label')}" labelFor="widg_tInserimentoCAP" errorFor="widg_tInserimentoCAP" labelId="tInserimentoCAPLbl"
	  >


<!-- widget tInserimentoCAP -->
<s:textfield 
	
	
	name="widg_tInserimentoCAP" id="widg_tInserimentoCAP"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoCAP')"
	size="5" 
/>

	
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


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','tInserimentoTelefonoCellulare')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.tInserimentoTelefonoCellulare.label')}" labelFor="widg_tInserimentoTelefonoCellulare" errorFor="widg_tInserimentoTelefonoCellulare" labelId="tInserimentoTelefonoCellulareLbl"
	position="first"  >


<!-- widget tInserimentoTelefonoCellulare -->
<s:textfield 
	
title=""	
	name="widg_tInserimentoTelefonoCellulare" id="widg_tInserimentoTelefonoCellulare"
	disabled="isWidgetDisabled('cpInserimentoOperatore','tInserimentoTelefonoCellulare')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','ptAssociatoAziendaIscrittaAlboForestaleInserimento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpInserimentoOperatore.ptAssociatoAziendaIscrittaAlboForestaleInserimento.label')}" labelFor="widg_ptAssociatoAziendaIscrittaAlboForestaleInserimento" errorFor="widg_ptAssociatoAziendaIscrittaAlboForestaleInserimento" labelId="ptAssociatoAziendaIscrittaAlboForestaleInserimentoLbl"   >


<!-- widget ptAssociatoAziendaIscrittaAlboForestaleInserimento -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_7_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoDatiAnagraficiOperatore_7_3_fictitious_ -->


	
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


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','rbPubblicabilitaGroup')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserimentoOperatore.rbPubblicabilitaGroup.label')}" labelFor="widg_rbPubblicabilitaGroup" errorFor="widg_rbPubblicabilitaGroup" labelId="rbPubblicabilitaGroupLbl"
	position="first"  >


<!-- widget rbPubblicabilitaGroup -->

	
<div id="widg_rbPubblicabilitaGroup" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbPubblicabilitaSi" name="widg_rbPubblicabilitaGroup"
	list="#{'pubSi':'SI'}"
	disabled="isWidgetDisabled('cpInserimentoOperatore','rbPubblicabilitaGroup')"
	cssClass="radio"
	
	/> <label  for="widg_rbPubblicabilitaSipubSi"><s:text name="cpInserimentoOperatore.rbPubblicabilitaGroup.rbPubblicabilitaSi.label" /></label>








<s:radio
	
	
	id="widg_rbPubblicabilitaNo" name="widg_rbPubblicabilitaGroup"
	list="#{'pubNo':'NO'}"
	disabled="isWidgetDisabled('cpInserimentoOperatore','rbPubblicabilitaGroup')"
	cssClass="radio"
	
	/> <label  for="widg_rbPubblicabilitaNopubNo"><s:text name="cpInserimentoOperatore.rbPubblicabilitaGroup.rbPubblicabilitaNo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','ptStatoSchedaInserimentoOperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpInserimentoOperatore.ptStatoSchedaInserimentoOperatore.label')}" labelFor="widg_ptStatoSchedaInserimentoOperatore" errorFor="widg_ptStatoSchedaInserimentoOperatore" labelId="ptStatoSchedaInserimentoOperatoreLbl"   >


<!-- widget ptStatoSchedaInserimentoOperatore -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_8_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoDatiAnagraficiOperatore_8_3_fictitious_ -->


	
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


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_9_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpInserimentoDatiAnagraficiOperatore_9_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_9_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoDatiAnagraficiOperatore_9_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpInserimentoOperatore','wpInserimentoDatiAnagraficiOperatore_9_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpInserimentoDatiAnagraficiOperatore_9_3_fictitious_ -->


	
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



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInserimentoDatiAnagraficiOperatore --></div>

	

		
	
</div>

	<!-- endFragment:p_fpWizardDatiAnagraficiOperatore --></div>
