package steps;

import pages.PreInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertEquals;

public class PreInsuranceSteps extends BaseSteps {

    @Step("Появился заголовок Страхование путешественников")
    public void stepCheckTitle(String checkTitle) {
        PreInsurancePage preInsurancePage = new PreInsurancePage(driver);
        assertEquals(checkTitle, preInsurancePage.title.getText());
    }

    @Step("Выполнено нажатие на кнопку Оформить Онлайн")
    public void stepSendButton() {
        click(new PreInsurancePage(driver).sendButton);
    }
}


