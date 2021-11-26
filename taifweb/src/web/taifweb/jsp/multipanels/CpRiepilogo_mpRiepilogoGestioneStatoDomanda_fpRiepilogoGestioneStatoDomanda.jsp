#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpRiepilogoGestioneStatoDomanda" class="formPanelBlock"><!-- startFragment:p_fpRiepilogoGestioneStatoDomanda -->
		
	
<div class="formPanel" id="fpRiepilogoGestioneStatoDomanda">


	
	

	
	
			
	
	<div id="p_wpRiepilogoGestioneStatoDomanda" class="widgetsPanelBlock"><!-- startFragment:p_wpRiepilogoGestioneStatoDomanda -->
	
	

<div class="widgetsPanel" id="wpRiepilogoGestioneStatoDomanda">
	
	<customtag:widgetsPanel id="wpRiepilogoGestioneStatoDomandaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('CpRiepilogo','cbRiepilogoStatiDomandaTest')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpRiepilogo.cbRiepilogoStatiDomandaTest.label')}" labelFor="widg_cbRiepilogoStatiDomandaTest" errorFor="appDataidStatoDomandaRiepilogo" labelId="cbRiepilogoStatiDomandaTestLbl"
	position="first"  >


<!-- widget cbRiepilogoStatiDomandaTest -->
<s:select name="appDataidStatoDomandaRiepilogo" id="widg_cbRiepilogoStatiDomandaTest"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatiDomandaRiepilogo"
	  disabled="isWidgetDisabled('CpRiepilogo','cbRiepilogoStatiDomandaTest')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpRiepilogo','tfRiepilogoNumeroProtocolloTest')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpRiepilogo.tfRiepilogoNumeroProtocolloTest.label')}" labelFor="widg_tfRiepilogoNumeroProtocolloTest" errorFor="appDatastatoDomanda.numeroProtocollo" labelId="tfRiepilogoNumeroProtocolloTestLbl"
	position="last"  >


<!-- widget tfRiepilogoNumeroProtocolloTest -->
<s:textfield 
	
	
	name="appDatastatoDomanda.numeroProtocollo" id="widg_tfRiepilogoNumeroProtocolloTest"
maxlength="20"	disabled="isWidgetDisabled('CpRiepilogo','tfRiepilogoNumeroProtocolloTest')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('CpRiepilogo','tfRiepilogoNoteTest')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('CpRiepilogo.tfRiepilogoNoteTest.label')}" labelFor="widg_tfRiepilogoNoteTest" errorFor="appDatastatoDomanda.note" labelId="tfRiepilogoNoteTestLbl"
	position="first"  >


<!-- widget tfRiepilogoNoteTest -->
<s:textfield 
	
	
	name="appDatastatoDomanda.note" id="widg_tfRiepilogoNoteTest"
maxlength="20"	disabled="isWidgetDisabled('CpRiepilogo','tfRiepilogoNoteTest')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('CpRiepilogo','btnRiepilogoConfermaModificaStatoTest')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRiepilogoConfermaModificaStatoTest -->
<s:submit name="widg_btnRiepilogoConfermaModificaStatoTest" id="widg_btnRiepilogoConfermaModificaStatoTest" method="handleBtnRiepilogoConfermaModificaStatoTest_CLICKED"
	key="CpRiepilogo.btnRiepilogoConfermaModificaStatoTest.label" cssClass="buttonWidget save"
	disabled="isWidgetDisabled('CpRiepilogo','btnRiepilogoConfermaModificaStatoTest')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRiepilogoGestioneStatoDomanda --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRiepilogoGestioneStatoDomanda --></div>
