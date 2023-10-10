package com.Baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;
	
	public static WebDriver BrowserLaunch(String Browser) {

		if  (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		} 
		
		else if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if (Browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver Launch_url(String url) {
		driver.get(url);
		return driver;
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void sendKeys(WebElement element1, String data) {
		element1.sendKeys(data);
	}

	public static void screenshot(String filename) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Eclipse projects\\NykaaMaven\\Screenshots\\" + filename + ".png");
		FileUtils.copyFile(src, dest);

	}

	public static void get_title(String m) {
		driver.getTitle();
	}

	public static void get_text(String xpath) {
		WebElement text = driver.findElement(By.xpath(xpath));
		text.getText();
	}

	public static void dropdown_Index(WebElement dropdown, int a) {
		Select s = new Select(dropdown);
		s.selectByIndex(a);
	}

	public static void dropdown_Value(WebElement dropdown, String value) {
		Select s = new Select(dropdown);
		s.selectByValue(value);
	}

	public static void dropdown_text(WebElement dropdown, String text) {
		Select s = new Select(dropdown);
		s.selectByVisibleText(text);
	}

	public static void Simple_alert() {
		Alert ok = driver.switchTo().alert();
		ok.accept();
	}
	public static void alert_dismiss() {
		
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	
	public static void rightclick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.contextClick(element).perform();
	}

	public static void mousehover(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}

	public static void drag_drop(String xpath) {
		WebElement from = driver.findElement(By.xpath("source xpath"));
		WebElement to = driver.findElement(By.xpath("target xpath"));

		Actions act = new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
	}

	public static void robot(String xpath) throws AWTException {

		driver.findElement(By.xpath(xpath));
		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_DOWN);
		ro.keyRelease(KeyEvent.VK_DOWN);

		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void frames_single(String xpath) {
		driver.switchTo().frame(xpath);

	}

	public static void Window_Handle(int window) {
		Set<String> handle = driver.getWindowHandles();
		List<String> wh = new ArrayList<>(handle);
		driver.switchTo().window(wh.get(window)).getCurrentUrl();
	}
	
	

//	public static void implicit_wait(String xpath) {
//		WebElement implicit = driver.findElement(By.xpath(xpath));
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//
//	}
//
//	public static void explicit_wait(String xpath) {
//		WebElement expli = driver.findElement(By.xpath(xpath));
//		WebDriverWait explicit = new WebDriverWait(driver, 10);
//		explicit.until(ExpectedConditions.visibilityOf(expli));
//	}

	public static void scrolldown(WebElement down) {
		JavascriptExecutor jd = (JavascriptExecutor) driver;
		jd.executeScript("arguements[0].scrollIntoView();", down);
		
		//jd.executeScript("window.scrollby(300,0);");
	}

	public static void scrollup(String xpath) {
		WebElement scroll = driver.findElement(By.xpath(xpath));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguements[0].scrollIntoView();", scroll);
		js.executeScript("window.scrollby(0,300);");
	}

	public static void clickJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}
	
}
