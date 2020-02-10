package Test1;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;

//import static Test1.XPathVariables.clickContributions;

public class ContributionPage {
    WebDriver driver;
    XPathVariables xPathVariables = new XPathVariables();
    Settings settings = new Settings();

        public ContributionPage(WebDriver driver) {
            this.driver = driver;
        }

        @Step("Перейти на страницу \"Вклад\"")
        public void goPageContribution() {
            Assert.assertTrue(driver.findElement(xPathVariables.clickContributions).isDisplayed());
            driver.findElement(xPathVariables.clickContributions).click();
        }
        @Step("Выбрать чекбокс \"В отделении банка\"")
        public void clickCheckBox () {
            Assert.assertTrue(driver.findElement(xPathVariables.clickCalculatorCheck).isDisplayed());
            driver.findElement(xPathVariables.clickCalculatorCheck).click();
        }
        @Step("Ввести сумму вклада")
        public void enterValueMoney (String amount){
            Assert.assertTrue(driver.findElement(xPathVariables.clickAmount).isDisplayed());
            driver.findElement(xPathVariables.clickAmount).sendKeys(amount);
        }

        @Step("Передвинуть ползунок \"На срок\"")
        public void changeMonth () {
            Assert.assertTrue(driver.findElement(xPathVariables.changeMonth).isDisplayed());
            driver.findElement(xPathVariables.changeMonth).sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT);
        }
        @Step("Выгрузить Печатную Форму \"Общие условия по вкладам\"")
        public void downloadFile () {
            Assert.assertTrue(driver.findElement(xPathVariables.downloadFile).isDisplayed());
            driver.findElement(xPathVariables.downloadFile).click();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            File file = new File(settings.openFile);
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                try {
                    desktop.open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
