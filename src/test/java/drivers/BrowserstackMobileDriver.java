package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Validation;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities caps) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(caps);

        mutableCapabilities.setCapability("browserstack.appium_version", "1.22.0");
        mutableCapabilities.setCapability("browserstack.user", Validation.configBrowserstack.username());
        mutableCapabilities.setCapability("browserstack.key", Validation.configBrowserstack.password());
        mutableCapabilities.setCapability("app", Validation.configBrowserstack.app());
        mutableCapabilities.setCapability("device", "Samsung Galaxy S22 Plus");
        mutableCapabilities.setCapability("os_version", "12.0");
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(Validation.configBrowserstack.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
