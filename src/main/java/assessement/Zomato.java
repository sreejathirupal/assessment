package assessement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Zomato {
	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "./drivers/chromedriver.exe")	;
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.zomato.com/register#");
		driver.manage().window().maximize();//maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	
    

}
