package baseTestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtil{
    public WebDriver driver;

    private String browser, targetURL;
    private int implicitWait;

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void setupDriverAndOpenTargetUrl() {
        readConfig("src/test/resources/config.properties");
        setupDriver();
        driver.manage().timeouts().implicitlyWait(Duration.from(Duration.ofSeconds(implicitWait)));
        driver.get(targetURL);
    }


    private void readConfig(String pathToFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);

            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
            targetURL = properties.getProperty("url");
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    private void setupDriver() {
        switch (browser){
            case "chrome":
                driver = setupChromeDriver();
                break;
            case "firefox":
                driver = setupFirefoxDriver();
                break;

        }

    }
    private WebDriver setupChromeDriver (){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    private WebDriver setupFirefoxDriver () {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

}

