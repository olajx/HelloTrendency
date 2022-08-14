package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    ReferencePage referencePage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'header__hamburger-menu')]")
    private WebElement hamburgerMenu;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-nav/div[1]/nav/ul/li[2]/a")
    public WebElement referencesMenuItem;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(), '99%')]")
    public WebElement homePageTitle;

    @FindBy(how = How.XPATH, using = "//button[contains(., 'Elfogadom')]")
    public WebElement acceptCookiesButton;


    public void openHamburgerMenu() {
        hamburgerMenu.click();
    }

    public void clickReferencesMenuItem() {
        referencesMenuItem.click();
    }

    public void titleDisplayed() {
        homePageTitle.isDisplayed();
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

    public void selectMenuItem(String item){
        referencePage = new ReferencePage(driver);

        switch (item) {
            case "Home":
                titleDisplayed();
                break;
            case "References":
                referencePage.titleDisplayed();
        }
    }
}
