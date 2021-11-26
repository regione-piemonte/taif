/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.manager.validation;



import java.util.List;

import org.apache.log4j.Logger;

import it.csi.taif.topforweb.business.manager.message.Message;
import it.csi.taif.topforweb.dto.ExecResults;
import it.csi.taif.topforweb.exception.ManagerException;
import it.csi.taif.topforweb.util.Constants;

/**
 *
 * @author 71740 (Simone Cornacchia)
 */
public final class Validator {

    /**
     * Logger da utilizzare.
     */
    private static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);

    /**
     * Risultato della valutazione con successo.
     */
    public static final String OK = "Ok";

    /**
     * Risultato della valutazione con errore.
     */
    public static final String KO = "Ko";

    /**
     * Segnala i campi che risultano errati.
     *
     * @param result Result in cui segnalare i campi
     * @param e Eccezione che contiene i campi errati
     */
    private static void segnalaCampiErrati(ExecResults result, ManagerException e) {
        LOG.debug("DIMENSIONE ERRORI --> " + e.getMapField().size());

        result.getFldErrors().putAll(e.getMapField());
    }

    /**
     * Gestisce l'eccezione impostando opportunamente l'oggetto result.
     *
     * @param result Result da impostare
     * @param e Eccezione sollevata
     */
    public static void gestisciEccezione(ExecResults result, ManagerException e) {
        gestisciEccezione(result, e, KO);
    }

    /**
     * Gestisce l'eccezione impostando opportunamente l'oggetto result.
     *
     * @param result Result da impostare
     * @param e Eccezione sollevata
     * @param resultCode
     */
    public static void gestisciEccezione(ExecResults result, ManagerException e, String resultCode) {
        segnalaCampiErrati(result, e);

        final List<Message> messageList = e.getMessageList();
        if (messageList != null) {
            for (final Message m : messageList) {
                gestisciEccezione(result, m);
            }
        }

        result.setResultCode(resultCode);
    }

    /**
     *
     * @param result
     * @param m
     */
    private static void gestisciEccezione(ExecResults result, Message m) {
        if (m != null) {
            if (m.isErrorMessage()) {
              
                result.getGlobalErrors().add(m.getText());
            }

            if (m.isInfoMessage()) {
                
                result.getGlobalMessages().add(m.getText());
            }
        }
    }

    /**
     * Constructor.
     */
    private Validator() {
        /* NOP */
    }

}
