/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.report;

import java.awt.Color;

//TAIF-29: itextpdf DEPRECATA sostituita con openpdf (lowagie)
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Font.FontFamily;
import com.lowagie.text.*;

public class FontsForDocuments {

	
    public Font catFont = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
    public Font redFont = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL, Color.RED);
    public Font subFontBold = new Font(Font.TIMES_ROMAN, 16, Font.BOLD);
    public Font subFont = new Font(Font.TIMES_ROMAN, 14, Font.NORMAL);
    public Font normalFont = new Font(Font.TIMES_ROMAN, 10, Font.NORMAL);
    public Font normalFontBlue = new Font(Font.TIMES_ROMAN, 10, Font.NORMAL, Color.RED);
    public Font normalBold = new Font(Font.TIMES_ROMAN, 10, Font.BOLD);
    public Font smallBold = new Font(Font.TIMES_ROMAN, 8, Font.BOLD);
    public Font small = new Font(Font.TIMES_ROMAN, 8, Font.NORMAL);
    public Font verySmall = new Font(Font.TIMES_ROMAN, 6, Font.NORMAL);
    public Font smallUnderline = new Font(Font.TIMES_ROMAN, 8, Font.UNDERLINE);
    public Font normalBoldUnderline = new Font(Font.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE);
    public Font normalUnderline = new Font(Font.TIMES_ROMAN, 12, Font.ITALIC | Font.UNDERLINE);
    public Font normalBold12 = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
    public Font normalBig = new Font(Font.TIMES_ROMAN, 12);
    public Font bigBoldItalic = new Font(Font.TIMES_ROMAN, 12, Font.BOLDITALIC);
    public Font bigItalic = new Font(Font.TIMES_ROMAN, 12, Font.ITALIC);
    public Font normalItalic = new Font(Font.TIMES_ROMAN, 10, Font.ITALIC);
    public Font bigBold = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);

    public Font titoloFont20 = new Font(Font.TIMES_ROMAN, 20, Font.BOLD | Font.UNDERLINE);
    public Font titoloFont18 = new Font(Font.TIMES_ROMAN, 18, Font.BOLD | Font.UNDERLINE);
    public Font titoloFont16 = new Font(Font.TIMES_ROMAN, 16, Font.BOLD | Font.UNDERLINE);
    public Font titoloFont14 = new Font(Font.TIMES_ROMAN, 14, Font.BOLD | Font.UNDERLINE);
    public Font titoloFont12 = new Font(Font.TIMES_ROMAN, 12, Font.BOLDITALIC | Font.UNDERLINE);
    public Font descrFont12 = new Font(Font.TIMES_ROMAN, 12, Font.BOLD );
    public Font titoloFont10 = new Font(Font.TIMES_ROMAN, 10, Font.ITALIC);
    public Font titoloFont16Italic = new Font(Font.TIMES_ROMAN, 16, Font.ITALIC);
    public Font titoloFont18Italic = new Font(Font.TIMES_ROMAN, 18, Font.ITALIC);
    public Font titoloFontBold10 = new Font(Font.TIMES_ROMAN, 10, Font.BOLDITALIC);
    public Font descrFont10 = new Font(Font.TIMES_ROMAN, 10, Font.BOLD);
    public Font catFont22 = new Font(Font.TIMES_ROMAN, 22, Font.BOLD);
    public Font smallItalic = new Font(Font.TIMES_ROMAN, 8, Font.ITALIC);
    public static Font BOLD = new Font();
    public static Font NORMAL = new Font();
	
	
}
