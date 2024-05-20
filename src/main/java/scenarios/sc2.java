package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class sc2 {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void SortableList() {
        Reporter.log("Starting testSortableList...");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://qaplayground.dev/apps/sortable-list/");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Jeff Bezos']")));

            Actions actions = new Actions(driver);
             //Names
            WebElement JeffBezos = driver.findElement(By.xpath("//p[text()='Jeff Bezos']"));
            WebElement BillGates = driver.findElement(By.xpath("//p[text()='Bill Gates']"));
            WebElement WarrenBuffett = driver.findElement(By.xpath("//p[text()='Warren Buffett']"));
            WebElement BernardArnault = driver.findElement(By.xpath("//p[text()='Bernard Arnault']"));
            WebElement CarlosSlimHelu = driver.findElement(By.xpath("//p[text()='Carlos Slim Helu']"));
            WebElement AmancioOrtega = driver.findElement(By.xpath("//p[text()='Amancio Ortega']"));
            WebElement LarryEllison = driver.findElement(By.xpath("//p[text()='Larry Ellison']"));
            WebElement MarkZuckerberg = driver.findElement(By.xpath("//p[text()='Mark Zuckerberg']"));
            WebElement MichaelBloomberg = driver.findElement(By.xpath("//p[text()='Michael Bloomberg']"));
            WebElement LarryPage = driver.findElement(By.xpath("//p[text()='Larry Page']"));
            
            
            //Positions
 
            WebElement Position1 = driver.findElement(By.xpath("//span[text()='1']"));
            WebElement Position2 = driver.findElement(By.xpath("//span[text()='2']"));
            WebElement Position3 = driver.findElement(By.xpath("//span[text()='3']"));
            WebElement Position4 = driver.findElement(By.xpath("//span[text()='4']"));
            WebElement Position5 = driver.findElement(By.xpath("//span[text()='5']"));
            WebElement Position6 = driver.findElement(By.xpath("//span[text()='6']"));
            WebElement Position7 = driver.findElement(By.xpath("//span[text()='7']"));
            WebElement Position8 = driver.findElement(By.xpath("//span[text()='8']"));
            WebElement Position9 = driver.findElement(By.xpath("//span[text()='9']"));
            WebElement Position10 = driver.findElement(By.xpath("//span[text()='10']"));
            
            
             // Drag and drop actions for sorting
            actions.dragAndDrop(JeffBezos, Position1).perform();
            actions.dragAndDrop(BillGates, Position2).perform();
            actions.dragAndDrop(WarrenBuffett, Position3).perform();
            actions.dragAndDrop(BernardArnault, Position4).perform();
            actions.dragAndDrop(CarlosSlimHelu, Position5).perform();
            actions.dragAndDrop(AmancioOrtega, Position6).perform();
            actions.dragAndDrop(LarryEllison, Position7).perform();
            actions.dragAndDrop(MarkZuckerberg, Position8).perform();
            actions.dragAndDrop(MichaelBloomberg, Position9).perform();
            actions.dragAndDrop(LarryPage, Position10).perform();

            Reporter.log("Sorting test passed successfully.");
        } catch (Exception e) {
            Reporter.log("Test failed: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        Reporter.log("Browser closed.");
    }
}
