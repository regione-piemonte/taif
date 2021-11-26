/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.tika.Tika;

import it.csi.taif.taifweb.business.common.LanguageEnum;


/**
 *
 * @author  1312 (Francesca Morelli)
 * @author  1346 (Enrico Fusaro)
 * @author 71740 (Simone Cornacchia)
 */
public class GenericUtil {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".util");

    /**
     * <em>No Arguments</em> method invokation placeholder.
     */
    private static final Object[] NO_ARGS = new Object[0];

    /**
     *
     * @param aVO
     * @param useLog4J
     */
    public static void stampaVO(Object aVO, boolean useLog4J) {
        if (useLog4J) {
            LOGGER.info("*********************************************");
        }
        else {
        	System.out.println("*********************************************");
        }

        if (aVO != null) {
            final Method[] meth = aVO.getClass().getMethods();
            for (int i = 0; i < meth.length; i++) {
                final Method thisM = meth[i];
                if (thisM.getName().startsWith("get") && ! "get".equals(thisM.getName())) {
                    try {
                        if (useLog4J) {
                            LOGGER.info(" Nome: " + thisM.getName() + " == *" + thisM.invoke(aVO) + "*");
                        }
                        else {
                        	System.out.println(" Nome: " + thisM.getName() + " == *" + thisM.invoke(aVO) + "*");
                        }
                    } catch (IllegalArgumentException e) {
                        //LOGGER.error(e.getMessage(), e);
                    } catch (IllegalAccessException e) {
                       // LOGGER.error(e.getMessage(), e);
                    } catch (InvocationTargetException e) {
                        //LOGGER.error(e.getMessage(), e);
                    }
                }
            }
        }
    }

    /**
     *
     * @param aVO
     */
    public static void stampaVO(Object aVO) {
        stampaVO(aVO, false);
    }

    /**
     *
     * @param s
     * @return
     */
    public static String replacePointWihtComma(String s) {
        return s == null ? null : s.replace(".", ",");
    }

    /**
     * Recupera l'input stream associato ad un file contenuto nel class path
     *
     * @param fileName Nome del file
     * @return Input stream associato al file
     */
    public static InputStream getFileInClassPath(String fileName) {
        return GenericUtil.class.getClassLoader().getResourceAsStream(fileName);
    }

    /**
     *
     * @param string
     * @param regex
     * @return
     */
    public static boolean stringMatches(String string, String regex) {
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        return matcher.matches();
    }

    /**
     * Normalizza una stringa
     *
     * @param s Stringa da normalizzare
     * @return Stringa normalizzata
     */
    public static String normalizeNull(String s) {
        return s == null ? " " : s;
    }

    /**
     *
     * @param is
     * @return
     */
    public static String toString(ByteArrayInputStream is) {
        try {
            final int size = is.available();

            LOGGER.info("[GenericUtil::toString] size:" + size);

            final byte[] bytes = new byte[size];

            is.read(bytes, 0, size);

            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.info("[GenericUtil::toString] ERROR: " + e.getMessage(), e);

            return null;
        }
    }

    /**
     * Restituisce la stringa <em>normalizzata</em>, cio&egrave; con eventuali lettere accentate
     * sostituite dalle equivalenti prive di accento.
     *
     * @param nomeFile la stringa da normalizzare
     * @return la stringa <em>normalizzata</em>, cio&egrave; con eventuali lettere accentate
     *         sostituite dalle equivalenti prive di accento
     */
    public static String getNomeNormalizzato(String nomeFile) {
        //final String temp = Normalizer.normalize(nomeFile, Normalizer.Form.NFD);
    	final String temp = org.apache.commons.lang3.StringUtils.stripAccents(nomeFile);

        return temp.replaceAll("\\p{M}", "");
    }
    
    
    public static String getTracciatoFromSoggettoGestore(String idSoggettoGestore) {
    	int id = Integer.parseInt(idSoggettoGestore);
		String tracciato = null;
		switch (id) {
		case 1:
		case 2:
		case 3:
			tracciato = Constants.TRACCIATO_IT;
			break;
		case 4:
		case 5:
			tracciato = Constants.TRACCIATO_FR;
			break;
		default:
			tracciato = Constants.TRACCIATO_IT;
			break;
		}
		return tracciato;
    }
    
    public static boolean getBooleanFromString(String s) {
    	if(Constants.FLAG_SI.equals(s)) {
    		return true;
    	}
    	return false;
    }

    /**
     * Constructor.
     */
    protected GenericUtil() {
        /* NOP */
    }

	public static String getLinguaFromLocale(Locale locale) {
		String result = null;
		String language = locale.getLanguage();
		LanguageEnum langEnum = LanguageEnum.getByLingua(language);
		switch (langEnum) {
		case LANGUAGE_FR:
			result = it.csi.taif.taifweb.business.dao.util.Constants.fLang;
			break;
		case LANGUAGE_IT:
			result = it.csi.taif.taifweb.business.dao.util.Constants.iLang;
			break;
		default:
			result = it.csi.taif.taifweb.business.dao.util.Constants.iLang;
		}
		return result;
	}
	
	
	public static boolean between(int number, int min, int max) {
		if(number<=max && number>=min) {
			return true;
		}
		return false;
	}
	
	public static String getMimeTypeFromFileName(String fileName) {
		Tika tika = new Tika();
		return tika.detect(fileName);
	}
	
	public static String getFileExtension(String fileName) {
		return StringUtils.substringAfterLast(fileName, ".");
		
	}
	
}
