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
import org.openqa.selenium.NoSuchElementException;
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

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
        homePage.selectMenuItem(title);
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
        referencePage.filterBy(filter);
    }

    @Then("^I should see the following references:$")
    public void iShouldSeeTheFollowingReferences(DataTable dataTable) {
        referencePage = new ReferencePage(driver);
        List<String> referenceList = dataTable.asList(String.class);

        int i = 0;

        while (i < referenceList.size()) {
            String inputRef = referenceList.get(i);

            try {
                String actualRef = referencePage.getText(inputRef);
                Assert.assertEquals(inputRef, actualRef);
                System.out.println("Cool, " + inputRef +" is displayed!");
            }

            catch (NoSuchElementException e) {
                System.out.println("Oh, " + inputRef +" is not displayed. :(");
            }

            i++;
        }
    }
}
