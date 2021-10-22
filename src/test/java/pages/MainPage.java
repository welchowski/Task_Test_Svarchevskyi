package pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    String URL = "https://kulibin.com.ua/";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage goTo() {
        driver.get(URL);
        return this;
    }
}
