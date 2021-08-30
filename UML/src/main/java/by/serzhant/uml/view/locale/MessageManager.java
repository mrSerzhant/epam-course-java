package by.serzhant.uml.view.locale;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public enum MessageManager {
    EN(ResourceBundle.getBundle("property.language", new Locale("en", "US"))),
    RU(ResourceBundle.getBundle("property.language", new Locale("ru", "RU")));

    private ResourceBundle bundle;

    MessageManager(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public String getString(String key) {
        Enumeration<String> enumeration = bundle.getKeys();

        while (enumeration.hasMoreElements()) {
            String s = enumeration.nextElement();

            if (key.contains(s)) {
                key = key.replace(s, bundle.getString(s));

            }
        }

        return key;
    }
}
