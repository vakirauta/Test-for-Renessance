package Test1;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class MapPage {
    WebDriver driver;

    public MapPage(WebDriver driver) {
        this.driver = driver;
    }

        String region = "Пензенская область";
        String city = "Пенза";

        By buttonCard = By.xpath(".//a[@class='service__title-action']");
        By inputLastName = By.xpath(".//input[@name='ClientLastName']");
        By inputName = By.xpath(".//input[@name='ClientName']");
        By inputPhone = By.xpath(".//input[@name='ClientMobilePhone']");
        By inputEmail = By.xpath(".//input[@name='AdditionalEmail']");
        By checkbox = By.xpath(".//div[@class='jq-checkbox js-validation-ignore-checkbox']");
        By list = By.xpath(".//div[@class='jq-selectbox__trigger']");
        By selectWhereGetCard = By.xpath(".//div[@class='jq-selectbox__dropdown']/ul/li[.='"+ region +"']");
        By list2 = By.xpath("//*[@id=\"s3-styler\"]/div[1]/div[2]");
        By selectWhereGetCardCity = By.xpath(".//div[@class='jq-selectbox__dropdown']/ul/li[.='"+ city +"']");

    @Step("Перейти на страницу \"Карта\"")
    public void clickButtonCard(){
        driver.findElement(buttonCard).click();
    }
    @Step("Ввести в поля \"Фамилия\"")
    public void clientLastName(String clientLastName){
        Assert.assertTrue(driver.findElement(inputLastName).isDisplayed());
        driver.findElement(inputLastName).sendKeys(clientLastName);
    }
    @Step("Ввести в поля \"Имя\"")
    public void clientName(String clientName){
        Assert.assertTrue(driver.findElement(inputName).isDisplayed());
        driver.findElement(inputName).sendKeys(clientName);
    }
    @Step("Ввести в поля \"Мобильный телефон\"")
    public void clientPhone(String clientPhone){
        Assert.assertTrue(driver.findElement(inputPhone).isDisplayed());
        driver.findElement(inputPhone).sendKeys(clientPhone);
    }
    @Step("Ввести в поля \"e-mail\"")
    public void clientEmail(String clientEmail) {
        Assert.assertTrue(driver.findElement(inputEmail).isDisplayed());
        driver.findElement(inputEmail).sendKeys(clientEmail);
    }
    @Step("Выбрать чекбокс \"Нет отчества\"")
    public void clickCheckbox() {
        Assert.assertTrue(driver.findElement(checkbox).isDisplayed());
        driver.findElement(checkbox).click();
    }
    @Step("Выбрать значение из выпадающего списка \"Где вы желаете получить карту\"")
    public void getListAndScrollTo() {
          JavascriptExecutor js = (JavascriptExecutor) driver;
            Assert.assertTrue(driver.findElement(list).isDisplayed());
          WebElement Element = driver.findElement(list);
          js.executeScript("arguments[0].scrollIntoView();", Element);
    }
    @Step("Кликнуть на список \"Где Вы желаете получить карту?\"")
    public void clickWhereGetRegion() {
        Assert.assertTrue(driver.findElement(list).isDisplayed());
        driver.findElement(list).click();
    }
    @Step("Выбрать регион")
    public void selectWhereGetRegion() {
        Assert.assertTrue(driver.findElement(selectWhereGetCard).isDisplayed());
        driver.findElement(selectWhereGetCard).click();
    }
    @Step("Кликнуть на список \"Город\"")
    public void clickWhereGetCity() {
        Assert.assertTrue(driver.findElement(list2).isDisplayed());
        driver.findElement(list2).click();
    }
    @Step("Выбрать город")
    public void selectWhereGetCity() {
        Assert.assertTrue(driver.findElement(selectWhereGetCardCity).isDisplayed());
        driver.findElement(selectWhereGetCardCity).click();
    }
}


