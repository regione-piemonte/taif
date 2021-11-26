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

	
	<div id="p_fpWizardDatiAnagraficiSub2" class="formPanelBlock"><!-- startFragment:p_fpWizardDatiAnagraficiSub2 -->
		
	


	
	

	
	
			
	
	<div id="p_smpDomanda1.2" class="stdMessagePanelBlock"><!-- startFragment:p_smpDomanda1.2 -->
	
	
<div class="stdMessagePanel" id="smpDomanda1.2">
	<customtag:stdMessagePanel id="smpDomanda1.2" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpDomanda1.2 --></div>

			
	
	<div id="p_wpDatiAnagraficiSezione1.2" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiSezione1.2 -->
	
	

<div class="widgetsPanel" id="wpDatiAnagraficiSezione1.2">
	
	<customtag:widgetsPanel id="wpDatiAnagraficiSezione1.2Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="100">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','udwDatiAnagraficiSezione1.2')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_udwDatiAnagraficiSezione1.2" errorFor="widg_udwDatiAnagraficiSezione1.2" labelId="udwDatiAnagraficiSezione1.2Lbl"
	  >


<s:include value="/jsp/userwidgets/CpDomanda_udwDatiAnagraficiSezione1.2.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiSezione1.2 --></div>

			
	
	<div id="p_wpDatiAnagraficiTitolareRappresentanteLegale" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiTitolareRappresentanteLegale -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiAnagraficiTitolareRappresentanteLegale.label" /> </h4>
<div class="widgetsPanel" id="wpDatiAnagraficiTitolareRappresentanteLegale">
	
	<customtag:widgetsPanel id="wpDatiAnagraficiTitolareRappresentanteLegaleTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleNrsiMsa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiTitolareRappresentanteLegaleNrsiMsa.label')}" labelFor="widg_tfDatiAnagraficiTitolareRappresentanteLegaleNrsiMsa" errorFor="appDatatitolareRappresentanteLegale.nrsiMsa" labelId="tfDatiAnagraficiTitolareRappresentanteLegaleNrsiMsaLbl"
	position="first"  >


<!-- widget tfDatiAnagraficiTitolareRappresentanteLegaleNrsiMsa -->
<s:textfield 
	
title=""	
	name="appDatatitolareRappresentanteLegale.nrsiMsa" id="widg_tfDatiAnagraficiTitolareRappresentanteLegaleNrsiMsa"
maxlength="16"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleNrsiMsa')"
	size="16" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','btnCercaTitolareAnagraficaFr')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCercaTitolareAnagraficaFr -->
<s:submit name="widg_btnCercaTitolareAnagraficaFr" id="widg_btnCercaTitolareAnagraficaFr" method="handleBtnCercaTitolareAnagraficaFr_CLICKED"
	key="CpDomanda.btnCercaTitolareAnagraficaFr.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('CpDomanda','btnCercaTitolareAnagraficaFr')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiTitolareRappresentanteLegale_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiAnagraficiTitolareRappresentanteLegale_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleCodiceFiscale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiTitolareRappresentanteLegaleCodiceFiscale.label')}" labelFor="widg_tfDatiAnagraficiTitolareRappresentanteLegaleCodiceFiscale" errorFor="appDatatitolareRappresentanteLegale.codiceFiscale" labelId="tfDatiAnagraficiTitolareRappresentanteLegaleCodiceFiscaleLbl"
	position="first"  >


<!-- widget tfDatiAnagraficiTitolareRappresentanteLegaleCodiceFiscale -->
<s:textfield 
	
title=""	
	name="appDatatitolareRappresentanteLegale.codiceFiscale" id="widg_tfDatiAnagraficiTitolareRappresentanteLegaleCodiceFiscale"
maxlength="16"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleCodiceFiscale')"
	size="16" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','btnCercaTitolareAnagrafica')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCercaTitolareAnagrafica -->
<s:submit name="widg_btnCercaTitolareAnagrafica" id="widg_btnCercaTitolareAnagrafica" method="handleBtnCercaTitolareAnagrafica_CLICKED"
	key="CpDomanda.btnCercaTitolareAnagrafica.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('CpDomanda','btnCercaTitolareAnagrafica')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiTitolareRappresentanteLegale_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiAnagraficiTitolareRappresentanteLegale_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiTitolareRappresentanteLegaleCognome.label')}" labelFor="widg_tfDatiAnagraficiTitolareRappresentanteLegaleCognome" errorFor="appDatatitolareRappresentanteLegale.cognome" labelId="tfDatiAnagraficiTitolareRappresentanteLegaleCognomeLbl"
	position="first"  >


<!-- widget tfDatiAnagraficiTitolareRappresentanteLegaleCognome -->
<s:textfield 
	
title=""	
	name="appDatatitolareRappresentanteLegale.cognome" id="widg_tfDatiAnagraficiTitolareRappresentanteLegaleCognome"
maxlength="50"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleCognome')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiTitolareRappresentanteLegaleNome.label')}" labelFor="widg_tfDatiAnagraficiTitolareRappresentanteLegaleNome" errorFor="appDatatitolareRappresentanteLegale.nome" labelId="tfDatiAnagraficiTitolareRappresentanteLegaleNomeLbl"
	  >


<!-- widget tfDatiAnagraficiTitolareRappresentanteLegaleNome -->
<s:textfield 
	
title=""	
	name="appDatatitolareRappresentanteLegale.nome" id="widg_tfDatiAnagraficiTitolareRappresentanteLegaleNome"
maxlength="50"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleNome')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','calDatiAnagraficiTitolareRappresentanteLegaleDataNascita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.calDatiAnagraficiTitolareRappresentanteLegaleDataNascita.label')}" labelFor="widg_calDatiAnagraficiTitolareRappresentanteLegaleDataNascita" errorFor="appDatatitolareRappresentanteLegale.dataNascita" labelId="calDatiAnagraficiTitolareRappresentanteLegaleDataNascitaLbl"
	position="last"  >


<!-- widget calDatiAnagraficiTitolareRappresentanteLegaleDataNascita -->
<s:textfield 
	
	
	name="appDatatitolareRappresentanteLegale.dataNascita" id="widg_calDatiAnagraficiTitolareRappresentanteLegaleDataNascita"
	disabled="isWidgetDisabled('CpDomanda','calDatiAnagraficiTitolareRappresentanteLegaleDataNascita')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita.label')}" labelFor="widg_cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita" errorFor="appDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale" labelId="cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascitaLbl"
	position="first"  >


<!-- widget cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita -->
	<csiuicore:ajaxify id="p_wpDatiAnagraficiTitolareRappresentanteLegale" 
		widgetType="combo" 
		requestUri="/taifweb/base/domanda/CpDomanda!handleCbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita_VALUE_CHANGED.do"
		pageId="CpDomanda"
		formName="CpDomanda"
		javascriptDetection="false"
		nameSpace="/base/domanda">

<s:url id="widg_cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascitaurlComboBoxValueChange"
   action="/taifweb/CpDomanda!handleCbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita_VALUE_CHANGED" namespace="/base/domanda"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidStatoNascitaDatiAnagraficiTitolareRappresentanteLegale" id="widg_cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale"
	  disabled="isWidgetDisabled('CpDomanda','cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita','conferma','%{widg_cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascitaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita','conferma','%{widg_cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascitaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita.label')}" labelFor="widg_cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita" errorFor="appDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale" labelId="cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaLbl"
	  >


<!-- widget cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita -->
<s:select name="appDataidComuneNascitaDatiAnagraficiTitolareRappresentanteLegale" id="widg_cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniNascitaTitolareRappresentante"
	  disabled="isWidgetDisabled('CpDomanda','cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta.label')}" labelFor="widg_tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta" errorFor="appDatatitolareRappresentanteLegale.dsComuneNascitaNoIta" labelId="tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoItaLbl"
	position="last"  >


<!-- widget tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta -->
<s:textfield 
	
title=""	
	name="appDatatitolareRappresentanteLegale.dsComuneNascitaNoIta" id="widg_tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta"
maxlength="100"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleComuneNascitaNoIta')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza')" >

	
<customtag:widgetsPanelColumn  tooltip="minimo 4 caratteri" labelField="true" textLabel="%{getText('CpDomanda.cmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza.label')}" labelFor="widg_cmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza" errorFor="appDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale" labelId="cmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenzaLbl"
	position="first"  >


<!-- widget cmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza -->
<s:select name="appDataidComuneResidenzaDatiAnagraficiTitolareRappresentanteLegale" id="widg_cmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza"
	 
	
		title="minimo 4 caratteri"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniResidenzaTitolareRappresentante"
	  disabled="isWidgetDisabled('CpDomanda','cmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleComuneResidenzaNoIta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiTitolareRappresentanteLegaleComuneResidenzaNoIta.label')}" labelFor="widg_tfDatiAnagraficiTitolareRappresentanteLegaleComuneResidenzaNoIta" errorFor="appDatatitolareRappresentanteLegale.dsComuneResidenzaNoIta" labelId="tfDatiAnagraficiTitolareRappresentanteLegaleComuneResidenzaNoItaLbl"
	  >


<!-- widget tfDatiAnagraficiTitolareRappresentanteLegaleComuneResidenzaNoIta -->
<s:textfield 
	
title=""	
	name="appDatatitolareRappresentanteLegale.dsComuneResidenzaNoIta" id="widg_tfDatiAnagraficiTitolareRappresentanteLegaleComuneResidenzaNoIta"
maxlength="100"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleComuneResidenzaNoIta')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleCapResidenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiTitolareRappresentanteLegaleCapResidenza.label')}" labelFor="widg_tfDatiAnagraficiTitolareRappresentanteLegaleCapResidenza" errorFor="appDatatitolareRappresentanteLegale.cap" labelId="tfDatiAnagraficiTitolareRappresentanteLegaleCapResidenzaLbl"
	position="last"  >


<!-- widget tfDatiAnagraficiTitolareRappresentanteLegaleCapResidenza -->
<s:textfield 
	
title=""	
	name="appDatatitolareRappresentanteLegale.cap" id="widg_tfDatiAnagraficiTitolareRappresentanteLegaleCapResidenza"
maxlength="5"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleCapResidenza')"
	size="5" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleIndirizzoResidenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiTitolareRappresentanteLegaleIndirizzoResidenza.label')}" labelFor="widg_tfDatiAnagraficiTitolareRappresentanteLegaleIndirizzoResidenza" errorFor="appDatatitolareRappresentanteLegale.indirizzo" labelId="tfDatiAnagraficiTitolareRappresentanteLegaleIndirizzoResidenzaLbl"
	position="first" colSpan="3" >


<!-- widget tfDatiAnagraficiTitolareRappresentanteLegaleIndirizzoResidenza -->
<s:textfield 
	
title=""	
	name="appDatatitolareRappresentanteLegale.indirizzo" id="widg_tfDatiAnagraficiTitolareRappresentanteLegaleIndirizzoResidenza"
maxlength="100"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleIndirizzoResidenza')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleCivicoResidenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiTitolareRappresentanteLegaleCivicoResidenza.label')}" labelFor="widg_tfDatiAnagraficiTitolareRappresentanteLegaleCivicoResidenza" errorFor="appDatatitolareRappresentanteLegale.civico" labelId="tfDatiAnagraficiTitolareRappresentanteLegaleCivicoResidenzaLbl"
	position="last"  >


<!-- widget tfDatiAnagraficiTitolareRappresentanteLegaleCivicoResidenza -->
<s:textfield 
	
title=""	
	name="appDatatitolareRappresentanteLegale.civico" id="widg_tfDatiAnagraficiTitolareRappresentanteLegaleCivicoResidenza"
maxlength="5"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleCivicoResidenza')"
	size="5" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleTelefonoOCellulare')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiTitolareRappresentanteLegaleTelefonoOCellulare.label')}" labelFor="widg_tfDatiAnagraficiTitolareRappresentanteLegaleTelefonoOCellulare" errorFor="appDatatitolareRappresentanteLegale.telefono" labelId="tfDatiAnagraficiTitolareRappresentanteLegaleTelefonoOCellulareLbl"
	position="first" colSpan="3" >


<!-- widget tfDatiAnagraficiTitolareRappresentanteLegaleTelefonoOCellulare -->
<s:textfield 
	
title=""	
	name="appDatatitolareRappresentanteLegale.telefono" id="widg_tfDatiAnagraficiTitolareRappresentanteLegaleTelefonoOCellulare"
maxlength="20"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleTelefonoOCellulare')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleEmailPersonale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiTitolareRappresentanteLegaleEmailPersonale.label')}" labelFor="widg_tfDatiAnagraficiTitolareRappresentanteLegaleEmailPersonale" errorFor="appDatatitolareRappresentanteLegale.email" labelId="tfDatiAnagraficiTitolareRappresentanteLegaleEmailPersonaleLbl"
	position="last"  >


<!-- widget tfDatiAnagraficiTitolareRappresentanteLegaleEmailPersonale -->
<s:textfield 
	
title=""	
	name="appDatatitolareRappresentanteLegale.email" id="widg_tfDatiAnagraficiTitolareRappresentanteLegaleEmailPersonale"
maxlength="100"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiTitolareRappresentanteLegaleEmailPersonale')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudio.label')}" labelFor="widg_cbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudio" errorFor="appDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale" labelId="cbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudioLbl"
	position="first" colSpan="3" >


<!-- widget cbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudio -->
<s:select name="appDataidTitoloStudioDatiAnagraficiTitolareRappresentanteLegale" id="widg_cbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudio"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale"
	  disabled="isWidgetDisabled('CpDomanda','cbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudio')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','taDatiAnagraficiTitolareRappresentanteLegaleAltriCorsi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.taDatiAnagraficiTitolareRappresentanteLegaleAltriCorsi.label')}" labelFor="widg_taDatiAnagraficiTitolareRappresentanteLegaleAltriCorsi" errorFor="appDatatitolareRappresentanteLegale.altriStudi" labelId="taDatiAnagraficiTitolareRappresentanteLegaleAltriCorsiLbl"
	position="first" colSpan="3" >


<!-- widget taDatiAnagraficiTitolareRappresentanteLegaleAltriCorsi -->
<s:textarea 
	
title=""	
	name="appDatatitolareRappresentanteLegale.altriStudi" id="widg_taDatiAnagraficiTitolareRappresentanteLegaleAltriCorsi"
	disabled="isWidgetDisabled('CpDomanda','taDatiAnagraficiTitolareRappresentanteLegaleAltriCorsi')"
	rows="40"
	cols="60"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiTitolareRappresentanteLegale --></div>

			
	
	<div id="p_wpDatiAnagraficiRequisitiProfessionaliForestali" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiRequisitiProfessionaliForestali -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiAnagraficiRequisitiProfessionaliForestali.label" /> </h4>
<div class="widgetsPanel" id="wpDatiAnagraficiRequisitiProfessionaliForestali">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti')" >

	
<div class="tableWidget">


<!-- widget tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti -->
	<csiuicore:ajaxify id="p_wpDatiAnagraficiRequisitiProfessionaliForestali" 
		widgetType="table"		
		pageId="CpDomanda"
		javascriptDetection="false">
<s:set name="CpDomanda_tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti_clearStatus" value="isTableClearStatus('CpDomanda_tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoCorsiSostenutiTitolareRappresentanteLegale"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti_clearStatus}"
               uid="row_tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti"
               summary="" 
               class="dataTable">
	
		<display:column property="description" titleKey="CpDomanda.tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti.description.label" 
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


	
<s:if test="isWidgetVisible('CpDomanda','tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche')" >

	
<div class="tableWidget">


<!-- widget tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche -->
	<csiuicore:ajaxify id="p_wpDatiAnagraficiRequisitiProfessionaliForestali" 
		widgetType="table"		
		pageId="CpDomanda"
		javascriptDetection="false">
<s:set name="CpDomanda_tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche_clearStatus" value="isTableClearStatus('CpDomanda_tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoQualificheTitolareRappresentanteLegale"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche_clearStatus}"
               uid="row_tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche"
               summary="" 
               class="dataTable">
	
		<display:column property="description" titleKey="CpDomanda.tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche.description.label" 
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


	
<s:if test="isWidgetVisible('CpDomanda','tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti')" >

	
<div class="tableWidget">


<!-- widget tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti -->
	<csiuicore:ajaxify id="p_wpDatiAnagraficiRequisitiProfessionaliForestali" 
		widgetType="table"		
		pageId="CpDomanda"
		javascriptDetection="false">
<s:set name="CpDomanda_tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti_clearStatus" value="isTableClearStatus('CpDomanda_tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti')" />
<s:url id="CpDomandaViewUrl"						   
					   action="CpDomanda"
					   namespace="/base/domanda"/>
<display:table name="appDataelencoRiconiscimentiTitolareRappresentanteLegale"  				
			   excludedParams="*"			   export="false"
               id="widg_tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDomandaViewUrl}"  
               clearStatus="${CpDomanda_tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti_clearStatus}"
               uid="row_tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti"
               summary="" 
               class="dataTable">
	
		<display:column property="description" titleKey="CpDomanda.tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti.description.label" 
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

	<!-- endFragment:p_wpDatiAnagraficiRequisitiProfessionaliForestali --></div>

			
	
	
	<div id="p_mpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente" class="panelBlock"><!-- startFragment:p_mpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente -->
		

		
<s:if test="#session.CpDomanda_mpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente_selectedMultiPanel == 'CpDomanda_mpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente_fpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente'">
	<s:include value="/jsp/multipanels/CpDomanda_mpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente_fpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiAnagraficiTitolareRappresentanteLegaleAltroConducente --></div>

			
	
	
	<div id="p_mpDatiAnagraficiConduttoreAzienda" class="panelBlock"><!-- startFragment:p_mpDatiAnagraficiConduttoreAzienda -->
		

		
<s:if test="#session.CpDomanda_mpDatiAnagraficiConduttoreAzienda_selectedMultiPanel == 'CpDomanda_mpDatiAnagraficiConduttoreAzienda_fpDatiAnagraficiConduttoreAzienda'">
	<s:include value="/jsp/multipanels/CpDomanda_mpDatiAnagraficiConduttoreAzienda_fpDatiAnagraficiConduttoreAzienda.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiAnagraficiConduttoreAzienda --></div>

	

		
	

	<!-- endFragment:p_fpWizardDatiAnagraficiSub2 --></div>
