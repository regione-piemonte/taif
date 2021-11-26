/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.geojson.jackson;

/**
 * Utility class.<p>
 * Contains utility operations used mailny in the context of <code>GeoJSON</code> Serialization/Deserialization.
 * 
 * @author 71740 (Simone Cornacchia)
 */
final class Utils {

    /**
     * Lookup array for powers of ten.
     */
    private static final long[] POW10 = {
        1, 
        10, 
        100, 
        1000, 
        10000, 
        100000, 
        1000000, 
        10000000, 
        100000000, 
        1000000000
    };

    /**
     * A "round up" constant value.
     */
    private static final double ROUND_UP = 0.5D;

    /**
     * "Converts" a double value to its string representation, in a much more efficient way then {@link Double#toString()}
     *
     * @param v the double value to "convert" to its string representation
     * @param precision the precision to use during conversion
     * @return the "converted" double
     * @see http://stackoverflow.com/questions/10553710/fast-double-to-string-conversion-with-given-precision
     * @see LngLatAltSerializer#serialize(it.csi.sipra.sipraweb.util.geojson.LngLatAlt, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
     */
    static String fastDoubleToString(double val, int precision) {
        double v = val;

        final StringBuilder sb = new StringBuilder();
        if (v < 0) {
            sb.append('-');

            v = -v;
        }

        final long exp  = POW10[precision];
        final long lval = (long) (v * exp + ROUND_UP);
        sb.append(lval / exp).append('.');

        final long fval = lval % exp;
        for (int p = precision - 1; p > 0 && fval < POW10[p] && fval > 0; p--) {
            sb.append('0');
        }
        sb.append(fval);

        int i = sb.length() - 1;
        while (sb.charAt(i) == '0' && sb.charAt(i - 1) != '.') {
            sb.deleteCharAt(i);

            i--;
        }

        return sb.toString();
    }

    /**
     * Constructor.
     */
    private Utils() {
        /* NOP */
    }

}
