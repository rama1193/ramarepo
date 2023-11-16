import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebDriver.*;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumExample2 
{
	@Test
	public void MouseMove()
	{
		ChromeDriver driver =new ChromeDriver();
		
		driver.get("https://demoqa.com/droppable");
		
		Actions action = new Actions(driver);
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));	
		action.dragAndDrop(sourceElement, targetElement).build().perform();
		
	}
}