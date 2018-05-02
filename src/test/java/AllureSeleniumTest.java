import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.InsuranceSteps;
import steps.MainSteps;
import steps.PreInsuranceSteps;

import java.util.HashMap;

public class AllureSeleniumTest extends BaseSteps {

    MainSteps mainSteps = new MainSteps();
    PreInsuranceSteps preInsuranceSteps = new PreInsuranceSteps();
    InsuranceSteps insuranceSteps = new InsuranceSteps();

    HashMap<String, String> testData = new HashMap<>();

    @Test
    @Title("Страхование путешественников")
    public void Test() {
        testData.put("Фамилия латиница", "Ivanov");
        testData.put("Имя латиница", "Ivan");
        testData.put("Дата рождения латиница", "25.03.2000");
        testData.put("Фамилия", "Иванов");
        testData.put("Имя", "Иван");
        testData.put("Отчество", "Иванович");
        testData.put("Дата рождения", "25.03.2000");
        testData.put("Серия", "5525");
        testData.put("Номер", "587469");
        testData.put("Дата паспорта", "25.03.2015");
        testData.put("Кем выдан", "кем-то выдан");

        mainSteps.stepSelectMainMenu("Застраховать");
        mainSteps.setSelectSubMenu("Страхование путешественников");

        preInsuranceSteps.stepCheckTitle("Страхование путешественников");
        preInsuranceSteps.stepSendButton();

        insuranceSteps.stepSelectNewPage();
        insuranceSteps.stepSelectInsurance("Минимальная");
        insuranceSteps.stepClickButton();

        insuranceSteps.checkDataPage();
        insuranceSteps.fillFields(testData);
        insuranceSteps.checkFillFields(testData);
        insuranceSteps.stepClickButtonNext();
        insuranceSteps.checkErrorMessageField("Заполнены не все обязательные поля");
    }
}