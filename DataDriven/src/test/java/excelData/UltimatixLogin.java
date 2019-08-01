package excelData;

import java.io.IOException;
import java.lang.reflect.Array;

import org.apache.commons.math3.geometry.spherical.oned.ArcsSet.Split;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UltimatixLogin {
	String strname = this.getClass().getName();
	String arrayname[] = new String[2];
	String[] splitarray = strname.split("\\.");
	static ExcelDataCaptureTest ecd = new ExcelDataCaptureTest();
	
	@Test
	public void UltimatixLogin() throws InterruptedException, IOException {
		System.out.println(splitarray[1]);
		ecd.TestCaseData(splitarray[1]);
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Selenium Req\\Web Drivers\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ecd.getData("URL"));

		
		driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys(ecd.getData("UserName"));
		driver.findElement(By.xpath("//*[@id='proceed-button']")).click();
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//*[@id='password-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='password-login']")).sendKeys(ecd.getData("Password"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@value='Submit']")).click();
	}
	

}
