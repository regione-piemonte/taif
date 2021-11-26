#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/*
 * Copyright (c) 2009 Massimiliano Balestrieri
 * 
 * $Date: 2009-12-03 17:02:31 +0100 (gio, 03 dic 2009) $
 * $Rev: 254 $
 * @requires jQuery v1.3.2
 * 
 * Copyright (c) 2008 Massimiliano Balestrieri
 * Examples and docs at: http://maxb.net/blog/
 * Licensed GPL licenses:
 * http://www.gnu.org/licenses/gpl.html
 */
 
(function($){

var YToggle = function(){
	
	//1.2.6 non ha la proprietÃ  core .selector
	//console.log($(this).selector);	
	//console.log(this.selector);	
	return this.each(function(){
		
		//DA COSI'
		//<a href="#" id="toggle_handle_2" class="folder toggle_handle collapse">Altre spese</a>
		
		//A COSI'
		//<a href="#">
		//<a href="#" title="chiudi sezione" class="folder toggle_handle collapse" id="toggle_handle_2">
		//<span class="nascosto">nascondi </span>
		//Altre spese
		//</a>
		//</a>

		//MEGLIO COSI'
		//<a href="#" title="chiudi sezione" id="toggle_handle_2" class="folder toggle_handle collapse">
		//<span class="nascosto">nascondi </span>Altre spese</a>
		
		//console.log(this);
		var that = this;

		var _is_a = $(that).is("a");
		var _state = $(that).is(".collapse");
		var _id = that.id;
		
		var _css_on = 'espandi';
		var _css_off = 'collapse';
		
		var _title_on = 'espandi sezione';
		var _title_off = 'chiudi sezione';
		var _span_title_on = '<span class="collapse">visualizza </span>';
		var _span_title_off = '<span class="espandi">nascondi </span>';
		
		
		var _container = $(this).parents(".toggle_alternate");
		var _is_alternate = _container.length > 0;
		
		//console.log(_is_alternate);
		if (!_is_a) {
			var _classes = $(that).attr("class");
			var _title = _state ? _title_off : _title_on;
			
			//#var _text = $(that).text();
			//#var _handler = $('<a id="'+_id+'" class="'+_classes+'" title="'+_title+'" href="#">'+ _text + '</a>');
			var _handler = $('<a id="' + _id + '" class="' + _classes + '" title="' + _title + '" href="#"></a>');
			
			//console.log(that);
			//console.log(_handler);
			//return;
			//#$(that).empty().removeAttr("class").removeAttr("id").removeAttr("title");
			$(that).removeAttr("class").removeAttr("id").removeAttr("title");
			$(that).wrap(_handler);
		}
		
		if(!_id)
			return;
			
		var _target = _id.split("_").slice(2);//toggle_handle_1 -> 1
		var _css_target = '.toggle_target_' + _target;
		
		if(!_state){
			$(_css_target).hide();
			_bug_select(_css_target, false);
			
			//#$(_handler).prepend(_span_title_on);
			$(that).prepend(_span_title_on);
		}else{
			//#$(_handler).prepend(_span_title_off);
			$(that).prepend(_span_title_off);
		}
		
		var _tobind = _handler ? $(that).parent() : that;
		
		//#$(_handler)
		//console.log(_tobind)
		$(_tobind)
		.bind("apri", function(){
			$(this).find("span.collapse").remove();
			$(this).find("span.espandi").remove();
			$(this).removeClass(_css_on).addClass(_css_off);
			$(this).attr("title", _title_off);
			$(this).prepend(_span_title_off); 
			_state = true;  	
			
			$(_css_target).show();

			_bug_select(_css_target, true);
		})
		.bind("chiudi", function(){
			$(this).find("span.collapse").remove();
			$(this).find("span.espandi").remove();
			$(this).removeClass(_css_off).addClass(_css_on);
			$(this).attr("title", _title_on);
			$(this).prepend(_span_title_on); 
			_state = false; 
			
			$(_css_target).hide();
			
			_bug_select(_css_target, false);
		})
		.bind("mytoggle", function(){

			$(this).find("span.collapse").remove();
			$(this).find("span.espandi").remove();
			!_state ? $(this).removeClass(_css_on).addClass(_css_off) : $(this).removeClass(_css_off).addClass(_css_on);
			!_state ? $(this).attr("title", _title_off) : $(this).attr("title", _title_on);
			!_state ? $(this).prepend(_span_title_off) : $(this).prepend(_span_title_on); 
			_state = !_state;  	
			//console.log(_css_target);
			$(_css_target).toggle(_state);
			
			_bug_select(_css_target, _state);
		})
		.click(function(){
			//avrei usato .selector per rendere dinamico il plugin
			//console.log(_is_alternate)
			if (_is_alternate) {
			//console.log($('.toggle_handle', _container))
				$('.toggle_handle', _container).not(this).trigger("chiudi");
				//#$(_handler).trigger("apri");
				$(_tobind).trigger("apri");
			} else {
				//#$(_handler).trigger("mytoggle");
				$(_tobind).trigger("mytoggle");
			}
			return false;
		});;
		//BUG SELECT
		function _bug_select(el ,flag){
		  if (typeof document.body.style.maxHeight === "undefined") {//if IE 6
			$(el).find("select").toggle(flag);
		  }
		}
	});
};

$.fn.ytoggle = YToggle;	

 
////////////////////////////////////////////////////////////////////////////////
//*********** AUTOLOAD *********************************************************
////////////////////////////////////////////////////////////////////////////////

$(document).ready(function(){
	var handles = $("[id*='toggle']");
	if (handles != null){
		// span: add toggle_handle class
		handles.addClass("toggle_handle");
		handles.addClass("collapse");
		// span: change id toggle_X in toggle_handle_X
		handles.each(function(i,span){
				var inID = span["id"].split('_')[1];
				span["id"]="toggle_handle_"+inID;
				//div: add class toggle_target_X
				$("#"+inID).addClass("toggle_target_"+inID);
			}
		);
		// div: add class toggle_target_X
		handles.ytoggle();
	}
	//$("a.toggle_handle,span.toggle_handle").ytoggle();
});

})(jQuery);
