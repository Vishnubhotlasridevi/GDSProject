package gdsproject.pages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddGrantPageTest extends BaseReport {

    public AddGrantPage addGrant;

    @BeforeMethod
    public void setupWebDriver() {
        this.addGrant = new AddGrantPage();
        addGrant.webdriverclass();
        addGrant.clickLogin();
        addGrant.enterLoginDetails("S1234567A", "Tan Ah Kow", "BGPQEDEMO", "Acceptor");
        addGrant.getNewGrant();
    }

    @AfterMethod
    public void closeWebDriver() {
        this.addGrant.closeDriver();
    }

    @Test
    public void AddSector() {
        this.addGrant.selectSector();
        this.addGrant.selectGrant();
        this.addGrant.selectAssistance();
        Assert.assertEquals(this.addGrant.applyButton(),true);
        this.addGrant.applyGrant();
        Assert.assertEquals(this.addGrant.grantActions(),true);

    }
}