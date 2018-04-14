package ai.immigration.immigration.data.model;

import java.util.HashMap;

public class User {

    private HashMap<String, String> info;
    private static User user;

    private User() { }

    public static User getUserInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public boolean hasField(String field) {
        return info.containsKey(field);
    }

    public void addField(String field, String value) {
        info.put(field, value);
    }
}
