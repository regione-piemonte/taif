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
  var JQMenu = function( elem, options ){
      this.elem = elem;
      this.$elem = $(elem);
      this.options = options;
      
      this.onMenuOut = null;
    };

  // the plugin prototype
  JQMenu.prototype = {
    defaults: {
    	current: '#current'
    },
    
    state: {
    },
    
    initHor: function() {
    	// Introduce defaults that can be extended either
    	// globally or using an object literal.
    	this.config = $.extend({}, this.defaults, this.options);
      
    	// init common
    	this.initCommon();
    	// risale l'albero e aggiunge active class al nodo padre di li#current
		$(this.config.current, this.$elem).parents('li').eq(0).not(this.$elem).addClass('active-parent');
		// setta numero livelli da tenere aperti on reset
		this.resetOpenLevels = 2;
		// setta behavior su click/tab fuori menu
		this.onMenuOut = this.resetMenu;
		// bind al click fuori dal menu
		this.bindCloseOnClickOut();
		// bind al tab fuori dal menu		
		this.bindCloseOnTabOut();
		
		// init menu superfish
		$(this.$elem).superfish({
			closeOthers: true,
			closeOnClick: false
		});
		// apre il ramo del menu con foglia #current
		//this.openCurrent();
		
    	return this;
    },
    
    initDropDown: function() {
    	// Introduce defaults that can be extended either
    	// globally or using an object literal.
    	this.config = $.extend({}, this.defaults, this.options);
      
    	// init common
    	this.initCommon();
    	// risale l'albero e aggiunge active class al nodo li padre di li#current
		$(this.config.current, this.$elem).parents('li').last().not(this.$elem).addClass('active-parent');
		
		// init menu superfish
		$(this.$elem).superfish({
			closeOthers: true,
			closeOnClick: false,
			openOnClick: true,
			pathLevels: 0
		});
		// apre il ramo del menu con foglia #current
		//this.openCurrent();
		
    	return this;
    },
    
    initVer: function() {
    	// Introduce defaults that can be extended either
    	// globally or using an object literal.
    	this.config = $.extend({}, this.defaults, this.options);
    	
    	// init common
    	this.initCommon();
		// setta numero livelli da tenere aperti on reset
		this.resetOpenLevels = 3;
		// setta behavior su click/tab fuori menu
		this.onMenuOut = this.resetMenu;
		// bind al click fuori dal menu
		this.bindCloseOnClickOut();
		// bind al tab fuori dal menu		
		this.bindCloseOnTabOut();

		// init menu superfish
		$(this.$elem).superfish({
			closeOthers: false,
			closeOnClick: true,
			pathLevels: 2
		});
		// apre il ramo del menu con foglia #current
		//this.openCurrent();
		
    	return this;
    },
    
    initCommon: function() {
    	// risale l'albero e aggiunge active class a tutti i nodi padri di li#current
		$(this.config.current, this.$elem).parents('ul,li').not(this.$elem).addClass('active');
		// trasforma gli span in link (per navigazione da tastiera)
		$('span.parent', this.$elem).each(function(i,el){
			jQuery(el)
			    .after(jQuery('<a>')
			    		.attr('href','#')
			    		.addClass($(this).attr('class'))
			    		.text($(this).text()))
			    .remove();
		});
    },
    
    openCurrent: function() {
    	return;
    	// su tutti i nodi parents trigger del mouseover (serve per init plugin)
    	// e successivo trigger del click (apre il nodo)
    	$(this.config.current, this.$elem)
    		.parents('ul').siblings('.parent')
    		.slice(0, this.resetOpenLevels-1)
    		.trigger('mouseover').trigger('click');
    },
    
    resetMenu: function() {
    	//console.log('hide');
    	//$(this.$elem).hideSuperfishUl();
    	//this.openCurrent();
    	// BETA
    	$(this.$elem).resetSuperfish();
    },
    
    // ..bind al click fuori dal menu fa scattare la chiusura
    bindCloseOnClickOut: function() {
    	var that = this;
		$(document).bind('click', function(ev){
            var _target = ev.target || ev.srcElement;
            var _bool = false;
            $(_target).parents().each(function(){
            	if ($(this).is(that.$elem))
           			_bool = true; 
            });
            if(_bool) {
            	//console.log('click over menu');
                return;
            }
            else {
            	//console.log(that.onMenuOut, 'onMenuOut');
            	if (that.onMenuOut instanceof Function) {
            		that.onMenuOut.call(that);
            	}
            }
        });
    },
    
    // ..bind al tab (da tastiera) fuori dal menu fa scattare la chiusura
    bindCloseOnTabOut: function() {
    	var that = this;
		$(document).bind('keyup', function(ev){
			if (ev.keyCode==9) {
	            var _target = ev.target || ev.srcElement;
	            var _bool = false;
	            $(_target).parents().each(function(){
	            	if ($(this).is(that.$elem))
	           			_bool = true; 
	            });
	            if(_bool) {
	            	//console.log('click over menu');
	                return;
	            }
	            else {
	            	if (that.onMenuOut instanceof Function) {
	            		that.onMenuOut.call(that);
	            	}
	            }
			}
        });
    }
    
  };

  JQMenu.defaults = JQMenu.prototype.defaults;

  // API
  $.fn.menuHor = function(options) {
    return this.each(function() {
      new JQMenu(this, options).initHor();
    });
  };
  $.fn.menuVer = function(options) {
    return this.each(function() {
      new JQMenu(this, options).initVer();
    });
  };
  $.fn.menuDropDown = function(options) {
    return this.each(function() {
      new JQMenu(this, options).initDropDown();
    });
  };

  //optional: window.Plugin = Plugin;

})( jQuery, window , document );
