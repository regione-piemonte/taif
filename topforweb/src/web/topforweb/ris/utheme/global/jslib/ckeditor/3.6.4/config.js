#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
﻿/*
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{	
	config.language = 'it';					// imposto la lingua dell'interfaccia
	config.uiColor = '#CCCCCC';				// imposto il colore di base dell'interfaccia
	//config.width = '800px';				// imposto la larghezza
	//config.height = '280px';				// imposto l'altezza	
	//config.resize_enabled = false;		// nasconde la guida per il resize
	config.removePlugins = 'elementspath';	// nasconde la visualizzazione del DOM nel footer del widget
	
	config.toolbar = 'CSI'; 				// definisco la toolbar con i pulsanti desiderati
	config.toolbar_CSI =
	[
		{ name: 'clipboard', items : [ 'PasteText','PasteFromWord','-','Undo','Redo' ] },
		{ name: 'editing', items : [ 'Find','Replace'] },			
		{ name: 'colors', items : [ 'Font','FontSize' ] },			
		{ name: 'basicstyles', items : [ 'Bold','Italic','Underline','-', 'TextColor','BGColor' ] },
		{ name: 'links', items : [ 'Link','Unlink' ] },
		{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock' ] }		
	];
	
	/*	
		*****************************************
		*** CONFIGURAZIONE ORIGINALE COMPLETA ***
		*****************************************		
		[
			{ name: 'document', items : [ 'Source','-','Save','NewPage','DocProps','Preview','Print','-','Templates' ] },
			{ name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
			{ name: 'editing', items : [ 'Find','Replace','-','SelectAll','-','SpellChecker', 'Scayt' ] },
			{ name: 'forms', items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 
				'HiddenField' ] },
			'/',
			{ name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' ] },
			{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','CreateDiv',
			'-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
			{ name: 'links', items : [ 'Link','Unlink','Anchor' ] },
			{ name: 'insert', items : [ 'Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak','Iframe' ] },
			'/',
			{ name: 'styles', items : [ 'Styles','Format','Font','FontSize' ] },
			{ name: 'colors', items : [ 'TextColor','BGColor' ] },
			{ name: 'tools', items : [ 'Maximize', 'ShowBlocks','-','About' ] }
		]	
	*/
	
};
