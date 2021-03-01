package cucumberTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions (
        features = "classpath:feature"
        ,glue={"frontendTest/stepdef"},
        plugin={"html:target/cucumber-html-report.html"}
)
public class TestRunner {

}
