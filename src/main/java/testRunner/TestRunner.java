package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D://Users//KarT//Documents//Arya//Exercise1_aryat//Feature//Sample1.feature",
        glue={"Stepdefinitions"}
)
public class TestRunner
{
}
