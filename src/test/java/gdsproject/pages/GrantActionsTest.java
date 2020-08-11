package gdsproject.pages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GrantActionsTest extends BaseReport {

    public GrantActions grantAction;

    @BeforeMethod
    public void setupWebDriver() {
        this.grantAction = new GrantActions();
        grantAction.webdriverclass();
        grantAction.clickLogin();
        grantAction.enterLoginDetails("S1234567A", "Tan Ah Kow", "BGPQEDEMO", "Acceptor");
        grantAction.getNewGrant();
        grantAction.selectSector();
        grantAction.selectGrant();
        grantAction.selectAssistance();
        grantAction.applyGrant();
        grantAction.applyButton();
        grantAction.grantActions();
    }

    @AfterMethod
    public void closeWebDriver() {
        this.grantAction.closeDriver();
    }

    @Test
    public void proceedButton() {
        this.grantAction.proceed();
        String url = this.grantAction.driver.getCurrentUrl();
        Assert.assertTrue(url.contains("key_page"));
    }
}