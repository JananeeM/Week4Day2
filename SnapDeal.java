package Week4Day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.snapdeal.com/");
		String title = driver.getTitle();
		System.out.println("Title Of The Page is   :"+title);
		
		WebElement mensFashion = driver.findElement(By.xpath("(//a[@class='menuLinks leftCategoriesProduct '])[6]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(mensFashion).perform();
		
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		String countOfSportsShoe = driver.findElement(By.xpath("//span[@class='category-count']")).getText();
		System.out.println(countOfSportsShoe);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		WebElement sliderLeft = driver.findElement(By.xpath("//a[@class='price-slider-scroll left-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));
		//WebElement sliderRight = driver.findElement(By.xpath("//a[@class='price-slider-scroll right-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));
		
		
		builder.clickAndHold(sliderLeft).perform();
		builder.dragAndDropBy(sliderLeft,10,0).perform();
		builder.release();
		
		WebElement sliderRight = driver.findElement(By.xpath("//a[@class='price-slider-scroll right-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));
		
		builder.clickAndHold(sliderRight).perform();
		builder.dragAndDropBy(sliderRight,-60, 0).perform();
		
		WebElement slidertext = driver.findElement(By.xpath("//input[@name='toVal']"));
		slidertext.clear();
		slidertext.sendKeys("2000");
		Thread.sleep(2000);
		
		
		/*WebElement sliderRight = driver.findElement(By.xpath("//a[@class='price-slider-scroll right-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));
		builder.clickAndHold(sliderRight).perform();
		builder.dragAndDropBy(sliderRight,40,0).perform();*/
		
		//driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		//driver.findElement(By.xpath("//input[@id='Color_s-Navy']")).click();
		
		
		WebElement mouseHovernavy = driver.findElement(By.xpath("//img[@title='FORCE 10 By Liberty Navy Running Sports Shoes']"));
		builder.moveToElement(mouseHovernavy).perform();
		driver.findElement(By.xpath("(//div[@supc='SDL487786658'])[1]")).click();
		

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winHandle=new ArrayList<String>(windowHandles);
		System.out.println("The Number Of Window  :"+winHandle.size());
		driver.switchTo().window(winHandle.get(1));
		
		String mrp = driver.findElement(By.xpath("//div[@class='pdpCutPrice ']")).getText();
		System.out.println("Mrp Of The Selected Shoe is   :"+mrp);
		
		String discMrp =driver.findElement(By.xpath("//span[@class='pdp-final-price']")).getText();
		System.out.println("Discounted MRP  :"+discMrp);
		
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./snaps/Snapdeal.png");
		FileUtils.copyFile(src, dst);
		
		driver.close();
		driver.quit();
		
	}

}
