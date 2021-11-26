/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper;

import it.csi.csi.wrapper.UserException;
import it.csi.taif.taifweb.business.manager.message.Message;
import it.csi.taif.taifweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.taifweb.business.manager.message.MsgMgr;
import it.csi.taif.taifweb.exception.ServiceException;
import it.csi.taif.taifweb.util.Constants;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * Classe base per gli helper <code>facade</code> ai servizi.
 *
 * @author 71740 (Simone Cornacchia)
 */
public abstract class AbstractServiceHelper {
	
	protected static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".service");


    /**
     * Manager dei messaggi
     */
    protected MsgMgr msgMgr;

    /**
     * @return the msgMgr
     */
    public final MsgMgr getMsgMgr() {
        return this.msgMgr;
    }

    /**
     * @param msgMgr the msgMgr to set
     */
    public final void setMsgMgr(MsgMgr msgMgr) {
        this.msgMgr = msgMgr;
    }

    /**
     * Costruisce e restituisce un'istanza di tipo {@link Message}, opportunamente configurata.<br />
     * I valori forniti in {@code args} vengono sostituiti durante la fase di interpolazione delle variabili del messaggio.
     *
     * @param msgCode codice del messaggio
     * @param args valori da sostituire durante la fase di interpolazione delle variabili del messaggio
     * @return un'istanza di tipo {@link Message}, opportunamente configurata
     */
    protected final Message buildMessage(MsgCodeEnum msgCode, Object... args) {
        final Message message = this.msgMgr.getMessage(msgCode);

        if (ArrayUtils.isNotEmpty(args)) {
            for (final Object arg : args) {
                message.replacePlaceholder(arg == null ? "<NULL>" : arg.toString());
            }
        }

        return message;
    }

    /**
     * Costruisce e restituisce un'istanza di tipo {@link Message}, opportunamente configurata.<br />
     * I valori forniti in {@code args} vengono sostituiti durante la fase di interpolazione delle variabili del messaggio.
     *
     * @param msgCode codice del messaggio
     * @param args valori da sostituire durante la fase di interpolazione delle variabili del messaggio
     * @return un'istanza di tipo {@link Message}, opportunamente configurata
     */
    protected final Message buildMessageFormat(MsgCodeEnum msgCode, Object... args) {
        final Message message = this.msgMgr.getMessage(msgCode);

        message.replaceFormat(args);

        return message;
    }

    /**
     * 
     * @param logger
     * @param e
     * @param code
     * @param errorMessageFormat
     * @return 
     * @throws ServiceException
     */
    protected final ServiceException handleException(Logger logger, Exception e, MsgCodeEnum code, String errorMessageFormat)  {
        return this.handleException(logger, e, e.getMessage(), code, errorMessageFormat);
    }

    /**
     * 
     * @param logger
     * @param e
     * @param code
     * @param errorMessageFormat
     * @return 
     * @throws ServiceException
     */
    protected final ServiceException handleException(Logger logger, UserException e, MsgCodeEnum code, String errorMessageFormat)  {
        final String exceptionMessage = StringUtils.replace(StringEscapeUtils.unescapeHtml4(e.getNestedExcMsg()), "&apos;", "'");

        return this.handleException(logger, e, exceptionMessage, code, errorMessageFormat);
    }

    /**
     * 
     * @param logger
     * @param e
     * @param exceptionMessage
     * @param code
     * @param errorMessageFormat
     * @return 
     * @throws ServiceException
     */
    protected final ServiceException handleException(Logger logger, Exception e, String exceptionMessage, MsgCodeEnum code, String errorMessageFormat) {
        final Message errorMessage = this.buildMessageFormat(code, Constants.ERR_SERV, exceptionMessage);
    
        logger.error(String.format(errorMessageFormat, e.getClass().getName(), errorMessage.getText()), e);
    
        return new ServiceException(e, errorMessage);
    }

    /**
     * Constructor.
     */
    protected AbstractServiceHelper() {
        /* NOP */
    }

}
