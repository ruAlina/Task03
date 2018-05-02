package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InsurancePage;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InsuranceSteps extends BaseSteps {
    @Step("Переход на страницу Сбербанк страхование")
    public void stepSelectNewPage() {
        assertTrue(switchTo("Сбербанк страхование"));
    }

    @Step("Выбрана минимальная страховка")
    public void stepSelectInsurance(String menuItem) {
        click(new InsurancePage(driver).selectInsurance(menuItem));
    }

    @Step("Нажата кнопка Оформить")
    public void stepClickButton() {
        new InsurancePage(driver).pressButton();
    }

    @Step("Началось Оформление")
    public void checkDataPage() {
        click(new InsurancePage(driver).alert);
    }

    @Step("Поле {0} заполняется значением {1}")
    public void fillField(String field, String value) {
        new InsurancePage(driver).fillField(field, value);
    }

    @Step("Поля заполнены")
    public void fillFields(HashMap<String, String> fields) {
        fields.forEach((k, v) -> fillField(k, v));
    }

    @Step("Поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value) {
        String actual = new InsurancePage(driver).checkField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("Поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields) {
        fields.forEach((k, v) -> checkFillField(k, v));
    }

    @Step("Нажата кнопка Продолжить")
    public void stepClickButtonNext() {
        new InsurancePage(driver).buttonNext.click();
    }

    @Step("Проверка ошибки Заполнены не все обязательные поля")
    public void checkErrorMessageField(String menuItem) {
        InsurancePage insurancePage = new InsurancePage(driver);
        assertEquals(menuItem, insurancePage.alertText.getText());
    }

}