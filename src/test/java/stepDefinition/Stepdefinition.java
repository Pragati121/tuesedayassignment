package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

public class Stepdefinition extends BaseCLass {

        @Given("User is on Home Page")
        public void userIsOnHomePage() {

        }
        @When("click on Register")
        public void clickOnRegister() throws IOException {
                pageFactory.getHomePage().HomeUser();
        }

        @And("add User details")
        public void addUserDetails() throws IOException {
                pageFactory.getHomePage().Homemethod();
        }

        @When("click on Register then logout")
        public void click_on_register_then_logout() {

        }
}

