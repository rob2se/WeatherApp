package StepDefinitions;


import Actions.WeatherSiteActions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WeatherSiteStepDefinition {

    private WeatherSiteActions weatherSiteActions = new WeatherSiteActions(Hooks.driver);



    @When("^The weather app launches$")
    public void theWeatherAppLaunches(){

    }

    @Then("^The city field should default to Glasgow$")
    public void theCityFieldShouldDefaultToGlasgow() {
        weatherSiteActions.checkCityFieldDefaultValue();
    }

    @When("^The user deletes the contents of the city field$")
    public void theUserDeletesTheContentsOfTheCityField() {
        weatherSiteActions.clearConentsOfCityField();
    }

    @And("^Submits form$")
    public void submitsForm() {
        weatherSiteActions.submitForm();
    }

    @When("^The user enters an unknown city$")
    public void theUserEntersAnUnknownCity() {
        weatherSiteActions.clearConentsOfCityField();
        weatherSiteActions.enterUnknownCity();
        weatherSiteActions.submitForm();
    }

    @Then("^A warning message should be displayed$")
    public void aWarningMessageShouldBeDisplayed() {
        weatherSiteActions.checkErrorMessage();
    }


    @Then("^A five day forecast is displayed$")
    public void aFiveDayForecastIsDisplayed() {
        weatherSiteActions.checkFiveDayForecastIsDisplayed();
    }

    @When("^I expand a day$")
    public void iExpandADay() {
        weatherSiteActions.expandDayOne();
    }

    @Then("^A three hourly forecast is displayed$")
    public void aThreeHourlyForecastIsDisplayed() {
        weatherSiteActions.checkThreeHourlyForecastsAreDisplayed();
    }


}
