package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.ReferencePage;
import pageObjects.HomePage;

import java.text.Normalizer;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class Stepdefs {

    WebDriver driver;

    HomePage homePage;
    ReferencePage referencePage;

    String url = "https://trendency.hu";

    //normalize&remove hun accents character
    private static String normalize(String input) {
        return input == null ? null : Normalizer.normalize(input, Normalizer.Form.NFKD);
    }
    static String removeAccents(String input) {
        return normalize(input).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Implicit wait timeout for 15seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Given("I navigate to Home page")
    public void iNavigateToHomePage() {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
    }

    @Given("I open the hamburger menu")
    public void iOpenTheHamburgerMenu() {
        homePage = new HomePage(driver);
        homePage.openHamburgerMenu();
    }

    @Then("I should see the {string} page title")
    public void iShouldSeeTheTitle(String title) {
        homePage = new HomePage(driver);
        referencePage = new ReferencePage(driver);
        switch (title) {
            case "Home":
                homePage.titleDisplayed();
                break;
            case "References":
                referencePage.titleDisplayed();
        }
    }

    @When("I select the {string} menu item")
    public void iSelectTheMenuItem(String menuItem) {
        homePage = new HomePage(driver);

        if (Objects.equals(menuItem, "Reference")) {
            homePage.clickReferencesMenuItem();
        }
    }

    @When("I filter by {string}")
    public void iFilterBy(String filter) {
        referencePage = new ReferencePage(driver);

        switch (filter) {
            case "Android":
                referencePage.filterByAndroid();
                break;
            case "React":
                referencePage.filterByReact();
                break;
            case "Teszteles":
                referencePage.filterByTeszteles();
                break;
        }
    }

    @Then("^I should see the following references:$")
    public void iShouldSeeTheFollowingReferences(DataTable dataTable) {
        List<String> referenceList = dataTable.asList(String.class);
        String header = "";

        int i = 0;
        while (i < referenceList.size()) {
            switch (referenceList.get(i)) {
                case "origo":
                    referencePage.origo.isDisplayed();
                    header = referencePage.origo.getText();
                    Assert.assertEquals("ORIGO app", header);
                    System.out.println(header + " is displayed");
                    break;

                case "planet":
                    referencePage.planetBudapest.isDisplayed();
                    header = referencePage.planetBudapest.getText();
                    Assert.assertEquals("Planet Budapest 2021 Fenntarthatosagi Expo es Vilagtalalkozo", removeAccents(header));
                    System.out.println(header + " is displayed");
                    break;

                case "zoldut":
                    referencePage.zoldUt.isDisplayed();
                    header = referencePage.zoldUt.getText();
                    Assert.assertEquals("Zold ut", removeAccents(header));
                    System.out.println(header + " is displayed");
                    break;

                case "act2manage":
                    referencePage.act2manage.isDisplayed();
                    header = referencePage.act2manage.getText();
                    Assert.assertEquals("Act2manage", removeAccents(header));
                    System.out.println(header + " is displayed");
                    break;

                case "parlament":
                    referencePage.parlamentFutar.isDisplayed();
                    // remove qoutes
                    header = referencePage.parlamentFutar.getText();
                    Assert.assertEquals("Parlament", removeAccents(header).substring(0, 9));
                    System.out.println(header + " is displayed");
                    break;

                case "hackerAgency":
                    referencePage.hackeragency.isDisplayed();
                    header = referencePage.hackeragency.getText();
                    Assert.assertEquals("Hackeragency", header);
                    System.out.println(header + " is displayed");
                    break;

                case "ovb":
                    referencePage.ovbBiztosito.isDisplayed();
                    header = referencePage.ovbBiztosito.getText();
                    Assert.assertEquals("OVB biztosito", removeAccents(header));
                    System.out.println(header + " is displayed");
                    break;

                case "viragosMo":
                    referencePage.viragosMo.isDisplayed();
                    header = referencePage.viragosMo.getText();
                    Assert.assertEquals("Viragos Magyarorszag", removeAccents(header));
                    System.out.println(header + " is displayed");
                    break;

                case "siarena":
                    referencePage.siArena.isDisplayed();
                    header = referencePage.siArena.getText();
                    Assert.assertEquals("Siarena", removeAccents(header));
                    System.out.println(header + " is displayed");
                    break;

                case "magyarTurUgy":
                    referencePage.mTurisztikai.isDisplayed();
                    header = referencePage.mTurisztikai.getText();
                    Assert.assertEquals("Magyar Turisztikai Ugynokseg", removeAccents(header));
                    System.out.println(header + " is displayed");
                    break;

                case "magyarFejlBank":
                    referencePage.mBank.isDisplayed();
                    header = referencePage.mBank.getText();
                    Assert.assertEquals("Magyar Fejlesztesi Bank", removeAccents(header));
                    System.out.println(header + " is displayed");
                    break;

                case "TheTVoice":
                    referencePage.tenants.isDisplayed();
                    header = referencePage.tenants.getText();
                    Assert.assertEquals("The tenants' voice", header);
                    System.out.println(header + " is displayed");
                    break;

                case "dssCons":
                    referencePage.dss.isDisplayed();
                    header = referencePage.dss.getText();
                    Assert.assertEquals("DSS consulting", header);
                    System.out.println(header + " is displayed");
                    break;
            }
            i++;
        }
    }
}
