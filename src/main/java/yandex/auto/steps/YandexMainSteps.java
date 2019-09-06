package yandex.auto.steps;

import org.openqa.selenium.WebElement;
import yandex.auto.page.YandexMainPage;

import java.util.List;


public class YandexMainSteps extends YandexMainPage {

    public void stepPrintText(List<WebElement> listElements, int num){
        new YandexMainPage().printTextFromElement(listElements, num);
    }

}
