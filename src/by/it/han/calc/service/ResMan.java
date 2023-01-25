package by.it.han.calc.service;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {

    INSTANCE;
    private static final String baseName = "by.it.han.calc.resources.language.text";
    private static final String USER_LANGUAGE = "user.language";

    private ResourceBundle resourceBundle;

    ResMan() {
        String userLanguage = System.getProperty(USER_LANGUAGE);
        setLocal(new Locale(userLanguage));
    }


    public void setLocal(Locale local) {
        resourceBundle = ResourceBundle.getBundle(baseName, local);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

}