package Test1;

import org.openqa.selenium.By;

public class XPathVariables {
    By clickContributions = By.xpath(".//div[@class= 'service__title']/a[@href = '/contributions/']");
    By clickCalculatorCheck = By.xpath(".//div[@class = 'jq-checkbox calculator__check']");
    By clickAmount = By.xpath(".//input[@name = 'amount']");
    By changeMonth = By.xpath(".//div[@class='calculator__slide-section'][2]//span");
    By downloadFile = By.xpath(".//a[@class='document__title-link']");
    By BodyPage = By.xpath(".//div[@class = 'page-content js-page-content page-content_pb_0']");
}
