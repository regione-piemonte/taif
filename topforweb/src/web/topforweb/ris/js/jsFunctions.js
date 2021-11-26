#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
///////////////////////////////////////////////////////////////////////////////
//*********** SELECT A CASCATA ************************************************
// Funzione javascript per gestire relazione tra due select
// estratto dal file pulsantiPadreFiglio.js di SISP
////////////////////////////////////////////////////////////////////////////////

/**
 * Variabile che contiene il valore dell'ultimo combobox su cui � andato il
 * focus
 */
var old_value_combobox = "";

/** Variabile che contiene il nome dell'ultimo combobox su cui � andato il focus */
var old_name_combobox = "";

/**
 * Variabile che indica se si � premuto col mouse sulla combobox su cui si ha il
 * focus
 */
var is_onclick_combobox = false;

/**
 * Funzione che viene eseguita all'acquisizione del focus da parte del combobox
 */
function inFocus(oggetto) {
	old_value_combobox = oggetto.value;
	old_name_combobox = oggetto.name;
}

/**
 * Funzione che viene eseguita alla perdita del focus da parte del combobox e
 * simula il comportamento del click sul pulsante submit del form
 */
function lostFocus(oggetto, Submit_name, Submit_value, url) {
	// se l'oggetto che perde il focus � lo stesso di quello per cui ho
	// memorizzato il suo vecchio valore e
	// quest'ultimo � diverso da quello corrente eseguo il submit del form
	if (old_value_combobox != oggetto.value
			&& old_name_combobox == oggetto.name) {
		document.forms[0].action = url + "?" + Submit_name + "=" + Submit_value;
		document.forms[0].submit();
	}
}

/**
 * Funzione che viene eseguita al click sul combobox
 */
function onCBClick(oggetto, Submit_name, Submit_value, url) {
	// controllo se � gi� stato premuto il tasto del mouse
	if (is_onclick_combobox == true) {
		// mi comporto come se la combobox perda il fuoco
		is_onclick_combobox = false;
		lostFocus(oggetto, Submit_name, Submit_value, url)
		old_value_combobox = oggetto.value;
		old_name_combobox = oggetto.name;
	} else {
		// se non � stato premuto imposto la variabile a true per segnalare la
		// prima pressione
		is_onclick_combobox = true;
	}
}

// //////////////////////////////////////////////////////////////////////////////
// *********** RADIOBUTTONS ****************************************************
// Funzione javascript per gestire l'evento di change su un radiobutton
// //////////////////////////////////////////////////////////////////////////////

/**
 * 
 */
function onRBClick(url) {
	document.forms[0].action = url;
	document.forms[0].submit();
}

function copyValue(element1, element2) {
	var n2 = document.getElementById(element2);
	n2.value = element1.value;
}

function changeLanguage(l) {
	var curr_page = window.location.href;
	var index = curr_page.lastIndexOf('?request_locale');
	var c = '?';
	if (index > -1) {
		curr_page = curr_page.substring(0, index);
	} else {
		var index2 = curr_page.lastIndexOf('?');
		if (index2 > -1) {
			c = '&';
		}
	}
	next_page = curr_page + c + 'request_locale=' + l;
	window.location.assign(next_page);
}
