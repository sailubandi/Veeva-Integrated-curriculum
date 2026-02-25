package exam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class question3 {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

     
        driver.findElement(By.id("Wikipedia1_wikipedia-search-input"))
              .sendKeys("Selenium");

        driver.findElement(By.xpath("//input[@type='submit']"))
              .click();

    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='wikipedia-search-result-link']//a")));


        List<WebElement> links = driver.findElements(
                By.xpath("//div[@id='wikipedia-search-result-link']//a"));


        for (WebElement link : links) {
            System.out.println(link.getText());
        }

        driver.quit();
    }
}