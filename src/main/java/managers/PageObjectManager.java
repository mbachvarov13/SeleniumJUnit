package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.Common;
import pageObjects.HomePage;
import pageObjects.TodayDeals;

public class PageObjectManager {
    WebDriver driver;
    HomePage homePage;
    TodayDeals todayDeals;
    Common common;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public TodayDeals getTodayDeals() {
        return (todayDeals == null) ? todayDeals = new TodayDeals(driver) : todayDeals;
    }

    public Common getCommon() {
        return (common == null) ? common = new Common(driver) : common;
    }

}
