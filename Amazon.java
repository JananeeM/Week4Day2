package Week4Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro ",Keys.ENTER);
		String priceOfFirst = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The Proce Of The First Product Dispalyed is   :"+priceOfFirst);
	
		String customerRatings = driver.findElement(By.xpath("(//span[@class='a-size-base'])[1]")).getText();
		System.out.println("CustomerRating Of The First Displayed Product   :"+customerRatings);
		
		WebElement ratingStar = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-popover'])[1]"));
		Actions builder=new Actions(driver);
		builder.click(ratingStar).perform();
		
		WebElement webTable = driver.findElement(By.id("histogramTable"));
		
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		System.out.println("Number Of Rows In The Table :"+tableRows.size());
		
		WebElement webFirstRow = tableRows.get(0);
		
		
		List<WebElement> tableColumn = webFirstRow.findElements(By.tagName("td"));
		System.out.println("Number Of Columns In The Table :"+tableColumn.size());
		String Rating51 = tableColumn.get(0).getText();
		System.out.println(Rating51);
		String Rating5 = tableColumn.get(2).getText();
		System.out.println("5 Star Rating Percentage  :"+Rating5);
		
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winHandle=new ArrayList<String>(windowHandles);
		System.out.println("The Number Of Window  :"+winHandle.size());
		driver.switchTo().window(winHandle.get(1));
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='a-button-input'])[6]")).click();
		
		List<WebElement> TotalValue = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']"));
		for(int i=0;i<=TotalValue.size()-1;i++)
		{
			 String text = TotalValue.get(i).getText();
			 System.out.println(text);
		}
		System.out.println("Prices verified");
		
	
	}

}
