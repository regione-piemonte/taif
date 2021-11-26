/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.action;

import org.apache.commons.lang3.StringUtils;

import it.csi.taif.taifweb.dto.BaseSessionAwareDTO;
import it.csi.taif.taifweb.presentation.taifweb.action.BaseAction;
import it.csi.taif.taifweb.presentation.taifweb.action.CommandExecutionException;
import it.csi.taif.taifweb.presentation.taifweb.action.ICommand;


/**
 * A {@link BaseAction} adapter, which proudly does nothing at all but implement
 * empty (and immodifiable) superclass method stubs :-)
 *
 * @author 71740 (Simone Cornacchia)
 */
public class BaseActionAdapter extends BaseAction<BaseSessionAwareDTO> {

    private static final long serialVersionUID = -5490197699019522547L;
    
    /**
     * Nome del Content Panel.
     */
    private final String cpname;
    
    /**
     * Constructor.
     */
    public BaseActionAdapter() {
    	this(StringUtils.EMPTY);
    }

    /**
     * Constructor.
     *
     * @param cpname nome del Content Panel
     */
    public BaseActionAdapter(String cpname) {
    	this.cpname = cpname;
	}


    /* (non-Javadoc)
     * @see it.csi.sipra.sipraweb.presentation.sipraweb.action.BaseAction#modelClass()
     */
    @Override
    public final Class<?> modelClass() {
        return null;
    }

    /* (non-Javadoc)
     * @see it.csi.sipra.sipraweb.presentation.sipraweb.action.BaseAction#getModel()
     */
    @Override
    public final BaseSessionAwareDTO getModel() {
        return null;
    }

    /* (non-Javadoc)
     * @see it.csi.sipra.sipraweb.presentation.sipraweb.action.BaseAction#setModel(it.csi.sipra.sipraweb.dto.BaseSessionAwareDTO)
     */
    @Override
    public final void setModel(BaseSessionAwareDTO t) {
        /* NOP */
    }

    /* (non-Javadoc)
     * @see it.csi.sipra.sipraweb.presentation.sipraweb.action.BaseAction#dumpModel(boolean)
     */
    @Override
    protected final void dumpModel(boolean pre) {
        /* NOP */
    }

    /* (non-Javadoc)
     * @see it.csi.sipra.sipraweb.presentation.sipraweb.action.BaseAction#doBeforeEventCommand()
     */
    @Override
    protected final void doBeforeEventCommand() throws CommandExecutionException {
        /* NOP */
    }

    /* (non-Javadoc)
     * @see it.csi.sipra.sipraweb.presentation.sipraweb.action.BaseAction#doAfterEventCommand()
     */
    @Override
    protected final void doAfterEventCommand() throws CommandExecutionException {
        /* NOP */
    }

   

    /* (non-Javadoc)
     * @see it.csi.sipra.sipraweb.presentation.sipraweb.action.BaseAction#clearPageScopedAppData(java.lang.String)
     */
    @Override
    public final void clearPageScopedAppData(String targetContentPanelName) {
        /* NOP */
    }

	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}

}
