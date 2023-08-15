package com.Ticket.POM;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlightTicket {

	
	
	
	 By  depart=By.xpath("(//span[text()='Depart From'])[1]");
	 By  enter_depart_city=By.xpath("//input[@id='BE_flight_origin_city']");
	 By  Select_city_dropdown=By.xpath("//p[text()='Indira Gandhi International']");
	 By  enter_arrivel_city=By.xpath("//label[@for='BE_flight_arrival_city']");
	 By  Select_arrivel_city=By.xpath("//li[@class='active ac_over']");
	 By  Departure_Date=By.xpath("(//input[@id='BE_flight_origin_date']");
     By  depart_date_Selected=By.xpath("(//td[@id='12/12/2023'])[1]");
     By  non_Stop=By.xpath("//a[@title='Non Stop Flights']");
     By  Search_Flight_Submit=By.xpath("(//input[@type='submit'])[2]");
     By  Book_now_Button=By.xpath("(//button[text()='Book Now'])[1]");
     By  Email_ID=By.xpath("(//input[@placeholder='Email ID'])[2]");
     By  Mobile_num=By.xpath("(//input[@placeholder='Mobile Number'])[2]");
     By  Title_Dropdown=By.xpath("//select[@id='title0']");
     By  Entr_First_Middle_name=By.xpath("//input[@placeholder='First & Middle Name']");
     By  Last_name=By.xpath("//input[@placeholder='Last Name']");
     By  Review_Name_Confirm=By.xpath("(//button[text()='Confirm'])[1]");
     By  Select_Seat=By.xpath("//button[@ng-click='seatAutoselect()']");
     By  Proceed_to_pay_button=By.xpath(" //button[@id='gtm_saveflightreview']");


     
  
     
   
   
	    public static Log log = LogFactory.getLog(FlightTicket.class);

	

	 public WebDriver Flight_Book_E2E(WebDriver driver)   
	            throws Exception {
//	    	JavascriptExecutor js = (JavascriptExecutor) driver;
//	        js.executeScript("scroll(0,6900)");
		 
		 
	        Thread.sleep(1000);
	        
	        driver.findElement(depart).click();;
	        log.info("Clicked On Depart from");
	        
	        driver.findElement(enter_depart_city).sendKeys("Del");
	        log.info("Initials entered");
	        
	        driver.findElement(Select_city_dropdown).click();;
	        log.info("Selected From Dropdown");
	        
	        driver.findElement(Select_city_dropdown).click();;
	        log.info("Selected From Dropdown");
	        
	        driver.findElement(enter_arrivel_city).sendKeys("Mum");
	        log.info("Entered arrivel city inatials");
	        
	        driver.findElement(Select_arrivel_city).click();;
	        log.info("Selected arrivel From Dropdown");
	        
	        driver.findElement(Departure_Date).click();
	        log.info("Selected departure date function");
	        
	        driver.findElement(depart_date_Selected).click();;
	        log.info("Selected departure date from calender");
	        driver.findElement(non_Stop).click();
	        log.info("Selected non stop checkbox");
	        
	        driver.findElement(Search_Flight_Submit).click();;
	        log.info("Clicked on search flight");
	        
	        
	        // Applied Explicit wait element taking time to load
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        WebElement element =driver.findElement(Book_now_Button);
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        log.info("Book now button clicked");

            Thread.sleep(2000);
            
	        driver.findElement(Email_ID).sendKeys("ppravin.su@gmail.com");
	        log.info("Entred Email ID");
	        
	        driver.findElement(Mobile_num).sendKeys("8971865027");
	        log.info("Entred Mobile number");
	        
	        // Select class using to select title from dropdown

	        WebElement TitleDropdown =driver.findElement(Title_Dropdown);

	        Select sel = new Select(TitleDropdown);
	        sel.selectByVisibleText("Mr.");
	        log.info("Selected Title from dropdown");
	        
	        driver.findElement(Entr_First_Middle_name).sendKeys("Pravin S");
	        log.info("Entred Firt Name and Middle Name");
	        
	        driver.findElement(Last_name).sendKeys("U");
	        log.info("Entred Firt Name and Middle Name");

	        driver.findElement(Review_Name_Confirm).click();;
	        log.info("Name Reviewed and clicked on confirm button");
	        
	        driver.findElement(Select_Seat).click();;
	        log.info("Default seat selected");
	        
	        
	        WebElement payButton =driver.findElement(Proceed_to_pay_button);

	        // to scrole down to get proceed tp pay buttom
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", payButton);
	        log.info("Scrolled until pay Button clicked");

	        
	        payButton.click();
	        log.info("Proceed to pay Button clicked");
	        

	        
	        // from here We have to enter bank details & book ticket
	        
	        
	        
	        return driver;
	    } 
	    
	    
	   
}
