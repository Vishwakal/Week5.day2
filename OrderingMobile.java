package testNG;

import java.time.Duration;
import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderingMobile extends BaseClasstng{
	@Test
	public  void CreateOrdermobile() throws InterruptedException {
		// TODO Auto-generated method stub
		Shadow dom=new Shadow(driver); 
		dom.setImplicitWait(30);
		WebElement all = dom.findElementByXPath("//div[text()='All']"); 
		all.click();
		Thread.sleep(100);
		WebElement filter = dom.findElementByXPath("//input[@id='filter']"); 
		filter.sendKeys("Service catalog");
		Thread.sleep(1000);
		filter.sendKeys(Keys.ENTER);

		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']" );
		WebDriver frameSwitch = driver.switchTo().frame(frame);
		WebElement Mobiles = dom.findElementByXPath("//h2[contains(text(),'Mobiles')]"); 
		Mobiles.click();
		WebElement iphone = dom.findElementByXPath("//strong[text()='Apple iPhone 13']"); 
		iphone.click();
		Thread.sleep(100);
		WebElement Monthlydata = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select som = new Select(Monthlydata);
		som.selectByValue("500MB");
		driver.findElement(By.xpath("//label[text()='No']")).click();
		driver.findElement(By.xpath("//label[text()='Blue']")).click();
		driver.findElement(By.xpath("//label[text()='256 GB [add $100.00]']")).click();
		Thread.sleep(100);
		driver.findElement(By.id("oi_order_now_button")).click();
		String text = driver.findElement(By.id("requesturl")).getText();
		System.out.println("Request number :"+text);

		driver.close();



	}

}