package Week4Day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		
		WebElement menHover = driver.findElement(By.xpath("(//div[@class='desktop-navLink'])[1]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(menHover).perform();
		
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		
		String jacketsCOunt = driver.findElement(By.xpath("//h1[text()='Jackets for Men']/following-sibling::span")).getText();
		System.out.println("Number Of Jackets Displayed are  :"+jacketsCOunt);
		
		/*int number=Integer. parseInt(jacketsCOunt);
		System.out.println(number);*/
		
		String Jacketsub1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String Jacketsub2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		System.out.println("The Number Of Jackets In SubCategories   ");
		System.out.println(Jacketsub1);
		System.out.println(Jacketsub2);
		
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("DUKE");
		driver.findElement(By.xpath("(//label[@class=' common-customCheckbox'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		List<WebElement> brandDuke = driver.findElements(By.xpath("//h3[text()='Duke']"));
		System.out.println(brandDuke.size());
		for(WebElement webelement : brandDuke)
		{
			String text = webelement.getText();
			System.out.println(text);
		}
		
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']")).click();
		driver.findElement(By.xpath("(//label[@class='sort-label '])[3]")).click();
		
		
		String Price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("The Price of the first item  :"+Price);
		
		ChromeOptions options1 = new ChromeOptions();
		options1.addArguments("--disable-notifications");
		
		//driver.findElement(By.xpath("//img[@src='https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/productimage/2020/1/18/59c49e27-74a4-4563-9618-743e4fc4b0ce1579303691797-1.jpg']")).click();
		//builder.moveToElement(Sort).perform();
		driver.findElement(By.xpath("//img[@src='https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/productimage/2020/1/7/bf74cfa5-7f0f-42ce-8459-59b795596ec41578354948966-1.jpg']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winHandle=new ArrayList<String>(windowHandles);
		System.out.println("The Number Of Window  :"+winHandle.size());
		driver.switchTo().window(winHandle.get(1));
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./snaps/myntra.png");
		FileUtils.copyFile(src, dst);
		
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.close();
		
		
		//driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
		//driver.findElement(By.xpath("//input[@value='discount']")).click();
		//Alert alert=driver.switchTo().alert();
		//alert.accept();
		
		/*driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		List<WebElement> dukeBrand = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']//h3"));
		System.out.println("Brands Of The Seleceted Items");
		for(WebElement webelement : dukeBrand)
		{
			System.out.println("Brands Listed :  "+ webelement.getText());
		}
		
		
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']")).click();
		
		WebElement Sort = driver.findElement(By.xpath("//img[@src='https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/productimage/2020/1/18/59c49e27-74a4-4563-9618-743e4fc4b0ce1579303691797-1.jpg']"));
		builder.moveToElement(Sort).perform();*/
		
		//driver.findElement(By.xpath("(//label[@class='sort-label '])[3]")).click();
		/*Set<String> windowHandles = driver.getWindowHandles();
		List<String> winHandle=new ArrayList<String>(windowHandles);
		System.out.println("The Number Of Window  :"+winHandle.size());
		driver.switchTo().window(winHandle.get(1));*/
	
	
	}

}
