package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {

	protected static WebDriver driver;
	protected Properties prop;
	public WebDriver initializeDriver() throws IOException{
	
		prop =new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\90543\\Project\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName =prop.getProperty("browser");
	
		if(browserName.equals("chrome")){
			
			//execute in chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\90543\\Desktop\\chromedriver.exe");
			driver =new ChromeDriver();
			
		}else if(browserName.equals("firefox")){
			
			//execute in firefox driver
			System.setProperty("webdriver.geckho.driver", "C:\\Users\\90543\\Desktop\\geckodriver.exe");
			driver =new FirefoxDriver();
			
		}else{
			
			//execute IE driver
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException{
		
		File src =(File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C://Users//90543//Desktop//test//"+result+"screenshot.png"));
	}
}
