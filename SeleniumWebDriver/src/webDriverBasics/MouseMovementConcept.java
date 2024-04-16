package webDriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				 
				 WebDriver driver = new ChromeDriver();
				 
				 driver.manage().window().maximize(); //maximize browser window
				 driver.manage().deleteAllCookies();

				 driver.get("https://www.airindia.com/");
		
				 Actions a = new Actions(driver); //Actions class helps with the -- Mouse movements
				 
				 Thread.sleep(3000);
				 
				 a.moveToElement(driver.findElement(By.id("headernav0"))).build().perform(); //hover functionality
				 
				 driver.findElement(By.id("header0menu0link0")).click();
	}

}
