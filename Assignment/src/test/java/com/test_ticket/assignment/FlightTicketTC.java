package com.test_ticket.assignment;

import static org.testng.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Ticket.POM.FlightTicket;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test.base.UIBase;
import com.test.util.UIConstant;

public class FlightTicketTC {
	
	
	 public WebDriver driver;
	 private boolean testdone = false;
	    private UIBase baseHelper;
	    private FlightTicket ticket;
	    public static Log log = LogFactory.getLog(TrainTicketTC.class);

	    ExtentHtmlReporter htmlReporter;
	    ExtentReports extentReports;

	    @BeforeSuite
	    public void extentReportSetup()
	    {
	        htmlReporter = new ExtentHtmlReporter("./ExtentReport/extent1.html");
	        extentReports = new ExtentReports();
	        extentReports.attachReporter(htmlReporter);
	    }

	    @BeforeMethod(alwaysRun = true)
	    public boolean testSetUp()throws Exception
	    {
	   
	        baseHelper = new UIBase();
	        String baseUrl = UIBase.buildBaseUrl(UIConstant.HOST_IP);
	        String browserType = UIConstant.UI_CHROME;
	        // Pass whatever browser needs to be invoked.
	        log.info("Launching browser... :" + browserType);
	        driver = baseHelper.invokeBrowser(baseUrl, browserType);
	        return true;
	    

	    }
	    
	    @Test(description = "Test_001 : Flight Ticket E2E ", priority='1')
	    public void signUpClick()
	            throws Exception {
	        ExtentTest extentTest = extentReports.createTest("SignUpClick", "SignUp Click Test");
	        try {
	        	ticket.Flight_Book_E2E(driver);
	            log.info("Flight Ticket booked Succefully ...!!");
	            

	            // Reset flag to true if all test passed
	            testdone = true;
	            extentTest.log(Status.PASS, "Flight Ticket booked Succefully...!!");

	        } catch (AssertionError ex) {
	            log.error("Assertion Failed:" + ex.getMessage());
	            extentTest.log(Status.FAIL, "Assertion Error");
	            testdone = false;

	        } catch (Exception exception) {
	            log.error("Failed to perform any one operation - Flight ticket booking :"
	                    + exception.getMessage());
	            extentTest.log(Status.FAIL, "Failed to perform any one operation - Flight ticket booking :");
	            testdone = false;
	        }

	        // If flag is true, assertion will pass else, will false
	        assertTrue(testdone, "Test Execution Completed !!");
	    }

}
