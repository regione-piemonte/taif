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
	

	
	
<s:if test="isWidgetVisible('cpElencoOperatori','captchaExportRicercaLibera')" >

	
<customtag:widgetsPanelColumn  tooltip="Inserisci il codice di sicurezza" labelField="true" textLabel="%{getText('cpElencoOperatori.captchaExportRicercaLibera.label')}" labelFor="widg_captchaExportRicercaLibera" errorFor="widg_captchaExportRicercaLibera" labelId="captchaExportRicercaLiberaLbl"
	position="first"  >


<!-- widget captchaExportRicercaLibera -->
<img src="<%=request.getContextPath()%>/base/captchaServlet" alt="captcha"/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoOperatori','tfVerificaCaptchaRicercaLibera')" >

	
<customtag:widgetsPanelColumn  tooltip="immettere qui il testo che si legge nell'immagine" labelField="true" textLabel="%{getText('cpElencoOperatori.tfVerificaCaptchaRicercaLibera.label')}" labelFor="widg_tfVerificaCaptchaRicercaLibera" errorFor="widg_tfVerificaCaptchaRicercaLibera" labelId="tfVerificaCaptchaRicercaLiberaLbl"
	position="last"  >


<!-- widget tfVerificaCaptchaRicercaLibera -->
<s:textfield 
	
title="immettere qui il testo che si legge nell'immagine"	
	name="widg_tfVerificaCaptchaRicercaLibera" id="widg_tfVerificaCaptchaRicercaLibera"
maxlength="5"	disabled="isWidgetDisabled('cpElencoOperatori','tfVerificaCaptchaRicercaLibera')"
	size="5" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoOperatori','wpCaptcha_2_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpCaptcha_2_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoOperatori','btnVerificaCaptchaRicercaLiberaExport')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnVerificaCaptchaRicercaLiberaExport -->
<s:submit name="widg_btnVerificaCaptchaRicercaLiberaExport" id="widg_btnVerificaCaptchaRicercaLiberaExport" method="handleBtnVerificaCaptchaRicercaLiberaExport_CLICKED"
	key="cpElencoOperatori.btnVerificaCaptchaRicercaLiberaExport.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoOperatori','btnVerificaCaptchaRicercaLiberaExport')" />

	
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
