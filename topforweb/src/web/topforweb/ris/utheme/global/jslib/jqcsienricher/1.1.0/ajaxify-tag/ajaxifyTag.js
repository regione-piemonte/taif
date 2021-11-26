#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
/*****************************************
 * jqcsienricher v. 1.1.0 - ajaxifyTag   *
 *****************************************/


var old_value_combobox = ""; // --> variabile che contiene il valore
// dell'ultimo combobox su cui e' andato il focus
var old_name_combobox = ""; // --> variabile che contiene il nome dell'ultimo
// combobox su cui e' andato il focus
var is_onclick_combobox = false; // --> variabile che indica se si ? premuto
// col mouse sulla combobox su cui si ha il
// focus
/**
 * imposto a false la variabile che mi indica se devo mostrare la finestra di
 * attesa
 */
var isLoadingBoxMdd = true;
$.support.cors = true;
/**
 * reperimento path file corrente
 * @param {String} filename
 * @return {String}
 */
var getCurrentPathFile = function(filename){
	var i, a, links = document.getElementsByTagName("script"), len = links.length;
    for (i = 0; i < len; i++) {
        a = links[i];
        var pathFile = a.getAttribute("src");
        if (pathFile.indexOf(filename) != -1) {
            return pathFile.substring(0, pathFile.indexOf(filename));
        }
    }
}



/**
 * mostro la maschera di attesa. STDMDD-764: su IE l'evento beforeunload non e' affidabile
 * (scatta piu' volte => disattivo)
 */
window.onbeforeunload = function() {

	if (isLoadingBoxMdd  && !OOJS.isIE) {
		showLoadBox();
	}

	isLoadingBoxMdd = true;
}

/**
 * disabilito la maschera di attesa se sto cliccando sui link di export della
 * displaytag
 */
document.onclick = function(event) {
	if (window.event) {
		event = window.event;
	}

	var el = event.srcElement || event.target;

	var tag = el.tagName;
	var cssClass = el.className;

	if ((tag == 'span' || tag == 'SPAN')
			&& (cssClass == 'pdf' || cssClass == 'xls')) {
		isLoadingBoxMdd = false;
	} else if ((tag == 'input' || tag == 'INPUT')
			&& (cssClass.indexOf('showHelp') != -1 || cssClass
					.indexOf('showReport') != -1)) {
		isLoadingBoxMdd = false;
	}

}

function showLoadBox() {	 
        $.blockUI({ message: '<h1> Elaborazione in corso...</h1>' }); 
}

function hideLoadBox() {
		$.unblockUI();
}

/**
 * estrae l'id della pagina preso dal commento pageId della risposta
 * 
 * @param {String}
 *            fragment. 
 * @return {String} Restituisce la stringa dialogPanel se non trova il
 *            pageId.
 */
function getResponsePageId(fragment) {
	/*
	 * se non ho il page id allora sono in un dialogpanel
	 */
	if (fragment.indexOf('<!-- pageId:') == -1) {
		return 'dialogPanel';
	}
	var idStartIdx = fragment.indexOf('<!-- pageId:') + 12;
	var idEndIdx = fragment.indexOf(' -->', idStartIdx);
	return fragment.substring(idStartIdx, idEndIdx);
}

/**
 * estrae l'id dell'appmodule preso dal commento appmoduleId della risposta
 * (comprensivo del prefisso base/secure)
 * @param {String}
 *            fragment. 
 * @return {String}
 */
function getResponseAppmoduleId(fragment) {
	if (fragment.indexOf('<!-- appmoduleId:') == -1){
		return null;
	}
	var idStartIdx = fragment.indexOf('<!-- appmoduleId:') + 17;
	var idEndIdx = fragment.indexOf(' -->', idStartIdx);
	return fragment.substring(idStartIdx, idEndIdx);
}

/**
 * Restituisce il nome del contesto dell'applicazione
 * (es. http://myserver.mydom.com/myapp/secure/HomePage.do -> myapp)
 * @return
 */
function getCurrentContextPath(){
	var idxOfSecondSlash = location.pathname.indexOf("/",1);
	var path = location.pathname.substring(1,idxOfSecondSlash);
	return path;
}

/**
 * lancia l'evento di success sul callback
 * 
 * @param {String}
 *            response
 * @param {Object}
 *            opts
 * @param {String}
 *            id
 * @param {String}
 *            pageId
 */
function runSuccessAction(response, opts, id, pageId) {
	// var fragment = response.responseText;
	var fragment = response;

	var responsePageId = getResponsePageId(fragment);
	var responseAppmoduleId = getResponseAppmoduleId(fragment);

	if (responsePageId == 'dialogPanel') {
		// per un dialogPanel rimpiazzare l'intera form
		replaceForm(fragment);

	} else if (pageId != null
			&& fragment.indexOf('<!-- pageId:' + pageId + ' -->') == -1) {		
		var targetPageAction = "/" + getCurrentContextPath() + "/";
		if (fragment.indexOf('<!-- pageUrl:') == -1) {
			if (responseAppmoduleId != null)
				targetPageAction = targetPageAction + responseAppmoduleId + "/";
			targetPageAction = targetPageAction + responsePageId + '.do'
		} else {
			var numIn = fragment.indexOf('<!-- pageUrl:');
			var numFin = fragment.indexOf(':endpageUrl -->');
			numIn += 13;
			var lengthStr = numFin - numIn;
			targetPageAction = fragment.substr(numIn, lengthStr);
		}
		document.forms[0].action = targetPageAction;
		document.forms[0].submit();
	} else {
		// stessa pagina => rimpiazzare i frammenti
		replaceFragments(pageId, id, fragment);
	}

	hideLoadBox();
}

/**
 * 
 * @param targetContent la pagina completa d acui prendere la nuova form
 */
function replaceForm(targetContent){
	var fragment = targetContent;
	// devo tagliare su form e non su body perche' l'esecuzione dei google
	// analytics
	// blocca tutto!
	var idxOfForm = fragment.indexOf('<form');
	var idxOfEndForm = fragment.indexOf('</form>'); // memorizzo il dato in
													// una variabile per
													// poter controllarne il
													// valore in fase di
													// debug
	var fragm = fragment;
	if (idxOfForm >= 0) { /* STDMDD-830 */

		/* STDMDD-914 */
		if (idxOfEndForm >= 0 && idxOfEndForm > idxOfForm) // substring
															// esatta solo
															// se la end
															// esiste ed e'
															// maggiore
															// dello start
			fragm = fragment.substring(idxOfForm + 6, idxOfEndForm);
		else
			fragm = fragment.substring(idxOfForm + 6); // non imposto la
														// end e substringo
														// fino alla fine
														// del frammento

	}
	var frammento = $("form");
	frammento.children().replaceWith("<form " + fragm);	
	
}


/**
 * Cerca nella pagina target i marcatori "<!-- startFragment..." e "<!-- endFragment..."
 * che sono interni ai tag <div> associati a quell'elemento. poi cerca per id il
 * div corrispondente nel dom della pagina originale e lo rimpiazza con il nuovo contenuto
 * (che per completezza dovrebbe contenere anche i marcatori)
 * @param pageId id della pagina corrente
 * @param idList lista degli id dei frammenti da rimpiazzare
 * @param targetDocument la pagina d acui ritagliare i nuovi frammenti
 */
function replaceFragments(pageId, idList, targetDocument){
	var idSplit = idList instanceof Array ? idList : idList.split(',');
	for (var i = 0; i < idSplit.length; i++) {
		var startMark = '<!-- startFragment:' + idSplit[i] + ' -->';
		var endMark = '<!-- endFragment:' + idSplit[i] + ' -->';
		var startIdx = targetDocument.indexOf(startMark);
		startIdx = startIdx + startMark.length;
		var endIdx = targetDocument.indexOf(endMark)
		var fragm = ""+targetDocument
				.substring(startIdx, endIdx).trim();
		var frammento = $('#'+idSplit[i]);
		var replacedFragm = null;
		if (frammento != null){
			frammento.empty();
			replacedFragm = frammento.append(fragm);
		}
	}

	// riapplica gli arricchimenti del frammento
	if (uiEnricherMgr != undefined) {
		try {
			uiEnricherMgr.apply(pageId, idSplit);
		} catch (e) {
			// ***oggetto non trovato
		}
	}	
}



function runFailureAction(response, opts) {
	var messaggio = "";
	if (response.status == '304') {
		messaggio = "Impossibile eseguire l'operazione";
	} else if (response.status == '200') {
		var testo = response.responseText;
		if (testo.indexOf('application-error-msg-ext') != -1) {
			messaggio = testo.substring(testo
							.indexOf('<div id="application-error-msg-ext">')
							+ 36, testo.indexOf('</div>'));
		} else {
			return; // Do nothing
		}
	} else if (response.status == '401') {
		messaggio = "Autenticazione richiesta - Bisogna autenticarsi";
	} else if (response.status == '302') {
		messaggio = "Sessione scaduta";
	} else if (response.status == '500') {
		messaggio = "Si &egrave; verificato un errore applicativo.";
	} else {
		messaggio = "Si &egrave; verificato un problema generico";
	}
	alert(messaggio);
}

/**
 * @deprecated mantenuta solo per retrocompatib. con ajaxifytag
 * @param id lista degli id da refreshare
 * @param url
 * @param parameters non utilizzato
 * @param pageId
 */
function updateAjaxCallback(id, url, parameters, pageId) {
	var formName = ""; // non usatoin realta'
	xmlhttpPost(url, formName, id, pageId, 'Attendere...');
}


function serializeAllFormParameters(){
	return $( "form" ).serialize();
}

function xmlhttpPost(strURL, formname, id, pageId, responsemsg) {
	
	$.ajax({
		url : strURL,
		type : 'POST',
		beforereSend : showLoadBox(),
		complete: function (xhr,textStatus) {
			   hideLoadBox();
		},
		error: function (xhr,textStatus, exception) {
			   if (xhr.status == 302) {
					  var goToLoc = xhr.getResponseHeader("Location");
					  if (goToLoc != null)
				      location.href = goToLoc;
			   }
		},
		traditional: true, // parametri serializzati standard
		asynch:true,
		dataType:'html',
		crossDomain:true,
		data: serializeAllFormParameters(), // per passare tutti i parametri
		success : function(data, testStatus, jqXHR) {
			runSuccessAction(data, null, id, pageId);
		},
		failure : function(jqXHR, textStatus, errorThrown) {
			runFailureAction(response, opts);
		}
	});
}

// event handler RadioButtons
function onRBClickAjax(id, requestUri, parameters, pageId, formName) {
	xmlhttpPost(requestUri, formName, id, pageId, 'Attendere...');
}

// --> funzione che viene eseguita al click sul combobox
function onCBClickAjax(oggetto, id, requestUri, parameters, pageId, formName) {
	// controllo se ? gi? stato premuto il tasto del mouse
	if (is_onclick_combobox == true) {
		// mi comporto come se la combobox perda il fuoco
		is_onclick_combobox = false;
		// UpdateAjaxCallback(id, url, parameters, pageId) [MA]
		xmlhttpPost(requestUri, formName, id, pageId, 'Attendere...');
		old_value_combobox = oggetto.value;
		old_name_combobox = oggetto.name;
	} else
		// se non ? stato premuto imposto la variabile a true per segnalare la
		// prima pressione
		is_onclick_combobox = true;
}
