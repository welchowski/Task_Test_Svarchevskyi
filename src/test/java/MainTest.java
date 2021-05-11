import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//
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

    @Test(alwaysRun = true)
    public void Test1() throws InterruptedException {

//        в разделе "Электроинструменты" / "Дрели" на  трех товарах с акционным тикетом  проверить есть ли в карточке товара акционная цена
//        Для этого, из раздела "Электроинструменты"  перейти в раздел "Дрели"  используя меню.
//        Рандомно, на страничке выбрать товар, провалиться в карточку товара и проверить наличие акционной и старой цены
//        Так для 3-х товаров (выбор количества проверяемых товаров сделать гибким)

        //sizeElements
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//a[@href='/catalog/']")).click();
        WebElement menu = driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']"));
        WebElement elementInMenu = driver.findElement(By.xpath("//a[@href='/catalog/dreli/']"));
        actions.moveToElement(menu).moveToElement(elementInMenu).click().build().perform();

        List<WebElement> xpath = driver.findElements(By.xpath("//span[@style='display:block;']"));
        int salesCards = xpath.size();
        System.out.println("SalesCards: " + salesCards);

        int numberCards = 3;

        //RandomClickAndCheck
        for (int i = 0; i < numberCards; i++) {
            //numberRandomCards

            int min = 1;
            int max = salesCards;
            int diff = max - min;
            Random random = new Random();
            int j = random.nextInt(diff + 1) + min;

            driver.findElement(By.xpath("(//span[@style='display:block;']/../../../a)[" + j + "]")).click();
            System.out.println("rand value " + i + ": " + j);

            if (driver.findElements(By.xpath("//span[@class='item_old_price old-price']")).size() != 0) {
                System.out.println("Element old_price is Present");

                int olldPriceOfCards = driver.findElements(By.xpath("//span[@class='item_old_price old-price']")).size();

                //  System.out.println(olldPriceOfCards);

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

    @Test(alwaysRun = true)
    public void Test2() throws InterruptedException {

        System.out.println("----------------------TEST2-----------------------");

//            Перейти в раздел "Электроинструменты" / "Перфораторы"
//            Проверить, что у всех товаров этого раздела есть цена на первых двух страницах.

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
                    System.out.println(elmtNumber + " Element price is Present");
                } else {
                    // Assert.fail(elmtNumber+"Element price is NOT Present");
                    System.out.println(elmtNumber + "Element price is NOT Present");
                }
            }
            if (i < valuePage) driver.findElement(By.partialLinkText("Следующая")).click();
        }


    }

    @Test(alwaysRun = true)
    public void Test3() throws InterruptedException {
//        Перейти в раздел "Электроинструменты" / "Шуруповерты"
//        Вывести "Наименование" всех товаров у которых есть иконка с американским флагом на первых 3х страницах

        System.out.println("----------------------TEST3-----------------------");

        Actions aactions = new Actions(driver);
        driver.findElement(By.xpath("//a[@href='/catalog/']")).click();
        WebElement menu = driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']"));
        WebElement elementInMenu = driver.findElement(By.xpath("//a[@href='/catalog/shurupoverty/']"));
        aactions.moveToElement(menu).moveToElement(elementInMenu).click().build().perform();

        String USA = driver.findElement(By.xpath("//a[@class='title google_detail_link']/span")).getText() + " it USA";
        int numbrPages = 3;
        int USAPath;

        for (int i = 1; i <= numbrPages; i++) {
            System.out.println("Number Page: " + i);
            USAPath = driver.findElements(By.xpath("//img[contains(@src, 'United_states.jpg')]")).size();
            System.out.println("Number USA Flugs: " + USAPath);

            for (int j = 1; j <= USAPath; j++) {
                //"//a[@class='title google_detail_link']/span"
                System.out.println(driver.findElement(By.xpath("(//img[contains(@src, 'United_states.jpg')]/../../..//h4[@class='s_title'])["+j+"]")).getText() + " it USA");

            }
            System.out.println("\n");
            if (i < numbrPages) driver.findElement(By.partialLinkText("Следующая")).click();

        }
    }

    @Test(alwaysRun = true)
    public void Test4() throws InterruptedException {
        System.out.println("----------------------TEST4-----------------------");
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
        int counter = 0;
        int ExpectedRezultValue;
        //value for random
        int min = 1;
        int max = cardsCount;
        int diff = max - min;

        while (valueWere < 10) {

            for (int i = 0; i < 2; i++) {
                counter++;

                //numberRandomCards
                List<WebElement> cardsOfSales = driver.findElements(By.xpath("//span[@style='display:block;']"));
                cardsCount = cardsOfSales.size();

                //generateRandom


                Random random = new Random();
                j = random.nextInt(diff + 1) + min;

                //getting and compare result
                oldPrice = driver.findElement(By.xpath("(//span[contains(text(),'%')]/../../../..//span[@class='old-price'])[" + j + "]")).getText();

                valueOldPrice = Integer.parseInt(oldPrice.replaceAll("[^0-9]", ""));

                price = driver.findElement(By.xpath("(//span[contains(text(),'%')]/../../../..//span[@class='price'])[" + j + "]")).getText();

                valuePrice = Integer.parseInt(price.replaceAll("[^0-9]", ""));

                saleCards = driver.findElement(By.xpath("(//span[@style='display:block;'])[" + j + "]")).getText();

                sale = Integer.parseInt(saleCards.replaceAll("[^0-9]", ""));

                nameWere = driver.findElement(By.xpath("(//span[@style='display:block;']/../../../..//h4[@class='s_title']//span)[" + j + "]")).getText();

                actualRezult = (valueOldPrice + sale) / 100;

                ExpectedRezultValue = valuePrice - actualRezult;
                expectedResult = valuePrice;

                //Assert.assertEquals(ExpectedRezultValue,actualRezultValue,nameWere);
                System.out.println(counter + ".NAME_WERE: " + nameWere + ";\n Total sales cards: " + cardsCount + ";\n RAND=" + j + ";\n ACTUAL PRICE: " + price + ";\n OLD PRICE: " + valueOldPrice + ";\n EXPECTED RESULT: " + ExpectedRezultValue + ";\n SALE: " + sale + "%");
                valueWere++;
            }
            driver.findElement(By.partialLinkText("Следующая")).click();

        }
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.close();
    }
}


