package webDriverBasics;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HandleWindowPopUp {
	//Types of Pop-Ups :
	//1. Alerts -- JavaScript pop ups -- We use Alert API (accept, dismiss)
	//2. File upload Pop ups -- browse button (type='file', sendkeys(path of the file))
	//3. Browser window pop up -- Advertisement window/new tab/window (WindowHandler API -- getWindowHandles() )

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				 
				 WebDriver driver = new ChromeDriver();
				 
				 driver.manage().window().maximize(); //maximize browser window
				 driver.manage().deleteAllCookies();
				 
				 driver.get("https://demoqa.com/browser-windows");
				 
				// explicit wait - to wait for the compose button to be click-able
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));				 
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("windowButton"))).click();				 
	 
				 Set<String> handler = driver.getWindowHandles(); //get the ID of the new tab
				 
				 Iterator<String> it = handler.iterator();
				 
				 String parentWindowID = it.next();
				 System.out.println("Parent Window ID is: "+parentWindowID);
				 
				 String childWindowID = it.next();
				 System.out.println("Child Window ID is: "+childWindowID);			 
				 
				 driver.switchTo().window(childWindowID);	//switch to the child window		 				 
				 
				 System.out.println("Title of the child window is: "+driver.getTitle());
				 
				 WebElement t = driver.findElement(By.id("sampleHeading"));
				 
				 System.out.println("Text on child window is :"+ t.getText());
				 
				 driver.close();
				 
				 driver.switchTo().window(parentWindowID);
				 
				 //driver.switchTo().defaultContent();
				 
				 System.out.println("Title of the Parent window is: "+driver.getTitle());

	}

}
