
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class UserInteractions {
    public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Downloads\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		// Puts a Implicit wait, Will wait for 10 seconds before throwing exception
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Khởi động trang web
		driver.get("https://accounts.google.com");
		
//		// Điền giá trị 50 cho ô nhập liệu đầu tiên trên trang percent Caculator
//		driver.findElement(By.id("cpar1")).sendKeys("50");
                driver.findElement(By.id("identifierId")).sendKeys("kimhezin17");;
                driver.findElement(By.id("identifierNext")).click();
   
                WebDriverWait driverwait = new WebDriverWait(driver, 20 );
                WebElement element = driverwait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        
                driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("kothengancan1");
                driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
		
                WebDriverWait driverwait1 = new WebDriverWait(driver, 20 );
                WebElement element1 = driverwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='password']/div[2]/div[2]")));
		
		WebElement result = driver.findElement(By.xpath("//*[@id='password']/div[2]/div[2]"));
                result.getText();
		System.out.println("ket qua : " + result.getAttribute("value"));
		
		// Đóng trang web (trường hợp có 1 tab sẽ đóng trình duyệt)
//		driver.close();
// 
	}
}
