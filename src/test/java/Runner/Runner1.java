package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\PragatiSharma\\IdeaProjects\\NopCommerceBddPropertiesAndExcel\\src\\test\\java\\FeatureFile\\ComputerPage.feature"},
        glue = {"stepDefinition"},
        monochrome = true,
        plugin = {"pretty", "json:report/Cucumber.json"
        }
)
class Runner1  {

}


