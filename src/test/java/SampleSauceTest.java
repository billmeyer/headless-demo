import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SampleSauceTest
{

    public static final String USERNAME = System.getenv("HEADLESS_USERNAME");
    public static final String ACCESS_KEY = System.getenv("HEADLESS_ACCESS_KEY");
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-east1.headless.saucelabs" +
            ".com:4444";

    public static void main(String[] args)
    throws Exception
    {

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "linux");
        caps.setCapability("browser", "chrome");
        caps.setCapability("version", "latest");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        /**
         * Goes to Sauce Lab's guinea-pig page and prints title
         */

        driver.get("https://saucelabs.com/test/guinea-pig");
        System.out.println("title of page is: " + driver.getTitle());

        driver.quit();
    }
}
