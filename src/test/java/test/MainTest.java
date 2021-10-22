package test;

import org.testng.annotations.Test;

public class MainTest extends TestBase {


    @Test(retryAnalyzer = test.Retry.class)
    public void testDrill() {
       /*1. in the section "Power Tools" / "Drills" on three products with a promotional ticket, check if there is a promotional price in the product card
        To do this, from the "Power Tools" section, go to the "Drills" section using the menu.
        Randomly, select a product on the page, fall into the product card and check the availability of the promotional and old prices
        So for 3 products (make the choice of the number of checked products flexible)*/

        drillPage
                .goToDrillPage()
                .RandomClickAndCheckContainsOldAndActualPrice(20);
    }

    @Test(retryAnalyzer = test.Retry.class)
    public void testGrinder() {
         /*4. In the section "Power Tools" / "Grinders"
    For 10 random products marked "Promotion", calculate the promotional price relative to the old one using the discount percentage.
    In the assert of the failed test, output the name of the product, its expected and actual price.
    */

        grinderPage
                .goToBolgarkiPage()
                .RandClickAndChek(20, 20);
    }

    @Test(retryAnalyzer = test.Retry.class)
    public void testPerforator() {
         /* 2. Go to the section "Power tools" / "Rotary hammers"
    Check that all products in this section have a price on the first two pages.*/

        perforatorPage
                .gotoPerforatorPage()
                .shouldBePriceOnGoods(2);
    }

    @Test(retryAnalyzer = test.Retry.class)
    public void testScrewdriver() {
        /*
   3. Go to the section "Power Tools" / "Screwdrivers"
    Display the "Name" of all products that have an icon with the American flag on the first 3 pages */

        screwdriverPage
                .goToScrewdriverPage()
                .showGoodsWithUSAFlag(3);
    }
}



