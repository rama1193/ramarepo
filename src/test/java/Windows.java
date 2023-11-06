import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Windows 
{
@Test
public void alertHandle()
{
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://demoqa.com/alerts");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	driver.findElement(By.id("alertButton")).click();
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	alert.accept();
	driver.close();
}
@Test

public void OpenWinAndSwitch()
{
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://demoqa.com/alerts");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.navigate().to("https://www.google.com/");
	
	String currentWin = driver.getWindowHandle();
	Set<String> WindowIDs = driver.getWindowHandles();
	for(String Wind : WindowIDs)
	{
		driver.switchTo().window(Wind);
	}
	String text = driver.findElement(By.className("gb_t")).getText();
	System.out.println(text);
	driver.switchTo().window(currentWin);
	driver.close();
}
@Test

public void WinFrame()
{
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://demoqa.com/nestedframes");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	driver.switchTo().frame("frame1");
	WebElement ChildFrame = driver.findElement(By.xpath("//iframe[contains(@srcdoc,'Child Iframe')]"));
	driver.switchTo().frame(ChildFrame);
}

}
