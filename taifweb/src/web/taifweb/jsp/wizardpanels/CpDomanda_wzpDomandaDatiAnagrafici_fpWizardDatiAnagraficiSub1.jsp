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

	
	<div id="p_fpWizardDatiAnagraficiSub1" class="formPanelBlock"><!-- startFragment:p_fpWizardDatiAnagraficiSub1 -->
		
	


	
	

	
	
			
	
	<div id="p_smpDomanda1.1" class="stdMessagePanelBlock"><!-- startFragment:p_smpDomanda1.1 -->
	
	
<div class="stdMessagePanel" id="smpDomanda1.1">
	<customtag:stdMessagePanel id="smpDomanda1.1" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpDomanda1.1 --></div>

			
	
	<div id="p_wpDatiAnagraficiSezione1.1" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiSezione1.1 -->
	
	

<div class="widgetsPanel" id="wpDatiAnagraficiSezione1.1">
	
	<customtag:widgetsPanel id="wpDatiAnagraficiSezione1.1Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="100">
	

	
	
<s:if test="isWidgetVisible('CpDomanda','udwDatiAnagraficiSezione1.1')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_udwDatiAnagraficiSezione1.1" errorFor="widg_udwDatiAnagraficiSezione1.1" labelId="udwDatiAnagraficiSezione1.1Lbl"
	  >


<s:include value="/jsp/userwidgets/CpDomanda_udwDatiAnagraficiSezione1.1.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiSezione1.1 --></div>

			
	
	<div id="p_wpDatiAnagraficiAnagrafeAziendale" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiAnagrafeAziendale -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiAnagraficiAnagrafeAziendale.label" /> </h4>
<div class="widgetsPanel" id="wpDatiAnagraficiAnagrafeAziendale">
	
	<customtag:widgetsPanel id="wpDatiAnagraficiAnagrafeAziendaleTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleCodiceFiscale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAnagrafeAziendaleCodiceFiscale.label')}" labelFor="widg_tfDatiAnagraficiAnagrafeAziendaleCodiceFiscale" errorFor="appDataanagraficaAziendale.codiceFiscale" labelId="tfDatiAnagraficiAnagrafeAziendaleCodiceFiscaleLbl"
	position="first"  >


<!-- widget tfDatiAnagraficiAnagrafeAziendaleCodiceFiscale -->
<s:textfield 
	
title=""	
	name="appDataanagraficaAziendale.codiceFiscale" id="widg_tfDatiAnagraficiAnagrafeAziendaleCodiceFiscale"
maxlength="16"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleCodiceFiscale')"
	size="18" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','btnCercaAnagraficaAziendaAeep')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCercaAnagraficaAziendaAeep -->
<s:submit name="widg_btnCercaAnagraficaAziendaAeep" id="widg_btnCercaAnagraficaAziendaAeep" method="handleBtnCercaAnagraficaAziendaAeep_CLICKED"
	key="CpDomanda.btnCercaAnagraficaAziendaAeep.label" cssClass="buttonWidget search"
	disabled="isWidgetDisabled('CpDomanda','btnCercaAnagraficaAziendaAeep')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAnagrafeAziendalePartitaIva')" >

	
<customtag:widgetsPanelColumn  tooltip="partitaiva" labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAnagrafeAziendalePartitaIva.label')}" labelFor="widg_tfDatiAnagraficiAnagrafeAziendalePartitaIva" errorFor="appDataanagraficaAziendale.partitaIva" labelId="tfDatiAnagraficiAnagrafeAziendalePartitaIvaLbl"
	position="last"  >


<!-- widget tfDatiAnagraficiAnagrafeAziendalePartitaIva -->
<s:textfield 
	
title="partitaiva"	
	name="appDataanagraficaAziendale.partitaIva" id="widg_tfDatiAnagraficiAnagrafeAziendalePartitaIva"
maxlength="15"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAnagrafeAziendalePartitaIva')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleNSiret')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAnagrafeAziendaleNSiret.label')}" labelFor="widg_tfDatiAnagraficiAnagrafeAziendaleNSiret" errorFor="appDataanagraficaAziendale.codiceFiscale" labelId="tfDatiAnagraficiAnagrafeAziendaleNSiretLbl"
	position="first"  >


<!-- widget tfDatiAnagraficiAnagrafeAziendaleNSiret -->
<s:textfield 
	
title=""	
	name="appDataanagraficaAziendale.codiceFiscale" id="widg_tfDatiAnagraficiAnagrafeAziendaleNSiret"
maxlength="16"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleNSiret')"
	size="18" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleNtva')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAnagrafeAziendaleNtva.label')}" labelFor="widg_tfDatiAnagraficiAnagrafeAziendaleNtva" errorFor="appDataanagraficaAziendale.partitaIva" labelId="tfDatiAnagraficiAnagrafeAziendaleNtvaLbl"
	  >


<!-- widget tfDatiAnagraficiAnagrafeAziendaleNtva -->
<s:textfield 
	
title=""	
	name="appDataanagraficaAziendale.partitaIva" id="widg_tfDatiAnagraficiAnagrafeAziendaleNtva"
maxlength="15"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleNtva')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiAnagrafeAziendale_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiAnagraficiAnagrafeAziendale_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','taDatiAnagraficiAnagrafeAziendaleDescrizione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.taDatiAnagraficiAnagrafeAziendaleDescrizione.label')}" labelFor="widg_taDatiAnagraficiAnagrafeAziendaleDescrizione" errorFor="appDataanagraficaAziendale.descrizione" labelId="taDatiAnagraficiAnagrafeAziendaleDescrizioneLbl"
	position="first" colSpan="3" >


<!-- widget taDatiAnagraficiAnagrafeAziendaleDescrizione -->
<s:textarea 
	
	
	name="appDataanagraficaAziendale.descrizione" id="widg_taDatiAnagraficiAnagrafeAziendaleDescrizione"
	disabled="isWidgetDisabled('CpDomanda','taDatiAnagraficiAnagrafeAziendaleDescrizione')"
	rows="60"
	cols="60"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiAnagrafeAziendale --></div>

			
	
	<div id="p_wpDatiAnagraficiAnagrafeAziendaleAltriDati" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiAnagrafeAziendaleAltriDati -->
	
	

<div class="widgetsPanel" id="wpDatiAnagraficiAnagrafeAziendaleAltriDati">
	
	<customtag:widgetsPanel id="wpDatiAnagraficiAnagrafeAziendaleAltriDatiTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','cbDatiAnagraficiAnagrafeAziendaleAttivitaPrimaria')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbDatiAnagraficiAnagrafeAziendaleAttivitaPrimaria.label')}" labelFor="widg_cbDatiAnagraficiAnagrafeAziendaleAttivitaPrimaria" errorFor="appDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale" labelId="cbDatiAnagraficiAnagrafeAziendaleAttivitaPrimariaLbl"
	position="first"  >


<!-- widget cbDatiAnagraficiAnagrafeAziendaleAttivitaPrimaria -->
<s:select name="appDataidAttivitaPrincipaleDatiAnagraficiAnagrafeAziendale" id="widg_cbDatiAnagraficiAnagrafeAziendaleAttivitaPrimaria"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoAttivitaPrimariaDatiAnagraficiAnagrafeAnziendale"
	  disabled="isWidgetDisabled('CpDomanda','cbDatiAnagraficiAnagrafeAziendaleAttivitaPrimaria')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiAnagrafeAziendaleAltriDati_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiAnagraficiAnagrafeAziendaleAltriDati_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbDatiAnagraficiAnagrafeAziendaleAttivitaSecondaria')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbDatiAnagraficiAnagrafeAziendaleAttivitaSecondaria.label')}" labelFor="widg_cbDatiAnagraficiAnagrafeAziendaleAttivitaSecondaria" errorFor="appDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale" labelId="cbDatiAnagraficiAnagrafeAziendaleAttivitaSecondariaLbl"
	position="first"  >


<!-- widget cbDatiAnagraficiAnagrafeAziendaleAttivitaSecondaria -->
<s:select name="appDataidAttivitaSecondariaDatiAnagraficiAnagrafeAziendale" id="widg_cbDatiAnagraficiAnagrafeAziendaleAttivitaSecondaria"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale"
	  disabled="isWidgetDisabled('CpDomanda','cbDatiAnagraficiAnagrafeAziendaleAttivitaSecondaria')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiAnagrafeAziendaleAltriDati_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiAnagraficiAnagrafeAziendaleAltriDati_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','cbDatiAnagraficiAnagrafeAziendaleFormaGiuridica')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbDatiAnagraficiAnagrafeAziendaleFormaGiuridica.label')}" labelFor="widg_cbDatiAnagraficiAnagrafeAziendaleFormaGiuridica" errorFor="appDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale" labelId="cbDatiAnagraficiAnagrafeAziendaleFormaGiuridicaLbl"
	position="first"  >


<!-- widget cbDatiAnagraficiAnagrafeAziendaleFormaGiuridica -->
<s:select name="appDataidFormaGiuridicaDatiAnagraficiAnagrafeAziendale" id="widg_cbDatiAnagraficiAnagrafeAziendaleFormaGiuridica"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoFormeGiuridicheDatiAnagraficiAnagrafeAnziendale"
	  disabled="isWidgetDisabled('CpDomanda','cbDatiAnagraficiAnagrafeAziendaleFormaGiuridica')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','wpDatiAnagraficiAnagrafeAziendaleAltriDati_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiAnagraficiAnagrafeAziendaleAltriDati_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','taDatiAnagraficiAnagrafeAziendaleNote')" >

	
<customtag:widgetsPanelColumn  tooltip="Obbligatorio se la forma giuridica &egrave; altro" labelField="true" textLabel="%{getText('CpDomanda.taDatiAnagraficiAnagrafeAziendaleNote.label')}" labelFor="widg_taDatiAnagraficiAnagrafeAziendaleNote" errorFor="appDataanagraficaAziendale.note" labelId="taDatiAnagraficiAnagrafeAziendaleNoteLbl"
	position="first" colSpan="3" >


<!-- widget taDatiAnagraficiAnagrafeAziendaleNote -->
<s:textarea 
	
title="Obbligatorio se la forma giuridica &egrave; altro"	
	name="appDataanagraficaAziendale.note" id="widg_taDatiAnagraficiAnagrafeAziendaleNote"
	disabled="isWidgetDisabled('CpDomanda','taDatiAnagraficiAnagrafeAziendaleNote')"
	rows="30"
	cols="60"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiAnagrafeAziendaleAltriDati --></div>

			
	
	
	<div id="p_mpDatiAnagraficiIscrizioneCCIAA" class="panelBlock"><!-- startFragment:p_mpDatiAnagraficiIscrizioneCCIAA -->
		

		
<s:if test="#session.CpDomanda_mpDatiAnagraficiIscrizioneCCIAA_selectedMultiPanel == 'CpDomanda_mpDatiAnagraficiIscrizioneCCIAA_fpDatiAnagraficiIscrizioneCCIAA'">
	<s:include value="/jsp/multipanels/CpDomanda_mpDatiAnagraficiIscrizioneCCIAA_fpDatiAnagraficiIscrizioneCCIAA.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiAnagraficiIscrizioneCCIAA --></div>

			
	
	<div id="p_wpDatiAnagraficiAnagrafeAziendaleContatti" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiAnagrafeAziendaleContatti -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiAnagraficiAnagrafeAziendaleContatti.label" /> </h4>
<div class="widgetsPanel" id="wpDatiAnagraficiAnagrafeAziendaleContatti">
	
	<customtag:widgetsPanel id="wpDatiAnagraficiAnagrafeAziendaleContattiTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAnagrafeAziendaleEmail.label')}" labelFor="widg_tfDatiAnagraficiAnagrafeAziendaleEmail" errorFor="appDataanagraficaAziendale.email" labelId="tfDatiAnagraficiAnagrafeAziendaleEmailLbl"
	position="first"  >


<!-- widget tfDatiAnagraficiAnagrafeAziendaleEmail -->
<s:textfield 
	
title=""	
	name="appDataanagraficaAziendale.email" id="widg_tfDatiAnagraficiAnagrafeAziendaleEmail"
maxlength="100"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleEmail')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAnagrafeAziendalePec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAnagrafeAziendalePec.label')}" labelFor="widg_tfDatiAnagraficiAnagrafeAziendalePec" errorFor="appDataanagraficaAziendale.pec" labelId="tfDatiAnagraficiAnagrafeAziendalePecLbl"
	position="last"  >


<!-- widget tfDatiAnagraficiAnagrafeAziendalePec -->
<s:textfield 
	
title=""	
	name="appDataanagraficaAziendale.pec" id="widg_tfDatiAnagraficiAnagrafeAziendalePec"
maxlength="100"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAnagrafeAziendalePec')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleTelefono')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAnagrafeAziendaleTelefono.label')}" labelFor="widg_tfDatiAnagraficiAnagrafeAziendaleTelefono" errorFor="appDataanagraficaAziendale.telefono" labelId="tfDatiAnagraficiAnagrafeAziendaleTelefonoLbl"
	position="first"  >


<!-- widget tfDatiAnagraficiAnagrafeAziendaleTelefono -->
<s:textfield 
	
title=""	
	name="appDataanagraficaAziendale.telefono" id="widg_tfDatiAnagraficiAnagrafeAziendaleTelefono"
maxlength="15"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleTelefono')"
	size="18" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleCellulare')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAnagrafeAziendaleCellulare.label')}" labelFor="widg_tfDatiAnagraficiAnagrafeAziendaleCellulare" errorFor="appDataanagraficaAziendale.cellulare" labelId="tfDatiAnagraficiAnagrafeAziendaleCellulareLbl"
	position="last"  >


<!-- widget tfDatiAnagraficiAnagrafeAziendaleCellulare -->
<s:textfield 
	
title=""	
	name="appDataanagraficaAziendale.cellulare" id="widg_tfDatiAnagraficiAnagrafeAziendaleCellulare"
maxlength="15"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleCellulare')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleSitoInternet')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiAnagrafeAziendaleSitoInternet.label')}" labelFor="widg_tfDatiAnagraficiAnagrafeAziendaleSitoInternet" errorFor="appDataanagraficaAziendale.sitoInternet" labelId="tfDatiAnagraficiAnagrafeAziendaleSitoInternetLbl"
	position="first" colSpan="3" >


<!-- widget tfDatiAnagraficiAnagrafeAziendaleSitoInternet -->
<s:textfield 
	
title=""	
	name="appDataanagraficaAziendale.sitoInternet" id="widg_tfDatiAnagraficiAnagrafeAziendaleSitoInternet"
maxlength="100"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiAnagrafeAziendaleSitoInternet')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiAnagrafeAziendaleContatti --></div>

			
	
	<div id="p_wpDatiAnagraficiSedeLegale" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAnagraficiSedeLegale -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpDatiAnagraficiSedeLegale.label" /> </h4>
<div class="widgetsPanel" id="wpDatiAnagraficiSedeLegale">
	
	<customtag:widgetsPanel id="wpDatiAnagraficiSedeLegaleTbl" columns="10" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','cbDatiAnagraficiComuneSedeLegale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.cbDatiAnagraficiComuneSedeLegale.label')}" labelFor="widg_cbDatiAnagraficiComuneSedeLegale" errorFor="appDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale" labelId="cbDatiAnagraficiComuneSedeLegaleLbl"
	position="first"  >


<!-- widget cbDatiAnagraficiComuneSedeLegale -->
<s:select name="appDataidComuneSedeLegaleDatiAnagraficiAnagrafeAziendale" id="widg_cbDatiAnagraficiComuneSedeLegale"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniDatiAnagraficiAnagrafeAziendale"
	  disabled="isWidgetDisabled('CpDomanda','cbDatiAnagraficiComuneSedeLegale')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiComuneSedeLegale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiComuneSedeLegale.label')}" labelFor="widg_tfDatiAnagraficiComuneSedeLegale" errorFor="appDatasedeLegaleAnagrafeAziendale.dsComune" labelId="tfDatiAnagraficiComuneSedeLegaleLbl"
	  >


<!-- widget tfDatiAnagraficiComuneSedeLegale -->
<s:textfield 
	
title=""	
	name="appDatasedeLegaleAnagrafeAziendale.dsComune" id="widg_tfDatiAnagraficiComuneSedeLegale"
maxlength="100"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiComuneSedeLegale')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiCapSedeLegale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiCapSedeLegale.label')}" labelFor="widg_tfDatiAnagraficiCapSedeLegale" errorFor="appDatasedeLegaleAnagrafeAziendale.cap" labelId="tfDatiAnagraficiCapSedeLegaleLbl"
	  >


<!-- widget tfDatiAnagraficiCapSedeLegale -->
<s:textfield 
	
title=""	
	name="appDatasedeLegaleAnagrafeAziendale.cap" id="widg_tfDatiAnagraficiCapSedeLegale"
maxlength="5"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiCapSedeLegale')"
	size="5" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiIndirizzoSedeLegale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiIndirizzoSedeLegale.label')}" labelFor="widg_tfDatiAnagraficiIndirizzoSedeLegale" errorFor="appDatasedeLegaleAnagrafeAziendale.indirizzo" labelId="tfDatiAnagraficiIndirizzoSedeLegaleLbl"
	  >


<!-- widget tfDatiAnagraficiIndirizzoSedeLegale -->
<s:textfield 
	
title=""	
	name="appDatasedeLegaleAnagrafeAziendale.indirizzo" id="widg_tfDatiAnagraficiIndirizzoSedeLegale"
maxlength="35"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiIndirizzoSedeLegale')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  />
</s:else>


	
<s:if test="isWidgetVisible('CpDomanda','tfDatiAnagraficiCivicoSedeLegale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.tfDatiAnagraficiCivicoSedeLegale.label')}" labelFor="widg_tfDatiAnagraficiCivicoSedeLegale" errorFor="appDatasedeLegaleAnagrafeAziendale.numeroCivico" labelId="tfDatiAnagraficiCivicoSedeLegaleLbl"
	position="last"  >


<!-- widget tfDatiAnagraficiCivicoSedeLegale -->
<s:textfield 
	
title=""	
	name="appDatasedeLegaleAnagrafeAziendale.numeroCivico" id="widg_tfDatiAnagraficiCivicoSedeLegale"
maxlength="6"	disabled="isWidgetDisabled('CpDomanda','tfDatiAnagraficiCivicoSedeLegale')"
	size="6" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAnagraficiSedeLegale --></div>

			
	
	<div id="p_wpRadioAltreSedi" class="widgetsPanelBlock"><!-- startFragment:p_wpRadioAltreSedi -->
	
	

<div class="widgetsPanel" id="wpRadioAltreSedi">
	
	<customtag:widgetsPanel id="wpRadioAltreSediTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','rbsDatiAnagraficiAltreSedi2')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.rbsDatiAnagraficiAltreSedi2.label')}" labelFor="widg_rbsDatiAnagraficiAltreSedi2" errorFor="widg_rbsDatiAnagraficiAltreSedi2" labelId="rbsDatiAnagraficiAltreSedi2Lbl"
	position="first"  >


<!-- widget rbsDatiAnagraficiAltreSedi2 -->

	
<div id="widg_rbsDatiAnagraficiAltreSedi2" class="radiobuttons horizontal">





<div>

<s:url id="widg_rbsDatiAnagraficiAltreSedi2urlRadioButtonValueChange"
   action="/taifweb/CpDomanda!handleRbsDatiAnagraficiAltreSedi2_VALUE_CHANGED" namespace="/base/domanda"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbDatiAnagraficiAltreSediSi2" name="widg_rbsDatiAnagraficiAltreSedi2"
	list="#{'SI':'Si'}"
	disabled="isWidgetDisabled('CpDomanda','rbsDatiAnagraficiAltreSedi2')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsDatiAnagraficiAltreSedi2urlRadioButtonValueChange}')" 
	/> <label  for="widg_rbDatiAnagraficiAltreSediSi2SI"><s:text name="CpDomanda.rbsDatiAnagraficiAltreSedi2.rbDatiAnagraficiAltreSediSi2.label" /></label>
</div>





<div>

<s:radio
	
	
	id="widg_rbDatiAnagraficiAltreSediNo2" name="widg_rbsDatiAnagraficiAltreSedi2"
	list="#{'NO':'No'}"
	disabled="isWidgetDisabled('CpDomanda','rbsDatiAnagraficiAltreSedi2')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsDatiAnagraficiAltreSedi2urlRadioButtonValueChange}')" 
	/> <label  for="widg_rbDatiAnagraficiAltreSediNo2NO"><s:text name="CpDomanda.rbsDatiAnagraficiAltreSedi2.rbDatiAnagraficiAltreSediNo2.label" /></label>
</div>




	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRadioAltreSedi --></div>

			
	
	
	<div id="p_mpDatiAnagraficiSedi" class="panelBlock"><!-- startFragment:p_mpDatiAnagraficiSedi -->
		

		
<s:if test="#session.CpDomanda_mpDatiAnagraficiSedi_selectedMultiPanel == 'CpDomanda_mpDatiAnagraficiSedi_fpDatiAnagraficiSedi'">
	<s:include value="/jsp/multipanels/CpDomanda_mpDatiAnagraficiSedi_fpDatiAnagraficiSedi.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiAnagraficiSedi --></div>

			
	
	
	<div id="p_mpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo" class="panelBlock"><!-- startFragment:p_mpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo -->
		

		
<s:if test="#session.CpDomanda_mpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo_selectedMultiPanel == 'CpDomanda_mpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo_fpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo'">
	<s:include value="/jsp/multipanels/CpDomanda_mpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo_fpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiAnagraficiAnagrafeAziendaleMarcaDaBollo --></div>

			
	
	
	<div id="p_mpDatiAnagraficiConsensoPrivacy" class="panelBlock"><!-- startFragment:p_mpDatiAnagraficiConsensoPrivacy -->
		

		
<s:if test="#session.CpDomanda_mpDatiAnagraficiConsensoPrivacy_selectedMultiPanel == 'CpDomanda_mpDatiAnagraficiConsensoPrivacy_fpDatiAnagraficiConsensoPrivacy'">
	<s:include value="/jsp/multipanels/CpDomanda_mpDatiAnagraficiConsensoPrivacy_fpDatiAnagraficiConsensoPrivacy.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiAnagraficiConsensoPrivacy --></div>

	

		
	

	<!-- endFragment:p_fpWizardDatiAnagraficiSub1 --></div>
