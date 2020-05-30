
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ECommSite {

	 public WebDriver driver;

	    @BeforeClass
	    public void beforeClass() {
	    	 WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
			  String URL="http://automationpractice.com/index.php";
			  driver.get(URL);
			  driver.manage().window().maximize();
			 // driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    }

	   

	    @Test(priority=1)
	    public void ESignUp() {

	    	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    	
	    	//Click on Sign in
			  //driver.findElement(By.linkText("Sign in")).click();
	    	 driver.findElement(By.xpath("//a[@class='login']")).click();
			  
			  //Enter email address
			 // driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("test1249@test.com");
			  driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("testdemo43@test.com");
			  
			  //Click on "Create an account"
			  driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();
			  
			  //Select Title
			  driver.findElement(By.xpath("//div[@class='clearfix']//div[1]//label[1]")).click();
			 // driver.findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();
			  driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Test User");
			 // driver.findElement(By.name("customer_firstname")).sendKeys("Test User");
			 // driver.findElement(By.name("customer_lastname")).sendKeys("Vsoft");
			  driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Vsoft");
			  
			  driver.findElement(By.id("passwd")).sendKeys("PKR@PKR");
			  
			  // Enter your address
			  driver.findElement(By.id("firstname")).sendKeys("Test User");
			  driver.findElement(By.id("lastname")).sendKeys("Vsoft");
			  driver.findElement(By.id("company")).sendKeys("Vsoft");
			  driver.findElement(By.id("address1")).sendKeys("Test 81/1,2nd cross");
			  driver.findElement(By.id("city")).sendKeys("XYZ");
			  
			  // Select State
			  WebElement statedropdown=driver.findElement(By.name("id_state"));
			  Select oSelect=new Select(statedropdown);
			  oSelect.selectByValue("4");

			  driver.findElement(By.name("postcode")).sendKeys("51838");
			  
			  // Select Country
			  WebElement countrydropDown=driver.findElement(By.name("id_country"));
			  Select oSelectC=new Select(countrydropDown);
			  oSelectC.selectByVisibleText("United States");
			  
			  //Enter Mobile Number
			  driver.findElement(By.id("phone_mobile")).sendKeys("234567890");
			  driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
			  driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
			  driver.findElement(By.name("submitAccount")).click();
			  String userText=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();

			  // Validate that user has created
			  if(userText.contains("Vsoft")) {
			   System.out.println("User Verified,Test case Passed");
			  }
			  else {
			   System.out.println("User Verification Failed,Test case Failed");
			  }
	    }
	    
	    @Test(priority=2,dependsOnMethods="ESignUp")
	    public void EcomExpert (){
	    	
	    	  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

	    	  //Click on Sign out
	    	  driver.findElement(By.xpath("//a[@class='logout']")).click();
	    	  
	    	  //Click on Sign in
	    	  driver.findElement(By.xpath("//a[@class='login']")).click();
	    	  
	    	  //Login
	    	  driver.findElement(By.id("email")).sendKeys("testdemo43@test.com");
	    	  driver.findElement(By.id("passwd")).sendKeys("PKR@PKR");
	    	  driver.findElement(By.id("SubmitLogin")).click();
	    	  //Click on Women
	    	  driver.findElement(By.linkText("WOMEN")).click();

	    	  WebElement SecondImg=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
	    	  WebElement MoreBtn=driver.findElement(By.xpath("/html/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul/li[2]/div[1]/div[2]/div[2]/a[2]"));
	    	  Actions actions=new Actions(driver);
	    	  actions.moveToElement(SecondImg).moveToElement(MoreBtn).click().perform();

	    	  //Change quantity by 2
	    	  driver.findElement(By.id("quantity_wanted")).clear();
	    	  driver.findElement(By.id("quantity_wanted")).sendKeys("2");

	    	  //Select size as L
	    	  WebElement Sizedrpdwn=driver.findElement(By.xpath("//*[@id='group_1']"));
	    	  Select oSelect=new Select(Sizedrpdwn);
	    	  oSelect.selectByVisibleText("M");

	    	  //Select Color
	    	  driver.findElement(By.id("color_11")).click();

	    	  //Click on add to cart
	    	  driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();

	    	  //Click on proceed
	    	  driver.findElement(By.xpath("/html//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();
	    	  //Checkout page Proceed
	    	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
	    	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
	    	  //Agree terms&Conditions
	    	  driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
	    	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();

	    	  //Click on Payby Check
	    	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();
	    	  //Confirm the order
	    	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();

	    	  //Get Text
	    	  String ConfirmationText=driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();
	    	  
	    	  // Verify that Product is ordered
	    	  if(ConfirmationText.contains("complete")) {
	    	   System.out.println("Order Completed: Test Case Passed");
	    	  }
	    	  else {
	    	   System.out.println("Order Not Successfull: Test Case Failed");
	    	  }
	    }
	    
}
