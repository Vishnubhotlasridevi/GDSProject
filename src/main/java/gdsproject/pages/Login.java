package gdsproject.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Login extends BaseClass {

    public void clickLogin(){
        driver.findElement(By.id("login-button")).click();
    }

    public void enterLoginDetails(String nric,String name,String uen,String role){
        driver.findElement(By.name("CPUID")).sendKeys(nric);
        driver.findElement(By.name("CPUID_FullName")).sendKeys(name);
        driver.findElement(By.name("CPEntID")).sendKeys(uen);
        Select oSelect = new Select(driver.findElement(By.name("CPRole")));
        oSelect.selectByVisibleText(role);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
