package seleniumsample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		WebElement table = driver
				.findElement(By.xpath("//*[@id=\'post-body-5867683659713562481\']/div[1]/div[4]/table"));

		List<WebElement> structure = table.findElements(By.tagName("th"));
		System.out.println("Number of Column :" + structure.size());
		System.out.println("COLUMN VALUE :");
		for (WebElement title : structure) {
			String text = title.getText();
			System.out.println( text);
		}

		System.out.println(" =========================== ");
		
		
//read a rows
		List<WebElement> row = table.findElements(By.tagName("tr"));
		System.out.println("Number of rows :" + row.size());
		System.out.println("ROW VALUE : ");
		for (WebElement title : row) {
			String text = title.getText();
			System.out.println(text);
		}
		System.out.println("================================");
		
//Highest value
		
		List<WebElement> highestValue = driver.findElements(
				By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/tbody/tr/td[3]"));
		
		List<Integer> storeValue = new ArrayList<Integer>();
		for (WebElement webElement : highestValue) {
			String Value =	webElement.getText().replace("m", "");
			
		storeValue.add(Integer.parseInt(Value));
		}
		System.out.println("Final value" +storeValue);
		int LargestValue = Collections.max(storeValue);
		System.out.println("Largest value : "+ LargestValue);
		
		List<WebElement> lastColumn = table.findElements(By.xpath("//table[@class=\"tsc_table_s13\"]/tfoot//tr"));		
		int lastSizeColumn = lastColumn.size();	
		System.out.println("Size of the last column : " +lastSizeColumn);
	}
	

}
