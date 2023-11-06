import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SelenuimExample1 {
	@Test
	public void Xpath()
	{
		ChromeDriver driver =new ChromeDriver();
		
		driver.get("https://demoqa.com/buttons");
		
		//WebElement element = driver.findElement(By.xpath("//input[@id='email']"));
		//element.sendKeys("Testing@gmail.com" );
		Actions action = new Actions(driver);
		WebElement RightClick = driver.findElement (By.id("rightClickBtn"));
		action.contextClick(RightClick).build().perform();
		
		
		
		driver.quit();
	}

}
