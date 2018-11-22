/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author admin
 */
public class SeleniumNGTest {
    
    public SeleniumNGTest() {
    }

    @Test
    public void testSomeMethod() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com");
        
        driver.findElement(By.id("identifierId")).sendKeys("kimhezin17");
        driver.findElement(By.id("identifierNext")).click();
        
        WebDriverWait driverwait = new WebDriverWait(driver, 20 );
        WebElement element = driverwait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        
        driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("kothengancan1");
        driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
        
//        WebDriverWait driverwait1 = new WebDriverWait(driver, 20 );
//        WebElement element1 = driverwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='password']/div[2]/div[2]")));
//        Thread.sleep(5000);
 
        
        
//        WebDriverWait driverWait1 = new WebDriverWait(driver, 10);
//        WebElement element1 = driverWait1.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
//        WebElement we4 = driver.findElement(By.xpath("//*[@id='password']/div[2]/div[2]"));
//        String text = we4.getText();
//        
//        Assert.assertEquals(text, "Sai mật khẩu. Hãy thử lại hoặc nhấp vào Quên mật khẩu để đặt lại mật khẩu");
//        
    }
    
}
