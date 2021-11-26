/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.model.view.state;


import java.io.Serializable;

import it.csi.taif.taifweb.presentation.model.view.ViewElement;

public class ElementState implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean visible;
	private Boolean enabled;
	private ViewElement viewElement;

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public ViewElement getViewElement() {
		return viewElement;
	}

	public void setViewElement(ViewElement viewElement) {
		this.viewElement = viewElement;
	}

	

}
