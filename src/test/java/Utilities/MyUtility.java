package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MyUtility {
    WebDriver driver;

    public MyUtility(WebDriver driver) {
        this.driver=driver;
    }



    public void waitForElement(List<WebElement> webElement, long timeSec)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeSec));
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }
}
