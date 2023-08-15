package com.test.base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.test.util.UIConstant;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIBase {
	
	 public static WebDriver driver;

	   public static Log log = LogFactory.getLog(UIBase.class);

	    /*
	     * To construct Base URL
	     *
	     * @return String URL
	     * @throws Exception
	     */
	    public static String buildBaseUrl(String hostName)
	            throws Exception
	    {
	        if (hostName == null) {
	           log.error("Host name is not available !!");
	            return null;
	        }

	        return UIConstant.HTTP_PROTOCOL + "://" + hostName;

	    }

	    /*
	     * Switch to the browser based on browser type
	     *
	     * @param baseUrl
	     * @param browserType
	     * @throws Exception
	     */
	    public WebDriver invokeBrowser(String baseUrl,
	                                   String browserType)
	            throws Exception
	    {
	       log.trace("Trigger running Selenium..");

	        switch (browserType) {
	            case UIConstant.UI_FIREFOX: {
	                log.info("Setting up the Firefox Driver properties");
	                WebDriverManager.firefoxdriver().setup();
	                driver = new FirefoxDriver();
	                log.info("Driver Info " + driver);
	            }
	            case UIConstant.UI_IE : {
	                log.info("Setting up the IE Driver properties");
	                WebDriverManager.iedriver().setup();
	                driver = new InternetExplorerDriver();
	                log.info("Driver Info " + driver);
	            }
	            default : {
	                log.info("Setting up the Chrome Driver properties");
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();
	                log.info("Driver Info " + driver);
	               
	            }
	        }

	        setBrowserTimeouts(driver);
	        driver.navigate().to(baseUrl);
	        return driver;
	    }

	    /*
	     * To set browser timeouts
	     *
	     * @param driver
	     */
	    public void setBrowserTimeouts(WebDriver driver)
	    {
	        log.info("setBrowserTimeouts Setting browser timeouts");

	        driver.manage().timeouts().implicitlyWait(
	                UIConstant.PAGE_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(UIConstant.PAGE_LOAD_TIMEOUT,
	                TimeUnit.SECONDS);

	        log.info("Maximize browser");
	        driver.manage().window().maximize();
	    }

	    /*
	     * To terminate browser
	     *
	     * @param driver
	     */
	    public WebDriver terminateBrowser(WebDriver driver)
	    {
	        log.info("Closing the browser !!");
	       driver.quit();
	       // driver.close();
	       log.info("Browser has been closed !!");

	        return driver;
	       
	    }
	    public static void getScreenshot(String screensht) throws Exception {
	        File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(srcfile, new File("./failed_case_screenshot/" + screensht + ".png"));
	        log.info("Successfully take Screenshot");
	    }

}
