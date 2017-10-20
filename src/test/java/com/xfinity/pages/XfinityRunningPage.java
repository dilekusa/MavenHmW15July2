package com.xfinity.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class XfinityRunningPage {

	private WebDriver driver;

	public XfinityRunningPage(WebDriver driver) {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".ico.ico48.ico-download.blinking")
	public WebElement blinkDownload;

	@FindBy(css = "#finalResultsIPv4-download-value")
	public WebElement downloadSpeed;

	@FindBy(css = ".ico.ico48.ico-upload.blinking")
	public WebElement blinkUpload;

	@FindBy(css = "#finalResultsIPv4-upload-value")
	public WebElement uploadSpeed;

	@FindBy(css = "#finalResultsIPv4-upload-value")
	public List<WebElement> uploadSpeed3;
}
