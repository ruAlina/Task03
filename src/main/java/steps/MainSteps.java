package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;


public class MainSteps extends BaseSteps {
    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem) {
       click(new MainPage(driver).selectMainMenu(menuItem));
    }

    @Step("Выбран вид страхования {0}")
    public void setSelectSubMenu(String menuItem) {
        click(new MainPage(driver).selectSubMenu(menuItem));
    }
}