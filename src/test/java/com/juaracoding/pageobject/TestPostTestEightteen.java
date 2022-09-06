package com.juaracoding.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.PostTestEightteen;
import com.juaracoding.pageobject.pages.PostTestNineteen;

public class TestPostTestEightteen {

	public static WebDriver driver;
	private PostTestEightteen posttestEightteen;

	@BeforeClass
	public void setup() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}
	
	@BeforeMethod
	public void pageObject() {
		posttestEightteen = new PostTestEightteen();
	}
	
	@Test(priority = 1)
	public void TestPembelian1() {
		posttestEightteen.AlertTestQADismiss();
		posttestEightteen.SearchItem("Pink Drop");
		delay(3);
		scroll(500);
		posttestEightteen.SelectColorSize(1,1);
		delay(3);
	}
	
	@Test(priority = 2)
	public void TestPembelian2() {
		posttestEightteen.SearchItem("blue Denim");
		delay(3);
		scroll(500);
		posttestEightteen.SelectColorSize(1,1);
		delay(3);
	}
	
	@Test(priority = 3)
	public void ShowCart() {
		posttestEightteen.ViewCart();
		scroll(500);
	}
	
	@AfterClass
	public void closeBrowser() {
		delay(10);
		driver.quit();
		
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	static void scroll(int vertikal) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertikal+")");
}
}
