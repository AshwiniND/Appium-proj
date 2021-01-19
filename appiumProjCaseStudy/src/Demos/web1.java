package Demos;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class web1 extends capability {
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void bt() throws Exception
	{
		driver = capability();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testCase1() throws Exception 
	{
		driver.get("http://www.cricbuzz.com");
		//driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[3]/div[2]/a/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		Thread.sleep(2000);
		List<AndroidElement> links = driver.findElements(By.tagName("h4"));
		System.out.println(links.size());
		
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
		}
		Thread.sleep(4000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'Top Stories')]"));
		js.executeScript("arguments[0].scrollIntoView()",ele);
		Assert.assertEquals(ele.getText(),"Top Stories");
	}

	
}
