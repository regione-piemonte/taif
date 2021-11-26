#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/*
 * @author Cristiano Cucco (2012)
 * @requires jQuery v1.8.2
 * 
 * Inspired by https://github.com/addyosmani/jquery-plugin-patterns/blob/master/patterns/jquery.highly-configurable.plugin.boilerplate.js
 * by https://github.com/addyosmani
 */


// Note that with this pattern, as per Alex Sexton's, the plugin logic
// hasn't been nested in a jQuery plugin. Instead, we just use
// jQuery for its instantiation.

;(function( $, window, document, undefined ){

  // our plugin constructor
  var JQPanel = function( elem, options ){
      this.elem = elem;
      this.$elem = $(elem);
      this.options = options;
  };

  // the plugin prototype
  JQPanel.prototype = {
    defaults: {
    	mainPanel: '#mainPanel',
    	mainPanelFullClass: 'fullContent',
    	mainPanelMidClass: 'midContent',
    	panelElement: null,
    	handleElement: '.panelHandle',
    	handleOpenElement: '.open',
    	handleCloseElement: '.close',
    	handleClass: 'panelHandle',
    	closeClass: 'close',
    	openClass: 'open',
	    closeText: 'chiudi pannello',
	    openText: 'apri pannello',
	    hiddenClass: null,
	    hideOnInit: false,
	    customToggleAction: null,
	    debug: false
    },
    
    // oggetto con variabili di stato
    state: {
    	numLog: 0,
    	open: true
    },
    
    // inizializza plugin
    init: function() {
      // Introduce defaults that can be extended either
      // globally or using an object literal.
      this.config = $.extend({}, this.defaults, this.options);
      
      // inizializza pannello
      this.initPanel();
      
      return this;
    },
    
    // inizializza pannello a scomparsa
    initPanel: function() {
    	// wrappa contenuto panel in div aggiuntivo se non esiste panelElement 
    	if ($(this.config.panelElement).length>0) { 
    		this.wrapper = $(this.config.panelElement); 
    	} else {
	    	this.wrapper = $('<div>').addClass('hidablePanel')
	    		.append(this.$elem.children().not($(this.config.handleElement))).appendTo(this.$elem);
    	}
    	// crea maniglia
    	this.createHandle();
    	// attach render function to state changes
    	var that = this;
    	this.$elem.bind('stateChanged', function() {
    		// se tra le opzioni 
    		if (that.config.customToggleAction instanceof Function) {
    			that.config.customToggleAction.call(that);
    		} else {
    			that.renderPanel.call(that);
    		}
    	});
    	// stato iniziale
    	this.setState('open', !this.config.hideOnInit);
    },
    
    // crea maniglia apertura/chiusura pannello
    createHandle: function() {
    	var that = this;
    	// esiste un handle già pronto
    	if ($(this.config.handleElement, this.$elem).length > 0) {
    		var handle = $(this.config.handleElement, this.$elem).eq(0);
    		this.openCtrl = $(this.config.handleOpenElement, handle)
    			.click(function(){that.openPanel.call(that);})
    			.hide()
    			;
    		this.closeCtrl = $(this.config.handleCloseElement, handle)
				.click(function(){that.closePanel.call(that);})
				;
    	} 
    	// non esiste e lo devo creare
    	else {
        	this.openCtrl = $('<a href="#" />').addClass(this.config.openClass)
	    		.append($('<span>').text(this.config.openText))
	    		.click(function(){that.openPanel.call(that);})
	    		.hide() // di default è chiuso
	    		;
	    	this.closeCtrl = $('<a href="#" />').addClass(this.config.closeClass)
	    		.append($('<span>').text(this.config.closeText))
	    		.click(function(){that.closePanel.call(that);})
	    		; 
	    	var handle = $('<span>').addClass(this.config.handleClass)
	    		.append(this.openCtrl).append(this.closeCtrl);
	    	
	    	this.$elem.prepend(handle);
    	}
    },
    
    // effettua una serie di operazioni in funzione dello stato (this.state)
    renderPanel: function() {
    	this.log('renderPanel');
    	// manage Handle
    	this.openCtrl.css('display', this.state.open ? 'none' : 'block');
    	this.closeCtrl.css('display', this.state.open ? 'block' : 'none');
    	// manage Panel
    	if (this.config.hiddenClass == null){ 
    		this.wrapper.css('display', this.state.open ? 'block' : 'none');
    	} else { 
    		this.wrapper
    			.addClass(this.state.open ? '':this.config.hiddenClass)
    			.removeClass(this.state.open ? this.config.hiddenClass:'');
    	}
    	// manage main Panel
    	$(this.config.mainPanel)
    		.addClass(this.state.open ? this.config.mainPanelMidClass : this.config.mainPanelFullClass)
    		.removeClass(this.state.open ? this.config.mainPanelFullClass : this.config.mainPanelMidClass)
    		;
    },
    
    // apre il pannello
    openPanel: function() {
    	this.log('openPanel');
    	this.setState('open', true);
    },
    
    // chiude il pannello
    closePanel: function() {
    	this.log('closePanel');
    	this.setState('open', false);
    },
    
    // apre/chiude il pannello
    togglePanel: function() {
    	this.log('togglePanel');
    	this.setState('open', !this.state.open);
    },
    
    setState: function(key, val) {
    	this.state[key] = val;
    	// notify
    	this.$elem.trigger('stateChanged');
    },
    
    log: function(val, txt) {
    	if (!this.config.debug) return;
    	if (window.console) {
    		txt = txt ? txt : 'Log #'+this.state.numLog++;
    		console.log(val, txt);
    	}
    }
  };

  JQPanel.defaults = JQPanel.prototype.defaults;

  // API
  $.fn.jqpanel = function(options) {
	return this.each(function(){
	    // inizializza una volta sola per elemento
	    if ( !$.data(this, "apiJQPanel" )) {
	    	var instance = new JQPanel(this, options).init();
	    	// restituisce metodi API
	    	$.data( this, "apiJQPanel", {
	    		openPanel: function() { instance.openPanel(); },
	    		closePanel: function() { instance.closePanel(); },
	    		togglePanel: function() { instance.togglePanel(); }
	    	});
	    }
	});
  };

  //optional: window.Plugin = Plugin;

})( jQuery, window , document );
