import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectorCSS {
     WebDriver driver;

     @BeforeClass
     public void setUp() {
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          driver.manage().window().maximize();

     }

     @BeforeMethod

     public void navigate() {
          driver.get("http://the-internet.herokuapp.com/checkboxes");

     }

     @AfterClass

     public void tearDown() {
          driver.quit();

     }

     @Test
     public void CheckboxesTest() throws InterruptedException {

          WebElement CheckBox1 = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)"));
          Thread.sleep(2000);

          System.out.println("The checkbox selection state is - " + CheckBox1.isSelected());

          Assert .assertFalse(driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)")).isSelected());

          CheckBox1.click();
          Thread.sleep(2000);

          Assert.assertTrue(driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)")).isSelected());


          WebElement CheckBox2 = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)"));
          Thread.sleep(2000);
          System.out.println("The checkbox selection state is - " + CheckBox2.isSelected());

          Assert .assertTrue(driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)")).isSelected());

          CheckBox2.click();
          Assert .assertFalse(driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)")).isSelected());
          Thread .sleep(2000);


     }
}


