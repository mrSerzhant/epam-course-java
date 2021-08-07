package by.serzhant.loop_app.view.locale;

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

        if (!bundle.containsKey(key)) {
            return key;
        }

        return bundle.getString(key);
    }
}
