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

	
	<div id="p_fpDatiAnagraficiConduttoreAzienda" class="formPanelBlock"><!-- startFragment:p_fpDatiAnagraficiConduttoreAzienda -->
		
	
<div class="formPanel" id="fpDatiAnagraficiConduttoreAzienda">


	
	

	
	
			
	
	<div id="p_wpDatiAnagraficiConduttoreAzienda" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiConduttoreAzienda -->
	
	

<div class="widgetsPanel" id="wpDatiAnagraficiConduttoreAzienda">
	
	<customtag:widgetsPanel id="wpDatiAnagraficiConduttoreAziendaTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleCodiceFiscale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAltroTitolareRappresentanteLegaleCodiceFiscale.label')}" labelFor="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleCodiceFiscale" errorFor="appDataaltroTitolareRappresentanteLegale.codiceFiscale" labelId="tfDatiAnagraficiAltroTitolareRappresentanteLegaleCodiceFiscaleLbl"
	position="first"  >


<!-- widget tfDatiAnagraficiAltroTitolareRappresentanteLegaleCodiceFiscale -->
<s:textfield 
	
title=""	
	name="appDataaltroTitolareRappresentanteLegale.codiceFiscale" id="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleCodiceFiscale"
maxlength="16"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleCodiceFiscale')"
	size="16" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','btnCercaAltroTitolareAnagrafica')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCercaAltroTitolareAnagrafica -->
<s:submit name="widg_btnCercaAltroTitolareAnagrafica" id="widg_btnCercaAltroTitolareAnagrafica" method="handleBtnCercaAltroTitolareAnagrafica_CLICKED"
	key="CpDomanda.btnCercaAltroTitolareAnagrafica.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('CpDomanda','btnCercaAltroTitolareAnagrafica')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiConduttoreAzienda_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpDatiAnagraficiConduttoreAzienda_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiConduttoreAzienda_1_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiAnagraficiConduttoreAzienda_1_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAltroTitolareRappresentanteLegaleCognome.label')}" labelFor="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleCognome" errorFor="appDataaltroTitolareRappresentanteLegale.cognome" labelId="tfDatiAnagraficiAltroTitolareRappresentanteLegaleCognomeLbl"
	position="first" colSpan="3" >


<!-- widget tfDatiAnagraficiAltroTitolareRappresentanteLegaleCognome -->
<s:textfield 
	
title=""	
	name="appDataaltroTitolareRappresentanteLegale.cognome" id="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleCognome"
maxlength="15"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleCognome')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAltroTitolareRappresentanteLegaleNome.label')}" labelFor="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleNome" errorFor="appDataaltroTitolareRappresentanteLegale.nome" labelId="tfDatiAnagraficiAltroTitolareRappresentanteLegaleNomeLbl"
	position="last" colSpan="3" >


<!-- widget tfDatiAnagraficiAltroTitolareRappresentanteLegaleNome -->
<s:textfield 
	
title=""	
	name="appDataaltroTitolareRappresentanteLegale.nome" id="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleNome"
maxlength="15"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleNome')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','calDatiAnagraficiAltroTitolareRappresentanteLegaleDataNascita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.calDatiAnagraficiAltroTitolareRappresentanteLegaleDataNascita.label')}" labelFor="widg_calDatiAnagraficiAltroTitolareRappresentanteLegaleDataNascita" errorFor="appDataaltroTitolareRappresentanteLegale.dataNascita" labelId="calDatiAnagraficiAltroTitolareRappresentanteLegaleDataNascitaLbl"
	position="first"  >


<!-- widget calDatiAnagraficiAltroTitolareRappresentanteLegaleDataNascita -->
<s:textfield 
	
	
	name="appDataaltroTitolareRappresentanteLegale.dataNascita" id="widg_calDatiAnagraficiAltroTitolareRappresentanteLegaleDataNascita"
	disabled="isWidgetDisabled('CpDomanda','calDatiAnagraficiAltroTitolareRappresentanteLegaleDataNascita')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita.label')}" labelFor="widg_cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita" errorFor="appDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale" labelId="cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascitaLbl"
	  >


<!-- widget cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita -->
	<csiuicore:ajaxify id="p_wpDatiAnagraficiConduttoreAzienda" 
		widgetType="combo" 
		requestUri="/taifweb/base/domanda/CpDomanda!handleCbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita_VALUE_CHANGED.do"
		pageId="CpDomanda"
		formName="CpDomanda"
		javascriptDetection="false"
		nameSpace="/base/domanda">

<s:url id="widg_cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascitaurlComboBoxValueChange"
   action="/taifweb/CpDomanda!handleCbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita_VALUE_CHANGED" namespace="/base/domanda"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidStatoNascitaDatiAnagraficiAltroTitolareRappresentanteLegale" id="widg_cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale"
	  disabled="isWidgetDisabled('CpDomanda','cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita','conferma','%{widg_cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascitaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita','conferma','%{widg_cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascitaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta.label')}" labelFor="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta" errorFor="appDataaltroTitolareRappresentanteLegale.dsComuneNascitaNoIta" labelId="tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoItaLbl"
	  >


<!-- widget tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta -->
<s:textfield 
	
title=""	
	name="appDataaltroTitolareRappresentanteLegale.dsComuneNascitaNoIta" id="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta"
maxlength="100"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaNoIta')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita.label')}" labelFor="widg_cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita" errorFor="appDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale" labelId="cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascitaLbl"
	position="last"  >


<!-- widget cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita -->
<s:select name="appDataidComuneNascitaDatiAnagraficiAltroTitolareRappresentanteLegale" id="widg_cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniNascitaAltroTitolareRappresentante"
	  disabled="isWidgetDisabled('CpDomanda','cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenza.label')}" labelFor="widg_cbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenza" errorFor="appDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale" labelId="cbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenzaLbl"
	position="first" colSpan="3" >


<!-- widget cbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenza -->
<s:select name="appDataidComuneResidenzaDatiAnagraficiAltroTitolareRappresentanteLegale" id="widg_cbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenza"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniResidenzaAltroTitolareRappresentante"
	  disabled="isWidgetDisabled('CpDomanda','cbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenza')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleCapResidenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAltroTitolareRappresentanteLegaleCapResidenza.label')}" labelFor="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleCapResidenza" errorFor="appDataaltroTitolareRappresentanteLegale.cap" labelId="tfDatiAnagraficiAltroTitolareRappresentanteLegaleCapResidenzaLbl"
	  >


<!-- widget tfDatiAnagraficiAltroTitolareRappresentanteLegaleCapResidenza -->
<s:textfield 
	
title=""	
	name="appDataaltroTitolareRappresentanteLegale.cap" id="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleCapResidenza"
maxlength="5"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleCapResidenza')"
	size="5" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleIndirizzoResidenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAltroTitolareRappresentanteLegaleIndirizzoResidenza.label')}" labelFor="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleIndirizzoResidenza" errorFor="appDataaltroTitolareRappresentanteLegale.indirizzo" labelId="tfDatiAnagraficiAltroTitolareRappresentanteLegaleIndirizzoResidenzaLbl"
	  >


<!-- widget tfDatiAnagraficiAltroTitolareRappresentanteLegaleIndirizzoResidenza -->
<s:textfield 
	
title=""	
	name="appDataaltroTitolareRappresentanteLegale.indirizzo" id="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleIndirizzoResidenza"
maxlength="100"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleIndirizzoResidenza')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleCivicoResidenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAltroTitolareRappresentanteLegaleCivicoResidenza.label')}" labelFor="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleCivicoResidenza" errorFor="appDataaltroTitolareRappresentanteLegale.civico" labelId="tfDatiAnagraficiAltroTitolareRappresentanteLegaleCivicoResidenzaLbl"
	position="last"  >


<!-- widget tfDatiAnagraficiAltroTitolareRappresentanteLegaleCivicoResidenza -->
<s:textfield 
	
title=""	
	name="appDataaltroTitolareRappresentanteLegale.civico" id="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleCivicoResidenza"
maxlength="5"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleCivicoResidenza')"
	size="5" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleTelefonoOCellulare')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAltroTitolareRappresentanteLegaleTelefonoOCellulare.label')}" labelFor="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleTelefonoOCellulare" errorFor="appDataaltroTitolareRappresentanteLegale.telefono" labelId="tfDatiAnagraficiAltroTitolareRappresentanteLegaleTelefonoOCellulareLbl"
	position="first" colSpan="3" >


<!-- widget tfDatiAnagraficiAltroTitolareRappresentanteLegaleTelefonoOCellulare -->
<s:textfield 
	
title=""	
	name="appDataaltroTitolareRappresentanteLegale.telefono" id="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleTelefonoOCellulare"
maxlength="20"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleTelefonoOCellulare')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleEmailPersonale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAltroTitolareRappresentanteLegaleEmailPersonale.label')}" labelFor="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleEmailPersonale" errorFor="appDataaltroTitolareRappresentanteLegale.email" labelId="tfDatiAnagraficiAltroTitolareRappresentanteLegaleEmailPersonaleLbl"
	position="last" colSpan="3" >


<!-- widget tfDatiAnagraficiAltroTitolareRappresentanteLegaleEmailPersonale -->
<s:textfield 
	
title=""	
	name="appDataaltroTitolareRappresentanteLegale.email" id="widg_tfDatiAnagraficiAltroTitolareRappresentanteLegaleEmailPersonale"
maxlength="100"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAltroTitolareRappresentanteLegaleEmailPersonale')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudio.label')}" labelFor="widg_cbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudio" errorFor="appDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale" labelId="cbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudioLbl"
	position="first" colSpan="3" >


<!-- widget cbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudio -->
<s:select name="appDataidTitoloStudioDatiAnagraficiAltroTitolareRappresentanteLegale" id="widg_cbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudio"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale"
	  disabled="isWidgetDisabled('CpDomanda','cbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudio')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','taDatiAnagraficiAltriAltriCorsi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.taDatiAnagraficiAltriAltriCorsi.label')}" labelFor="widg_taDatiAnagraficiAltriAltriCorsi" errorFor="appDataaltroTitolareRappresentanteLegale.altriStudi" labelId="taDatiAnagraficiAltriAltriCorsiLbl"
	position="first"  >


<!-- widget taDatiAnagraficiAltriAltriCorsi -->
<s:textarea 
	
	
	name="appDataaltroTitolareRappresentanteLegale.altriStudi" id="widg_taDatiAnagraficiAltriAltriCorsi"
	disabled="isWidgetDisabled('CpDomanda','taDatiAnagraficiAltriAltriCorsi')"
	rows="20"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiConduttoreAzienda_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpDatiAnagraficiConduttoreAzienda_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiConduttoreAzienda_7_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpDatiAnagraficiConduttoreAzienda_7_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiConduttoreAzienda_7_4_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiAnagraficiConduttoreAzienda_7_4_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiConduttoreAzienda --></div>

			
	
	<div id="p_wpDatiAnagraficiAltriRequisitiProfessionaliForestali" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiAltriRequisitiProfessionaliForestali -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiAnagraficiAltriRequisitiProfessionaliForestali.label" /> </h4>
<div class="widgetsPanel" id="wpDatiAnagraficiAltriRequisitiProfessionaliForestali">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti')" >

	
<div class="tableWidget">


<!-- widget tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti -->
	<csiuicore:ajaxify id="p_wpDatiAnagraficiAltriRequisitiProfessionaliForestali" 
		widgetType="table"		
		pageId="CpDomanda"
		javascriptDetection="false">
<s:set name="CpDomanda_tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti_clearStatus" value="isTableClearStatus('CpDomanda_tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoCorsiSostenutiAltroTitolareRappresentanteLegale"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti_clearStatus}"
               uid="row_tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti"
               summary="" 
               class="dataTable">
	
		<display:column property="description" titleKey="CpDomanda.tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti.description.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche')" >

	
<div class="tableWidget">


<!-- widget tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche -->
	<csiuicore:ajaxify id="p_wpDatiAnagraficiAltriRequisitiProfessionaliForestali" 
		widgetType="table"		
		pageId="CpDomanda"
		javascriptDetection="false">
<s:set name="CpDomanda_tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche_clearStatus" value="isTableClearStatus('CpDomanda_tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoQualificheAltroTitolareRappresentanteLegale"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche_clearStatus}"
               uid="row_tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche"
               summary="" 
               class="dataTable">
	
		<display:column property="description" titleKey="CpDomanda.tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche.description.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti')" >

	
<div class="tableWidget">


<!-- widget tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti -->
	<csiuicore:ajaxify id="p_wpDatiAnagraficiAltriRequisitiProfessionaliForestali" 
		widgetType="table"		
		pageId="CpDomanda"
		javascriptDetection="false">
<s:set name="CpDomanda_tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti_clearStatus" value="isTableClearStatus('CpDomanda_tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoRiconiscimentiAltroTitolareRappresentanteLegale"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti_clearStatus}"
               uid="row_tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti"
               summary="" 
               class="dataTable">
	
		<display:column property="description" titleKey="CpDomanda.tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti.description.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiAltriRequisitiProfessionaliForestali --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiAnagraficiConduttoreAzienda --></div>
