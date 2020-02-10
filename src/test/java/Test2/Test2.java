package Test2;

import Test1.BaseSetup;
import Test1.MapPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {
    BaseSetup baseSetup = new BaseSetup();
    MapPage mapPage;


    @BeforeTest
    public void beforeTest(){
        baseSetup.initializeTestBaseSetup();
        baseSetup.openBrowser();
        mapPage = new MapPage(baseSetup.getDriver());
    }
    @Test
    public void mainTest() {
        mapPage.clickButtonCard();
        mapPage.clientLastName("Иванов");
        mapPage.clientName("Иван");
        mapPage.clientPhone("9521997578");
        mapPage.clientEmail("IvanIvanov@mail.ru");
        mapPage.clickCheckbox();
        mapPage.getListAndScrollTo();
        mapPage.clickWhereGetRegion();
        mapPage.selectWhereGetRegion();
        mapPage.clickWhereGetCity();
        mapPage.selectWhereGetCity();
    }

    @AfterClass
    public void afterTest() {
        baseSetup.tearDown();
    }
}
