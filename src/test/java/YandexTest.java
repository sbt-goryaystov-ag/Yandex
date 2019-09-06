import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import yandex.auto.steps.BaseSteps;
import yandex.auto.steps.YandexMainSteps;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class YandexTest extends BaseSteps {

    @Parameterized.Parameters
    public static Collection<Object[]> fio() {
        return Arrays.asList(new Object[][]{
                {"погода"},
                {"Липецк"},
                {"Лото"},
        });
    }

    @Parameterized.Parameter
    public String text;


    @Test
    public void yandex() throws InterruptedException {

        YandexMainSteps yandex = new YandexMainSteps();
        yandex.fillField(yandex.find, text);
        yandex.stepPrintText(yandex.listElements, 1);

    }

}