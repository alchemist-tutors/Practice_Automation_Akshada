package webDriverBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTestingUsingChromeOptions {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				 
				 ChromeOptions options = new ChromeOptions();
				 options.addArguments("windoe-size=1400,800");
				 options.addArguments("headless");
				 
				 WebDriver driver = new ChromeDriver(options);
				 
				 driver.manage().window().maximize(); //maximize browser window
				 driver.manage().deleteAllCookies();
				 
				 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); //Even if the page is completely loaded - doesn't mean all elements are fully loaded
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //updated for implicitly wait since Selenium 4
				 
				 driver.get("http://www.instagram.com"); //launch URL
				 
				 System.out.println("Login page title is: " +driver.getTitle());
				 
				 driver.findElement(By.name("username")).sendKeys("life_on_a_bullet");
				 
				 driver.findElement(By.name("password")).sendKeys("Sfit@561");
				 
				 driver.findElement(By.xpath("//button[@type='submit']")).click();
				 
				 System.out.println("Home page title is: " +driver.getTitle());
	}

}
