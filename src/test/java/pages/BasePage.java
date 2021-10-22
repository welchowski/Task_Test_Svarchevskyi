package pages;

import locators.Locators;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

public class BasePage extends Locators {

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 2);
    }

    public void takeScreenShoot(String pathAndNAmeFile) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(pathAndNAmeFile);

        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitVisibility(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

    public void click(WebElement webElement) {
        waitVisibility(webElement);
        webElement.click();
    }

    public void isElementDispleyed(WebElement webElement, String message_error) {

        Assert.assertTrue(webElement.isDisplayed(), message_error);
    }

    public String dateNow() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        return dateFormat.format(date);
    }

    public BasePage nextPage() {

        next_page.click();
        return this;
    }

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

    public int random(int numOfCards) {
        int min = 0;
        int max = numOfCards;
        int diff = max - min;
        Random random = new Random();
        return random.nextInt(diff + 1) + min;
    }

    public void waiting(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollTo(WebElement webElement) {
        Actions action = new Actions(driver);
        action.moveToElement(webElement).build().perform();
    }

    public String getText(WebElement webElement) {
        return webElement.getText();
    }

    public void isElementPresent(WebElement webElement, String message_error) {
        try {
            webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println(message_error);
            e.printStackTrace();
        }
    }

    public void CloseaLERT() {
        driver.findElement(By.className("close-prompt")).click();
    }

    public void CloseADDWindow() {
        driver.findElement(By.className("custom-close")).click();
    }

    protected void AlertDissmiss() {
        driver.switchTo().alert().dismiss();
    }

    public BasePage selelectOnMenuAndClick(WebElement webElement, WebElement webElement_1, WebElement webElement_2) {
        Actions actions = new Actions(driver);
        webElement.click();
        WebElement menu = webElement_1;
        WebElement elementInMenu = webElement_2;
        actions.moveToElement(menu).moveToElement(elementInMenu).click().build().perform();
        return this;
    }

    public void back() {
        driver.navigate().back();
    }

    public void randomClick(List<WebElement> webElements, int randNumber) {
        webElements.get(randNumber).click();
    }

    public String getNameOfGoodsWithSale(int a) {
        return "";
    }

    public void print(String str) {
        System.out.println(str);
    }
}
