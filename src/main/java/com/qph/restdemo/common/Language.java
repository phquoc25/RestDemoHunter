package com.qph.restdemo.common;

/**
 * Created by quocphan on 10/25/2016.
 * Copyright  Digitized data copyright © 2007, Google Corporation.
 * Copyright © 2008-2009, WenQuanYi Project Board of
 * Trustees, All rights reserved.

 * Droid Sans Fallback extension interface
 * ( http://wenq.org/index.cgi?Fontopia(cn) ),
 * copyright © 2008-2009 mozbug and Qianqian Fang
 * License  : This font is licensed under Apache2.0 or GPLv3
 * with font embedding exceptions (see Appendix B).
 * Read LICENSE_Apache2.txt and LICENSE_GPLv3.txt for details
 */
public enum Language {
    EN("en", "Noto Sans"),
    FR("fr", "Noto Sans"),
    ES("es", "Noto Sans"),
    PT("pt", "Noto Sans"),
    JA("ja", "WenQuanYi Micro Hei"),
    ZH("zh", "WenQuanYi Micro Hei"),
    RU("ru", "Noto Sans"),
    IT("it", "Noto Sans"),
    TR("tr", "Noto Sans"),
    AR("ar", "Noto Sans"),
    H1("h1", "Noto Sans"),
    ;

    public static final String DEFAULT_FONT = "Arial";
    private String languageCode;
    private String fontFamily;

    Language(String languageCode, String fontFamily) {
        this.languageCode = languageCode;
        this.fontFamily = fontFamily;
    }

    public String getLanguageCode() {
        return languageCode;
    }
    public String getFontFamily() {
        return fontFamily;
    }

    public static String getFontByLanguage(String languageCode){
        for(Language language : Language.values()){
            if (language.getLanguageCode().equalsIgnoreCase(languageCode)){
                return language.getFontFamily();
            }
        }
        return DEFAULT_FONT;
    }
}
