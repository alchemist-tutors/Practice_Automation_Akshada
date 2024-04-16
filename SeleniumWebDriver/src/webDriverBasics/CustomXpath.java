package webDriverBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomXpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				 
				 WebDriver driver = new ChromeDriver();
				 
				 driver.manage().window().maximize(); //maximize browser window
				 driver.manage().deleteAllCookies();
				 
				 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); //Even if the page is completely loaded - doesn't mean all elements are fully loaded
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //updated for implicitly wait since Selenium 4
				 
				 driver.get("https://www.ebay.com/");
				 
				 driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Books"); //method 1 : @id=''
				 
				 //driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
				 
				 driver.findElement(By.xpath("//input[contains(@id,'gh-btn')]")).click(); //method 2 : contains() - mostly used
				 
				 //Ue of 'contains' method in xpath:: In case of 'Dynamic id'
				 /*
				  * Eample, there is a website and an element has the id as :
				  * id = 'test_123'
				  * then, to locate the element we write - By.id("test_123")
				  * 
				  * The we refresh the website and id changes to :
				  * id = 'test_456'
				  * then, to locate the element we write - By.id("test_456")
				  * 
				  * The we refresh the website and id changes to :
				  * id = 'test_789'
				  * then, to locate the element we write - By.id("test_789")
				  * 
				  * Solution :::
				  * So in such cases - using contains we can write ::
				  * By.xpath("//input[contains(@id, 'test_')]")
				  */
				 
				 driver.navigate().back();			
				
				 Select s = new Select(driver.findElement(By.xpath("//select[starts-with(@id, 'gh-c')]"))); //Method 3 : starts-with()
				 s.selectByVisibleText("Art");
				
				 //driver.findElement(By.xpath("//button[ends-with(@id, '-a')]")).click(); //Method 4 : ends-with()
				 
				 driver.findElement(By.id("gh-shop-a")).click();
				 
				 // Creating a custom relative xpath for 'links' -- All links are represented by 'a' html tag - means anchor
				 driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click(); //Do not use @text - text() is a function //Method 5 : text()
				 Thread.sleep(2000);
				 driver.quit();
				 
				 //Disadvantages of Absolute xpath ::
				 //1. performance issue : slow
				 //2. Not reliable
				 //3. Can be changed at anytime in future
				 
				 //Advantages of relative xpath ::
				 //1. Very fast and robust
				 //2. Syntax is simple
				 //3. Unique and generic
				 //4. Can be used for dynamic elements
				 //5. Faster performance

	}

}
