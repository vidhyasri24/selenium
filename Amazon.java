package seleniumsample;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.xml.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Scanner scan = new Scanner(System.in);

		driver.get("http://www.amazon.in/");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("water bottles" + Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='brandsRefinements']/ul/li[8]/span/div/a/i")).click();

		List<WebElement> list = driver.findElements(By.xpath("//*[@id='brandsRefinements']/ul"));
		WebElement brands;
		for (WebElement webElement : list) {
			String waterBottle = webElement.getText();
			System.out.println(waterBottle);

			System.out.println("Enter The WaterBottle Brand Name");
			String bottleBrandName = scan.next();
			if (waterBottle.contains(bottleBrandName)) {

				System.out.println("Given brand is present");
				break;
			}
			else
			{
				System.out.println("Given Brand is not present");
			}
		}
		
	}
}

//
//		boolean brandList = list.contains("Cello");
//		System.out.println(brandList);
//
//		if (brandList) {
//			System.out.println("Given Brand is Contain");
//		}
//
//		else {
//			System.out.println("Given Brand is not Contain");
//		}
//	}
//}

//		Scanner scan = new Scanner(System.in);
//		String brandName = scan.next();
//		
//		if (list.equals(brandName)) 
//			System.out.println("contains");
//		else
//			System.out.println("not contains");

//		}}