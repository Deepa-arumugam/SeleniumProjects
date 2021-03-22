package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataTable {
	
	WebDriver driver;
	
	@Given("^you entering calculator$")
	public void you_entering_calculator() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepaa\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/");
	}

	@When("^you enteres input$")
	public void you_enteres_input(List<List<Character>> table) throws Throwable {
		
		int i=0;
		for(List<Character> list : table) {
		
			char a = list.get(0);
			char x = list.get(1);
			char b = list.get(2);
		driver.findElement(By.xpath("//*[contains(text(),'"+a+"') and @class='scinm']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'"+x+"') and @class='sciop']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'"+b+"') and @class='scinm']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'=') and @class='scieq']")).click();
		String ans = driver.findElement(By.id("sciOutPut")).getText();
		System.out.println(ans);

		i++;
		
		}

	}

	
}
