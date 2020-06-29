package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import step_definitions.step_impl.HomePage_impl;
import util.ConfigReader;
import util.Driver;

import java.awt.*;

public class HomePage_STEPS {
    private static WebDriver driver = Driver.getDriver();
    HomePage_impl homePageImpl = new HomePage_impl();

    @Given("User opens Home home page")
    public void user_opens_Home_home_page() {
        driver.get(ConfigReader.readProperty("url"));
    }

    @When("Verify Page Title")
    public void verify_Page_Title() {
        Assert.assertEquals("Practice", driver.getTitle());

    }

    @When("User navigate to Account List Button")
    public void user_navigate_to_Account_List_Button() {
        HomePage_impl.accountList();
    }

    @When("Open Your Orders Page")
    public void open_Your_Orders_Page() {
        HomePage_impl.singInPage();

    }

    @Then("Verifies order page title")
    public void verifies_order_page_title() {
        HomePage_impl.CartPage();

    }
}
