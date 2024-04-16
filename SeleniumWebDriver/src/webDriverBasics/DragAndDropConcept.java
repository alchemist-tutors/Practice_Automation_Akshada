package webDriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				 
				 WebDriver driver = new ChromeDriver();
				 
				 driver.manage().window().maximize(); //maximize browser window
				 driver.manage().deleteAllCookies();

				 Thread.sleep(4000);
				 
				 driver.get("https://jqueryui.com/droppable/");
				 
				 driver.switchTo().frame(0); //switch to frame only if it's present
				 
				Actions a = new Actions(driver);
				
				/*
				 * a.clickAndHold(driver.findElement(By.id("draggable")))
				 * .moveToElement(driver.findElement(By.id("droppable"))) 
				 * .release() 
				 * .build()
				 * .perform();
				 */
			  
				//OR
				
				WebElement drag = driver.findElement(By.id("draggable"));
				WebElement drop = driver.findElement(By.id("droppable"));
			   a.dragAndDrop(drag,drop).build().perform();
				
				

	}

}
