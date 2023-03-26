package testNG_assignnments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment_03 {
	
	ChromeDriver driver;
	String url = "http://www.flipkart.com";
	
	@BeforeTest
	public void invokeBrowser(){
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
	
		
		// \n \t -- escape character
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		driver.get(url);
		
	}
	
	
	@Test(priority = 0)
	public void getLinkCount(){
		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		
		System.out.println("Number of links on a page :: "+allLink.size());
	}
	
	
	@Test(priority = 1)
	public void getAllLinkInfo(){
		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		
		for(WebElement link:allLink){
			System.out.println("Link Text :: "+ link.getText());
			System.out.println("Link URL  :: "+ link.getAttribute("href"));
			
			System.out.println("-------------------------------------------");
		}
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
}
