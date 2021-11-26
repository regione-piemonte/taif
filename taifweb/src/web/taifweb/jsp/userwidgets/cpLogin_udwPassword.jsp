#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>

<%-- Parametro per la gestione della abilitazione/disabilitazione del widget --%>
<s:set name="cpLogin_udwPassword_enabled_local" value="isWidgetDisabled('cpLogin','udwPassword')" />

<!--PROTECTED REGION ID(R491130304) ENABLED START-->
<!-- Inserire qui il codice del widget -->
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpLogin.tfPasswordCustom.label')}" labelFor="widg_tfPasswordCustom" errorFor="appDatalogin.password" labelId="tfPasswordCustomLbl"
	  >


<!-- widget tfPassword -->
<s:password
	
	
	name="appDatalogin.password" id="widg_tfPasswordCustom"
maxlength="30"	
	size="30" 
/>


	
</customtag:widgetsPanelColumn>
<!--PROTECTED REGION END-->

