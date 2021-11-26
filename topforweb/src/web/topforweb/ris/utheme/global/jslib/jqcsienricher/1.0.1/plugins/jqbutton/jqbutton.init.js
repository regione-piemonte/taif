#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
;(function($){

	$.fn.jbutton_init = function() {
		
		return this.each(function(){
			$("span.close_js",this).jbutton({
				text : 'chiudi', 
				callback : function (el){
					$(el).parents(".ui-dialog-content:eq(0)").dialog("close");
				}
			});
			$("span.print_js",this).jbutton({
				text : 'stampa', 
				callback : function (){
					window.print();
				} 
			});
		});
	};
	
})(jQuery);
