package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class ReferencePage {

    public ReferencePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//h1[contains(text(), 'meg, miket')]")
    public WebElement referencePageTitle;

    @FindBy(how = How.XPATH, using = "//app-tag[1]/a[@href='/referenciak/android']")
    public WebElement androidFilter;

    @FindBy(how = How.XPATH, using = "//app-tag[1]/a[@href='/referenciak/react']")
    public WebElement reactFilter;

    @FindBy(how = How.XPATH, using = "//app-tag[1]/a[contains(@href, '/referenciak/teszt')]")
    public WebElement tesztelesFilter;

    @FindBy(how = How.XPATH, using = "//h2[contains(., 'ORIGO app')]")
    public WebElement origo;

    @FindBy(how = How.XPATH, using = "//h2[contains(., 'Planet Budapest')]")
    public WebElement planetBudapest;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-projects/div[3]/div/div[3]/app-project/article/h2")
    public WebElement zoldUt;

    @FindBy(how = How.XPATH, using = "//h2[contains(., 'Act2manage')]")
    public WebElement act2manage;

    @FindBy(how = How.XPATH, using = "//h2[contains(., 'Parlament')]")
    public WebElement parlamentFutar;

    @FindBy(how = How.XPATH, using = "//h2[contains(., 'Hackeragency')]")
    public WebElement hackeragency;

    @FindBy(how = How.XPATH, using = "//h2[contains(., 'OVB')]")
    public WebElement ovbBiztosito;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-projects/div[3]/div/div[1]/app-project/article/h2")
    public WebElement viragosMo;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-projects/div[3]/div/div[2]/app-project/article/h2")
    public WebElement siArena;

    @FindBy(how = How.XPATH, using = "//h2[contains(., 'Turisztikai')]")
    public WebElement mTurisztikai;

    @FindBy(how = How.XPATH, using = "//h2[contains(., 'Bank')]")
    public WebElement mBank;

    @FindBy(how = How.XPATH, using = "//h2[contains(., 'The tenants')]")
    public WebElement tenants;

    @FindBy(how = How.XPATH, using = "//h2[contains(., 'DSS')]")
    public WebElement dss;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-projects/div[2]/div/button")
    public WebElement openFilterButton;

    public void titleDisplayed() {
        referencePageTitle.isDisplayed();
    }

    public void filterByAndroid() {
        androidFilter.isDisplayed();
        androidFilter.click();
    }

    public void filterByReact() {
        reactFilter.isDisplayed();
        reactFilter.click();
    }

    public void filterByTeszteles() {
        openFilterButton.click();
        tesztelesFilter.isDisplayed();
        tesztelesFilter.click();
    }
}

