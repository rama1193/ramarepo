import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumEx3 {
	@Test
	public void dropdown()
	{
				
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.facebook.com/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				driver.findElement(By.linkText("Create new account")).click();
				driver.findElement(By.name("firstname")).sendKeys("First Name");
				driver.findElement(By.name("lastname")).sendKeys("LastNAme");
				
				WebElement dayElement = driver.findElement(By.id("day"));
				Select selectDay= new Select(dayElement);
				selectDay.selectByVisibleText("10");
				
				WebElement monthElement = driver.findElement(By.id("month"));
				Select selectMonth= new Select(monthElement);
				selectMonth.selectByVisibleText("Mar");
				
	}

}
