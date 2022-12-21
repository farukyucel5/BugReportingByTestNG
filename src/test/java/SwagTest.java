import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwagTest {
    static WebDriver driver;
    @BeforeClass
    public static void first(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

    }

    @Test
    public void test1(){
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
    }

    @Test
    public void test2(){

        driver.findElement(By.xpath("//a[@id='reset_sidebar_link']")).click();
    }

    @Test
    public void test3(){
        WebElement element=driver.findElement(By.xpath("//span[@class='select_container']"));
        Select select=new Select(element);

        select.selectByVisibleText("Name (Z to A)");
    }

    @AfterClass
    public static void close(){
        driver.quit();
    }


}
