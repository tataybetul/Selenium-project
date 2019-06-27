package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;


public class ValidateTitle extends Base{

	public static Logger logger=(Logger)LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		logger.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		logger.info("Navigated to home page");
	}

	@Test
	public void basePageNavigation() throws IOException{
		
		LandingPage landingPage = new LandingPage(driver);
		
		Assert.assertEquals(landingPage.getTitle().getText(), "FEATURED COURSES");
		logger.info("Successfully validated text message");
	}
	
	@AfterTest
	public void tearDown(){
		
		driver.close();
		driver= null;
	}
	
}
