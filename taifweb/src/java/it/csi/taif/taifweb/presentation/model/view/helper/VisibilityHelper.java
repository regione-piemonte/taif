/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.model.view.helper;


import java.util.ArrayList;
import java.util.Map;

import it.csi.taif.taifweb.dto.BaseSessionAwareDTO;
import it.csi.taif.taifweb.presentation.taifweb.action.ActivateMultiPanelItemCommand;
import it.csi.taif.taifweb.presentation.taifweb.action.BaseAction;
import it.csi.taif.taifweb.presentation.taifweb.action.CommandExecutionException;
import it.csi.taif.taifweb.presentation.taifweb.action.OnOffCommand;
import it.csi.taif.taifweb.presentation.taifweb.action.VisibilityCommand;
import it.csi.taif.taifweb.util.action.BaseActionAdapter;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public final class VisibilityHelper {

    /**
     * {@link BaseActionAdapter} instance, used to pass a <code>session</code> reference to commands.
     */
    private final BaseAction<BaseSessionAwareDTO> action;

    /**
     *
     * @param theModel
     * @param cpname
     * @return
     */
    public static VisibilityHelper of(BaseSessionAwareDTO theModel, String cpname) {
        return new VisibilityHelper(theModel, cpname);
    }

    /**
     *
     * @param targetsWidgets
     * @return
     * @throws CommandExecutionException
     */
    public VisibilityHelper show(String... targetsWidgets) throws CommandExecutionException {
        return this.setVisibility(true, targetsWidgets);
    }

    /**
     *
     * @param targetsWidgets
     * @return
     * @throws CommandExecutionException
     */
    public VisibilityHelper hide(String... targetsWidgets) throws CommandExecutionException {
        return this.setVisibility(false, targetsWidgets);
    }

    /**
     *
     * @param targetsWidgets
     * @return
     * @throws CommandExecutionException
     */
    public VisibilityHelper on(String... targetsWidgets) throws CommandExecutionException {
        return this.setOnOff(true, targetsWidgets);
    }

    /**
     *
     * @param targetsWidgets
     * @return
     * @throws CommandExecutionException
     */
    public VisibilityHelper off(String... targetsWidgets) throws CommandExecutionException {
        return this.setOnOff(false, targetsWidgets);
    }

    /**
     *
     * @param show
     * @param targetsWidgets
     * @return
     * @throws CommandExecutionException
     */
    public VisibilityHelper setVisibility(boolean show, String... targetsWidgets) throws CommandExecutionException {
        VisibilityCommand vc = new VisibilityCommand(targetsWidgets, show);
        vc.doCommand(this.action);

        return this;
    }
    
    public VisibilityHelper setVisibility(boolean show, ArrayList<String> targetsWidgets) throws CommandExecutionException {
        return setVisibility(show,  targetsWidgets.toArray(new String[targetsWidgets.size()]));
    }

    /**
     *
     * @param show
     * @param targetsWidgets
     * @return
     * @throws CommandExecutionException
     */
    public VisibilityHelper setOnOff(boolean show, String... targetsWidgets) throws CommandExecutionException {
        OnOffCommand onOff = new OnOffCommand(targetsWidgets, show);
        onOff.doCommand(this.action);

        return this;
    }
    
    public VisibilityHelper setOnOff(boolean show, ArrayList<String> targetsWidgets) throws CommandExecutionException {
    	return setOnOff(show, targetsWidgets.toArray(new String[targetsWidgets.size()]));
    }
    
    public VisibilityHelper activateMultipanel(String cpname, String mpname, String fpname)throws CommandExecutionException{
    	
    	ActivateMultiPanelItemCommand activate = new ActivateMultiPanelItemCommand(cpname, mpname, fpname);
    	activate.doCommand(this.action);
    	
    	return this;
    }
    
    public VisibilityHelper deactivateMultipanel(String cpname, String mpname)throws CommandExecutionException{
    	
    	return activateMultipanel(cpname, mpname, null);
    }
    
    /**
     * Constructor.
     *
     * @param theModel
     * @param cpname
     */
    private VisibilityHelper(BaseSessionAwareDTO theModel, String cpname) {
        

        @SuppressWarnings("unchecked")
        Map<String, Object> session = theModel.getSession();

        this.action = new BaseActionAdapter(cpname);
        this.action.setSession(session);
    }
    
    
}
