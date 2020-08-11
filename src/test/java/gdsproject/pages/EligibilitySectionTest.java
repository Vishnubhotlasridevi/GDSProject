package gdsproject.pages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EligibilitySectionTest extends BaseReport {

    public EligibilitySection eligibilitySection;

    @BeforeMethod
    public void setupWebDriver() {
        this.eligibilitySection = new EligibilitySection();
        eligibilitySection.webdriverclass();
        eligibilitySection.clickLogin();
        eligibilitySection.enterLoginDetails("S1234567A", "Tan Ah Kow", "BGPQEDEMO", "Acceptor");
        eligibilitySection.getNewGrant();
        eligibilitySection.selectSector();
        eligibilitySection.selectGrant();
        eligibilitySection.selectAssistance();
        eligibilitySection.applyGrant();
        eligibilitySection.applyButton();
        eligibilitySection.grantActions();
        eligibilitySection.proceed();
    }

    @AfterMethod
    public void closeWebDriver() {
        this.eligibilitySection.closeDriver();
    }

    @Test
    public void us1_AC1_Contains4Questions() {
        Assert.assertEquals(this.eligibilitySection.questions(), true);
    }

    @Test
    public void us1_AC2_QuestionsYesOrNo() {
        Assert.assertEquals(this.eligibilitySection.selectApplicantRegistered("Yes"), true);
        Assert.assertEquals(this.eligibilitySection.selectApplicantRegistered("No"), true);
        Assert.assertEquals(this.eligibilitySection.selectTurnover("Yes"), true);
        Assert.assertEquals(this.eligibilitySection.selectTurnover("No"), true);
        Assert.assertEquals(this.eligibilitySection.selectLocalEquity("Yes"), true);
        Assert.assertEquals(this.eligibilitySection.selectLocalEquity("No"), true);
        Assert.assertEquals(this.eligibilitySection.verifyTrueStatements("Yes"), true);
        Assert.assertEquals(this.eligibilitySection.verifyTrueStatements("No"), true);
    }

    @Test
    public void us1_AC3_QuestionErrorMessage() {
        this.eligibilitySection.selectApplicantRegistered("No");
        Assert.assertEquals(this.eligibilitySection.checkErrorMessage(), true);
    }

    @Test
    public void us1_AC5_SaveButton(){
        this.eligibilitySection.selectApplicantRegistered("Yes");
        this.eligibilitySection.selectTurnover("No");
        this.eligibilitySection.selectLocalEquity("No");
        this.eligibilitySection.verifyTrueStatements("Yes");
        this.eligibilitySection.saveButton();
        this.eligibilitySection.pageRefresh();
        this.eligibilitySection.driver.switchTo().alert().accept();

        Assert.assertEquals(this.eligibilitySection.getApplicationRegistered(), "Yes");
        Assert.assertEquals(this.eligibilitySection.getTurnover(), "No");
        Assert.assertEquals(this.eligibilitySection.getLocalEquity(), "No");
        Assert.assertEquals(this.eligibilitySection.getTrueStatements(), "Yes");
    }
}
