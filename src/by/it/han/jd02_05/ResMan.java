package by.it.han.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {

    INSTANCE;
    private static final String baseName = "by.it.han.jd02_05.language.text";

    private ResourceBundle resourceBundle;

    ResMan() {
        setLocal(new Locale("en"));
    }


    public void setLocal(Locale local) {
        resourceBundle = ResourceBundle.getBundle(baseName, local);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

}
