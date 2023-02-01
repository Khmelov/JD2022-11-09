package by.it.vasileuskaya.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private ResourceBundle bundle;

    ResMan() {
        setLocale(Locale.ENGLISH);
    }

    private static final String baseName = "by.it.vasileuskaya.jd02_05.language.text";

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
