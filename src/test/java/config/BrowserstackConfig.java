package config;
import org.aeonbits.owner.Config;
@Config.Sources({"classpath:browserstack.properties"})
public interface BrowserstackConfig extends Config {
        @Config.Key("username")
        String username();

        @Config.Key("password")
        String password();

        @Config.Key("app")
        String app();

        @Config.Key("url")
        String url();
}
