/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.dozer.loader.xml.ELEngine;

import bsh.This;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaCorsiExtAltriCorsiDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaDatiIdentificativiOperatoreDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaExtRicercaNumeroAlboForestaleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTQualificaByIdPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTRiconoscimentoByIdPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter;
import it.csi.taif.topforweb.business.manager.TopForMgr;
import it.csi.taif.topforweb.dto.common.CodeDescription;
import it.csi.taif.topforweb.dto.common.UDTWrappedDouble10Decimal;
import it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale;
import it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel;
import it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel;
import it.csi.taif.topforweb.dto.operatore.Operatore;
import it.csi.taif.topforweb.dto.qualifica.Qualifica;
import it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento;
import it.csi.taif.topforweb.exception.ManagerException;

/**
 *
 * @author  1346 (Diego Fusaro)
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public final class ConvertUtil extends GenericUtil {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".util");

    /**
     * Pattern per formattazione data (<code>dd/MM/yyyy</code>).
     */
    public static final String FORMAT_DATE_STANDARD   = "dd/MM/yyyy";

    /**
     * Pattern per formattazione data (<code>dd_MM_yyyy</code>).
     */
    public static final String FORMAT_DATE_UNDERSCORE = "dd_MM_yyyy";

    /**
     * Lista dei formati decimali.
     */
    private static final  Map<Integer, String> DECIMAL_FORMATS = new HashMap<Integer, String>();

    /**
     *
     * @param dt
     * @return
     */
    public static String convertToString(java.util.Date dt) {
        if (dt == null) {
            return null;
        } else {
            final SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_STANDARD, Locale.getDefault());

            return sdf.format(dt);
        }
    }

    /**
     *
     * @param dt
     * @param format
     * @return
     */
    public static String convertToString(java.util.Date dt, String format) {
        if (dt == null) {
            return null;
        } else {
            final SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());

            return sdf.format(dt);
        }
    }

    /**
     *
     * @param s
     * @return
     * @throws Exception
     */
    public static java.util.Date convertToDate(String s) throws Exception {
        if (org.apache.commons.lang3.StringUtils.isEmpty(s)) {
            final SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_STANDARD, Locale.getDefault());
            try {
                final java.util.Date result = sdf.parse(s);

                return result;
            } catch (ParseException e) {
                throw new Exception("Errore nel parsing della data " + s, e);
            }
        } else {
            return null;
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public static Calendar convertToCalendar(String s) {
        Calendar result = null;
        try {
            final java.util.Date date = convertToDate(s);
            if (date != null) {
                result = Calendar.getInstance();
                result.setTime(date);
            }
        } catch (Exception e) {
            LOGGER.error("[ConvertUtil::convertToCalendar] ERROR: " + e.getMessage(), e);

            return null;
        }
        return result;
    }

    /**
     *
     * @param s
     * @return
     */
    public static java.sql.Date convertToSqlDate(String s) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(s)) {
            final SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_STANDARD, Locale.getDefault());
            try {
                return new Date(sdf.parse(s).getTime());
            } catch (ParseException e) {
                LOGGER.error("[ConvertUtil::convertToSqlDate] ERROR: " + e.getMessage(), e);

                return null;
            }
        } else {
            return null;
        }
    }

    /**
     *
     * @param i
     * @return
     */
    public static String convertToString(Integer i) {
        if (i == null) {
            return null;
        } else {
            return Integer.toString(i);
        }
    }

    /**
     *
     * @param i
     * @return
     */
    public static String convertToString(Long i) {
        if (i == null) {
            return null;
        } else {
            return Long.toString(i);
        }
    }

    /**
     *
     * @param i
     * @return
     */
    public static String convertToString(Double i) {
        if (i == null) {
            return null;
        } else {
            return Double.toString(i).replace(".", ",");
        }
    }

    /**
     *
     * @param i
     * @return
     */
    public static String convertToString(Float i) {
        if (i == null) {
            return null;
        } else {
            return Float.toString(i).replace(".", ",");
        }
    }

    /**
     *
     * @param i
     * @return
     */
    public static String convertToString(BigDecimal i) {
        if (i == null) {
            return null;
        } else {
            return i.toString().replace(".", ",");
        }
    }

    /**
     *
     * @param i
     * @return
     */
    public static String convertToStringNoReplace(BigDecimal i) {
        if (i == null) {
            return null;
        } else {
            return i.toString();
        }
    }

    /**
     * Converte un {@link BigDecimal} in stringa
     *
     * @param number Numero da convertire
     * @param decimali Decimali da visualizzare
     * @return Numero convertito
     */
    public static String convertToString(BigDecimal number, int decimali) {
        DecimalFormat formatter = null;
        String format = null;
        String stringValue = null;

        if (number != null) {
            format = getNumberFormat(decimali);
            formatter = new DecimalFormat(format);
            stringValue = formatter.format(number.doubleValue());
        }
        return stringValue;
    }

    /**
     * Restituisce il formato numerico richiesto
     *
     * @param decimali Decimali da visualizzare
     * @return Formato numerico
     */
    private static String getNumberFormat(int decimali) {
        String format = DECIMAL_FORMATS.get(decimali);
        if (format == null) {
            final StringBuilder formatBuilder  = new StringBuilder("#,##0");
            final StringBuilder decimalBuilder = new StringBuilder();

            for (int i = 0; i < decimali; i++) {
                decimalBuilder.append("0");
            }
            if (decimalBuilder.length() > 0) {
                formatBuilder.append(".").append(decimalBuilder);
            }

            format = formatBuilder.toString();

            DECIMAL_FORMATS.put(decimali, format);
        }

        return format;
    }

    /**
     *
     * @param s
     * @return
     */
    public static Integer convertToInteger(String s) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(s)) {
            return null;
        } else {
            try {
                return Integer.parseInt(s);
            } catch (Exception e) {
                LOGGER.error("[ConvertUtil::convertToInteger] ERROR: " + e.getMessage(), e);

                return null;
            }
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public static Double convertToDouble(String s) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(s)) {
            return null;
        } else {
            try {
                return new Double(Double.parseDouble(s.replaceAll(",", ".")));
            } catch (Exception e) {
                LOGGER.error("[ConvertUtil::convertToDouble] ERROR: " + e.getMessage(), e);

                return null;
            }
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public static Float convertToFloat(String s) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(s)) {
            return null;
        } else {
            try {
                return new Float(Double.parseDouble(s.replaceAll(",", ".")));
            } catch (Exception e) {
                LOGGER.error("[ConvertUtil::convertToFloat] ERROR: " + e.getMessage(), e);

                return null;
            }
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public static Float convertToFloat(BigDecimal s) {
        if (s == null) {
            return null;
        } else {
            try {
                return new Float(s.floatValue());
            } catch (Exception e) {
                LOGGER.error("[ConvertUtil::convertToFloat] ERROR: " + e.getMessage(), e);

                return null;
            }
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public static Long convertToLong(String s) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(s)) {
            return null;
        } else {
            try {
                return Long.parseLong(s);
            } catch (Exception e) {
                LOGGER.error("[ConvertUtil::convertToLong] ERROR: " + e.getMessage(), e);

                return null;
            }
        }
    }

    /**
     * Converte una stringa in {@link BigDecimal}.<br />
     * Accetta anche numeri con la virgola come separatore dei decimali.
     * Non sono ammessi separatori di migliaia.
     *
     * @param value Valore da convertire
     * @return {@link BigDecimal} che rappresenta il valore
     */
    public static BigDecimal convertToBigDecimal(String value) {
        BigDecimal number = null;
        LOGGER.debug("------- VALORE DA CONVERTIRE ----- *"+value+"*");
        if (org.apache.commons.lang3.StringUtils.isNotBlank(value)) {
            try {
            	 LOGGER.debug("------- 1 ----- "+value.length());
                // Si converte l'eventuale virgola in punto
                number = new BigDecimal(value.replaceAll(",", "."));
                LOGGER.debug("------- 2 ----- ");
            } catch (Exception e) {
                LOGGER.error("[ConvertUtil::convertToBigDecimal] ERROR: " + e.getMessage(), e);
            }
            LOGGER.debug("------- 3 ----- ");
        }
        LOGGER.debug("------- 4 ----- ");
        return number;
    }	

    /**
     *
     * @param b
     * @return
     */
    public static int convertToInteger(BigDecimal b) {
        int i = 0;
        if (b != null) {
            i = b.intValue();
        }
        return i;
    }

    /**
     *
     * @param b
     * @return
     */
    public static Long convertToLong(BigDecimal b) {
        Long l = null;
        if (b != null) {
            l = b.longValue();
        }
        return l;
    }

    /**
     * Restituisce l'anno di una data
     *
     * @param value Data da cui estrarre l'anno
     * @return Anno della data
     * @throws Exception Errore durante la conversione della data
     */
    public static int getYear(String value) throws Exception {
        return getYear(convertToDate(value));
    }

    /**
     * Restituisce l'anno di una data
     *
     * @param date Data da cui estrarre l'anno
     * @return Anno della data
     */
    public static int getYear(java.util.Date date) {
        final GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        return calendar.get(Calendar.YEAR);
    }

    /**
     *
     * @param b
     * @return
     */
    public static int flagPdf(BigDecimal b) {
        int result = 0;
        if (b != null) {
            result = b.intValue();
        }
        return result;
    }

    /**
     *
     * @param s
     * @return
     */
    public static int flagPdf(String s) {
        int result = 0;
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(s)) {
            result = Integer.parseInt(s);
        }
        return result;
    }

    /**
     *
     * @param s
     * @return
     */
    public static String flagPdfString(String s) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(s)) {
            return EMPTY;
        }
        return s;
    }

    /**
     *
     * @param i
     * @return
     */
    public static BigDecimal convertToBigDecimal(int i) {
        return BigDecimal.valueOf(i);
    }

    /**
     *
     * @param b
     * @return
     */
    public static String flagPdfString(BigDecimal b) {
        if (b == null) {
            return EMPTY;
        }
        return convertToString(b);
    }

    /**
     *
     * @param f
     * @return
     */
    public static BigDecimal convertToBigDecimal(float f) {
        return BigDecimal.valueOf(f);
    }

    /**
     *
     * @param l
     * @return
     */
    public static BigDecimal convertToBigDecimal(long l) {
        return BigDecimal.valueOf(l);
    }

    /**
     *
     * @param b
     * @return
     */
    public static float convertToFloatPrimitive(BigDecimal b) {
        float f = 0;
        if (b != null) {
            f = convertToFloat(b);
        }
        return f;
    }

    /**
     *
     * @param list
     * @return
     */
    public static String convertToSqlIn(List<String> list) {
        final StringBuilder in = new StringBuilder();
        boolean first = true;
        if (list != null) {
            for (final String id : list) {
                if (first) {
                    first = false;
                } else {
                    in.append(",");
                }
                in.append(id);
            }
        }
        return in.toString();
    }

    /**
     *
     * @param list
     * @return
     */
    public static String[] convertToStringArray(List<String> list) {
        String[] result = null;
        if (list != null) {
            result = new String[list.size()];

            list.toArray(result);
        }
        return result;
    }

    /**
     *
     * @param d
     * @return
     */
    public static BigDecimal convertToBigDecimal(double d) {
        return BigDecimal.valueOf(d);
    }

    /**
     *
     * @param b
     * @return
     */
    public static double convertToDouble(BigDecimal b) {
        double d = 0;
        if (b != null) {
            d = b.doubleValue();
        }
        return d;
    }

    /**
     *
     * @param value
     * @return
     */
    public static Integer toInteger(String value) {
        return isEmpty(value)? null : Integer.valueOf(value);
    }

    /**
     *
     * @param value
     * @return
     */
    public static String toStringValue(BigDecimal value) {
        return value == null ? null : value.toString();
    }

    /**
     *
     * @param value
     * @return
     */
    public static String toStringValue(Double value) {
        return value == null ? null : value.toString();
    }

    /**
     *
     * @param value
     * @return
     */
    public static String toStringValue(Object value) {
        return value == null ? null : value.toString();
    }

    /**
     *
     * @param value
     * @return
     */
    public static Long toLong(BigDecimal value) {
        return value == null ? null : value.longValue();
    }

    /**
     *
     * @param value
     * @return
     */
    public static BigDecimal toBigDecimal(Integer value) {
        return value == null ? null : BigDecimal.valueOf(value);
    }

    /**
     *
     * @param value
     * @return
     */
    public static BigDecimal toBigDecimal(Double value) {
        return value == null ? null : BigDecimal.valueOf(value);
    }

    /**
     *
     * @param value
     * @return
     */
    public static BigDecimal toBigDecimal(UDTWrappedDouble10Decimal value) {
        return value == null ? null : toBigDecimal(value.getValue());
    }

    /**
     *
     * @param value
     * @return
     */
    public static Integer toInteger(BigDecimal value) {
        return value == null ? null : value.intValue();
    }

    /**
     *
     * @param value
     * @return
     */
    public static Double toDouble(BigDecimal value) {
        return value == null ? null : value.doubleValue();
    }

    /**
     *
     * @param value
     * @return
     */
    public static Double toDouble(UDTWrappedDouble10Decimal value) {
        return value == null ? null : value.getValue();
    }

    /**
     *
     * @param value
     * @return
     */
    public static UDTWrappedDouble10Decimal toDouble10(BigDecimal value) {
        return value == null ? null : new UDTWrappedDouble10Decimal(value.doubleValue());
    }

    /**
     *
     * @param value
     * @return
     */
    public static UDTWrappedDouble10Decimal toDouble10(Double value) {
        return value == null ? null : new UDTWrappedDouble10Decimal(value);
    }

    /**
     *
     * @param value
     * @return
     */
    public static UDTWrappedDouble10Decimal toDouble10(String value) {
        return value == null ? null : new UDTWrappedDouble10Decimal(convertToDouble(value));
    }

    /**
     *
     * @param input
     * @return
     */
    public static byte[] toBytes(ByteArrayInputStream input) {
        byte[] result = null;

        if (input != null) {
            try {
                result = new byte[input.available()];

                input.read(result);
            } catch (IOException e) {
                LOGGER.error("[ConvertUtil::toBytes] IOException: " + e.getMessage(), e);

                result = null;
            }
        }

        return result;
    }

    /**
     *
     * @param numero
     * @return
     */
    public static String formattazioneProgressivoPratica(String numero) {
        String result = EMPTY;

        if (org.apache.commons.lang3.StringUtils.isNotEmpty(numero) && NumberUtils.isNumber(numero)) {
            result = String.format("%04d", Integer.parseInt(numero));
        }

        return result;
    }

    /**
     * 
     * @param value
     * @param token
     * @return
     */
    public static String[] toArray(String value, String token){
        String[] result = null;
        if (StringUtils.isNotEmpty(value) && StringUtils.isNotEmpty(token)) {
            final StringTokenizer st = new StringTokenizer(value, token);
            final int count = st.countTokens();
            result = new String[count];
            for (int i = 0; i < count; i++) {
                result[i] = st.nextToken();
            }
        }
        return result == null ? new String[0]:result;
    }

    /**
     * 
     * @param value
     * @param token
     * @return
     */
    public static List<String> toArrayList(String value, String token) {
        final List<String> result = new ArrayList<String>();    
        if (StringUtils.isNotEmpty(value) && StringUtils.isNotEmpty(token)) {
            final StringTokenizer st = new StringTokenizer(value, token);
            final int count = st.countTokens();
            for (int i = 0; i < count; i++) {
                result.add(st.nextToken());
            }
        }

        return result;
    }
    
	public static boolean checkIsNullOrEmpty(String stringa) {
		boolean notEmpty = false;
		if(stringa!=null && !stringa.equalsIgnoreCase("") && !stringa.equalsIgnoreCase(Constants.NESSUN_DATO)){
			notEmpty = true;
		}
		return notEmpty;
	}
	
	public static boolean checkListIsNullOrEmpty(java.util.List<String> lista) {
		boolean notEmpty = false;
		if(lista!= null && lista.size() != 0 && lista.size()  > 0){
			notEmpty = true;
		}
		return notEmpty;
	}
	
	public static boolean checkIntIsNullOrZero(int intero) {
		boolean notEmpty = false;
		if(intero != 0){
			notEmpty = true;
		}
		return notEmpty;
	}
	
	public static boolean checkIntIsNullOrZero(BigDecimal intero) {
		boolean notEmpty = false;
		if(intero.intValue() != 0){
			notEmpty = true;
		}
		return notEmpty;
	}
	
	public static boolean checkDateIsNullOrZero(Date date) {
		boolean notEmpty = false;
		if(date != null){
			notEmpty = true;
		}
		return notEmpty;
	}
	
	public static String createStringForQuery(java.util.List<String> lista) {
		String stringa ="(";
		for(int i=0;i<lista.size();i++) {
			stringa+= "'"+lista.get(i)+"'";
			if(i!=lista.size()-1) {
				stringa+=",";
			} else {
				stringa+=")";
			}
		}
		return stringa;
	}
	
	public static String createStringForQuerywithJdbcTemplate(java.util.List<String> lista) {
		String stringa ="";
		for(int i=0;i<lista.size();i++) {
			stringa+= "'"+lista.get(i)+"'";
			if(i!=lista.size()-1) {
				stringa+=",";
			} else {
				stringa+="";
			}
		}
		return stringa;
	}
	
	public static String getLinguaFromSoggettoGestore(int idSoggettoGestore) {
		String lingua = it.csi.taif.topforweb.business.dao.util.Constants.itaLang;
		switch (idSoggettoGestore) {
		case it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_SUPERADMIN :
			lingua = it.csi.taif.topforweb.business.dao.util.Constants.itaLang;
			break;
		case it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_PIEMONTE :
			lingua = it.csi.taif.topforweb.business.dao.util.Constants.itaLang;
			break;
		case it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_LIGURIA :
			lingua = it.csi.taif.topforweb.business.dao.util.Constants.itaLang;
			break;
		case it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_VDA :
			lingua = it.csi.taif.topforweb.business.dao.util.Constants.itaLang;
			break;
		case it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_ASDEFS :
			lingua = it.csi.taif.topforweb.business.dao.util.Constants.fraLang;
			break;
		case it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_SEFSAM :
			lingua = it.csi.taif.topforweb.business.dao.util.Constants.fraLang;
			break;
	}
		return lingua;
	}
	
	public static String getLinguaFromTipoAccesso(String tipoAccesso) {
		String lingua = it.csi.taif.topforweb.business.dao.util.Constants.itaLang;
		switch (new Integer(tipoAccesso)) {
		case it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_SUPERADMIN :
			lingua = it.csi.taif.topforweb.business.dao.util.Constants.itaLang;
			break;
		case it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_PIEMONTE :
			lingua = it.csi.taif.topforweb.business.dao.util.Constants.itaLang;
			break;
		case it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_LIGURIA :
			lingua = it.csi.taif.topforweb.business.dao.util.Constants.itaLang;
			break;
		case it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_VDA :
			lingua = it.csi.taif.topforweb.business.dao.util.Constants.itaLang;
			break;
		case it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_ASDEFS :
			lingua = it.csi.taif.topforweb.business.dao.util.Constants.fraLang;
			break;
		case it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_SEFSAM :
			lingua = it.csi.taif.topforweb.business.dao.util.Constants.fraLang;
			break;
		}
			return lingua;
	}
	
	public static int getSoggettoGestoreFromIstat(int idSoggettoGestore) {
		int lingua = 0;
		switch (idSoggettoGestore) {
		case 1 : case 2 : case 3 : case 4: case 5 : case 6 : case 96 : case 103 :
			lingua = 1;
			break;
		case 8 : case 9 : case 10 : case 11 :
			lingua = 2;
			break;
		case 7 :
			lingua = 3;
			break;
		default:
			lingua = 1;
		}
		
		
			
		return lingua;
	}
	
	
	public static String createStringForQueryWithInt(java.util.List<String> lista) {
		String stringa ="(";
		for(int i=0;i<lista.size();i++) {
			stringa+= lista.get(i);
			if(i!=lista.size()-1) {
				stringa+=",";
			} else {
				stringa+=")";
			}
		}
		return stringa;
	}
	
	public static Object resizeArray (Object oldArray, int newSize) {
		   int oldSize = java.lang.reflect.Array.getLength(oldArray);
		   Class elementType = oldArray.getClass().getComponentType();
		   Object newArray = java.lang.reflect.Array.newInstance(
		         elementType, newSize);
		   int preserveLength = Math.min(oldSize, newSize);
		   if (preserveLength > 0)
		      System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
		   return newArray; }
	
	public static String getDenominazioneComuneFromCodiceIstat(String codiceIstatComune,  ArrayList<CodeDescription> list) {
		String denominazioneComune = "";
		for (CodeDescription element : list) {
			if (element.getCode().equalsIgnoreCase(codiceIstatComune)) {
				denominazioneComune = element.getDescription();
				break;
			}
		}
		return denominazioneComune;
	}
	
	public static String getIdByDescription(String desc, ArrayList<CodeDescription> list) {
		for(CodeDescription obj : list) {
			if(obj.getDescription().equalsIgnoreCase(desc)) {
				return obj.getCode();
			}
		}
		return "";
	}
	
	public static String getDescriptionById(String id, ArrayList<CodeDescription> list) {
		for(CodeDescription obj : list) {
			if(obj.getCode().equalsIgnoreCase(id)) {
				return obj.getDescription();
			}
		}
		return "";
	}
	
	public static String getDescriptionAltroCorsoById(String id, ArrayList<CorsoProfessionale> list) {
		for(CorsoProfessionale obj : list) {
			if(obj.getIdCorsoProfessionale().equalsIgnoreCase(id)) {
				return obj.getTitoloCorso();
			}
		}
		return "";
	}
	
	public static ArrayList<CodeDescription> createElencoStatoOperatore(String linguaDati) {
		ArrayList<CodeDescription> list = new ArrayList<CodeDescription>();
		CodeDescription obj1 = new CodeDescription();
		CodeDescription obj2 = new CodeDescription();
		obj1.setCode(it.csi.taif.topforweb.business.dao.util.Constants.zero);
		obj2.setCode(it.csi.taif.topforweb.business.dao.util.Constants.one);
		if (linguaDati.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.fLang)) {
			obj1.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_NON_PUBBLICO_FRA);
			obj2.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_PUBBLICO_FRA);
		} else {
			obj1.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_NON_PUBBLICO_ITA);
			obj2.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_PUBBLICO_ITA);
		}
		list.add(obj1);
		list.add(obj2);
		return list;
	}
	
	public static Object caricaDatiOperatore(TopForMgr topForfMgr,
			CpInserimentoOperatoreModel theModel, Integer idPersona) throws ManagerException {
		return caricaDatiOperatore(topForfMgr, theModel, convertToString(idPersona));
	}
	
	public static Object  caricaDatiOperatore(TopForMgr topForfMgr, Object theModel, String idPersonaOperatore) throws ManagerException {
		CpInserimentoOperatoreModel theModelTemp = (CpInserimentoOperatoreModel) theModel;
		RicercaOperatoreFilter filtroIdPersona = new RicercaOperatoreFilter();
		filtroIdPersona.setIdPersona(idPersonaOperatore);
		
		theModelTemp.setAppDataelencoComuniRicercaOperatoreGestore(topForfMgr.getElencoComuni());
		theModelTemp.setAppDataelencoNazioni(topForfMgr.getElencoNazioniPerLingua(it.csi.taif.topforweb.business.dao.util.Constants.oneInt, theModelTemp.getAppDatatracciato()));
		theModelTemp.setAppDataelencoStatoSchedaRicerca(topForfMgr.getElencoStatoSchedaPerLingua(it.csi.taif.topforweb.business.dao.util.Constants.oneInt, theModelTemp.getAppDatatracciato()));

		theModelTemp.setAppDataelencoStatoOperatoreRicerca(ConvertUtil.createElencoStatoOperatore(theModelTemp.getAppDatatracciato()));
		
		ArrayList<CorsoProfessionale> listCorsiFinanziatiRegione = new ArrayList<CorsoProfessionale>();
		listCorsiFinanziatiRegione = recuperoCorsiFinanziatiRegione(topForfMgr,filtroIdPersona, theModelTemp);
		theModelTemp.setAppDataelencoCorsiProfessionaliFinanziatiDaRegione(listCorsiFinanziatiRegione);

		ArrayList<CorsoProfessionale> listAltriCorsi = new ArrayList<CorsoProfessionale>();
		listAltriCorsi = recuperoAltriCorsi(topForfMgr,filtroIdPersona);
		theModelTemp.setAppDataelencoAltriCorsi(listAltriCorsi);
		
		ArrayList<Qualifica> listQualifiche = new ArrayList<Qualifica>();
		listQualifiche = recuperoQualifiche(topForfMgr,filtroIdPersona);
		theModelTemp.setAppDataelencoQualifiche(listQualifiche);

		ArrayList<Riconoscimento> listRiconoscimenti = new ArrayList<Riconoscimento>();
		listRiconoscimenti = recuperoRiconoscimenti(topForfMgr,filtroIdPersona);
		theModelTemp.setAppDataelencoRiconoscimento(listRiconoscimenti);
		
		theModelTemp = ConvertUtil.recuperaDatiOperatore(new Integer(idPersonaOperatore), theModelTemp, topForfMgr);
		
		theModel = theModelTemp;
		
		return theModel;
		
		
		
	}
	
	private static ArrayList<CorsoProfessionale> recuperoCorsiFinanziatiRegione(TopForMgr topForfMgr,RicercaOperatoreFilter filtroIdPersona,
			CpInserimentoOperatoreModel theModelTemp) throws ManagerException {
		ArrayList<CorsoProfessionale> list = new ArrayList<CorsoProfessionale>();
		List<TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto> corsiFinanziatiRegione = topForfMgr
				.findRicercaCorsiFinanziatiRegione(filtroIdPersona);
		
		for (TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto el : corsiFinanziatiRegione) {
			CorsoProfessionale corso = new CorsoProfessionale();
			corso.setIdCorsoProfessionale(el.getIdCorso());
			corso.setDsAgenziaFormativa(el.getDsAgenziaFormativa());
			corso.setDsUnitaFormativa(el.getDsUnitaFormativa());
			corso.setDsEsitoCorso(el.getDsEsitoCorso()); //esito
			corso.setTitoloCorso(el.getTitoloCorso());
			corso.setEsitoCorso(el.getFlgEsito());
			
			if (ConvertUtil.checkIsNullOrEmpty(el.getSedeCorso())) {
				String sedeCorso = getDenominazioneComuneFromCodiceIstat(el.getSedeCorso(), theModelTemp.getAppDataelencoComuni());
				corso.setSedeCorso(sedeCorso);
			}

			corso.setPeriodoSvolgimento(el.getPeriodoSvolgimento());
			corso.setNumeroOre(el.getNOre());
			corso.setIconaAttestato(el.getIdCorso());
			corso.setIconaAllegato(el.getIdAllegato());
			corso.setIconaCancella(el.getIdCorso());
			list.add(corso);
		}

		return list;
	}
	
	private static ArrayList<CorsoProfessionale> recuperoAltriCorsi(TopForMgr topForfMgr,RicercaOperatoreFilter filtroIdPersona) throws ManagerException {
		ArrayList<CorsoProfessionale> list = new ArrayList<CorsoProfessionale>();
		List<TaifTPersonaCorsiExtAltriCorsiDto> altriCorsi = topForfMgr.findAltriCorsi(filtroIdPersona);

		for (TaifTPersonaCorsiExtAltriCorsiDto el : altriCorsi) {
			CorsoProfessionale corso = new CorsoProfessionale();
			String idCorso = ConvertUtil.checkIsNullOrEmpty(el.getIdCorso()) ? el.getIdCorso() : "";
			corso.setIdCorsoProfessionale(idCorso);
			
			String titoloCorso = ConvertUtil.checkIsNullOrEmpty(el.getTitoloCorso()) ? el.getTitoloCorso() : "";
			if(ConvertUtil.checkIsNullOrEmpty(el.getDescrizioneAltroCorso())){
				titoloCorso = titoloCorso + " - " + el.getDescrizioneAltroCorso();
			}
			corso.setTitoloCorso(titoloCorso);
			
			String descrizioneCorso = ConvertUtil.checkIsNullOrEmpty(el.getDescrizioneAltroCorso())
					? el.getDescrizioneAltroCorso()
					: "";
			corso.setDescrizioneAltroCorso(descrizioneCorso);
			
			String esitoCorso = ConvertUtil.checkIsNullOrEmpty(el.getDsEsitoCorso())
							? el.getDsEsitoCorso()
							: "";
			corso.setDsEsitoCorso(esitoCorso);
			String scadenza = "";
			if (ConvertUtil.checkIsNullOrEmpty(el.getAttestatoConScadenza()) && el.getAttestatoConScadenza()
					.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.zero)) {
				scadenza = it.csi.taif.topforweb.business.dao.util.Constants.NO_VALUE;
			}
			if (ConvertUtil.checkIsNullOrEmpty(el.getAttestatoConScadenza()) && el.getAttestatoConScadenza()
					.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.one)) {
				scadenza = it.csi.taif.topforweb.business.dao.util.Constants.SI_VALUE;
			}
			corso.setDsAttestatoConScadenza(scadenza);
			corso.setIconaAttestato(el.getIdCorso());
			corso.setIconaAllegato(el.getIdAllegato());
			corso.setIconaCancella(el.getIdCorso());
			list.add(corso);
		}

		return list;
	}
	
	private static ArrayList<Qualifica> recuperoQualifiche(TopForMgr topForfMgr,RicercaOperatoreFilter filtroIdPersona) throws ManagerException {
		ArrayList<Qualifica> list = new ArrayList<Qualifica>();
		List<TaifTQualificaByIdPersonaDto> qualifiche = topForfMgr.findQualificaByIdPersona(filtroIdPersona);

		for (TaifTQualificaByIdPersonaDto el : qualifiche) {
			Qualifica qualifica = new Qualifica();
			qualifica.setIdQualifica(el.getIdQualifica() + "");
			qualifica.setAgenziaFormativa(el.getRagioneSociale());
			qualifica.setTipoQualifica(el.getTipoQualifica());
			if (ConvertUtil.checkDateIsNullOrZero(el.getDataRilascio())) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String dataRilascio = sdf.format(el.getDataRilascio());
				qualifica.setDataQualifica(dataRilascio);
			}
			list.add(qualifica);
		}

		return list;
	}
	
	private static ArrayList<Riconoscimento> recuperoRiconoscimenti(TopForMgr topForfMgr, RicercaOperatoreFilter filtroIdPersona) throws ManagerException {
		ArrayList<Riconoscimento> list = new ArrayList<Riconoscimento>();
		List<TaifTRiconoscimentoByIdPersonaDto> riconoscimenti = topForfMgr.findRiconoscimenti(filtroIdPersona);

		for (TaifTRiconoscimentoByIdPersonaDto el : riconoscimenti) {
			Riconoscimento riconoscimento = new Riconoscimento();
			riconoscimento.setIdRiconoscimento(el.getIdRiconoscimento()+"");
    	    riconoscimento.setAgenziaFormativa(el.getRagioneSociale());
    	    riconoscimento.setUnitaFormativa(el.getUnitaFormativa());
    	    if(el.getNote() != null){
    		riconoscimento.setNote(el.getNote());
    	    }
    	    riconoscimento.setIconaCancella(String.valueOf(el.getIdRiconoscimento()));
			
			riconoscimento.setNote(	el.getNote());
			if (ConvertUtil.checkDateIsNullOrZero(el.getDataRilascio())) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String dataRiconoscimento = sdf.format(el.getDataRilascio());
				riconoscimento.setDataRiconoscimento(dataRiconoscimento);
			}

			list.add(riconoscimento);
		}

		return list;
	}

	public static CpElencoOperatoriModel recuperaDatiDettaglioOperatore(Integer idRiga, CpElencoOperatoriModel theModel, TopForMgr topForfMgr) throws ManagerException {
		
		RicercaOperatoreFilter filtroIdPersona = new RicercaOperatoreFilter();
		filtroIdPersona.setIdPersona(theModel.getIdRiga());
		
		Operatore operatore = new Operatore();
		operatore = recuperaDatiAnagraficiDettaglioOperatore(filtroIdPersona, topForfMgr, theModel.getAppDatacurrentUser().getLingua(), theModel.getAppDatacurrentUser().getTipoAccesso(),theModel.getAppDataelencoComuniRicercaOperatoreGestore(),theModel.getAppDataelencoStatoSchedaRicerca(), theModel.getAppDataelencoNazioni());
		operatore.setComuneNascitaOperatore(getDenominazioneComuneFromCodiceIstat(operatore.getComuneNascitaOperatore(), theModel.getAppDataelencoComuniRicercaOperatoreGestore()));
		ArrayList<CorsoProfessionale> listCorsiFinanziatiRegione = new ArrayList<CorsoProfessionale>();
		listCorsiFinanziatiRegione = recuperoCorsiFinanziatiRegione(filtroIdPersona, topForfMgr,theModel.getAppDataelencoComuniRicercaOperatoreGestore());

		ArrayList<CorsoProfessionale> listAltriCorsi = new ArrayList<CorsoProfessionale>();
		listAltriCorsi = recuperoAltriCorsi(filtroIdPersona, topForfMgr);
		
		ArrayList<Qualifica> listQualifiche = new ArrayList<Qualifica>();
		listQualifiche = recuperoQualifiche(filtroIdPersona, topForfMgr);

		ArrayList<Riconoscimento> listRiconoscimenti = new ArrayList<Riconoscimento>();
		listRiconoscimenti = recuperoRiconoscimenti(topForfMgr,filtroIdPersona);
		
		String idStatoSchedaSelezionato = ConvertUtil.getIdByDescription(operatore.getStatoScheda(),theModel.getAppDataelencoStatoSchedaRicerca());
		theModel.setAppDataidStatoSchedaSelezionato(idStatoSchedaSelezionato);
		
		theModel.setAppDataelencoCorsiProfessionaliFinanziatiDaRegione(listCorsiFinanziatiRegione);
		theModel.setAppDataelencoAltriCorsi(listAltriCorsi);
		theModel.setAppDataelencoQualifiche(listQualifiche);
		theModel.setAppDataelencoRiconoscimento(listRiconoscimenti);
		
		theModel.setAppDatadettaglioOperatoreSelezionato(operatore);
		
		return theModel;
		
	}
	
	public static CpInserimentoOperatoreModel recuperaDatiOperatore(Integer idPersona, CpInserimentoOperatoreModel theModel, TopForMgr topForfMgr) throws ManagerException {
		
		theModel.setAppDatadatiOperatoreFromDB(recuperaOperatore(idPersona, theModel, topForfMgr));
		
		return theModel;
		
	}
	
	public static Operatore recuperaOperatore(Integer idPersona, CpInserimentoOperatoreModel theModel, TopForMgr topForfMgr) throws ManagerException {
		
		RicercaOperatoreFilter filtroIdPersona = new RicercaOperatoreFilter();
		filtroIdPersona.setIdPersona(idPersona.toString());
		
		Operatore operatore = new Operatore();
		operatore = recuperaDatiAnagraficiDettaglioOperatore(filtroIdPersona, topForfMgr, theModel.getAppDatacurrentUser().getLingua(), theModel.getAppDatacurrentUser().getTipoAccesso(),theModel.getAppDataelencoComuniRicercaOperatoreGestore(),theModel.getAppDataelencoStatoSchedaRicerca(), theModel.getAppDataelencoNazioni());		
		// al posto dei delle descrizioni metto i codici per fare il confronto per l'invio mail
		operatore.setStatoOperatore(getIdByDescription(operatore.getStatoOperatore(), theModel.getAppDataelencoStatoOperatoreRicerca()));
		operatore.setStatoScheda(getIdByDescription(operatore.getStatoScheda(), theModel.getAppDataelencoStatoSchedaRicerca()));
		
		ArrayList<CorsoProfessionale> listCorsiFinanziatiRegione = new ArrayList<CorsoProfessionale>();
		listCorsiFinanziatiRegione = recuperoCorsiFinanziatiRegione(filtroIdPersona, topForfMgr, theModel.getAppDataelencoComuniRicercaOperatoreGestore());

		ArrayList<CorsoProfessionale> listAltriCorsi = new ArrayList<CorsoProfessionale>();
		listAltriCorsi = recuperoAltriCorsi(filtroIdPersona, topForfMgr);
		
		ArrayList<Qualifica> listQualifiche = new ArrayList<Qualifica>();
		listQualifiche = recuperoQualifiche(filtroIdPersona, topForfMgr);

		ArrayList<Riconoscimento> listRiconoscimenti = new ArrayList<Riconoscimento>();
		listRiconoscimenti = recuperoRiconoscimenti(topForfMgr,filtroIdPersona);
		
		/*
		 * theModel.setAppDataelencoCorsiProfessionaliFinanziatiDaRegione(
		 * listCorsiFinanziatiRegione);
		 * theModel.setAppDataelencoAltriCorsi(listAltriCorsi);
		 * theModel.setAppDataelencoQualifiche(listQualifiche);
		 * theModel.setAppDataelencoRiconoscimento(listRiconoscimenti);
		 */
		
		
		operatore.setElencoCorsiProfessionaliFinanziatiRegione(listCorsiFinanziatiRegione);
		operatore.setElencoAltriCorsi(listAltriCorsi);
		operatore.setElencoQualifiche(listQualifiche);
		operatore.setElencoRiconoscimenti(listRiconoscimenti);
		
		
		
		return operatore;
		
	}
	
	private static Operatore recuperaDatiAnagraficiDettaglioOperatore(RicercaOperatoreFilter filtroIdPersona, TopForMgr topForfMgr, String lingua, String tipoAccesso, ArrayList<CodeDescription> elencoComuni, ArrayList<CodeDescription> elencoStatoScheda, ArrayList<CodeDescription> elencoNazioni)
			throws ManagerException {
		List<TaifTPersonaDatiIdentificativiOperatoreDto> resOp = topForfMgr
				.ricercaDettaglioOperatoreByIdPersona(filtroIdPersona);
		TaifTPersonaDatiIdentificativiOperatoreDto operatoreTrovato = resOp.get(0);
		List<TaifTPersonaExtRicercaNumeroAlboForestaleDto> associatoAziendaIscrittaAlboRegione = topForfMgr
				.findRicercaNumeroAlboForestale(filtroIdPersona);

		//String nazOp = checkNazionalitaOperatore(operatoreTrovato);

		Operatore op = new Operatore();
		if (operatoreTrovato.getPubblico()
				.intValue() == it.csi.taif.topforweb.business.dao.util.Constants.ID_STATO_OPERATORE_PUBBLICO) {
			if (lingua.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
				op.setStatoOperatore(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_PUBBLICO_ITA);
			} else {
				op.setStatoOperatore(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_PUBBLICO_FRA);
			}
		} else {
			if (lingua.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
				op.setStatoOperatore(
						it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_NON_PUBBLICO_ITA);
			} else {
				op.setStatoOperatore(
						it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_NON_PUBBLICO_FRA);
			}
		}
		if (lingua.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
			op.setStatoScheda(operatoreTrovato.getStatoSchedaIta());
		} else {
			op.setStatoScheda(operatoreTrovato.getStatoSchedaFra());
		}
		op.setElencoAppartenenzaOperatore(operatoreTrovato.getElencoAppartenenza());

		op.setIdSoggettoGestore(operatoreTrovato.getIdSoggettoGestore() + "");
		
		if (tipoAccesso.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.TIPO_ACCESSO_LIBERO_IT)) {
			op.setCodiceFiscaleOperatore("");
		} else {
			op.setCodiceFiscaleOperatore(operatoreTrovato.getCodiceFiscale());
		}

		if (tipoAccesso.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.TIPO_ACCESSO_LIBERO_FR)) {
			op.setNRsiMsa("");
		} else {
			op.setNRsiMsa(operatoreTrovato.getNRsiMsa());
		}

		op.setCognomeNomeOperatore(operatoreTrovato.getNome() + " " + operatoreTrovato.getCognome());
		op.setCognomeOperatore(operatoreTrovato.getCognome());
		op.setNomeOperatore(operatoreTrovato.getNome());
		// se operatore italiano
		if (checkNazionalitaOperatore(operatoreTrovato).equalsIgnoreCase(Constants.LINGUA_DATI_ITA)) {
			if (ConvertUtil.checkDateIsNullOrZero(operatoreTrovato.getDataNascita())) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String dataNascita = sdf.format(operatoreTrovato.getDataNascita());
				op.setDataNascitaOperatore(dataNascita);
			}

			op.setComuneNascitaOperatore(
					getDenominazioneComuneFromCodiceIstat(operatoreTrovato.getIstatComuneNascita(), elencoComuni));
			op.setStatoNascitaOperatore(operatoreTrovato.getNazioneNascitaIta());
		}

		String comuneResidenza = ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getIstatComuneResidenza())
				? getDenominazioneComuneFromCodiceIstat(operatoreTrovato.getIstatComuneResidenza(), elencoComuni)
				: "";

		// se operatore non italiano
		if (!checkNazionalitaOperatore(operatoreTrovato).equalsIgnoreCase(Constants.LINGUA_DATI_ITA)) {
			String luogoNascita = ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getComuneEsteroNascita())
					? operatoreTrovato.getComuneEsteroNascita()
					: "";
			op.setComuneEsteroNascitaOperatore(luogoNascita);
			op.setStatoNascitaOperatore(operatoreTrovato.getNazioneNascitaFra());
			comuneResidenza = ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getComuneEsteroResidenza())
					? operatoreTrovato.getComuneEsteroResidenza()
					: "";
			op.setStatoNascitaOperatore(comuneResidenza);
		}
		
		op.setDsStatoNascitaOperatore(op.getStatoNascitaOperatore());

		String indirizzoResidenza = ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getIndirizzoResidenza())
				? operatoreTrovato.getIndirizzoResidenza()
				: "";
		String capResidenza = ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getCapResidenza())
				? operatoreTrovato.getCapResidenza()
				: "";

		op.setIndirizzoResidenzaOperatore(indirizzoResidenza + " " + capResidenza + " " + comuneResidenza);

		String telefono = ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getTelefono())
				? operatoreTrovato.getTelefono()
				: "";
		String cellulare = ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getCellulare())
				? operatoreTrovato.getCellulare()
				: "";
		if (!telefono.equalsIgnoreCase("") && !cellulare.equalsIgnoreCase("")) {
			op.setTelefonoOperatore(telefono + " -- " + cellulare);
		} else if (!telefono.equalsIgnoreCase("") && cellulare.equalsIgnoreCase("")) {
			op.setTelefonoOperatore(telefono);
		} else if (telefono.equalsIgnoreCase("") && !cellulare.equalsIgnoreCase("")) {
			op.setTelefonoOperatore(cellulare);
		}

		String email = ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getEmailPersonale())
				? operatoreTrovato.getEmailPersonale()
				: "";
		op.setEmailOperatore(email);

		String titoloStudioIta = ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getTitoloStudioIta())
				? operatoreTrovato.getTitoloStudioIta()
				: "";
		String titoloStudioFra = ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getTitoloStudioFra())
				? operatoreTrovato.getTitoloStudioFra()
				: "";
		if (!titoloStudioIta.equalsIgnoreCase("") && !titoloStudioFra.equalsIgnoreCase("")) {
			op.setTitoloStudioIta(titoloStudioIta + " -- " + titoloStudioFra);
		} else if (!titoloStudioIta.equalsIgnoreCase("") && titoloStudioFra.equalsIgnoreCase("")) {
			op.setTitoloStudioIta(titoloStudioIta);
		} else if (titoloStudioIta.equalsIgnoreCase("") && !titoloStudioFra.equalsIgnoreCase("")) {
			op.setTitoloStudioIta(titoloStudioFra);
		}

		op.setAltriStudiCorsiOperatore(operatoreTrovato.getAltriStudi());

		String numeroAlboForestale = "NO";
		if (associatoAziendaIscrittaAlboRegione != null && associatoAziendaIscrittaAlboRegione.size() != 0) {
			String numero = associatoAziendaIscrittaAlboRegione.get(0).getNumeroAlboForestale();
			numeroAlboForestale = ConvertUtil.checkIsNullOrEmpty(numero)
					? "SI &emsp;&emsp;<b>numero albo<b>:    " + numero
					: "NO";
		}
		op.setAssociatoAziendaIscrittaAlboForestaleENumeroAlbo(numeroAlboForestale);

		if (ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getStatoSchedaIta())
				|| ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getStatoSchedaFra())) {
			String statoScheda = "";
			if (lingua
					.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
				statoScheda = operatoreTrovato.getStatoSchedaIta();
				op.setStatoScheda(getIdByDescription(operatoreTrovato.getStatoSchedaIta(),elencoStatoScheda));
			} else {
				statoScheda = operatoreTrovato.getStatoSchedaFra();
				op.setStatoScheda(getIdByDescription(operatoreTrovato.getStatoSchedaFra(),elencoStatoScheda));
			}
			op.setStatoScheda(statoScheda);
		}
		
		op.setStatoNascitaOperatore(operatoreTrovato.getIdNazione()+"");
		op.setComuneNascitaOperatore(operatoreTrovato.getIstatComuneNascita());
		op.setComuneEsteroNascitaOperatore(operatoreTrovato.getComuneEsteroNascita());
		op.setComuneEsteroResidenzaOperatore(operatoreTrovato.getComuneEsteroResidenza());
		op.setComuneNascitaOperatore(operatoreTrovato.getIstatComuneNascita());
		op.setComuneResidenzaOperatore(operatoreTrovato.getIstatComuneResidenza());
		op.setIndirizzoResidenzaOperatore(operatoreTrovato.getIndirizzoResidenza());
		op.setCivicoResidenzaOperatore(operatoreTrovato.getCivicoResidenza());
		op.setCapResidenzaOperatore(operatoreTrovato.getCapResidenza());
		op.setTelefonoOperatore(operatoreTrovato.getTelefono());
		op.setCellulareOperatore(operatoreTrovato.getCellulare());
		op.setEmailOperatore(operatoreTrovato.getEmailPersonale());
		
		return op;
	}
	
	
	
	
	
	private static ArrayList<CorsoProfessionale> recuperoCorsiFinanziatiRegione(RicercaOperatoreFilter filtroIdPersona, TopForMgr topForfMgr, ArrayList<CodeDescription> elencoComuni) throws ManagerException {
		ArrayList<CorsoProfessionale> list = new ArrayList<CorsoProfessionale>();
		List<TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto> corsiFinanziatiRegione = topForfMgr
				.findRicercaCorsiFinanziatiRegione(filtroIdPersona);

		for (TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto el : corsiFinanziatiRegione) {
			CorsoProfessionale corso = new CorsoProfessionale();
			corso.setIdCorsoProfessionale(el.getIdCorso());
			// Modifica Enrico 19/06/2019
			corso.setIdAllegato(el.getIdAllegato());
			corso.setDsAgenziaFormativa(el.getDsAgenziaFormativa());
			corso.setDsUnitaFormativa(el.getDsUnitaFormativa());
			corso.setDsEsitoCorso(el.getDsEsitoCorso()); //esito
			corso.setEsitoCorso(el.getFlgEsito());
			corso.setTitoloCorso(el.getTitoloCorso());
			
			if (ConvertUtil.checkIsNullOrEmpty(el.getSedeCorso())) {
				String sedeCorso = ConvertUtil.getDenominazioneComuneFromCodiceIstat(el.getSedeCorso(),elencoComuni);
				corso.setSedeCorso(sedeCorso);
			}

			corso.setPeriodoSvolgimento(el.getPeriodoSvolgimento());
			corso.setNumeroOre(el.getNOre());
			corso.setIconaAttestato(el.getIdCorso());
			corso.setIconaAllegato(el.getIdAllegato());
			corso.setIconaCancella(el.getIdCorso());
			list.add(corso);
		}

		return list;
	}
	
	
	
	private static ArrayList<CorsoProfessionale> recuperoAltriCorsi(RicercaOperatoreFilter filtroIdPersona, TopForMgr topForfMgr) throws ManagerException {
		ArrayList<CorsoProfessionale> list = new ArrayList<CorsoProfessionale>();
		List<TaifTPersonaCorsiExtAltriCorsiDto> altriCorsi = topForfMgr.findAltriCorsi(filtroIdPersona);

		for (TaifTPersonaCorsiExtAltriCorsiDto el : altriCorsi) {
			CorsoProfessionale corso = new CorsoProfessionale();
			String idCorso = ConvertUtil.checkIsNullOrEmpty(el.getIdCorso()) ? el.getIdCorso() : "";
			corso.setIdCorsoProfessionale(idCorso);
			String titoloCorso = ConvertUtil.checkIsNullOrEmpty(el.getTitoloCorso()) ? el.getTitoloCorso() : "";
			corso.setTitoloCorso(titoloCorso);
			String descrizioneCorso = ConvertUtil.checkIsNullOrEmpty(el.getDescrizioneAltroCorso())
					? el.getDescrizioneAltroCorso()
					: "";
			corso.setDescrizioneAltroCorso(descrizioneCorso);
			if (ConvertUtil.checkIsNullOrEmpty(el.getDescrizioneAltroCorso())) {
				corso.setTitoloCorso(el.getTitoloCorso() + " " + el.getDescrizioneAltroCorso());
			} else {
				corso.setTitoloCorso(el.getTitoloCorso());
			}
			String esitoCorso = ConvertUtil.checkIsNullOrEmpty(el.getDsEsitoCorso()) ? el.getDsEsitoCorso() : "";
			corso.setDsEsitoCorso(esitoCorso);
			String scadenza = "";
			if (ConvertUtil.checkIsNullOrEmpty(el.getAttestatoConScadenza()) && el.getAttestatoConScadenza()
					.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.zero)) {
				scadenza = it.csi.taif.topforweb.business.dao.util.Constants.NO_VALUE;
			}
			if (ConvertUtil.checkIsNullOrEmpty(el.getAttestatoConScadenza()) && el.getAttestatoConScadenza()
					.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.one)) {
				scadenza = it.csi.taif.topforweb.business.dao.util.Constants.SI_VALUE;
			}
			corso.setDsAttestatoConScadenza(scadenza);
			corso.setIconaAttestato(el.getIdCorso());
			corso.setIconaAllegato(el.getIdAllegato());
			corso.setIconaCancella(el.getIdCorso());
			list.add(corso);
		}

		return list;
	}
	


	private static ArrayList<Qualifica> recuperoQualifiche(RicercaOperatoreFilter filtroIdPersona,TopForMgr topForfMgr) throws ManagerException {
		ArrayList<Qualifica> list = new ArrayList<Qualifica>();
		List<TaifTQualificaByIdPersonaDto> qualifiche = topForfMgr.findQualificaByIdPersona(filtroIdPersona);

		for (TaifTQualificaByIdPersonaDto el : qualifiche) {
			Qualifica qualifica = new Qualifica();
			qualifica.setIdQualifica(el.getIdQualifica() + "");
			qualifica.setAgenziaFormativa(el.getRagioneSociale());
			qualifica.setTipoQualifica(el.getTipoQualifica());
			if (ConvertUtil.checkDateIsNullOrZero(el.getDataRilascio())) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String dataRilascio = sdf.format(el.getDataRilascio());
				qualifica.setDataQualifica(dataRilascio);
			}
			list.add(qualifica);
		}

		return list;
	}

	private static ArrayList<Riconoscimento> recuperoRiconoscimenti(RicercaOperatoreFilter filtroIdPersona,
			CpElencoOperatoriModel theModel,TopForMgr topForfMgr) throws ManagerException {
		ArrayList<Riconoscimento> list = new ArrayList<Riconoscimento>();
		List<TaifTRiconoscimentoByIdPersonaDto> riconoscimenti = topForfMgr
				.findRiconoscimentoByIdPersona(filtroIdPersona);

		for (TaifTRiconoscimentoByIdPersonaDto el : riconoscimenti) {
			Riconoscimento riconoscimento = new Riconoscimento();
			riconoscimento.setIdRiconoscimento(el.getIdRiconoscimento() + "");
			riconoscimento.setAgenziaFormativa(el.getRagioneSociale());
			riconoscimento.setUnitaFormativa(el.getUnitaFormativa());
			if (ConvertUtil.checkDateIsNullOrZero(el.getDataRilascio())) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String dataRilascio = sdf.format(el.getDataRilascio());
				riconoscimento.setDataRiconoscimento(dataRilascio);
				riconoscimento.setNote(el.getNote());
			}

			list.add(riconoscimento);
		}

		return list;
	}
	
	private static String checkNazionalitaOperatore(TaifTPersonaDatiIdentificativiOperatoreDto operatoreTrovato) {
		if (ConvertUtil.checkIsNullOrEmpty(operatoreTrovato.getCodiceFiscale())) {
			return Constants.LINGUA_DATI_ITA;
		}
		return Constants.LINGUA_DATI_FRA;
	}

	private static String getDenominazioneComuneFromCodiceIstat(String codiceIstatComune, CpElencoOperatoriModel theModel) {
		String denominazioneComune = "";
		for (CodeDescription element : theModel.getAppDataelencoComuniRicercaOperatoreGestore()) {
			if (element.getCode().equalsIgnoreCase(codiceIstatComune)) {
				denominazioneComune = element.getDescription();
				break;
			}
		}
		return denominazioneComune;
	}

	
	
}
