package shopping.website;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ShoppingWebsiteTest {
	
	WebElement element;
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	
	@Test
	public void CheckDressExists() throws InterruptedException {
		
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.id("search_query_top")).sendKeys("dress",Keys.ENTER);
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[4]/div/div[2]/h5/a")).isDisplayed());
		WebElement printedChiffonDress = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[4]/div/div[2]/h5/a"));
		assertEquals("Text is not the same", "Printed Chiffon Dress", printedChiffonDress.getText());
		
	}

}
