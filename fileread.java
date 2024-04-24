package sample;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class BuggerReader {
	private static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args)  throws IOException, InterruptedException {
			// Open the Browser
		WebDriver driver=new ChromeDriver();
		// This code is to create a string URL and assign the website
		String url="http://testphp.vulnweb.com/login.php";
		/* Now driver will open chrome and enter the website address in
		* address bar
		*/
		driver.get(url);
		//The code to maximize the Chrome browser
		driver.manage().window().maximize();
		// This is a sleep thread to pass the execution for few seconds
		sleep(2); // Slow down
		//Code to type Username and password
		WebElement username=driver.findElement(By.xpath("//div[@id='content']/div[1]/form[@name='loginform']/table//input[@name='uname']"));
		username.sendKeys("test");
		WebElement password=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/form/table/tbody/tr[2]/td[2]/input[@name='pass']"));
		password.sendKeys("test");
		sleep(2); // Slow down
		WebElement
		loginbtn=driver.findElement(By.xpath("//div[@id='content']//form[@name='loginform']/table/tbody/tr[3]/td/input[@value='login']"));
		loginbtn.click();
		System.out.println("The Test Executed Successfully");
		
		// Read from a notepad:
		BufferedReader reader = new BufferedReader(new FileReader("C:/Users/utkar/Downloads/data.txt"));
			
		String line = reader.readLine();
		String[] content = line.split(",");

		

		 for(int i=0;i<content.length;i++)
			 System.out.println(content[i]);
		WebElement field1_input =
		driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/table//input[@name='urname']"));
		WebElement field2_input =
		driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/table//input[@name='ucc']"));
		WebElement field3_input =
		driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/table//input[@name='uemail']"));
		WebElement field4_input =
		driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/table//input[@name='uphone']"));
		WebElement field5_input =
		driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/table//textarea[@name='uaddress']"));


		field1_input.clear();
		field2_input.clear();
		field3_input.clear();
		field4_input.clear();
		field5_input.clear();
		field1_input.sendKeys(content[0]);
		field2_input.sendKeys(content[1]);
		field3_input.sendKeys(content[2]);
		field4_input.sendKeys(content[3]);
		field5_input.sendKeys(content[4]);
		WebElement
		submit_btn=driver.findElement(By.xpath("//div[@id='content']//form[@name='form1']/table/tbody/tr[6]/td/input[@name='update']"));
		submit_btn.click();
		sleep(5);
		reader.close();
		driver.close();
		
		
		
		}

}
