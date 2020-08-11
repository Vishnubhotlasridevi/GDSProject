package gdsproject.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.Assert;

public class LoginTest extends BaseReport {

    public Login loginPage;

    @BeforeMethod
    public void setupWebDriver() {
        this.loginPage = new Login();
        loginPage.webdriverclass();
    }

    @AfterMethod
    public void closeWebDriver(ITestResult result) {
        this.loginPage.closeDriver();
        this.extent.flush();
    }

    @Test
    public void verifyLoginPage() {

        ExtentTest reportLogger = this.extent.createTest("LoginTest");
        reportLogger.log(Status.INFO, "Login to GDS Website");

        this.loginPage.clickLogin();
        String url = this.loginPage.driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url, "https://bgp-qa.gds-gov.tech/saml/sso_stub");

        reportLogger.log(Status.PASS, "Login Successful");
    }

    @Test
    public void verifyCredentials_validCase() {

        ExtentTest reportLogger = this.extent.createTest("Credentials Validation Test");
        reportLogger.log(Status.INFO, "Verify Credentials");

        this.loginPage.clickLogin();
        this.loginPage.enterLoginDetails("S1234567A","Tan Ah Kow","BGPQEDEMO","Acceptor");
        String url = this.loginPage.driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url, "https://bgp-qa.gds-gov.tech/dashboard");

        reportLogger.log(Status.PASS, "Verify Credentials Successful");
    }
}