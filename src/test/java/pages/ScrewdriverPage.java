package pages;

import org.openqa.selenium.WebDriver;

public class ScrewdriverPage extends BasePage {

    public ScrewdriverPage(WebDriver driver) {
        super(driver);
    }

    int USAFlagsNumber = 0;

    public ScrewdriverPage goToScrewdriverPage() {

        System.out.println("----------------------TEST_ScrewdriverPage-----------------------");
        selelectOnMenuAndClick(main_menu,
                menu_electroinstruments,
                sub_menu_shurupoverty);
        return this;
    }

    public ScrewdriverPage showGoodsWithUSAFlag(int numbrPages) {
        for (int i = 1; i <= numbrPages; i++) {
            USAFlagsNumber = name_goods_with_usa_flagLIST.size();
            System.out.println("USAFlagsNumbers on page:" + USAFlagsNumber);

            for (int j = 1; j <= USAFlagsNumber; j++) {

                print(name_goods_with_usa_flagLIST.get(j - 1).getText() + " it is of USA goods");
            }
            USAFlagsNumber = 0;
            System.out.println("\n");
            if (i < numbrPages) nextPage();
        }
        return this;
    }
}
