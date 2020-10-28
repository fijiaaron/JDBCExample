import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class HelloSelenium
{
	@Test
	public void openChromeDriver()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.chrome.com");
		driver.quit();
	}

	@Test
	public void openFirefoxDriver()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://firefox.com");
		driver.quit();
	}

	@Test
	public void openEdgeDriver()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://microsoftedge.com");
		driver.quit();
	}

	@Test
	public void openSafariDriver() throws IOException
	{
		WebDriver driver = new SafariDriver();
		driver.get("https://safari.com");
		driver.manage().window().maximize();
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("/tmp/creenshot.png"));

		driver.quit();
	}

}
