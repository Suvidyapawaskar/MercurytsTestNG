package mt.mercurytoursdatadriventest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Mercurytourstest {

	WebDriver driver;
	
	@BeforeSuite
	public void Openbrowser()
	{
		System.setProperty("webdriver.chrome.driver","G:\\Selenium Setup\\setup1\\chromedriver_win32 (8)\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("The browser is successfully opened");
		driver.manage().window().maximize();
	}

	@BeforeTest
	public void EnterApplicationurl()
	{
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		System.out.println("The url has entered successfully");
	}
	@AfterSuite
	public void Closebrowser()
	{
		driver.close();
	}
	
	@Test(dataProvider="getdata")
	public void Loginwithvaliddata(String username,String password) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();  
	}
	
	@DataProvider(name="getdata")
	public Object[][]getdata() throws IOException
	{
	Exceldataconfig config = new Exceldataconfig("F:\\Suvidya_data\\Java_Selenium\\mercurytoursdatadriventest\\src\\test\\resources\\Logindetails.xlsx");
	int rows=config.getRowcount("Sheet1");
	Object[][]data = new Object[rows][2];
	
	for(int i=0;i<rows;i++)
	{
		data[i][0]=config.getData("Sheet1", i, 0);
		data[i][1]=config.getData("Sheet1", i, 1);
		
	}
	
	return data;
	
	
	}
	
}
