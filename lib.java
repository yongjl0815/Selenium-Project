package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;	

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import static org.junit.Assert.*;


public class Lib{
	
	WebDriver driver;
	
    int pass_check_counter = 0;
    int total_checks = 0;
	
	//Create a new session
	public void setUp(String address) {
	   	System.setProperty("webdriver.gecko.driver","C:\\Extra\\kshows\\AVI\\Codes\\Selenium\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		this.driver.get(address);
	}
	
	
	//Go back to the previous page
	public void navigateBack() {
		this.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		this.driver.navigate().back();
	}
	//=======================================================================================
	
	
	@Test
	//Check the title of the page
	public void test_Title(String title) {
	    this.pass_check_counter += 1;
	    this.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String actualTitle = this.driver.getTitle();
        //if (actualTitle == title){
		if(actualTitle.equals(title)) {
            this.pass_check_counter += 1;
        }
        else {
        	System.out.println ("=====> Title check failed");
        	System.out.println ("Actual title is " + actualTitle);
        	System.out.println ("Expected title is " + title)	;	
        }
	}
	
	

//===== By Class
	@Test
    //check if an element is present 
    public void test_By_Class(String name) {
        total_checks += 1;
        try {
        	assertNotNull(this.driver.findElement(By.className(name)));
            pass_check_counter += 1;
        }
        catch(Exception e){
        	System.out.println ("=====> Class " + name + " is not present") ;
        }
    }

	@Test
    // check link
    public void test_Link_By_Class(String name) { 
        total_checks += 1;
        try {
        	WebElement images_link = this.driver.findElement(By.className(name));      
            try {
                images_link.click();
                pass_check_counter += 1;
            }
            catch(Exception e) {
            	System.out.println ("=====> Link " + name + " can't be clicked");
            }
        }
        catch(Exception e){
        	System.out.println ("=====> Link " + name + " is not present");
        }
	}

	@Test
    // make sure search bar works
    public void test_Search_Box_Class(String name, String keyWord) {
        // locate, enter, and search        
		WebElement elem = this.driver.findElement(By.className(name));  
        //elem.clear();
        elem.sendKeys(keyWord);
        elem.submit();
        // makesure search result is not empty
        assertNotSame("No results found.", this.driver.getPageSource());
	}
            
            

//===== By Id
	@Test
    //check if an element is present 
    public void test_By_Id(String name) {
        total_checks += 1;
        try {
        	assertNotNull(this.driver.findElement(By.id(name)));
            pass_check_counter += 1;
        }
        catch(Exception e){
        	System.out.println ("=====> Id " + name + " is not present") ;
        }
	}

    // check link
    public void test_Link_By_Id(String name) {
        total_checks += 1;
        try {
            WebElement images_link = this.driver.findElement(By.id(name)) ;          
            try {
                images_link.click();
                pass_check_counter += 1;
            }
            catch(Exception e){
            	System.out.println ("=====> Link " + name + " can't be clicked");
            }
        }
        catch(Exception e){
        	System.out.println ("=====> Link" + name + "is not present");
        }
    }
 
 	@Test
    // make sure search bar works
    public void test_Search_Box_Id(String name, String keyWord) {
        // locate, enter, and search        
 		WebElement elem = this.driver.findElement(By.className(name));
        //elem.clear()
        elem.sendKeys(keyWord);
        elem.submit();
        // makesure search result is not empty
        assertNotSame("No results found.", this.driver.getPageSource()); 
 	}
        
            

//===== By Name
	@Test
    //check if an element is present 
    public void test_By_Name(String name) {
        total_checks += 1;
        try {
        	assertNotNull(this.driver.findElement(By.name(name)));
            pass_check_counter += 1;
        }
        catch(Exception e){
        	System.out.println ("=====> Name " + name + " is not present") ; 
        }
	}
            
	@Test
    // check link
    public void test_Link_By_Name(String name) {
        total_checks += 1;
        try {
            WebElement images_link = this.driver.findElement(By.name(name));         
            try {
                images_link.click();
                pass_check_counter += 1;
            }
            catch(Exception e){
            	System.out.println ("=====> Link " + name + " can't be clicked");
            }
        }
        catch(Exception e){
        	System.out.println ("=====> Link " + name + " is not present");
        }
	}
            
	@Test
    // make sure search bar works
    public void test_Search_Box_Name(String name, String keyWord) {
        // locate, enter, and search        
         WebElement elem = this.driver.findElement(By.name(name));  
        //elem.clear()
         elem.sendKeys(keyWord);
         elem.submit();
        // makesure search result is not empty
         assertNotSame("No results found.", this.driver.getPageSource()); 
	}
        

         
//===== By Tag
	@Test
    //check if an element is present 
    public void test_By_Tag(String name) {
        total_checks += 1;
        try {
        	assertNotNull(this.driver.findElement(By.tagName(name)));
            pass_check_counter += 1;
        }
        catch(Exception e) {
        	System.out.println ("=====> Tag" + name + "is not present") ;
        }
	}

	@Test
    // check link
    public void test_Link_By_Tag(String name) {
        total_checks += 1;
        try {
            WebElement images_link = this.driver.findElement(By.tagName(name));           
            try {
                images_link.click();
                pass_check_counter += 1;;
            }
            catch(Exception e) {;
            	System.out.println ("=====> Link " + name + " can't be clicked");
            }
        }
        catch(Exception e) {
        	System.out.println ("=====> Link " + name + " is not present");
        }
	}
 
 	@Test
    // make sure search bar works
    public void test_Search_Box_Tag(String name, String keyWord) {
        // locate, enter, and search        
        WebElement elem = this.driver.findElement(By.tagName(name));
        //elem.clear()
        elem.sendKeys(keyWord);
        elem.submit();
       // makesure search result is not empty
        assertNotSame("No results found.", this.driver.getPageSource()); 
        }
            
            
//===== By CSS
	@Test
    //check if an image is present 
    public void test_Image_By_Css(String name) {
        total_checks += 1;
        try {
            WebElement elem = this.driver.findElement(By.cssSelector(name));
            assertNotNull(elem);
            //print ("==> Image", .elem.get_attribute('src'), "is present")
            pass_check_counter += 1;
        }
        catch(Exception e) {
        	System.out.println ("=====> Image " + name + " is not present");
        }
    }

	@Test
    //check if an image is present 
    public void test_Text_By_Css(String name) {
        total_checks += 1;
        try {
            WebElement elem = this.driver.findElement(By.cssSelector(name));
            assertNotNull(elem);
            pass_check_counter += 1;
        }
        catch(Exception e) {
        	System.out.println("=====> Image " + name + " is not present"); 
        }
    }



//===== By Link Text
	@Test
    // check images link
    public void test_Link_By_Link_text(String name) {
        total_checks += 1;
        try {
            WebElement images_link = this.driver.findElement(By.linkText(name));
            try {
                images_link.click();
                pass_check_counter += 1;
            }
            catch(Exception e) {
            	System.out.println ("=====> Link " + name + " can't be clicked");
            }
        }
        catch(Exception e) {
        	System.out.println ("=====>  Link " + name + " is not present");	
        }
    }
	
	
	
	//=======================================================================================
	//Print result
	public void printResult() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Total test ran = " + this.total_checks);
		System.out.println("Total test passed = " + this.pass_check_counter);
		System.out.println("--------------------------------------------------------------");
	}
	
	
	//End the session
	public void tearDown() {
		this.driver.quit();
	}
}
