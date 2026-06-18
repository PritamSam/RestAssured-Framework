package auth;

import config.ConfigReader;

public class AuthManager {
    private AuthManager() {}

    public static String getApiKey() {

        return ConfigReader.get("api.key");
    }
}
