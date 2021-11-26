/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util;
 
import java.util.Comparator;
 
import org.apache.commons.lang3.builder.CompareToBuilder;

import it.csi.taif.topforweb.dto.common.CodeDescription;
 
public class CodeDescriptionComparator implements Comparator<CodeDescription> {
 
    public int compare(CodeDescription o1, CodeDescription o2) {
        return new CompareToBuilder()
                .append(o1.getDescription(), o2.getDescription()).toComparison();
    }
}
