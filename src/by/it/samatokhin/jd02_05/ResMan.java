package by.it.samatokhin.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private static ResourceBundle resourceBundle;


    ResMan() {
        setLocale(Locale.ENGLISH);
    }

    private static final String baseName = "by.it.samatokhin.jd02_05.language.text";


    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public static String get(String key) {
        return resourceBundle.getString(key);
    }
}
