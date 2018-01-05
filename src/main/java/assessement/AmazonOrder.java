package assessement;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonOrder {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/?tag=googinhydmabk-21&ref_=pd_mn_ABKror72");
		driver.manage().window().maximize();// maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Actions actions = new Actions(driver);
		WebElement mainmenu = driver.findElementById("nav-link-shopall");
		actions.moveToElement(mainmenu).build().perform();

		WebElement womesfash = driver.findElementByCssSelector("[data-nav-panelkey='WomensFashionPanel']");
		actions.moveToElement(womesfash).build().perform();

		driver.findElementByCssSelector(
				"div.nav-subcats > div:nth-of-type(8) > div.nav-column.nav-column-first > div:nth-of-type(2) > a:nth-of-type(1) > span.nav-text")
				.click();

		driver.findElementByXPath("//img[@alt='Fastrack']").click();
		driver.findElementByLinkText("Fastrack OTS Explorer Analog Blue Dial Men's Watch - 9463AL07J").click();

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows.size());
		ArrayList<String> allHandles = new ArrayList<String>();
		allHandles.addAll(allWindows);
		String secondWindow = allHandles.get(1);
		driver.switchTo().window(secondWindow);

		driver.findElementByXPath("//input[@id='buy-now-button']").click();
		driver.findElementByXPath("//input[@id='ap_email']").sendKeys("sreeja.thirupal@gmail.com");
		driver.findElementByXPath("//input[@id='continue']").click();
		driver.findElementByXPath("//input[@id='ap_password']").sendKeys("sreeja123");
		driver.findElementByXPath("//input[@id='signInSubmit']").click();

	}
}
