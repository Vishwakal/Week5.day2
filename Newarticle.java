package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Newarticle extends BaseClasstng {
	@Test
	public void createNewArticle() throws InterruptedException {
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(5);
		// Click-All
		dom.findElementByXPath("//div[@id = 'd6e462a5c3533010cbd77096e940dd8c']").click();
		// Enter Service catalog in filter navigator and press enter
		dom.findElementByXPath("//input[@id = 'filter']").sendKeys("Knowledge");
		dom.findElementByXPath("//mark[text() = 'Knowledge']").click();
		// wait for 2 sec
		Thread.sleep(2000);
		// Switch to frame which is there in shadow dom
		WebElement frameEle = dom.findElementByXPath("//iframe[@id = 'gsft_main']");
		driver.switchTo().frame(frameEle);
		// Click on Create new Article
		driver.findElement(By.className("btn-group")).click();
		// Select knowledge base as IT
		driver.findElement(By.id("sys_display.kb_knowledge.kb_knowledge_base")).sendKeys("IT" + Keys.ENTER);
		// Click on search icon
		driver.findElement(By.id("lookup.kb_knowledge.kb_category")).click();
		// select IT
		driver.findElement(By.xpath("//span[text() = 'IT']")).click();
		// Select Java
		driver.findElement(By.xpath("//span[text() = 'Java']")).click();
		// Click on OK
		driver.findElement(By.id("ok_button")).click();
		// Fill Short description
		driver.findElement(By.id("kb_knowledge.short_description")).sendKeys("Short description");
		// Click on submit
		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
		System.out.println("New Article is created");
	}

}
