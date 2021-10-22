package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public DrillPage drillPage;
    public GrinderPage grinderPage;
    public PerforatorPage perforatorPage;
    public ScrewdriverPage screwdriverPage;
    public MainPage mainPage;

    public List<WebElement> getWebElements(WebElement webElement) {

        List<WebElement> webElementsSize;
        String str = webElement.toString();
        String FindByPath = str.replaceAll(".*-> ", "");
        String By = FindByPath.replaceAll(":.*", "");
        String path = FindByPath.replaceAll(".*: ", "").replaceAll("]$", "");

        switch (By) {
            case ("xpath"):
                webElementsSize = driver.findElements(org.openqa.selenium.By.xpath(path));
                break;
            case ("className"):
                webElementsSize = driver.findElements(org.openqa.selenium.By.className(path));
                break;
            case ("cssSelector"):
                webElementsSize = driver.findElements(org.openqa.selenium.By.cssSelector(path));
                break;
            case ("id"):
                webElementsSize = driver.findElements(org.openqa.selenium.By.id(path));
                break;
            case ("linkText"):
                webElementsSize = driver.findElements(org.openqa.selenium.By.linkText(path));
                break;
            case ("name"):
                webElementsSize = driver.findElements(org.openqa.selenium.By.name(path));
                break;
            case ("partialLinkText"):
                webElementsSize = driver.findElements(org.openqa.selenium.By.partialLinkText(path));
                break;
            case ("tagName"):
                webElementsSize = driver.findElements(org.openqa.selenium.By.tagName(path));
                break;
            default:
                webElementsSize = null;
                System.out.println("ERROR switch parametr");
                break;

        }

        return webElementsSize;
    }

    @BeforeTest(alwaysRun = true)
    public void preConditions() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        // driver.manage().window().setSize(new Dimension(6900, 1000));
        //driver.manage().window().setPosition(new Point(-10, -110));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        drillPage = PageFactory.initElements(driver, DrillPage.class);
        grinderPage = PageFactory.initElements(driver, GrinderPage.class);
        perforatorPage = PageFactory.initElements(driver, PerforatorPage.class);
        screwdriverPage = PageFactory.initElements(driver, ScrewdriverPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.goTo();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        driver.quit();
    }
}
