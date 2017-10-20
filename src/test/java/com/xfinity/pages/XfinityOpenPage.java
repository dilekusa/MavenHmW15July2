package com.xfinity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class XfinityOpenPage {
	private WebDriver driver;

	public XfinityOpenPage(WebDriver driver) {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "action-start-test")
	public WebElement StartButton;

}
