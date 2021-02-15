package app.pure.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/authorization.properties"
})
public interface AuthorizationConfig extends Config {
    @Key("google.username")
    String googleUsername();

    @Key("google.password")
    String googlePassword();
}
