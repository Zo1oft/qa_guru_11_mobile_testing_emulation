package config;

import org.aeonbits.owner.ConfigFactory;

public class Validation {
        public static BrowserstackConfig configBrowserstack = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
        public static EmulationConfig configEmulation = ConfigFactory.create(EmulationConfig.class, System.getProperties());
}
