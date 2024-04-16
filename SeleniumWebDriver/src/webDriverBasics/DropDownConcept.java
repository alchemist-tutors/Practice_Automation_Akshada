package webDriverBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownConcept {

	public static void main(String[] args) {
		
		
		 System.setProperty("webdriver.gecko.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\geckodriver-v0.34.0-win64\\geckodriver.exe");
				 
				 WebDriver driver = new FirefoxDriver();
				 
				 driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
				 
				 System.out.println(driver.getTitle());

		 Select s = new Select(driver.findElement(By.id("state")));
		 
		 s.selectByVisibleText("NCR");
		 
		 Select s1 = new Select(driver.findElement(By.id("city")));
		 
		 s1.selectByIndex(1);
	 			
     Select s2 = new Select(driver.findElement(By.id("city")));
	      
	      // getting the list of options in the dropdown with getOptions()
	      
	      List <WebElement> op = s2.getOptions();
	      
	      int size = op.size();
	      
	      for(int i =0; i<size ; i++){
	         String options = op.get(i).getText();
        System.out.println(options);
	      }
		
	      driver.quit();
	}

}
