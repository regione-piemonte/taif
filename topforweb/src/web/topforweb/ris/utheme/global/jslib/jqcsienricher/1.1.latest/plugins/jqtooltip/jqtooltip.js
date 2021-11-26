#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/*
 * Copyright (c) 2009 Massimiliano Balestrieri
 * 
 * $Date: 2010-06-10 10:51:44 +0200 (gio, 10 giu 2010) $
 * $Rev: 337 $
 * @requires jQuery v1.3.2
 * 
 * Copyright (c) 2008 Massimiliano Balestrieri
 * Examples and docs at: http://maxb.net/blog/
 * Licensed GPL licenses:
 * http://www.gnu.org/licenses/gpl.html
 */

(function($){
	
jQTooltip = {}; 

////////////////////////////////////////////////////////////////////////////////
//========== CARICAMENTO CSS ===================================================
////////////////////////////////////////////////////////////////////////////////

jQTooltip.Css = {
    load   : function(options){
    	if(options.constructor === String)
    		var _options = {url : options, media : "screen"};
    	else
    		var _options = $.extend({media : "screen"}, options);
    	
    	$('head').append('<link type="text/css" href="'+_options.url+'" rel="stylesheet" media="'+_options.media+'" />'); 
    }
};

$.fn.loadcss = jQTooltip.Css.load;



////////////////////////////////////////////////////////////////////////////////
//========== TOOLTIP ===========================================================
////////////////////////////////////////////////////////////////////////////////

jQTooltip.Tooltip = {
	counter : 0,
	build   : function(options){
        
        var _options = $.extend({
			has_image        : true,
			img_class        : 'im_error',
			link_class       : 'link_errore',
			target_class_on  : 'elenco_errori_visibile',
			target_class_off : 'elenco_errori_invisibile'
		}, options);
        //$("span.txt_errore span").css({color:"auto",display:"inline",});//fontWeight: "normal"
        
		var _static = jQTooltip.Tooltip.counter++;   
		 
        return this.each(function(nr){
            
            var that = this;
            //console.log(that);
            var _img = $(this).find("img").eq(0);
            if(_img.hasClass(_options.img_class) || !_options.has_image){
                
				var _id = nr + 1;
				_id = _static + '_' + _id;
				
				var _link = '<a href="#toolt_'+ _id +'" class="'+_options.link_class+'">&nbsp;</a>';
				if(_options.has_image){
					$(_img).after(_link);
				}else{
					$(that).prepend(_link);
				}	
                
				var _target = $(this).find("span").eq(0).attr("id", "toolt_" + _id).addClass(_options.target_class_off);

                $(this).find("a").eq(0)
                .bind("mostra", function(){
                    //console.log(_target);
                    _target.removeClass(_options.target_class_off).addClass(_options.target_class_on);
                })
                .bind("nascondi", function(){
                    //console.log(_target);
                    _target.removeClass(_options.target_class_on).addClass(_options.target_class_off);
                })
                .bind("mytoggle", function(){
                    if(_target.hasClass(_options.target_class_off)){
                         $(this).trigger("mostra");
                    }else{
                         $(this).trigger("nascondi");
                    }
                })
                .click(function(){
                    $(this).trigger("mytoggle");
                    return false;
                })
                .hover(
                    function(){
                        $(this).trigger("mostra");

                    },
                    function(){
                        $(this).trigger("nascondi");
                    }
                );
                
            }
          
        });
	},
	init: function() {
		$("span.txt_errore", this).tooltip();
		$("span.txtTooltip", this).tooltip({has_image : false, target_class_on : 'txt_visibile', target_class_off : 'txt_invisibile', link_class : 'link_txt'});
		$("span.txtError", this).tooltip({img_class : 'imError'});
		$("span.txtWarning", this).tooltip({img_class : 'imWarning', link_class : 'link_warning'});
	}
};

$.fn.tooltip = jQTooltip.Tooltip.build;
$.fn.tooltip_init = jQTooltip.Tooltip.init;


////////////////////////////////////////////////////////////////////////////////
//*********** AUTOLOAD *********************************************************
////////////////////////////////////////////////////////////////////////////////
$(document).ready(function(){
//	jQuery(this).tooltip_init();
});

})(jQuery);
