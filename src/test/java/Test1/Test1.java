package Test1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test1 {
    BaseSetup baseSetup = new BaseSetup();
    ContributionPage contributionPage;
    GetDataEndTime time = new GetDataEndTime();
    DataBase DataBase = new DataBase();

    @BeforeTest
    public void beforeTest() {
        String timeStartOpenBrowser = time.getData();
        baseSetup.initializeTestBaseSetup();
        contributionPage = new ContributionPage(baseSetup.getDriver());
        baseSetup.openBrowser();
        String timeEndOpenBrowser = time.getData();
        DataBase.writeDateAndTimeToDataBase("openBrowser", timeStartOpenBrowser, timeEndOpenBrowser);
    }

    @Test
    public void mainTest() {
        String timeLoadPageContribution = time.getData();
        contributionPage.goPageContribution();
        String timeOutPageContribution = time.getData();
        DataBase.writeDateAndTimeToDataBase("goPageContribution",timeLoadPageContribution,timeOutPageContribution);

        contributionPage.clickCheckBox();
        String timeEndClickCheckBox = time.getData();
        DataBase.writeDateAndTimeToDataBase("clickCheckBox",timeOutPageContribution,timeEndClickCheckBox);

        contributionPage.enterValueMoney("40000");
        String timeEndEnterValueMoney = time.getData();
        DataBase.writeDateAndTimeToDataBase("enterValueMoney",timeEndClickCheckBox,timeEndEnterValueMoney);

        contributionPage.changeMonth();
        String timeEndChangeMonth = time.getData();
        DataBase.writeDateAndTimeToDataBase("changeMonth",timeEndEnterValueMoney,timeEndChangeMonth);

        contributionPage.downloadFile();
        String timeEndDownloadFile = time.getData();
        DataBase.writeDateAndTimeToDataBase("downloadFile",timeEndChangeMonth,timeEndDownloadFile);
    }

    @AfterClass
    public void afterTest() throws IOException {
        baseSetup.tearDown();
    }
}
