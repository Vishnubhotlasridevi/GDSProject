package gdsproject.pages;

import org.openqa.selenium.By;

public class GrantActions extends AddGrantPage {

    public void proceed(){
        driver.findElement(By.id("keyPage-form-button")).click();
    }
}
