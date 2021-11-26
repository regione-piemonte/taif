#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/taif/taifweb/presentation/taifweb/action/common/CpDocumentazioneAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/common -->
<!-- pageId:CpDocumentazione -->

<s:form id="CpDocumentazione" action="CpDocumentazione" namespace="/base/common" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpDocumentazioneUserInfo" class="formPanelBlock"><!-- startFragment:p_fpDocumentazioneUserInfo -->

	
	

	
	
			
	
	<div id="p_uipDocumentazione" class="userInfoPanelBlock"><!-- startFragment:p_uipDocumentazione -->
	
	
<div class="userInfoPanel" id="uipDocumentazione">
	<div class="userData">
		<span class="user">Utente: <span class="value"><s:property value="appDatacurrentUser.nome" /> <s:property value="appDatacurrentUser.cognome" /></span></span>
		<span class="organization">Ente: <span class="value"><s:property value="appDatacurrentUser.ente" /></span></span>
		<span class="role">Ruolo: <span class="value"><s:property value="appDatacurrentUser.ruolo" /></span></span>
	</div>
	<div class="userInfoActions">
		<!-- uscita dal servizio e/o cambio ruolo -->
		<s:url id="logoutUrl" action="Logout" namespace="/secure" method="confirmLogout" />
		<s:a href="%{logoutUrl}" title="chiudi: questo link fa uscire dal servizio">esci</s:a>
	</div>
</div>

	<!-- endFragment:p_uipDocumentazione --></div>

			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('CpDocumentazione','menuView')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpDocumentazioneUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpDocumentazioneBody" class="formPanelBlock"><!-- startFragment:p_fpDocumentazioneBody -->

	
	

	
	
			
	
	<div id="p_smpDocumentazione" class="stdMessagePanelBlock"><!-- startFragment:p_smpDocumentazione -->
	
	
<div class="stdMessagePanel" id="smpDocumentazione">
	<customtag:stdMessagePanel id="smpDocumentazione" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_smpDocumentazione --></div>

			
	
	<div id="p_wpLabelDownloadDocumenti" class="widgetsPanelBlock"><!-- startFragment:p_wpLabelDownloadDocumenti -->
	
	

<div class="widgetsPanel" id="wpLabelDownloadDocumenti">
	
	<customtag:widgetsPanel id="wpLabelDownloadDocumentiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		percentCols="0,100">
	

	
	
<s:if test="isWidgetVisible('CpDocumentazione','udwTitoloDownloadDocumenti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_udwTitoloDownloadDocumenti" errorFor="widg_udwTitoloDownloadDocumenti" labelId="udwTitoloDownloadDocumentiLbl"
	  >


<s:include value="/jsp/userwidgets/CpDocumentazione_udwTitoloDownloadDocumenti.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpLabelDownloadDocumenti --></div>

			
	
	<div id="p_wpDownloadDocumenti" class="widgetsPanelBlock"><!-- startFragment:p_wpDownloadDocumenti -->
	
	

<div class="widgetsPanel" id="wpDownloadDocumenti">
	
	<customtag:widgetsPanel id="wpDownloadDocumentiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDocumentazione','cbTipoFirmaAllegatiDownload')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDocumentazione.cbTipoFirmaAllegatiDownload.label')}" labelFor="widg_cbTipoFirmaAllegatiDownload" errorFor="appDataidTipologiaAllegatoDownloadSelezionato" labelId="cbTipoFirmaAllegatiDownloadLbl"
	  >


<!-- widget cbTipoFirmaAllegatiDownload -->

<s:url id="widg_cbTipoFirmaAllegatiDownloadurlComboBoxValueChange"
   action="/taifweb/CpDocumentazione!handleCbTipoFirmaAllegatiDownload_VALUE_CHANGED" namespace="/base/common"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidTipologiaAllegatoDownloadSelezionato" id="widg_cbTipoFirmaAllegatiDownload"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipologieAllegatiDownload"
	  disabled="isWidgetDisabled('CpDocumentazione','cbTipoFirmaAllegatiDownload')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbTipoFirmaAllegatiDownload','conferma','%{widg_cbTipoFirmaAllegatiDownloadurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoFirmaAllegatiDownload','conferma','%{widg_cbTipoFirmaAllegatiDownloadurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDownloadDocumenti --></div>

			
	
	<div id="p_wpTabellaDownloadAllegati" class="widgetsPanelBlock"><!-- startFragment:p_wpTabellaDownloadAllegati -->
	
	

<div class="widgetsPanel" id="wpTabellaDownloadAllegati">
	

	
	
<s:if test="isWidgetVisible('CpDocumentazione','tElencoDownloadAllegati')" >

	
<div class="tableWidget">


<!-- widget tElencoDownloadAllegati -->
<s:set name="CpDocumentazione_tElencoDownloadAllegati_clearStatus" value="isTableClearStatus('CpDocumentazione_tElencoDownloadAllegati')" />
<s:url id="CpDocumentazioneViewUrl"						   
					   action="CpDocumentazione"
					   namespace="/base/common"/>
<display:table name="appDataelencoAllegatiDownload"  				
			   excludedParams="*"			   export="false"
               id="widg_tElencoDownloadAllegati"
               pagesize="0"
               keepStatus="true"
               requestURI="${CpDocumentazioneViewUrl}"  
               clearStatus="${CpDocumentazione_tElencoDownloadAllegati_clearStatus}"
               uid="row_tElencoDownloadAllegati"
               summary="" 
decorator="it.csi.taif.taifweb.presentation.decorator.common.CpDocumentazioneTElencoDownloadAllegatiCustomDecorator"               class="dataTable">
	
		<display:column property="nomeFile" titleKey="CpDocumentazione.tElencoDownloadAllegati.nomeFile.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="iconaDownload" titleKey="CpDocumentazione.tElencoDownloadAllegati.iconaDownload.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="first"/>
</s:else>



	
	
	
</div>

	<!-- endFragment:p_wpTabellaDownloadAllegati --></div>

			
	
	<div id="p_wpDocumentiFirmati" class="widgetsPanelBlock"><!-- startFragment:p_wpDocumentiFirmati -->
	
	
<h4 class="wpLabel"><s:text name="CpDocumentazione.wpDocumentiFirmati.label" /> <span id="toggle_wpDocumentiFirmati"></span></h4>
<div class="widgetsPanel" id="wpDocumentiFirmati">
	
	<customtag:widgetsPanel id="wpDocumentiFirmatiTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDocumentazione','cbTipoFirma')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDocumentazione.cbTipoFirma.label')}" labelFor="widg_cbTipoFirma" errorFor="appDataidTipologiaAllegatoSelezionato" labelId="cbTipoFirmaLbl"
	position="first"  >


<!-- widget cbTipoFirma -->

<s:url id="widg_cbTipoFirmaurlComboBoxValueChange"
   action="/taifweb/CpDocumentazione!handleCbTipoFirma_VALUE_CHANGED" namespace="/base/common"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidTipologiaAllegatoSelezionato" id="widg_cbTipoFirma"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipologieAllegati"
	  disabled="isWidgetDisabled('CpDocumentazione','cbTipoFirma')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbTipoFirma','conferma','%{widg_cbTipoFirmaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoFirma','conferma','%{widg_cbTipoFirmaurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpDocumentazione','cbSottotipoFirma')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDocumentazione.cbSottotipoFirma.label')}" labelFor="widg_cbSottotipoFirma" errorFor="appDataidSottotipologiaAllegatoSelezionato" labelId="cbSottotipoFirmaLbl"
	  >


<!-- widget cbSottotipoFirma -->
<s:select name="appDataidSottotipologiaAllegatoSelezionato" id="widg_cbSottotipoFirma"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSottotipologieAllegati"
	  disabled="isWidgetDisabled('CpDocumentazione','cbSottotipoFirma')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDocumentazione','updFile')" >

	
<customtag:widgetsPanelColumn  tooltip="Selezionare il file da caricare" labelField="true" textLabel="%{getText('CpDocumentazione.updFile.label')}" labelFor="widg_updFile" errorFor="widg_updFile" labelId="updFileLbl"
	  >


<s:file 
	
title="Selezionare il file da caricare"	
	name="widg_updFile" id="widg_updFile"
	disabled="isWidgetDisabled('CpDocumentazione','updFile')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('CpDocumentazione','loadAllegatoButton')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget loadAllegatoButton -->
<s:submit name="widg_loadAllegatoButton" id="widg_loadAllegatoButton" method="handleLoadAllegatoButton_CLICKED"
	key="CpDocumentazione.loadAllegatoButton.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('CpDocumentazione','loadAllegatoButton')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDocumentiFirmati --></div>

			
	
	
	<div id="p_mpElencoAllegatiFirmati" class="panelBlock"><!-- startFragment:p_mpElencoAllegatiFirmati -->
		

		
<s:if test="#session.CpDocumentazione_mpElencoAllegatiFirmati_selectedMultiPanel == 'CpDocumentazione_mpElencoAllegatiFirmati_fpElencoAllegatiFirmati'">
	<s:include value="/jsp/multipanels/CpDocumentazione_mpElencoAllegatiFirmati_fpElencoAllegatiFirmati.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpElencoAllegatiFirmati --></div>

			
	
	<div id="p_cmdpDocumentazioneFun" class="commandPanelBlock"><!-- startFragment:p_cmdpDocumentazioneFun -->
	
	
<div class="commandPanel functional" id="cmdpDocumentazioneFun">

	
	
		

	
	
	
	

	
	
	
	<div class="button center">
		
<s:if test="isWidgetVisible('CpDocumentazione','btnDocumentazioneIndietro')" >

	



<!-- widget btnDocumentazioneIndietro -->
<s:submit name="widg_btnDocumentazioneIndietro" id="widg_btnDocumentazioneIndietro" method="handleBtnDocumentazioneIndietro_CLICKED"
	key="CpDocumentazione.btnDocumentazioneIndietro.label" cssClass="buttonWidget back"
	disabled="isWidgetDisabled('CpDocumentazione','btnDocumentazioneIndietro')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('CpDocumentazione','btnDocumentazioneInvio')" >

	



<!-- widget btnDocumentazioneInvio -->
<s:submit name="widg_btnDocumentazioneInvio" id="widg_btnDocumentazioneInvio" method="handleBtnDocumentazioneInvio_CLICKED"
	key="CpDocumentazione.btnDocumentazioneInvio.label" cssClass="buttonWidget sendMessage"
	disabled="isWidgetDisabled('CpDocumentazione','btnDocumentazioneInvio')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdpDocumentazioneFun --></div>

	

	<!-- endFragment:p_fpDocumentazioneBody --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
