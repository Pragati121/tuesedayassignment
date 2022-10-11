package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class ComputerPageStepDefinition extends BaseCLass{
    @Given("User is in the Home Page")
    public void user_is_in_the_home_page() {
        setUpDriver();
    }

    @And("click on Computer and notebook")
    public void click_on_computer_and_notebook() {
     pageFactory.getComputerclick().ClickOnComputer();
    }
    @And("Choose items according to their prices")
    public void choose_items_according_to_their_prices() {
     pageFactory.getComputerclick().SortitemsByPrice();
    }
    @And("Add item to cart  and go to shopping cart page")
    public void add_item_to_cart_and_go_to_shopping_cart_page() {
    pageFactory.getComputerclick().AddItemTocart();
    }
    @And("Add User details")
    public void add_user_details() throws IOException {
        pageFactory.getComputerclick().AddUserdetails();
        pageFactory.getComputerclick().login();
   // driver.close();
    }
}
