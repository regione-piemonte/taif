/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.apache.oro.text.regex.StringSubstitution;
import org.apache.oro.text.regex.Util;

public class XSSRequestWrapper extends HttpServletRequestWrapper{
	private PatternMatcher matcher;
	
	private Pattern patternSingleQuote;
	private Pattern patternEscapeSingleQuote;
	private StringSubstitution substitutionSingleQuote;
	
	private Pattern patternDoubleQuote;
	private Pattern patternEscapeDoubleQuote;
	private StringSubstitution substitutionDoubleQuote;
	
	private Pattern patternAsteriskQuote;
	private Pattern patternEscapeAsteriskQuote;
	private StringSubstitution substitutionAsteriskQuote;
	
	private Pattern patternMajorQuote;
	private Pattern patternEscapeMajorQuote;
	private StringSubstitution substitutionMajorQuote;
	
	private Pattern patternMinorQuote;
	private Pattern patternEscapeMinorQuote;
	private StringSubstitution substitutionMinorQuote;
	
	private Pattern patternAlert;
	private StringSubstitution substitutionAlert;
	
	private Perl5Compiler compiler;

	public XSSRequestWrapper(HttpServletRequest servletRequest)	{
		super(servletRequest);
		
		System.out.println(" ************ XSSRequestWrapper  BEGIN");
		
		compiler = new Perl5Compiler();
		matcher = new Perl5Matcher();
		substitutionSingleQuote = new StringSubstitution("&rsquo;");
		substitutionDoubleQuote = new StringSubstitution("&rdquo;");
		substitutionAsteriskQuote = new StringSubstitution("&#42;");
		substitutionMajorQuote = new  StringSubstitution("&gt;");
		substitutionMinorQuote = new StringSubstitution("&lt;");
		
		substitutionAlert = new StringSubstitution("noalert");
		
		try	{
			patternEscapeSingleQuote = compiler.compile("%27", Perl5Compiler.CASE_INSENSITIVE_MASK);
			patternSingleQuote = compiler.compile("[\']", Perl5Compiler.CASE_INSENSITIVE_MASK);
			
			patternEscapeDoubleQuote = compiler.compile("%22", Perl5Compiler.CASE_INSENSITIVE_MASK);
			patternDoubleQuote = compiler.compile("[\"]", Perl5Compiler.CASE_INSENSITIVE_MASK);
			
			patternEscapeAsteriskQuote = compiler.compile("%2a", Perl5Compiler.CASE_INSENSITIVE_MASK);
			patternAsteriskQuote = compiler.compile("[\"]", Perl5Compiler.CASE_INSENSITIVE_MASK);
			
			patternEscapeMajorQuote = compiler.compile("%3E", Perl5Compiler.CASE_INSENSITIVE_MASK);
			patternMajorQuote = compiler.compile("[>]", Perl5Compiler.CASE_INSENSITIVE_MASK);
			
			patternEscapeMinorQuote = compiler.compile("%3C", Perl5Compiler.CASE_INSENSITIVE_MASK);
			patternMinorQuote = compiler.compile("[<]", Perl5Compiler.CASE_INSENSITIVE_MASK);
			
			patternAlert = compiler.compile("alert", Perl5Compiler.CASE_INSENSITIVE_MASK);
		}catch (Exception err)	{
			/**nop**/
		}
		System.out.println(" ************ XSSRequestWrapper  END");
	}

	public String[] getParameterValues(String parameter){
		String[] values = super.getParameterValues(parameter);
		//System.out.println(" ************ XSSRequestWrapper - getParameterValues - BEGIN");
		if (values == null)	{
			return null;
		}

		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++)	{
			encodedValues[i] = stripXSS(values[i]);
			//System.out.println(" ************ XSSRequestWrapper - encodedValues[i]: "+encodedValues[i]);
		}
		//System.out.println(" ************ XSSRequestWrapper - getParameterValues - END");
		return encodedValues;
	}

	public String getParameter(String parameter){
		String value = super.getParameter(parameter);

		return stripXSS(value);
	}

	public String getHeader(String name){
		String value = super.getHeader(name);
		return stripXSS(value);
	}

	private String stripXSS(String value){
		//System.out.println(" ************ XSSRequestWrapper - stripXSS - BEGIN");
		if (value != null && patternAlert != null)	{
			value = Util.substitute(matcher, patternEscapeSingleQuote, substitutionSingleQuote, value, Util.SUBSTITUTE_ALL);
			value = Util.substitute(matcher, patternSingleQuote, substitutionSingleQuote, value, Util.SUBSTITUTE_ALL);
			
			value = Util.substitute(matcher, patternEscapeDoubleQuote, substitutionDoubleQuote, value, Util.SUBSTITUTE_ALL);
			value = Util.substitute(matcher, patternDoubleQuote, substitutionDoubleQuote, value, Util.SUBSTITUTE_ALL);
			
			value = Util.substitute(matcher, patternEscapeAsteriskQuote, substitutionAsteriskQuote, value, Util.SUBSTITUTE_ALL);
			value = Util.substitute(matcher, patternAsteriskQuote, substitutionAsteriskQuote, value, Util.SUBSTITUTE_ALL);
			
			value = Util.substitute(matcher, patternEscapeMajorQuote, substitutionMajorQuote, value, Util.SUBSTITUTE_ALL);
			value = Util.substitute(matcher, patternMajorQuote, substitutionMajorQuote, value, Util.SUBSTITUTE_ALL);
			
			value = Util.substitute(matcher, patternEscapeMinorQuote, substitutionMinorQuote, value, Util.SUBSTITUTE_ALL);
			value = Util.substitute(matcher, patternMinorQuote, substitutionMinorQuote, value, Util.SUBSTITUTE_ALL);
			
			value = Util.substitute(matcher, patternAlert, substitutionAlert, value, Util.SUBSTITUTE_ALL);
		}
		//System.out.println(" ************ XSSRequestWrapper - stripXSS - END");
		return value;
	}
}
