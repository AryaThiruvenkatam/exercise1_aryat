package Stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Sample1Steps {

    @Given("start the script")
    public void startthescript() {
        System.out.println("script execution started");
    }

    @Then("script execution in progress")
    public void scriptExecutionInProgress() {
        System.out.println("script execution in progress");
    }


    @And("Execution completed")
    public void executionCompleted() {
        System.out.println("Execution completed");
    }


}
