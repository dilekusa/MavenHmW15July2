package com.xfinity.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xfinity.pages.XfinityOpenPage;
import com.xfinity.pages.XfinityRunningPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.Config;
import utilities.Driver;

public class XfinityStartButton {

	static WebDriver driver;
	static double downloadSpeed;
	static double uploadSpeed;

	@Given("^User Sets Implicit wait to (\\d+) seconds$")
	public void user_Sets_Implicit_wait_to_seconds(int sec) throws Throwable {
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@When("^User Navigates to URL$")
	public void user_Navigates_to_URL() throws Throwable {
		driver.get(Config.getProperty("url"));

	}

	@When("^User Waits until Start Test button is clickable$")
	public void user_Waits_until_Start_Test_button_is_clickable() throws Throwable {
		XfinityOpenPage openPage = new XfinityOpenPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(openPage.StartButton));

	}

	@When("^User Click on Start Test button$")
	public void user_Click_on_Start_Test_button() throws Throwable {
		XfinityOpenPage openPage = new XfinityOpenPage(driver);
		openPage.StartButton.click();

	}

	@When("^User Wait until Blinking Download icon disappears$")
	public void user_Wait_until_Blinking_Download_icon_disappears() throws Throwable {
		WebDriverWait waitForBlink = new WebDriverWait(driver, 100);
		XfinityRunningPage runPage = new XfinityRunningPage(driver);
		waitForBlink.until(ExpectedConditions.invisibilityOf(runPage.blinkDownload));

	}

	@When("^User Read Download speed value into a variable$")
	public void user_Read_Download_speed_value_into_a_variable() throws Throwable {
		XfinityRunningPage runPage = new XfinityRunningPage(driver);
		Thread.sleep(2000);
		String downloadValue = runPage.downloadSpeed.getAttribute("innerText");
		System.out.println(downloadValue);
		downloadSpeed = Double.parseDouble(downloadValue);
		System.out.println("download speed is: " + downloadSpeed + "  Mbps ");
	}

	@When("^Wait until Blinking Upload icon disappears$")
	public void wait_until_Blinking_Upload_icon_disappears() throws Throwable {
		WebDriverWait waitForBlinkUpload = new WebDriverWait(driver, 100);
		XfinityRunningPage runPage2 = new XfinityRunningPage(driver);
		waitForBlinkUpload.until(ExpectedConditions.invisibilityOf(runPage2.blinkUpload));
	}

	@When("^Read Upload speed value into a variable$")
	public void read_Upload_speed_value_into_a_variable() throws Throwable {
		XfinityRunningPage runPage3 = new XfinityRunningPage(driver);
		String uploadValue = runPage3.uploadSpeed.getAttribute("innerText");
		System.out.println(uploadValue);
		uploadSpeed = Double.parseDouble(uploadValue);
		System.out.println("upload speed is: " + uploadSpeed + "  Mbps ");

	}

	@Then("^Set Following Conditions:$")
	public void set_Following_Conditions() throws Throwable {

		if (downloadSpeed < 20) {
			System.out.println("Poor Download Speed...");
		} else if (downloadSpeed >= 20 && downloadSpeed <= 50) {
			System.out.println("Acceptable Download Speed...");

		} else if (downloadSpeed > 50 && downloadSpeed < 100) {
			System.out.println("Excellent Download Speed...");

		} else if (downloadSpeed >= 100) {
			System.out.println("SuperFast Download Speed...");
			System.out.println("Fast fast");
		}

		System.out.println("Now we are looking for upload speed");

		if (uploadSpeed < 20) {
			System.out.println("Poor UpLoad Speed...");
		} else if (uploadSpeed >= 20 && uploadSpeed <= 50) {
			System.out.println("Acceptable UpLoad Speed...");

		} else if (uploadSpeed > 50 && uploadSpeed < 100) {
			System.out.println("Excellent UpLoad Speed...");

		} else if (uploadSpeed >= 100) {
			System.out.println("SuperFast UpLoad Speed...");
		}

	}
}