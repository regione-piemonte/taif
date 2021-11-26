#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/*
 * Copyright (c) 2008 Massimiliano Balestrieri
 * 
 * @requires jQuery v1.3.2
 * @requires jQuery UI v1.7.2
 * 
 * Copyright (c) 2008 Massimiliano Balestrieri
 * Examples and docs at: http://maxb.net/blog/
 * Licensed GPL licenses:
 * http://www.gnu.org/licenses/gpl.html
 */

;(function($){

var DialogAhah = function(options){
	
	return this.each(function(){
		
		var that = this;
		
		//var _target = that.href;
		var _href = '#';
		
		var _metadata = {};
		
		if($.fn.metadata)
			_metadata = $(that).metadata();
		
		var _options = $.extend({
			chiudi : true,
			modal: false
		}, options, _metadata);
		
		if(this.title)
			_options.title = this.title;

		if (that.tagName.toUpperCase() == "A") {
			_href = that.href;
		}
		if (that.tagName.toUpperCase() == "INPUT" && _options.href != undefined) {
			_href = _options.href;
		}
		
		if(_href.indexOf("#") !== -1 && !_options.target){
			_options.target = "#" + this.href.split("#")[1]; 
			_options.type = 'inline';
		}
		if(_options.modal){
			_options.overlay = { opacity: 0.5,background: "black"  };
		}
		//disabilitare il resize?
		var _ie6 = false; //typeof document.body.style.maxHeight === "undefined";
        if(_ie6)
			_options.resizable = false;
		
		//console.log(_options);
		function _close(){
	       $("#ahah").remove();
	       $(".ui-dialog").remove();
	       $("#dialog_target").remove();
		   $('#dialog-print').attr("media", "javascript-print");
	    }
		_options.open = function(ev){
			$('#dialog-print').attr("media", "print");
			if(!_options.chiudi){
				//all'apertura della dialog nascondo il tasto close
				var _t = $(ev.target).parent();
				$('.ui-dialog-titlebar-close', _t).hide();
			}

		};
		var oldHrefTitle = $(that).attr('title');
		if (oldHrefTitle == null)
			oldHrefTitle = "";
		$(that).attr('title', oldHrefTitle + ' - Attenzione: questo link si apre in una nuova finestra');
		//EVENTO
		$(that).click(function(event){
			
			// stop propagation (blocca handler nativi)
			event.stopPropagation();
			
			//INLINE
			if (_options.target && _options.type == 'inline') {
				_options.close = function(){
					$('#dialog-print').attr("media", "javascript-print");
				};
				
				var _clone = $(_options.target).clone();
				$("body").append(_clone);
				_clone.dialog(_options).show();
			}
			else {
				_options.close = _close;
				$.ajax({
					url: _href,
					dataType: 'html',
					success: function(data){
						var re = /<body([\S\s]*)>([\S\s]*)<\/body>/;
						var _d = data.match(re);
						
						var _html = _d && _d[0] ? _d[0] : data;
						_html = _html.replace(/<script[\s\S]*script>/ig, '');
						
						//RIMUOVIAMO ALTRE DIALOG
						$("#ahah, #dialog_target, .ui-dialog").remove();
						
						var _ahah = $('<div id="ahah" style="display:none"></div>');
						$("body").append(_ahah);//+_d[0]+'
						_ahah.append(_html);
						
						var _dialog = $("#ahah").find("#dialog_target");
						//console.log(_dialog);
						//console.log(_ahah);
						if (_dialog.length == 0) {
							_dialog = _ahah;
						}
						if(_options.load)
							_options.load(_dialog);
						
						_dialog
						.dialog(_options)
						//.trigger("ready")//BETA
						.show()
						;
					}
				});
			}
			return false;
		});//evento
	
	});//each

};

$.fn.dialogahah = DialogAhah;
	
////////////////////////////////////////////////////////////////////////////////
//*********** DIALOGAHAH AUTOLOAD **********************************************
////////////////////////////////////////////////////////////////////////////////

//$('link[media="javascript-screen"]').attr("media", "screen");
//$('#dialog-print').attr("media", "javascript");

$(document).ready(function(){
	$("a.dialog").dialogahah();	
	
	$('div.dialog').dialogahah({
        title : this.title
    });
});

})(jQuery);
