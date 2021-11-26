#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/*******************************************************************************
 * jqcsienricher v. 1.0.0 *
 ******************************************************************************/

// ***dichiarazione dei n amespaces
OOJS.ns('JQCsi.GreaseExt');
OOJS.ns('JQCsi.GreaseExt.data');
OOJS.ns('JQCsi.ui.maps');
OOJS.ns('ExtCsi.ui.maps'); // lasciato namespace Ext per evitare impatti all
							// extjscsienricher

/**
 * gestore delle costanti
 * 
 * @function JQCsi.GreaseExt.Constants
 */
JQCsi.GreaseExt.Constants = function() {
	return {
		/**
		 * valore dell'evento di start delle chiamate ajax value =
		 * 'startchiamate'
		 * 
		 * @type {String}
		 */
		START_CALL_EVENT : 'startchiamate',
		/**
		 * valore dell'evento di end delle chiamate ajax value = 'endchiamate'
		 * 
		 * @type {String}
		 */
		END_CALL_EVENT : 'endchiamate',
		/**
		 * valore della chiave di coda value = 'in esecuzione'
		 * 
		 * @type {String}
		 */
		KEY_CODE : 'in esecuzione',
		/**
		 * valore della chiave di ZOOMRECT value = 'zoomrect'
		 * 
		 * @type {String}
		 */
		ZOOMRECT_KEY : 'zoomrect',
		/**
		 * contenuto della chiave di ZOOMRECT value = '<strong>Zoom avanti:</strong>
		 * cliccare per ingrandire e centrare la mappa o tracciare un rettangolo
		 * sull\'area di zoom'
		 * 
		 * @type {String}
		 */
		ZOOMRECT_VALUE : '<strong>Zoom avanti:</strong>  cliccare per ingrandire e centrare la mappa o tracciare un rettangolo sull\'area di zoom',
		/**
		 * valore della chiave di eventHandler value = 'eventHandler'
		 * 
		 * @type {String}
		 */
		EVENTH_HANDLER_KEY : 'eventHandler',
		/**
		 * contenuto della chiave di eventHandler value = 'Cliccare per
		 * abilitare la localizzazione sulla mappa'
		 * 
		 * @type {String}
		 */
		EVENTH_HANDLER_VALUE : 'Cliccare per abilitare la localizzazione sulla mappa',
		/**
		 * valore della chiave di PAN value = 'pan'
		 * 
		 * @type {String}
		 */
		PAN_KEY : 'pan',
		/**
		 * contenuto della chiave di PAN value = '<strong>Pan:
		 * </strong>cliccare sulla mappa e trascinare per spostarla'
		 * 
		 * @type {String}
		 */
		PAN_VALUE : '<strong>Pan: </strong>cliccare sulla mappa e trascinare per spostarla',
		/**
		 * valore della chiave di ZOOMOUT value = 'zoomout'
		 * 
		 * @type {String}
		 */
		ZOOMOUT_KEY : 'zoomout',
		/**
		 * contenuto della chiave di ZOOMOUT value = '<strong>Zoom indietro:
		 * </strong>cliccare per ridurre la scala di zoom e centrare la mappa
		 * sul punto'
		 * 
		 * @type {String}
		 */
		ZOOMOUT_VALUE : '<strong>Zoom indietro: </strong>cliccare per ridurre la scala di zoom e centrare la mappa sul punto',
		/**
		 * valore della chiave di IDENTIFY value = 'identify'
		 * 
		 * @type {String}
		 */
		IDENTIFY_KEY : 'identify',
		/**
		 * contenuto della chiave di IDENTIFY value = '<strong>Identify:
		 * </strong>cliccare su mappa per identify del layer selezionato in TOC'
		 * 
		 * @type {String}
		 */
		IDENTIFY_VALUE : '<strong>Identify: </strong>cliccare su mappa per identify del layer selezionato in TOC',
		/**
		 * valore della chiave di MISURA_LINEA value = 'msuraLinea'
		 * 
		 * @type {String}
		 */
		MISURA_LINEA_KEY : 'msuraLinea',
		/**
		 * contenuto della chiave di MISURA_LINEA value = '<strong>Misura
		 * linea: </strong>cliccare su mappa per ogni segmento da misurare.
		 * doppio clic per terminare misura'
		 * 
		 * @type {String}
		 */
		MISURA_LINEA_VALUE : '<strong>Misura linea: </strong>cliccare su mappa per ogni segmento da misurare. doppio clic per terminare misura',
		/**
		 * valore della chiave di MISURA_AREA value = 'msuraArea'
		 * 
		 * @type {String}
		 */
		MISURA_AREA_KEY : 'msuraArea',
		/**
		 * contenuto della chiave di MISURA_AREA value = '<strong>Misura
		 * poligono: </strong>cliccare per tracciare i vertici dell\'area di
		 * poligonale da misurare'
		 * 
		 * @type {String}
		 */
		MISURA_AREA_VALUE : '<strong>Misura poligono: </strong>cliccare per tracciare i vertici dell\'area di poligonale da misurare',
		/**
		 * testo che compare nel messaggio di attesa value = 'Elaborazione in
		 * corso'
		 * 
		 * @type {String}
		 */
		MSG_ELABORAZIONE : 'Elaborazione in corso',
		/**
		 * testo che compare nel messaggio di salvataggio value =
		 * 'Salvataggio...'
		 * 
		 * @type {String}
		 */
		PROGRESS_TEXT : 'Salvataggio...',
		/**
		 * nome del layer indirizzo value = 'indirizzoLayer'
		 * 
		 * @type {String}
		 */
		LAYER_NAME : 'indirizzoLayer',
		/**
		 * suffisso del metodo di start envelope value = 'calcolaStartEnvelope'
		 * 
		 * @type {String}
		 */
		START_ENVELOPE_SUFFIX_METHOD : 'calcolaStartEnvelope',
		/**
		 * suffisso del metodo di max envelope value = 'calcolaMaxEnvelope'
		 * 
		 * @type {String}
		 */
		MAX_ENVELOPE_SUFFIX_METHOD : 'calcolaMaxEnvelope',
		/**
		 * suffisso del metodo identify value = 'identify'
		 * 
		 * @type {String}
		 */
		IDENTIFY_SUFFIX_METHOD : 'identify',
		/**
		 * testo del tooltip value = 'zoom in/zoom rettangolo'
		 * 
		 * @type {String}
		 */
		TOOLTIP_ZOOMRECT : 'zoom in/zoom rettangolo',
		/**
		 * testo del tooltip value = 'abilita click su mappa'
		 * 
		 * @type {String}
		 */
		TOOLTIP_CLICK : 'abilita click su mappa',
		/**
		 * testo del bottone zoom value = 'Zoom '
		 * 
		 * @type {String}
		 */
		TEXT_ZOOM_BUTTON : 'Zoom ',
		/**
		 * testo del bottone max value = 'Max'
		 * 
		 * @type {String}
		 */
		TEXT_MAX_BUTTON : 'Max',
		/**
		 * testo del bottone precedente value = 'Precedente'
		 * 
		 * @type {String}
		 */
		TEXT_PREC_BUTTON : 'Precedente',
		/**
		 * testo del bottone successivo value = 'Successivo'
		 * 
		 * @type {String}
		 */
		TEXT_SUCC_BUTTON : 'Successivo',
		/**
		 * testo del bottone puntuale value = 'puntuale'
		 * 
		 * @type {String}
		 */
		TEXT_PUNTUALE_BUTTON : 'puntuale',
		/**
		 * testo del bottone aggiorna value = 'Aggiorna'
		 * 
		 * @type {String}
		 */
		TEXT_AGGIORNA_BUTTON : 'Aggiorna',

		/**
		 * testo del bottone disegna value = 'Disegna'
		 * 
		 * @type {String}
		 */
		TEXT_DISEGNA : 'Disegna',

		/**
		 * testo del bottone disegna punto value = 'Punto'
		 * 
		 * @type {String}
		 */
		TEXT_EDIT_POINT : 'Punto',

		/**
		 * testo del tooltip del bottone disegna punto value = 'Disegna punto'
		 * 
		 * @type {String}
		 */
		TOOLTIP_EDIT_POINT : 'Disegna punto',

		/**
		 * testo del bottone disegna linea value = 'Linea'
		 * 
		 * @type {String}
		 */
		TEXT_EDIT_LINE : 'Linea',

		/**
		 * testo del tooltip del bottone disegna linea value = 'Disegna linea'
		 * 
		 * @type {String}
		 */
		TOOLTIP_EDIT_LINE : 'Disegna linea',

		/**
		 * testo del bottone disegna poligono value = 'Poligono'
		 * 
		 * @type {String}
		 */
		TEXT_EDIT_POLYGON : 'Poligono',

		/**
		 * testo del tooltip del bottone disegna poligono value = 'Disegna
		 * poligono'
		 * 
		 * @type {String}
		 */
		TOOLTIP_EDIT_POLYGON : 'Disegna poligono',

		/**
		 * restituisce il messaggio per l'errore 304 restituito dalla response
		 * value = 'Impossibile eseguire l\'operazione'
		 * 
		 * @type String
		 */
		MSG_FAILURE_REQUEST_304 : 'Impossibile eseguire l\'operazione',
		/**
		 * restituisce il messaggio per l'errore 401 restituito dalla response
		 * value = 'Autenticazione richiesta - Bisogna autenticarsi'
		 * 
		 * @type String
		 */
		MSG_FAILURE_REQUEST_401 : 'Autenticazione richiesta - Bisogna autenticarsi',
		/**
		 * restituisce il messaggio per l'errore 302 restituito dalla response
		 * value = 'Sessione scaduta'
		 * 
		 * @type String
		 */
		MSG_FAILURE_REQUEST_302 : 'Sessione scaduta',
		/**
		 * restituisce il messaggio per l'errore 500 restituito dalla response
		 * value = 'Si &egrave; verificato un errore applicativo.'
		 * 
		 * @type String
		 */
		MSG_FAILURE_REQUEST_500 : 'Si &egrave; verificato un errore applicativo.',
		/**
		 * restituisce il messaggio per l'errore 502 restituito dalla response
		 * value = 'Gateway non valido.'
		 * 
		 * @type String
		 */
		MSG_FAILURE_REQUEST_502 : 'Gateway non valido.',
		/**
		 * restituisce il messaggio per l'errore generico restituito dalla
		 * response value = 'Si &egrave; verificato un problema generico'
		 * 
		 * @type String
		 */
		MSG_FAILURE_REQUEST_GENERIC : 'Si &egrave; verificato un problema di comunicazione con il server',
		/**
		 * restituisce il messaggio per l'eccezione remota restituito dalla
		 * response value = 'Attenzione eccezione remota'
		 * 
		 * @type String
		 */
		MSG_REMOTE_EXCEPTION : 'Attenzione eccezione remota',

		/**
		 * Style per i dati di selezione e ricerca
		 * 
		 * @type OpenLayers.StyleMap
		 */
		defaultSelectedDatiStyle : OpenLayers.Util.extend(
				new OpenLayers.StyleMap(), new OpenLayers.StyleMap({
					"default" : new OpenLayers.Style({
						pointRadius : 5, // sized according to type attribute
						fillColor : "#ffffff",
						fillOpacity: 0.2,
						strokeColor : "#ff9933",
						strokeWidth : 2,
						graphicZIndex : 1
					}),
					"select" : new OpenLayers.Style({
						fillColor : "#66ccff",
						fillOpacity: 0.2,
						strokeColor : "#3399ff",
						graphicZIndex : 2
					})

				})),

		/**
		 * Style per i dati di selezione e ricerca
		 * 
		 * @type OpenLayers.StyleMap
		 */
		defaultEditingDatiStyle : OpenLayers.Util.extend(
				new OpenLayers.StyleMap(), new OpenLayers.StyleMap({
					"default" : new OpenLayers.Style({
						pointRadius : 5, // sized according to type attribute
						fillColor : "#FF4F19",
						fillOpacity: 0.2,
						strokeColor : "#932D11",
						strokeWidth : 2,
						graphicZIndex : 1
					}),
					"select" : new OpenLayers.Style({
						fillColor : "#66ccff",
						fillOpacity: 0.2,
						strokeColor : "#3399ff",
						graphicZIndex : 2
					})

				}))

	}
}();

/**
 * variabile che indica se ci sono problemi di collegamento con il server
 * 
 * @type Boolean
 */
var requestActive = true;
/**
 * shorthand per la funzione constants
 */
var constants = JQCsi.GreaseExt.Constants
/**
 * Gestore chiamate
 * 
 * @class JQCsi.GreaseExt.data.Connection
 * @extends Ext.data.Connection
 */
JQCsi.GreaseExt.data.Connection = OOJS.extend(
		OOJS.data.Connection , {
			/**
			 * @cfg {Array} richiesteInCoda array che contiene tutte le
			 *      richieste in coda
			 */
			richiesteInCoda : new Array(),
			/**
			 * @cfg {Array} chiaviCodeInesecuzione
			 */
			chiaviCodeInesecuzione : new Array(),
			/**
			 * 
			 * @cfg {Number} richiesteInEsecuzione
			 */
			richiesteInEsecuzione : 0,
			constructor : function(config) {
				this.addEvents(constants.START_CALL_EVENT,
						constants.END_CALL_EVENT);
				arguments.callee.superclass.constructor.call(this, config);
			},
			push : function(ajaxObject, coda) {
				if (!requestActive) {
					new JQCsi.ui.maps.Utility.showMessageBoxErrors({});
				}
				ajaxObject.greaseAjaxCoda = coda;

				var inExec = false;
				if (this.chiaviCodeInesecuzione[coda] != undefined
						&& this.chiaviCodeInesecuzione[coda] != null) {
					inExec = true;
				}
				if (this.richiesteInEsecuzione <= 0) {
					this.fireEvent(constants.START_CALL_EVENT, this);
				}
				if (inExec == true) {
					if (this.richiesteInCoda[coda] == undefined
							|| this.richiesteInCoda[coda] == null)
						this.richiesteInEsecuzione++;
					this.richiesteInCoda[coda] = ajaxObject;
				} else {
					this.esegui(ajaxObject, coda);
					this.richiesteInEsecuzione++;
				}

			},
			esegui : function(oggettoAjax, codaKey) {
				if (!requestActive) {
					new JQCsi.ui.maps.Utility.showMessageBoxErrors({});
				}
				this.chiaviCodeInesecuzione[codaKey] = constants.KEY_CODE;
				this.request(oggettoAjax); 
			},
			pop : function(codaKey) {
				if (!requestActive) {
					new JQCsi.ui.maps.Utility.showMessageBoxErrors({});
				}
				this.chiaviCodeInesecuzione[codaKey] = null;
				var obj = this.richiesteInCoda[codaKey];

				if (obj != undefined && obj != null) {
					this.esegui(obj, codaKey);
					this.richiesteInCoda[codaKey] = null;
				} else {
				}

			},
			handleResponse : function(response) {
				if (response.responseText
						.indexOf('<div id="applicationError">') != -1) {
					new JQCsi.ui.maps.Utility.showMessageBoxErrors(response);
				}
				this.pop(response.argument.options.greaseAjaxCoda);
				this.richiesteInEsecuzione--;
				if (this.richiesteInEsecuzione <= 0) {
					this.fireEvent(constants.END_CALL_EVENT, this);
				}
				JQCsi.GreaseExt.data.Connection.superclass.handleResponse.call(
						this, response);
			},
			handleFailure : function(response, e) {
				if (response.status == '302' || response.status == '304'
						|| response.status == '401' || response.status == '500'
						|| response.status == '502') {
					new JQCsi.ui.maps.Utility.showMessageBoxErrors(response);
				}
				this.pop(response.argument.options.greaseAjaxCoda);
				this.richiesteInEsecuzione--;
				if (this.richiesteInEsecuzione <= 0)
					this.fireEvent(constants.END_CALL_EVENT, this);
				JQCsi.GreaseExt.data.Connection.superclass.handleResponse.call(
						this, response);
			}
		});

/**
 * 
 */
JQCsi.GreaseExt.Ajax = new JQCsi.GreaseExt.data.Connection({
	autoAbort : false,
	/**
	 * Serialize the passed form into a url encoded string
	 * 
	 * @param {String/HTMLElement}
	 *            form
	 * @return {String}
	 */
	serializeForm : function(form) {
		return  OOJS.lib.Ajax.serializeForm(form);
	}
});

/**
 * 
 * @class JQCsi.GreaseExt.BaseViewport
 * @extends Object
 */
JQCsi.GreaseExt.BaseViewport = OOJS.extend(Object, {
	mappe : new Array(),
	mappeKey : new Array(),
	toolbar : null,
	addMap : function(mappa) {
		this.mappe[mappa.idGreaseMap] = mappa;
		this.mappeKey[this.mappeKey.length] = mappa.idGreaseMap;

	},
	addToolbar : function(toolbarIn) {
		this.toolbar = toolbarIn;
		if (this.toolbar.items != undefined) { /* §§ */
			for ( var j = 0; j < this.toolbar.items.items.length; j++) {
				var curButton = this.toolbar.items.items[j];
				curButton.on('toggle', this.toggleComando, this);
				curButton.on('cycleunset', this.unsetCycle, this);

				if (curButton.pressed == true)
					this.toggleComando(curButton, true);
			}
		}
	},
	unsetCycle : function() {
		for ( var j = 0; j < this.mappeKey.length; j++) {
			var curCtrl = this.mappe[this.mappeKey[j]].controlli[idDeattiva];
			if (curCtrl && curCtrl != null) {
				curCtrl.deactivate();
			}
		}
	},
	unsetCycle : function(btn, idDeattiva) {
		for ( var j = 0; j < this.mappeKey.length; j++) {
			var curCtrl = this.mappe[this.mappeKey[j]].controlli[idDeattiva];
			if (curCtrl && curCtrl != null) {
				curCtrl.deactivate();
			}
		}
	},

	toggleComando : function(btn, state) {
		for ( var j = 0; j < this.mappeKey.length; j++) {

			var idControllo = btn.id;
			if (btn.idControlloAttivo && btn.idControlloAttivo != null)
				idControllo = btn.idControlloAttivo;

			var curCtrl = this.mappe[this.mappeKey[j]].controlli[idControllo];
			if (curCtrl && curCtrl != null) {
				if (state == true) {
					curCtrl.activate();
				} else {
					curCtrl.deactivate();
				}
			}
		}
	},
	refreshMappe : function() {
		for ( var j = 0; j < this.mappeKey.length; j++) {
			this.mappe[this.mappeKey[j]].aggiornaMappa();
		}
	},
	zoomPrecedente : function(idMappa) {
		if (idMappa && idMappa != null) {
			this.mappe[idMappa].zoomPrecedente();
		} else {
			for ( var j = 0; j < this.mappeKey.length; j++) {
				this.mappe[this.mappeKey[j]].zoomPrecedente();
			}
		}
	},
	zoomSuccessivo : function(idMappa) {
		if (idMappa && idMappa != null) {
			this.mappe[idMappa].zoomSuccessivo();
		} else {
			for ( var j = 0; j < this.mappeKey.length; j++) {
				this.mappe[this.mappeKey[j]].zoomSuccessivo();
			}
		}
	},
	forceResize : function() {
		return false;
	}
});


/**
 * 
 * @class JQCsi.GreaseExt.ProgressBar
 * @extends Object
 */
JQCsi.GreaseExt.ProgressBar = OOJS.extend(Object, {
	constructor : function(config) {
		JQCsi.GreaseExt.Ajax.on(constants.START_CALL_EVENT, this.onProgress,
				this);
		JQCsi.GreaseExt.Ajax.on(constants.END_CALL_EVENT, this.offProgress,
				this);
	},
	onProgress : function() {
		/*
		 * §§ Ext.MessageBox.show({ msg : constants.MSG_ELABORAZIONE,
		 * progressText : constants.PROGRESS_TEXT, width : 300, wait : true,
		 * waitConfig : { interval : 100 } });
		 */

	},
	offProgress : function() {
		/*
		 * §§ Ext.MessageBox.hide();
		 */
	}
});






/**
 * 
 */
OpenLayers.Layer.GreaseLayer = OpenLayers
		.Class(
				OpenLayers.Layer,
				{

					greaseId : null,
					imgContdiv : null,
					prevResolution : null,
					prevLeft : null,
					prevTop : null,
					actionName : null,
					actionNamespace : null,
					idMappa : null,
					appDataName : null,
					initialize : function(name, actionName, greaseId, options,
							idMappa, appDataName, actionNamespace) {
						this.actionName = actionName;
						this.actionNamespace = actionNamespace;
						this.idMappa = idMappa;
						this.appDataName = appDataName;
						var newArguments = arguments;
						newArguments = [ name, options ];
						OpenLayers.Layer.prototype.initialize.apply(this,
								newArguments);
						this.greaseId = greaseId;
						this.imgContdiv = document.createElement('div');
						this.imgContdiv.id = OpenLayers.Util
								.createUniqueID("OpenLayersDivCnt-"
										+ this.greaseId);
						this.imgContdiv.style.top = (0) + "px";
						this.imgContdiv.style.left = (0) + "px";
						this.imgContdiv.style.position = "absolute";
						this.div.appendChild(this.imgContdiv);
					},
					destroy : function() {
						this.greaseId = null;
						OpenLayers.Layer.prototype.destroy.apply(this,
								arguments);
						this.imgContdiv = null;
					},
					clone : function(obj) {
						if (obj == null) {
							obj = new OpenLayers.GreaseOl.Layer.GreaseLayer(
									this.name, this.actionName, this.greaseId,
									this.options, this.idMappa,
									this.appDataName, this.actionNamespace);
						}
						obj = OpenLayers.Layer.prototype.clone.apply(this,
								[ obj ]);

						return obj;
					},
					clearImages : function() {
						this.imgContdiv.innerHTML = "";
					},
					/*
					 * OVERRIDE della superclass ... qui va fatta la chiamata
					 * ajax
					 */
					moveTo : function(bounds, zoomChanged, dragging) {
						var ext = this.map.getExtent();

						this.prevResolution = this.map.getResolution();
						this.prevLeft = this.map.getExtent().left;
						this.prevTop = this.map.getExtent().top;

						if (this.map.tocPanel != null
								&& this.map.tocPanel
										.isMapserviceOn(this.greaseId) == false) {
							this.clearImages();
						} else

						if (dragging == undefined || dragging == false) {
							if (dragging == undefined) {
								aspetta = "si";
							}
							if (zoomChanged != undefined && zoomChanged == true) {
								this.clearImages();
							}
							var leftN = parseInt(this.map.layerContainerDiv.style.left);
							var topN = parseInt(this.map.layerContainerDiv.style.top);

							var jsonLayers = "[]";
							if (this.map.tocPanel != null) {
								jsonLayers = this.map.tocPanel
										.getJsonLayers(this.greaseId);
								this.map.tocPanel.setStatoMs(this.greaseId,
										'load');
							}

							// ***normalizzazione parametri da postare
							var listaParametri = {};
							var appDataName = this.appDataName;
							var root = [ appDataName ].join('');
							listaParametri[root + '.dimx'] = this.map.getSize().w;
							listaParametri[root + '.dimy'] = this.map.getSize().h;
							listaParametri[root + '.livelloZoom'] = this.map
									.getZoom();
							listaParametri[root + '.envelope.nordest.coordXStr'] = (new String(
									"" + ext.right)).replace(",", ".");
							listaParametri[root + '.envelope.nordest.coordYStr'] = (new String(
									"" + ext.top)).replace(",", ".");
							listaParametri[root
									+ '.envelope.sudovest.coordXStr'] = (new String(
									"" + ext.left)).replace(",", ".");
							listaParametri[root
									+ '.envelope.sudovest.coordYStr'] = (new String(
									"" + ext.bottom)).replace(",", ".");
							listaParametri[root + '.mainOffsetLeft'] = leftN;
							listaParametri[root + '.mainOffsetTop'] = topN;
							listaParametri['strIdCurServizio'] = this.greaseId;
							listaParametri['layersJson'] = jsonLayers;
							var paramsPost = OOJS.apply(listaParametri);
							// ***fine normalizzazione parametri
							JQCsi.GreaseExt.Ajax
									.push(
											{
												url : ((this.actionNamespace != undefined && this.actionNamespace != null) ? this.actionNamespace
														+ "/"
														: "")
														+ this.actionName
														+ '!refreshMap'
														+ JQCsi.ui.maps.Utility
																.toFirstUpper(this.idMappa)
														+ 'SingleService.do',
												method : 'POST',
												params : paramsPost,
												scope : this,
												isUpload : false,
												headers : {
													'Content-Type' : 'application/x-www-form-urlencoded',
													'X-Requested-With' : 'XMLHttpRequest'
												},
												fileUpload : false,
												success : function(result,
														request) {

													var dati = null;
													try {
														dati = OOJS.util.JSON.decode(result.responseText);
													} catch (err) {
													}
													var valRet = this
															.updateImages(dati);
													if (valRet != 'ok'
															|| dati == null
															|| dati.dati == null
															|| dati.dati.extElementToc == null) {
														if (this.map.tocPanel != null)
															this.map.tocPanel
																	.setStatoMs(
																			this.greaseId,
																			'ko');
													} else {
														if (this.map.tocPanel != null)
															this.map.tocPanel
																	.setStatoMs(
																			this.greaseId,
																			'ok');
														if (this.map.tocPanel != null)
															this.map.tocPanel
																	.upDateMS(
																			this.greaseId,
																			dati.dati.extElementToc);
													}

												},
												failure : function(result,
														request) {

												}
											}, this.greaseId);

						}

						/*
						 * var display = this.visibility; if (!this.isBaseLayer) {
						 * display = display && this.inRange; }
						 * this.display(display);
						 */
					},

					updateImages : function(servizioCorrente) {

						this.clearImages();

						var leftN = parseInt(this.map.layerContainerDiv.style.left);
						var topN = parseInt(this.map.layerContainerDiv.style.top);

						var ret = 'ko';
						if (servizioCorrente == null
								|| servizioCorrente.dati == null
								|| servizioCorrente.dati.images == null
								|| servizioCorrente.dati.images.length <= 0)
							return ret;

						var size = this.map.getSize();
						this.imgContdiv.style.top = (0 - topN - size.h) + "px";
						this.imgContdiv.style.left = (0 - leftN - size.w)
								+ "px";
						this.imgContdiv.style.width = (size.w * 3) + "px";
						this.imgContdiv.style.height = (size.h * 3) + "px";

						for ( var i = 0; i < servizioCorrente.dati.images.length; i++) {
							if (servizioCorrente.dati.images[i] != null
									&& servizioCorrente.dati.images[i].imageUrl != null) {
								ret = 'ok';

								var newImager = document.createElement('img');
								newImager.id = OpenLayers.Util
										.createUniqueID("OpenLayersDivImg-"
												+ this.greaseId);
								newImager.style.top = (size.h + servizioCorrente.dati.images[i].offsetTop)
										+ "px";
								newImager.style.left = (size.w + servizioCorrente.dati.images[i].offsetLeft)
										+ "px";
								newImager.style.width = servizioCorrente.dati.images[i].dimx
										+ "px";
								newImager.style.height = servizioCorrente.dati.images[i].dimy
										+ "px";
								newImager.style.position = "absolute";
								newImager.style.overflow = "visible";

								newImager.src = servizioCorrente.dati.images[i].imageUrl;

								// this.div.appendChild(newImager);
								this.imgContdiv.appendChild(newImager);

							}
						}

						this
								.setOpacity(parseFloat(servizioCorrente.dati.opacity) + 0.001);
						return ret;

					},

					setOpacity : function(opacity) {
						if (opacity != this.opacity) {
							this.opacity = opacity;
							OpenLayers.Util
									.modifyDOMElement(this.imgContdiv, null,
											null, null, null, null, null,
											opacity);
						}
					},

					CLASS_NAME : "OpenLayers.Layer.GreaseLayer"
				});

/**
 * 
 */
OpenLayers.Control.GreaseZoomBox = OpenLayers.Class(OpenLayers.Control.ZoomBox,
		{

			CLASS_NAME : "OpenLayers.Control.GreaseZoomBox"
		});

/**
 * aggiunge il controllo di eventhandler click alla mappa
 */
OpenLayers.Control.EventHandlerClick = OpenLayers
		.Class(
				OpenLayers.Control,
				{
					clickEventUrl : null,
					refreshIds : [],
					actionName : null,
					actionNamespace : null,
					appDataName : null,
					defaultHandlerOptions : {
						'single' : true,
						'double' : false,
						'pixelTolerance' : 0,
						'stopSingle' : false,
						'stopDouble' : false
					},

					initialize : function(clickEventUrl, refreshIds,
							actionName, appDataName, actionNamespace) {
						this.clickEventUrl = clickEventUrl;
						this.refreshIds = refreshIds;
						this.actionName = actionName;
						this.actionNamespace = actionNamespace,
								this.appDataName = appDataName;
						this.handlerOptions = OpenLayers.Util.extend({},
								this.defaultHandlerOptions);
						OpenLayers.Control.prototype.initialize.apply(this,
								arguments);
						this.handler = new OpenLayers.Handler.Click(this, {
							'click' : this.trigger
						}, this.handlerOptions);
					},

					trigger : function(e) {
						var lonlat = this.map.getLonLatFromViewPortPx(e.xy);
						// ***normalizzazione parametri da postare
						var listaParametri = {};
						var appDataName = this.appDataName;
						var root = [ appDataName ].join('');
						listaParametri[root + '.xclick'] = lonlat.lon;
						listaParametri[root + '.yclick'] = lonlat.lat;
						var paramsPost = OOJS.apply(listaParametri);
						// ***fine normalizzazione parametri
						var pageId = this.actionName;
						var pageNs = ((this.actionNamespace != undefined && this.actionNamespace != null) ? this.actionNamespace
								+ "/"
								: "");
						JQCsi.GreaseExt.Ajax
								.push(
										{
											url : this.clickEventUrl,
											method : 'POST',
											params : paramsPost,
											scope : this,
											isUpload : false,
											headers : {
												'Content-Type' : 'application/x-www-form-urlencoded',
												'X-Requested-With' : 'XMLHttpRequest'
											},
											fileUpload : false,
											success : function(result, request) {
												var fragment = result.responseText;

												var responsePageId = new JQCsi.ui.maps.Utility.getResponsePageId(
														fragment);

												if (responsePageId == 'dialogPanel') {
													/*var fragm = fragment
															.substring(
																	fragment
																			.indexOf('<body>') + 6,
																	fragment
																			.indexOf('</body>'));
													var frammento = OOJS
															.getBody();
													frammento.dom.innerHTML = fragm;*/
													replaceForm(fragment);

												} else if (pageId != null
														&& fragment
																.indexOf('<!-- pageId:'
																		+ pageId
																		+ ' -->') == -1) {
													/*
													 * 
													 */
													document.forms[0].action = pageNs
															+ responsePageId
															+ '.do';
													document.forms[0].submit();

												} else {

													var idSplit = this.refreshIds;													
													replaceFragments(pageId, idSplit, fragment);

												}


											},
											failure : function(result, request) {

											}
										}, 'controllimappa');
					},
					CLASS_NAME : "OpenLayers.Control.EventHandlerClick"

				});
/**
 * 
 */
OpenLayers.Control.GreaseClick = OpenLayers.Class(OpenLayers.Control, {

	defaultHandlerOptions : {
		'single' : true,
		'double' : false,
		'pixelTolerance' : 0,
		'stopSingle' : false,
		'stopDouble' : false
	},

	initialize : function(options) {
		this.handlerOptions = OpenLayers.Util.extend({},
				this.defaultHandlerOptions);
		OpenLayers.Control.prototype.initialize.apply(this, arguments);
		this.handler = new OpenLayers.Handler.Click(this, {
			'click' : this.onClick,
			'dblclick' : this.onDblclick
		}, this.handlerOptions);
	},

	onClick : function(evt) {
		var lonlat = this.map.getLonLatFromViewPortPx(e.xy);
	},

	onDblclick : function(evt) {
		var lonlat = this.map.getLonLatFromViewPortPx(e.xy);
	},

	CLASS_NAME : "OpenLayers.Control.GreaseClick"
});

/**
 * 
 */
OpenLayers.Control.GreaseZoomOut = OpenLayers
		.Class(OpenLayers.Control.GreaseClick,
				{

					comandoToolbar : 'ZOOMOUT',

					initialize : function(options, comando) {
						this.comandoToolbar = (comando ? comando
								: this.comandoToolbar);
						OpenLayers.Control.GreaseClick.prototype.initialize
								.apply(this, arguments);
					},

					onClick : function(evt) {
						var lonLat = this.map.getLonLatFromViewPortPx(evt.xy);
						this.map.setCenter(lonLat, this.map.getZoom() - 1);
					},

					onDblclick : function(evt) {
						var lonlat = this.map.getLonLatFromViewPortPx(evt.xy);
					},

					CLASS_NAME : "OpenLayers.Control.GreaseZoomOut"
				});

/**
 * 
 */
OpenLayers.Control.GreaseIdentify = OpenLayers
		.Class(OpenLayers.Control.GreaseClick,
				{
					comandoToolbar : 'IDENTIFY',
					idMappa : null,
					initialize : function(options, comando, idMappa) {
						this.idMappa = idMappa;
						this.comandoToolbar = (comando ? comando
								: this.comandoToolbar);
						OpenLayers.Control.GreaseClick.prototype.initialize
								.apply(this, arguments);
					},

					onClick : function(evt) {
						var lonlat = this.map.getLonLatFromViewPortPx(evt.xy);
						x = lonlat.lon;
						y = lonlat.lat;
						this.map.interroga(x, y, this.comandoToolbar,
								constants.IDENTIFY_SUFFIX_METHOD
										+ JQCsi.ui.maps.Utility
												.toFirstUpper(this.idMappa));
					},

					CLASS_NAME : "OpenLayers.Control.GreaseIdentify"
				});

/**
 * 
 * @class JQCsi.ui.maps.Marker
 */
JQCsi.ui.maps.Marker = OOJS
		.extend(
				function(config) {
					OOJS.apply(this, config);
				},
				{
					idMappa : null,
					envelopeWeb : null,
					idResult : null,
					descInd : null,
					addMarkerIndirizzo : function() {
						if (this.envelopeWeb == undefined
								|| this.envelopeWeb == null)
							return -1;
						var style_blue = OpenLayers.Util.extend({},
								OpenLayers.Feature.Vector.style['default']);

						var centrox = this.envelopeWeb.left
								+ ((this.envelopeWeb.right - this.envelopeWeb.left) / 2);
						var centroy = this.envelopeWeb.bottom
								+ ((this.envelopeWeb.top - this.envelopeWeb.bottom) / 2);

						var indirizzoLayer = null;

						var lll = viewport.mappe[this.idMappa]
								.getLayersByName(constants.LAYER_NAME);
						if (lll != null && lll.length > 0) {

							for ( var markerCount = 0; markerCount < viewport.mappe[this.idMappa].popups.length; markerCount++) {
								if (null != viewport.mappe[this.idMappa].popups[markerCount]
										&& null != viewport.mappe[this.idMappa].popups[markerCount].feature.layer
										&& viewport.mappe[this.idMappa].popups[markerCount].feature.layer.name == constants.LAYER_NAME) {
									viewport.mappe[this.idMappa].popups[markerCount]
											.destroy();
								}
							}
							lll[0].destroy();
						}

						var markerClick = function(evt) {
							if (this.popup == null) {
								this.popup = this.createPopup(this.closeBox);
								viewport.mappe[this.idMappa]
										.addPopup(this.popup);
								this.popup.show();
							} else {
								this.popup.toggle();
							}
							currentPopup = this.popup;
							// currentPopup.show();
							OpenLayers.Event.stop(evt);
						};
						indirizzoLayer = new OpenLayers.Layer.Markers(
								constants.LAYER_NAME);
						viewport.mappe[this.idMappa].addLayer(indirizzoLayer);

						var sizeOrig = new OpenLayers.Size(21, 41);
						var size = new OpenLayers.Size(42, 42);
						var offset = new OpenLayers.Pixel(-(sizeOrig.w / 2),
								-sizeOrig.h);

						var icon = new OpenLayers.Icon("./marker_shadow.png",
								size, offset);
						var feature = new OpenLayers.Feature(indirizzoLayer,
								new OpenLayers.LonLat(centrox, centroy));
						feature.closeBox = true;
						feature.data.overflow = 'auto';
						feature.data.popupContentHTML = '<p>' + this.idResult
								+ '</p>' + '<p>' + this.descInd + '<p>';

						feature.data.icon = icon.clone();

						feature.popupClass = OpenLayers.Class(
								OpenLayers.Popup.FramedCloud, {
									'autoSize' : true,
									'panMapIfOutOfView' : false,
									'minSize' : new OpenLayers.Size(200, 200),
									'maxSize' : new OpenLayers.Size(400, 400)

								});
						indirizzoLayer.events.register("mousedown", feature,
								markerClick);

						var marker = feature.createMarker();

						indirizzoLayer.addMarker(marker);

						feature.popup = feature.createPopup(true);
						viewport.mappe[this.idMappa].addPopup(feature.popup);
					}
				});

/**
 * 
 */
OpenLayers.GreaseMap = OpenLayers
		.Class(
				OpenLayers.Map,
				{

					controlli : new Array(),
					idGreaseMap : null,
					idDivMap : null,
					actionName : null,
					actionNamespace : null,
					idMappa : null,
					appDataName : null,
					setupMetod : null,
					tocPanel : null,
					projectName : null,
					controlliTrasparenza : new Array(),
					tocLoaded : false,
					mapInitialized : false,
					clickEventUrl : null,
					refreshIds : [],
					// END UC-MDDGIS-6 Editing
					LAYER_EDITING_NAME : 'editLayer',
					editingEventUrl : null,
					refreshEditingIds : [],
					editingDataName : null,
					pointEditingActive: false,
					lineEditingActive: false,
					polygonEditingActive: false,

					// END UC-MDDGIS-6 Editing

					initialize : function(idGreaseMap, actionName, idMappa,
							appDataName, div, options, projectName,
							clickEventUrl, refreshIds, editingDataName,
							editingEventUrl, refreshEditingIds, pointEditingActive, lineEditingActive, polygonEditingActive, actionNamespace) {

						// START UC-MDDGIS-6 Editing
						this.EVENT_TYPES[this.EVENT_TYPES.length] = 'mappaInit';
						// END UC-MDDGIS-6 Editing

						this.actionName = (actionName != null ? actionName
								: this.actionName);
						this.actionNamespace = actionNamespace;
						this.idGreaseMap = idGreaseMap;
						this.idDivMap = div; //...
						this.setupMetod = 'map'
								+ JQCsi.ui.maps.Utility.toFirstUpper(idMappa)
								+ 'Setup';
						this.idMappa = idMappa;
						this.projectName = projectName;
						this.appDataName = appDataName;
						this.clickEventUrl = clickEventUrl;
						this.refreshIds = refreshIds;

						this.editingDataName = editingDataName;
						this.refreshEditingIds = refreshEditingIds;
						this.editingEventUrl = editingEventUrl;
						
						this.pointEditingActive = pointEditingActive;
						this.lineEditingActive = lineEditingActive;
						this.polygonEditingActive = polygonEditingActive;

						OpenLayers.Map.prototype.initialize.apply(this, [ div,
								options ]);
//this.addControllo(new OpenLayers.Control.LayerSwitcher({'div':OpenLayers.Util.getElement('layerswitcher_'+this.idDivMap)}));

						// funzione di drag & pan
						this.addControllo(new OpenLayers.Control.Navigation(),
								constants.PAN_KEY);
						//disattiva inizialmente la manina di drag&pan
						//this.controlli[constants.PAN_KEY].deactivate();
						this.addControllo(
								new OpenLayers.Control.GreaseZoomBox(),
								'zoomrect');
						this.addControllo(
								new OpenLayers.Control.GreaseZoomOut(),
								'zoomout');
						if (!OOJS.isEmpty(clickEventUrl)
								&& !OOJS.isEmpty(refreshIds)) {
							this.addControllo(
									new OpenLayers.Control.EventHandlerClick(
											clickEventUrl, refreshIds,
											actionName, appDataName,
											actionNamespace), 'eventHandler');
						}
						this
								.addControllo(
										new OpenLayers.Control.GreaseNavigationHistory(),
										'historyNav');

					},

					switchControlliLayout : function(tipoControllo, state,
							options) {
						if (state == false) {
							for ( var j = 0; j < this.controls.length; j++) {
								if (this.controls[j].CLASS_NAME == tipoControllo.prototype.CLASS_NAME) {
									this.removeControl(this.controls[j]);
									break;
								}
							}
						} else {
							var alreadyPresent = false
							for ( var j = 0; j < this.controls.length; j++) {
								if (this.controls[j].CLASS_NAME == tipoControllo.prototype.CLASS_NAME) {
									alreadyPresent = true;
									break;
								}
							}
							if (alreadyPresent == false)
								this.addControl(new tipoControllo(options));
						}

					},

					addControlloTrasparenza : function(controllo, idLayer) {
						this.controlliTrasparenza[idLayer] = controllo;
						this.controlliTrasparenza[idLayer].on('change',
								this.setLayerTransparency, this, {
									idLayer : idLayer
								});
					},

					addControlliMisura : function() {

						this.addControllo(
								new OpenLayers.Control.GreaseMisuraArea(),
								constants.MISURA_AREA_KEY);
						this.addControllo(
								new OpenLayers.Control.GreaseMisuraLinea(),
								constants.MISURA_LINEA_KEY);
						this.controlli[constants.MISURA_LINEA_KEY].events.on({
							"measure" : this.gestisciMisura,
							"measurepartial" : this.gestisciMisura,
							scope : this
						});
						this.controlli[constants.MISURA_AREA_KEY].events.on({
							"measure" : this.gestisciMisura,
							"measurepartial" : this.gestisciMisura,
							scope : this

						});
					},

					setLayerTransparency : function(slider, newValue) {
						var asasas = "";

						this.getLayersByName(slider.idLayer)[0]
								.setOpacity(newValue / 100);

					},

					setToc : function(toc) {
						if (toc && toc != null) {
							this.tocPanel = toc;
							this.tocPanel.on('nodedrop', this.sortLayers, this);
							this.tocPanel.on('tocLoaded', this.tocCaricata,
									this);
							this.tocPanel.loadToc();
						} else {
							this.tocCaricata();
						}
					},

					misuraWin : null,

					gestisciMisura : function(event) {
						var geometry = event.geometry;
						var units = event.units;
						var order = event.order;
						var measure = event.measure;
						var misuraEffattuata = measure.toFixed(3);

						// TODO parte da customizzare per esigenze specifiche
						var out = "";
						if (order == 1) {
							out += " " + misuraEffattuata + " " + units;
						} else {
							out += " " + misuraEffattuata + " " + units
									+ "<sup>2</" + "sup>";
						}

						if (this.misuraWin == null) {
							this.misuraWin = new Object() /*
															 * §§ new
															 * Ext.Window({
															 * applyTo :
															 * 'misuraWin',
															 * layout : 'fit',
															 * width : 130,
															 * height : 50,
															 * closeAction :
															 * 'hide', plain :
															 * true, draggable :
															 * false, resizable :
															 * false, contentEl :
															 * 'outputMisura',
															 * bodyBorder :
															 * false, header :
															 * false, y : 10, x :
															 * 100, style : {
															 * top : '10px',
															 * right : '120px' }
															 * 
															 * });
															 */
						}
						var element = document.getElementById('outputMisura');
						element.innerHTML = out;
						var dim = this.getSize();

						this.misuraWin.setPosition(dim.w - 10 - 130, 10);

						this.misuraWin.show();

					},

					tocCaricata : function() {
						this.tocLoaded = true;
						this.startMap();
					},
					startMap : function() {
						if (this.tocLoaded == true
								&& this.mapInitialized == true) {

							this
									.calcolaNavigazione(
											null,
											null,
											null,
											constants.START_ENVELOPE_SUFFIX_METHOD
													+ JQCsi.ui.maps.Utility
															.toFirstUpper(this.idMappa));
						}
					},

					zoomMax : function() {
						this.calcolaNavigazione(null, null, null,
								constants.MAX_ENVELOPE_SUFFIX_METHOD
										+ JQCsi.ui.maps.Utility
												.toFirstUpper(this.idMappa));
					},

					sortLayers : function(event) {
						var isLayer = event.data.node.attributes['leaf'];
						var isMapserviceFisico = event.data.node.attributes['tipologia'] == 'fisico';

						var targetMSId = event.target.attributes['idMapservice'];
						var startMSId = event.data.node.attributes['idMapservice'];

						var targetLayer = this.getLayersByName(targetMSId)[0];
						var startLayer = this.getLayersByName(startMSId)[0];

						var indiceTarget = this.getLayerIndex(targetLayer);
						var indiceStart = this.getLayerIndex(startLayer);

						var delta = indiceTarget - indiceStart;

						if (delta < 0 && event.point == 'above') {
							delta = delta + 1;
						}

						if (delta > 0 && event.point == 'below') {
							delta = delta - 1;
						}

						if (delta != 0) {
							this.raiseLayer(startLayer, delta);
						}

						var indiceTargetA = this.getLayerIndex(targetLayer);
						var indiceStartA = this.getLayerIndex(startLayer);

					},

					destroy : function() {
						OpenLayers.Map.prototype.destroy.apply(this, arguments);
						this.controlli = null;
						this.tocPanel = null;
					},

					addControllo : function(controllo, chiave) {
						this.controlli[chiave] = controllo;
						this.addControl(this.controlli[chiave]);
					},

					doMapSetup : function(setupUrl) {
						JQCsi.GreaseExt.Ajax
								.push(
										{
											url : ((setupUrl != undefined && setupUrl != null) ? setupUrl
													: ((this.actionNamespace != undefined && this.actionNamespace != null) ? this.actionNamespace
															+ "/"
															: "")
															+ this.actionName
															+ "!"
															+ this.setupMetod
															+ ".do"),
											method : 'POST',
											params : {
												idMappaCorrente : this.idGreaseMap
											},
											scope : this,
											isUpload : false,
											headers : {
												'Content-Type' : 'application/x-www-form-urlencoded',
												'X-Requested-With' : 'XMLHttpRequest'
											},
											fileUpload : false,
											success : function(result, request) {

												var dati = OOJS.util.JSON.decode(result.responseText);
												this.initMap(dati);
											},
											failure : function(result, request) {

											}
										}, "setup_" + this.idGreaseMap);

					},

					// TODO ... forse da ricollocare
					posizionaMappaPerIndirizzo : function(idComune, idVia,
							civico, descrizioneInd) {
						JQCsi.GreaseExt.Ajax
								.push(
										{
											url : null,// 'locind!localizzaIndirizzo.do',
														// da capire se
											// serve
											method : 'POST',
											params : {
												idMappaCorrente : this.idGreaseMap,
												idComune : idComune,
												idVia : idVia,
												civico : civico
											},
											scope : this,
											isUpload : false,
											headers : {
												'Content-Type' : 'application/x-www-form-urlencoded',
												'X-Requested-With' : 'XMLHttpRequest'
											},
											fileUpload : false,
											success : function(result, request) {

												var dati = OOJS.util.JSON.decode(result.responseText);
						
												if (dati != null
														&& dati.dati != null) {
													this
															.zoomToExtent(
																	new OpenLayers.Bounds(
																			dati.dati.sudovest.coordX,
																			dati.dati.sudovest.coordY,
																			dati.dati.nordest.coordX,
																			dati.dati.nordest.coordY),
																	true);
													var ttt = 'jj';
													addMarkerIndirizzo(
															new OpenLayers.Bounds(
																	dati.dati.sudovest.coordX,
																	dati.dati.sudovest.coordY,
																	dati.dati.nordest.coordX,
																	dati.dati.nordest.coordY),
															dati.customErrorType,
															descrizioneInd);

												}

											},
											failure : function(result, request) {

											}
										}, "setup_" + this.idGreaseMap);

					},

					initMap : function(olMapConfig) {
						this.maxExtent = new OpenLayers.Bounds(
								olMapConfig.servizioCfg.envelope.sudovest.coordX,
								olMapConfig.servizioCfg.envelope.sudovest.coordY,
								olMapConfig.servizioCfg.envelope.nordest.coordX,
								olMapConfig.servizioCfg.envelope.nordest.coordY);
						this.maxResolution = olMapConfig.servizioCfg.maxResolution;
						this.minResolution = olMapConfig.servizioCfg.minResolution;
						this.projection = new OpenLayers.Projection(
								olMapConfig.servizioCfg.srs);
						var projectName = this.projectName;
						this
								.addLayer(new OpenLayers.Layer.TMS(
										"BaseLayer",
										"",
										{
											tileSize : new OpenLayers.Size(
													olMapConfig.servizioCfg.tileSize,
													olMapConfig.servizioCfg.tileSize),
											buffer : null,
											'type' : 'gif',
											'getURL' : function(bounds) {
												ret = '/ris/utheme/global/themes/openlayersthemeV1/css/im/pixel.gif';
												return ret;
											},
											numZoomLevels : olMapConfig.servizioCfg.numeroLivelli,
											visibility : true,
											isBaseLayer : true,
											maxResolution : olMapConfig.servizioCfg.maxResolution,
											minResolution : olMapConfig.servizioCfg.minResolution,
											maxExtent : new OpenLayers.Bounds(
													olMapConfig.servizioCfg.envelope.sudovest.coordX,
													olMapConfig.servizioCfg.envelope.sudovest.coordY,
													olMapConfig.servizioCfg.envelope.nordest.coordX,
													olMapConfig.servizioCfg.envelope.nordest.coordY),
											restrictedExtent : new OpenLayers.Bounds(
													olMapConfig.servizioCfg.envelope.sudovest.coordX,
													olMapConfig.servizioCfg.envelope.sudovest.coordY,
													olMapConfig.servizioCfg.envelope.nordest.coordX,
													olMapConfig.servizioCfg.envelope.nordest.coordY)
										}));
						for ( var jk = 0; olMapConfig.serviziClient != null
								&& jk < olMapConfig.serviziClient.length; jk++) {
							if (olMapConfig.serviziClient[jk].tipoMapservice == 'TMS') {
								var curLayer = new OpenLayers.Layer.TMS(
										olMapConfig.serviziClient[jk].idServizio,
										olMapConfig.serviziClient[jk].hostName,
										{
											tileSize : new OpenLayers.Size(
													olMapConfig.serviziClient[jk].tileSize,
													olMapConfig.serviziClient[jk].tileSize),
											buffer : null,
											'type' : 'gif',
											'getURL' : function(bounds) {
												/*
												 * var res =
												 * this.map.getResolution(); var
												 * x = Math .round((bounds.left -
												 * this.maxExtent.left) / (res *
												 * this.tileSize.w)); var y =
												 * Math
												 * .round((this.maxExtent.top -
												 * bounds.top) / (res *
												 * this.tileSize.h)); var z =
												 * this.map.getZoom(); var limit =
												 * Math.pow(2, z);
												 * 
												 * x = ((x % limit) + limit) %
												 * limit; y = limit - y - 1;
												 * 
												 * var url = this.url;
												 * 
												 * if (url instanceof Array) {
												 * url = this.selectUrl("",
												 * url); }
												 * 
												 * url = url.replace("<LEVEL>",
												 * z); url = url.replace("<COLUMN>",
												 * x); url = url.replace("<ROW>",
												 * y);
												 * 
												 * return url;
												 */
												var res = this.map
														.getResolution();

												var x = Math
														.round((bounds.left - this.maxExtent.left)
																/ (res * this.tileSize.w));
												var y = Math
														.round((this.maxExtent.top - bounds.top)
																/ (res * this.tileSize.h));

												var z = 0;

												var deltaExtent = this.maxExtent.top
														- this.maxExtent.bottom;
												// //console.debug("deltaExtent="+deltaExtent);
												var newlev = -1;
												while (newlev == -1
														&& z < this.numZoomLevels) {
													var scFactorCur = deltaExtent
															/ (256 * Math.pow(
																	2, z));
													if (res == scFactorCur) {
														newlev = z;
													}
													z++;
												}
												// var z = this.map.getZoom();
												var limit = Math.pow(2, newlev);
												// limit = Math.pow(2,
												// this.map.getZoom()+4);

												x = ((x % limit) + limit)
														% limit;
												y = limit - y - 1;

												// var path = z + "/" + x + "/"
												// + y + "." + this.type;
												var url = this.url;

												if (url instanceof Array) {
													url = this.selectUrl("",
															url);
												}

												url = url.replace("<LEVEL>",
														newlev);
												url = url
														.replace("<COLUMN>", x);
												url = url.replace("<ROW>", y);

												return url;

											},
											numZoomLevels : olMapConfig.serviziClient[jk].numeroLivelli,
											visibility : true,
											isBaseLayer : false,
											maxResolution : olMapConfig.serviziClient[jk].maxResolution,
											minResolution : olMapConfig.serviziClient[jk].minResolution,
											maxExtent : new OpenLayers.Bounds(
													olMapConfig.serviziClient[jk].envelope.sudovest.coordX,
													olMapConfig.serviziClient[jk].envelope.sudovest.coordY,
													olMapConfig.serviziClient[jk].envelope.nordest.coordX,
													olMapConfig.serviziClient[jk].envelope.nordest.coordY),
											restrictedExtent : new OpenLayers.Bounds(
													olMapConfig.serviziClient[jk].envelope.sudovest.coordX,
													olMapConfig.serviziClient[jk].envelope.sudovest.coordY,
													olMapConfig.serviziClient[jk].envelope.nordest.coordX,
													olMapConfig.serviziClient[jk].envelope.nordest.coordY)
										});
								this.addLayer(curLayer);
							} else if (olMapConfig.serviziClient[jk].tipoMapservice == 'GREASE') {
								var curLayer = new OpenLayers.Layer.GreaseLayer(
										olMapConfig.serviziClient[jk].idServizio,
										this.actionName,
										olMapConfig.serviziClient[jk].idServizio,
										{
											transitionEffect : 'resize',
											isBaseLayer : false
										}, this.idMappa, this.appDataName,
										this.actionNamespace);
								this.addLayer(curLayer);
							}
						}
						this.fractionalZoom = olMapConfig.fractionalZoom;

						this.mapInitialized = true;

						if (olMapConfig.datiStartup
								&& olMapConfig.datiStartup != null
								&& olMapConfig.datiStartup.length > 0) {
							var bgeoms = new OpenLayers.Layer.Vector(
									"BusinessGeometries",
									{
										styleMap : constants.defaultSelectedDatiStyle
									});
							this.addLayer(bgeoms);
							for ( var cntBgeom = 0; cntBgeom < olMapConfig.datiStartup.length; cntBgeom++) {
								var geoJsonFormat = new OpenLayers.Format.GeoJSON();
								var feature = geoJsonFormat
										.read(olMapConfig.datiStartup[cntBgeom].geometria);

								for ( var ttt = 0; ttt < feature.length; ttt++) {
									feature[ttt].attributes = {
										'idFeature' : olMapConfig.datiStartup[cntBgeom].identificativo
									};
								}
								bgeoms.addFeatures(feature);

							}
						}

						// START UC-MDDGIS-6 Editing
						this
								.addLayer(new OpenLayers.Layer.Vector(
										this.LAYER_EDITING_NAME,
										{
											styleMap : constants.defaultEditingDatiStyle
										}));

						if (olMapConfig.datiEditing
								&& olMapConfig.datiEditing != null
								&& olMapConfig.datiEditing.length > 0) {
							// var bgeoms=new
							// OpenLayers.Layer.Vector("BusinessGeometries");
							// this.addLayer(bgeoms);
							for ( var cntBgeom = 0; cntBgeom < olMapConfig.datiEditing.length; cntBgeom++) {
								var geoJsonFormat = new OpenLayers.Format.GeoJSON();
								var feature = geoJsonFormat
										.read(olMapConfig.datiEditing[cntBgeom].geometria);

								for ( var ttt = 0; ttt < feature.length; ttt++) {
									feature[ttt].attributes = {
										'idFeature' : olMapConfig.datiEditing[cntBgeom].identificativo
									};
								}
								this.getEditingLayer().addFeatures(feature);

							}
						}

						this.events.triggerEvent("mappaInit");
						// END UC-MDDGIS-6 Editing

						this.startMap();

					},
					// START UC-MDDGIS-6 Editing
					addControlliEditing : function() {
						this.addControllo(
								new OpenLayers.Control.GreaseDrawFeature(this
										.getEditingLayer(),
										OpenLayers.Handler.Point, {}),
								'drawpoint');
						this.addControllo(
								new OpenLayers.Control.GreaseDrawFeature(this
										.getEditingLayer(),
										OpenLayers.Handler.Path, {}),
								'drawline');
						this.addControllo(
								new OpenLayers.Control.GreaseDrawFeature(this
										.getEditingLayer(),
										OpenLayers.Handler.Polygon, {}),
								'drawpoly');
						this.addControllo(
								new OpenLayers.Control.GreaseModifyFeature(this
										.getEditingLayer(), {}),
								'modifyfeature');
					},
					getEditingLayer : function() {
						return this.getLayersByName(this.LAYER_EDITING_NAME)[0];
					},

					getBusinessLayer : function() {
						var ll = this.getLayersByName("BusinessGeometries");
						if (ll && ll != null && ll != undefined
								&& ll.length > 0)
							return ll[0];
						return null;
					},

					resetEditingLayer : function() {
						var edLay = this.getEditingLayer();
						var a = edLay.removeFeatures();
						a = edLay.destroyFeatures();
						return true;
					},
					attivaModificaUltimaFeature : function(modoModifica) {

						// TODO ... rivedere
						// if (this.olcontrolli['DRAW_MODIFY'].active==false ||
						// this.olcontrolli['DRAW_MODIFY'].active==null) {
						// this.toggleControl('DRAW_MODIFY',{cursorClass:null,command:'DRAW'});
						// }

						if (modoModifica && modoModifica == 'RESHAPE') {
							this.controlli['modifyfeature'].mode = OpenLayers.Control.ModifyFeature.RESHAPE;

						} else if (modoModifica && modoModifica == 'MODIFY') {
							this.controlli['modifyfeature'].mode = OpenLayers.Control.ModifyFeature.RESIZE
									| OpenLayers.Control.ModifyFeature.ROTATE
									| OpenLayers.Control.ModifyFeature.DRAG;

							this.controlli['modifyfeature'].mode &= ~OpenLayers.Control.ModifyFeature.RESHAPE;

						} else {
							this.controlli['modifyfeature'].mode = OpenLayers.Control.ModifyFeature.RESHAPE;
						}
						var edLayer = this.getEditingLayer();
						var feature = edLayer.features[edLayer.features.length - 1];
						var selectControl = this.controlli['modifyfeature'].selectControl;
						// selectControl.unselect(feature);
						selectControl.select(feature);
						viewport.toggleComando({
							id : 'modifyfeature'
						}, true);
						for ( var key in this.controlli) {
							if (this.controlli[key].CLASS_NAME
									&& this.controlli[key].CLASS_NAME != null
									&& this.controlli[key].CLASS_NAME
											.indexOf('OpenLayers.Control.') == 0
									&& key != 'modifyfeature') {
								try {
									this.controlli[key].deactivate();
								} catch (err) {
								}
							}
						}

					},

					// END UC-MDDGIS-6 Editing

					moveTo : function(lonlat, zoom, options) {
						if (this.tocPanel != null) {
							for ( var i = 0, len = this.layers.length; i < len; i++) {
								var layer = this.layers[i];
								if (layer !== this.baseLayer
										&& !layer.isBaseLayer
										&& layer.CLASS_NAME != "OpenLayers.Layer.GreaseLayer") {
									layer.setVisibility(this.tocPanel
											.isMapserviceOn(layer.name))
								}
							}
						}

						OpenLayers.Map.prototype.moveTo.apply(this, [ lonlat,
								zoom, options ]);
					},

					aggiornaMappa : function() {
						this.pan(1, 0);
						if (this.controlli['historyNav']) {
							this.controlli['historyNav']
									.previousTriggerNoRestore();
						}
					},

					zoomPrecedente : function() {
						this.controlli['historyNav'].previousTrigger();
					},

					zoomSuccessivo : function() {
						this.controlli['historyNav'].nextTrigger();
					},

					calcolaNavigazione : function(xClick, yClick, comando,
							metodo) {

						metodo = (metodo ? metodo : 'calcolaNavigazione');
						var ext = this.getExtent();
						var idServizio = 'nosrv';
						var idLayer = 'nolay';
						if (this.tocPanel != null) {

							idLayer = this.tocPanel.getActiveLayer();
							idServizio = this.tocPanel.getActiveMapservice();

						}
						var leftN = parseInt(this.layerContainerDiv.style.left);
						var topN = parseInt(this.layerContainerDiv.style.top);

						if (isNaN(leftN))
							leftN = 0;
						if (isNaN(topN))
							topN = 0;

						// ***normalizzazione parametri da postare
						var listaParametri = {};
						var appDataName = this.appDataName;
						var root = [ appDataName ].join('');
						listaParametri[root + '.idServizioAttivo'] = new String(
								"" + idServizio);
						listaParametri[root + '.idLayerAttivo'] = idLayer;
						listaParametri[root + '.xclick'] = xClick;
						listaParametri[root + '.yclick'] = yClick;
						listaParametri[root + '.dimx'] = this.getSize().w;
						listaParametri[root + '.dimy'] = this.getSize().h;
						listaParametri[root + '.livelloZoom'] = this.getZoom();
						if (!OOJS.isEmpty(ext)) {
							listaParametri[root + '.envelope.nordest.coordXStr'] = new String(
									"" + ext.right).replace(",", ".");
							listaParametri[root + '.envelope.nordest.coordYStr'] = new String(
									"" + ext.top).replace(",", ".");
							listaParametri[root
									+ '.envelope.sudovest.coordXStr'] = new String(
									"" + ext.left).replace(",", ".");
							listaParametri[root
									+ '.envelope.sudovest.coordYStr'] = new String(
									"" + ext.bottom).replace(",", ".");
						}
						listaParametri[root + '.mainOffsetLeft'] = leftN;
						listaParametri[root + '.mainOffsetTop'] = topN;
						listaParametri['toolbar.comando'] = comando;
						listaParametri['strIdCurServizio'] = idServizio;
						var paramsPost = OOJS.apply(listaParametri);
						// ***fine normalizzazione parametri
						JQCsi.GreaseExt.Ajax
								.push(
										{
											url : ((this.actionNamespace != undefined && this.actionNamespace != null) ? this.actionNamespace
													+ "/"
													: "")
													+ this.actionName
													+ "!"
													+ metodo + ".do",
											method : 'POST',
											params : paramsPost,
											scope : this,
											isUpload : false,
											headers : {
												'Content-Type' : 'application/x-www-form-urlencoded',
												'X-Requested-With' : 'XMLHttpRequest'
											},
											fileUpload : false,
											success : function(result, request) {

												var dati = OOJS.util.JSON.decode(result.responseText);
																
												this
														.zoomToExtent(
																new OpenLayers.Bounds(
																		dati.dati.sudovest.coordX,
																		dati.dati.sudovest.coordY,
																		dati.dati.nordest.coordX,
																		dati.dati.nordest.coordY),
																true);

											},
											failure : function(result, request) {
												alert('problema:'+result);
											}
										}, 'controllimappa');
					},

					interroga : function(xClick, yClick, comando, metodo) {
						var ext = this.getExtent();
						var idServizio = 'TAIMS_aree_protette_2';
						var idLayer = '8';
						if (this.tocPanel != null) {

							idLayer = this.tocPanel.getActiveLayer();
							idServizio = this.tocPanel.getActiveMapservice();

						}
						var leftN = parseInt(this.layerContainerDiv.style.left);
						var topN = parseInt(this.layerContainerDiv.style.top);

						// ***normalizzazione parametri da postare
						var listaParametri = {};
						var appDataName = this.appDataName;
						var root = [ appDataName ].join('');
						listaParametri[root + '.idServizioAttivo'] = new String(
								"" + idServizio);
						listaParametri[root + '.idLayerAttivo'] = idLayer;
						listaParametri[root + '.xclick'] = xClick;
						listaParametri[root + '.yclick'] = yClick;
						listaParametri[root + '.dimx'] = this.getSize().w;
						listaParametri[root + '.dimy'] = this.getSize().h;
						listaParametri[root + '.livelloZoom'] = this.getZoom();
						listaParametri[root + '.envelope.nordest.coordXStr'] = (new String(
								"" + ext.right)).replace(",", ".");
						listaParametri[root + '.envelope.nordest.coordYStr'] = (new String(
								"" + ext.top)).replace(",", ".");
						listaParametri[root + '.envelope.sudovest.coordXStr'] = (new String(
								"" + ext.left)).replace(",", ".");
						listaParametri[root + '.envelope.sudovest.coordYStr'] = (new String(
								"" + ext.bottom)).replace(",", ".");
						listaParametri[root + '.mainOffsetLeft'] = leftN;
						listaParametri[root + '.mainOffsetTop'] = topN;
						listaParametri['toolbar.comando'] = comando;
						listaParametri['strIdCurServizio'] = idServizio;
						var paramsPost = OOJS.apply(listaParametri);
						// ***fine normalizzazione parametri
						JQCsi.GreaseExt.Ajax
								.push(
										{
											url : ((this.actionNamespace != undefined && this.actionNamespace != null) ? this.actionNamespace
													+ "/"
													: "")
													+ this.actionName
													+ "!"
													+ metodo + ".do",
											method : 'POST',
											params : paramsPost,
											scope : this,
											isUpload : false,
											headers : {
												'Content-Type' : 'application/x-www-form-urlencoded',
												'X-Requested-With' : 'XMLHttpRequest'
											},
											fileUpload : false,
											success : function(result, request) {
												new JQCsi.ui.maps.Utility.showGrid(
														result, request);
											},
											failure : function(result, request) {
												new JQCsi.ui.maps.Utility.showMessageBoxErrors(
														result);
											}
										}, "codaInterrogazione");
					},

					CLASS_NAME : "OpenLayers.GreaseMap"
				});

/**
 * 
 */
OpenLayers.Control.GreaseNavigationHistory = OpenLayers
		.Class(OpenLayers.Control.NavigationHistory,
				{

					previousTriggerNoRestore : function() {
						var current = this.previousStack.shift();
						var state = this.previousStack.shift();
						if (state != undefined) {
							this.nextStack.unshift(current);
							this.previousStack.unshift(state);
							this.onNextChange(this.nextStack[0],
									this.nextStack.length);
							this.onPreviousChange(this.previousStack[1],
									this.previousStack.length - 1);
						} else {
							this.previousStack.unshift(current);
						}
						return state;
					},

					CLASS_NAME : "OpenLayers.Control.GreaseNavigationHistory"
				});

/**
 * classe di utility
 * 
 * @class JQCsi.ui.maps.Utility
 */
JQCsi.ui.maps.Utility = function() {
	return {
		toFirstUpper : function(stringa) {
			return stringa.substr(0, 1).toUpperCase() + stringa.substr(1);
		},
		/**
		 * mostra il messagebox degli errori
		 * 
		 * @param {Object}
		 *            response
		 */
		showMessageBoxErrors : function(response) {
			// new JQCsi.GreaseExt.ProgressBar().offProgress();
			var messaggio = "";
			if (response.status == '304') {
				messaggio = constants.MSG_FAILURE_REQUEST_304;
			} else if (response.status == '200') {
				var testo = response.responseText;
				if (testo.indexOf('applicationError') != -1) {
					var subTesto = testo.substring(testo
							.indexOf('<div id="applicationError">') + 27,
							testo.length);
					messaggio = subTesto.substring(0, subTesto
							.indexOf('</div>'));
					messaggio += "</br>";
					var subLinks = testo.substring(testo
							.indexOf('<div id="applicationError_links">') + 33,
							testo.length);
					messaggio += subLinks.substring(0, subLinks
							.indexOf('</div>'));
					requestActive = false;
				} else {
					return; // Do nothing
				}
			} else if (response.status == '401') {
				messaggio = constants.MSG_FAILURE_REQUEST_401;
			} else if (response.status == '302') {
				messaggio = constants.MSG_FAILURE_REQUEST_302;
				requestActive = false;
			} else if (response.status == '500') {
				messaggio = constants.MSG_FAILURE_REQUEST_500;
			} else if (response.status == '502') {
				messaggio = constants.MSG_FAILURE_REQUEST_502;
				requestActive = false;
			} else {
				messaggio = constants.MSG_FAILURE_REQUEST_GENERIC;
			}
			(function() {
				/*
				 * §§ Ext.Msg.show({ title : constants.MSG_REMOTE_EXCEPTION, msg :
				 * messaggio, icon : Ext.Msg.ERROR, minWidth : 400, buttons :
				 * Ext.Msg.OK });
				 */
			}).defer(1000);
		},
		/**
		 * 
		 */
		get_url_CSI : function(bounds) {
			var res = this.map.getResolution();
			var x = Math.round((bounds.left - this.maxExtent.left)
					/ (res * this.tileSize.w));
			var y = Math.round((this.maxExtent.top - bounds.top)
					/ (res * this.tileSize.h));
			var z = this.map.getZoom();
			var limit = Math.pow(2, z);

			x = ((x % limit) + limit) % limit;
			y = limit - y - 1;

			var path = z + "/" + x + "/" + y + "." + this.type;
			var url = this.url;

			if (url instanceof Array) {
				url = this.selectUrl(path, url);
			}

			return url + path;
		},
		/**
		 * restituisce l'id del frammento da ricaricare
		 */
		getResponsePageId : function(fragment) {
			/*
			 * se non ho il page id allora sono in un dialogpanel
			 */
			if (fragment.indexOf('<!-- pageId:') == -1) {
				return 'dialogPanel';
			}
			var idStartIdx = fragment.indexOf('<!-- pageId:') + 12;
			var idEndIdx = fragment.indexOf(' -->', idStartIdx);
			return fragment.substring(idStartIdx, idEndIdx);
		},
		/**
		 * 
		 */
		zoomToRecordRenderer : function(value, metaData, record, rowIndex,
				colIndex, store) {
			var geometry = record.json['COL2'];
			alert(geometry);
			return '<a href="javascript:alert(' + value + ':\n' + geometry
					+ ')" target="_blank">' + value + '</a>';
		},
		/**
		 * 
		 */
		showGrid : function(response, request) {

			var jsonData = OOJS.util.JSON.decode(response.responseText);
									
			var grid = OOJS.getCmp('identify-grid');

			var colModel = new Object(); /*
											 * §§ new
											 * Ext.grid.ColumnModel(jsonData.dati.columnModel);
											 */

			colModel.config[0].renderer = this.zoomToRecordRenderer;

			var gridView = new Object(); /* §§ new Ext.grid.GridView(); */
			var store = new Object(); /*
										 * §§ new Ext.data.JsonStore({ fields :
										 * jsonData.dati.columns, data :
										 * jsonData.dati.rows });
										 */

			if (grid) {
				grid.reconfigure(store, colModel);
			} else {
				grid = new Object(); /*
										 * §§ new Ext.grid.GridPanel({ defaults : {
										 * sortable : true }, applyTo :
										 * 'identify-grid', store : store,
										 * colModel : colModel, view : gridView
										 * });
										 */
			}

			var win = new Object(); /*
									 * §§ new Ext.Window({ applyTo :
									 * 'identify-win', layout : 'fit', items :
									 * [grid], width : 500, height : 300,
									 * closeAction : 'hide', plain : true,
									 * buttons : [{ text : 'Submit', disabled :
									 * true }, { text : 'Close', handler :
									 * function() { win.hide(); } }] });
									 */

			win.show(this);
		}
	}
}();

var viewport = null;


/***
 * 
 */
$(function() {
	// the widget definition, where "custom" is the namespace,
	// "colorize" the widget name
	$.widget("custom.gistoolbar",
			{
				// default options
				options : {
					map : null // la mappa a cui deve essere associata la toolbar
				},
				// the constructor
				_create : function() {
//					this.element
					// add a class for theming
//					.addClass("custom-colorize")
					// prevent double click to select text
//					.disableSelection();
//					this.changer = $("<button>", {
//						text : "change",
//						"class" : "custom-colorize-changer"
//					}).appendTo(this.element).button();
					// bind click events on the changer button to the random
					// method
//					this._on(this.changer, {
						// _on won't call random when widget is disabled
//						click : "random"
//					});
//					this._refresh();
					var mappaTmp = this.options['map'];
					var gistoolbar = this;
					var idDivMappa = mappaTmp.idDivMap; // coincide con l'id del widget mapview...
					
					// creo la struttura HTML e il collegamento ai tools
					
					///////////////////////////////////////////////////////
					// toggle group per comandi navigazione (ci sono sempre)
					// widget
					this.element.append("<span id='"+idDivMappa+"_navTools'></span>");
					var navToolsSpan = $("#"+idDivMappa+"_navTools");
					navToolsSpan.append("<input type='radio' id='"+idDivMappa+"NavBarOnly' name='"+idDivMappa+"_navTools' checked='checked' class='mapViewNavBarOnly'/><label id='"+idDivMappa+"NavBarOnlyLabel' for='"+idDivMappa+"NavBarOnly' class='mapViewNavBarOnlyLabel'>naviga</label>");
					navToolsSpan.append("<input type='radio' id='"+idDivMappa+"DragPanTool' name='"+idDivMappa+"_navTools'  class='mapViewDragPanTool'/><label id='"+idDivMappa+"DragPanToolLabel' for='"+idDivMappa+"DragPanTool' class='mapViewDragPanToolLabel'>trascina mappa</label>");
					navToolsSpan.append("<input type='radio' id='"+idDivMappa+"ZoomBoxTool' name='"+idDivMappa+"_navTools'  class='mapViewZoomBoxTool'/><label id='"+idDivMappa+"ZoomBoxToolLabel' for='"+idDivMappa+"ZoomBoxTool' class='mapViewZoomBoxToolLabel'>zoom su area</label>");
					// collegamento con i tools
					gistoolbar._resetAllNavTools();
					$("#"+idDivMappa+"NavBarOnly").on("click", function(a,b){
						gistoolbar._resetAllDrawTools();
						gistoolbar._resetAllNavTools();
					}).button();
					$("#"+idDivMappa+"DragPanTool").on("click", function(a,b){
						mappaTmp.controlli[constants.PAN_KEY].activate();
						gistoolbar._resetAllDrawTools();
						gistoolbar._toggleNavTool(constants.PAN_KEY);
					}).button();
					$("#"+idDivMappa+"ZoomBoxTool").on("click", function(a,b){
						mappaTmp.controlli['zoomrect'].activate();
						gistoolbar._resetAllDrawTools();
						gistoolbar._toggleNavTool('zoomrect');
					}).button();
					$("#"+idDivMappa+"_navTools").buttonset();
				
					//////////////////////////////////////
					// click command (solo se configurato)
					if (!OOJS.isEmpty(mappaTmp.clickEventUrl)
							&& !OOJS.isEmpty(mappaTmp.refreshIds)){
						// widget
						this.element.append("<input type='button' id='"+idDivMappa+"ClickTool' value='click' class='mapViewClickTool' />");
						// collegamento al tool
						$("#"+idDivMappa+"ClickTool").on("click", function(a,b){
							mappaTmp.controlli['eventHandler'].activate();
							gistoolbar._resetAllDrawTools();
							gistoolbar._resetAllNavTools();
						}).button();
					}
				
					// draw commands (solo se previsto e solo quelli effettivamente configurati)
					if (mappaTmp.pointEditingActive || mappaTmp.lineEditingActive || mappaTmp.polygonEditingActive){
						this.element.append("<span id='"+idDivMappa+"_editTools'></span>");
						var navToolsSpan = $("#"+idDivMappa+"_editTools");
						
						navToolsSpan.append("<input type='radio' id='"+idDivMappa+"DisableDrawTools' name='"+idDivMappa+"_editTools'  class='mapViewDisableDrawTools' checked='checked'/><label id='"+idDivMappa+"DisableDrawToolsLabel' for='"+idDivMappa+"DisableDrawTools' class='mapViewDisableDrawToolsLabel'>disabilita disegno</label>");
						$("#"+idDivMappa+"DisableDrawTools").on("click", function(a,b){
							gistoolbar._resetAllDrawTools();
							gistoolbar._resetAllNavTools();
						}).button();
						
						if(mappaTmp.pointEditingActive){
							navToolsSpan.append("<input type='radio' id='"+idDivMappa+"DrawPointTool' name='"+idDivMappa+"_editTools'  class='mapViewDrawPointTool'/><label id='"+idDivMappa+"DrawPointToolLabel' for='"+idDivMappa+"DrawPointTool' class='mapViewDrawPointToolLabel'>disegna punto</label>");
							$("#"+idDivMappa+"DrawPointTool").on("click", function(a,b){
								mappaTmp.controlli['drawpoint'].activate();
								gistoolbar._resetAllNavTools();
							}).button();
						}
						
						if(mappaTmp.lineEditingActive){
							navToolsSpan.append("<input type='radio' id='"+idDivMappa+"DrawLineTool' name='"+idDivMappa+"_editTools' class='mapViewDrawLineTool'/><label id='"+idDivMappa+"DrawLineToolLabel' for='"+idDivMappa+"DrawLineTool' class='mapViewDrawLineToolLabel'>disegna linea</label>");
							$("#"+idDivMappa+"DrawLineTool").on("click", function(a,b){
								mappaTmp.controlli['drawline'].activate();
								gistoolbar._resetAllNavTools();
							}).button();
						}
						
						if(mappaTmp.polygonEditingActive){
							navToolsSpan.append("<input type='radio' id='"+idDivMappa+"DrawPolyTool' name='"+idDivMappa+"_editTools' class='mapViewDrawPolyTool'/><label id='"+idDivMappa+"DrawPolyToolLabel' for='"+idDivMappa+"DrawPolyTool' class='mapViewDrawPolyToolLabel'>disegna poligono</label>");
							$("#"+idDivMappa+"DrawPolyTool").on("click", function(a,b){
								mappaTmp.controlli['drawpoly'].activate();
								gistoolbar._resetAllNavTools();
							}).button();
						}
						
						$("#"+idDivMappa+"_editTools").buttonset();
					}
					
					
				},
				/**
				 * disattiva tutti i tool di disegno presenti
				 */
				_resetAllDrawTools : function () {
					var mappaTmp = this.options['map'];
					if (mappaTmp.pointEditingActive)
						mappaTmp.controlli['drawpoint'].deactivate();
					if (mappaTmp.lineEditingActive)
						mappaTmp.controlli['drawline'].deactivate();
					if (mappaTmp.polygonEditingActive)
						mappaTmp.controlli['drawpoly'].deactivate();
					$("#"+mappaTmp.idDivMap+"DisableDrawTools").attr('checked', true);
					$("#"+mappaTmp.idDivMap+"DisableDrawToolsLabel").addClass('ui-state-active');
					$("#"+mappaTmp.idDivMap+"DrawPointToolLabel").removeClass('ui-state-active');
					$("#"+mappaTmp.idDivMap+"DrawLineToolLabel").removeClass('ui-state-active');
					$("#"+mappaTmp.idDivMap+"DrawPolyToolLabel").removeClass('ui-state-active');
					//$("#"+mappaTmp.idDivMap+"_navTools").refresh();
				},
				/**
				 * resetta i tool di navigazione (impostando il tool che usa solo la barra)
				 */
				_resetAllNavTools : function() {
					var mappaTmp = this.options['map'];
					mappaTmp.controlli[constants.PAN_KEY].deactivate();
					mappaTmp.controlli['zoomrect'].deactivate();
					$("#"+mappaTmp.idDivMap+"NavBarOnlyLabel").addClass('ui-state-active');
					$("#"+mappaTmp.idDivMap+"DragPanToolLabel").removeClass('ui-state-active');
					$("#"+mappaTmp.idDivMap+"ZoomBoxToolLabel").removeClass('ui-state-active');
				},
				_toggleNavTool : function (toolOn) {
					this._resetAllNavTools();
					var mappaTmp = this.options['map'];
					mappaTmp.controlli[toolOn].activate();
				}, 
				// called when created, and later when changing options
				_refresh : function() {
					/*this.element.css("background-color", "rgb("
							+ this.options.red + "," + this.options.green + ","
							+ this.options.blue + ")");
					// trigger a callback/event
					this._trigger("change");*/
				},
				
				// events bound via _on are removed automatically
				// revert other modifications here
				_destroy : function() {
					// remove generated elements
					this.changer.remove();
					this.element.removeClass("custom-colorize")
							.enableSelection().css("background-color",
									"transparent");
				},
				// _setOptions is called with a hash of all options that are
				// changing
				// always refresh when changing options
				_setOptions : function() {
					// _super and _superApply handle keeping the right
					// this-context
					this._superApply(arguments);
					this._refresh();
				},
				// _setOption is called for each individual option that is
				// changing
				_setOption : function(key, value) {
					// prevent invalid color values
					if (/red|green|blue/.test(key)
							&& (value < 0 || value > 255)) {
						return;
					}
					this._super(key, value);
				}
			});
});
/**
 * 
 */





/**
 * funzione di inizializzazione della mappa
 * 
 * @class JQCsi.ui.maps.InitMap
 */
// JQCsi.ui.maps.InitMap = Ext.extend(function(config) {
ExtCsi.ui.maps.InitMap = OOJS
		.extend(
				function(config) {
					OOJS.apply(this, config);
				},
				{
					/**
					 * 
					 * @cfg {String} idHiddenField e' l'id del campo nascosto
					 *      nella form che contiene l'id della mappa che arriva
					 *      dal servizio
					 */
					idHiddenField : null,
					/**
					 * 
					 * @cfg {String} idDivToolbar e' l'id del div che contiene
					 *      la toolbar
					 */
					idDivToolbar : null,
					/**
					 * 
					 * @cfg {String} idDivLayerSwitcher l'id del div che
					 *      contiene il layer-switcher (se configurato)
					 */
					idDivLayerSwitcher : null,
					/**
					 * 
					 * @cfg {String} idDivMappa e' l'id del div che contiene la
					 *      mappa corrisponde al nome della mappa modellata
					 */
					idDivMappa : null,
					/**
					 * 
					 * @cfg {String} idMappa corrisponde all'id della mappa
					 *      modellata
					 */
					idMappa : null,
					/**
					 * 
					 * @cfg {String} actionName nome della action che deve
					 *      essere chiamata per la costruzione della mappa
					 */
					actionName : null,
					/**
					 * 
					 * @cfg {String} actionNamespace namesopace della action che
					 *      deve essere chiamata per la costruzione della mappa
					 */
					actionNamespace : null,
					/**
					 * 
					 * @cfg {String} appDataName nome dell'application data che
					 *      contiene la mappa
					 */
					appDataName : null,
					/**
					 * 
					 * @cfg {String} projectName nome del progetto target
					 */
					projectName : null,
					/**
					 * 
					 * @cfg {String} clickEventUrl se presente allora lancia
					 *      l'eventhandler associato al click sulla mappa
					 */
					clickEventUrl : null,
					/**
					 * 
					 * @cfg {Array} refreshIds elenco di id dei pannelli da
					 *      refreshare
					 */
					refreshIds : [],

					/**
					 * 
					 * @cfg {String} editingEventUrl se presente allora lancia
					 *      l'eventhandler associato all'editing sulla mappa
					 */
					editingEventUrl : null,
					/**
					 * 
					 * @cfg {Array} refreshEditingIds elenco di id dei pannelli
					 *      da refreshare in caso di editing
					 */
					refreshEditingIds : [],

					/**
					 * 
					 * @cfg {String} editingDataName nome dell'application data
					 *      che contiene i dati di editing
					 */
					editingDataName : null,

					/**
					 * 
					 * @cfg {boolean} layerSwitcher indica se attivare o meno il
					 *      layer switcher
					 * 
					 */
					layerSwitcher : false,

					/**
					 * 
					 * @cfg {String} layerswirtcher: nome del ms di background
					 *      con i dati mappa
					 */
					backgroundMapMapServiceName : null,

					/**
					 * 
					 * @cfg {String} layerswirtcher: etichetta del ms di
					 *      background con i dati mappa
					 */
					backgroundMapSwitcherLabel : null,

					/**
					 * 
					 * @cfg {String} layerswirtcher: nome del ms di background
					 *      con i dati foto
					 */
					backgroundPhotoAerialMapServiceName : null,

					/**
					 * 
					 * @cfg {String} layerswirtcher: etichetta del ms di
					 *      background con i dati foto
					 */
					backgroundPhotoAerialSwitcherLabel : null,

					/**
					 * 
					 * @cfg {boolean} indica se attivare il pulsante per
					 *      l'editing puntuale
					 * 
					 */
					pointEditingActive : false,

					/**
					 * 
					 * @cfg {boolean} indica se attivare il pulsante per
					 *      l'editing puntuale
					 * 
					 */
					lineEditingActive : false,

					/**
					 * 
					 * @cfg {boolean} indica se attivare il pulsante per
					 *      l'editing puntuale
					 * 
					 */
					polygonEditingActive : false,

					init : function() {

						if (OOJS.isEmpty(/* §§ OOJS.get(this.idDivMappa) */ $(this.idDivMappa))) {
							return;
						}
						new JQCsi.GreaseExt.ProgressBar();
						viewport = new JQCsi.GreaseExt.BaseViewport();
						var idMappaBack = $(this.idHiddenField).val(); /* §§OOJS.get(this.idHiddenField).getValue(); */

						var mappaTmp = new OpenLayers.GreaseMap(
								idMappaBack,
								this.actionName,
								this.idMappa,
								this.appDataName,
								this.idDivMappa,
								{
									controls : [ new OpenLayers.Control.PanZoomBar()],
									displayOutsideMaxExtent : false,
									projection : new OpenLayers.Projection(
											"EPSG:32632"),
									units : 'm'
								}, this.projectName, this.clickEventUrl,
								this.refreshIds, this.editingDataName,
								this.editingEventUrl, this.refreshEditingIds,
								this.pointEditingActive,
								this.lineEditingActive,
								this.polygonEditingActive,
								this.actionNamespace);

						if (!OOJS.isEmpty(this.editingEventUrl)
								&& !OOJS.isEmpty(this.refreshEditingIds)) {
							mappaTmp.events.register("mappaInit", mappaTmp,
									function() {
										this.addControlliEditing();
									});
						}

						mappaTmp.events
								.register(
										"mappaInit",
										mappaTmp,
										function() {
											this.getEditingLayer().styleMap = constants.defaultEditingDatiStyle;
											if (null != this.getBusinessLayer())
												this.getBusinessLayer().styleMap = constants.defaultSelectedDatiStyle;
										});

						mappaTmp.addControllo(
								new OpenLayers.Control.GreaseIdentify(null,
										null, this.idMappa), 'identify');
										
						mappaTmp.doMapSetup();

						if (this.layerSwitcher == true
								&& !OOJS
										.isEmpty(this.backgroundMapMapServiceName)
								&& !OOJS
										.isEmpty(this.backgroundMapSwitcherLabel)
								&& !OOJS
										.isEmpty(this.backgroundPhotoAerialMapServiceName)
								&& !OOJS
										.isEmpty(this.backgroundPhotoAerialSwitcherLabel)) {
						var ls = new JQCsi.GreaseExt.GreaseLayerSwitcher(
									{
										renderTo : this.idDivLayerSwitcher,
										mappa : mappaTmp,
										buttonNameMapserviceMap : this.backgroundMapSwitcherLabel,
										buttonNameMapservicePhotoAerial : this.backgroundPhotoAerialSwitcherLabel,
										backgroundNameMapserviceMap : this.backgroundMapMapServiceName,
										backgroundNameMapservicePhotoAerial : this.backgroundPhotoAerialMapServiceName,
										idLayerSwitcher : this.idDivLayerSwitcher
									});
							ls.initComponent();
							// ls.render('layerswitcher');
							mappaTmp.setToc(ls);

						} else {
							mappaTmp.setToc(null);
						}

						viewport.addMap(mappaTmp);

				
						$("#"+this.idDivToolbar).gistoolbar({map: mappaTmp});


					}
				});

// START UC-MDDGIS-6 Editing

OpenLayers.Control.GreaseEditingWidget = OpenLayers
		.Class({

			viewport : null,

			confirmWin : null,

			elementDiv : 'editconfirmwin',

			initialize : function(options) {
				OpenLayers.Util.extend(this, options);
				this.confirmWin = new Ext.Window(
						{
							applyTo : this.elementDiv,
							layout : 'fit',
							width : 400,
							height : 100,
							resizable : false,
							closeAction : 'hide',
							plain : true,
							modal : true,
							closable : false,
							resizable : false,
							minimizable : false,
							maximizable : false,
							buttonAlign : "center",
							autoCreate : true,
							constrain : true,
							constrainHeader : true,
							stateful : false,
							shim : true,
							plain : true,
							footer : true,

							buttons : [
									{
										text : 'Salva',
										handler : function() {
											// TODO
											this.resetEditingLayer();
										}
									},
									{
										text : 'Modifica Vertici',
										handler : function() {
											this.layer.map
													.attivaModificaUltimaFeature('RESHAPE');
											this.widget.hide();
										}
									},
									{
										text : 'Sposta/Ruota/Resize',
										handler : function() {
											this.layer.map
													.attivaModificaUltimaFeature('MODIFY');
											this.widget.hide();
										}
									}, {
										text : 'Annulla',
										handler : function() {
											this.resetEditingLayer();

										}
									} ]

						});
				this.confirmWin.getEl().addClass('x-window-dlg');
			},

			hide : function() {
				this.confirmWin.hide();
			},

			mostraConfermaEditing : function(scope) {
				for ( var cntBtn = 0; cntBtn < this.confirmWin.buttons.length; cntBtn++) {
					this.confirmWin.buttons[cntBtn].scope = scope;
				}
				this.confirmWin.show();

			},

			CLASS_NAME : "OpenLayers.Control.GreaseEditingWidget"
		});

OpenLayers.Control.GreaseModifyFeature = OpenLayers
		.Class(
				OpenLayers.Control.ModifyFeature,
				{

					// widget:null,

					initialize : function(layer, handler, options) {
						OpenLayers.Control.ModifyFeature.prototype.initialize
								.apply(this, [ layer, handler, options ]);
					},

					unselectFeature : function(object) {
						OpenLayers.Control.ModifyFeature.prototype.unselectFeature
								.apply(this, [ object ]);

						// var geometry=object.feature.geometry;
						var geometry = null;
						if (object.feature && object.feature.geometry)
							geometry = object.feature.geometry;
						else
							geometry = object.geometry;

						var geometryType = '';
						var str = "";
						if (this.layer.features.length == 1) {
							var geojson = new OpenLayers.Format.GeoJSON();
							str = geojson.write(geometry, false);
						} else {
							var geometrie = new Array();
							for ( var k = 0; k < this.layer.features.length; k++) {
								var curGeom = this.layer.features[k].geometry;
								geometrie.push(curGeom);
							}
							var geomColl = null;
							if (geometry.CLASS_NAME == 'OpenLayers.Geometry.Point') {
								geomColl = new OpenLayers.Geometry.MultiPoint({
									'components' : geometrie
								});
							} else if (geometry.CLASS_NAME == 'OpenLayers.Geometry.LineString') {
								geomColl = new OpenLayers.Geometry.MultiLineString(
										{
											'components' : geometrie
										});
							} else if (geometry.CLASS_NAME == 'OpenLayers.Geometry.Polygon') {
								geomColl = new OpenLayers.Geometry.MultiPolygon(
										geometrie);
							}

							var geojson = new OpenLayers.Format.GeoJSON();
							str = geojson.write(geomColl, false);
						}
						// this.widget.mostraConfermaEditing(this);

					},
					resetEditingLayer : function() {
						this.layer.map.resetEditingLayer();
						// this.widget.hide();
					},

					CLASS_NAME : "OpenLayers.Control.GreaseModifyFeature"
				});

OpenLayers.Control.GreaseDrawFeature = OpenLayers
		.Class(
				OpenLayers.Control.DrawFeature,
				{

					singleGeom : true,

					// widget:null,

					initialize : function(layer, handler, options) {
						// this.greaseOptions = OpenLayers.Util.extend({},
						// this.defaultGreaseOptions);
						OpenLayers.Control.DrawFeature.prototype.initialize
								.apply(this, [ layer, handler, options ]);

						// if (options.singleGeom)
						// this.singleGeom=options.singleGeom;
						// if (options.actionName)
						// this.actionName=options.actionName;

					},

					activate : function() {
						this.resetFeatures();
						OpenLayers.Control.DrawFeature.prototype.activate
								.apply(this, arguments);
					},

					deactivate : function() {
						OpenLayers.Control.DrawFeature.prototype.deactivate
								.apply(this, arguments);
					},

					resetFeatures : function() {
						this.layer.removeFeatures();
						this.layer.destroyFeatures();
						return true;
					},

					drawFeature : function(geometry) {
						if (this.singleGeom == true) {
							this.resetFeatures();
						}
						OpenLayers.Control.DrawFeature.prototype.drawFeature
								.apply(this, [ geometry ]);

						var geometryType = '';
						var str = "";
						if (this.singleGeom == true) {
							var geojson = new OpenLayers.Format.GeoJSON();
							str = geojson.write(geometry, false);
						} else {
							var geometrie = new Array();
							for ( var k = 0; k < this.layer.features.length; k++) {
								var curGeom = this.layer.features[k].geometry;
								geometrie.push(curGeom);
							}
							var geomColl = null;
							if (geometry.CLASS_NAME == 'OpenLayers.Geometry.Point') {
								geomColl = new OpenLayers.Geometry.MultiPoint({
									'components' : geometrie
								});
							} else if (geometry.CLASS_NAME == 'OpenLayers.Geometry.LineString') {
								geomColl = new OpenLayers.Geometry.MultiLineString(
										{
											'components' : geometrie
										});
							} else if (geometry.CLASS_NAME == 'OpenLayers.Geometry.Polygon') {
								geomColl = new OpenLayers.Geometry.MultiPolygon(
										geometrie);
							}

							var geojson = new OpenLayers.Format.GeoJSON();
							str = geojson.write(geomColl, false);
						}

						//this.widget.mostraConfermaEditing(this);

						this.handleEditCommit(str);

					},

					/**
					 * gestisce l'evento di termine editing di un elemento
					 */
					handleEditCommit : function(jsonGeom) {
						var listaParametri = {};
						var editingDataName = this.layer.map.editingDataName;
						var root = [ editingDataName ].join('');
						/*
							listaParametri[root + '.dimx'] = this.map.getSize().w;
							listaParametri[root + '.dimy'] = this.map.getSize().h;
							listaParametri[root + '.livelloZoom'] = this.map.getZoom();
							listaParametri[root + '.envelope.nordest.coordXStr'] = (new String(""
									+ ext.right)).replace(",", ".");
							listaParametri[root + '.envelope.nordest.coordYStr'] = (new String(""
									+ ext.top)).replace(",", ".");
							listaParametri[root + '.envelope.sudovest.coordXStr'] = (new String(""
									+ ext.left)).replace(",", ".");
							listaParametri[root + '.envelope.sudovest.coordYStr'] = (new String(""
									+ ext.bottom)).replace(",", ".");
						    
						 */
						//listaParametri[root + '[0].geometria'] = jsonGeom;
						listaParametri[root] = '[{"identificativo":"noIdentificativoNewGeom","geometria":'
								+ jsonGeom + '}]';
						//listaParametri[root ] = '[{"geometria":{"type":"Point","coordinates":[414497.18617719,5024058.8349878]},"identificativo":"noIdentificativoNewGeom"}]';

						/*
						 listaParametri[root +'.identificativo'] = 'ciccio';
						 listaParametri[root + '.geometria'] = jsonGeom;
						 listaParametri[root +'.identificativo'] = 'pasticcio';
						 listaParametri[root + '.geometria'] = '{"type":"Point","coordinates":[414497.18617719,5024058.8349878]}';
						 */
						var paramsPost = OOJS.apply(listaParametri);

						var pageId = this.layer.map.actionName;
						var pageNs = ((this.layer.map.actionNamespace != undefined && this.layer.map.actionNamespace != null) ? this.layer.map.actionNamespace
								+ "/"
								: "");

						JQCsi.GreaseExt.Ajax
								.push(
										{
											url : this.layer.map.editingEventUrl,
											method : 'POST',
											params : paramsPost,
											scope : this,
											isUpload : false,
											headers : {
												'Content-Type' : 'application/x-www-form-urlencoded',
												'X-Requested-With' : 'XMLHttpRequest'
											},
											fileUpload : false,
											success : function(result, request) {
												var fragment = result.responseText;

												var responsePageId = new JQCsi.ui.maps.Utility.getResponsePageId(
														fragment);

												if (responsePageId == 'dialogPanel') {
													/*var fragm = fragment
															.substring(
																	fragment
																			.indexOf('<body>') + 6,
																	fragment
																			.indexOf('</body>'));
													var frammento = OOJS
															.getBody();
													frammento.dom.innerHTML = fragm;*/
													replaceForm(fragment);

												} else if (pageId != null
														&& fragment
																.indexOf('<!-- pageId:'
																		+ pageId
																		+ ' -->') == -1) {
													/*
													 * 
													 */
													document.forms[0].action = pageNs
															+ responsePageId
															+ '.do';
													document.forms[0].submit();

												} else {

													var idSplit = this.layer.map.refreshEditingIds;
													replaceFragments(pageId, idSplit, fragment);

												}

												
											},
											failure : function(result, request) {

											}
										}, 'codaEditing');

					},

					resetEditingLayer : function() {
						this.layer.map.resetEditingLayer();
						//this.widget.hide();
					},

					CLASS_NAME : "OpenLayers.Control.GreaseDrawFeature"
				});



/***
 * 
 */
$(function() {
	// the widget definition, where "custom" is the namespace,
	// "gislayerswitcher" the widget name
	$.widget("custom.gislayerswitcher",
			{
				// default options
				options : {
					map : null, // la mappa a cui deve essere associato il layerSwitcher
					toc : null // istanza di GreaseLayerSwitcher..
				},
				// the constructor
				_create : function() {
					var mappaTmp = this.options['map'];
					var gislayoutswitcher = this;
					var idDivMappa = mappaTmp.idDivMap; // coincide con l'id del widget mapview...
					var theToc = this.options['toc'];
					this.element.append("<span id='layoutSwitcherSpan_"+idDivMappa+"'></span>");
					var lsspan = $("#layoutSwitcherSpan_"+idDivMappa);
					lsspan.append("<input type='radio' id='"+idDivMappa+"LayerMap' name='"+idDivMappa+"_layerSwitcher' class='mapViewLayerSwitcherMap'/><label for='"+idDivMappa+"LayerMap'>mappa</label>");
					lsspan.append("<input type='radio' id='"+idDivMappa+"LayerAerial' name='"+idDivMappa+"_layerSwitcher' checked='checked' class='mapViewLayerSwitcherAerial'/><label for='"+idDivMappa+"LayerAerial'>satellite</label>");
					
					
					
					$("#"+idDivMappa+"LayerAerial").on("click", function(a,b){
						theToc.selectAerialAsBackground();
					}).button();
					$("#"+idDivMappa+"LayerMap").on("click", function(a,b){
						theToc.selectMapAsBackground();
					}).button();
					lsspan.buttonset();
					
				},
				// called when created, and later when changing options
				_refresh : function() {
					
				},
				
				// events bound via _on are removed automatically
				// revert other modifications here
				_destroy : function() {
					
				},
				// _setOptions is called with a hash of all options that are
				// changing
				// always refresh when changing options
				_setOptions : function() {
					// _super and _superApply handle keeping the right
					// this-context
					this._superApply(arguments);
					this._refresh();
				},
				_setOption : function(key, value) {
	
				}
			});
});



JQCsi.GreaseExt.GreaseLayerSwitcher = OOJS
		.extend(
				OOJS.util.Observable /* §§ Ext.Toolbar */,
				{

					mappa : null,

					backgroundNameMapserviceMap : null,
					buttonNameMapserviceMap : null,
					backgroundNameMapservicePhotoAerial : null,
					buttonNameMapservicePhotoAerial : null,
					activeBackground : null,
					idLayerSwitcher: null,
					
					constructor : function(config){
						OOJS.apply(this, config);
						$("#"+this.idLayerSwitcher).gislayerswitcher({map: this.mappa, toc : this});
					},
					initComponent : function() {
					/*	this.items = [ new Ext.Button({
							id : 'lsmappa',
							//text: 'Pan',
							//iconCls: 'pan',
							tooltip : 'Mappa',
							tooltipType : 'title',
							enableToggle : true,
							allowDepress : false,
							toggleGroup : "layerSwitcher",
							pressed : true
						}), '-', new Ext.Button({
							id : 'lssat',
							//text: 'Pan',
							//iconCls: 'zoomrect',
							tooltip : 'Satellite',
							tooltipType : 'title',
							enableToggle : true,
							allowDepress : false,
							toggleGroup : "layerSwitcher",
							pressed : false
						}) ];
						*/
						/*JQCsi.GreaseExt.GreaseLayerSwitcher.superclass.initComponent
								.call(this);*/

						/*this.items.items[0].on('toggle', this.toggleComando,
								this);
						this.items.items[0].tooltip = this.buttonNameMapserviceMap;
						this.items.items[0].text = this.buttonNameMapserviceMap;

						this.items.items[2].on('toggle', this.toggleComando,
								this);
						this.items.items[2].tooltip = this.buttonNameMapservicePhotoAerial;
						this.items.items[2].text = this.buttonNameMapservicePhotoAerial;
						*/
						//TODO provo a rendere compatibile con toc
						this.addEvents('nodedrop');
						this.addEvents('tocLoaded');
						this.activeBackground = this.backgroundNameMapserviceMap;

					},
					loadToc : function() {
						//Retro comp con toc
						this.fireEvent('tocLoaded', this);
					},

					isMapserviceOn : function(idMapservice) {
						
						/* §§ */
						if (idMapservice
								.indexOf(this.backgroundNameMapserviceMap + "_") == 0) {
							return (this.activeBackground == this.backgroundNameMapserviceMap);
						} else if (idMapservice
								.indexOf(this.backgroundNameMapservicePhotoAerial
										+ "_") == 0) {
							return (this.activeBackground == this.backgroundNameMapservicePhotoAerial);
						} else {
							//TODO
							return this.mappa.getLayersByName(idMapservice)[0].visibility;
						}
						return true;
					},
					getActiveLayer : function() {
						return null;
					},
					getActiveMapservice : function() {
						return null;
					},
					setStatoMs : function(idservizio, stato) {
					},
					upDateMS : function(idservizio, data) {
					},
					getJsonLayers : function(idMapservice) {
						return "[]";
					},
					selectMapAsBackground : function(){
						this.activeBackground = this.backgroundNameMapserviceMap;
						this.mappa.aggiornaMappa();
					},
					selectAerialAsBackground : function(){
						this.activeBackground = this.backgroundNameMapservicePhotoAerial;
						this.mappa.aggiornaMappa();
					}
					/*,
					toggleComando : function(btn, state) {

						if (btn.id == 'lsmappa' && state == true) {
							this.activeBackground = this.backgroundNameMapserviceMap;
							this.mappa.aggiornaMappa();
						}
						if (btn.id == 'lssat' && state == true) {
							this.activeBackground = this.backgroundNameMapservicePhotoAerial;
							this.mappa.aggiornaMappa();
						}
					}*/
				});

// END UC-MDDGIS-6 Editing
