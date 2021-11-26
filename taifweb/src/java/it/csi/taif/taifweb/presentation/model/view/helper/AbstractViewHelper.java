/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.model.view.helper;

import it.csi.taif.taifweb.dto.BaseSessionAwareDTO;
import it.csi.taif.taifweb.presentation.model.view.state.ElementState;
import it.csi.taif.taifweb.presentation.model.view.state.ViewState;
import it.csi.taif.taifweb.presentation.taifweb.action.CommandExecutionException;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.GenericUtil;
import it.csi.taif.taifweb.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.api.client.util.Lists;



/**
 * 
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 * @author  1346 (Enrico Fusaro)
 */
public abstract class AbstractViewHelper {

    protected static final <T extends BaseSessionAwareDTO> Map<String, Object> getSession(T theModel) {
        @SuppressWarnings("unchecked")
        final Map<String, Object> session = theModel.getSession();

        return session;
    }

    public static <T extends BaseSessionAwareDTO> ViewState getViewState(T theModel, String viewStateName) {
        ViewState viewState = (ViewState) getSession(theModel).get(viewStateName);

        if (viewState == null) {
            viewState = new ViewState();
            getSession(theModel).put(viewStateName, viewState);
        }

        return viewState;
    }

    public static <T extends BaseSessionAwareDTO> ViewState resetViewState(T theModel, String viewStateName) {
        getSession(theModel).remove(viewStateName);

        return getViewState(theModel, viewStateName);
    }

    protected static final <M extends BaseSessionAwareDTO, ES extends ElementState> void updateView(M theModel, String CPNAME, ES es) throws Exception {
        final String targetWidget = es.getViewElement().getName();
        final Boolean isVisible = es.getVisible();
        final Boolean isEnabled = es.getEnabled();

        if (StringUtils.isBlank(targetWidget)) {
            throw new IllegalArgumentException("widget name cannot be empty");
        }

        if (isVisible != null) {
            VisibilityHelper.of(theModel, CPNAME).setVisibility(isVisible, targetWidget);
        }

        if (isEnabled != null) {
            VisibilityHelper.of(theModel, CPNAME).setOnOff(isEnabled, targetWidget);
        }
    }
    
    protected static final <M extends BaseSessionAwareDTO, CV extends ConfigVisibility> void updateView(M theModel, String CPNAME, CV cv) throws CommandExecutionException  {
        // Clean
        for (String s : cv.getClean()) {
            theModel.getSession().remove(s);
        }
        // Activate
        for (String s: cv.getActivate()){
            String mpname = org.apache.commons.lang3.StringUtils.substringBefore(s, ".");
            String fpname = org.apache.commons.lang3.StringUtils.substringAfter(s, ".");
            VisibilityHelper.of(theModel, CPNAME).activateMultipanel(CPNAME,mpname, fpname);
        }
        // Deactivate
        for(String s: cv.getDeactivate()){
            VisibilityHelper.of(theModel, CPNAME).deactivateMultipanel(CPNAME,s);
        }
        // On
        VisibilityHelper.of(theModel, CPNAME).setOnOff(true, cv.getOn());
        // Off
        VisibilityHelper.of(theModel, CPNAME).setOnOff(false, cv.getOff());
        // Show
        VisibilityHelper.of(theModel, CPNAME).setVisibility(true, cv.getShow());
        // Hide
        VisibilityHelper.of(theModel, CPNAME).setVisibility(false, cv.getHide());
    }

    /**
     * 
     * @param key
     * @param filePropertiesName
     * @return
     */
    public static String[] getValues(String key, String filePropertiesName) {
        final Properties props = new Properties();

        try {
            final InputStream is = GenericUtil.getFileInClassPath(filePropertiesName);
            props.load(is);

            final String[] result = ConvertUtil.toArray(props.getProperty(key), ",");

            return result;
        } catch(IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    /**
     * 
     * @param key
     * @param filePropertiesName
     * @return
     */
    public static ArrayList<String> getValuesList(String key, String filePropertiesName) {
        final Properties props = new Properties();

        try {
            final InputStream is = GenericUtil.getFileInClassPath(filePropertiesName);
            props.load(is);

            final List<String> result = ConvertUtil.toArrayList(props.getProperty(key), ",");

            return Lists.newArrayList(result);
        } catch(IOException e) {
            e.printStackTrace();
            return Lists.newArrayList();
        }
    }

    /**
     * Constructor.
     */
    protected AbstractViewHelper() {
        /* NOP */
    }

}
