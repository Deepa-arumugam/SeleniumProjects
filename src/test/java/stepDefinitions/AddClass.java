package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddClass{		
		
	   WebDriver driver;

	   @Given("^user entering calculator$")
	   public void user_entering_calculator() throws Throwable {
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepaa\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.calculator.net/");
		   }

	   @When("^user is entered (\\d+) (.*) (\\d+)$")
	   public void user_is_entered(int a,char s ,int b) throws Throwable {
			driver.findElement(By.xpath("//*[contains(text(),'"+a+"') and @class='scinm']")).click();
			driver.findElement(By.xpath("//*[contains(text(),'"+s+"') and @class='sciop']")).click();
			driver.findElement(By.xpath("//*[contains(text(),'"+b+"') and @class='scinm']")).click();

	   }

		@When("^enters the equal to key$")
		public void enters_the_equal_to_key() throws Throwable {
			driver.findElement(By.xpath("//*[contains(text(),'=') and @class='scieq']")).click();

		}
		
		@Then("^the user see the results$")
		public void the_user_see_the_results() throws Throwable {
		
			String ans = driver.findElement(By.id("sciOutPut")).getText();
			System.out.println(ans);
		}
		
		@After
		public void ClosePage() {
		}
		
}