/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.xss;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

/**
 * Anti cross-site scripting (XSS) filter by AM
 * 
 * JDK 1.3+
 * 
 * dependency : Jakarta ORO
 * 
 * ivy.xml:
 * 
 * <dependency org="apache" name="jakarta-oro" rev="2.0.8"> <artifact
 * name="jakarta-oro-2.0.8" type="jar" /> </dependency>
 * 
 * 
 * web.xml
 * 
 * <filter> <filter-name>XSSFilter</filter-name>
 * <filter-class>it.csi.sipe.util.XSSFilter</filter-class> </filter>
 * <filter-mapping> <filter-name>XSSFilter</filter-name>
 * <servlet-name>action</servlet-name> <url-pattern>*.do</url-pattern>
 * </filter-mapping>
 *
 * @author Agostino Moronese
 * @version 1.0
 * @since 2016-02-04
 */
public class XSSFilter implements Filter {
	
	
	public XSSFilter()	{
		/**nop**/
	}

	public void init(FilterConfig fConfig) throws ServletException	{
		// implementation method
	}

	public void destroy()	{
		// implementation method
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException	{	
		System.out.println(" - XSS FILTER SONO QUI?");

	    
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String method = httpServletRequest.getMethod();
		if (!"post".equalsIgnoreCase(method) && !"get".equalsIgnoreCase(method)){
			//System.out.println(" ************ doFilter  POST OR GET");
			((HttpServletResponse) response).sendError(403);
		}else{
			//System.out.println(" ************ doFilter  ELSE");
			if (testXSS(httpServletRequest))
				doFilterError(request, response);
			else
				doFilterSanitize(httpServletRequest, response, chain);
		}
	}

	private void doFilterSanitize(HttpServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException	{
		chain.doFilter(new XSSRequestWrapper(request), response);
	}

	// ===========================================================================
	private void doFilterError(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException	{
		servletResponse.setContentType("text/html");
		PrintWriter out = servletResponse.getWriter();
		out.println("<br/><br/>Anti cross-site scripting (XSS) filter by AM<br/><br/>");
	}

	private boolean testXSS(HttpServletRequest servletRequest)	{
		//System.out.println(" ************ testXSS BEGIN");
		try	{
			String paramValue = null;
			Enumeration<?> enumeration = servletRequest.getParameterNames();
			while (enumeration.hasMoreElements())	{
				paramValue = servletRequest.getParameter((String) enumeration.nextElement());
				//System.out.println(" PARAM VALUE: "+paramValue);
				if (textXSS(paramValue))
					return true;
			}

			String headerValue = null;
			enumeration = servletRequest.getHeaderNames();
			while (enumeration.hasMoreElements())	{
				headerValue = servletRequest.getParameter((String) enumeration.nextElement());

				if (textXSS(headerValue))
					return true;
			}
		}catch (IOException ex)	{
			return true;
		}
		
		System.out.println(" ************ testXSS END");

		return false;
	}

	private boolean textXSS(String valueInput) throws IOException{
		if (valueInput != null)	{	
			
			String value = URLDecoder.decode(valueInput, "UTF-8");
			//System.out.println("************ testXSS  CONTROLLO BEGIN - value: "+value);
			value = StringEscapeUtils.unescapeHtml4(value);
			value = value.replaceAll("\n", "");
			value = value.replaceAll("`", "'");
			value = value.replaceAll(" ", "");
			
			
			try	{
				// Avoid null characters
				
				PatternCompiler compiler = new Perl5Compiler();
				PatternMatcher matcher = new Perl5Matcher();

				// Avoid anything between script tags
				Pattern scriptPattern = compiler.compile("<script>(.*?)</script>", Perl5Compiler.CASE_INSENSITIVE_MASK);
				boolean match = matcher.contains(value, scriptPattern);
				if (match)
					return true;
				
				// Avoid anything in a src='...' type of expression
				scriptPattern = compiler.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Perl5Compiler.CASE_INSENSITIVE_MASK | Perl5Compiler.MULTILINE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;

				scriptPattern = compiler.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Perl5Compiler.CASE_INSENSITIVE_MASK | Perl5Compiler.MULTILINE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;

				// Remove any lonesome </script> tag
				scriptPattern = compiler.compile("</script>", Perl5Compiler.CASE_INSENSITIVE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;

				// Remove any lonesome <script ...> tag
				scriptPattern = compiler.compile("<script(.*?)>", Perl5Compiler.CASE_INSENSITIVE_MASK | Perl5Compiler.MULTILINE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;

				// Avoid eval(...) expressions
				scriptPattern = compiler.compile("eval\\((.*?)\\)", Perl5Compiler.CASE_INSENSITIVE_MASK | Perl5Compiler.MULTILINE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;

				// Avoid expression(...) expressions
				scriptPattern = compiler.compile("expression\\((.*?)\\)", Perl5Compiler.CASE_INSENSITIVE_MASK | Perl5Compiler.MULTILINE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;
				
				// Avoid expression(...) xss
				scriptPattern = compiler.compile("xss:.*?\\((.*?)\\)", Perl5Compiler.CASE_INSENSITIVE_MASK | Perl5Compiler.MULTILINE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;
				
				
				// Avoid expression(...) iFrame
				scriptPattern = compiler.compile("iframe.*?", Perl5Compiler.CASE_INSENSITIVE_MASK | Perl5Compiler.MULTILINE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;
				

				// Avoid javascript:... expressions
				scriptPattern = compiler.compile("javascript:", Perl5Compiler.CASE_INSENSITIVE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;

				// Avoid vbscript:... expressions
				scriptPattern = compiler.compile("vbscript:", Perl5Compiler.CASE_INSENSITIVE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;

				// Avoid onload= expressions
				scriptPattern = compiler.compile("onload(.*?)=", Perl5Compiler.CASE_INSENSITIVE_MASK | Perl5Compiler.MULTILINE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;

				// Avoid onmouseover
				scriptPattern = compiler.compile("onmouse*(.*?)=", Perl5Compiler.CASE_INSENSITIVE_MASK | Perl5Compiler.MULTILINE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;
				
				// Avoid onfocus
				scriptPattern = compiler.compile("onfocus(.*?)=", Perl5Compiler.CASE_INSENSITIVE_MASK | Perl5Compiler.MULTILINE_MASK);
				match = matcher.contains(value, scriptPattern);
				if (match)
					return true;

			}catch (MalformedPatternException ex)	{
				ex.printStackTrace();
				//throw new IOException("XSS attack!");
				return true;

			 }	finally	{
				// System.out.println(" ************ testXSS  CONTROLLO END");
			}
		}

		
		return false;
	}
	
}
