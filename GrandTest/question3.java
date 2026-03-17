package assignment3.v3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class question3{

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void loginTest() {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        String url = driver.getCurrentUrl();

        if (url.contains("logged-in-successfully")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
