package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "D:\\eclips-workspace\\Sel_Cucumber_Project\\src\\test\\resources\\Feature\\Urban.feature",
		glue = "stepdefinition"
		
		
		)

public class UrbanRun extends AbstractTestNGCucumberTests{

	
	
}
