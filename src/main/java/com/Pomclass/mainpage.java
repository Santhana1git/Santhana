package com.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainpage {

	public WebDriver driver;
	
	public mainpage(WebDriver main) {
		this.driver = main;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='shopMen']")
	private WebElement shopmen;

	@FindBy(xpath = "//div[@class='loaderCat viptshirtLdr dIb mA pA r0   h80 b4 l0 t0 ']")
	private WebElement click_tshirt;

	@FindBy(xpath = "(//span[@class=' h321  dB vT pR bgF wp100'])[1]")
	private WebElement choosebrand;

	@FindBy(xpath = "(//div[@class='prdC fs12 p8  pR taC bs  '])[1]")
	private WebElement select_tshirt;

	@FindBy(xpath = "//span[text()=' L ']")
	private WebElement select_size;

	@FindBy(xpath = "//div[text()='ADD TO CART']")
	private WebElement addtocart;
	
	@FindBy(xpath = "//a[text()='BUY NOW']")
	private WebElement buybutton;
	

	public WebElement getShopmen() {
		return shopmen;
	}

	public WebElement getClick_tshirt() {
		return click_tshirt;
	}

	public WebElement getChoosebrand() {
		return choosebrand;
	}

	public WebElement getSelect_tshirt() {
		return select_tshirt;
	}

	public WebElement getSelect_size() {
		return select_size;
	}

	public WebElement getAddtocart() {
		return addtocart;
	}
	
	public WebElement getBuybutton() {
		return buybutton;
	}

}
