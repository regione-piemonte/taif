/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.manager.message;



import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.GenericUtil;

/**
 *
 * @author  1346 (Enrico Fusaro)
 * @author 71740 (Simone Cornacchia)
 */
public final class MsgMgr {

    /**
     * Logger da utilizzare
     */
    private static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager.messaggi");

    /**
     * Nome del file properties dei messaggi di default
     */
    private static final String DEFAULT_FILE_PROPERTIES_NAME = "messages.properties";

    /**
     * Separatore delle informazioni sul messaggio
     */
    private static final String MSG_INFO_SEP = "\\|";

    /**
     * Indice del tipo di messaggio
     */
    private static final int MSG_TYPE_INDEX = 0;

    /**
     * Indice del testo del messaggio
     */
    private static final int MSG_TEXT_INDEX = 1;

    /**
     * Numero di informazioni associate ad un messaggio
     */
    private static final int MSG_INFO_COUNT = 2;

    /**
     * Lista dei messaggi
     */
    private Map<MsgCodeEnum, Message> messagesList = null;

    /**
     * Nome del file properties da caricare
     */
    private String filePropertiesName = null;

    /**
     * Constructor.
     *
     * Inizializza un'istanza della classe.
     */
    public MsgMgr() {
        this(DEFAULT_FILE_PROPERTIES_NAME);
    }

    /**
     * Constructor.
     *
     * Inizializza un'istanza della classe.
     *
     * @param filePropertiesName Nome del file properties da caricare
     */
    public MsgMgr(String filePropertiesName) {
        this.filePropertiesName = filePropertiesName;
    }

    /**
     * Inizializza la lista dei messaggi
     */
    private void init() {
        if (this.messagesList == null) {
            this.messagesList = new Hashtable<MsgCodeEnum, Message>();

            final Properties props = new Properties();
            try {
                LOG.debug("filePropertiesName --> " + this.filePropertiesName);

                final InputStream is = GenericUtil.getFileInClassPath(this.filePropertiesName);

                props.load(is);

                this.buildMessages(props);
            } catch(IOException e) {
                // Non dovrebbe verificarsi mai
                LOG.error("Errore durante la lettura del file properties " + filePropertiesName, e);
            }
        }
    }

    /**
     * Restituisce il numero di messaggi disponibili
     *
     * @return Numero di messaggi disponibili
     */
    public int getCount() {
        this.init();

        return this.messagesList.size();
    }

    /**
     * Restituisce il messaggio ad un codice d'errore
     *
     * @param code Codice d'errore
     * @return Messaggio associato al codice d'errore
     */
    public Message getMessage(MsgCodeEnum code) {
        this.init();

        return (Message) this.messagesList.get(code).clone();
    }

    /**
     * Verifica del manager
     */
    public void test() {
        LOG.debug("MessageManager RAGGIUNTO CORRETTAMENTE");
    }

    /**
     * Imposta il nome del file properties da caricare
     *
     * @param filePropertiesName Nome del file properties da caricare
     */
    public void setFilePropertiesName(String filePropertiesName) {
        this.filePropertiesName = filePropertiesName;

        this.messagesList = null;
    }

    /**
     * Restituisce il nome del file properties da caricare
     *
     * @return Nome del file properties da caricare
     */
    public String getFilePropertiesName() {
        return this.filePropertiesName;
    }

    /**
     *
     * @param props
     */
    private void buildMessages(Properties props) {
        MsgCodeEnum msgCode = null;
        MsgTypeEnum msgType = null;
        Message message = null;
        String msgText = null;
        String[] infoMsg = null;
        String propValue = null;

        for (final Object key : props.keySet()) {
            try {
                propValue = props.getProperty(key.toString());

                infoMsg = propValue.split(MSG_INFO_SEP, -1);

                if (infoMsg.length == MSG_INFO_COUNT) {
                    msgCode = MsgCodeEnum.valueOf(key.toString().toUpperCase());
                    msgType = MsgTypeEnum.valueOf(infoMsg[MSG_TYPE_INDEX].toUpperCase());
                    msgText = infoMsg[MSG_TEXT_INDEX];

                    message = new Message(msgCode, msgType, msgText);

                    this.messagesList.put(msgCode, message);
                } else {
                    LOG.error("Messaggio con un numero di campi errati: " + propValue);
                }
            } catch(Exception e) {
                LOG.error("Messaggio con valori errati: " + propValue, e);
            }
        }
    }

}
