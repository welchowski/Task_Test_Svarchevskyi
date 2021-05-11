import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

public class MainTest {


    WebDriver driver;

    @BeforeTest

    public void preConditions() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kulibin.com.ua/");


    }

    @Test(enabled = true)
    public void Test1() throws InterruptedException {
        System.out.println("TEST1");
        //clickOnMenu



        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//a[@href='/catalog/']")).click();
        WebElement menu = driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']"));
        WebElement elementInMenu = driver.findElement(By.xpath("//a[@href='/catalog/dreli/']"));
        actions.moveToElement(menu).moveToElement(elementInMenu).click().build().perform();


//        driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']")).click();
//        driver.findElement(By.xpath("//a[@title='Дрели']")).click();
//        driver.findElements(By.className("old-price"));


        //sizeElements

        List<WebElement> xpath = driver.findElements(By.xpath("//span[@style='display:block;']"));
        int xpathCount = xpath.size();
        System.out.println("Total xpath: " + xpathCount);

        int numberCards = 3;

        //RandomClickAndCheck
        for (int i = 0; i < numberCards; i++) {
            //numberRandomCards

            int min = 1;
            int max = xpathCount;
            int diff = max - min;
            Random random = new Random();
            int j = random.nextInt(diff + 1) + min;

            driver.findElement(By.xpath("(//span[@style='display:block;']/../../../a)[" + j + "]")).click();
            System.out.println("rand value " + i + ": " + j);

            if (driver.findElements(By.xpath("//span[@class='item_old_price old-price']")).size() != 0) {
                System.out.println("Element old_price is Present");
 
                int ede = driver.findElements(By.xpath("//span[@class='item_old_price old-price']")).size();
                System.out.println(ede);

            } else {
                // Assert.fail("Element old_price is NOT Present");
                System.out.println("Element old_price is NOT Present");
            }

            if (driver.findElements(By.xpath("//div[@class='item-print-block']//span[@class='price']")).size() != 0) {
                System.out.println("Element price is Present");

            } else {
                // Assert.fail("Element price is NOT Present");
                System.out.println("Element price is NOT Present");
            }
            driver.navigate().back();
        }
    }

    @Test(dependsOnMethods = {"Test1"}, alwaysRun = true)
    public void Test2() throws InterruptedException {

        System.out.println("TEST2");

//            Actions builder = new Actions(driver);
//            builder.moveToElement(driver.findElement(By.xpath("//a[@href='/catalog/']")));
//            builder.moveToElement(driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']")));
//            builder.moveToElement(driver.findElement(By.xpath("//a[@href='/catalog/perforatory/']")));
//            builder.click(driver.findElement(By.xpath("//a[@href='/catalog/perforatory/']")));

        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//a[@href='/catalog/']")).click();
        WebElement menu = driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']"));
        WebElement elementInMenu = driver.findElement(By.xpath("//a[@href='/catalog/perforatory/']"));
        actions.moveToElement(menu).moveToElement(elementInMenu).click().build().perform();

        List<WebElement> sizeList = driver.findElements(By.xpath("//li[@class='col-xs-4 js-product']"));
        int listCount = sizeList.size();

        System.out.println("Value lists: " + listCount);
        int elmtNumber = 0;
        int valuePage = 2;
        for (int i = 1; i <= valuePage; i++) {

            for (int j = 0; j < listCount; j++) {
                elmtNumber++;
                if (driver.findElements(By.xpath("//span[@class='price']")).size() != 0) {
                    // Assert.fail(elmtNumber+"Element price is Present");
                    System.out.println(elmtNumber + " Element price is Present");
                } else {
                    // Assert.fail(elmtNumber+"Element price is NOT Present");
                    System.out.println(elmtNumber + "Element price is NOT Present");
                }
            }
            if (i < valuePage) driver.findElement(By.partialLinkText("Следующая")).click();
        }

        System.out.println("TEST2");
    }

    @Test
    public void Test3() throws InterruptedException {
//        Перейти в раздел "Электроинструменты" / "Шуруповерты"
//        Вывести "Наименование" всех товаров у которых есть иконка с американским флагом на первых 3х страницах

        System.out.println("TEST3");
        Actions aactions = new Actions(driver);
        driver.findElement(By.xpath("//a[@href='/catalog/']")).click();
        WebElement menu = driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']"));
        WebElement elementInMenu = driver.findElement(By.xpath("//a[@href='/catalog/shurupoverty/']"));
        aactions.moveToElement(menu).moveToElement(elementInMenu).click().build().perform();

        int numbrPages = 3;
        int USAPath = driver.findElements(By.xpath("//img[contains(@src, 'United_states.jpg')]")).size();
        System.out.println(USAPath);
        for (int i = 1; i <= numbrPages; i++) {

            for (int j = 0; j <= USAPath; j++) {
                System.out.println(driver.findElement(By.xpath("//a[@class='title google_detail_link']/span")).getText() + " it USA");
            }
            if (i < numbrPages) driver.findElement(By.partialLinkText("Следующая")).click();
        }
    }

    @Test
    public void Test4() throws InterruptedException {
        System.out.println("TEST4");
//        В разделе "Электроинструменты" / "Болгарки"
//        Для 10 рандомных товаров с пометкой "Акция" провести расчет акционной цены относительно старой используя процент скидки.
//        В assert упавшего теста вывести наименование товара его ожидаемую и фактическую цену.

        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//a[@href='/catalog/']")).click();
        WebElement menu = driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']"));
        WebElement elementInMenu = driver.findElement(By.xpath("//a[@href='/catalog/bolgarki/']"));
        actions.moveToElement(menu).moveToElement(elementInMenu).click().build().perform();

        String oldPrice;
        String price;
        String saleCards;
        String nameWere;
        int valuePrice;
        int valueOldPrice;
        int sale;
        int valueWere = 0;
        int j;
        int cardsCount = 2;
        int actualRezult;
        int expectedResult;

        while (valueWere < 10) {

            for (int i = 0; i < 2; i++) {

                //numberRandomCards
                List<WebElement> cardsOfSales = driver.findElements(By.xpath("//span[@style='display:block;']"));
                cardsCount = cardsOfSales.size();
                //generateRandom
                System.out.println("Total xpath: " + cardsCount);
                int min = 1;
                int max = cardsCount;
                int diff = max - min;
                Random random = new Random();
                j = random.nextInt(diff + 1) + min;
                System.out.println();

                oldPrice = driver.findElement(By.xpath("(//span[contains(text(),'%')]/../../../..//span[@class='old-price'])[" + j + "]")).getText();

                valueOldPrice = Integer.parseInt(oldPrice.replaceAll("[^0-9]", ""));

                price = driver.findElement(By.xpath("(//span[contains(text(),'%')]/../../../..//span[@class='price'])[" + j + "]")).getText();

                valuePrice = Integer.parseInt(price.replaceAll("[^0-9]", ""));

                saleCards = driver.findElement(By.xpath("(//span[@style='display:block;'])[" + j + "]")).getText();

                sale = Integer.parseInt(saleCards.replaceAll("[^0-9]", ""));

                nameWere = driver.findElement(By.xpath("(//span[@style='display:block;']/../../../..//h4[@class='s_title']//span)[" + j + "]")).getText();


                actualRezult = (valueOldPrice + sale) / 100;
                int actualREZULT = valuePrice - actualRezult;
                expectedResult = valuePrice;


                // Assert.assertNotEquals(actualREZULT, expectedResult,nameWere);
                System.out.println(valueWere + ".NAME_WERE: " + nameWere + "; RAND=" + j + ";\n ACTUAL PRICE: " + actualREZULT + ";\n OLD PRICE: " + valueOldPrice + ";\n EXPECTED RESULT: " + expectedResult + ";\n SALE: " + sale + "%");

            }
            driver.findElement(By.partialLinkText("Следующая")).click();
            valueWere++;
        }
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.close();
    }
}


