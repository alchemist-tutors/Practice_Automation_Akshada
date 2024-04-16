package webDriverBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException{
		 System.setProperty("webdriver.gecko.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\geckodriver-v0.34.0-win64\\geckodriver.exe");
				 
				 WebDriver driver = new FirefoxDriver();
				 
				 driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
				 
				 driver.findElement(By.className("signinbtn")).click(); //Clicked on sign in button without entering credentials to trigger the pop up
				 
				 Thread.sleep(5000); //To wait for 5 seconds
				 
				 
				 Alert alert = driver.switchTo().alert(); //takes you to the pop up from the browser window  --- ****VVV Imp***
				 //Alert is an Interface
				 
				 String s = alert.getText(); //returns the text on pop up
							 
				 System.out.println(s);
				 
				 alert.accept(); //Clicks on 'Ok' button of alert
				 
				 //alert.dismiss(); //Clicks on 'Cancel' button
				 
				 //alert.sendKeys("Proceed"); //Sometimes alert pop ups can have textboxes and then we need to click on Ok
				 
				 driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
				 
				 driver.findElement(By.xpath("//button[@onclick='myPromp()']")).click();
				 
				 Alert alert1 = driver.switchTo().alert();
				 
				Thread.sleep(2000);
				 alert1.sendKeys("Ok, will do");
				 
				 Thread.sleep(2000);
				 
				 alert1.accept();

				 Thread.sleep(2000);
				 
				 driver.quit();
				 

	}

}
