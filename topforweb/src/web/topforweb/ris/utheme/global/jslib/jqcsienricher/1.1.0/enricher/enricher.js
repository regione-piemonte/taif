#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/*****************************
 * jqcsienricher v. 1.1.0 *
 *****************************/


// Funzione javascript per gestire relazione tra due select //

// // ***** in ajaxifyTag
// var old_value_combobox=""; //--> variabile che contiene il valore dell'ultimo
// combobox su cui e' andato il focus
// var old_name_combobox=""; //--> variabile che contiene il nome dell'ultimo
// combobox su cui e' andato il focus
// var is_onclick_combobox=false; //--> variabile che indica se si e' premuto col
// mouse sulla combobox su cui si ha il focus

function inFocus(oggetto) {
	old_value_combobox = oggetto.value;
	old_name_combobox = oggetto.name;
}

function cleanUrl(url) {
	var questionMarkIdx = url.indexOf("?");
	if (questionMarkIdx > 0){
		url = url.substring(0,questionMarkIdx);
	}

	return url;
}

// --> funzione che viene eseguita alla perdita del focus da parte del combobox
// e simula il comportamento del click
// sul pulsante submit del form
function lostFocus(oggetto, Submit_name, Submit_value, url) {
	// se l'oggetto che perde il focus ? lo stesso di quello per cui ho
	// memorizzato il suo vecchio valore e
	// quest'ultimo e' diverso da quello corrente eseguo il submit del form
	if (old_value_combobox != oggetto.value
			&& old_name_combobox == oggetto.name) {
		document.forms[0].action = cleanUrl(url);
		document.forms[0].submit();
	}
}

// --> funzione che viene eseguita al click sul combobox
function onCBClick(oggetto, Submit_name, Submit_value, url) {
	// controllo se e' gia' stato premuto il tasto del mouse
	if (is_onclick_combobox == true) {
		// mi comporto come se la combobox perda il fuoco
		is_onclick_combobox = false;
		lostFocus(oggetto, Submit_name, Submit_value, url)
		old_value_combobox = oggetto.value;
		old_name_combobox = oggetto.name;
	} else
		// se non e' stato premuto imposto la variabile a true per segnalare la
		// prima pressione
		is_onclick_combobox = true;
}




////////////////////////////////////////////////////////////////////////////////
//*********** RADIOBUTTONS ****************************************************
// Funzione javascript per gestire l'evento di change su un radiobutton
////////////////////////////////////////////////////////////////////////////////

function onRBClick(url) {
    document.forms[0].action = cleanUrl(url);
    document.forms[0].submit();
}


// ////////////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////////

OOJS.ns('JQCsi.enricher');
OOJS.ns('JQCsi.enrichments');
OOJS.ns('JQCsi.ui.windows');
OOJS.ns('JQCsi.util');

/**
 * @class JQCsi.enricher.UIEnricher
 * @extends Object Gestore degli arricchimenti. Una pagina pu? contenere vari
 *          arricchimenti. Ciascun arricchimento e' relativo ad un widget, ad un
 *          pannello, alla pagina nel complesso. Gli arricchimenti devono essere
 *          applicati: 1) al caricamento iniziale della pagina: tutti 2) ogni
 *          qual volta viene ricaricata la porzione di pagina a cui fa
 *          riferimento l'arricchimento Ogni arricchimento deve essere applicato
 *          una sola volta e non deve essere riapplicato se la porzione di
 *          pagina a cui fa riferimento non e' stata rinfrescata. Poiche' allo
 *          stato attuale il meccanismo di refresh ajax ha come elementi di
 *          refresh selettivo i pannelli e non i singoli widget, deve essere
 *          possibile comandare il "redo" selettivo degli arricchimenti in modo
 *          da riapplicare gli arricchimenti relativi a un insieme di pannelli.
 *          All'interno di un pannello, essendo possibile inserire vari widget,
 *          e' ipotizzabile la necessita' di realizzare vari arricchimenti atomici
 *          (magari ciascuno relativo ad un particolare widget). Non c'e' pero'
 *          l'esigenza di applicare solo alcuni degli arricchimenti relativi ai
 *          vari widget, e dunque gli arricchimenti possono essere registrati a
 *          livello di pannello. Poiche' i pannelli possono essere annidati e
 *          l'azione di refresh puo' essere associata a tutti i livelli di
 *          pannello e' compito di chi registra e successivamnete richiama gli
 *          arricchimenti, registrare e richiamare gli arricchimenti corretti.
 * 
 * Registrazione: se P1 contiene P1_1 e P1_2 devono essere registrati
 * potenzialmente fino a 3 arricchimenti, se necessario: uno relativo
 * esclusivamente a P1_1, uno a P1_2, e uno a P1, con il criterio che gli
 * arricchimenti siano additivi e non sovrapposti.
 * 
 * Richiamo: se P1 contiene P1_1 e P1_2 e viene effettuato il refresh di P1
 * devono essere riapplicati gli arricchimenti relativi ai due sottopannelli e
 * al pannello contenitore, se viene effettuato il refresh di uno solo dei due
 * sottopannelli deve essere riapplicato solo l'arricchimento corrispondente.
 */
JQCsi.enricher.UIEnricher = OOJS.extend(Object, {
	enrichments : {},
	structure : {},
	ready : false,
	/**
	 * @method setReady Imposta come pronto l'enricher
	 */
	setReady : function() {
		this.ready = true;
	},
	/**
	 * @method
	 * @param {Object}
	 *            structure la struttura del pannello imposta al struttura di
	 *            pannelli di un ContentPanel. La struttura &egrave; del tipo:
	 * 
	 * <pre></code>
	 * 		 
	 * 	  { name : &lt;nome&gt;
	 * 	  	 panels : 
	 * 	    [
	 * 	      {
	 * 	      	 &lt;stessa struttura&gt;
	 * 	      }
	 * 	    ]
	 * 	  }		
	 * 		
	 * </code></pre>
	 */
	setStructure : function(structure) {
		this.structure = structure;
	},
	/**
	 * @method
	 * @param {String}
	 *            panelId
	 * @param {String}
	 *            currStruct
	 * @return {Object} il sottoalbero di struttura che ha come root panelId
	 */
	locateInStructure : function(panelId, currStruct) {
		// alert("locate in structure:"+panelId+","+currStruct);
		if (currStruct != null && currStruct != []) {
			if (currStruct instanceof Array) {
				// alert("currStruct is array of "+currStruct.length+"
				// elements");
				var i = 0;
				var currSubp = null;
				var locatedInChild = null;
				for (i = 0; i < currStruct.length; i++) {
					currSubp = currStruct[i];
					locatedInChild = this.locateInStructure(panelId, currSubp);
					// alert(locatedInChild);
					if (locatedInChild != null)
						return locatedInChild;
				}
				return null;
			} else if (currStruct.name != undefined) {
				// alert("currStruct is a panel named "+currStruct.name);
				if (currStruct.name == panelId) {
					return currStruct;
				} else {
					// alert("go down...");
					return this.locateInStructure(panelId, currStruct.panels);
				}
			}
		} else {
			return null;
		}
	},
	/**
	 * @method
	 * @param {String}
	 *            panelID
	 * @param {String}
	 *            enrichment registra un arricchimento relativo al pannello
	 *            "panelID". gli arricchimenti sono additivi.
	 */
	registerEnrichment : function(panelID, enrichment) {
		if (!this.ready) {
			// alert('UIEnricher.register:'+name);
			var enrichmentsForPanel = this.enrichments[panelID];
			// se ? il primo istanzio l'array
			if (enrichmentsForPanel == null) {
				this.enrichments[panelID] = {
					value : new Array()
				};
				enrichmentsForPanel = this.enrichments[panelID];
			}
			var enrichmentsDtls = enrichmentsForPanel.value;
			enrichmentsDtls.push(enrichment);
		} else
			throw "UIEnricher cannot register in ready state";
	},
	/**
	 * @method
	 * @param {Array}
	 *            targets Applica tutt gli arricchimenti per i target
	 *            specificati, compresi quelli globali 'di skin'
	 */
	applyEnrichments : function(/* string[] */targets) {
		if (this.ready) {
			var i = 0;
			var currTarget;
			var targetStruct = null;
			for (i = 0; i < targets.length; i++) {
				currTarget = targets[i];
				targetStruct = this.locateInStructure(currTarget,
						this.structure);
				if (targetStruct != null) {
					this.applyEnrichmentsInternal(currTarget, targetStruct);
				} else
					throw "cannot locate " + currTarget + " in ui structure";
			}
			// globali
			try {
				styleEnrichments();
			} catch (err) {
				// ignore...
			}
		} else
			throw "UIEnricher cannot apply in non-ready state";
	},
	/**
	 * @param {String}
	 *            target il nome del pannello target su cui applicare
	 *            l'enrichment
	 * @param {Object}
	 *            targetStructure il sottoalbero di struttura pannelli con root
	 *            il nodo corrisp. al pannello target applica gli arricchimenti
	 *            per il singolo target tenendo presente la struttura dei
	 *            pannelli
	 */
	applyEnrichmentsInternal : function(/* string[] */target, targetStructure) {
		// alert("applyEnrichmentsInternal("+target+")");
		var currEnrStruct = this.enrichments[target];
		if (currEnrStruct != null) {
			var currEnrArray = currEnrStruct.value;
			for (var i = 0; i < currEnrArray.length; i++) {
				var currEnr = currEnrArray[i];
				currEnr();
			}
		} else {
			// scendo nella struttura
			var childs = targetStructure.panels;
			if (childs != null) {
				for (var i = 0; i < childs.length; i++) {
					var currChild = childs[i];
					this.applyEnrichmentsInternal(currChild.name, currChild);
				}
			}
		}
	},
	/**
	 * Applica tutti gli arricchimenti registrati nell'enricher, compresi quelli
	 * globali 'di skin'
	 */
	applyAll : function() {
		if (this.ready) {
			// alert('UIEnricher.applyAll:'+this.enrichments);
			for (var currTarget in this.enrichments) {
				// alert('UIEnricher.currTarget:'+currTarget);
				if (currTarget != null) {
					var currEnrArray = this.enrichments[currTarget].value;
					for (var i = 0; i < currEnrArray.length; i++) {
						var currEnr = currEnrArray[i];
						currEnr();
					}
				}
			}
			// globali
			try {
				styleEnrichments();
			} catch (err) {
				// ignore...
			}
		} else
			throw "UIEnricher cannot apply in non-ready state";
	}
});

// //////////////////////////////
// //////////////////////////////
// //////////////////////////////

/**
 * @class JQCsi.enrichments.NRichment
 * @extends Object Classe base degli arricchimenti registrabili nell' UIEnricher
 */
JQCsi.enrichments.NRichment = OOJS.extend(Object, {
			/**
			 * @method
			 */
			applyNRich : function() {
			}// override

		});

/**
 * @class JQCsi.enrichments.AddDatePicker
 * @extends JQCsi.enrichments.NRichment Arricchimento per trasformare un input
 *          in calendar.
 */
JQCsi.enrichments.AddDatePicker = OOJS.extend(JQCsi.enrichments.NRichment, {
			/**
			 * @cfg {String} widgId (obbligatorio) il nome del widget da
			 *      arricchire
			 */
			widgId : null,
			/**
			 * @cfg {Boolean} required (obbligatorio) true se il campo e'
			 *      obbligatorio
			 */
			required : false,
			/**
			 * @cfg {Boolean} changeYear (opzionale, default false): true per permettere
			 * selezione anno con dropdown
			 */
			selectYear: false,
			/**
			 * @cfg {String} determina il range della dropdown list per la selezione anno
			 * (utilizzato solo con selectYear=true)
			 */
			selectYearRange: 'c-10:c+10',
			/**
			 * @cfg {Boolean} (opzionale, default false): true per permettere
			 * selezione mese con dropdown 
			 */
			selectMonth: false, 
			constructor : function(config) {
				this.widgId = config.widgId;
				this.required = config.required;
				this.selectYear = config.selectYear;
				this.selectYearRange = config.selectYearRange;
				this.selectMonth = config.selectMonth;
			},
			applyNRich : function() {
				var originalEl = $('#' + this.widgId);
				if (originalEl != undefined && originalEl != null) {
					var isDisabled = originalEl.attr("disabled");
					originalEl.datepicker({
						showOn : "both",
						buttonImageOnly : true,
						buttonText : "",
						changeYear : this.selectYear,
						yearRange : this.selectYearRange,
						changeMonth : this.selectMonth,
						disabled : isDisabled
					});
				}
			}
		});

/**
 * @class JQCsi.enrichments.ErrorPopupEnabler
 * @extends JQCsi.enrichments.NRichment Abilita la visualizzazione dei popup di
 *          errore, se presenti. questo arricchimento e' globale e va richiamato
 *          ad ogni refresh.
 */
JQCsi.enrichments.ErrorPopupEnabler = OOJS.extend(JQCsi.enrichments.NRichment,
		{
			applyNRich : function() {
				// Nothing to do here: see jqtooltip.js, AUTOLOAD section
			}
		});

/**
 * Libreria di arricchimenti standard
 */
function UIEnrichments() {
	
}

/// date picker
//inizializzazione default dei widget
$(function($){
    $.datepicker.regional['it'] = {
        clearText: 'Svuota', clearStatus: 'Annulla',
        closeText: 'Chiudi', closeStatus: 'Chiudere senza modificare',
        prevText: '&#x3c;Prec', prevStatus: 'Mese precedente',
        prevBigText: '&#x3c;&#x3c;', prevBigStatus: 'Mostra l\'anno precedente',
        nextText: 'Succ&#x3e;', nextStatus: 'Mese successivo',
        nextBigText: '&#x3e;&#x3e;', nextBigStatus: 'Mostra l\'anno successivo',
        currentText: 'Oggi', currentStatus: 'Mese corrente',
        monthNames: ['Gennaio','Febbraio','Marzo','Aprile','Maggio','Giugno',
        'Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre'],
        monthNamesShort: ['Gen','Feb','Mar','Apr','Mag','Giu',
        'Lug','Ago','Set','Ott','Nov','Dic'],
        monthStatus: 'Seleziona un altro mese', yearStatus: 'Seleziona un altro anno',
        weekHeader: 'Sm', weekStatus: 'Settimana dell\'anno',
        dayNames: ['Domenica','Luned&#236','Marted&#236','Mercoled&#236','Gioved&#236','Venerd&#236','Sabato'],
        dayNamesShort: ['Dom','Lun','Mar','Mer','Gio','Ven','Sab'],
        dayNamesMin: ['Do','Lu','Ma','Me','Gio','Ve','Sa'],
        dayStatus: 'Usa DD come primo giorno della settimana', dateStatus: 'Seleziona D, M d',
        dateFormat: 'dd/mm/yy', firstDay: 1, 
        initStatus: 'Scegliere una data', isRTL: false};
    $.datepicker.setDefaults($.datepicker.regional['it']);
});

/// combobox
(function( $ ) {
	$.widget( "custom.combobox", {
		_create: function() {
			this.wrapper = $( "<span>" )
				.addClass( "custom-combobox" )
				.insertAfter( this.element );

			this.element.hide();
			this._createAutocomplete();
			this._createShowAllButton();
		},

		_createAutocomplete: function() {
			var selected = this.element.children( ":selected" ),
				value = selected.val() ? selected.text() : "";

			this.input = $( "<input>" )
				.appendTo( this.wrapper )
				.val( value )
				.attr( "title", "" )
				.addClass( "custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left" )
				.autocomplete({
					delay: 0,
					minLength: 0,
					source: $.proxy( this, "_source" )
				})
				.tooltip({
					tooltipClass: "ui-state-highlight"
				});
			var onSelectFunction = this._getSelectFunction(this.element);
			
			this._on( this.input, {
				autocompleteselect: function( event, ui ) {
					ui.item.option.selected = true;
					//this._trigger( "select", event, {
					//	item: ui.item.option
					//});
					if (onSelectFunction != undefined && onSelectFunction != null)
						 onSelectFunction();
				},

				autocompletechange: "_removeIfInvalid"
			});
		},
		_getSelectFunction : function(originalSelect) {
			var el = originalSelect;
			var originalOnBlur = el.attr("onblur");
			var valueChangedFunc = null; // NOP
			if (originalOnBlur != null
					&& originalOnBlur != undefined) {
				if (typeof originalOnBlur == 'string') {
					if (originalOnBlur != "") {
						var xmlHttpPostIdx = originalOnBlur
								.indexOf('xmlHttpPost');
						var returnIdx = originalOnBlur
								.indexOf('return');
						if (returnIdx > -1) {
							// rimuovo il "return;" finale
							originalOnBlur = originalOnBlur
									.substring(xmlHttpPostIdx,
											returnIdx - 1);
						}
						// trasformo in function
						valueChangedFunc = function() {
							eval(originalOnBlur);
						};
						return valueChangedFunc;
					}
				} else if (typeof originalOnBlur == 'function'){
					valueChangedFunc = originalOnBlur;
					return valueChangedFunc;
					}
				else
					throw "errore nell'impostazione della callback di on-select: tipo dell'attributo onblur ("
							+ (typeof originalOnBlur)
							+ ") non valido";
			}
		},
		_createShowAllButton: function() {
			var input = this.input,
				wasOpen = false;

			$( "<a>" )
				.attr( "tabIndex", -1 )
				.attr( "title", "Show All Items" )
				.tooltip()
				.appendTo( this.wrapper )
				.button({
					icons: {
						primary: "ui-icon-triangle-1-s"
					},
					text: false
				})
				.removeClass( "ui-corner-all" )
				.addClass( "custom-combobox-toggle ui-corner-right" )
				.mousedown(function() {
					wasOpen = input.autocomplete( "widget" ).is( ":visible" );
				})
				.click(function() {
					input.focus();

					// Close if already visible
					if ( wasOpen ) {
						return;
					}

					// Pass empty string as value to search for, displaying all results
					input.autocomplete( "search", "" );
				});
		},

		_source: function( request, response ) {
			var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
			response( this.element.children( "option" ).map(function() {
				var text = $( this ).text();
				if ( this.value && ( !request.term || matcher.test(text) ) )
					return {
						label: text,
						value: text,
						option: this
					};
			}) );
		},

		_removeIfInvalid: function( event, ui ) {

			// Selected an item, nothing to do
			if ( ui.item ) {
				return;
			}

			// Search for a match (case-insensitive)
			var value = this.input.val(),
				valueLowerCase = value.toLowerCase(),
				valid = false;
			this.element.children( "option" ).each(function() {
				if ( $( this ).text().toLowerCase() === valueLowerCase ) {
					this.selected = valid = true;
					return false;
				}
			});

			// Found a match, nothing to do
			if ( valid ) {
				return;
			}

			// Remove invalid value
			this.input
				.val( "" )
				.attr( "title", value + " didn't match any item" )
				.tooltip( "open" );
			this.element.val( "" );
			this._delay(function() {
				this.input.tooltip( "close" ).attr( "title", "" );
			}, 2500 );
			this.input.data( "ui-autocomplete" ).term = "";
		},

		_destroy: function() {
			this.wrapper.remove();
			this.element.show();
		}
	});
})( jQuery );



var uiNRichLib = new UIEnrichments();

/**
 * REMOVE IT!!
 */
UIEnrichments.prototype.addDatePickerNRich = function(widg_id, /* boolean */
		required, /* boolean */ selectYear, /* string */ selectYearRange, /* boolean */ selectMonth) {
	nr = new JQCsi.enrichments.AddDatePicker({
				widgId : widg_id,
				required : required,
				selectYear : selectYear,
				selectYearRange : selectYearRange,
				selectMonth : selectMonth
			});
	nr.applyNRich();
}

/**
 * @class JQCsi.enrichments.AddTextSuggestion
 * @extends JQCsi.enrichments.NRichment Arricchimento per aggiungere la
 *          suggestion remota ad un TextField.
 */
JQCsi.enrichments.AddTextSuggestion = OOJS.extend(JQCsi.enrichments.NRichment,
		{
			/**
			 * @cfg (String) suggestionUrl (obbligatorio) l'url che restituisce
			 *      l'elenco di suggestion. L'url riceve il testo immesso nel
			 *      parametro http specificato in 'queryParamOgnl' e deve
			 *      restituire un array di stringhe serializzato in formato JSON
			 *      (es. ["uno", "due", "tre", ...])
			 */
			suggestionUrl : null,
			/**
			 * @cfg (String) widgetId (obbligatorio) l'id html del TextField a
			 *      cui si deve applicare l'arricchimento
			 */
			widgetId : null,
			/**
			 * @cfg (String) queryParamOgnl (obbligatorio) il nome in cui viene
			 *      passato al server il testo parziale digitato da utente
			 */
			queryParamOgnl : null,
			/**
			 * @cfg (Boolean) required (obbligatorio) true se il campo e'
			 *      obbligatorio
			 */
			required : false,
			/**
			 * @cfg (Number) minChars (opzionale) specifica il numero di caratteri minimo
			 *      necessario per far partire la query. Il default e' 4
			 */
			minChars : 4,
			constructor : function(config) {
				this.suggestionUrl = config.suggestionUrl;
				this.widgetId = config.widgetId;
				this.queryParamOgnl = config.queryParamOgnl;
				this.required = config.required;
				if (config.minChars != undefined && config.minChars != null)
					this.minChars = config.minChars;
			},
			applyNRich : function() {
				var el = $("#"+this.widgetId);
				var url = this.suggestionUrl;
				if (el != undefined && el != null) {
					var mustDisable = el.attr("disabled") == "disabled"
							|| el.attr("disabled") == true;
					el.autocomplete({
						source: function(request, response) {
						    var query = {};
						    query[el.attr("name")] = request.term;
						    $.getJSON(url, query, response);
						},
						minLength: this.minChars
					});
				}
			}
		});

/**
 * REMOVE IT!!
 */
UIEnrichments.prototype.addTextSuggestionNRich = function(suggestionUrl,
		widgetId, queryParamOgnl, required, minChars) {
	nr = new JQCsi.enrichments.AddTextSuggestion({
				suggestionUrl : suggestionUrl,
				widgetId : widgetId,
				queryParamOgnl : queryParamOgnl,
				required : required,
				minChars : minChars
			});
	nr.applyNRich();
};

JQCsi.enrichments.AddComboSuggestion = OOJS.extend(
		JQCsi.enrichments.NRichment, {
			/**
			 * @cfg (String) suggestionUrl (obbligatorio) l'url che restituisce
			 *      l'elenco di suggestion.
			 */
			suggestionUrl : null,
			/**
			 * @cfg (String) widgetId (obbligatorio) l'id html del TextField a
			 *      cui si deve applicare l'arricchimento
			 */
			widgetId : null,
			/**
			 * @cfg (String) appDataName (obbligatorio) il nome dell'application
			 *      data
			 */
			appDataName : null,
			/**
			 * 
			 * @cfg {String} keyField nome della chiave della combo
			 */
			keyField : null,
			/**
			 * 
			 * @cfg {String} valueField nome del valore della combo
			 */
			valueField : null,
			/**
			 * 
			 * @cfg {String} refreshIds stringa che contiene gli id degli
			 *      oggetti da rileggere se ? presente un evento di valuechanged
			 */
			refreshIds : null,
			/**
			 * 
			 * @cfg {String} valueChangedUrl url della action da richiamare sul
			 *      valuechange
			 */
			valueChangedUrl : null,
			/**
			 * 
			 * @cfg {String} pageId id della pagina
			 */
			var_pageId : null,
			/**
			 * 
			 * @cfg {String} nome della form
			 */
			formName : null,
			/**
			 * @cfg (Boolean) required (obbligatorio) true se il campo ?
			 *      obbligatorio
			 */
			required : false,
			/**
			 * onSelectFunction
			 */
			onSelectFunction : null,
			/**
			 * @cfg (Number) minChars (opzionale) specifica il numero di caratteri minimo
			 *      necessario per far partire la query. Il default ? 4
			 */
			minChars : 4,
			constructor : function(config) {
				this.suggestionUrl = config.suggestionUrl;
				this.widgetId = config.widgetId;
				this.appDataName = config.appDataName;
				this.keyField = config.keyField;
				this.valueField = config.valueField;
				this.required = config.required;
				this.refreshIds = config.refreshIds;
				this.valueChangedUrl = config.valueChangedUrl;
				this.var_pageId = config.pageId;
				this.formName = config.formName;
				if (config.minChars != undefined && config.minChars != null)
					this.minChars = config.minChars;
				var v_valueChangedUrl = this.valueChangedUrl;
				var v_formName = this.formName;
				var v_refreshIds = this.refreshIds;
				var v_pageId = this.var_pageId;
				if (v_valueChangedUrl != undefined && v_valueChangedUrl != null
						&& v_valueChangedUrl != "") {
					this.onSelectFunction = function() {
						xmlhttpPost(v_valueChangedUrl, v_formName,
								v_refreshIds, this.v_pageId, "");
					};
				}
			},
			applyNRich : function() {
				var el = $("#"+this.widgetId);
				var url = this.suggestionUrl;
				var _keyFieldName = this.keyField;
				var _valFieldName = this.valueField;
				var hiddenId = 'hidden_'+this.widgetId;
				var mustDisable = el.attr("disabled") == "disabled"
					|| el.attr("disabled") == true; 
				var onSelectFunction = this.onSelectFunction;
				if (el != undefined && el != null && el.length >0 && !mustDisable) {
					// aggiunge l'hidden
					el.after("<input id=\""+hiddenId+"\" type=\"hidden\" name=\""+this.appDataName+"."+this.keyField+"\">");
					// abilita l'autocomplete
					el.autocomplete({
						source: function(request, response) {
						    var query = {};
						    query[el.attr("name")] = request.term;
						    $.getJSON(url, query, response);
						},
						select: function( event, ui ) {
							var selectedKey = ui.item[_keyFieldName];
							var selectedDescr = ui.item[_valFieldName];
							el.val(selectedDescr);
							var hiddenEl = $("#"+hiddenId);
							hiddenEl.val(selectedKey);
							ui.item.value=selectedDescr;
							
							if (onSelectFunction != undefined && onSelectFunction != null)
								 onSelectFunction();
						//	ui.item.option.selected = true;
						//	this._trigger( "select", event, {
						//		item: ui.item
						//	});
							
						},
						minLength: this.minChars
					}).data( "ui-autocomplete" )._renderItem = function( ul, item ) {
						return $( "<li>" )
						.append( "<a>" +  item[_valFieldName] +  "</a>" )
						.appendTo( ul );
						};
					
					var query = {};
					query[el.attr("name")] = el.val();
					$.getJSON(url, query, function( data, textStatus, jqXHR){
						if (data != null && data.length==1){
							var hiddenEl = $("#"+hiddenId);
							var preSelectedKey = data[0][_keyFieldName];
							hiddenEl.val(preSelectedKey);
						}
						else if (data != null && data.length > 1 && el.val() != null){
							// cerco una event. corrisp. totale
							for ( var el_i = 0; el_i < data.length; el_i++) {
								if (data[el_i][_valFieldName] == el.val()){
									var hiddenEl = $("#"+hiddenId);
									var preSelectedKey = data[el_i][_keyFieldName];
									hiddenEl.val(preSelectedKey);
									break;
								}
							}
						}
						
					});
				}
			}
		});

UIEnrichments.prototype.addComboSuggestionNRich = function(suggestionUrl,
		widgetId, appDataName, keyField, valueField, refreshIds,
		valueChangedUrl, pageId, formName, required, minChars) {
	nr = new JQCsi.enrichments.AddComboSuggestion({
				suggestionUrl : suggestionUrl,
				widgetId : widgetId,
				appDataName : appDataName,
				keyField : keyField,
				valueField : valueField,
				refreshIds : refreshIds,
				valueChangedUrl : valueChangedUrl,
				pageId : pageId,
				formName : formName,
				required : required, 
				minChars : minChars
			});
	nr.applyNRich();
};

/**
 * @class JQCsi.enrichments.AddComboNarrowing
 * @extends JQCsi.enrichments.NRichment Aggiunge ad una comboBox la funzione di
 *          autonarrowing, preservando un eventuale evento di VALUE_CHANGED
 */
 JQCsi.enrichments.AddComboNarrowing = OOJS.extend(JQCsi.enrichments.NRichment,
		{ 
			/**
			 * @cfg {String} widgetId (obbligatorio) l'id html della Table a cui
			 *      si deve applicare l'arricchimento
			 */
			widgetId : null,
			/**
			 * @cfg {Boolean} required (obbligatorio) true se il campo ?
			 *      obbligatorio
			 */
			required : false,
			constructor : function(config) {
				this.widgetId = config.widgetId;
				this.required = config.required;
			},
			applyNRich : function() {
				var el = $("#"+this.widgetId);
				var mustDisable = el.attr("disabled") == "disabled"
					|| el.attr("disabled") == true;
				if (el != undefined && el != null && !mustDisable){
					el.combobox();
				}
			/*	var el = Ext.get(this.widgetId);
				if (el != undefined && el != null) {
					var mustDisable = el.getAttribute("disabled") == "disabled"
							|| el.getAttribute("disabled") == true;
					var originalOnBlur = el.getAttribute("onblur");
					var valueChangedFunc = null; // NOP
					if (originalOnBlur != null && originalOnBlur != undefined) {
						if (typeof originalOnBlur == 'string') {
							if (originalOnBlur != "") {
								var xmlHttpPostIdx = originalOnBlur
										.indexOf('xmlHttpPost');
								var returnIdx = originalOnBlur
										.indexOf('return');
								if (returnIdx > -1) {
									// rimuovo il "return;" finale
									originalOnBlur = originalOnBlur.substring(
											xmlHttpPostIdx, returnIdx - 1);
								}
								// trasformo in function
								valueChangedFunc = function() {
									eval(originalOnBlur);
								};
							}
						} else if (typeof originalOnBlur == 'function')
							valueChangedFunc = originalOnBlur;
						else
							throw "errore nell'impostazione della callback di on-select: tipo dell'attributo onblur ("
									+ (typeof originalOnBlur) + ") non valido";
					}
					 
					var convertedCombo = new Ext.form.ComboBox({
								typeAhead : false,
								triggerAction : 'all',
								transform : this.widgetId,
								forceSelection : true,
								disabled : mustDisable,
								allowBlank : true,
								width : el.getWidth() + 17
							}); 
					
							
					
					 //[LC] STDMDD-1164, 1060 - Se esiste un "title" nell'elemento originale, lo ricreo con "Ext.ToolTip"
					
					if (el.getAttribute('title') != null && el.getAttribute('title') != '' ){				
						var tt = new Ext.ToolTip({							
							target: convertedCombo.getEl(),
							title: el.getAttribute('title'),
							plain: true,
							showDelay: 500,
							hideDelay: 0,
							trackMouse: true
						});								
						
						if (valueChangedFunc != null){				
						convertedCombo.on('select', valueChangedFunc);
					     convertedCombo.on('change', 
					    		function(convertedCombo, newVal, oldVal){convertedCombo.reset();});
					  }
					}
				}*/
			}
		});

/**
 * REMOVE IT!!
 */
UIEnrichments.prototype.addComboNarrowingNRich = function(widgetId, required) {
	nr = new JQCsi.enrichments.AddComboNarrowing({
				widgetId : widgetId,
				required : required
			});
	nr.applyNRich();	
}


/**
 * @class JQCsi.enrichments.AddTooltipsByID
 * @extends JQCsi.enrichments.NRichment Associa un tooltip a popup agli
 *          elementi html identificati tramite id. L'arricchimento e' effettuato
 *          in bundle. Se il tip vale null o "" non viene aggiunto
 */
JQCsi.enrichments.AddTooltipsByID = OOJS.extend(JQCsi.enrichments.NRichment, {
			/**
			 * @cfg tipsMap: mappa <id, tip>
			 */
			tipsMap : null,
			constructor : function(config) {
				this.tipsMap = config.tipsMap;
			},
			applyNRich : function() {
				var i = 0;
				for (i = 0; i < this.tipsMap.length; i++) {
					var currEntry = this.tipsMap[i];
					var currId = currEntry.id;
					var currTip = currEntry.tip;
					var currEl = Ext.get(currId);
					if (currEl != null && currTip != null && currTip != "") {
						new OOJS.ToolTip({
									target : currEl,
									html : currTip
								});
					}
				}
			}
		});

/**
 * REMOVE IT!!!
 */
UIEnrichments.prototype.addTooltipsByIDNRich = function(tipsMap) {
	nr = new JQCsi.enrichments.AddTooltipsByID({
				tipsMap : tipsMap
			});
	nr.applyNRich();
}

/**
 * @class JQCsi.enrichments.BasicTextFieldNRichment
 * @extends JQCsi.enrichments.NRichment Arricchisce i TextField attribuendo il
 *          L&F ExtJs, con: - evidenziazione constraint di required -
 *          evidenziazione constraint di validazione/conversione (?)
 */
JQCsi.enrichments.BasicTextFieldNRichment = OOJS.extend(
		JQCsi.enrichments.NRichment, {
			/**
			 * @cfg {String} widgetId
			 */
			widgetId : null,
			/**
			 * @cfg {Boolean} required
			 */
			required : false,
			/**
			 * @cfg {String} dataType
			 */
			dataType : null,
			/**
			 * @cfg {String} dataTypeModifier
			 */
			dataTypeModifier : null,
			constructor : function(config) {
				this.widgetId = config.widgetId;
				this.required = config.required;
				this.dataType = config.dataType;
				this.dataTypeModifier = config.dataTypeModifier;
			},
			applyNRich : function() {
				var el = $("#"+this.widgetId);
				if (el != undefined && el != null) {
					if (this.dataType != null
							&& (this.dataType == "int" || this.dataType == "float"
									|| this.dataType == "long"
									|| this.dataType == "double"
									|| this.dataType == "java.lang.Integer"
									|| this.dataType == "java.lang.Float"
									|| this.dataType == "java.lang.Double" 
									|| this.dataType == "java.lang.Long")) {
						var integerNumber = this.dataType == "int"
								|| this.dataType == "long"
								|| this.dataType == "java.lang.Integer"
								|| this.dataType == "java.lang.Long";
						if (integerNumber){
							el.keyfilter(/[\-\d\.]/);
						}
						else{
							el.keyfilter(/[\-\d\.\,]/);
						}
					} else {
						;;
					}
				}
			}
		});

/**
 * REMOVE IT !!!
 */
UIEnrichments.prototype.basicTextFieldNRich = function(widgetId, required,
		dataType, dataTypeModifier) {
	nr = new JQCsi.enrichments.BasicTextFieldNRichment({
				widgetId : widgetId,
				required : required,
				dataType : dataType,
				dataTypeModifier : dataTypeModifier
			});
	nr.applyNRich();
}


JQCsi.enrichments.EditorTextAreaNRichment = OOJS.extend(
		JQCsi.enrichments.NRichment, {
			/**
			 * @cfg {String} widgetId
			 */
			widgetId : null,
			/**
			 * @cfg {Boolean} required
			 */
			required : false,
			/**
			 * @cfg {String} dataType
			 */
			dataType : null,
			/**
			 * @cfg {String} dataTypeModifier
			 */
			dataTypeModifier : null,
			constructor : function(config) {
				this.widgetId = config.widgetId;
				this.required = config.required;
				this.dataType = config.dataType;
				this.dataTypeModifier = config.dataTypeModifier;
			},
			applyNRich : function() {
				var el = $("#"+this.widgetId);// cerco di ottenre la textarea html dal dom
				if (el != undefined && el != null && el.length >0) {	// verifico se esiste				
					
					//	verifico se esiste gi? l'istanza di CKEditor: in caso affermativo, lo elimino (operazione necessaria quando si ricarica il singolo pannello e non tutta la pagina)			
					if(CKEDITOR.instances[this.widgetId]){
					   delete CKEDITOR.instances[this.widgetId];
					}
					
					// trasformo la textarea in CKEditor utilizzando il file di configurazione custom presente nella skin in uso
					var ck = new CKEDITOR.replace(this.widgetId, {
						customConfig : '/ris/utheme/global/themes/xstructureV1/js/CKEditor/CKEditor_config.js'
					});		
					
				}
			}
		});
		

UIEnrichments.prototype.editorTextAreaNRich = function(widgetId, required,
		dataType, dataTypeModifier) {
	nr = new JQCsi.enrichments.EditorTextAreaNRichment({
				widgetId : widgetId,
				required : required,
				dataType : dataType,
				dataTypeModifier : dataTypeModifier
			});
	nr.applyNRich();
}


///////////////////////////////////////////
// Slider
///////////////////////////////////////////


JQCsi.enrichments.SliderNRichment = OOJS.extend(
		JQCsi.enrichments.NRichment, {
			/**
			 * @cfg {String} widgetId l'il del widget a cui applicare l'arricchimento
			 */
			widgetId : null,
			/**
			 * @cfg {Boolean} required true se il widget e' required (non ha effetto attualmente)
			 */
			required : false,
			/**
			 * @cfg {String} dataType (il tipo del valore del widget)
			 */
			dataType : null,
			/**
			 * @cfg {String} dataTypeModifier (il constraint sul valore (al momento non utilizzato)
			 */
			dataTypeModifier : null,
			/**
			 * @cfg {String} "fixed" => fissi e presi dalle property "fixedLB" e "fixedUB"; 
			 *               "dynamic" => presi dinamicamente dal valore di appositi elementi hidden 
			 */
			boundsType : null,
			/**
			 * @cfg {int} l'estremo inferiore dello slider (se boundsType=fixed)
			 */
			fixedLB : null,
			/**
			 * @cfg {int} l'estremo superiore dello slider (se boundsType=fixed)
			 */
			fixedUB : null,
			/**
			 * @cfg {float} lo step di spostamento dello slider (default = 1)
			 */
			step : 1.0,
			/**
			 * @cfg {String} "single" => selezione puntuale; "double" = selezione di range
			 */ 
			sliderType : null,
			constructor : function(config) {
				this.widgetId = config.widgetId;
				this.required = config.required;
				this.dataType = config.dataType;
				this.dataTypeModifier = config.dataTypeModifier;
				this.boundsType = config.boundsType;
				this.sliderType = config.sliderType;
				if (config.boundsType == "fixed"){
					this.fixedLB = config.fixedLB;
					this.fixedUB = config.fixedUB;
				}
				this.step = config.step;
			},
			applyNRich : function() {
				var el = $("#"+this.widgetId);// cerco di ottenere l'input di aggancio dal dom
				if (el != undefined && el != null && el.length >0) {	// verifico se esiste				
					
					var isDisabled = el.attr("disabled");
					if (isDisabled != undefined && isDisabled != null && isDisabled== "disabled"){
						isDisabled = true;
					} 
					else{
						idDisabled = false;
					}
					
					var doubleSlider = false;
					
					// init bounds
					var lb = 0; // dummy
					var ub = 100 // dummy
					var step = this.step;
					if (this.boundsType != null && this.boundsType == "fixed"){
						lb = this.fixedLB;
						ub = this.fixedUB;
					}
					else {
						// boundsType = dynamic
						lb = normalizeAndParse($("#"+this.widgetId+"_LB").prop("value"), this.dataType);
						ub = normalizeAndParse($("#"+this.widgetId+"_UB").prop("value"), this.dataType);
					}
					
					// init selection(s)
					var startSelLB = normalizeAndParse($("#"+this.widgetId+"_LB_selected").prop("value"), this.dataType);
					var startSelUB = null;
					if (this.sliderType!=null && this.sliderType=="double"){
						doubleSlider = true;
						startSelUB = normalizeAndParse($("#"+this.widgetId+"_UB_selected").prop("value"), this.dataType);
					}
					var varWidgID = this.widgetId;
					var valueType = this.dataType;
					//init widget
				    el.ionRangeSlider({
				    	type : this.sliderType,
				    	scale : true,
				        min : lb,
				        max : ub,
				        step : step,
				        from : startSelLB,
				        to : startSelUB,
				        disable : isDisabled,
				        onChange : function (data){
				        	var vv = null;
				        	if (doubleSlider){ // double selection => value= a;b
				        		var vv = $("#"+varWidgID).prop("value").split(";");
							var elVal1 = vv[0];
				        		var elVal2 = vv[1];
							$("#"+varWidgID+"_UB_selected").val(normalizeAndFormat(elVal2, valueType));
				        		$("#"+varWidgID+"_LB_selected").val(normalizeAndFormat(elVal1, valueType));
					        	
				        	}
				        	else{ // single selection => value = a
							var elVal=$("#"+varWidgID).prop("value");
				        		var vv = normalizeAndFormat(elVal, valueType);	
				        		$("#"+varWidgID+"_LB_selected").val(vv);
				        	}
				
				        	
				        } 
				    });	
					
					
							
					
				}
			}
		});
		

/**
 * permette di parsificare interi dove "." e' sep. di migliaia
 */
function normalizeAndParse(s, type){
	if (s == null){
		return null;
	}
	else{
		if (type ==null || type == "java.lang.Integer" || type == "int"){
			return parseInt(s.replace(".",""));
		}
		else if (type== "java.lang.Float" || type=="float"){
			var sn = s; //s.replace(".","").replace(",",".");
			return parseFloat(sn);
		}
		else if (type== "java.lang.Double" || type=="double"){
			var sn = s; //s.replace(".","").replace(",",".");
			return parseDouble(sn);
		}
	}
}

function normalizeAndFormat(n, type){
	if (type == "java.lang.Float" || type == "float" || type == "java.lang.Double" || type == "double"){
		var snn = String(n);
		return snn.replace(".",",");
	}
	else
	return String(n);
}

UIEnrichments.prototype.sliderNRich = function(widgetId, required,
		dataType, dataTypeModifier, boundsType, fixedLB, fixedUB, step, sliderType) {
	nr = new JQCsi.enrichments.SliderNRichment({
				widgetId : widgetId,
				required : required,
				dataType : dataType,
				dataTypeModifier : dataTypeModifier,
				boundsType : boundsType,
				fixedLB : fixedLB,
				fixedUB : fixedUB,
				step : step,
				sliderType : sliderType
			});
	nr.applyNRich();
}

// /////////////////////////////////////////////
// // DIALOG E POPUP
// /////////////////////////////////////////////

/**
 * @class JQCsi.ui.windows.HtmlDialog
 * @extends Object Dialog a popup utilizzabile per mostrare il contenuto di una
 *          pagina reperibile ad un determinato URL.
 */
JQCsi.ui.windows.HtmlDialog = OOJS.extend(Object, {
			/**
			 * @cfg {String} url la url della pagina da visualizzare
			 */
			url : null,
			/**
			 * @cfg {Integer} height dimensione verticale del dialog
			 *      (300=default)
			 */
			height : 300,
			/**
			 * @cfg {Integer} width dimensione orizzontale del dialog
			 *      (300=default)
			 */
			width : 300,
			/**
			 * @cfg {Boolean} resizable true=finestra ridimensionabile
			 */
			resizable : true,
			constructor : function(config) {
				this.url = config.url;
				this.height = config.height;
				this.width = config.width;
				this.resizable = config.resizable;
			},
			show : function() {
				/*
				var ulDialog = new Ext.Window({

							height : this.height,
							width : this.width,
							minHeight : 50,
							minWidth : 100,
							modal : true,
							shadow : true,
							collapsible : true,
							closable : true,
							autoScroll : true,
							body : new Ext.ux.ManagedIFrame({
										autoCreate : {
											id : 'dynamicIframe1',
											cls : 'x-window-body',
											width : '100%',
											height : '100%',
											src : JQCsi.util.URLUtils
													.normalizzaUrl(this.url)
										}
									}),
							animate : true,
							title : "Dialog",
							resizable : true,
							bodyBorder : true,
							buttons : [{
										text : "Chiudi",
										handler : function() {
											ulDialog.hide();
											ulDialog.destroy();
										}
									}],
							keys : [{
										key : 27,
										fn : function() {
											ulDialog.hide();
											ulDialog.destroy();
										},
										scope : this
									}]
						});
				ulDialog.show(); */
			}
		});

/**
 * @class JQCsi.ui.windows.HtmlPopup
 * @extends Object Dialog a popup utilizzabile per mostrare il contenuto di una
 *          pagina reperibile ad un determinato URL.
 */
JQCsi.ui.windows.HtmlPopup = OOJS.extend(Object, {
			/**
			 * @cfg {String} url la url della pagina da visualizzare
			 */
			url : null,
			/**
			 * @cfg {Integer} height dimensione verticale del dialog
			 *      (300=default)
			 */
			height : 300,
			/**
			 * @cfg {Integer} width dimensione orizzontale del dialog
			 *      (300=default)
			 */
			width : 300,
			/**
			 * @cfg {Boolean} resizable true=finestra ridimensionabile
			 */
			resizable : true,
			/**
			 * @cfg {Boolean} scrollable true=finestra scrollabile
			 */
			scrollable : true,
			/**
			 * @cfg {Boolean} toolbar true=toolbar presente
			 */
			toolbar : true,
			constructor : function(config) {
				this.url = config.url;
				this.height = config.height;
				this.width = config.width;
				this.resizable = config.resizable;
				this.scrollable = config.scrollable;
				this.toolbar = config.toolbar;
			},
			show : function() {
				var parametri = '';
				if (this.toolbar) {
					parametri += 'toolbar=yes, ';
				} else {
					parametri += 'toolbar=no, ';
				}
				if (this.resizable) {
					parametri += 'resizable=yes, ';
				} else {
					parametri += 'resizable=no, ';
				}
				if (this.scrollable) {
					parametri += 'scrollbars=yes, ';
				} else {
					parametri += 'scrollbars=no, ';
				}
				parametri += 'top=70, ';
				parametri += 'left=70, ';
				parametri += 'width=' + this.width + ', ';
				parametri += 'height=' + this.height;
				window.open(JQCsi.util.URLUtils.normalizzaUrl(this.url), 'Window',
						parametri);
			}
		});

/**
 * @class JQCsi.util.URLUtil
 * @extends Object Funzioni di utilita' per la manipolazione di URL.
 */
JQCsi.util.URLUtils = function() {
	return {
		/**
		 * @method
		 * @param {String}
		 *            url l'url da normalizzare
		 * @return {String} l'url normalizzato [TODO:spiegare meglio]
		 */
		normalizzaUrl : function(url) {
			if (url.indexOf('http:') != -1) {
				return url;
			}

			var tmpPath = location.href.toString();

			if (JQCsi.util.URLUtils.startsWith(url, '/')) {
				return tmpPath.substring(0, tmpPath
								.indexOf(JQCsi.util.URLUtils.rightBack(
										tmpPath, "/"))
								- 1)
						+ url;
			} else {
				return tmpPath.substring(0, tmpPath
								.indexOf(JQCsi.util.URLUtils.rightBack(
										tmpPath, "/")))
						+ url;
			}
		},
		/**
		 * @method
		 * @param {String}
		 *            strSource [TODO:??]
		 * @param {String}
		 *            strSearch [TODO:??] usata per ricostruire l'url [TODO:
		 *            spiegare meglio]
		 */
		rightBack : function(strSource, strSearch) {
			sourceStringBack = "";
			searchStringBack = "";
			result = "";
			turn = "";
			pos = -1;
			for (i = strSource.length; i > -1; i--) {
				sourceStringBack = sourceStringBack + strSource.charAt(i)
			} // end for
			for (i = strSearch.length; i > -1; i--) {
				searchStringBack = searchStringBack + strSearch.charAt(i)
			} // end for
			pos = sourceStringBack.indexOf(searchStringBack);
			result = sourceStringBack.substring(0, pos)
			for (i = result.length; i > -1; i--) {
				turn = turn + result.charAt(i)
			}
			return turn;
		},
		/**
		 * @method
		 * @param {String}
		 *            str la stringa in cui cercare il prefisso
		 * @param {String}
		 *            prefix il prefisso da cercare nella stringa verifica se
		 *            una stringa inizia con un prefisso specificato.
		 */
		startsWith : function(str, prefix) {
			return (str.match("^" + prefix) == prefix);
		}
	}

}();

// /////////////////////////////////////////////
// / gestione dello stato client side dei widget
// /////////////////////////////////////////////

/**
 * Inizializza il gestore dello stato client side basato sui cookie. Ciascun
 * widget interessato avra' uno 'stateId' univoco composto da <id content
 * panel>_<id widget>.
 */
UIEnrichments.prototype.initStateManager = function() {
/*	var cp = new Ext.state.CookieProvider({
				path : "/",
				expires : new Date(new Date().getTime() + (1000 * 60 * 60 * 8))
			});
	Ext.state.Manager.setProvider(cp); */
}

// /////////////////////
// /////////////////////
// /////////////////////

/**
 * Mantiene gli arricchitori dell'intera applicazione
 */
// function UIEnricherMgr() {
// this.enrichers = {};
// this.ready = false;
// }
JQCsi.enricher.UIEnricherMgr = OOJS.extend(Object, {
			enrichers : {},
			ready : false,
			setReady : function() {
				// alert('nrm.setReady');
				this.ready = true;
				for (var currEnricher in this.enrichers) {
					this.enrichers[currEnricher].value.setReady();
				}
			},
			setEnricherForPage : function(pageId, /* UIEnricher */enricher) {
				if (!this.ready) {
					// alert('UIEnricherMgr.setEnricherForPage:'+pageId )
					this.enrichers[pageId] = {
						value : enricher
					};
				} else
					throw "UIEnricherMgr: cannot set enricher in ready state";
			},
			getEnricherForPage : /* UIEnricher */function(pageId) {
				// alert('UIEnricherMgr.getEnricherForPage:'+pageId );
				var temp = this.enrichers[pageId];
				if (temp != null)
					return temp.value;
				else
					return null;
			},
			registerEnrichment : function(pageId, name, enrichment) {
				// alert('UIEnricherMgr.register:'+pageId+','+name);
				var enricher = this.getEnricherForPage(pageId);
				if (enricher == null) {
					enricher = new JQCsi.enricher.UIEnricher();
					this.setEnricherForPage(pageId, enricher);
				}
				enricher.registerEnrichment(name, enrichment);
			},
			setPageStructure : function(pageId, structure) {
				var enricher = this.getEnricherForPage(pageId);
				if (enricher == null) {
					enricher = new JQCsi.enricher.UIEnricher();
					this.setEnricherForPage(pageId, enricher);
				}
				enricher.setStructure(structure);
			},
			applyAll : function(pageId) {
				if (this.ready) {
					// alert('UIEnricher.applyAllRich:'+pageId);
					var enricher = this.getEnricherForPage(pageId);
					if (enricher != null)
						enricher.applyAll();
				} else
					throw "UIEnricherMgr cannot apply in non-ready state";
			},
			apply : function(pageId, /* string [] */targets) {
				if (this.ready) {
					// alert('UIEnricher.applyRich:'+pageId+','+targets);
					var enricher = this.getEnricherForPage(pageId);
					if (enricher != null)
						enricher.applyEnrichments(targets);
				} else
					throw "UIEnricherMgr cannot apply in non-ready state";
			}

		});

/**
 * "singleton" di Enricher manager per tutta l'applicazione
 */
// var uiEnricherMgr = new UIEnricherMgr();
var uiEnricherMgr = new JQCsi.enricher.UIEnricherMgr();
