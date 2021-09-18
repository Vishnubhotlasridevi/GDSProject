package gdsproject.pages;

import org.openqa.selenium.By;

public class Dashboard extends Login {

    public void getNewGrant(){
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Util.waitForPageLoad(driver, By.xpath("//*[text()='Get new grant']"), 30l);
        driver.findElement(By.xpath("//*[text()='Get new grant']")).click();
    }
}
