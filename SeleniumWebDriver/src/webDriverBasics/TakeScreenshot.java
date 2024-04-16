package webDriverBasics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TakeScreenshot {

	public static void main(String[] args) throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				 
				 WebDriver driver = new ChromeDriver();
				 
				 driver.manage().window().maximize(); //maximize browser window
				 driver.manage().deleteAllCookies();
				 
				 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); //Even if the page is completely loaded - doesn't mean all elements are fully loaded
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //updated for implicitly wait since Selenium 4
				 
				 driver.get("http://www.facebook.com"); //launch URL
				 
				 //Taking Screenshots in 3 steps or can be done in 2 steps as well::
				 
				 //Step 1 :: Take Screenshot and store as a file format ::
				 File src = ((TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE); //getScreenshotAs() method
				 
				 //Step 2 :: Create a destination for the SS file
				 File dst =  new File("C:\\Users\\ameya\\eclipse-workspace\\SeleniumWebDriver\\facebook_SS.png");
				 
				 //Step 3 :: Now copy the screenshot to desired location using copyfile method ::
				 FileUtils.copyFile(src,dst); //copyFile() method

	}

}
