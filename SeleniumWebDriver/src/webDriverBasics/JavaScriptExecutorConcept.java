package webDriverBasics;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\ameya\\Desktop\\Akshada\\Selenium JARS and Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); //HTMLUnitDriver is a "CLASS" and it implements WebDriver Interface
		 
		 driver.manage().window().maximize(); //maximize browser window
		 driver.manage().deleteAllCookies();
		 
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40)); //Even if the page is completely loaded - doesn't mean all elements are fully loaded
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //updated for implicitly wait since Selenium 4
		 
		 driver.get("https://crmpro.com/");
		 
		 System.out.println("Before login title is: " +driver.getTitle());
		 
		 driver.findElement(By.name("username")).sendKeys("akshadad");
		 driver.findElement(By.name("password")).sendKeys("1234567");
		 
		 //driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
		 WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		 
		 flash(loginBtn, driver); //Highlight the element
		 
		 drawBorder(loginBtn, driver); //Draw a border around login btn
		 
		//Taking Screenshots in 3 steps or can be done in 2 steps as well::
		 
		 //Step 1 :: Take Screenshot and store as a file format ::
		 File src = ((TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE); //getScreenshotAs() method
		 
		 //Step 2 :: Create a destination for the SS file
		 File dst =  new File("C:\\Users\\ameya\\eclipse-workspace\\SeleniumWebDriver\\loginbtn_border.png");
		 
		 //Step 3 :: Now copy the screenshot to desired location using copyfile method ::
		 FileUtils.copyFile(src,dst); //copyFile() method
		 
		 generateAlert(driver, "There is an issue with login button on login page"); //generate user defined alert message at run time on web page
		 
		 Alert a = driver.switchTo().alert();
		 a.accept();
		 
		// clickElementByJS(loginBtn, driver); //Click on any element (img, button, link) using JSE
		 
		 //Refresh the page using normal selenium ::
		 //1 --- driver.navigate().refresh();
		 
		 //Refresh the page using JSE ::
		 refreshBrowserByJS(driver);
		 
		//System.out.println(getTitleByJS(driver)); //Get the title of the web page
		
		//System.out.println(getPageInnerTextJSE(driver)); //Get all the text present on the web page
		 
		//scrollpageDown(driver);
		 
		WebElement fp = driver.findElement(By.linkText("Forgot Password?"));
			
		scrollIntoView(fp, driver);;	
		
	}
	
	public static void flash(WebElement element, WebDriver driver) throws InterruptedException {                         
        
        String bgcolor = element.getCssValue("backgroundColor");   //Using getCSSValue() to get the color of the button                          
        
        for (int i = 0; i<10; i++) {   //Will blink 10 times                                                           
            changeColor("rgb(0,200,0)", element,driver);//1                                  
                                                                       
            changeColor(bgcolor, element,driver);//2                                            
                                                                            
        }
    }
    public static void changeColor(String color, WebElement element, WebDriver driver) {         
    	
    	JavascriptExecutor js = ((JavascriptExecutor) driver);                                     
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element); //JS code

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
        }
    
    public static void drawBorder(WebElement element, WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);                                     
    	js.executeScript("arguments[0].style.border='3px solid red'", element);
    	
    }
    
    public static void generateAlert(WebDriver driver, String message) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);                                     
    	js.executeScript("alert('"+message+"')");
    }
    
    public static void clickElementByJS(WebElement element, WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);  
    	js.executeScript("arguments[0].click()", element);
    	
    }
    
    public static void refreshBrowserByJS(WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver); 
    	js.executeScript("history.go(0)");
    	
    }
    
    public static String getTitleByJS(WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver); 
    	String title = js.executeScript("return document.title;").toString();
    	return title;
    	
    }
    
    public static String getPageInnerTextJSE(WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver); 
    	String pageText = js.executeScript("return document.documentElement.innerText;").toString();
    	return pageText;
    	
    }
    
    public static void scrollpageDown(WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver); 
    	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    
    //scrollpageUp method is also used to scroll up --  refer Prem sir's manual testing pdf to scroll using other options lile --
    //js.executeScript("window.scrollBy(0,-350)", "");
    
    public static void scrollIntoView(WebElement element, WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver); 
    	js.executeScript("arguments[0].scrollIntoView(true)", element);
    }
}
