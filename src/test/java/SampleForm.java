import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.*;
//import org.openqa.selenium.support.ui.Select;
 

public class SampleForm
{
	@Test
	public void FillForm()
	{
		ChromeDriver driver = new ChromeDriver();
	driver.get("https://demoqa.com/automation-practice-form");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor)driver;
Actions s=new Actions(driver);
	driver.findElement(By.id("firstName")).sendKeys("Rama");
	driver.findElement(By.id("lastName")).sendKeys("KRish");
	driver.findElement(By.id("userEmail")).sendKeys("rama@gmail.com");
	driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();

	driver.findElement(By.id("userNumber")).sendKeys("3298568923");
	WebElement dob=driver.findElement(By.id("dateOfBirthInput"));

    js.executeScript("arguments[0].scrollIntoView(true)",dob);
    s.doubleClick(dob).build().perform();
    dob.sendKeys("13 Mar 2013");
	dob.sendKeys(Keys.ESCAPE);
   // WebElement Day = driver.findElement(By.id("react-datepicker__month"));
    
	//WebElement Month = driver.findElement(By.className("react-datepicker__month-select"));
	//Select selectMonth = new Select(Month);
	//selectMonth.selectByVisibleText("March");
	driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
	driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();
	driver.findElement(By.id("currentAddress")).sendKeys("6105 fire water drive");
	
	
	
	}
	
}
