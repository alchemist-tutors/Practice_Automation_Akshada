package webDriverBasics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				 
				 WebDriver driver = new ChromeDriver();
				 
				 driver.manage().window().maximize(); //maximize browser window
				 driver.manage().deleteAllCookies();
				 
				 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); //Even if the page is completely loaded - doesn't mean all elements are fully loaded
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //updated for implicitly wait since Selenium 4
				 
				 driver.get("http://www.facebook.com");
				 
				 driver.navigate().to("http://www.flipkart.com");
				 
				 driver.navigate().back();
				 
				 driver.navigate().forward();
				 
				 driver.navigate().back();
				 
				 driver.navigate().refresh();
				 
				 Thread.sleep(2000);
				 
				 //Difference between driver.get() method and driver.navigate().to() method ::
				 
				 //driver.get() : It's used to go to the particular website , 
				 //But it doesn't maintain the browser History and cookies so , we can't use forward and backward button , 
				 //if we click on that , page will not get schedule

				 //driver.navigate() : it's used to go to the particular website , but it maintains the browser history and cookies, 
				 //so we can use forward and backward button to navigate between the pages during the coding of Testcase
				 

	}

}
