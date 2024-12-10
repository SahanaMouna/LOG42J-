package Navigate; //log4j

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class Demo_3 {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(Demo_3.class.getName());
		ChromeDriver driver=new ChromeDriver();
		logger.debug("Chrome is opened");
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		logger.debug("omayo website is opened");
//		driver.findElement(By.id("link1")).click();
//		driver.navigate().back();
//		driver.navigate().forward();         //to navigate forward & backward
		driver.findElement(By.linkText("Open a popup window")).click();
		logger.debug("popup window is opened");
		Set<String> win = driver.getWindowHandles();
		Iterator<String> itr = win.iterator();
		String parent = itr.next();
		String child = itr.next();
		driver.switchTo().window(child);
		String name = driver.findElement(By.xpath("//h3[text()=\"New Window\"]")).getText();
		logger.debug("text has been copied & printed");
         if(name.equals("Nw Window"))
         {
		logger.info("text executed successfully");
         }
         else {
        logger.error("Incorrect text displayed");
         }
         driver.quit();
	}

}
