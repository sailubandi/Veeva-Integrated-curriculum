package assignment3.v3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class question2 {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Index Frame");
        driver.switchTo().defaultContent();

        driver.switchTo().frame("singleframe");
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Name Frame");
        driver.switchTo().defaultContent();

        driver.findElement(By.linkText("Iframe with in an Iframe")).click();

        WebElement outer = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        driver.switchTo().frame(outer);

        WebElement inner = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(inner);

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Nested Frame");

        driver.switchTo().defaultContent();

        driver.quit();
    }
}