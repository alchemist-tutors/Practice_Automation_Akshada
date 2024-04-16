package webDriverBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadPropertiesFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		 
		
		Properties p = new Properties();
		
		//FileInputStream class created a stream and connects properties file and the JAVA code
		FileInputStream ip = new FileInputStream("C:\\Users\\ameya\\eclipse-workspace\\SeleniumWebDriver\\src\\webDriverBasics\\Properties.properties"); //location of properties file
		
		p.load(ip); //load the properties file
		
		System.out.println(p.getProperty("name"));
		
		System.out.println(p.getProperty("age"));
		
		String url = p.getProperty("url");
		System.out.println(url);
		
		String browser = p.getProperty("browser");
		System.out.println(browser);	
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("IE")){
			System.setProperty("webdriver.ie.driver",
					 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
		}		

		driver.get(url);
		driver.manage().window().maximize();

		driver.findElement(By.name(p.getProperty("user_name"))).sendKeys(p.getProperty("userId"));
		driver.findElement(By.name(p.getProperty("pwd_name"))).sendKeys(p.getProperty("password")); 
		driver.findElement(By.xpath(p.getProperty("submit"))).click();
		 

		//JSE Concept :: for ebay.com -- register
		/*
		 * driver.findElement(By.id("businessName")).click();
		 * 
		 * WebElement wb = driver.findElement(By.id("businessName"));
		 * 
		 * JavascriptExecutor jse = (JavascriptExecutor)driver;
		 * jse.executeScript("arguments[0].value='Ameya'", wb);
		 */	
		
	}

}
