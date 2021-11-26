/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.helper.dto;

import it.csi.taif.topforweb.util.builder.ToStringBuilder;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * <code>DTO</code> delle informazioni definite per il <em>Comune</em>,
 * cos&igrave; come ottenute dall'invocazione al servizio dei <em>Limiti Amministrativi</em>.
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public final class Comune implements Serializable {

    private static final long serialVersionUID = 5502173827646213500L;

    /**
     * <code>Codice</code> <code>ISTAT</code> del <em>Comune</em>.
     */
    private String istat;

    /**
     * <code>Toponimo</code> del <em>Comune</em>.
     */
    private String toponimo;

    /**
     * Constructor.
     */
    public Comune() {
        /* NOP */
    }

    /**
     * Constructor.
     *
     * @param istat il <code>Codice</code> <code>ISTAT</code> del <em>Comune</em>
     * @param toponimo il <code>Toponimo</code> del <em>Comune</em>
     */
    public Comune(String istat, String toponimo) {
        this.istat = istat;
        this.toponimo = toponimo;
    }

    /**
     * Restituisce il <code>Codice</code> <code>ISTAT</code> del <em>Comune</em>.
     *
     * @return the istat il <code>Codice</code> <code>ISTAT</code> del <em>Comune</em>
     */
    public String getIstat() {
        return this.istat;
    }

    /**
     * Imposta il <code>Codice</code> <code>ISTAT</code> del <em>Comune</em>.
     *
     * @param istat il <code>Codice</code> <code>ISTAT</code> del <em>Comune</em>
     */
    public void setIstat(String istat) {
        this.istat = istat;
    }

    /**
     * Restituisce il <code>Toponimo</code> del <em>Comune</em>.
     *
     * @return il <code>Toponimo</code> del <em>Comune</em>
     */
    public String getToponimo() {
        return this.toponimo;
    }

    /**
     * Imposta il <code>Toponimo</code> del <em>Comune</em>.
     *
     * @param toponimo il <code>Toponimo</code> del <em>Comune</em>
     */
    public void setToponimo(String toponimo) {
        this.toponimo = toponimo;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(this.istat)
               .append(this.toponimo);

        return builder.toHashCode();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Comune other = (Comune) obj;

        final EqualsBuilder builder = new EqualsBuilder();
        builder.append(this.istat, other.istat)
               .append(this.toponimo, other.toponimo);

        return builder.isEquals();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.objectToString(this);
    }

}
