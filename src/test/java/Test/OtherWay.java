package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--allow-insecure-localhost");
		options.addArguments("acceptInsecureCerts");
		options.addArguments("--ignore-certificate-errors");

		WebDriver driver = new ChromeDriver(options);

		// Launch Website
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");

		// Fetch the text "This is sample text." and print it on console
		// Use the class name of the div to locate it and then fetch text using
		// getText() method
		String sampleText = driver.findElement(By.className("col-md-12")).getText();
		System.out.println(sampleText);

		Thread.sleep(2000);

		// Use the linkText locator method to find the link and perform click using
		// click() method
		driver.findElement(By.linkText("This is a link")).click();

		// Click on the textbox and send value
		driver.findElement(By.id("fname")).sendKeys("Selenium");

		Thread.sleep(2000);

		// Clear the text written in the textbox
		driver.findElement(By.id("fname")).clear();

		Thread.sleep(2000);

		// Click on the Submit button using click() command
		driver.findElement(By.id("idOfButton")).click();

		Thread.sleep(2000);

		// Locate the radio button by id and check it using click() function
		driver.findElement(By.id("male")).click();

		Thread.sleep(2000);

		// Locate the checkbox by cssSelector and check it using click() function
		driver.findElement(By.cssSelector("input.Automation")).click();

		Thread.sleep(2000);

		// Use Select class for selecting value from dropdown
		Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));
		dropdown.selectByVisibleText("Database Testing");

		Thread.sleep(2000);

		// WebElement on which drag and drop operation needs to be performed
		WebElement from = driver.findElement(By.id("sourceImage"));

		// WebElement to which the above object is dropped
		WebElement to = driver.findElement(By.id("targetDiv"));

		// Creating object of Actions class to build composite actions
		Actions act = new Actions(driver);

		// Performing the drag and drop action
		act.dragAndDrop(from, to).build().perform();

		Thread.sleep(2000);

		// Handling alert boxes
		// Click on generate alert button
		driver.findElement(By.xpath("/html/body/div/div[11]/div/p/button")).click();

		// Using Alert class to first switch to or focus to the alert box
		Alert alert = driver.switchTo().alert();

		// Using accept() method to accept the alert box
		alert.accept();

		// Handling confirm box
		// Click on Generate Confirm Box
		driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button")).click();

		Alert confirmBox = driver.switchTo().alert();

		// Using dismiss() command to dismiss the confirm box
		// Similarly accept can be used to accept the confirm box
		confirmBox.dismiss();

		Thread.sleep(2000);

		// Scroll down the webpage by 4500 pixels
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 4500)");

		Thread.sleep(2000);

		// Close the Browser
		driver.close();

	}

}
