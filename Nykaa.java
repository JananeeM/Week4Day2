package Week4Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.nykaa.com/");
		String title = driver.getTitle();
		System.out.println("Title Of The Page is   :"+title);
		//driver.switchTo().frame(0);
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(brands).perform();
		driver.findElement(By.xpath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']")).click();
		String title2 = driver.getTitle();
		System.out.println(title2);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//div[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		driver.findElement(By.xpath("//img[@class='listing-img']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winHandle=new ArrayList<String>(windowHandles);
		System.out.println("The Number Of Window  :"+winHandle.size());
		driver.switchTo().window(winHandle.get(1));
		driver.findElement(By.xpath("//div[@class='pull-left']//button[1]")).click();
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		String total = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println(total);
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		
		/*WebElement category = driver.findElement(By.xpath("//a[text()='categories']"));
		builder.moveToElement(category).perform();
		
		WebElement hair = driver.findElement(By.xpath("//a[text()='hair']"));
		builder.moveToElement(hair).perform();
		
		WebElement haircare = driver.findElement(By.xpath("//a[text()='hair care']"));
		builder.moveToElement(haircare);
		
		driver.findElement(By.xpath("//a[text()='Shampoo']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winHandle=new ArrayList<String>(windowHandles);
		System.out.println("The Number Of Window  :"+winHandle.size());
		driver.switchTo().window(winHandle.get(1));
		
		//driver.findElement(By.xpath("//div[text()='Category']")).click();
		*/
		String FinalPrice = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println(FinalPrice);
		if(total.equalsIgnoreCase(FinalPrice))
		{
			System.out.println("The Prices Are Verified And Matched");
		}
		else
			System.out.println("The Prices Are Not Matching");
	}

}
