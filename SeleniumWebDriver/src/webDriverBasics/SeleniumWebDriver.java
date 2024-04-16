package webDriverBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumWebDriver {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); //path for ChromeDriver
		WebDriver driver1 = new ChromeDriver(); // already implements WebDriver Interface
		driver1.get("http://www.google.com"); //get() method are already included in "WedbDriver" interface - It's used to launch the URL
		String title = driver1.getTitle(); //To get the title of the web page
		System.out.println(driver1.getTitle());
		if(title.equals("Google")) {
			System.out.println("Correct title");
		}
		else {
			System.out.println("Incorrect title");
		}
		driver1.quit(); //To close the "browser" completely

		System.out.println("******************************");

		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\geckodriver-v0.34.0-win64\\geckodriver.exe"
		 * );
		 * 
		 * WebDriver driver2 = new FirefoxDriver();
		 * 
		 * driver2.get("http://www.google.com");
		 * 
		 * System.out.println(driver2.getTitle());
		 * 
		 * driver2.quit();
		 */

	}

}
