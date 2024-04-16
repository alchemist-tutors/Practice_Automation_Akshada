package webDriverBasics;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitWaitConcept {

	//Thread.sleep() 		 -- Static wait
	//Implicit/Explicit wait -- Dynamic wait
	
	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				 
				 WebDriver driver = new ChromeDriver();
				 
				 driver.manage().window().maximize(); //maximize browser window
				 driver.manage().deleteAllCookies();

				// OLD ::
				// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //depricated since Selenium 4
				// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //depricated since Selenium 4
				
				 // NEW :: Dynamic wait
				 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5)); //Even if the page is completely loaded - doesn't mean all elements are fully loaded
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //updated for implicitly wait since Selenium 4
				 
	
				 //Page load timeout :: 
				 //Page load timeout in selenium can be defined as the time that a script grants for a web page 
				 //to load or be displayed. In case the page loads within the timeout limit, the script continues to run. 
				 //However, in the other case where the timeout limit is exceeded, the script stops and gives a timeout exception.
				 
				 //Here, the WebDriver instance waits for 30 seconds for every page to get loaded before throwing an exception. 
				 //If the page is not loaded in 30 seconds of time, then it throws TimedOutException at run time.
	
	//***********************************************************************************************************************************************//
				 
				 //Implicit wait ::
				 // Implicit wait is a process in which it notifies the web driver to wait for some specific time to check 
				 //if any element is not available on a web page. Only after the wait is over, it throws an exception ‘Nosuchelemtfound’ 
				 // if it does not find any element on the web page immediately.
	}

}
