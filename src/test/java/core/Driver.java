package core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null){
            init();
        }
        return driver;
    }

    private static void set(WebDriver driverInput) {
        driver = driverInput;
    }

    public static void init() {
        Properties properties = new Properties();
        FileInputStream propFile;
        try {
            propFile = new FileInputStream("test.properties");
            properties.load(propFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        @SuppressWarnings("unchecked")
        Enumeration<String> e = (Enumeration<String>) properties.propertyNames();
        while (e.hasMoreElements()) {
            String key = e.nextElement();
            System.setProperty(String.valueOf(key), properties.getProperty(String.valueOf(key)));
            Reporter.log(key + " - " + properties.getProperty(String.valueOf(key)), 2, true);
        }
        WebDriver driverInput;
        switch (System.getProperty("test.browser")) {
            case "firefox":
                FirefoxProfile profile = new FirefoxProfile();
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Oleksandr_Senkevych\\Downloads\\geckodriver-v0.18.0-win64\\geckodriver.exe");
                profile.setPreference("driver.helperApps.alwaysAsk.force", false);
                profile.setPreference("driver.download.folderList", 2);
                profile.setPreference("driver.download.dir", "C:\\tmp");
                profile.setPreference("services.sync.prefs.sync.driver.download.manager.showWhenStarting", false);
                profile.setPreference("driver.download.useDownloadDir", true);
                profile.setPreference("driver.helperApps.neverAsk.saveToDisk", "application/zip, application/x-gzip, image/bmp");
                driverInput = new FirefoxDriver(profile);
                break;
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driverInput = new ChromeDriver();
                driverInput.manage().window().maximize();
                break;

            default:
                throw new AssertionError("Unsupported driver: " + System.getProperty("test.browser"));
        }
        driverInput.manage().timeouts().implicitlyWait(
                Integer.parseInt(System.getProperty("test.timeout")),
                TimeUnit.SECONDS);
        Driver.set(driverInput);
    }

    public static void tearDown() {
        Driver.get().quit();
        driver = null;
    }
}
