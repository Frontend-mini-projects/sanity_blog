package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testing {
	private static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
			// Open the Browser
			WebDriver driver = new ChromeDriver();
			String url = "https://the-internet.herokuapp.com/login";
			driver.get(url);
			driver.manage().window().maximize();
			
			
			// Added for exercise 4
			sleep(2);
			WebElement username = driver.findElement(By.xpath("/html//input[@id='username']"));
			username.sendKeys("tomsmith");
			
			
			WebElement password = driver.findElement(By.xpath("/html//input[@id='password']"));
			password.sendKeys("SuperSecretPassword!");
			sleep(2);
			

			WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
			loginbtn.click();
			
			
			String expectedurl = "https://the-internet.herokuapp.com/secure";
			String actualurl = driver.getCurrentUrl();
			// check matches or not
			Assert.assertEquals(actualurl,expectedurl,"The URL is not the same as expected");
			sleep(5);
			
			System.out.println("The program executed successfully");
			
			// search for logout button
			driver.get(expectedurl);
			
			WebElement logoutbtn = driver.findElement(By.className("iconsignout"));
			
			Assert.assertTrue(logoutbtn.isDisplayed(),"logout");
			logoutbtn.click();
			
			System.out.println(logoutbtn+"logout found");
			driver.close();
		}
		
	}
