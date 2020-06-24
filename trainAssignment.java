package Week3;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.stream.*;

public class trainAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Launch https://erail.in/
		driver.get("https://erail.in/");
		
		//Click the 'sort on date' checkbox
		driver.findElementById("chkSelectDateOnly").click();
		
		//Clear and type in the from station text field
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").click();
		
		//Select From Chennai
		driver.findElementById("txtStationFrom").sendKeys("Chennai");
		List<WebElement> dropdown_list =  driver.findElementsByXPath("//*[contains(@title,'Chennai')]");
		System.out.println("The Options in the Dropdown are: " + dropdown_list.size());
		for(int i=0; i<dropdown_list.size(); i++)
		{
			System.out.println(dropdown_list.get(i).getText());
			if(dropdown_list.get(i).getText().contains("Mgr Chennai Ctr")) 
			{
				dropdown_list.get(i).click();
				break;
			}
		}	
		
		//Clear and type in the To station text field
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").click();
		
		//Select To Coimbatore
		driver.findElementById("txtStationTo").sendKeys("Coimbatore");
		List<WebElement> dropdown_list1 =  driver.findElementsByXPath("//*[contains(@title,'Coimbatore')]");
		System.out.println("The Options in the Dropdown are: " + dropdown_list1.size());

		for(int i=0; i<dropdown_list1.size(); i++)
		{
			System.out.println(dropdown_list1.get(i).getText());
			if(dropdown_list1.get(i).getText().contains("Coimbatore Jn")) 
			{
				dropdown_list1.get(i).click();
				break;
			}
		}
		driver.findElementById("buttonFromTo").click();
		Thread.sleep(2000);
		
		//Store all the train names in a list
		List<WebElement> trainNames = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//td[2]");
		for (int i=0; i < trainNames.size() ; i++)
		{
			WebElement element = trainNames.get(i);
			System.out.println("Trains from Chennai to Coimbatore are " + element.getText());
		}
		System.out.println("Number of Trains from Chennai to Coimbatore in List are" + trainNames.size());
	
		//Add List to a Set
        Set<String> uniqueTrainNames = new HashSet<String>();
		for (WebElement eachTrainElement : trainNames) {
			String eachTrainName = eachTrainElement.getText();
			uniqueTrainNames.add(eachTrainName);
			System.out.println("Trains from Chennai to Coimbatore are " +eachTrainName);
		}
		System.out.println("Number of Trains from Chennai to Coimbatore in SET are" + uniqueTrainNames.size());
		 
		//Compare the Size of list and Set to verify the names are unique
		if (trainNames.size() == uniqueTrainNames.size())
		{
			System.out.println("Train names does not contain duplicate");
		}
		else
			System.out.println("Train names contains duplicate");
	}

}
