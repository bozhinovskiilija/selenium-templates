package drivers;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;

public interface IDriver {

    WebDriver Initialize(BrowserType browser);
}
