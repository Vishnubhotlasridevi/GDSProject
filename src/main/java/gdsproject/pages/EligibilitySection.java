package gdsproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EligibilitySection extends GrantActions {

    public boolean questions() {
        boolean Question = true;
        Question = driver.findElement(By.xpath("//*[text()='Is the applicant registered in Singapore?']")).isDisplayed();
        Question = Question && driver.findElement(By.xpath("//*[contains(text(),\"Is the applicant's group sales turnover less than or equal to S$100m or is the applicant's group employment size less than or equal to 200?\")]")).isDisplayed();
        Question = Question && driver.findElement(By.xpath("//*[contains(text(),'Does the applicant have at least 30%')]")).isDisplayed();
        //Question = Question && driver.findElement(By.xpath("//*[contains(text(),'Are all the following statements true for this project?')]")).isDisplayed();
        //WebElement webElement = driver.findElement(By.className("control-label bgp-label")).findElement(By.tagName("ul"));
        return Question;
    }

    public boolean selectApplicantRegistered(String appReg) {
        Actions actions = new Actions(driver);
        if (appReg.equalsIgnoreCase("Yes")) {
            actions.moveToElement(driver.findElement(By.id("react-eligibility-sg_registered_check-true"))).click().build().perform();
            return driver.findElement(By.id("react-eligibility-sg_registered_check-true")).isSelected();
        } else {
            actions.moveToElement(driver.findElement(By.id("react-eligibility-sg_registered_check-false"))).click().build().perform();
            return driver.findElement(By.id("react-eligibility-sg_registered_check-false")).isSelected();
        }
    }

    public boolean selectTurnover(String turnOver) {
        Actions actions = new Actions(driver);
        if (turnOver.equalsIgnoreCase("Yes")) {
            actions.moveToElement(driver.findElement(By.id("react-eligibility-turnover_check-true"))).click().build().perform();;
            return driver.findElement(By.id("react-eligibility-turnover_check-true")).isSelected();
        } else {
            actions.moveToElement(driver.findElement(By.id("react-eligibility-turnover_check-false"))).click().build().perform();;
            return driver.findElement(By.id("react-eligibility-turnover_check-false")).isSelected();
        }
    }

    public boolean selectLocalEquity(String localEquity) {
        Actions actions = new Actions(driver);
        if (localEquity.equalsIgnoreCase("Yes")) {
            actions.moveToElement(driver.findElement(By.id("react-eligibility-global_hq_check-true"))). click().build().perform();;
            return driver.findElement(By.id("react-eligibility-global_hq_check-true")).isSelected();
        } else {
            actions.moveToElement(driver.findElement(By.id("react-eligibility-global_hq_check-false"))).click().build().perform();;
            return driver.findElement(By.id("react-eligibility-global_hq_check-false")).isSelected();
        }
    }

    public boolean verifyTrueStatements(String trueStatements) {
        Actions actions = new Actions(driver);
        if (trueStatements.equalsIgnoreCase("Yes")) {
            actions.moveToElement(driver.findElement(By.id("react-eligibility-started_project_check-true"))).click().build().perform();;
            return driver.findElement(By.id("react-eligibility-started_project_check-true")).isSelected();
        } else {
            actions.moveToElement(driver.findElement(By.id("react-eligibility-started_project_check-false"))).click().build().perform();;
            return driver.findElement(By.id("react-eligibility-started_project_check-false")).isSelected();
        }
    }

    public boolean checkErrorMessage() {
        return driver.findElement(By.xpath("//*[text()='Visit Smart Advisor on the SME Portal for more information on other government assistance.']")).isDisplayed();
    }

    public void saveButton(){

        driver.findElement(By.id("save-btn")).click();
    }

    public void pageRefresh(){
        driver.navigate().refresh();
    }
    public String getApplicationRegistered(){
        if(driver.findElement(By.id("react-eligibility-sg_registered_check-true")).isSelected())
            return "Yes";
        else if(driver.findElement(By.id("react-eligibility-sg_registered_check-false")).isSelected())
            return "No";
        return "";
    }
    public String getTurnover(){
        if(driver.findElement(By.id("react-eligibility-turnover_check-true")).isSelected())
            return "Yes";
        else if(driver.findElement(By.id("react-eligibility-turnover_check-false")).isSelected())
            return "No";
        return "";
    }

    public String getLocalEquity(){
        if(driver.findElement(By.id("react-eligibility-global_hq_check-true")).isSelected())
            return "Yes";
        else if(driver.findElement(By.id("react-eligibility-global_hq_check-false")).isSelected())
            return "No";
        return "";
    }

    public String getTrueStatements(){
        if(driver.findElement(By.id("react-eligibility-started_project_check-true")).isSelected())
            return "Yes";
        else if(driver.findElement(By.id("react-eligibility-started_project_check-false")).isSelected())
            return "No";
        return "";
    }
    public void nextButton(){
        driver.findElement((By.id("next-btn"))).click();
    }
}