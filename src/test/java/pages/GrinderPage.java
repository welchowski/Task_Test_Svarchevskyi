package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GrinderPage extends BasePage {
    public GrinderPage(WebDriver driver) {
        super(driver);
    }

    String nameWere;

    int valuePrice;
    int valueOldPrice;
    int sale;
    int valueGoods = 0;
    int randNumberCardWithSale;
    int actualResultSale;
    int ValueExpectedResult;

    public GrinderPage goToBolgarkiPage() {
        System.out.println("----------------------TEST_GrinderPage-----------------------");
        selelectOnMenuAndClick(main_menu, menu_electroinstruments, sub_menu_bolgarki);
        return this;
    }

    public void shouldBeActualSalePrice(int randNumber) {
        scrollTo(old_priceLIST.get(randNumber));
        waiting(30);

        valueOldPrice = Integer.parseInt(getText(old_priceLIST.get(randNumber)).replaceAll("[^0-9]", ""));
        valuePrice = Integer.parseInt(getText(price_in_card_with_saleLIST.get(randNumber)).replaceAll("[^0-9]", ""));
        sale = Integer.parseInt(getText(price_sale_percentLIST.get(randNumber)).replaceAll("[^0-9]", ""));
        nameWere = getText(name_were_with_saleLIST.get(randNumber));
        actualResultSale = (valueOldPrice + sale) / 100;
        ValueExpectedResult = valuePrice - actualResultSale;

        Assert.assertEquals(valuePrice, ValueExpectedResult, nameWere);
    }

    public GrinderPage RandClickAndChek(int valueGoodsOnPage, int valueGeneralGoods) {
        valueGoods = 0;

        while (valueGoods < valueGeneralGoods) {
            if (valueGoodsOnPage > name_were_with_saleLIST.size()) {
                valueGoodsOnPage = name_were_with_saleLIST.size();
            }

            for (int i = 0; i < valueGoodsOnPage; i++) {
                if (valueGoods == valueGeneralGoods) {
                    break;
                }
                valueGoods++;
                randNumberCardWithSale = random(name_were_with_saleLIST.size() - 1);
                shouldBeActualSalePrice(randNumberCardWithSale);
            }
            nextPage();
        }
        valueGoods = 0;
        return this;
    }
}
