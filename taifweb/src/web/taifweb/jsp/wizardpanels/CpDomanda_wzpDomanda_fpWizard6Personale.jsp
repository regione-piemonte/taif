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

	
	<div id="p_fpWizard6Personale" class="formPanelBlock"><!-- startFragment:p_fpWizard6Personale -->
		
	


	
	

	
	
			
	
	<div id="p_wpPersonale" class="widgetsPanelBlock"><!-- startFragment:p_wpPersonale -->
	
	
<h4 class="wpLabel"><s:text name="CpDomanda.wpPersonale.label" /> </h4>
<div class="widgetsPanel" id="wpPersonale">
	
	<customtag:widgetsPanel id="wpPersonaleTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpDomanda','udwAvvisoPersonaleDomandaAddettoFormazioneForestale')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >


<s:include value="/jsp/userwidgets/CpDomanda_udwAvvisoPersonaleDomandaAddettoFormazioneForestale.jsp"></s:include>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('CpDomanda','rbsPersonale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpDomanda.rbsPersonale.label')}" labelFor="widg_rbsPersonale" errorFor="widg_rbsPersonale" labelId="rbsPersonaleLbl"
	  >


<!-- widget rbsPersonale -->

	
<div id="widg_rbsPersonale" class="radiobuttons horizontal">





<div>

<s:url id="widg_rbsPersonaleurlRadioButtonValueChange"
   action="/taifweb/CpDomanda!handleRbsPersonale_VALUE_CHANGED" namespace="/base/domanda"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbPersonaleSi" name="widg_rbsPersonale"
	list="#{'SI':'Si'}"
	disabled="isWidgetDisabled('CpDomanda','rbsPersonale')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsPersonaleurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbPersonaleSiSI"><s:text name="CpDomanda.rbsPersonale.rbPersonaleSi.label" /></label>
</div>





<div>

<s:radio
	
	
	id="widg_rbPersonaleNo" name="widg_rbsPersonale"
	list="#{'NO':'No'}"
	disabled="isWidgetDisabled('CpDomanda','rbsPersonale')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbsPersonaleurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbPersonaleNoNO"><s:text name="CpDomanda.rbsPersonale.rbPersonaleNo.label" /></label>
</div>




	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpPersonale --></div>

			
	
	
	<div id="p_mpAltroPersonale" class="panelBlock"><!-- startFragment:p_mpAltroPersonale -->
		

		
<s:if test="#session.CpDomanda_mpAltroPersonale_selectedMultiPanel == 'CpDomanda_mpAltroPersonale_fpAltroPersonale'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAltroPersonale_fpAltroPersonale.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAltroPersonale --></div>

			
	
	
	<div id="p_mpAltroPersonaleFr" class="panelBlock"><!-- startFragment:p_mpAltroPersonaleFr -->
		

		
<s:if test="#session.CpDomanda_mpAltroPersonaleFr_selectedMultiPanel == 'CpDomanda_mpAltroPersonaleFr_fpAltroPersonaleFr'">
	<s:include value="/jsp/multipanels/CpDomanda_mpAltroPersonaleFr_fpAltroPersonaleFr.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAltroPersonaleFr --></div>

	

		
	

	<!-- endFragment:p_fpWizard6Personale --></div>
