package hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.UUID;

public class SimpleTest {
    WebDriver driver;
    @Test
    public void checkMethod(){
        System.setProperty("webdriver.chrome.driver", "C:\\ПРОГИ\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://151.80.70.42:3000/");
        driver.findElement(By.cssSelector("i.mdi-content-add")).click();

        driver.findElement(By.cssSelector("input[id=icon_prefix]")).clear();
        driver.findElement(By.cssSelector("input[id=icon_prefix]")).sendKeys(UUID.randomUUID().toString());

        driver.findElement(By.cssSelector("input[id=icon_telephone]")).clear();

        long timaInMillis = System.currentTimeMillis() %1000000000000L;

        driver.findElement(By.cssSelector("input[id=icon_telephone]")).sendKeys(((Long) timaInMillis).toString());

        driver.findElement(By.cssSelector("div.col.s9 a.save-btn")).click();
    }
    @AfterTest
    public void afterAll(){
        driver.quit();
    }
}
