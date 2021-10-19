package stepDefinitions;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.Common;
import pageObjects.HomePage;
import pageObjects.TodayDeals;

import java.util.concurrent.TimeUnit;

public class Steps {
    WebDriver driver;
    HomePage homePage;
    TodayDeals todayDeals;
    Common common;
    PageObjectManager pageObjectManager;
    ConfigFileReader configFileReader;

    @Given("^user is navigating to Amazon$")
    public void navigateToHomePage() throws InterruptedException {
        configFileReader = new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        driver.quit();
    }
}
