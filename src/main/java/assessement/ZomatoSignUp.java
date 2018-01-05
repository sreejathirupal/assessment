package assessement;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZomatoSignUp {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		String path = "./data/sree.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook w1 = WorkbookFactory.create(fis);
		Sheet s1 = w1.getSheet("Sheet1");
		Row r1 = s1.getRow(1);
		String Fname = r1.getCell(0).getStringCellValue();
		String EmailId = r1.getCell(1).getStringCellValue();
		String Password = r1.getCell(2).getStringCellValue();

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.zomato.com/register");

		driver.manage().window().maximize();// maximize the window
		driver.findElementById("signup-link").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementByXPath("//a[@class='ui button massive basic fluid login-icons ld-small']").click();

		driver.findElementById("sd-fullname").sendKeys(Fname);
		driver.findElementById("sd-email").sendKeys(EmailId);
		driver.findElementById("sd-password").sendKeys(Password);
		driver.findElementById("sd-submit").click();

		if (EmailId.equals(Password)) {
			r1.createCell(3).setCellValue("true");

		} else {
			r1.createCell(3).setCellValue("false");
		}
		FileOutputStream fos = new FileOutputStream(path);
		w1.write(fos);

	}

}
