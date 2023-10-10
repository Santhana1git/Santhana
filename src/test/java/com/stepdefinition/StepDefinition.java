package com.stepdefinition;

import com.Baseclass.Baseclass;
import com.Pomclass.mainpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class StepDefinition extends Baseclass {

	mainpage mp = new mainpage(driver);

	@Given("User clicks the mens section page")
	public void user_clicks_the_mens_section_page() throws Exception {
		mp.getShopmen().click();
		Thread.sleep(8000);
		mp.getClick_tshirt().click();
		Thread.sleep(3000);
	}
	@When("User select a brand and one tshirt")
	public void user_select_a_brand_and_one_tshirt() throws Exception {
		mp.getChoosebrand().click();
		Thread.sleep(3000);
		mp.getSelect_tshirt().click();
		Thread.sleep(3000);
	}
	@And("User select size and click add to cart")
	public void user_select_size_and_click_add_to_cart() throws Exception {
		mp.getSelect_size().click();
		Thread.sleep(3000);
		mp.getAddtocart().click();
		Thread.sleep(3000);
	}
	@Then("User clicks buy button and close")
	public void user_clicks_buy_button_and_close() throws Exception {
		mp.getBuybutton().click();
		Thread.sleep(3000);
		driver.close();
	}
	
	
}
