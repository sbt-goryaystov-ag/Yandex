package yandex.auto.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import yandex.auto.util.Init;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Init.getDriver(), this);
    }

    public void printTextFromElement(List<WebElement> listElements, int num) {
        List<WebElement> elements = new ArrayList<>();
        try {
            Thread.sleep(500);
            System.setOut(new java.io.PrintStream(System.out, true, "Cp866"));
        } catch(UnsupportedEncodingException|InterruptedException  e) {
            e.printStackTrace();
        }

        elements = listElements;
        int cnt = num - 1 >= 0 ? num - 1 : num - 1 < elements.size() ? num - 1 : 0;
        if (elements.size() > 0) {
            elements = elements.get(cnt).findElements(By.xpath("./span"));

            for (WebElement element : elements) {
                System.out.print(element.getAttribute("innerText") + " ");
            }
            System.out.println();
        }
    }

    public void fillField(WebElement element, String value) throws InterruptedException {
        element.click();
        element.clear();
        element.sendKeys(value);
    }
}