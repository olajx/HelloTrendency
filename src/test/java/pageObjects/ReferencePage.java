package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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

    public void filterBy(String filter) {
        switch (filter) {
            case "Android":
                androidFilter.isDisplayed();
                androidFilter.click();
                break;

            case "React":
                reactFilter.isDisplayed();
                reactFilter.click();
                break;

            case "Tesztelés":
                openFilterButton.click();
                tesztelesFilter.isDisplayed();
                tesztelesFilter.click();
                break;
        }

    }

    public String getText(String text) {
        String ref = "";
            switch (text) {
                case "ORIGO app":
                    ref = origo.getText();
                    break;

                case "Planet Budapest 2021 Fenntarthatósági Expó és Világtalálkozó":
                    ref = planetBudapest.getText();
                    break;

                case "Zöld út":
                    ref = zoldUt.getText();
                    break;

                case "Act2manage":
                    ref = act2manage.getText();
                    break;

                case "Parlament „E-futár”":
                    ref = parlamentFutar.getText();
                    break;

                case "Hackeragency":
                    ref = hackeragency.getText();
                    break;

                case "OVB biztosító":
                    ref = ovbBiztosito.getText();
                    break;

                case "Virágos Magyarország":
                    ref = viragosMo.getText();
                    break;

                case "Síaréna":
                    ref = siArena.getText();
                    break;

                case "Magyar Turisztikai Ügynökség":
                    ref = mTurisztikai.getText();
                    break;

                case "Magyar Fejlesztési Bank":
                    ref = mBank.getText();
                    break;

                case "The tenants' voice":
                    ref = tenants.getText();
                    break;

                case "DSS consulting":
                    ref = dss.getText();
                    break;
        }
        return ref;
    }
}

