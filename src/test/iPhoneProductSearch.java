package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class iPhoneProductSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Chrome Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		/*Firefox Driver
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		WebDriver driver = new FirefoxDriver();
		*/
						
		driver.get("https://www.amazon.in/");			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		Thread.sleep(5000);
		
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("iphone 12");
		
		WebElement searchbutton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbutton.click();
		
		List<WebElement> itemText = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> itemprice = driver.findElements(By.xpath("//span[@class ='a-price-whole']"));
		
		
		System.out.println("Product names displayed are "+itemText.size());
		System.out.println("Product prices displayed are " +itemprice.size());
		
		for(int i=0 ;i<itemText.size();i++)
		{
			System.out.println("Product Name is " +itemText.get(i).getText()+ " and Product Price is "+itemprice.get(i).getText());
		}

	driver.close();	
		
	}
	
}	


