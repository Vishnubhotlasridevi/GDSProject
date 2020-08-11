package gdsproject.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;

    public void webdriverclass() {
        System.setProperty("webdriver.chrome.driver", "C:\\AllJavaProjects\\GDSProject\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://public:Let$BeC001@bgp-qa.gds-gov.tech/");
    }
    public void closeDriver(){
        driver.close();
    }
}