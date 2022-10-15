package testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Newproposal extends BaseClasstng {
	@Test
	public void createNewProposal() throws InterruptedException {
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(5);
		// Click-All
		dom.findElementByXPath("//div[@id = 'd6e462a5c3533010cbd77096e940dd8c']").click();
		// Enter Service catalog in filter navigator and press enter
		dom.findElementByXPath("//input[@id = 'filter']").sendKeys("Proposal"); // +
																				// Keys.ENTER);
		dom.findElementByXPath("//mark[text() = 'Proposal']").click();
		// wait for 3 sec
		Thread.sleep(2000);
		// Switch to frame which is there in shadow dom
		WebElement frameEle = dom.findElementByXPath("//iframe[@id = 'gsft_main']");
		driver.switchTo().frame(frameEle);
		// Click on New
		driver.findElement(By.xpath("//button[text() = 'New']")).click();
		// Note the number
		String number = driver.findElement(By.id("std_change_proposal.number")).getAttribute("value");
		// Fill mandatory field - fill mandatory fields
		driver.findElement(By.id("std_change_proposal.short_description")).sendKeys("Week5 Assignment");
		// Click on Submit button
		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
		// Verify the successful creation of new Proposal"
		List<WebElement> newProposal = driver.findElements(By.xpath("//tbody[@class = 'list2_body']//td[3]/a"));
		// table[@id = 'std_change_proposal_table']//tbody//td[4]
		boolean isCreated = false;
		for (WebElement webElement : newProposal) {
			String proposalNum = webElement.getText();
			if (proposalNum.contains(number)) {
				isCreated = true;
				break;
			}
		}
		if (isCreated == true) {
			System.out.println(number + " proposal is created ");
		} else {
			System.out.println("New proposal is not created");
		}

	}

}
