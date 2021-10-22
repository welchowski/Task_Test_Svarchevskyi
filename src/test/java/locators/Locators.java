package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;

public class Locators {

    public WebDriver driver;
    public WebDriverWait wait;
    public Date date = new Date();

    public final String PRICE_IN_CARD_WITH_SALE = ".col-xs-4 .old-price + .price";
    public final String NAME_WERE_WITH_SALE = "//span[@style='display:block;']/../../../..//h4[@class='s_title']//span";
    public final String NAME_GOODS_WITH_USA_FLAG = "//img[contains(@src, 'United_states.jpg')]/../../..//h4[@class='s_title']";
    public final String GOODS_CARD = ".col-xs-4";
    public final String PRICE = ".col-xs-4 .price";
    public final String PRICE_SALE_PERCENT = ".stick-list__span";
    public final String OLD_PRICE_IN_CARDS = ".item_old_price";
    public final String PRICE_IN_CARDS = ".item-print-block .price";
    public final String OLD_PRICE = ".col-xs-4 .old-price";

    public final String MAIN_MENU = ".icon-menu_catalog";
    public final String MENU_ELECTROINSTRUMENTS = "a[href='/catalog/elektroinstrument/']";
    public final String SUB_MENU_BOLGARKI = "a[href='/catalog/bolgarki/']";
    public final String SUB_MENU_DRELI = "a[href='/catalog/dreli/']";
    public final String SUB_MENU_PERFORATORY = "a[href='/catalog/perforatory/']";
    public final String SUB_MENU_SHURUPOVERTY = "a[href='/catalog/shurupoverty/']";

    public final String NEXT_PAGE = ".next.btn-blue";

    @FindBy(css = NEXT_PAGE)
    public WebElement next_page;
    @FindBy(xpath = NAME_WERE_WITH_SALE)
    public List<WebElement> name_were_with_saleLIST;
    @FindBy(xpath = NAME_GOODS_WITH_USA_FLAG)
    public List<WebElement> name_goods_with_usa_flagLIST;
    @FindBy(css = GOODS_CARD)
    public List<WebElement> goods_cardLIST;
    @FindBy(css = PRICE)
    public List<WebElement> priceLIST;
    @FindBy(css = PRICE_SALE_PERCENT)
    public List<WebElement> price_sale_percentLIST;
    @FindBy(css = OLD_PRICE_IN_CARDS)
    public WebElement old_price_in_cards;
    @FindBy(css = PRICE_IN_CARDS)
    public WebElement price_in_cards;
    @FindBy(css = OLD_PRICE)
    public List<WebElement> old_priceLIST;
    @FindBy(css = PRICE_IN_CARD_WITH_SALE)
    public List<WebElement> price_in_card_with_saleLIST;

    @FindBy(css = MAIN_MENU)
    public WebElement main_menu;
    @FindBy(css = MENU_ELECTROINSTRUMENTS)
    public WebElement menu_electroinstruments;
    @FindBy(css = SUB_MENU_BOLGARKI)
    public WebElement sub_menu_bolgarki;
    @FindBy(css = SUB_MENU_DRELI)
    public WebElement sub_menu_dreli;
    @FindBy(css = SUB_MENU_PERFORATORY)
    public WebElement sub_menu_perforatory;
    @FindBy(css = SUB_MENU_SHURUPOVERTY)
    public WebElement sub_menu_shurupoverty;
}
