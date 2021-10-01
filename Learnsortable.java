package Week4Day2;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Learnsortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/sortable");
		String title = driver.getTitle();
		System.out.println("Title Of The Page is   :"+title);
		
		driver.switchTo().frame(0);
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		
		Actions builder=new Actions(driver);
		Point loctaion=item2.getLocation();
		int x = loctaion.getX();
		int y = loctaion.getY();
		builder.dragAndDropBy(item1, x, y).perform();
		
	
		Point loctaion2=item4.getLocation();
		int x1 = loctaion2.getX();
		int y1 = loctaion2.getY();
		builder.dragAndDropBy(item3, x1, y1).perform();
		
		
	
		

	}

}
