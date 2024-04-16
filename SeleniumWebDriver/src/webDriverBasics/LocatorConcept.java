package webDriverBasics;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

//Important finders::
//1. xpath
//2. id
//3. name
//4. cssSelector	

public class LocatorConcept {
	// Download Firebug Persona -- inspecting HTML, CSS and JavaScript elements on a
	// web page
	// Download Truepath -- for copying xpath

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\geckodriver-v0.34.0-win64\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Akshada"); // 'By' is a class //1. xpath

		driver.findElement(By.id("email")).sendKeys("abc.xyz@gmail.com"); // 2. id

		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();

		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("7896532148");
		
		driver.findElement(By.id("dob")).click();
		
		driver.wait(6000);
		
		driver.findElement(By.id("dob")).sendKeys("04");
		
		driver.findElement(By.id("dob")).sendKeys("04");
		
		driver.findElement(By.id("dob")).sendKeys("2000");
		
		driver.findElement(By.id("dob")).click();

		driver.findElement(By.name("subjects")).sendKeys("History");

		driver.findElement(By.id("hobbies")).click();

		driver.findElement(By.id("picture")).sendKeys("C:\\Users\\ameya\\Desktop\\Collage\\37.jpg"); //To upload a file on Browse button -- never use .click() method
		//just one condition to upload file is that :: while inspection of HTML web element -- the element should have an attribute called as -- type="file"
		
		driver.findElement(By.xpath("//textarea[@name='picture']")).sendKeys("123 old street");

		Select s = new Select(driver.findElement(By.id("state")));

		s.selectByVisibleText("NCR");

		Select s1 = new Select(driver.findElement(By.id("city")));

		s1.selectByIndex(1);

		Select s2 = new Select(driver.findElement(By.id("city")));

		// getting the list of options in the dropdown with getOptions()

		List<WebElement> op = s2.getOptions();

		int size = op.size();

		for (int i = 0; i < size; i++) {
			String options = op.get(i).getText();
			System.out.println(options);
		}

		System.out.println("****************************");

		// driver.get("https://www.tutorialspoint.com/selenium/practice/links.php");

		// driver.findElement(By.linkText("Home")).click(); //4. link text

		// driver.findElement(By.partialLinkText("Bad")).click(); //5. partial link text

		// driver.findElement(By.cssSelector("#unauthorized")).click(); //6. cssSelector

		// driver.wait(2000);

		// driver.quit();// To close the "browser" completely

	}

}
