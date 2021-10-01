package Week4Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarWaleAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.carwale.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='o-brXWGL o-dsiSgT o-bUVylL o-AxjCR o-bkmzIL o-fHCdSc o-eZTujG o-TNyGU o-BEqzB o-frwuxB o-cOktWz o-flhBew o-bvnEWn o-cpnuEd']")).click();
		WebElement city=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		city.sendKeys("Chennai",Keys.ENTER);
		Thread.sleep(2000);
		WebElement selectCity = driver.findElement(By.xpath("//div[@class='o-fznJzu o-fznJPk o-OAYdd o-dbKqqe o-cpnuEd o-bUVylL o-eMXLyl o-GFmfi']"));
		Actions builder=new Actions(driver);
		builder.doubleClick(selectCity).perform();
	/*	
		WebElement sliderStart = driver.findElement(By.xpath("(//div[@class='o-eVIFUq o-cUSgRL o-fuiuOo o-jeeUx '])[1]"));
		//WebElement sliderEnd = driver.findElement(By.xpath("(//div[@class='o-eVIFUq o-cUSgRL o-fuiuOo o-jeeUx '])[1]"));
		Point location=sliderStart.getLocation();
		int x=location.getX();
		int y=location.getY();
		System.out.println(x);
		System.out.println(y);
		builder.clickAndHold(sliderStart);
		builder.dragAndDropBy(sliderStart, x+10, y);
		
		*/
		
		//driver.findElement(By.xpath("//div[text()='Choose your Budget']")).click();
		WebElement Slider1 = driver.findElement(By.xpath("(//button[@role='slider'])[1]"));
		WebElement Slider2 = driver.findElement(By.xpath("(//button[@role='slider'])[2]"));
		Point location=Slider1.getLocation();
		int x=location.getX();
		int y=location.getY();
		System.out.println(x);
		System.out.println(y);
		
		builder.dragAndDropBy(Slider1, 60, 0).perform();
		builder.dragAndDropBy(Slider2,-129, 0).perform();
	}

}
