package PageObjects;

import Base.Hooks;
import Utilities.MyUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Base.DriversFactory.getDriver;

public class GoogleSearchPage {

    private WebDriver driver= getDriver();
    public MyUtility utility;


    public GoogleSearchPage() {
        PageFactory.initElements(driver, this);
        utility = new MyUtility(driver);
    }

    @FindBy(id = "APjFqb")
    WebElement searchBox;

    @FindAll(@FindBy(xpath = "//span[@class='VuuXrf']"))
    List<WebElement> firstResult;

    public void enterSearchItem(String searchItem) {
        searchBox.clear();
        searchBox.sendKeys(searchItem+"\n");


    }

    public String getFirstResultName() throws InterruptedException {
        String firstResultName="";
        utility.waitForElement(firstResult,20);
        System.out.println(firstResult);
        firstResultName = firstResult.get(0).getText();
        return firstResultName;
    }

    public void openURL(String arg0) {
        driver.get(arg0);
    }
}
