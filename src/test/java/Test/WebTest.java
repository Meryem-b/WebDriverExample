package Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

 public class WebTest {
	 public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("acceptInsecureCerts");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-notifications");
			options.addArguments("disable-infobars");
			
			WebDriver driver = new ChromeDriver(options);
		
			driver.get("https://www.testandquiz.com/selenium/testing.html");
			driver.manage().window().maximize(); 
			
		   TimeUnit.SECONDS.sleep(2);
			
		   driver.findElement(By.linkText("This is a link")).click();
		   TimeUnit.SECONDS.sleep(1);
		   
		   driver.navigate().back();  //sayfada geri gider
		   TimeUnit.SECONDS.sleep(1);
		   
		    WebElement name = driver.findElement(By.id("fname"));
		    name.sendKeys("meryem sema");
		    TimeUnit.SECONDS.sleep(1);
		    name.clear();
		    TimeUnit.SECONDS.sleep(1);
		    
		    driver.findElement(By.id("idOfButton")).click();
		    TimeUnit.SECONDS.sleep(1);
		    
		    boolean radioButton = driver.findElement(By.id("female")).isSelected();
		    System.out.println(radioButton); //tıklı degil false döndü
		    TimeUnit.SECONDS.sleep(1);
		    driver.findElement(By.id("female")).click();
		    
		  //-------------------------------------------------------------------------------------------------------------
			boolean Checkbox = driver.findElement(By.xpath("//input[@type='checkbox'][@class='Automation']")).isEnabled();
		   // tıklı olup olmadıgını bu sekilde bulabiliriz.bu element tıklanabilir mi der
			System.out.println(Checkbox); // true dondü bir yere tıklamadı yani tıklı degil bi sonraki kod da tıkladım
			
			boolean Checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][@class='Automation']")).isSelected();
			System.out.println("BU FARKLI OLAN " + Checkbox2); 
			
			driver.findElement(By.xpath("//input[@type='checkbox'][@class='Automation']")).click();
		  //-------------------------------------------------------------------------------------------------------------
			
		    TimeUnit.SECONDS.sleep(1);
		    
		    driver.findElement(By.id("testingDropdown")).click();
		    TimeUnit.SECONDS.sleep(2);
		    
		    driver.findElement(By.id("performance")).click();
		    TimeUnit.SECONDS.sleep(2);
		    // yukardaki yerine bu da olur
		    // Locate the checkbox by cssSelector and check it using click() function
		 	//	driver.findElement(By.cssSelector("input.Automation")).click();
		    // Thread.sleep(2000);
		    // Use Select class for selecting value from dropdown
		 	//	Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));
		 	//	dropdown.selectByVisibleText("Database Testing");

		 
		    
		    //-------------------------------------------------------------------------------------------------------------
			WebElement doubleClickButton = driver.findElement(By.id("dblClkBtn"));
			//cift tıklama gerçekleştirmek için 
			Actions action = new Actions(driver);  //clasımın adı actions   //action. yazınca orada cıkanları kullanabilirsin  
			action.doubleClick(doubleClickButton).perform(); //clik işlemini bu sekilde gerçekleştirmiş olucaz
			TimeUnit.SECONDS.sleep(5);
			driver.switchTo().alert().dismiss();
			TimeUnit.SECONDS.sleep(5);
			//-------------------------------------------------------------------------------------------------------------
			
			// Handling alert boxes
			// Click on generate alert button
			driver.findElement(By.xpath("/html/body/div/div[11]/div/p/button")).click();
			// Using Alert class to first switch to or focus to the alert box
			Alert alert = driver.switchTo().alert();

			// Using accept() method to accept the alert box
			alert.accept();
			Thread.sleep(1000);

			//-------------------------------------------------------------------------------------------------------------
		 
			// Handling confirm box
			// Click on Generate Confirm Box
			driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button")).click();
			Thread.sleep(1000);
			
			Alert confirmBox = driver.switchTo().alert();

			// Using dismiss() command to dismiss the confirm box
			// Similarly accept can be used to accept the confirm box
			confirmBox.dismiss();
			Thread.sleep(1000);
			
			//-------------------------------------------------------------------------------------------------------------		
			// WebElement to which the above object is dropped
			driver.findElement(By.id("targetDiv"));
			Thread.sleep(1000);
			
			// WebElement on which drag and drop operation needs to be performed
			 driver.findElement(By.id("sourceImage"));
			 Thread.sleep(1000);
	      
			// Scroll down the webpage by 4500 pixels
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scrollBy(0, 4500)");

			Thread.sleep(2000);		

			// Close the Browser
			driver.close();

				}

			}

