package seleniumsample;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.myntra.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input")).sendKeys("kurti");

		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='desktop-header-cnt']/div[2]/div[3]/div/ul/li"));
		for (WebElement webElement : list) {
			if (webElement.getText().equals("Kurtis For Women")) {
				webElement.click();
				break;
			}
		}
		driver.findElement(By.xpath("//*[@id='desktopSearchResults']/div[2]/section/ul/li[1]/a")).click();

		Set<String> set = driver.getWindowHandles();
		for (String window : set) {
			driver.switchTo().window(window);
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='sizeButtonsContainer']/div[2]/div[2]/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id='mountRoot']/div/div/div/main/div[2]/div[2]/div[3]/div/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='mountRoot']/div/div/div/main/div[2]/div[2]/div[3]/div/a")).click();

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotfile = screenshot.getScreenshotAs(OutputType.FILE);
		String filename = "Myntra";
		File file = new File("C:\\Users\\vidhyasri.m\\eclipse-workspace\\selenium\\src\\test\\resources\\screen\\"
				+ filename + ".png");

		org.openqa.selenium.io.FileHandler.copy(screenshotfile, file);

	}

}
