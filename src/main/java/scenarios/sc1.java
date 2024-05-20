package scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class sc1 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to your ChromeDriver executable
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void tesMenuActions() throws InterruptedException {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(80))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);

        // Navigate to your web site
        driver.get("https://qaplayground.dev/apps/context-menu/");

        // Find the element to perform right click
        WebElement elementToRightClick = driver.findElement(By.xpath("//nav[@class='topnav']"));

        // Perform right click
        Actions actions = new Actions(driver);
        actions.contextClick(elementToRightClick).perform();

        // Find and click on the "Share" menu option
        WebElement shareMenuOption = driver.findElement(By.xpath("(//li[@class='menu-item share'])[1]"));
        Actions act = new Actions(driver);

        // Hover over the element
        act.moveToElement(shareMenuOption).perform();

        // Click on social media links
        clickSocialMediaLink(driver, "Twitter", "Menu item Twitter clicked");
        clickSocialMediaLink(driver, "Instagram", "Menu item Instagram clicked");
        clickSocialMediaLink(driver, "Dribble", "Menu item Dribble clicked");
        clickSocialMediaLink(driver, "Telegram", "Menu item Telegram clicked");
    }

    public static void clickSocialMediaLink(WebDriver driver, String platform, String expectedText) throws InterruptedException {
        // Find social media link
        WebElement socialMediaLink = driver.findElement(By.xpath("//span[text()='" + platform + "']"));
        socialMediaLink.click();

        // Get the text after clicking the link
        WebElement pageContent = driver.findElement(By.xpath("//p[@id='msg']"));
        String textAfterClick = pageContent.getText();

        Assert.assertEquals(expectedText, textAfterClick);
        System.out.println(textAfterClick);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
