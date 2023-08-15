package com.Ticket.POM;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.test.util.Credentials;

public class TrainTicket {
	

	 By  more_Button=By.xpath("//span[@class='more-arr']");
     By  Trains=By.xpath("//span[text()='Trains']");
     By  depart=By.xpath("//input[@id='BE_train_from_station']");
     By  depart_city =By.xpath("//input[@id='BE_train_from_station']");
     By  depart_city_dropdown =By.xpath("//li[@class='active ac_over']");
     By  arrivel_city =By.xpath("//input[@id='BE_train_to_station']");
     By  arrivel_city_dropdown =By.xpath("//li[@class='active ac_over']");
     By  search_train_button =By.xpath("//li[@class='active ac_over']");
     
     By  Login_button =By.xpath("//div[@class='Log-modal div-center']//button[@class='search-btn']");
     By  Email_input =By.xpath("//input[@id='login-input']");
     By  Continue_button =By.xpath("//button[@id='login-continue-btn']");
     By  password_input =By.xpath("//input[@id='login-password']");
     By  Login_submit =By.xpath("//button[@id='login-submit-btn']");

     By  selected_class =By.xpath("//body/div[@id='root']/div/div[@class='train-result']/div[@class='wrappers']/div[3]/div[1]/ul[1]/li[2]");

     By  Irctc_user_id =By.xpath("//div[@class='irctc-left']//input[@type='text']");
     By  Continue_Button =By.xpath("//button[text()='Continue']");
     By  Continue_Button_two =By.xpath("//div[@class='irctc-div mt20']//button[@class='search-btn']");

     By  Select_Price =By.xpath("//body[1]/div[1]/div[1]/div[5]/div[1]/div[3]/div[2]/div[2]/ul[5]/li[4]/button[1]");

     By  dine =By.xpath("//body[1]/div[1]/div[1]/div[5]/div[1]/div[3]/div[2]/div[2]/ul[5]/li[4]/button[1]");

   
	    public static Log log = LogFactory.getLog(FlightTicket.class);
	    Credentials creds = new Credentials();

	    
	    

	 public WebDriver train_tickets_E2E(WebDriver driver)   
	            throws Exception {
	    	
		 WebElement elementToHover = driver.findElement(more_Button);
             // Create an Actions instance to hover on 
	        Actions actions = new Actions(driver);
	        // Perform the hover action
	        actions.moveToElement(elementToHover).build().perform();
	        log.info("Hover on more button header");

	        driver.findElement(Trains).click();
	        log.info("Clicked on Trains button");
	        Thread.sleep(1000);
	        driver.findElement(depart_city).sendKeys("Mumbai");
	        log.info("Entred depart city initials");
	        driver.findElement(depart_city_dropdown).click();
	        log.info("Selected departure city from dropdown");

	        driver.findElement(arrivel_city).sendKeys("pune");;
	        log.info("Entred depart city initials of arrivel city");
	        

	        driver.findElement(arrivel_city_dropdown).click();
	        log.info("Selected arrivel city from dropdown");
	        
	        driver.findElement(search_train_button).click();
	        log.info("Clicked on Search trains button");
	        Thread.sleep(1000);

	        driver.findElement(Login_button).click();
	        log.info("Click on login button");
	        Thread.sleep(1000);

	        driver.findElement(Email_input).sendKeys(creds.Valid_email);;
	        log.info("Entred valid email ID");
	        
	        driver.findElement(Continue_button).click();
	        log.info("Click on login button");
  
	        driver.findElement(password_input).sendKeys(creds.Valid_pass);;
	        log.info("Entred valid password");
		 
	        driver.findElement(Login_submit).click();
	        log.info("Clicked on login submit button");
	        
	        driver.findElement(selected_class).click();
	        log.info("Clicked on 2A ticket category");
	        
	        driver.findElement(Irctc_user_id).sendKeys(creds.IRCTC_ID);;
	        log.info("Entred IRCTC ID");
	        
	        driver.findElement(Continue_Button).click();
	        log.info("Clicked on continue button on irctc popup");
	        
	        driver.findElement(Continue_Button_two).click();
	        log.info("Clicked on continue button on 2nd irctc popup");
	        
	        // To select price
	        driver.findElement(Select_Price).click();
	        log.info("Clicked on Available ticket");
	        
	        
	        
	        return driver;
	        
	        
	        
	    } 
	    
	    
	  

}
