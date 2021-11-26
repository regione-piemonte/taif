#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
function styleEnrichments(){
	
	
	/**
	 * gestione pupup e dialog
	 * Ricerco gli oggetti che hanno CSS aprihelp - apricontatti - apri a cui applico le caratteristiche desiderate
	 */
		
	var nuovaFinestraText = "";
	var sonoObjHM;	
	
	
    // APRIHELP
	// ({url: aprihelpElements[index].href, height: '440', width: '790', resizable: false, scrollable: false, toolbar: true}
	var aAprihelp = jQuery('a.aprihelp');
	if (aAprihelp != null) {aAprihelp.dialogahah({
               width: 400, 
                modal: false, 
                bgiframe: true, 
                resizable: true, 
                draggable: true,
                chiudi   :true, 
		title: 'questo link si apre in una nuova finestra'
            });
	};
	
	    // APRIALBO
	    var aAlbo = jQuery('a.aprialbo');
	    if (aAlbo) {
		    aAlbo.dialogahah({
                 width: 600, 
				 modal: false, 
                bgiframe: true, 
                resizable: true, 
                draggable: true,
                chiudi   :true,
                load: function(dialog_target) {
                    // init buttons rupar modale
                    jQuery(dialog_target).jbutton_init();
                }
            });
    };

	
	
}


// When the user clicks on div, open the popup
	function showPopup(e) {
		var popup = document.getElementById(e);
		popup.classList.toggle("show");
	}
		
