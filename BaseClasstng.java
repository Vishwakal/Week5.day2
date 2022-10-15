package testNG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClasstng {
	public EdgeDriver driver;
	String filename;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod
	public void preCondition(String url, String username, String password) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		// Launch ServiceNow application
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// driver.findElement(By.xpath("//a[text() = 'Agree and
		// Proceed']")).click();
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("sysverb_login")).click();
		}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
//	@DataProvider(name="ExcelResult")
//	public String[][] fetchdata() throws IOException{
//		String[][] data;
//		data =ReadExcelData.readSheetData(filename);
//		return data;
//	}
//}

