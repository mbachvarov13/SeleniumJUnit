package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TodayDeals {

    @FindBy(how = How.XPATH, using = "//div[@data-id='deals-collection-TB']")
    public WebElement topBrandsBtn;

    public TodayDeals(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnTopBrands() {
        topBrandsBtn.click();
    }
}
