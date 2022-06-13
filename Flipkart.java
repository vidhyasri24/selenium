package seleniumsample;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		WebElement searchKurthis = driver
				.findElement(By.xpath("//*[@id=\'container\']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input"));
		searchKurthis.sendKeys("smart watches" + Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement close = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
		close.click();

		List<WebElement> rating = driver.findElements(By.className("_3LWZlK"));
		System.out.println("Total number of rating  : "  +rating.size());
		
		List<Float> list = new ArrayList<Float>();
		
		for (WebElement webElement : rating) {
			String watchRating = webElement.getText();
			// System.out.println(watchRating);
			list.add(Float.parseFloat(watchRating));
		}
		Float maxRating = Collections.max(list);
		System.out.println("highest rating : " + maxRating);
		Float minRating = Collections.min(list);
		System.out.println("lowest rating: " + minRating);

	}
}