package testScriptSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Start {

	public static void main(String[] args) throws InterruptedException {
		
		
		WelcomePage wp = new WelcomePage();
		System.out.println("Main method--before call");
		wp.homeScreen();
		System.out.println("Main method--after call");
		//Thread.sleep(2000);
		
		

	}

}
