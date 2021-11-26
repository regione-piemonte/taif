#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpCaptcha" class="formPanelBlock"><!-- startFragment:p_fpCaptcha -->
		
	
<div class="formPanel" id="fpCaptcha">


	
	

	
	
			
	
	<div id="p_wpCaptcha" class="widgetsPanelBlock"><!-- startFragment:p_wpCaptcha -->
	
	

<div class="widgetsPanel" id="wpCaptcha">
	
	<customtag:widgetsPanel id="wpCaptchaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpElencoAccessoLibero','captchaExportRicercaLibera')" >

	
<customtag:widgetsPanelColumn  tooltip="Inserisci il codice " labelField="true" textLabel="%{getText('cpElencoAccessoLibero.captchaExportRicercaLibera.label')}" labelFor="widg_captchaExportRicercaLibera" errorFor="widg_captchaExportRicercaLibera" labelId="captchaExportRicercaLiberaLbl"
	position="first"  >


<!-- widget captchaExportRicercaLibera -->
<img src="<%=request.getContextPath()%>/base/captchaServlet" alt="captcha"/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoAccessoLibero','wpCaptcha_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpCaptcha_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoAccessoLibero','tfVerificaCaptchaRicercaLibera')" >

	
<customtag:widgetsPanelColumn  tooltip="immettere qui il testo che si legge nell'immagine" labelField="true" textLabel="%{getText('cpElencoAccessoLibero.tfVerificaCaptchaRicercaLibera.label')}" labelFor="widg_tfVerificaCaptchaRicercaLibera" errorFor="widg_tfVerificaCaptchaRicercaLibera" labelId="tfVerificaCaptchaRicercaLiberaLbl"
	position="first"  >


<!-- widget tfVerificaCaptchaRicercaLibera -->
<s:textfield 
	
title="immettere qui il testo che si legge nell'immagine"	
	name="widg_tfVerificaCaptchaRicercaLibera" id="widg_tfVerificaCaptchaRicercaLibera"
maxlength="5"	disabled="isWidgetDisabled('cpElencoAccessoLibero','tfVerificaCaptchaRicercaLibera')"
	size="5" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoAccessoLibero','btnVerificaCaptchaRicercaLiberaExport')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnVerificaCaptchaRicercaLiberaExport -->
<s:submit name="widg_btnVerificaCaptchaRicercaLiberaExport" id="widg_btnVerificaCaptchaRicercaLiberaExport" method="handleBtnVerificaCaptchaRicercaLiberaExport_CLICKED"
	key="cpElencoAccessoLibero.btnVerificaCaptchaRicercaLiberaExport.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoAccessoLibero','btnVerificaCaptchaRicercaLiberaExport')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpCaptcha --></div>

	

		
	
</div>

	<!-- endFragment:p_fpCaptcha --></div>
