package pageObjects;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.processing.Filer;

public class Common {
    WebDriver driver;

    public Common(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }
}
