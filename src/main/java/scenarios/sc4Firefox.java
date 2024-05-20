package scenarios;


	
	 
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	 
	public class sc4Firefox {
	    protected WebDriver firefoxDriver;
	 
	    @BeforeTest
	    public void setUp() {
	        firefoxDriver = new FirefoxDriver();
	    }
	 
	    @Test
	    public void testBasicAuth() {
	 
	    	firefoxDriver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	    	String actual = firefoxDriver.findElement(By.xpath("//p[normalize-space(text())='Congratulations! You must have the proper credentials.']")).getText();
	    	String expected = "Congratulations! You must have the proper credentials.";
	    	Assert.assertEquals(actual, expected);
	    	System.out.println(actual);
	    }
	 
	   @AfterTest
	  public void tearDown() { 
	       firefoxDriver.quit();
	 }
	}

