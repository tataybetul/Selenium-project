package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	public static Logger logger=(Logger)LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password) throws IOException{
		
		driver= initializeDriver();
		driver.get("http://qaclickacademy.com");
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getLogin().click();
		
		LoginPage loginPage =new LoginPage(driver);
		loginPage.getEmail().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		loginPage.getSubmit().click();
		
	}
	
	@AfterTest
	public void tearDown(){
		
		driver.close();
		driver= null;
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data =new Object[2][2];
		data[0][0] ="betulll@qw.com";
		data[0][1] ="rterter";
		//data[0][2] ="11112";
		
		data[1][0] ="aykannn@qw.com";
		data[1][1] ="534534";
		//data[1][2] ="56565";
		
		return data;
	}
	
}
