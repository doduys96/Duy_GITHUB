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


/**
 *
 * @author admin
 */
public class Selenium {
    private static WebDriver driver = null;
    public static void main(String[] args) {
        
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com");
        
        WebElement we =  driver.findElement(By.id("identifierId"));
        we.sendKeys("kimhezin17");
        WebElement we1 = driver.findElement(By.id("identifierNext"));
        we1.click();
        
        WebDriverWait driverwait = new WebDriverWait(driver, 20 );
        WebElement element = driverwait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        
        WebElement we2 = driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
        we2.sendKeys("kothengancan1");
        WebElement we3 = driver.findElement(By.xpath("//*[@id='passwordNext']/content/span"));
        we3.click();
        
        WebElement we4 = driver.findElement(By.xpath("//*[@class='dEOOab RxsGPe']"));
        String text = we4.getText();
        System.out.println("" + text);
        
                
    }
    
}
