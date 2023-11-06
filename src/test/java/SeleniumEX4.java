import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
public class SeleniumEX4
{
@Test
	public void GetMethods()
	{
				
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.facebook.com/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				WebElement emailInput = driver.findElement(By.id ("email"));
				String text1= emailInput.getAttribute("aria-label");
				System.out.println(text1);
				
				WebElement LoginText = driver.findElement(By.name("login"));
				String Text2= LoginText.getText();
				System.out.println(Text2);
				
				String text3 = LoginText.getCssValue("background-color");
				System.out.println(text3);
				
				String title = driver.getTitle();
				System.out.println(title);
				
				String url = driver.getCurrentUrl();
				System.out.println(url);
				
				String PageSource = driver.getPageSource();
				System.out.println(PageSource);
				
				driver.quit();
				
}
}
