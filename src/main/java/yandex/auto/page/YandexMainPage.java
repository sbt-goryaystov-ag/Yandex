package yandex.auto.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YandexMainPage extends BasePage {

    @FindBy(id = "text")
    public WebElement find;

    @FindBy(xpath = "//div[@class='suggest2__content suggest2__content_theme_normal']/li")
    public List<WebElement> listElements;

}
