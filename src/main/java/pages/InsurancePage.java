package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;


import static org.junit.Assert.assertTrue;

public class InsurancePage {
    @FindBy(xpath = "//div[@id='views']")
    public WebElement insurance;

    @FindBy(xpath = "//span [contains(text(),'Оформить')]")
    public WebElement sendButton;

    @FindBy(name = "insured0_surname")
    public WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    public WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    public WebElement insuredBirthdate;

    @FindBy(name = "surname")
    public WebElement surname;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "middlename")
    public WebElement middlename;

    @FindBy(name = "birthDate")
    public WebElement birthDate;

    @FindBy(name = "male")
    public WebElement male;

    @FindBy(name = "passport_series")
    public WebElement passportSeries;

    @FindBy(name = "passport_number")
    public WebElement passportNumber;

    @FindBy(name = "issueDate")
    public WebElement issueDate;

    @FindBy(name = "issuePlace")
    public WebElement issuePlace;

    @FindBy(xpath = "//span [contains(text(),'Продолжить')]")
    public WebElement buttonNext;

    @FindBy(xpath = "//div [text()='Заполнены не все обязательные поля']")
    public WebElement alertText;

    @FindBy(xpath = "//LI[contains(@class, 'active')]//SPAN[contains(@class, 'b-heading-tabset-title')]")
    public WebElement alert;

    public InsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void fillField(String fildName, String value) {
        switch (fildName) {
            case "Фамилия латиница":
                fullFillRefactor(insuredSurname, value);
                break;
            case "Имя латиница":
                fullFillRefactor(insuredName, value);
                break;
            case "Дата рождения латиница":
                fullFillRefactor(insuredBirthdate, value);
                break;
            case "Фамилия":
                fullFillRefactor(surname, value);
                break;
            case "Имя":
                fullFillRefactor(name, value);
                break;
            case "Отчество":
                fullFillRefactor(middlename, value);
                break;
            case "Дата рождения":
                fullFillRefactor(birthDate, value);
                break;
            case "Пол":
                fullFillRefactor(male, value);
                break;
            case "Серия":
                fullFillRefactor(passportSeries, value);
                break;
            case "Номер":
                fullFillRefactor(passportNumber, value);
                break;
            case "Дата паспорта":
                fullFillRefactor(issueDate, value);
                break;
            case "Кем выдан":
                fullFillRefactor(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fildName + "' не объявлено на странице");
        }
    }

    public String checkField(String fieldName) {
        switch (fieldName) {
            case "Фамилия латиница":
                return insuredSurname.getAttribute("value");
            case "Имя латиница":
                return insuredName.getAttribute("value");
            case "Дата рождения латиница":
                return insuredBirthdate.getAttribute("value");
            case "Фамилия":
                return surname.getAttribute("value");
            case "Имя":
                return name.getAttribute("value");
            case "Отчество":
                return middlename.getAttribute("value");
            case "Дата рождения":
                return birthDate.getAttribute("value");
            case "Серия":
                return passportSeries.getAttribute("value");
            case "Номер":
                return passportNumber.getAttribute("value");
            case "Дата паспорта":
                return issueDate.getAttribute("value");
            case "Кем выдан":
                return issuePlace.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void fullFillRefactor(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public WebElement selectInsurance(String menuItem) {
        return insurance.findElement(By.xpath(".//div[text()='" + menuItem + "']"));
    }

    public void pressButton() {
        sendButton.click();
    }
    public void checkFieldErrorMessage(String field, String errorMessage){
        String xpath = "//*[text()='"+field+"']/..//*[@class='validation-error']";
        String actualValue = BaseSteps.getDriver().findElement(By.xpath(xpath)).getText();
        assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }
}