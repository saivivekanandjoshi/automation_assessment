package scenarios;


	
	 
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	 
	public class sc4 {
	    protected WebDriver chromeDriver;
	 
	    @BeforeTest
	    public void setUp() {
	        chromeDriver = new ChromeDriver();
	    }
	 
	    @Test
	    public void testBasicAuth() {
	 
	    	chromeDriver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	    	String actual = chromeDriver.findElement(By.xpath("//p[normalize-space(text())='Congratulations! You must have the proper credentials.']")).getText();
	    	String expected = "Congratulations! You must have the proper credentials.";
	    	Assert.assertEquals(actual, expected);
	    	System.out.println(actual);
	    }
	 
	   @AfterTest
	  public void tearDown() { 
	       chromeDriver.quit();
	 }
	}

