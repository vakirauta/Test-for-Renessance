package Test1;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class BaseSetup {

    WebDriver driver;
    Settings settings = new Settings();

    public WebDriver getDriver() {
        return driver;
    }

    public ChromeOptions getChromPref() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        String downloadFilepath = settings.pathDownloadFile;
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("download.default_directory", downloadFilepath);
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.directory_upgrade", true);
        ChromeOptions options = new ChromeOptions();
        return options.setExperimentalOption("prefs", chromePrefs);
    }



    public void initializeTestBaseSetup() {
        try {
            driver = new ChromeDriver(getChromPref());
         } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }
    @Step("Открыть сайт rencredit.ru")
    public void openBrowser() {
        driver.get(settings.getAdressWebSite());
    }

    public void tearDown() {
        driver.quit();
    }
}
