package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class sc3 {

    private WebDriver driver;
    private WebDriverWait wait;
    private ArrayList<String> links;
    private ArrayList<String> pageTitles;
    private ArrayList<Integer> pageLinksCount;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        links = new ArrayList<>();
        pageTitles = new ArrayList<>();
        pageLinksCount = new ArrayList<>();
    }

    @Test
    public void storeUrlsTest() {
        String a = "https://www.lambdatest.com/blog/selenium-best-practices-for-web-testing/";
        String b = "https://www.ministryoftesting.com/articles/websites-to-practice-testing";
        String c = "https://naveenautomationlabs.com/opencart/";
        String d = "https://demo.guru99.com/";

        storeUrls(a, b, c, d);
    }

    @Test(dependsOnMethods = {"storeUrlsTest"})
    public void printPageUrlTitleLinkTest() {
        printPageUrlTitleLink();
    }

    @Test(dependsOnMethods = {"printPageUrlTitleLinkTest"})
    public void maxLinkPageTitleTest() {
        maxLinkPageTitle();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void storeUrls(String url1, String url2, String url3, String url4) {
        driver.get(url1);
        links.add(driver.getCurrentUrl());
        driver.get(url2);
        links.add(driver.getCurrentUrl());
        driver.get(url3);
        links.add(driver.getCurrentUrl());
        driver.get(url4);
        links.add(driver.getCurrentUrl());
    }

    public void printPageUrlTitleLink() {
        for (int i = 0; i < links.size(); i++) {
            driver.get(links.get(i));
            List<WebElement> count = driver.findElements(By.tagName("a"));
            pageTitles.add(driver.getTitle());
            pageLinksCount.add(count.size());

            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            System.out.println(count.size());
            System.out.println(" ");
        }
    }

    public void maxLinkPageTitle() {
        int maxLinks = Integer.MIN_VALUE;
        int maxLinksIndex = -1;

        for (int i = 0; i < pageTitles.size(); i++) {
            if (pageLinksCount.get(i) > maxLinks) {
                maxLinks = pageLinksCount.get(i);
                maxLinksIndex = i;
            }
        }

        if (maxLinksIndex != -1) {
            System.out.println("The highest page link:");
            System.out.println(pageTitles.get(maxLinksIndex) + " " + maxLinks);
        } else {
            System.out.println("No pages found");
        }
    }
}
