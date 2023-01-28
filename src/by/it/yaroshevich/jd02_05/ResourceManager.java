package by.it.yaroshevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANSE;

    private static final String baseName = "by.it.yaroshevich.jd02_05.language.text";
    private ResourceBundle resourceBundle;

    ResourceManager(){
        setLocale(Locale.ENGLISH);
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get (String key){
        return resourceBundle.getString(key);
    }
}
