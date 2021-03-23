package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataTableWithHeader {

	WebDriver driver;
	@Given("^you entering calculator website$")
	public void you_entering_calculator_website() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepaa\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.calculator.net/");
		System.out.println("In calculator website");
	}

	@When("^you enteres input values$")
	public void you_enteres_input_values(DataTable data ) throws Throwable {
	 
		List<Map<String,String>> list = data.asMaps(String.class, String.class);
		for (Map<String, String> map : list) {
			String a = map.get("a");
			String b = map.get("b");
			driver.findElement(By.xpath("//*[contains(text(),'"+a+"') and @class='scinm']")).click();
			driver.findElement(By.xpath("//*[contains(text(),'+') and @class='sciop']")).click();
			driver.findElement(By.xpath("//*[contains(text(),'"+b+"') and @class='scinm']")).click();
			driver.findElement(By.xpath("//*[contains(text(),'=') and @class='scieq']")).click();
			String ans = driver.findElement(By.id("sciOutPut")).getText();
			System.out.println(ans);
			if(ans.equals(String.valueOf(Integer.parseInt(a)+Integer.parseInt(b)))) {
				System.out.println("Test case passed");
			}else {
				System.out.println("Test case failed");

			}
			
		}
	}
	
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.close();
	}

}
