package assignment3.v3;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class question1 {

    public static void main(String[] args) throws Exception {

    	FileInputStream file = new FileInputStream("C:/Users/sailu/Downloads/my.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getLastRowNum();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        for (int i = 1; i <= rows; i++) {

            String username = sheet.getRow(i).getCell(0).getStringCellValue();
            String password = sheet.getRow(i).getCell(1).getStringCellValue();

            driver.get("https://practicetestautomation.com/practice-test-login/");

            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys(username);

            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(password);

            driver.findElement(By.id("submit")).click();

            String currentUrl = driver.getCurrentUrl();

            if (currentUrl.contains("logged-in-successfully")) {
                System.out.println("Login SUCCESS for: " + username);
            } else {
                System.out.println(" Login FAILED for: " + username);
            }
        }

        // 🔹 Step 7: Close Resources
        driver.quit();
        workbook.close();
        file.close();
    }
}
