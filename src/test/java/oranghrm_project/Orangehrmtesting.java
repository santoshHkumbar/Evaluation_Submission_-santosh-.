package oranghrm_project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orangehrmtesting {
	WebDriver driver;
	
	 @BeforeTest
	 public void bt() {
		 //open the website 
		 WebDriverManager.chromedriver().setup();
		 //open with Chrome browser
		 driver = new ChromeDriver();
		 //Visiting the applications
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 //window to be maximize
		 driver.manage().window().maximize();	

}
	 @Test
	 public void login() throws InterruptedException {
		 Thread.sleep(2000);
		// the login for the OrangeHRM website
		 driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			 Thread.sleep(2000);
}
	 
	 @Test(alwaysRun = true,dependsOnMethods = {"login"})
	 public void admin() throws InterruptedException {
		 Thread.sleep(2000);
		//After Login, click on Admit and select User Management > Users
		 driver.findElement(By.linkText("Admin")).click();
		 //Select 'User Management' from the dropdown.
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//i[@class='oxd-icon bi-chevron-down' and @with-container='false'])[1]")).click();
			Thread.sleep(4000);
			//Click 'Users'.
			driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']")).click();
		
		
	
		//Select 'Ranga Akunuri' from the Employee Name dropdown 
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Ranga");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='oxd-autocomplete-option'])[1]")).click();
		
		//search the 

		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.linkText("Admin")).click();
		 
	 }
	 
	 @Test(alwaysRun = true,dependsOnMethods = {"login"})
	 public void assertnew() throws InterruptedException {
		//Assert the Employee name of ‘James Butler’ and check the status whether enabled or not from the web table
			
			driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("James");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='oxd-autocomplete-option'])[1]")).click();
			
			driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")).click();
			driver.findElement(By.xpath("//div[@class='oxd-select-option --selected']")).click();
			
			
			
			//search the 

			 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
	 }
	 @Test(alwaysRun = true,dependsOnMethods = {"login"})
	 public void logout() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
	
				 driver.findElement(By.xpath("(//a[@class='oxd-userdropdown-link'])[4]")).click();
		
	 }

	 @AfterTest
	 public void close() {
		 //driver.close();
	 }
}
