package gdsproject.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseReport {

    public Dashboard dashboardPage;

    @BeforeMethod
    public void setupWebdriver() {
        this.dashboardPage = new Dashboard();
        dashboardPage.webdriverclass();
        dashboardPage.clickLogin();
        dashboardPage.enterLoginDetails("S1234567A","Tan Ah Kow","BGPQEDEMO","Acceptor");
    }
    @AfterMethod
    public void closeWebDriver() {
        this.dashboardPage.closeDriver();
        this.extent.flush();
    }

    @Test
    public void addNewGrant() {
        ExtentTest reportLogger = this.extent.createTest("New Grant");
        reportLogger.log(Status.INFO, "Add new Grant");

        this.dashboardPage.getNewGrant();

        reportLogger.log(Status.PASS, "Add new Grant Successful");
    }
}