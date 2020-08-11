package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
    public static void waitForPageLoad(WebDriver driver, By by, Long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);// 1 minute
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
