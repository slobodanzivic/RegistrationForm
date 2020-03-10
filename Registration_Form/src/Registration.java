import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class Registration {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://accounts.eclipse.org/user/register");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[id='edit-mail']")).sendKeys("peraperic@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='First name']")).sendKeys("Petar");
		driver.findElement(By.cssSelector("input[placeholder='Last name']")).sendKeys("Petrovic");
		driver.findElement(By.cssSelector("input[placeholder='Organization']")).sendKeys("Organizacija vencanja");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("password12345");
		driver.findElement(By.cssSelector("input[placeholder='Confirm password']")).sendKeys("password12345");
	
		WebElement country = driver.findElement(By.cssSelector("select[autocomplete='country']"));
		Select countrySelect = new Select(country);
		countrySelect.selectByVisibleText("France");
		
		WebElement createNewAccount = driver.findElement(By.cssSelector("div[class='col-sm-24'] [class='btn btn-primary btn-lg']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(createNewAccount);
		actions.perform();
		
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[name='op']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("div[class='alert alert-block alert-danger messages error']")).getText());
	
		driver.close();
	}
}
