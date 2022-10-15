package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Newcaller extends BaseClasstng {
	@Test
	public void createNewCaller() throws InterruptedException {
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(5);
		// Click-All
		dom.findElementByXPath("//div[@id = 'd6e462a5c3533010cbd77096e940dd8c']").click();
		// Enter Service catalog in filter navigator and press enter
		dom.findElementByXPath("//input[@id = 'filter']").sendKeys("Callers");
		dom.findElementByXPath("//mark[text() = 'Callers']").click();
		// wait for 3 sec
		Thread.sleep(2000);
		// Switch to frame which is there in shadow dom
		WebElement frameEle = dom.findElementByXPath("//iframe[@id = 'gsft_main']");
		driver.switchTo().frame(frameEle);
		// Click on New
		driver.findElement(By.xpath("//button[text() = 'New']")).click();
		// Fill first name
		driver.findElement(By.id("sys_user.first_name")).sendKeys("Anitha");
		driver.findElement(By.id("sys_user.last_name")).sendKeys("Mahendran");
		driver.findElement(By.id("sys_user.title")).sendKeys("Mrs");
		// Click on submit
		driver.findElement(By.id("sysverb_insert")).click();
		// Search and verify the newly created Caller"
		String lastName = driver.findElement(By.xpath("//tbody[@class = 'list2_body']//td[3]/a")).getText();
		if (lastName.contains("Mahendran")) {
			System.out.println("New Caller is creating for " + lastName);

		} else {
			System.out.println("New Caller is not creating");
		}

	}
}