package webDriverBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckElementVisibility {
	
	//1. isDisplayed()
	//2. isEnabled()
	//3. isSelected()

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); //HTMLUnitDriver is a "CLASS" and it implements WebDriver Interface
		 
		 driver.manage().window().maximize(); //maximize browser window
		 driver.manage().deleteAllCookies();
		 
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40)); //Even if the page is completely loaded - doesn't mean all elements are fully loaded
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //updated for implicitly wait since Selenium 4
		 
		 driver.get("https://classic.freecrm.com/register/");
		 
		 //1 ----- isDisplayed() method -- this method is applicable for all the elements on the web page
		 // -- It will return true if the element is displayed or false if the element is not displayed	 
		 boolean display = driver.findElement(By.id("submitButton")).isDisplayed(); //Checking if submit button is displayed or not
		 System.out.println(display); //true
		 
		 
		 //2 ----- isEnabled() method -- The element is definitely present on the page - This method checks if the element is enable or not (Mostly used with buttons)
		 // -- It will return true if the element is Enabled or false if the element is not enabled
		 boolean disable = driver.findElement(By.id("submitButton")).isEnabled(); //Checking if submit button is enabled or not
		 System.out.println(disable); //false
		 
		 //Select "I agree" checkbox to enable submit button --
		 driver.findElement(By.name("agreeTerms")).click();
		 boolean enable = driver.findElement(By.id("submitButton")).isEnabled(); //submit button is enabled now
		 System.out.println(enable); //true
		 
		 //3 ----- isSelected() method -- Only applicable for checkbox, dropdowns, radio buttons :
		 driver.findElement(By.name("agreeTerms"));
		 boolean select =  driver.findElement(By.name("agreeTerms")).isSelected(); //submit button is enabled now
		 System.out.println(select); //true
		 
		 //De-select the checkbox ::
		 driver.findElement(By.name("agreeTerms")).click();
		 boolean deselect =  driver.findElement(By.name("agreeTerms")).isSelected(); //submit button is enabled now
		 System.out.println(deselect); //false
		 
		
	}

}
