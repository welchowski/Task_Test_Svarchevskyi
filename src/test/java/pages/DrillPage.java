package pages;

import org.openqa.selenium.*;

public class DrillPage extends BasePage {

    public DrillPage(WebDriver driver) {
        super(driver);
    }

    int counter = 0;

    public DrillPage goToDrillPage() {
        System.out.println("----------------------TEST_DrillPage-----------------------");
        selelectOnMenuAndClick(main_menu, menu_electroinstruments, sub_menu_dreli);
        return this;
    }

    public void checkedIsPresentOldAndSalesPrice() {
        isElementDispleyed(price_in_cards, "Price don't present");
        isElementDispleyed(old_price_in_cards, "Old price don't present");
    }

    public DrillPage RandomClickAndCheckContainsOldAndActualPrice(int numOfCards) {

        while (counter <= numOfCards) {
            for (int i = 0; i <= name_were_with_saleLIST.size(); i++) {
                if (counter >= numOfCards) {
                    break;
                }

                randomClick(name_were_with_saleLIST, random(name_were_with_saleLIST.size() - 1));

                //  print(getText(price_in_cards));
                checkedIsPresentOldAndSalesPrice();
                counter++;
                back();
            }
            if (counter >= numOfCards) {
                break;
            }
            nextPage();
        }
        return this;
    }
}

