package Base;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DriversFactory {

    private  static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();


    public static WebDriver getDriver(){
        if(webDriver.get()==null)
        {
            webDriver.set(initializeDriver());
        }

        return webDriver.get();


    }

    public static String getBrowserType() throws IOException {
        System.out.println(System.getProperty("user.dir"));
        FileReader fr = new FileReader(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties"));
        Properties prop = new Properties();
        prop.load(fr);
        String browserType = (String) prop.get("browser");
        return browserType;

    }
    private  static WebDriver initializeDriver() {

        WebDriver driver =null;
        try {
            String browser = getBrowserType();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    driver = new FirefoxDriver(firefoxOptions);
                    driver.manage().window().maximize();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    driver.manage().window().maximize();
                    break;

            }
        }catch (Exception e)
        {
            e.getStackTrace();
        }
        return driver;
    }

    public static void closeDriver()
    {
        webDriver.get().quit();
        webDriver.remove();
    }


}

