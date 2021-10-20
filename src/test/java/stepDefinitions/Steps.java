package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pageObjects.Common;
import pageObjects.HomePage;
import pageObjects.TodayDeals;

public class Steps {
    WebDriver driver;
    HomePage homePage;
    TodayDeals todayDeals;
    Common common;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;

    @Given("^user is navigating to Amazon$")
    public void navigateToHomePage() throws InterruptedException {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
        common = pageObjectManager.getCommon();
        common.navigateToHomePage();
    }

    @When("^user click on Today's Deals$")
    public void userClickOnTodayDeals() {
        homePage = pageObjectManager.getHomePage();
        homePage.clickOnTodayDeals();
    }

    @Then("^user is able to click on Top Brands$")
    public void userClickOnTopBrands() throws InterruptedException {
        todayDeals = pageObjectManager.getTodayDeals();
        todayDeals.clickOnTopBrands();
        Thread.sleep(3000);
    }

    @After
    public void AfterSteps() {
        webDriverManager.closeDriver();
    }
}
