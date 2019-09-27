import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PayModeTests {

    private WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        driver.get("https://pmx-qa3-cs.saas-n.com/px/login");
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='username']")));
        username.sendKeys("IOKTIABROV_QA3_I@paymode.com");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='password']")));
        password.sendKeys("Test1QAi234");
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        submit.click();
        wait.until(ExpectedConditions.titleContains("Verify Your Account - Paymode-X"));
        WebElement radiobutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='OOBSMS_primary']")));
        radiobutton.click();
        WebElement contin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        contin.click();
        wait.until(ExpectedConditions.titleContains("Verify Your Account"));


        String value = username.getText();

        Assert.assertEquals("string", "string", "Strings must be equal");


        driver.findElement(By.name("username"));
//new Select(login).selectByValue("value");
    }
}
