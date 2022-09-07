package Assesment;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
    public ChromeDriver driver;
    public String filename;
    @Parameters({"url","username","password"})
    @BeforeMethod
    public void precondition(String url,String username,String password) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt2 = new ChromeOptions();
        opt2.addArguments("disable-notifications");
        driver = new ChromeDriver(opt2);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("Login")).click();
    }
    @AfterMethod
    public void postcondition() {
        driver.close();
    }
}
