package pages;

import org.openqa.selenium.WebDriver;

public class PerforatorPage extends BasePage {
    public PerforatorPage(WebDriver driver) {
        super(driver);
    }

    int listCount;

    public PerforatorPage gotoPerforatorPage() {
        System.out.println("----------------------TEST_PerforatorPage-----------------------");
        selelectOnMenuAndClick(main_menu, menu_electroinstruments, sub_menu_perforatory);
        return this;
    }

    public PerforatorPage shouldBePriceOnGoods(int numOfPages) {
        listCount = goods_cardLIST.size();

        for (int i = 1; i <= numOfPages; i++) {
            for (int j = 0; j <= listCount - 1; j++) {
                scrollTo(priceLIST.get(j));
                isElementDispleyed(priceLIST.get(j), "Price not present");
                // System.out.println(name_wereLIST.get(j).getText() + " " + priceLIST.get(j).getText());
            }
            CloseaLERT();
            if (i < numOfPages) nextPage();
        }
        return this;
    }
}


