package gdsproject.pages;

import org.openqa.selenium.By;

public class AddGrantPage extends Dashboard {

    public void selectSector() {
        //Util.waitForPageLoad(driver, By.xpath("//*[text()='IT']"), 10l);
        driver.findElement(By.xpath("//*[text()='IT']")).click();
    }

    public void selectGrant() {
        driver.findElement(By.xpath("//*[text()='Bring my business overseas or establish a stronger international presence']")).click();
    }

    public void selectAssistance() {
        driver.findElement(By.xpath("//*[text()='Market Readiness Assistance']")).click();
    }

    public void applyGrant() {
        driver.findElement(By.id("go-to-grant")).click();
    }

    public boolean applyButton() {
        return driver.findElement(By.id("go-to-grant")).isEnabled();
    }

    public boolean grantActions() {
        return driver.findElement(By.xpath("//*[text()='Grant Actions']")).isDisplayed();
    }

    public void nextButton() {
        driver.findElement(By.className("bgp-btn bgp-btn-next")).click();
    }

    public void previousButton() {
        driver.findElement(By.className("gp-btn bgp-btn-back pull-left")).click();
    }
}
