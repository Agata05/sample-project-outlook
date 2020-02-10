package selenium.configurations;

public class TestConfig {

    private TypedProperties typedProperties = new TypedProperties("/test_config.properties");
    private static final String KEY_BROWSER = "base_url";
    private static final String KEY_BASE_URL = "base_url";
    private static final String KEY_LOGIN = "login";
    private static final String KEY_PASSWORD = "password";

    public TestConfig() {
    }

    TestConfig(final TypedProperties typedProperties) {
        this.typedProperties = typedProperties;
    }

    public String getBrowser() {
        return this.typedProperties.getValue(KEY_BROWSER);
    }

    public String getBaseUrl() {
        return this.typedProperties.getValue(KEY_BASE_URL);
    }

    public String getLogin() {
        return typedProperties.getValue(KEY_LOGIN);
    }

    public String getPassword() {
        return typedProperties.getValue(KEY_PASSWORD);
    }


}
