#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
<%@taglib uri="/struts-tags" prefix="s" %>

<%-- Parametro per la gestione della abilitazione/disabilitazione del widget --%>
<s:set name="CpDomanda_udwInfoAttrezzatureFr_enabled_local" value="isWidgetDisabled('CpDomanda','udwInfoAttrezzatureFr')" />

<!--PROTECTED REGION ID(R-2031928061) ENABLED START-->
<!-- Inserire qui il codice del widget -->
<div id="p_msgInfo" class="msgBoxPanelBlock">
                           <!-- startFragment:p_msgInfo -->
                           <div class="msgBoxPanel info" id="msgInfo">
                              <p>
                                 <!-- widget ptInfo -->
                                 Section non requise
                              </p>
                           </div>
                           <!-- endFragment:p_msgInfo -->
                        </div>
<!--PROTECTED REGION END-->

