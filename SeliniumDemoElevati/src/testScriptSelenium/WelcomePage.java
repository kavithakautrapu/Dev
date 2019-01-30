package testScriptSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	WebDriver driver = new FirefoxDriver();
	
	/*public WelcomePage(WebDriver wb){		
		System.out.println("In constructor");
		this.driver = wb;		
		PageFactory.initElements(wb, this);
		
	}*/
	
	public void homeScreen() throws InterruptedException {
		
		System.out.println("In homeScreen before app open");
		driver.navigate().to("http://pc0cqcje.in.ibm.com:7055/ElevatiDemo/");
		Thread.sleep(8000);
		System.out.println("In homescreen before button click");
		WebElement WButtonCheck = driver.findElement(By.id("showOrders"));
		WButtonCheck.click();
		Thread.sleep(1000);
		driver.close();
		driver.quit();
		
	}

}
