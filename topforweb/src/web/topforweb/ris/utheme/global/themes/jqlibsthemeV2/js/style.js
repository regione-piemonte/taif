#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
function styleEnrichments(){
	
	// Sulla base della struttura UL>LI, costruisco il corrispondente menu arricchito, riportando le classi CSS e gli HREF originari
//	var hmn = ExtCsi.enrichments.Menus.buildMenus('mainMenu');
	
	// menu ad espansione sul mouse over
	//var menuTrgUls=jQuery('#mainMenu ul');
 /*       var menuTrgUls=jQuery('div.menuPanel.vertical #mainMenu ul');
	if (menuTrgUls != null){
		menuTrgUls.menuVer();
	}
	*/
	var menuTrgUls2=jQuery('div.menuPanel.horizontal #mainMenu ul');
	if (menuTrgUls2 != null){
		menuTrgUls2.menuHor();
	}
	
	//*** debug ***
//	var aprihelpRichElements = Ext.query('table > .aprihelp');
	//alert(" ))) Numero di oggetti 'aprihelpRichElements' individuati: "+aprihelpRichElements.length);
	
		
	/**
	 * gestione pupup e dialog
	 * Ricerco gli oggetti che hanno CSS aprihelp - apricontatti - apri a cui applico le caratteristiche desiderate
	 */
		
	var nuovaFinestraText = " - Attenzione: questo link si apre in una nuova finestra";
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


	// APRI
	//({height: '600', width: '800', resizable: true, scrollable: true, toolbar: true});
	    var aApri = jQuery('a.apri');
	    if (aApri != null){
		aApri.click(
		    function(event){
			var url = $(this).attr("href");
			var oldHrefTitle = $(this).attr('title');
			if (oldHrefTitle == null)
			oldHrefTitle = "";
			$(this).attr('title', oldHrefTitle + ' - Attenzione: questo link si apre in una nuova finestra');
			window.open(url, "new window","width=800,height=600,scrollbars=yes,toolbar=yes");
			event.preventDefault();			    
			    }
		);
		
		
	    };
	
	    // APRICONTATTI
	    //{height: '260', width: '510', resizable: false, scrollable: false, toolbar: true});
	    var aApricontatti = jQuery('a.apricontatti');
	    if (aApricontatti != null) {
		    aApricontatti.dialogahah({
                 width: 400, 
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
	/* APRIHELP =============================================
	 * applico la chiamata al popup per ogni
	 * elemento che ha la classe css .aprihelp
	 */		 
//	var aprihelpElements = Ext.query(".aprihelp");							// tutti gli elementi con CSS aprihelp
	//alert(" ))) Numero di oggetti 'aprihelpElements' individuati: "+aprihelpElements.length);
	
//	var aprihelpButtonElements = Ext.query("em button", aprihelpElements );	// seleziono solo i BUTTON dentro EM (table > tbody > tr > td > em > button: cos� � strutturata una singola voce del menu orizzontale)
	//alert(" ))) Numero di oggetti 'aprihelpButtonElements' individuati: "+aprihelpButtonElements.length);

	// PARSIFICO GLI ELEMENTI DEL MENU ORIZZONTALE CON CSS .APRIHELP	
//	Ext.each(aprihelpButtonElements, function(elemento, index){
//		if(Ext.isIE)	
//			elemento.title = (aprihelpElements[index].innerText.trim())+nuovaFinestraText;
//		else	
//			elemento.title = (aprihelpElements[index].text.trim())+nuovaFinestraText;
		
//		elemento.onclick = function(){	
//			var dialog = new ExtCsi.ui.windows.HtmlDialog({url: aprihelpElements[index].href, height: '440', width: '790', resizable: false, scrollable: false, toolbar: true});
//			dialog.show();
//			return false;
//		};
//	});

	// PARSIFICO GLI ELEMENTI CON CSS .APRIHELP (NO MENU ORIZZONTALE)
//	Ext.each(aprihelpElements, function(elemento, index){
				
		//alert("Il title e' |"+elemento.title+"|")
		//alert("Il tag e' |"+elemento.tagName+"|")
		//alert("Il CSS e' |"+elemento.className+"|")
		//alert("id e' |"+elemento.id+"|")
		//alert("aprihelpButtonElements.length== "+aprihelpButtonElements.length)
		//alert("aprihelpElements.length== "+aprihelpElements.length)
			
//		sonoObjHM = false;
//		for(var i = 0; i < aprihelpButtonElements.length; i++) {
			//alert("01: "+elemento.tagName);
			//alert("02: "+Ext.query("em button", elemento));
			
//			var currEl =  Ext.query("em button", elemento);			
//			if(currEl.length > 0){	// *** se � una TABLE che contiene EM > BUTTON, la scarto perch� � l'oggetto del menu orizzonatale gi� processato *** //
			  //alert("sono un oggetto .aprihelp del menu orizz")
//			  sonoObjHM = true;
//			  break;
//			}
//		}
					
//		if(!sonoObjHM){	// se NON � un oggetto del menu orizzontale, lo parsifico
			//alert("testOne aprihelp")
//			if(Ext.isIE)
//				elemento.title = (elemento.innerText.trim())+nuovaFinestraText;			
//			else	
//				elemento.title = (elemento.text.trim())+nuovaFinestraText;
				
//			elemento.onclick = function(){
//				var dialog = new  ExtCsi.ui.windows.HtmlDialog({url: elemento.href, height: '440', width: '790', resizable: true, scrollable: false, toolbar: true});
//				dialog.show();
//				return false;
//			};
//		}

//	});	

		
		
		
	/* APRICONTATTI =============================================
	 * applico la chiamata al popup per ogni
	 * elemento che ha la classe css .apricontatti
	 */	 
//	var apricontattiElements = Ext.query(".apricontatti");
	//alert(" ))) Numero di oggetti 'apricontattiElements' individuati: "+apricontattiElements.length);
	
//	var apricontattiButtonElements = Ext.query("em button", apricontattiElements );
	//alert(" ))) Numero di oggetti 'apricontattiButtonElements' individuati: "+apricontattiButtonElements.length);

	// PARSIFICO GLI ELEMENTI DEL MENU ORIZZONTALE CON CSS .APRICONTATTI
//	Ext.each(apricontattiButtonElements, function(elemento, index){
//		if(Ext.isIE)
//			elemento.title = (apricontattiElements[index].innerText.trim())+nuovaFinestraText;
//		else	
//			elemento.title = (apricontattiElements[index].text.trim())+nuovaFinestraText;
			
//		elemento.onclick = function(){	
//			var dialog = new ExtCsi.ui.windows.HtmlDialog({url: apricontattiElements[index].href, height: '260', width: '510', resizable: false, scrollable: false, toolbar: true});
//			dialog.show();
//			return false;
//		};
//	});

	// PARSIFICO GLI ELEMENTI CON CSS .APRICONTATTI (NO MENU ORIZZONTALE)	
//	Ext.each(apricontattiElements, function(elemento, index){
	
//		sonoObjHM = false;
//		for(var i = 0; i < apricontattiButtonElements.length; i++) {
			//alert("01: "+elemento.tagName);
			//alert("02: "+Ext.query("em button", elemento));
			
//			var currEl =  Ext.query("em button", elemento);					
//			if(currEl.length > 0){	// se � una TABLE che contiene EM > BUTTON, la scarto perch� � l'oggetto del menu orizzonatale gi� processato
			  //alert("sono un oggetto .apricontatti del menu orizz")
//			  sonoObjHM = true;
//			  break;
//			}
//		}
		
//		if(!sonoObjHM){	// se NON � un oggetto del menu orizzontale, lo parsifico
			//alert("testOne apricontatti")
//			if(Ext.isIE)
//				elemento.title = (elemento.innerText.trim())+nuovaFinestraText;			
//			else	
//				elemento.title = (elemento.text.trim())+nuovaFinestraText;
				
//			elemento.onclick = function(){
//				var dialog = new  ExtCsi.ui.windows.HtmlDialog({url: elemento.href, height: '260', width: '510', resizable: false, scrollable: false, toolbar: true});
//				dialog.show();
//				return false;
//			};
//		}
//	});		


		
		
		
	/* APRI ============================================= 
	 * applico la chiamata al popup per ogni
	 * elemento che ha la classe css .apri
	 */
	 
//	var apriElements = Ext.query(".apri");
//	var apriButtonElements = Ext.query("em button", apriElements );
	
	// PARSIFICO GLI ELEMENTI DEL MENU ORIZZONTALE CON CSS .APRI
//	Ext.each(apriButtonElements, function(elemento, index){
//		if(Ext.isIE)
//			elemento.title = (apriElements[index].innerText.trim())+nuovaFinestraText;
//		else
//			elemento.title = (apriElements[index].text.trim())+nuovaFinestraText;
			
//		elemento.onclick = function(){	
//			var dialog = new ExtCsi.ui.windows.HtmlPopup({url: apriElements[index].href, height: '600', width: '800', resizable: true, scrollable: true, toolbar: true});
//			dialog.show();
//			return false;
//		};
//	});
			
	// PARSIFICO GLI ELEMENTI CON CSS .APRI (NO MENU ORIZZONTALE)		
//	Ext.each(apriElements, function(elemento, index){
		
//		sonoObjHM = false;
//		for(var i = 0; i < apriButtonElements.length; i++) {
			//alert("01: "+elemento.tagName);
			//alert("02: "+Ext.query("em button", elemento));
			
//			var currEl =  Ext.query("em button", elemento);			
//			if(currEl.length > 0){	// se � una TABLE che contiene EM > BUTTON, la scarto perch� � l'oggetto del menu orizzonatale gi� processato
			  //alert("sono un oggetto .apri del menu orizz")
//			  sonoObjHM = true;
//			  break;
//			}
//		}
	
//		if(!sonoObjHM){	// se NON � un oggetto del menu orizzontale, lo parsifico
			//alert("testOne apri")
//			if(Ext.isIE)
//				elemento.title = (elemento.innerText.trim())+nuovaFinestraText;			
//			else	
//				elemento.title = (elemento.text.trim())+nuovaFinestraText;
				
//			elemento.onclick = function(){
//				var dialog = new  ExtCsi.ui.windows.HtmlPopup({url: elemento.href, height: '600', width: '800', resizable: true, scrollable: true, toolbar: true});
//				dialog.show();
//				return false;
//			};
//		}
//	});		

	
	
	/*
	 * richiamo all'arricchitore del popup errori
	 * se ce ne sono
	 */
	var popupErrori = new JQCsi.enrichments.ErrorPopupEnabler();
	popupErrori.applyNRich();
	
	
	/*
	 * toggle panel
	 */
//	var toggle = new ExtCsi.enrichments.TogglePanel({
//		label_on :'&nbsp;<span class="espandi">Visualizza</span>',
//		label_off :'&nbsp;<span class="collapse">Nascondi</span>',
//		keep_status : true, //se impostato a true allora mantiene lo stato delle sezioni, default:false
//		menu2 : '.togglepanel_menu',//default: false (niente "menu")
//		menu_on : 'apri tutte le sezioni',//default: visualizza tutte le sezioni
//		menu_off : 'nascondi tutte le sezioni'//default : nascondi tutte le sezioni
//	}).init();  
	
	
	
}


/*
 *	ROLLOVER PER INTERNET EXPLORER 6 SU ELEMENTI DI TIPO "INPUT"
 */
 /*
Ext.onReady(function(){	
	doRolloverOnIE6Input();
});


function doRolloverOnIE6Input(){
	
	if(Ext.isIE6){		
		//alert("INPUT SUBMIT presenti: "+Ext.query('input[type=submit]').length+"\nINPUT RESET presenti: "+Ext.query("input[type=reset]").length);
		
		
		Ext.each(Ext.query('input[type=submit],input[type=reset]'), function(e){ 	// ciclo su tutti gli elementi INPUT di tipo SUBMIT e RESET presenti in pagina 
			
			var cssNormal = "";
					
																					// evento MOUSE OVER - naming rule = (nomeCss+"Hover")
			if (e.attachEvent){														// verifico se il browser supporta il metodo "attachEvent"
				e.attachEvent("onmouseover", 
								function(){	var cssHover = "";						// reset variabile locale
											cssNormal = e.className;				// registro il css in entrata (senza mouse over)
											var tokens = cssNormal.split(" ");		// se l'oggetto ha pi� css li spezzo usando il blank come separatore
											for(var i = 0;i<tokens.length;i++){		
												cssHover += tokens[i]+"Hover ";		// ad ogni token aggiungo la desinenza "Hover" e ricompongo la stringa
											}
											e.className = cssHover;  				// impongo al browser di usare il/i nuovo/i css
										});
			}
			

																					// evento MOUSE OUT 
			if (e.attachEvent){
				e.attachEvent("onmouseout", 
								function(){  e.className = cssNormal;  });			// ripristino lo stile di partenza precedentemente salvato
			}
			
		});
	}
}
*/
