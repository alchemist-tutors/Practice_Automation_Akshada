package webDriverBasics;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;


public class HTMLUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				 
				 //WebDriver driver = new ChromeDriver();
		
				//*************This Concept is called -- "Ghost Driver" OR "HeadLesss Browser"*************//
		
				//HTMLUnitDriver is NOT available from Selenium version 3 onwards.
				//To use HTMLUnitDriver -- We have to download HTMLUnitDriver JAR file.
		
				//Advantages of HTMLUnitDriver ::
				//1. testing is happening behind the scenes -- No browser is launched
				//2. very fast execution -- improves performance of the script
		
				//Disadvantages --
				//1. Not suitable for Actions class -- Mouse movement or double click or drag and drop etc -- These features cannot be automated 
				
				
				//Examples of HeadLess Browsers ::
				//1. HtmlUnitDriver - With JAVA
				//2. PhantomJS -- With JavaScript
				//3. 
				WebDriver driver = new HtmlUnitDriver(); //HTMLUnitDriver is a "CLASS" and it implements WebDriver Interface
				 
				 driver.manage().window().maximize(); //maximize browser window
				 driver.manage().deleteAllCookies();
				 
				 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); //Even if the page is completely loaded - doesn't mean all elements are fully loaded
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //updated for implicitly wait since Selenium 4
				 
				 driver.get("https://crmpro.com/");
				 
				 System.out.println("Before login title is: " +driver.getTitle());
				 
				 driver.findElement(By.name("username")).sendKeys("akshadad");
				 driver.findElement(By.name("password")).sendKeys("1234567");
				 
				 driver.findElement(By.xpath("//input[@type='submit']")).click();
				 
				 Thread.sleep(2000);
				 
				 System.out.println("After login title is: " +driver.getTitle());

	}
}
