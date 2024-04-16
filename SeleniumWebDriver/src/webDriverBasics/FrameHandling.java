package webDriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\geckodriver-v0.34.0-win64\\geckodriver.exe");
				 
				 WebDriver driver = new FirefoxDriver();
				 
				 driver.get("https://classic.crmpro.com/index.html");
				 
				 driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("akshadad"); //username
				 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234567"); //pwd
				 
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//input[@type='submit']")).click(); //Submit btn
				 
				 Thread.sleep(30000);
				 
				 driver.switchTo().frame("mainpanel"); //switching from browser page into frame
				 
				 Thread.sleep(2000);
				 
				 driver.findElement(By.xpath("//a[@title='Contacts']")).click();
				 //OR
				 //driver.findElement(By.xpath("//a[contains(text(),'Contacts']")).click();
				 
		
				 
				 driver.findElement(By.xpath("//a[@title='Pipeline']")).click();
				 
				 Thread.sleep(2000);
				 
				 driver.quit();
	}

}
