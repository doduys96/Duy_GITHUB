/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Duy
 */
public class Duy_selenium {
   public void tc () throws IOException, InterruptedException{
       
       System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\Driver\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("http://demo.guru99.com/v4");
       
       ArrayList<String> userName = readExcelData(0);
       ArrayList<String> pass = readExcelData(1);
       
       for (int i = 0; i < userName.size(); i++) {
        driver.findElement(By.xpath("//*[@name='uid']")).sendKeys(userName.get(i));
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(pass.get(i));
        
        driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
//        Thread.sleep(6000);
        String RESULT = "Manger Id : "+ userName.get(i);
        String RESULT1 = "User or Password is not valid";
//        driver.findElement(By.xpath("//*[@href='Logout.php']")).click();
        try{
            Alert alt = driver.switchTo().alert();
            String actualBoxtitle = alt.getText();
            if(actualBoxtitle.contains(RESULT1)){
                System.out.println(userName.get(i)+ ": Login Fail");
                alt.accept();
            }  
        }catch(Exception Ex){
            WebElement result = driver.findElement(By.xpath("//*[@style='color: green']"));
            String s = result.getText();
            if(s.contains(RESULT)){
                System.out.println(userName.get(i)+ ": Login Pass");
                Thread.sleep(5000);
                driver.findElement(By.xpath("//*[@href='Logout.php']")).click();
                driver.switchTo().alert().accept();
//                driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
                }
            }
//            driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
        }
    
       
   }
   public ArrayList<String> readExcelData(int a1) throws FileNotFoundException, IOException{
       FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium.xls");
       HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet s = wb.getSheet("Sheet1");
        Iterator<Row> rowIt = s.iterator();
        rowIt.next();
        ArrayList<String> list = new ArrayList<String>();
        while(rowIt.hasNext()){
            list.add(rowIt.next().getCell(a1).getStringCellValue());
        }
//        System.out.println("Danh sach : : " + list);
        
        return list;
   }
    public static void main(String[] args) throws IOException, InterruptedException{
        Duy_selenium duy = new Duy_selenium();
        duy.tc();
    }
}
