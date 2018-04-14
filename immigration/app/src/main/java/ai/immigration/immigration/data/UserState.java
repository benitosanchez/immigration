package ai.immigration.immigration.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

public class UserState {
    private HashMap<String, String> user_info;

    public UserState() {
        user_info = new HashMap<>();
    }

    public void SetUserInfo(String key, String val) {
        user_info.put(key, val);
    }

    public String GetUserInfo(String key) {
        return user_info.get(key);
    }

    public String ToJsonString() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(user_info);
    }
}
