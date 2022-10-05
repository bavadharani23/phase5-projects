package com.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
	private static String url = "http://localhost:8080/P01AutomateWebApp/index.jsp";
	
	WebDriver driver;
	@Test

	public void ValidateLoginScript() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bava\\eclipse_workspace\\selenium\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get(url);
		
	}
	@Test(priority=3)
	private void addDetailsToLoginForm() throws InterruptedException {

		driver.findElement(By.cssSelector(".topnav > a:nth-child(2)")).click();
		driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys("Bavadharani");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("bava");
		
		Thread.sleep(3000);
		screenshot(driver,"loginss");

		Boolean Display = driver.findElement(By.xpath("/html/body/center/div/form/input[4]")).isDisplayed();
		System.out.println("Button displayed is "+ Display);
		Boolean Enable = driver.findElement(By.xpath("/html/body/center/div/form/input[4]")).isEnabled();
		System.out.println("Button Enabled is "+ Enable);

		driver.findElement(By.xpath("/html/body/center/div/form/input[4]")).click();
		Thread.sleep(2000);
		
		//switch focus to alert
		 Alert a = driver.switchTo().alert();
	      //get alert text
	      String s= driver.switchTo().alert().getText();
	      System.out.println("Alert text is: " + s);
	 
	      Thread.sleep(300);
	     //accepting alert
	      a.accept();
	      screenshot(driver,"alertmsg");
	      driver.navigate().to(url);
	     	
	}
	@Test(priority=1)
	private void addDetailToRegisterForm() throws InterruptedException {

		

		driver.findElement(By.xpath("/html/body/div/a[3]")).click();
		Thread.sleep(300);

		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Bavadharani@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"psw\"]")).sendKeys("bava");
		driver.findElement(By.xpath("//*[@id=\"psw-repeat\"]")).sendKeys("bava");

		Boolean Display1 = driver.findElement(By.xpath("/html/body/form/div[1]/button")).isDisplayed();
		System.out.println("Button displayed is "+ Display1);
		Boolean Enable1 = driver.findElement(By.xpath("/html/body/form/div[1]/button")).isEnabled();
		System.out.println("Button Enabled is "+ Enable1);
		screenshot(driver,"registers");
		Thread.sleep(300);

		driver.findElement(By.xpath("/html/body/form/div[1]/button")).click();

		Thread.sleep(300);
		driver.navigate().to(url);

	}
	
	@Test(priority=2)
	
	private void addToCart() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/a[4]")).click();
		Thread.sleep(300);
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("div.product-item:nth-child(1) > div:nth-child(4) > input:nth-child(2)")).click();
		driver.findElement(By.cssSelector("div.product-item:nth-child(2) > div:nth-child(4) > input:nth-child(2)")).click();
		driver.findElement(By.cssSelector("div.product-item:nth-child(3) > div:nth-child(4) > input:nth-child(2)")).click();
		driver.findElement(By.cssSelector("div.product-item:nth-child(4) > div:nth-child(4) > input:nth-child(2)")).click();
		Thread.sleep(300);
		screenshot(driver,"shoppingcart");
		driver.findElement(By.xpath("//*[@id=\"btnEmpty\"]")).click();
		screenshot(driver,"emptycart");
		driver.navigate().to(url);
		

	}
	
	public void screenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File(screenshotName + ".png"));
			System.out.println("Screenshot taken");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}