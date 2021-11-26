#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
;(function($){

////////////////////////////////////////////////////////////////////////////////
//========== PULSANTI FUNZIONALI================================================
////////////////////////////////////////////////////////////////////////////////

var jQButton = {
    build : function(options){
        var _options = $.extend({
            text     : 'bottone',
            callback : function(){}  
        }, options);
        
        return this.each(function(){
            $('<a href="#">'+_options.text+'</a>')
            .attr("rel",_options.text)
            .click(function(){
                _options.callback(this);
                return false;
            })
            .appendTo(this);    
        });
    },
    init : function() {
    	
    } 
};

$.fn.jbutton = jQButton.build;
$.fn.jbutton_init = jQButton.init;

$(document).bind("ready", function(ev){
	var _target = ev.target || document;
	jQuery(_target).jbutton_init();
});

})(jQuery);

