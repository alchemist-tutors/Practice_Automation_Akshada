package webDriverBasics;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				 
				 WebDriver driver = new ChromeDriver();
				 
				 driver.manage().window().maximize(); //maximize browser window
				 driver.manage().deleteAllCookies();
				 
				 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); //Even if the page is completely loaded - doesn't mean all elements are fully loaded
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //updated for implicitly wait since Selenium 4
				 
				 driver.get("https://www.ebay.com/");
				 
				 //Get the total count of links on the page - All the links are represented by 'a' tag
				 List<WebElement> a = driver.findElements(By.tagName("a")); //DO not use .sendKeys or click() here - This returns a List of web elements
				 System.out.println("Number of links on the page are: " +a.size());
				 
				 List<WebElement> btn = driver.findElements(By.tagName("button"));
				 System.out.println("Number of buttons on the page are: " +btn.size());
				 
				 List<WebElement> img = driver.findElements(By.tagName("img"));
				 System.out.println("Number of images on the page are: " +img.size());
				 
				 List<WebElement> inputtag = driver.findElements(By.tagName("input"));
				 System.out.println("Number of input tags on the page are: " +inputtag.size());
				 
				 //Get the text of each link on the page
				 for(int i = 0; i<a.size(); i++) {
					 String linkText = a.get(i).getText();
					 System.out.println(linkText);
				 }

				 driver.quit();
	}

}
